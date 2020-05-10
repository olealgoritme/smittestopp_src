package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import d.b.a.t;
import d.b.a.t.b;
import d.b.d.i.b;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.h.b;
import d.b.d.i.j;
import d.b.d.i.o.a;
import d.b.d.i.p;
import d.b.e.b1;
import d.b.e.c;
import d.b.e.c.d;
import d.b.e.g0;
import d.b.e.g0.a;
import d.b.e.n;
import e.a.a.a.a;

public class ActionMenuView
  extends g0
  implements h.b, p
{
  public h M;
  public Context N;
  public int O;
  public boolean P;
  public c Q;
  public o.a R;
  public h.a S;
  public boolean T;
  public int U;
  public int V;
  public int W;
  public e a0;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = getResourcesgetDisplayMetricsdensity;
    V = ((int)(56.0F * f));
    W = ((int)(f * 4.0F));
    N = paramContext;
    O = 0;
  }
  
  public static int b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c localc = (c)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.d())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, Integer.MIN_VALUE), i);
      int j = paramView.getMeasuredWidth();
      int k = j / paramInt1;
      paramInt2 = k;
      if (j % paramInt1 != 0) {
        paramInt2 = k + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((c) || (paramInt3 == 0)) {
      bool = false;
    }
    f = bool;
    d = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), i);
    return paramInt2;
  }
  
  public void a(h paramh)
  {
    M = paramh;
  }
  
  public boolean a(j paramj)
  {
    return M.a(paramj, null, 0);
  }
  
  public boolean b(int paramInt)
  {
    boolean bool1 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool2 = bool1;
    if (paramInt < getChildCount())
    {
      bool2 = bool1;
      if ((localView1 instanceof a)) {
        bool2 = false | ((a)localView1).a();
      }
    }
    bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if ((localView2 instanceof a)) {
        bool1 = bool2 | ((a)localView2).c();
      }
    }
    return bool1;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if ((paramLayoutParams != null) && ((paramLayoutParams instanceof c))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public c generateDefaultLayoutParams()
  {
    c localc = new c(-2, -2);
    b = 16;
    return localc;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new c(getContext(), paramAttributeSet);
  }
  
  public c generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof c)) {
        paramLayoutParams = new c((c)paramLayoutParams);
      } else {
        paramLayoutParams = new c(paramLayoutParams);
      }
      if (b <= 0) {
        b = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  public g0.a generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new c(getContext(), paramAttributeSet);
  }
  
  public Menu getMenu()
  {
    if (M == null)
    {
      Object localObject1 = getContext();
      Object localObject2 = new h((Context)localObject1);
      M = ((h)localObject2);
      e = new d();
      localObject1 = new c((Context)localObject1);
      Q = ((c)localObject1);
      J = true;
      K = true;
      localObject2 = R;
      if (localObject2 == null) {
        localObject2 = new b();
      }
      B = ((o.a)localObject2);
      M.a(Q, N);
      localObject2 = Q;
      E = this;
      M = z;
    }
    return M;
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    c localc = Q;
    Object localObject = G;
    if (localObject != null) {
      localObject = ((ImageView)localObject).getDrawable();
    } else if (I) {
      localObject = H;
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public int getPopupTheme()
  {
    return O;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = Q;
    if (paramConfiguration != null)
    {
      paramConfiguration.a(false);
      if (Q.f())
      {
        Q.b();
        Q.g();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c localc = Q;
    if (localc != null) {
      localc.a();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!T)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i = getChildCount();
    int j = (paramInt4 - paramInt2) / 2;
    int k = getDividerWidth();
    int m = paramInt3 - paramInt1;
    paramInt1 = m - getPaddingRight() - getPaddingLeft();
    paramBoolean = b1.a(this);
    paramInt3 = 0;
    paramInt4 = 0;
    paramInt2 = 0;
    Object localObject1;
    Object localObject2;
    int n;
    int i2;
    while (paramInt3 < i)
    {
      localObject1 = getChildAt(paramInt3);
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (c)((View)localObject1).getLayoutParams();
        if (c)
        {
          n = ((View)localObject1).getMeasuredWidth();
          paramInt4 = n;
          if (b(paramInt3)) {
            paramInt4 = n + k;
          }
          int i1 = ((View)localObject1).getMeasuredHeight();
          if (paramBoolean)
          {
            n = getPaddingLeft() + leftMargin;
            i2 = n + paramInt4;
          }
          else
          {
            i2 = getWidth() - getPaddingRight() - rightMargin;
            n = i2 - paramInt4;
          }
          int i3 = j - i1 / 2;
          ((View)localObject1).layout(n, i3, i2, i1 + i3);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        }
        else
        {
          paramInt1 -= ((View)localObject1).getMeasuredWidth() + leftMargin + rightMargin;
          b(paramInt3);
          paramInt2++;
        }
      }
      paramInt3++;
    }
    if ((i == 1) && (paramInt4 == 0))
    {
      localObject2 = getChildAt(0);
      paramInt2 = ((View)localObject2).getMeasuredWidth();
      paramInt1 = ((View)localObject2).getMeasuredHeight();
      paramInt3 = m / 2 - paramInt2 / 2;
      paramInt4 = j - paramInt1 / 2;
      ((View)localObject2).layout(paramInt3, paramInt4, paramInt2 + paramInt3, paramInt1 + paramInt4);
      return;
    }
    paramInt2 -= (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        localObject2 = getChildAt(paramInt1);
        localObject1 = (c)((View)localObject2).getLayoutParams();
        paramInt3 = paramInt2;
        if (((View)localObject2).getVisibility() != 8) {
          if (c)
          {
            paramInt3 = paramInt2;
          }
          else
          {
            n = paramInt2 - rightMargin;
            paramInt2 = ((View)localObject2).getMeasuredWidth();
            i2 = ((View)localObject2).getMeasuredHeight();
            paramInt3 = j - i2 / 2;
            ((View)localObject2).layout(n - paramInt2, paramInt3, n, i2 + paramInt3);
            paramInt3 = n - (paramInt2 + leftMargin + paramInt4);
          }
        }
        paramInt1++;
        paramInt2 = paramInt3;
      }
    }
    paramInt3 = getPaddingLeft();
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localObject2 = getChildAt(paramInt1);
      localObject1 = (c)((View)localObject2).getLayoutParams();
      paramInt2 = paramInt3;
      if (((View)localObject2).getVisibility() != 8) {
        if (c)
        {
          paramInt2 = paramInt3;
        }
        else
        {
          paramInt2 = paramInt3 + leftMargin;
          n = ((View)localObject2).getMeasuredWidth();
          i2 = ((View)localObject2).getMeasuredHeight();
          paramInt3 = j - i2 / 2;
          ((View)localObject2).layout(paramInt2, paramInt3, paramInt2 + n, i2 + paramInt3);
          paramInt2 = a.a(n, rightMargin, paramInt4, paramInt2);
        }
      }
      paramInt1++;
      paramInt3 = paramInt2;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = T;
    boolean bool2;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    T = bool2;
    if (bool1 != bool2) {
      U = 0;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    Object localObject1;
    if (T)
    {
      localObject1 = M;
      if ((localObject1 != null) && (i != U))
      {
        U = i;
        ((h)localObject1).b(true);
      }
    }
    int j = getChildCount();
    if ((T) && (j > 0))
    {
      int k = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i = View.MeasureSpec.getSize(paramInt2);
      int m = getPaddingLeft();
      j = getPaddingRight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom() + n;
      int i2 = ViewGroup.getChildMeasureSpec(paramInt2, i1, -2);
      int i3 = paramInt1 - (j + m);
      paramInt2 = V;
      paramInt1 = i3 / paramInt2;
      if (paramInt1 == 0)
      {
        setMeasuredDimension(i3, 0);
      }
      else
      {
        int i4 = i3 % paramInt2 / paramInt1 + paramInt2;
        int i5 = getChildCount();
        int i6 = 0;
        m = 0;
        int i7 = 0;
        paramInt2 = 0;
        int i8 = 0;
        j = 0;
        long l1 = 0L;
        Object localObject2;
        long l2;
        while (i8 < i5)
        {
          localObject1 = getChildAt(i8);
          if (((View)localObject1).getVisibility() != 8)
          {
            bool2 = localObject1 instanceof ActionMenuItemView;
            i6++;
            if (bool2)
            {
              n = W;
              ((View)localObject1).setPadding(n, 0, n, 0);
            }
            localObject2 = (c)((View)localObject1).getLayoutParams();
            h = false;
            e = 0;
            d = 0;
            f = false;
            leftMargin = 0;
            rightMargin = 0;
            if ((bool2) && (((ActionMenuItemView)localObject1).d())) {
              bool2 = true;
            } else {
              bool2 = false;
            }
            g = bool2;
            if (c) {
              n = 1;
            } else {
              n = paramInt1;
            }
            i9 = b((View)localObject1, i4, n, i2, i1);
            i7 = Math.max(i7, i9);
            n = paramInt2;
            if (f) {
              n = paramInt2 + 1;
            }
            if (c) {
              j = 1;
            }
            paramInt1 -= i9;
            m = Math.max(m, ((View)localObject1).getMeasuredHeight());
            l2 = l1;
            if (i9 == 1) {
              l2 = l1 | 1 << i8;
            }
            l1 = l2;
            paramInt2 = n;
          }
          i8++;
        }
        if ((j != 0) && (i6 == 2)) {
          n = 1;
        } else {
          n = 0;
        }
        int i9 = 0;
        i1 = paramInt2;
        i8 = paramInt1;
        paramInt2 = i9;
        paramInt1 = m;
        while ((i1 > 0) && (i8 > 0))
        {
          i9 = Integer.MAX_VALUE;
          int i10 = 0;
          int i11 = 0;
          long l3 = 0L;
          m = paramInt2;
          while (i10 < i5)
          {
            localObject1 = (c)getChildAt(i10).getLayoutParams();
            int i12;
            if (!f)
            {
              i12 = i9;
              paramInt2 = i11;
              l2 = l3;
            }
            else
            {
              int i13 = d;
              if (i13 < i9)
              {
                l2 = 1L << i10;
                i12 = i13;
                paramInt2 = 1;
              }
              else
              {
                i12 = i9;
                paramInt2 = i11;
                l2 = l3;
                if (i13 == i9)
                {
                  paramInt2 = i11 + 1;
                  l2 = l3 | 1L << i10;
                  i12 = i9;
                }
              }
            }
            i10++;
            i9 = i12;
            i11 = paramInt2;
            l3 = l2;
          }
          paramInt2 = paramInt1;
          paramInt1 = m;
          l1 |= l3;
          if (i11 > i8) {
            break label849;
          }
          for (paramInt1 = 0; paramInt1 < i5; paramInt1++)
          {
            localObject2 = getChildAt(paramInt1);
            localObject1 = (c)((View)localObject2).getLayoutParams();
            long l4 = 1 << paramInt1;
            if ((l3 & l4) == 0L)
            {
              l2 = l1;
              if (d == i9 + 1) {
                l2 = l1 | l4;
              }
              l1 = l2;
            }
            else
            {
              if ((n != 0) && (g) && (i8 == 1))
              {
                m = W;
                ((View)localObject2).setPadding(m + i4, 0, m, 0);
              }
              d += 1;
              h = true;
              i8--;
            }
          }
          paramInt1 = paramInt2;
          paramInt2 = 1;
        }
        m = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = m;
        label849:
        if ((j == 0) && (i6 == 1)) {
          m = 1;
        } else {
          m = 0;
        }
        j = paramInt1;
        if (i8 > 0)
        {
          j = paramInt1;
          if (l1 != 0L) {
            if ((i8 >= i6 - 1) && (m == 0))
            {
              j = paramInt1;
              if (i7 <= 1) {}
            }
            else
            {
              float f1 = Long.bitCount(l1);
              float f2 = f1;
              if (m == 0)
              {
                float f3 = f1;
                if ((l1 & 1L) != 0L)
                {
                  f3 = f1;
                  if (!getChildAt0getLayoutParamsg) {
                    f3 = f1 - 0.5F;
                  }
                }
                j = i5 - 1;
                f2 = f3;
                if ((l1 & 1 << j) != 0L)
                {
                  f2 = f3;
                  if (!getChildAtgetLayoutParamsg) {
                    f2 = f3 - 0.5F;
                  }
                }
              }
              if (f2 > 0.0F) {
                m = (int)(i8 * i4 / f2);
              } else {
                m = 0;
              }
              n = 0;
              for (;;)
              {
                j = paramInt1;
                if (n >= i5) {
                  break;
                }
                if ((l1 & 1 << n) == 0L)
                {
                  j = paramInt1;
                }
                else
                {
                  localObject1 = getChildAt(n);
                  localObject2 = (c)((View)localObject1).getLayoutParams();
                  if ((localObject1 instanceof ActionMenuItemView))
                  {
                    e = m;
                    h = true;
                    if ((n == 0) && (!g)) {
                      leftMargin = (-m / 2);
                    }
                  }
                  else
                  {
                    if (!c) {
                      break label1181;
                    }
                    e = m;
                    h = true;
                    rightMargin = (-m / 2);
                  }
                  j = 1;
                  break label1219;
                  label1181:
                  if (n != 0) {
                    leftMargin = (m / 2);
                  }
                  j = paramInt1;
                  if (n != i5 - 1)
                  {
                    rightMargin = (m / 2);
                    j = paramInt1;
                  }
                }
                label1219:
                n++;
                paramInt1 = j;
              }
            }
          }
        }
        if (j != 0) {
          for (paramInt1 = 0; paramInt1 < i5; paramInt1++)
          {
            localObject2 = getChildAt(paramInt1);
            localObject1 = (c)((View)localObject2).getLayoutParams();
            if (h) {
              ((View)localObject2).measure(View.MeasureSpec.makeMeasureSpec(d * i4 + e, 1073741824), i2);
            }
          }
        }
        if (k == 1073741824) {
          paramInt2 = i;
        }
        setMeasuredDimension(i3, paramInt2);
      }
    }
    else
    {
      for (i = 0; i < j; i++)
      {
        localObject1 = (c)getChildAt(i).getLayoutParams();
        rightMargin = 0;
        leftMargin = 0;
      }
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    Q.O = paramBoolean;
  }
  
  public void setOnMenuItemClickListener(e parame)
  {
    a0 = parame;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    c localc = Q;
    c.d locald = G;
    if (locald != null)
    {
      locald.setImageDrawable(paramDrawable);
    }
    else
    {
      I = true;
      H = paramDrawable;
    }
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    P = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (O != paramInt)
    {
      O = paramInt;
      if (paramInt == 0) {
        N = getContext();
      } else {
        N = new ContextThemeWrapper(getContext(), paramInt);
      }
    }
  }
  
  public void setPresenter(c paramc)
  {
    Q = paramc;
    E = this;
    M = z;
  }
  
  public static abstract interface a
  {
    public abstract boolean a();
    
    public abstract boolean c();
  }
  
  public static class b
    implements o.a
  {
    public void a(h paramh, boolean paramBoolean) {}
    
    public boolean a(h paramh)
    {
      return false;
    }
  }
  
  public static class c
    extends g0.a
  {
    @ViewDebug.ExportedProperty
    public boolean c;
    @ViewDebug.ExportedProperty
    public int d;
    @ViewDebug.ExportedProperty
    public int e;
    @ViewDebug.ExportedProperty
    public boolean f;
    @ViewDebug.ExportedProperty
    public boolean g;
    public boolean h;
    
    public c(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      c = false;
    }
    
    public c(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public c(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public c(c paramc)
    {
      super();
      c = c;
    }
  }
  
  public class d
    implements h.a
  {
    public d() {}
    
    public void a(h paramh)
    {
      h.a locala = S;
      if (locala != null) {
        locala.a(paramh);
      }
    }
    
    public boolean a(h paramh, MenuItem paramMenuItem)
    {
      paramh = a0;
      boolean bool1 = false;
      boolean bool2 = bool1;
      if (paramh != null)
      {
        paramh = a.g0;
        boolean bool3;
        if (paramh != null) {
          bool3 = a.c.onMenuItemSelected(0, paramMenuItem);
        } else {
          bool3 = false;
        }
        bool2 = bool1;
        if (bool3) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public static abstract interface e {}
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */