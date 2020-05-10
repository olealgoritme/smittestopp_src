package com.microsoft.identity.common.internal.authorities;

public class AccountsInOneOrganization
  extends AzureActiveDirectoryAudience
{
  public AccountsInOneOrganization() {}
  
  public AccountsInOneOrganization(String paramString)
  {
    setTenantId(paramString);
  }
  
  public AccountsInOneOrganization(String paramString1, String paramString2)
  {
    setCloudUrl(paramString1);
    setTenantId(paramString2);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AccountsInOneOrganization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */