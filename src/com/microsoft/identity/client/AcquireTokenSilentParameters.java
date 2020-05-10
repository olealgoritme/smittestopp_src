package com.microsoft.identity.client;

public class AcquireTokenSilentParameters
  extends TokenParameters
{
  public SilentAuthenticationCallback mCallback;
  public boolean mForceRefresh;
  
  public AcquireTokenSilentParameters(AcquireTokenSilentParameters.Builder paramBuilder)
  {
    super(paramBuilder);
    mForceRefresh = AcquireTokenSilentParameters.Builder.access$000(paramBuilder);
    mCallback = AcquireTokenSilentParameters.Builder.access$100(paramBuilder);
  }
  
  public SilentAuthenticationCallback getCallback()
  {
    return mCallback;
  }
  
  public boolean getForceRefresh()
  {
    return mForceRefresh;
  }
  
  public void setCallback(SilentAuthenticationCallback paramSilentAuthenticationCallback)
  {
    mCallback = paramSilentAuthenticationCallback;
  }
  
  public void setForceRefresh(boolean paramBoolean)
  {
    mForceRefresh = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.AcquireTokenSilentParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */