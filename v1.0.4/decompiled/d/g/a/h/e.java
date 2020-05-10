package d.g.a.h;

import d.b.a.r;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e
  extends n
{
  public int A0 = 0;
  public int B0 = 0;
  public int C0 = 7;
  public boolean D0 = false;
  public boolean E0 = false;
  public boolean F0 = false;
  public boolean l0 = false;
  public d.g.a.e m0 = new d.g.a.e();
  public m n0;
  public int o0;
  public int p0;
  public int q0;
  public int r0;
  public int s0 = 0;
  public int t0 = 0;
  public b[] u0 = new b[4];
  public b[] v0 = new b[4];
  public List<f> w0 = new ArrayList();
  public boolean x0 = false;
  public boolean y0 = false;
  public boolean z0 = false;
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    int i = k0.size();
    for (int j = 0; j < i; j++) {
      ((d)k0.get(j)).a(paramInt);
    }
  }
  
  public void a(d paramd, int paramInt)
  {
    b[] arrayOfb;
    if (paramInt == 0)
    {
      paramInt = s0;
      arrayOfb = v0;
      if (paramInt + 1 >= arrayOfb.length) {
        v0 = ((b[])Arrays.copyOf(arrayOfb, arrayOfb.length * 2));
      }
      v0[s0] = new b(paramd, 0, l0);
      s0 += 1;
    }
    else if (paramInt == 1)
    {
      paramInt = t0;
      arrayOfb = u0;
      if (paramInt + 1 >= arrayOfb.length) {
        u0 = ((b[])Arrays.copyOf(arrayOfb, arrayOfb.length * 2));
      }
      u0[t0] = new b(paramd, 1, l0);
      t0 += 1;
    }
  }
  
  public boolean d(d.g.a.e parame)
  {
    a(parame);
    int i = k0.size();
    for (int j = 0; j < i; j++)
    {
      d locald = (d)k0.get(j);
      Object localObject2;
      if ((locald instanceof e))
      {
        Object localObject1 = C;
        localObject2 = localObject1[0];
        localObject1 = localObject1[1];
        if (localObject2 == d.a.WRAP_CONTENT) {
          locald.a(d.a.FIXED);
        }
        if (localObject1 == d.a.WRAP_CONTENT) {
          locald.b(d.a.FIXED);
        }
        locald.a(parame);
        if (localObject2 == d.a.WRAP_CONTENT) {
          locald.a((d.a)localObject2);
        }
        if (localObject1 == d.a.WRAP_CONTENT) {
          locald.b((d.a)localObject1);
        }
      }
      else
      {
        int k;
        int m;
        if ((C[0] != d.a.WRAP_CONTENT) && (C[0] == d.a.MATCH_PARENT))
        {
          k = s.e;
          m = i() - u.e;
          localObject2 = s;
          i = parame.a(localObject2);
          localObject2 = u;
          i = parame.a(localObject2);
          parame.a(s.i, k);
          parame.a(u.i, m);
          a = 2;
          locald.a(k, m);
        }
        if ((C[1] != d.a.WRAP_CONTENT) && (C[1] == d.a.MATCH_PARENT))
        {
          k = t.e;
          m = d() - v.e;
          localObject2 = t;
          i = parame.a(localObject2);
          localObject2 = v;
          i = parame.a(localObject2);
          parame.a(t.i, k);
          parame.a(v.i, m);
          if ((Q > 0) || (Y == 8))
          {
            localObject2 = w;
            i = parame.a(localObject2);
            parame.a(w.i, Q + k);
          }
          b = 2;
          locald.c(k, m);
        }
        locald.a(parame);
      }
    }
    if (s0 > 0) {
      r.a(this, parame, 0);
    }
    if (t0 > 0) {
      r.a(this, parame, 1);
    }
    return true;
  }
  
  public boolean g(int paramInt)
  {
    boolean bool;
    if ((C0 & paramInt) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void k()
  {
    m0.f();
    o0 = 0;
    q0 = 0;
    p0 = 0;
    r0 = 0;
    w0.clear();
    D0 = false;
    super.k();
  }
  
  public void o()
  {
    int i = I;
    int j = J;
    int k = Math.max(0, i());
    int m = Math.max(0, d());
    E0 = false;
    F0 = false;
    if (D != null)
    {
      if (n0 == null) {
        n0 = new m(this);
      }
      localObject1 = n0;
      if (localObject1 != null)
      {
        a = I;
        b = J;
        c = i();
        d = d();
        n = e.size();
        for (i1 = 0; i1 < n; i1++)
        {
          localObject3 = (m.a)e.get(i1);
          localObject4 = a(a.c);
          a = ((c)localObject4);
          if (localObject4 != null)
          {
            b = d;
            c = ((c)localObject4).a();
            localObject4 = a;
            d = g;
            e = h;
          }
          else
          {
            b = null;
            c = 0;
            d = c.b.STRONG;
            e = 0;
          }
        }
        I = o0;
        J = p0;
        localObject1 = D;
        if ((localObject1 != null) && ((localObject1 instanceof e))) {
          localObject1 = (e)localObject1;
        }
        n = B.size();
        for (i1 = 0; i1 < n; i1++) {
          ((c)B.get(i1)).c();
        }
        a(m0.l);
      }
      else
      {
        throw null;
      }
    }
    else
    {
      I = 0;
      J = 0;
    }
    if (C0 != 0)
    {
      if (!g(8)) {
        p();
      }
      if (!g(32))
      {
        if (!g(8)) {
          a(C0);
        }
        r();
      }
      m0.g = true;
    }
    else
    {
      m0.g = false;
    }
    Object localObject1 = C;
    Object localObject3 = localObject1[1];
    Object localObject4 = localObject1[0];
    q();
    if (w0.size() == 0)
    {
      w0.clear();
      w0.add(0, new f(k0));
    }
    int n = w0.size();
    Object localObject5 = k0;
    int i2;
    if ((e() != d.a.WRAP_CONTENT) && (h() != d.a.WRAP_CONTENT)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    int i3 = 0;
    int i4 = 0;
    int i1 = j;
    j = i3;
    int i5;
    for (;;)
    {
      i5 = 0;
      if ((i4 >= n) || (D0)) {
        break;
      }
      if (!w0.get(i4)).d)
      {
        Object localObject6;
        if (g(32)) {
          if ((e() == d.a.FIXED) && (h() == d.a.FIXED))
          {
            localObject6 = (f)w0.get(i4);
            if (!j.isEmpty())
            {
              localObject1 = j;
            }
            else
            {
              i3 = a.size();
              while (i5 < i3)
              {
                localObject1 = (d)a.get(i5);
                if (!b0) {
                  ((f)localObject6).a((ArrayList)j, (d)localObject1);
                }
                i5++;
              }
              k.clear();
              k.addAll(a);
              k.removeAll(j);
              localObject1 = j;
            }
            k0 = ((ArrayList)localObject1);
          }
          else
          {
            k0 = ((ArrayList)w0.get(i4)).a);
          }
        }
        q();
        int i6 = k0.size();
        for (i3 = 0; i3 < i6; i3++)
        {
          localObject1 = (d)k0.get(i3);
          if ((localObject1 instanceof n)) {
            ((n)localObject1).o();
          }
        }
        i5 = j;
        int i7 = 0;
        j = 1;
        i3 = n;
        n = i5;
        while (j != 0)
        {
          i5 = n;
          int i8 = i7 + 1;
          n = j;
          try
          {
            m0.f();
            n = j;
            q();
            n = j;
            b(m0);
            i7 = 0;
            for (;;)
            {
              if (i7 < i6)
              {
                n = j;
                localObject1 = (d)k0.get(i7);
              }
              try
              {
                ((d)localObject1).b(m0);
                i7++;
              }
              catch (Exception localException1)
              {
                n = j;
                localException2 = ???;
                break label1099;
              }
            }
            d(m0);
            try
            {
              localObject1 = m0;
              if (g)
              {
                for (n = 0; n < j; n++) {
                  if (!f[n].e)
                  {
                    n = 0;
                    break label1039;
                  }
                }
                n = 1;
                label1039:
                if (n == 0) {
                  ((d.g.a.e)localObject1).a(c);
                } else {
                  ((d.g.a.e)localObject1).a();
                }
              }
              else
              {
                ((d.g.a.e)localObject1).a(c);
              }
              n = 1;
            }
            catch (Exception localException1)
            {
              n = 1;
            }
            localException3.printStackTrace();
          }
          catch (Exception localException3) {}
          label1099:
          localObject6 = System.out;
          Object localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("EXCEPTION : ");
          ((StringBuilder)localObject7).append(localException3);
          ((PrintStream)localObject6).println(((StringBuilder)localObject7).toString());
          if (n != 0)
          {
            localObject2 = m0;
            localObject6 = i.a;
            localObject6[2] = 0;
            c((d.g.a.e)localObject2);
            n = k0.size();
            for (j = 0; j < n; j++)
            {
              localObject7 = (d)k0.get(j);
              ((d)localObject7).c((d.g.a.e)localObject2);
              if ((C[0] == d.a.MATCH_CONSTRAINT) && (((d)localObject7).i() < T)) {
                localObject6[2] = 1;
              }
              if ((C[1] == d.a.MATCH_CONSTRAINT) && (((d)localObject7).d() < U)) {
                localObject6[2] = 1;
              }
            }
            j = i1;
          }
          else
          {
            c(m0);
            for (n = 0;; n++)
            {
              j = i1;
              if (n >= i6) {
                break;
              }
              localObject2 = (d)k0.get(n);
              if ((C[0] == d.a.MATCH_CONSTRAINT) && (((d)localObject2).i() < T))
              {
                i.a[2] = true;
                j = i1;
                break;
              }
              if ((C[1] == d.a.MATCH_CONSTRAINT) && (((d)localObject2).d() < U))
              {
                i.a[2] = true;
                j = i1;
                break;
              }
            }
          }
          if ((i2 != 0) && (i8 < 8) && (i.a[2] != 0))
          {
            n = 0;
            i7 = 0;
            i1 = 0;
            while (n < i6)
            {
              localObject2 = (d)k0.get(n);
              i9 = I;
              i7 = Math.max(i7, ((d)localObject2).i() + i9);
              i9 = J;
              i1 = Math.max(i1, ((d)localObject2).d() + i9);
              n++;
            }
            n = Math.max(R, i7);
            int i9 = Math.max(S, i1);
            if ((localObject4 == d.a.WRAP_CONTENT) && (i() < n))
            {
              f(n);
              C[0] = d.a.WRAP_CONTENT;
              i5 = 1;
              i7 = 1;
            }
            else
            {
              i1 = 0;
              i7 = i5;
              i5 = i1;
            }
            n = i5;
            i1 = i7;
            if (localObject3 == d.a.WRAP_CONTENT)
            {
              n = i5;
              i1 = i7;
              if (d() < i9)
              {
                e(i9);
                C[1] = d.a.WRAP_CONTENT;
                n = 1;
                i1 = 1;
              }
            }
          }
          else
          {
            n = 0;
            i1 = i5;
          }
          i5 = Math.max(R, i());
          if (i5 > i())
          {
            f(i5);
            C[0] = d.a.FIXED;
            n = 1;
            i1 = 1;
          }
          i5 = Math.max(S, d());
          if (i5 > d())
          {
            e(i5);
            C[1] = d.a.FIXED;
            n = 1;
            i1 = 1;
          }
          i7 = n;
          i5 = i1;
          if (i1 == 0)
          {
            if ((C[0] == d.a.WRAP_CONTENT) && (k > 0) && (i() > k))
            {
              E0 = true;
              C[0] = d.a.FIXED;
              f(k);
              n = 1;
              i1 = 1;
            }
            else
            {
              i5 = n;
              n = i1;
              i1 = i5;
            }
            if ((C[1] == d.a.WRAP_CONTENT) && (m > 0) && (d() > m))
            {
              F0 = true;
              C[1] = d.a.FIXED;
              e(m);
              i5 = 1;
              i1 = 1;
            }
            else
            {
              i5 = n;
              i7 = i1;
            }
          }
          else
          {
            i1 = i5;
            i5 = i7;
          }
          i7 = i8;
          n = i1;
          i1 = j;
          j = i5;
        }
        localObject2 = (f)w0.get(i4);
        i5 = k.size();
        for (j = 0; j < i5; j++) {
          ((f)localObject2).a((d)k.get(j));
        }
        j = n;
        n = i3;
      }
      i4++;
    }
    k0 = ((ArrayList)localObject5);
    if (D != null)
    {
      i5 = Math.max(R, i());
      i3 = Math.max(S, d());
      localObject5 = n0;
      I = a;
      J = b;
      f(c);
      e(d);
      n = e.size();
      for (i1 = 0; i1 < n; i1++)
      {
        localObject2 = (m.a)e.get(i1);
        a(a.c).a(b, c, -1, d, e, false);
      }
      f(i5 + o0 + q0);
      e(i3 + p0 + r0);
    }
    else
    {
      I = i;
      J = i1;
    }
    if (j != 0)
    {
      localObject2 = C;
      localObject2[0] = localObject4;
      localObject2[1] = localObject3;
    }
    a(m0.l);
    localObject3 = D;
    Object localObject2 = this;
    while (localObject3 != null)
    {
      localObject4 = D;
      if ((localObject3 instanceof e)) {
        localObject2 = (e)localObject3;
      }
      localObject3 = localObject4;
    }
    if (this == localObject2) {
      n();
    }
  }
  
  public void p()
  {
    int i = k0.size();
    l();
    for (int j = 0; j < i; j++) {
      ((d)k0.get(j)).l();
    }
  }
  
  public final void q()
  {
    s0 = 0;
    t0 = 0;
  }
  
  public void r()
  {
    j localj1 = aLEFTa;
    j localj2 = aTOPa;
    localj1.a(null, 0.0F);
    localj2.a(null, 0.0F);
  }
}

/* Location:
 * Qualified Name:     base.d.g.a.h.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */