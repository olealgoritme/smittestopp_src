package com.microsoft.appcenter.utils.context;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import e.a.a.a.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class SessionContext
{
  public static final String STORAGE_KEY = "sessions";
  public static final String STORAGE_KEY_VALUE_SEPARATOR = "/";
  public static final int STORAGE_MAX_SESSIONS = 10;
  public static SessionContext sInstance;
  public final long mAppLaunchTimestamp = System.currentTimeMillis();
  public final NavigableMap<Long, SessionContext.SessionInfo> mSessions = new TreeMap();
  
  public SessionContext()
  {
    Object localObject1 = SharedPreferencesManager.getStringSet("sessions");
    if (localObject1 != null)
    {
      Iterator localIterator = ((Set)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = str.split("/", -1);
        try
        {
          long l1 = Long.parseLong(localObject2[0]);
          localObject1 = localObject2[1];
          if (((String)localObject1).isEmpty()) {
            localObject1 = null;
          } else {
            localObject1 = UUID.fromString((String)localObject1);
          }
          long l2;
          if (localObject2.length > 2) {
            l2 = Long.parseLong(localObject2[2]);
          } else {
            l2 = l1;
          }
          localObject2 = mSessions;
          SessionContext.SessionInfo localSessionInfo = new com/microsoft/appcenter/utils/context/SessionContext$SessionInfo;
          localSessionInfo.<init>(l1, (UUID)localObject1, l2);
          ((NavigableMap)localObject2).put(Long.valueOf(l1), localSessionInfo);
        }
        catch (RuntimeException localRuntimeException)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Ignore invalid session in store: ");
          ((StringBuilder)localObject1).append(str);
          AppCenterLog.warn("AppCenter", ((StringBuilder)localObject1).toString(), localRuntimeException);
        }
      }
    }
    localObject1 = a.a("Loaded stored sessions: ");
    ((StringBuilder)localObject1).append(mSessions);
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
    addSession(null);
  }
  
  public static SessionContext getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localSessionContext = new com/microsoft/appcenter/utils/context/SessionContext;
        localSessionContext.<init>();
        sInstance = localSessionContext;
      }
      SessionContext localSessionContext = sInstance;
      return localSessionContext;
    }
    finally {}
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
  
  public void addSession(UUID paramUUID)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = mSessions;
      SessionContext.SessionInfo localSessionInfo = new com/microsoft/appcenter/utils/context/SessionContext$SessionInfo;
      localSessionInfo.<init>(l, paramUUID, mAppLaunchTimestamp);
      ((NavigableMap)localObject).put(Long.valueOf(l), localSessionInfo);
      if (mSessions.size() > 10) {
        mSessions.pollFirstEntry();
      }
      localObject = new java/util/LinkedHashSet;
      ((LinkedHashSet)localObject).<init>();
      paramUUID = mSessions.values().iterator();
      while (paramUUID.hasNext()) {
        ((HashSet)localObject).add(((SessionContext.SessionInfo)paramUUID.next()).toString());
      }
      SharedPreferencesManager.putStringSet("sessions", (Set)localObject);
      return;
    }
    finally {}
  }
  
  public void clearSessions()
  {
    try
    {
      mSessions.clear();
      SharedPreferencesManager.remove("sessions");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public SessionContext.SessionInfo getSessionAt(long paramLong)
  {
    try
    {
      Object localObject1 = mSessions.floorEntry(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        localObject1 = (SessionContext.SessionInfo)((Map.Entry)localObject1).getValue();
        return (SessionContext.SessionInfo)localObject1;
      }
      return null;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.context.SessionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */