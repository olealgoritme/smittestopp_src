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
  
  public BrokerResult(Builder paramBuilder)
  {
    mAccessToken = Builder.access$000(paramBuilder);
    mIdToken = Builder.access$100(paramBuilder);
    mRefreshToken = Builder.access$200(paramBuilder);
    mHomeAccountId = Builder.access$300(paramBuilder);
    mLocalAccountId = Builder.access$400(paramBuilder);
    mUserName = Builder.access$500(paramBuilder);
    mTokenType = Builder.access$600(paramBuilder);
    mClientId = Builder.access$700(paramBuilder);
    mFamilyId = Builder.access$800(paramBuilder);
    mScope = Builder.access$900(paramBuilder);
    mClientInfo = Builder.access$1000(paramBuilder);
    mAuthority = Builder.access$1100(paramBuilder);
    mEnvironment = Builder.access$1200(paramBuilder);
    mTenantId = Builder.access$1300(paramBuilder);
    mExpiresOn = Builder.access$1400(paramBuilder);
    mExtendedExpiresOn = Builder.access$1500(paramBuilder);
    mCachedAt = Builder.access$1600(paramBuilder);
    mSpeRing = Builder.access$1700(paramBuilder);
    mRefreshTokenAge = Builder.access$1800(paramBuilder);
    mSuccess = Builder.access$1900(paramBuilder);
    mTenantProfileData = Builder.access$2000(paramBuilder);
    mErrorCode = Builder.access$2100(paramBuilder);
    mErrorMessage = Builder.access$2200(paramBuilder);
    mCorrelationId = Builder.access$2300(paramBuilder);
    mSubErrorCode = Builder.access$2400(paramBuilder);
    mHttpStatusCode = Builder.access$2500(paramBuilder);
    mHttpResponseBody = Builder.access$2600(paramBuilder);
    mHttpResponseHeaders = Builder.access$2700(paramBuilder);
    mCliTelemErrorCode = Builder.access$2800(paramBuilder);
    mCliTelemSubErrorCode = Builder.access$2900(paramBuilder);
    mExceptionType = Builder.access$3000(paramBuilder);
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
  
  public static class Builder
  {
    public String mAccessToken;
    public String mAuthority;
    public long mCachedAt;
    public String mCliTelemErrorCode;
    public String mCliTelemSubErrorCode;
    public String mClientId;
    public String mClientInfo;
    public String mCorrelationId;
    public String mEnvironment;
    public String mErrorCode;
    public String mErrorMessage;
    public String mExceptionType;
    public long mExpiresOn;
    public long mExtendedExpiresOn;
    public String mFamilyId;
    public String mHomeAccountId;
    public String mHttpResponseBody;
    public String mHttpResponseHeaders;
    public int mHttpStatusCode;
    public String mIdToken;
    public String mLocalAccountId;
    public String mNegotiatedBrokerProtocolVersion;
    public String mRefreshToken;
    public String mRefreshTokenAge;
    public String mScope;
    public String mSpeRing;
    public String mSubErrorCode;
    public boolean mSuccess;
    public String mTenantId;
    public List<ICacheRecord> mTenantProfileData;
    public String mTokenType;
    public String mUserName;
    
    public Builder accessToken(String paramString)
    {
      mAccessToken = paramString;
      return this;
    }
    
    public Builder authority(String paramString)
    {
      mAuthority = paramString;
      return this;
    }
    
    public BrokerResult build()
    {
      return new BrokerResult(this, null);
    }
    
    public Builder cachedAt(long paramLong)
    {
      mCachedAt = paramLong;
      return this;
    }
    
    public Builder cliTelemErrorCode(String paramString)
    {
      mCliTelemErrorCode = paramString;
      return this;
    }
    
    public Builder cliTelemSubErrorCode(String paramString)
    {
      mCliTelemSubErrorCode = paramString;
      return this;
    }
    
    public Builder clientId(String paramString)
    {
      mClientId = paramString;
      return this;
    }
    
    public Builder clientInfo(String paramString)
    {
      mClientInfo = paramString;
      return this;
    }
    
    public Builder correlationId(String paramString)
    {
      mCorrelationId = paramString;
      return this;
    }
    
    public Builder environment(String paramString)
    {
      mEnvironment = paramString;
      return this;
    }
    
    public Builder errorCode(String paramString)
    {
      mErrorCode = paramString;
      return this;
    }
    
    public Builder errorMessage(String paramString)
    {
      mErrorMessage = paramString;
      return this;
    }
    
    public Builder exceptionType(String paramString)
    {
      mExceptionType = paramString;
      return this;
    }
    
    public Builder expiresOn(long paramLong)
    {
      mExpiresOn = paramLong;
      return this;
    }
    
    public Builder extendedExpiresOn(long paramLong)
    {
      mExtendedExpiresOn = paramLong;
      return this;
    }
    
    public Builder familyId(String paramString)
    {
      mFamilyId = paramString;
      return this;
    }
    
    public Builder homeAccountId(String paramString)
    {
      mHomeAccountId = paramString;
      return this;
    }
    
    public Builder httpResponseBody(String paramString)
    {
      mHttpResponseBody = paramString;
      return this;
    }
    
    public Builder httpResponseHeaders(String paramString)
    {
      mHttpResponseHeaders = paramString;
      return this;
    }
    
    public Builder httpStatusCode(int paramInt)
    {
      mHttpStatusCode = paramInt;
      return this;
    }
    
    public Builder idToken(String paramString)
    {
      mIdToken = paramString;
      return this;
    }
    
    public Builder localAccountId(String paramString)
    {
      mLocalAccountId = paramString;
      return this;
    }
    
    public Builder negotiatedBrokerProtocolVersion(String paramString)
    {
      mNegotiatedBrokerProtocolVersion = paramString;
      return this;
    }
    
    public Builder oauthSubErrorCode(String paramString)
    {
      mSubErrorCode = paramString;
      return this;
    }
    
    public Builder refreshToken(String paramString)
    {
      mRefreshToken = paramString;
      return this;
    }
    
    public Builder refreshTokenAge(String paramString)
    {
      mRefreshTokenAge = paramString;
      return this;
    }
    
    public Builder scope(String paramString)
    {
      mScope = paramString;
      return this;
    }
    
    public Builder speRing(String paramString)
    {
      mSpeRing = paramString;
      return this;
    }
    
    public Builder success(boolean paramBoolean)
    {
      mSuccess = paramBoolean;
      return this;
    }
    
    public Builder tenantId(String paramString)
    {
      mTenantId = paramString;
      return this;
    }
    
    public Builder tenantProfileRecords(List<ICacheRecord> paramList)
    {
      mTenantProfileData = paramList;
      return this;
    }
    
    public Builder tokenType(String paramString)
    {
      mTokenType = paramString;
      return this;
    }
    
    public Builder userName(String paramString)
    {
      mUserName = paramString;
      return this;
    }
  }
  
  public class SerializedNames
  {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String AUTHORITY = "authority";
    public static final String BROKER_ERROR_CODE = "broker_error_code";
    public static final String BROKER_ERROR_MESSAGE = "broker_error_message";
    public static final String BROKER_EXCEPTION_TYPE = "broker_exception_type";
    public static final String CACHED_AT = "cached_at";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_INFO = "client_info";
    public static final String CLI_TELEM_ERRORCODE = "cli_telem_error_code";
    public static final String CLI_TELEM_SUB_ERROR_CODE = "cli_telem_suberror_code";
    public static final String CORRELATION_ID = "correlation_id";
    public static final String ENVIRONMENT = "environment";
    public static final String EXPIRES_ON = "expires_on";
    public static final String EXTENDED_EXPIRES_ON = "ext_expires_on";
    public static final String FAMILY_ID = "family_id";
    public static final String HOME_ACCOUNT_ID = "home_account_id";
    public static final String HTTP_HEADERS = "http_response_headers";
    public static final String HTTP_RESPONSE_BODY = "http_response_body";
    public static final String HTTP_RESPONSE_CODE = "http_response_code";
    public static final String ID_TOKEN = "id_token";
    public static final String LOCAL_ACCOUNT_ID = "local_account_id";
    public static final String OAUTH_SUB_ERROR = "oauth_sub_error";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String REFRESH_TOKEN_AGE = "refresh_token_age";
    public static final String SCOPES = "scopes";
    public static final String SPE_RING = "spe_ring";
    public static final String SUCCESS = "success";
    public static final String TENANT_ID = "tenant_id";
    public static final String TENANT_PROFILE_CACHE_RECORDS = "tenant_profile_cache_records";
    public static final String TOKEN_TYPE = "token_type";
    public static final String USERNAME = "username";
    
    public SerializedNames() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.BrokerResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */