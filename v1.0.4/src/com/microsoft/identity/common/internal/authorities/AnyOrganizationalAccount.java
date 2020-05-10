package com.microsoft.identity.common.internal.authorities;

public class AnyOrganizationalAccount
  extends AzureActiveDirectoryAudience
{
  public AnyOrganizationalAccount()
  {
    setTenantId("organizations");
  }
  
  public AnyOrganizationalAccount(String paramString)
  {
    setCloudUrl(paramString);
    setTenantId("organizations");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AnyOrganizationalAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */