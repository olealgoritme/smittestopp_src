package com.microsoft.identity.client;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Base64;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.configuration.HttpConfiguration;
import com.microsoft.identity.client.configuration.LoggerConfiguration;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authorities.Environment;
import com.microsoft.identity.common.internal.authorities.UnknownAudience;
import com.microsoft.identity.common.internal.authorities.UnknownAuthority;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.telemetry.TelemetryConfiguration;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import com.microsoft.identity.common.internal.ui.browser.BrowserDescriptor;
import e.a.a.a.a;
import e.c.c.v.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PublicClientApplicationConfiguration
{
  public static final String TAG = "PublicClientApplicationConfiguration";
  @c("account_mode")
  public AccountMode mAccountMode;
  public transient Context mAppContext;
  @c("authorities")
  public List<Authority> mAuthorities;
  @c("authorization_user_agent")
  public AuthorizationAgent mAuthorizationAgent;
  @c("browser_safelist")
  public List<BrowserDescriptor> mBrowserSafeList;
  @c("client_capabilities")
  public String mClientCapabilities;
  @c("client_id")
  public String mClientId;
  @c("environment")
  public Environment mEnvironment;
  @c("http")
  public HttpConfiguration mHttpConfiguration;
  public transient boolean mIsSharedDevice = false;
  @c("logging")
  public LoggerConfiguration mLoggerConfiguration;
  @c("multiple_clouds_supported")
  public Boolean mMultipleCloudsSupported;
  public transient OAuth2TokenCache mOAuth2TokenCache;
  @c("redirect_uri")
  public String mRedirectUri;
  @c("minimum_required_broker_protocol_version")
  public String mRequiredBrokerProtocolVersion;
  @c("telemetry")
  public TelemetryConfiguration mTelemetryConfiguration;
  @c("broker_redirect_uri_registered")
  public Boolean mUseBroker;
  @c("web_view_zoom_controls_enabled")
  public Boolean webViewZoomControlsEnabled;
  @c("web_view_zoom_enabled")
  public Boolean webViewZoomEnabled;
  
  private void checkDefaultAuthoritySpecified()
  {
    Object localObject = mAuthorities;
    if ((localObject != null) && (((List)localObject).size() > 1))
    {
      int i = 0;
      localObject = mAuthorities.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Authority)((Iterator)localObject).next()).getDefault()) {
          i++;
        }
      }
      if (i != 0)
      {
        if (i > 1) {
          throw new IllegalArgumentException("More than one authority in your configuration is marked as default.  Only one authority may be default.");
        }
      }
      else {
        throw new IllegalArgumentException("One authority in your configuration must be marked as default.");
      }
    }
  }
  
  private boolean isBrokerRedirectUri()
  {
    StringBuilder localStringBuilder = a.a("msauth://");
    localStringBuilder.append(mAppContext.getPackageName());
    localStringBuilder.append("/.*");
    return Pattern.compile(localStringBuilder.toString()).matcher(mRedirectUri).matches();
  }
  
  private void nullConfigurationCheck(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      return;
    }
    throw new IllegalArgumentException(a.b(paramString1, " cannot be null.  Invalid configuration."));
  }
  
  private void validateAzureActiveDirectoryAuthority(AzureActiveDirectoryAuthority paramAzureActiveDirectoryAuthority)
  {
    paramAzureActiveDirectoryAuthority = mAudience;
    if ((paramAzureActiveDirectoryAuthority != null) && ((paramAzureActiveDirectoryAuthority instanceof UnknownAudience))) {
      throw new IllegalArgumentException("Unrecognized audience type for AzureActiveDirectoryAuthority -- null, invalid, or unknown type specified");
    }
  }
  
  private void verifyRedirectUriWithAppSignature()
  {
    String str = mAppContext.getPackageName();
    try
    {
      Signature[] arrayOfSignature = mAppContext.getPackageManager().getPackageInfo(str, 64).signatures;
      int i = arrayOfSignature.length;
      int j = 0;
      while (j < i)
      {
        Object localObject1 = arrayOfSignature[j];
        Object localObject2 = MessageDigest.getInstance("SHA");
        ((MessageDigest)localObject2).update(((Signature)localObject1).toByteArray());
        localObject1 = Base64.encodeToString(((MessageDigest)localObject2).digest(), 2);
        localObject2 = new android/net/Uri$Builder;
        ((Uri.Builder)localObject2).<init>();
        localObject2 = ((Uri.Builder)localObject2).scheme("msauth").authority(str).appendPath((String)localObject1).build();
        boolean bool = mRedirectUri.equalsIgnoreCase(((Uri)localObject2).toString());
        if (bool) {
          return;
        }
        j++;
        continue;
        Logger.error(TAG, "Unexpected error in verifyRedirectUriWithAppSignature()", localNameNotFoundException);
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    throw new MsalClientException("redirect_uri_validation_error", "The redirect URI in the configuration file doesn't match with the one generated with package name and signature hash. Please verify the uri in the config file and your app registration in Azure portal.");
  }
  
  public void checkIntentFilterAddedToAppManifestForBrokerFlow()
  {
    boolean bool = MsalUtils.hasCustomTabRedirectActivity(mAppContext, mRedirectUri);
    if (((getAuthorizationAgent() != AuthorizationAgent.DEFAULT) && (getAuthorizationAgent() != AuthorizationAgent.BROWSER)) || (bool))
    {
      if (!mUseBroker.booleanValue()) {
        return;
      }
      if (!isBrokerRedirectUri())
      {
        Logger.info(TAG, "The app is still using legacy MSAL redirect uri. Switch to MSAL local auth.");
        mUseBroker = Boolean.valueOf(false);
        return;
      }
      verifyRedirectUriWithAppSignature();
      return;
    }
    Uri localUri = Uri.parse(mRedirectUri);
    StringBuilder localStringBuilder = a.a("Intent filter for: ");
    localStringBuilder.append(BrowserTabActivity.class.getSimpleName());
    localStringBuilder.append(" is missing.  Please make sure you have the following activity in your AndroidManifest.xml \n\n<activity android:name=\"com.microsoft.identity.client.BrowserTabActivity\">\n\t<intent-filter>\n\t\t<action android:name=\"android.intent.action.VIEW\" />\n\t\t<category android:name=\"android.intent.category.DEFAULT\" />\n\t\t<category android:name=\"android.intent.category.BROWSABLE\" />\n\t\t<data\n\t\t\tandroid:host=\"");
    localStringBuilder.append(localUri.getHost());
    localStringBuilder.append("\"\n\t\t\tandroid:path=\"");
    localStringBuilder.append(localUri.getPath());
    localStringBuilder.append("\"\n\t\t\tandroid:scheme=\"");
    localStringBuilder.append(localUri.getScheme());
    localStringBuilder.append("\" />\n\t</intent-filter>\n</activity>\n");
    throw new MsalClientException("app_manifest_validation_error", localStringBuilder.toString());
  }
  
  public AccountMode getAccountMode()
  {
    return mAccountMode;
  }
  
  public Context getAppContext()
  {
    return mAppContext;
  }
  
  public List<Authority> getAuthorities()
  {
    return mAuthorities;
  }
  
  public AuthorizationAgent getAuthorizationAgent()
  {
    return mAuthorizationAgent;
  }
  
  public List<BrowserDescriptor> getBrowserSafeList()
  {
    return mBrowserSafeList;
  }
  
  public String getClientCapabilities()
  {
    return mClientCapabilities;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public Authority getDefaultAuthority()
  {
    Object localObject = mAuthorities;
    if (localObject != null)
    {
      if (((List)localObject).size() > 1)
      {
        localObject = mAuthorities.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Authority localAuthority = (Authority)((Iterator)localObject).next();
          if (localAuthority.getDefault()) {
            return localAuthority;
          }
        }
        return null;
      }
      return (Authority)mAuthorities.get(0);
    }
    return null;
  }
  
  public Environment getEnvironment()
  {
    return mEnvironment;
  }
  
  public HttpConfiguration getHttpConfiguration()
  {
    return mHttpConfiguration;
  }
  
  public boolean getIsSharedDevice()
  {
    return mIsSharedDevice;
  }
  
  public LoggerConfiguration getLoggerConfiguration()
  {
    return mLoggerConfiguration;
  }
  
  public Boolean getMultipleCloudsSupported()
  {
    return mMultipleCloudsSupported;
  }
  
  public OAuth2TokenCache getOAuth2TokenCache()
  {
    return mOAuth2TokenCache;
  }
  
  public String getRedirectUri()
  {
    return mRedirectUri;
  }
  
  public String getRequiredBrokerProtocolVersion()
  {
    return mRequiredBrokerProtocolVersion;
  }
  
  public TelemetryConfiguration getTelemetryConfiguration()
  {
    return mTelemetryConfiguration;
  }
  
  public Boolean getUseBroker()
  {
    return mUseBroker;
  }
  
  public boolean isDefaultAuthorityConfigured()
  {
    return getDefaultAuthority() != null;
  }
  
  public boolean isWebViewZoomControlsEnabled()
  {
    return webViewZoomControlsEnabled.booleanValue();
  }
  
  public boolean isWebViewZoomEnabled()
  {
    return webViewZoomEnabled.booleanValue();
  }
  
  public void mergeConfiguration(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    Object localObject1 = mClientId;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mClientId;
    }
    mClientId = ((String)localObject2);
    localObject1 = mRedirectUri;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mRedirectUri;
    }
    mRedirectUri = ((String)localObject2);
    localObject1 = mAuthorities;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mAuthorities;
    }
    mAuthorities = ((List)localObject2);
    localObject1 = mAuthorizationAgent;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mAuthorizationAgent;
    }
    mAuthorizationAgent = ((AuthorizationAgent)localObject2);
    localObject1 = mEnvironment;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mEnvironment;
    }
    mEnvironment = ((Environment)localObject2);
    localObject1 = mHttpConfiguration;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mHttpConfiguration;
    }
    mHttpConfiguration = ((HttpConfiguration)localObject2);
    localObject1 = mMultipleCloudsSupported;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mMultipleCloudsSupported;
    }
    mMultipleCloudsSupported = ((Boolean)localObject2);
    localObject1 = mUseBroker;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mUseBroker;
    }
    mUseBroker = ((Boolean)localObject2);
    localObject1 = mTelemetryConfiguration;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mTelemetryConfiguration;
    }
    mTelemetryConfiguration = ((TelemetryConfiguration)localObject2);
    localObject1 = mRequiredBrokerProtocolVersion;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mRequiredBrokerProtocolVersion;
    }
    mRequiredBrokerProtocolVersion = ((String)localObject2);
    localObject2 = mBrowserSafeList;
    if (localObject2 == null)
    {
      mBrowserSafeList = mBrowserSafeList;
    }
    else
    {
      localObject1 = mBrowserSafeList;
      if (localObject1 != null) {
        ((List)localObject2).addAll((Collection)localObject1);
      }
    }
    localObject2 = mAccountMode;
    if (localObject2 == AccountMode.MULTIPLE) {
      localObject2 = mAccountMode;
    }
    mAccountMode = ((AccountMode)localObject2);
    localObject1 = mClientCapabilities;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mClientCapabilities;
    }
    mClientCapabilities = ((String)localObject2);
    boolean bool1 = mIsSharedDevice;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (bool1 == true) {
      bool3 = mIsSharedDevice;
    }
    mIsSharedDevice = bool3;
    localObject1 = mLoggerConfiguration;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = mLoggerConfiguration;
    }
    mLoggerConfiguration = ((LoggerConfiguration)localObject2);
    localObject2 = webViewZoomControlsEnabled;
    if ((localObject2 != null) && (!((Boolean)localObject2).booleanValue())) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    webViewZoomControlsEnabled = Boolean.valueOf(bool3);
    paramPublicClientApplicationConfiguration = webViewZoomEnabled;
    bool3 = bool2;
    if (paramPublicClientApplicationConfiguration != null) {
      if (paramPublicClientApplicationConfiguration.booleanValue()) {
        bool3 = bool2;
      } else {
        bool3 = false;
      }
    }
    webViewZoomEnabled = Boolean.valueOf(bool3);
  }
  
  public void setAppContext(Context paramContext)
  {
    mAppContext = paramContext;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setIsSharedDevice(boolean paramBoolean)
  {
    mIsSharedDevice = paramBoolean;
  }
  
  public void setOAuth2TokenCache(OAuth2TokenCache paramOAuth2TokenCache)
  {
    mOAuth2TokenCache = paramOAuth2TokenCache;
  }
  
  public void setRedirectUri(String paramString)
  {
    mRedirectUri = paramString;
  }
  
  public void setTokenCacheSecretKeys(byte[] paramArrayOfByte)
  {
    AuthenticationSettings.INSTANCE.setSecretKey(paramArrayOfByte);
  }
  
  public void setWebViewZoomControlsEnabled(boolean paramBoolean)
  {
    webViewZoomControlsEnabled = Boolean.valueOf(paramBoolean);
  }
  
  public void setWebViewZoomEnabled(boolean paramBoolean)
  {
    webViewZoomEnabled = Boolean.valueOf(paramBoolean);
  }
  
  public void validateConfiguration()
  {
    nullConfigurationCheck("redirect_uri", mRedirectUri);
    nullConfigurationCheck("client_id", mClientId);
    checkDefaultAuthoritySpecified();
    if (!mAuthorizationAgent.equals(AuthorizationAgent.WEBVIEW))
    {
      localObject = mBrowserSafeList;
      if ((localObject == null) || (((List)localObject).isEmpty())) {
        throw new IllegalArgumentException("Null browser safe list configured.");
      }
    }
    Object localObject = mAuthorities.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Authority localAuthority = (Authority)((Iterator)localObject).next();
      if (!(localAuthority instanceof UnknownAuthority))
      {
        if ((localAuthority instanceof AzureActiveDirectoryAuthority)) {
          validateAzureActiveDirectoryAuthority((AzureActiveDirectoryAuthority)localAuthority);
        }
      }
      else {
        throw new IllegalArgumentException("Unrecognized authority type -- null, invalid or unknown type specified.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplicationConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */