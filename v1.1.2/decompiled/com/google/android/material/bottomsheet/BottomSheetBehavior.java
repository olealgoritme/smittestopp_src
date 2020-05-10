package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import com.google.android.material.R.dimen;
import com.google.android.material.R.styleable;
import d.b.a.s;
import d.i.i.n;
import d.k.b.a.c;
import e.c.a.b.e.b.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.c<V>
{
  public boolean a = true;
  public float b;
  public int c;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public boolean j;
  public boolean k;
  public int l = 4;
  public d.k.b.a m;
  public boolean n;
  public int o;
  public boolean p;
  public int q;
  public WeakReference<V> r;
  public WeakReference<View> s;
  public b t;
  public VelocityTracker u;
  public int v;
  public int w;
  public boolean x;
  public Map<View, Integer> y;
  public final a.c z = new a();
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
    int i1;
    if (localTypedValue != null)
    {
      i1 = data;
      if (i1 == -1)
      {
        b(i1);
        break label82;
      }
    }
    b(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    label82:
    j = paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true);
    if (a != bool)
    {
      a = bool;
      if (r != null) {
        a();
      }
      if ((a) && (l == 6)) {
        i1 = 3;
      } else {
        i1 = l;
      }
      c(i1);
    }
    k = paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
    paramAttributeSet.recycle();
    b = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  public Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new c(View.BaseSavedState.EMPTY_STATE, l);
  }
  
  public View a(View paramView)
  {
    if (n.u(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = 0;
      int i2 = localViewGroup.getChildCount();
      while (i1 < i2)
      {
        paramView = a(localViewGroup.getChildAt(i1));
        if (paramView != null) {
          return paramView;
        }
        i1++;
      }
    }
    return null;
  }
  
  public final void a()
  {
    if (a) {
      i = Math.max(q - f, g);
    } else {
      i = (q - f);
    }
  }
  
  public void a(int paramInt)
  {
    if ((View)r.get() != null)
    {
      Object localObject = t;
      if (localObject != null) {
        if (paramInt > i) {
          localObject = (b.d)localObject;
        } else {
          localObject = (b.d)localObject;
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    int i1;
    int i2;
    if (paramInt == 4)
    {
      i1 = i;
      i2 = paramInt;
    }
    else if (paramInt == 6)
    {
      int i3 = h;
      i1 = i3;
      i2 = paramInt;
      if (a)
      {
        int i4 = g;
        i1 = i3;
        i2 = paramInt;
        if (i3 <= i4)
        {
          i2 = 3;
          i1 = i4;
        }
      }
    }
    else if (paramInt == 3)
    {
      i1 = b();
      i2 = paramInt;
    }
    else
    {
      if ((!j) || (paramInt != 5)) {
        break label151;
      }
      i1 = q;
      i2 = paramInt;
    }
    if (m.a(paramView, paramView.getLeft(), i1))
    {
      c(2);
      n.a(paramView, new d(paramView, i2));
    }
    else
    {
      c(i2);
    }
    return;
    label151:
    throw new IllegalArgumentException(e.a.a.a.a.a("Illegal state argument: ", paramInt));
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramV = (c)paramParcelable;
    paramCoordinatorLayout = x;
    int i1 = z;
    if ((i1 != 1) && (i1 != 2)) {
      l = i1;
    } else {
      l = 4;
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    int i1 = paramV.getTop();
    paramInt = b();
    int i2 = 3;
    if (i1 == paramInt)
    {
      c(3);
      return;
    }
    if ((paramView == s.get()) && (p))
    {
      if (o > 0)
      {
        paramInt = b();
      }
      else
      {
        if (j)
        {
          paramCoordinatorLayout = u;
          float f1;
          if (paramCoordinatorLayout == null)
          {
            f1 = 0.0F;
          }
          else
          {
            paramCoordinatorLayout.computeCurrentVelocity(1000, b);
            f1 = u.getYVelocity(v);
          }
          if (a(paramV, f1))
          {
            paramInt = q;
            i2 = 5;
            break label289;
          }
        }
        if (o == 0)
        {
          paramInt = paramV.getTop();
          if (a)
          {
            if (Math.abs(paramInt - g) < Math.abs(paramInt - i))
            {
              paramInt = g;
              break label289;
            }
            paramInt = i;
          }
          else
          {
            i1 = h;
            if (paramInt < i1)
            {
              if (paramInt < Math.abs(paramInt - i))
              {
                paramInt = 0;
                break label289;
              }
              paramInt = h;
            }
            else
            {
              if (Math.abs(paramInt - i1) >= Math.abs(paramInt - i)) {
                break label271;
              }
              paramInt = h;
            }
            i2 = 6;
            break label289;
            label271:
            paramInt = i;
          }
        }
        else
        {
          paramInt = i;
        }
        i2 = 4;
      }
      label289:
      if (m.a(paramV, paramV.getLeft(), paramInt))
      {
        c(2);
        n.a(paramV, new d(paramV, i2));
      }
      else
      {
        c(i2);
      }
      p = false;
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    if (paramView != (View)s.get()) {
      return;
    }
    paramInt3 = paramV.getTop();
    paramInt1 = paramInt3 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt1 < b())
      {
        paramArrayOfInt[1] = (paramInt3 - b());
        n.d(paramV, -paramArrayOfInt[1]);
        c(3);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        n.d(paramV, -paramInt2);
        c(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1)))
    {
      int i1 = i;
      if ((paramInt1 > i1) && (!j))
      {
        paramArrayOfInt[1] = (paramInt3 - i1);
        n.d(paramV, -paramArrayOfInt[1]);
        c(4);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        n.d(paramV, -paramInt2);
        c(1);
      }
    }
    a(paramV.getTop());
    o = paramInt2;
    p = true;
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = r;
    if (localObject == null) {
      return;
    }
    localObject = ((View)((WeakReference)localObject).get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int i1 = ((ViewGroup)localObject).getChildCount();
    if (paramBoolean) {
      if (y == null) {
        y = new HashMap(i1);
      } else {
        return;
      }
    }
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = ((ViewGroup)localObject).getChildAt(i2);
      if (localView != r.get()) {
        if (!paramBoolean)
        {
          Map localMap = y;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            n.e(localView, ((Integer)y.get(localView)).intValue());
          }
        }
        else
        {
          y.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          n.e(localView, 4);
        }
      }
    }
    if (!paramBoolean) {
      y = null;
    }
  }
  
  public boolean a(View paramView, float paramFloat)
  {
    boolean bool1 = k;
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    if (paramView.getTop() < i) {
      return false;
    }
    if (Math.abs(paramFloat * 0.1F + paramView.getTop() - i) / c <= 0.5F) {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((n.g(paramCoordinatorLayout)) && (!paramV.getFitsSystemWindows())) {
      paramV.setFitsSystemWindows(true);
    }
    int i1 = paramV.getTop();
    paramCoordinatorLayout.b(paramV, paramInt);
    q = paramCoordinatorLayout.getHeight();
    if (d)
    {
      if (e == 0) {
        e = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      }
      f = Math.max(e, q - paramCoordinatorLayout.getWidth() * 9 / 16);
    }
    else
    {
      f = c;
    }
    g = Math.max(0, q - paramV.getHeight());
    h = (q / 2);
    a();
    paramInt = l;
    if (paramInt == 3)
    {
      n.d(paramV, b());
    }
    else if (paramInt == 6)
    {
      n.d(paramV, h);
    }
    else if ((j) && (paramInt == 5))
    {
      n.d(paramV, q);
    }
    else
    {
      paramInt = l;
      if (paramInt == 4) {
        n.d(paramV, i);
      } else if ((paramInt == 1) || (paramInt == 2)) {
        n.d(paramV, i1 - paramV.getTop());
      }
    }
    if (m == null)
    {
      a.c localc = z;
      m = new d.k.b.a(paramCoordinatorLayout.getContext(), paramCoordinatorLayout, localc);
    }
    r = new WeakReference(paramV);
    s = new WeakReference(a(paramV));
    return true;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool1 = paramV.isShown();
    boolean bool2 = false;
    if (!bool1)
    {
      n = true;
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    Object localObject1 = null;
    if (i1 == 0)
    {
      v = -1;
      localObject2 = u;
      if (localObject2 != null)
      {
        ((VelocityTracker)localObject2).recycle();
        u = null;
      }
    }
    if (u == null) {
      u = VelocityTracker.obtain();
    }
    u.addMovement(paramMotionEvent);
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3))
      {
        x = false;
        v = -1;
        if (n)
        {
          n = false;
          return false;
        }
      }
    }
    else
    {
      int i2 = (int)paramMotionEvent.getX();
      w = ((int)paramMotionEvent.getY());
      localObject2 = s;
      if (localObject2 != null) {
        localObject2 = (View)((WeakReference)localObject2).get();
      } else {
        localObject2 = null;
      }
      if ((localObject2 != null) && (paramCoordinatorLayout.a((View)localObject2, i2, w)))
      {
        v = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        x = true;
      }
      if ((v == -1) && (!paramCoordinatorLayout.a(paramV, i2, w))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      n = bool1;
    }
    if (!n)
    {
      paramV = m;
      if ((paramV != null) && (paramV.c(paramMotionEvent))) {
        return true;
      }
    }
    Object localObject2 = s;
    paramV = (V)localObject1;
    if (localObject2 != null) {
      paramV = (View)((WeakReference)localObject2).get();
    }
    bool1 = bool2;
    if (i1 == 2)
    {
      bool1 = bool2;
      if (paramV != null)
      {
        bool1 = bool2;
        if (!n)
        {
          bool1 = bool2;
          if (l != 1)
          {
            bool1 = bool2;
            if (!paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
            {
              bool1 = bool2;
              if (m != null)
              {
                bool1 = bool2;
                if (Math.abs(w - paramMotionEvent.getY()) > m.b) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool;
    if ((paramView == s.get()) && (l != 3)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    o = 0;
    p = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final int b()
  {
    int i1;
    if (a) {
      i1 = g;
    } else {
      i1 = 0;
    }
    return i1;
  }
  
  public final void b(int paramInt)
  {
    int i1 = 1;
    if (paramInt == -1)
    {
      if (!d)
      {
        d = true;
        paramInt = i1;
        break label73;
      }
    }
    else {
      if ((d) || (c != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label73;
    label47:
    d = false;
    c = Math.max(0, paramInt);
    i = (q - paramInt);
    paramInt = i1;
    label73:
    if ((paramInt != 0) && (l == 4))
    {
      Object localObject = r;
      if (localObject != null)
      {
        localObject = (View)((WeakReference)localObject).get();
        if (localObject != null) {
          ((View)localObject).requestLayout();
        }
      }
    }
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      return false;
    }
    int i1 = paramMotionEvent.getActionMasked();
    if ((l == 1) && (i1 == 0)) {
      return true;
    }
    paramCoordinatorLayout = m;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.a(paramMotionEvent);
    }
    if (i1 == 0)
    {
      v = -1;
      paramCoordinatorLayout = u;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        u = null;
      }
    }
    if (u == null) {
      u = VelocityTracker.obtain();
    }
    u.addMovement(paramMotionEvent);
    if ((i1 == 2) && (!n))
    {
      float f1 = Math.abs(w - paramMotionEvent.getY());
      paramCoordinatorLayout = m;
      if (f1 > b) {
        paramCoordinatorLayout.a(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    }
    return n ^ true;
  }
  
  public void c(int paramInt)
  {
    if (l == paramInt) {
      return;
    }
    l = paramInt;
    if ((paramInt != 6) && (paramInt != 3))
    {
      if ((paramInt == 5) || (paramInt == 4)) {
        a(false);
      }
    }
    else {
      a(true);
    }
    if ((View)r.get() != null)
    {
      Object localObject = t;
      if (localObject != null)
      {
        localObject = (b.d)localObject;
        if (localObject != null)
        {
          if (paramInt == 5) {
            a.cancel();
          }
        }
        else {
          throw null;
        }
      }
    }
  }
  
  public class a
    extends a.c
  {
    public a() {}
    
    public int a(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getLeft();
    }
    
    public void a(int paramInt)
    {
      if (paramInt == 1) {
        c(1);
      }
    }
    
    public void a(View paramView, float paramFloat1, float paramFloat2)
    {
      int i = 3;
      BottomSheetBehavior localBottomSheetBehavior;
      int j;
      int k;
      if (paramFloat2 < 0.0F)
      {
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if (a)
        {
          j = g;
          break label330;
        }
        k = paramView.getTop();
        j = h;
        if (k > j) {
          break label311;
        }
      }
      else
      {
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if ((j) && (localBottomSheetBehavior.a(paramView, paramFloat2)) && ((paramView.getTop() > BottomSheetBehavior.this.i) || (Math.abs(paramFloat1) < Math.abs(paramFloat2))))
        {
          j = q;
          i = 5;
          break label330;
        }
        if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
          j = BottomSheetBehavior.this.i;
        }
      }
      for (;;)
      {
        i = 4;
        break;
        j = paramView.getTop();
        localBottomSheetBehavior = BottomSheetBehavior.this;
        if (a)
        {
          if (Math.abs(j - g) < Math.abs(j - BottomSheetBehavior.this.i))
          {
            j = g;
            break;
          }
          j = BottomSheetBehavior.this.i;
        }
        else
        {
          k = h;
          if (j < k)
          {
            if (j < Math.abs(j - i))
            {
              j = 0;
              break;
            }
            j = h;
          }
          else
          {
            if (Math.abs(j - k) >= Math.abs(j - BottomSheetBehavior.this.i)) {
              break label318;
            }
            j = h;
          }
          label311:
          i = 6;
          break;
          label318:
          j = BottomSheetBehavior.this.i;
        }
      }
      label330:
      if (m.b(paramView.getLeft(), j))
      {
        c(2);
        n.a(paramView, new BottomSheetBehavior.d(BottomSheetBehavior.this, paramView, i));
      }
      else
      {
        c(i);
      }
    }
    
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      BottomSheetBehavior.this.a(paramInt2);
    }
    
    public int b(View paramView)
    {
      paramView = BottomSheetBehavior.this;
      if (j) {
        return q;
      }
      return i;
    }
    
    public int b(View paramView, int paramInt1, int paramInt2)
    {
      int i = b();
      paramView = BottomSheetBehavior.this;
      if (j) {
        paramInt2 = q;
      } else {
        paramInt2 = i;
      }
      return s.a(paramInt1, i, paramInt2);
    }
    
    public boolean b(View paramView, int paramInt)
    {
      Object localObject = BottomSheetBehavior.this;
      int i = l;
      boolean bool = true;
      if (i == 1) {
        return false;
      }
      if (x) {
        return false;
      }
      if ((i == 3) && (v == paramInt))
      {
        localObject = (View)s.get();
        if ((localObject != null) && (((View)localObject).canScrollVertically(-1))) {
          return false;
        }
      }
      localObject = r;
      if ((localObject == null) || (((WeakReference)localObject).get() != paramView)) {
        bool = false;
      }
      return bool;
    }
  }
  
  public static abstract class b {}
  
  public static class c
    extends d.k.a.a
  {
    public static final Parcelable.Creator<c> CREATOR = new a();
    public final int z;
    
    public c(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      z = paramParcel.readInt();
    }
    
    public c(Parcelable paramParcelable, int paramInt)
    {
      super();
      z = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeInt(z);
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.c>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new BottomSheetBehavior.c(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomSheetBehavior.c(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new BottomSheetBehavior.c[paramInt];
      }
    }
  }
  
  public class d
    implements Runnable
  {
    public final View x;
    public final int y;
    
    public d(View paramView, int paramInt)
    {
      x = paramView;
      y = paramInt;
    }
    
    public void run()
    {
      d.k.b.a locala = m;
      if ((locala != null) && (locala.a(true))) {
        n.a(x, this);
      } else {
        c(y);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */