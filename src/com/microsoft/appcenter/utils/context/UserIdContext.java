package com.microsoft.appcenter.utils.context;

import android.text.TextUtils;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserIdContext
{
  public static final String CUSTOM_PREFIX = "c";
  public static final int USER_ID_APP_CENTER_MAX_LENGTH = 256;
  public static UserIdContext sInstance;
  public final Set<UserIdContext.Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap());
  public String mUserId;
  
  public static boolean checkUserIdValidForAppCenter(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 256))
    {
      AppCenterLog.error("AppCenter", "userId is limited to 256 characters.");
      return false;
    }
    return true;
  }
  
  public static boolean checkUserIdValidForOneCollector(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    if (paramString.isEmpty())
    {
      AppCenterLog.error("AppCenter", "userId must not be empty.");
      return false;
    }
    int i = paramString.indexOf(":");
    if (i >= 0)
    {
      String str = paramString.substring(0, i);
      if (!str.equals("c"))
      {
        AppCenterLog.error("AppCenter", String.format("userId prefix must be '%s%s', '%s%s' is not supported.", new Object[] { "c", ":", str, ":" }));
        return false;
      }
      if (i == paramString.length() - 1)
      {
        AppCenterLog.error("AppCenter", "userId must not be empty.");
        return false;
      }
    }
    return true;
  }
  
  public static UserIdContext getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localUserIdContext = new com/microsoft/appcenter/utils/context/UserIdContext;
        localUserIdContext.<init>();
        sInstance = localUserIdContext;
      }
      UserIdContext localUserIdContext = sInstance;
      return localUserIdContext;
    }
    finally {}
  }
  
  public static String getPrefixedUserId(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.contains(":")) {
        str = a.b("c:", paramString);
      }
    }
    return str;
  }
  
  public static void unsetInstance()
  {
    try
    {
      sInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean updateUserId(String paramString)
  {
    try
    {
      boolean bool = TextUtils.equals(mUserId, paramString);
      if (bool) {
        return false;
      }
      mUserId = paramString;
      return true;
    }
    finally {}
  }
  
  public void addListener(UserIdContext.Listener paramListener)
  {
    mListeners.add(paramListener);
  }
  
  public String getUserId()
  {
    try
    {
      String str = mUserId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void removeListener(UserIdContext.Listener paramListener)
  {
    mListeners.remove(paramListener);
  }
  
  public void setUserId(String paramString)
  {
    if (!updateUserId(paramString)) {
      return;
    }
    paramString = mListeners.iterator();
    while (paramString.hasNext()) {
      ((UserIdContext.Listener)paramString.next()).onNewUserId(mUserId);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.context.UserIdContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */