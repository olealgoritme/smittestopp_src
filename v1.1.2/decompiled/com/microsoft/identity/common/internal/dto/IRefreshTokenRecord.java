package com.microsoft.identity.common.internal.dto;

public abstract interface IRefreshTokenRecord
{
  public abstract String getClientId();
  
  public abstract String getEnvironment();
  
  public abstract String getFamilyId();
  
  public abstract String getHomeAccountId();
  
  public abstract String getSecret();
  
  public abstract String getTarget();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.dto.IRefreshTokenRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */