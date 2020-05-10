package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationErrorResponse;

public class MicrosoftStsAuthorizationErrorResponse
  extends MicrosoftAuthorizationErrorResponse
{
  public String mErrorSubcode;
  
  public MicrosoftStsAuthorizationErrorResponse(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public MicrosoftStsAuthorizationErrorResponse(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString3);
    mErrorSubcode = paramString2;
  }
  
  public String getErrorSubcode()
  {
    return mErrorSubcode;
  }
  
  public void setErrorSubcode(String paramString)
  {
    mErrorSubcode = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */