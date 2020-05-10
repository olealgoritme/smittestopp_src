package d.g.a;

import java.util.Arrays;

public class a
{
  public int a = 0;
  public final b b;
  public final c c;
  public int d = 8;
  public g e = null;
  public int[] f = new int[8];
  public int[] g = new int[8];
  public float[] h = new float[8];
  public int i = -1;
  public int j = -1;
  public boolean k = false;
  
  public a(b paramb, c paramc)
  {
    b = paramb;
    c = paramc;
  }
  
  public final float a(g paramg)
  {
    int m = i;
    for (int n = 0; (m != -1) && (n < a); n++)
    {
      if (f[m] == b) {
        return h[m];
      }
      m = g[m];
    }
    return 0.0F;
  }
  
  public final float a(g paramg, boolean paramBoolean)
  {
    if (e == paramg) {
      e = null;
    }
    int m = i;
    if (m == -1) {
      return 0.0F;
    }
    int n = 0;
    int i1 = -1;
    while ((m != -1) && (n < a))
    {
      if (f[m] == b)
      {
        if (m == i)
        {
          i = g[m];
        }
        else
        {
          int[] arrayOfInt = g;
          arrayOfInt[i1] = arrayOfInt[m];
        }
        if (paramBoolean) {
          paramg.b(b);
        }
        j -= 1;
        a -= 1;
        f[m] = -1;
        if (k) {
          j = m;
        }
        return h[m];
      }
      int i2 = g[m];
      n++;
      i1 = m;
      m = i2;
    }
    return 0.0F;
  }
  
  public final g a(int paramInt)
  {
    int m = i;
    for (int n = 0; (m != -1) && (n < a); n++)
    {
      if (n == paramInt) {
        return c.c[f[m]];
      }
      m = g[m];
    }
    return null;
  }
  
  public g a(boolean[] paramArrayOfBoolean, g paramg)
  {
    int m = i;
    int n = 0;
    Object localObject1 = null;
    float f2;
    for (float f1 = 0.0F; (m != -1) && (n < a); f1 = f2)
    {
      Object localObject2 = localObject1;
      f2 = f1;
      if (h[m] < 0.0F)
      {
        g localg = c.c[f[m]];
        if (paramArrayOfBoolean != null)
        {
          localObject2 = localObject1;
          f2 = f1;
          if (paramArrayOfBoolean[b] != 0) {}
        }
        else
        {
          localObject2 = localObject1;
          f2 = f1;
          if (localg != paramg)
          {
            g.a locala = g;
            if (locala != g.a.SLACK)
            {
              localObject2 = localObject1;
              f2 = f1;
              if (locala != g.a.ERROR) {}
            }
            else
            {
              float f3 = h[m];
              localObject2 = localObject1;
              f2 = f1;
              if (f3 < f1)
              {
                localObject2 = localg;
                f2 = f3;
              }
            }
          }
        }
      }
      m = g[m];
      n++;
      localObject1 = localObject2;
    }
    return (g)localObject1;
  }
  
  public final void a()
  {
    int m = i;
    for (int n = 0; (m != -1) && (n < a); n++)
    {
      g localg = c.c[f[m]];
      if (localg != null) {
        localg.b(b);
      }
      m = g[m];
    }
    i = -1;
    j = -1;
    k = false;
    a = 0;
  }
  
  public final void a(g paramg, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      a(paramg, true);
      return;
    }
    int m = i;
    if (m == -1)
    {
      i = 0;
      h[0] = paramFloat;
      f[0] = b;
      g[0] = -1;
      j += 1;
      paramg.a(b);
      a += 1;
      if (!k)
      {
        m = j + 1;
        j = m;
        paramg = f;
        if (m >= paramg.length)
        {
          k = true;
          j = (paramg.length - 1);
        }
      }
      return;
    }
    int n = 0;
    int i1 = -1;
    int i3;
    while ((m != -1) && (n < a))
    {
      arrayOfInt = f;
      int i2 = arrayOfInt[m];
      i3 = b;
      if (i2 == i3)
      {
        h[m] = paramFloat;
        return;
      }
      if (arrayOfInt[m] < i3) {
        i1 = m;
      }
      m = g[m];
      n++;
    }
    m = j;
    if (k)
    {
      arrayOfInt = f;
      if (arrayOfInt[m] != -1) {
        m = arrayOfInt.length;
      }
    }
    else
    {
      m++;
    }
    int[] arrayOfInt = f;
    n = m;
    if (m >= arrayOfInt.length)
    {
      n = m;
      if (a < arrayOfInt.length) {
        for (i3 = 0;; i3++)
        {
          arrayOfInt = f;
          n = m;
          if (i3 >= arrayOfInt.length) {
            break;
          }
          if (arrayOfInt[i3] == -1)
          {
            n = i3;
            break;
          }
        }
      }
    }
    arrayOfInt = f;
    m = n;
    if (n >= arrayOfInt.length)
    {
      m = arrayOfInt.length;
      n = d * 2;
      d = n;
      k = false;
      j = (m - 1);
      h = Arrays.copyOf(h, n);
      f = Arrays.copyOf(f, d);
      g = Arrays.copyOf(g, d);
    }
    f[m] = b;
    h[m] = paramFloat;
    if (i1 != -1)
    {
      arrayOfInt = g;
      arrayOfInt[m] = arrayOfInt[i1];
      arrayOfInt[i1] = m;
    }
    else
    {
      g[m] = i;
      i = m;
    }
    j += 1;
    paramg.a(b);
    a += 1;
    if (!k) {
      j += 1;
    }
    if (a >= f.length) {
      k = true;
    }
    m = j;
    paramg = f;
    if (m >= paramg.length)
    {
      k = true;
      j = (paramg.length - 1);
    }
  }
  
  public final void a(g paramg, float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    int m = i;
    if (m == -1)
    {
      i = 0;
      h[0] = paramFloat;
      f[0] = b;
      g[0] = -1;
      j += 1;
      paramg.a(b);
      a += 1;
      if (!k)
      {
        m = j + 1;
        j = m;
        paramg = f;
        if (m >= paramg.length)
        {
          k = true;
          j = (paramg.length - 1);
        }
      }
      return;
    }
    int n = 0;
    int i1 = -1;
    int i3;
    while ((m != -1) && (n < a))
    {
      localObject = f;
      int i2 = localObject[m];
      i3 = b;
      if (i2 == i3)
      {
        localObject = h;
        localObject[m] += paramFloat;
        if (localObject[m] == 0.0F)
        {
          if (m == i)
          {
            i = g[m];
          }
          else
          {
            localObject = g;
            localObject[i1] = localObject[m];
          }
          if (paramBoolean) {
            paramg.b(b);
          }
          if (k) {
            j = m;
          }
          j -= 1;
          a -= 1;
        }
        return;
      }
      if (localObject[m] < i3) {
        i1 = m;
      }
      m = g[m];
      n++;
    }
    m = j;
    if (k)
    {
      localObject = f;
      if (localObject[m] != -1) {
        m = localObject.length;
      }
    }
    else
    {
      m++;
    }
    Object localObject = f;
    n = m;
    if (m >= localObject.length)
    {
      n = m;
      if (a < localObject.length) {
        for (i3 = 0;; i3++)
        {
          localObject = f;
          n = m;
          if (i3 >= localObject.length) {
            break;
          }
          if (localObject[i3] == -1)
          {
            n = i3;
            break;
          }
        }
      }
    }
    localObject = f;
    m = n;
    if (n >= localObject.length)
    {
      m = localObject.length;
      n = d * 2;
      d = n;
      k = false;
      j = (m - 1);
      h = Arrays.copyOf(h, n);
      f = Arrays.copyOf(f, d);
      g = Arrays.copyOf(g, d);
    }
    f[m] = b;
    h[m] = paramFloat;
    if (i1 != -1)
    {
      localObject = g;
      localObject[m] = localObject[i1];
      localObject[i1] = m;
    }
    else
    {
      g[m] = i;
      i = m;
    }
    j += 1;
    paramg.a(b);
    a += 1;
    if (!k) {
      j += 1;
    }
    m = j;
    paramg = f;
    if (m >= paramg.length)
    {
      k = true;
      j = (paramg.length - 1);
    }
  }
  
  public final float b(int paramInt)
  {
    int m = i;
    for (int n = 0; (m != -1) && (n < a); n++)
    {
      if (n == paramInt) {
        return h[m];
      }
      m = g[m];
    }
    return 0.0F;
  }
  
  public final boolean b(g paramg)
  {
    int m = j;
    boolean bool = true;
    if (m > 1) {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    int m = i;
    Object localObject = "";
    for (int n = 0; (m != -1) && (n < a); n++)
    {
      localObject = e.a.a.a.a.a(e.a.a.a.a.b((String)localObject, " -> "));
      ((StringBuilder)localObject).append(h[m]);
      ((StringBuilder)localObject).append(" : ");
      localObject = e.a.a.a.a.a(((StringBuilder)localObject).toString());
      ((StringBuilder)localObject).append(c.c[f[m]]);
      localObject = ((StringBuilder)localObject).toString();
      m = g[m];
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     d.g.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */