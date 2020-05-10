package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import androidx.appcompat.R.attr;
import d.b.a.a.a;
import d.b.d.b;
import d.b.d.i.h;
import d.b.d.i.j;
import d.b.d.i.o;
import d.b.d.i.o.a;
import d.b.d.i.t;
import d.b.e.l;
import d.b.e.v0;
import java.util.ArrayList;

public class Toolbar$c
  implements o
{
  public h x;
  public j y;
  
  public Toolbar$c(Toolbar paramToolbar) {}
  
  public void a(Context paramContext, h paramh)
  {
    h localh = x;
    if (localh != null)
    {
      paramContext = y;
      if (paramContext != null) {
        localh.a(paramContext);
      }
    }
    x = paramh;
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(h paramh, boolean paramBoolean) {}
  
  public void a(o.a parama) {}
  
  public void a(boolean paramBoolean)
  {
    if (y != null)
    {
      h localh = x;
      int i = 0;
      int j = i;
      if (localh != null)
      {
        int k = localh.size();
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
  
  public boolean a(h paramh, j paramj)
  {
    paramh = z.F;
    if ((paramh instanceof b)) {
      ((b)paramh).c();
    }
    paramh = z;
    paramh.removeView(F);
    paramh = z;
    paramh.removeView(E);
    paramh = z;
    F = null;
    int i = e0.size();
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      paramh.addView((View)e0.get(i));
    }
    e0.clear();
    y = null;
    z.requestLayout();
    C = false;
    n.b(false);
    return true;
  }
  
  public boolean a(t paramt)
  {
    return false;
  }
  
  public boolean b(h paramh, j paramj)
  {
    paramh = z;
    if (E == null)
    {
      localObject = new l(paramh.getContext(), null, R.attr.toolbarNavigationButtonStyle);
      E = ((ImageButton)localObject);
      ((ImageButton)localObject).setImageDrawable(C);
      E.setContentDescription(D);
      localObject = paramh.generateDefaultLayoutParams();
      a = (K & 0x70 | 0x800003);
      b = 2;
      E.setLayoutParams((ViewGroup.LayoutParams)localObject);
      E.setOnClickListener(new v0(paramh));
    }
    paramh = z.E.getParent();
    Object localObject = z;
    if (paramh != localObject)
    {
      if ((paramh instanceof ViewGroup)) {
        ((ViewGroup)paramh).removeView(E);
      }
      paramh = z;
      paramh.addView(E);
    }
    z.F = paramj.getActionView();
    y = paramj;
    paramh = z.F.getParent();
    localObject = z;
    if (paramh != localObject)
    {
      if ((paramh instanceof ViewGroup)) {
        ((ViewGroup)paramh).removeView(F);
      }
      localObject = z.generateDefaultLayoutParams();
      paramh = z;
      a = (0x800003 | K & 0x70);
      b = 2;
      F.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramh = z;
      paramh.addView(F);
    }
    paramh = z;
    int i = paramh.getChildCount();
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      localObject = paramh.getChildAt(j);
      i = j;
      if (getLayoutParamsb != 2)
      {
        i = j;
        if (localObject != x)
        {
          paramh.removeViewAt(j);
          e0.add(localObject);
          i = j;
        }
      }
    }
    z.requestLayout();
    C = true;
    n.b(false);
    paramh = z.F;
    if ((paramh instanceof b)) {
      ((b)paramh).a();
    }
    return true;
  }
  
  public boolean c()
  {
    return false;
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
 * Qualified Name:     androidx.appcompat.widget.Toolbar.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */