package d.t.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.R.styleable;
import d.i.i.n;
import d.i.i.x.d;
import d.i.i.x.d.b;
import java.util.ArrayList;

public abstract class s$k
{
  public b a;
  public s b;
  public final x.b c = new s.k.a(this);
  public final x.b d = new s.k.b(this);
  public x e = new x(c);
  public x f = new x(d);
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public boolean j = true;
  public boolean k = true;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i1 != Integer.MIN_VALUE)
    {
      if (i1 != 1073741824) {
        paramInt1 = Math.max(paramInt2, paramInt3);
      }
      return paramInt1;
    }
    return Math.min(paramInt1, Math.max(paramInt2, paramInt3));
  }
  
  public static s.k.c a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    s.k.c localc = new s.k.c();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
    a = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
    b = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
    c = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
    d = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
    paramContext.recycle();
    return localc;
  }
  
  public int a(View paramView)
  {
    return ((s.l)paramView.getLayoutParams()).a();
  }
  
  public int a(s.q paramq, s.u paramu)
  {
    paramq = b;
    return 1;
  }
  
  public int a(s.u paramu)
  {
    return 0;
  }
  
  public View a(int paramInt)
  {
    Object localObject = a;
    if (localObject != null)
    {
      paramInt = ((b)localObject).c(paramInt);
      localObject = ((t)a).a(paramInt);
    }
    else
    {
      localObject = null;
    }
    return (View)localObject;
  }
  
  public s.l a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new s.l(paramContext, paramAttributeSet);
  }
  
  public s.l a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof s.l)) {
      return new s.l((s.l)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new s.l((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new s.l(paramLayoutParams);
  }
  
  public void a(int paramInt, s.q paramq)
  {
    View localView = a(paramInt);
    c(paramInt);
    paramq.a(localView);
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(View paramView, d paramd)
  {
    Object localObject = s.b(paramView);
    if ((localObject != null) && (!((s.x)localObject).n()) && (!a.b(a)))
    {
      localObject = b;
      a(y, C0, paramView, paramd);
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    s locals = b;
    Object localObject = y;
    localObject = C0;
    if ((locals != null) && (paramAccessibilityEvent != null))
    {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (!locals.canScrollVertically(1))
      {
        bool2 = bool1;
        if (!b.canScrollVertically(-1))
        {
          bool2 = bool1;
          if (!b.canScrollHorizontally(-1)) {
            if (b.canScrollHorizontally(1)) {
              bool2 = bool1;
            } else {
              bool2 = false;
            }
          }
        }
      }
      paramAccessibilityEvent.setScrollable(bool2);
    }
  }
  
  public void a(s.q paramq)
  {
    for (int i1 = d() - 1; i1 >= 0; i1--) {
      if (!s.b(a(i1)).u()) {
        a(i1, paramq);
      }
    }
  }
  
  public void a(s.q paramq, s.u paramu, View paramView, d paramd)
  {
    int i1;
    if (b()) {
      i1 = a(paramView);
    } else {
      i1 = 0;
    }
    int i2;
    if (a()) {
      i2 = a(paramView);
    } else {
      i2 = 0;
    }
    paramd.a(d.b.a(i1, 1, i2, 1, false, false));
  }
  
  public void a(s params) {}
  
  public void a(s params, int paramInt1, int paramInt2) {}
  
  public void a(s params, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(s params, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(s params, s.q paramq) {}
  
  public void a(String paramString)
  {
    s locals = b;
    if (locals != null) {
      locals.a(paramString);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(s.l paraml)
  {
    boolean bool;
    if (paraml != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(s params, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    int[] arrayOfInt = new int[2];
    int i1 = g();
    int i2 = i();
    int i3 = o;
    int i4 = h();
    int i5 = p;
    int i6 = f();
    int i7 = paramView.getLeft() + left - paramView.getScrollX();
    int i8 = paramView.getTop() + top - paramView.getScrollY();
    int i9 = paramRect.width();
    int i10 = paramRect.height();
    int i11 = i7 - i1;
    i1 = Math.min(0, i11);
    int i12 = i8 - i2;
    i2 = Math.min(0, i12);
    i9 = i9 + i7 - (i3 - i4);
    i3 = Math.max(0, i9);
    i6 = Math.max(0, i10 + i8 - (i5 - i6));
    if (e() == 1)
    {
      if (i3 != 0) {
        i1 = i3;
      } else {
        i1 = Math.max(i1, i9);
      }
    }
    else if (i1 == 0) {
      i1 = Math.min(i11, i3);
    }
    if (i2 == 0) {
      i2 = Math.min(i12, i6);
    }
    arrayOfInt[0] = i1;
    arrayOfInt[1] = i2;
    i3 = arrayOfInt[0];
    i2 = arrayOfInt[1];
    if (paramBoolean2)
    {
      paramRect = params.getFocusedChild();
      if (paramRect == null) {}
      do
      {
        i1 = 0;
        break;
        i1 = g();
        i11 = i();
        i6 = o;
        i5 = h();
        i12 = p;
        i10 = f();
        paramView = b.E;
        s.a(paramRect, paramView);
      } while ((left - i3 >= i6 - i5) || (right - i3 <= i1) || (top - i2 >= i12 - i10) || (bottom - i2 <= i11));
      i1 = 1;
      if (i1 == 0) {}
    }
    else
    {
      if ((i3 != 0) || (i2 != 0)) {
        break label392;
      }
    }
    return false;
    label392:
    if (paramBoolean1) {
      params.scrollBy(i3, i2);
    } else {
      params.c(i3, i2);
    }
    return true;
  }
  
  public int b(s.q paramq, s.u paramu)
  {
    paramq = b;
    return 1;
  }
  
  public int b(s.u paramu)
  {
    return 0;
  }
  
  public void b(int paramInt) {}
  
  public void b(s.q paramq)
  {
    int i1 = a.size();
    for (int i2 = i1 - 1; i2 >= 0; i2--)
    {
      View localView = a.get(i2)).a;
      s.x localx = s.b(localView);
      if (!localx.u())
      {
        localx.a(false);
        if (localx.p()) {
          b.removeDetachedView(localView, false);
        }
        s.h localh = b.k0;
        if (localh != null) {
          localh.b(localx);
        }
        localx.a(true);
        localx = s.b(localView);
        m = null;
        n = false;
        localx.b();
        paramq.a(localx);
      }
    }
    a.clear();
    paramq = b;
    if (paramq != null) {
      paramq.clear();
    }
    if (i1 > 0) {
      b.invalidate();
    }
  }
  
  public void b(s params)
  {
    if (params == null)
    {
      b = null;
      a = null;
      o = 0;
      p = 0;
    }
    else
    {
      b = params;
      a = B;
      o = params.getWidth();
      p = params.getHeight();
    }
    m = 1073741824;
    n = 1073741824;
  }
  
  public void b(s params, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    return false;
  }
  
  public int c(s.u paramu)
  {
    return 0;
  }
  
  public abstract s.l c();
  
  public void c(int paramInt)
  {
    if (a(paramInt) != null)
    {
      b localb = a;
      paramInt = localb.c(paramInt);
      View localView = ((t)a).a(paramInt);
      if (localView != null)
      {
        if (b.d(paramInt)) {
          localb.c(localView);
        }
        ((t)a).b(paramInt);
      }
    }
  }
  
  public int d()
  {
    b localb = a;
    int i1;
    if (localb != null) {
      i1 = localb.a();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int d(s.u paramu)
  {
    return 0;
  }
  
  public int e()
  {
    return n.i(b);
  }
  
  public int e(s.u paramu)
  {
    return 0;
  }
  
  public int f()
  {
    s locals = b;
    int i1;
    if (locals != null) {
      i1 = locals.getPaddingBottom();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int f(s.u paramu)
  {
    return 0;
  }
  
  public int g()
  {
    s locals = b;
    int i1;
    if (locals != null) {
      i1 = locals.getPaddingLeft();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int h()
  {
    s locals = b;
    int i1;
    if (locals != null) {
      i1 = locals.getPaddingRight();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int i()
  {
    s locals = b;
    int i1;
    if (locals != null) {
      i1 = locals.getPaddingTop();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public boolean j()
  {
    return i;
  }
  
  public Parcelable k()
  {
    return null;
  }
  
  public void l()
  {
    s locals = b;
    if (locals != null) {
      locals.requestLayout();
    }
  }
  
  public boolean m()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */