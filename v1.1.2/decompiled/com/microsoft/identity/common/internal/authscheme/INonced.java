package com.microsoft.identity.common.internal.authscheme;

import java.io.Serializable;

public abstract interface INonced
  extends Serializable
{
  public abstract String getNonce();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authscheme.INonced
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */