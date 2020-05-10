package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;

public class CacheRecord
  implements ICacheRecord
{
  public AccessTokenRecord mAccessToken;
  public AccountRecord mAccount;
  public IdTokenRecord mIdToken;
  public RefreshTokenRecord mRefreshToken;
  public IdTokenRecord mV1IdToken;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (CacheRecord.class == paramObject.getClass()))
    {
      paramObject = (CacheRecord)paramObject;
      Object localObject = mAccount;
      if (localObject != null ? !((AccountRecord)localObject).equals(mAccount) : mAccount != null) {
        return false;
      }
      localObject = mAccessToken;
      if (localObject != null ? !((Credential)localObject).equals(mAccessToken) : mAccessToken != null) {
        return false;
      }
      localObject = mRefreshToken;
      if (localObject != null ? !((RefreshTokenRecord)localObject).equals(mRefreshToken) : mRefreshToken != null) {
        return false;
      }
      localObject = mIdToken;
      paramObject = mIdToken;
      if (localObject != null) {
        bool = ((IdTokenRecord)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public AccessTokenRecord getAccessToken()
  {
    return mAccessToken;
  }
  
  public AccountRecord getAccount()
  {
    return mAccount;
  }
  
  public IdTokenRecord getIdToken()
  {
    return mIdToken;
  }
  
  public RefreshTokenRecord getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public IdTokenRecord getV1IdToken()
  {
    return mV1IdToken;
  }
  
  public int hashCode()
  {
    Object localObject = mAccount;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((AccountRecord)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = mAccessToken;
    int k;
    if (localObject != null) {
      k = ((Credential)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = mRefreshToken;
    int m;
    if (localObject != null) {
      m = ((RefreshTokenRecord)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = mIdToken;
    if (localObject != null) {
      i = ((IdTokenRecord)localObject).hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public void setAccessToken(AccessTokenRecord paramAccessTokenRecord)
  {
    mAccessToken = paramAccessTokenRecord;
  }
  
  public void setAccount(AccountRecord paramAccountRecord)
  {
    mAccount = paramAccountRecord;
  }
  
  public void setIdToken(IdTokenRecord paramIdTokenRecord)
  {
    mIdToken = paramIdTokenRecord;
  }
  
  public void setRefreshToken(RefreshTokenRecord paramRefreshTokenRecord)
  {
    mRefreshToken = paramRefreshTokenRecord;
  }
  
  public void setV1IdToken(IdTokenRecord paramIdTokenRecord)
  {
    mV1IdToken = paramIdTokenRecord;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.CacheRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */