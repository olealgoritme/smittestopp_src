package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultiTenantAccount
  extends Account
  implements IMultiTenantAccount
{
  public Map<String, ITenantProfile> mTenantProfiles = new HashMap();
  
  public MultiTenantAccount(String paramString, IDToken paramIDToken)
  {
    super(paramString, paramIDToken);
  }
  
  public Map<String, ITenantProfile> getTenantProfiles()
  {
    return Collections.unmodifiableMap(mTenantProfiles);
  }
  
  public void setTenantProfiles(Map<String, ITenantProfile> paramMap)
  {
    mTenantProfiles = paramMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.MultiTenantAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */