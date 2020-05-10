package com.microsoft.identity.common.internal.authscheme;

import java.net.URL;

public abstract interface IPoPAuthenticationSchemeParams
  extends INonced
{
  public abstract String getHttpMethod();
  
  public abstract URL getUrl();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authscheme.IPoPAuthenticationSchemeParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */