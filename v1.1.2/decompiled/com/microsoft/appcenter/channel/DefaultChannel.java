package com.microsoft.appcenter.channel;

import android.content.Context;
import android.os.Handler;
import com.microsoft.appcenter.CancellationException;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.AppCenterIngestion;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.persistence.DatabasePersistence;
import com.microsoft.appcenter.persistence.Persistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class DefaultChannel
  implements Channel
{
  public static final int CLEAR_BATCH_SIZE = 100;
  public static final long MINIMUM_TRANSMISSION_INTERVAL = 3000L;
  public static final String START_TIMER_PREFIX = "startTimerPrefix.";
  public final Handler mAppCenterHandler;
  public String mAppSecret;
  public final Context mContext;
  public int mCurrentState;
  public Device mDevice;
  public boolean mDiscardLogs;
  public boolean mEnabled;
  public final Map<String, GroupState> mGroupStates;
  public final Ingestion mIngestion;
  public final Set<Ingestion> mIngestions;
  public final UUID mInstallId;
  public final Collection<Channel.Listener> mListeners;
  public final Persistence mPersistence;
  
  public DefaultChannel(Context paramContext, String paramString, LogSerializer paramLogSerializer, HttpClient paramHttpClient, Handler paramHandler)
  {
    this(paramContext, paramString, buildDefaultPersistence(paramContext, paramLogSerializer), new AppCenterIngestion(paramHttpClient, paramLogSerializer), paramHandler);
  }
  
  public DefaultChannel(Context paramContext, String paramString, Persistence paramPersistence, Ingestion paramIngestion, Handler paramHandler)
  {
    mContext = paramContext;
    mAppSecret = paramString;
    mInstallId = IdHelper.getInstallId();
    mGroupStates = new HashMap();
    mListeners = new LinkedHashSet();
    mPersistence = paramPersistence;
    mIngestion = paramIngestion;
    paramContext = new HashSet();
    mIngestions = paramContext;
    paramContext.add(mIngestion);
    mAppCenterHandler = paramHandler;
    mEnabled = true;
  }
  
  public static Persistence buildDefaultPersistence(Context paramContext, LogSerializer paramLogSerializer)
  {
    paramContext = new DatabasePersistence(paramContext);
    paramContext.setLogSerializer(paramLogSerializer);
    return paramContext;
  }
  
  private void checkPendingLogsAfterPost(GroupState paramGroupState, int paramInt)
  {
    if (checkStateDidNotChange(paramGroupState, paramInt)) {
      checkPendingLogs(paramGroupState);
    }
  }
  
  private boolean checkStateDidNotChange(GroupState paramGroupState, int paramInt)
  {
    try
    {
      if (paramInt == mCurrentState)
      {
        Object localObject = mGroupStates.get(mName);
        if (paramGroupState == localObject)
        {
          bool = true;
          break label38;
        }
      }
      boolean bool = false;
      label38:
      return bool;
    }
    finally
    {
      paramGroupState = finally;
      throw paramGroupState;
    }
  }
  
  private void deleteLogsOnSuspended(GroupState paramGroupState)
  {
    ArrayList localArrayList = new ArrayList();
    mPersistence.getLogs(mName, Collections.emptyList(), 100, localArrayList);
    if ((localArrayList.size() > 0) && (mListener != null))
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Log localLog = (Log)localIterator.next();
        mListener.onBeforeSending(localLog);
        mListener.onFailure(localLog, new CancellationException());
      }
    }
    if ((localArrayList.size() >= 100) && (mListener != null)) {
      deleteLogsOnSuspended(paramGroupState);
    } else {
      mPersistence.deleteLogs(mName);
    }
  }
  
  private void handleSendingFailure(GroupState paramGroupState, String paramString, Exception paramException)
  {
    try
    {
      String str = mName;
      List localList = (List)mSendingBatches.remove(paramString);
      if (localList != null)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Sending logs groupName=");
        localStringBuilder.append(str);
        localStringBuilder.append(" id=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" failed");
        AppCenterLog.error("AppCenter", localStringBuilder.toString(), paramException);
        boolean bool = HttpUtils.isRecoverableError(paramException);
        if (bool)
        {
          mPendingLogCount += localList.size();
        }
        else
        {
          paramGroupState = mListener;
          if (paramGroupState != null)
          {
            paramString = localList.iterator();
            while (paramString.hasNext()) {
              paramGroupState.onFailure((Log)paramString.next(), paramException);
            }
          }
        }
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
        suspend(bool, paramException);
      }
      return;
    }
    finally {}
  }
  
  private void handleSendingSuccess(GroupState paramGroupState, String paramString)
  {
    try
    {
      Object localObject = (List)mSendingBatches.remove(paramString);
      if (localObject != null)
      {
        mPersistence.deleteLogs(mName, paramString);
        paramString = mListener;
        if (paramString != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramString.onSuccess((Log)((Iterator)localObject).next());
          }
        }
        checkPendingLogs(paramGroupState);
      }
      return;
    }
    finally {}
  }
  
  private Long resolveCustomTriggerInterval(GroupState paramGroupState)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder = a.a("startTimerPrefix.");
    localStringBuilder.append(mName);
    long l2 = SharedPreferencesManager.getLong(localStringBuilder.toString());
    if (mPendingLogCount > 0)
    {
      if ((l2 != 0L) && (l2 <= l1)) {
        return Long.valueOf(Math.max(mBatchTimeInterval - (l1 - l2), 0L));
      }
      localStringBuilder = a.a("startTimerPrefix.");
      localStringBuilder.append(mName);
      SharedPreferencesManager.putLong(localStringBuilder.toString(), l1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("The timer value for ");
      localStringBuilder.append(mName);
      localStringBuilder.append(" has been saved.");
      AppCenterLog.debug("AppCenter", localStringBuilder.toString());
      return Long.valueOf(mBatchTimeInterval);
    }
    if (l2 + mBatchTimeInterval < l1)
    {
      localStringBuilder = a.a("startTimerPrefix.");
      localStringBuilder.append(mName);
      SharedPreferencesManager.remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("The timer for ");
      localStringBuilder.append(mName);
      localStringBuilder.append(" channel finished.");
      AppCenterLog.debug("AppCenter", localStringBuilder.toString());
    }
    return null;
  }
  
  private Long resolveDefaultTriggerInterval(GroupState paramGroupState)
  {
    int i = mPendingLogCount;
    if (i >= mMaxLogsPerBatch) {
      return Long.valueOf(0L);
    }
    if (i > 0) {
      paramGroupState = Long.valueOf(mBatchTimeInterval);
    } else {
      paramGroupState = null;
    }
    return paramGroupState;
  }
  
  private Long resolveTriggerInterval(GroupState paramGroupState)
  {
    if (mBatchTimeInterval > 3000L) {
      return resolveCustomTriggerInterval(paramGroupState);
    }
    return resolveDefaultTriggerInterval(paramGroupState);
  }
  
  private void sendLogs(GroupState paramGroupState, int paramInt, List<Log> paramList, String paramString)
  {
    try
    {
      if (checkStateDidNotChange(paramGroupState, paramInt))
      {
        LogContainer localLogContainer = new com/microsoft/appcenter/ingestion/models/LogContainer;
        localLogContainer.<init>();
        localLogContainer.setLogs(paramList);
        Ingestion localIngestion = mIngestion;
        paramList = mAppSecret;
        UUID localUUID = mInstallId;
        ServiceCallback local2 = new com/microsoft/appcenter/channel/DefaultChannel$2;
        local2.<init>(this, paramGroupState, paramString);
        localIngestion.sendAsync(paramList, localUUID, localLogContainer, local2);
        paramString = mAppCenterHandler;
        paramList = new com/microsoft/appcenter/channel/DefaultChannel$3;
        paramList.<init>(this, paramGroupState, paramInt);
        paramString.post(paramList);
      }
      return;
    }
    finally
    {
      paramGroupState = finally;
      throw paramGroupState;
    }
  }
  
  private void suspend(boolean paramBoolean, Exception paramException)
  {
    mEnabled = false;
    mDiscardLogs = paramBoolean;
    mCurrentState += 1;
    Iterator localIterator1 = mGroupStates.values().iterator();
    break label78;
    label35:
    Object localObject1;
    if (localIterator1.hasNext())
    {
      localObject1 = (GroupState)localIterator1.next();
      cancelTimer((GroupState)localObject1);
      localIterator2 = mSendingBatches.entrySet().iterator();
      for (;;)
      {
        label78:
        if (!localIterator2.hasNext()) {
          break label35;
        }
        Object localObject2 = (Map.Entry)localIterator2.next();
        localIterator2.remove();
        if (!paramBoolean) {
          break;
        }
        Channel.GroupListener localGroupListener = mListener;
        if (localGroupListener == null) {
          break;
        }
        localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localGroupListener.onFailure((Log)((Iterator)localObject2).next(), paramException);
        }
      }
    }
    Iterator localIterator2 = mIngestions.iterator();
    while (localIterator2.hasNext())
    {
      localObject1 = (Ingestion)localIterator2.next();
      try
      {
        ((Closeable)localObject1).close();
      }
      catch (IOException localIOException)
      {
        paramException = new StringBuilder();
        paramException.append("Failed to close ingestion: ");
        paramException.append(localObject1);
        AppCenterLog.error("AppCenter", paramException.toString(), localIOException);
      }
    }
    if (paramBoolean)
    {
      paramException = mGroupStates.values().iterator();
      while (paramException.hasNext()) {
        deleteLogsOnSuspended((GroupState)paramException.next());
      }
    }
    mPersistence.clearPendingLogState();
  }
  
  private void triggerIngestion(GroupState paramGroupState)
  {
    try
    {
      boolean bool = mEnabled;
      if (!bool) {
        return;
      }
      int i = mPendingLogCount;
      int j = Math.min(i, mMaxLogsPerBatch);
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("triggerIngestion(");
      ((StringBuilder)localObject1).append(mName);
      ((StringBuilder)localObject1).append(") pendingLogCount=");
      ((StringBuilder)localObject1).append(i);
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
      cancelTimer(paramGroupState);
      if (mSendingBatches.size() == mMaxParallelBatches)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Already sending ");
        ((StringBuilder)localObject1).append(mMaxParallelBatches);
        ((StringBuilder)localObject1).append(" batches of analytics data to the server.");
        AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>(j);
      i = mCurrentState;
      String str = mPersistence.getLogs(mName, mPausedTargetKeys, j, (List)localObject1);
      mPendingLogCount -= j;
      if (str == null) {
        return;
      }
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("ingestLogs(");
      ((StringBuilder)localObject2).append(mName);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append(") pendingLogCount=");
      ((StringBuilder)localObject2).append(mPendingLogCount);
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject2).toString());
      if (mListener != null)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Log localLog = (Log)((Iterator)localObject2).next();
          mListener.onBeforeSending(localLog);
        }
      }
      mSendingBatches.put(str, localObject1);
      localObject2 = new com/microsoft/appcenter/channel/DefaultChannel$1;
      ((1)localObject2).<init>(this, paramGroupState, i, (List)localObject1, str);
      HandlerUtils.runOnUiThread((Runnable)localObject2);
      return;
    }
    finally {}
  }
  
  public void addGroup(String paramString, int paramInt1, long paramLong, int paramInt2, Ingestion paramIngestion, Channel.GroupListener paramGroupListener)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("addGroup(");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(")");
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
      if (paramIngestion == null) {
        paramIngestion = mIngestion;
      }
      mIngestions.add(paramIngestion);
      localObject = new com/microsoft/appcenter/channel/DefaultChannel$GroupState;
      ((GroupState)localObject).<init>(this, paramString, paramInt1, paramLong, paramInt2, paramIngestion, paramGroupListener);
      mGroupStates.put(paramString, localObject);
      mPendingLogCount = mPersistence.countLogs(paramString);
      if ((mAppSecret != null) || (mIngestion != paramIngestion)) {
        checkPendingLogs((GroupState)localObject);
      }
      paramIngestion = mListeners.iterator();
      while (paramIngestion.hasNext()) {
        ((Channel.Listener)paramIngestion.next()).onGroupAdded(paramString, paramGroupListener, paramLong);
      }
      return;
    }
    finally {}
  }
  
  public void addListener(Channel.Listener paramListener)
  {
    try
    {
      mListeners.add(paramListener);
      return;
    }
    finally
    {
      paramListener = finally;
      throw paramListener;
    }
  }
  
  public void cancelTimer(GroupState paramGroupState)
  {
    if (mScheduled)
    {
      mScheduled = false;
      mAppCenterHandler.removeCallbacks(mRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startTimerPrefix.");
      localStringBuilder.append(mName);
      SharedPreferencesManager.remove(localStringBuilder.toString());
    }
  }
  
  public void checkPendingLogs(GroupState paramGroupState)
  {
    try
    {
      AppCenterLog.debug("AppCenter", String.format("checkPendingLogs(%s) pendingLogCount=%s batchTimeInterval=%s", new Object[] { mName, Integer.valueOf(mPendingLogCount), Long.valueOf(mBatchTimeInterval) }));
      Long localLong = resolveTriggerInterval(paramGroupState);
      if ((localLong != null) && (!mPaused))
      {
        if (localLong.longValue() == 0L)
        {
          triggerIngestion(paramGroupState);
        }
        else if (!mScheduled)
        {
          mScheduled = true;
          mAppCenterHandler.postDelayed(mRunnable, localLong.longValue());
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void clear(String paramString)
  {
    try
    {
      boolean bool = mGroupStates.containsKey(paramString);
      if (!bool) {
        return;
      }
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("clear(");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(")");
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
      mPersistence.deleteLogs(paramString);
      localObject = mListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Channel.Listener)((Iterator)localObject).next()).onClear(paramString);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void enqueue(Log paramLog, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/microsoft/appcenter/channel/DefaultChannel:mGroupStates	Ljava/util/Map;
    //   6: aload_2
    //   7: invokeinterface 178 2 0
    //   12: checkcast 18	com/microsoft/appcenter/channel/DefaultChannel$GroupState
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +38 -> 57
    //   22: new 245	java/lang/StringBuilder
    //   25: astore_1
    //   26: aload_1
    //   27: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   30: aload_1
    //   31: ldc_w 529
    //   34: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc_w 258
    //   47: aload_1
    //   48: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 531	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 379	com/microsoft/appcenter/channel/DefaultChannel:mDiscardLogs	Z
    //   61: ifeq +58 -> 119
    //   64: ldc_w 258
    //   67: ldc_w 533
    //   70: invokestatic 536	com/microsoft/appcenter/utils/AppCenterLog:warn	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 4
    //   75: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   78: ifnull +38 -> 116
    //   81: aload 4
    //   83: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   86: aload_1
    //   87: invokeinterface 222 2 0
    //   92: aload 4
    //   94: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   97: astore 4
    //   99: new 224	com/microsoft/appcenter/CancellationException
    //   102: astore_2
    //   103: aload_2
    //   104: invokespecial 225	com/microsoft/appcenter/CancellationException:<init>	()V
    //   107: aload 4
    //   109: aload_1
    //   110: aload_2
    //   111: invokeinterface 229 3 0
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: aload_0
    //   120: getfield 98	com/microsoft/appcenter/channel/DefaultChannel:mListeners	Ljava/util/Collection;
    //   123: invokeinterface 386 1 0
    //   128: astore 5
    //   130: aload 5
    //   132: invokeinterface 210 1 0
    //   137: ifeq +23 -> 160
    //   140: aload 5
    //   142: invokeinterface 214 1 0
    //   147: checkcast 470	com/microsoft/appcenter/channel/Channel$Listener
    //   150: aload_1
    //   151: aload_2
    //   152: invokeinterface 540 3 0
    //   157: goto -27 -> 130
    //   160: aload_1
    //   161: invokeinterface 544 1 0
    //   166: ifnonnull +52 -> 218
    //   169: aload_0
    //   170: getfield 546	com/microsoft/appcenter/channel/DefaultChannel:mDevice	Lcom/microsoft/appcenter/ingestion/models/Device;
    //   173: astore 5
    //   175: aload 5
    //   177: ifnonnull +31 -> 208
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 78	com/microsoft/appcenter/channel/DefaultChannel:mContext	Landroid/content/Context;
    //   185: invokestatic 552	com/microsoft/appcenter/utils/DeviceInfoHelper:getDeviceInfo	(Landroid/content/Context;)Lcom/microsoft/appcenter/ingestion/models/Device;
    //   188: putfield 546	com/microsoft/appcenter/channel/DefaultChannel:mDevice	Lcom/microsoft/appcenter/ingestion/models/Device;
    //   191: goto +17 -> 208
    //   194: astore_1
    //   195: ldc_w 258
    //   198: ldc_w 554
    //   201: aload_1
    //   202: invokestatic 268	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: monitorexit
    //   207: return
    //   208: aload_1
    //   209: aload_0
    //   210: getfield 546	com/microsoft/appcenter/channel/DefaultChannel:mDevice	Lcom/microsoft/appcenter/ingestion/models/Device;
    //   213: invokeinterface 558 2 0
    //   218: aload_1
    //   219: invokeinterface 562 1 0
    //   224: ifnonnull +21 -> 245
    //   227: new 564	java/util/Date
    //   230: astore 5
    //   232: aload 5
    //   234: invokespecial 565	java/util/Date:<init>	()V
    //   237: aload_1
    //   238: aload 5
    //   240: invokeinterface 569 2 0
    //   245: aload_0
    //   246: getfield 98	com/microsoft/appcenter/channel/DefaultChannel:mListeners	Ljava/util/Collection;
    //   249: invokeinterface 386 1 0
    //   254: astore 5
    //   256: aload 5
    //   258: invokeinterface 210 1 0
    //   263: ifeq +24 -> 287
    //   266: aload 5
    //   268: invokeinterface 214 1 0
    //   273: checkcast 470	com/microsoft/appcenter/channel/Channel$Listener
    //   276: aload_1
    //   277: aload_2
    //   278: iload_3
    //   279: invokeinterface 572 4 0
    //   284: goto -28 -> 256
    //   287: aload_0
    //   288: getfield 98	com/microsoft/appcenter/channel/DefaultChannel:mListeners	Ljava/util/Collection;
    //   291: invokeinterface 386 1 0
    //   296: astore 5
    //   298: iconst_0
    //   299: istore 6
    //   301: aload 5
    //   303: invokeinterface 210 1 0
    //   308: ifeq +37 -> 345
    //   311: aload 5
    //   313: invokeinterface 214 1 0
    //   318: checkcast 470	com/microsoft/appcenter/channel/Channel$Listener
    //   321: astore 7
    //   323: iload 6
    //   325: ifne +14 -> 339
    //   328: aload 7
    //   330: aload_1
    //   331: invokeinterface 576 2 0
    //   336: ifeq -38 -> 298
    //   339: iconst_1
    //   340: istore 6
    //   342: goto -41 -> 301
    //   345: iload 6
    //   347: ifeq +51 -> 398
    //   350: new 245	java/lang/StringBuilder
    //   353: astore_2
    //   354: aload_2
    //   355: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   358: aload_2
    //   359: ldc_w 578
    //   362: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_2
    //   367: aload_1
    //   368: invokeinterface 581 1 0
    //   373: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_2
    //   378: ldc_w 583
    //   381: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: ldc_w 258
    //   388: aload_2
    //   389: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 334	com/microsoft/appcenter/utils/AppCenterLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: goto +268 -> 663
    //   398: aload_0
    //   399: getfield 80	com/microsoft/appcenter/channel/DefaultChannel:mAppSecret	Ljava/lang/String;
    //   402: ifnonnull +63 -> 465
    //   405: aload 4
    //   407: getfield 357	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mIngestion	Lcom/microsoft/appcenter/ingestion/Ingestion;
    //   410: aload_0
    //   411: getfield 102	com/microsoft/appcenter/channel/DefaultChannel:mIngestion	Lcom/microsoft/appcenter/ingestion/Ingestion;
    //   414: if_acmpne +51 -> 465
    //   417: new 245	java/lang/StringBuilder
    //   420: astore_2
    //   421: aload_2
    //   422: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   425: aload_2
    //   426: ldc_w 578
    //   429: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_2
    //   434: aload_1
    //   435: invokeinterface 581 1 0
    //   440: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_2
    //   445: ldc_w 585
    //   448: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: ldc_w 258
    //   455: aload_2
    //   456: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 334	com/microsoft/appcenter/utils/AppCenterLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: aload_0
    //   463: monitorexit
    //   464: return
    //   465: aload_0
    //   466: getfield 100	com/microsoft/appcenter/channel/DefaultChannel:mPersistence	Lcom/microsoft/appcenter/persistence/Persistence;
    //   469: aload_1
    //   470: aload_2
    //   471: iload_3
    //   472: invokevirtual 589	com/microsoft/appcenter/persistence/Persistence:putLog	(Lcom/microsoft/appcenter/ingestion/models/Log;Ljava/lang/String;I)J
    //   475: pop2
    //   476: aload_1
    //   477: invokeinterface 592 1 0
    //   482: invokeinterface 394 1 0
    //   487: astore_1
    //   488: aload_1
    //   489: invokeinterface 210 1 0
    //   494: ifeq +19 -> 513
    //   497: aload_1
    //   498: invokeinterface 214 1 0
    //   503: checkcast 496	java/lang/String
    //   506: invokestatic 598	com/microsoft/appcenter/ingestion/models/one/PartAUtils:getTargetKey	(Ljava/lang/String;)Ljava/lang/String;
    //   509: astore_1
    //   510: goto +5 -> 515
    //   513: aconst_null
    //   514: astore_1
    //   515: aload 4
    //   517: getfield 439	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mPausedTargetKeys	Ljava/util/Collection;
    //   520: aload_1
    //   521: invokeinterface 601 2 0
    //   526: ifeq +46 -> 572
    //   529: new 245	java/lang/StringBuilder
    //   532: astore_2
    //   533: aload_2
    //   534: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   537: aload_2
    //   538: ldc_w 603
    //   541: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_2
    //   546: aload_1
    //   547: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_2
    //   552: ldc_w 605
    //   555: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: ldc_w 258
    //   562: aload_2
    //   563: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 334	com/microsoft/appcenter/utils/AppCenterLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload_0
    //   570: monitorexit
    //   571: return
    //   572: aload 4
    //   574: aload 4
    //   576: getfield 277	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mPendingLogCount	I
    //   579: iconst_1
    //   580: iadd
    //   581: putfield 277	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mPendingLogCount	I
    //   584: new 245	java/lang/StringBuilder
    //   587: astore_1
    //   588: aload_1
    //   589: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   592: aload_1
    //   593: ldc_w 607
    //   596: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload_1
    //   601: aload 4
    //   603: getfield 172	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mName	Ljava/lang/String;
    //   606: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload_1
    //   611: ldc_w 422
    //   614: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload_1
    //   619: aload 4
    //   621: getfield 277	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mPendingLogCount	I
    //   624: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: ldc_w 258
    //   631: aload_1
    //   632: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 334	com/microsoft/appcenter/utils/AppCenterLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload_0
    //   639: getfield 117	com/microsoft/appcenter/channel/DefaultChannel:mEnabled	Z
    //   642: ifeq +12 -> 654
    //   645: aload_0
    //   646: aload 4
    //   648: invokevirtual 167	com/microsoft/appcenter/channel/DefaultChannel:checkPendingLogs	(Lcom/microsoft/appcenter/channel/DefaultChannel$GroupState;)V
    //   651: goto +12 -> 663
    //   654: ldc_w 258
    //   657: ldc_w 609
    //   660: invokestatic 334	com/microsoft/appcenter/utils/AppCenterLog:debug	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload_0
    //   664: monitorexit
    //   665: return
    //   666: astore_2
    //   667: ldc_w 258
    //   670: ldc_w 611
    //   673: aload_2
    //   674: invokestatic 268	com/microsoft/appcenter/utils/AppCenterLog:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   677: aload 4
    //   679: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   682: ifnull +26 -> 708
    //   685: aload 4
    //   687: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   690: aload_1
    //   691: invokeinterface 222 2 0
    //   696: aload 4
    //   698: getfield 200	com/microsoft/appcenter/channel/DefaultChannel$GroupState:mListener	Lcom/microsoft/appcenter/channel/Channel$GroupListener;
    //   701: aload_1
    //   702: aload_2
    //   703: invokeinterface 229 3 0
    //   708: aload_0
    //   709: monitorexit
    //   710: return
    //   711: astore_1
    //   712: aload_0
    //   713: monitorexit
    //   714: aload_1
    //   715: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	DefaultChannel
    //   0	716	1	paramLog	Log
    //   0	716	2	paramString	String
    //   0	716	3	paramInt	int
    //   15	682	4	localObject1	Object
    //   128	184	5	localObject2	Object
    //   299	47	6	i	int
    //   321	8	7	localListener	Channel.Listener
    // Exception table:
    //   from	to	target	type
    //   180	191	194	com/microsoft/appcenter/utils/DeviceInfoHelper$DeviceInfoException
    //   465	476	666	com/microsoft/appcenter/persistence/Persistence$PersistenceException
    //   2	17	711	finally
    //   22	54	711	finally
    //   57	116	711	finally
    //   119	130	711	finally
    //   130	157	711	finally
    //   160	175	711	finally
    //   180	191	711	finally
    //   195	205	711	finally
    //   208	218	711	finally
    //   218	245	711	finally
    //   245	256	711	finally
    //   256	284	711	finally
    //   287	298	711	finally
    //   301	323	711	finally
    //   328	339	711	finally
    //   350	395	711	finally
    //   398	462	711	finally
    //   465	476	711	finally
    //   476	510	711	finally
    //   515	569	711	finally
    //   572	651	711	finally
    //   654	663	711	finally
    //   667	708	711	finally
  }
  
  public GroupState getGroupState(String paramString)
  {
    return (GroupState)mGroupStates.get(paramString);
  }
  
  public void invalidateDeviceCache()
  {
    try
    {
      mDevice = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnabled()
  {
    try
    {
      boolean bool = mEnabled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void pauseGroup(String paramString1, String paramString2)
  {
    try
    {
      Object localObject1 = (GroupState)mGroupStates.get(paramString1);
      if (localObject1 != null)
      {
        if (paramString2 != null)
        {
          localObject2 = PartAUtils.getTargetKey(paramString2);
          if (mPausedTargetKeys.add(localObject2))
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((StringBuilder)localObject1).append("pauseGroup(");
            ((StringBuilder)localObject1).append(paramString1);
            ((StringBuilder)localObject1).append(", ");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(")");
            AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
          }
        }
        else if (!mPaused)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append("pauseGroup(");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(")");
          AppCenterLog.debug("AppCenter", ((StringBuilder)localObject2).toString());
          mPaused = true;
          cancelTimer((GroupState)localObject1);
        }
        Object localObject2 = mListeners.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Channel.Listener)((Iterator)localObject2).next()).onPaused(paramString1, paramString2);
        }
      }
      return;
    }
    finally {}
  }
  
  public void removeGroup(String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("removeGroup(");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(")");
      AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
      localObject = (GroupState)mGroupStates.remove(paramString);
      if (localObject != null) {
        cancelTimer((GroupState)localObject);
      }
      localObject = mListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Channel.Listener)((Iterator)localObject).next()).onGroupRemoved(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void removeListener(Channel.Listener paramListener)
  {
    try
    {
      mListeners.remove(paramListener);
      return;
    }
    finally
    {
      paramListener = finally;
      throw paramListener;
    }
  }
  
  public void resumeGroup(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (GroupState)mGroupStates.get(paramString1);
      if (localObject != null)
      {
        StringBuilder localStringBuilder;
        if (paramString2 != null)
        {
          String str = PartAUtils.getTargetKey(paramString2);
          if (mPausedTargetKeys.remove(str))
          {
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("resumeGroup(");
            localStringBuilder.append(paramString1);
            localStringBuilder.append(", ");
            localStringBuilder.append(str);
            localStringBuilder.append(")");
            AppCenterLog.debug("AppCenter", localStringBuilder.toString());
            mPendingLogCount = mPersistence.countLogs(paramString1);
            checkPendingLogs((GroupState)localObject);
          }
        }
        else if (mPaused)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("resumeGroup(");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(")");
          AppCenterLog.debug("AppCenter", localStringBuilder.toString());
          mPaused = false;
          checkPendingLogs((GroupState)localObject);
        }
        localObject = mListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Channel.Listener)((Iterator)localObject).next()).onResumed(paramString1, paramString2);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setAppSecret(String paramString)
  {
    try
    {
      mAppSecret = paramString;
      if (mEnabled)
      {
        Iterator localIterator = mGroupStates.values().iterator();
        while (localIterator.hasNext())
        {
          paramString = (GroupState)localIterator.next();
          if (mIngestion == mIngestion) {
            checkPendingLogs(paramString);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    try
    {
      boolean bool = mEnabled;
      if (bool == paramBoolean) {
        return;
      }
      if (paramBoolean)
      {
        mEnabled = true;
        mDiscardLogs = false;
        mCurrentState += 1;
        localObject1 = mIngestions.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Ingestion)((Iterator)localObject1).next()).reopen();
        }
        localObject1 = mGroupStates.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          checkPendingLogs((GroupState)((Iterator)localObject1).next());
        }
      }
      Object localObject1 = new com/microsoft/appcenter/CancellationException;
      ((CancellationException)localObject1).<init>();
      suspend(true, (Exception)localObject1);
      localObject1 = mListeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Channel.Listener)((Iterator)localObject1).next()).onGloballyEnabled(paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  public void setLogUrl(String paramString)
  {
    try
    {
      mIngestion.setLogUrl(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean setMaxStorageSize(long paramLong)
  {
    try
    {
      boolean bool = mPersistence.setMaxStorageSize(paramLong);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void shutdown()
  {
    try
    {
      CancellationException localCancellationException = new com/microsoft/appcenter/CancellationException;
      localCancellationException.<init>();
      suspend(false, localCancellationException);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public class GroupState
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
    public final Runnable mRunnable = new Runnable()
    {
      public void run()
      {
        DefaultChannel.GroupState localGroupState = DefaultChannel.GroupState.this;
        mScheduled = false;
        DefaultChannel.access$500(this$0, localGroupState);
      }
    };
    public boolean mScheduled;
    public final Map<String, List<Log>> mSendingBatches = new HashMap();
    
    public GroupState(String paramString, int paramInt1, long paramLong, int paramInt2, Ingestion paramIngestion, Channel.GroupListener paramGroupListener)
    {
      mName = paramString;
      mMaxLogsPerBatch = paramInt1;
      mBatchTimeInterval = paramLong;
      mMaxParallelBatches = paramInt2;
      mIngestion = paramIngestion;
      mListener = paramGroupListener;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.channel.DefaultChannel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */