package e.b.a.a.q;

import e.a.a.a.a;
import e.b.a.a.h;
import e.b.a.a.i;
import e.b.a.a.k;

public final class d
  extends k
{
  public final d c;
  public b d;
  public d e;
  public String f;
  public int g;
  public int h;
  
  public d(d paramd, b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    c = paramd;
    d = paramb;
    a = paramInt1;
    g = paramInt2;
    h = paramInt3;
    b = -1;
  }
  
  public d a(int paramInt1, int paramInt2)
  {
    Object localObject = e;
    if (localObject == null)
    {
      localObject = d;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((b)localObject).a();
      }
      localObject = new d(this, (b)localObject, 1, paramInt1, paramInt2);
      e = ((d)localObject);
    }
    else
    {
      ((d)localObject).a(1, paramInt1, paramInt2);
    }
    return (d)localObject;
  }
  
  public String a()
  {
    return f;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = -1;
    g = paramInt2;
    h = paramInt3;
    f = null;
    b localb = d;
    if (localb != null)
    {
      b = null;
      c = null;
      d = null;
    }
  }
  
  public void a(String paramString)
  {
    f = paramString;
    Object localObject = d;
    if ((localObject != null) && (((b)localObject).a(paramString)))
    {
      localObject = a;
      if ((localObject instanceof i)) {
        localObject = (i)localObject;
      } else {
        localObject = null;
      }
      throw new h((i)localObject, a.a("Duplicate field '", paramString, "'"));
    }
  }
  
  public d b(int paramInt1, int paramInt2)
  {
    Object localObject = e;
    if (localObject == null)
    {
      localObject = d;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((b)localObject).a();
      }
      localObject = new d(this, (b)localObject, 2, paramInt1, paramInt2);
      e = ((d)localObject);
      return (d)localObject;
    }
    ((d)localObject).a(2, paramInt1, paramInt2);
    return (d)localObject;
  }
}

/* Location:
 * Qualified Name:     e.b.a.a.q.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */