package com.microsoft.identity.common.internal.authscheme;

import e.a.a.a.a;
import e.c.c.v.c;

public abstract class AbstractAuthenticationScheme
  implements INameable
{
  @c("name")
  public final String mName;
  
  public AbstractAuthenticationScheme(String paramString)
  {
    mName = paramString;
  }
  
  public final String getName()
  {
    return mName;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("AbstractAuthenticationScheme{mName='");
    localStringBuilder.append(mName);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class SerializedNames
  {
    public static final String NAME = "name";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */