package com.microsoft.identity.common.internal.dto;

import e.c.c.v.c;

public abstract class Credential
  extends AccountCredentialBase
{
  @c("cached_at")
  public String mCachedAt;
  @c("client_id")
  public String mClientId;
  @c("credential_type")
  public String mCredentialType;
  @c("environment")
  public String mEnvironment;
  @c("home_account_id")
  public String mHomeAccountId;
  @c("secret")
  public String mSecret;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (Credential)paramObject;
      String str = mClientId;
      if (str != null ? !str.equals(mClientId) : mClientId != null) {
        return false;
      }
      str = mCredentialType;
      if (str != null ? !str.equals(mCredentialType) : mCredentialType != null) {
        return false;
      }
      str = mEnvironment;
      if (str != null ? !str.equals(mEnvironment) : mEnvironment != null) {
        return false;
      }
      str = mSecret;
      if (str != null ? !str.equals(mSecret) : mSecret != null) {
        return false;
      }
      str = mHomeAccountId;
      if (str != null ? !str.equals(mHomeAccountId) : mHomeAccountId != null) {
        return false;
      }
      str = mCachedAt;
      paramObject = mCachedAt;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getCachedAt()
  {
    return mCachedAt;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getCredentialType()
  {
    return mCredentialType;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getHomeAccountId()
  {
    return mHomeAccountId;
  }
  
  public String getSecret()
  {
    return mSecret;
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
    str = mCredentialType;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = mEnvironment;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = mSecret;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = mHomeAccountId;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = mCachedAt;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public abstract boolean isExpired();
  
  public void setCachedAt(String paramString)
  {
    mCachedAt = paramString;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setCredentialType(String paramString)
  {
    mCredentialType = paramString;
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
  
  public void setHomeAccountId(String paramString)
  {
    mHomeAccountId = paramString;
  }
  
  public void setSecret(String paramString)
  {
    mSecret = paramString;
  }
  
  public static class SerializedNames
  {
    public static final String CACHED_AT = "cached_at";
    public static final String CLIENT_ID = "client_id";
    public static final String CREDENTIAL_TYPE = "credential_type";
    public static final String ENVIRONMENT = "environment";
    public static final String EXPIRES_ON = "expires_on";
    public static final String HOME_ACCOUNT_ID = "home_account_id";
    public static final String SECRET = "secret";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.Credential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */