package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftIdToken;

public class AzureActiveDirectoryIdToken
  extends MicrosoftIdToken
{
  public static final String IDENTITY_PROVIDER = "idp";
  public static final String PASSWORD_CHANGE_URL = "pwd_url";
  public static final String PASSWORD_EXPIRATION = "pwd_exp";
  public static final String UNIQUE_NAME = "unique_name";
  public static final String UPN = "upn";
  
  public AzureActiveDirectoryIdToken(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryIdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */