package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Context;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.controllers.MSALControllerFactory;
import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.client.internal.controllers.OperationParametersAdapter;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;
import com.microsoft.identity.common.adal.internal.util.JsonExtensions;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.controllers.BaseCommand;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.CommandDispatcher;
import com.microsoft.identity.common.internal.controllers.GetCurrentAccountCommand;
import com.microsoft.identity.common.internal.controllers.RemoveCurrentAccountCommand;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.internal.result.ResultFuture;
import e.a.a.a.a;
import java.util.List;

public class SingleAccountPublicClientApplication
  extends PublicClientApplication
  implements ISingleAccountPublicClientApplication
{
  public static final String CURRENT_ACCOUNT_SHARED_PREFERENCE_KEY = "com.microsoft.identity.client.single_account_credential_cache.current_account";
  public static final String SINGLE_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.single_account_credential_cache";
  public static final String TAG = "SingleAccountPublicClientApplication";
  public SharedPreferencesFileManager sharedPreferencesFileManager;
  
  public SingleAccountPublicClientApplication(PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    super(paramPublicClientApplicationConfiguration);
    initializeSharedPreferenceFileManager(paramPublicClientApplicationConfiguration.getAppContext());
  }
  
  private void checkCurrentAccountNotifyCallback(ISingleAccountPublicClientApplication.CurrentAccountCallback paramCurrentAccountCallback, List<ICacheRecord> paramList)
  {
    MultiTenantAccount localMultiTenantAccount1 = getPersistedCurrentAccount();
    MultiTenantAccount localMultiTenantAccount2;
    if (paramList == null) {
      localMultiTenantAccount2 = null;
    } else {
      localMultiTenantAccount2 = getAccountFromICacheRecordList(paramList);
    }
    if (didCurrentAccountChange(localMultiTenantAccount2)) {
      paramCurrentAccountCallback.onAccountChanged(localMultiTenantAccount1, localMultiTenantAccount2);
    }
    persistCurrentAccount(paramList);
    paramCurrentAccountCallback.onAccountLoaded(localMultiTenantAccount2);
  }
  
  private boolean didCurrentAccountChange(MultiTenantAccount paramMultiTenantAccount)
  {
    Object localObject = getPersistedCurrentAccount();
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((Account)localObject).getHomeAccountId();
    }
    if (paramMultiTenantAccount == null) {
      paramMultiTenantAccount = str;
    } else {
      paramMultiTenantAccount = paramMultiTenantAccount.getHomeAccountId();
    }
    return ((String)localObject).equalsIgnoreCase(paramMultiTenantAccount) ^ true;
  }
  
  private MultiTenantAccount getAccountFromICacheRecordList(List<ICacheRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = AccountAdapter.adapt(paramList);
      if (paramList.size() != 1) {
        a.b(new StringBuilder(), TAG, ":getAccountFromICacheRecords", "Returned cacheRecords were adapted into multiple IAccount. This is unexpected in Single account mode.Returning the first adapted account.");
      }
      return (MultiTenantAccount)paramList.get(0);
    }
    return null;
  }
  
  private void getCurrentAccountAsyncInternal(final ISingleAccountPublicClientApplication.CurrentAccountCallback paramCurrentAccountCallback, String paramString)
  {
    Object localObject = mPublicClientConfiguration;
    OperationParameters localOperationParameters = OperationParametersAdapter.createOperationParameters((PublicClientApplicationConfiguration)localObject, ((PublicClientApplicationConfiguration)localObject).getOAuth2TokenCache());
    try
    {
      localObject = MSALControllerFactory.getDefaultController(mPublicClientConfiguration.getAppContext(), localOperationParameters.getAuthority(), mPublicClientConfiguration);
      paramCurrentAccountCallback = new GetCurrentAccountCommand(localOperationParameters, (BaseController)localObject, new CommandCallback()
      {
        public void onCancel() {}
        
        public void onError(BaseException paramAnonymousBaseException)
        {
          paramCurrentAccountCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramAnonymousBaseException));
        }
        
        public void onTaskCompleted(List<ICacheRecord> paramAnonymousList)
        {
          SingleAccountPublicClientApplication.access$000(SingleAccountPublicClientApplication.this, paramCurrentAccountCallback, paramAnonymousList);
        }
      });
      paramCurrentAccountCallback.setPublicApiId(paramString);
      CommandDispatcher.submitSilent(paramCurrentAccountCallback);
      return;
    }
    catch (MsalClientException paramString)
    {
      paramCurrentAccountCallback.onError(paramString);
    }
  }
  
  private MultiTenantAccount getPersistedCurrentAccount()
  {
    String str = sharedPreferencesFileManager.getString("com.microsoft.identity.client.single_account_credential_cache.current_account");
    if (str == null) {
      return null;
    }
    return getAccountFromICacheRecordList(JsonExtensions.getICacheRecordListFromJsonString(str));
  }
  
  private void initializeSharedPreferenceFileManager(Context paramContext)
  {
    sharedPreferencesFileManager = new SharedPreferencesFileManager(paramContext, "com.microsoft.identity.client.single_account_credential_cache", new StorageHelper(paramContext));
  }
  
  private void persistCurrentAccount(List<ICacheRecord> paramList)
  {
    sharedPreferencesFileManager.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = JsonExtensions.getJsonStringFromICacheRecordList(paramList);
      sharedPreferencesFileManager.putString("com.microsoft.identity.client.single_account_credential_cache.current_account", paramList);
    }
  }
  
  public void acquireToken(Activity paramActivity, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback)
  {
    if (getPersistedCurrentAccount() == null)
    {
      paramAuthenticationCallback.onError(new MsalClientException("no_current_account"));
      return;
    }
    acquireTokenInternal(buildAcquireTokenParameters(paramActivity, null, paramArrayOfString, getPersistedCurrentAccount(), null, null, null, null, paramAuthenticationCallback, null, null), "125");
  }
  
  public void acquireToken(AcquireTokenParameters paramAcquireTokenParameters)
  {
    MultiTenantAccount localMultiTenantAccount = getPersistedCurrentAccount();
    if (localMultiTenantAccount != null)
    {
      paramAcquireTokenParameters.setAccount(localMultiTenantAccount);
      paramAcquireTokenParameters.setLoginHint("");
    }
    acquireTokenInternal(paramAcquireTokenParameters, "124");
  }
  
  public IAuthenticationResult acquireTokenSilent(AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    MultiTenantAccount localMultiTenantAccount = getPersistedCurrentAccount();
    if (localMultiTenantAccount != null)
    {
      paramAcquireTokenSilentParameters.setAccount(localMultiTenantAccount);
      return acquireTokenSilentInternal(paramAcquireTokenSilentParameters, "23");
    }
    throw new MsalClientException("no_current_account");
  }
  
  public IAuthenticationResult acquireTokenSilent(String[] paramArrayOfString, String paramString)
  {
    MultiTenantAccount localMultiTenantAccount = getPersistedCurrentAccount();
    if (localMultiTenantAccount != null) {
      return acquireTokenSilentSyncInternal(paramArrayOfString, paramString, localMultiTenantAccount, false, "25");
    }
    throw new MsalClientException("no_current_account");
  }
  
  public void acquireTokenSilentAsync(AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    MultiTenantAccount localMultiTenantAccount = getPersistedCurrentAccount();
    if (localMultiTenantAccount == null)
    {
      paramAcquireTokenSilentParameters.getCallback().onError(new MsalClientException("no_current_account"));
      return;
    }
    paramAcquireTokenSilentParameters.setAccount(localMultiTenantAccount);
    acquireTokenSilentAsyncInternal(paramAcquireTokenSilentParameters, "24");
  }
  
  public void acquireTokenSilentAsync(String[] paramArrayOfString, String paramString, SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    MultiTenantAccount localMultiTenantAccount = getPersistedCurrentAccount();
    if (localMultiTenantAccount == null)
    {
      paramSilentAuthenticationCallback.onError(new MsalClientException("no_current_account"));
      return;
    }
    acquireTokenSilentAsyncInternal(buildAcquireTokenSilentParameters(paramArrayOfString, localMultiTenantAccount, paramString, false, null, paramSilentAuthenticationCallback), "26");
  }
  
  public CommandCallback<ILocalAuthenticationResult, BaseException> getCommandCallback(final SilentAuthenticationCallback paramSilentAuthenticationCallback, final TokenParameters paramTokenParameters)
  {
    new CommandCallback()
    {
      public void onCancel()
      {
        SilentAuthenticationCallback localSilentAuthenticationCallback = paramSilentAuthenticationCallback;
        if ((localSilentAuthenticationCallback instanceof AuthenticationCallback))
        {
          ((AuthenticationCallback)localSilentAuthenticationCallback).onCancel();
          return;
        }
        throw new IllegalStateException("Silent requests cannot be cancelled.");
      }
      
      public void onError(BaseException paramAnonymousBaseException)
      {
        paramAnonymousBaseException = MsalExceptionAdapter.msalExceptionFromBaseException(paramAnonymousBaseException);
        SilentAuthenticationCallback localSilentAuthenticationCallback = paramSilentAuthenticationCallback;
        if (localSilentAuthenticationCallback != null)
        {
          localSilentAuthenticationCallback.onError(paramAnonymousBaseException);
          return;
        }
        throw new IllegalStateException("callback cannot be null or empty");
      }
      
      public void onTaskCompleted(ILocalAuthenticationResult paramAnonymousILocalAuthenticationResult)
      {
        if (paramSilentAuthenticationCallback != null)
        {
          MultiTenantAccount localMultiTenantAccount = SingleAccountPublicClientApplication.access$100(SingleAccountPublicClientApplication.this, paramAnonymousILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
          if (SingleAccountPublicClientApplication.access$200(SingleAccountPublicClientApplication.this, localMultiTenantAccount))
          {
            if (SingleAccountPublicClientApplication.access$300(SingleAccountPublicClientApplication.this) != null)
            {
              paramSilentAuthenticationCallback.onError(new MsalClientException("returned_account_does_not_match_current_account"));
              return;
            }
            SingleAccountPublicClientApplication.access$400(SingleAccountPublicClientApplication.this, paramAnonymousILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
          }
          else
          {
            SingleAccountPublicClientApplication.access$400(SingleAccountPublicClientApplication.this, paramAnonymousILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
          }
          postAuthResult(paramAnonymousILocalAuthenticationResult, paramTokenParameters, paramSilentAuthenticationCallback);
          return;
        }
        throw new IllegalStateException("callback cannot be null or empty");
      }
    };
  }
  
  public ICurrentAccountResult getCurrentAccount()
  {
    MsalUtils.throwOnMainThread("getCurrentAccount");
    final Object localObject = new ResultFuture();
    getCurrentAccountAsyncInternal(new ISingleAccountPublicClientApplication.CurrentAccountCallback()
    {
      public void onAccountChanged(IAccount paramAnonymousIAccount1, IAccount paramAnonymousIAccount2)
      {
        paramAnonymousIAccount1 = new CurrentAccountResult(paramAnonymousIAccount2, paramAnonymousIAccount1, false);
        localObject.setResult(new AsyncResult(paramAnonymousIAccount1, null));
      }
      
      public void onAccountLoaded(IAccount paramAnonymousIAccount)
      {
        paramAnonymousIAccount = new CurrentAccountResult(paramAnonymousIAccount, null, false);
        localObject.setResult(new AsyncResult(paramAnonymousIAccount, null));
      }
      
      public void onError(MsalException paramAnonymousMsalException)
      {
        localObject.setResult(new AsyncResult(null, paramAnonymousMsalException));
      }
    }, "921");
    localObject = (AsyncResult)((ResultFuture)localObject).get();
    if (((AsyncResult)localObject).getSuccess()) {
      return (ICurrentAccountResult)((AsyncResult)localObject).getResult();
    }
    throw ((AsyncResult)localObject).getException();
  }
  
  public void getCurrentAccountAsync(ISingleAccountPublicClientApplication.CurrentAccountCallback paramCurrentAccountCallback)
  {
    getCurrentAccountAsyncInternal(paramCurrentAccountCallback, "922");
  }
  
  public void signIn(Activity paramActivity, String paramString, String[] paramArrayOfString, AuthenticationCallback paramAuthenticationCallback)
  {
    if (getPersistedCurrentAccount() != null)
    {
      paramAuthenticationCallback.onError(new MsalClientException("invalid_parameter"));
      return;
    }
    acquireTokenInternal(buildAcquireTokenParameters(paramActivity, null, paramArrayOfString, null, null, null, null, null, paramAuthenticationCallback, paramString, null), "123");
  }
  
  public void signOut(ISingleAccountPublicClientApplication.SignOutCallback paramSignOutCallback)
  {
    signOutInternal(paramSignOutCallback, "928");
  }
  
  public boolean signOut()
  {
    MsalUtils.throwOnMainThread("signOut");
    final Object localObject = new ResultFuture();
    signOutInternal(new ISingleAccountPublicClientApplication.SignOutCallback()
    {
      public void onError(MsalException paramAnonymousMsalException)
      {
        localObject.setResult(new AsyncResult(Boolean.valueOf(false), paramAnonymousMsalException));
      }
      
      public void onSignOut()
      {
        localObject.setResult(new AsyncResult(Boolean.valueOf(true), null));
      }
    }, "927");
    localObject = (AsyncResult)((ResultFuture)localObject).get();
    if (((AsyncResult)localObject).getSuccess()) {
      return ((Boolean)((AsyncResult)localObject).getResult()).booleanValue();
    }
    throw ((AsyncResult)localObject).getException();
  }
  
  public void signOutInternal(final ISingleAccountPublicClientApplication.SignOutCallback paramSignOutCallback, String paramString)
  {
    Object localObject1 = getPersistedCurrentAccount();
    if (localObject1 == null)
    {
      paramSignOutCallback.onError(new MsalClientException("no_current_account"));
      return;
    }
    Object localObject2 = mPublicClientConfiguration;
    localObject2 = OperationParametersAdapter.createOperationParameters((PublicClientApplicationConfiguration)localObject2, ((PublicClientApplicationConfiguration)localObject2).getOAuth2TokenCache());
    AccountRecord localAccountRecord = new AccountRecord();
    localAccountRecord.setEnvironment(((Account)localObject1).getEnvironment());
    localAccountRecord.setHomeAccountId(((Account)localObject1).getHomeAccountId());
    ((OperationParameters)localObject2).setAccount(localAccountRecord);
    try
    {
      localObject1 = MSALControllerFactory.getDefaultController(mPublicClientConfiguration.getAppContext(), ((OperationParameters)localObject2).getAuthority(), mPublicClientConfiguration);
      paramSignOutCallback = new RemoveCurrentAccountCommand((OperationParameters)localObject2, (BaseController)localObject1, new CommandCallback()
      {
        public void onCancel() {}
        
        public void onError(BaseException paramAnonymousBaseException)
        {
          paramSignOutCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramAnonymousBaseException));
        }
        
        public void onTaskCompleted(Boolean paramAnonymousBoolean)
        {
          SingleAccountPublicClientApplication.access$400(SingleAccountPublicClientApplication.this, null);
          paramSignOutCallback.onSignOut();
        }
      });
      paramSignOutCallback.setPublicApiId(paramString);
      CommandDispatcher.submitSilent(paramSignOutCallback);
      return;
    }
    catch (MsalClientException paramString)
    {
      paramSignOutCallback.onError(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.SingleAccountPublicClientApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */