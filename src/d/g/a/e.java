package d.g.a;

import java.util.Arrays;
import java.util.HashMap;

public class e
{
  public static int p = 1000;
  public int a = 0;
  public HashMap<String, g> b = null;
  public e.a c;
  public int d = 32;
  public int e = 32;
  public b[] f = null;
  public boolean g = false;
  public boolean[] h = new boolean[32];
  public int i = 1;
  public int j = 0;
  public int k = 32;
  public final c l;
  public g[] m = new g[p];
  public int n = 0;
  public final e.a o;
  
  public e()
  {
    e();
    c localc = new c();
    l = localc;
    c = new d(localc);
    o = new b(l);
  }
  
  public b a(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = b();
    int i1 = 0;
    int i2 = 0;
    if (paramInt1 != 0)
    {
      i1 = i2;
      i2 = paramInt1;
      if (paramInt1 < 0)
      {
        i2 = paramInt1 * -1;
        i1 = 1;
      }
      b = i2;
    }
    if (i1 == 0)
    {
      d.a(paramg1, -1.0F);
      d.a(paramg2, 1.0F);
    }
    else
    {
      d.a(paramg1, 1.0F);
      d.a(paramg2, -1.0F);
    }
    if (paramInt2 != 6) {
      localb.a(this, paramInt2);
    }
    a(localb);
    return localb;
  }
  
  public g a(int paramInt, String paramString)
  {
    if (i + 1 >= e) {
      d();
    }
    paramString = a(g.a.ERROR, paramString);
    int i1 = a + 1;
    a = i1;
    i += 1;
    b = i1;
    d = paramInt;
    l.c[i1] = paramString;
    c.a(paramString);
    return paramString;
  }
  
  public final g a(g.a parama, String paramString)
  {
    paramString = (g)l.b.a();
    if (paramString == null)
    {
      paramString = new g(parama);
      g = parama;
      parama = paramString;
    }
    else
    {
      paramString.a();
      g = parama;
      parama = paramString;
    }
    int i1 = n;
    int i2 = p;
    if (i1 >= i2)
    {
      i1 = i2 * 2;
      p = i1;
      m = ((g[])Arrays.copyOf(m, i1));
    }
    paramString = m;
    i1 = n;
    n = (i1 + 1);
    paramString[i1] = parama;
    return parama;
  }
  
  public g a(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      return null;
    }
    if (i + 1 >= e) {
      d();
    }
    if ((paramObject instanceof d.g.a.h.c))
    {
      d.g.a.h.c localc = (d.g.a.h.c)paramObject;
      localObject = i;
      paramObject = localObject;
      if (localObject == null)
      {
        localc.d();
        paramObject = i;
      }
      int i1 = b;
      if ((i1 != -1) && (i1 <= a))
      {
        localObject = paramObject;
        if (l.c[i1] != null) {}
      }
      else
      {
        if (b != -1) {
          ((g)paramObject).a();
        }
        i1 = a + 1;
        a = i1;
        i += 1;
        b = i1;
        g = g.a.UNRESTRICTED;
        l.c[i1] = paramObject;
        localObject = paramObject;
      }
    }
    return (g)localObject;
  }
  
  public final void a()
  {
    for (int i1 = 0; i1 < j; i1++)
    {
      b localb = f[i1];
      a.e = b;
    }
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    int i1 = j;
    int i2 = 1;
    if ((i1 + 1 >= k) || (i + 1 >= e)) {
      d();
    }
    if (!e)
    {
      c(paramb);
      if ((a == null) && (b == 0.0F) && (d.a == 0)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return;
      }
      float f1 = b;
      if (f1 < 0.0F)
      {
        b = (f1 * -1.0F);
        localObject1 = d;
        i3 = i;
        for (i1 = 0; (i3 != -1) && (i1 < a); i1++)
        {
          localObject2 = h;
          localObject2[i3] *= -1.0F;
          i3 = g[i3];
        }
      }
      a locala = d;
      int i3 = i;
      i1 = 0;
      Object localObject3 = null;
      Object localObject1 = null;
      float f2 = 0.0F;
      boolean bool1 = false;
      float f3 = 0.0F;
      label327:
      int i5;
      for (int i4 = 0; (i3 != -1) && (i1 < a); i4 = i5)
      {
        Object localObject4 = h;
        float f4 = localObject4[i3];
        localObject2 = c.c[f[i3]];
        if (f4 < 0.0F)
        {
          f1 = f4;
          if (f4 <= -0.001F) {
            break label327;
          }
          localObject4[i3] = 0.0F;
          ((g)localObject2).b(b);
        }
        else
        {
          f1 = f4;
          if (f4 >= 0.001F) {
            break label327;
          }
          localObject4[i3] = 0.0F;
          ((g)localObject2).b(b);
        }
        f1 = 0.0F;
        localObject4 = localObject3;
        Object localObject5 = localObject1;
        f4 = f2;
        boolean bool2 = bool1;
        float f5 = f3;
        i5 = i4;
        if (f1 != 0.0F) {
          if (g == g.a.UNRESTRICTED)
          {
            if (localObject1 == null) {}
            for (bool2 = locala.b((g)localObject2);; bool2 = locala.b((g)localObject2))
            {
              break;
              if (f2 <= f1) {
                break label429;
              }
            }
            localObject4 = localObject3;
            localObject5 = localObject2;
            f4 = f1;
            f5 = f3;
            i5 = i4;
            break label728;
            label429:
            localObject4 = localObject3;
            localObject5 = localObject1;
            f4 = f2;
            bool2 = bool1;
            f5 = f3;
            i5 = i4;
            if (!bool1)
            {
              localObject4 = localObject3;
              localObject5 = localObject1;
              f4 = f2;
              bool2 = bool1;
              f5 = f3;
              i5 = i4;
              if (locala.b((g)localObject2))
              {
                bool2 = true;
                localObject4 = localObject3;
                localObject5 = localObject2;
                f4 = f1;
                f5 = f3;
                i5 = i4;
              }
            }
          }
          else
          {
            localObject4 = localObject3;
            localObject5 = localObject1;
            f4 = f2;
            bool2 = bool1;
            f5 = f3;
            i5 = i4;
            if (localObject1 == null)
            {
              localObject4 = localObject3;
              localObject5 = localObject1;
              f4 = f2;
              bool2 = bool1;
              f5 = f3;
              i5 = i4;
              if (f1 < 0.0F)
              {
                if (localObject3 == null) {}
                for (bool2 = locala.b((g)localObject2);; bool2 = locala.b((g)localObject2))
                {
                  i5 = bool2;
                  break;
                  if (f3 <= f1) {
                    break label642;
                  }
                }
                localObject4 = localObject2;
                localObject5 = localObject1;
                f4 = f2;
                bool2 = bool1;
                f5 = f1;
                break label728;
                label642:
                localObject4 = localObject3;
                localObject5 = localObject1;
                f4 = f2;
                bool2 = bool1;
                f5 = f3;
                i5 = i4;
                if (i4 == 0)
                {
                  localObject4 = localObject3;
                  localObject5 = localObject1;
                  f4 = f2;
                  bool2 = bool1;
                  f5 = f3;
                  i5 = i4;
                  if (locala.b((g)localObject2))
                  {
                    i5 = 1;
                    f5 = f1;
                    bool2 = bool1;
                    f4 = f2;
                    localObject5 = localObject1;
                    localObject4 = localObject2;
                  }
                }
              }
            }
          }
        }
        label728:
        i3 = g[i3];
        i1++;
        localObject3 = localObject4;
        localObject1 = localObject5;
        f2 = f4;
        bool1 = bool2;
        f3 = f5;
      }
      if (localObject1 != null) {
        localObject3 = localObject1;
      }
      if (localObject3 == null)
      {
        i1 = 1;
      }
      else
      {
        paramb.b((g)localObject3);
        i1 = 0;
      }
      if (d.a == 0) {
        e = true;
      }
      if (i1 != 0)
      {
        if (i + 1 >= e) {
          d();
        }
        localObject2 = a(g.a.SLACK, null);
        i1 = a + 1;
        a = i1;
        i += 1;
        b = i1;
        l.c[i1] = localObject2;
        a = ((g)localObject2);
        b(paramb);
        localObject1 = (b)o;
        if (localObject1 != null)
        {
          a = null;
          d.a();
          for (i1 = 0;; i1++)
          {
            localObject3 = d;
            if (i1 >= a) {
              break;
            }
            localObject3 = ((a)localObject3).a(i1);
            f1 = d.b(i1);
            d.a((g)localObject3, f1, true);
          }
          b(o);
          if (c == -1)
          {
            if (a == localObject2)
            {
              localObject2 = d.a(null, (g)localObject2);
              if (localObject2 != null) {
                paramb.b((g)localObject2);
              }
            }
            if (!e) {
              a.c(paramb);
            }
            j -= 1;
          }
          i1 = 1;
        }
        else
        {
          throw null;
        }
      }
      else
      {
        i1 = 0;
      }
      Object localObject2 = a;
      if (localObject2 != null)
      {
        i3 = i2;
        if (g == g.a.UNRESTRICTED) {
          break label1100;
        }
        if (b >= 0.0F)
        {
          i3 = i2;
          break label1100;
        }
      }
      i3 = 0;
      label1100:
      if (i3 == 0) {
        return;
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 == 0) {
      b(paramb);
    }
  }
  
  public void a(e.a parama)
  {
    c((b)parama);
    Object localObject;
    for (int i1 = 0; i1 < j; i1++)
    {
      localObject = f;
      if ((a.g != g.a.UNRESTRICTED) && (b < 0.0F))
      {
        i1 = 1;
        break label65;
      }
    }
    i1 = 0;
    label65:
    if (i1 != 0)
    {
      int i2 = 0;
      int i3;
      for (i1 = 0; i2 == 0; i1 = i3)
      {
        i3 = i1 + 1;
        float f1 = Float.MAX_VALUE;
        int i4 = 0;
        i1 = -1;
        int i5 = -1;
        int i9;
        g localg;
        for (int i6 = 0; i4 < j; i6 = i9)
        {
          localObject = f[i4];
          float f2;
          int i7;
          int i8;
          if (a.g == g.a.UNRESTRICTED)
          {
            f2 = f1;
            i7 = i1;
            i8 = i5;
            i9 = i6;
          }
          else if (e)
          {
            f2 = f1;
            i7 = i1;
            i8 = i5;
            i9 = i6;
          }
          else
          {
            f2 = f1;
            i7 = i1;
            i8 = i5;
            i9 = i6;
            if (b < 0.0F)
            {
              int i10 = 1;
              for (;;)
              {
                f2 = f1;
                i7 = i1;
                i8 = i5;
                i9 = i6;
                if (i10 >= i) {
                  break;
                }
                localg = l.c[i10];
                float f3 = d.a(localg);
                int i11;
                if (f3 <= 0.0F)
                {
                  f2 = f1;
                  i11 = i1;
                  i8 = i5;
                  i7 = i6;
                }
                else
                {
                  i8 = 0;
                  i9 = i1;
                  i1 = i8;
                  for (;;)
                  {
                    f2 = f1;
                    i11 = i9;
                    i8 = i5;
                    i7 = i6;
                    if (i1 >= 7) {
                      break;
                    }
                    f2 = f[i1] / f3;
                    if ((f2 >= f1) || (i1 != i6))
                    {
                      i8 = i6;
                      if (i1 <= i6) {}
                    }
                    else
                    {
                      i8 = i1;
                      f1 = f2;
                      i9 = i4;
                      i5 = i10;
                    }
                    i1++;
                    i6 = i8;
                  }
                }
                i10++;
                f1 = f2;
                i1 = i11;
                i5 = i8;
                i6 = i7;
              }
            }
          }
          i4++;
          f1 = f2;
          i1 = i7;
          i5 = i8;
        }
        if (i1 != -1)
        {
          localObject = f[i1];
          a.c = -1;
          ((b)localObject).b(l.c[i5]);
          localg = a;
          c = i1;
          localg.c((b)localObject);
        }
        else
        {
          i2 = 1;
        }
        if (i3 > i / 2) {
          i2 = 1;
        }
      }
    }
    b(parama);
    a();
  }
  
  public void a(g paramg, int paramInt)
  {
    int i1 = c;
    b localb;
    if (i1 != -1)
    {
      localb = f[i1];
      if (e)
      {
        b = paramInt;
      }
      else if (d.a == 0)
      {
        e = true;
        b = paramInt;
      }
      else
      {
        localb = b();
        if (paramInt < 0)
        {
          b = (paramInt * -1);
          d.a(paramg, 1.0F);
        }
        else
        {
          b = paramInt;
          d.a(paramg, -1.0F);
        }
        a(localb);
      }
    }
    else
    {
      localb = b();
      a = paramg;
      float f1 = paramInt;
      e = f1;
      b = f1;
      e = true;
      a(localb);
    }
  }
  
  public void a(g paramg1, g paramg2, int paramInt1, float paramFloat, g paramg3, g paramg4, int paramInt2, int paramInt3)
  {
    b localb = b();
    if (paramg2 == paramg3)
    {
      d.a(paramg1, 1.0F);
      d.a(paramg4, 1.0F);
      d.a(paramg2, -2.0F);
    }
    else if (paramFloat == 0.5F)
    {
      d.a(paramg1, 1.0F);
      d.a(paramg2, -1.0F);
      d.a(paramg3, -1.0F);
      d.a(paramg4, 1.0F);
      if ((paramInt1 > 0) || (paramInt2 > 0)) {
        b = (-paramInt1 + paramInt2);
      }
    }
    else if (paramFloat <= 0.0F)
    {
      d.a(paramg1, -1.0F);
      d.a(paramg2, 1.0F);
      b = paramInt1;
    }
    else if (paramFloat >= 1.0F)
    {
      d.a(paramg3, -1.0F);
      d.a(paramg4, 1.0F);
      b = paramInt2;
    }
    else
    {
      a locala = d;
      float f1 = 1.0F - paramFloat;
      locala.a(paramg1, f1 * 1.0F);
      d.a(paramg2, f1 * -1.0F);
      d.a(paramg3, -1.0F * paramFloat);
      d.a(paramg4, 1.0F * paramFloat);
      if ((paramInt1 > 0) || (paramInt2 > 0))
      {
        float f2 = -paramInt1;
        b = (paramInt2 * paramFloat + f2 * f1);
      }
    }
    if (paramInt3 != 6) {
      localb.a(this, paramInt3);
    }
    a(localb);
  }
  
  public void a(g paramg1, g paramg2, g paramg3, g paramg4, float paramFloat, int paramInt)
  {
    b localb = b();
    localb.a(paramg1, paramg2, paramg3, paramg4, paramFloat);
    if (paramInt != 6) {
      localb.a(this, paramInt);
    }
    a(localb);
  }
  
  public final int b(e.a parama)
  {
    for (int i1 = 0; i1 < i; i1++) {
      h[i1] = false;
    }
    int i2 = 0;
    i1 = 0;
    while (i2 == 0)
    {
      int i3 = i1 + 1;
      if (i3 >= i * 2) {
        return i3;
      }
      Object localObject1 = (b)parama;
      Object localObject2 = a;
      if (localObject2 != null) {
        h[b] = true;
      }
      localObject2 = h;
      localObject1 = d.a((boolean[])localObject2, null);
      if (localObject1 != null)
      {
        localObject2 = h;
        i1 = b;
        if (localObject2[i1] != 0) {
          return i3;
        }
        localObject2[i1] = 1;
      }
      if (localObject1 != null)
      {
        float f1 = Float.MAX_VALUE;
        i1 = 0;
        int i5;
        for (int i4 = -1; i1 < j; i4 = i5)
        {
          b localb = f[i1];
          float f2;
          if (a.g == g.a.UNRESTRICTED)
          {
            f2 = f1;
            i5 = i4;
          }
          else if (e)
          {
            f2 = f1;
            i5 = i4;
          }
          else
          {
            localObject2 = d;
            int i6 = i;
            if (i6 != -1) {
              for (i5 = 0; (i6 != -1) && (i5 < a); i5++)
              {
                if (f[i6] == b)
                {
                  i6 = 1;
                  break label287;
                }
                i6 = g[i6];
              }
            }
            i6 = 0;
            label287:
            f2 = f1;
            i5 = i4;
            if (i6 != 0)
            {
              float f3 = d.a((g)localObject1);
              f2 = f1;
              i5 = i4;
              if (f3 < 0.0F)
              {
                f3 = -b / f3;
                f2 = f1;
                i5 = i4;
                if (f3 < f1)
                {
                  i5 = i1;
                  f2 = f3;
                }
              }
            }
          }
          i1++;
          f1 = f2;
        }
        if (i4 > -1)
        {
          localObject2 = f[i4];
          a.c = -1;
          ((b)localObject2).b((g)localObject1);
          localObject1 = a;
          c = i4;
          ((g)localObject1).c((b)localObject2);
          i1 = i3;
          continue;
        }
      }
      i2 = 1;
      i1 = i3;
    }
    return i1;
  }
  
  public int b(Object paramObject)
  {
    paramObject = i;
    if (paramObject != null) {
      return (int)(e + 0.5F);
    }
    return 0;
  }
  
  public b b()
  {
    b localb = (b)l.a.a();
    if (localb == null)
    {
      localb = new b(l);
    }
    else
    {
      a = null;
      d.a();
      b = 0.0F;
      e = false;
    }
    g.k += 1;
    return localb;
  }
  
  public final void b(b paramb)
  {
    Object localObject = f;
    int i1 = j;
    if (localObject[i1] != null) {
      l.a.a(localObject[i1]);
    }
    localObject = f;
    i1 = j;
    localObject[i1] = paramb;
    localObject = a;
    c = i1;
    j = (i1 + 1);
    ((g)localObject).c(paramb);
  }
  
  public void b(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = b();
    g localg = c();
    d = 0;
    localb.a(paramg1, paramg2, localg, paramInt1);
    if (paramInt2 != 6)
    {
      paramInt1 = (int)(d.a(localg) * -1.0F);
      paramg1 = a(paramInt2, null);
      d.a(paramg1, paramInt1);
    }
    a(localb);
  }
  
  public g c()
  {
    if (i + 1 >= e) {
      d();
    }
    g localg = a(g.a.SLACK, null);
    int i1 = a + 1;
    a = i1;
    i += 1;
    b = i1;
    l.c[i1] = localg;
    return localg;
  }
  
  public final void c(b paramb)
  {
    if (j > 0)
    {
      a locala1 = d;
      b[] arrayOfb = f;
      int i1 = i;
      int i2 = 0;
      for (int i3 = 0;; i3++)
      {
        if ((i1 == -1) || (i3 >= a)) {
          break label240;
        }
        Object localObject = c.c[f[i1]];
        if (c != -1)
        {
          float f1 = h[i1];
          locala1.a((g)localObject, true);
          localObject = arrayOfb[c];
          if (!e)
          {
            a locala2 = d;
            i1 = i;
            for (i3 = i2; (i1 != -1) && (i3 < a); i3++)
            {
              locala1.a(c.c[f[i1]], h[i1] * f1, true);
              i1 = g[i1];
            }
          }
          float f2 = b;
          b = (b * f1 + f2);
          a.b(paramb);
          i1 = i;
          break;
        }
        i1 = g[i1];
      }
      label240:
      if (d.a == 0) {
        e = true;
      }
    }
  }
  
  public void c(g paramg1, g paramg2, int paramInt1, int paramInt2)
  {
    b localb = b();
    g localg = c();
    d = 0;
    localb.b(paramg1, paramg2, localg, paramInt1);
    if (paramInt2 != 6)
    {
      paramInt1 = (int)(d.a(localg) * -1.0F);
      paramg1 = a(paramInt2, null);
      d.a(paramg1, paramInt1);
    }
    a(localb);
  }
  
  public final void d()
  {
    int i1 = d * 2;
    d = i1;
    f = ((b[])Arrays.copyOf(f, i1));
    c localc = l;
    c = ((g[])Arrays.copyOf(c, d));
    i1 = d;
    h = new boolean[i1];
    e = i1;
    k = i1;
  }
  
  public final void e()
  {
    for (int i1 = 0;; i1++)
    {
      Object localObject = f;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      if (localObject != null) {
        l.a.a(localObject);
      }
      f[i1] = null;
    }
  }
  
  public void f()
  {
    Object localObject2;
    for (int i1 = 0;; i1++)
    {
      localObject1 = l;
      localObject2 = c;
      if (i1 >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i1];
      if (localObject2 != null) {
        ((g)localObject2).a();
      }
    }
    Object localObject1 = b;
    g[] arrayOfg = m;
    int i2 = n;
    if (localObject1 != null)
    {
      i1 = i2;
      if (i2 > arrayOfg.length) {
        i1 = arrayOfg.length;
      }
      for (i2 = 0; i2 < i1; i2++)
      {
        localObject2 = arrayOfg[i2];
        int i3 = b;
        Object[] arrayOfObject = a;
        if (i3 < arrayOfObject.length)
        {
          arrayOfObject[i3] = localObject2;
          b = (i3 + 1);
        }
      }
      n = 0;
      Arrays.fill(l.c, null);
      localObject2 = b;
      if (localObject2 != null) {
        ((HashMap)localObject2).clear();
      }
      a = 0;
      localObject2 = (b)c;
      d.a();
      a = null;
      b = 0.0F;
      i = 1;
      for (i1 = 0; i1 < j; i1++) {
        f[i1].c = false;
      }
      e();
      j = 0;
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */