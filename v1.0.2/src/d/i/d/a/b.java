package d.i.d.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;
import android.view.View;

public abstract interface b
  extends MenuItem
{
  public abstract b a(d.i.i.b paramb);
  
  public abstract d.i.i.b a();
  
  public abstract boolean collapseActionView();
  
  public abstract boolean expandActionView();
  
  public abstract View getActionView();
  
  public abstract int getAlphabeticModifiers();
  
  public abstract CharSequence getContentDescription();
  
  public abstract ColorStateList getIconTintList();
  
  public abstract PorterDuff.Mode getIconTintMode();
  
  public abstract int getNumericModifiers();
  
  public abstract CharSequence getTooltipText();
  
  public abstract boolean isActionViewExpanded();
  
  public abstract MenuItem setActionView(int paramInt);
  
  public abstract MenuItem setActionView(View paramView);
  
  public abstract MenuItem setAlphabeticShortcut(char paramChar, int paramInt);
  
  public abstract b setContentDescription(CharSequence paramCharSequence);
  
  public abstract MenuItem setIconTintList(ColorStateList paramColorStateList);
  
  public abstract MenuItem setIconTintMode(PorterDuff.Mode paramMode);
  
  public abstract MenuItem setNumericShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2);
  
  public abstract void setShowAsAction(int paramInt);
  
  public abstract MenuItem setShowAsActionFlags(int paramInt);
  
  public abstract b setTooltipText(CharSequence paramCharSequence);
}

/* Location:
 * Qualified Name:     base.d.i.d.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */