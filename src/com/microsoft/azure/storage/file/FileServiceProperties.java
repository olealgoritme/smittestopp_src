package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.CorsProperties;
import com.microsoft.azure.storage.MetricsProperties;
import com.microsoft.azure.storage.ServiceProperties;

public class FileServiceProperties
{
  public ServiceProperties serviceProperties;
  
  public FileServiceProperties()
  {
    this(new ServiceProperties());
  }
  
  public FileServiceProperties(ServiceProperties paramServiceProperties)
  {
    serviceProperties = paramServiceProperties;
    paramServiceProperties.setLogging(null);
    serviceProperties.setDefaultServiceVersion(null);
  }
  
  public CorsProperties getCors()
  {
    return serviceProperties.getCors();
  }
  
  public MetricsProperties getHourMetrics()
  {
    return serviceProperties.getHourMetrics();
  }
  
  public MetricsProperties getMinuteMetrics()
  {
    return serviceProperties.getMinuteMetrics();
  }
  
  public ServiceProperties getServiceProperties()
  {
    return serviceProperties;
  }
  
  public void setCors(CorsProperties paramCorsProperties)
  {
    serviceProperties.setCors(paramCorsProperties);
  }
  
  public void setHourMetrics(MetricsProperties paramMetricsProperties)
  {
    serviceProperties.setHourMetrics(paramMetricsProperties);
  }
  
  public void setMinuteMetrics(MetricsProperties paramMetricsProperties)
  {
    serviceProperties.setMinuteMetrics(paramMetricsProperties);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileServiceProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */