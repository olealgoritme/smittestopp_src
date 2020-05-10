package k.b.a.k2;

import java.util.Enumeration;
import java.util.Hashtable;
import k.b.a.b0;
import k.b.a.d;
import k.b.a.e;
import k.b.a.e1;
import k.b.a.n;
import k.b.a.o;
import k.b.a.t;
import k.b.a.u;
import k.b.a.x;

public class c
  extends n
  implements d
{
  public static k.b.a.k2.d.a C = k.b.a.k2.d.b.L;
  public b[] A;
  public e1 B;
  public boolean x;
  public int y;
  public k.b.a.k2.d.a z;
  
  public c(u paramu)
  {
    z = ((k.b.a.k2.d.a)localObject1);
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
  
  public t c()
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
    Object localObject = ((e)paramObject).c();
    if (B.b((t)localObject)) {
      return true;
    }
    try
    {
      k.b.a.k2.d.a locala = z;
      localObject = new k/b/a/k2/c;
      ((c)localObject).<init>(u.a(((e)paramObject).c()));
      boolean bool = locala.a(this, (c)localObject);
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
    k.b.a.k2.d.b localb = (k.b.a.k2.d.b)z;
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
 * Qualified Name:     base.k.b.a.k2.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */