package com.microsoft.identity.common.internal.cache;

import e.c.c.v.c;

public class BrokerApplicationMetadata
  extends AbstractApplicationMetadata
{
  @c("family_id")
  public String mFoci;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (BrokerApplicationMetadata.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (BrokerApplicationMetadata)paramObject;
      paramObject = mFoci;
      localObject = mFoci;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getFoci()
  {
    return mFoci;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    String str = mFoci;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void setFoci(String paramString)
  {
    mFoci = paramString;
  }
  
  public static final class SerializedNames
    extends AbstractApplicationMetadata.SerializedNames
  {
    public static final String FAMILY_ID = "family_id";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.BrokerApplicationMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */