package com.microsoft.identity.common.internal.authscheme;

public abstract class TokenAuthenticationScheme
  extends AbstractAuthenticationScheme
  implements ITokenAuthenticationSchemeInternal
{
  public static final String SCHEME_DELIMITER = " ";
  
  public TokenAuthenticationScheme(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.authscheme.TokenAuthenticationScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */