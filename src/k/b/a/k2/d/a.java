package k.b.a.k2.d;

import java.util.Enumeration;
import java.util.Hashtable;
import k.b.a.k2.b;
import k.b.a.t;
import k.b.a.x;

public abstract class a
{
  public static Hashtable a(Hashtable paramHashtable)
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = paramHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      localHashtable.put(localObject, paramHashtable.get(localObject));
    }
    return localHashtable;
  }
  
  public boolean a(b paramb1, b paramb2)
  {
    int i = x.x.length;
    int j = x.x.length;
    boolean bool1 = true;
    if (i != j) {}
    boolean bool2;
    do
    {
      bool2 = false;
      break;
      paramb1 = paramb1.g();
      paramb2 = paramb2.g();
    } while (paramb1.length != paramb2.length);
    for (j = 0;; j++)
    {
      bool2 = bool1;
      if (j == paramb1.length) {
        break label167;
      }
      Object localObject1 = paramb1[j];
      Object localObject2 = paramb2[j];
      if ((localObject1 == localObject2) || ((localObject1 != null) && (localObject2 != null) && (x.b(x)) && (e.c.a.a.b.l.c.a(y).equals(e.c.a.a.b.l.c.a(y))))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
    }
    label167:
    return bool2;
  }
  
  public boolean a(k.b.a.k2.c paramc1, k.b.a.k2.c paramc2)
  {
    paramc1 = paramc1.f();
    b[] arrayOfb = paramc2.f();
    if (paramc1.length != arrayOfb.length) {
      return false;
    }
    boolean bool;
    if ((paramc1[0].f() != null) && (arrayOfb[0].f() != null)) {
      bool = 0fx.b(0fx) ^ true;
    } else {
      bool = false;
    }
    for (int i = 0; i != paramc1.length; i++)
    {
      paramc2 = paramc1[i];
      if (bool) {
        for (j = arrayOfb.length - 1;; j--)
        {
          if (j < 0) {
            break label178;
          }
          if ((arrayOfb[j] != null) && (a(paramc2, arrayOfb[j])))
          {
            arrayOfb[j] = null;
            break;
          }
        }
      }
      for (int j = 0; j != arrayOfb.length; j++) {
        if ((arrayOfb[j] != null) && (a(paramc2, arrayOfb[j])))
        {
          arrayOfb[j] = null;
          j = 1;
          break label181;
        }
      }
      label178:
      j = 0;
      label181:
      if (j == 0) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.k2.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */