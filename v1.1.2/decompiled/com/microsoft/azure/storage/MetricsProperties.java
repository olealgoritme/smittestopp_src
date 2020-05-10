package com.microsoft.azure.storage;

public final class MetricsProperties
{
  public MetricsLevel metricsLevel = MetricsLevel.DISABLED;
  public Integer retentionIntervalInDays;
  public String version = "1.0";
  
  public MetricsLevel getMetricsLevel()
  {
    return metricsLevel;
  }
  
  public Integer getRetentionIntervalInDays()
  {
    return retentionIntervalInDays;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public void setMetricsLevel(MetricsLevel paramMetricsLevel)
  {
    metricsLevel = paramMetricsLevel;
  }
  
  public void setRetentionIntervalInDays(Integer paramInteger)
  {
    retentionIntervalInDays = paramInteger;
  }
  
  public void setVersion(String paramString)
  {
    version = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.MetricsProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */