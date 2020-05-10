package com.microsoft.identity.common.internal.controllers;

public abstract interface TaskCompletedCallbackWithError<T, U>
  extends TaskCompletedCallback<T>
{
  public abstract void onError(U paramU);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */