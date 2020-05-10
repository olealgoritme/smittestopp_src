package com.microsoft.azure.sdk.iot.device.hsm.parser;

import com.google.gson.Gson;
import com.microsoft.azure.sdk.iot.deps.util.Base64;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;
import javax.crypto.Mac;

public class SignRequest
{
  public static final String ALGO_NAME = "algo";
  public static final String DATA_NAME = "data";
  public static final String KEY_ID_NAME = "keyId";
  public transient Mac algo;
  @a(deserialize=false, serialize=true)
  @c("algo")
  public String algoString;
  @a(deserialize=false, serialize=true)
  @c("data")
  public String data;
  @a(deserialize=false, serialize=true)
  @c("keyId")
  public String keyId;
  
  public byte[] getData()
  {
    return data.getBytes();
  }
  
  public void setAlgo(Mac paramMac)
  {
    algo = paramMac;
    algoString = paramMac.getAlgorithm().toUpperCase();
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    data = Base64.encodeBase64StringLocal(paramArrayOfByte);
  }
  
  public void setKeyId(String paramString)
  {
    keyId = paramString;
  }
  
  public String toJson()
  {
    return new e().a().a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.hsm.parser.SignRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */