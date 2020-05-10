package com.microsoft.azure.sdk.iot.device.hsm.parser;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class SignResponse
{
  public static final String DIGEST_NAME = "digest";
  @a(deserialize=true, serialize=true)
  @c("digest")
  public String digest;
  
  public static SignResponse fromJson(String paramString)
  {
    paramString = new e().a().a(paramString, SignResponse.class);
    return (SignResponse)t.a(SignResponse.class).cast(paramString);
  }
  
  public String getDigest()
  {
    return digest;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.hsm.parser.SignResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */