package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import java.io.IOException;
import java.util.UUID;
import l.a.b.a.d.a0;
import l.a.b.a.d.c0;
import l.f.b;
import l.f.c;

public class AmqpsDeviceAuthenticationX509
  extends AmqpsDeviceAuthentication
{
  public static final b log = c.a(AmqpsDeviceAuthenticationX509.class);
  public final DeviceClientConfig deviceClientConfig;
  
  public AmqpsDeviceAuthenticationX509(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig);
    deviceClientConfig = paramDeviceClientConfig;
    paramDeviceClientConfig = AmqpsDeviceOperationLinkState.OPENED;
    amqpsSendLinkState = paramDeviceClientConfig;
    amqpsRecvLinkState = paramDeviceClientConfig;
  }
  
  public void authenticate(DeviceClientConfig paramDeviceClientConfig, UUID paramUUID)
  {
    throw new TransportException("Cannot authenticate on demand with x509 auth");
  }
  
  public String getLinkInstanceType()
  {
    return "x509";
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    return null;
  }
  
  public boolean handleAuthenticationMessage(AmqpsMessage paramAmqpsMessage, UUID paramUUID)
  {
    return false;
  }
  
  public boolean onLinkRemoteOpen(String paramString)
  {
    return false;
  }
  
  public boolean operationLinksOpened()
  {
    return true;
  }
  
  public AmqpsSendReturnValue sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    return null;
  }
  
  public void setSslDomain(c0 paramc0)
  {
    if (paramc0 != null) {
      try
      {
        a0 locala0 = makeDomain(deviceClientConfig.getAuthenticationProvider().getSSLContext());
        paramc0.a(locala0);
        return;
      }
      catch (IOException paramc0)
      {
        log.b("setSslDomain has thrown exception", paramc0);
        throw new TransportException(paramc0);
      }
    }
    throw new IllegalArgumentException("Input parameter transport cannot be null.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceAuthenticationX509
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */