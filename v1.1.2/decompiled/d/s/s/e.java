package d.s.s;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.NavController;
import androidx.navigation.NavController.b;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import d.s.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

public final class e
  implements NavController.b
{
  public e(WeakReference paramWeakReference, NavController paramNavController) {}
  
  public void a(NavController paramNavController, i parami, Bundle paramBundle)
  {
    paramNavController = (BottomNavigationView)a.get();
    if (paramNavController == null)
    {
      b.l.remove(this);
      return;
    }
    Menu localMenu = paramNavController.getMenu();
    int i = localMenu.size();
    for (int j = 0; j < i; j++)
    {
      MenuItem localMenuItem = localMenu.getItem(j);
      int k = localMenuItem.getItemId();
      for (paramNavController = parami; z != k; paramNavController = paramBundle)
      {
        paramBundle = y;
        if (paramBundle == null) {
          break;
        }
      }
      if (z == k) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        localMenuItem.setChecked(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.s.s.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */