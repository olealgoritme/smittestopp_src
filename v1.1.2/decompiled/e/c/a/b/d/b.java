package e.c.a.b.d;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import d.b.d.i.h;
import d.b.d.i.j;

public final class b
  extends h
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 <= 5)
    {
      j();
      paramCharSequence = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
      ((j)paramCharSequence).b(true);
      i();
      return paramCharSequence;
    }
    throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.d.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */