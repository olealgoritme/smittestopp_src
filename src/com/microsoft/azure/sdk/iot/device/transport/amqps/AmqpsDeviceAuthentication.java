package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import java.util.UUID;
import javax.net.ssl.SSLContext;
import k.a.b.a.d.a0;
import k.a.b.a.d.a0.a;
import k.a.b.a.d.a0.b;
import k.a.b.a.d.c0;
import k.a.b.a.d.g0.m0.e;
import k.a.b.a.d.g0.m0.f;
import k.f.b;
import k.f.c;

public abstract class AmqpsDeviceAuthentication
  extends AmqpsDeviceOperations
{
  public static final b log = c.a(AmqpsDeviceAuthentication.class);
  
  public AmqpsDeviceAuthentication(DeviceClientConfig paramDeviceClientConfig)
  {
    super(paramDeviceClientConfig, "", "", "", "", "", "");
  }
  
  public abstract void authenticate(DeviceClientConfig paramDeviceClientConfig, UUID paramUUID);
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    throw new TransportException("Should not be called");
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    throw new TransportException("Should not be called");
  }
  
  public abstract boolean handleAuthenticationMessage(AmqpsMessage paramAmqpsMessage, UUID paramUUID);
  
  public a0 makeDomain(SSLContext paramSSLContext)
  {
    e locale = new e();
    c = paramSSLContext;
    b = a0.b.VERIFY_PEER;
    f localf = d;
    a = null;
    paramSSLContext = a0.a.CLIENT;
    a = null;
    a = paramSSLContext;
    return locale;
  }
  
  public abstract void setSslDomain(c0 paramc0);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceAuthentication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */