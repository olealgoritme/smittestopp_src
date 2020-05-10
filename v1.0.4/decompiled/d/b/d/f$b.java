package d.b.d;

import android.content.res.ColorStateList;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import d.b.d.i.i;
import d.b.d.i.j;

public class f$b
{
  public d.i.i.b A;
  public CharSequence B;
  public CharSequence C;
  public ColorStateList D = null;
  public PorterDuff.Mode E = null;
  public Menu a;
  public int b;
  public int c;
  public int d;
  public int e;
  public boolean f;
  public boolean g;
  public boolean h;
  public int i;
  public int j;
  public CharSequence k;
  public CharSequence l;
  public int m;
  public char n;
  public int o;
  public char p;
  public int q;
  public int r;
  public boolean s;
  public boolean t;
  public boolean u;
  public int v;
  public int w;
  public String x;
  public String y;
  public String z;
  
  public f$b(f paramf, Menu paramMenu)
  {
    a = paramMenu;
    b = 0;
    c = 0;
    d = 0;
    e = 0;
    f = true;
    g = true;
  }
  
  public SubMenu a()
  {
    h = true;
    SubMenu localSubMenu = a.addSubMenu(b, i, j, k);
    a(localSubMenu.getItem());
    return localSubMenu;
  }
  
  public final <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = Class.forName(paramString, false, F.c.getClassLoader()).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("Cannot instantiate class: ");
      paramArrayOfObject.append(paramString);
      Log.w("SupportMenuInflater", paramArrayOfObject.toString(), paramArrayOfClass);
    }
    return null;
  }
  
  public final void a(MenuItem paramMenuItem)
  {
    Object localObject1 = paramMenuItem.setChecked(s).setVisible(t).setEnabled(u);
    int i1 = r;
    int i2 = 0;
    if (i1 >= 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((MenuItem)localObject1).setCheckable(bool).setTitleCondensed(l).setIcon(m);
    i1 = v;
    if (i1 >= 0) {
      paramMenuItem.setShowAsAction(i1);
    }
    if (z != null) {
      if (!F.c.isRestricted())
      {
        localObject1 = F;
        if (d == null) {
          d = ((f)localObject1).a(c);
        }
        paramMenuItem.setOnMenuItemClickListener(new f.a(d, z));
      }
      else
      {
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
    }
    boolean bool = paramMenuItem instanceof i;
    if (bool) {
      localObject1 = (i)paramMenuItem;
    }
    if (r >= 2) {
      if (bool)
      {
        ((i)paramMenuItem).b(true);
      }
      else if ((paramMenuItem instanceof j))
      {
        localObject1 = (j)paramMenuItem;
        try
        {
          if (e == null) {
            e = d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
          }
          e.invoke(d, new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception localException)
        {
          Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
        }
      }
    }
    Object localObject2 = x;
    if (localObject2 != null)
    {
      paramMenuItem.setActionView((View)a((String)localObject2, f.e, F.a));
      i2 = 1;
    }
    i1 = w;
    if (i1 > 0) {
      if (i2 == 0) {
        paramMenuItem.setActionView(i1);
      } else {
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
    }
    localObject2 = A;
    if (localObject2 != null) {
      if ((paramMenuItem instanceof d.i.d.a.b)) {
        ((d.i.d.a.b)paramMenuItem).a((d.i.i.b)localObject2);
      } else {
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
      }
    }
    localObject2 = B;
    bool = paramMenuItem instanceof d.i.d.a.b;
    if (bool) {
      ((d.i.d.a.b)paramMenuItem).setContentDescription((CharSequence)localObject2);
    } else if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setContentDescription((CharSequence)localObject2);
    }
    localObject2 = C;
    if (bool) {
      ((d.i.d.a.b)paramMenuItem).setTooltipText((CharSequence)localObject2);
    } else if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setTooltipText((CharSequence)localObject2);
    }
    char c1 = n;
    i2 = o;
    if (bool) {
      ((d.i.d.a.b)paramMenuItem).setAlphabeticShortcut(c1, i2);
    } else if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setAlphabeticShortcut(c1, i2);
    }
    c1 = p;
    i2 = q;
    if (bool) {
      ((d.i.d.a.b)paramMenuItem).setNumericShortcut(c1, i2);
    } else if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setNumericShortcut(c1, i2);
    }
    localObject2 = E;
    if (localObject2 != null) {
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setIconTintMode((PorterDuff.Mode)localObject2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setIconTintMode((PorterDuff.Mode)localObject2);
      }
    }
    localObject2 = D;
    if (localObject2 != null) {
      if (bool) {
        ((d.i.d.a.b)paramMenuItem).setIconTintList((ColorStateList)localObject2);
      } else if (Build.VERSION.SDK_INT >= 26) {
        paramMenuItem.setIconTintList((ColorStateList)localObject2);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */