package com.microsoft.azure.storage;

public class DeleteRetentionPolicy
{
  public boolean enabled = false;
  public Integer retentionIntervalInDays;
  
  public boolean getEnabled()
  {
    return enabled;
  }
  
  public Integer getRetentionIntervalInDays()
  {
    return retentionIntervalInDays;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    enabled = paramBoolean;
  }
  
  public void setRetentionIntervalInDays(Integer paramInteger)
  {
    retentionIntervalInDays = paramInteger;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.DeleteRetentionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */