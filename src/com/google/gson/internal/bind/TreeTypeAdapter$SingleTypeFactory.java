package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.a.a.b.l.c;
import e.c.c.i;
import e.c.c.r;
import e.c.c.u;
import e.c.c.x.a;

public final class TreeTypeAdapter$SingleTypeFactory
  implements u
{
  public final r<?> A;
  public final i<?> B;
  public final a<?> x;
  public final boolean y;
  public final Class<?> z;
  
  public TreeTypeAdapter$SingleTypeFactory(Object paramObject, a<?> parama, boolean paramBoolean, Class<?> paramClass)
  {
    boolean bool = paramObject instanceof r;
    Object localObject1 = null;
    if (bool) {
      localObject2 = (r)paramObject;
    } else {
      localObject2 = null;
    }
    A = ((r)localObject2);
    Object localObject2 = localObject1;
    if ((paramObject instanceof i)) {
      localObject2 = (i)paramObject;
    }
    B = ((i)localObject2);
    if ((A == null) && (localObject2 == null)) {
      bool = false;
    } else {
      bool = true;
    }
    c.a(bool);
    x = parama;
    y = paramBoolean;
    z = paramClass;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    a locala = x;
    boolean bool;
    if (locala != null)
    {
      if ((!locala.equals(parama)) && ((!y) || (x.getType() != parama.getRawType()))) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = z.isAssignableFrom(parama.getRawType());
    }
    if (bool) {
      paramGson = new TreeTypeAdapter(A, B, paramGson, parama, this);
    } else {
      paramGson = null;
    }
    return paramGson;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TreeTypeAdapter.SingleTypeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */