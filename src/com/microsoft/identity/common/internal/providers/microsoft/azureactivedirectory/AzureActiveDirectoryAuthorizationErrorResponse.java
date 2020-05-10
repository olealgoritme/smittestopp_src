package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationErrorResponse;

public class AzureActiveDirectoryAuthorizationErrorResponse
  extends MicrosoftAuthorizationErrorResponse
{
  public String mErrorCodes;
  
  public AzureActiveDirectoryAuthorizationErrorResponse(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public String getErrorCodes()
  {
    return mErrorCodes;
  }
  
  public void setErrorCodes(String paramString)
  {
    mErrorCodes = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */