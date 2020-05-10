package com.microsoft.appcenter.utils.context;

import e.a.a.a.a;
import java.util.UUID;

public class SessionContext$SessionInfo
{
  public final long mAppLaunchTimestamp;
  public final UUID mSessionId;
  public final long mTimestamp;
  
  public SessionContext$SessionInfo(long paramLong1, UUID paramUUID, long paramLong2)
  {
    mTimestamp = paramLong1;
    mSessionId = paramUUID;
    mAppLaunchTimestamp = paramLong2;
  }
  
  public long getAppLaunchTimestamp()
  {
    return mAppLaunchTimestamp;
  }
  
  public UUID getSessionId()
  {
    return mSessionId;
  }
  
  public long getTimestamp()
  {
    return mTimestamp;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getTimestamp());
    ((StringBuilder)localObject).append("/");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (getSessionId() != null)
    {
      localObject = a.a(str);
      ((StringBuilder)localObject).append(getSessionId());
      localObject = ((StringBuilder)localObject).toString();
    }
    localObject = a.a((String)localObject, "/");
    ((StringBuilder)localObject).append(getAppLaunchTimestamp());
    return ((StringBuilder)localObject).toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.context.SessionContext.SessionInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */