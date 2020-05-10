package d.b.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

public final class i
  implements d.i.d.a.b
{
  public d.i.i.b A;
  public MenuItem.OnActionExpandListener B;
  public boolean C = false;
  public ContextMenu.ContextMenuInfo D;
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public CharSequence e;
  public CharSequence f;
  public Intent g;
  public char h;
  public int i = 4096;
  public char j;
  public int k = 4096;
  public Drawable l;
  public int m = 0;
  public g n;
  public r o;
  public MenuItem.OnMenuItemClickListener p;
  public CharSequence q;
  public CharSequence r;
  public ColorStateList s = null;
  public PorterDuff.Mode t = null;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public int x = 16;
  public int y = 0;
  public View z;
  
  public i(g paramg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    n = paramg;
    a = paramInt2;
    b = paramInt1;
    c = paramInt3;
    d = paramInt4;
    e = paramCharSequence;
    y = paramInt5;
  }
  
  public static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  public final Drawable a(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (w) {
        if (!u)
        {
          localDrawable = paramDrawable;
          if (!v) {}
        }
        else
        {
          localDrawable = d.b.a.r.c(paramDrawable).mutate();
          if (u) {
            localDrawable.setTintList(s);
          }
          if (v) {
            localDrawable.setTintMode(t);
          }
          w = false;
        }
      }
    }
    return localDrawable;
  }
  
  public d.i.d.a.b a(d.i.i.b paramb)
  {
    d.i.i.b localb = A;
    if (localb != null) {
      a = null;
    }
    z = null;
    A = paramb;
    n.b(true);
    paramb = A;
    if (paramb != null) {
      paramb.a(new i.a(this));
    }
    return this;
  }
  
  public d.i.i.b a()
  {
    return A;
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = x;
    int i2;
    if (paramBoolean) {
      i2 = 2;
    } else {
      i2 = 0;
    }
    i2 |= i1 & 0xFFFFFFFD;
    x = i2;
    if (i1 != i2) {
      n.b(false);
    }
  }
  
  public char b()
  {
    char c1;
    char c2;
    if (n.f())
    {
      c1 = j;
      c2 = c1;
    }
    else
    {
      c1 = h;
      c2 = c1;
    }
    return c2;
  }
  
  public void b(boolean paramBoolean)
  {
    int i1 = x;
    int i2;
    if (paramBoolean) {
      i2 = 4;
    } else {
      i2 = 0;
    }
    x = (i2 | i1 & 0xFFFFFFFB);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      x |= 0x20;
    } else {
      x &= 0xFFFFFFDF;
    }
  }
  
  public boolean c()
  {
    int i1 = y;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if ((i1 & 0x8) != 0)
    {
      if (z == null)
      {
        d.i.i.b localb = A;
        if (localb != null) {
          z = localb.a(this);
        }
      }
      bool2 = bool1;
      if (z != null) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean collapseActionView()
  {
    if ((y & 0x8) == 0) {
      return false;
    }
    if (z == null) {
      return true;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = B;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionCollapse(this))) {
      return false;
    }
    return n.a(this);
  }
  
  public boolean d()
  {
    boolean bool;
    if ((x & 0x20) == 32) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean d(boolean paramBoolean)
  {
    int i1 = x;
    boolean bool = false;
    int i2;
    if (paramBoolean) {
      i2 = 0;
    } else {
      i2 = 8;
    }
    i2 |= i1 & 0xFFFFFFF7;
    x = i2;
    paramBoolean = bool;
    if (i1 != i2) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean e()
  {
    boolean bool;
    if ((x & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean expandActionView()
  {
    if (!c()) {
      return false;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = B;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return n.b(this);
  }
  
  public boolean f()
  {
    boolean bool;
    if ((n.g()) && (b() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView()
  {
    Object localObject = z;
    if (localObject != null) {
      return (View)localObject;
    }
    localObject = A;
    if (localObject != null)
    {
      localObject = ((d.i.i.b)localObject).a(this);
      z = ((View)localObject);
      return (View)localObject;
    }
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return k;
  }
  
  public char getAlphabeticShortcut()
  {
    return j;
  }
  
  public CharSequence getContentDescription()
  {
    return q;
  }
  
  public int getGroupId()
  {
    return b;
  }
  
  public Drawable getIcon()
  {
    Drawable localDrawable = l;
    if (localDrawable != null) {
      return a(localDrawable);
    }
    int i1 = m;
    if (i1 != 0)
    {
      localDrawable = a.c(n.a, i1);
      m = 0;
      l = localDrawable;
      return a(localDrawable);
    }
    return null;
  }
  
  public ColorStateList getIconTintList()
  {
    return s;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return t;
  }
  
  public Intent getIntent()
  {
    return g;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return D;
  }
  
  public int getNumericModifiers()
  {
    return i;
  }
  
  public char getNumericShortcut()
  {
    return h;
  }
  
  public int getOrder()
  {
    return c;
  }
  
  public SubMenu getSubMenu()
  {
    return o;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return e;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = f;
    if (localCharSequence == null) {
      localCharSequence = e;
    }
    return localCharSequence;
  }
  
  public CharSequence getTooltipText()
  {
    return r;
  }
  
  public boolean hasSubMenu()
  {
    boolean bool;
    if (o != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isActionViewExpanded()
  {
    return C;
  }
  
  public boolean isCheckable()
  {
    int i1 = x;
    boolean bool = true;
    if ((i1 & 0x1) != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isChecked()
  {
    boolean bool;
    if ((x & 0x2) == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEnabled()
  {
    boolean bool;
    if ((x & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isVisible()
  {
    d.i.i.b localb = A;
    boolean bool1 = true;
    boolean bool2 = true;
    if ((localb != null) && (localb.b()))
    {
      if (((x & 0x8) != 0) || (!A.a())) {
        bool2 = false;
      }
      return bool2;
    }
    if ((x & 0x8) == 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public MenuItem setActionView(int paramInt)
  {
    Context localContext = n.a;
    setActionView(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public d.i.d.a.b setActionView(View paramView)
  {
    z = paramView;
    A = null;
    if ((paramView != null) && (paramView.getId() == -1))
    {
      int i1 = a;
      if (i1 > 0) {
        paramView.setId(i1);
      }
    }
    n.h();
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (j == paramChar) {
      return this;
    }
    j = Character.toLowerCase(paramChar);
    n.b(false);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((j == paramChar) && (k == paramInt)) {
      return this;
    }
    j = Character.toLowerCase(paramChar);
    k = KeyEvent.normalizeMetaState(paramInt);
    n.b(false);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = x;
    int i2 = paramBoolean | i1 & 0xFFFFFFFE;
    x = i2;
    if (i1 != i2) {
      n.b(false);
    }
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((x & 0x4) != 0)
    {
      g localg = n;
      if (localg != null)
      {
        int i1 = getGroupId();
        int i2 = f.size();
        localg.j();
        for (int i3 = 0; i3 < i2; i3++)
        {
          i locali = (i)f.get(i3);
          if ((b == i1) && (locali.e()) && (locali.isCheckable()))
          {
            if (locali == this) {
              paramBoolean = true;
            } else {
              paramBoolean = false;
            }
            locali.a(paramBoolean);
          }
        }
        localg.i();
      }
      else
      {
        throw null;
      }
    }
    else
    {
      a(paramBoolean);
    }
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    q = paramCharSequence;
    n.b(false);
    return this;
  }
  
  public d.i.d.a.b setContentDescription(CharSequence paramCharSequence)
  {
    q = paramCharSequence;
    n.b(false);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      x |= 0x10;
    } else {
      x &= 0xFFFFFFEF;
    }
    n.b(false);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    l = null;
    m = paramInt;
    w = true;
    n.b(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    m = 0;
    l = paramDrawable;
    w = true;
    n.b(false);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    s = paramColorStateList;
    u = true;
    w = true;
    n.b(false);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    t = paramMode;
    v = true;
    w = true;
    n.b(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    if (h == paramChar) {
      return this;
    }
    h = ((char)paramChar);
    n.b(false);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((h == paramChar) && (i == paramInt)) {
      return this;
    }
    h = ((char)paramChar);
    i = KeyEvent.normalizeMetaState(paramInt);
    n.b(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    B = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    p = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    h = ((char)paramChar1);
    j = Character.toLowerCase(paramChar2);
    n.b(false);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    h = ((char)paramChar1);
    i = KeyEvent.normalizeMetaState(paramInt1);
    j = Character.toLowerCase(paramChar2);
    k = KeyEvent.normalizeMetaState(paramInt2);
    n.b(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    int i1 = paramInt & 0x3;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2)) {
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    y = paramInt;
    n.h();
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    setTitle(n.a.getString(paramInt));
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    e = paramCharSequence;
    n.b(false);
    r localr = o;
    if (localr != null) {
      localr.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    f = paramCharSequence;
    n.b(false);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    r = paramCharSequence;
    n.b(false);
    return this;
  }
  
  public d.i.d.a.b setTooltipText(CharSequence paramCharSequence)
  {
    r = paramCharSequence;
    n.b(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (d(paramBoolean))
    {
      g localg = n;
      h = true;
      localg.b(true);
    }
    return this;
  }
  
  public String toString()
  {
    Object localObject = e;
    if (localObject != null) {
      localObject = ((CharSequence)localObject).toString();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */