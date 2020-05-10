package com.microsoft.identity.client;

import java.util.Date;

public abstract interface IAuthenticationResult
{
  public abstract String getAccessToken();
  
  public abstract IAccount getAccount();
  
  public abstract String getAuthenticationScheme();
  
  public abstract String getAuthorizationHeader();
  
  public abstract Date getExpiresOn();
  
  public abstract String[] getScope();
  
  public abstract String getTenantId();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IAuthenticationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */