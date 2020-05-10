package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.net.URI;
import java.security.InvalidKeyException;
import java.util.Map;

public abstract class StorageCredentials
{
  public boolean httpsOnly = false;
  
  public static StorageCredentials tryParseCredentials(String paramString)
  {
    return tryParseCredentials(Utility.parseAccountString(paramString));
  }
  
  public static StorageCredentials tryParseCredentials(Map<String, String> paramMap)
  {
    String str1;
    if (paramMap.get("AccountName") != null) {
      str1 = (String)paramMap.get("AccountName");
    } else {
      str1 = null;
    }
    String str2;
    if (paramMap.get("AccountKey") != null) {
      str2 = (String)paramMap.get("AccountKey");
    } else {
      str2 = null;
    }
    if (paramMap.get("SharedAccessSignature") != null) {
      paramMap = (String)paramMap.get("SharedAccessSignature");
    } else {
      paramMap = null;
    }
    if ((str1 != null) && (str2 != null) && (paramMap == null))
    {
      if (Base64.validateIsBase64String(str2)) {
        return new StorageCredentialsAccountAndKey(str1, str2);
      }
      throw new InvalidKeyException("Storage Key is not a valid base64 encoded string.");
    }
    if ((str2 == null) && (paramMap != null)) {
      return new StorageCredentialsSharedAccessSignature(paramMap);
    }
    return null;
  }
  
  public String getAccountName()
  {
    return null;
  }
  
  public boolean isHttpsOnly()
  {
    return httpsOnly;
  }
  
  public void setHttpsOnly(boolean paramBoolean)
  {
    httpsOnly = paramBoolean;
  }
  
  public abstract String toString(boolean paramBoolean);
  
  public StorageUri transformUri(StorageUri paramStorageUri)
  {
    return transformUri(paramStorageUri, null);
  }
  
  public abstract StorageUri transformUri(StorageUri paramStorageUri, OperationContext paramOperationContext);
  
  public URI transformUri(URI paramURI)
  {
    return transformUri(paramURI, null);
  }
  
  public abstract URI transformUri(URI paramURI, OperationContext paramOperationContext);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */