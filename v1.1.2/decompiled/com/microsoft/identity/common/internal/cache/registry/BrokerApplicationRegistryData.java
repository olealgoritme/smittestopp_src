package com.microsoft.identity.common.internal.cache.registry;

import com.microsoft.identity.common.internal.cache.AbstractApplicationMetadata;
import com.microsoft.identity.common.internal.cache.AbstractApplicationMetadata.SerializedNames;
import e.c.c.v.c;

public class BrokerApplicationRegistryData
  extends AbstractApplicationMetadata
{
  @c("wpj_account_access_allowed")
  public boolean mWpjAccountAccessAllowed;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (BrokerApplicationRegistryData.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (BrokerApplicationRegistryData)paramObject;
      if (mWpjAccountAccessAllowed != mWpjAccountAccessAllowed) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode() * 31 + mWpjAccountAccessAllowed;
  }
  
  public boolean isWpjAccountAccessAllowed()
  {
    return mWpjAccountAccessAllowed;
  }
  
  public void setWpjAccountAccessAllowed(boolean paramBoolean)
  {
    mWpjAccountAccessAllowed = paramBoolean;
  }
  
  public static final class SerializedNames
    extends AbstractApplicationMetadata.SerializedNames
  {
    public static final String ALLOW_WPJ_ACCESS = "wpj_account_access_allowed";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.registry.BrokerApplicationRegistryData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */