package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import java.util.Map;

public class TenantProfile
  extends Account
  implements ITenantProfile
{
  public TenantProfile(String paramString, IDToken paramIDToken)
  {
    super(paramString, paramIDToken);
  }
  
  public String getTenantId()
  {
    String str;
    if (getClaims() != null)
    {
      str = (String)getClaims().get("tid");
      if (str != null) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.TenantProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */