package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.controllers.ExceptionAdapter;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.internal.telemetry.Properties;

public class ApiEndEvent
  extends BaseEvent
{
  public ApiEndEvent()
  {
    names("api_end_event");
    types("Microsoft.MSAL.api_event");
  }
  
  public ApiEndEvent isApiCallSuccessful(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      put("_is_successful", paramBoolean.toString());
    }
    return this;
  }
  
  public ApiEndEvent put(String paramString1, String paramString2)
  {
    super.put(paramString1, paramString2);
    return this;
  }
  
  public ApiEndEvent putApiErrorCode(String paramString)
  {
    put("Microsoft.MSAL.api_error_code", paramString);
    return this;
  }
  
  public ApiEndEvent putApiId(String paramString)
  {
    put("Microsoft.MSAL.api_id", paramString);
    return this;
  }
  
  public ApiEndEvent putException(Exception paramException)
  {
    if (paramException == null) {
      return this;
    }
    paramException = ExceptionAdapter.baseExceptionFromException(paramException);
    if ((paramException instanceof UserCancelException)) {
      put("Microsoft.MSAL.user_cancel", "true");
    }
    put("Microsoft.MSAL.server_error_code", paramException.getCliTelemErrorCode());
    put("Microsoft.MSAL.server_sub_error_code", paramException.getCliTelemSubErrorCode());
    put("Microsoft.MSAL.api_error_code", paramException.getErrorCode());
    put("Microsoft.MSAL.spe_ring", paramException.getSpeRing());
    put("Microsoft.MSAL.error_description", paramException.getMessage());
    put("Microsoft.MSAL.rt_age", paramException.getRefreshTokenAge());
    put("_is_successful", "false");
    return this;
  }
  
  public ApiEndEvent putResult(AcquireTokenResult paramAcquireTokenResult)
  {
    if (paramAcquireTokenResult == null) {
      return this;
    }
    if (paramAcquireTokenResult.getSucceeded() != null) {
      put("_is_successful", paramAcquireTokenResult.getSucceeded().toString());
    }
    if (paramAcquireTokenResult.getLocalAuthenticationResult() != null)
    {
      put("Microsoft.MSAL.user_id", paramAcquireTokenResult.getLocalAuthenticationResult().getUniqueId());
      put("Microsoft.MSAL.tenant_id", paramAcquireTokenResult.getLocalAuthenticationResult().getTenantId());
      put("Microsoft.MSAL.spe_ring", paramAcquireTokenResult.getLocalAuthenticationResult().getSpeRing());
      put("Microsoft.MSAL.rt_age", paramAcquireTokenResult.getLocalAuthenticationResult().getRefreshTokenAge());
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */