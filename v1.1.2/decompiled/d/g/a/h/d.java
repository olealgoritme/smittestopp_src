package d.g.a.h;

import d.g.a.b;
import d.g.a.g;
import java.util.ArrayList;
import java.util.HashSet;

public class d
{
  public static float j0 = 0.5F;
  public c[] A;
  public ArrayList<c> B;
  public a[] C;
  public d D;
  public int E;
  public int F;
  public float G;
  public int H;
  public int I;
  public int J;
  public int K;
  public int L;
  public int M;
  public int N;
  public int O;
  public int P;
  public int Q;
  public int R;
  public int S;
  public int T;
  public int U;
  public float V;
  public float W;
  public Object X;
  public int Y;
  public String Z;
  public int a = -1;
  public String a0;
  public int b = -1;
  public boolean b0;
  public k c;
  public boolean c0;
  public k d;
  public boolean d0;
  public int e = 0;
  public int e0;
  public int f = 0;
  public int f0;
  public int[] g = new int[2];
  public float[] g0;
  public int h = 0;
  public d[] h0;
  public int i = 0;
  public d[] i0;
  public float j = 1.0F;
  public int k = 0;
  public int l = 0;
  public float m = 1.0F;
  public int n = -1;
  public float o = 1.0F;
  public f p = null;
  public int[] q = { Integer.MAX_VALUE, Integer.MAX_VALUE };
  public float r = 0.0F;
  public c s = new c(this, c.c.LEFT);
  public c t = new c(this, c.c.TOP);
  public c u = new c(this, c.c.RIGHT);
  public c v = new c(this, c.c.BOTTOM);
  public c w = new c(this, c.c.BASELINE);
  public c x = new c(this, c.c.CENTER_X);
  public c y = new c(this, c.c.CENTER_Y);
  public c z;
  
  public d()
  {
    Object localObject = new c(this, c.c.CENTER);
    z = ((c)localObject);
    A = new c[] { s, u, t, v, w, localObject };
    localObject = new ArrayList();
    B = ((ArrayList)localObject);
    a locala = a.FIXED;
    C = new a[] { locala, locala };
    D = null;
    E = 0;
    F = 0;
    G = 0.0F;
    H = -1;
    I = 0;
    J = 0;
    K = 0;
    L = 0;
    M = 0;
    N = 0;
    O = 0;
    P = 0;
    Q = 0;
    float f1 = j0;
    V = f1;
    W = f1;
    Y = 0;
    Z = null;
    a0 = null;
    b0 = false;
    c0 = false;
    d0 = false;
    e0 = 0;
    f0 = 0;
    g0 = new float[] { -1.0F, -1.0F };
    h0 = new d[] { null, null };
    i0 = new d[] { null, null };
    ((ArrayList)localObject).add(s);
    B.add(t);
    B.add(u);
    B.add(v);
    B.add(x);
    B.add(y);
    B.add(z);
    B.add(w);
  }
  
  public c a(c.c paramc)
  {
    switch (paramc.ordinal())
    {
    default: 
      throw new AssertionError(paramc.name());
    case 0: 
      return null;
    case 8: 
      return y;
    case 7: 
      return x;
    case 6: 
      return z;
    case 5: 
      return w;
    case 4: 
      return v;
    case 3: 
      return u;
    case 2: 
      return t;
    }
    return s;
  }
  
  public void a(int paramInt)
  {
    for (int i1 = 0; i1 < 6; i1++)
    {
      localj1 = A[i1].a;
      localObject1 = c;
      localObject2 = d;
      if (localObject2 != null)
      {
        if (d == localObject1)
        {
          h = 4;
          a.h = 4;
        }
        int i2 = c.a();
        localObject1 = c.c;
        int i3;
        if (localObject1 != c.c.RIGHT)
        {
          i3 = i2;
          if (localObject1 != c.c.BOTTOM) {}
        }
        else
        {
          i3 = -i2;
        }
        localj1.a(a, i3);
      }
    }
    j localj2 = s.a;
    j localj1 = t.a;
    Object localObject1 = u.a;
    Object localObject2 = v.a;
    if ((paramInt & 0x8) == 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((C[0] == a.MATCH_CONSTRAINT) && (i.a(this, 0))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((h != 4) && (h != 4)) {
      if ((C[0] != a.FIXED) && ((i1 == 0) || (Y != 8)))
      {
        if (i1 != 0)
        {
          i1 = i();
          h = 1;
          h = 1;
          if ((s.d == null) && (u.d == null))
          {
            if (paramInt != 0)
            {
              ((j)localObject1).a(localj2, 1, g());
            }
            else
            {
              d = localj2;
              e = i1;
              a.add(localObject1);
            }
          }
          else if ((s.d != null) && (u.d == null))
          {
            if (paramInt != 0)
            {
              ((j)localObject1).a(localj2, 1, g());
            }
            else
            {
              d = localj2;
              e = i1;
              a.add(localObject1);
            }
          }
          else if ((s.d == null) && (u.d != null))
          {
            if (paramInt != 0)
            {
              localj2.a((j)localObject1, -1, g());
            }
            else
            {
              i1 = -i1;
              d = ((j)localObject1);
              e = i1;
              a.add(localj2);
            }
          }
          else if ((s.d != null) && (u.d != null))
          {
            if (paramInt != 0)
            {
              ga.add(localj2);
              ga.add(localObject1);
            }
            if (G == 0.0F)
            {
              h = 3;
              h = 3;
              i = ((j)localObject1);
              i = localj2;
            }
            else
            {
              h = 2;
              h = 2;
              i = ((j)localObject1);
              i = localj2;
              f(i1);
            }
          }
        }
      }
      else if ((s.d == null) && (u.d == null))
      {
        h = 1;
        h = 1;
        if (paramInt != 0)
        {
          ((j)localObject1).a(localj2, 1, g());
        }
        else
        {
          i1 = i();
          d = localj2;
          e = i1;
          a.add(localObject1);
        }
      }
      else if ((s.d != null) && (u.d == null))
      {
        h = 1;
        h = 1;
        if (paramInt != 0)
        {
          ((j)localObject1).a(localj2, 1, g());
        }
        else
        {
          i1 = i();
          d = localj2;
          e = i1;
          a.add(localObject1);
        }
      }
      else if ((s.d == null) && (u.d != null))
      {
        h = 1;
        h = 1;
        i1 = -i();
        d = ((j)localObject1);
        e = i1;
        a.add(localj2);
        if (paramInt != 0)
        {
          localj2.a((j)localObject1, -1, g());
        }
        else
        {
          i1 = -i();
          d = ((j)localObject1);
          e = i1;
          a.add(localj2);
        }
      }
      else if ((s.d != null) && (u.d != null))
      {
        h = 2;
        h = 2;
        if (paramInt != 0)
        {
          ga.add(localj2);
          ga.add(localObject1);
          k localk = g();
          i = ((j)localObject1);
          l = localk;
          m = -1;
          localk = g();
          i = localj2;
          l = localk;
          m = 1;
        }
        else
        {
          i = ((j)localObject1);
          i = localj2;
        }
      }
    }
    if ((C[1] == a.MATCH_CONSTRAINT) && (i.a(this, 1))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((h != 4) && (h != 4)) {
      if ((C[1] != a.FIXED) && ((i1 == 0) || (Y != 8)))
      {
        if (i1 != 0)
        {
          i1 = d();
          h = 1;
          h = 1;
          if ((t.d == null) && (v.d == null))
          {
            if (paramInt != 0)
            {
              ((j)localObject2).a(localj1, 1, f());
            }
            else
            {
              d = localj1;
              e = i1;
              a.add(localObject2);
            }
          }
          else if ((t.d != null) && (v.d == null))
          {
            if (paramInt != 0)
            {
              ((j)localObject2).a(localj1, 1, f());
            }
            else
            {
              d = localj1;
              e = i1;
              a.add(localObject2);
            }
          }
          else if ((t.d == null) && (v.d != null))
          {
            if (paramInt != 0)
            {
              localj1.a((j)localObject2, -1, f());
            }
            else
            {
              paramInt = -i1;
              d = ((j)localObject2);
              e = paramInt;
              a.add(localj1);
            }
          }
          else if ((t.d != null) && (v.d != null))
          {
            if (paramInt != 0)
            {
              fa.add(localj1);
              ga.add(localObject2);
            }
            if (G == 0.0F)
            {
              h = 3;
              h = 3;
              i = ((j)localObject2);
              i = localj1;
            }
            else
            {
              h = 2;
              h = 2;
              i = ((j)localObject2);
              i = localj1;
              e(i1);
              paramInt = Q;
              if (paramInt > 0) {
                w.a.a(1, localj1, paramInt);
              }
            }
          }
        }
      }
      else if ((t.d == null) && (v.d == null))
      {
        h = 1;
        h = 1;
        if (paramInt != 0)
        {
          ((j)localObject2).a(localj1, 1, f());
        }
        else
        {
          paramInt = d();
          d = localj1;
          e = paramInt;
          a.add(localObject2);
        }
        localObject2 = w;
        if (d != null)
        {
          localObject2 = a;
          h = 1;
          localj1.a(1, (j)localObject2, -Q);
        }
      }
      else if ((t.d != null) && (v.d == null))
      {
        h = 1;
        h = 1;
        if (paramInt != 0)
        {
          ((j)localObject2).a(localj1, 1, f());
        }
        else
        {
          paramInt = d();
          d = localj1;
          e = paramInt;
          a.add(localObject2);
        }
        paramInt = Q;
        if (paramInt > 0) {
          w.a.a(1, localj1, paramInt);
        }
      }
      else if ((t.d == null) && (v.d != null))
      {
        h = 1;
        h = 1;
        if (paramInt != 0)
        {
          localj1.a((j)localObject2, -1, f());
        }
        else
        {
          paramInt = -d();
          d = ((j)localObject2);
          e = paramInt;
          a.add(localj1);
        }
        paramInt = Q;
        if (paramInt > 0) {
          w.a.a(1, localj1, paramInt);
        }
      }
      else if ((t.d != null) && (v.d != null))
      {
        h = 2;
        h = 2;
        if (paramInt != 0)
        {
          localObject1 = f();
          i = ((j)localObject2);
          l = ((k)localObject1);
          m = -1;
          localObject1 = f();
          i = localj1;
          l = ((k)localObject1);
          m = 1;
          fa.add(localj1);
          ga.add(localObject2);
        }
        else
        {
          i = ((j)localObject2);
          i = localj1;
        }
        paramInt = Q;
        if (paramInt > 0) {
          w.a.a(1, localj1, paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    I = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    E = paramInt1;
    paramInt2 = R;
    if (paramInt1 < paramInt2) {
      E = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      I = paramInt1;
      paramInt1 = paramInt2 - paramInt1;
      E = paramInt1;
      paramInt2 = R;
      if (paramInt1 < paramInt2) {
        E = paramInt2;
      }
    }
    else if (paramInt3 == 1)
    {
      J = paramInt1;
      paramInt2 -= paramInt1;
      F = paramInt2;
      paramInt1 = S;
      if (paramInt2 < paramInt1) {
        F = paramInt1;
      }
    }
    c0 = true;
  }
  
  public void a(d.g.a.c paramc)
  {
    s.d();
    t.d();
    u.d();
    v.d();
    w.d();
    z.d();
    x.d();
    y.d();
  }
  
  public void a(d.g.a.e parame)
  {
    g localg1 = parame.a(s);
    g localg2 = parame.a(u);
    Object localObject1 = parame.a(t);
    g localg3 = parame.a(v);
    Object localObject2 = parame.a(w);
    Object localObject3 = D;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool5;
    if (localObject3 != null)
    {
      if ((localObject3 != null) && (C[0] == a.WRAP_CONTENT)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject3 = D;
      if ((localObject3 != null) && (C[1] == a.WRAP_CONTENT)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (d(0)) {
        ((e)D).a(this, 0);
      }
      do
      {
        do
        {
          bool3 = true;
          break;
          localObject4 = s;
          localObject3 = d;
        } while ((localObject3 != null) && (d == localObject4));
        localObject3 = u;
        localObject4 = d;
      } while ((localObject4 != null) && (d == localObject3));
      bool3 = false;
      if (d(1)) {
        ((e)D).a(this, 1);
      }
      do
      {
        do
        {
          bool4 = true;
          break;
          localObject3 = t;
          localObject4 = d;
        } while ((localObject4 != null) && (d == localObject3));
        localObject4 = v;
        localObject3 = d;
      } while ((localObject3 != null) && (d == localObject4));
      bool4 = false;
      if ((bool1) && (Y != 8) && (s.d == null) && (u.d == null)) {
        parame.b(parame.a(D.u), localg2, 0, 1);
      }
      if ((bool2) && (Y != 8) && (t.d == null) && (v.d == null) && (w == null)) {
        parame.b(parame.a(D.v), localg3, 0, 1);
      }
      bool5 = bool3;
      bool6 = bool4;
      bool3 = bool1;
      bool4 = bool5;
      bool1 = bool6;
    }
    else
    {
      bool3 = false;
      bool4 = false;
      bool2 = false;
      bool1 = false;
    }
    int i1 = E;
    int i2 = R;
    int i3 = i1;
    if (i1 < i2) {
      i3 = i2;
    }
    int i4 = F;
    i1 = S;
    i2 = i4;
    if (i4 < i1) {
      i2 = i1;
    }
    int i5;
    if (C[0] != a.MATCH_CONSTRAINT) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i6;
    if (C[1] != a.MATCH_CONSTRAINT) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    n = H;
    float f1 = G;
    o = f1;
    i1 = e;
    int i7 = f;
    Object localObject5;
    if ((f1 > 0.0F) && (Y != 8))
    {
      i4 = i1;
      if (C[0] == a.MATCH_CONSTRAINT)
      {
        i4 = i1;
        if (i1 == 0) {
          i4 = 3;
        }
      }
      i1 = i7;
      if (C[1] == a.MATCH_CONSTRAINT)
      {
        i1 = i7;
        if (i7 == 0) {
          i1 = 3;
        }
      }
      localObject5 = C;
      localObject4 = localObject5[0];
      localObject3 = a.MATCH_CONSTRAINT;
      if ((localObject4 == localObject3) && (localObject5[1] == localObject3) && (i4 == 3) && (i1 == 3))
      {
        if (n == -1) {
          if ((i5 != 0) && (i6 == 0))
          {
            n = 0;
          }
          else if ((i5 == 0) && (i6 != 0))
          {
            n = 1;
            if (H == -1) {
              o = (1.0F / o);
            }
          }
        }
        if ((n == 0) && ((!t.b()) || (!v.b()))) {
          n = 1;
        } else if ((n == 1) && ((!s.b()) || (!u.b()))) {
          n = 0;
        }
        if ((n == -1) && ((!t.b()) || (!v.b()) || (!s.b()) || (!u.b()))) {
          if ((t.b()) && (v.b()))
          {
            n = 0;
          }
          else if ((s.b()) && (u.b()))
          {
            o = (1.0F / o);
            n = 1;
          }
        }
        if (n == -1) {
          if ((bool3) && (!bool2))
          {
            n = 0;
          }
          else if ((!bool3) && (bool2))
          {
            o = (1.0F / o);
            n = 1;
          }
        }
        if (n == -1) {
          if ((h > 0) && (k == 0))
          {
            n = 0;
          }
          else if ((h == 0) && (k > 0))
          {
            o = (1.0F / o);
            n = 1;
          }
        }
        i7 = i3;
        if (n == -1)
        {
          i7 = i3;
          if (bool3)
          {
            i7 = i3;
            if (bool2)
            {
              o = (1.0F / o);
              n = 1;
              i7 = i3;
            }
          }
        }
      }
      else
      {
        localObject3 = C;
        localObject5 = localObject3[0];
        localObject4 = a.MATCH_CONSTRAINT;
        if ((localObject5 == localObject4) && (i4 == 3))
        {
          n = 0;
          i3 = (int)(o * F);
          i7 = i3;
          if (localObject3[1] != localObject4)
          {
            i7 = i3;
            i5 = i2;
            i4 = i1;
            i3 = 0;
            i6 = 4;
            i2 = i7;
            i1 = i5;
            i7 = i6;
            break label1353;
          }
        }
        else
        {
          i7 = i3;
          if (C[1] == a.MATCH_CONSTRAINT)
          {
            i7 = i3;
            if (i1 == 3)
            {
              n = 1;
              if (H == -1) {
                o = (1.0F / o);
              }
              i5 = (int)(o * E);
              localObject3 = C[0];
              localObject4 = a.MATCH_CONSTRAINT;
              i2 = i3;
              int i8 = i4;
              i6 = i2;
              i7 = i5;
              if (localObject3 == localObject4) {
                break label1304;
              }
              i3 = 0;
              i4 = 4;
              i1 = i5;
              i7 = i8;
              break label1353;
            }
          }
        }
      }
      i6 = i7;
      i7 = i2;
      label1304:
      i5 = i1;
      i3 = 1;
      i2 = i6;
      i1 = i7;
      i7 = i4;
      i4 = i5;
    }
    else
    {
      i4 = i7;
      i5 = 0;
      i7 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
    }
    label1353:
    localObject3 = g;
    localObject3[0] = i7;
    localObject3[1] = i4;
    if (i3 != 0)
    {
      i5 = n;
      if ((i5 == 0) || (i5 == -1))
      {
        bool6 = true;
        break label1402;
      }
    }
    boolean bool6 = false;
    label1402:
    if ((C[0] == a.WRAP_CONTENT) && ((this instanceof e))) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool7 = z.b() ^ true;
    if (a != 2)
    {
      localObject3 = D;
      if (localObject3 != null) {
        localObject3 = parame.a(u);
      } else {
        localObject3 = null;
      }
      localObject4 = D;
      if (localObject4 != null) {
        localObject4 = parame.a(s);
      } else {
        localObject4 = null;
      }
      a(parame, bool3, (g)localObject4, (g)localObject3, C[0], bool5, s, u, I, i2, R, q[0], V, bool6, bool4, i7, h, i, j, bool7);
    }
    localObject3 = localObject1;
    if (b == 2) {
      return;
    }
    if ((C[1] == a.WRAP_CONTENT) && ((this instanceof e))) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (i3 != 0)
    {
      i2 = n;
      if ((i2 == 1) || (i2 == -1))
      {
        bool4 = true;
        break label1648;
      }
    }
    boolean bool4 = false;
    label1648:
    i2 = Q;
    if (i2 > 0)
    {
      localObject4 = w.a;
      if (b == 1)
      {
        ((j)localObject4).a(parame);
      }
      else
      {
        localObject4 = parame;
        ((d.g.a.e)localObject4).a((g)localObject2, (g)localObject3, i2, 6);
        localObject1 = w.d;
        if (localObject1 != null)
        {
          ((d.g.a.e)localObject4).a((g)localObject2, ((d.g.a.e)localObject4).a(localObject1), 0, 6);
          bool6 = false;
          break label1745;
        }
      }
    }
    bool6 = bool7;
    label1745:
    Object localObject4 = parame;
    localObject2 = localObject3;
    localObject3 = D;
    if (localObject3 != null) {
      localObject3 = ((d.g.a.e)localObject4).a(v);
    } else {
      localObject3 = null;
    }
    localObject1 = D;
    if (localObject1 != null) {
      localObject4 = ((d.g.a.e)localObject4).a(t);
    } else {
      localObject4 = null;
    }
    a(parame, bool2, (g)localObject4, (g)localObject3, C[1], bool3, t, v, J, i1, S, q[1], W, bool4, bool1, i4, k, l, m, bool6);
    if (i3 != 0)
    {
      localObject3 = this;
      if (n == 1) {
        parame.a(localg3, (g)localObject2, localg2, localg1, o, 6);
      } else {
        parame.a(localg2, localg1, localg3, (g)localObject2, o, 6);
      }
    }
    localObject3 = this;
    if (z.b())
    {
      localObject5 = z.d.b;
      f1 = (float)Math.toRadians(r + 90.0F);
      i3 = z.a();
      localg3 = parame.a(((d)localObject3).a(c.c.LEFT));
      localObject2 = parame.a(((d)localObject3).a(c.c.TOP));
      localObject4 = parame.a(((d)localObject3).a(c.c.RIGHT));
      localObject1 = parame.a(((d)localObject3).a(c.c.BOTTOM));
      localObject3 = parame.a(((d)localObject5).a(c.c.LEFT));
      localg1 = parame.a(((d)localObject5).a(c.c.TOP));
      localg2 = parame.a(((d)localObject5).a(c.c.RIGHT));
      g localg4 = parame.a(((d)localObject5).a(c.c.BOTTOM));
      localObject5 = parame.b();
      double d1 = f1;
      double d2 = Math.sin(d1);
      double d3 = i3;
      ((b)localObject5).b((g)localObject2, (g)localObject1, localg1, localg4, (float)(d2 * d3));
      parame.a((b)localObject5);
      localObject2 = parame.b();
      ((b)localObject2).b(localg3, (g)localObject4, (g)localObject3, localg2, (float)(Math.cos(d1) * d3));
      parame.a((b)localObject2);
    }
  }
  
  public final void a(d.g.a.e parame, boolean paramBoolean1, g paramg1, g paramg2, a parama, boolean paramBoolean2, c paramc1, c paramc2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5)
  {
    g localg1 = parame.a(paramc1);
    g localg2 = parame.a(paramc2);
    g localg3 = parame.a(d);
    Object localObject1 = parame.a(d);
    Object localObject2;
    if (g)
    {
      localObject2 = a;
      if ((b == 1) && (a.b == 1))
      {
        ((j)localObject2).a(parame);
        a.a(parame);
        if ((!paramBoolean4) && (paramBoolean1)) {
          parame.b(paramg2, localg2, 0, 6);
        }
        return;
      }
    }
    boolean bool1 = paramc1.b();
    boolean bool2 = paramc2.b();
    boolean bool3 = z.b();
    if (bool1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (bool2) {
      i2 = i1 + 1;
    }
    int i1 = i2;
    if (bool3) {
      i1 = i2 + 1;
    }
    if (paramBoolean3) {
      i2 = 3;
    } else {
      i2 = paramInt5;
    }
    paramInt5 = parama.ordinal();
    if (paramInt5 != 0) {
      if ((paramInt5 != 1) && (paramInt5 == 2)) {}
    }
    for (;;)
    {
      paramInt5 = 0;
      break;
      if (i2 != 4)
      {
        paramInt5 = 1;
        break;
      }
    }
    if (Y == 8)
    {
      paramInt2 = 0;
      paramInt5 = 0;
    }
    if (paramBoolean5) {
      if ((!bool1) && (!bool2) && (!bool3)) {
        parame.a(localg1, paramInt1);
      } else if ((bool1) && (!bool2)) {
        parame.a(localg1, localg3, paramc1.a(), 6);
      }
    }
    parama = (a)localObject1;
    if (paramInt5 == 0)
    {
      if (paramBoolean2)
      {
        parame.a(localg2, localg1, 0, 3);
        if (paramInt3 > 0) {
          parame.b(localg2, localg1, paramInt3, 6);
        }
        if (paramInt4 < Integer.MAX_VALUE) {
          parame.c(localg2, localg1, paramInt4, 6);
        }
      }
      else
      {
        parame.a(localg2, localg1, paramInt2, 6);
      }
      paramInt4 = paramInt6;
      paramInt2 = paramInt5;
      paramInt5 = paramInt7;
    }
    else
    {
      paramInt4 = paramInt6;
      if (paramInt6 == -2) {
        paramInt4 = paramInt2;
      }
      paramInt1 = paramInt7;
      if (paramInt7 == -2) {
        paramInt1 = paramInt2;
      }
      paramInt6 = paramInt2;
      if (paramInt4 > 0)
      {
        parame.b(localg2, localg1, paramInt4, 6);
        paramInt6 = Math.max(paramInt2, paramInt4);
      }
      paramInt2 = paramInt6;
      if (paramInt1 > 0)
      {
        parame.c(localg2, localg1, paramInt1, 6);
        paramInt2 = Math.min(paramInt6, paramInt1);
      }
      if (i2 == 1)
      {
        if (paramBoolean1) {
          parame.a(localg2, localg1, paramInt2, 6);
        } else if (paramBoolean4) {
          parame.a(localg2, localg1, paramInt2, 4);
        } else {
          parame.a(localg2, localg1, paramInt2, 1);
        }
      }
      else if (i2 == 2)
      {
        localObject1 = c;
        if ((localObject1 != c.c.TOP) && (localObject1 != c.c.BOTTOM))
        {
          localObject2 = parame.a(D.a(c.c.LEFT));
          localObject1 = parame.a(D.a(c.c.RIGHT));
        }
        else
        {
          localObject2 = parame.a(D.a(c.c.TOP));
          localObject1 = parame.a(D.a(c.c.BOTTOM));
        }
        b localb = parame.b();
        localb.a(localg2, localg1, (g)localObject1, (g)localObject2, paramFloat2);
        parame.a(localb);
        paramInt5 = 0;
      }
      if ((paramInt5 != 0) && (i1 != 2) && (!paramBoolean3))
      {
        paramInt5 = Math.max(paramInt4, paramInt2);
        paramInt2 = paramInt5;
        if (paramInt1 > 0) {
          paramInt2 = Math.min(paramInt1, paramInt5);
        }
        parame.a(localg2, localg1, paramInt2, 6);
        paramInt2 = 0;
        paramInt5 = paramInt1;
      }
      else
      {
        paramInt2 = paramInt5;
        paramInt5 = paramInt1;
      }
    }
    localObject1 = parama;
    parama = localg3;
    if ((paramBoolean5) && (!paramBoolean4))
    {
      if ((!bool1) && (!bool2) && (!bool3))
      {
        if (paramBoolean1) {
          parame.b(paramg2, localg2, 0, 5);
        }
      }
      else if ((bool1) && (!bool2))
      {
        if (paramBoolean1) {
          parame.b(paramg2, localg2, 0, 5);
        }
      }
      else if ((!bool1) && (bool2))
      {
        parame.a(localg2, (g)localObject1, -paramc2.a(), 6);
        if (paramBoolean1) {
          parame.b(localg1, paramg1, 0, 5);
        }
      }
      else if ((bool1) && (bool2))
      {
        if (paramInt2 != 0)
        {
          if ((paramBoolean1) && (paramInt3 == 0)) {
            parame.b(localg2, localg1, 0, 6);
          }
          if (i2 == 0)
          {
            if ((paramInt5 <= 0) && (paramInt4 <= 0))
            {
              paramInt3 = 6;
              paramInt1 = 0;
            }
            else
            {
              paramInt3 = 4;
              paramInt1 = 1;
            }
            parame.a(localg1, parama, paramc1.a(), paramInt3);
            parame.a(localg2, (g)localObject1, -paramc2.a(), paramInt3);
            if ((paramInt5 <= 0) && (paramInt4 <= 0)) {
              paramInt4 = 0;
            } else {
              paramInt4 = 1;
            }
            paramInt5 = 5;
            paramInt3 = paramInt1;
            paramInt1 = paramInt5;
          }
          else
          {
            if (i2 != 1) {
              break label1065;
            }
            paramInt4 = 1;
            paramInt3 = 1;
            paramInt1 = 6;
          }
          paramInt6 = paramInt4;
          paramInt4 = paramInt3;
          paramInt5 = paramInt1;
          break label1164;
          label1065:
          if (i2 == 3)
          {
            if ((!paramBoolean3) && (n != -1) && (paramInt5 <= 0)) {
              paramInt1 = 6;
            } else {
              paramInt1 = 4;
            }
            parame.a(localg1, parama, paramc1.a(), paramInt1);
            parame.a(localg2, (g)localObject1, -paramc2.a(), paramInt1);
            paramInt1 = 1;
            paramInt3 = 1;
            break label1153;
          }
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = 1;
        }
        paramInt3 = 0;
        label1153:
        paramInt5 = 5;
        paramInt4 = paramInt3;
        paramInt6 = paramInt1;
        label1164:
        if (paramInt6 != 0)
        {
          paramInt3 = paramc1.a();
          paramInt1 = paramc2.a();
          paramBoolean2 = true;
          parame.a(localg1, parama, paramInt3, paramFloat1, (g)localObject1, localg2, paramInt1, paramInt5);
          paramBoolean3 = d.b instanceof a;
          paramBoolean4 = d.b instanceof a;
          if ((paramBoolean3) && (!paramBoolean4))
          {
            paramInt3 = 6;
            break label1281;
          }
          if ((!paramBoolean3) && (paramBoolean4))
          {
            paramBoolean2 = paramBoolean1;
            paramInt3 = 5;
            paramInt1 = 6;
            paramBoolean3 = true;
            break label1287;
          }
        }
        paramBoolean2 = paramBoolean1;
        paramInt3 = 5;
        label1281:
        paramBoolean3 = paramBoolean1;
        paramInt1 = 5;
        label1287:
        if (paramInt4 != 0)
        {
          paramInt3 = 6;
          paramInt1 = 6;
        }
        if (((paramInt2 == 0) && (paramBoolean3)) || (paramInt4 != 0)) {
          parame.b(localg1, parama, paramc1.a(), paramInt1);
        }
        if (((paramInt2 == 0) && (paramBoolean2)) || (paramInt4 != 0)) {
          parame.c(localg2, (g)localObject1, -paramc2.a(), paramInt3);
        }
        if (paramBoolean1) {
          parame.b(localg1, paramg1, 0, 6);
        }
      }
      if (paramBoolean1) {
        parame.b(paramg2, localg2, 0, 6);
      }
      return;
    }
    if ((i1 < 2) && (paramBoolean1))
    {
      parame.b(localg1, paramg1, 0, 6);
      parame.b(paramg2, localg2, 0, 6);
    }
  }
  
  public void a(c.c paramc1, d paramd, c.c paramc2, int paramInt1, int paramInt2)
  {
    a(paramc1).a(paramd.a(paramc2), paramInt1, paramInt2, c.b.STRONG, 0, true);
  }
  
  public void a(a parama)
  {
    C[0] = parama;
    if (parama == a.WRAP_CONTENT) {
      f(T);
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (Y != 8) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public a b(int paramInt)
  {
    if (paramInt == 0) {
      return e();
    }
    if (paramInt == 1) {
      return h();
    }
    return null;
  }
  
  public ArrayList<c> b()
  {
    return B;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    O = paramInt1;
    P = paramInt2;
  }
  
  public void b(d.g.a.e parame)
  {
    parame.a(s);
    parame.a(t);
    parame.a(u);
    parame.a(v);
    if (Q > 0) {
      parame.a(w);
    }
  }
  
  public void b(a parama)
  {
    C[1] = parama;
    if (parama == a.WRAP_CONTENT) {
      e(U);
    }
  }
  
  public int c()
  {
    return J + F;
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 0) {
      return i();
    }
    if (paramInt == 1) {
      return d();
    }
    return 0;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    J = paramInt1;
    paramInt1 = paramInt2 - paramInt1;
    F = paramInt1;
    paramInt2 = S;
    if (paramInt1 < paramInt2) {
      F = paramInt2;
    }
  }
  
  public void c(d.g.a.e parame)
  {
    int i1 = parame.b(s);
    int i2 = parame.b(t);
    int i3 = parame.b(u);
    int i4 = parame.b(v);
    int i5;
    if ((i3 - i1 >= 0) && (i4 - i2 >= 0) && (i1 != Integer.MIN_VALUE) && (i1 != Integer.MAX_VALUE) && (i2 != Integer.MIN_VALUE) && (i2 != Integer.MAX_VALUE) && (i3 != Integer.MIN_VALUE) && (i3 != Integer.MAX_VALUE) && (i4 != Integer.MIN_VALUE))
    {
      i5 = i4;
      if (i4 != Integer.MAX_VALUE) {}
    }
    else
    {
      i5 = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
    i4 = i3 - i1;
    i3 = i5 - i2;
    I = i1;
    J = i2;
    if (Y == 8)
    {
      E = 0;
      F = 0;
    }
    else
    {
      i5 = i4;
      if (C[0] == a.FIXED)
      {
        i2 = E;
        i5 = i4;
        if (i4 < i2) {
          i5 = i2;
        }
      }
      i2 = i3;
      if (C[1] == a.FIXED)
      {
        i1 = F;
        i2 = i3;
        if (i3 < i1) {
          i2 = i1;
        }
      }
      E = i5;
      F = i2;
      i5 = S;
      if (i2 < i5) {
        F = i5;
      }
      i5 = E;
      i2 = R;
      if (i5 < i2) {
        E = i2;
      }
      c0 = true;
    }
  }
  
  public int d()
  {
    if (Y == 8) {
      return 0;
    }
    return F;
  }
  
  public final boolean d(int paramInt)
  {
    paramInt *= 2;
    c[] arrayOfc = A;
    c localc = d;
    boolean bool = true;
    if ((localc != null) && (d.d != arrayOfc[paramInt]))
    {
      paramInt++;
      if ((d != null) && (d.d == arrayOfc[paramInt])) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public a e()
  {
    return C[0];
  }
  
  public void e(int paramInt)
  {
    F = paramInt;
    int i1 = S;
    if (paramInt < i1) {
      F = i1;
    }
  }
  
  public k f()
  {
    if (d == null) {
      d = new k();
    }
    return d;
  }
  
  public void f(int paramInt)
  {
    E = paramInt;
    int i1 = R;
    if (paramInt < i1) {
      E = i1;
    }
  }
  
  public k g()
  {
    if (c == null) {
      c = new k();
    }
    return c;
  }
  
  public a h()
  {
    return C[1];
  }
  
  public int i()
  {
    if (Y == 8) {
      return 0;
    }
    return E;
  }
  
  public boolean j()
  {
    return (s.a.b == 1) && (u.a.b == 1) && (t.a.b == 1) && (v.a.b == 1);
  }
  
  public void k()
  {
    s.c();
    t.c();
    u.c();
    v.c();
    w.c();
    x.c();
    y.c();
    z.c();
    D = null;
    r = 0.0F;
    E = 0;
    F = 0;
    G = 0.0F;
    H = -1;
    I = 0;
    J = 0;
    M = 0;
    N = 0;
    O = 0;
    P = 0;
    Q = 0;
    R = 0;
    S = 0;
    T = 0;
    U = 0;
    float f1 = j0;
    V = f1;
    W = f1;
    Object localObject = C;
    a locala = a.FIXED;
    localObject[0] = locala;
    localObject[1] = locala;
    X = null;
    Y = 0;
    a0 = null;
    e0 = 0;
    f0 = 0;
    localObject = g0;
    localObject[0] = -1.0F;
    localObject[1] = -1.0F;
    a = -1;
    b = -1;
    localObject = q;
    localObject[0] = Integer.MAX_VALUE;
    localObject[1] = Integer.MAX_VALUE;
    e = 0;
    f = 0;
    j = 1.0F;
    m = 1.0F;
    i = Integer.MAX_VALUE;
    l = Integer.MAX_VALUE;
    h = 0;
    k = 0;
    n = -1;
    o = 1.0F;
    localObject = c;
    if (localObject != null)
    {
      b = 0;
      a.clear();
      c = 0.0F;
    }
    localObject = d;
    if (localObject != null)
    {
      b = 0;
      a.clear();
      c = 0.0F;
    }
    p = null;
    b0 = false;
    c0 = false;
    d0 = false;
  }
  
  public void l()
  {
    for (int i1 = 0; i1 < 6; i1++) {
      A[i1].a.e();
    }
  }
  
  public void m() {}
  
  public void n()
  {
    int i1 = I;
    int i2 = J;
    M = i1;
    N = i2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = a0;
    String str = "";
    if (localObject != null) {
      localObject = e.a.a.a.a.a(e.a.a.a.a.a("type: "), a0, " ");
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (Z != null) {
      localObject = e.a.a.a.a.a(e.a.a.a.a.a("id: "), Z, " ");
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("(");
    localStringBuilder.append(I);
    localStringBuilder.append(", ");
    localStringBuilder.append(J);
    localStringBuilder.append(") - (");
    localStringBuilder.append(E);
    localStringBuilder.append(" x ");
    localStringBuilder.append(F);
    localStringBuilder.append(") wrap: (");
    localStringBuilder.append(T);
    localStringBuilder.append(" x ");
    localStringBuilder.append(U);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static enum a
  {
    static
    {
      MATCH_CONSTRAINT = new a("MATCH_CONSTRAINT", 2);
      a locala = new a("MATCH_PARENT", 3);
      MATCH_PARENT = locala;
      $VALUES = new a[] { FIXED, WRAP_CONTENT, MATCH_CONSTRAINT, locala };
    }
    
    public a() {}
  }
}

/* Location:
 * Qualified Name:     d.g.a.h.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */