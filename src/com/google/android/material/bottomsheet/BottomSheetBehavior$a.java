package com.google.android.material.bottomsheet;

import android.view.View;
import d.b.a.r;
import d.i.i.n;
import d.k.b.a;
import d.k.b.a.c;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior$a
  extends a.c
{
  public BottomSheetBehavior$a(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getLeft();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      a.c(1);
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = 3;
    BottomSheetBehavior localBottomSheetBehavior;
    int j;
    int k;
    if (paramFloat2 < 0.0F)
    {
      localBottomSheetBehavior = a;
      if (a)
      {
        j = g;
        break label330;
      }
      k = paramView.getTop();
      j = a.h;
      if (k > j) {
        break label311;
      }
    }
    else
    {
      localBottomSheetBehavior = a;
      if ((j) && (localBottomSheetBehavior.a(paramView, paramFloat2)) && ((paramView.getTop() > a.i) || (Math.abs(paramFloat1) < Math.abs(paramFloat2))))
      {
        j = a.q;
        i = 5;
        break label330;
      }
      if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
        j = a.i;
      }
    }
    for (;;)
    {
      i = 4;
      break;
      k = paramView.getTop();
      localBottomSheetBehavior = a;
      if (a)
      {
        if (Math.abs(k - g) < Math.abs(k - a.i))
        {
          j = a.g;
          break;
        }
        j = a.i;
      }
      else
      {
        j = h;
        if (k < j)
        {
          if (k < Math.abs(k - i))
          {
            j = 0;
            break;
          }
          j = a.h;
        }
        else
        {
          if (Math.abs(k - j) >= Math.abs(k - a.i)) {
            break label318;
          }
          j = a.h;
        }
        label311:
        i = 6;
        break;
        label318:
        j = a.i;
      }
    }
    label330:
    if (a.m.b(paramView.getLeft(), j))
    {
      a.c(2);
      n.a(paramView, new BottomSheetBehavior.d(a, paramView, i));
    }
    else
    {
      a.c(i);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramInt2);
  }
  
  public int b(View paramView)
  {
    paramView = a;
    if (j) {
      return q;
    }
    return i;
  }
  
  public int b(View paramView, int paramInt1, int paramInt2)
  {
    int i = a.b();
    paramView = a;
    if (j) {
      paramInt2 = q;
    } else {
      paramInt2 = i;
    }
    return r.a(paramInt1, i, paramInt2);
  }
  
  public boolean b(View paramView, int paramInt)
  {
    Object localObject = a;
    int i = l;
    boolean bool = true;
    if (i == 1) {
      return false;
    }
    if (x) {
      return false;
    }
    if ((i == 3) && (v == paramInt))
    {
      localObject = (View)s.get();
      if ((localObject != null) && (((View)localObject).canScrollVertically(-1))) {
        return false;
      }
    }
    localObject = a.r;
    if ((localObject == null) || (((WeakReference)localObject).get() != paramView)) {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.bottomsheet.BottomSheetBehavior.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */