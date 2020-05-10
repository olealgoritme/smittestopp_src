package com.microsoft.identity.client;

public class AcquireTokenSilentParameters$Builder
  extends TokenParameters.Builder<Builder>
{
  public SilentAuthenticationCallback mCallback;
  public boolean mForceRefresh;
  
  public AcquireTokenSilentParameters build()
  {
    return new AcquireTokenSilentParameters(this);
  }
  
  public Builder forceRefresh(boolean paramBoolean)
  {
    mForceRefresh = paramBoolean;
    return self();
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder withCallback(SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    mCallback = paramSilentAuthenticationCallback;
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AcquireTokenSilentParameters.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */