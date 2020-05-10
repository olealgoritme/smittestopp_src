package d.b.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k
  extends c<d.i.d.a.b>
  implements MenuItem
{
  public Method e;
  
  public k(Context paramContext, d.i.d.a.b paramb)
  {
    super(paramContext, paramb);
  }
  
  public a a(ActionProvider paramActionProvider)
  {
    return new a(b, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((d.i.d.a.b)a).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((d.i.d.a.b)a).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    d.i.i.b localb = ((d.i.d.a.b)a).a();
    if ((localb instanceof a)) {
      return b;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView1 = ((d.i.d.a.b)a).getActionView();
    View localView2 = localView1;
    if ((localView1 instanceof b)) {
      localView2 = (View)x;
    }
    return localView2;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((d.i.d.a.b)a).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((d.i.d.a.b)a).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((d.i.d.a.b)a).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((d.i.d.a.b)a).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((d.i.d.a.b)a).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((d.i.d.a.b)a).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((d.i.d.a.b)a).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((d.i.d.a.b)a).getIntent();
  }
  
  public int getItemId()
  {
    return ((d.i.d.a.b)a).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((d.i.d.a.b)a).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((d.i.d.a.b)a).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((d.i.d.a.b)a).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((d.i.d.a.b)a).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((d.i.d.a.b)a).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((d.i.d.a.b)a).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((d.i.d.a.b)a).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((d.i.d.a.b)a).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((d.i.d.a.b)a).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((d.i.d.a.b)a).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((d.i.d.a.b)a).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((d.i.d.a.b)a).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((d.i.d.a.b)a).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((d.i.d.a.b)a).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    d.i.d.a.b localb = (d.i.d.a.b)a;
    if (paramActionProvider != null) {
      paramActionProvider = a(paramActionProvider);
    } else {
      paramActionProvider = null;
    }
    localb.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((d.i.d.a.b)a).setActionView(paramInt);
    View localView = ((d.i.d.a.b)a).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((d.i.d.a.b)a).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((d.i.d.a.b)a).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((d.i.d.a.b)a).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((d.i.d.a.b)a).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((d.i.d.a.b)a).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((d.i.d.a.b)a).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((d.i.d.a.b)a).setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((d.i.d.a.b)a).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((d.i.d.a.b)a).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((d.i.d.a.b)a).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((d.i.d.a.b)a).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((d.i.d.a.b)a).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((d.i.d.a.b)a).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((d.i.d.a.b)a).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((d.i.d.a.b)a).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    d.i.d.a.b localb = (d.i.d.a.b)a;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new c(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localb.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    d.i.d.a.b localb = (d.i.d.a.b)a;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((d.i.d.a.b)a).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((d.i.d.a.b)a).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((d.i.d.a.b)a).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((d.i.d.a.b)a).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((d.i.d.a.b)a).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((d.i.d.a.b)a).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((d.i.d.a.b)a).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((d.i.d.a.b)a).setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((d.i.d.a.b)a).setVisible(paramBoolean);
  }
  
  public class a
    extends d.i.i.b
  {
    public final ActionProvider b;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      b = paramActionProvider;
    }
  }
  
  public static class b
    extends FrameLayout
    implements d.b.d.b
  {
    public final CollapsibleActionView x;
    
    public b(View paramView)
    {
      super();
      x = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public void a()
    {
      x.onActionViewExpanded();
    }
    
    public void c()
    {
      x.onActionViewCollapsed();
    }
  }
  
  public class c
    extends d<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    public c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)a).onMenuItemActionCollapse(a(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)a).onMenuItemActionExpand(a(paramMenuItem));
    }
  }
  
  public class d
    extends d<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    public d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)a).onMenuItemClick(a(paramMenuItem));
    }
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */