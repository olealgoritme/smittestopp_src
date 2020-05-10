package com.microsoft.identity.client.configuration;

public enum AccountMode
{
  static
  {
    AccountMode localAccountMode = new AccountMode("MULTIPLE", 1);
    MULTIPLE = localAccountMode;
    $VALUES = new AccountMode[] { SINGLE, localAccountMode };
  }
  
  public AccountMode() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.configuration.AccountMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */