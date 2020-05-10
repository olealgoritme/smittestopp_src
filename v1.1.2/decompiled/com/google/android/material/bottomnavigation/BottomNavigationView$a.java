package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.R.anim;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.s.i;
import d.s.j;
import d.s.n;
import d.s.s.d;

public class BottomNavigationView$a
  implements h.a
{
  public BottomNavigationView$a(BottomNavigationView paramBottomNavigationView) {}
  
  public void a(h paramh) {}
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    paramh = x.C;
    boolean bool = true;
    if ((paramh != null) && (paramMenuItem.getItemId() == x.getSelectedItemId()))
    {
      x.C.a(paramMenuItem);
      return true;
    }
    paramh = x.B;
    if (paramh != null)
    {
      NavController localNavController = a;
      int i = R.anim.nav_default_enter_anim;
      int j = R.anim.nav_default_exit_anim;
      int k = R.anim.nav_default_pop_enter_anim;
      int m = R.anim.nav_default_pop_exit_anim;
      int n;
      if ((paramMenuItem.getOrder() & 0x30000) == 0)
      {
        paramh = d;
        if (paramh != null)
        {
          while ((paramh instanceof j))
          {
            paramh = (j)paramh;
            paramh = paramh.b(G);
          }
          n = z;
        }
        else
        {
          throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
      }
      else
      {
        n = -1;
      }
      int i1 = 0;
      paramh = new n(true, n, false, i, j, k, m);
      try
      {
        localNavController.a(paramMenuItem.getItemId(), null, paramh);
        n = 1;
      }
      catch (IllegalArgumentException paramh)
      {
        n = i1;
      }
      if (n == 0) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */