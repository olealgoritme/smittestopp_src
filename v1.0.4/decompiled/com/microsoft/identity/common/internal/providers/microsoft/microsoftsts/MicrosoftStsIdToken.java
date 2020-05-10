package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftIdToken;

public class MicrosoftStsIdToken
  extends MicrosoftIdToken
{
  public static final String AIO = "aio";
  public static final String EXPIRATION_TIME = "exp";
  public static final String UTI = "uti";
  
  public MicrosoftStsIdToken(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsIdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */