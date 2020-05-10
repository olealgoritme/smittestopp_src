package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AccessToken;
import java.util.Date;

public class AzureActiveDirectoryAccessToken
  extends AccessToken
{
  public Date mExpiresOn;
  public Date mExtendedExpiresOn;
  
  public AzureActiveDirectoryAccessToken(AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    super(paramAzureActiveDirectoryTokenResponse);
    mExpiresOn = paramAzureActiveDirectoryTokenResponse.getExpiresOn();
    mExtendedExpiresOn = paramAzureActiveDirectoryTokenResponse.getExtExpiresOn();
  }
  
  public Date getExpiresOn()
  {
    return mExpiresOn;
  }
  
  public Date getExtendedExpiresOn()
  {
    return mExtendedExpiresOn;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccessToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */