package d.b.d.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.Map;

import d.f.a;
import d.i.d.a.b;

public abstract class c
{
  public final Context a;
  public Map<b, MenuItem> b;
  public Map<d.i.d.a.c, SubMenu> c;
  
  public c(Context paramContext)
  {
    a = paramContext;
  }
  
  public final MenuItem a(MenuItem paramMenuItem)
  {
    Object localObject = paramMenuItem;
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (b == null) {
        b = new a();
      }
      paramMenuItem = (MenuItem)b.get(paramMenuItem);
      localObject = paramMenuItem;
      if (paramMenuItem == null)
      {
        localObject = new j(a, localb);
        b.put(localb, localObject);
      }
    }
    return (MenuItem)localObject;
  }
  
  public final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof d.i.d.a.c))
    {
      d.i.d.a.c localc = (d.i.d.a.c)paramSubMenu;
      if (c == null) {
        c = new a();
      }
      SubMenu localSubMenu = (SubMenu)c.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new s(a, localc);
        c.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */