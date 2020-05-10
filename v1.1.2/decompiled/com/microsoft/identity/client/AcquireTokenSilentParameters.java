package com.microsoft.identity.client;

public class AcquireTokenSilentParameters
  extends TokenParameters
{
  public SilentAuthenticationCallback mCallback;
  public boolean mForceRefresh;
  
  public AcquireTokenSilentParameters(Builder paramBuilder)
  {
    super(paramBuilder);
    mForceRefresh = Builder.access$000(paramBuilder);
    mCallback = Builder.access$100(paramBuilder);
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
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AcquireTokenSilentParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */