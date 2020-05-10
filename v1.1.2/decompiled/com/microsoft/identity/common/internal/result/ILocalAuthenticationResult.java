package com.microsoft.identity.common.internal.result;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import java.util.Date;
import java.util.List;

public abstract interface ILocalAuthenticationResult
{
  public abstract String getAccessToken();
  
  public abstract AccessTokenRecord getAccessTokenRecord();
  
  public abstract IAccountRecord getAccountRecord();
  
  public abstract List<ICacheRecord> getCacheRecordWithTenantProfileData();
  
  public abstract Date getExpiresOn();
  
  public abstract String getFamilyId();
  
  public abstract String getIdToken();
  
  public abstract String getRefreshToken();
  
  public abstract String getRefreshTokenAge();
  
  public abstract String[] getScope();
  
  public abstract String getSpeRing();
  
  public abstract String getTenantId();
  
  public abstract String getUniqueId();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.result.ILocalAuthenticationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */