package com.microsoft.identity.client.configuration;

import e.c.c.v.c;

public class HttpConfiguration
{
  @c("connect_timeout")
  public int mConnectTimeout;
  @c("read_timeout")
  public int mReadTimeout;
  
  public int getConnectTimeout()
  {
    return mConnectTimeout;
  }
  
  public int getReadTimeout()
  {
    return mReadTimeout;
  }
  
  public void setConnectTimeout(int paramInt)
  {
    mConnectTimeout = paramInt;
  }
  
  public void setReadTimeout(int paramInt)
  {
    mReadTimeout = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.configuration.HttpConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */