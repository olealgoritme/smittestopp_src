package d.t.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.w;
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
  public static Comparator<c> C = new a();
  public ArrayList<c> A = new ArrayList();
  public ArrayList<RecyclerView> x = new ArrayList();
  public long y;
  public long z;
  
  public final RecyclerView.w a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    int i = B.b();
    for (int j = 0; j < i; j++)
    {
      localObject1 = RecyclerView.b(B.d(j));
      if ((c == paramInt) && (!((RecyclerView.w)localObject1).l()))
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
      paramRecyclerView.m();
      RecyclerView.w localw = ((RecyclerView.p)localObject1).a(paramInt, false, paramLong);
      if (localw != null) {
        if ((localw.k()) && (!localw.l())) {
          ((RecyclerView.p)localObject1).a(a);
        } else {
          ((RecyclerView.p)localObject1).a(localw, false);
        }
      }
      return localw;
    }
    finally
    {
      paramRecyclerView.a(false);
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
      localObject1 = (RecyclerView)x.get(j);
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
    j = 0;
    Object localObject4;
    int n;
    for (int m = 0; j < i; m = n)
    {
      localObject4 = (RecyclerView)x.get(j);
      if (((ViewGroup)localObject4).getWindowVisibility() != 0)
      {
        n = m;
      }
      else
      {
        localObject3 = B0;
        k = Math.abs(a);
        int i1 = Math.abs(b) + k;
        for (k = 0;; k += 2)
        {
          n = m;
          if (k >= d * 2) {
            break;
          }
          if (m >= A.size())
          {
            localObject1 = new c();
            A.add(localObject1);
          }
          else
          {
            localObject1 = (c)A.get(m);
          }
          n = c[(k + 1)];
          boolean bool;
          if (n <= i1) {
            bool = true;
          } else {
            bool = false;
          }
          a = bool;
          b = i1;
          c = n;
          d = ((RecyclerView)localObject4);
          e = c[k];
          m++;
        }
      }
      j++;
    }
    Collections.sort(A, C);
    for (m = 0; m < A.size(); m++)
    {
      localObject1 = (c)A.get(m);
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
      if ((localObject3 != null) && (b != null) && (((RecyclerView.w)localObject3).k()) && (!((RecyclerView.w)localObject3).l()))
      {
        RecyclerView localRecyclerView = (RecyclerView)b.get();
        if (localRecyclerView != null)
        {
          if ((b0) && (B.b() != 0)) {
            localRecyclerView.o();
          }
          localObject3 = B0;
          d = 0;
          localObject4 = c;
          if (localObject4 != null) {
            Arrays.fill((int[])localObject4, -1);
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
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((N) && (y == 0L))
    {
      y = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = B0;
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
        RecyclerView localRecyclerView = (RecyclerView)x.get(j);
        l2 = l1;
        if (localRecyclerView.getWindowVisibility() == 0) {
          l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
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
  
  public static final class a
    implements Comparator<m.c>
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (m.c)paramObject1;
      paramObject2 = (m.c)paramObject2;
      RecyclerView localRecyclerView = d;
      int i = 1;
      int j = 0;
      if (localRecyclerView == null) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if (d == null) {
        m = 1;
      } else {
        m = 0;
      }
      if (k != m)
      {
        if (d == null)
        {
          k = i;
          break label98;
        }
      }
      else
      {
        boolean bool = a;
        if (bool == a) {
          break label101;
        }
        k = i;
        if (!bool) {
          break label98;
        }
      }
      int k = -1;
      label98:
      break label144;
      label101:
      k = b - b;
      if (k == 0)
      {
        m = c - c;
        k = j;
        if (m != 0) {
          k = m;
        }
      }
      label144:
      return k;
    }
  }
  
  public static class b
  {
    public int a;
    public int b;
    public int[] c;
    public int d;
    
    public boolean a(int paramInt)
    {
      if (c != null)
      {
        int i = d;
        for (int j = 0; j < i * 2; j += 2) {
          if (c[j] == paramInt) {
            return true;
          }
        }
      }
      return false;
    }
  }
  
  public static class c
  {
    public boolean a;
    public int b;
    public int c;
    public RecyclerView d;
    public int e;
  }
}

/* Location:
 * Qualified Name:     d.t.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */