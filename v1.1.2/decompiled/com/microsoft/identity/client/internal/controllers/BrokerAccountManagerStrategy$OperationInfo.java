package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.request.OperationParameters;

public abstract interface BrokerAccountManagerStrategy$OperationInfo<T extends OperationParameters, U>
{
  public abstract String getMethodName();
  
  public abstract Bundle getRequestBundle(T paramT);
  
  public abstract U getResultFromBundle(Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.OperationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */