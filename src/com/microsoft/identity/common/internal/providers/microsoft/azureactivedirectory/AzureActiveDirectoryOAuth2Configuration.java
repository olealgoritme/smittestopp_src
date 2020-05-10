package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Configuration;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AzureActiveDirectoryOAuth2Configuration
  extends OAuth2Configuration
{
  public boolean mAuthorityHostValidationEnabled = true;
  public URL mAuthorityUrl;
  public Map<String, String> mFlightParameters = new HashMap();
  public boolean mMultipleCloudsSupported;
  public AzureActiveDirectorySlice mSlice;
  
  public URL getAuthorityUrl()
  {
    return mAuthorityUrl;
  }
  
  public Map<String, String> getFlightParameters()
  {
    return mFlightParameters;
  }
  
  public boolean getMultipleCloudsSupported()
  {
    return mMultipleCloudsSupported;
  }
  
  public AzureActiveDirectorySlice getSlice()
  {
    return mSlice;
  }
  
  public boolean isAuthorityHostValidationEnabled()
  {
    return mAuthorityHostValidationEnabled;
  }
  
  public void setAuthorityHostValidationEnabled(boolean paramBoolean)
  {
    mAuthorityHostValidationEnabled = paramBoolean;
  }
  
  public void setAuthorityUrl(URL paramURL)
  {
    mAuthorityUrl = paramURL;
  }
  
  public void setFlightParameters(Map<String, String> paramMap)
  {
    mFlightParameters = paramMap;
  }
  
  public void setMultipleCloudsSupported(boolean paramBoolean)
  {
    mMultipleCloudsSupported = paramBoolean;
  }
  
  public void setSlice(AzureActiveDirectorySlice paramAzureActiveDirectorySlice)
  {
    mSlice = paramAzureActiveDirectorySlice;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */