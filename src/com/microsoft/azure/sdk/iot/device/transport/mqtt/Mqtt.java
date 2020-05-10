package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.ReconnectionNotifier;
import com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.PahoExceptionTranslator;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import k.c.a.a.a.e;
import k.c.a.a.a.g;
import k.c.a.a.a.k;
import k.c.a.a.a.l;
import k.c.a.a.a.q;
import k.c.a.a.a.s.p;

public abstract class Mqtt
  implements g
{
  public static final String ABSOLUTE_EXPIRY_TIME = "$.exp";
  public static final String CONNECTION_DEVICE_ID = "$.cdid";
  public static final String CONNECTION_MODULE_ID = "$.cmid";
  public static final int CONNECTION_TIMEOUT = 60000;
  public static final String CONTENT_ENCODING = "$.ce";
  public static final String CONTENT_TYPE = "$.ct";
  public static final String CORRELATION_ID = "$.cid";
  public static final String CREATION_TIME_UTC = "$.ctime";
  public static final int DISCONNECTION_TIMEOUT = 60000;
  public static final String INPUTS_PATH_STRING = "inputs";
  public static final String IOTHUB_ACK = "iothub-ack";
  public static final String MESSAGE_ID = "$.mid";
  public static final char MESSAGE_PROPERTY_KEY_VALUE_SEPARATOR = '=';
  public static final char MESSAGE_PROPERTY_SEPARATOR = '&';
  public static final char MESSAGE_SYSTEM_PROPERTY_IDENTIFIER_DECODED = '$';
  public static final String MESSAGE_SYSTEM_PROPERTY_IDENTIFIER_ENCODED = "%24";
  public static final String MODULES_PATH_STRING = "modules";
  public static final String MQTT_SECURITY_INTERFACE_ID = "$.ifid";
  public static final String OUTPUT_NAME = "$.on";
  public static final int PROPERTY_KEY_INDEX = 0;
  public static final int PROPERTY_VALUE_INDEX = 1;
  public static final String TO = "$.to";
  public static final String USER_ID = "$.uid";
  public static final k.f.b log = k.f.c.a(Mqtt.class);
  public ConcurrentLinkedQueue<k.a.a.b.e.b<String, byte[]>> allReceivedMessages;
  public String connectionId;
  public final Object incomingLock;
  public IotHubListener listener;
  public MqttMessageListener messageListener;
  public MqttConnection mqttConnection;
  public final Object publishLock;
  public final Object stateLock;
  public Map<Integer, Message> unacknowledgedSentMessages;
  public boolean userSpecifiedSASTokenExpiredOnRetry = false;
  
  public Mqtt(MqttConnection paramMqttConnection, IotHubListener paramIotHubListener, MqttMessageListener paramMqttMessageListener, String paramString, Map<Integer, Message> paramMap)
  {
    if (paramMqttConnection != null)
    {
      mqttConnection = paramMqttConnection;
      allReceivedMessages = paramMqttConnection.getAllReceivedMessages();
      stateLock = paramMqttConnection.getMqttLock();
      incomingLock = new Object();
      publishLock = new Object();
      userSpecifiedSASTokenExpiredOnRetry = false;
      listener = paramIotHubListener;
      messageListener = paramMqttMessageListener;
      connectionId = paramString;
      unacknowledgedSentMessages = paramMap;
      return;
    }
    throw new IllegalArgumentException("Mqtt connection info cannot be null");
  }
  
  private void assignPropertiesToMessage(Message paramMessage, String paramString)
  {
    paramString = paramString.split(String.valueOf('&'));
    int i = paramString.length;
    int j = 0;
    Object localObject;
    for (;;)
    {
      if (j >= i) {
        return;
      }
      localObject = paramString[j];
      if (((String)localObject).contains("="))
      {
        String str = localObject.split("=")[0];
        localObject = ((String)localObject).split("=");
        int k = 1;
        localObject = localObject[1];
        try
        {
          str = URLDecoder.decode(str, StandardCharsets.UTF_8.name());
          localObject = URLDecoder.decode((String)localObject, StandardCharsets.UTF_8.name());
          switch (str.hashCode())
          {
          default: 
            break;
          case 34732934: 
            if (str.equals("$.uid")) {
              k = 4;
            }
            break;
          case 34725246: 
            if (!str.equals("$.mid")) {
              break;
            }
            break;
          case 34718035: 
            if (str.equals("$.exp")) {
              k = 8;
            }
            break;
          case 34715636: 
            if (str.equals("$.cid")) {
              k = 3;
            }
            break;
          case 1120389: 
            if (str.equals("$.to")) {
              k = 0;
            }
            break;
          case 1120233: 
            if (str.equals("$.on")) {
              k = 5;
            }
            break;
          case 1119867: 
            if (str.equals("$.ct")) {
              k = 7;
            }
            break;
          case 1119852: 
            if (str.equals("$.ce")) {
              k = 6;
            }
            break;
          case -662840349: 
            if (str.equals("iothub-ack")) {
              k = 2;
            }
            break;
          }
          k = -1;
          switch (k)
          {
          default: 
            paramMessage.setProperty(str, (String)localObject);
            break;
          case 7: 
            paramMessage.setContentType((String)localObject);
            break;
          case 6: 
            paramMessage.setContentEncoding((String)localObject);
            break;
          case 5: 
            paramMessage.setOutputName((String)localObject);
            break;
          case 3: 
            paramMessage.setCorrelationId((String)localObject);
            break;
          case 1: 
            paramMessage.setMessageId((String)localObject);
          }
          j++;
        }
        catch (UnsupportedEncodingException paramMessage)
        {
          throw new IllegalStateException(paramMessage);
        }
      }
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("Unexpected property string provided. Expected '=' symbol between key and value of the property in string: ", (String)localObject));
  }
  
  private IotHubTransportMessage constructMessage(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new IotHubTransportMessage(paramArrayOfByte, MessageType.DEVICE_TELEMETRY);
    int i = paramString.indexOf("%24");
    if (i != -1)
    {
      assignPropertiesToMessage(paramArrayOfByte, paramString.substring(i));
      paramString = paramString.substring(0, i).split("/");
      if ((paramString.length > 2) && (paramString[2].equals("modules"))) {
        paramArrayOfByte.setConnectionModuleId(paramString[3]);
      }
      if ((paramString.length > 4) && (paramString[4].equals("inputs"))) {
        paramArrayOfByte.setInputName(paramString[5]);
      }
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public void connect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:stateLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 110	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:mqttConnection	Lcom/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
    //   11: invokevirtual 265	com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection:getMqttAsyncClient	()Lk/c/a/a/a/f;
    //   14: invokevirtual 270	k/c/a/a/a/f:b	()Z
    //   17: ifne +56 -> 73
    //   20: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   23: ldc_w 272
    //   26: invokeinterface 276 2 0
    //   31: aload_0
    //   32: getfield 110	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:mqttConnection	Lcom/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
    //   35: invokevirtual 265	com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection:getMqttAsyncClient	()Lk/c/a/a/a/f;
    //   38: aload_0
    //   39: getfield 110	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:mqttConnection	Lcom/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
    //   42: invokevirtual 280	com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection:getConnectionOptions	()Lk/c/a/a/a/i;
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 283	k/c/a/a/a/f:a	(Lk/c/a/a/a/i;Ljava/lang/Object;Lk/c/a/a/a/a;)Lk/c/a/a/a/e;
    //   50: checkcast 285	k/c/a/a/a/q
    //   53: getfield 288	k/c/a/a/a/q:a	Lk/c/a/a/a/s/p;
    //   56: ldc2_w 289
    //   59: invokevirtual 295	k/c/a/a/a/s/p:a	(J)V
    //   62: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   65: ldc_w 297
    //   68: invokeinterface 276 2 0
    //   73: aload_1
    //   74: monitorexit
    //   75: return
    //   76: astore_2
    //   77: goto +28 -> 105
    //   80: astore_2
    //   81: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   84: ldc_w 299
    //   87: aload_2
    //   88: invokeinterface 302 3 0
    //   93: aload_0
    //   94: invokevirtual 305	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:disconnect	()V
    //   97: aload_2
    //   98: ldc_w 307
    //   101: invokestatic 313	com/microsoft/azure/sdk/iot/device/transport/mqtt/exceptions/PahoExceptionTranslator:convertToMqttException	(Lk/c/a/a/a/k;Ljava/lang/String;)Lcom/microsoft/azure/sdk/iot/device/exceptions/ProtocolException;
    //   104: athrow
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	Mqtt
    //   4	102	1	localObject1	Object
    //   76	1	2	localObject2	Object
    //   80	28	2	localk	k
    // Exception table:
    //   from	to	target	type
    //   7	73	76	finally
    //   73	75	76	finally
    //   81	105	76	finally
    //   105	107	76	finally
    //   7	73	80	k/c/a/a/a/k
  }
  
  public void connectionLost(Throwable paramThrowable)
  {
    log.b("Mqtt connection lost", paramThrowable);
    try
    {
      if (mqttConnection != null) {
        disconnect();
      }
      Object localObject1 = null;
    }
    catch (TransportException localTransportException) {}
    if (listener != null)
    {
      Object localObject2 = localTransportException;
      if (localTransportException == null) {
        if ((paramThrowable instanceof k))
        {
          localObject2 = PahoExceptionTranslator.convertToMqttException((k)paramThrowable, "Mqtt connection lost");
          log.c("Mqtt connection loss interpreted into transport exception", (Throwable)localObject2);
        }
        else
        {
          localObject2 = new TransportException(paramThrowable);
        }
      }
      ReconnectionNotifier.notifyDisconnectAsync((Throwable)localObject2, listener, connectionId);
    }
  }
  
  public void deliveryComplete(k.c.a.a.a.c paramc)
  {
    log.d("Mqtt message with message id {} was acknowledge by service", Integer.valueOf(a.n));
    synchronized (publishLock)
    {
      if ((listener != null) && (unacknowledgedSentMessages.containsKey(Integer.valueOf(a.n))))
      {
        log.d("Mqtt message with message id {} that was acknowledge by service was sent by this client", Integer.valueOf(a.n));
        paramc = (Message)unacknowledgedSentMessages.remove(Integer.valueOf(a.n));
      }
      else
      {
        log.c("Mqtt message with message id {} that was acknowledge by service was not sent by this client, will be ignored", Integer.valueOf(a.n));
        paramc = null;
      }
      if ((paramc instanceof IotHubTransportMessage))
      {
        ??? = ((IotHubTransportMessage)paramc).getDeviceOperationType();
        if ((??? == DeviceOperations.DEVICE_OPERATION_TWIN_SUBSCRIBE_DESIRED_PROPERTIES_REQUEST) || (??? == DeviceOperations.DEVICE_OPERATION_METHOD_SUBSCRIBE_REQUEST) || (??? == DeviceOperations.DEVICE_OPERATION_TWIN_UNSUBSCRIBE_DESIRED_PROPERTIES_REQUEST)) {
          return;
        }
      }
      listener.onMessageSent(paramc, null);
      return;
    }
  }
  
  public void disconnect()
  {
    try
    {
      if (mqttConnection.isConnected())
      {
        log.b("Sending MQTT DISCONNECT packet");
        e locale = mqttConnection.disconnect();
        if (locale != null) {
          a.a(60000L);
        }
        log.b("Sent MQTT DISCONNECT packet was acknowledged");
      }
      mqttConnection.close();
      mqttConnection.setMqttAsyncClient(null);
      return;
    }
    catch (k localk)
    {
      log.b("Exception encountered while sending MQTT DISCONNECT packet", localk);
      throw PahoExceptionTranslator.convertToMqttException(localk, "Unable to disconnect");
    }
  }
  
  public void messageArrived(String paramString, l paraml)
  {
    log.e("Mqtt message arrived on topic {} with mqtt message id {}", paramString, Integer.valueOf(f));
    mqttConnection.getAllReceivedMessages().add(new k.a.a.b.e.a(paramString, b));
    paramString = messageListener;
    if (paramString != null) {
      paramString.onMessageArrived(f);
    }
  }
  
  public k.a.a.b.e.b<String, byte[]> peekMessage()
  {
    return (k.a.a.b.e.b)allReceivedMessages.peek();
  }
  
  public void publish(String paramString, Message paramMessage)
  {
    try
    {
      if (mqttConnection.getMqttAsyncClient() != null)
      {
        if (!userSpecifiedSASTokenExpiredOnRetry)
        {
          if (mqttConnection.getMqttAsyncClient().b())
          {
            if ((paramMessage != null) && (paramString != null) && (paramString.length() != 0) && (paramMessage.getBytes() != null))
            {
              Object localObject1 = paramMessage.getBytes();
              while (mqttConnection.getMqttAsyncClient().A.m.c().length >= 10)
              {
                Thread.sleep(10L);
                if (mqttConnection.getMqttAsyncClient() != null)
                {
                  if (!mqttConnection.getMqttAsyncClient().b())
                  {
                    localObject1 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
                    ((TransportException)localObject1).<init>("Cannot publish when mqtt client is holding 10 tokens and is disconnected");
                    ((TransportException)localObject1).setRetryable(true);
                    throw ((Throwable)localObject1);
                  }
                }
                else
                {
                  localObject1 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
                  ((TransportException)localObject1).<init>("Connection was lost while waiting for mqtt deliveries to finish");
                  ((TransportException)localObject1).setRetryable(true);
                  throw ((Throwable)localObject1);
                }
              }
              if (localObject1.length == 0)
              {
                localObject1 = new k/c/a/a/a/l;
                ((l)localObject1).<init>();
              }
              else
              {
                localObject1 = new l((byte[])localObject1);
              }
              ((l)localObject1).a(1);
              synchronized (publishLock)
              {
                log.e("Publishing message ({}) to MQTT topic {}", paramMessage, paramString);
                localObject1 = mqttConnection.getMqttAsyncClient().a(paramString, (l)localObject1);
                unacknowledgedSentMessages.put(Integer.valueOf(a.n), paramMessage);
                log.b("Message published to MQTT topic {}. Mqtt message id {} added to list of messages to wait for acknowledgement ({})", new Object[] { paramString, Integer.valueOf(a.n), paramMessage });
                return;
              }
            }
            localObject3 = new java/lang/IllegalArgumentException;
            ((IllegalArgumentException)localObject3).<init>("Cannot publish on null or empty publish topic");
            throw ((Throwable)localObject3);
          }
          localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
          ((TransportException)localObject3).<init>("Cannot publish when mqtt client is disconnected");
          ((TransportException)localObject3).setRetryable(true);
          throw ((Throwable)localObject3);
        }
        localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
        ((TransportException)localObject3).<init>("Cannot publish when user supplied SAS token has expired");
        throw ((Throwable)localObject3);
      }
      Object localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
      ((TransportException)localObject3).<init>("Need to open first!");
      ((TransportException)localObject3).setRetryable(true);
      throw ((Throwable)localObject3);
    }
    catch (InterruptedException paramMessage)
    {
      throw new TransportException(e.a.a.a.a.b("Interrupted, Unable to publish message on topic : ", paramString), paramMessage);
    }
    catch (k localk)
    {
      log.c("Message could not be published to MQTT topic {} ({})", new Object[] { paramString, paramMessage, localk });
      paramMessage = new StringBuilder();
      paramMessage.append("Unable to publish message on topic : ");
      paramMessage.append(paramString);
      throw PahoExceptionTranslator.convertToMqttException(localk, paramMessage.toString());
    }
  }
  
  public IotHubTransportMessage receive()
  {
    synchronized (incomingLock)
    {
      if (mqttConnection != null)
      {
        localObject2 = peekMessage();
        if (localObject2 != null)
        {
          localObject3 = (String)((k.a.a.b.e.b)localObject2).getKey();
          if (localObject3 != null)
          {
            localObject2 = (byte[])((k.a.a.b.e.b)localObject2).getValue();
            if (localObject2 != null)
            {
              allReceivedMessages.poll();
              localObject3 = constructMessage((byte[])localObject2, (String)localObject3);
              return (IotHubTransportMessage)localObject3;
            }
            localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
            ((TransportException)localObject3).<init>("Data cannot be null when topic is non-null");
            throw ((Throwable)localObject3);
          }
          return null;
        }
        return null;
      }
      Object localObject3 = new com/microsoft/azure/sdk/iot/device/exceptions/TransportException;
      Object localObject2 = new java/lang/IllegalArgumentException;
      ((IllegalArgumentException)localObject2).<init>("Mqtt client should be initialised at least once before using it");
      ((TransportException)localObject3).<init>((Throwable)localObject2);
      throw ((Throwable)localObject3);
    }
  }
  
  public boolean sendMessageAcknowledgement(int paramInt)
  {
    log.d("Sending mqtt ack for received message with mqtt message id {}", Integer.valueOf(paramInt));
    return mqttConnection.sendMessageAcknowledgement(paramInt);
  }
  
  /* Error */
  public void subscribe(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:stateLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +114 -> 122
    //   11: aload_0
    //   12: getfield 108	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:userSpecifiedSASTokenExpiredOnRetry	Z
    //   15: ifne +85 -> 100
    //   18: aload_0
    //   19: getfield 110	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:mqttConnection	Lcom/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
    //   22: invokevirtual 265	com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection:getMqttAsyncClient	()Lk/c/a/a/a/f;
    //   25: invokevirtual 270	k/c/a/a/a/f:b	()Z
    //   28: ifeq +54 -> 82
    //   31: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   34: ldc_w 563
    //   37: aload_1
    //   38: invokeinterface 565 3 0
    //   43: aload_0
    //   44: getfield 110	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:mqttConnection	Lcom/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection;
    //   47: invokevirtual 265	com/microsoft/azure/sdk/iot/device/transport/mqtt/MqttConnection:getMqttAsyncClient	()Lk/c/a/a/a/f;
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 568	k/c/a/a/a/f:a	(Ljava/lang/String;I)Lk/c/a/a/a/e;
    //   55: checkcast 285	k/c/a/a/a/q
    //   58: getfield 288	k/c/a/a/a/q:a	Lk/c/a/a/a/s/p;
    //   61: ldc2_w 569
    //   64: invokevirtual 295	k/c/a/a/a/s/p:a	(J)V
    //   67: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   70: ldc_w 572
    //   73: aload_1
    //   74: invokeinterface 565 3 0
    //   79: aload_2
    //   80: monitorexit
    //   81: return
    //   82: new 316	com/microsoft/azure/sdk/iot/device/exceptions/TransportException
    //   85: astore_3
    //   86: aload_3
    //   87: ldc_w 574
    //   90: invokespecial 480	com/microsoft/azure/sdk/iot/device/exceptions/TransportException:<init>	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: iconst_1
    //   95: invokevirtual 484	com/microsoft/azure/sdk/iot/device/exceptions/TransportException:setRetryable	(Z)V
    //   98: aload_3
    //   99: athrow
    //   100: new 316	com/microsoft/azure/sdk/iot/device/exceptions/TransportException
    //   103: astore_3
    //   104: aload_3
    //   105: ldc_w 576
    //   108: invokespecial 480	com/microsoft/azure/sdk/iot/device/exceptions/TransportException:<init>	(Ljava/lang/String;)V
    //   111: aload_3
    //   112: athrow
    //   113: astore_1
    //   114: goto +67 -> 181
    //   117: astore 4
    //   119: goto +16 -> 135
    //   122: new 138	java/lang/IllegalArgumentException
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 578
    //   130: invokespecial 143	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: athrow
    //   135: getstatic 101	com/microsoft/azure/sdk/iot/device/transport/mqtt/Mqtt:log	Lk/f/b;
    //   138: ldc_w 580
    //   141: aload_1
    //   142: aload 4
    //   144: invokeinterface 582 4 0
    //   149: new 524	java/lang/StringBuilder
    //   152: astore_3
    //   153: aload_3
    //   154: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   157: aload_3
    //   158: ldc_w 584
    //   161: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: aload_1
    //   167: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 4
    //   173: aload_3
    //   174: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 313	com/microsoft/azure/sdk/iot/device/transport/mqtt/exceptions/PahoExceptionTranslator:convertToMqttException	(Lk/c/a/a/a/k;Ljava/lang/String;)Lcom/microsoft/azure/sdk/iot/device/exceptions/ProtocolException;
    //   180: athrow
    //   181: aload_2
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	Mqtt
    //   0	185	1	paramString	String
    //   4	178	2	localObject1	Object
    //   85	89	3	localObject2	Object
    //   117	55	4	localk	k
    // Exception table:
    //   from	to	target	type
    //   11	79	113	finally
    //   79	81	113	finally
    //   82	100	113	finally
    //   100	113	113	finally
    //   122	135	113	finally
    //   135	181	113	finally
    //   181	183	113	finally
    //   11	79	117	k/c/a/a/a/k
    //   82	100	117	k/c/a/a/a/k
    //   100	113	117	k/c/a/a/a/k
    //   122	135	117	k/c/a/a/a/k
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.Mqtt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */