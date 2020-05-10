package d.b.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import java.lang.reflect.Method;

public class j
  extends c
  implements MenuItem
{
  public final d.i.d.a.b d;
  public Method e;
  
  public j(Context paramContext, d.i.d.a.b paramb)
  {
    super(paramContext);
    if (paramb != null)
    {
      d = paramb;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public boolean collapseActionView()
  {
    return d.collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return d.expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    d.i.i.b localb = d.a();
    if ((localb instanceof j.a)) {
      return b;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView1 = d.getActionView();
    View localView2 = localView1;
    if ((localView1 instanceof j.c)) {
      localView2 = (View)x;
    }
    return localView2;
  }
  
  public int getAlphabeticModifiers()
  {
    return d.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return d.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return d.getContentDescription();
  }
  
  public int getGroupId()
  {
    return d.getGroupId();
  }
  
  public Drawable getIcon()
  {
    return d.getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return d.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return d.getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return d.getIntent();
  }
  
  public int getItemId()
  {
    return d.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return d.getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return d.getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return d.getNumericShortcut();
  }
  
  public int getOrder()
  {
    return d.getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(d.getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return d.getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return d.getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return d.getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return d.hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return d.isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return d.isCheckable();
  }
  
  public boolean isChecked()
  {
    return d.isChecked();
  }
  
  public boolean isEnabled()
  {
    return d.isEnabled();
  }
  
  public boolean isVisible()
  {
    return d.isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    j.b localb = new j.b(this, a, paramActionProvider);
    d.i.d.a.b localb1 = d;
    if (paramActionProvider != null) {
      paramActionProvider = localb;
    } else {
      paramActionProvider = null;
    }
    localb1.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    d.setActionView(paramInt);
    View localView = d.getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      d.setActionView(new j.c(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new j.c(paramView);
    }
    d.setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    d.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    d.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    d.setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    d.setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    d.setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    d.setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    d.setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    d.setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    d.setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    d.setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    d.setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    d.setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    d.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    d.i.d.a.b localb = d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new j.d(this, paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localb.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    d.i.d.a.b localb = d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new j.e(this, paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    d.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    d.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    d.setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    d.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    d.setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    d.setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    d.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    d.setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return d.setVisible(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     base.d.b.d.i.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */