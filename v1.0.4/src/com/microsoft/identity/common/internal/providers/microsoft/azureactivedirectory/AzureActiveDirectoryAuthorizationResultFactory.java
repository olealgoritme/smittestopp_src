package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.HashMap;

public class AzureActiveDirectoryAuthorizationResultFactory
  extends AuthorizationResultFactory<AzureActiveDirectoryAuthorizationResult, AzureActiveDirectoryAuthorizationRequest>
{
  public static final String ERROR_CODES = "error_codes";
  public static final String TAG = "AzureActiveDirectoryAuthorizationResultFactory";
  
  private AzureActiveDirectoryAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus paramAuthorizationStatus, String paramString1, String paramString2)
  {
    return new AzureActiveDirectoryAuthorizationResult(paramAuthorizationStatus, new AzureActiveDirectoryAuthorizationErrorResponse(paramString1, paramString2));
  }
  
  private AzureActiveDirectoryAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus paramAuthorizationStatus, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Logger.info(TAG, paramString4, "Error is returned from webview redirect");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errorDescription: ");
    localStringBuilder.append(paramString2);
    Logger.infoPII(str, paramString4, localStringBuilder.toString());
    paramString1 = new AzureActiveDirectoryAuthorizationErrorResponse(paramString1, paramString2);
    paramString1.setErrorCodes(paramString3);
    return new AzureActiveDirectoryAuthorizationResult(paramAuthorizationStatus, paramString1);
  }
  
  private AzureActiveDirectoryAuthorizationResult parseUrlAndCreateAuthorizationResult(String paramString1, String paramString2)
  {
    HashMap localHashMap = StringExtensions.getUrlParameters(paramString1);
    if ((localHashMap != null) && (!localHashMap.isEmpty()))
    {
      paramString1 = (String)localHashMap.get("correlation_id");
      if (localHashMap.containsKey("code")) {
        paramString1 = validateAndCreateAuthorizationResult((String)localHashMap.get("code"), (String)localHashMap.get("state"), paramString2, paramString1);
      } else if (localHashMap.containsKey("error")) {
        paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, (String)localHashMap.get("error"), (String)localHashMap.get("error_description"), (String)localHashMap.get("error_codes"), paramString1);
      } else {
        paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "The authorization server returned an invalid response.");
      }
      return paramString1;
    }
    Logger.warn(TAG, "Invalid server response, empty query string from the webview redirect.");
    return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "The authorization server returned an invalid response.");
  }
  
  private AzureActiveDirectoryAuthorizationResult validateAndCreateAuthorizationResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (StringUtil.isEmpty(paramString2))
    {
      Logger.warn(TAG, paramString4, "State parameter is not returned from the webview redirect.");
      paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", "State is not returned");
    }
    else if ((!StringUtil.isEmpty(paramString3)) && (paramString3.equals(paramString2)))
    {
      Logger.info(TAG, paramString4, "Auth code is successfully returned from webview redirect.");
      paramString1 = new AzureActiveDirectoryAuthorizationResponse(paramString1, paramString2);
      paramString1.setCorrelationId(paramString4);
      paramString1 = new AzureActiveDirectoryAuthorizationResult(AuthorizationStatus.SUCCESS, paramString1);
    }
    else
    {
      Logger.warn(TAG, paramString4, "State parameter returned from the redirect is not same as the one sent in request.");
      paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", "Returned state from authorize endpoint is not the same as the one sent");
    }
    return paramString1;
  }
  
  public AzureActiveDirectoryAuthorizationResult createAuthorizationResult(int paramInt, Intent paramIntent, AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      Object localObject = paramIntent.getExtras();
      int i = ((Bundle)localObject).getInt("com.microsoft.aad.adal:RequestId");
      paramAzureActiveDirectoryAuthorizationRequest = null;
      switch (paramInt)
      {
      case 2004: 
      default: 
        paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "Unknown error", a.b("Unknown result code returned [", paramInt, "]"));
        break;
      case 2007: 
        Logger.verbose(TAG, "Device needs to have broker installed, we expect the apps to call usback when the broker is installed");
        paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "Device needs to have broker installed");
        break;
      case 2006: 
        Logger.verbose(TAG, "Device needs to have broker installed, we expect the apps to call usback when the broker is installed");
        paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "Device needs to have broker installed");
        break;
      case 2005: 
        localObject = ((Bundle)localObject).getSerializable("com.microsoft.aad.adal:AuthenticationException");
        paramIntent = paramAzureActiveDirectoryAuthorizationRequest;
        if (localObject != null)
        {
          paramIntent = paramAzureActiveDirectoryAuthorizationRequest;
          if ((localObject instanceof ClientException))
          {
            paramIntent = (ClientException)localObject;
            paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, paramIntent.getErrorCode(), paramIntent.getMessage());
          }
        }
        break;
      case 2003: 
        paramIntent = parseUrlAndCreateAuthorizationResult(((Bundle)localObject).getString("com.microsoft.aad.adal:BrowserFinalUrl", ""), paramIntent.getStringExtra("request_state_parameter"));
        break;
      case 2002: 
        paramIntent = ((Bundle)localObject).getString("com.microsoft.aad.adal:BrowserErrorCode");
        paramAzureActiveDirectoryAuthorizationRequest = ((Bundle)localObject).getString("com.microsoft.aad.adal:BrowserErrorMessage");
        paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, paramIntent, paramAzureActiveDirectoryAuthorizationRequest);
        break;
      case 2001: 
        paramAzureActiveDirectoryAuthorizationRequest = TAG;
        paramIntent = new StringBuilder();
        paramIntent.append("User cancel the request in webview: ");
        paramIntent.append(i);
        Logger.verbose(paramAzureActiveDirectoryAuthorizationRequest, paramIntent.toString());
        paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.USER_CANCEL, "user_cancelled", "User pressed device back button to cancel the flow.");
      }
      paramAzureActiveDirectoryAuthorizationRequest = paramIntent;
      if (paramIntent == null) {
        paramAzureActiveDirectoryAuthorizationRequest = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "Unknown error", a.b("Unknown result code returned [", paramInt, "]"));
      }
      return paramAzureActiveDirectoryAuthorizationRequest;
    }
    return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "Received null intent");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationResultFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */