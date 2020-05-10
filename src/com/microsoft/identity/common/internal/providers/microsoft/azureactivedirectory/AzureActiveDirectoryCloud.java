package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import e.c.c.v.c;
import java.util.ArrayList;
import java.util.List;

public class AzureActiveDirectoryCloud
{
  @c("aliases")
  public List<String> mCloudHostAliases;
  public boolean mIsValidated;
  @c("preferred_cache")
  public final String mPreferredCacheHostName;
  @c("preferred_network")
  public final String mPreferredNetworkHostName;
  
  public AzureActiveDirectoryCloud(String paramString1, String paramString2)
  {
    mPreferredNetworkHostName = paramString1;
    mPreferredCacheHostName = paramString2;
    mIsValidated = true;
  }
  
  public AzureActiveDirectoryCloud(String paramString1, String paramString2, List<String> paramList)
  {
    mPreferredNetworkHostName = paramString1;
    mPreferredCacheHostName = paramString2;
    paramString1 = new ArrayList();
    mCloudHostAliases = paramString1;
    paramString1.addAll(paramList);
    mIsValidated = true;
  }
  
  public AzureActiveDirectoryCloud(boolean paramBoolean)
  {
    mIsValidated = paramBoolean;
    mPreferredNetworkHostName = null;
    mPreferredCacheHostName = null;
  }
  
  public List<String> getHostAliases()
  {
    return mCloudHostAliases;
  }
  
  public String getPreferredCacheHostName()
  {
    return mPreferredCacheHostName;
  }
  
  public String getPreferredNetworkHostName()
  {
    return mPreferredNetworkHostName;
  }
  
  public boolean isValidated()
  {
    return mIsValidated;
  }
  
  public void setIsValidated(boolean paramBoolean)
  {
    mIsValidated = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */