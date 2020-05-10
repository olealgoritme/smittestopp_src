package com.microsoft.azure.sdk.iot.device.transport.https;

public enum HttpsMethod
{
  static
  {
    HttpsMethod localHttpsMethod = new HttpsMethod("DELETE", 3);
    DELETE = localHttpsMethod;
    $VALUES = new HttpsMethod[] { GET, POST, PUT, localHttpsMethod };
  }
  
  public HttpsMethod() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.https.HttpsMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */