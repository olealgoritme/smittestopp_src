package d.g.a.h;

import d.g.a.g.a;

public class c
{
  public j a = new j(this);
  public final d b;
  public final c.c c;
  public c d;
  public int e = 0;
  public int f = -1;
  public c.b g = c.b.NONE;
  public int h;
  public d.g.a.g i;
  
  public c(d paramd, c.c paramc)
  {
    c.a locala = c.a.RELAXED;
    h = 0;
    b = paramd;
    c = paramc;
  }
  
  public int a()
  {
    if (b.Y == 8) {
      return 0;
    }
    int j = f;
    if (j > -1)
    {
      c localc = d;
      if ((localc != null) && (b.Y == 8)) {
        return j;
      }
    }
    return e;
  }
  
  public boolean a(c paramc, int paramInt1, int paramInt2, c.b paramb, int paramInt3, boolean paramBoolean)
  {
    if (paramc == null)
    {
      d = null;
      e = 0;
      f = -1;
      g = c.b.NONE;
      h = 2;
      return true;
    }
    if (!paramBoolean)
    {
      c.c localc1 = c;
      c.c localc2 = c;
      int j;
      if (localc1 == localc2)
      {
        if (localc2 == c.c.BASELINE)
        {
          if (b.Q > 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (j == 0) {
            break label217;
          }
          if (b.Q > 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (j == 0) {
            break label217;
          }
        }
      }
      else {
        switch (localc2.ordinal())
        {
        default: 
          throw new AssertionError(c.name());
        case 6: 
          if ((localc1 == c.c.BASELINE) || (localc1 == c.c.CENTER_X) || (localc1 == c.c.CENTER_Y)) {
            break;
          }
        }
      }
      for (;;)
      {
        j = 1;
        break;
        label217:
        label281:
        do
        {
          int k;
          do
          {
            j = 0;
            break label342;
            if ((localc1 != c.c.TOP) && (localc1 != c.c.BOTTOM)) {
              k = 0;
            } else {
              k = 1;
            }
            j = k;
            if (!(b instanceof g)) {
              break label281;
            }
            if (k != 0) {
              break;
            }
          } while (localc1 != c.c.CENTER_Y);
          break;
          do
          {
            break;
            if ((localc1 != c.c.LEFT) && (localc1 != c.c.RIGHT)) {
              k = 0;
            } else {
              k = 1;
            }
            j = k;
          } while (!(b instanceof g));
          if (k != 0) {
            break;
          }
        } while (localc1 != c.c.CENTER_X);
      }
      label342:
      if (j == 0) {
        return false;
      }
    }
    d = paramc;
    if (paramInt1 > 0) {
      e = paramInt1;
    } else {
      e = 0;
    }
    f = paramInt2;
    g = paramb;
    h = paramInt3;
    return true;
  }
  
  public boolean b()
  {
    boolean bool;
    if (d != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    d = null;
    e = 0;
    f = -1;
    g = c.b.STRONG;
    h = 0;
    c.a locala = c.a.RELAXED;
    a.e();
  }
  
  public void d()
  {
    d.g.a.g localg = i;
    if (localg == null) {
      i = new d.g.a.g(g.a.UNRESTRICTED);
    } else {
      localg.a();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.Z);
    localStringBuilder.append(":");
    localStringBuilder.append(c.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.h.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */