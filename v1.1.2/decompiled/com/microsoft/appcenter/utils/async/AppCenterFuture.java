package com.microsoft.appcenter.utils.async;

public abstract interface AppCenterFuture<T>
{
  public abstract T get();
  
  public abstract boolean isDone();
  
  public abstract void thenAccept(AppCenterConsumer<T> paramAppCenterConsumer);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.async.AppCenterFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */