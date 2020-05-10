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
import e.a.a.a.a;

public class GridLayoutManager
  extends LinearLayoutManager
{
  public boolean E = false;
  public int F = -1;
  public final SparseIntArray G = new SparseIntArray();
  public final SparseIntArray H = new SparseIntArray();
  public c I = new a();
  public final Rect J = new Rect();
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = aspanCount;
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
  
  public int a(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    if (q == 1) {
      return F;
    }
    if (paramt.a() < 1) {
      return 0;
    }
    return a(paramp, paramt, paramt.a() - 1) + 1;
  }
  
  public final int a(RecyclerView.p paramp, RecyclerView.t paramt, int paramInt)
  {
    if (!g) {
      return I.a(paramInt, F);
    }
    int i = paramp.a(paramInt);
    if (i == -1)
    {
      paramp = new StringBuilder();
      paramp.append("Cannot find span size for pre layout position. ");
      paramp.append(paramInt);
      Log.w("GridLayoutManager", paramp.toString());
      return 0;
    }
    return I.a(i, F);
  }
  
  public RecyclerView.k a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new b(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.k a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new b((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new b(paramLayoutParams);
  }
  
  public void a(RecyclerView.p paramp, RecyclerView.t paramt, View paramView, d paramd)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof b))
    {
      super.a(paramView, paramd);
      return;
    }
    paramView = (b)localLayoutParams;
    int i = a(paramp, paramt, paramView.a());
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
      j = e;
      k = f;
      m = F;
      if ((m > 1) && (k == m)) {
        bool = true;
      } else {
        bool = false;
      }
      paramd.a(d.b.a(i, 1, j, k, bool, false));
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    I.a.clear();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    I.a.clear();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    I.a.clear();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
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
  
  public boolean a(RecyclerView.k paramk)
  {
    return paramk instanceof b;
  }
  
  public int b(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    if (q == 0) {
      return F;
    }
    if (paramt.a() < 1) {
      return 0;
    }
    return a(paramp, paramt, paramt.a() - 1) + 1;
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    I.a.clear();
  }
  
  public RecyclerView.k c()
  {
    if (q == 0) {
      return new b(-2, -1);
    }
    return new b(-1, -2);
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
  
  public static final class a
    extends GridLayoutManager.c
  {}
  
  public static class b
    extends RecyclerView.k
  {
    public int e = -1;
    public int f = 0;
    
    public b(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public b(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public b(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract class c
  {
    public final SparseIntArray a = new SparseIntArray();
    public boolean b = false;
    
    public int a(int paramInt1, int paramInt2)
    {
      int i = 0;
      int j = 0;
      int n;
      for (int k = 0; i < paramInt1; k = n)
      {
        int m = j + 1;
        if (m == paramInt2)
        {
          n = k + 1;
          j = 0;
        }
        else
        {
          j = m;
          n = k;
          if (m > paramInt2)
          {
            n = k + 1;
            j = 1;
          }
        }
        i++;
      }
      paramInt1 = k;
      if (j + 1 > paramInt2) {
        paramInt1 = k + 1;
      }
      return paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */