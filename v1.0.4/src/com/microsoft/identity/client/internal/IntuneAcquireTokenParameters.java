package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.AcquireTokenParameters;

public class IntuneAcquireTokenParameters
  extends AcquireTokenParameters
{
  public boolean mBrokerBrowserSupportEnabled;
  
  public IntuneAcquireTokenParameters(IntuneAcquireTokenParameters.Builder paramBuilder)
  {
    super(paramBuilder);
    mBrokerBrowserSupportEnabled = IntuneAcquireTokenParameters.Builder.access$000(paramBuilder);
  }
  
  public boolean isBrokerBrowserSupportEnabled()
  {
    return mBrokerBrowserSupportEnabled;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.IntuneAcquireTokenParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */