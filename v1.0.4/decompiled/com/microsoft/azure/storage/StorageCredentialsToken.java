package com.microsoft.azure.storage;

import java.net.URI;

public final class StorageCredentialsToken
  extends StorageCredentials
{
  public volatile String accountName;
  public volatile String token;
  
  public StorageCredentialsToken(String paramString1, String paramString2)
  {
    accountName = paramString1;
    token = paramString2;
  }
  
  public String getAccountName()
  {
    return accountName;
  }
  
  public String getToken()
  {
    return token;
  }
  
  public boolean isHttpsOnly()
  {
    return true;
  }
  
  public String toString(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = token;
    } else {
      str = "[token hidden]";
    }
    return String.format("%s=%s", new Object[] { "AccountToken", str });
  }
  
  public StorageUri transformUri(StorageUri paramStorageUri, OperationContext paramOperationContext)
  {
    return paramStorageUri;
  }
  
  public URI transformUri(URI paramURI, OperationContext paramOperationContext)
  {
    return paramURI;
  }
  
  public void updateToken(String paramString)
  {
    try
    {
      token = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageCredentialsToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */