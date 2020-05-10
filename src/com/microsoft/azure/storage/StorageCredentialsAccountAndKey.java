package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class StorageCredentialsAccountAndKey
  extends StorageCredentials
{
  public String accountName;
  public Mac hmacSha256;
  public byte[] key;
  
  public StorageCredentialsAccountAndKey(String paramString1, String paramString2)
  {
    this(paramString1, Base64.decode(paramString2));
  }
  
  public StorageCredentialsAccountAndKey(String paramString, byte[] paramArrayOfByte)
  {
    if (!Utility.isNullOrEmptyOrWhitespace(paramString))
    {
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
      {
        accountName = paramString;
        key = paramArrayOfByte;
        return;
      }
      throw new IllegalArgumentException("Storage Key is not a valid base64 encoded string.");
    }
    throw new IllegalArgumentException("Invalid account name.");
  }
  
  public String exportBase64EncodedKey()
  {
    return Base64.encode(key);
  }
  
  public byte[] exportKey()
  {
    return (byte[])key.clone();
  }
  
  public String getAccountName()
  {
    return accountName;
  }
  
  public Mac getHmac256()
  {
    try
    {
      Mac localMac = hmacSha256;
      if (localMac == null) {
        try
        {
          localMac = Mac.getInstance("HmacSHA256");
          hmacSha256 = localMac;
          SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
          localSecretKeySpec.<init>(key, "HmacSHA256");
          localMac.init(localSecretKeySpec);
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localObject1 = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)localObject1).<init>();
          throw ((Throwable)localObject1);
        }
      }
      Object localObject1 = hmacSha256;
      return (Mac)localObject1;
    }
    finally {}
  }
  
  public void setAccountName(String paramString)
  {
    accountName = paramString;
  }
  
  public String toString(boolean paramBoolean)
  {
    String str1 = getAccountName();
    String str2;
    if (paramBoolean) {
      str2 = exportBase64EncodedKey();
    } else {
      str2 = "[key hidden]";
    }
    return String.format("%s=%s;%s=%s", new Object[] { "AccountName", str1, "AccountKey", str2 });
  }
  
  public StorageUri transformUri(StorageUri paramStorageUri, OperationContext paramOperationContext)
  {
    return paramStorageUri;
  }
  
  public URI transformUri(URI paramURI, OperationContext paramOperationContext)
  {
    return paramURI;
  }
  
  public void updateKey(String paramString)
  {
    try
    {
      updateKey(Base64.decode(paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void updateKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length != 0)
      {
        key = paramArrayOfByte;
        hmacSha256 = null;
        return;
      }
      paramArrayOfByte = new java/lang/IllegalArgumentException;
      paramArrayOfByte.<init>("Storage Key is not a valid base64 encoded string.");
      throw paramArrayOfByte;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageCredentialsAccountAndKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */