package com.microsoft.azure.storage;

public final class ServiceProperties
{
  public CorsProperties cors;
  public String defaultServiceVersion;
  public DeleteRetentionPolicy deleteRetentionPolicy;
  public MetricsProperties hourMetrics;
  public LoggingProperties logging;
  public MetricsProperties minuteMetrics;
  public StaticWebsiteProperties staticWebsiteProperties;
  
  public ServiceProperties()
  {
    setLogging(new LoggingProperties());
    setHourMetrics(new MetricsProperties());
    setMinuteMetrics(new MetricsProperties());
    setCors(new CorsProperties());
  }
  
  public CorsProperties getCors()
  {
    return cors;
  }
  
  public String getDefaultServiceVersion()
  {
    return defaultServiceVersion;
  }
  
  public DeleteRetentionPolicy getDeleteRetentionPolicy()
  {
    return deleteRetentionPolicy;
  }
  
  public MetricsProperties getHourMetrics()
  {
    return hourMetrics;
  }
  
  public LoggingProperties getLogging()
  {
    return logging;
  }
  
  public MetricsProperties getMinuteMetrics()
  {
    return minuteMetrics;
  }
  
  public StaticWebsiteProperties getStaticWebsiteProperties()
  {
    return staticWebsiteProperties;
  }
  
  public void setCors(CorsProperties paramCorsProperties)
  {
    cors = paramCorsProperties;
  }
  
  public void setDefaultServiceVersion(String paramString)
  {
    defaultServiceVersion = paramString;
  }
  
  public void setDeleteRetentionPolicy(DeleteRetentionPolicy paramDeleteRetentionPolicy)
  {
    deleteRetentionPolicy = paramDeleteRetentionPolicy;
  }
  
  public void setHourMetrics(MetricsProperties paramMetricsProperties)
  {
    hourMetrics = paramMetricsProperties;
  }
  
  public void setLogging(LoggingProperties paramLoggingProperties)
  {
    logging = paramLoggingProperties;
  }
  
  public void setMinuteMetrics(MetricsProperties paramMetricsProperties)
  {
    minuteMetrics = paramMetricsProperties;
  }
  
  public void setStaticWebsiteProperties(StaticWebsiteProperties paramStaticWebsiteProperties)
  {
    staticWebsiteProperties = paramStaticWebsiteProperties;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.ServiceProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */