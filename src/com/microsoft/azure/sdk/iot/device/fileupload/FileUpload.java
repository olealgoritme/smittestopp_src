package com.microsoft.azure.sdk.iot.device.fileupload;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsTransportManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import k.f.b;
import k.f.c;

public final class FileUpload
{
  public static final int MAX_UPLOAD_PARALLEL = 10;
  public static Queue<FileUploadInProgress> fileUploadInProgressesSet;
  public static final b log = c.a(FileUpload.class);
  public FileUpload.FileUploadStatusCallBack fileUploadStatusCallBack;
  public HttpsTransportManager httpsTransportManager;
  public ScheduledExecutorService taskScheduler;
  
  public FileUpload(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      httpsTransportManager = new HttpsTransportManager(paramDeviceClientConfig);
      try
      {
        taskScheduler = Executors.newScheduledThreadPool(10);
        fileUploadInProgressesSet = new LinkedBlockingDeque();
        fileUploadStatusCallBack = new FileUpload.FileUploadStatusCallBack(this, null);
        log.c("FileUpload object is created successfully");
        return;
      }
      catch (NullPointerException paramDeviceClientConfig) {}catch (IllegalArgumentException paramDeviceClientConfig) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create a pool of threads to manager uploads: ");
      localStringBuilder.append(paramDeviceClientConfig);
      throw new IOException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("config is null");
  }
  
  public void closeNow()
  {
    taskScheduler.shutdownNow();
    Iterator localIterator = fileUploadInProgressesSet.iterator();
    while (localIterator.hasNext())
    {
      FileUploadInProgress localFileUploadInProgress = (FileUploadInProgress)localIterator.next();
      if (localFileUploadInProgress.isCancelled()) {
        localFileUploadInProgress.triggerCallback(IotHubStatusCode.ERROR);
      }
    }
  }
  
  public void uploadToBlobAsync(String paramString, InputStream paramInputStream, long paramLong, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.isEmpty())
      {
        if (paramInputStream != null)
        {
          if (paramLong >= 0L)
          {
            if (paramIotHubEventCallback != null)
            {
              FileUploadInProgress localFileUploadInProgress = new com/microsoft/azure/sdk/iot/device/fileupload/FileUploadInProgress;
              localFileUploadInProgress.<init>(paramIotHubEventCallback, paramObject);
              fileUploadInProgressesSet.add(localFileUploadInProgress);
              paramIotHubEventCallback = new com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask;
              paramIotHubEventCallback.<init>(paramString, paramInputStream, paramLong, httpsTransportManager, fileUploadStatusCallBack, localFileUploadInProgress);
              localFileUploadInProgress.setTask(taskScheduler.submit(paramIotHubEventCallback));
              return;
            }
            paramString = new java/lang/IllegalArgumentException;
            paramString.<init>("statusCallback is null");
            throw paramString;
          }
          paramString = new java/lang/IllegalArgumentException;
          paramString.<init>("streamLength is negative");
          throw paramString;
        }
        paramString = new java/lang/IllegalArgumentException;
        paramString.<init>("inputStream is null");
        throw paramString;
      }
      paramString = new java/lang/IllegalArgumentException;
      paramString.<init>("blobName is null or empty");
      throw paramString;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.fileupload.FileUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */