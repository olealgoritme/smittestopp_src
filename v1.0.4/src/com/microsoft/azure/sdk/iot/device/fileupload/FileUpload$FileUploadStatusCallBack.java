package com.microsoft.azure.sdk.iot.device.fileupload;

import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import java.util.Queue;
import k.f.b;

public final class FileUpload$FileUploadStatusCallBack
  implements IotHubEventCallback
{
  public FileUpload$FileUploadStatusCallBack(FileUpload paramFileUpload) {}
  
  public void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof FileUploadInProgress))
      {
        ((FileUploadInProgress)paramObject).triggerCallback(paramIotHubStatusCode);
        try
        {
          FileUpload.access$100().remove(paramObject);
        }
        catch (UnsupportedOperationException paramIotHubStatusCode) {}catch (NullPointerException paramIotHubStatusCode) {}catch (ClassCastException paramIotHubStatusCode) {}
        FileUpload.access$200().e("FileUploadStatusCallBack received callback for unknown FileUpload", paramIotHubStatusCode);
      }
      else
      {
        FileUpload.access$200().a("FileUploadStatusCallBack received callback for unknown FileUpload");
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.fileupload.FileUpload.FileUploadStatusCallBack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */