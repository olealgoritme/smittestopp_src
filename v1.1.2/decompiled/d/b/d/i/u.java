package d.b.d.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u
  extends q
  implements SubMenu
{
  public u(Context paramContext, d.i.d.a.c paramc)
  {
    super(paramContext, paramc);
  }
  
  public void clearHeader()
  {
    ((d.i.d.a.c)a).clearHeader();
  }
  
  public MenuItem getItem()
  {
    return a(((d.i.d.a.c)a).getItem());
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    ((d.i.d.a.c)a).setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((d.i.d.a.c)a).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    ((d.i.d.a.c)a).setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((d.i.d.a.c)a).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    ((d.i.d.a.c)a).setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    ((d.i.d.a.c)a).setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    ((d.i.d.a.c)a).setIcon(paramDrawable);
    return this;
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */