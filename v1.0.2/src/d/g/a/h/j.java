package d.g.a.h;

import d.g.a.e;
import d.g.a.g;
import e.a.a.a.a;
import java.util.HashSet;

public class j
  extends l
{
  public c c;
  public j d;
  public float e;
  public j f;
  public float g;
  public int h = 0;
  public j i;
  public k j = null;
  public int k = 1;
  public k l = null;
  public int m = 1;
  
  public j(c paramc)
  {
    c = paramc;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 1) {
      return "DIRECT";
    }
    if (paramInt == 2) {
      return "CENTER";
    }
    if (paramInt == 3) {
      return "MATCH";
    }
    if (paramInt == 4) {
      return "CHAIN";
    }
    if (paramInt == 5) {
      return "BARRIER";
    }
    return "UNCONNECTED";
  }
  
  public void a(int paramInt1, j paramj, int paramInt2)
  {
    h = paramInt1;
    d = paramj;
    e = paramInt2;
    a.add(this);
  }
  
  public void a(e parame)
  {
    g localg = c.i;
    j localj = f;
    if (localj == null) {
      parame.a(localg, (int)(g + 0.5F));
    } else {
      parame.a(localg, parame.a(c), (int)(g + 0.5F), 6);
    }
  }
  
  public void a(j paramj, float paramFloat)
  {
    if ((b == 0) || ((f != paramj) && (g != paramFloat)))
    {
      f = paramj;
      g = paramFloat;
      if (b == 1) {
        b();
      }
      a();
    }
  }
  
  public void a(j paramj, int paramInt)
  {
    d = paramj;
    e = paramInt;
    a.add(this);
  }
  
  public void a(j paramj, int paramInt, k paramk)
  {
    d = paramj;
    a.add(this);
    j = paramk;
    k = paramInt;
    a.add(this);
  }
  
  public void d()
  {
    int n = b;
    int i1 = 1;
    if (n == 1) {
      return;
    }
    if (h == 4) {
      return;
    }
    Object localObject1 = j;
    if (localObject1 != null)
    {
      if (b != 1) {
        return;
      }
      e = (k * c);
    }
    localObject1 = l;
    float f1;
    if (localObject1 != null)
    {
      if (b != 1) {
        return;
      }
      f1 = c;
    }
    if (h == 1)
    {
      localObject1 = d;
      if ((localObject1 == null) || (b == 1))
      {
        localObject1 = d;
        if (localObject1 == null)
        {
          f = this;
          g = e;
        }
        else
        {
          f = f;
          g = (g + e);
        }
        a();
        return;
      }
    }
    j localj;
    Object localObject2;
    if (h == 2)
    {
      localj = d;
      if ((localj != null) && (b == 1))
      {
        localObject1 = i;
        if (localObject1 != null)
        {
          localObject2 = d;
          if ((localObject2 != null) && (b == 1))
          {
            f = f;
            f = f;
            localObject1 = c.c;
            localObject2 = c.c.RIGHT;
            int i2 = 0;
            n = i1;
            if (localObject1 != localObject2) {
              if (localObject1 == c.c.BOTTOM) {
                n = i1;
              } else {
                n = 0;
              }
            }
            if (n != 0)
            {
              f1 = d.g;
              f2 = i.d.g;
            }
            else
            {
              f1 = i.d.g;
              f2 = d.g;
            }
            f1 -= f2;
            localObject2 = c;
            localObject1 = c;
            if ((localObject1 != c.c.LEFT) && (localObject1 != c.c.RIGHT))
            {
              f2 = f1 - b.d();
              f1 = c.b.W;
            }
            else
            {
              f2 = f1 - c.b.i();
              f1 = c.b.V;
            }
            int i3 = c.a();
            i1 = i.c.a();
            if (c.d == i.c.d)
            {
              f1 = 0.5F;
              i1 = 0;
            }
            else
            {
              i2 = i3;
            }
            float f3 = i2;
            float f4 = i1;
            float f2 = f2 - f3 - f4;
            if (n != 0)
            {
              localObject1 = i;
              g = (f2 * f1 + (d.g + f4));
              g = (d.g - f3 - (1.0F - f1) * f2);
            }
            else
            {
              g = (f2 * f1 + (d.g + f3));
              localObject1 = i;
              g = (d.g - f4 - (1.0F - f1) * f2);
            }
            a();
            i.a();
            return;
          }
        }
      }
    }
    if (h == 3)
    {
      localj = d;
      if ((localj != null) && (b == 1))
      {
        localObject2 = i;
        if (localObject2 != null)
        {
          localObject1 = d;
          if ((localObject1 != null) && (b == 1))
          {
            f = f;
            f = f;
            g += e;
            g += e;
            a();
            i.a();
            return;
          }
        }
      }
    }
    if (h == 5) {
      c.b.m();
    }
  }
  
  public void e()
  {
    b = 0;
    a.clear();
    d = null;
    e = 0.0F;
    j = null;
    k = 1;
    l = null;
    m = 1;
    f = null;
    g = 0.0F;
    i = null;
    h = 0;
  }
  
  public String toString()
  {
    if (b == 1)
    {
      if (f == this)
      {
        localStringBuilder = a.a("[");
        localStringBuilder.append(c);
        localStringBuilder.append(", RESOLVED: ");
        localStringBuilder.append(g);
        localStringBuilder.append("]  type: ");
        localStringBuilder.append(a(h));
        return localStringBuilder.toString();
      }
      localStringBuilder = a.a("[");
      localStringBuilder.append(c);
      localStringBuilder.append(", RESOLVED: ");
      localStringBuilder.append(f);
      localStringBuilder.append(":");
      localStringBuilder.append(g);
      localStringBuilder.append("] type: ");
      localStringBuilder.append(a(h));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = a.a("{ ");
    localStringBuilder.append(c);
    localStringBuilder.append(" UNRESOLVED} type: ");
    localStringBuilder.append(a(h));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.h.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */