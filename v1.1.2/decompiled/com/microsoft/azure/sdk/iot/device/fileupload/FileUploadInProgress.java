package com.microsoft.azure.sdk.iot.device.fileupload;

import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import java.io.IOException;
import java.util.concurrent.Future;

public final class FileUploadInProgress
{
  public IotHubEventCallback statusCallback;
  public Object statusCallbackContext;
  public Future task;
  
  public FileUploadInProgress(IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if (paramIotHubEventCallback != null)
    {
      statusCallback = paramIotHubEventCallback;
      statusCallbackContext = paramObject;
      return;
    }
    throw new IllegalArgumentException("status callback is null");
  }
  
  public boolean isCancelled()
  {
    Future localFuture = task;
    if (localFuture != null) {
      return localFuture.isCancelled();
    }
    throw new IOException("future task is null");
  }
  
  public void setTask(Future paramFuture)
  {
    if (paramFuture != null)
    {
      task = paramFuture;
      return;
    }
    throw new IllegalArgumentException("future task is null");
  }
  
  public void triggerCallback(IotHubStatusCode paramIotHubStatusCode)
  {
    statusCallback.execute(paramIotHubStatusCode, statusCallbackContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.fileupload.FileUploadInProgress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */