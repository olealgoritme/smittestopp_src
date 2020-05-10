package e.b.a.a.q;

import e.a.a.a.a;
import e.b.a.a.f;
import e.b.a.a.k;

public class e
  extends k
{
  public final e c;
  public b d;
  public e e;
  public String f;
  public boolean g;
  
  public e(int paramInt, e parame, b paramb)
  {
    a = paramInt;
    c = parame;
    d = paramb;
    b = -1;
  }
  
  public int a(String paramString)
  {
    if ((a == 2) && (!g))
    {
      int i = 1;
      g = true;
      f = paramString;
      Object localObject1 = d;
      if ((localObject1 != null) && (((b)localObject1).a(paramString)))
      {
        Object localObject2 = a;
        localObject1 = a.a("Duplicate field '", paramString, "'");
        if ((localObject2 instanceof f)) {
          paramString = (f)localObject2;
        } else {
          paramString = null;
        }
        throw new e.b.a.a.e((String)localObject1, paramString);
      }
      if (b < 0) {
        i = 0;
      }
      return i;
    }
    return 4;
  }
  
  public final String a()
  {
    return f;
  }
  
  public e f()
  {
    Object localObject1 = e;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      localObject1 = d;
      if (localObject1 != null) {
        localObject2 = ((b)localObject1).a();
      }
      localObject2 = new e(2, this, (b)localObject2);
      e = ((e)localObject2);
      return (e)localObject2;
    }
    a = 2;
    b = -1;
    f = null;
    g = false;
    localObject2 = d;
    if (localObject2 != null)
    {
      b = null;
      c = null;
      d = null;
    }
    return (e)localObject1;
  }
  
  public int g()
  {
    int i = a;
    int j = 0;
    int k = 0;
    if (i == 2)
    {
      if (!g) {
        return 5;
      }
      g = false;
      b += 1;
      return 2;
    }
    if (i == 1)
    {
      j = b;
      b = (j + 1);
      if (j >= 0) {
        k = 1;
      }
      return k;
    }
    k = b + 1;
    b = k;
    if (k == 0) {
      k = j;
    } else {
      k = 3;
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */