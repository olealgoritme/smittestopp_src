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
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
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
    return (AcquireTokenResult)invokeBrokerAccountManagerOperation(paramAcquireTokenSilentOperationParameters, new BrokerAccountManagerStrategy.3(this));
  }
  
  public List<ICacheRecord> getBrokerAccounts(OperationParameters paramOperationParameters)
  {
    return (List)invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.4(this));
  }
  
  public Intent getBrokerAuthorizationIntent(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":getBrokerAuthorizationIntent");
    Logger.verbose(localStringBuilder.toString(), "Get the broker authorization intent from AccountManager.");
    return (Intent)invokeBrokerAccountManagerOperation(paramAcquireTokenOperationParameters, new BrokerAccountManagerStrategy.2(this, paramAcquireTokenOperationParameters));
  }
  
  public List<ICacheRecord> getCurrentAccountInSharedDevice(OperationParameters paramOperationParameters)
  {
    return (List)invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.7(this));
  }
  
  public boolean getDeviceMode(OperationParameters paramOperationParameters)
  {
    return ((Boolean)invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.6(this))).booleanValue();
  }
  
  @SuppressLint({"MissingPermission"})
  public void hello(OperationParameters paramOperationParameters)
  {
    if (BrokerMsalController.isAccountManagerPermissionsGranted(paramOperationParameters.getAppContext()))
    {
      invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.1(this));
      return;
    }
    throw new BrokerCommunicationException("AccountManager permissions are not granted", null);
  }
  
  @SuppressLint({"MissingPermission"})
  public <T extends OperationParameters, U> U invokeBrokerAccountManagerOperation(T paramT, BrokerAccountManagerStrategy.OperationInfo<T, U> paramOperationInfo)
  {
    String str = paramOperationInfo.getMethodName();
    Telemetry.emit(new BrokerStartEvent().putAction(str).putStrategy("account_manager"));
    try
    {
      AccountManagerFuture localAccountManagerFuture = AccountManager.get(paramT.getAppContext()).addAccount("com.microsoft.workaccount", "adal.authtoken.type", null, paramOperationInfo.getRequestBundle(paramT), null, null, getPreferredHandler());
      paramT = new java/lang/StringBuilder;
      paramT.<init>();
      paramT.append(TAG);
      paramT.append(str);
      Logger.verbose(paramT.toString(), "Received result from broker");
      paramT = paramOperationInfo.getResultFromBundle((Bundle)localAccountManagerFuture.getResult());
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
    invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.5(this));
  }
  
  public void signOutFromSharedDevice(OperationParameters paramOperationParameters)
  {
    invokeBrokerAccountManagerOperation(paramOperationParameters, new BrokerAccountManagerStrategy.8(this));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */