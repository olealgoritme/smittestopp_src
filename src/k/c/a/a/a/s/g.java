package k.c.a.a.a.s;

import java.util.Hashtable;
import k.c.a.a.a.e;
import k.c.a.a.a.f;
import k.c.a.a.a.h;
import k.c.a.a.a.k;
import k.c.a.a.a.n;
import k.c.a.a.a.q;

public class g
  implements k.c.a.a.a.a
{
  public k.c.a.a.a.u.a a;
  public f b;
  public a c;
  public k.c.a.a.a.i d;
  public q e;
  public Object f;
  public k.c.a.a.a.a g;
  public int h;
  public h i;
  public boolean j;
  
  public g(f paramf, k.c.a.a.a.u.a parama, a parama1, k.c.a.a.a.i parami, q paramq, Object paramObject, k.c.a.a.a.a parama2, boolean paramBoolean)
  {
    a = parama;
    b = paramf;
    c = parama1;
    d = parami;
    e = paramq;
    f = paramObject;
    g = parama2;
    h = n;
    j = paramBoolean;
  }
  
  public void a()
  {
    q localq = new q(b.y);
    Object localObject = a;
    l = this;
    m = this;
    k.c.a.a.a.u.a locala = a;
    localObject = b.y;
    locala.b();
    if (d.k)
    {
      localObject = a;
      ((k.c.a.a.a.u.a)localObject).a();
      x.clear();
    }
    localObject = d;
    if (n == 0) {
      ((k.c.a.a.a.i)localObject).a(4);
    }
    try
    {
      c.a(d, localq);
    }
    catch (k localk)
    {
      a(localq, localk);
    }
  }
  
  public void a(e parame)
  {
    if (h == 0) {
      d.a(0);
    }
    e.a.a(a.g, null);
    e.a.a();
    q localq = e;
    p localp = a;
    k = b;
    if (c != null)
    {
      parame = g;
      if (parame != null)
      {
        m = f;
        parame.a(localq);
      }
      if (i != null)
      {
        parame = c;
        parame = e[d].c();
        i.a(j, parame);
      }
      return;
    }
    throw null;
  }
  
  public void a(e parame, Throwable paramThrowable)
  {
    Object localObject = c;
    int k = e.length;
    int m = d + 1;
    if ((m >= k) && ((h != 0) || (d.n != 4)))
    {
      if (h == 0) {
        d.a(0);
      }
      if ((paramThrowable instanceof k)) {
        parame = (k)paramThrowable;
      } else {
        parame = new k(paramThrowable);
      }
      e.a.a(null, parame);
      e.a.a();
      parame = e;
      p localp = a;
      k = b;
      localObject = g;
      if (localObject != null)
      {
        m = f;
        ((k.c.a.a.a.a)localObject).a(parame, paramThrowable);
      }
    }
    else
    {
      if (h == 0)
      {
        paramThrowable = d;
        if (n == 4)
        {
          paramThrowable.a(3);
        }
        else
        {
          paramThrowable.a(4);
          c.d = m;
        }
      }
      else
      {
        c.d = m;
      }
      try
      {
        a();
      }
      catch (n paramThrowable)
      {
        a(parame, paramThrowable);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */