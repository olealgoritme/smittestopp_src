package com.microsoft.identity.client;

public abstract interface AuthenticationCallback
  extends SilentAuthenticationCallback
{
  public abstract void onCancel();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AuthenticationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */