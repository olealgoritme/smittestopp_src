package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.internal.telemetry.CliTelemInfo;
import e.a.a.a.a;

public class TokenResult
  implements IResult
{
  public CliTelemInfo mCliTelemInfo;
  public boolean mSuccess = false;
  public TokenErrorResponse mTokenErrorResponse;
  public TokenResponse mTokenResponse;
  
  public TokenResult() {}
  
  public TokenResult(TokenErrorResponse paramTokenErrorResponse)
  {
    this(null, paramTokenErrorResponse);
  }
  
  public TokenResult(TokenResponse paramTokenResponse)
  {
    this(paramTokenResponse, null);
  }
  
  public TokenResult(TokenResponse paramTokenResponse, TokenErrorResponse paramTokenErrorResponse)
  {
    mTokenResponse = paramTokenResponse;
    mTokenErrorResponse = paramTokenErrorResponse;
    if (paramTokenResponse != null) {
      mSuccess = true;
    }
  }
  
  public CliTelemInfo getCliTelemInfo()
  {
    return mCliTelemInfo;
  }
  
  public TokenErrorResponse getErrorResponse()
  {
    return mTokenErrorResponse;
  }
  
  public boolean getSuccess()
  {
    return mSuccess;
  }
  
  public TokenResponse getSuccessResponse()
  {
    return mTokenResponse;
  }
  
  public TokenResponse getTokenResponse()
  {
    return mTokenResponse;
  }
  
  public void setCliTelemInfo(CliTelemInfo paramCliTelemInfo)
  {
    mCliTelemInfo = paramCliTelemInfo;
  }
  
  public void setSuccess(boolean paramBoolean)
  {
    mSuccess = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("TokenResult{mTokenResponse=");
    localStringBuilder.append(mTokenResponse);
    localStringBuilder.append(", mTokenErrorResponse=");
    localStringBuilder.append(mTokenErrorResponse);
    localStringBuilder.append(", mSuccess=");
    localStringBuilder.append(mSuccess);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.TokenResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */