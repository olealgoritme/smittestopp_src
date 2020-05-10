package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.configuration.HttpConfiguration;
import com.microsoft.identity.client.configuration.LoggerConfiguration;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.OperationParametersAdapter;
import com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.CommandDispatcher;
import com.microsoft.identity.common.internal.controllers.GetDeviceModeCommand;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.internal.result.ResultFuture;
import com.microsoft.identity.common.internal.telemetry.Telemetry.Builder;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PublicClientApplication
  implements IPublicClientApplication, ITokenShare
{
  public static final String ACCESS_NETWORK_STATE_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
  public static final String INTERNET_PERMISSION = "android.permission.INTERNET";
  public static final String TAG = "PublicClientApplication";
  public static final String TSL_MSG_FAILED_TO_SAVE = "Failed to save FRT - see getCause() for additional Exception info";
  public static final String TSM_MSG_FAILED_TO_RETRIEVE = "Failed to retrieve FRT - see getCause() for additional Exception info";
  public static final ExecutorService sBackgroundExecutor = ;
  public PublicClientApplication.AccountMatcher homeAccountMatcher = new PublicClientApplication.10(this);
  public PublicClientApplication.AccountMatcher localAccountMatcher = new PublicClientApplication.11(this);
  public PublicClientApplicationConfiguration mPublicClientConfiguration;
  public TokenShareUtility mTokenShareUtility;
  public PublicClientApplication.AccountMatcher usernameMatcher = new PublicClientApplication.12(this);
  
  public PublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    mPublicClientConfiguration = paramPublicClientApplicationConfiguration;
    initializeApplication();
  }
  
  private void checkInternetPermission()
  {
    PackageManager localPackageManager = mPublicClientConfiguration.getAppContext().getPackageManager();
    if ((localPackageManager.checkPermission("android.permission.INTERNET", mPublicClientConfiguration.getAppContext().getPackageName()) == 0) && (localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", mPublicClientConfiguration.getAppContext().getPackageName()) == 0)) {
      return;
    }
    throw new IllegalStateException("android.permission.Internet or android.permission.ACCESS_NETWORK_STATE is missing");
  }
  
  public static IPublicClientApplication create(Context paramContext, int paramInt)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    return create(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt));
  }
  
  public static IPublicClientApplication create(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    MsalUtils.validateNonNullArgument(paramPublicClientApplicationConfiguration, "configuration");
    MsalUtils.throwOnMainThread("createPublicClientApplication");
    ResultFuture localResultFuture = new ResultFuture();
    create(paramPublicClientApplicationConfiguration, null, null, null, new PublicClientApplication.1(localResultFuture));
    paramPublicClientApplicationConfiguration = (AsyncResult)localResultFuture.get();
    if (paramPublicClientApplicationConfiguration.getSuccess()) {
      return (IPublicClientApplication)paramPublicClientApplicationConfiguration.getResult();
    }
    throw paramPublicClientApplicationConfiguration.getException();
  }
  
  public static void create(Context paramContext, int paramInt, IPublicClientApplication.ApplicationCreatedListener paramApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramApplicationCreatedListener, "listener");
    create(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt), null, null, null, paramApplicationCreatedListener);
  }
  
  public static void create(Context paramContext, File paramFile, IPublicClientApplication.ApplicationCreatedListener paramApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramApplicationCreatedListener, "listener");
    create(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramFile), null, null, null, paramApplicationCreatedListener);
  }
  
  public static void create(Context paramContext, String paramString1, String paramString2, String paramString3, IPublicClientApplication.ApplicationCreatedListener paramApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramString1, "client_id");
    MsalUtils.validateNonNullArgument(paramString3, "redirect_uri");
    MsalUtils.validateNonNullArgument(paramApplicationCreatedListener, "listener");
    create(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext), paramString1, paramString2, paramString3, paramApplicationCreatedListener);
  }
  
  public static void create(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, String paramString1, String paramString2, String paramString3, IPublicClientApplication.ApplicationCreatedListener paramApplicationCreatedListener)
  {
    if (paramString1 != null) {
      paramPublicClientApplicationConfiguration.setClientId(paramString1);
    }
    if (paramString2 != null)
    {
      paramPublicClientApplicationConfiguration.getAuthorities().clear();
      paramString1 = Authority.getAuthorityFromAuthorityUrl(paramString2);
      paramString1.setDefault(Boolean.valueOf(true));
      paramPublicClientApplicationConfiguration.getAuthorities().add(paramString1);
    }
    if (paramString3 != null) {
      paramPublicClientApplicationConfiguration.setRedirectUri(paramString3);
    }
    paramString1 = OperationParametersAdapter.createOperationParameters(paramPublicClientApplicationConfiguration, paramPublicClientApplicationConfiguration.getOAuth2TokenCache());
    try
    {
      paramString2 = MSALControllerFactory.getDefaultController(paramPublicClientApplicationConfiguration.getAppContext(), paramString1.getAuthority(), paramPublicClientApplicationConfiguration);
      CommandDispatcher.submitSilent(new GetDeviceModeCommand(paramString1, paramString2, new PublicClientApplication.2(paramApplicationCreatedListener, paramPublicClientApplicationConfiguration)));
      return;
    }
    catch (MsalClientException paramPublicClientApplicationConfiguration)
    {
      paramApplicationCreatedListener.onError(paramPublicClientApplicationConfiguration);
    }
  }
  
  public static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(Context paramContext, int paramInt)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    return createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt));
  }
  
  public static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(Context paramContext, File paramFile)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramFile, "configFile");
    return createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramFile));
  }
  
  public static IMultipleAccountPublicClientApplication createMultipleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    if (paramPublicClientApplicationConfiguration.getAccountMode() == AccountMode.MULTIPLE)
    {
      IPublicClientApplication localIPublicClientApplication = create(paramPublicClientApplicationConfiguration);
      if ((localIPublicClientApplication instanceof IMultipleAccountPublicClientApplication)) {
        return (IMultipleAccountPublicClientApplication)localIPublicClientApplication;
      }
      if ((paramPublicClientApplicationConfiguration.getAccountMode() == AccountMode.MULTIPLE) && (localIPublicClientApplication.isSharedDevice())) {
        throw new MsalClientException("multiple_account_pca_init_fail_on_shared_device", "AccountMode in configuration is set to multiple. However, the device is marked as shared (which requires single account mode).");
      }
      throw new MsalClientException("multiple_account_pca_init_fail_unknown_reason", "Multiple account PublicClientApplication could not be created for unknown reasons");
    }
    throw new MsalClientException("multiple_account_pca_init_fail_account_mode", "AccountMode in configuration is not set to multiple. Cannot initialize multiple account PublicClientApplication.");
  }
  
  public static void createMultipleAccountPublicClientApplication(Context paramContext, int paramInt, IPublicClientApplication.IMultipleAccountApplicationCreatedListener paramIMultipleAccountApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramIMultipleAccountApplicationCreatedListener, "listener");
    createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt), paramIMultipleAccountApplicationCreatedListener);
  }
  
  public static void createMultipleAccountPublicClientApplication(Context paramContext, File paramFile, IPublicClientApplication.IMultipleAccountApplicationCreatedListener paramIMultipleAccountApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramIMultipleAccountApplicationCreatedListener, "listener");
    createMultipleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramFile), paramIMultipleAccountApplicationCreatedListener);
  }
  
  public static void createMultipleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, IPublicClientApplication.IMultipleAccountApplicationCreatedListener paramIMultipleAccountApplicationCreatedListener)
  {
    create(paramPublicClientApplicationConfiguration, null, null, null, new PublicClientApplication.3(paramIMultipleAccountApplicationCreatedListener));
  }
  
  public static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(Context paramContext, int paramInt)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    return createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt));
  }
  
  public static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(Context paramContext, File paramFile)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    return createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramFile));
  }
  
  public static ISingleAccountPublicClientApplication createSingleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    IPublicClientApplication localIPublicClientApplication = create(paramPublicClientApplicationConfiguration);
    if ((localIPublicClientApplication instanceof ISingleAccountPublicClientApplication)) {
      return (ISingleAccountPublicClientApplication)localIPublicClientApplication;
    }
    if (paramPublicClientApplicationConfiguration.getAccountMode() != AccountMode.SINGLE) {
      throw new MsalClientException("single_account_pca_init_fail_account_mode", "AccountMode in configuration is not set to single. Cannot initialize single account PublicClientApplication.");
    }
    throw new MsalClientException("single_account_pca_init_fail_unknown_reason", "A single account public client application could not be created for unknown reasons.");
  }
  
  public static void createSingleAccountPublicClientApplication(Context paramContext, int paramInt, IPublicClientApplication.ISingleAccountApplicationCreatedListener paramISingleAccountApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramISingleAccountApplicationCreatedListener, "listener");
    createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramInt), paramISingleAccountApplicationCreatedListener);
  }
  
  public static void createSingleAccountPublicClientApplication(Context paramContext, File paramFile, IPublicClientApplication.ISingleAccountApplicationCreatedListener paramISingleAccountApplicationCreatedListener)
  {
    MsalUtils.validateNonNullArgument(paramContext, "context");
    MsalUtils.validateNonNullArgument(paramFile, "config_file");
    MsalUtils.validateNonNullArgument(paramISingleAccountApplicationCreatedListener, "listener");
    createSingleAccountPublicClientApplication(PublicClientApplicationConfigurationFactory.initializeConfiguration(paramContext, paramFile), paramISingleAccountApplicationCreatedListener);
  }
  
  public static void createSingleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, IPublicClientApplication.ISingleAccountApplicationCreatedListener paramISingleAccountApplicationCreatedListener)
  {
    create(paramPublicClientApplicationConfiguration, null, null, null, new PublicClientApplication.4(paramISingleAccountApplicationCreatedListener));
  }
  
  public static CommandCallback<List<ICacheRecord>, BaseException> getLoadAccountsCallback(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback)
  {
    return new PublicClientApplication.8(paramLoadAccountsCallback);
  }
  
  private OAuth2TokenCache<?, ?, ?> getOAuth2TokenCache()
  {
    return MsalOAuth2TokenCache.create(mPublicClientConfiguration.getAppContext());
  }
  
  public static String getSdkVersion()
  {
    return "1.4.0";
  }
  
  private void initializeApplication()
  {
    Object localObject = mPublicClientConfiguration.getAppContext();
    EstsTelemetry.getInstance().setupLastRequestTelemetryCache((Context)localObject);
    setupTelemetry((Context)localObject, mPublicClientConfiguration);
    AzureActiveDirectory.setEnvironment(mPublicClientConfiguration.getEnvironment());
    Authority.addKnownAuthorities(mPublicClientConfiguration.getAuthorities());
    initializeHttpSettings(mPublicClientConfiguration.getHttpConfiguration());
    initializeLoggerSettings(mPublicClientConfiguration.getLoggerConfiguration());
    initializeTokenSharingLibrary();
    mPublicClientConfiguration.checkIntentFilterAddedToAppManifestForBrokerFlow();
    checkInternetPermission();
    HttpCache.initialize(((Context)localObject).getCacheDir());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":initializeApplication");
    com.microsoft.identity.common.internal.logging.Logger.info(((StringBuilder)localObject).toString(), "Create new public client application.");
  }
  
  private void initializeHttpSettings(HttpConfiguration paramHttpConfiguration)
  {
    if (paramHttpConfiguration == null)
    {
      paramHttpConfiguration = new StringBuilder();
      paramHttpConfiguration.append(TAG);
      paramHttpConfiguration.append(":initializeHttpSettings");
      com.microsoft.identity.common.internal.logging.Logger.info(paramHttpConfiguration.toString(), "HttpConfiguration not provided - using defaults.");
      return;
    }
    int i = paramHttpConfiguration.getReadTimeout();
    int j = paramHttpConfiguration.getConnectTimeout();
    if (i >= 0) {
      com.microsoft.identity.common.internal.net.HttpRequest.READ_TIMEOUT = i;
    }
    if (j >= 0) {
      com.microsoft.identity.common.internal.net.HttpRequest.CONNECT_TIMEOUT = j;
    }
  }
  
  private void initializeLoggerSettings(LoggerConfiguration paramLoggerConfiguration)
  {
    if (paramLoggerConfiguration != null)
    {
      Logger.LogLevel localLogLevel = paramLoggerConfiguration.getLogLevel();
      boolean bool1 = paramLoggerConfiguration.isPiiEnabled();
      boolean bool2 = paramLoggerConfiguration.isLogcatEnabled();
      paramLoggerConfiguration = Logger.getInstance();
      if (localLogLevel != null) {
        paramLoggerConfiguration.setLogLevel(localLogLevel);
      }
      paramLoggerConfiguration.setEnablePII(bool1);
      paramLoggerConfiguration.setEnableLogcatLog(bool2);
    }
  }
  
  private void initializeTokenSharingLibrary()
  {
    if ((mPublicClientConfiguration.getOAuth2TokenCache() instanceof MsalOAuth2TokenCache))
    {
      mTokenShareUtility = new TokenShareUtility(mPublicClientConfiguration.getClientId(), mPublicClientConfiguration.getRedirectUri(), mPublicClientConfiguration.getDefaultAuthority().getAuthorityURL().toString(), (MsalOAuth2TokenCache)mPublicClientConfiguration.getOAuth2TokenCache());
      return;
    }
    throw new IllegalStateException("TSL support mandates use of the MsalOAuth2TokenCache");
  }
  
  private AccountRecord selectAccountRecordForTokenRequest(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration, TokenParameters paramTokenParameters)
  {
    if (TextUtils.isEmpty(paramTokenParameters.getAuthority())) {
      paramTokenParameters.setAuthority(paramPublicClientApplicationConfiguration.getDefaultAuthority().getAuthorityUri().toString());
    }
    Object localObject1 = paramTokenParameters.getAccount();
    paramPublicClientApplicationConfiguration = null;
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = paramTokenParameters.getAccount();
    MultiTenantAccount localMultiTenantAccount = (MultiTenantAccount)localObject2;
    Authority localAuthority = Authority.getAuthorityFromAuthorityUrl(paramTokenParameters.getAuthority());
    if ((localAuthority instanceof AzureActiveDirectoryB2CAuthority)) {
      return AccountAdapter.getAccountInternal(mPublicClientConfiguration.getClientId(), mPublicClientConfiguration.getOAuth2TokenCache(), localMultiTenantAccount.getHomeAccountId(), localMultiTenantAccount.getTenantId());
    }
    if ((localAuthority instanceof AzureActiveDirectoryAuthority))
    {
      AzureActiveDirectoryAuthority localAzureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority)localAuthority;
      String str = localAzureActiveDirectoryAuthority.getAudience().getTenantId();
      AccountRecord localAccountRecord = new AccountRecord();
      localAccountRecord.setEnvironment(localMultiTenantAccount.getEnvironment());
      localAccountRecord.setHomeAccountId(localMultiTenantAccount.getHomeAccountId());
      localObject1 = str;
      if (!StringUtil.isUuid(str))
      {
        localObject1 = str;
        if (!AzureActiveDirectoryAudience.isHomeTenantAlias(str)) {
          localObject1 = localAzureActiveDirectoryAuthority.getAudience().getTenantUuidForAlias(localAuthority.getAuthorityURL().toString());
        }
      }
      if ((!AzureActiveDirectoryAudience.isHomeTenantAlias((String)localObject1)) && (!OperationParametersAdapter.isAccountHomeTenant(localMultiTenantAccount.getClaims(), (String)localObject1))) {
        paramPublicClientApplicationConfiguration = (IAccount)localMultiTenantAccount.getTenantProfiles().get(localObject1);
      } else if (localMultiTenantAccount.getClaims() != null) {
        paramPublicClientApplicationConfiguration = localMultiTenantAccount;
      }
      if ((paramPublicClientApplicationConfiguration == null) && ((paramTokenParameters instanceof AcquireTokenSilentParameters))) {
        if (((IClaimable)localObject2).getClaims() != null)
        {
          paramPublicClientApplicationConfiguration = (PublicClientApplicationConfiguration)localObject2;
        }
        else
        {
          localObject2 = localMultiTenantAccount.getTenantProfiles().values().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramTokenParameters = (ITenantProfile)((Iterator)localObject2).next();
            if (paramTokenParameters.getClaims() != null) {
              paramPublicClientApplicationConfiguration = paramTokenParameters;
            }
          }
        }
      }
      if (paramPublicClientApplicationConfiguration != null)
      {
        localAccountRecord.setLocalAccountId(paramPublicClientApplicationConfiguration.getId());
        localAccountRecord.setUsername(paramPublicClientApplicationConfiguration.getUsername());
        return localAccountRecord;
      }
      paramTokenParameters = TAG;
      paramPublicClientApplicationConfiguration = new StringBuilder();
      paramPublicClientApplicationConfiguration.append("No account record found for IAccount with request tenantId: ");
      paramPublicClientApplicationConfiguration.append((String)localObject1);
      com.microsoft.identity.common.internal.logging.Logger.warnPII(paramTokenParameters, paramPublicClientApplicationConfiguration.toString());
      throw new ClientException("no_account_found", "No account record found for IAccount");
    }
    paramPublicClientApplicationConfiguration = a.a("Unsupported Authority type: ");
    paramPublicClientApplicationConfiguration.append(localAuthority.getClass().getSimpleName());
    throw new UnsupportedOperationException(paramPublicClientApplicationConfiguration.toString());
  }
  
  private void setupTelemetry(Context paramContext, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    if (paramPublicClientApplicationConfiguration.getTelemetryConfiguration() != null) {
      com.microsoft.identity.common.internal.logging.Logger.verbose(TAG, "Telemetry configuration is set. Telemetry is enabled.");
    } else {
      com.microsoft.identity.common.internal.logging.Logger.verbose(TAG, "Telemetry configuration is null. Telemetry is disabled.");
    }
    new Telemetry.Builder().withContext(paramContext).defaultConfiguration(paramPublicClientApplicationConfiguration.getTelemetryConfiguration()).build();
  }
  
  private void validateBrokerNotInUse()
  {
    if (!MSALControllerFactory.brokerEligible(mPublicClientConfiguration.getAppContext(), mPublicClientConfiguration.getDefaultAuthority(), mPublicClientConfiguration)) {
      return;
    }
    throw new MsalClientException("Cannot perform this action - broker is enabled.");
  }
  
  public void acquireToken(Activity paramActivity, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback)
  {
    acquireTokenInternal(buildAcquireTokenParameters(paramActivity, null, paramArrayOfString, null, null, null, null, null, paramAuthenticationCallback, null, null), "122");
  }
  
  public void acquireToken(AcquireTokenParameters paramAcquireTokenParameters)
  {
    acquireTokenInternal(paramAcquireTokenParameters, "121");
  }
  
  public void acquireTokenInternal(AcquireTokenParameters paramAcquireTokenParameters, String paramString)
  {
    sBackgroundExecutor.submit(new PublicClientApplication.5(this, paramAcquireTokenParameters, paramString));
  }
  
  public IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    return acquireTokenSilentInternal(paramAcquireTokenSilentParameters, "21");
  }
  
  public void acquireTokenSilentAsync(AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    acquireTokenSilentAsyncInternal(paramAcquireTokenSilentParameters, "22");
  }
  
  public void acquireTokenSilentAsyncInternal(AcquireTokenSilentParameters paramAcquireTokenSilentParameters, String paramString)
  {
    sBackgroundExecutor.submit(new PublicClientApplication.6(this, paramAcquireTokenSilentParameters, paramString));
  }
  
  public IAuthenticationResult acquireTokenSilentInternal(AcquireTokenSilentParameters paramAcquireTokenSilentParameters, String paramString)
  {
    if (paramAcquireTokenSilentParameters.getCallback() == null)
    {
      ResultFuture localResultFuture = new ResultFuture();
      paramAcquireTokenSilentParameters.setCallback(new PublicClientApplication.7(this, localResultFuture));
      acquireTokenSilentAsyncInternal(paramAcquireTokenSilentParameters, paramString);
      paramAcquireTokenSilentParameters = (AsyncResult)localResultFuture.get();
      if (paramAcquireTokenSilentParameters.getSuccess()) {
        return (IAuthenticationResult)paramAcquireTokenSilentParameters.getResult();
      }
      throw paramAcquireTokenSilentParameters.getException();
    }
    throw new IllegalArgumentException("Do not provide callback for synchronous methods");
  }
  
  public IAuthenticationResult acquireTokenSilentSyncInternal(String[] paramArrayOfString, String paramString1, IAccount paramIAccount, boolean paramBoolean, String paramString2)
  {
    MsalUtils.throwOnMainThread("acquireTokenSilent");
    ResultFuture localResultFuture = new ResultFuture();
    acquireTokenSilentAsyncInternal(buildAcquireTokenSilentParameters(paramArrayOfString, paramIAccount, paramString1, paramBoolean, null, new PublicClientApplication.13(this, localResultFuture)), paramString2);
    paramArrayOfString = (AsyncResult)localResultFuture.get();
    if (paramArrayOfString.getSuccess()) {
      return (IAuthenticationResult)paramArrayOfString.getResult();
    }
    throw paramArrayOfString.getException();
  }
  
  public AcquireTokenParameters buildAcquireTokenParameters(Activity paramActivity, Fragment paramFragment, String[] paramArrayOfString1, IAccount paramIAccount, Prompt paramPrompt, List<Pair<String, String>> paramList, String[] paramArrayOfString2, String paramString1, AuthenticationCallback paramAuthenticationCallback, String paramString2, ClaimsRequest paramClaimsRequest)
  {
    MsalUtils.validateNonNullArgument(paramActivity, "activity");
    MsalUtils.validateNonNullArgument(paramArrayOfString1, "scopes");
    MsalUtils.validateNonNullArgument(paramAuthenticationCallback, "callback");
    paramFragment = ((AcquireTokenParameters.Builder)((AcquireTokenParameters.Builder)new AcquireTokenParameters.Builder().startAuthorizationFromActivity(paramActivity).withFragment(paramFragment).forAccount(paramIAccount)).withScopes(Arrays.asList(paramArrayOfString1))).withPrompt(paramPrompt).withAuthorizationQueryStringParameters(paramList);
    paramActivity = paramArrayOfString2;
    if (paramArrayOfString2 == null) {
      paramActivity = new String[0];
    }
    return ((AcquireTokenParameters.Builder)((AcquireTokenParameters.Builder)paramFragment.withOtherScopesToAuthorize(Arrays.asList(paramActivity)).fromAuthority(paramString1)).withCallback(paramAuthenticationCallback).withLoginHint(paramString2).withClaims(paramClaimsRequest)).build();
  }
  
  public AcquireTokenSilentParameters buildAcquireTokenSilentParameters(String[] paramArrayOfString, IAccount paramIAccount, String paramString, boolean paramBoolean, ClaimsRequest paramClaimsRequest, SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    MsalUtils.validateNonNullArgument(paramIAccount, "account");
    MsalUtils.validateNonNullArgument(paramSilentAuthenticationCallback, "callback");
    return ((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)new AcquireTokenSilentParameters.Builder().withScopes(Arrays.asList(paramArrayOfString))).forAccount(paramIAccount)).fromAuthority(paramString)).forceRefresh(paramBoolean).withClaims(paramClaimsRequest)).withCallback(paramSilentAuthenticationCallback).build();
  }
  
  public CommandCallback getCommandCallback(SilentAuthenticationCallback paramSilentAuthenticationCallback, TokenParameters paramTokenParameters)
  {
    return new PublicClientApplication.9(this, paramTokenParameters, paramSilentAuthenticationCallback);
  }
  
  public PublicClientApplicationConfiguration getConfiguration()
  {
    return mPublicClientConfiguration;
  }
  
  public String getMsaFamilyRefreshToken(String paramString)
  {
    MsalUtils.validateNonNullArgument(paramString, "identifier");
    validateBrokerNotInUse();
    try
    {
      paramString = mTokenShareUtility.getMsaFamilyRefreshToken(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new MsalClientException("token_cache_item_not_found", "Failed to retrieve FRT - see getCause() for additional Exception info", paramString);
    }
  }
  
  public String getOrgIdFamilyRefreshToken(String paramString)
  {
    MsalUtils.validateNonNullArgument(paramString, "identifier");
    validateBrokerNotInUse();
    try
    {
      paramString = mTokenShareUtility.getOrgIdFamilyRefreshToken(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new MsalClientException("token_cache_item_not_found", "Failed to retrieve FRT - see getCause() for additional Exception info", paramString);
    }
  }
  
  public boolean isSharedDevice()
  {
    return mPublicClientConfiguration.getIsSharedDevice();
  }
  
  public void postAuthResult(ILocalAuthenticationResult paramILocalAuthenticationResult, TokenParameters paramTokenParameters, SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    if (paramSilentAuthenticationCallback != null)
    {
      List localList = AuthenticationResultAdapter.getDeclinedScopes(Arrays.asList(paramILocalAuthenticationResult.getScope()), paramTokenParameters.getScopes());
      if (!localList.isEmpty()) {
        paramSilentAuthenticationCallback.onError(AuthenticationResultAdapter.declinedScopeExceptionFromResult(paramILocalAuthenticationResult, localList, paramTokenParameters));
      } else {
        paramSilentAuthenticationCallback.onSuccess(AuthenticationResultAdapter.adapt(paramILocalAuthenticationResult));
      }
      return;
    }
    throw new IllegalStateException("callback cannot be null or empty");
  }
  
  public void saveMsaFamilyRefreshToken(String paramString)
  {
    MsalUtils.validateNonNullArgument(paramString, "refreshToken");
    validateBrokerNotInUse();
    try
    {
      mTokenShareUtility.saveMsaFamilyRefreshToken(paramString);
      return;
    }
    catch (Exception paramString)
    {
      throw new MsalClientException("failed_to_persist_msa_credential", "Failed to save FRT - see getCause() for additional Exception info", paramString);
    }
  }
  
  public void saveOrgIdFamilyRefreshToken(String paramString)
  {
    MsalUtils.validateNonNullArgument(paramString, "SsoStateSerializerBlob");
    validateBrokerNotInUse();
    try
    {
      mTokenShareUtility.saveOrgIdFamilyRefreshToken(paramString);
      return;
    }
    catch (Exception paramString)
    {
      throw new MsalClientException("token_sharing_deserialization_error", "Failed to save FRT - see getCause() for additional Exception info", paramString);
    }
  }
  
  public void validateAcquireTokenParameters(AcquireTokenParameters paramAcquireTokenParameters)
  {
    Activity localActivity = paramAcquireTokenParameters.getActivity();
    List localList = paramAcquireTokenParameters.getScopes();
    paramAcquireTokenParameters = paramAcquireTokenParameters.getCallback();
    MsalUtils.validateNonNullArg(localActivity, "activity");
    MsalUtils.validateNonNullArg(localList, "scopes");
    MsalUtils.validateNonNullArg(paramAcquireTokenParameters, "callback");
  }
  
  public void validateAcquireTokenSilentParameters(AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    String str = paramAcquireTokenSilentParameters.getAuthority();
    IAccount localIAccount = paramAcquireTokenSilentParameters.getAccount();
    List localList = paramAcquireTokenSilentParameters.getScopes();
    paramAcquireTokenSilentParameters = paramAcquireTokenSilentParameters.getCallback();
    MsalUtils.validateNonNullArg(str, "authority");
    MsalUtils.validateNonNullArg(localIAccount, "account");
    MsalUtils.validateNonNullArg(paramAcquireTokenSilentParameters, "callback");
    MsalUtils.validateNonNullArg(localList, "scopes");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */