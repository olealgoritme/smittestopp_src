package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.i.i.x.d;
import d.i.i.x.d.b;
import d.t.a.s;
import d.t.a.s.k;
import d.t.a.s.k.c;
import d.t.a.s.l;
import d.t.a.s.q;
import d.t.a.s.u;
import e.a.a.a.a;

public class GridLayoutManager
  extends LinearLayoutManager
{
  public boolean E = false;
  public int F = -1;
  public final SparseIntArray G = new SparseIntArray();
  public final SparseIntArray H = new SparseIntArray();
  public GridLayoutManager.c I = new GridLayoutManager.a();
  public final Rect J = new Rect();
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = ab;
    if (paramInt1 != F)
    {
      E = true;
      if (paramInt1 >= 1)
      {
        F = paramInt1;
        I.a.clear();
        l();
      }
    }
    else
    {
      return;
    }
    throw new IllegalArgumentException(a.a("Span count should be at least 1. Provided ", paramInt1));
  }
  
  public int a(s.q paramq, s.u paramu)
  {
    if (q == 1) {
      return F;
    }
    if (paramu.a() < 1) {
      return 0;
    }
    return a(paramq, paramu, paramu.a() - 1) + 1;
  }
  
  public final int a(s.q paramq, s.u paramu, int paramInt)
  {
    if (!g) {
      return I.a(paramInt, F);
    }
    int i = paramq.a(paramInt);
    if (i == -1)
    {
      paramq = new StringBuilder();
      paramq.append("Cannot find span size for pre layout position. ");
      paramq.append(paramInt);
      Log.w("GridLayoutManager", paramq.toString());
      return 0;
    }
    return I.a(i, F);
  }
  
  public s.l a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GridLayoutManager.b(paramContext, paramAttributeSet);
  }
  
  public s.l a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GridLayoutManager.b((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GridLayoutManager.b(paramLayoutParams);
  }
  
  public void a(s.q paramq, s.u paramu, View paramView, d paramd)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.b))
    {
      super.a(paramView, paramd);
      return;
    }
    paramView = (GridLayoutManager.b)localLayoutParams;
    int i = a(paramq, paramu, paramView.a());
    int j;
    int k;
    int m;
    boolean bool;
    if (q == 0)
    {
      j = e;
      k = f;
      m = F;
      if ((m > 1) && (k == m)) {
        bool = true;
      } else {
        bool = false;
      }
      paramd.a(d.b.a(j, k, i, 1, bool, false));
    }
    else
    {
      k = e;
      j = f;
      m = F;
      if ((m > 1) && (j == m)) {
        bool = true;
      } else {
        bool = false;
      }
      paramd.a(d.b.a(i, 1, k, j, bool, false));
    }
  }
  
  public void a(s params)
  {
    I.a.clear();
  }
  
  public void a(s params, int paramInt1, int paramInt2)
  {
    I.a.clear();
  }
  
  public void a(s params, int paramInt1, int paramInt2, int paramInt3)
  {
    I.a.clear();
  }
  
  public void a(s params, int paramInt1, int paramInt2, Object paramObject)
  {
    I.a.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(null);
      if (w)
      {
        w = false;
        l();
      }
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean a(s.l paraml)
  {
    return paraml instanceof GridLayoutManager.b;
  }
  
  public int b(s.q paramq, s.u paramu)
  {
    if (q == 0) {
      return F;
    }
    if (paramu.a() < 1) {
      return 0;
    }
    return a(paramq, paramu, paramu.a() - 1) + 1;
  }
  
  public void b(s params, int paramInt1, int paramInt2)
  {
    I.a.clear();
  }
  
  public s.l c()
  {
    if (q == 0) {
      return new GridLayoutManager.b(-2, -1);
    }
    return new GridLayoutManager.b(-1, -2);
  }
  
  public boolean m()
  {
    boolean bool;
    if ((A == null) && (!E)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.androidx.recyclerview.widget.GridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */