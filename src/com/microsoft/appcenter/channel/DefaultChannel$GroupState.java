package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DefaultChannel$GroupState
{
  public final long mBatchTimeInterval;
  public final Ingestion mIngestion;
  public final Channel.GroupListener mListener;
  public final int mMaxLogsPerBatch;
  public final int mMaxParallelBatches;
  public final String mName;
  public boolean mPaused;
  public final Collection<String> mPausedTargetKeys = new HashSet();
  public int mPendingLogCount;
  public final Runnable mRunnable = new DefaultChannel.GroupState.1(this);
  public boolean mScheduled;
  public final Map<String, List<Log>> mSendingBatches = new HashMap();
  
  public DefaultChannel$GroupState(DefaultChannel paramDefaultChannel, String paramString, int paramInt1, long paramLong, int paramInt2, Ingestion paramIngestion, Channel.GroupListener paramGroupListener)
  {
    mName = paramString;
    mMaxLogsPerBatch = paramInt1;
    mBatchTimeInterval = paramLong;
    mMaxParallelBatches = paramInt2;
    mIngestion = paramIngestion;
    mListener = paramGroupListener;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.DefaultChannel.GroupState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */