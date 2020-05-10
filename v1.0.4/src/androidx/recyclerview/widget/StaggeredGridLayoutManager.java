package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import d.i.i.x.d;
import d.i.i.x.d.b;
import d.t.a.n;
import d.t.a.s;
import d.t.a.s.k;
import d.t.a.s.k.c;
import d.t.a.s.l;
import d.t.a.s.q;
import d.t.a.s.u;
import java.util.ArrayList;
import java.util.BitSet;

public class StaggeredGridLayoutManager
  extends s.k
{
  public int A;
  public StaggeredGridLayoutManager.d B;
  public int C;
  public boolean D;
  public boolean E;
  public StaggeredGridLayoutManager.e F;
  public final Rect G;
  public final StaggeredGridLayoutManager.b H;
  public boolean I;
  public boolean J;
  public final Runnable K;
  public int q = -1;
  public StaggeredGridLayoutManager.f[] r;
  public d.t.a.r s;
  public d.t.a.r t;
  public int u;
  public final n v;
  public boolean w;
  public boolean x;
  public BitSet y;
  public int z;
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    int i = 0;
    w = false;
    x = false;
    z = -1;
    A = Integer.MIN_VALUE;
    B = new StaggeredGridLayoutManager.d();
    C = 2;
    G = new Rect();
    H = new StaggeredGridLayoutManager.b(this);
    I = false;
    J = true;
    K = new StaggeredGridLayoutManager.a(this);
    paramContext = s.k.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = a;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    a(null);
    if (paramInt1 != u)
    {
      u = paramInt1;
      paramAttributeSet = s;
      s = t;
      t = paramAttributeSet;
      l();
    }
    paramInt1 = b;
    a(null);
    if (paramInt1 != q)
    {
      B.a();
      l();
      q = paramInt1;
      y = new BitSet(q);
      r = new StaggeredGridLayoutManager.f[q];
      for (paramInt1 = i; paramInt1 < q; paramInt1++) {
        r[paramInt1] = new StaggeredGridLayoutManager.f(this, paramInt1);
      }
      l();
    }
    boolean bool = c;
    a(null);
    paramContext = F;
    if ((paramContext != null) && (E != bool)) {
      E = bool;
    }
    w = bool;
    l();
    v = new n();
    s = d.t.a.r.a(this, u);
    t = d.t.a.r.a(this, 1 - u);
  }
  
  public int a(s.q paramq, s.u paramu)
  {
    if (u == 1) {
      return q;
    }
    return 1;
  }
  
  public int a(s.u paramu)
  {
    return g(paramu);
  }
  
  public View a(boolean paramBoolean)
  {
    int i = s.b();
    int j = s.a();
    int k = d() - 1;
    Object localObject2;
    for (Object localObject1 = null; k >= 0; localObject1 = localObject2)
    {
      View localView = a(k);
      int m = s.b(localView);
      int n = s.a(localView);
      localObject2 = localObject1;
      if (n > i) {
        if (m >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n > j) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      k--;
    }
    return (View)localObject1;
  }
  
  public s.l a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new StaggeredGridLayoutManager.c(paramContext, paramAttributeSet);
  }
  
  public s.l a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new StaggeredGridLayoutManager.c((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new StaggeredGridLayoutManager.c(paramLayoutParams);
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.e))
    {
      F = ((StaggeredGridLayoutManager.e)paramParcelable);
      l();
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (d() > 0)
    {
      View localView1 = b(false);
      View localView2 = a(false);
      if ((localView1 != null) && (localView2 != null))
      {
        int i = a(localView1);
        int j = a(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
        }
        else
        {
          paramAccessibilityEvent.setFromIndex(j);
          paramAccessibilityEvent.setToIndex(i);
        }
      }
    }
  }
  
  public void a(s.q paramq, s.u paramu, View paramView, d paramd)
  {
    paramq = paramView.getLayoutParams();
    if (!(paramq instanceof StaggeredGridLayoutManager.c))
    {
      super.a(paramView, paramd);
      return;
    }
    paramq = (StaggeredGridLayoutManager.c)paramq;
    int i;
    int j;
    if (u == 0)
    {
      paramu = e;
      if (paramu == null) {
        i = -1;
      } else {
        i = e;
      }
      if (f) {
        j = q;
      } else {
        j = 1;
      }
      paramd.a(d.b.a(i, j, -1, -1, f, false));
    }
    else
    {
      paramu = e;
      if (paramu == null) {
        i = -1;
      } else {
        i = e;
      }
      if (f) {
        j = q;
      } else {
        j = 1;
      }
      paramd.a(d.b.a(-1, -1, i, j, f, false));
    }
  }
  
  public void a(s params)
  {
    B.a();
    l();
  }
  
  public void a(s params, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 1);
  }
  
  public void a(s params, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, 8);
  }
  
  public void a(s params, int paramInt1, int paramInt2, Object paramObject)
  {
    b(paramInt1, paramInt2, 4);
  }
  
  public void a(s params, s.q paramq)
  {
    Runnable localRunnable = K;
    paramq = b;
    if (paramq != null) {
      paramq.removeCallbacks(localRunnable);
    }
    for (int i = 0; i < q; i++) {
      r[i].c();
    }
    params.requestLayout();
  }
  
  public void a(String paramString)
  {
    if (F == null)
    {
      s locals = b;
      if (locals != null) {
        locals.a(paramString);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (u == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(s.l paraml)
  {
    return paraml instanceof StaggeredGridLayoutManager.c;
  }
  
  public int b(s.q paramq, s.u paramu)
  {
    if (u == 0) {
      return q;
    }
    return 1;
  }
  
  public int b(s.u paramu)
  {
    return h(paramu);
  }
  
  public View b(boolean paramBoolean)
  {
    int i = s.b();
    int j = s.a();
    int k = d();
    Object localObject1 = null;
    int m = 0;
    while (m < k)
    {
      View localView = a(m);
      int n = s.b(localView);
      Object localObject2 = localObject1;
      if (s.a(localView) > i) {
        if (n >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n < i) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      m++;
      localObject1 = localObject2;
    }
    return (View)localObject1;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      n();
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (x) {
      i = p();
    } else {
      i = o();
    }
    int j;
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        j = paramInt2 + 1;
      }
      else
      {
        j = paramInt1 + 1;
        k = paramInt2;
        break label60;
      }
    }
    else {
      j = paramInt1 + paramInt2;
    }
    int k = paramInt1;
    label60:
    B.d(k);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          B.b(paramInt1, 1);
          B.a(paramInt2, 1);
        }
      }
      else {
        B.b(paramInt1, paramInt2);
      }
    }
    else {
      B.a(paramInt1, paramInt2);
    }
    if (j <= i) {
      return;
    }
    if (x) {
      paramInt1 = o();
    } else {
      paramInt1 = p();
    }
    if (k <= paramInt1) {
      l();
    }
  }
  
  public void b(s params, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 2);
  }
  
  public boolean b()
  {
    int i = u;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public int c(s.u paramu)
  {
    return i(paramu);
  }
  
  public s.l c()
  {
    if (u == 0) {
      return new StaggeredGridLayoutManager.c(-2, -1);
    }
    return new StaggeredGridLayoutManager.c(-1, -2);
  }
  
  public int d(s.u paramu)
  {
    return g(paramu);
  }
  
  public int e(s.u paramu)
  {
    return h(paramu);
  }
  
  public int f(s.u paramu)
  {
    return i(paramu);
  }
  
  public final int g(s.u paramu)
  {
    if (d() == 0) {
      return 0;
    }
    return d.b.a.r.a(paramu, s, b(J ^ true), a(J ^ true), this, J);
  }
  
  public final int h(s.u paramu)
  {
    if (d() == 0) {
      return 0;
    }
    return d.b.a.r.a(paramu, s, b(J ^ true), a(J ^ true), this, J, x);
  }
  
  public final int i(s.u paramu)
  {
    if (d() == 0) {
      return 0;
    }
    return d.b.a.r.b(paramu, s, b(J ^ true), a(J ^ true), this, J);
  }
  
  public boolean j()
  {
    boolean bool;
    if (C != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Parcelable k()
  {
    if (F != null) {
      return new StaggeredGridLayoutManager.e(F);
    }
    StaggeredGridLayoutManager.e locale = new StaggeredGridLayoutManager.e();
    E = w;
    F = D;
    G = E;
    StaggeredGridLayoutManager.d locald = B;
    int i = 0;
    Object localObject;
    if (locald != null)
    {
      localObject = a;
      if (localObject != null)
      {
        C = ((int[])localObject);
        B = localObject.length;
        D = b;
        break label102;
      }
    }
    B = 0;
    label102:
    int j = d();
    int k = -1;
    if (j > 0)
    {
      if (D) {
        j = p();
      } else {
        j = o();
      }
      x = j;
      if (x) {
        localObject = a(true);
      } else {
        localObject = b(true);
      }
      if (localObject == null) {
        j = k;
      } else {
        j = a((View)localObject);
      }
      y = j;
      j = q;
      z = j;
      A = new int[j];
      while (i < q)
      {
        if (D)
        {
          k = r[i].a(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label305;
          }
          j = s.a();
        }
        else
        {
          k = r[i].b(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label305;
          }
          j = s.b();
        }
        j = k - j;
        label305:
        A[i] = j;
        i++;
      }
    }
    x = -1;
    y = -1;
    z = 0;
    return locale;
  }
  
  public boolean m()
  {
    boolean bool;
    if (F == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean n()
  {
    if ((d() != 0) && (C != 0) && (h))
    {
      int i;
      int j;
      if (x)
      {
        i = p();
        j = o();
      }
      else
      {
        i = o();
        j = p();
      }
      if ((i == 0) && (q() != null))
      {
        B.a();
        g = true;
        l();
        return true;
      }
      if (!I) {
        return false;
      }
      int k;
      if (x) {
        k = -1;
      } else {
        k = 1;
      }
      Object localObject = B;
      j++;
      localObject = ((StaggeredGridLayoutManager.d)localObject).a(i, j, k, true);
      if (localObject == null)
      {
        I = false;
        B.b(j);
        return false;
      }
      StaggeredGridLayoutManager.d.a locala = B.a(i, x, k * -1, true);
      if (locala == null) {
        B.b(x);
      } else {
        B.b(x + 1);
      }
      g = true;
      l();
      return true;
    }
    return false;
  }
  
  public int o()
  {
    int i = d();
    int j = 0;
    if (i != 0) {
      j = a(a(0));
    }
    return j;
  }
  
  public int p()
  {
    int i = d();
    if (i == 0) {
      i = 0;
    } else {
      i = a(a(i - 1));
    }
    return i;
  }
  
  public View q()
  {
    int i = d() - 1;
    BitSet localBitSet = new BitSet(q);
    localBitSet.set(0, q, true);
    int j;
    if ((u == 1) && (r())) {
      j = 1;
    } else {
      j = -1;
    }
    int k;
    if (x)
    {
      k = -1;
    }
    else
    {
      k = i + 1;
      i = 0;
    }
    int m;
    if (i < k) {
      m = 1;
    } else {
      m = -1;
    }
    while (i != k)
    {
      View localView = a(i);
      StaggeredGridLayoutManager.c localc = (StaggeredGridLayoutManager.c)localView.getLayoutParams();
      int n;
      Object localObject;
      if (localBitSet.get(e.e))
      {
        StaggeredGridLayoutManager.f localf = e;
        boolean bool;
        if (x)
        {
          n = c;
          if (n == Integer.MIN_VALUE)
          {
            localf.a();
            n = c;
          }
          if (n >= s.a()) {
            break label286;
          }
          localObject = a;
          bool = agetsize1f;
        }
        else
        {
          n = b;
          if (n == Integer.MIN_VALUE)
          {
            localf.b();
            n = b;
          }
          if (n <= s.b()) {
            break label286;
          }
          bool = aa.get(0)).f;
        }
        n = bool ^ true;
        break label289;
        label286:
        n = 0;
        label289:
        if (n != 0) {
          return localView;
        }
        localBitSet.clear(e.e);
      }
      if (!f)
      {
        n = i + m;
        if (n != k)
        {
          localObject = a(n);
          int i1;
          if (x)
          {
            i1 = s.a(localView);
            n = s.a((View)localObject);
            if (i1 < n) {
              return localView;
            }
            if (i1 != n) {
              break label435;
            }
          }
          else
          {
            i1 = s.b(localView);
            n = s.b((View)localObject);
            if (i1 > n) {
              return localView;
            }
            if (i1 != n) {
              break label435;
            }
          }
          n = 1;
          break label438;
          label435:
          n = 0;
          label438:
          if (n != 0)
          {
            localObject = (StaggeredGridLayoutManager.c)((View)localObject).getLayoutParams();
            if (e.e - e.e < 0) {
              n = 1;
            } else {
              n = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (n != i1) {
              return localView;
            }
          }
        }
      }
      i += m;
    }
    return null;
  }
  
  public boolean r()
  {
    int i = e();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.StaggeredGridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */