package com.microsoft.identity.common.internal.dto;

import e.c.c.v.c;

public class IdTokenRecord
  extends Credential
{
  @c("authority")
  public String mAuthority;
  @c("realm")
  public String mRealm;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (IdTokenRecord.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (IdTokenRecord)paramObject;
      String str = mRealm;
      if (str != null ? !str.equals(mRealm) : mRealm != null) {
        return false;
      }
      str = mAuthority;
      paramObject = mAuthority;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public String getRealm()
  {
    return mRealm;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    String str = mRealm;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = mAuthority;
    if (str != null) {
      j = str.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public boolean isExpired()
  {
    return false;
  }
  
  public void setAuthority(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void setRealm(String paramString)
  {
    mRealm = paramString;
  }
  
  public static class SerializedNames
    extends Credential.SerializedNames
  {
    public static final String AUTHORITY = "authority";
    public static final String REALM = "realm";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.IdTokenRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */