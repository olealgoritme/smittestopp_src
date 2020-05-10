package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import e.c.c.w.q;
import e.c.c.y.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class TypeAdapters$29
  extends TypeAdapter<j>
{
  public void a(c paramc, j paramj)
  {
    if ((paramj != null) && (!(paramj instanceof l)))
    {
      Object localObject;
      if ((paramj instanceof p))
      {
        localObject = paramj.d();
        paramj = a;
        if ((paramj instanceof Number)) {
          paramc.a(((p)localObject).h());
        } else if ((paramj instanceof Boolean)) {
          paramc.a(((p)localObject).g());
        } else {
          paramc.c(((p)localObject).f());
        }
      }
      else if ((paramj instanceof g))
      {
        paramc.b();
        paramj = paramj.b().iterator();
        while (paramj.hasNext()) {
          a(paramc, (j)paramj.next());
        }
        paramc.d();
      }
      else if ((paramj instanceof m))
      {
        paramc.c();
        localObject = paramj.c().g().iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramj = (Map.Entry)((Iterator)localObject).next();
          paramc.a((String)paramj.getKey());
          a(paramc, (j)paramj.getValue());
        }
        paramc.e();
      }
      else
      {
        paramc = e.a.a.a.a.a("Couldn't write ");
        paramc.append(paramj.getClass());
        throw new IllegalArgumentException(paramc.toString());
      }
    }
    else
    {
      paramc.g();
    }
  }
  
  public j read(e.c.c.y.a parama)
  {
    int i = parama.r().ordinal();
    Object localObject;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 6)
          {
            if (i != 7)
            {
              if (i == 8)
              {
                parama.o();
                return l.a;
              }
              throw new IllegalArgumentException();
            }
            return new p(Boolean.valueOf(parama.j()));
          }
          return new p(new q(parama.p()));
        }
        return new p(parama.p());
      }
      localObject = new m();
      parama.b();
      while (parama.h()) {
        ((m)localObject).a(parama.n(), read(parama));
      }
      parama.f();
      return (j)localObject;
    }
    g localg = new g();
    parama.a();
    while (parama.h())
    {
      j localj = read(parama);
      localObject = localj;
      if (localj == null) {
        localObject = l.a;
      }
      x.add(localObject);
    }
    parama.e();
    return localg;
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TypeAdapters.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */