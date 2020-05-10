package com.microsoft.appcenter;

import android.os.Bundle;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;

public class ServiceInstrumentationUtils
{
  public static final String DISABLE_ALL_SERVICES = "All";
  public static final String DISABLE_SERVICES = "APP_CENTER_DISABLE";
  
  public static boolean isServiceDisabledByInstrumentation(String paramString)
  {
    try
    {
      Object localObject = InstrumentationRegistryHelper.getArguments().getString("APP_CENTER_DISABLE");
      if (localObject == null) {
        return false;
      }
      localObject = ((String)localObject).split(",");
      int i = localObject.length;
      int j = 0;
      while (j < i)
      {
        String str = localObject[j].trim();
        if (!str.equals("All"))
        {
          boolean bool = str.equals(paramString);
          if (!bool)
          {
            j++;
            continue;
          }
        }
        return true;
      }
      return false;
    }
    catch (LinkageError|IllegalStateException paramString)
    {
      AppCenterLog.debug("AppCenter", "Cannot read instrumentation variables in a non-test environment.");
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ServiceInstrumentationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */