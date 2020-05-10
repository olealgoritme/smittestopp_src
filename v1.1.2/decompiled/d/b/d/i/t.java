package d.b.d.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class t
  extends h
  implements SubMenu
{
  public h A;
  public j B;
  
  public t(Context paramContext, h paramh, j paramj)
  {
    super(paramContext);
    A = paramh;
    B = paramj;
  }
  
  public void a(h.a parama)
  {
    A.a(parama);
  }
  
  public boolean a(h paramh, MenuItem paramMenuItem)
  {
    boolean bool;
    if ((!super.a(paramh, paramMenuItem)) && (!A.a(paramh, paramMenuItem))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(j paramj)
  {
    return A.a(paramj);
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
  
  public boolean b(j paramj)
  {
    return A.b(paramj);
  }
  
  public h c()
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
 * Qualified Name:     d.b.d.i.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */