package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.internal.dto.IRefreshTokenRecord;

public abstract class RefreshToken
  implements IRefreshTokenRecord
{
  public String mRawRefreshToken;
  public long mTokenReceivedTime;
  
  public RefreshToken(TokenResponse paramTokenResponse)
  {
    mTokenReceivedTime = paramTokenResponse.getResponseReceivedTime();
    mRawRefreshToken = paramTokenResponse.getRefreshToken();
  }
  
  public RefreshToken(String paramString)
  {
    mRawRefreshToken = paramString;
  }
  
  public String getRefreshToken()
  {
    return mRawRefreshToken;
  }
  
  public long getTokenReceivedTime()
  {
    return mTokenReceivedTime;
  }
  
  public void setRawRefreshToken(String paramString)
  {
    mRawRefreshToken = paramString;
  }
  
  public void setTokenReceivedTime(long paramLong)
  {
    mTokenReceivedTime = paramLong;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.RefreshToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */