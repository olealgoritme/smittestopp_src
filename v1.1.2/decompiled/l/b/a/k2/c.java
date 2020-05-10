package l.b.a.k2;

import java.util.Enumeration;
import java.util.Hashtable;
import l.b.a.b0;
import l.b.a.d;
import l.b.a.e;
import l.b.a.e1;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;
import l.b.a.u;
import l.b.a.x;

public class c
  extends n
  implements d
{
  public static l.b.a.k2.d.a C = l.b.a.k2.d.b.L;
  public b[] A;
  public e1 B;
  public boolean x;
  public int y;
  public l.b.a.k2.d.a z;
  
  public c(u paramu)
  {
    z = ((l.b.a.k2.d.a)localObject1);
    A = new b[paramu.size()];
    Enumeration localEnumeration = paramu.j();
    int i = 1;
    for (int j = 0; localEnumeration.hasMoreElements(); j++)
    {
      Object localObject2 = localEnumeration.nextElement();
      if ((localObject2 instanceof b)) {
        localObject1 = (b)localObject2;
      } else if (localObject2 != null) {
        localObject1 = new b(x.a(localObject2));
      } else {
        localObject1 = null;
      }
      int k;
      if (localObject1 == localObject2) {
        k = 1;
      } else {
        k = 0;
      }
      i &= k;
      A[j] = localObject1;
    }
    if (i != 0) {
      paramu = (e1)paramu.h();
    } else {
      paramu = new e1(A);
    }
    B = paramu;
  }
  
  public static c a(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      return (c)paramObject;
    }
    if (paramObject != null) {
      return new c(u.a(paramObject));
    }
    return null;
  }
  
  public static c a(b0 paramb0)
  {
    return a(u.a(paramb0, true));
  }
  
  public t b()
  {
    return B;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof c)) && (!(paramObject instanceof u))) {
      return false;
    }
    Object localObject = ((e)paramObject).b();
    if (B.b((t)localObject)) {
      return true;
    }
    try
    {
      localObject = z;
      c localc = new l/b/a/k2/c;
      localc.<init>(u.a(((e)paramObject).b()));
      boolean bool = ((l.b.a.k2.d.a)localObject).a(this, localc);
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public b[] f()
  {
    return (b[])A.clone();
  }
  
  public int hashCode()
  {
    if (x) {
      return y;
    }
    x = true;
    if (z != null)
    {
      b[] arrayOfb = f();
      int i = 0;
      int k;
      for (int j = 0; i != arrayOfb.length; j = k)
      {
        if (x.x.length > 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          a[] arrayOfa = arrayOfb[i].g();
          for (int m = 0;; m++)
          {
            k = j;
            if (m == arrayOfa.length) {
              break;
            }
            j = j ^ x.hashCode() ^ e.c.a.a.b.l.c.a(y).hashCode();
          }
        }
        k = j ^ fx.hashCode() ^ e.c.a.a.b.l.c.a(fy).hashCode();
        i++;
      }
      y = j;
      return j;
    }
    throw null;
  }
  
  public String toString()
  {
    l.b.a.k2.d.b localb = (l.b.a.k2.d.b)z;
    if (localb != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      b[] arrayOfb = f();
      int i = 0;
      int j = 1;
      while (i < arrayOfb.length)
      {
        if (j != 0) {
          j = 0;
        } else {
          localStringBuffer.append(',');
        }
        Object localObject = arrayOfb[i];
        Hashtable localHashtable = a;
        int k;
        if (x.x.length > 1) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          localObject = ((b)localObject).g();
          k = 0;
          int m = 1;
          while (k != localObject.length)
          {
            if (m != 0) {
              m = 0;
            } else {
              localStringBuffer.append('+');
            }
            e.c.a.a.b.l.c.a(localStringBuffer, localObject[k], localHashtable);
            k++;
          }
        }
        if (((b)localObject).f() != null) {
          e.c.a.a.b.l.c.a(localStringBuffer, ((b)localObject).f(), localHashtable);
        }
        i++;
      }
      return localStringBuffer.toString();
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     l.b.a.k2.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */