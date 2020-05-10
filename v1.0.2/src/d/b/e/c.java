package d.b.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.R.layout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActionMenuView.c;

import java.util.ArrayList;

import d.b.d.i.b;
import d.b.d.i.g;
import d.b.d.i.i;
import d.b.d.i.k;
import d.b.d.i.l;
import d.b.d.i.n.a;
import d.b.d.i.r;

public class c
  extends b
{
  public c.d G;
  public Drawable H;
  public boolean I;
  public boolean J;
  public boolean K;
  public int L;
  public int M;
  public int N;
  public boolean O;
  public int P;
  public final SparseBooleanArray Q = new SparseBooleanArray();
  public c.e R;
  public c.a S;
  public c.c T;
  public c.b U;
  public final c.f V = new c.f(this);
  public int W;
  
  public c(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  public View a(i parami, View paramView, ViewGroup paramViewGroup)
  {
    View localView = parami.getActionView();
    if ((localView == null) || (parami.c())) {
      localView = super.a(parami, paramView, paramViewGroup);
    }
    int i;
    if (C) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramView = (ActionMenuView)paramViewGroup;
    parami = localView.getLayoutParams();
    if (paramView != null)
    {
      if (!(parami instanceof ActionMenuView.c)) {
        localView.setLayoutParams(paramView.generateLayoutParams(parami));
      }
      return localView;
    }
    throw null;
  }
  
  public void a(Context paramContext, g paramg)
  {
    y = paramContext;
    LayoutInflater.from(paramContext);
    z = paramg;
    paramg = paramContext.getResources();
    if (!K) {
      J = true;
    }
    int i = getResourcesgetDisplayMetricswidthPixels;
    int j = 2;
    L = (i / 2);
    paramContext = paramContext.getResources().getConfiguration();
    i = screenWidthDp;
    int k = screenHeightDp;
    if ((smallestScreenWidthDp <= 600) && (i <= 600) && ((i <= 960) || (k <= 720)) && ((i <= 720) || (k <= 960)))
    {
      if ((i < 500) && ((i <= 640) || (k <= 480)) && ((i <= 480) || (k <= 640)))
      {
        if (i >= 360) {
          j = 3;
        }
      }
      else {
        j = 4;
      }
    }
    else {
      j = 5;
    }
    N = j;
    j = L;
    if (J)
    {
      if (G == null)
      {
        paramContext = new c.d(this, x);
        G = paramContext;
        if (I)
        {
          paramContext.setImageDrawable(H);
          H = null;
          I = false;
        }
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
        G.measure(i, i);
      }
      j -= G.getMeasuredWidth();
    }
    else
    {
      G = null;
    }
    M = j;
    P = ((int)(getDisplayMetricsdensity * 56.0F));
  }
  
  public void a(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof c.g)) {
      return;
    }
    int i = x;
    if (i > 0)
    {
      paramParcelable = z.findItem(i);
      if (paramParcelable != null) {
        a((r)paramParcelable.getSubMenu());
      }
    }
  }
  
  public void a(g paramg, boolean paramBoolean)
  {
    a();
    m.a locala = B;
    if (locala != null) {
      locala.a(paramg, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ((View)E).requestLayout();
    Object localObject1 = z;
    int i = 0;
    Object localObject2;
    int j;
    if (localObject1 != null)
    {
      ((g)localObject1).a();
      localObject2 = i;
      j = ((ArrayList)localObject2).size();
      for (k = 0; k < j; k++) {
        localObject1 = getA;
      }
    }
    localObject1 = z;
    if (localObject1 != null)
    {
      ((g)localObject1).a();
      localObject1 = j;
    }
    else
    {
      localObject1 = null;
    }
    int k = i;
    boolean bool;
    if (J)
    {
      k = i;
      if (localObject1 != null)
      {
        j = ((ArrayList)localObject1).size();
        if (j == 1)
        {
          bool = get0C ^ true;
        }
        else
        {
          bool = i;
          if (j > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (G == null) {
        G = new c.d(this, x);
      }
      localObject1 = (ViewGroup)G.getParent();
      if (localObject1 != E)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(G);
        }
        ActionMenuView localActionMenuView = (ActionMenuView)E;
        localObject2 = G;
        localObject1 = localActionMenuView.generateDefaultLayoutParams();
        c = true;
        localActionMenuView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      localObject1 = G;
      if (localObject1 != null)
      {
        localObject1 = ((ImageView)localObject1).getParent();
        localObject2 = E;
        if (localObject1 == localObject2) {
          ((ViewGroup)localObject2).removeView(G);
        }
      }
    }
    ((ActionMenuView)E).setOverflowReserved(J);
  }
  
  public boolean a()
  {
    return c() | e();
  }
  
  public boolean a(r paramr)
  {
    boolean bool1 = paramr.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject1 = paramr;; localObject1 = (r)localObject2)
    {
      localObject2 = A;
      if (localObject2 == z) {
        break;
      }
    }
    i locali = B;
    ViewGroup localViewGroup = (ViewGroup)E;
    Object localObject2 = null;
    if (localViewGroup == null)
    {
      localObject1 = localObject2;
    }
    else
    {
      i = localViewGroup.getChildCount();
      for (j = 0;; j++)
      {
        localObject1 = localObject2;
        if (j >= i) {
          break;
        }
        localObject1 = localViewGroup.getChildAt(j);
        if (((localObject1 instanceof n.a)) && (((n.a)localObject1).getItemData() == locali)) {
          break;
        }
      }
    }
    if (localObject1 == null) {
      return false;
    }
    W = B.getItemId();
    int i = paramr.size();
    for (int j = 0;; j++)
    {
      bool1 = bool2;
      if (j >= i) {
        break;
      }
      localObject2 = paramr.getItem(j);
      if ((((MenuItem)localObject2).isVisible()) && (((MenuItem)localObject2).getIcon() != null))
      {
        bool1 = true;
        break;
      }
    }
    localObject1 = new c.a(this, y, paramr, (View)localObject1);
    S = ((c.a)localObject1);
    h = bool1;
    localObject1 = j;
    if (localObject1 != null) {
      ((k)localObject1).b(bool1);
    }
    if (S.d())
    {
      localObject1 = B;
      if (localObject1 != null) {
        ((m.a)localObject1).a(paramr);
      }
      return true;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean b()
  {
    Object localObject1 = z;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((g)localObject1).d();
      i = ((ArrayList)localObject1).size();
    }
    else
    {
      localObject1 = null;
      i = 0;
    }
    int j = N;
    int k = M;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)E;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    i locali;
    while (n < i)
    {
      locali = (i)((ArrayList)localObject1).get(n);
      if ((y & 0x2) == 2) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      if (i4 != 0)
      {
        i3++;
      }
      else
      {
        if ((y & 0x1) == 1) {
          i4 = 1;
        } else {
          i4 = 0;
        }
        if (i4 != 0) {
          i2++;
        } else {
          i1 = 1;
        }
      }
      i4 = j;
      if (O)
      {
        i4 = j;
        if (C) {
          i4 = 0;
        }
      }
      n++;
      j = i4;
    }
    n = j;
    if (J) {
      if (i1 == 0)
      {
        n = j;
        if (i2 + i3 <= j) {}
      }
      else
      {
        n = j - 1;
      }
    }
    j = n - i3;
    SparseBooleanArray localSparseBooleanArray = Q;
    localSparseBooleanArray.clear();
    int i4 = 0;
    i3 = 0;
    i2 = k;
    while (i4 < i)
    {
      locali = (i)((ArrayList)localObject1).get(i4);
      if ((y & 0x2) == 2) {
        n = 1;
      } else {
        n = 0;
      }
      Object localObject2;
      if (n != 0)
      {
        localObject2 = a(locali, null, localViewGroup);
        ((View)localObject2).measure(m, m);
        i1 = ((View)localObject2).getMeasuredWidth();
        i2 -= i1;
        n = i3;
        if (i3 == 0) {
          n = i1;
        }
        i3 = b;
        if (i3 != 0) {
          localSparseBooleanArray.put(i3, true);
        }
        locali.c(true);
        i3 = i2;
        i1 = n;
      }
      else
      {
        if ((y & 0x1) == 1) {
          n = 1;
        } else {
          n = 0;
        }
        if (n == 0) {
          break label652;
        }
        int i5 = b;
        boolean bool = localSparseBooleanArray.get(i5);
        int i6;
        if (((j > 0) || (bool)) && (i2 > 0)) {
          i6 = 1;
        } else {
          i6 = 0;
        }
        n = i2;
        i1 = i3;
        int i7 = i6;
        if (i6 != 0)
        {
          localObject2 = a(locali, null, localViewGroup);
          ((View)localObject2).measure(m, m);
          k = ((View)localObject2).getMeasuredWidth();
          n = i2 - k;
          i1 = i3;
          if (i3 == 0) {
            i1 = k;
          }
          if (n + i1 > 0) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          i7 = i6 & i3;
        }
        if ((i7 != 0) && (i5 != 0))
        {
          localSparseBooleanArray.put(i5, true);
          i3 = j;
        }
        else
        {
          i3 = j;
          if (bool)
          {
            localSparseBooleanArray.put(i5, false);
            i2 = 0;
            for (;;)
            {
              i3 = j;
              if (i2 >= i4) {
                break;
              }
              localObject2 = (i)((ArrayList)localObject1).get(i2);
              i3 = j;
              if (b == i5)
              {
                i3 = j;
                if (((i)localObject2).d()) {
                  i3 = j + 1;
                }
                ((i)localObject2).c(false);
              }
              i2++;
              j = i3;
            }
          }
        }
        j = i3;
        if (i7 != 0) {
          j = i3 - 1;
        }
        locali.c(i7);
        i3 = n;
      }
      break label666;
      label652:
      locali.c(false);
      i1 = i3;
      i3 = i2;
      label666:
      i4++;
      i2 = i3;
      i3 = i1;
    }
    return true;
  }
  
  public boolean c()
  {
    Object localObject = T;
    if (localObject != null)
    {
      d.b.d.i.n localn = E;
      if (localn != null)
      {
        ((View)localn).removeCallbacks((Runnable)localObject);
        T = null;
        return true;
      }
    }
    localObject = R;
    if (localObject != null)
    {
      if (((l)localObject).b()) {
        j.dismiss();
      }
      return true;
    }
    return false;
  }
  
  public Parcelable d()
  {
    c.g localg = new c.g();
    x = W;
    return localg;
  }
  
  public boolean e()
  {
    c.a locala = S;
    if (locala != null)
    {
      if (locala.b()) {
        j.dismiss();
      }
      return true;
    }
    return false;
  }
  
  public boolean f()
  {
    c.e locale = R;
    boolean bool;
    if ((locale != null) && (locale.b())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean g()
  {
    if ((J) && (!f()))
    {
      Object localObject = z;
      if ((localObject != null) && (E != null) && (T == null))
      {
        ((g)localObject).a();
        if (!j.isEmpty())
        {
          localObject = new c.c(this, new c.e(this, y, z, G, true));
          T = ((c.c)localObject);
          ((View)E).post((Runnable)localObject);
          super.a(null);
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */