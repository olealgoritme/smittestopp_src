package k.b.a;

import java.util.Enumeration;
import java.util.Iterator;

public class a2
  extends u
{
  public byte[] y;
  
  public a2(byte[] paramArrayOfByte)
  {
    y = paramArrayOfByte;
  }
  
  public e a(int paramInt)
  {
    try
    {
      l();
      e locale = x[paramInt];
      return locale;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    try
    {
      if (y != null) {
        paramr.a(paramBoolean, 48, y);
      } else {
        super.i().a(paramr, paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  public int f()
  {
    try
    {
      if (y != null)
      {
        i = d2.a(y.length);
        int j = y.length;
        return i + 1 + j;
      }
      int i = super.i().f();
      return i;
    }
    finally {}
  }
  
  public t h()
  {
    try
    {
      l();
      t localt = super.h();
      return localt;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      l();
      int i = super.hashCode();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public t i()
  {
    try
    {
      l();
      t localt = super.i();
      return localt;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Iterator<e> iterator()
  {
    try
    {
      l();
      Iterator localIterator = super.iterator();
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Enumeration j()
  {
    try
    {
      if (y != null)
      {
        localObject1 = new z1(y);
        return (Enumeration)localObject1;
      }
      Object localObject1 = new u.a(this);
      return (Enumeration)localObject1;
    }
    finally {}
  }
  
  public e[] k()
  {
    l();
    return x;
  }
  
  public final void l()
  {
    if (y != null)
    {
      f localf = new f(10);
      z1 localz1 = new z1(y);
      while (localz1.hasMoreElements()) {
        localf.a((t)localz1.nextElement());
      }
      x = localf.a();
      y = null;
    }
  }
  
  public int size()
  {
    try
    {
      l();
      int i = x.length;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.a2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */