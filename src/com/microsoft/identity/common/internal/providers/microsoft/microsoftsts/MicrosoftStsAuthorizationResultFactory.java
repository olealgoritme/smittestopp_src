package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import android.content.Intent;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.HashMap;

public class MicrosoftStsAuthorizationResultFactory
  extends AuthorizationResultFactory<MicrosoftStsAuthorizationResult, MicrosoftStsAuthorizationRequest>
{
  public static final String ERROR_SUBCODE = "error_subcode";
  public static final String TAG = "MicrosoftStsAuthorizationResultFactory";
  
  private MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus paramAuthorizationStatus, String paramString1, String paramString2)
  {
    Logger.info(TAG, "Error is returned from webview redirect");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" errorDescription: ");
    localStringBuilder.append(paramString2);
    Logger.infoPII(str, localStringBuilder.toString());
    return new MicrosoftStsAuthorizationResult(paramAuthorizationStatus, new MicrosoftStsAuthorizationErrorResponse(paramString1, paramString2));
  }
  
  private MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus paramAuthorizationStatus, String paramString1, String paramString2, String paramString3)
  {
    Logger.info(TAG, "Error is returned from webview redirect");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("error: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("error subcode:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" errorDescription: ");
    localStringBuilder.append(paramString3);
    Logger.infoPII(str, localStringBuilder.toString());
    return new MicrosoftStsAuthorizationResult(paramAuthorizationStatus, new MicrosoftStsAuthorizationErrorResponse(paramString1, paramString2, paramString3));
  }
  
  private MicrosoftStsAuthorizationResult parseUrlAndCreateAuthorizationResponse(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      paramString1 = null;
    } else {
      paramString1 = StringExtensions.getUrlParameters(paramString1);
    }
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if (paramString1.containsKey("code")) {
        paramString1 = validateAndCreateAuthorizationResult(paramString1, paramString2);
      } else if (paramString1.containsKey("error")) {
        paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, (String)paramString1.get("error"), (String)paramString1.get("error_subcode"), (String)paramString1.get("error_description"));
      } else {
        paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "The authorization server returned an invalid response.");
      }
    }
    else
    {
      Logger.warn(TAG, "Invalid server response, empty query string from the webview redirect.");
      paramString1 = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "The authorization server returned an invalid response.");
    }
    return paramString1;
  }
  
  private MicrosoftStsAuthorizationResult validateAndCreateAuthorizationResult(HashMap<String, String> paramHashMap, String paramString)
  {
    String str1 = (String)paramHashMap.get("state");
    String str2 = (String)paramHashMap.get("code");
    if (StringUtil.isEmpty(str1))
    {
      Logger.warn(TAG, "State parameter is not returned from the webview redirect.");
      paramHashMap = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", "State is not returned");
    }
    else if ((!StringUtil.isEmpty(paramString)) && (paramString.equals(str1)))
    {
      Logger.info(TAG, "Auth code is successfully returned from webview redirect.");
      paramHashMap = new MicrosoftStsAuthorizationResponse(str2, str1, paramHashMap);
      paramHashMap = new MicrosoftStsAuthorizationResult(AuthorizationStatus.SUCCESS, paramHashMap);
    }
    else
    {
      Logger.warn(TAG, "State parameter returned from the redirect is not same as the one sent in request.");
      paramHashMap = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", "Returned state from authorize endpoint is not the same as the one sent");
    }
    return paramHashMap;
  }
  
  public MicrosoftStsAuthorizationResult createAuthorizationResult(int paramInt, Intent paramIntent, MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest)
  {
    if (paramIntent == null) {
      return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "Received null intent");
    }
    switch (paramInt)
    {
    case 2004: 
    case 2005: 
    default: 
      paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "Unknown error", "Unknown result code returned ");
      break;
    case 2008: 
      Logger.info(TAG, null, "SDK cancelled the authorization request.");
      paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.SDK_CANCEL, "auth_cancelled_by_sdk", "Sdk cancelled the auth flow as the app launched a new interactive auth request.");
      break;
    case 2007: 
      Logger.info(TAG, "Device Registration needed, need to start WPJ");
      paramMicrosoftStsAuthorizationRequest = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "Device needs to be registered to access the resource", "Device needs to be registered to access the resource");
      ((MicrosoftStsAuthorizationErrorResponse)paramMicrosoftStsAuthorizationRequest.getAuthorizationErrorResponse()).setUserName(paramIntent.getStringExtra("username"));
      paramIntent = paramMicrosoftStsAuthorizationRequest;
      break;
    case 2006: 
      Logger.info(TAG, "Device needs to have broker installed, we expect the apps to call usback when the broker is installed");
      paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "authorization_failed", "Device needs to have broker installed");
      break;
    case 2003: 
      paramIntent = parseUrlAndCreateAuthorizationResponse(paramIntent.getStringExtra("com.microsoft.identity.client.final.url"), paramMicrosoftStsAuthorizationRequest.getState());
      break;
    case 2002: 
      paramMicrosoftStsAuthorizationRequest = paramIntent.getStringExtra("com.microsoft.aad.adal:BrowserErrorCode");
      String str = paramIntent.getStringExtra("com.microsoft.aad.adal:BrowserErrorSubCode");
      paramIntent = paramIntent.getStringExtra("com.microsoft.aad.adal:BrowserErrorMessage");
      paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, paramMicrosoftStsAuthorizationRequest, str, paramIntent);
      break;
    case 2001: 
      Logger.info(TAG, null, "User cancel the authorization request in UI.");
      paramIntent = createAuthorizationResultWithErrorResponse(AuthorizationStatus.USER_CANCEL, "user_cancelled", "User pressed device back button to cancel the flow.");
    }
    return paramIntent;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResultFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */