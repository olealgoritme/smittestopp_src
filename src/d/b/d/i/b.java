package d.b.d.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;

import java.util.ArrayList;

import d.b.e.c;
import d.b.e.c.b;

public abstract class b
  implements m
{
  public LayoutInflater A;
  public m.a B;
  public int C;
  public int D;
  public n E;
  public int F;
  public Context x;
  public Context y;
  public g z;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    x = paramContext;
    A = LayoutInflater.from(paramContext);
    C = paramInt1;
    D = paramInt2;
  }
  
  public View a(i parami, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof n.a)) {
      paramView = (n.a)paramView;
    } else {
      paramView = (n.a)A.inflate(D, paramViewGroup, false);
    }
    paramViewGroup = (c)this;
    paramView.a(parami, 0);
    parami = (ActionMenuView)E;
    ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)paramView;
    localActionMenuItemView.setItemInvoker(parami);
    if (U == null) {
      U = new c.b(paramViewGroup);
    }
    localActionMenuItemView.setPopupCallback(U);
    return (View)paramView;
  }
  
  public void a(m.a parama)
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
      ((g)localObject).a();
      ArrayList localArrayList = z.d();
      int i = localArrayList.size();
      int j = 0;
      for (k = 0;; k = m)
      {
        m = k;
        if (j >= i) {
          break;
        }
        i locali = (i)localArrayList.get(j);
        m = k;
        if (locali.d())
        {
          View localView1 = localViewGroup.getChildAt(k);
          if ((localView1 instanceof n.a)) {
            localObject = ((n.a)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = a(locali, localView1, localViewGroup);
          if (locali != localObject)
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
  
  public boolean a(g paramg, i parami)
  {
    return false;
  }
  
  public boolean a(r paramr)
  {
    m.a locala = B;
    if (locala != null) {
      return locala.a(paramr);
    }
    return false;
  }
  
  public boolean b(g paramg, i parami)
  {
    return false;
  }
  
  public int getId()
  {
    return F;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */