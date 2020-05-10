package com.microsoft.identity.common.internal.controllers;

public abstract interface Command<T>
{
  public abstract T execute();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.Command
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */