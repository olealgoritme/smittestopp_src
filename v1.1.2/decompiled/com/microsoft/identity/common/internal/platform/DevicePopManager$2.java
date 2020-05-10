package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import java.util.concurrent.CountDownLatch;

public class DevicePopManager$2
  implements TaskCompletedCallbackWithError<String, ClientException>
{
  public DevicePopManager$2(DevicePopManager paramDevicePopManager, String[] paramArrayOfString, CountDownLatch paramCountDownLatch, ClientException[] paramArrayOfClientException) {}
  
  public void onError(ClientException paramClientException)
  {
    val$errorResult[0] = paramClientException;
    val$latch.countDown();
  }
  
  public void onTaskCompleted(String paramString)
  {
    val$result[0] = paramString;
    val$latch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.platform.DevicePopManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */