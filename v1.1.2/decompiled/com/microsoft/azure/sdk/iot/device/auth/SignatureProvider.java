package com.microsoft.azure.sdk.iot.device.auth;

public abstract interface SignatureProvider
{
  public abstract String sign(String paramString1, String paramString2, String paramString3);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.SignatureProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */