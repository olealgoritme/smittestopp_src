package d.b.d.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class s
  extends o
  implements SubMenu
{
  public final d.i.d.a.c e;
  
  public s(Context paramContext, d.i.d.a.c paramc)
  {
    super(paramContext, paramc);
    e = paramc;
  }
  
  public void clearHeader()
  {
    e.clearHeader();
  }
  
  public MenuItem getItem()
  {
    return a(e.getItem());
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    e.setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    e.setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    e.setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    e.setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    e.setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    e.setIcon(paramDrawable);
    return this;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */