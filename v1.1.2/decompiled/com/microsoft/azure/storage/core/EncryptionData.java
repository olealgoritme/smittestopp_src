package com.microsoft.azure.storage.core;

import e.b.a.a.b;
import e.b.a.a.f;
import e.b.a.a.i;
import e.b.a.a.l;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EncryptionData
{
  public byte[] contentEncryptionIV;
  public EncryptionAgent encryptionAgent;
  public HashMap<String, String> keyWrappingMetadata;
  public WrappedContentKey wrappedContentKey;
  
  public static void consumeJsonObject(i parami)
  {
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    if (y != l.END_OBJECT) {
      consumeJsonObject(parami);
    }
  }
  
  public static EncryptionData deserialize(i parami)
  {
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    EncryptionData localEncryptionData = new EncryptionData();
    while (y != l.END_OBJECT)
    {
      String str = parami.c();
      parami.f();
      if (str.equals("WrappedContentKey")) {
        localEncryptionData.setWrappedContentKey(WrappedContentKey.deserialize(parami));
      } else if (str.equals("EncryptionAgent")) {
        localEncryptionData.setEncryptionAgent(EncryptionAgent.deserialize(parami));
      } else if (str.equals("ContentEncryptionIV")) {
        localEncryptionData.setContentEncryptionIV(parami.a());
      } else if (str.equals("KeyWrappingMetadata")) {
        localEncryptionData.setKeyWrappingMetadata(deserializeKeyWrappingMetadata(parami));
      } else {
        consumeJsonObject(parami);
      }
      parami.f();
    }
    JsonUtilities.assertIsEndObjectJsonToken(parami);
    return localEncryptionData;
  }
  
  public static EncryptionData deserialize(String paramString)
  {
    paramString = Utility.getJsonParser(paramString);
    try
    {
      if (!paramString.e()) {
        paramString.f();
      }
      EncryptionData localEncryptionData = deserialize(paramString);
      return localEncryptionData;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static HashMap<String, String> deserializeKeyWrappingMetadata(i parami)
  {
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    HashMap localHashMap = new HashMap();
    while (y != l.END_OBJECT)
    {
      String str = parami.c();
      parami.f();
      localHashMap.put(str, parami.d());
      parami.f();
    }
    JsonUtilities.assertIsEndObjectJsonToken(parami);
    return localHashMap;
  }
  
  public void copyValues(EncryptionData paramEncryptionData)
  {
    setWrappedContentKey(paramEncryptionData.getWrappedContentKey());
    setEncryptionAgent(paramEncryptionData.getEncryptionAgent());
    setContentEncryptionIV(paramEncryptionData.getContentEncryptionIV());
    setKeyWrappingMetadata(paramEncryptionData.getKeyWrappingMetadata());
  }
  
  public byte[] getContentEncryptionIV()
  {
    return contentEncryptionIV;
  }
  
  public EncryptionAgent getEncryptionAgent()
  {
    return encryptionAgent;
  }
  
  public HashMap<String, String> getKeyWrappingMetadata()
  {
    return keyWrappingMetadata;
  }
  
  public WrappedContentKey getWrappedContentKey()
  {
    return wrappedContentKey;
  }
  
  public String serialize()
  {
    StringWriter localStringWriter = new StringWriter();
    f localf = Utility.getJsonGenerator(localStringWriter);
    try
    {
      localf.c();
      serialize(localf);
      localf.a();
      return localStringWriter.toString();
    }
    finally
    {
      localf.close();
    }
  }
  
  public void serialize(f paramf)
  {
    paramf.a("WrappedContentKey");
    paramf.c();
    getWrappedContentKey().serialize(paramf);
    paramf.a();
    paramf.a("EncryptionAgent");
    paramf.c();
    getEncryptionAgent().serialize(paramf);
    paramf.a();
    Object localObject = getContentEncryptionIV();
    paramf.a("ContentEncryptionIV");
    paramf.a(b.b, (byte[])localObject, 0, localObject.length);
    paramf.a("KeyWrappingMetadata");
    paramf.c();
    Iterator localIterator = keyWrappingMetadata.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)keyWrappingMetadata.get(str1);
      localObject = (e.b.a.a.q.c)paramf;
      ((f)localObject).a(str1);
      ((f)localObject).b(str2);
    }
    paramf.a();
  }
  
  public void setContentEncryptionIV(byte[] paramArrayOfByte)
  {
    contentEncryptionIV = paramArrayOfByte;
  }
  
  public void setEncryptionAgent(EncryptionAgent paramEncryptionAgent)
  {
    encryptionAgent = paramEncryptionAgent;
  }
  
  public void setKeyWrappingMetadata(HashMap<String, String> paramHashMap)
  {
    keyWrappingMetadata = paramHashMap;
  }
  
  public void setWrappedContentKey(WrappedContentKey paramWrappedContentKey)
  {
    wrappedContentKey = paramWrappedContentKey;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.EncryptionData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */