package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import android.text.TextUtils;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import e.a.a.a.a;
import e.c.c.v.c;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Authority
{
  public static final String ADFS_PATH_SEGMENT = "adfs";
  public static final String B2C = "B2C";
  public static final String B2C_PATH_SEGMENT = "tfp";
  public static final String TAG = "Authority";
  public static List<Authority> knownAuthorities = new ArrayList();
  public static Object sLock = new Object();
  @c("type")
  public String mAuthorityTypeString;
  @c("authority_url")
  public String mAuthorityUrl;
  @c("default")
  public boolean mIsDefault = false;
  public boolean mKnownToDeveloper = false;
  public boolean mKnownToMicrosoft = false;
  
  public static void addKnownAuthorities(List<Authority> paramList)
  {
    synchronized (sLock)
    {
      knownAuthorities.addAll(paramList);
      return;
    }
  }
  
  public static boolean authorityIsKnownFromConfiguration(String paramString)
  {
    boolean bool;
    if (getEquivalentConfiguredAuthority(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static Authority createAadAuthority(Uri paramUri, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUri.getScheme());
    localStringBuilder.append("://");
    localStringBuilder.append(paramUri.getHost());
    return new AzureActiveDirectoryAuthority(AzureActiveDirectoryAudience.getAzureActiveDirectoryAudience(localStringBuilder.toString(), (String)paramList.get(0)));
  }
  
  public static Authority getAuthorityFromAuthorityUrl(String paramString)
  {
    try
    {
      Object localObject = new URL(paramString);
      Uri localUri = Uri.parse(((URL)localObject).toString());
      localObject = localUri.getPathSegments();
      if (((List)localObject).size() == 0) {
        return new UnknownAuthority();
      }
      if (authorityIsKnownFromConfiguration(paramString))
      {
        if ("B2C".equalsIgnoreCase(getEquivalentConfiguredAuthoritymAuthorityTypeString)) {
          paramString = new AzureActiveDirectoryB2CAuthority(paramString);
        } else {
          paramString = createAadAuthority(localUri, (List)localObject);
        }
      }
      else
      {
        int i = 0;
        String str = ((String)((List)localObject).get(0)).toLowerCase();
        int j = str.hashCode();
        if (j != 114750)
        {
          if ((j == 2989104) && (str.equals("adfs"))) {
            break label153;
          }
        }
        else if (str.equals("tfp"))
        {
          i = 1;
          break label153;
        }
        i = -1;
        label153:
        if (i != 0)
        {
          if (i != 1)
          {
            paramString = new StringBuilder();
            paramString.append(TAG);
            paramString.append(":getAuthorityFromAuthorityUrl");
            Logger.verbose(paramString.toString(), "Authority type default: AAD");
            paramString = createAadAuthority(localUri, (List)localObject);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(TAG);
            ((StringBuilder)localObject).append(":getAuthorityFromAuthorityUrl");
            Logger.verbose(((StringBuilder)localObject).toString(), "Authority type is B2C");
            paramString = new AzureActiveDirectoryB2CAuthority(paramString);
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TAG);
          ((StringBuilder)localObject).append(":getAuthorityFromAuthorityUrl");
          Logger.verbose(((StringBuilder)localObject).toString(), "Authority type is ADFS");
          paramString = new ActiveDirectoryFederationServicesAuthority(paramString);
        }
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException("Invalid authority URL");
    }
  }
  
  public static Authority getEquivalentConfiguredAuthority(String paramString)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new java/net/URL;
      ((URL)localObject2).<init>(paramString);
      localObject2 = ((URL)localObject2).getAuthority();
      Iterator localIterator = knownAuthorities.iterator();
      boolean bool;
      do
      {
        do
        {
          paramString = (String)localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (Authority)localIterator.next();
        } while (TextUtils.isEmpty(mAuthorityUrl));
        URL localURL = new java/net/URL;
        localURL.<init>(mAuthorityUrl);
        bool = ((String)localObject2).equalsIgnoreCase(localURL.getAuthority());
      } while (!bool);
    }
    catch (MalformedURLException paramString)
    {
      Logger.errorPII(TAG, "Error parsing authority", paramString);
      paramString = (String)localObject1;
    }
    return paramString;
  }
  
  public static KnownAuthorityResult getKnownAuthorityResult(Authority paramAuthority)
  {
    a.b(new StringBuilder(), TAG, ":getKnownAuthorityResult", "Getting known authority result...");
    ClientException localClientException1;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":getKnownAuthorityResult");
      Logger.verbose(localStringBuilder.toString(), "Performing cloud discovery");
      performCloudDiscovery();
      localStringBuilder = null;
    }
    catch (IOException localIOException)
    {
      localClientException1 = new ClientException("io_error", "Unable to perform cloud discovery", localIOException);
    }
    boolean bool1 = false;
    ClientException localClientException2 = localClientException1;
    boolean bool2 = bool1;
    if (localClientException1 == null) {
      if (!isKnownAuthority(paramAuthority))
      {
        localClientException2 = new ClientException("unknown_authority", "Provided authority is not known.  MSAL will only make requests to known authorities");
        bool2 = bool1;
      }
      else
      {
        bool2 = true;
        localClientException2 = localClientException1;
      }
    }
    return new KnownAuthorityResult(bool2, localClientException2);
  }
  
  public static boolean isKnownAuthority(Authority paramAuthority)
  {
    boolean bool1 = false;
    if (paramAuthority == null)
    {
      a.c(new StringBuilder(), TAG, ":isKnownAuthority", "Authority is null");
      return false;
    }
    if (!paramAuthority.getKnownToDeveloper())
    {
      Iterator localIterator = knownAuthorities.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Authority)localIterator.next();
      } while ((mAuthorityUrl == null) || (paramAuthority.getAuthorityURL() == null) || (paramAuthority.getAuthorityURL().getAuthority() == null) || (!mAuthorityUrl.toLowerCase().contains(paramAuthority.getAuthorityURL().getAuthority().toLowerCase())));
    }
    boolean bool2 = true;
    break label121;
    bool2 = false;
    label121:
    boolean bool3 = AzureActiveDirectory.hasCloudHost(paramAuthority.getAuthorityURL());
    if ((bool2) || (bool3)) {
      bool1 = true;
    }
    Object localObject = a.a(new StringBuilder(), TAG, ":isKnownAuthority");
    paramAuthority = new StringBuilder();
    paramAuthority.append("Authority is known to developer? [");
    paramAuthority.append(bool2);
    paramAuthority.append("]");
    Logger.verbose((String)localObject, paramAuthority.toString());
    localObject = a.a(new StringBuilder(), TAG, ":isKnownAuthority");
    paramAuthority = new StringBuilder();
    paramAuthority.append("Authority is known to Microsoft? [");
    paramAuthority.append(bool3);
    paramAuthority.append("]");
    Logger.verbose((String)localObject, paramAuthority.toString());
    return bool1;
  }
  
  public static void performCloudDiscovery()
  {
    a.b(new StringBuilder(), TAG, ":performCloudDiscovery", "Performing cloud discovery...");
    synchronized (sLock)
    {
      if (!AzureActiveDirectory.isInitialized()) {
        AzureActiveDirectory.performCloudDiscovery();
      }
      return;
    }
  }
  
  public abstract OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters paramOAuth2StrategyParameters);
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Authority)) {
      return false;
    }
    paramObject = (Authority)paramObject;
    if (!mAuthorityTypeString.equals(mAuthorityTypeString)) {
      return false;
    }
    return getAuthorityURL().equals(((Authority)paramObject).getAuthorityURL());
  }
  
  public String getAuthorityTypeString()
  {
    return mAuthorityTypeString;
  }
  
  public abstract URL getAuthorityURL();
  
  public abstract Uri getAuthorityUri();
  
  public boolean getDefault()
  {
    return mIsDefault;
  }
  
  public boolean getKnownToDeveloper()
  {
    return mKnownToDeveloper;
  }
  
  public boolean getKnownToMicrosoft()
  {
    return mKnownToMicrosoft;
  }
  
  public int hashCode()
  {
    int i = mAuthorityTypeString.hashCode();
    return getAuthorityURL().hashCode() + i * 31;
  }
  
  public void setDefault(Boolean paramBoolean)
  {
    mIsDefault = paramBoolean.booleanValue();
  }
  
  public static class KnownAuthorityResult
  {
    public ClientException mClientException;
    public boolean mKnown;
    
    public KnownAuthorityResult(boolean paramBoolean, ClientException paramClientException)
    {
      mKnown = paramBoolean;
      mClientException = paramClientException;
    }
    
    public ClientException getClientException()
    {
      return mClientException;
    }
    
    public boolean getKnown()
    {
      return mKnown;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authorities.Authority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */