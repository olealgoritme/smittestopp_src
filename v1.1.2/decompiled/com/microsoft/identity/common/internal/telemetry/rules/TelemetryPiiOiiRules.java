package com.microsoft.identity.common.internal.telemetry.rules;

import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class TelemetryPiiOiiRules
{
  public static TelemetryPiiOiiRules sInstance;
  public final String[] oiiArray = { "Microsoft.MSAL.tenant_id", "Microsoft.MSAL.client_id", "Microsoft.MSAL.redirect_uri", "Microsoft.MSAL.http_path", "Microsoft.MSAL.authority", "Microsoft.MSAL.idp" };
  public Set<String> oiiPropertiesSet = new HashSet(Arrays.asList(oiiArray));
  public final String[] piiArray = { "Microsoft.MSAL.user_id", "Microsoft.MSAL.device_id", "Microsoft.MSAL.login_hint", "Microsoft.MSAL.error_description", "Microsoft.MSAL.query_params", "Microsoft.MSAL.redirect_uri", "Microsoft.MSAL.scope_value", "Microsoft.MSAL.claim_request" };
  public Set<String> piiPropertiesSet = new HashSet(Arrays.asList(piiArray));
  
  public static TelemetryPiiOiiRules getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localTelemetryPiiOiiRules = new com/microsoft/identity/common/internal/telemetry/rules/TelemetryPiiOiiRules;
        localTelemetryPiiOiiRules.<init>();
        sInstance = localTelemetryPiiOiiRules;
      }
      TelemetryPiiOiiRules localTelemetryPiiOiiRules = sInstance;
      return localTelemetryPiiOiiRules;
    }
    finally {}
  }
  
  public boolean isOii(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    return oiiPropertiesSet.contains(paramString);
  }
  
  public boolean isPii(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return false;
    }
    return piiPropertiesSet.contains(paramString);
  }
  
  public boolean isPiiOrOii(String paramString)
  {
    boolean bool;
    if ((!isPii(paramString)) && (!isOii(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.rules.TelemetryPiiOiiRules
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */