package com.microsoft.identity.client.internal.controllers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.microsoft.identity.client.AcquireTokenParameters;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IClaimable;
import com.microsoft.identity.client.ITenantProfile;
import com.microsoft.identity.client.MultiTenantAccount;
import com.microsoft.identity.client.Prompt;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.client.TokenParameters;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.claims.RequestedClaimAdditionalInformation;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.IntuneAcquireTokenParameters;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.internal.authscheme.AuthenticationSchemeFactory;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OperationParametersAdapter
{
  public static final String CLIENT_CAPABILITIES_CLAIM = "XMS_CC";
  public static final String TAG = "OperationParametersAdapter";
  
  public static ClaimsRequest addClientCapabilitiesToClaimsRequest(ClaimsRequest paramClaimsRequest, String paramString)
  {
    ClaimsRequest localClaimsRequest = paramClaimsRequest;
    if (paramClaimsRequest == null) {
      localClaimsRequest = new ClaimsRequest();
    }
    if (paramString != null)
    {
      paramClaimsRequest = new RequestedClaimAdditionalInformation();
      paramClaimsRequest.setValues(new ArrayList(Arrays.asList(paramString.split(","))));
      localClaimsRequest.requestClaimInAccessToken("XMS_CC", paramClaimsRequest);
    }
    return localClaimsRequest;
  }
  
  public static AcquireTokenOperationParameters createAcquireTokenOperationParameters(AcquireTokenParameters paramAcquireTokenParameters, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, OAuth2TokenCache paramOAuth2TokenCache)
  {
    AcquireTokenOperationParameters localAcquireTokenOperationParameters = new AcquireTokenOperationParameters();
    localAcquireTokenOperationParameters.setAuthenticationScheme(AuthenticationSchemeFactory.createScheme(paramAcquireTokenParameters.getAuthenticationScheme()));
    if (StringUtil.isEmpty(paramAcquireTokenParameters.getAuthority()))
    {
      if (paramAcquireTokenParameters.getAccount() != null) {
        localAcquireTokenOperationParameters.setAuthority(getRequestAuthority(paramPublicClientApplicationConfiguration));
      } else {
        localAcquireTokenOperationParameters.setAuthority(paramPublicClientApplicationConfiguration.getDefaultAuthority());
      }
    }
    else {
      localAcquireTokenOperationParameters.setAuthority(Authority.getAuthorityFromAuthorityUrl(paramAcquireTokenParameters.getAuthority()));
    }
    localAcquireTokenOperationParameters.setBrowserSafeList(paramPublicClientApplicationConfiguration.getBrowserSafeList());
    if ((localAcquireTokenOperationParameters.getAuthority() instanceof AzureActiveDirectoryAuthority))
    {
      ((AzureActiveDirectoryAuthority)localAcquireTokenOperationParameters.getAuthority()).setMultipleCloudsSupported(paramPublicClientApplicationConfiguration.getMultipleCloudsSupported().booleanValue());
      localAcquireTokenOperationParameters.setClaimsRequest(ClaimsRequest.getJsonStringFromClaimsRequest(addClientCapabilitiesToClaimsRequest(paramAcquireTokenParameters.getClaimsRequest(), paramPublicClientApplicationConfiguration.getClientCapabilities())));
      if (paramAcquireTokenParameters.getClaimsRequest() != null) {
        localAcquireTokenOperationParameters.setForceRefresh(true);
      }
    }
    else
    {
      localAcquireTokenOperationParameters.setClaimsRequest(ClaimsRequest.getJsonStringFromClaimsRequest(paramAcquireTokenParameters.getClaimsRequest()));
    }
    StringBuilder localStringBuilder = a.a("Using authority: [");
    localStringBuilder.append(localAcquireTokenOperationParameters.getAuthority().getAuthorityUri());
    localStringBuilder.append("]");
    Logger.verbosePII(":createAcquireTokenOperationParameters", localStringBuilder.toString());
    localAcquireTokenOperationParameters.setScopes(new HashSet(paramAcquireTokenParameters.getScopes()));
    localAcquireTokenOperationParameters.setClientId(paramPublicClientApplicationConfiguration.getClientId());
    localAcquireTokenOperationParameters.setRedirectUri(paramPublicClientApplicationConfiguration.getRedirectUri());
    localAcquireTokenOperationParameters.setActivity(paramAcquireTokenParameters.getActivity());
    localAcquireTokenOperationParameters.setFragment(paramAcquireTokenParameters.getFragment());
    if (paramAcquireTokenParameters.getAccount() != null)
    {
      localAcquireTokenOperationParameters.setLoginHint(getUsername(paramAcquireTokenParameters.getAccount()));
      localAcquireTokenOperationParameters.setAccount(paramAcquireTokenParameters.getAccountRecord());
    }
    else
    {
      localAcquireTokenOperationParameters.setLoginHint(paramAcquireTokenParameters.getLoginHint());
    }
    localAcquireTokenOperationParameters.setTokenCache(paramOAuth2TokenCache);
    localAcquireTokenOperationParameters.setExtraQueryStringParameters(paramAcquireTokenParameters.getExtraQueryStringParameters());
    localAcquireTokenOperationParameters.setExtraScopesToConsent(paramAcquireTokenParameters.getExtraScopesToConsent());
    localAcquireTokenOperationParameters.setAppContext(paramPublicClientApplicationConfiguration.getAppContext());
    if (paramPublicClientApplicationConfiguration.getAuthorizationAgent() != null) {
      localAcquireTokenOperationParameters.setAuthorizationAgent(paramPublicClientApplicationConfiguration.getAuthorizationAgent());
    } else {
      localAcquireTokenOperationParameters.setAuthorizationAgent(AuthorizationAgent.DEFAULT);
    }
    if ((paramAcquireTokenParameters instanceof IntuneAcquireTokenParameters))
    {
      boolean bool = ((IntuneAcquireTokenParameters)paramAcquireTokenParameters).isBrokerBrowserSupportEnabled();
      paramOAuth2TokenCache = a.a(new StringBuilder(), TAG, ":createAcquireTokenOperationParameters");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" IntuneAcquireTokenParameters instance, broker browser enabled : ");
      localStringBuilder.append(bool);
      Logger.info(paramOAuth2TokenCache, localStringBuilder.toString());
      localAcquireTokenOperationParameters.setBrokerBrowserSupportEnabled(bool);
    }
    if ((paramAcquireTokenParameters.getPrompt() != null) && (paramAcquireTokenParameters.getPrompt() != Prompt.WHEN_REQUIRED)) {
      localAcquireTokenOperationParameters.setOpenIdConnectPromptParameter(paramAcquireTokenParameters.getPrompt().toOpenIdConnectPromptParameter());
    } else {
      localAcquireTokenOperationParameters.setOpenIdConnectPromptParameter(OpenIdConnectPromptParameter.SELECT_ACCOUNT);
    }
    paramAcquireTokenParameters = paramPublicClientApplicationConfiguration.getAppContext();
    localAcquireTokenOperationParameters.setApplicationName(paramAcquireTokenParameters.getPackageName());
    localAcquireTokenOperationParameters.setApplicationVersion(getPackageVersion(paramAcquireTokenParameters));
    localAcquireTokenOperationParameters.setSdkVersion(PublicClientApplication.getSdkVersion());
    localAcquireTokenOperationParameters.setWebViewZoomControlsEnabled(paramPublicClientApplicationConfiguration.isWebViewZoomControlsEnabled());
    localAcquireTokenOperationParameters.setWebViewZoomEnabled(paramPublicClientApplicationConfiguration.isWebViewZoomEnabled());
    return localAcquireTokenOperationParameters;
  }
  
  public static AcquireTokenSilentOperationParameters createAcquireTokenSilentOperationParameters(AcquireTokenSilentParameters paramAcquireTokenSilentParameters, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, OAuth2TokenCache paramOAuth2TokenCache)
  {
    Context localContext = paramPublicClientApplicationConfiguration.getAppContext();
    Authority localAuthority = Authority.getAuthorityFromAuthorityUrl(paramAcquireTokenSilentParameters.getAuthority());
    ClaimsRequest localClaimsRequest = paramAcquireTokenSilentParameters.getClaimsRequest();
    String str = ClaimsRequest.getJsonStringFromClaimsRequest(localClaimsRequest);
    AcquireTokenSilentOperationParameters localAcquireTokenSilentOperationParameters = new AcquireTokenSilentOperationParameters();
    localAcquireTokenSilentOperationParameters.setAppContext(paramPublicClientApplicationConfiguration.getAppContext());
    localAcquireTokenSilentOperationParameters.setScopes(new HashSet(paramAcquireTokenSilentParameters.getScopes()));
    localAcquireTokenSilentOperationParameters.setClientId(paramPublicClientApplicationConfiguration.getClientId());
    localAcquireTokenSilentOperationParameters.setTokenCache(paramOAuth2TokenCache);
    localAcquireTokenSilentOperationParameters.setAuthority(localAuthority);
    localAcquireTokenSilentOperationParameters.setApplicationName(localContext.getPackageName());
    localAcquireTokenSilentOperationParameters.setApplicationVersion(getPackageVersion(localContext));
    localAcquireTokenSilentOperationParameters.setSdkVersion(PublicClientApplication.getSdkVersion());
    localAcquireTokenSilentOperationParameters.setForceRefresh(paramAcquireTokenSilentParameters.getForceRefresh());
    localAcquireTokenSilentOperationParameters.setRedirectUri(paramPublicClientApplicationConfiguration.getRedirectUri());
    localAcquireTokenSilentOperationParameters.setAccount(paramAcquireTokenSilentParameters.getAccountRecord());
    localAcquireTokenSilentOperationParameters.setAuthenticationScheme(AuthenticationSchemeFactory.createScheme(paramAcquireTokenSilentParameters.getAuthenticationScheme()));
    paramAcquireTokenSilentParameters = str;
    if ((localAcquireTokenSilentOperationParameters.getAuthority() instanceof AzureActiveDirectoryAuthority))
    {
      ((AzureActiveDirectoryAuthority)localAcquireTokenSilentOperationParameters.getAuthority()).setMultipleCloudsSupported(paramPublicClientApplicationConfiguration.getMultipleCloudsSupported().booleanValue());
      paramAcquireTokenSilentParameters = addClientCapabilitiesToClaimsRequest(localClaimsRequest, paramPublicClientApplicationConfiguration.getClientCapabilities());
      if (localClaimsRequest != null) {
        localAcquireTokenSilentOperationParameters.setForceRefresh(true);
      }
      paramAcquireTokenSilentParameters = ClaimsRequest.getJsonStringFromClaimsRequest(paramAcquireTokenSilentParameters);
    }
    localAcquireTokenSilentOperationParameters.setClaimsRequest(paramAcquireTokenSilentParameters);
    return localAcquireTokenSilentOperationParameters;
  }
  
  public static OperationParameters createOperationParameters(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, OAuth2TokenCache paramOAuth2TokenCache)
  {
    OperationParameters localOperationParameters = new OperationParameters();
    localOperationParameters.setAppContext(paramPublicClientApplicationConfiguration.getAppContext());
    localOperationParameters.setTokenCache(paramOAuth2TokenCache);
    localOperationParameters.setBrowserSafeList(paramPublicClientApplicationConfiguration.getBrowserSafeList());
    localOperationParameters.setIsSharedDevice(paramPublicClientApplicationConfiguration.getIsSharedDevice());
    localOperationParameters.setClientId(paramPublicClientApplicationConfiguration.getClientId());
    localOperationParameters.setRedirectUri(paramPublicClientApplicationConfiguration.getRedirectUri());
    localOperationParameters.setAuthority(paramPublicClientApplicationConfiguration.getDefaultAuthority());
    localOperationParameters.setApplicationName(paramPublicClientApplicationConfiguration.getAppContext().getPackageName());
    localOperationParameters.setApplicationVersion(getPackageVersion(paramPublicClientApplicationConfiguration.getAppContext()));
    localOperationParameters.setSdkVersion(PublicClientApplication.getSdkVersion());
    localOperationParameters.setRequiredBrokerProtocolVersion(paramPublicClientApplicationConfiguration.getRequiredBrokerProtocolVersion());
    return localOperationParameters;
  }
  
  public static String getPackageVersion(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      paramContext = getPackageManagergetPackageInfo0versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Authority getRequestAuthority(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    String str;
    if ((paramPublicClientApplicationConfiguration.getDefaultAuthority() instanceof AzureActiveDirectoryB2CAuthority)) {
      str = paramPublicClientApplicationConfiguration.getDefaultAuthority().getAuthorityURL().toString();
    } else {
      str = null;
    }
    if (str == null) {
      paramPublicClientApplicationConfiguration = paramPublicClientApplicationConfiguration.getDefaultAuthority();
    } else {
      paramPublicClientApplicationConfiguration = Authority.getAuthorityFromAuthorityUrl(str);
    }
    return paramPublicClientApplicationConfiguration;
  }
  
  public static String getUsername(IAccount paramIAccount)
  {
    if (paramIAccount.getClaims() != null)
    {
      paramIAccount = SchemaUtil.getDisplayableId(paramIAccount.getClaims());
    }
    else
    {
      Iterator localIterator = ((MultiTenantAccount)paramIAccount).getTenantProfiles().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramIAccount = (Map.Entry)localIterator.next();
        if (((ITenantProfile)paramIAccount.getValue()).getClaims() != null)
        {
          paramIAccount = SchemaUtil.getDisplayableId(((ITenantProfile)paramIAccount.getValue()).getClaims());
          if (!"Missing from the token response".equalsIgnoreCase(paramIAccount)) {
            return paramIAccount;
          }
        }
      }
      paramIAccount = null;
    }
    return paramIAccount;
  }
  
  public static boolean isAccountHomeTenant(Map<String, ?> paramMap, String paramString)
  {
    boolean bool;
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      bool = paramMap.get("tid").equals(paramString);
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void validateClaimsExistForTenant(String paramString, IClaimable paramIClaimable)
  {
    if ((paramIClaimable != null) && (paramIClaimable.getClaims() != null)) {
      return;
    }
    paramIClaimable = a.a("Attempting to authorize for tenant: ", paramString, " but no matching account was found.");
    paramString = new StringBuilder();
    paramString.append(TAG);
    paramString.append(":validateClaimsExistForTenant");
    Logger.warn(paramString.toString(), paramIClaimable);
    throw new MsalClientException(paramIClaimable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.OperationParametersAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */