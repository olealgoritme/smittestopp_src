package com.microsoft.azure.storage;

import java.util.Date;

public abstract class SharedAccessPolicy
{
  public Date sharedAccessExpiryTime;
  public Date sharedAccessStartTime;
  
  public Date getSharedAccessExpiryTime()
  {
    return sharedAccessExpiryTime;
  }
  
  public Date getSharedAccessStartTime()
  {
    return sharedAccessStartTime;
  }
  
  public abstract String permissionsToString();
  
  public abstract void setPermissionsFromString(String paramString);
  
  public void setSharedAccessExpiryTime(Date paramDate)
  {
    sharedAccessExpiryTime = paramDate;
  }
  
  public void setSharedAccessStartTime(Date paramDate)
  {
    sharedAccessStartTime = paramDate;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */