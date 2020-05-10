package com.microsoft.identity.common.internal.authorities;

public class AllAccounts
  extends AzureActiveDirectoryAudience
{
  public static final String ALL_ACCOUNTS_TENANT_ID = "common";
  
  public AllAccounts()
  {
    setTenantId("common");
  }
  
  public AllAccounts(String paramString)
  {
    setCloudUrl(paramString);
    setTenantId("common");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AllAccounts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */