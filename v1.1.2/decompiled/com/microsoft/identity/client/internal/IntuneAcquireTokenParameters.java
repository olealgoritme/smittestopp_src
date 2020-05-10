package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.AcquireTokenParameters;
import com.microsoft.identity.client.AcquireTokenParameters.Builder;

public class IntuneAcquireTokenParameters
  extends AcquireTokenParameters
{
  public boolean mBrokerBrowserSupportEnabled;
  
  public IntuneAcquireTokenParameters(Builder paramBuilder)
  {
    super(paramBuilder);
    mBrokerBrowserSupportEnabled = Builder.access$000(paramBuilder);
  }
  
  public boolean isBrokerBrowserSupportEnabled()
  {
    return mBrokerBrowserSupportEnabled;
  }
  
  public static class Builder
    extends AcquireTokenParameters.Builder
  {
    public boolean mBrokerBrowserSupportEnabled;
    
    public Builder brokerBrowserSupportEnabled(boolean paramBoolean)
    {
      mBrokerBrowserSupportEnabled = paramBoolean;
      return this;
    }
    
    public IntuneAcquireTokenParameters build()
    {
      return new IntuneAcquireTokenParameters(this, null);
    }
    
    public Builder self()
    {
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.IntuneAcquireTokenParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */