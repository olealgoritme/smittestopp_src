package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AccessToken;

public class MicrosoftStsAccessToken
  extends AccessToken
{
  public Long mExtExpiresIn;
  
  public MicrosoftStsAccessToken(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    super(paramMicrosoftStsTokenResponse);
    mExtExpiresIn = paramMicrosoftStsTokenResponse.getExtExpiresIn();
  }
  
  public Long getExtExpiresIn()
  {
    return mExtExpiresIn;
  }
  
  public void setExtExpiresIn(Long paramLong)
  {
    mExtExpiresIn = paramLong;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAccessToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */