package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.AcquireTokenParameters.Builder;

public class IntuneAcquireTokenParameters$Builder
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

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.IntuneAcquireTokenParameters.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */