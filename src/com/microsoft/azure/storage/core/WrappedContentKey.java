package com.microsoft.azure.storage.core;

import e.b.a.a.b;
import e.b.a.a.f;
import e.b.a.a.i;
import e.b.a.a.l;

public class WrappedContentKey
{
  public String algorithm;
  public byte[] encryptedKey;
  public String keyId;
  
  public WrappedContentKey() {}
  
  public WrappedContentKey(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    keyId = paramString1;
    encryptedKey = paramArrayOfByte;
    algorithm = paramString2;
  }
  
  public static WrappedContentKey deserialize(i parami)
  {
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    WrappedContentKey localWrappedContentKey = new WrappedContentKey();
    while (y != l.END_OBJECT)
    {
      String str = parami.c();
      parami.f();
      if (str.equals("KeyId")) {
        localWrappedContentKey.setKeyId(parami.d());
      } else if (str.equals("EncryptedKey")) {
        localWrappedContentKey.setEncryptedKey(parami.a());
      } else if (str.equals("Algorithm")) {
        localWrappedContentKey.setAlgorithm(parami.d());
      }
      parami.f();
    }
    JsonUtilities.assertIsEndObjectJsonToken(parami);
    return localWrappedContentKey;
  }
  
  public String getAlgorithm()
  {
    return algorithm;
  }
  
  public byte[] getEncryptedKey()
  {
    return encryptedKey;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public void serialize(f paramf)
  {
    String str = getKeyId();
    Object localObject = (e.b.a.a.q.c)paramf;
    ((f)localObject).a("KeyId");
    ((f)localObject).b(str);
    localObject = getEncryptedKey();
    paramf.a("EncryptedKey");
    paramf.a(b.b, (byte[])localObject, 0, localObject.length);
    localObject = getAlgorithm();
    paramf = (e.b.a.a.q.c)paramf;
    paramf.a("Algorithm");
    paramf.b((String)localObject);
  }
  
  public void setAlgorithm(String paramString)
  {
    algorithm = paramString;
  }
  
  public void setEncryptedKey(byte[] paramArrayOfByte)
  {
    encryptedKey = paramArrayOfByte;
  }
  
  public void setKeyId(String paramString)
  {
    keyId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.WrappedContentKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */