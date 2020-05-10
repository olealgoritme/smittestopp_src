package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import java.util.Map;

public class ActiveDirectoryFederationServicesIdToken
  extends IDToken
{
  public ActiveDirectoryFederationServicesIdToken(String paramString)
  {
    super(paramString);
  }
  
  public Map<String, ?> getTokenClaims()
  {
    return super.getTokenClaims();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServicesIdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */