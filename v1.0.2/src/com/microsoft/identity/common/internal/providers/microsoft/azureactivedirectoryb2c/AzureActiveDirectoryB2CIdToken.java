package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import java.util.Map;

public class AzureActiveDirectoryB2CIdToken
  extends IDToken
{
  public AzureActiveDirectoryB2CIdToken(String paramString)
  {
    super(paramString);
  }
  
  public Map<String, ?> getTokenClaims()
  {
    return super.getTokenClaims();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c.AzureActiveDirectoryB2CIdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */