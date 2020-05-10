package com.microsoft.identity.common.internal.cache;

import e.c.c.v.c;

public abstract class AbstractApplicationMetadata
{
  @c("client_id")
  public String mClientId;
  @c("environment")
  public String mEnvironment;
  @c("application_uid")
  public int mUid;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (AbstractApplicationMetadata)paramObject;
      if (mUid != mUid) {
        return false;
      }
      String str = mClientId;
      if (str != null ? !str.equals(mClientId) : mClientId != null) {
        return false;
      }
      str = mEnvironment;
      paramObject = mEnvironment;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public int getUid()
  {
    return mUid;
  }
  
  public int hashCode()
  {
    String str = mClientId;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = mEnvironment;
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + i) * 31 + mUid;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
  
  public void setUid(int paramInt)
  {
    mUid = paramInt;
  }
  
  public static class SerializedNames
  {
    public static final String APPLICATION_UID = "application_uid";
    public static final String CLIENT_ID = "client_id";
    public static final String ENVIRONMENT = "environment";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.AbstractApplicationMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */