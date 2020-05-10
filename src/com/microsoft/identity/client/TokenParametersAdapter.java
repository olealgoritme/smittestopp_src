package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import java.util.List;

public class TokenParametersAdapter
{
  public static AcquireTokenSilentParameters silentParametersFromInteractive(AcquireTokenParameters paramAcquireTokenParameters, ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    paramILocalAuthenticationResult = (IAccount)AccountAdapter.adapt(paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData()).get(0);
    return ((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)((AcquireTokenSilentParameters.Builder)new AcquireTokenSilentParameters.Builder().withCallback(paramAcquireTokenParameters.getCallback()).fromAuthority(paramAcquireTokenParameters.getAuthority())).withClaims(paramAcquireTokenParameters.getClaimsRequest())).withScopes(paramAcquireTokenParameters.getScopes())).forAccount(paramILocalAuthenticationResult)).build();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.TokenParametersAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */