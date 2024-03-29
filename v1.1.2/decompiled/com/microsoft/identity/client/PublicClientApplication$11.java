package com.microsoft.identity.client;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PublicClientApplication$11
  extends PublicClientApplication.AccountMatcher
{
  public PublicClientApplication$11(PublicClientApplication paramPublicClientApplication)
  {
    super(paramPublicClientApplication);
  }
  
  public boolean matches(String paramString, IAccount paramIAccount)
  {
    if (paramString.contains(paramIAccount.getId())) {
      return true;
    }
    if ((paramIAccount instanceof MultiTenantAccount))
    {
      paramIAccount = ((MultiTenantAccount)paramIAccount).getTenantProfiles();
      if ((paramIAccount != null) && (!paramIAccount.isEmpty()))
      {
        Iterator localIterator = paramIAccount.entrySet().iterator();
        while (localIterator.hasNext())
        {
          paramIAccount = (Map.Entry)localIterator.next();
          if ((!TextUtils.isEmpty(((ITenantProfile)paramIAccount.getValue()).getId())) && (paramString.contains(((ITenantProfile)paramIAccount.getValue()).getId()))) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */