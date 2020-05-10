package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.LocationMode;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class StorageRequest<C, P, R>
{
  public boolean arePropertiesPopulated = false;
  public HttpURLConnection connection;
  public String contentMD5 = null;
  public StreamMd5AndLength currentDescriptor = null;
  public StorageLocation currentLocation;
  public long currentRequestByteCount = 0L;
  public AccessCondition etagLockCondition = null;
  public StorageException exceptionReference;
  public boolean isSent = false;
  public Long length = null;
  public LocationMode locationMode;
  public String lockedETag = null;
  public boolean nonExceptionedRetryableFailure;
  public Long offset = null;
  public RequestLocationMode requestLocationMode;
  public RequestOptions requestOptions;
  public RequestResult result;
  public InputStream sendStream;
  public StorageUri storageUri;
  
  public StorageRequest() {}
  
  public StorageRequest(RequestOptions paramRequestOptions, StorageUri paramStorageUri)
  {
    setRequestOptions(paramRequestOptions);
    setStorageUri(paramStorageUri);
    locationMode = LocationMode.PRIMARY_ONLY;
    requestLocationMode = RequestLocationMode.PRIMARY_ONLY;
  }
  
  public static final void signBlobQueueAndFileRequest(HttpURLConnection paramHttpURLConnection, ServiceClient paramServiceClient, long paramLong, OperationContext paramOperationContext)
  {
    StorageCredentialsHelper.signBlobQueueAndFileRequest(paramServiceClient.getCredentials(), paramHttpURLConnection, paramLong, paramOperationContext);
  }
  
  public static final void signTableRequest(HttpURLConnection paramHttpURLConnection, ServiceClient paramServiceClient, long paramLong, OperationContext paramOperationContext)
  {
    StorageCredentialsHelper.signTableRequest(paramServiceClient.getCredentials(), paramHttpURLConnection, paramLong, paramOperationContext);
  }
  
  public void applyLocationModeToRequest()
  {
    if (getRequestOptions().getLocationMode() != null) {
      setLocationMode(getRequestOptions().getLocationMode());
    }
  }
  
  public abstract HttpURLConnection buildRequest(C paramC, P paramP, OperationContext paramOperationContext);
  
  public boolean getArePropertiesPopulated()
  {
    return arePropertiesPopulated;
  }
  
  public final HttpURLConnection getConnection()
  {
    return connection;
  }
  
  public final String getContentMD5()
  {
    return contentMD5;
  }
  
  public StreamMd5AndLength getCurrentDescriptor()
  {
    return currentDescriptor;
  }
  
  public StorageLocation getCurrentLocation()
  {
    return currentLocation;
  }
  
  public long getCurrentRequestByteCount()
  {
    return currentRequestByteCount;
  }
  
  public AccessCondition getETagLockCondition()
  {
    return etagLockCondition;
  }
  
  public final StorageException getException()
  {
    return exceptionReference;
  }
  
  public Long getLength()
  {
    return length;
  }
  
  public LocationMode getLocationMode()
  {
    return locationMode;
  }
  
  public final String getLockedETag()
  {
    return lockedETag;
  }
  
  public Long getOffset()
  {
    return offset;
  }
  
  public RequestLocationMode getRequestLocationMode()
  {
    return requestLocationMode;
  }
  
  public final RequestOptions getRequestOptions()
  {
    return requestOptions;
  }
  
  public final RequestResult getResult()
  {
    return result;
  }
  
  public final InputStream getSendStream()
  {
    return sendStream;
  }
  
  public StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public final void initialize(OperationContext paramOperationContext)
  {
    RequestResult localRequestResult = new RequestResult();
    setResult(localRequestResult);
    paramOperationContext.appendRequestResult(localRequestResult);
    setException(null);
    setNonExceptionedRetryableFailure(false);
    setIsSent(false);
  }
  
  public void initializeLocation()
  {
    if (getStorageUri() != null)
    {
      int i = getLocationMode().ordinal();
      if ((i != 0) && (i != 1))
      {
        if ((i != 2) && (i != 3)) {
          throw new IllegalArgumentException(String.format("The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "locationMode", getLocationMode() }));
        }
        setCurrentLocation(StorageLocation.SECONDARY);
      }
      else
      {
        setCurrentLocation(StorageLocation.PRIMARY);
      }
    }
    else
    {
      setCurrentLocation(StorageLocation.PRIMARY);
    }
  }
  
  public final boolean isNonExceptionedRetryableFailure()
  {
    return nonExceptionedRetryableFailure;
  }
  
  public boolean isSent()
  {
    return isSent;
  }
  
  public final StorageException materializeException(OperationContext paramOperationContext)
  {
    if (getException() != null) {
      return getException();
    }
    return StorageException.translateException(this, null, paramOperationContext);
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    localObject1 = null;
    Object localObject2 = localObject1;
    try
    {
      if (getConnection() != null) {
        if (getConnection().getErrorStream() == null) {
          localObject2 = localObject1;
        } else {
          localObject2 = StorageErrorHandler.getExtendedErrorInformation(getConnection().getErrorStream());
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
    return (StorageExtendedErrorInformation)localObject2;
  }
  
  public R postProcessResponse(HttpURLConnection paramHttpURLConnection, P paramP, C paramC, OperationContext paramOperationContext, R paramR)
  {
    return paramR;
  }
  
  public abstract R preProcessResponse(P paramP, C paramC, OperationContext paramOperationContext);
  
  public void recoveryAction(OperationContext paramOperationContext) {}
  
  public void setArePropertiesPopulated(boolean paramBoolean)
  {
    arePropertiesPopulated = paramBoolean;
  }
  
  public final void setConnection(HttpURLConnection paramHttpURLConnection)
  {
    connection = paramHttpURLConnection;
  }
  
  public void setContentMD5(String paramString)
  {
    contentMD5 = paramString;
  }
  
  public void setCurrentDescriptor(StreamMd5AndLength paramStreamMd5AndLength)
  {
    currentDescriptor = paramStreamMd5AndLength;
  }
  
  public void setCurrentLocation(StorageLocation paramStorageLocation)
  {
    currentLocation = paramStorageLocation;
  }
  
  public void setCurrentRequestByteCount(long paramLong)
  {
    currentRequestByteCount = paramLong;
  }
  
  public void setETagLockCondition(AccessCondition paramAccessCondition)
  {
    etagLockCondition = paramAccessCondition;
  }
  
  public final void setException(StorageException paramStorageException)
  {
    exceptionReference = paramStorageException;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, P paramP, OperationContext paramOperationContext) {}
  
  public void setIsSent(boolean paramBoolean)
  {
    isSent = paramBoolean;
  }
  
  public void setLength(Long paramLong)
  {
    length = paramLong;
  }
  
  public void setLocationMode(LocationMode paramLocationMode)
  {
    locationMode = paramLocationMode;
  }
  
  public void setLockedETag(String paramString)
  {
    lockedETag = paramString;
  }
  
  public final void setNonExceptionedRetryableFailure(boolean paramBoolean)
  {
    nonExceptionedRetryableFailure = paramBoolean;
  }
  
  public void setOffset(Long paramLong)
  {
    offset = paramLong;
  }
  
  public void setRequestLocationMode() {}
  
  public void setRequestLocationMode(RequestLocationMode paramRequestLocationMode)
  {
    requestLocationMode = paramRequestLocationMode;
  }
  
  public final void setRequestOptions(RequestOptions paramRequestOptions)
  {
    requestOptions = paramRequestOptions;
  }
  
  public final void setResult(RequestResult paramRequestResult)
  {
    result = paramRequestResult;
  }
  
  public void setSendStream(InputStream paramInputStream)
  {
    sendStream = paramInputStream;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
  
  public abstract void signRequest(HttpURLConnection paramHttpURLConnection, C paramC, OperationContext paramOperationContext);
  
  public void validateLocation()
  {
    if ((getStorageUri() != null) && (!getStorageUri().validateLocationMode(locationMode))) {
      throw new UnsupportedOperationException("The URI for the target storage location is not specified. Please consider changing the request's location mode.");
    }
    int i = getRequestLocationMode().ordinal();
    if (i != 0)
    {
      if (i == 1) {
        if (getLocationMode() != LocationMode.PRIMARY_ONLY)
        {
          setCurrentLocation(StorageLocation.SECONDARY);
          setLocationMode(LocationMode.SECONDARY_ONLY);
        }
        else
        {
          throw new IllegalArgumentException("This operation can only be executed against the secondary storage location.");
        }
      }
    }
    else
    {
      if (getLocationMode() == LocationMode.SECONDARY_ONLY) {
        break label129;
      }
      setCurrentLocation(StorageLocation.PRIMARY);
      setLocationMode(LocationMode.PRIMARY_ONLY);
    }
    getResult().setTargetLocation(currentLocation);
    return;
    label129:
    throw new IllegalArgumentException("This operation can only be executed against the primary storage location.");
  }
  
  public void validateStreamWrite(StreamMd5AndLength paramStreamMd5AndLength) {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.StorageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */