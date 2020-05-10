package com.microsoft.identity.common.internal.request;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.result.AdalBrokerResultAdapter;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class AdalBrokerRequestAdapter
  implements IBrokerRequestAdapter
{
  public static final String TAG = AdalBrokerResultAdapter.class.getName();
  
  private List<Pair<String, String>> getExtraQueryParamAsList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!StringUtil.isEmpty(paramString)) {
      for (paramString : paramString.split("&")) {
        if (!StringUtil.isEmpty(paramString))
        {
          paramString = paramString.split("=");
          Object localObject = paramString[0];
          if (paramString.length > 1) {
            paramString = paramString[1];
          } else {
            paramString = null;
          }
          localArrayList.add(new Pair(localObject, paramString));
        }
      }
    }
    return localArrayList;
  }
  
  private String getPackageNameFromBundle(Bundle paramBundle, Context paramContext)
  {
    String str = paramBundle.getString("caller.info.package");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      paramBundle = paramBundle.getString("x-app-name");
      localObject = paramBundle;
      if (TextUtils.isEmpty(paramBundle))
      {
        Logger.warn(TAG, "Caller package name not set by app, getting from context");
        localObject = paramContext.getPackageName();
      }
    }
    return (String)localObject;
  }
  
  public static AzureActiveDirectoryAuthority getRequestAuthorityWithExtraQP(String paramString, List<Pair<String, String>> paramList)
  {
    AzureActiveDirectoryAuthority localAzureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority)Authority.getAuthorityFromAuthorityUrl(paramString);
    if (paramList != null)
    {
      AzureActiveDirectorySlice localAzureActiveDirectorySlice = new AzureActiveDirectorySlice();
      Iterator localIterator = new ArrayList(paramList).iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (StringUtil.isEmpty((String)first))
        {
          Logger.warn(TAG, "The extra query parameter.first is empty.");
        }
        else if (((String)first).equalsIgnoreCase("instance_aware"))
        {
          Logger.info(TAG, "Set the extra query parameter mMultipleCloudAware for MicrosoftStsAuthorizationRequest.");
          String str = TAG;
          StringBuilder localStringBuilder = a.a("Set the mMultipleCloudAware to ");
          paramString = second;
          if (paramString == null) {
            paramString = "null";
          } else {
            paramString = (String)paramString;
          }
          localStringBuilder.append(paramString);
          Logger.infoPII(str, localStringBuilder.toString());
          paramString = second;
          boolean bool;
          if ((paramString != null) && (((String)paramString).equalsIgnoreCase(Boolean.TRUE.toString()))) {
            bool = true;
          } else {
            bool = false;
          }
          mMultipleCloudsSupported = bool;
          paramList.remove(localPair);
        }
        else if (((String)first).equalsIgnoreCase("slice"))
        {
          localAzureActiveDirectorySlice.setSlice((String)second);
          paramList.remove(localPair);
        }
        else if (((String)first).equalsIgnoreCase("dc"))
        {
          localAzureActiveDirectorySlice.setDataCenter((String)second);
          paramList.remove(localPair);
        }
      }
      Logger.verbose(TAG, "Set the extra query parameter mSlice for MicrosoftStsAuthorizationRequest.");
      paramList = TAG;
      paramString = a.a("Set the mSlice to ");
      paramString.append(localAzureActiveDirectorySlice.toString());
      Logger.verbosePII(paramList, paramString.toString());
      mSlice = localAzureActiveDirectorySlice;
    }
    return localAzureActiveDirectoryAuthority;
  }
  
  private boolean packageNameWasProvidedInBundle(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return false;
    }
    String str = paramBundle.getString("caller.info.package");
    paramBundle = paramBundle.getString("x-app-name");
    if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramBundle))) {
      bool = true;
    }
    return bool;
  }
  
  public BrokerAcquireTokenOperationParameters brokerInteractiveParametersFromActivity(Activity paramActivity)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append("brokerInteractiveParametersFromActivity");
    Logger.verbose(((StringBuilder)localObject1).toString(), "Constructing BrokerAcquireTokenOperationParameters from activity ");
    BrokerAcquireTokenOperationParameters localBrokerAcquireTokenOperationParameters = new BrokerAcquireTokenOperationParameters();
    Intent localIntent = paramActivity.getIntent();
    localBrokerAcquireTokenOperationParameters.setAuthenticationScheme(new BearerAuthenticationSchemeInternal());
    localBrokerAcquireTokenOperationParameters.setActivity(paramActivity);
    localBrokerAcquireTokenOperationParameters.setAppContext(paramActivity.getApplicationContext());
    localBrokerAcquireTokenOperationParameters.setSdkType(SdkType.ADAL);
    localBrokerAcquireTokenOperationParameters.setCallerUId(localIntent.getIntExtra("caller.info.uid", 0));
    boolean bool = packageNameWasProvidedInBundle(localIntent.getExtras());
    localBrokerAcquireTokenOperationParameters.setCallerPackageName(getPackageNameFromBundle(localIntent.getExtras(), paramActivity.getApplicationContext()));
    localBrokerAcquireTokenOperationParameters.setCallerAppVersion(localIntent.getStringExtra("x-app-ver"));
    Object localObject2 = getExtraQueryParamAsList(localIntent.getStringExtra("account.extra.query.param"));
    localObject1 = getRequestAuthorityWithExtraQP(localIntent.getStringExtra("account.authority"), (List)localObject2);
    if (((AzureActiveDirectoryAuthority)localObject1).getAudience().getTenantId().equalsIgnoreCase("common")) {
      ((AzureActiveDirectoryAuthority)localObject1).getAudience().setTenantId("organizations");
    }
    localBrokerAcquireTokenOperationParameters.setAuthority((Authority)localObject1);
    localBrokerAcquireTokenOperationParameters.setExtraQueryStringParameters((List)localObject2);
    localObject1 = localIntent.getStringExtra("account.resource");
    localObject2 = new HashSet();
    ((HashSet)localObject2).add(TokenCacheItemMigrationAdapter.getScopeFromResource((String)localObject1));
    localBrokerAcquireTokenOperationParameters.setScopes((Set)localObject2);
    localBrokerAcquireTokenOperationParameters.setClientId(localIntent.getStringExtra("account.clientid.key"));
    if (bool) {
      localBrokerAcquireTokenOperationParameters.setRedirectUri(BrokerValidator.getBrokerRedirectUri(paramActivity, localBrokerAcquireTokenOperationParameters.getCallerPackageName()));
    } else {
      localBrokerAcquireTokenOperationParameters.setRedirectUri(localIntent.getStringExtra("account.redirect"));
    }
    localBrokerAcquireTokenOperationParameters.setLoginHint(localIntent.getStringExtra("account.name"));
    localObject1 = localIntent.getStringExtra("account.correlationid");
    paramActivity = (Activity)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Logger.info(TAG, "Correlation id not set by Adal, creating a new one");
      paramActivity = UUID.randomUUID().toString();
    }
    localBrokerAcquireTokenOperationParameters.setCorrelationId(paramActivity);
    localBrokerAcquireTokenOperationParameters.setClaimsRequest(localIntent.getStringExtra("account.claims"));
    localBrokerAcquireTokenOperationParameters.setOpenIdConnectPromptParameter(OpenIdConnectPromptParameter._fromPromptBehavior(localIntent.getStringExtra("account.prompt")));
    localBrokerAcquireTokenOperationParameters.setAuthorizationAgent(AuthorizationAgent.WEBVIEW);
    return localBrokerAcquireTokenOperationParameters;
  }
  
  public BrokerRequest brokerRequestFromAcquireTokenParameters(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    throw new UnsupportedOperationException();
  }
  
  public BrokerRequest brokerRequestFromSilentOperationParameters(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    throw new UnsupportedOperationException();
  }
  
  public BrokerAcquireTokenSilentOperationParameters brokerSilentParametersFromBundle(Bundle paramBundle, Context paramContext, Account paramAccount)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":brokerSilentParametersFromBundle");
    Logger.verbose(((StringBuilder)localObject).toString(), "Constructing BrokerAcquireTokenOperationParameters from activity ");
    BrokerAcquireTokenSilentOperationParameters localBrokerAcquireTokenSilentOperationParameters = new BrokerAcquireTokenSilentOperationParameters();
    localBrokerAcquireTokenSilentOperationParameters.setAuthenticationScheme(new BearerAuthenticationSchemeInternal());
    localBrokerAcquireTokenSilentOperationParameters.setAppContext(paramContext);
    localBrokerAcquireTokenSilentOperationParameters.setAccountManagerAccount(paramAccount);
    localBrokerAcquireTokenSilentOperationParameters.setSdkType(SdkType.ADAL);
    localBrokerAcquireTokenSilentOperationParameters.setCallerUId(paramBundle.getInt("caller.info.uid"));
    boolean bool = packageNameWasProvidedInBundle(paramBundle);
    String str = getPackageNameFromBundle(paramBundle, paramContext);
    localBrokerAcquireTokenSilentOperationParameters.setCallerPackageName(str);
    localBrokerAcquireTokenSilentOperationParameters.setCallerAppVersion(paramBundle.getString("x-app-ver"));
    localBrokerAcquireTokenSilentOperationParameters.setAuthority(Authority.getAuthorityFromAuthorityUrl(paramBundle.getString("account.authority")));
    localObject = paramBundle.getString("account.correlationid");
    paramAccount = (Account)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Logger.info(TAG, "Correlation id not set by Adal, creating a new one");
      paramAccount = UUID.randomUUID().toString();
    }
    localBrokerAcquireTokenSilentOperationParameters.setCorrelationId(paramAccount);
    localObject = paramBundle.getString("account.resource");
    paramAccount = new HashSet();
    paramAccount.add(TokenCacheItemMigrationAdapter.getScopeFromResource((String)localObject));
    localBrokerAcquireTokenSilentOperationParameters.setScopes(paramAccount);
    localBrokerAcquireTokenSilentOperationParameters.setClientId(paramBundle.getString("account.clientid.key"));
    localBrokerAcquireTokenSilentOperationParameters.setLocalAccountId(paramBundle.getString("account.userinfo.userid"));
    localObject = paramBundle.getString("account.redirect");
    if (!bool)
    {
      paramAccount = (Account)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      paramAccount = BrokerValidator.getBrokerRedirectUri(paramContext, str);
    }
    localBrokerAcquireTokenSilentOperationParameters.setRedirectUri(paramAccount);
    localBrokerAcquireTokenSilentOperationParameters.setForceRefresh(Boolean.parseBoolean(paramBundle.getString("force.refresh")));
    localBrokerAcquireTokenSilentOperationParameters.setClaimsRequest(paramBundle.getString("account.claims"));
    localBrokerAcquireTokenSilentOperationParameters.setLoginHint(paramBundle.getString("account.name"));
    localBrokerAcquireTokenSilentOperationParameters.setExtraQueryStringParameters(getExtraQueryParamAsList(paramBundle.getString("account.extra.query.param")));
    return localBrokerAcquireTokenSilentOperationParameters;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.AdalBrokerRequestAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */