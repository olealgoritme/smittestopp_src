package d.b.d;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import d.b.d.i.j;
import d.b.d.i.o;
import d.f.h;
import d.i.d.a.b;

public class e$a
  implements a.a
{
  public final ActionMode.Callback a;
  public final Context b;
  public final ArrayList<e> c;
  public final h<Menu, Menu> d;
  
  public e$a(Context paramContext, ActionMode.Callback paramCallback)
  {
    b = paramContext;
    a = paramCallback;
    c = new ArrayList();
    d = new h();
  }
  
  public final Menu a(Menu paramMenu)
  {
    Menu localMenu = (Menu)d.getOrDefault(paramMenu, null);
    Object localObject = localMenu;
    if (localMenu == null)
    {
      localObject = new o(b, (d.i.d.a.a)paramMenu);
      d.put(paramMenu, localObject);
    }
    return (Menu)localObject;
  }
  
  public void a(a parama)
  {
    a.onDestroyActionMode(b(parama));
  }
  
  public boolean a(a parama, Menu paramMenu)
  {
    return a.onPrepareActionMode(b(parama), a(paramMenu));
  }
  
  public boolean a(a parama, MenuItem paramMenuItem)
  {
    return a.onActionItemClicked(b(parama), new j(b, (b)paramMenuItem));
  }
  
  public ActionMode b(a parama)
  {
    int i = c.size();
    for (int j = 0; j < i; j++)
    {
      e locale = (e)c.get(j);
      if ((locale != null) && (b == parama)) {
        return locale;
      }
    }
    parama = new e(b, parama);
    c.add(parama);
    return parama;
  }
  
  public boolean b(a parama, Menu paramMenu)
  {
    return a.onCreateActionMode(b(parama), a(paramMenu));
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */