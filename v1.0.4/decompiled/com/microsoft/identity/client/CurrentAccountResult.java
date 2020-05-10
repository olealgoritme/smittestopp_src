package com.microsoft.identity.client;

public class CurrentAccountResult
  implements ICurrentAccountResult
{
  public boolean mChanged;
  public IAccount mCurrentAccount;
  public IAccount mPriorAccount;
  
  public CurrentAccountResult(IAccount paramIAccount1, IAccount paramIAccount2, boolean paramBoolean)
  {
    mCurrentAccount = paramIAccount1;
    mPriorAccount = paramIAccount2;
    mChanged = paramBoolean;
  }
  
  public boolean didAccountChange()
  {
    return mChanged;
  }
  
  public IAccount getCurrentAccount()
  {
    return mCurrentAccount;
  }
  
  public IAccount getPriorAccount()
  {
    return mPriorAccount;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.CurrentAccountResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */