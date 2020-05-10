package com.google.gson.internal.bind;

import com.google.gson.Gson;
import e.c.c.h;
import e.c.c.j;
import e.c.c.q;
import e.c.c.w.z.a;
import e.c.c.w.z.b;
import java.lang.reflect.Type;

public final class TreeTypeAdapter$b
  implements q, h
{
  public j a(Object paramObject, Type paramType)
  {
    Gson localGson = a.c;
    if (localGson != null)
    {
      b localb = new b();
      localGson.a(paramObject, paramType, localb);
      return localb.j();
    }
    throw null;
  }
  
  public <R> R a(j paramj, Type paramType)
  {
    Gson localGson = a.c;
    Object localObject = null;
    if (localGson != null)
    {
      if (paramj == null) {
        paramj = (j)localObject;
      } else {
        paramj = localGson.a(new a(paramj), paramType);
      }
      return paramj;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TreeTypeAdapter.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */