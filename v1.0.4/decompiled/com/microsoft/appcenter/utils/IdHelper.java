package com.microsoft.appcenter.utils;

import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.UUID;

public class IdHelper
{
  public static UUID getInstallId()
  {
    Object localObject = SharedPreferencesManager.getString("installId", "");
    UUID localUUID;
    try
    {
      localObject = UUID.fromString((String)localObject);
    }
    catch (Exception localException)
    {
      AppCenterLog.warn("AppCenter", "Unable to get installID from Shared Preferences");
      localUUID = UUID.randomUUID();
      SharedPreferencesManager.putString("installId", localUUID.toString());
    }
    return localUUID;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.IdHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */