package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;
import com.microsoft.azure.storage.StorageCredentialsSharedAccessSignature;
import com.microsoft.azure.storage.StorageCredentialsToken;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import javax.crypto.Mac;
import javax.net.ssl.HttpsURLConnection;

public final class StorageCredentialsHelper
{
  public static boolean canCredentialsGenerateClient(StorageCredentials paramStorageCredentials)
  {
    boolean bool;
    if ((!canCredentialsSignRequest(paramStorageCredentials)) && (!paramStorageCredentials.getClass().equals(StorageCredentialsSharedAccessSignature.class)) && (!paramStorageCredentials.getClass().equals(StorageCredentialsToken.class))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean canCredentialsSignRequest(StorageCredentials paramStorageCredentials)
  {
    return paramStorageCredentials.getClass().equals(StorageCredentialsAccountAndKey.class);
  }
  
  public static String computeHmac256(StorageCredentials paramStorageCredentials, String paramString)
  {
    try
    {
      boolean bool = paramStorageCredentials.getClass().equals(StorageCredentialsAccountAndKey.class);
      if (bool) {
        try
        {
          paramString = paramString.getBytes("UTF-8");
          paramStorageCredentials = Base64.encode(((StorageCredentialsAccountAndKey)paramStorageCredentials).getHmac256().doFinal(paramString));
          return paramStorageCredentials;
        }
        catch (UnsupportedEncodingException paramStorageCredentials)
        {
          paramString = new java/lang/IllegalArgumentException;
          paramString.<init>(paramStorageCredentials);
          throw paramString;
        }
      }
      return null;
    }
    finally {}
  }
  
  public static void signBlobQueueAndFileRequest(StorageCredentials paramStorageCredentials, HttpURLConnection paramHttpURLConnection, long paramLong, OperationContext paramOperationContext)
  {
    if (paramStorageCredentials.getClass().equals(StorageCredentialsAccountAndKey.class))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      paramHttpURLConnection.setRequestProperty("x-ms-date", Utility.getGMTTime());
      String str = CanonicalizerFactory.getBlobQueueFileCanonicalizer(paramHttpURLConnection).canonicalize(paramHttpURLConnection, paramStorageCredentials.getAccountName(), Long.valueOf(paramLong));
      paramOperationContext = computeHmac256(paramStorageCredentials, str);
      Logger.trace(localOperationContext, "Signing %s", str);
      paramHttpURLConnection.setRequestProperty("Authorization", String.format("%s %s:%s", new Object[] { "SharedKey", paramStorageCredentials.getAccountName(), paramOperationContext }));
    }
    else if (paramStorageCredentials.getClass().equals(StorageCredentialsToken.class))
    {
      if ((paramHttpURLConnection instanceof HttpsURLConnection)) {
        paramHttpURLConnection.setRequestProperty("Authorization", String.format("%s %s", new Object[] { "Bearer", ((StorageCredentialsToken)paramStorageCredentials).getToken() }));
      } else {
        throw new IllegalArgumentException("Token credential is only supported for HTTPS requests.");
      }
    }
  }
  
  public static void signTableRequest(StorageCredentials paramStorageCredentials, HttpURLConnection paramHttpURLConnection, long paramLong, OperationContext paramOperationContext)
  {
    if (paramStorageCredentials.getClass().equals(StorageCredentialsAccountAndKey.class))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      paramHttpURLConnection.setRequestProperty("x-ms-date", Utility.getGMTTime());
      String str = CanonicalizerFactory.getTableCanonicalizer(paramHttpURLConnection).canonicalize(paramHttpURLConnection, paramStorageCredentials.getAccountName(), Long.valueOf(paramLong));
      paramOperationContext = computeHmac256(paramStorageCredentials, str);
      Logger.trace(localOperationContext, "Signing %s", str);
      paramHttpURLConnection.setRequestProperty("Authorization", String.format("%s %s:%s", new Object[] { "SharedKey", paramStorageCredentials.getAccountName(), paramOperationContext }));
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.StorageCredentialsHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */