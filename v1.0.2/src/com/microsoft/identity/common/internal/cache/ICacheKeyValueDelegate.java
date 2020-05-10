package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccountCredentialBase;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;

public abstract interface ICacheKeyValueDelegate
{
  public abstract <T extends AccountCredentialBase> T fromCacheValue(String paramString, Class<? extends AccountCredentialBase> paramClass);
  
  public abstract String generateCacheKey(AccountRecord paramAccountRecord);
  
  public abstract String generateCacheKey(Credential paramCredential);
  
  public abstract String generateCacheValue(AccountRecord paramAccountRecord);
  
  public abstract String generateCacheValue(Credential paramCredential);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.ICacheKeyValueDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */