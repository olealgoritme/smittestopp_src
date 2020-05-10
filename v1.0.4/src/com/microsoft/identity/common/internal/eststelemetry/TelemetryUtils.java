package com.microsoft.identity.common.internal.eststelemetry;

import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.IErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;

public class TelemetryUtils
{
  public static String errorFromAcquireTokenResult(AcquireTokenResult paramAcquireTokenResult)
  {
    if (paramAcquireTokenResult == null) {
      return "unknown_error";
    }
    String str = getErrorFromAuthorizationResult(paramAcquireTokenResult.getAuthorizationResult());
    if (str != null) {
      return str;
    }
    return getErrorFromTokenResult(paramAcquireTokenResult.getTokenResult());
  }
  
  public static String getErrorFromAuthorizationResult(AuthorizationResult paramAuthorizationResult)
  {
    if ((paramAuthorizationResult != null) && (paramAuthorizationResult.getErrorResponse() != null)) {
      return paramAuthorizationResult.getErrorResponse().getError();
    }
    return null;
  }
  
  public static String getErrorFromTokenResult(TokenResult paramTokenResult)
  {
    if ((paramTokenResult != null) && (paramTokenResult.getErrorResponse() != null)) {
      return paramTokenResult.getErrorResponse().getError();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.eststelemetry.TelemetryUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */