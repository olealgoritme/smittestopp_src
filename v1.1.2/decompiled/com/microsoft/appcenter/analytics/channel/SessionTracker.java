package com.microsoft.appcenter.analytics.channel;

import android.os.SystemClock;
import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.SessionContext.SessionInfo;
import java.util.Date;
import java.util.UUID;

public class SessionTracker
  extends AbstractChannelListener
{
  public static final long SESSION_TIMEOUT = 20000L;
  public final Channel mChannel;
  public final String mGroupName;
  public Long mLastPausedTime;
  public long mLastQueuedLogTime;
  public Long mLastResumedTime;
  public UUID mSid;
  
  public SessionTracker(Channel paramChannel, String paramString)
  {
    mChannel = paramChannel;
    mGroupName = paramString;
  }
  
  private boolean hasSessionTimedOut()
  {
    Object localObject = mLastPausedTime;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool2;
    if (SystemClock.elapsedRealtime() - mLastQueuedLogTime >= 20000L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if (mLastResumedTime.longValue() - Math.max(mLastPausedTime.longValue(), mLastQueuedLogTime) >= 20000L) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("noLogSentForLong=");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" wasBackgroundForLong=");
    ((StringBuilder)localObject).append(bool3);
    AppCenterLog.debug("AppCenterAnalytics", ((StringBuilder)localObject).toString());
    boolean bool4 = bool1;
    if (bool2)
    {
      bool4 = bool1;
      if (bool3) {
        bool4 = true;
      }
    }
    return bool4;
  }
  
  private void sendStartSessionIfNeeded()
  {
    if ((mSid == null) || (hasSessionTimedOut()))
    {
      mSid = UUID.randomUUID();
      SessionContext.getInstance().addSession(mSid);
      mLastQueuedLogTime = SystemClock.elapsedRealtime();
      StartSessionLog localStartSessionLog = new StartSessionLog();
      localStartSessionLog.setSid(mSid);
      mChannel.enqueue(localStartSessionLog, mGroupName, 1);
    }
  }
  
  public void clearSessions()
  {
    SessionContext.getInstance().clearSessions();
  }
  
  public void onActivityPaused()
  {
    AppCenterLog.debug("AppCenterAnalytics", "onActivityPaused");
    mLastPausedTime = Long.valueOf(SystemClock.elapsedRealtime());
  }
  
  public void onActivityResumed()
  {
    AppCenterLog.debug("AppCenterAnalytics", "onActivityResumed");
    mLastResumedTime = Long.valueOf(SystemClock.elapsedRealtime());
    sendStartSessionIfNeeded();
  }
  
  public void onPreparingLog(Log paramLog, String paramString)
  {
    if ((!(paramLog instanceof StartSessionLog)) && (!(paramLog instanceof StartServiceLog)))
    {
      paramString = paramLog.getTimestamp();
      if (paramString != null)
      {
        paramString = SessionContext.getInstance().getSessionAt(paramString.getTime());
        if (paramString != null) {
          paramLog.setSid(paramString.getSessionId());
        }
      }
      else
      {
        paramLog.setSid(mSid);
        mLastQueuedLogTime = SystemClock.elapsedRealtime();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.channel.SessionTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */