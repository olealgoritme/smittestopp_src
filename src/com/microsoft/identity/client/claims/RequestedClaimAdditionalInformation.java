package com.microsoft.identity.client.claims;

import e.c.c.v.c;
import java.util.ArrayList;
import java.util.List;

public class RequestedClaimAdditionalInformation
{
  @c("essential")
  public Boolean mEssential = Boolean.valueOf(false);
  @c("value")
  public Object mValue = null;
  @c("values")
  public List<Object> mValues = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof RequestedClaimAdditionalInformation)) {
      return false;
    }
    paramObject = (RequestedClaimAdditionalInformation)paramObject;
    Object localObject = mEssential;
    if (localObject != null ? !((Boolean)localObject).equals(mEssential) : mEssential != null) {
      return false;
    }
    localObject = mValues;
    if (localObject != null ? !((List)localObject).equals(mValues) : mValues != null) {
      return false;
    }
    localObject = mValue;
    paramObject = mValue;
    if (localObject != null) {
      bool = localObject.equals(paramObject);
    } else if (paramObject != null) {
      bool = false;
    }
    return bool;
  }
  
  public Boolean getEssential()
  {
    return mEssential;
  }
  
  public Object getValue()
  {
    return mValue;
  }
  
  public List<Object> getValues()
  {
    return mValues;
  }
  
  public int hashCode()
  {
    Object localObject = mEssential;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((Boolean)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = mValues;
    int k;
    if (localObject != null) {
      k = ((List)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = mValue;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public void setEssential(Boolean paramBoolean)
  {
    mEssential = paramBoolean;
  }
  
  public void setValue(Object paramObject)
  {
    mValue = paramObject;
  }
  
  public void setValues(List<Object> paramList)
  {
    mValues = paramList;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.RequestedClaimAdditionalInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */