package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.navigation.NavController;
import androidx.navigation.ui.R.anim;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import d.b.d.f;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.o;
import d.b.e.u0;
import d.k.a.a;
import d.s.i;
import d.s.j;
import e.c.a.b.d.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class BottomNavigationView
  extends FrameLayout
{
  public MenuInflater A;
  public c B;
  public b C;
  public final h x;
  public final e.c.a.b.d.d y;
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
    y = new e.c.a.b.d.d(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    gravity = 17;
    y.setLayoutParams(localLayoutParams);
    Object localObject1 = z;
    Object localObject2 = y;
    y = ((e.c.a.b.d.d)localObject2);
    A = 1;
    ((e.c.a.b.d.d)localObject2).setPresenter((e.c.a.b.d.e)localObject1);
    localObject2 = x;
    ((h)localObject2).a(z, a);
    localObject2 = z;
    getContext();
    localObject1 = x;
    x = ((h)localObject1);
    y.U = ((h)localObject1);
    localObject2 = R.styleable.BottomNavigationView;
    int i = R.style.Widget_Design_BottomNavigationView;
    int j = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
    int k = R.styleable.BottomNavigationView_itemTextAppearanceActive;
    e.c.a.b.j.e.a(paramContext, paramAttributeSet, paramInt, i);
    e.c.a.b.j.e.a(paramContext, paramAttributeSet, (int[])localObject2, paramInt, i, new int[] { j, k });
    paramContext = new u0(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, i));
    if (paramContext.e(R.styleable.BottomNavigationView_itemIconTint))
    {
      y.setIconTintList(paramContext.a(R.styleable.BottomNavigationView_itemIconTint));
    }
    else
    {
      paramAttributeSet = y;
      paramAttributeSet.setIconTintList(paramAttributeSet.a(16842808));
    }
    setItemIconSize(paramContext.c(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
    if (paramContext.e(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
      setItemTextAppearanceInactive(paramContext.g(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
    }
    if (paramContext.e(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
      setItemTextAppearanceActive(paramContext.g(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
    }
    if (paramContext.e(R.styleable.BottomNavigationView_itemTextColor)) {
      setItemTextColor(paramContext.a(R.styleable.BottomNavigationView_itemTextColor));
    }
    if (paramContext.e(R.styleable.BottomNavigationView_elevation)) {
      d.i.i.n.a(this, paramContext.c(R.styleable.BottomNavigationView_elevation, 0));
    }
    setLabelVisibilityMode(paramContext.e(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
    setItemHorizontalTranslationEnabled(paramContext.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt = paramContext.g(R.styleable.BottomNavigationView_itemBackground, 0);
    y.setItemBackgroundRes(paramInt);
    if (paramContext.e(R.styleable.BottomNavigationView_menu))
    {
      paramInt = paramContext.g(R.styleable.BottomNavigationView_menu, 0);
      z.z = true;
      getMenuInflater().inflate(paramInt, x);
      paramAttributeSet = z;
      z = false;
      paramAttributeSet.a(true);
    }
    b.recycle();
    addView(y, localLayoutParams);
    x.a(new a());
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
    if (!(paramParcelable instanceof d))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Object localObject1 = (d)paramParcelable;
    super.onRestoreInstanceState(x);
    paramParcelable = x;
    localObject1 = z;
    if (paramParcelable != null)
    {
      SparseArray localSparseArray = ((Bundle)localObject1).getSparseParcelableArray("android:menu:presenters");
      if ((localSparseArray != null) && (!v.isEmpty()))
      {
        Iterator localIterator = v.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (WeakReference)localIterator.next();
          localObject1 = (o)((WeakReference)localObject2).get();
          if (localObject1 == null)
          {
            v.remove(localObject2);
          }
          else
          {
            int i = ((o)localObject1).getId();
            if (i > 0)
            {
              localObject2 = (Parcelable)localSparseArray.get(i);
              if (localObject2 != null) {
                ((o)localObject1).a((Parcelable)localObject2);
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
    d locald = new d(super.onSaveInstanceState());
    Bundle localBundle = new Bundle();
    z = localBundle;
    h localh = x;
    if (!v.isEmpty())
    {
      SparseArray localSparseArray = new SparseArray();
      Iterator localIterator = v.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        Object localObject = (o)localWeakReference.get();
        if (localObject == null)
        {
          v.remove(localWeakReference);
        }
        else
        {
          int i = ((o)localObject).getId();
          if (i > 0)
          {
            localObject = ((o)localObject).d();
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
    e.c.a.b.d.d locald = y;
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
  
  public void setOnNavigationItemReselectedListener(b paramb)
  {
    C = paramb;
  }
  
  public void setOnNavigationItemSelectedListener(c paramc)
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
  
  public class a
    implements h.a
  {
    public a() {}
    
    public void a(h paramh) {}
    
    public boolean a(h paramh, MenuItem paramMenuItem)
    {
      paramh = C;
      boolean bool = true;
      if ((paramh != null) && (paramMenuItem.getItemId() == getSelectedItemId()))
      {
        C.a(paramMenuItem);
        return true;
      }
      paramh = B;
      if (paramh != null)
      {
        NavController localNavController = a;
        int i = R.anim.nav_default_enter_anim;
        int j = R.anim.nav_default_exit_anim;
        int k = R.anim.nav_default_pop_enter_anim;
        int m = R.anim.nav_default_pop_exit_anim;
        int n;
        if ((paramMenuItem.getOrder() & 0x30000) == 0)
        {
          paramh = d;
          if (paramh != null)
          {
            while ((paramh instanceof j))
            {
              paramh = (j)paramh;
              paramh = paramh.b(G);
            }
            n = z;
          }
          else
          {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
          }
        }
        else
        {
          n = -1;
        }
        int i1 = 0;
        paramh = new d.s.n(true, n, false, i, j, k, m);
        try
        {
          localNavController.a(paramMenuItem.getItemId(), null, paramh);
          n = 1;
        }
        catch (IllegalArgumentException paramh)
        {
          n = i1;
        }
        if (n == 0) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(MenuItem paramMenuItem);
  }
  
  public static abstract interface c {}
  
  public static class d
    extends a
  {
    public static final Parcelable.Creator<d> CREATOR = new a();
    public Bundle z;
    
    public d(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      z = paramParcel.readBundle(paramClassLoader);
    }
    
    public d(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeBundle(z);
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<BottomNavigationView.d>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new BottomNavigationView.d(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomNavigationView.d(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new BottomNavigationView.d[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */