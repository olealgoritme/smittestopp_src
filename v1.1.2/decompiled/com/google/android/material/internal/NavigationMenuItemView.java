package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import d.b.a.s;
import d.b.d.i.j;
import d.b.d.i.p.a;
import d.b.e.g0;
import d.b.e.g0.a;
import d.i.i.a;
import d.i.i.n;
import d.i.i.x.d;
import e.c.a.b.j.b;

public class NavigationMenuItemView
  extends b
  implements p.a
{
  public static final int[] f0 = { 16842912 };
  public final int S;
  public boolean T;
  public boolean U;
  public final CheckedTextView V;
  public FrameLayout W;
  public j a0;
  public ColorStateList b0;
  public boolean c0;
  public Drawable d0;
  public final a e0 = new a();
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(R.layout.design_navigation_menu_item, this, true);
    S = paramContext.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
    paramContext = (CheckedTextView)findViewById(R.id.design_menu_item_text);
    V = paramContext;
    paramContext.setDuplicateParentStateEnabled(true);
    n.a(V, e0);
  }
  
  private void setActionView(View paramView)
  {
    if (paramView != null)
    {
      if (W == null) {
        W = ((FrameLayout)((ViewStub)findViewById(R.id.design_menu_item_action_area_stub)).inflate());
      }
      W.removeAllViews();
      W.addView(paramView);
    }
  }
  
  public void a(j paramj, int paramInt)
  {
    a0 = paramj;
    if (paramj.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    Object localObject = getBackground();
    paramInt = 1;
    if (localObject == null)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, localTypedValue, true))
      {
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(f0, new ColorDrawable(data));
        ((StateListDrawable)localObject).addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
      }
      else
      {
        localObject = null;
      }
      n.a(this, (Drawable)localObject);
    }
    setCheckable(paramj.isCheckable());
    setChecked(paramj.isChecked());
    setEnabled(paramj.isEnabled());
    setTitle(e);
    setIcon(paramj.getIcon());
    setActionView(paramj.getActionView());
    setContentDescription(q);
    s.a(this, r);
    paramj = a0;
    if ((e != null) || (paramj.getIcon() != null) || (a0.getActionView() == null)) {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      V.setVisibility(8);
      paramj = W;
      if (paramj != null)
      {
        paramj = (g0.a)paramj.getLayoutParams();
        width = -1;
        W.setLayoutParams(paramj);
      }
    }
    else
    {
      V.setVisibility(0);
      paramj = W;
      if (paramj != null)
      {
        paramj = (g0.a)paramj.getLayoutParams();
        width = -2;
        W.setLayoutParams(paramj);
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public j getItemData()
  {
    return a0;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    j localj = a0;
    if ((localj != null) && (localj.isCheckable()) && (a0.isChecked())) {
      ViewGroup.mergeDrawableStates(arrayOfInt, f0);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (U != paramBoolean)
    {
      U = paramBoolean;
      a locala = e0;
      CheckedTextView localCheckedTextView = V;
      a.sendAccessibilityEvent(localCheckedTextView, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    V.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i;
    if (paramDrawable != null)
    {
      Object localObject = paramDrawable;
      if (c0)
      {
        localObject = paramDrawable.getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        localObject = s.c(paramDrawable).mutate();
        ((Drawable)localObject).setTintList(b0);
      }
      i = S;
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramDrawable = (Drawable)localObject;
    }
    else if (T)
    {
      if (d0 == null)
      {
        paramDrawable = getResources().getDrawable(R.drawable.navigation_empty_icon, getContext().getTheme());
        d0 = paramDrawable;
        if (paramDrawable != null)
        {
          i = S;
          paramDrawable.setBounds(0, 0, i, i);
        }
      }
      paramDrawable = d0;
    }
    V.setCompoundDrawablesRelative(paramDrawable, null, null, null);
  }
  
  public void setIconPadding(int paramInt)
  {
    V.setCompoundDrawablePadding(paramInt);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    b0 = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    c0 = bool;
    paramColorStateList = a0;
    if (paramColorStateList != null) {
      setIcon(paramColorStateList.getIcon());
    }
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    T = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    s.d(V, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    V.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    V.setText(paramCharSequence);
  }
  
  public class a
    extends a
  {
    public a() {}
    
    public void a(View paramView, d paramd)
    {
      a.onInitializeAccessibilityNodeInfo(paramView, a);
      boolean bool = U;
      a.setCheckable(bool);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.internal.NavigationMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */