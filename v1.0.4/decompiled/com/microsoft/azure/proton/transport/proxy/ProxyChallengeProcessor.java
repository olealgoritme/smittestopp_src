package com.microsoft.azure.proton.transport.proxy;

import java.util.Map;

public abstract interface ProxyChallengeProcessor
{
  public abstract Map<String, String> getHeader();
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.ProxyChallengeProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */