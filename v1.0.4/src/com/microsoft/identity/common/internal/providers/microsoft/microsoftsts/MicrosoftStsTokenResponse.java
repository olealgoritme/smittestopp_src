package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import e.c.c.v.c;

public class MicrosoftStsTokenResponse
  extends MicrosoftTokenResponse
{
  @c("not_before")
  public String mExpiresNotBefore;
  
  public String getExpiresNotBefore()
  {
    return mExpiresNotBefore;
  }
  
  public void setExpiresNotBefore(String paramString)
  {
    mExpiresNotBefore = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */