package com.microsoft.identity.common.internal.request;

import com.google.gson.internal.bind.TreeTypeAdapter.b;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.logging.Logger;
import e.c.c.h;
import e.c.c.i;
import e.c.c.j;
import e.c.c.m;
import e.c.c.q;
import e.c.c.r;
import java.lang.reflect.Type;

public class AuthenticationSchemeTypeAdapter
  implements i<AbstractAuthenticationScheme>, r<AbstractAuthenticationScheme>
{
  public static final String TAG = "AuthenticationSchemeTypeAdapter";
  
  public AbstractAuthenticationScheme deserialize(j paramj, Type paramType, h paramh)
  {
    paramType = paramj.c().a("name").f();
    int i = paramType.hashCode();
    if (i != 80401)
    {
      if ((i == 1985802113) && (paramType.equals("Bearer")))
      {
        i = 0;
        break label69;
      }
    }
    else if (paramType.equals("PoP"))
    {
      i = 1;
      break label69;
    }
    i = -1;
    label69:
    if (i != 0)
    {
      if (i != 1)
      {
        Logger.warn(TAG, "Unrecognized auth scheme. Deserializing as null.");
        return null;
      }
      return (AbstractAuthenticationScheme)((TreeTypeAdapter.b)paramh).a(paramj, PopAuthenticationSchemeInternal.class);
    }
    return (AbstractAuthenticationScheme)((TreeTypeAdapter.b)paramh).a(paramj, BearerAuthenticationSchemeInternal.class);
  }
  
  public j serialize(AbstractAuthenticationScheme paramAbstractAuthenticationScheme, Type paramType, q paramq)
  {
    paramType = paramAbstractAuthenticationScheme.getName();
    int i = paramType.hashCode();
    if (i != 80401)
    {
      if ((i == 1985802113) && (paramType.equals("Bearer")))
      {
        i = 0;
        break label61;
      }
    }
    else if (paramType.equals("PoP"))
    {
      i = 1;
      break label61;
    }
    i = -1;
    label61:
    if (i != 0)
    {
      if (i != 1)
      {
        Logger.warn(TAG, "Unrecognized auth scheme. Serializing as null.");
        return null;
      }
      return ((TreeTypeAdapter.b)paramq).a(paramAbstractAuthenticationScheme, PopAuthenticationSchemeInternal.class);
    }
    return ((TreeTypeAdapter.b)paramq).a(paramAbstractAuthenticationScheme, BearerAuthenticationSchemeInternal.class);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.AuthenticationSchemeTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */