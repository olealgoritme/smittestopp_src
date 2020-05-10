package com.microsoft.identity.common.internal.telemetry;

import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.telemetry.adapter.TelemetryAggregationAdapter;
import com.microsoft.identity.common.internal.telemetry.adapter.TelemetryDefaultAdapter;
import com.microsoft.identity.common.internal.telemetry.events.BaseEvent;
import com.microsoft.identity.common.internal.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.internal.telemetry.observers.ITelemetryDefaultObserver;
import com.microsoft.identity.common.internal.telemetry.observers.ITelemetryObserver;
import com.microsoft.identity.common.internal.telemetry.rules.TelemetryPiiOiiRules;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Telemetry
{
  public static final String TAG = "Telemetry";
  public static Queue<ITelemetryObserver> mObservers;
  public static volatile Telemetry sTelemetryInstance;
  public TelemetryConfiguration mDefaultConfiguration;
  public boolean mIsDebugging;
  public final boolean mIsTelemetryEnabled;
  public TelemetryContext mTelemetryContext;
  public Queue<Map<String, String>> mTelemetryRawDataMap;
  
  public Telemetry(Telemetry.Builder paramBuilder)
  {
    if ((paramBuilder != null) && (Telemetry.Builder.access$000(paramBuilder) != null) && (Telemetry.Builder.access$100(paramBuilder) != null))
    {
      mIsTelemetryEnabled = true;
      mDefaultConfiguration = Telemetry.Builder.access$100(paramBuilder);
      mTelemetryContext = Telemetry.Builder.access$000(paramBuilder);
      mIsDebugging = Telemetry.Builder.access$200(paramBuilder).booleanValue();
      mTelemetryRawDataMap = new ConcurrentLinkedQueue();
    }
    else
    {
      Logger.warn(TAG, "Telemetry is disabled because the Telemetry context or configuration is null");
      mIsTelemetryEnabled = false;
    }
  }
  
  private Map<String, String> applyPiiOiiRule(Map<String, String> paramMap)
  {
    if (mDefaultConfiguration.isPiiEnabled())
    {
      Logger.warn(TAG, "Telemetry PII/OII is enabled by the developer.");
      return paramMap;
    }
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!TelemetryPiiOiiRules.getInstance().isPiiOrOii((String)localEntry.getKey())) {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  public static void emit(BaseEvent paramBaseEvent)
  {
    if (getInstancemIsTelemetryEnabled) {
      getInstance().getRequestMap().add(paramBaseEvent.getProperties());
    }
  }
  
  public static Telemetry getInstance()
  {
    try
    {
      if (sTelemetryInstance == null)
      {
        localObject1 = new com/microsoft/identity/common/internal/telemetry/Telemetry$Builder;
        ((Telemetry.Builder)localObject1).<init>();
        ((Telemetry.Builder)localObject1).build();
      }
      Object localObject1 = sTelemetryInstance;
      return (Telemetry)localObject1;
    }
    finally {}
  }
  
  private Queue<Map<String, String>> getRequestMap()
  {
    return mTelemetryRawDataMap;
  }
  
  public static Telemetry prepareInstance(Telemetry.Builder paramBuilder)
  {
    try
    {
      Telemetry localTelemetry = new com/microsoft/identity/common/internal/telemetry/Telemetry;
      localTelemetry.<init>(paramBuilder);
      sTelemetryInstance = localTelemetry;
      paramBuilder = sTelemetryInstance;
      return paramBuilder;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  public void addObserver(ITelemetryObserver paramITelemetryObserver)
  {
    if (paramITelemetryObserver != null)
    {
      if (mObservers == null) {
        mObservers = new ConcurrentLinkedQueue();
      }
      mObservers.add(paramITelemetryObserver);
      return;
    }
    throw new IllegalArgumentException("Telemetry Observer instance cannot be null");
  }
  
  public void flush()
  {
    if (getInstancemIsTelemetryEnabled) {
      flush((String)DiagnosticContext.getRequestContext().get("correlation_id"));
    }
  }
  
  public void flush(String paramString)
  {
    if (!mIsTelemetryEnabled) {
      return;
    }
    if (mObservers == null)
    {
      Logger.warn(TAG, "No telemetry observer set.");
      return;
    }
    if (StringUtil.isEmpty(paramString))
    {
      Logger.warn(TAG, "No correlation id set.");
      return;
    }
    if ((!mDefaultConfiguration.isDebugEnabled()) && (mIsDebugging)) {
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    Iterator localIterator = mTelemetryRawDataMap.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Map)localIterator.next();
      if (paramString.equalsIgnoreCase((String)((Map)localObject).get("Microsoft.MSAL.correlation_id")))
      {
        localCopyOnWriteArrayList.add(applyPiiOiiRule((Map)localObject));
        localIterator.remove();
      }
    }
    localCopyOnWriteArrayList.add(applyPiiOiiRule(mTelemetryContext.getProperties()));
    localIterator = mObservers.iterator();
    while (localIterator.hasNext())
    {
      ITelemetryObserver localITelemetryObserver = (ITelemetryObserver)localIterator.next();
      if ((localITelemetryObserver instanceof ITelemetryAggregatedObserver))
      {
        new TelemetryAggregationAdapter((ITelemetryAggregatedObserver)localITelemetryObserver).process(localCopyOnWriteArrayList);
      }
      else if ((localITelemetryObserver instanceof ITelemetryDefaultObserver))
      {
        new TelemetryDefaultAdapter((ITelemetryDefaultObserver)localITelemetryObserver).process(localCopyOnWriteArrayList);
      }
      else
      {
        localObject = TAG;
        paramString = a.a("Unknown observer type: ");
        paramString.append(localITelemetryObserver.getClass());
        Logger.warn((String)localObject, paramString.toString());
      }
    }
  }
  
  public List<ITelemetryObserver> getObservers()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList;
    if (mObservers != null) {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList(mObservers);
    } else {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    }
    return Collections.unmodifiableList(localCopyOnWriteArrayList);
  }
  
  public void removeAllObservers()
  {
    Queue localQueue = mObservers;
    if (localQueue == null) {
      return;
    }
    localQueue.clear();
  }
  
  public void removeObserver(ITelemetryObserver paramITelemetryObserver)
  {
    if (paramITelemetryObserver != null)
    {
      Queue localQueue = mObservers;
      if (localQueue != null)
      {
        localQueue.remove(paramITelemetryObserver);
        return;
      }
    }
    Logger.warn(TAG, "Unable to remove the observer. Either the observer is null or the observer list is empty.");
  }
  
  public void removeObserver(Class<?> paramClass)
  {
    if (paramClass != null)
    {
      Object localObject = mObservers;
      if (localObject != null)
      {
        localObject = ((Queue)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((ITelemetryObserver)((Iterator)localObject).next()).getClass() == paramClass)
          {
            String str = TAG;
            StringBuilder localStringBuilder = a.a("The [");
            localStringBuilder.append(paramClass.getSimpleName());
            localStringBuilder.append("] observer is removed.");
            Logger.verbose(str, localStringBuilder.toString());
            ((Iterator)localObject).remove();
          }
        }
        return;
      }
    }
    Logger.warn(TAG, "Unable to remove the observe. Either the observer is null or the observer list is empty.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.Telemetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */