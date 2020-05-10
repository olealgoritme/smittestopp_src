package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import e.a.a.a.a;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class AuthenticationResult
  implements IAuthenticationResult
{
  public final AccessTokenRecord mAccessToken;
  public final IAccount mAccount;
  public final String mTenantId;
  
  public AuthenticationResult(List<ICacheRecord> paramList)
  {
    ICacheRecord localICacheRecord = (ICacheRecord)paramList.get(0);
    mAccessToken = localICacheRecord.getAccessToken();
    mTenantId = localICacheRecord.getAccount().getRealm();
    mAccount = ((IAccount)AccountAdapter.adapt(paramList).get(0));
  }
  
  public String getAccessToken()
  {
    return mAccessToken.getSecret();
  }
  
  public IAccount getAccount()
  {
    return mAccount;
  }
  
  public String getAuthenticationScheme()
  {
    return mAccessToken.getAccessTokenType();
  }
  
  public String getAuthorizationHeader()
  {
    StringBuilder localStringBuilder = a.a(mAccessToken.getAccessTokenType(), " ");
    localStringBuilder.append(mAccessToken.getSecret());
    return localStringBuilder.toString();
  }
  
  public Date getExpiresOn()
  {
    return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(mAccessToken.getExpiresOn())));
  }
  
  public String[] getScope()
  {
    return mAccessToken.getTarget().split("\\s");
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AuthenticationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */