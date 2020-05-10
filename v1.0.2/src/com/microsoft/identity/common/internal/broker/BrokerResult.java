package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import e.c.c.v.c;
import java.io.Serializable;
import java.util.List;

public class BrokerResult
  implements Serializable
{
  public static final long serialVersionUID = 8606631820514878489L;
  @c("access_token")
  public String mAccessToken;
  @c("authority")
  public String mAuthority;
  @c("cached_at")
  public long mCachedAt;
  @c("cli_telem_error_code")
  public String mCliTelemErrorCode;
  @c("cli_telem_suberror_code")
  public String mCliTelemSubErrorCode;
  @c("client_id")
  public String mClientId;
  @c("client_info")
  public String mClientInfo;
  @c("correlation_id")
  public String mCorrelationId;
  @c("environment")
  public String mEnvironment;
  @c("broker_error_code")
  public String mErrorCode;
  @c("broker_error_message")
  public String mErrorMessage;
  @c("broker_exception_type")
  public final String mExceptionType;
  @c("expires_on")
  public long mExpiresOn;
  @c("ext_expires_on")
  public long mExtendedExpiresOn;
  @c("family_id")
  public String mFamilyId;
  @c("home_account_id")
  public String mHomeAccountId;
  @c("http_response_body")
  public String mHttpResponseBody;
  @c("http_response_headers")
  public String mHttpResponseHeaders;
  @c("http_response_code")
  public int mHttpStatusCode;
  @c("id_token")
  public String mIdToken;
  @c("local_account_id")
  public String mLocalAccountId;
  @c("refresh_token")
  public String mRefreshToken;
  @c("refresh_token_age")
  public String mRefreshTokenAge;
  @c("scopes")
  public String mScope;
  @c("spe_ring")
  public String mSpeRing;
  @c("oauth_sub_error")
  public String mSubErrorCode;
  @c("success")
  public boolean mSuccess;
  @c("tenant_id")
  public String mTenantId;
  @c("tenant_profile_cache_records")
  public final List<ICacheRecord> mTenantProfileData;
  @c("token_type")
  public String mTokenType;
  @c("username")
  public String mUserName;
  
  public BrokerResult(BrokerResult.Builder paramBuilder)
  {
    mAccessToken = BrokerResult.Builder.access$000(paramBuilder);
    mIdToken = BrokerResult.Builder.access$100(paramBuilder);
    mRefreshToken = BrokerResult.Builder.access$200(paramBuilder);
    mHomeAccountId = BrokerResult.Builder.access$300(paramBuilder);
    mLocalAccountId = BrokerResult.Builder.access$400(paramBuilder);
    mUserName = BrokerResult.Builder.access$500(paramBuilder);
    mTokenType = BrokerResult.Builder.access$600(paramBuilder);
    mClientId = BrokerResult.Builder.access$700(paramBuilder);
    mFamilyId = BrokerResult.Builder.access$800(paramBuilder);
    mScope = BrokerResult.Builder.access$900(paramBuilder);
    mClientInfo = BrokerResult.Builder.access$1000(paramBuilder);
    mAuthority = BrokerResult.Builder.access$1100(paramBuilder);
    mEnvironment = BrokerResult.Builder.access$1200(paramBuilder);
    mTenantId = BrokerResult.Builder.access$1300(paramBuilder);
    mExpiresOn = BrokerResult.Builder.access$1400(paramBuilder);
    mExtendedExpiresOn = BrokerResult.Builder.access$1500(paramBuilder);
    mCachedAt = BrokerResult.Builder.access$1600(paramBuilder);
    mSpeRing = BrokerResult.Builder.access$1700(paramBuilder);
    mRefreshTokenAge = BrokerResult.Builder.access$1800(paramBuilder);
    mSuccess = BrokerResult.Builder.access$1900(paramBuilder);
    mTenantProfileData = BrokerResult.Builder.access$2000(paramBuilder);
    mErrorCode = BrokerResult.Builder.access$2100(paramBuilder);
    mErrorMessage = BrokerResult.Builder.access$2200(paramBuilder);
    mCorrelationId = BrokerResult.Builder.access$2300(paramBuilder);
    mSubErrorCode = BrokerResult.Builder.access$2400(paramBuilder);
    mHttpStatusCode = BrokerResult.Builder.access$2500(paramBuilder);
    mHttpResponseBody = BrokerResult.Builder.access$2600(paramBuilder);
    mHttpResponseHeaders = BrokerResult.Builder.access$2700(paramBuilder);
    mCliTelemErrorCode = BrokerResult.Builder.access$2800(paramBuilder);
    mCliTelemSubErrorCode = BrokerResult.Builder.access$2900(paramBuilder);
    mExceptionType = BrokerResult.Builder.access$3000(paramBuilder);
  }
  
  public String getAccessToken()
  {
    return mAccessToken;
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public long getCachedAt()
  {
    return mCachedAt;
  }
  
  public String getCliTelemErrorCode()
  {
    return mCliTelemErrorCode;
  }
  
  public String getCliTelemSubErrorCode()
  {
    return mCliTelemSubErrorCode;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getClientInfo()
  {
    return mClientInfo;
  }
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getErrorCode()
  {
    return mErrorCode;
  }
  
  public String getErrorMessage()
  {
    return mErrorMessage;
  }
  
  public String getExceptionType()
  {
    return mExceptionType;
  }
  
  public long getExpiresOn()
  {
    return mExpiresOn;
  }
  
  public long getExtendedExpiresOn()
  {
    return mExtendedExpiresOn;
  }
  
  public String getFamilyId()
  {
    return mFamilyId;
  }
  
  public String getHomeAccountId()
  {
    return mHomeAccountId;
  }
  
  public String getHttpResponseBody()
  {
    return mHttpResponseBody;
  }
  
  public String getHttpResponseHeaders()
  {
    return mHttpResponseHeaders;
  }
  
  public int getHttpStatusCode()
  {
    return mHttpStatusCode;
  }
  
  public String getIdToken()
  {
    return mIdToken;
  }
  
  public String getLocalAccountId()
  {
    return mLocalAccountId;
  }
  
  public String getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public String getRefreshTokenAge()
  {
    return mRefreshTokenAge;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public String getSubErrorCode()
  {
    return mSubErrorCode;
  }
  
  public String getTenantId()
  {
    return mTenantId;
  }
  
  public List<ICacheRecord> getTenantProfileData()
  {
    return mTenantProfileData;
  }
  
  public String getTokenType()
  {
    return mTokenType;
  }
  
  public String getUserName()
  {
    return mUserName;
  }
  
  public boolean isSuccess()
  {
    return mSuccess;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */