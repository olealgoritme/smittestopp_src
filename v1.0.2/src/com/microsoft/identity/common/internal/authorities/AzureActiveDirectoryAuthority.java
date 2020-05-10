package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import android.net.Uri.Builder;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import e.a.a.a.a;
import e.c.c.v.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AzureActiveDirectoryAuthority
  extends Authority
{
  public static final transient String TAG = "AzureActiveDirectoryAuthority";
  @c("audience")
  public AzureActiveDirectoryAudience mAudience;
  public AzureActiveDirectoryCloud mAzureActiveDirectoryCloud;
  @c("flight_parameters")
  public Map<String, String> mFlightParameters;
  public boolean mMultipleCloudsSupported = false;
  @c("slice")
  public AzureActiveDirectorySlice mSlice;
  
  public AzureActiveDirectoryAuthority()
  {
    mAudience = new AllAccounts();
    mAuthorityTypeString = "AAD";
    mMultipleCloudsSupported = false;
    getAzureActiveDirectoryCloud();
  }
  
  public AzureActiveDirectoryAuthority(AzureActiveDirectoryAudience paramAzureActiveDirectoryAudience)
  {
    mAudience = paramAzureActiveDirectoryAudience;
    mAuthorityTypeString = "AAD";
    getAzureActiveDirectoryCloud();
  }
  
  private void getAzureActiveDirectoryCloud()
  {
    Object localObject;
    try
    {
      localObject = new java/net/URL;
      ((URL)localObject).<init>(mAudience.getCloudUrl());
      localObject = AzureActiveDirectory.getAzureActiveDirectoryCloud((URL)localObject);
      mKnownToMicrosoft = true;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getAzureActiveDirectoryCloud");
      Logger.errorPII(((StringBuilder)localObject).toString(), "AAD cloud URL was malformed.", localMalformedURLException);
      localObject = null;
      mKnownToMicrosoft = false;
    }
    mAzureActiveDirectoryCloud = ((AzureActiveDirectoryCloud)localObject);
  }
  
  public MicrosoftStsOAuth2Configuration createOAuth2Configuration()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":createOAuth2Configuration");
    Logger.verbose(((StringBuilder)localObject1).toString(), "Creating OAuth2Configuration");
    localObject1 = new MicrosoftStsOAuth2Configuration();
    ((AzureActiveDirectoryOAuth2Configuration)localObject1).setAuthorityUrl(getAuthorityURL());
    Object localObject2;
    if (mSlice != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":createOAuth2Configuration");
      Logger.info(((StringBuilder)localObject2).toString(), "Setting slice parameters...");
      localObject2 = new AzureActiveDirectorySlice();
      ((AzureActiveDirectorySlice)localObject2).setSlice(mSlice.getSlice());
      ((AzureActiveDirectorySlice)localObject2).setDataCenter(mSlice.getDC());
      ((AzureActiveDirectoryOAuth2Configuration)localObject1).setSlice((AzureActiveDirectorySlice)localObject2);
    }
    if (mFlightParameters != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":createOAuth2Configuration");
      Logger.info(((StringBuilder)localObject2).toString(), "Setting flight parameters...");
      localObject2 = mFlightParameters.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((AzureActiveDirectoryOAuth2Configuration)localObject1).getFlightParameters().put(localEntry.getKey(), localEntry.getValue());
      }
    }
    ((AzureActiveDirectoryOAuth2Configuration)localObject1).setMultipleCloudsSupported(mMultipleCloudsSupported);
    return (MicrosoftStsOAuth2Configuration)localObject1;
  }
  
  public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    return new MicrosoftStsOAuth2Strategy(createOAuth2Configuration(), paramOAuth2StrategyParameters);
  }
  
  public AzureActiveDirectoryAudience getAudience()
  {
    return mAudience;
  }
  
  public URL getAuthorityURL()
  {
    try
    {
      URL localURL = new URL(getAuthorityUri().toString());
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException("Authority URL is not a URL.", localMalformedURLException);
    }
  }
  
  public Uri getAuthorityUri()
  {
    getAzureActiveDirectoryCloud();
    Object localObject;
    if (mAzureActiveDirectoryCloud == null)
    {
      localObject = Uri.parse(mAudience.getCloudUrl());
    }
    else
    {
      localObject = a.a("https://");
      ((StringBuilder)localObject).append(mAzureActiveDirectoryCloud.getPreferredNetworkHostName());
      localObject = Uri.parse(((StringBuilder)localObject).toString());
    }
    return ((Uri)localObject).buildUpon().appendPath(mAudience.getTenantId()).build();
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
  
  public void setMultipleCloudsSupported(boolean paramBoolean)
  {
    mMultipleCloudsSupported = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */