package com.microsoft.identity.common.internal.broker;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import java.util.List;

public class BrokerResult$Builder
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

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.BrokerResult.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */