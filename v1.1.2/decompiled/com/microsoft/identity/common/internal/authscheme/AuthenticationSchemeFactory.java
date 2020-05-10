package com.microsoft.identity.common.internal.authscheme;

import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;

public class AuthenticationSchemeFactory
{
  public static final String TAG = "AuthenticationSchemeFactory";
  
  public static AbstractAuthenticationScheme createScheme(INameable paramINameable)
  {
    if (paramINameable == null) {
      return new BearerAuthenticationSchemeInternal();
    }
    Object localObject = paramINameable.getName();
    int i = -1;
    int j = ((String)localObject).hashCode();
    if (j != 80401)
    {
      if ((j == 1985802113) && (((String)localObject).equals("Bearer"))) {
        i = 0;
      }
    }
    else if (((String)localObject).equals("PoP")) {
      i = 1;
    }
    if (i != 0)
    {
      if (i == 1)
      {
        if ((paramINameable instanceof IPoPAuthenticationSchemeParams))
        {
          Logger.verbose(TAG, "Constructing PoP Authentication Scheme.");
          paramINameable = (IPoPAuthenticationSchemeParams)paramINameable;
          return new PopAuthenticationSchemeInternal(paramINameable.getHttpMethod(), paramINameable.getUrl(), paramINameable.getNonce());
        }
        throw new IllegalStateException("Unrecognized parameter type.");
      }
      localObject = a.a("Unknown or unsupported scheme: ");
      ((StringBuilder)localObject).append(paramINameable.getName());
      throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
    }
    Logger.verbose(TAG, "Constructing Bearer Authentication Scheme.");
    return new BearerAuthenticationSchemeInternal();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authscheme.AuthenticationSchemeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */