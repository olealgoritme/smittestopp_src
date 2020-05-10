package com.microsoft.azure.sdk.iot.device.auth;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IotHubX509
{
  public String pathToPrivateKey;
  public String pathToPublicKeyCertificate;
  public String privateKey;
  public String publicKeyCertificate;
  
  public IotHubX509(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if (paramBoolean1) {
          pathToPublicKeyCertificate = paramString1;
        } else {
          publicKeyCertificate = paramString1;
        }
        if (paramBoolean2) {
          pathToPrivateKey = paramString2;
        } else {
          privateKey = paramString2;
        }
        return;
      }
      throw new IllegalArgumentException("Private key certificate cannot be null or empty");
    }
    throw new IllegalArgumentException("Public key certificate cannot be null or empty");
  }
  
  private String readFromFile(String paramString)
  {
    return new String(Files.readAllBytes(Paths.get(paramString, new String[0])));
  }
  
  public String getPrivateKey()
  {
    if (privateKey == null)
    {
      String str = pathToPrivateKey;
      if (str != null) {
        privateKey = readFromFile(str);
      }
    }
    return privateKey;
  }
  
  public String getPublicKeyCertificate()
  {
    if (publicKeyCertificate == null)
    {
      String str = pathToPublicKeyCertificate;
      if (str != null) {
        publicKeyCertificate = readFromFile(str);
      }
    }
    return publicKeyCertificate;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubX509
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */