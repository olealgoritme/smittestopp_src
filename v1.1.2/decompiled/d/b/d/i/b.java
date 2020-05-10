package d.b.d.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import d.b.e.c;
import d.b.e.c.b;
import java.util.ArrayList;

public abstract class b
  implements o
{
  public LayoutInflater A;
  public o.a B;
  public int C;
  public int D;
  public p E;
  public int F;
  public Context x;
  public Context y;
  public h z;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    x = paramContext;
    A = LayoutInflater.from(paramContext);
    C = paramInt1;
    D = paramInt2;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof p.a)) {
      paramView = (p.a)paramView;
    } else {
      paramView = (p.a)A.inflate(D, paramViewGroup, false);
    }
    paramViewGroup = (c)this;
    paramView.a(paramj, 0);
    ActionMenuView localActionMenuView = (ActionMenuView)E;
    paramj = (ActionMenuItemView)paramView;
    paramj.setItemInvoker(localActionMenuView);
    if (V == null) {
      V = new c.b(paramViewGroup);
    }
    paramj.setPopupCallback(V);
    return (View)paramView;
  }
  
  public void a(o.a parama)
  {
    B = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)E;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = z;
    int k;
    if (localObject != null)
    {
      ((h)localObject).a();
      ArrayList localArrayList = z.d();
      int i = localArrayList.size();
      int j = 0;
      for (k = 0;; k = m)
      {
        m = k;
        if (j >= i) {
          break;
        }
        j localj = (j)localArrayList.get(j);
        m = k;
        if (localj.d())
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof p.a)) {
            localObject = ((p.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(localj, localView1, localViewGroup);
          if (localj != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1)
          {
            localObject = (ViewGroup)localView2.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeView(localView2);
            }
            ((ViewGroup)E).addView(localView2, k);
          }
          m = k + 1;
        }
        j++;
      }
    }
    int m = 0;
    while (m < localViewGroup.getChildCount())
    {
      localObject = (c)this;
      if (localViewGroup.getChildAt(m) == G)
      {
        k = 0;
      }
      else
      {
        localViewGroup.removeViewAt(m);
        k = 1;
      }
      if (k == 0) {
        m++;
      }
    }
  }
  
  public boolean a(h paramh, j paramj)
  {
    return false;
  }
  
  public boolean a(t paramt)
  {
    o.a locala = B;
    if (locala != null) {
      return locala.a(paramt);
    }
    return false;
  }
  
  public boolean b(h paramh, j paramj)
  {
    return false;
  }
  
  public int getId()
  {
    return F;
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */