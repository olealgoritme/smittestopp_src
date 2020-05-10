package com.microsoft.identity.common.internal.telemetry.adapter;

import com.microsoft.identity.common.internal.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.internal.telemetry.rules.TelemetryAggregationRules;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class TelemetryAggregationAdapter
  implements ITelemetryAdapter<List<Map<String, String>>>
{
  public final String END = "end";
  public final String START = "start";
  public ITelemetryAggregatedObserver mObserver;
  
  public TelemetryAggregationAdapter(ITelemetryAggregatedObserver paramITelemetryAggregatedObserver)
  {
    mObserver = paramITelemetryAggregatedObserver;
  }
  
  private Map<String, String> applyAggregationRule(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if ((!StringUtil.isEmpty((String)localEntry.getValue())) && (!TelemetryAggregationRules.getInstance().isRedundant((String)localEntry.getKey()))) {
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  private void calculateEventResponseTime(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    Iterator localIterator = paramMap1.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      if (str1.contains("start"))
      {
        String str2 = (String)paramMap1.get(str1.replace("start", "end"));
        if (str2 != null)
        {
          str1 = str1.replace("start", "response");
          long l = Long.parseLong((String)localEntry.getValue());
          paramMap2.put(str1, String.valueOf(Long.parseLong(str2) - l));
        }
      }
    }
  }
  
  private void trackEventResponseTime(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    String str1 = (String)paramMap2.get("Microsoft.MSAL.event_name");
    String str2 = (String)paramMap2.get("Microsoft.MSAL.event_type");
    if ((str1 != null) && (str1.contains("start"))) {
      paramMap1.put(a.b(str2, "_start_time"), paramMap2.get("Microsoft.MSAL.occur_time"));
    }
    if ((str1 != null) && (str1.contains("end"))) {
      paramMap1.put(a.b(str2, "_end_time"), paramMap2.get("Microsoft.MSAL.occur_time"));
    }
  }
  
  public ITelemetryAggregatedObserver getObserver()
  {
    return mObserver;
  }
  
  public void process(List<Map<String, String>> paramList)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      paramList = (String)localMap.get("Microsoft.MSAL.event_name");
      String str1 = (String)localMap.get("Microsoft.MSAL.event_type");
      if (StringUtil.isEmpty(paramList))
      {
        localHashMap1.putAll(applyAggregationRule(localMap));
      }
      else
      {
        if (paramList.contains("start"))
        {
          String str2 = a.b(str1, "_count");
          String str3 = (String)localHashMap1.get(str2);
          paramList = str3;
          if (str3 == null) {
            paramList = "0";
          }
          localHashMap1.put(str2, String.valueOf(Integer.parseInt(paramList) + 1));
        }
        if (!StringUtil.isEmpty((String)localMap.get("_is_successful"))) {
          localHashMap1.put(a.b(str1, "_is_successful"), localMap.get("_is_successful"));
        }
        trackEventResponseTime(localHashMap2, localMap);
        localHashMap1.putAll(applyAggregationRule(localMap));
      }
    }
    calculateEventResponseTime(localHashMap2, localHashMap1);
    mObserver.onReceived(localHashMap1);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.adapter.TelemetryAggregationAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */