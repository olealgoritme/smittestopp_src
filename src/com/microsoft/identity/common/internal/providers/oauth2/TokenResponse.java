package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.c;

public class TokenResponse
  implements ISuccessResponse
{
  @c("access_token")
  public String mAccessToken;
  @e.c.c.v.a
  @c("expires_in")
  public Long mExpiresIn;
  @c("id_token")
  public String mIdToken;
  @c("refresh_token")
  public String mRefreshToken;
  @e.c.c.v.a
  public long mResponseReceivedTime;
  @e.c.c.v.a
  @c("scope")
  public String mScope;
  @e.c.c.v.a
  @c("state")
  public String mState;
  @e.c.c.v.a
  @c("token_type")
  public String mTokenType;
  
  public String getAccessToken()
  {
    return mAccessToken;
  }
  
  public Long getExpiresIn()
  {
    return mExpiresIn;
  }
  
  public String getIdToken()
  {
    return mIdToken;
  }
  
  public String getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public long getResponseReceivedTime()
  {
    return mResponseReceivedTime;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public String getState()
  {
    return mState;
  }
  
  public String getTokenType()
  {
    return mTokenType;
  }
  
  public void setAccessToken(String paramString)
  {
    mAccessToken = paramString;
  }
  
  public void setExpiresIn(Long paramLong)
  {
    mExpiresIn = paramLong;
  }
  
  public void setIdToken(String paramString)
  {
    mIdToken = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    mRefreshToken = paramString;
  }
  
  public void setResponseReceivedTime(Long paramLong)
  {
    mResponseReceivedTime = paramLong.longValue();
  }
  
  public void setScope(String paramString)
  {
    mScope = paramString;
  }
  
  public void setState(String paramString)
  {
    mState = paramString;
  }
  
  public void setTokenType(String paramString)
  {
    mTokenType = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("TokenResponse{mExpiresIn=");
    localStringBuilder.append(mExpiresIn);
    localStringBuilder.append(", mAccessToken='");
    e.a.a.a.a.a(localStringBuilder, mAccessToken, '\'', ", mTokenType='");
    e.a.a.a.a.a(localStringBuilder, mTokenType, '\'', ", mRefreshToken='");
    e.a.a.a.a.a(localStringBuilder, mRefreshToken, '\'', ", mScope='");
    e.a.a.a.a.a(localStringBuilder, mScope, '\'', ", mState='");
    e.a.a.a.a.a(localStringBuilder, mState, '\'', ", mIdToken='");
    e.a.a.a.a.a(localStringBuilder, mIdToken, '\'', ", mResponseReceivedTime=");
    localStringBuilder.append(mResponseReceivedTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.TokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */