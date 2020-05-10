package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import e.c.c.v.c;

public class AzureActiveDirectorySlice
{
  public static final String DC_PARAMETER = "dc";
  public static final String SLICE_PARAMETER = "slice";
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
  
  public void setDataCenter(String paramString)
  {
    mDataCenter = paramString;
  }
  
  public void setSlice(String paramString)
  {
    mSlice = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */