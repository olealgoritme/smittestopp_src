package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.OneCollectorIngestion;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.Extensions;
import com.microsoft.appcenter.ingestion.models.one.SdkExtension;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class OneCollectorChannelListener
  extends AbstractChannelListener
{
  public static final String ONE_COLLECTOR_GROUP_NAME_SUFFIX = "/one";
  public static final int ONE_COLLECTOR_TRIGGER_COUNT = 50;
  public static final int ONE_COLLECTOR_TRIGGER_MAX_PARALLEL_REQUESTS = 2;
  public final Channel mChannel;
  public final Map<String, EpochAndSeq> mEpochsAndSeqsByIKey = new HashMap();
  public final Ingestion mIngestion;
  public final UUID mInstallId;
  public final LogSerializer mLogSerializer;
  
  public OneCollectorChannelListener(Channel paramChannel, LogSerializer paramLogSerializer, HttpClient paramHttpClient, UUID paramUUID)
  {
    this(new OneCollectorIngestion(paramHttpClient, paramLogSerializer), paramChannel, paramLogSerializer, paramUUID);
  }
  
  public OneCollectorChannelListener(OneCollectorIngestion paramOneCollectorIngestion, Channel paramChannel, LogSerializer paramLogSerializer, UUID paramUUID)
  {
    mChannel = paramChannel;
    mLogSerializer = paramLogSerializer;
    mInstallId = paramUUID;
    mIngestion = paramOneCollectorIngestion;
  }
  
  public static String getOneCollectorGroupName(String paramString)
  {
    return a.b(paramString, "/one");
  }
  
  public static boolean isOneCollectorCompatible(Log paramLog)
  {
    boolean bool;
    if ((!(paramLog instanceof CommonSchemaLog)) && (!paramLog.getTransmissionTargetTokens().isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isOneCollectorGroup(String paramString)
  {
    return paramString.endsWith("/one");
  }
  
  public void onClear(String paramString)
  {
    if (isOneCollectorGroup(paramString)) {
      return;
    }
    mChannel.clear(getOneCollectorGroupName(paramString));
  }
  
  public void onGloballyEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {
      mEpochsAndSeqsByIKey.clear();
    }
  }
  
  public void onGroupAdded(String paramString, Channel.GroupListener paramGroupListener, long paramLong)
  {
    if (isOneCollectorGroup(paramString)) {
      return;
    }
    paramString = getOneCollectorGroupName(paramString);
    mChannel.addGroup(paramString, 50, paramLong, 2, mIngestion, paramGroupListener);
  }
  
  public void onGroupRemoved(String paramString)
  {
    if (isOneCollectorGroup(paramString)) {
      return;
    }
    paramString = getOneCollectorGroupName(paramString);
    mChannel.removeGroup(paramString);
  }
  
  public void onPaused(String paramString1, String paramString2)
  {
    if (isOneCollectorGroup(paramString1)) {
      return;
    }
    mChannel.pauseGroup(getOneCollectorGroupName(paramString1), paramString2);
  }
  
  public void onPreparedLog(Log paramLog, String paramString, int paramInt)
  {
    if (!isOneCollectorCompatible(paramLog)) {
      return;
    }
    try
    {
      Collection localCollection = mLogSerializer.toCommonSchemaLog(paramLog);
      Iterator localIterator = localCollection.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        CommonSchemaLog localCommonSchemaLog = (CommonSchemaLog)localIterator.next();
        localCommonSchemaLog.setFlags(Long.valueOf(paramInt));
        localObject = (EpochAndSeq)mEpochsAndSeqsByIKey.get(localCommonSchemaLog.getIKey());
        paramLog = (Log)localObject;
        if (localObject == null)
        {
          paramLog = new EpochAndSeq(UUID.randomUUID().toString());
          mEpochsAndSeqsByIKey.put(localCommonSchemaLog.getIKey(), paramLog);
        }
        localObject = localCommonSchemaLog.getExt().getSdk();
        ((SdkExtension)localObject).setEpoch(epoch);
        long l = seq + 1L;
        seq = l;
        ((SdkExtension)localObject).setSeq(Long.valueOf(l));
        ((SdkExtension)localObject).setInstallId(mInstallId);
      }
      paramLog = getOneCollectorGroupName(paramString);
      paramString = localCollection.iterator();
      while (paramString.hasNext())
      {
        localObject = (CommonSchemaLog)paramString.next();
        mChannel.enqueue((Log)localObject, paramLog, paramInt);
      }
      return;
    }
    catch (IllegalArgumentException paramLog)
    {
      paramString = a.a("Cannot send a log to one collector: ");
      paramString.append(paramLog.getMessage());
      AppCenterLog.error("AppCenter", paramString.toString());
    }
  }
  
  public void onResumed(String paramString1, String paramString2)
  {
    if (isOneCollectorGroup(paramString1)) {
      return;
    }
    mChannel.resumeGroup(getOneCollectorGroupName(paramString1), paramString2);
  }
  
  public void setLogUrl(String paramString)
  {
    mIngestion.setLogUrl(paramString);
  }
  
  public boolean shouldFilter(Log paramLog)
  {
    return isOneCollectorCompatible(paramLog);
  }
  
  public static class EpochAndSeq
  {
    public final String epoch;
    public long seq;
    
    public EpochAndSeq(String paramString)
    {
      epoch = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.channel.OneCollectorChannelListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */