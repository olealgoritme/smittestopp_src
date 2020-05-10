package d.g.a;

import java.util.Arrays;

public class g
{
  public static int k = 1;
  public String a;
  public int b = -1;
  public int c = -1;
  public int d = 0;
  public float e;
  public float[] f = new float[7];
  public a g;
  public b[] h = new b[8];
  public int i = 0;
  public int j = 0;
  
  public g(a parama)
  {
    g = parama;
  }
  
  public void a()
  {
    a = null;
    g = a.UNKNOWN;
    d = 0;
    b = -1;
    c = -1;
    e = 0.0F;
    i = 0;
    j = 0;
  }
  
  public final void a(b paramb)
  {
    int n;
    for (int m = 0;; m++)
    {
      n = i;
      if (m >= n) {
        break;
      }
      if (h[m] == paramb) {
        return;
      }
    }
    b[] arrayOfb = h;
    if (n >= arrayOfb.length) {
      h = ((b[])Arrays.copyOf(arrayOfb, arrayOfb.length * 2));
    }
    arrayOfb = h;
    m = i;
    arrayOfb[m] = paramb;
    i = (m + 1);
  }
  
  public final void b(b paramb)
  {
    int m = i;
    int n = 0;
    for (int i1 = 0; i1 < m; i1++) {
      if (h[i1] == paramb)
      {
        while (n < m - i1 - 1)
        {
          paramb = h;
          int i2 = i1 + n;
          paramb[i2] = paramb[(i2 + 1)];
          n++;
        }
        i -= 1;
        return;
      }
    }
  }
  
  public final void c(b paramb)
  {
    int m = i;
    label234:
    for (int n = 0; n < m; n++)
    {
      Object localObject1 = h;
      a locala = d;
      localObject1 = localObject1[n];
      int i1 = i;
      for (int i2 = 0;; i2++)
      {
        if ((i1 == -1) || (i2 >= a)) {
          break label234;
        }
        int i3 = f[i1];
        Object localObject2 = a;
        if (i3 == b)
        {
          float f1 = h[i1];
          locala.a((g)localObject2, false);
          localObject2 = d;
          i2 = i;
          for (i1 = 0; (i2 != -1) && (i1 < a); i1++)
          {
            locala.a(c.c[f[i2]], h[i2] * f1, false);
            i2 = g[i2];
          }
          float f2 = b;
          b = (b * f1 + f2);
          i1 = i;
          break;
        }
        i1 = g[i1];
      }
    }
    i = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("");
    localStringBuilder.append(a);
    return localStringBuilder.toString();
  }
  
  public static enum a
  {
    static
    {
      CONSTANT = new a("CONSTANT", 1);
      SLACK = new a("SLACK", 2);
      ERROR = new a("ERROR", 3);
      a locala = new a("UNKNOWN", 4);
      UNKNOWN = locala;
      $VALUES = new a[] { UNRESTRICTED, CONSTANT, SLACK, ERROR, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     d.g.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */