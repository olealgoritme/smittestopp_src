package com.microsoft.azure.storage;

public final class AccountInformation
{
  public String accountKind;
  public String skuName;
  
  public String getAccountKind()
  {
    return accountKind;
  }
  
  public String getSkuName()
  {
    return skuName;
  }
  
  public void setAccountKind(String paramString)
  {
    accountKind = paramString;
  }
  
  public void setSkuName(String paramString)
  {
    skuName = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.AccountInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */