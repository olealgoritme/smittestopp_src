package d.t.a;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class m
  implements Runnable
{
  public static final ThreadLocal<m> B = new ThreadLocal();
  public static Comparator<m.c> C = new m.a();
  public ArrayList<m.c> A = new ArrayList();
  public ArrayList<s> x = new ArrayList();
  public long y;
  public long z;
  
  public final s.x a(s params, int paramInt, long paramLong)
  {
    int i = B.b();
    for (int j = 0; j < i; j++)
    {
      localObject1 = s.b(B.d(j));
      if ((c == paramInt) && (!((s.x)localObject1).l()))
      {
        j = 1;
        break label65;
      }
    }
    j = 0;
    label65:
    if (j != 0) {
      return null;
    }
    Object localObject1 = y;
    try
    {
      params.m();
      s.x localx = ((s.q)localObject1).a(paramInt, false, paramLong);
      if (localx != null) {
        if ((localx.k()) && (!localx.l())) {
          ((s.q)localObject1).a(a);
        } else {
          ((s.q)localObject1).a(localx, false);
        }
      }
      return localx;
    }
    finally
    {
      params.a(false);
    }
  }
  
  public void a(long paramLong)
  {
    int i = x.size();
    int j = 0;
    Object localObject1;
    Object localObject3;
    for (int k = 0; j < i; k = m)
    {
      localObject1 = (s)x.get(j);
      m = k;
      if (((ViewGroup)localObject1).getWindowVisibility() == 0)
      {
        localObject3 = B0;
        d = 0;
        localObject3 = c;
        if (localObject3 != null) {
          Arrays.fill((int[])localObject3, -1);
        }
        m = k + B0.d;
      }
      j++;
    }
    A.ensureCapacity(k);
    k = 0;
    Object localObject4;
    int n;
    for (int m = 0; k < i; m = n)
    {
      localObject4 = (s)x.get(k);
      if (((ViewGroup)localObject4).getWindowVisibility() != 0)
      {
        n = m;
      }
      else
      {
        localObject3 = B0;
        j = Math.abs(a);
        int i1 = Math.abs(b) + j;
        for (j = 0;; j += 2)
        {
          n = m;
          if (j >= d * 2) {
            break;
          }
          if (m >= A.size())
          {
            localObject1 = new m.c();
            A.add(localObject1);
          }
          else
          {
            localObject1 = (m.c)A.get(m);
          }
          n = c[(j + 1)];
          boolean bool;
          if (n <= i1) {
            bool = true;
          } else {
            bool = false;
          }
          a = bool;
          b = i1;
          c = n;
          d = ((s)localObject4);
          e = c[j];
          m++;
        }
      }
      k++;
    }
    Collections.sort(A, C);
    for (m = 0; m < A.size(); m++)
    {
      localObject1 = (m.c)A.get(m);
      if (d == null) {
        break;
      }
      long l;
      if (a) {
        l = Long.MAX_VALUE;
      } else {
        l = paramLong;
      }
      localObject3 = a(d, e, l);
      if ((localObject3 != null) && (b != null) && (((s.x)localObject3).k()) && (!((s.x)localObject3).l()))
      {
        localObject3 = (s)b.get();
        if (localObject3 != null)
        {
          if ((b0) && (B.b() != 0)) {
            ((s)localObject3).o();
          }
          localObject4 = B0;
          d = 0;
          int[] arrayOfInt = c;
          if (arrayOfInt != null) {
            Arrays.fill(arrayOfInt, -1);
          }
          if (d != 0) {
            try
            {
              d.i.e.b.a("RV Nested Prefetch");
              C0.d = 1;
              throw null;
            }
            finally
            {
              d.i.e.b.a();
            }
          }
        }
      }
      a = false;
      b = 0;
      c = 0;
      d = null;
      e = 0;
    }
  }
  
  public void a(s params, int paramInt1, int paramInt2)
  {
    if ((N) && (y == 0L))
    {
      y = params.getNanoTime();
      params.post(this);
    }
    params = B0;
    a = paramInt1;
    b = paramInt2;
  }
  
  public void run()
  {
    try
    {
      d.i.e.b.a("RV Prefetch");
      boolean bool = x.isEmpty();
      if (bool) {
        return;
      }
      int i = x.size();
      int j = 0;
      long l2;
      for (long l1 = 0L; j < i; l1 = l2)
      {
        s locals = (s)x.get(j);
        l2 = l1;
        if (locals.getWindowVisibility() == 0) {
          l2 = Math.max(locals.getDrawingTime(), l1);
        }
        j++;
      }
      if (l1 == 0L) {
        return;
      }
      a(TimeUnit.MILLISECONDS.toNanos(l1) + z);
      return;
    }
    finally
    {
      y = 0L;
      d.i.e.b.a();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */