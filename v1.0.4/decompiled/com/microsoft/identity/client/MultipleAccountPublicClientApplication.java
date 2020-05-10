package com.microsoft.identity.client;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.OperationParametersAdapter;
import com.microsoft.identity.common.adal.internal.cache.IStorageHelper;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;
import com.microsoft.identity.common.internal.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.internal.cache.ISharedPreferencesFileManager;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.controllers.BaseCommand;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.CommandDispatcher;
import com.microsoft.identity.common.internal.controllers.LoadAccountCommand;
import com.microsoft.identity.common.internal.controllers.RemoveAccountCommand;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenMigrationUtility;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.ResultFuture;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleAccountPublicClientApplication
  extends PublicClientApplication
  implements IMultipleAccountPublicClientApplication
{
  public static final String TAG = "MultipleAccountPublicClientApplication";
  
  public MultipleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    super(paramPublicClientApplicationConfiguration);
  }
  
  private void getAccountInternal(String paramString1, IMultipleAccountPublicClientApplication.GetAccountCallback paramGetAccountCallback, String paramString2)
  {
    a.b(new StringBuilder(), TAG, ":getAccount", "Get account with the identifier.");
    try
    {
      OperationParameters localOperationParameters = OperationParametersAdapter.createOperationParameters(mPublicClientConfiguration, mPublicClientConfiguration.getOAuth2TokenCache());
      LoadAccountCommand localLoadAccountCommand = new com/microsoft/identity/common/internal/controllers/LoadAccountCommand;
      List localList = MSALControllerFactory.getAllControllers(mPublicClientConfiguration.getAppContext(), localOperationParameters.getAuthority(), mPublicClientConfiguration);
      MultipleAccountPublicClientApplication.4 local4 = new com/microsoft/identity/client/MultipleAccountPublicClientApplication$4;
      local4.<init>(this, paramGetAccountCallback, paramString1);
      localLoadAccountCommand.<init>(localOperationParameters, localList, local4);
      localLoadAccountCommand.setPublicApiId(paramString2);
      CommandDispatcher.submitSilent(localLoadAccountCommand);
    }
    catch (MsalClientException paramString1)
    {
      Logger.error(a.a(new StringBuilder(), TAG, ":getAccount"), paramString1.getMessage(), paramString1);
      paramGetAccountCallback.onError(paramString1);
    }
  }
  
  private void getAccountsInternal(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback, String paramString)
  {
    Object localObject1 = mPublicClientConfiguration.getOAuth2TokenCache().getAccountsWithAggregatedAccountData(null, mPublicClientConfiguration.getClientId());
    Handler localHandler;
    if ((Looper.myLooper() != null) && (Looper.getMainLooper() != Looper.myLooper())) {
      localHandler = new Handler(Looper.myLooper());
    } else {
      localHandler = new Handler(Looper.getMainLooper());
    }
    Object localObject2;
    if (((List)localObject1).isEmpty())
    {
      localObject1 = new StorageHelper(mPublicClientConfiguration.getAppContext());
      localObject2 = new SharedPreferencesFileManager(mPublicClientConfiguration.getAppContext(), "com.microsoft.aad.adal.cache", (IStorageHelper)localObject1).getAll();
      localObject1 = new HashMap();
      ((HashMap)localObject1).put(mPublicClientConfiguration.getClientId(), mPublicClientConfiguration.getRedirectUri());
      new TokenMigrationUtility()._import(new AdalMigrationAdapter(mPublicClientConfiguration.getAppContext(), (Map)localObject1, false), (Map)localObject2, (IShareSingleSignOnState)mPublicClientConfiguration.getOAuth2TokenCache(), new MultipleAccountPublicClientApplication.1(this));
    }
    else
    {
      new AdalMigrationAdapter(mPublicClientConfiguration.getAppContext(), null, false).setMigrationStatus(true);
    }
    try
    {
      localObject1 = OperationParametersAdapter.createOperationParameters(mPublicClientConfiguration, mPublicClientConfiguration.getOAuth2TokenCache());
      localObject2 = new com/microsoft/identity/common/internal/controllers/LoadAccountCommand;
      ((LoadAccountCommand)localObject2).<init>((OperationParameters)localObject1, MSALControllerFactory.getAllControllers(mPublicClientConfiguration.getAppContext(), ((OperationParameters)localObject1).getAuthority(), mPublicClientConfiguration), PublicClientApplication.getLoadAccountsCallback(paramLoadAccountsCallback));
      ((BaseCommand)localObject2).setPublicApiId(paramString);
      CommandDispatcher.submitSilent((BaseCommand)localObject2);
    }
    catch (MsalClientException paramString)
    {
      localHandler.post(new MultipleAccountPublicClientApplication.2(this, paramLoadAccountsCallback, paramString));
    }
  }
  
  private void removeAccountInternal(IAccount paramIAccount, IMultipleAccountPublicClientApplication.RemoveAccountCallback paramRemoveAccountCallback, String paramString)
  {
    Object localObject1 = (MultiTenantAccount)paramIAccount;
    if (localObject1 == null)
    {
      Logger.warn(TAG, "Requisite IAccount or IAccount fields were null. Insufficient criteria to remove IAccount.");
      paramRemoveAccountCallback.onError(new MsalClientException("invalid_parameter"));
      return;
    }
    paramIAccount = mPublicClientConfiguration;
    paramIAccount = OperationParametersAdapter.createOperationParameters(paramIAccount, paramIAccount.getOAuth2TokenCache());
    Object localObject2 = new AccountRecord();
    ((AccountRecord)localObject2).setEnvironment(((Account)localObject1).getEnvironment());
    ((AccountRecord)localObject2).setHomeAccountId(((Account)localObject1).getHomeAccountId());
    paramIAccount.setAccount((IAccountRecord)localObject2);
    try
    {
      RemoveAccountCommand localRemoveAccountCommand = new com/microsoft/identity/common/internal/controllers/RemoveAccountCommand;
      localObject1 = MSALControllerFactory.getAllControllers(mPublicClientConfiguration.getAppContext(), paramIAccount.getAuthority(), mPublicClientConfiguration);
      localObject2 = new com/microsoft/identity/client/MultipleAccountPublicClientApplication$6;
      ((MultipleAccountPublicClientApplication.6)localObject2).<init>(this, paramRemoveAccountCallback);
      localRemoveAccountCommand.<init>(paramIAccount, (List)localObject1, (CommandCallback)localObject2);
      localRemoveAccountCommand.setPublicApiId(paramString);
      CommandDispatcher.submitSilent(localRemoveAccountCommand);
    }
    catch (MsalClientException paramIAccount)
    {
      paramRemoveAccountCallback.onError(paramIAccount);
    }
  }
  
  public void acquireToken(Activity paramActivity, String[] paramArrayOfString, String paramString, AuthenticationCallback paramAuthenticationCallback)
  {
    acquireTokenInternal(buildAcquireTokenParameters(paramActivity, null, paramArrayOfString, null, null, null, null, null, paramAuthenticationCallback, paramString, null), "126");
  }
  
  public IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, IAccount paramIAccount, String paramString)
  {
    return acquireTokenSilentSyncInternal(paramArrayOfString, paramString, paramIAccount, false, "27");
  }
  
  public void acquireTokenSilentAsync(String[] paramArrayOfString, IAccount paramIAccount, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    acquireTokenSilentAsyncInternal(buildAcquireTokenSilentParameters(paramArrayOfString, paramIAccount, paramString, false, null, paramSilentAuthenticationCallback), "28");
  }
  
  public IAccount getAccount(String paramString)
  {
    MsalUtils.throwOnMainThread("getAccount");
    ResultFuture localResultFuture = new ResultFuture();
    getAccountInternal(paramString, new MultipleAccountPublicClientApplication.5(this, localResultFuture), "925");
    paramString = (AsyncResult)localResultFuture.get();
    if (paramString.getSuccess()) {
      return (IAccount)paramString.getResult();
    }
    throw paramString.getException();
  }
  
  public void getAccount(String paramString, IMultipleAccountPublicClientApplication.GetAccountCallback paramGetAccountCallback)
  {
    getAccountInternal(paramString, paramGetAccountCallback, "926");
  }
  
  public List<IAccount> getAccounts()
  {
    MsalUtils.throwOnMainThread("getAccounts");
    Object localObject = new ResultFuture();
    getAccountsInternal(new MultipleAccountPublicClientApplication.3(this, (ResultFuture)localObject), "923");
    localObject = (AsyncResult)((ResultFuture)localObject).get();
    if (((AsyncResult)localObject).getSuccess()) {
      return (List)((AsyncResult)localObject).getResult();
    }
    throw ((AsyncResult)localObject).getException();
  }
  
  public void getAccounts(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback)
  {
    getAccountsInternal(paramLoadAccountsCallback, "924");
  }
  
  public void removeAccount(IAccount paramIAccount, IMultipleAccountPublicClientApplication.RemoveAccountCallback paramRemoveAccountCallback)
  {
    removeAccountInternal(paramIAccount, paramRemoveAccountCallback, "930");
  }
  
  public boolean removeAccount(IAccount paramIAccount)
  {
    ResultFuture localResultFuture = new ResultFuture();
    removeAccountInternal(paramIAccount, new MultipleAccountPublicClientApplication.7(this, localResultFuture), "929");
    paramIAccount = (AsyncResult)localResultFuture.get();
    if (paramIAccount.getSuccess()) {
      return ((Boolean)paramIAccount.getResult()).booleanValue();
    }
    throw paramIAccount.getException();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MultipleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */