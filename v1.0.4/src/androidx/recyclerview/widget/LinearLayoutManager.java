package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import d.t.a.s;
import d.t.a.s.k;
import d.t.a.s.k.c;
import d.t.a.s.l;
import d.t.a.s.q;
import d.t.a.s.u;
import d.t.a.x;
import e.a.a.a.a;

public class LinearLayoutManager
  extends s.k
{
  public LinearLayoutManager.d A = null;
  public final LinearLayoutManager.a B = new LinearLayoutManager.a();
  public final LinearLayoutManager.b C = new LinearLayoutManager.b();
  public int D = 2;
  public int q = 1;
  public LinearLayoutManager.c r;
  public d.t.a.r s;
  public boolean t;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = true;
  public int y = -1;
  public int z = Integer.MIN_VALUE;
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    d(paramInt);
    a(null);
    if (paramBoolean != u)
    {
      u = paramBoolean;
      l();
    }
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = s.k.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d(a);
    boolean bool = c;
    a(null);
    if (bool != u)
    {
      u = bool;
      l();
    }
    a(d);
  }
  
  public int a(s.u paramu)
  {
    return g(paramu);
  }
  
  public View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    n();
    int i = 320;
    int j;
    if (paramBoolean1) {
      j = 24579;
    } else {
      j = 320;
    }
    if (!paramBoolean2) {
      i = 0;
    }
    View localView;
    if (q == 0) {
      localView = e.a(paramInt1, paramInt2, j, i);
    } else {
      localView = f.a(paramInt1, paramInt2, j, i);
    }
    return localView;
  }
  
  public final View a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (v) {
      return a(0, d(), paramBoolean1, paramBoolean2);
    }
    return a(d() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.d))
    {
      A = ((LinearLayoutManager.d)paramParcelable);
      l();
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (d() > 0)
    {
      View localView = a(0, d(), false, true);
      int i = -1;
      int j;
      if (localView == null) {
        j = -1;
      } else {
        j = a(localView);
      }
      paramAccessibilityEvent.setFromIndex(j);
      localView = a(d() - 1, -1, false, true);
      if (localView == null) {
        j = i;
      } else {
        j = a(localView);
      }
      paramAccessibilityEvent.setToIndex(j);
    }
  }
  
  public void a(s params, s.q paramq) {}
  
  public void a(String paramString)
  {
    if (A == null)
    {
      s locals = b;
      if (locals != null) {
        locals.a(paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(null);
    if (w == paramBoolean) {
      return;
    }
    w = paramBoolean;
    l();
  }
  
  public boolean a()
  {
    boolean bool;
    if (q == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int b(s.u paramu)
  {
    return h(paramu);
  }
  
  public final View b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (v) {
      return a(d() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return a(0, d(), paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    int i = q;
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
    return new s.l(-2, -2);
  }
  
  public int d(s.u paramu)
  {
    return g(paramu);
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException(a.a("invalid orientation:", paramInt));
    }
    a(null);
    if ((paramInt != q) || (s == null))
    {
      d.t.a.r localr = d.t.a.r.a(this, paramInt);
      s = localr;
      B.a = localr;
      q = paramInt;
      l();
    }
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
    n();
    return d.b.a.r.a(paramu, s, b(x ^ true, true), a(x ^ true, true), this, x);
  }
  
  public final int h(s.u paramu)
  {
    if (d() == 0) {
      return 0;
    }
    n();
    return d.b.a.r.a(paramu, s, b(x ^ true, true), a(x ^ true, true), this, x, v);
  }
  
  public final int i(s.u paramu)
  {
    if (d() == 0) {
      return 0;
    }
    n();
    return d.b.a.r.b(paramu, s, b(x ^ true, true), a(x ^ true, true), this, x);
  }
  
  public boolean j()
  {
    return true;
  }
  
  public Parcelable k()
  {
    if (A != null) {
      return new LinearLayoutManager.d(A);
    }
    LinearLayoutManager.d locald = new LinearLayoutManager.d();
    if (d() > 0)
    {
      n();
      boolean bool = t ^ v;
      z = bool;
      View localView;
      if (bool)
      {
        localView = o();
        y = (s.a() - s.a(localView));
        x = a(localView);
      }
      else
      {
        localView = p();
        x = a(localView);
        y = (s.b(localView) - s.b());
      }
    }
    else
    {
      x = -1;
    }
    return locald;
  }
  
  public boolean m()
  {
    boolean bool;
    if ((A == null) && (t == w)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void n()
  {
    if (r == null) {
      r = new LinearLayoutManager.c();
    }
  }
  
  public final View o()
  {
    int i;
    if (v) {
      i = 0;
    } else {
      i = d() - 1;
    }
    return a(i);
  }
  
  public final View p()
  {
    int i;
    if (v) {
      i = d() - 1;
    } else {
      i = 0;
    }
    return a(i);
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.LinearLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */