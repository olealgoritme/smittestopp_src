package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;

public class DevicePopManager$1
  implements Runnable
{
  public DevicePopManager$1(DevicePopManager paramDevicePopManager, TaskCompletedCallbackWithError paramTaskCompletedCallbackWithError, Context paramContext) {}
  
  public void run()
  {
    try
    {
      val$callback.onTaskCompleted(this$0.generateAsymmetricKey(val$context));
    }
    catch (ClientException localClientException)
    {
      val$callback.onError(localClientException);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.platform.DevicePopManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */