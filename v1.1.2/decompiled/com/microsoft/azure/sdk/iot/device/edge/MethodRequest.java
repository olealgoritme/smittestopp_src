package com.microsoft.azure.sdk.iot.device.edge;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;

public class MethodRequest
{
  public static final String CONNECT_TIMEOUT_KEY_NAME = "connectTimeoutInSeconds";
  public static final String METHOD_NAME_KEY_NAME = "methodName";
  public static final String PAYLOAD_KEY_NAME = "payload";
  public static final String RESPONSE_TIMEOUT_KEY_NAME = "responseTimeoutInSeconds";
  @a(deserialize=false, serialize=true)
  @c("connectTimeoutInSeconds")
  public Integer connectionTimeoutInSeconds;
  @a(deserialize=false, serialize=true)
  @c("methodName")
  public String methodName;
  @a(deserialize=false, serialize=true)
  @c("payload")
  public String payload;
  @a(deserialize=false, serialize=true)
  @c("responseTimeoutInSeconds")
  public Integer responseTimeoutInSeconds;
  
  public MethodRequest() {}
  
  public MethodRequest(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null, null);
  }
  
  public MethodRequest(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      payload = paramString2;
      methodName = paramString1;
      responseTimeoutInSeconds = paramInteger1;
      connectionTimeoutInSeconds = paramInteger2;
      return;
    }
    throw new IllegalArgumentException("MethodName cannot be null or empty");
  }
  
  public String toJson()
  {
    return new e().a().a(this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.edge.MethodRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */