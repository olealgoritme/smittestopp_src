package com.android.volley.toolbox;

public abstract interface Authenticator
{
  public abstract String getAuthToken();
  
  public abstract void invalidateAuthToken(String paramString);
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.Authenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */