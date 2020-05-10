package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.PkceChallenge;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class MicrosoftAuthorizationRequest$Builder<B extends Builder<B>>
  extends AuthorizationRequest.Builder<B>
{
  public URL mAuthority;
  public Map<String, String> mFlightParameters = new HashMap();
  public String mLibraryName;
  public String mLibraryVersion;
  public Boolean mMultipleCloudAware;
  public PkceChallenge mPkceChallenge;
  public AzureActiveDirectorySlice mSlice;
  
  public abstract B self();
  
  public B setAuthority(URL paramURL)
  {
    mAuthority = paramURL;
    return self();
  }
  
  public B setFlightParameters(Map<String, String> paramMap)
  {
    mFlightParameters = paramMap;
    return self();
  }
  
  public B setLibraryName(String paramString)
  {
    mLibraryName = paramString;
    return self();
  }
  
  public B setLibraryVersion(String paramString)
  {
    mLibraryVersion = paramString;
    return self();
  }
  
  public B setMultipleCloudAware(boolean paramBoolean)
  {
    mMultipleCloudAware = Boolean.valueOf(paramBoolean);
    return self();
  }
  
  public B setPkceChallenge(PkceChallenge paramPkceChallenge)
  {
    mPkceChallenge = paramPkceChallenge;
    return self();
  }
  
  public B setSlice(AzureActiveDirectorySlice paramAzureActiveDirectorySlice)
  {
    mSlice = paramAzureActiveDirectorySlice;
    return self();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */