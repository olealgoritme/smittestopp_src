package com.microsoft.azure.storage;

public enum MetricsLevel
{
  static
  {
    MetricsLevel localMetricsLevel = new MetricsLevel("SERVICE_AND_API", 2);
    SERVICE_AND_API = localMetricsLevel;
    $VALUES = new MetricsLevel[] { DISABLED, SERVICE, localMetricsLevel };
  }
  
  public MetricsLevel() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.MetricsLevel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */