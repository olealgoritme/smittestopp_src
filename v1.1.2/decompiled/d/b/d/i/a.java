package d.b.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import d.b.a.s;

public class a
  implements d.i.d.a.b
{
  public final int a;
  public final int b;
  public final int c;
  public CharSequence d;
  public CharSequence e;
  public Intent f;
  public char g;
  public int h = 4096;
  public char i;
  public int j = 4096;
  public Drawable k;
  public Context l;
  public CharSequence m;
  public CharSequence n;
  public ColorStateList o = null;
  public PorterDuff.Mode p = null;
  public boolean q = false;
  public boolean r = false;
  public int s = 16;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    l = paramContext;
    a = paramInt2;
    b = paramInt1;
    c = paramInt4;
    d = paramCharSequence;
  }
  
  public d.i.d.a.b a(d.i.i.b paramb)
  {
    throw new UnsupportedOperationException();
  }
  
  public d.i.i.b a()
  {
    return null;
  }
  
  public final void b()
  {
    if ((k != null) && ((q) || (r)))
    {
      Drawable localDrawable = s.c(k);
      k = localDrawable;
      localDrawable = localDrawable.mutate();
      k = localDrawable;
      if (q) {
        localDrawable.setTintList(o);
      }
      if (r) {
        k.setTintMode(p);
      }
    }
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return j;
  }
  
  public char getAlphabeticShortcut()
  {
    return i;
  }
  
  public CharSequence getContentDescription()
  {
    return m;
  }
  
  public int getGroupId()
  {
    return b;
  }
  
  public Drawable getIcon()
  {
    return k;
  }
  
  public ColorStateList getIconTintList()
  {
    return o;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return p;
  }
  
  public Intent getIntent()
  {
    return f;
  }
  
  public int getItemId()
  {
    return a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public int getNumericModifiers()
  {
    return h;
  }
  
  public char getNumericShortcut()
  {
    return g;
  }
  
  public int getOrder()
  {
    return c;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return d;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = e;
    if (localCharSequence == null) {
      localCharSequence = d;
    }
    return localCharSequence;
  }
  
  public CharSequence getTooltipText()
  {
    return n;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    int i1 = s;
    boolean bool = true;
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isChecked()
  {
    boolean bool;
    if ((s & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEnabled()
  {
    boolean bool;
    if ((s & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isVisible()
  {
    boolean bool;
    if ((s & 0x8) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setActionView(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setActionView(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    i = Character.toLowerCase(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    i = Character.toLowerCase(paramChar);
    j = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    s = (paramBoolean | s & 0xFFFFFFFE);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    int i1 = s;
    int i2;
    if (paramBoolean) {
      i2 = 2;
    } else {
      i2 = 0;
    }
    s = (i2 | i1 & 0xFFFFFFFD);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    m = paramCharSequence;
    return this;
  }
  
  public d.i.d.a.b setContentDescription(CharSequence paramCharSequence)
  {
    m = paramCharSequence;
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int i1 = s;
    int i2;
    if (paramBoolean) {
      i2 = 16;
    } else {
      i2 = 0;
    }
    s = (i2 | i1 & 0xFFFFFFEF);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    k = d.i.b.a.c(l, paramInt);
    b();
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    k = paramDrawable;
    b();
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    o = paramColorStateList;
    q = true;
    b();
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    p = paramMode;
    r = true;
    b();
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    f = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    g = ((char)paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    g = ((char)paramChar);
    h = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    g = ((char)paramChar1);
    i = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    g = ((char)paramChar1);
    h = KeyEvent.normalizeMetaState(paramInt1);
    i = Character.toLowerCase(paramChar2);
    j = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    d = l.getResources().getString(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    d = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    e = paramCharSequence;
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    n = paramCharSequence;
    return this;
  }
  
  public d.i.d.a.b setTooltipText(CharSequence paramCharSequence)
  {
    n = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    int i1 = s;
    int i2 = 8;
    if (paramBoolean) {
      i2 = 0;
    }
    s = (i1 & 0x8 | i2);
    return this;
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */