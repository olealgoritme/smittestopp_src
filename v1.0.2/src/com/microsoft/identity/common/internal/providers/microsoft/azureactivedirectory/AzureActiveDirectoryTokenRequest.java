package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import e.c.c.v.c;

public class AzureActiveDirectoryTokenRequest
  extends TokenRequest
{
  @c("resource")
  public String mResourceId;
  
  public String getResourceId()
  {
    return mResourceId;
  }
  
  public void setResourceId(String paramString)
  {
    mResourceId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */