package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import l.a.b.a.b.f;
import l.a.b.a.b.k.d;
import l.a.b.a.b.k.p;
import l.a.b.a.d.a0;
import l.a.b.a.d.c0;
import l.a.b.a.d.g0.v;
import l.f.b;

public final class AmqpsDeviceAuthenticationCBS
  extends AmqpsDeviceAuthentication
{
  public static final String CBS_REPLY = "cbs";
  public static final String CBS_TO = "$cbs";
  public static final String DEVICES_PATH = "/devices/";
  public static final String NAME_KEY = "name";
  public static final String OPERATION_KEY = "operation";
  public static final String OPERATION_VALUE = "put-token";
  public static final String RECEIVER_LINK_ENDPOINT_PATH = "$cbs";
  public static final String RECEIVER_LINK_TAG_PREFIX = "cbs-receiver-";
  public static final String SENDER_LINK_ENDPOINT_PATH = "$cbs";
  public static final String SENDER_LINK_TAG_PREFIX = "cbs-sender-";
  public static final String TYPE_KEY = "type";
  public static final String TYPE_VALUE = "servicebus.windows.net:sastoken";
  public static final b log = l.f.c.a(AmqpsDeviceAuthenticationCBS.class);
  public String PROP_KEY_STATUS_CODE = "status-code";
  public final DeviceClientConfig deviceClientConfig;
  public long nextTag = 0L;
  
  public AmqpsDeviceAuthenticationCBS(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig);
    deviceClientConfig = paramDeviceClientConfig;
    senderLinkEndpointPath = "$cbs";
    receiverLinkEndpointPath = "$cbs";
    StringBuilder localStringBuilder = e.a.a.a.a.a("cbs-sender-");
    localStringBuilder.append(senderLinkTag);
    senderLinkTag = localStringBuilder.toString();
    localStringBuilder = e.a.a.a.a.a("cbs-receiver-");
    localStringBuilder.append(receiverLinkTag);
    receiverLinkTag = localStringBuilder.toString();
    senderLinkAddress = senderLinkEndpointPath;
    receiverLinkAddress = receiverLinkEndpointPath;
    amqpProperties.put(f.a("com.microsoft:api-version"), TransportUtils.IOTHUB_API_VERSION);
    amqpProperties.put(f.a("iothub-connection-device-id"), paramDeviceClientConfig.getDeviceId());
  }
  
  private l.a.b.a.f.d.a createCBSAuthenticationMessage(DeviceClientConfig paramDeviceClientConfig, UUID paramUUID)
  {
    l.a.b.a.f.d.a locala = new l.a.b.a.f.d.a();
    Object localObject = new p();
    a = paramUUID;
    c = "$cbs";
    e = "cbs";
    locala.setProperties((p)localObject);
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("operation", "put-token");
    localHashMap.put("type", "servicebus.windows.net:sastoken");
    localObject = paramDeviceClientConfig.getGatewayHostname();
    if (localObject != null)
    {
      paramUUID = (UUID)localObject;
      if (!((String)localObject).isEmpty()) {}
    }
    else
    {
      paramUUID = paramDeviceClientConfig.getIotHubHostname();
    }
    paramUUID = e.a.a.a.a.a(paramUUID, "/devices/");
    paramUUID.append(paramDeviceClientConfig.getDeviceId());
    localHashMap.put("name", paramUUID.toString());
    locala.setApplicationProperties(new d(localHashMap));
    try
    {
      paramUUID = new l/a/b/a/b/k/c;
      paramUUID.<init>(paramDeviceClientConfig.getSasTokenAuthentication().getRenewedSasToken(true, true));
      locala.setBody(paramUUID);
      return locala;
    }
    catch (IOException paramDeviceClientConfig)
    {
      log.e("getRenewedSasToken has thrown exception while building new cbs authentication message", paramDeviceClientConfig);
      throw new TransportException(paramDeviceClientConfig);
    }
  }
  
  public void authenticate(DeviceClientConfig paramDeviceClientConfig, UUID paramUUID)
  {
    log.d("authenticate called in AmqpsDeviceAuthenticationCBS");
    paramUUID = createCBSAuthenticationMessage(paramDeviceClientConfig, paramUUID);
    paramDeviceClientConfig = new byte['Ѐ'];
    for (;;)
    {
      try
      {
        int i = paramUUID.encode(paramDeviceClientConfig, 0, paramDeviceClientConfig.length);
        paramUUID = String.valueOf(nextTag).getBytes();
        long l = nextTag;
        if ((l != 2147483647L) && (l >= 0L)) {
          nextTag = (l + 1L);
        } else {
          nextTag = 0L;
        }
        sendMessageAndGetDeliveryTag(MessageType.CBS_AUTHENTICATION, paramDeviceClientConfig, 0, i, paramUUID);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        paramDeviceClientConfig = new byte[paramDeviceClientConfig.length * 2];
      }
    }
  }
  
  public String getLinkInstanceType()
  {
    return "cbs";
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    paramString = super.getMessageFromReceiverLink(paramString);
    if (paramString != null)
    {
      paramString.setAmqpsMessageType(MessageType.CBS_AUTHENTICATION);
      if (paramString.getCorrelationId() != null) {
        log.a("Received amqp message on cbs receiver link with link correlation id {} and message correlation id {}", linkCorrelationId, paramString.getCorrelationId());
      } else {
        log.e("Received amqp message on cbs receiver link with link correlation id {}", linkCorrelationId);
      }
    }
    return paramString;
  }
  
  public boolean handleAuthenticationMessage(AmqpsMessage paramAmqpsMessage, UUID paramUUID)
  {
    if (paramAmqpsMessage != null)
    {
      if ((paramAmqpsMessage.getApplicationProperties() != null) && (paramAmqpsMessage.getProperties() != null))
      {
        if (getPropertiesf.equals(paramUUID))
        {
          Iterator localIterator = getApplicationPropertiesa.entrySet().iterator();
          while (localIterator.hasNext())
          {
            paramUUID = (Map.Entry)localIterator.next();
            if ((((String)paramUUID.getKey()).equals(PROP_KEY_STATUS_CODE)) && ((paramUUID.getValue() instanceof Integer)))
            {
              int i = ((Integer)paramUUID.getValue()).intValue();
              if (i == 200)
              {
                log.e("CBS authentication message was acknowledged with status 200, authentication for one cbs link pair was successful");
                paramAmqpsMessage.acknowledge(AmqpsMessage.ACK_TYPE.COMPLETE);
                return true;
              }
              log.a("CBS authentication message was rejected with status {}, authentication has failed", Integer.valueOf(i));
              return false;
            }
          }
          log.c("Could not handle authentication message because the received message did not contain a status code even though the correlation id was the expected value");
        }
        else
        {
          log.d("Could not handle authentication message because the received correlation id did not match the expected value");
        }
      }
      else {
        log.c("Could not handle authentication message because it had no application properties or had no system properties");
      }
    }
    else {
      log.c("Could not handle authentication message because it was null");
    }
    return false;
  }
  
  public void setSslDomain(c0 paramc0)
  {
    ((v)paramc0.L()).a(new String[] { "ANONYMOUS" });
    try
    {
      a0 locala0 = makeDomain(deviceClientConfig.getAuthenticationProvider().getSSLContext());
      paramc0.a(locala0);
      return;
    }
    catch (IOException paramc0)
    {
      log.e("setSslDomain has thrown an exception", paramc0);
      throw new TransportException(paramc0);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceAuthenticationCBS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */