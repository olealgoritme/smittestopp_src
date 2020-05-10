package d.b.e;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.layout;
import androidx.appcompat.view.menu.ActionMenuItemView.b;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActionMenuView.a;
import androidx.appcompat.widget.ActionMenuView.c;
import d.b.a.s;
import d.b.d.i.b;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.j;
import d.b.d.i.m;
import d.b.d.i.o.a;
import d.b.d.i.p.a;
import d.b.d.i.r;
import d.b.d.i.t;
import java.util.ArrayList;

public class c
  extends b
{
  public d G;
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
  public View R;
  public e S;
  public a T;
  public c U;
  public b V;
  public final f W = new f();
  public int X;
  
  public c(Context paramContext)
  {
    super(paramContext, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramj.getActionView();
    if ((localView == null) || (paramj.c())) {
      localView = super.a(paramj, paramView, paramViewGroup);
    }
    int i;
    if (C) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramView = (ActionMenuView)paramViewGroup;
    paramj = localView.getLayoutParams();
    if (!paramView.checkLayoutParams(paramj)) {
      localView.setLayoutParams(paramView.generateLayoutParams(paramj));
    }
    return localView;
  }
  
  public void a(Context paramContext, h paramh)
  {
    y = paramContext;
    LayoutInflater.from(paramContext);
    z = paramh;
    paramh = paramContext.getResources();
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
        paramContext = new d(x);
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
    R = null;
  }
  
  public void a(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof g)) {
      return;
    }
    int i = x;
    if (i > 0)
    {
      paramParcelable = z.findItem(i);
      if (paramParcelable != null) {
        a((t)paramParcelable.getSubMenu());
      }
    }
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    a();
    o.a locala = B;
    if (locala != null) {
      locala.a(paramh, paramBoolean);
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
      ((h)localObject1).a();
      localObject2 = i;
      j = ((ArrayList)localObject2).size();
      for (k = 0; k < j; k++) {
        localObject1 = getA;
      }
    }
    localObject1 = z;
    if (localObject1 != null)
    {
      ((h)localObject1).a();
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
        G = new d(x);
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
        localObject2 = ((ImageView)localObject1).getParent();
        localObject1 = E;
        if (localObject2 == localObject1) {
          ((ViewGroup)localObject1).removeView(G);
        }
      }
    }
    ((ActionMenuView)E).setOverflowReserved(J);
  }
  
  public boolean a()
  {
    return b() | e();
  }
  
  public boolean a(t paramt)
  {
    boolean bool1 = paramt.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject1 = paramt;; localObject1 = (t)localObject2)
    {
      localObject2 = A;
      if (localObject2 == z) {
        break;
      }
    }
    j localj = B;
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
        if (((localObject1 instanceof p.a)) && (((p.a)localObject1).getItemData() == localj)) {
          break;
        }
      }
    }
    if (localObject1 == null) {
      return false;
    }
    X = B.getItemId();
    int i = paramt.size();
    for (int j = 0;; j++)
    {
      bool1 = bool2;
      if (j >= i) {
        break;
      }
      localObject2 = paramt.getItem(j);
      if ((((MenuItem)localObject2).isVisible()) && (((MenuItem)localObject2).getIcon() != null))
      {
        bool1 = true;
        break;
      }
    }
    localObject1 = new a(y, paramt, (View)localObject1);
    T = ((a)localObject1);
    h = bool1;
    localObject1 = j;
    if (localObject1 != null) {
      ((m)localObject1).b(bool1);
    }
    if (T.d())
    {
      localObject1 = B;
      if (localObject1 != null) {
        ((o.a)localObject1).a(paramt);
      }
      return true;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean b()
  {
    c localc = U;
    if (localc != null)
    {
      localObject = E;
      if (localObject != null)
      {
        ((View)localObject).removeCallbacks(localc);
        U = null;
        return true;
      }
    }
    Object localObject = S;
    if (localObject != null)
    {
      if (((d.b.d.i.n)localObject).b()) {
        j.dismiss();
      }
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    Object localObject1 = z;
    int i = 0;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).d();
      j = ((ArrayList)localObject1).size();
    }
    else
    {
      localObject1 = null;
      j = 0;
    }
    int k = N;
    int n = M;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)E;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    while (i2 < j)
    {
      localObject2 = (j)((ArrayList)localObject1).get(i2);
      if ((y & 0x2) == 2) {
        i6 = 1;
      } else {
        i6 = 0;
      }
      if (i6 != 0)
      {
        i5++;
      }
      else
      {
        if ((y & 0x1) == 1) {
          i6 = 1;
        } else {
          i6 = 0;
        }
        if (i6 != 0) {
          i4++;
        } else {
          i3 = 1;
        }
      }
      i6 = k;
      if (O)
      {
        i6 = k;
        if (C) {
          i6 = 0;
        }
      }
      i2++;
      k = i6;
    }
    i2 = k;
    if (J) {
      if (i3 == 0)
      {
        i2 = k;
        if (i4 + i5 <= k) {}
      }
      else
      {
        i2 = k - 1;
      }
    }
    i5 = i2 - i5;
    Object localObject2 = Q;
    ((SparseBooleanArray)localObject2).clear();
    int i6 = 0;
    k = 0;
    i4 = n;
    while (i6 < j)
    {
      j localj = (j)((ArrayList)localObject1).get(i6);
      if ((y & 0x2) == 2) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      Object localObject3;
      if (i2 != 0)
      {
        localObject3 = a(localj, R, localViewGroup);
        if (R == null) {
          R = ((View)localObject3);
        }
        ((View)localObject3).measure(i1, i1);
        i3 = ((View)localObject3).getMeasuredWidth();
        i4 -= i3;
        i2 = k;
        if (k == 0) {
          i2 = i3;
        }
        k = b;
        if (k != 0) {
          ((SparseBooleanArray)localObject2).put(k, true);
        }
        localj.c(true);
        k = i2;
      }
      else
      {
        if ((y & 0x1) == 1) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (i2 != 0)
        {
          int i7 = b;
          boolean bool = ((SparseBooleanArray)localObject2).get(i7);
          if (((i5 > 0) || (bool)) && (i4 > 0)) {
            i = 1;
          } else {
            i = 0;
          }
          i3 = i4;
          i2 = k;
          int i8 = i;
          if (i != 0)
          {
            localObject3 = a(localj, R, localViewGroup);
            if (R == null) {
              R = ((View)localObject3);
            }
            ((View)localObject3).measure(i1, i1);
            n = ((View)localObject3).getMeasuredWidth();
            i3 = i4 - n;
            i2 = k;
            if (k == 0) {
              i2 = n;
            }
            if (i3 + i2 > 0) {
              k = 1;
            } else {
              k = 0;
            }
            i8 = i & k;
          }
          if ((i8 != 0) && (i7 != 0))
          {
            ((SparseBooleanArray)localObject2).put(i7, true);
            k = i5;
          }
          else
          {
            k = i5;
            if (bool)
            {
              ((SparseBooleanArray)localObject2).put(i7, false);
              i4 = 0;
              for (;;)
              {
                k = i5;
                if (i4 >= i6) {
                  break;
                }
                localObject3 = (j)((ArrayList)localObject1).get(i4);
                k = i5;
                if (b == i7)
                {
                  k = i5;
                  if (((j)localObject3).d()) {
                    m = i5 + 1;
                  }
                  ((j)localObject3).c(false);
                }
                i4++;
                i5 = m;
              }
            }
          }
          i5 = m;
          if (i8 != 0) {
            i5 = m - 1;
          }
          localj.c(i8);
          i = 0;
          i4 = i3;
          int m = i2;
        }
        else
        {
          localj.c(i);
        }
      }
      i6++;
    }
    return true;
  }
  
  public Parcelable d()
  {
    g localg = new g();
    x = X;
    return localg;
  }
  
  public boolean e()
  {
    a locala = T;
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
    e locale = S;
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
      if ((localObject != null) && (E != null) && (U == null))
      {
        ((h)localObject).a();
        if (!j.isEmpty())
        {
          localObject = new c(new e(y, z, G, true));
          U = ((c)localObject);
          ((View)E).post((Runnable)localObject);
          super.a(null);
          return true;
        }
      }
    }
    return false;
  }
  
  public class a
    extends d.b.d.i.n
  {
    public a(Context paramContext, t paramt, View paramView)
    {
      super(paramt, paramView, false, R.attr.actionOverflowMenuStyle, 0);
      if (!B.d())
      {
        paramt = G;
        paramContext = paramt;
        if (paramt == null) {
          paramContext = (View)E;
        }
        f = paramContext;
      }
      a(W);
    }
    
    public void c()
    {
      c localc = c.this;
      T = null;
      X = 0;
      super.c();
    }
  }
  
  public class b
    extends ActionMenuItemView.b
  {
    public b() {}
  }
  
  public class c
    implements Runnable
  {
    public c.e x;
    
    public c(c.e parame)
    {
      x = parame;
    }
    
    public void run()
    {
      h localh = z;
      if (localh != null)
      {
        localObject = e;
        if (localObject != null) {
          ((h.a)localObject).a(localh);
        }
      }
      Object localObject = (View)E;
      if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (x.d())) {
        S = x;
      }
      U = null;
    }
  }
  
  public class d
    extends n
    implements ActionMenuView.a
  {
    public d(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
      s.a(this, getContentDescription());
      setOnTouchListener(new a(this, c.this));
    }
    
    public boolean a()
    {
      return false;
    }
    
    public boolean c()
    {
      return false;
    }
    
    public boolean performClick()
    {
      if (super.performClick()) {
        return true;
      }
      playSoundEffect(0);
      g();
      return true;
    }
    
    public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      Drawable localDrawable1 = getDrawable();
      Drawable localDrawable2 = getBackground();
      if ((localDrawable1 != null) && (localDrawable2 != null))
      {
        int i = getWidth();
        paramInt4 = getHeight();
        paramInt1 = Math.max(i, paramInt4) / 2;
        int j = getPaddingLeft();
        int k = getPaddingRight();
        paramInt3 = getPaddingTop();
        paramInt2 = getPaddingBottom();
        i = (i + (j - k)) / 2;
        paramInt2 = (paramInt4 + (paramInt3 - paramInt2)) / 2;
        localDrawable2.setHotspotBounds(i - paramInt1, paramInt2 - paramInt1, i + paramInt1, paramInt2 + paramInt1);
      }
      return bool;
    }
    
    public class a
      extends f0
    {
      public a(View paramView, c paramc)
      {
        super();
      }
      
      public r b()
      {
        c.e locale = S;
        if (locale == null) {
          return null;
        }
        return locale.a();
      }
      
      public boolean c()
      {
        g();
        return true;
      }
      
      public boolean d()
      {
        c localc = c.this;
        if (U != null) {
          return false;
        }
        localc.b();
        return true;
      }
    }
  }
  
  public class e
    extends d.b.d.i.n
  {
    public e(Context paramContext, h paramh, View paramView, boolean paramBoolean)
    {
      super(paramh, paramView, paramBoolean, R.attr.actionOverflowMenuStyle, 0);
      g = 8388613;
      a(W);
    }
    
    public void c()
    {
      h localh = z;
      if (localh != null) {
        localh.a(true);
      }
      S = null;
      super.c();
    }
  }
  
  public class f
    implements o.a
  {
    public f() {}
    
    public void a(h paramh, boolean paramBoolean)
    {
      if ((paramh instanceof t)) {
        paramh.c().a(false);
      }
      o.a locala = B;
      if (locala != null) {
        locala.a(paramh, paramBoolean);
      }
    }
    
    public boolean a(h paramh)
    {
      boolean bool = false;
      if (paramh == null) {
        return false;
      }
      X = B.getItemId();
      o.a locala = B;
      if (locala != null) {
        bool = locala.a(paramh);
      }
      return bool;
    }
  }
  
  public static class g
    implements Parcelable
  {
    public static final Parcelable.Creator<g> CREATOR = new a();
    public int x;
    
    public g() {}
    
    public g(Parcel paramParcel)
    {
      x = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(x);
    }
    
    public static final class a
      implements Parcelable.Creator<c.g>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new c.g(paramParcel);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new c.g[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */