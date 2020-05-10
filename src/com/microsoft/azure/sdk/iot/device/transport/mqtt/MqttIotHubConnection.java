package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.ProductInfo;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportConnection;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;
import e.a.a.a.a;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLContext;
import k.c.a.a.a.g;
import k.f.b;
import k.f.c;

public class MqttIotHubConnection
  implements IotHubTransportConnection, MqttMessageListener
{
  public static final String API_VERSION;
  public static final String SSL_PORT_SUFFIX = ":8883";
  public static final String SSL_PREFIX = "ssl://";
  public static final String WEBSOCKET_QUERY = "?iothub-no-client-cert=true";
  public static final String WEBSOCKET_RAW_PATH = "/$iothub/websocket";
  public static final String WS_SSL_PREFIX = "wss://";
  public static final b log = c.a(MqttIotHubConnection.class);
  public final Object MQTT_CONNECTION_LOCK = new Object();
  public final DeviceClientConfig config;
  public String connectionId;
  public MqttMessaging deviceMessaging;
  public MqttDeviceMethod deviceMethod;
  public MqttDeviceTwin deviceTwin;
  public String iotHubUserName;
  public String iotHubUserPassword;
  public IotHubListener listener;
  public MqttConnection mqttConnection;
  public Map<IotHubTransportMessage, Integer> receivedMessagesToAcknowledge = new ConcurrentHashMap();
  public IotHubConnectionStatus state = IotHubConnectionStatus.DISCONNECTED;
  public Map<Integer, Message> unacknowledgedSentMessages = new ConcurrentHashMap();
  
  static
  {
    StringBuilder localStringBuilder = a.a("?api-version=");
    localStringBuilder.append(TransportUtils.IOTHUB_API_VERSION);
    API_VERSION = localStringBuilder.toString();
  }
  
  public MqttIotHubConnection(DeviceClientConfig paramDeviceClientConfig)
  {
    Object localObject = MQTT_CONNECTION_LOCK;
    if (paramDeviceClientConfig != null) {
      try
      {
        if ((paramDeviceClientConfig.getIotHubHostname() != null) && (paramDeviceClientConfig.getIotHubHostname().length() != 0))
        {
          if ((paramDeviceClientConfig.getDeviceId() != null) && (paramDeviceClientConfig.getDeviceId().length() != 0))
          {
            if ((paramDeviceClientConfig.getIotHubName() != null) && (paramDeviceClientConfig.getIotHubName().length() != 0))
            {
              config = paramDeviceClientConfig;
              deviceMessaging = null;
              deviceMethod = null;
              deviceTwin = null;
              return;
            }
            paramDeviceClientConfig = new java/lang/IllegalArgumentException;
            paramDeviceClientConfig.<init>("hubName cannot be null or empty.");
            throw paramDeviceClientConfig;
          }
          paramDeviceClientConfig = new java/lang/IllegalArgumentException;
          paramDeviceClientConfig.<init>("deviceID cannot be null or empty.");
          throw paramDeviceClientConfig;
        }
        paramDeviceClientConfig = new java/lang/IllegalArgumentException;
        paramDeviceClientConfig.<init>("hostName cannot be null or empty.");
        throw paramDeviceClientConfig;
      }
      finally
      {
        break label181;
      }
    }
    paramDeviceClientConfig = new java/lang/IllegalArgumentException;
    paramDeviceClientConfig.<init>("The DeviceClientConfig cannot be null.");
    throw paramDeviceClientConfig;
    label181:
    throw paramDeviceClientConfig;
  }
  
  private IotHubTransportMessage receiveMessage()
  {
    IotHubTransportMessage localIotHubTransportMessage = deviceMethod.receive();
    if (localIotHubTransportMessage != null)
    {
      log.d("Received MQTT device method message ({})", localIotHubTransportMessage);
      return localIotHubTransportMessage;
    }
    localIotHubTransportMessage = deviceTwin.receive();
    if (localIotHubTransportMessage != null)
    {
      log.d("Received MQTT device twin message ({})", localIotHubTransportMessage);
      return localIotHubTransportMessage;
    }
    localIotHubTransportMessage = deviceMessaging.receive();
    if (localIotHubTransportMessage != null)
    {
      log.d("Received MQTT device messaging message ({})", localIotHubTransportMessage);
      return localIotHubTransportMessage;
    }
    return null;
  }
  
  public void close()
  {
    if (state == IotHubConnectionStatus.DISCONNECTED) {
      return;
    }
    log.b("Closing MQTT connection");
    try
    {
      if (deviceMethod != null)
      {
        deviceMethod.stop();
        deviceMethod = null;
      }
      if (deviceTwin != null)
      {
        deviceTwin.stop();
        deviceTwin = null;
      }
      if (deviceMessaging != null)
      {
        deviceMessaging.stop();
        deviceMessaging = null;
      }
      state = IotHubConnectionStatus.DISCONNECTED;
      log.b("Successfully closed MQTT connection");
      return;
    }
    catch (TransportException localTransportException)
    {
      state = IotHubConnectionStatus.DISCONNECTED;
      log.e("Exception encountered while closing MQTT connection, connection state is unknown", localTransportException);
      throw localTransportException;
    }
  }
  
  public String getConnectionId()
  {
    return connectionId;
  }
  
  public void onMessageArrived(int paramInt)
  {
    Object localObject;
    try
    {
      IotHubTransportMessage localIotHubTransportMessage = receiveMessage();
    }
    catch (TransportException localTransportException)
    {
      listener.onMessageReceived(null, new TransportException("Failed to receive message from service", localTransportException));
      log.e("Encountered exception while receiving message over MQTT", localTransportException);
      localObject = null;
    }
    if (localObject == null)
    {
      listener.onMessageReceived(null, new TransportException("Message sent from service could not be parsed"));
      log.d("Received message that could not be parsed. That message has been ignored.");
    }
    else
    {
      log.d("MQTT received message so it has been added to the messages to acknowledge list ({})", localObject);
      receivedMessagesToAcknowledge.put(localObject, Integer.valueOf(paramInt));
      paramInt = ((Message)localObject).getMessageType().ordinal();
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            ((IotHubTransportMessage)localObject).setMessageCallback(config.getDeviceTwinMessageCallback());
            ((IotHubTransportMessage)localObject).setMessageCallbackContext(config.getDeviceTwinMessageContext());
          }
        }
        else
        {
          ((IotHubTransportMessage)localObject).setMessageCallback(config.getDeviceMethodsMessageCallback());
          ((IotHubTransportMessage)localObject).setMessageCallbackContext(config.getDeviceMethodsMessageContext());
        }
      }
      else
      {
        ((IotHubTransportMessage)localObject).setMessageCallback(config.getDeviceTelemetryMessageCallback(((Message)localObject).getInputName()));
        ((IotHubTransportMessage)localObject).setMessageCallbackContext(config.getDeviceTelemetryMessageContext(((Message)localObject).getInputName()));
      }
      listener.onMessageReceived((IotHubTransportMessage)localObject, null);
    }
  }
  
  public void open(Queue<DeviceClientConfig> paramQueue, ScheduledExecutorService paramScheduledExecutorService)
  {
    connectionId = UUID.randomUUID().toString();
    if (paramQueue.size() <= 1) {
      synchronized (MQTT_CONNECTION_LOCK)
      {
        if (state == IotHubConnectionStatus.CONNECTED) {
          return;
        }
        log.b("Opening MQTT connection...");
        try
        {
          Object localObject2 = config.getAuthenticationProvider().getSSLContext();
          if (config.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN)
          {
            log.e("MQTT connection will use sas token based auth");
            iotHubUserPassword = config.getSasTokenAuthentication().getRenewedSasToken(false, false);
          }
          else if (config.getAuthenticationType() == DeviceClientConfig.AuthType.X509_CERTIFICATE)
          {
            if (!config.isUseWebsocket())
            {
              log.e("MQTT connection will use X509 certificate based auth");
              iotHubUserPassword = null;
            }
            else
            {
              paramQueue = new java/lang/UnsupportedOperationException;
              paramQueue.<init>("X509 authentication is not supported over MQTT_WS");
              throw paramQueue;
            }
          }
          paramQueue = config.getProductInfo().getUserAgentString();
          paramScheduledExecutorService = new java/lang/StringBuilder;
          paramScheduledExecutorService.<init>();
          paramScheduledExecutorService.append("DeviceClientType=");
          paramScheduledExecutorService.append(URLEncoder.encode(paramQueue, "UTF-8").replaceAll("\\+", "%20"));
          Object localObject3 = paramScheduledExecutorService.toString();
          paramScheduledExecutorService = config.getDeviceId();
          Object localObject4 = config.getModuleId();
          paramQueue = paramScheduledExecutorService;
          if (localObject4 != null)
          {
            paramQueue = paramScheduledExecutorService;
            if (!((String)localObject4).isEmpty())
            {
              paramQueue = new java/lang/StringBuilder;
              paramQueue.<init>();
              paramQueue.append(paramScheduledExecutorService);
              paramQueue.append("/");
              paramQueue.append((String)localObject4);
              paramQueue = paramQueue.toString();
            }
          }
          paramScheduledExecutorService = new java/lang/StringBuilder;
          paramScheduledExecutorService.<init>();
          paramScheduledExecutorService.append(config.getIotHubHostname());
          paramScheduledExecutorService.append("/");
          paramScheduledExecutorService.append(paramQueue);
          paramScheduledExecutorService.append("/");
          paramScheduledExecutorService.append(API_VERSION);
          paramScheduledExecutorService.append("&");
          paramScheduledExecutorService.append((String)localObject3);
          iotHubUserName = paramScheduledExecutorService.toString();
          localObject3 = config.getGatewayHostname();
          if (localObject3 != null)
          {
            paramScheduledExecutorService = (ScheduledExecutorService)localObject3;
            if (!((String)localObject3).isEmpty()) {}
          }
          else
          {
            paramScheduledExecutorService = config.getIotHubHostname();
          }
          if (config.isUseWebsocket())
          {
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            ((StringBuilder)localObject3).append("wss://");
            ((StringBuilder)localObject3).append(paramScheduledExecutorService);
            ((StringBuilder)localObject3).append("/$iothub/websocket");
            ((StringBuilder)localObject3).append("?iothub-no-client-cert=true");
            paramScheduledExecutorService = ((StringBuilder)localObject3).toString();
            localObject3 = new com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
            ((MqttConnection)localObject3).<init>(paramScheduledExecutorService, paramQueue, iotHubUserName, iotHubUserPassword, (SSLContext)localObject2, config.getProxySettings());
            mqttConnection = ((MqttConnection)localObject3);
          }
          else
          {
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            ((StringBuilder)localObject3).append("ssl://");
            ((StringBuilder)localObject3).append(paramScheduledExecutorService);
            ((StringBuilder)localObject3).append(":8883");
            paramScheduledExecutorService = ((StringBuilder)localObject3).toString();
            localObject3 = new com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
            ((MqttConnection)localObject3).<init>(paramScheduledExecutorService, paramQueue, iotHubUserName, iotHubUserPassword, (SSLContext)localObject2, null);
            mqttConnection = ((MqttConnection)localObject3);
          }
          localObject3 = new com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttMessaging;
          MqttConnection localMqttConnection = mqttConnection;
          paramQueue = config.getDeviceId();
          localObject4 = listener;
          localObject2 = connectionId;
          paramScheduledExecutorService = config.getModuleId();
          boolean bool;
          if ((config.getGatewayHostname() != null) && (!config.getGatewayHostname().isEmpty())) {
            bool = true;
          } else {
            bool = false;
          }
          ((MqttMessaging)localObject3).<init>(localMqttConnection, paramQueue, (IotHubListener)localObject4, this, (String)localObject2, paramScheduledExecutorService, bool, unacknowledgedSentMessages);
          deviceMessaging = ((MqttMessaging)localObject3);
          mqttConnection.setMqttCallback((g)localObject3);
          paramQueue = new com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttDeviceMethod;
          paramQueue.<init>(mqttConnection, connectionId, unacknowledgedSentMessages);
          deviceMethod = paramQueue;
          paramQueue = new com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttDeviceTwin;
          paramQueue.<init>(mqttConnection, connectionId, unacknowledgedSentMessages);
          deviceTwin = paramQueue;
          deviceMessaging.start();
          state = IotHubConnectionStatus.CONNECTED;
          log.b("MQTT connection opened successfully");
          listener.onConnectionEstablished(connectionId);
          return;
        }
        catch (IOException paramScheduledExecutorService)
        {
          log.e("Exception encountered while opening MQTT connection; closing connection", paramScheduledExecutorService);
          state = IotHubConnectionStatus.DISCONNECTED;
          if (deviceMethod != null) {
            deviceMethod.stop();
          }
          if (deviceTwin != null) {
            deviceTwin.stop();
          }
          if (deviceMessaging != null) {
            deviceMessaging.stop();
          }
          paramQueue = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
          paramQueue.<init>(paramScheduledExecutorService);
          throw paramQueue;
        }
      }
    }
    throw new UnsupportedOperationException("Mqtt does not support Multiplexing");
  }
  
  public IotHubStatusCode sendMessage(Message paramMessage)
  {
    Object localObject = MQTT_CONNECTION_LOCK;
    if (paramMessage != null) {}
    try
    {
      if ((paramMessage.getBytes() != null) && ((paramMessage.getMessageType() == MessageType.DEVICE_TWIN) || (paramMessage.getMessageType() == MessageType.DEVICE_METHODS) || (paramMessage.getBytes().length != 0)))
      {
        if (state != IotHubConnectionStatus.DISCONNECTED)
        {
          IotHubStatusCode localIotHubStatusCode = IotHubStatusCode.OK_EMPTY;
          if (paramMessage.getMessageType() == MessageType.DEVICE_METHODS)
          {
            deviceMethod.start();
            log.d("Sending MQTT device method message ({})", paramMessage);
            deviceMethod.send((IotHubTransportMessage)paramMessage);
          }
          else if (paramMessage.getMessageType() == MessageType.DEVICE_TWIN)
          {
            deviceTwin.start();
            log.d("Sending MQTT device twin message ({})", paramMessage);
            deviceTwin.send((IotHubTransportMessage)paramMessage);
          }
          else
          {
            log.d("Sending MQTT device telemetry message ({})", paramMessage);
            deviceMessaging.send(paramMessage);
          }
          return localIotHubStatusCode;
        }
        paramMessage = new java/lang/IllegalStateException;
        paramMessage.<init>("Cannot send event using a closed MQTT connection");
        throw paramMessage;
      }
      paramMessage = IotHubStatusCode.BAD_FORMAT;
      return paramMessage;
    }
    finally {}
  }
  
  public boolean sendMessageResult(Message paramMessage, IotHubMessageResult paramIotHubMessageResult)
  {
    if ((paramMessage != null) && (paramIotHubMessageResult != null))
    {
      log.d("Checking if MQTT layer can acknowledge the received message ({})", paramMessage);
      if (receivedMessagesToAcknowledge.containsKey(paramMessage))
      {
        int i = ((Integer)receivedMessagesToAcknowledge.get(paramMessage)).intValue();
        log.d("Sending MQTT ACK for a received message ({})", paramMessage);
        boolean bool;
        if (paramMessage.getMessageType() == MessageType.DEVICE_METHODS)
        {
          deviceMethod.start();
          bool = deviceMethod.sendMessageAcknowledgement(i);
        }
        else if (paramMessage.getMessageType() == MessageType.DEVICE_TWIN)
        {
          deviceTwin.start();
          bool = deviceTwin.sendMessageAcknowledgement(i);
        }
        else
        {
          bool = deviceMessaging.sendMessageAcknowledgement(i);
        }
        if (bool)
        {
          log.d("MQTT ACK was sent for a received message so it has been removed from the messages to acknowledge list ({})", paramMessage);
          receivedMessagesToAcknowledge.remove(paramMessage);
        }
        return bool;
      }
      paramIotHubMessageResult = new TransportException(new IllegalArgumentException("Provided message cannot be acknowledged because it was already acknowledged or was never received from service"));
      log.d("Mqtt layer could not acknowledge received message because it has no mapping to an outstanding mqtt message id ({})", paramMessage, paramIotHubMessageResult);
      throw paramIotHubMessageResult;
    }
    throw new TransportException(new IllegalArgumentException("message and result must be non-null"));
  }
  
  public void setListener(IotHubListener paramIotHubListener)
  {
    if (paramIotHubListener != null)
    {
      listener = paramIotHubListener;
      return;
    }
    throw new IllegalArgumentException("listener cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttIotHubConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */