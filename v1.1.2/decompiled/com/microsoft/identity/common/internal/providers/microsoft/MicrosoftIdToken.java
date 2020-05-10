package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.IDToken;

public class MicrosoftIdToken
  extends IDToken
{
  public static final String AUDIENCE = "aud";
  public static final String ISSUED_AT = "iat";
  public static final String ISSUER = "iss";
  public static final String NOT_BEFORE = "nbf";
  public static final String OBJECT_ID = "oid";
  public static final String TENANT_ID = "tid";
  public static final String VERSION = "ver";
  
  public MicrosoftIdToken(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftIdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */