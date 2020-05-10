package com.microsoft.identity.common.internal.controllers;

public abstract interface CommandCallback<T, U>
  extends TaskCompletedCallbackWithError<T, U>
{
  public abstract void onCancel();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.CommandCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */