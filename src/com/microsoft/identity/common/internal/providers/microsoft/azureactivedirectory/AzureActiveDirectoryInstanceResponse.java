package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import e.c.c.v.c;
import java.util.ArrayList;

public class AzureActiveDirectoryInstanceResponse
{
  @c("api-version")
  public String mApiVersion;
  @c("metadata")
  public ArrayList<AzureActiveDirectoryCloud> mClouds;
  @c("tenant_discovery_endpoint")
  public String mTestDiscoveryEndpoint;
  
  public String getApiVersion()
  {
    return mApiVersion;
  }
  
  public ArrayList<AzureActiveDirectoryCloud> getClouds()
  {
    return mClouds;
  }
  
  public String getTestDiscoveryEndpoint()
  {
    return mTestDiscoveryEndpoint;
  }
  
  public void setApiVersion(String paramString)
  {
    mApiVersion = mApiVersion;
  }
  
  public void setClouds(ArrayList<AzureActiveDirectoryCloud> paramArrayList)
  {
    mClouds = mClouds;
  }
  
  public void setTestDiscoveryEndpoint(String paramString)
  {
    mTestDiscoveryEndpoint = mTestDiscoveryEndpoint;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryInstanceResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */