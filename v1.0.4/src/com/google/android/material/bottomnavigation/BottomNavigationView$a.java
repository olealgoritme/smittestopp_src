package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.ui.R.anim;
import d.b.d.i.g;
import d.b.d.i.g.a;
import d.s.i;
import d.s.j;
import d.s.n;
import d.s.s.d;

public class BottomNavigationView$a
  implements g.a
{
  public BottomNavigationView$a(BottomNavigationView paramBottomNavigationView) {}
  
  public void a(g paramg) {}
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    paramg = x.C;
    boolean bool = true;
    if ((paramg != null) && (paramMenuItem.getItemId() == x.getSelectedItemId()))
    {
      x.C.a(paramMenuItem);
      return true;
    }
    paramg = x.B;
    if (paramg != null)
    {
      NavController localNavController = a;
      int i = R.anim.nav_default_enter_anim;
      int j = R.anim.nav_default_exit_anim;
      int k = R.anim.nav_default_pop_enter_anim;
      int m = R.anim.nav_default_pop_exit_anim;
      int n;
      if ((paramMenuItem.getOrder() & 0x30000) == 0)
      {
        paramg = d;
        if (paramg != null)
        {
          while ((paramg instanceof j))
          {
            paramg = (j)paramg;
            paramg = paramg.b(G);
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
      paramg = new n(true, n, false, i, j, k, m);
      try
      {
        localNavController.a(paramMenuItem.getItemId(), null, paramg);
        n = 1;
      }
      catch (IllegalArgumentException paramg)
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
 * Qualified Name:     base.com.google.android.material.bottomnavigation.BottomNavigationView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */