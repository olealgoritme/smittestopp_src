package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.PathUtility;
import java.net.URI;
import java.util.Map;

public final class StorageCredentialsSharedAccessSignature
  extends StorageCredentials
{
  public final String token;
  
  public StorageCredentialsSharedAccessSignature(String paramString)
  {
    token = paramString;
    if (paramString == null) {
      setHttpsOnly(false);
    } else {
      try
      {
        paramString = (String[])PathUtility.parseQueryString(paramString).get("spr");
        boolean bool;
        if ((paramString != null) && ("https".equals(paramString[0]))) {
          bool = true;
        } else {
          bool = false;
        }
        setHttpsOnly(bool);
      }
      catch (StorageException paramString)
      {
        setHttpsOnly(false);
      }
    }
  }
  
  public String getToken()
  {
    return token;
  }
  
  public String toString(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = token;
    } else {
      str = "[signature hidden]";
    }
    return String.format("%s=%s", new Object[] { "SharedAccessSignature", str });
  }
  
  public StorageUri transformUri(StorageUri paramStorageUri, OperationContext paramOperationContext)
  {
    return new StorageUri(transformUri(paramStorageUri.getPrimaryUri(), paramOperationContext), transformUri(paramStorageUri.getSecondaryUri(), paramOperationContext));
  }
  
  public URI transformUri(URI paramURI, OperationContext paramOperationContext)
  {
    if (paramURI == null) {
      return null;
    }
    if ((isHttpsOnly()) && (!paramURI.getScheme().equals("https"))) {
      throw new IllegalArgumentException("Cannot use HTTP with credentials that only support HTTPS.");
    }
    return PathUtility.addToQuery(PathUtility.addToQuery(paramURI, token), "api-version=2018-03-28");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageCredentialsSharedAccessSignature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */