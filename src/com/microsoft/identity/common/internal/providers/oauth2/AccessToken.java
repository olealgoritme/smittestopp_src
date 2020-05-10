package com.microsoft.identity.common.internal.providers.oauth2;

public class AccessToken
{
  public static final int SECONDS_MS = 1000;
  public long mExpiresIn;
  public String mRawAccessToken;
  public final long mTokenExpiredBuffer = 600000L;
  public long mTokenReceivedTime;
  public String mTokenType;
  
  public AccessToken(TokenResponse paramTokenResponse)
  {
    mExpiresIn = paramTokenResponse.getExpiresIn().longValue();
    mTokenReceivedTime = paramTokenResponse.getResponseReceivedTime();
    mTokenType = paramTokenResponse.getTokenType();
    mRawAccessToken = paramTokenResponse.getAccessToken();
  }
  
  public String getAccessToken()
  {
    return mRawAccessToken;
  }
  
  public long getExpiresIn()
  {
    return mExpiresIn;
  }
  
  public String getRawAccessToken()
  {
    return mRawAccessToken;
  }
  
  public long getTokenExpiredBuffer()
  {
    return 600000L;
  }
  
  public long getTokenReceivedTime()
  {
    return mTokenReceivedTime;
  }
  
  public String getTokenType()
  {
    return mTokenType;
  }
  
  public boolean isExpired()
  {
    long l1 = System.currentTimeMillis();
    long l2 = mTokenReceivedTime;
    boolean bool;
    if (mExpiresIn * 1000L + l2 > l1 + 600000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setExpiresIn(long paramLong)
  {
    mExpiresIn = paramLong;
  }
  
  public void setRawAccessToken(String paramString)
  {
    mRawAccessToken = paramString;
  }
  
  public void setTokenReceivedTime(long paramLong)
  {
    mTokenReceivedTime = paramLong;
  }
  
  public void setTokenType(String paramString)
  {
    mTokenType = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.AccessToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */