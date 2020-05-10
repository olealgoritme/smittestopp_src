package com.microsoft.identity.common.internal.result;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.ADALError;
import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import java.util.Date;

public class AdalBrokerResultAdapter
  implements IBrokerResultAdapter
{
  public static final String TAG = "com.microsoft.identity.common.internal.result.AdalBrokerResultAdapter";
  
  private String getAuthority(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    Uri.Builder localBuilder = new Uri.Builder().scheme("https");
    localBuilder.authority(paramILocalAuthenticationResult.getAccessTokenRecord().getEnvironment());
    if (!TextUtils.isEmpty(paramILocalAuthenticationResult.getTenantId())) {
      localBuilder.appendPath(paramILocalAuthenticationResult.getTenantId());
    } else {
      localBuilder.appendPath("common");
    }
    return localBuilder.build().toString();
  }
  
  private void mapExceptionToBundle(Bundle paramBundle, BaseException paramBaseException)
  {
    if ((paramBaseException instanceof UserCancelException))
    {
      Logger.info(TAG, "Setting Bundle result from UserCancelException.");
      setErrorToResultBundle(paramBundle, 4, paramBaseException.getMessage());
    }
    else if ((paramBaseException instanceof ArgumentException))
    {
      Logger.info(TAG, "Setting Bundle result from ArgumentException.");
      setErrorToResultBundle(paramBundle, 7, paramBaseException.getMessage());
    }
    else if ((paramBaseException instanceof ClientException))
    {
      setClientExceptionPropertiesToBundle(paramBundle, (ClientException)paramBaseException);
    }
    else if ((paramBaseException instanceof ServiceException))
    {
      setServiceExceptionPropertiesToBundle(paramBundle, (ServiceException)paramBaseException);
    }
    else
    {
      Logger.info(TAG, "Setting Bundle result for Unknown Exception/Bad result.");
      setErrorToResultBundle(paramBundle, 8, paramBaseException.getMessage());
    }
  }
  
  private void setClientExceptionPropertiesToBundle(Bundle paramBundle, ClientException paramClientException)
  {
    Logger.info(TAG, "Setting properties from ClientException.");
    if (paramClientException.getErrorCode().equalsIgnoreCase("device_network_not_available")) {
      setErrorToResultBundle(paramBundle, 3, ADALError.DEVICE_CONNECTION_IS_NOT_AVAILABLE.getDescription());
    } else if (paramClientException.getErrorCode().equalsIgnoreCase("device_network_not_available_doze_mode")) {
      setErrorToResultBundle(paramBundle, 3, ADALError.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION.getDescription());
    } else if (paramClientException.getErrorCode().equalsIgnoreCase("io_error")) {
      setErrorToResultBundle(paramBundle, 3, ADALError.IO_EXCEPTION.getDescription());
    }
  }
  
  private void setErrorToResultBundle(Bundle paramBundle, int paramInt, String paramString)
  {
    paramBundle.putInt("errorCode", paramInt);
    paramBundle.putString("errorMessage", paramString);
  }
  
  private void setIntuneAppProtectionPropertiesToBundle(Bundle paramBundle, IntuneAppProtectionPolicyRequiredException paramIntuneAppProtectionPolicyRequiredException)
  {
    Logger.info(TAG, "Setting properties from IntuneAppProtectionPolicyRequiredException.");
    ADALError localADALError = ADALError.AUTH_FAILED_INTUNE_POLICY_REQUIRED;
    paramBundle.putString("com.microsoft.aad.adal:BrowserErrorCode", "AUTH_FAILED_INTUNE_POLICY_REQUIRED");
    paramBundle.putString("account.userinfo.tenantid", paramIntuneAppProtectionPolicyRequiredException.getTenantId());
    paramBundle.putString("account.authority", paramIntuneAppProtectionPolicyRequiredException.getAuthorityUrl());
    paramBundle.putString("account.userinfo.userid", paramIntuneAppProtectionPolicyRequiredException.getAccountUserId());
    paramBundle.putString("account.name", paramIntuneAppProtectionPolicyRequiredException.getAccountUpn());
  }
  
  private void setServiceExceptionPropertiesToBundle(Bundle paramBundle, ServiceException paramServiceException)
  {
    Logger.info(TAG, "Setting properties from ServiceException.");
    paramBundle.putString("error", paramServiceException.getErrorCode());
    paramBundle.putString("error_description", paramServiceException.getMessage());
    paramBundle.putString("suberror", paramServiceException.getOAuthSubErrorCode());
    if (paramServiceException.getHttpResponseBody() != null) {
      paramBundle.putSerializable("response_body", paramServiceException.getHttpResponseBody());
    }
    if (paramServiceException.getHttpResponseHeaders() != null) {
      paramBundle.putSerializable("response_headers", paramServiceException.getHttpResponseHeaders());
    }
    paramBundle.putInt("status_code", paramServiceException.getHttpStatusCode());
    if ((paramServiceException instanceof IntuneAppProtectionPolicyRequiredException)) {
      setIntuneAppProtectionPropertiesToBundle(paramBundle, (IntuneAppProtectionPolicyRequiredException)paramServiceException);
    }
    if ((paramServiceException.getErrorCode().equalsIgnoreCase("invalid_grant")) || (paramServiceException.getErrorCode().equalsIgnoreCase("interaction_required")))
    {
      paramBundle.putString("error", ADALError.AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED.getDescription());
      paramBundle.putString("error_description", paramServiceException.getMessage());
    }
  }
  
  public ILocalAuthenticationResult authenticationResultFromBundle(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public Bundle bundleFromAuthenticationResult(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    Logger.verbose(TAG, "Constructing success bundle from Authentication Result.");
    Bundle localBundle = new Bundle();
    IAccountRecord localIAccountRecord = paramILocalAuthenticationResult.getAccountRecord();
    localBundle.putString("account.login.hint", localIAccountRecord.getUsername());
    localBundle.putString("account.userinfo.userid", localIAccountRecord.getLocalAccountId());
    localBundle.putString("account.userinfo.userid.displayable", localIAccountRecord.getUsername());
    localBundle.putString("account.userinfo.given.name", localIAccountRecord.getFirstName());
    localBundle.putString("account.userinfo.family.name", localIAccountRecord.getFamilyName());
    localBundle.putString("account.userinfo.identity.provider", SchemaUtil.getIdentityProvider(paramILocalAuthenticationResult.getIdToken()));
    localBundle.putString("account.userinfo.tenantid", paramILocalAuthenticationResult.getTenantId());
    localBundle.putLong("account.expiredate", paramILocalAuthenticationResult.getExpiresOn().getTime());
    localBundle.putString("account.authority", getAuthority(paramILocalAuthenticationResult));
    localBundle.putString("account.access.token", paramILocalAuthenticationResult.getAccessToken());
    localBundle.putString("account.idtoken", paramILocalAuthenticationResult.getIdToken());
    localBundle.putString("cliteleminfo.spe_ring", paramILocalAuthenticationResult.getSpeRing());
    localBundle.putString("cliteleminfo.rt_age", paramILocalAuthenticationResult.getRefreshTokenAge());
    return localBundle;
  }
  
  public Bundle bundleFromBaseException(BaseException paramBaseException)
  {
    Logger.verbose(TAG, "Constructing error bundle from exception.");
    Bundle localBundle = new Bundle();
    localBundle.putString("com.microsoft.aad.adal:BrowserErrorCode", paramBaseException.getErrorCode());
    localBundle.putString("com.microsoft.aad.adal:BrowserErrorMessage", paramBaseException.getMessage());
    localBundle.putString("cliteleminfo.spe_ring", paramBaseException.getSpeRing());
    localBundle.putString("cliteleminfo.rt_age", paramBaseException.getRefreshTokenAge());
    localBundle.putString("cliteleminfo.server_error", paramBaseException.getCliTelemErrorCode());
    localBundle.putString("cliteleminfo.server_suberror", paramBaseException.getCliTelemSubErrorCode());
    mapExceptionToBundle(localBundle, paramBaseException);
    return localBundle;
  }
  
  public BaseException getBaseExceptionFromBundle(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.result.AdalBrokerResultAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */