package androidx.recyclerview.widget;

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
import d.t.a.b;
import d.t.a.b.a;
import d.t.a.s;
import d.t.a.w;
import d.t.a.w.b;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager
{
  public b a;
  public RecyclerView b;
  public final w.b c = new a();
  public final w.b d = new b();
  public w e = new w(c);
  public w f = new w(d);
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
  
  public static Properties a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Properties localProperties = new Properties();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
    orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
    spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
    reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
    stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
    paramContext.recycle();
    return localProperties;
  }
  
  public int a(View paramView)
  {
    return ((RecyclerView.k)paramView.getLayoutParams()).a();
  }
  
  public int a(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    paramp = b;
    return 1;
  }
  
  public int a(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public View a(int paramInt)
  {
    Object localObject = a;
    if (localObject != null)
    {
      paramInt = ((b)localObject).c(paramInt);
      localObject = ((s)a).a(paramInt);
    }
    else
    {
      localObject = null;
    }
    return (View)localObject;
  }
  
  public RecyclerView.k a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new RecyclerView.k(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.k a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof RecyclerView.k)) {
      return new RecyclerView.k((RecyclerView.k)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new RecyclerView.k((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new RecyclerView.k(paramLayoutParams);
  }
  
  public void a(int paramInt, RecyclerView.p paramp)
  {
    View localView = a(paramInt);
    c(paramInt);
    paramp.a(localView);
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public void a(View paramView, d paramd)
  {
    Object localObject = RecyclerView.b(paramView);
    if ((localObject != null) && (!((RecyclerView.w)localObject).n()) && (!a.b(a)))
    {
      localObject = b;
      a(y, C0, paramView, paramd);
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    RecyclerView localRecyclerView = b;
    Object localObject = y;
    localObject = C0;
    if ((localRecyclerView != null) && (paramAccessibilityEvent != null))
    {
      boolean bool1 = true;
      boolean bool2 = bool1;
      if (!localRecyclerView.canScrollVertically(1))
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
  
  public void a(RecyclerView.p paramp)
  {
    for (int i1 = d() - 1; i1 >= 0; i1--) {
      if (!RecyclerView.b(a(i1)).u()) {
        a(i1, paramp);
      }
    }
  }
  
  public void a(RecyclerView.p paramp, RecyclerView.t paramt, View paramView, d paramd)
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
  
  public void a(RecyclerView paramRecyclerView) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.p paramp) {}
  
  public void a(String paramString)
  {
    RecyclerView localRecyclerView = b;
    if (localRecyclerView != null) {
      localRecyclerView.a(paramString);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(RecyclerView.k paramk)
  {
    boolean bool;
    if (paramk != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
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
    i7 = i9 + i7 - (i3 - i4);
    i9 = Math.max(0, i7);
    i6 = Math.max(0, i10 + i8 - (i5 - i6));
    if (e() == 1)
    {
      if (i9 != 0) {
        i1 = i9;
      } else {
        i1 = Math.max(i1, i7);
      }
    }
    else if (i1 == 0) {
      i1 = Math.min(i11, i9);
    }
    if (i2 == 0) {
      i2 = Math.min(i12, i6);
    }
    arrayOfInt[0] = i1;
    arrayOfInt[1] = i2;
    i2 = arrayOfInt[0];
    i9 = arrayOfInt[1];
    if (paramBoolean2)
    {
      paramRect = paramRecyclerView.getFocusedChild();
      if (paramRect == null) {}
      do
      {
        i1 = 0;
        break;
        i5 = g();
        i12 = i();
        i11 = o;
        i6 = h();
        i1 = p;
        i8 = f();
        paramView = b.E;
        RecyclerView.a(paramRect, paramView);
      } while ((left - i2 >= i11 - i6) || (right - i2 <= i5) || (top - i9 >= i1 - i8) || (bottom - i9 <= i12));
      i1 = 1;
      if (i1 == 0) {}
    }
    else
    {
      if ((i2 != 0) || (i9 != 0)) {
        break label392;
      }
    }
    return false;
    label392:
    if (paramBoolean1) {
      paramRecyclerView.scrollBy(i2, i9);
    } else {
      paramRecyclerView.c(i2, i9);
    }
    return true;
  }
  
  public int b(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    paramp = b;
    return 1;
  }
  
  public int b(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public void b(int paramInt) {}
  
  public void b(RecyclerView.p paramp)
  {
    int i1 = a.size();
    for (int i2 = i1 - 1; i2 >= 0; i2--)
    {
      View localView = a.get(i2)).a;
      RecyclerView.w localw = RecyclerView.b(localView);
      if (!localw.u())
      {
        localw.a(false);
        if (localw.p()) {
          b.removeDetachedView(localView, false);
        }
        RecyclerView.h localh = b.k0;
        if (localh != null) {
          localh.b(localw);
        }
        localw.a(true);
        localw = RecyclerView.b(localView);
        m = null;
        n = false;
        localw.b();
        paramp.a(localw);
      }
    }
    a.clear();
    paramp = b;
    if (paramp != null) {
      paramp.clear();
    }
    if (i1 > 0) {
      b.invalidate();
    }
  }
  
  public void b(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      b = null;
      a = null;
      o = 0;
      p = 0;
    }
    else
    {
      b = paramRecyclerView;
      a = B;
      o = paramRecyclerView.getWidth();
      p = paramRecyclerView.getHeight();
    }
    m = 1073741824;
    n = 1073741824;
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    return false;
  }
  
  public int c(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public abstract RecyclerView.k c();
  
  public void c(int paramInt)
  {
    if (a(paramInt) != null)
    {
      b localb = a;
      paramInt = localb.c(paramInt);
      View localView = ((s)a).a(paramInt);
      if (localView != null)
      {
        if (b.d(paramInt)) {
          localb.c(localView);
        }
        ((s)a).b(paramInt);
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
  
  public int d(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public int e()
  {
    return n.i(b);
  }
  
  public int e(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public int f()
  {
    RecyclerView localRecyclerView = b;
    int i1;
    if (localRecyclerView != null) {
      i1 = localRecyclerView.getPaddingBottom();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int f(RecyclerView.t paramt)
  {
    return 0;
  }
  
  public int g()
  {
    RecyclerView localRecyclerView = b;
    int i1;
    if (localRecyclerView != null) {
      i1 = localRecyclerView.getPaddingLeft();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int h()
  {
    RecyclerView localRecyclerView = b;
    int i1;
    if (localRecyclerView != null) {
      i1 = localRecyclerView.getPaddingRight();
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public int i()
  {
    RecyclerView localRecyclerView = b;
    int i1;
    if (localRecyclerView != null) {
      i1 = localRecyclerView.getPaddingTop();
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
    RecyclerView localRecyclerView = b;
    if (localRecyclerView != null) {
      localRecyclerView.requestLayout();
    }
  }
  
  public boolean m()
  {
    return false;
  }
  
  public static class Properties
  {
    public int orientation;
    public boolean reverseLayout;
    public int spanCount;
    public boolean stackFromEnd;
  }
  
  public class a
    implements w.b
  {
    public a() {}
    
    public int a()
    {
      RecyclerView.LayoutManager localLayoutManager = RecyclerView.LayoutManager.this;
      return o - localLayoutManager.h();
    }
    
    public int a(View paramView)
    {
      RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
      if (RecyclerView.LayoutManager.this != null) {
        return paramView.getLeft() - getLayoutParamsb.left - leftMargin;
      }
      throw null;
    }
    
    public View a(int paramInt)
    {
      return RecyclerView.LayoutManager.this.a(paramInt);
    }
    
    public int b()
    {
      return g();
    }
    
    public int b(View paramView)
    {
      RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
      if (RecyclerView.LayoutManager.this != null) {
        return paramView.getRight() + getLayoutParamsb.right + rightMargin;
      }
      throw null;
    }
  }
  
  public class b
    implements w.b
  {
    public b() {}
    
    public int a()
    {
      RecyclerView.LayoutManager localLayoutManager = RecyclerView.LayoutManager.this;
      return p - localLayoutManager.f();
    }
    
    public int a(View paramView)
    {
      RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
      if (RecyclerView.LayoutManager.this != null) {
        return paramView.getTop() - getLayoutParamsb.top - topMargin;
      }
      throw null;
    }
    
    public View a(int paramInt)
    {
      return RecyclerView.LayoutManager.this.a(paramInt);
    }
    
    public int b()
    {
      return i();
    }
    
    public int b(View paramView)
    {
      RecyclerView.k localk = (RecyclerView.k)paramView.getLayoutParams();
      if (RecyclerView.LayoutManager.this != null) {
        return paramView.getBottom() + getLayoutParamsb.bottom + bottomMargin;
      }
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.LayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */