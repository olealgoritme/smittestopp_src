package com.microsoft.identity.common.internal.authorities;

import e.c.c.v.c;

public class AzureActiveDirectorySlice
{
  @c("dc")
  public String mDataCenter;
  @c("slice")
  public String mSlice;
  
  public String getDC()
  {
    return mDataCenter;
  }
  
  public String getSlice()
  {
    return mSlice;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.AzureActiveDirectorySlice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */