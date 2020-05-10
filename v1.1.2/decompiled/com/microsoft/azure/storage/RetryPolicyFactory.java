package com.microsoft.azure.storage;

public abstract interface RetryPolicyFactory
{
  public abstract RetryPolicy createInstance(OperationContext paramOperationContext);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryPolicyFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */