package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.cache.SchemaUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PublicClientApplication$12
  extends PublicClientApplication.AccountMatcher
{
  public PublicClientApplication$12(PublicClientApplication paramPublicClientApplication)
  {
    super(paramPublicClientApplication);
  }
  
  public boolean matches(String paramString, IAccount paramIAccount)
  {
    Object localObject = new ArrayList();
    if (paramIAccount.getClaims() != null) {
      ((ArrayList)localObject).add(paramIAccount);
    }
    if ((paramIAccount instanceof MultiTenantAccount))
    {
      Iterator localIterator = ((MultiTenantAccount)paramIAccount).getTenantProfiles().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramIAccount = (Map.Entry)localIterator.next();
        if (((ITenantProfile)paramIAccount.getValue()).getClaims() != null) {
          ((ArrayList)localObject).add(paramIAccount.getValue());
        }
      }
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramIAccount = (IClaimable)((Iterator)localObject).next();
      if ((paramIAccount.getClaims() != null) && (paramString.equalsIgnoreCase(SchemaUtil.getDisplayableId(paramIAccount.getClaims())))) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */