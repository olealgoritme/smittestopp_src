package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.v.c;

public enum ConfigurationStatus
{
  public int numVal;
  
  static
  {
    ConfigurationStatus localConfigurationStatus = new ConfigurationStatus("APPLIED", 1, 2);
    APPLIED = localConfigurationStatus;
    $VALUES = new ConfigurationStatus[] { TARGETED, localConfigurationStatus };
  }
  
  public ConfigurationStatus(int paramInt)
  {
    numVal = paramInt;
  }
  
  public int getNumVal()
  {
    return numVal;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.ConfigurationStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */