package com.microsoft.identity.common.internal.dto;

public abstract interface IAccountRecord
{
  public abstract String getAlternativeAccountId();
  
  public abstract String getAuthorityType();
  
  public abstract String getAvatarUrl();
  
  public abstract String getClientInfo();
  
  public abstract String getEnvironment();
  
  public abstract String getFamilyName();
  
  public abstract String getFirstName();
  
  public abstract String getHomeAccountId();
  
  public abstract String getLocalAccountId();
  
  public abstract String getMiddleName();
  
  public abstract String getName();
  
  public abstract String getRealm();
  
  public abstract String getUsername();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.dto.IAccountRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */