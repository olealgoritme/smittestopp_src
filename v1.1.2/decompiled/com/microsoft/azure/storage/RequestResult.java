package com.microsoft.azure.storage;

import java.util.Date;

public final class RequestResult
{
  public String contentMD5;
  public String errorCode;
  public String etag;
  public Exception exception;
  public String requestDate;
  public boolean requestServiceEncrypted;
  public String serviceRequestID;
  public Date startDate;
  public int statusCode = -1;
  public String statusMessage;
  public Date stopDate;
  public StorageLocation targetLocation;
  
  public String getContentMD5()
  {
    return contentMD5;
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  public String getRequestDate()
  {
    return requestDate;
  }
  
  public String getServiceRequestID()
  {
    return serviceRequestID;
  }
  
  public Date getStartDate()
  {
    return startDate;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String getStatusMessage()
  {
    return statusMessage;
  }
  
  public Date getStopDate()
  {
    if (stopDate == null) {
      stopDate = new Date();
    }
    return stopDate;
  }
  
  public StorageLocation getTargetLocation()
  {
    return targetLocation;
  }
  
  public boolean isRequestServiceEncrypted()
  {
    return requestServiceEncrypted;
  }
  
  public void setContentMD5(String paramString)
  {
    contentMD5 = paramString;
  }
  
  public void setErrorCode(String paramString)
  {
    errorCode = paramString;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setException(Exception paramException)
  {
    exception = paramException;
  }
  
  public void setRequestDate(String paramString)
  {
    requestDate = paramString;
  }
  
  public void setRequestServiceEncrypted(boolean paramBoolean)
  {
    requestServiceEncrypted = paramBoolean;
  }
  
  public void setServiceRequestID(String paramString)
  {
    serviceRequestID = paramString;
  }
  
  public void setStartDate(Date paramDate)
  {
    startDate = paramDate;
  }
  
  public void setStatusCode(int paramInt)
  {
    statusCode = paramInt;
  }
  
  public void setStatusMessage(String paramString)
  {
    statusMessage = paramString;
  }
  
  public void setStopDate(Date paramDate)
  {
    stopDate = paramDate;
  }
  
  public void setTargetLocation(StorageLocation paramStorageLocation)
  {
    targetLocation = paramStorageLocation;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RequestResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */