package com.microsoft.identity.client.exception;

import com.microsoft.identity.client.AcquireTokenSilentParameters;
import java.util.List;

public class MsalDeclinedScopeException
  extends MsalException
{
  public List<String> mDeclinedScopes;
  public List<String> mGrantedScopes;
  public AcquireTokenSilentParameters mSilentParametersForGrantedScopes;
  
  public MsalDeclinedScopeException(List<String> paramList1, List<String> paramList2, AcquireTokenSilentParameters paramAcquireTokenSilentParameters)
  {
    super("declined_scope_error", "Some or all requested scopes have been declined by the Server");
    mGrantedScopes = paramList1;
    mDeclinedScopes = paramList2;
    mSilentParametersForGrantedScopes = paramAcquireTokenSilentParameters;
  }
  
  public List<String> getDeclinedScopes()
  {
    return mDeclinedScopes;
  }
  
  public List<String> getGrantedScopes()
  {
    return mGrantedScopes;
  }
  
  public AcquireTokenSilentParameters getSilentParametersForGrantedScopes()
  {
    return mSilentParametersForGrantedScopes;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.exception.MsalDeclinedScopeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */