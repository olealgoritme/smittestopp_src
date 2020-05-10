package com.microsoft.identity.common.internal.request;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authorities.Environment;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.internal.broker.BrokerRequest.Builder;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import com.microsoft.identity.common.internal.ui.browser.Browser;
import com.microsoft.identity.common.internal.ui.browser.BrowserDescriptor;
import com.microsoft.identity.common.internal.ui.browser.BrowserSelector;
import com.microsoft.identity.common.internal.util.QueryParamsAdapter;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import e.c.c.e;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MsalBrokerRequestAdapter
  implements IBrokerRequestAdapter
{
  public static final String TAG = "com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter";
  public static Gson sRequestAdapterGsonInstance;
  
  static
  {
    e locale = new e();
    locale.a(AbstractAuthenticationScheme.class, new AuthenticationSchemeTypeAdapter());
    sRequestAdapterGsonInstance = locale.a();
  }
  
  public static AbstractAuthenticationScheme getAuthenticationScheme(BrokerRequest paramBrokerRequest)
  {
    AbstractAuthenticationScheme localAbstractAuthenticationScheme = paramBrokerRequest.getAuthenticationScheme();
    paramBrokerRequest = localAbstractAuthenticationScheme;
    if (localAbstractAuthenticationScheme == null) {
      paramBrokerRequest = new BearerAuthenticationSchemeInternal();
    }
    return paramBrokerRequest;
  }
  
  public static List<BrowserDescriptor> getBrowserSafeListForBroker()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add("7fmduHKTdHHrlMvldlEqAIlSfii1tl35bxj1OXN5Ve8c4lU6URVu4xtSHc3BVZxS6WWJnxMDhIfQN0N0K2NDJg==");
    localArrayList.add(new BrowserDescriptor("com.android.chrome", localHashSet, null, null));
    return localArrayList;
  }
  
  private boolean getMultipleCloudsSupported(OperationParameters paramOperationParameters)
  {
    if ((paramOperationParameters.getAuthority() instanceof AzureActiveDirectoryAuthority)) {
      return ((AzureActiveDirectoryAuthority)paramOperationParameters.getAuthority()).getMultipleCloudsSupported();
    }
    return false;
  }
  
  private String getRedirectUri(OperationParameters paramOperationParameters)
  {
    if (TextUtils.isEmpty(paramOperationParameters.getRedirectUri())) {
      return BrokerValidator.getBrokerRedirectUri(paramOperationParameters.getAppContext(), paramOperationParameters.getApplicationName());
    }
    return paramOperationParameters.getRedirectUri();
  }
  
  private Set<String> getScopesAsSet(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashSet();
    }
    return new HashSet(Arrays.asList(paramString.split(" ")));
  }
  
  private boolean isCallingPackageIntune(String paramString)
  {
    String str = a.a(new StringBuilder(), TAG, ":isCallingPackageIntune");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Calling package name : ");
    localStringBuilder.append(paramString);
    Logger.info(str, localStringBuilder.toString());
    return "com.microsoft.intune".equalsIgnoreCase(paramString);
  }
  
  public BrokerAcquireTokenOperationParameters brokerInteractiveParametersFromActivity(Activity paramActivity)
  {
    Logger.info(TAG, "Constructing BrokerAcquireTokenOperationParameters from calling activity");
    BrokerAcquireTokenOperationParameters localBrokerAcquireTokenOperationParameters = new BrokerAcquireTokenOperationParameters();
    Object localObject = paramActivity.getIntent();
    BrokerRequest localBrokerRequest = (BrokerRequest)sRequestAdapterGsonInstance.a(((Intent)localObject).getStringExtra("broker_request_v2"), BrokerRequest.class);
    localBrokerAcquireTokenOperationParameters.setAuthenticationScheme(getAuthenticationScheme(localBrokerRequest));
    localBrokerAcquireTokenOperationParameters.setActivity(paramActivity);
    localBrokerAcquireTokenOperationParameters.setAppContext(paramActivity.getApplicationContext());
    localBrokerAcquireTokenOperationParameters.setSdkType(SdkType.MSAL);
    localBrokerAcquireTokenOperationParameters.setCallerUId(((Intent)localObject).getIntExtra("caller.info.uid", 0));
    localBrokerAcquireTokenOperationParameters.setCallerPackageName(localBrokerRequest.getApplicationName());
    localBrokerAcquireTokenOperationParameters.setCallerAppVersion(localBrokerRequest.getApplicationVersion());
    paramActivity = new ArrayList();
    if (!TextUtils.isEmpty(localBrokerRequest.getExtraQueryStringParameter()))
    {
      paramActivity = QueryParamsAdapter._fromJson(localBrokerRequest.getExtraQueryStringParameter());
      localBrokerAcquireTokenOperationParameters.setExtraQueryStringParameters(paramActivity);
    }
    paramActivity = AdalBrokerRequestAdapter.getRequestAuthorityWithExtraQP(localBrokerRequest.getAuthority(), paramActivity);
    if (paramActivity != null)
    {
      paramActivity.setMultipleCloudsSupported(localBrokerRequest.getMultipleCloudsSupported());
      localBrokerAcquireTokenOperationParameters.setAuthority(paramActivity);
    }
    localBrokerAcquireTokenOperationParameters.setScopes(getScopesAsSet(localBrokerRequest.getScope()));
    localBrokerAcquireTokenOperationParameters.setClientId(localBrokerRequest.getClientId());
    localBrokerAcquireTokenOperationParameters.setRedirectUri(localBrokerRequest.getRedirect());
    localBrokerAcquireTokenOperationParameters.setLoginHint(localBrokerRequest.getUserName());
    localObject = localBrokerRequest.getCorrelationId();
    paramActivity = (Activity)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramActivity = UUID.randomUUID().toString();
    }
    localBrokerAcquireTokenOperationParameters.setCorrelationId(paramActivity);
    localBrokerAcquireTokenOperationParameters.setClaimsRequest(localBrokerRequest.getClaims());
    if (localBrokerRequest.getPrompt() != null) {
      paramActivity = OpenIdConnectPromptParameter.valueOf(localBrokerRequest.getPrompt());
    } else {
      paramActivity = OpenIdConnectPromptParameter.NONE;
    }
    localBrokerAcquireTokenOperationParameters.setOpenIdConnectPromptParameter(paramActivity);
    paramActivity = TAG;
    localObject = a.a("Authorization agent passed in by MSAL: ");
    ((StringBuilder)localObject).append(localBrokerRequest.getAuthorizationAgent());
    Logger.info(paramActivity, ((StringBuilder)localObject).toString());
    if (localBrokerRequest.getAuthorizationAgent() != null)
    {
      paramActivity = localBrokerRequest.getAuthorizationAgent();
      localObject = AuthorizationAgent.BROWSER;
      if ((paramActivity.equalsIgnoreCase("BROWSER")) && (isCallingPackageIntune(localBrokerAcquireTokenOperationParameters.getCallerPackageName())))
      {
        Logger.info(TAG, "Setting Authorization Agent to Browser for Intune app");
        localBrokerAcquireTokenOperationParameters.setAuthorizationAgent(AuthorizationAgent.BROWSER);
        localBrokerAcquireTokenOperationParameters.setBrokerBrowserSupportEnabled(true);
        localBrokerAcquireTokenOperationParameters.setBrowserSafeList(getBrowserSafeListForBroker());
        break label370;
      }
    }
    localBrokerAcquireTokenOperationParameters.setAuthorizationAgent(AuthorizationAgent.WEBVIEW);
    label370:
    if (!TextUtils.isEmpty(localBrokerRequest.getEnvironment())) {
      AzureActiveDirectory.setEnvironment(Environment.valueOf(localBrokerRequest.getEnvironment()));
    }
    return localBrokerAcquireTokenOperationParameters;
  }
  
  public BrokerRequest brokerRequestFromAcquireTokenParameters(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    Logger.info(TAG, "Constructing result bundle from AcquireTokenOperationParameters.");
    BrokerRequest.Builder localBuilder = new BrokerRequest.Builder().authority(paramAcquireTokenOperationParameters.getAuthority().getAuthorityURL().toString()).scope(TextUtils.join(" ", paramAcquireTokenOperationParameters.getScopes())).redirect(getRedirectUri(paramAcquireTokenOperationParameters)).clientId(paramAcquireTokenOperationParameters.getClientId()).username(paramAcquireTokenOperationParameters.getLoginHint());
    Object localObject;
    if (paramAcquireTokenOperationParameters.getExtraQueryStringParameters() != null) {
      localObject = QueryParamsAdapter._toJson(paramAcquireTokenOperationParameters.getExtraQueryStringParameters());
    } else {
      localObject = null;
    }
    localBuilder = localBuilder.extraQueryStringParameter((String)localObject).prompt(paramAcquireTokenOperationParameters.getOpenIdConnectPromptParameter().name()).claims(paramAcquireTokenOperationParameters.getClaimsRequestJson()).forceRefresh(paramAcquireTokenOperationParameters.getForceRefresh()).correlationId((String)DiagnosticContext.getRequestContext().get("correlation_id")).applicationName(paramAcquireTokenOperationParameters.getApplicationName()).applicationVersion(paramAcquireTokenOperationParameters.getApplicationVersion()).msalVersion(paramAcquireTokenOperationParameters.getSdkVersion()).environment(AzureActiveDirectory.getEnvironment().name()).multipleCloudsSupported(getMultipleCloudsSupported(paramAcquireTokenOperationParameters));
    if (paramAcquireTokenOperationParameters.isBrokerBrowserSupportEnabled())
    {
      localObject = AuthorizationAgent.BROWSER;
      localObject = "BROWSER";
    }
    else
    {
      localObject = AuthorizationAgent.WEBVIEW;
      localObject = "WEBVIEW";
    }
    return localBuilder.authorizationAgent((String)localObject).authenticationScheme(paramAcquireTokenOperationParameters.getAuthenticationScheme()).build();
  }
  
  public BrokerRequest brokerRequestFromSilentOperationParameters(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    Logger.info(TAG, "Constructing result bundle from AcquireTokenSilentOperationParameters.");
    return new BrokerRequest.Builder().authority(paramAcquireTokenSilentOperationParameters.getAuthority().getAuthorityURL().toString()).scope(TextUtils.join(" ", paramAcquireTokenSilentOperationParameters.getScopes())).redirect(getRedirectUri(paramAcquireTokenSilentOperationParameters)).clientId(paramAcquireTokenSilentOperationParameters.getClientId()).homeAccountId(paramAcquireTokenSilentOperationParameters.getAccount().getHomeAccountId()).localAccountId(paramAcquireTokenSilentOperationParameters.getAccount().getLocalAccountId()).username(paramAcquireTokenSilentOperationParameters.getAccount().getUsername()).claims(paramAcquireTokenSilentOperationParameters.getClaimsRequestJson()).forceRefresh(paramAcquireTokenSilentOperationParameters.getForceRefresh()).correlationId((String)DiagnosticContext.getRequestContext().get("correlation_id")).applicationName(paramAcquireTokenSilentOperationParameters.getApplicationName()).applicationVersion(paramAcquireTokenSilentOperationParameters.getApplicationVersion()).msalVersion(paramAcquireTokenSilentOperationParameters.getSdkVersion()).environment(AzureActiveDirectory.getEnvironment().name()).multipleCloudsSupported(getMultipleCloudsSupported(paramAcquireTokenSilentOperationParameters)).authenticationScheme(paramAcquireTokenSilentOperationParameters.getAuthenticationScheme()).build();
  }
  
  public BrokerAcquireTokenSilentOperationParameters brokerSilentParametersFromBundle(Bundle paramBundle, Context paramContext, Account paramAccount)
  {
    Logger.info(TAG, "Constructing BrokerAcquireTokenSilentOperationParameters from result bundle");
    BrokerRequest localBrokerRequest = (BrokerRequest)sRequestAdapterGsonInstance.a(paramBundle.getString("broker_request_v2"), BrokerRequest.class);
    BrokerAcquireTokenSilentOperationParameters localBrokerAcquireTokenSilentOperationParameters = new BrokerAcquireTokenSilentOperationParameters();
    localBrokerAcquireTokenSilentOperationParameters.setAuthenticationScheme(getAuthenticationScheme(localBrokerRequest));
    localBrokerAcquireTokenSilentOperationParameters.setAppContext(paramContext);
    localBrokerAcquireTokenSilentOperationParameters.setAccountManagerAccount(paramAccount);
    localBrokerAcquireTokenSilentOperationParameters.setSdkType(SdkType.MSAL);
    localBrokerAcquireTokenSilentOperationParameters.setCallerUId(paramBundle.getInt("caller.info.uid"));
    localBrokerAcquireTokenSilentOperationParameters.setCallerPackageName(localBrokerRequest.getApplicationName());
    localBrokerAcquireTokenSilentOperationParameters.setCallerAppVersion(localBrokerRequest.getApplicationVersion());
    paramContext = Authority.getAuthorityFromAuthorityUrl(localBrokerRequest.getAuthority());
    if ((paramContext instanceof AzureActiveDirectoryAuthority)) {
      ((AzureActiveDirectoryAuthority)paramContext).setMultipleCloudsSupported(localBrokerRequest.getMultipleCloudsSupported());
    }
    localBrokerAcquireTokenSilentOperationParameters.setAuthority(paramContext);
    paramContext = paramBundle.getString(localBrokerRequest.getCorrelationId());
    paramBundle = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      paramBundle = UUID.randomUUID().toString();
    }
    localBrokerAcquireTokenSilentOperationParameters.setCorrelationId(paramBundle);
    localBrokerAcquireTokenSilentOperationParameters.setScopes(getScopesAsSet(localBrokerRequest.getScope()));
    localBrokerAcquireTokenSilentOperationParameters.setRedirectUri(localBrokerRequest.getRedirect());
    localBrokerAcquireTokenSilentOperationParameters.setClientId(localBrokerRequest.getClientId());
    localBrokerAcquireTokenSilentOperationParameters.setForceRefresh(localBrokerRequest.getForceRefresh());
    localBrokerAcquireTokenSilentOperationParameters.setClaimsRequest(localBrokerRequest.getClaims());
    localBrokerAcquireTokenSilentOperationParameters.setLoginHint(localBrokerRequest.getUserName());
    localBrokerAcquireTokenSilentOperationParameters.setHomeAccountId(localBrokerRequest.getHomeAccountId());
    localBrokerAcquireTokenSilentOperationParameters.setLocalAccountId(localBrokerRequest.getLocalAccountId());
    if (!TextUtils.isEmpty(localBrokerRequest.getExtraQueryStringParameter())) {
      localBrokerAcquireTokenSilentOperationParameters.setExtraQueryStringParameters(QueryParamsAdapter._fromJson(localBrokerRequest.getExtraQueryStringParameter()));
    }
    if (!TextUtils.isEmpty(localBrokerRequest.getEnvironment())) {
      AzureActiveDirectory.setEnvironment(Environment.valueOf(localBrokerRequest.getEnvironment()));
    }
    return localBrokerAcquireTokenSilentOperationParameters;
  }
  
  public Bundle getRequestBundleForAcquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    Object localObject = new MsalBrokerRequestAdapter();
    Bundle localBundle = new Bundle();
    localObject = ((MsalBrokerRequestAdapter)localObject).brokerRequestFromSilentOperationParameters(paramAcquireTokenSilentOperationParameters);
    localBundle.putString("broker_request_v2", sRequestAdapterGsonInstance.a(localObject, BrokerRequest.class));
    localBundle.putInt("caller.info.uid", getAppContextgetApplicationInfouid);
    return localBundle;
  }
  
  public Bundle getRequestBundleForGetAccounts(OperationParameters paramOperationParameters)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("account.clientid.key", paramOperationParameters.getClientId());
    localBundle.putString("account.redirect", paramOperationParameters.getRedirectUri());
    return localBundle;
  }
  
  public Bundle getRequestBundleForHello(OperationParameters paramOperationParameters)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("broker.protocol.version.name", "4.0");
    if (!StringUtil.isEmpty(paramOperationParameters.getRequiredBrokerProtocolVersion())) {
      localBundle.putString("required.broker.protocol.version.name", paramOperationParameters.getRequiredBrokerProtocolVersion());
    }
    return localBundle;
  }
  
  public Bundle getRequestBundleForRemoveAccount(OperationParameters paramOperationParameters)
  {
    Bundle localBundle = new Bundle();
    if (paramOperationParameters.getAccount() != null)
    {
      localBundle.putString("account.clientid.key", paramOperationParameters.getClientId());
      localBundle.putString("environment", paramOperationParameters.getAccount().getEnvironment());
      localBundle.putString("account.home.account.id", paramOperationParameters.getAccount().getHomeAccountId());
    }
    return localBundle;
  }
  
  public Bundle getRequestBundleForRemoveAccountFromSharedDevice(OperationParameters paramOperationParameters)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("default.browser.package.name", BrowserSelector.select(paramOperationParameters.getAppContext(), paramOperationParameters.getBrowserSafeList()).getPackageName());
    }
    catch (ClientException paramOperationParameters)
    {
      Logger.error(TAG, paramOperationParameters.getErrorCode(), paramOperationParameters);
    }
    return localBundle;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */