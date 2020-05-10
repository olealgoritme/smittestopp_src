package com.microsoft.identity.common.internal.result;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.util.HashMapExtensions;
import com.microsoft.identity.common.adal.internal.util.JsonExtensions;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.exception.UiRequiredException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.broker.BrokerResult.Builder;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.SdkType;
import com.microsoft.identity.common.internal.util.HeaderSerializationUtil;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;

public class MsalBrokerResultAdapter
  implements IBrokerResultAdapter
{
  public static final String TAG = "com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter";
  
  private BaseException getBaseExceptionFromErrorCodes(BrokerResult paramBrokerResult)
  {
    Object localObject1 = paramBrokerResult.getErrorCode();
    Object localObject2;
    Object localObject3;
    if ((!"interaction_required".equalsIgnoreCase((String)localObject1)) && (!"invalid_grant".equalsIgnoreCase((String)localObject1)) && (!"Broker refresh token is invalid".equalsIgnoreCase((String)localObject1)) && (!"no_tokens_found".equalsIgnoreCase((String)localObject1)))
    {
      if (("unauthorized_client".equalsIgnoreCase((String)localObject1)) && ("protection_policy_required".equalsIgnoreCase(paramBrokerResult.getSubErrorCode())))
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Received a IntuneAppProtectionPolicyRequiredException exception from Broker : ");
        ((StringBuilder)localObject3).append((String)localObject1);
        Logger.warn((String)localObject2, ((StringBuilder)localObject3).toString());
        localObject1 = getIntuneProtectionRequiredException(paramBrokerResult);
      }
      else if ("User cancelled".equalsIgnoreCase((String)localObject1))
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Received a User cancelled exception from Broker : ");
        ((StringBuilder)localObject3).append((String)localObject1);
        Logger.warn((String)localObject2, ((StringBuilder)localObject3).toString());
        localObject1 = new UserCancelException();
      }
      else if ("illegal_argument_exception".equalsIgnoreCase((String)localObject1))
      {
        localObject3 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Received a Argument exception from Broker : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Logger.warn((String)localObject3, ((StringBuilder)localObject2).toString());
        localObject1 = new ArgumentException("brokerTokenRequest", (String)localObject1, paramBrokerResult.getErrorMessage());
      }
      else if ((TextUtils.isEmpty(paramBrokerResult.getHttpResponseHeaders())) && (TextUtils.isEmpty(paramBrokerResult.getHttpResponseBody())))
      {
        localObject3 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Received a Client exception from Broker : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Logger.warn((String)localObject3, ((StringBuilder)localObject2).toString());
        localObject1 = new ClientException(paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
      }
      else
      {
        localObject3 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Received a Service exception from Broker : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Logger.warn((String)localObject3, ((StringBuilder)localObject2).toString());
        localObject1 = getServiceException(paramBrokerResult);
      }
    }
    else
    {
      localObject2 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Received a UIRequired exception from Broker : ");
      ((StringBuilder)localObject3).append((String)localObject1);
      Logger.warn((String)localObject2, ((StringBuilder)localObject3).toString());
      localObject1 = new UiRequiredException((String)localObject1, paramBrokerResult.getErrorMessage());
    }
    ((BaseException)localObject1).setCliTelemErrorCode(paramBrokerResult.getCliTelemErrorCode());
    ((BaseException)localObject1).setCliTelemSubErrorCode(paramBrokerResult.getCliTelemSubErrorCode());
    ((BaseException)localObject1).setCorrelationId(paramBrokerResult.getCorrelationId());
    ((BaseException)localObject1).setSpeRing(paramBrokerResult.getSpeRing());
    ((BaseException)localObject1).setRefreshTokenAge(paramBrokerResult.getRefreshTokenAge());
    return (BaseException)localObject1;
  }
  
  private BaseException getBaseExceptionFromExceptionType(String paramString, BrokerResult paramBrokerResult)
  {
    String str = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Received a ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" from Broker : ");
    ((StringBuilder)localObject).append(paramBrokerResult.getErrorCode());
    Logger.warn(str, ((StringBuilder)localObject).toString());
    if (paramString.equalsIgnoreCase(UiRequiredException.sName))
    {
      paramString = new UiRequiredException(paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
    }
    else if (paramString.equalsIgnoreCase(ServiceException.sName))
    {
      paramString = getServiceException(paramBrokerResult);
    }
    else if (paramString.equalsIgnoreCase(IntuneAppProtectionPolicyRequiredException.sName))
    {
      paramString = getIntuneProtectionRequiredException(paramBrokerResult);
    }
    else if (paramString.equalsIgnoreCase(UserCancelException.sName))
    {
      paramString = new UserCancelException();
    }
    else if (paramString.equalsIgnoreCase(ClientException.sName))
    {
      paramString = new ClientException(paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
    }
    else if (paramString.equalsIgnoreCase(ArgumentException.sName))
    {
      paramString = new ArgumentException("brokerTokenRequest", paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
    }
    else
    {
      localObject = TAG;
      paramString = a.a(" Exception type is unknown : ", paramString);
      paramString.append(paramBrokerResult.getErrorCode());
      paramString.append(", defaulting to Client Exception ");
      Logger.warn((String)localObject, paramString.toString());
      paramString = new ClientException(paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
    }
    paramString.setCliTelemErrorCode(paramBrokerResult.getCliTelemErrorCode());
    paramString.setCliTelemSubErrorCode(paramBrokerResult.getCliTelemSubErrorCode());
    paramString.setCorrelationId(paramBrokerResult.getCorrelationId());
    paramString.setSpeRing(paramBrokerResult.getSpeRing());
    paramString.setRefreshTokenAge(paramBrokerResult.getRefreshTokenAge());
    return paramString;
  }
  
  private IntuneAppProtectionPolicyRequiredException getIntuneProtectionRequiredException(BrokerResult paramBrokerResult)
  {
    IntuneAppProtectionPolicyRequiredException localIntuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(paramBrokerResult.getErrorCode(), paramBrokerResult.getErrorMessage());
    localIntuneAppProtectionPolicyRequiredException.setTenantId(paramBrokerResult.getTenantId());
    localIntuneAppProtectionPolicyRequiredException.setAuthorityUrl(paramBrokerResult.getAuthority());
    localIntuneAppProtectionPolicyRequiredException.setAccountUserId(paramBrokerResult.getLocalAccountId());
    localIntuneAppProtectionPolicyRequiredException.setAccountUpn(paramBrokerResult.getUserName());
    localIntuneAppProtectionPolicyRequiredException.setOauthSubErrorCode(paramBrokerResult.getSubErrorCode());
    try
    {
      localIntuneAppProtectionPolicyRequiredException.setHttpResponseBody(HashMapExtensions.jsonStringAsMap(paramBrokerResult.getHttpResponseBody()));
      if (paramBrokerResult.getHttpResponseHeaders() != null) {
        localIntuneAppProtectionPolicyRequiredException.setHttpResponseHeaders(HeaderSerializationUtil.fromJson(paramBrokerResult.getHttpResponseHeaders()));
      }
    }
    catch (JSONException paramBrokerResult)
    {
      Logger.warn(TAG, "Unable to parse json");
    }
    return localIntuneAppProtectionPolicyRequiredException;
  }
  
  private ServiceException getServiceException(BrokerResult paramBrokerResult)
  {
    Object localObject1 = paramBrokerResult.getErrorCode();
    Object localObject2 = paramBrokerResult.getErrorMessage();
    Object localObject3 = null;
    localObject2 = new ServiceException((String)localObject1, (String)localObject2, null);
    ((ServiceException)localObject2).setOauthSubErrorCode(paramBrokerResult.getSubErrorCode());
    try
    {
      if (paramBrokerResult.getHttpResponseBody() != null) {
        localObject1 = HashMapExtensions.jsonStringAsMap(paramBrokerResult.getHttpResponseBody());
      } else {
        localObject1 = null;
      }
      ((ServiceException)localObject2).setHttpResponseBody((HashMap)localObject1);
      localObject1 = localObject3;
      if (paramBrokerResult.getHttpResponseHeaders() != null) {
        localObject1 = HeaderSerializationUtil.fromJson(paramBrokerResult.getHttpResponseHeaders());
      }
      ((ServiceException)localObject2).setHttpResponseHeaders((HashMap)localObject1);
    }
    catch (JSONException paramBrokerResult)
    {
      Logger.warn(TAG, "Unable to parse json");
    }
    return (ServiceException)localObject2;
  }
  
  public ILocalAuthenticationResult authenticationResultFromBundle(Bundle paramBundle)
  {
    paramBundle = JsonExtensions.getBrokerResultFromJsonString(paramBundle.getString("broker_result_v2"));
    if (paramBundle == null)
    {
      Logger.error(TAG, "Broker Result not returned from Broker, ", null);
      return null;
    }
    Logger.info(TAG, "Broker Result returned from Bundle, constructing authentication result");
    paramBundle = paramBundle.getTenantProfileData();
    return new LocalAuthenticationResult((ICacheRecord)paramBundle.get(0), paramBundle, SdkType.MSAL);
  }
  
  public Bundle bundleFromAccounts(List<ICacheRecord> paramList)
  {
    Bundle localBundle = new Bundle();
    if (paramList != null) {
      localBundle.putString("broker_accounts", JsonExtensions.getJsonStringFromICacheRecordList(paramList));
    }
    return localBundle;
  }
  
  public Bundle bundleFromAuthenticationResult(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    Logger.info(TAG, "Constructing result bundle from ILocalAuthenticationResult");
    Object localObject = paramILocalAuthenticationResult.getAccountRecord();
    AccessTokenRecord localAccessTokenRecord = paramILocalAuthenticationResult.getAccessTokenRecord();
    localObject = new BrokerResult.Builder().tenantProfileRecords(paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData()).accessToken(paramILocalAuthenticationResult.getAccessToken()).idToken(paramILocalAuthenticationResult.getIdToken()).refreshToken(paramILocalAuthenticationResult.getRefreshToken()).homeAccountId(((IAccountRecord)localObject).getHomeAccountId()).localAccountId(((IAccountRecord)localObject).getLocalAccountId()).userName(((IAccountRecord)localObject).getUsername()).tokenType(localAccessTokenRecord.getAccessTokenType()).clientId(localAccessTokenRecord.getClientId()).familyId(paramILocalAuthenticationResult.getFamilyId()).scope(localAccessTokenRecord.getTarget()).clientInfo(((IAccountRecord)localObject).getClientInfo()).authority(localAccessTokenRecord.getAuthority()).environment(localAccessTokenRecord.getEnvironment()).tenantId(paramILocalAuthenticationResult.getTenantId()).expiresOn(Long.parseLong(localAccessTokenRecord.getExpiresOn())).extendedExpiresOn(Long.parseLong(localAccessTokenRecord.getExtendedExpiresOn())).cachedAt(Long.parseLong(localAccessTokenRecord.getCachedAt())).speRing(paramILocalAuthenticationResult.getSpeRing()).refreshTokenAge(paramILocalAuthenticationResult.getRefreshTokenAge()).success(true).build();
    paramILocalAuthenticationResult = new Bundle();
    paramILocalAuthenticationResult.putString("broker_result_v2", MsalBrokerRequestAdapter.sRequestAdapterGsonInstance.a(localObject, BrokerResult.class));
    paramILocalAuthenticationResult.putBoolean("broker_request_v2_success", true);
    return paramILocalAuthenticationResult;
  }
  
  public Bundle bundleFromBaseException(BaseException paramBaseException)
  {
    Logger.info(TAG, "Constructing result bundle from BaseException");
    BrokerResult.Builder localBuilder = new BrokerResult.Builder().success(false).errorCode(paramBaseException.getErrorCode()).errorMessage(paramBaseException.getMessage()).exceptionType(paramBaseException.getExceptionName()).correlationId(paramBaseException.getCorrelationId()).cliTelemErrorCode(paramBaseException.getCliTelemErrorCode()).cliTelemSubErrorCode(paramBaseException.getCliTelemSubErrorCode()).speRing(paramBaseException.getSpeRing()).refreshTokenAge(paramBaseException.getRefreshTokenAge());
    if ((paramBaseException instanceof ServiceException))
    {
      ServiceException localServiceException = (ServiceException)paramBaseException;
      localBuilder.oauthSubErrorCode(localServiceException.getOAuthSubErrorCode()).httpStatusCode(localServiceException.getHttpStatusCode()).httpResponseHeaders(HeaderSerializationUtil.toJson(localServiceException.getHttpResponseHeaders())).httpResponseBody(MsalBrokerRequestAdapter.sRequestAdapterGsonInstance.a(localServiceException.getHttpResponseBody()));
    }
    if ((paramBaseException instanceof IntuneAppProtectionPolicyRequiredException))
    {
      paramBaseException = (IntuneAppProtectionPolicyRequiredException)paramBaseException;
      localBuilder.userName(paramBaseException.getAccountUpn()).localAccountId(paramBaseException.getAccountUserId()).authority(paramBaseException.getAuthorityUrl()).tenantId(paramBaseException.getTenantId());
    }
    paramBaseException = new Bundle();
    paramBaseException.putString("broker_result_v2", MsalBrokerRequestAdapter.sRequestAdapterGsonInstance.a(localBuilder.build(), BrokerResult.class));
    paramBaseException.putBoolean("broker_request_v2_success", false);
    return paramBaseException;
  }
  
  public Bundle bundleFromDeviceMode(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("broker_device_mode", paramBoolean);
    return localBundle;
  }
  
  public List<ICacheRecord> getAccountsFromResultBundle(Bundle paramBundle)
  {
    String str = paramBundle.getString("broker_accounts");
    if (str != null) {
      return JsonExtensions.getICacheRecordListFromJsonString(str);
    }
    throw new MsalBrokerResultAdapter().getBaseExceptionFromBundle(paramBundle);
  }
  
  public AcquireTokenResult getAcquireTokenResultFromResultBundle(Bundle paramBundle)
  {
    MsalBrokerResultAdapter localMsalBrokerResultAdapter = new MsalBrokerResultAdapter();
    if (paramBundle.getBoolean("broker_request_v2_success"))
    {
      AcquireTokenResult localAcquireTokenResult = new AcquireTokenResult();
      localAcquireTokenResult.setLocalAuthenticationResult(localMsalBrokerResultAdapter.authenticationResultFromBundle(paramBundle));
      return localAcquireTokenResult;
    }
    throw localMsalBrokerResultAdapter.getBaseExceptionFromBundle(paramBundle);
  }
  
  public BaseException getBaseExceptionFromBundle(Bundle paramBundle)
  {
    Logger.info(TAG, "Constructing exception from result bundle");
    paramBundle = JsonExtensions.getBrokerResultFromJsonString(paramBundle.getString("broker_result_v2"));
    if (paramBundle == null)
    {
      Logger.error(TAG, "Broker Result not returned from Broker", null);
      return new BaseException("unknown_error", "Broker Result not returned from Broker");
    }
    String str = paramBundle.getExceptionType();
    if (!TextUtils.isEmpty(str)) {
      return getBaseExceptionFromExceptionType(str, paramBundle);
    }
    Logger.info(TAG, "Exception type is not returned from the broker, using error codes to transform to the right exception");
    return getBaseExceptionFromErrorCodes(paramBundle);
  }
  
  public boolean getDeviceModeFromResultBundle(Bundle paramBundle)
  {
    if (paramBundle.containsKey("broker_device_mode")) {
      return paramBundle.getBoolean("broker_device_mode");
    }
    throw new MsalBrokerResultAdapter().getBaseExceptionFromBundle(paramBundle);
  }
  
  public void verifyHelloFromResultBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!StringUtil.isEmpty(paramBundle.getString("common.broker.protocol.version.name")))
      {
        String str = paramBundle.getString("common.broker.protocol.version.name");
        paramBundle = a.a(new StringBuilder(), TAG, ":verifyHelloFromResultBundle");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Able to establish the connect, the broker protocol version in common is [");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        Logger.info(paramBundle, localStringBuilder.toString());
        return;
      }
      if ((!StringUtil.isEmpty(paramBundle.getString("error"))) && (!StringUtil.isEmpty(paramBundle.getString("error_description")))) {
        throw new ClientException(paramBundle.getString("error"), paramBundle.getString("error_description"));
      }
      if ((paramBundle.get("broker_result_v2") != null) && ((paramBundle.get("broker_result_v2") instanceof BrokerResult)))
      {
        paramBundle = (BrokerResult)paramBundle.get("broker_result_v2");
        throw new ClientException(paramBundle.getErrorCode(), paramBundle.getErrorMessage());
      }
      paramBundle = new StringBuilder();
      paramBundle.append(TAG);
      paramBundle.append(":verifyHelloFromResultBundle");
      Logger.warn(paramBundle.toString(), "The result bundle is not in a recognizable format.");
      throw new ClientException("unsupported_broker_version", "Please update Intune Company Portal and/or Microsoft Authenticator to the latest version.");
    }
    paramBundle = new StringBuilder();
    paramBundle.append(TAG);
    paramBundle.append(":verifyHelloFromResultBundle");
    Logger.warn(paramBundle.toString(), "The hello result bundle is null.");
    throw new ClientException("unsupported_broker_version", "Please update Intune Company Portal and/or Microsoft Authenticator to the latest version.");
  }
  
  public void verifyRemoveAccountResultFromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    BrokerResult localBrokerResult = JsonExtensions.getBrokerResultFromJsonString(paramBundle.getString("broker_result_v2"));
    if ((localBrokerResult != null) && (localBrokerResult.isSuccess())) {
      return;
    }
    Logger.warn(TAG, "Failed to remove account.");
    throw getBaseExceptionFromBundle(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */