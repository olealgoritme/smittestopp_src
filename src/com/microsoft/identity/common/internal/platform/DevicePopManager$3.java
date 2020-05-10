package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import com.microsoft.identity.common.internal.logging.Logger;
import e.e.a.f;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import org.json.JSONException;

public class DevicePopManager$3
  implements Runnable
{
  public DevicePopManager$3(DevicePopManager paramDevicePopManager, TaskCompletedCallbackWithError paramTaskCompletedCallbackWithError) {}
  
  public void run()
  {
    String str2;
    try
    {
      String str1 = DevicePopManager.access$300(DevicePopManager.access$200(DevicePopManager.access$100(DevicePopManager.access$000(this$0).getEntry("microsoft-device-pop", null))));
      val$callback.onTaskCompleted(str1);
      return;
    }
    catch (JSONException localJSONException)
    {
      str2 = "json_construction_failed";
    }
    catch (f localf)
    {
      str2 = "failed_to_compute_thumbprint_with_sha256";
    }
    catch (UnrecoverableEntryException localUnrecoverableEntryException)
    {
      str2 = "protection_params_invalid";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      str2 = "no_such_algorithm";
    }
    catch (KeyStoreException localKeyStoreException)
    {
      str2 = "keystore_not_initialized";
    }
    ClientException localClientException = new ClientException(str2, localKeyStoreException.getMessage(), localKeyStoreException);
    Logger.error(DevicePopManager.access$400(), localClientException.getMessage(), localClientException);
    val$callback.onError(localClientException);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.platform.DevicePopManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */