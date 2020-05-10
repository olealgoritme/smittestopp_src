package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;

public abstract interface ICacheRecord
{
  public abstract AccessTokenRecord getAccessToken();
  
  public abstract AccountRecord getAccount();
  
  public abstract IdTokenRecord getIdToken();
  
  public abstract RefreshTokenRecord getRefreshToken();
  
  public abstract IdTokenRecord getV1IdToken();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.ICacheRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */