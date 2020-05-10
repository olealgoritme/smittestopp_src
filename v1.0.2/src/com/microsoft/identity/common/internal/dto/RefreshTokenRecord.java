package com.microsoft.identity.common.internal.dto;

import e.a.a.a.a;
import e.c.c.v.c;

public class RefreshTokenRecord
  extends Credential
{
  @c("family_id")
  public String mFamilyId;
  @c("target")
  public String mTarget;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (RefreshTokenRecord.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (RefreshTokenRecord)paramObject;
      paramObject = mFamilyId;
      if (paramObject != null ? !((String)paramObject).equals(mFamilyId) : mFamilyId != null) {
        return false;
      }
      paramObject = mTarget;
      localObject = mTarget;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getFamilyId()
  {
    return mFamilyId;
  }
  
  public String getTarget()
  {
    return mTarget;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    String str = mFamilyId;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = mTarget;
    if (str != null) {
      j = str.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public boolean isExpired()
  {
    return false;
  }
  
  public void setFamilyId(String paramString)
  {
    mFamilyId = paramString;
  }
  
  public void setTarget(String paramString)
  {
    mTarget = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("RefreshToken{mFamilyId='");
    a.a(localStringBuilder, mFamilyId, '\'', ", mTarget='");
    a.a(localStringBuilder, mTarget, '\'', "} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.dto.RefreshTokenRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */