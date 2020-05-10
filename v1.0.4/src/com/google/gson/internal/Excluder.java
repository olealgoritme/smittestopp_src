package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.v.d;
import e.c.c.v.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
  implements u, Cloneable
{
  public static final Excluder D = new Excluder();
  public boolean A;
  public List<e.c.c.a> B = Collections.emptyList();
  public List<e.c.c.a> C = Collections.emptyList();
  public double x = -1.0D;
  public int y = 136;
  public boolean z = true;
  
  public <T> TypeAdapter<T> a(Gson paramGson, e.c.c.x.a<T> parama)
  {
    Class localClass = parama.getRawType();
    boolean bool1 = a(localClass);
    boolean bool2;
    if ((!bool1) && (!a(localClass, true))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if ((!bool1) && (!a(localClass, false))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((!bool2) && (!bool1)) {
      return null;
    }
    return new Excluder.1(this, bool1, bool2, paramGson, parama);
  }
  
  public final boolean a(d paramd, e parame)
  {
    boolean bool1 = false;
    int i;
    if ((paramd != null) && (paramd.value() > x)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool2 = bool1;
    if (i != 0)
    {
      if ((parame != null) && (parame.value() <= x)) {
        i = 0;
      } else {
        i = 1;
      }
      bool2 = bool1;
      if (i != 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public final boolean a(Class<?> paramClass)
  {
    if ((x != -1.0D) && (!a((d)paramClass.getAnnotation(d.class), (e)paramClass.getAnnotation(e.class)))) {
      return true;
    }
    if ((!z) && (c(paramClass))) {
      return true;
    }
    return b(paramClass);
  }
  
  public final boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = B;
    } else {
      localObject = C;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((e.c.c.a)((Iterator)localObject).next()).a(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean b(Class<?> paramClass)
  {
    boolean bool;
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean c(Class<?> paramClass)
  {
    boolean bool1 = paramClass.isMemberClass();
    boolean bool2 = true;
    if (bool1)
    {
      int i;
      if ((paramClass.getModifiers() & 0x8) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {}
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public Excluder clone()
  {
    try
    {
      Excluder localExcluder = (Excluder)super.clone();
      return localExcluder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.Excluder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */