package com.microsoft.identity.common.internal.authorities;

public class AnyPersonalAccount
  extends AzureActiveDirectoryAudience
{
  public static final String ANY_PERSONAL_ACCOUNT_TENANT_ID = "consumers";
  
  public AnyPersonalAccount()
  {
    setTenantId("consumers");
  }
  
  public AnyPersonalAccount(String paramString)
  {
    setTenantId("consumers");
    setCloudUrl(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AnyPersonalAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */