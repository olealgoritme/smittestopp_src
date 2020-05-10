package com.microsoft.identity.common.internal.controllers;

import android.content.Intent;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;

public abstract interface TokenOperation
{
  public abstract AcquireTokenResult execute();
  
  public abstract void notify(int paramInt1, int paramInt2, Intent paramIntent);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.TokenOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */