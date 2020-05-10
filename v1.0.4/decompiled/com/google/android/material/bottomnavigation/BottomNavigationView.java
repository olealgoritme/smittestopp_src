package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import d.b.d.f;
import d.b.d.i.g;
import d.b.d.i.m;
import d.b.e.x0;
import d.i.i.n;
import d.k.a.a;
import e.c.a.b.d.b;
import e.c.a.b.d.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class BottomNavigationView
  extends FrameLayout
{
  public MenuInflater A;
  public BottomNavigationView.c B;
  public BottomNavigationView.b C;
  public final g x;
  public final d y;
  public final e.c.a.b.d.e z = new e.c.a.b.d.e();
  
  public BottomNavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    x = new b(paramContext);
    y = new d(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    gravity = 17;
    y.setLayoutParams(localLayoutParams);
    Object localObject1 = z;
    Object localObject2 = y;
    y = ((d)localObject2);
    A = 1;
    ((d)localObject2).setPresenter((e.c.a.b.d.e)localObject1);
    localObject2 = x;
    ((g)localObject2).a(z, a);
    localObject2 = z;
    getContext();
    localObject1 = x;
    x = ((g)localObject1);
    y.U = ((g)localObject1);
    localObject2 = R.styleable.BottomNavigationView;
    int i = R.style.Widget_Design_BottomNavigationView;
    int j = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
    int k = R.styleable.BottomNavigationView_itemTextAppearanceActive;
    e.c.a.b.j.e.a(paramContext, paramAttributeSet, paramInt, i);
    e.c.a.b.j.e.a(paramContext, paramAttributeSet, (int[])localObject2, paramInt, i, new int[] { j, k });
    paramContext = new x0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, i));
    if (paramContext.f(R.styleable.BottomNavigationView_itemIconTint))
    {
      y.setIconTintList(paramContext.a(R.styleable.BottomNavigationView_itemIconTint));
    }
    else
    {
      paramAttributeSet = y;
      paramAttributeSet.setIconTintList(paramAttributeSet.a(16842808));
    }
    setItemIconSize(paramContext.b(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
    if (paramContext.f(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
      setItemTextAppearanceInactive(paramContext.f(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
    }
    if (paramContext.f(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
      setItemTextAppearanceActive(paramContext.f(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
    }
    if (paramContext.f(R.styleable.BottomNavigationView_itemTextColor)) {
      setItemTextColor(paramContext.a(R.styleable.BottomNavigationView_itemTextColor));
    }
    if (paramContext.f(R.styleable.BottomNavigationView_elevation)) {
      n.a(this, paramContext.b(R.styleable.BottomNavigationView_elevation, 0));
    }
    setLabelVisibilityMode(paramContext.d(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
    setItemHorizontalTranslationEnabled(paramContext.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt = paramContext.f(R.styleable.BottomNavigationView_itemBackground, 0);
    y.setItemBackgroundRes(paramInt);
    if (paramContext.f(R.styleable.BottomNavigationView_menu))
    {
      paramInt = paramContext.f(R.styleable.BottomNavigationView_menu, 0);
      z.z = true;
      getMenuInflater().inflate(paramInt, x);
      paramAttributeSet = z;
      z = false;
      paramAttributeSet.a(true);
    }
    b.recycle();
    addView(y, localLayoutParams);
    x.a(new BottomNavigationView.a(this));
  }
  
  private MenuInflater getMenuInflater()
  {
    if (A == null) {
      A = new f(getContext());
    }
    return A;
  }
  
  public Drawable getItemBackground()
  {
    return y.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return y.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return y.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return y.getIconTintList();
  }
  
  public int getItemTextAppearanceActive()
  {
    return y.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return y.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return y.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return y.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return x;
  }
  
  public int getSelectedItemId()
  {
    return y.getSelectedItemId();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof BottomNavigationView.d))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Object localObject1 = (BottomNavigationView.d)paramParcelable;
    super.onRestoreInstanceState(x);
    paramParcelable = x;
    localObject1 = z;
    if (paramParcelable != null)
    {
      localObject1 = ((Bundle)localObject1).getSparseParcelableArray("android:menu:presenters");
      if ((localObject1 != null) && (!v.isEmpty()))
      {
        Iterator localIterator = v.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (WeakReference)localIterator.next();
          m localm = (m)((WeakReference)localObject2).get();
          if (localm == null)
          {
            v.remove(localObject2);
          }
          else
          {
            int i = localm.getId();
            if (i > 0)
            {
              localObject2 = (Parcelable)((SparseArray)localObject1).get(i);
              if (localObject2 != null) {
                localm.a((Parcelable)localObject2);
              }
            }
          }
        }
      }
      return;
    }
    throw null;
  }
  
  public Parcelable onSaveInstanceState()
  {
    BottomNavigationView.d locald = new BottomNavigationView.d(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    z = localBundle;
    g localg = x;
    if (!v.isEmpty())
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = v.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        m localm = (m)((WeakReference)localObject).get();
        if (localm == null)
        {
          v.remove(localObject);
        }
        else
        {
          int i = localm.getId();
          if (i > 0)
          {
            localObject = localm.d();
            if (localObject != null) {
              localSparseArray.put(i, localObject);
            }
          }
        }
      }
      localBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
    }
    return locald;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    y.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    y.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    d locald = y;
    if (F != paramBoolean)
    {
      locald.setItemHorizontalTranslationEnabled(paramBoolean);
      z.a(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    y.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    y.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    y.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    y.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    y.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (y.getLabelVisibilityMode() != paramInt)
    {
      y.setLabelVisibilityMode(paramInt);
      z.a(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(BottomNavigationView.b paramb)
  {
    C = paramb;
  }
  
  public void setOnNavigationItemSelectedListener(BottomNavigationView.c paramc)
  {
    B = paramc;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = x.findItem(paramInt);
    if ((localMenuItem != null) && (!x.a(localMenuItem, z, 0))) {
      localMenuItem.setChecked(true);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.material.bottomnavigation.BottomNavigationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */