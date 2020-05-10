package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StorageRequest<***>;
import com.microsoft.azure.storage.core.Utility;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;

public class StorageException
  extends Exception
{
  public static final long serialVersionUID = 7972747254288274928L;
  public String errorCode;
  public StorageExtendedErrorInformation extendedErrorInformation;
  public final int httpStatusCode;
  
  public StorageException(String paramString1, String paramString2, int paramInt, StorageExtendedErrorInformation paramStorageExtendedErrorInformation, Exception paramException)
  {
    super(paramString2, paramException);
    errorCode = paramString1;
    httpStatusCode = paramInt;
    extendedErrorInformation = paramStorageExtendedErrorInformation;
  }
  
  public StorageException(String paramString1, String paramString2, Exception paramException)
  {
    this(paramString1, paramString2, 306, null, paramException);
  }
  
  public static StorageException translateClientException(Exception paramException)
  {
    return new StorageException("Client error", "A Client side exception occurred, please check the inner exception for details", 306, null, paramException);
  }
  
  public static StorageException translateException(StorageRequest<?, ?, ?> paramStorageRequest, Exception paramException, OperationContext paramOperationContext)
  {
    Object localObject1;
    int i;
    if ((paramStorageRequest != null) && (paramStorageRequest.getConnection() != null))
    {
      boolean bool = paramException instanceof SocketException;
      localObject1 = "";
      if (bool)
      {
        if (paramException == null) {
          paramStorageRequest = (StorageRequest<?, ?, ?>)localObject1;
        } else {
          paramStorageRequest = paramException.getMessage();
        }
        paramOperationContext = StorageErrorCode.SERVICE_INTERNAL_ERROR;
        return new StorageException("SERVICE_INTERNAL_ERROR", "An unknown failure occurred : ".concat(paramStorageRequest), 500, null, paramException);
      }
      localObject1 = null;
      i = 0;
    }
    try
    {
      int j = paramStorageRequest.getConnection().getResponseCode();
      i = j;
      localObject2 = paramStorageRequest.getConnection().getResponseMessage();
      i = j;
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (localObject1 == null) {
      localObject1 = "";
    }
    localObject2 = paramStorageRequest.parseErrorDetails();
    paramStorageRequest = new StorageException(paramStorageRequest.getResult().getErrorCode(), (String)localObject1, i, (StorageExtendedErrorInformation)localObject2, paramException);
    Utility.logHttpError(paramStorageRequest, paramOperationContext);
    return paramStorageRequest;
    return translateClientException(paramException);
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public StorageExtendedErrorInformation getExtendedErrorInformation()
  {
    return extendedErrorInformation;
  }
  
  public int getHttpStatusCode()
  {
    return httpStatusCode;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */