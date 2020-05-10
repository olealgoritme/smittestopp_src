package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import d.b.d.b;
import d.b.d.i.g;
import d.b.d.i.i;
import d.b.d.i.m;
import d.b.d.i.m.a;
import d.b.d.i.r;
import java.util.ArrayList;

public class Toolbar$d
  implements m
{
  public g x;
  public i y;
  
  public Toolbar$d(Toolbar paramToolbar) {}
  
  public void a(Context paramContext, g paramg)
  {
    paramContext = x;
    if (paramContext != null)
    {
      i locali = y;
      if (locali != null) {
        paramContext.a(locali);
      }
    }
    x = paramg;
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(g paramg, boolean paramBoolean) {}
  
  public void a(m.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (y != null)
    {
      g localg = x;
      int i = 0;
      int j = i;
      if (localg != null)
      {
        int k = localg.size();
        for (int m = 0;; m++)
        {
          j = i;
          if (m >= k) {
            break;
          }
          if (x.getItem(m) == y)
          {
            j = 1;
            break;
          }
        }
      }
      if (j == 0) {
        a(x, y);
      }
    }
  }
  
  public boolean a(g paramg, i parami)
  {
    paramg = z.F;
    if ((paramg instanceof b)) {
      ((b)paramg).b();
    }
    paramg = z;
    paramg.removeView(F);
    paramg = z;
    paramg.removeView(E);
    paramg = z;
    F = null;
    int i = e0.size();
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      paramg.addView((View)e0.get(i));
    }
    e0.clear();
    y = null;
    z.requestLayout();
    C = false;
    n.b(false);
    return true;
  }
  
  public boolean a(r paramr)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(g paramg, i parami)
  {
    z.a();
    paramg = z.E.getParent();
    Object localObject = z;
    if (paramg != localObject)
    {
      if ((paramg instanceof ViewGroup)) {
        ((ViewGroup)paramg).removeView(E);
      }
      paramg = z;
      paramg.addView(E);
    }
    z.F = parami.getActionView();
    y = parami;
    localObject = z.F.getParent();
    paramg = z;
    if (localObject != paramg)
    {
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(F);
      }
      paramg = z.generateDefaultLayoutParams();
      localObject = z;
      a = (0x800003 | K & 0x70);
      b = 2;
      F.setLayoutParams(paramg);
      paramg = z;
      paramg.addView(F);
    }
    localObject = z;
    int i = ((ViewGroup)localObject).getChildCount();
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      paramg = ((ViewGroup)localObject).getChildAt(j);
      i = j;
      if (getLayoutParamsb != 2)
      {
        i = j;
        if (paramg != x)
        {
          ((ViewGroup)localObject).removeViewAt(j);
          e0.add(paramg);
          i = j;
        }
      }
    }
    z.requestLayout();
    C = true;
    n.b(false);
    paramg = z.F;
    if ((paramg instanceof b)) {
      ((b)paramg).a();
    }
    return true;
  }
  
  public Parcelable d()
  {
    return null;
  }
  
  public int getId()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.Toolbar.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */