package com.microsoft.identity.client.internal.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.microsoft.identity.client.exception.BrokerCommunicationException;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.broker.BrokerResultFuture;
import com.microsoft.identity.common.internal.broker.MicrosoftAuthClient;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAccount;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.internal.util.ICacheRecordGsonAdapter;
import e.a.a.a.a;
import e.c.c.e;
import java.util.ArrayList;
import java.util.List;

public class BrokerMsalController
  extends BaseController
{
  public static final String MANIFEST_PERMISSION_MANAGE_ACCOUNTS = "android.permission.MANAGE_ACCOUNTS";
  public static final String TAG = "BrokerMsalController";
  public BrokerResultFuture mBrokerResultFuture;
  
  private Intent getBrokerAuthorizationIntent(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    return (Intent)invokeBrokerOperation(paramAcquireTokenOperationParameters, new BrokerMsalController.1(this));
  }
  
  private List<BrokerBaseStrategy> getStrategies()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BrokerAuthServiceStrategy());
    localArrayList.add(new BrokerAccountManagerStrategy());
    return localArrayList;
  }
  
  private <T extends OperationParameters, U> U invokeBrokerOperation(T paramT, BrokerMsalController.BrokerOperationInfo<T, U> paramBrokerOperationInfo)
  {
    if (paramBrokerOperationInfo.getTelemetryApiId() != null) {
      Telemetry.emit(new ApiStartEvent().putProperties(paramT).putApiId(paramBrokerOperationInfo.getTelemetryApiId()));
    }
    List localList = getStrategies();
    int i = 0;
    Object localObject1 = null;
    Object localObject3;
    for (Object localObject2 = null;; localObject2 = localBrokerCommunicationException)
    {
      localObject3 = localObject1;
      if (i >= localList.size()) {
        break;
      }
      Object localObject4 = (BrokerBaseStrategy)localList.get(i);
      try
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append(TAG);
        ((StringBuilder)localObject3).append(paramBrokerOperationInfo.getMethodName());
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Executing with strategy: ");
        localStringBuilder.append(localObject4.getClass().getSimpleName());
        Logger.info((String)localObject3, localStringBuilder.toString());
        ((BrokerBaseStrategy)localObject4).hello(paramT);
        localObject3 = paramBrokerOperationInfo.perform((BrokerBaseStrategy)localObject4, paramT);
        localObject1 = localObject3;
        localObject4 = localObject2;
        if (localObject3 != null) {
          break;
        }
        i++;
      }
      catch (Exception localException) {}catch (BaseException paramT)
      {
        if (paramBrokerOperationInfo.getTelemetryApiId() != null) {
          Telemetry.emit(new ApiEndEvent().putException(paramT).putApiId(paramBrokerOperationInfo.getTelemetryApiId()));
        }
        throw paramT;
      }
      catch (BrokerCommunicationException localBrokerCommunicationException) {}
    }
    if (localObject3 == null)
    {
      paramT = new BrokerCommunicationException("MSAL failed to communicate to Broker.", (Throwable)localObject2);
      if (paramBrokerOperationInfo.getTelemetryApiId() != null) {
        Telemetry.emit(new ApiEndEvent().putException(paramT).putApiId(paramBrokerOperationInfo.getTelemetryApiId()));
      }
      throw paramT;
    }
    if (paramBrokerOperationInfo.getTelemetryApiId() != null)
    {
      paramT = new ApiEndEvent().putApiId(paramBrokerOperationInfo.getTelemetryApiId()).isApiCallSuccessful(Boolean.TRUE);
      paramBrokerOperationInfo.putValueInSuccessEvent(paramT, localObject3);
      Telemetry.emit(paramT);
    }
    return (U)localObject3;
  }
  
  public static boolean isAccountManagerPermissionsGranted(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return true;
    }
    return isPermissionGranted(paramContext, "android.permission.MANAGE_ACCOUNTS");
  }
  
  public static boolean isMicrosoftAuthServiceSupported(Context paramContext)
  {
    boolean bool;
    if (new MicrosoftAuthClient(paramContext).getIntentForAuthService(paramContext) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isPermissionGranted(Context paramContext, String paramString)
  {
    boolean bool;
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    String str = a.a(new StringBuilder(), TAG, ":isPermissionGranted");
    paramContext = new StringBuilder();
    paramContext.append("is ");
    paramContext.append(paramString);
    paramContext.append(" granted? [");
    paramContext.append(bool);
    paramContext.append("]");
    Logger.verbose(str, paramContext.toString());
    return bool;
  }
  
  private void saveMsaAccountToCache(Bundle paramBundle, MsalOAuth2TokenCache paramMsalOAuth2TokenCache)
  {
    Object localObject1 = new e();
    ((e)localObject1).a(ICacheRecord.class, new ICacheRecordGsonAdapter());
    localObject1 = (BrokerResult)((e)localObject1).a().a(paramBundle.getString("broker_result_v2"), BrokerResult.class);
    if ((paramBundle.getBoolean("broker_request_v2_success")) && (localObject1 != null) && ("9188040d-6c67-4c5b-b112-36a304b66dad".equalsIgnoreCase(((BrokerResult)localObject1).getTenantId())))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(TAG);
      paramBundle.append(":saveMsaAccountToCache");
      Logger.info(paramBundle.toString(), "Result returned for MSA Account, saving to cache");
      try
      {
        ClientInfo localClientInfo = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
        localClientInfo.<init>(((BrokerResult)localObject1).getClientInfo());
        paramBundle = new com/microsoft/identity/common/internal/providers/microsoft/microsoftsts/MicrosoftStsAccount;
        Object localObject2 = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
        ((IDToken)localObject2).<init>(((BrokerResult)localObject1).getIdToken());
        paramBundle.<init>((IDToken)localObject2, localClientInfo);
        paramBundle.setEnvironment(((BrokerResult)localObject1).getEnvironment());
        localObject2 = new com/microsoft/identity/common/internal/providers/microsoft/MicrosoftRefreshToken;
        ((MicrosoftRefreshToken)localObject2).<init>(((BrokerResult)localObject1).getRefreshToken(), localClientInfo, ((BrokerResult)localObject1).getScope(), ((BrokerResult)localObject1).getClientId(), ((BrokerResult)localObject1).getEnvironment(), ((BrokerResult)localObject1).getFamilyId());
        paramMsalOAuth2TokenCache.setSingleSignOnState(paramBundle, (RefreshToken)localObject2);
      }
      catch (ServiceException paramMsalOAuth2TokenCache)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(TAG);
        paramBundle.append(":saveMsaAccountToCache");
        Logger.errorPII(paramBundle.toString(), "Exception while creating Idtoken or ClientInfo, cannot save MSA account tokens", paramMsalOAuth2TokenCache);
        throw new ClientException("invalid_jwt", paramMsalOAuth2TokenCache.getMessage(), paramMsalOAuth2TokenCache);
      }
    }
  }
  
  public AcquireTokenResult acquireToken(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    Telemetry.emit(new ApiStartEvent().putProperties(paramAcquireTokenOperationParameters).putApiId("201"));
    mBrokerResultFuture = new BrokerResultFuture();
    Object localObject = getBrokerAuthorizationIntent(paramAcquireTokenOperationParameters);
    Intent localIntent = new Intent(paramAcquireTokenOperationParameters.getAppContext(), BrokerActivity.class);
    localIntent.putExtra("broker_intent", (Parcelable)localObject);
    mBrokerResultFuture = new BrokerResultFuture();
    paramAcquireTokenOperationParameters.getActivity().startActivity(localIntent);
    localObject = mBrokerResultFuture.get();
    saveMsaAccountToCache((Bundle)localObject, (MsalOAuth2TokenCache)paramAcquireTokenOperationParameters.getTokenCache());
    try
    {
      paramAcquireTokenOperationParameters = new com/microsoft/identity/common/internal/result/MsalBrokerResultAdapter;
      paramAcquireTokenOperationParameters.<init>();
      paramAcquireTokenOperationParameters = paramAcquireTokenOperationParameters.getAcquireTokenResultFromResultBundle((Bundle)localObject);
      Telemetry.emit(new ApiEndEvent().putResult(paramAcquireTokenOperationParameters).putApiId("201"));
      return paramAcquireTokenOperationParameters;
    }
    catch (BaseException paramAcquireTokenOperationParameters)
    {
      Telemetry.emit(new ApiEndEvent().putException(paramAcquireTokenOperationParameters).putApiId("201"));
      throw paramAcquireTokenOperationParameters;
    }
  }
  
  public AcquireTokenResult acquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    return (AcquireTokenResult)invokeBrokerOperation(paramAcquireTokenSilentOperationParameters, new BrokerMsalController.2(this));
  }
  
  public void completeAcquireToken(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Telemetry.emit(new ApiStartEvent().putApiId("202").put("Microsoft.MSAL.result_code", String.valueOf(paramInt2)).put("Microsoft.MSAL.request_code", String.valueOf(paramInt1)));
    mBrokerResultFuture.setResultBundle(paramIntent.getExtras());
    Telemetry.emit(new ApiEndEvent().putApiId("202"));
  }
  
  public List<ICacheRecord> getAccounts(OperationParameters paramOperationParameters)
  {
    return (List)invokeBrokerOperation(paramOperationParameters, new BrokerMsalController.3(this));
  }
  
  public List<ICacheRecord> getCurrentAccount(OperationParameters paramOperationParameters)
  {
    if (!paramOperationParameters.getIsSharedDevice())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":getCurrentAccount");
      Logger.verbose(localStringBuilder.toString(), "Not a shared device, invoke getAccounts() instead of getCurrentAccount()");
      return getAccounts(paramOperationParameters);
    }
    return (List)invokeBrokerOperation(paramOperationParameters, new BrokerMsalController.6(this));
  }
  
  public boolean getDeviceMode(OperationParameters paramOperationParameters)
  {
    return ((Boolean)invokeBrokerOperation(paramOperationParameters, new BrokerMsalController.5(this))).booleanValue();
  }
  
  public boolean removeAccount(OperationParameters paramOperationParameters)
  {
    return ((Boolean)invokeBrokerOperation(paramOperationParameters, new BrokerMsalController.4(this))).booleanValue();
  }
  
  public boolean removeCurrentAccount(OperationParameters paramOperationParameters)
  {
    if (!paramOperationParameters.getIsSharedDevice())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":removeCurrentAccount");
      Logger.verbose(localStringBuilder.toString(), "Not a shared device, invoke removeAccount() instead of removeCurrentAccount()");
      return removeAccount(paramOperationParameters);
    }
    return ((Boolean)invokeBrokerOperation(paramOperationParameters, new BrokerMsalController.7(this))).booleanValue();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */