package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.authscheme.INameable;

public abstract class AuthenticationScheme
  implements INameable
{
  public final String mSchemeName;
  
  public AuthenticationScheme(String paramString)
  {
    mSchemeName = paramString;
  }
  
  public final String getName()
  {
    return mSchemeName;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.AuthenticationScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */