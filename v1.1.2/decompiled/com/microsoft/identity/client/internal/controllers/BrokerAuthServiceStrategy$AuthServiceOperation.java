package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.client.IMicrosoftAuthService;

public abstract interface BrokerAuthServiceStrategy$AuthServiceOperation<T>
{
  public abstract String getOperationName();
  
  public abstract T perform(IMicrosoftAuthService paramIMicrosoftAuthService);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.AuthServiceOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */