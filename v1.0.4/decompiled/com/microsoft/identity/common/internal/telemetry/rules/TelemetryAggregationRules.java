package com.microsoft.identity.common.internal.telemetry.rules;

import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TelemetryAggregationRules
{
  public static TelemetryAggregationRules sInstance;
  public final String[] aggregatedArray = { "Microsoft.MSAL.event_name", "Microsoft.MSAL.occur_time", "Microsoft.MSAL.event_type", "_is_successful" };
  public Set<String> aggregatedPropertiesSet = new HashSet(Arrays.asList(aggregatedArray));
  
  public static TelemetryAggregationRules getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localTelemetryAggregationRules = new com/microsoft/identity/common/internal/telemetry/rules/TelemetryAggregationRules;
        localTelemetryAggregationRules.<init>();
        sInstance = localTelemetryAggregationRules;
      }
      TelemetryAggregationRules localTelemetryAggregationRules = sInstance;
      return localTelemetryAggregationRules;
    }
    finally {}
  }
  
  public boolean isRedundant(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    return aggregatedPropertiesSet.contains(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.rules.TelemetryAggregationRules
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */