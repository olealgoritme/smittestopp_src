package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.telemetry.Properties;

public class BrokerEndEvent
  extends BaseEvent
{
  public BrokerEndEvent()
  {
    names("broker_end_event");
    types("Microsoft.MSAL.broker_event");
  }
  
  public BrokerEndEvent isSuccessful(boolean paramBoolean)
  {
    put("_is_successful", String.valueOf(paramBoolean));
    return this;
  }
  
  public BrokerEndEvent putAction(String paramString)
  {
    put("Microsoft.MSAL.broker_action", paramString);
    return this;
  }
  
  public BrokerEndEvent putErrorCode(String paramString)
  {
    put("Microsoft.MSAL.api_error_code", paramString);
    return this;
  }
  
  public BrokerEndEvent putErrorDescription(String paramString)
  {
    put("Microsoft.MSAL.error_description", paramString);
    return this;
  }
  
  public BrokerEndEvent putException(BaseException paramBaseException)
  {
    if (paramBaseException == null) {
      return this;
    }
    if ((paramBaseException instanceof UserCancelException)) {
      put("Microsoft.MSAL.user_cancel", "true");
    }
    put("Microsoft.MSAL.server_error_code", paramBaseException.getCliTelemErrorCode());
    put("Microsoft.MSAL.server_sub_error_code", paramBaseException.getCliTelemSubErrorCode());
    put("Microsoft.MSAL.api_error_code", paramBaseException.getErrorCode());
    put("Microsoft.MSAL.spe_ring", paramBaseException.getSpeRing());
    put("Microsoft.MSAL.error_description", paramBaseException.getMessage());
    put("Microsoft.MSAL.rt_age", paramBaseException.getRefreshTokenAge());
    put("_is_successful", "false");
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.events.BrokerEndEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */