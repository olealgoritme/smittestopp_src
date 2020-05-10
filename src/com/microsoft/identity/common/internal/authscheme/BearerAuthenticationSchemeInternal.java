package com.microsoft.identity.common.internal.authscheme;

public class BearerAuthenticationSchemeInternal
  extends TokenAuthenticationScheme
  implements ITokenAuthenticationSchemeInternal
{
  public static final String SCHEME_BEARER = "Bearer";
  
  public BearerAuthenticationSchemeInternal()
  {
    super("Bearer");
  }
  
  public String getAccessTokenForScheme(String paramString)
  {
    return paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */