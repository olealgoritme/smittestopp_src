package com.microsoft.identity.common.internal.dto;

import e.c.c.v.c;

public class AccountRecord
  extends AccountCredentialBase
  implements IAccountRecord
{
  @c("alternative_account_id")
  public String mAlternativeAccountId;
  @c("authority_type")
  public String mAuthorityType;
  @c("avatar_url")
  public String mAvatarUrl;
  @c("client_info")
  public String mClientInfo;
  @c("environment")
  public String mEnvironment;
  @c("family_name")
  public String mFamilyName;
  @c("first_name")
  public String mFirstName;
  @c("home_account_id")
  public String mHomeAccountId;
  @c("local_account_id")
  public String mLocalAccountId;
  @c("middle_name")
  public String mMiddleName;
  @c("name")
  public String mName;
  @c("realm")
  public String mRealm;
  @c("username")
  public String mUsername;
  
  public AccountRecord() {}
  
  public AccountRecord(IAccountRecord paramIAccountRecord)
  {
    setHomeAccountId(paramIAccountRecord.getHomeAccountId());
    setEnvironment(paramIAccountRecord.getEnvironment());
    setRealm(paramIAccountRecord.getRealm());
    setLocalAccountId(paramIAccountRecord.getLocalAccountId());
    setUsername(paramIAccountRecord.getUsername());
    setAuthorityType(paramIAccountRecord.getAuthorityType());
    setClientInfo(paramIAccountRecord.getClientInfo());
    setAlternativeAccountId(paramIAccountRecord.getAlternativeAccountId());
    setFirstName(paramIAccountRecord.getFirstName());
    setFamilyName(paramIAccountRecord.getFamilyName());
    setMiddleName(paramIAccountRecord.getMiddleName());
    setName(paramIAccountRecord.getName());
    setAvatarUrl(paramIAccountRecord.getAvatarUrl());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (AccountRecord.class == paramObject.getClass()))
    {
      paramObject = (AccountRecord)paramObject;
      String str = mHomeAccountId;
      if (str != null ? !str.equals(mHomeAccountId) : mHomeAccountId != null) {
        return false;
      }
      str = mEnvironment;
      if (str != null ? !str.equals(mEnvironment) : mEnvironment != null) {
        return false;
      }
      str = mRealm;
      if (str != null ? !str.equals(mRealm) : mRealm != null) {
        return false;
      }
      str = mLocalAccountId;
      if (str != null ? !str.equals(mLocalAccountId) : mLocalAccountId != null) {
        return false;
      }
      str = mUsername;
      if (str != null ? !str.equals(mUsername) : mUsername != null) {
        return false;
      }
      str = mAuthorityType;
      if (str != null ? !str.equals(mAuthorityType) : mAuthorityType != null) {
        return false;
      }
      str = mAlternativeAccountId;
      if (str != null ? !str.equals(mAlternativeAccountId) : mAlternativeAccountId != null) {
        return false;
      }
      str = mFirstName;
      if (str != null ? !str.equals(mFirstName) : mFirstName != null) {
        return false;
      }
      str = mFamilyName;
      if (str != null ? !str.equals(mFamilyName) : mFamilyName != null) {
        return false;
      }
      str = mAvatarUrl;
      paramObject = mAvatarUrl;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAlternativeAccountId()
  {
    return mAlternativeAccountId;
  }
  
  public String getAuthorityType()
  {
    return mAuthorityType;
  }
  
  public String getAvatarUrl()
  {
    return mAvatarUrl;
  }
  
  public String getClientInfo()
  {
    return mClientInfo;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getFamilyName()
  {
    return mFamilyName;
  }
  
  public String getFirstName()
  {
    return mFirstName;
  }
  
  public String getHomeAccountId()
  {
    return mHomeAccountId;
  }
  
  public String getLocalAccountId()
  {
    return mLocalAccountId;
  }
  
  public String getMiddleName()
  {
    return mMiddleName;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getRealm()
  {
    return mRealm;
  }
  
  public String getUsername()
  {
    return mUsername;
  }
  
  public int hashCode()
  {
    String str = mHomeAccountId;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = mEnvironment;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = mRealm;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = mLocalAccountId;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = mUsername;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = mAuthorityType;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = mAlternativeAccountId;
    int i3;
    if (str != null) {
      i3 = str.hashCode();
    } else {
      i3 = 0;
    }
    str = mFirstName;
    int i4;
    if (str != null) {
      i4 = str.hashCode();
    } else {
      i4 = 0;
    }
    str = mFamilyName;
    int i5;
    if (str != null) {
      i5 = str.hashCode();
    } else {
      i5 = 0;
    }
    str = mAvatarUrl;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i;
  }
  
  public void setAlternativeAccountId(String paramString)
  {
    mAlternativeAccountId = paramString;
  }
  
  public void setAuthorityType(String paramString)
  {
    mAuthorityType = paramString;
  }
  
  public void setAvatarUrl(String paramString)
  {
    mAvatarUrl = paramString;
  }
  
  public void setClientInfo(String paramString)
  {
    mClientInfo = paramString;
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
  
  public void setFamilyName(String paramString)
  {
    mFamilyName = paramString;
  }
  
  public void setFirstName(String paramString)
  {
    mFirstName = paramString;
  }
  
  public void setHomeAccountId(String paramString)
  {
    mHomeAccountId = paramString;
  }
  
  public void setLocalAccountId(String paramString)
  {
    mLocalAccountId = paramString;
  }
  
  public void setMiddleName(String paramString)
  {
    mMiddleName = paramString;
  }
  
  public void setName(String paramString)
  {
    mName = paramString;
  }
  
  public void setRealm(String paramString)
  {
    mRealm = paramString;
  }
  
  public void setUsername(String paramString)
  {
    mUsername = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.dto.AccountRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */