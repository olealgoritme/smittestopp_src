package d.b.d.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import d.f.a;
import d.i.d.a.b;
import java.util.Map;

public abstract class c<T>
  extends d<T>
{
  public final Context b;
  public Map<b, MenuItem> c;
  public Map<d.i.d.a.c, SubMenu> d;
  
  public c(Context paramContext, T paramT)
  {
    super(paramT);
    b = paramContext;
  }
  
  public final MenuItem a(MenuItem paramMenuItem)
  {
    Object localObject = paramMenuItem;
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (c == null) {
        c = new a();
      }
      paramMenuItem = (MenuItem)c.get(paramMenuItem);
      localObject = paramMenuItem;
      if (paramMenuItem == null)
      {
        localObject = new l(b, localb);
        c.put(localb, localObject);
      }
    }
    return (MenuItem)localObject;
  }
  
  public final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof d.i.d.a.c))
    {
      d.i.d.a.c localc = (d.i.d.a.c)paramSubMenu;
      if (d == null) {
        d = new a();
      }
      SubMenu localSubMenu = (SubMenu)d.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new u(b, localc);
        d.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */