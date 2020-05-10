package com.microsoft.azure.sdk.iot.device.edge;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class MethodResult
{
  public static final String PAYLOAD_KEY_NAME = "payload";
  public static final String STATUS_KEY_NAME = "status";
  @a(deserialize=true, serialize=false)
  @c("payload")
  public Object payload;
  @a(deserialize=true, serialize=false)
  @c("status")
  public int status;
  
  public MethodResult() {}
  
  public MethodResult(String paramString)
  {
    paramString = new e().a().a(paramString, MethodResult.class);
    MethodResult localMethodResult = (MethodResult)t.a(MethodResult.class).cast(paramString);
    paramString = payload;
    if (paramString == null) {
      paramString = null;
    }
    payload = paramString;
    status = status;
  }
  
  public String getPayload()
  {
    Object localObject = payload;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if ((localObject instanceof byte[])) {
      return new String((byte[])payload);
    }
    return localObject.toString();
  }
  
  public Object getPayloadObject()
  {
    return payload;
  }
  
  public int getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.edge.MethodResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */