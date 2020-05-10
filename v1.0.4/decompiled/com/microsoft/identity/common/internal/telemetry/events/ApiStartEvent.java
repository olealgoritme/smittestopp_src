package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.BrokerAcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.BrokerAcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.Properties;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

public class ApiStartEvent
  extends BaseEvent
{
  public static final String TAG = "ApiStartEvent";
  
  public ApiStartEvent()
  {
    names("api_start_event");
    types("Microsoft.MSAL.api_event");
  }
  
  public static String sanitizeUrlForTelemetry(String paramString)
  {
    Object localObject = null;
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(paramString);
      paramString = localURL;
    }
    catch (MalformedURLException paramString)
    {
      Logger.errorPII(TAG, "Url is invalid", paramString);
      paramString = null;
    }
    if (paramString == null) {
      paramString = (String)localObject;
    } else {
      paramString = sanitizeUrlForTelemetry(paramString);
    }
    return paramString;
  }
  
  public static String sanitizeUrlForTelemetry(URL paramURL)
  {
    if (paramURL == null) {
      return null;
    }
    String str = paramURL.getAuthority();
    String[] arrayOfString = paramURL.getPath().split("/");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol());
    localStringBuilder.append("://");
    localStringBuilder.append(str);
    localStringBuilder.append('/');
    for (int i = 2; i < arrayOfString.length; i++)
    {
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('/');
    }
    return localStringBuilder.toString();
  }
  
  public ApiStartEvent authority(String paramString)
  {
    put("Microsoft.MSAL.authority", sanitizeUrlForTelemetry(paramString));
    return this;
  }
  
  public ApiStartEvent put(String paramString1, String paramString2)
  {
    super.put(paramString1, paramString2);
    return this;
  }
  
  public ApiStartEvent putApiId(String paramString)
  {
    put("Microsoft.MSAL.api_id", paramString);
    return this;
  }
  
  public ApiStartEvent putAuthorityType(String paramString)
  {
    put("Microsoft.MSAL.authority_type", paramString);
    return this;
  }
  
  public ApiStartEvent putExtendedExpiresOnSetting(String paramString)
  {
    put("Microsoft.MSAL.extended_expires_on_setting", paramString);
    return this;
  }
  
  public ApiStartEvent putLoginHint(String paramString)
  {
    try
    {
      put("Microsoft.MSAL.login_hint", StringExtensions.createHash(paramString));
    }
    catch (UnsupportedEncodingException paramString) {}catch (NoSuchAlgorithmException paramString) {}
    Logger.warn(TAG, paramString.getMessage());
    return this;
  }
  
  public ApiStartEvent putProperties(OperationParameters paramOperationParameters)
  {
    if (paramOperationParameters == null) {
      return this;
    }
    Object localObject = paramOperationParameters.getAuthority();
    if (localObject != null)
    {
      if (((Authority)localObject).getAuthorityURL() != null) {
        put("Microsoft.MSAL.authority", ((Authority)localObject).getAuthorityURL().getAuthority());
      }
      put("Microsoft.MSAL.authority_type", ((Authority)localObject).getAuthorityTypeString());
    }
    if (paramOperationParameters.getSdkType() != null) {
      put("Microsoft.MSAL.sdk_name", paramOperationParameters.getSdkType().name());
    }
    put("Microsoft.MSAL.sdk_version", paramOperationParameters.getSdkVersion());
    if (StringUtil.isEmpty(paramOperationParameters.getClaimsRequestJson())) {
      localObject = "false";
    } else {
      localObject = "true";
    }
    put("Microsoft.MSAL.claim_request", (String)localObject);
    put("Microsoft.MSAL.redirect_uri", paramOperationParameters.getRedirectUri());
    put("Microsoft.MSAL.client_id", paramOperationParameters.getClientId());
    if ((paramOperationParameters instanceof AcquireTokenOperationParameters))
    {
      localObject = (AcquireTokenOperationParameters)paramOperationParameters;
      if (((AcquireTokenOperationParameters)localObject).getAuthorizationAgent() != null) {
        put("Microsoft.MSAL.user_agent", ((AcquireTokenOperationParameters)localObject).getAuthorizationAgent().name());
      }
      put("Microsoft.MSAL.login_hint", ((AcquireTokenOperationParameters)localObject).getLoginHint());
      if (((AcquireTokenOperationParameters)localObject).getExtraQueryStringParameters() != null) {
        put("Microsoft.MSAL.query_params", String.valueOf(((AcquireTokenOperationParameters)localObject).getExtraQueryStringParameters().size()));
      }
      if (((AcquireTokenOperationParameters)localObject).getOpenIdConnectPromptParameter() != null) {
        put("Microsoft.MSAL.prompt_behavior", ((AcquireTokenOperationParameters)localObject).getOpenIdConnectPromptParameter().toString());
      }
    }
    if ((paramOperationParameters instanceof AcquireTokenSilentOperationParameters))
    {
      if (paramOperationParameters.getAccount() != null) {
        put("Microsoft.MSAL.user_id", paramOperationParameters.getAccount().getHomeAccountId());
      }
      put("Microsoft.MSAL.force_refresh", String.valueOf(paramOperationParameters.getForceRefresh()));
      put("Microsoft.MSAL.broker_protocol_version", String.valueOf(paramOperationParameters.getRequiredBrokerProtocolVersion()));
      if (paramOperationParameters.getScopes() != null)
      {
        put("Microsoft.MSAL.scope_size", String.valueOf(paramOperationParameters.getScopes().size()));
        put("Microsoft.MSAL.scope_value", paramOperationParameters.getScopes().toString());
      }
    }
    boolean bool = paramOperationParameters instanceof BrokerAcquireTokenOperationParameters;
    bool = paramOperationParameters instanceof BrokerAcquireTokenSilentOperationParameters;
    return this;
  }
  
  public ApiStartEvent putValidationStatus(String paramString)
  {
    put("Microsoft.MSAL.authority_validation_status", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */