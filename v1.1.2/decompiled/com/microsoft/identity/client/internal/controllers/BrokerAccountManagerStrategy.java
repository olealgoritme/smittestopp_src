package com.microsoft.identity.client.internal.controllers;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.client.exception.BrokerCommunicationException;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.BrokerEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.BrokerStartEvent;
import e.a.a.a.a;
import java.io.IOException;
import java.util.List;

public class BrokerAccountManagerStrategy
  extends BrokerBaseStrategy
{
  public static final String TAG = "BrokerAccountManagerStrategy";
  
  public AcquireTokenResult acquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    (AcquireTokenResult)invokeBrokerAccountManagerOperation(paramAcquireTokenSilentOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":acquireTokenSilentWithAccountManager";
      }
      
      public Bundle getRequestBundle(AcquireTokenSilentOperationParameters paramAnonymousAcquireTokenSilentOperationParameters)
      {
        paramAnonymousAcquireTokenSilentOperationParameters = mRequestAdapter.getRequestBundleForAcquireTokenSilent(paramAnonymousAcquireTokenSilentOperationParameters);
        paramAnonymousAcquireTokenSilentOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "ACQUIRE_TOKEN_SILENT");
        return paramAnonymousAcquireTokenSilentOperationParameters;
      }
      
      public AcquireTokenResult getResultFromBundle(Bundle paramAnonymousBundle)
      {
        return mResultAdapter.getAcquireTokenResultFromResultBundle(paramAnonymousBundle);
      }
    });
  }
  
  public List<ICacheRecord> getBrokerAccounts(OperationParameters paramOperationParameters)
  {
    (List)invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":getBrokerAccountsWithAccountManager";
      }
      
      public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
      {
        paramAnonymousOperationParameters = mRequestAdapter.getRequestBundleForGetAccounts(paramAnonymousOperationParameters);
        paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_ACCOUNTS");
        return paramAnonymousOperationParameters;
      }
      
      public List<ICacheRecord> getResultFromBundle(Bundle paramAnonymousBundle)
      {
        return mResultAdapter.getAccountsFromResultBundle(paramAnonymousBundle);
      }
    });
  }
  
  public Intent getBrokerAuthorizationIntent(final AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":getBrokerAuthorizationIntent");
    Logger.verbose(localStringBuilder.toString(), "Get the broker authorization intent from AccountManager.");
    (Intent)invokeBrokerAccountManagerOperation(paramAcquireTokenOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":getBrokerAuthorizationIntent";
      }
      
      public Bundle getRequestBundle(AcquireTokenOperationParameters paramAnonymousAcquireTokenOperationParameters)
      {
        paramAnonymousAcquireTokenOperationParameters = new Bundle();
        paramAnonymousAcquireTokenOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_INTENT_FOR_INTERACTIVE_REQUEST");
        return paramAnonymousAcquireTokenOperationParameters;
      }
      
      public Intent getResultFromBundle(Bundle paramAnonymousBundle)
      {
        paramAnonymousBundle = (Intent)paramAnonymousBundle.getParcelable("intent");
        return completeInteractiveRequestIntent(paramAnonymousBundle, paramAcquireTokenOperationParameters);
      }
    });
  }
  
  public List<ICacheRecord> getCurrentAccountInSharedDevice(OperationParameters paramOperationParameters)
  {
    (List)invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":getCurrentAccountInSharedDeviceWithAccountManager";
      }
      
      public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
      {
        paramAnonymousOperationParameters = mRequestAdapter.getRequestBundleForGetAccounts(paramAnonymousOperationParameters);
        paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_CURRENT_ACCOUNT");
        return paramAnonymousOperationParameters;
      }
      
      public List<ICacheRecord> getResultFromBundle(Bundle paramAnonymousBundle)
      {
        return mResultAdapter.getAccountsFromResultBundle(paramAnonymousBundle);
      }
    });
  }
  
  public boolean getDeviceMode(OperationParameters paramOperationParameters)
  {
    ((Boolean)invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":getDeviceModeWithAccountManager";
      }
      
      public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
      {
        paramAnonymousOperationParameters = new Bundle();
        paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_DEVICE_MODE");
        return paramAnonymousOperationParameters;
      }
      
      public Boolean getResultFromBundle(Bundle paramAnonymousBundle)
      {
        return Boolean.valueOf(mResultAdapter.getDeviceModeFromResultBundle(paramAnonymousBundle));
      }
    })).booleanValue();
  }
  
  @SuppressLint({"MissingPermission"})
  public void hello(OperationParameters paramOperationParameters)
  {
    if (BrokerMsalController.isAccountManagerPermissionsGranted(paramOperationParameters.getAppContext()))
    {
      invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
      {
        public String getMethodName()
        {
          return ":helloWithAccountManager";
        }
        
        public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
        {
          paramAnonymousOperationParameters = mRequestAdapter.getRequestBundleForHello(paramAnonymousOperationParameters);
          paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "HELLO");
          return paramAnonymousOperationParameters;
        }
        
        public Void getResultFromBundle(Bundle paramAnonymousBundle)
        {
          mResultAdapter.verifyHelloFromResultBundle(paramAnonymousBundle);
          return null;
        }
      });
      return;
    }
    throw new BrokerCommunicationException("AccountManager permissions are not granted", null);
  }
  
  @SuppressLint({"MissingPermission"})
  public <T extends OperationParameters, U> U invokeBrokerAccountManagerOperation(T paramT, OperationInfo<T, U> paramOperationInfo)
  {
    String str = paramOperationInfo.getMethodName();
    Telemetry.emit(new BrokerStartEvent().putAction(str).putStrategy("account_manager"));
    try
    {
      paramT = AccountManager.get(paramT.getAppContext()).addAccount("com.microsoft.workaccount", "adal.authtoken.type", null, paramOperationInfo.getRequestBundle(paramT), null, null, getPreferredHandler());
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(TAG);
      localStringBuilder.append(str);
      Logger.verbose(localStringBuilder.toString(), "Received result from broker");
      paramT = paramOperationInfo.getResultFromBundle((Bundle)paramT.getResult());
      Telemetry.emit(new BrokerEndEvent().putAction(str).isSuccessful(true));
      return paramT;
    }
    catch (BaseException paramT)
    {
      Logger.error(a.a(new StringBuilder(), TAG, str), paramT.getMessage(), paramT);
      Telemetry.emit(new BrokerEndEvent().putAction(str).isSuccessful(false).putErrorCode(paramT.getErrorCode()).putErrorDescription(paramT.getMessage()));
      throw paramT;
    }
    catch (OperationCanceledException paramT) {}catch (IOException paramT) {}catch (AuthenticatorException paramT) {}
    Logger.error(a.a(new StringBuilder(), TAG, str), paramT.getMessage(), paramT);
    Telemetry.emit(new BrokerEndEvent().putAction(str).isSuccessful(false).putErrorCode("io_error").putErrorDescription(paramT.getMessage()));
    throw new BrokerCommunicationException("Failed to connect to AccountManager", paramT);
  }
  
  public void removeBrokerAccount(OperationParameters paramOperationParameters)
  {
    invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":removeBrokerAccountWithAccountManager";
      }
      
      public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
      {
        paramAnonymousOperationParameters = mRequestAdapter.getRequestBundleForRemoveAccount(paramAnonymousOperationParameters);
        paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "REMOVE_ACCOUNT");
        return paramAnonymousOperationParameters;
      }
      
      public Void getResultFromBundle(Bundle paramAnonymousBundle)
      {
        mResultAdapter.verifyRemoveAccountResultFromBundle(paramAnonymousBundle);
        return null;
      }
    });
  }
  
  public void signOutFromSharedDevice(OperationParameters paramOperationParameters)
  {
    invokeBrokerAccountManagerOperation(paramOperationParameters, new OperationInfo()
    {
      public String getMethodName()
      {
        return ":signOutFromSharedDeviceWithAccountManager";
      }
      
      public Bundle getRequestBundle(OperationParameters paramAnonymousOperationParameters)
      {
        paramAnonymousOperationParameters = mRequestAdapter.getRequestBundleForRemoveAccountFromSharedDevice(paramAnonymousOperationParameters);
        paramAnonymousOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "REMOVE_ACCOUNT_FROM_SHARED_DEVICE");
        return paramAnonymousOperationParameters;
      }
      
      public Void getResultFromBundle(Bundle paramAnonymousBundle)
      {
        mResultAdapter.verifyRemoveAccountResultFromBundle(paramAnonymousBundle);
        return null;
      }
    });
  }
  
  public static abstract interface OperationInfo<T extends OperationParameters, U>
  {
    public abstract String getMethodName();
    
    public abstract Bundle getRequestBundle(T paramT);
    
    public abstract U getResultFromBundle(Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */