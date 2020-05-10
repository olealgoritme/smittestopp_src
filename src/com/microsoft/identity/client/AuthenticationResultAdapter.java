package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalDeclinedScopeException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class AuthenticationResultAdapter
{
  public static final String TAG = "com.microsoft.identity.client.AuthenticationResultAdapter";
  
  public static IAuthenticationResult adapt(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    return new AuthenticationResult(paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
  }
  
  public static MsalDeclinedScopeException declinedScopeExceptionFromResult(ILocalAuthenticationResult paramILocalAuthenticationResult, List<String> paramList, TokenParameters paramTokenParameters)
  {
    List localList = Arrays.asList(paramILocalAuthenticationResult.getScope());
    String str = a.a(new StringBuilder(), TAG, ":declinedScopeExceptionFromResult");
    StringBuilder localStringBuilder = a.a("Returning DeclinedScopeException as not all requested scopes are granted, Requested scopes: ");
    localStringBuilder.append(paramTokenParameters.getScopes().toString());
    localStringBuilder.append(" Granted scopes:");
    localStringBuilder.append(localList.toString());
    Logger.warn(str, localStringBuilder.toString());
    if ((paramTokenParameters instanceof AcquireTokenSilentParameters)) {
      paramILocalAuthenticationResult = (AcquireTokenSilentParameters)paramTokenParameters;
    } else {
      paramILocalAuthenticationResult = TokenParametersAdapter.silentParametersFromInteractive((AcquireTokenParameters)paramTokenParameters, paramILocalAuthenticationResult);
    }
    paramILocalAuthenticationResult.setScopes(localList);
    return new MsalDeclinedScopeException(localList, paramList, paramILocalAuthenticationResult);
  }
  
  public static List<String> getDeclinedScopes(List<String> paramList1, List<String> paramList2)
  {
    HashSet localHashSet = new HashSet();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      localHashSet.add(((String)paramList1.next()).toLowerCase());
    }
    Object localObject = new HashSet();
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext()) {
      ((HashSet)localObject).add(((String)paramList1.next()).toLowerCase());
    }
    paramList1 = new ArrayList();
    paramList2 = ((HashSet)localObject).iterator();
    while (paramList2.hasNext())
    {
      localObject = (String)paramList2.next();
      if (!localHashSet.contains(localObject)) {
        paramList1.add(localObject);
      }
    }
    return paramList1;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AuthenticationResultAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */