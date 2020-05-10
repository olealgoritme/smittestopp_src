package com.microsoft.azure.sdk.iot.device.transport.amqps;

public enum AmqpsDeviceAuthenticationState
{
  static
  {
    NOT_AUTHENTICATED = new AmqpsDeviceAuthenticationState("NOT_AUTHENTICATED", 1);
    AUTHENTICATING = new AmqpsDeviceAuthenticationState("AUTHENTICATING", 2);
    AmqpsDeviceAuthenticationState localAmqpsDeviceAuthenticationState = new AmqpsDeviceAuthenticationState("AUTHENTICATED", 3);
    AUTHENTICATED = localAmqpsDeviceAuthenticationState;
    $VALUES = new AmqpsDeviceAuthenticationState[] { UNKNOWN, NOT_AUTHENTICATED, AUTHENTICATING, localAmqpsDeviceAuthenticationState };
  }
  
  public AmqpsDeviceAuthenticationState() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceAuthenticationState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */