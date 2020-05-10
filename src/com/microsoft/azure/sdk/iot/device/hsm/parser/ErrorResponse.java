package com.microsoft.azure.sdk.iot.device.hsm.parser;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class ErrorResponse
{
  public static final String MESSAGE_NAME = "message";
  @a(deserialize=true, serialize=true)
  @c("message")
  public String message;
  
  public static ErrorResponse fromJson(String paramString)
  {
    paramString = new e().a().a(paramString, ErrorResponse.class);
    return (ErrorResponse)t.a(ErrorResponse.class).cast(paramString);
  }
  
  public String getMessage()
  {
    return message;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.hsm.parser.ErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */