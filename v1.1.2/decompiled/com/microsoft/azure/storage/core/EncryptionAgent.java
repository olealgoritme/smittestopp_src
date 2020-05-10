package com.microsoft.azure.storage.core;

import e.b.a.a.f;
import e.b.a.a.i;
import e.b.a.a.l;

public class EncryptionAgent
{
  public EncryptionAlgorithm encryptionAlgorithm;
  public String protocol;
  
  public EncryptionAgent() {}
  
  public EncryptionAgent(String paramString, EncryptionAlgorithm paramEncryptionAlgorithm)
  {
    protocol = paramString;
    encryptionAlgorithm = paramEncryptionAlgorithm;
  }
  
  public static EncryptionAgent deserialize(i parami)
  {
    JsonUtilities.assertIsStartObjectJsonToken(parami);
    parami.f();
    EncryptionAgent localEncryptionAgent = new EncryptionAgent();
    while (y != l.END_OBJECT)
    {
      String str = parami.c();
      parami.f();
      if (str.equals("Protocol")) {
        localEncryptionAgent.setProtocol(parami.d());
      } else if (str.equals("EncryptionAlgorithm")) {
        localEncryptionAgent.setEncryptionAlgorithm(EncryptionAlgorithm.valueOf(parami.d()));
      }
      parami.f();
    }
    JsonUtilities.assertIsEndObjectJsonToken(parami);
    return localEncryptionAgent;
  }
  
  public EncryptionAlgorithm getEncryptionAlgorithm()
  {
    return encryptionAlgorithm;
  }
  
  public String getProtocol()
  {
    return protocol;
  }
  
  public void serialize(f paramf)
  {
    String str = getProtocol();
    e.b.a.a.q.c localc = (e.b.a.a.q.c)paramf;
    localc.a("Protocol");
    localc.b(str);
    str = getEncryptionAlgorithm().toString();
    paramf = (e.b.a.a.q.c)paramf;
    paramf.a("EncryptionAlgorithm");
    paramf.b(str);
  }
  
  public void setEncryptionAlgorithm(EncryptionAlgorithm paramEncryptionAlgorithm)
  {
    encryptionAlgorithm = paramEncryptionAlgorithm;
  }
  
  public void setProtocol(String paramString)
  {
    protocol = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.EncryptionAgent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */