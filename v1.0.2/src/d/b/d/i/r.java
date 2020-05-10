package d.b.d.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class r
  extends g
  implements SubMenu
{
  public g A;
  public i B;
  
  public r(Context paramContext, g paramg, i parami)
  {
    super(paramContext);
    A = paramg;
    B = parami;
  }
  
  public void a(g.a parama)
  {
    A.a(parama);
  }
  
  public boolean a(g paramg, MenuItem paramMenuItem)
  {
    boolean bool;
    if ((!super.a(paramg, paramMenuItem)) && (!A.a(paramg, paramMenuItem))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(i parami)
  {
    return A.a(parami);
  }
  
  public String b()
  {
    Object localObject = B;
    int i;
    if (localObject != null) {
      i = a;
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android:menu:actionviewstates");
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
  }
  
  public boolean b(i parami)
  {
    return A.b(parami);
  }
  
  public g c()
  {
    return A.c();
  }
  
  public boolean e()
  {
    return A.e();
  }
  
  public boolean f()
  {
    return A.f();
  }
  
  public boolean g()
  {
    return A.g();
  }
  
  public MenuItem getItem()
  {
    return B;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    A.setGroupDividerEnabled(paramBoolean);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    a(0, null, paramInt, null, null);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    a(paramInt, null, 0, null, null);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    B.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    B.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    A.setQwertyMode(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */