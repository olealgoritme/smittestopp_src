package com.microsoft.identity.client;

public abstract interface ICurrentAccountResult
{
  public abstract boolean didAccountChange();
  
  public abstract IAccount getCurrentAccount();
  
  public abstract IAccount getPriorAccount();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.ICurrentAccountResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */