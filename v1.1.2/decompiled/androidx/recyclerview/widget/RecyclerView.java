package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.R.dimen;
import androidx.recyclerview.R.styleable;
import d.i.i.g;
import d.i.i.n;
import d.i.i.r;
import d.i.i.x.d.b;
import d.t.a.a.b;
import d.t.a.b.a;
import d.t.a.c;
import d.t.a.e;
import d.t.a.f;
import d.t.a.k;
import d.t.a.k.a;
import d.t.a.k.b;
import d.t.a.l;
import d.t.a.m;
import d.t.a.m.b;
import d.t.a.s;
import d.t.a.t;
import d.t.a.u;
import d.t.a.v;
import d.t.a.w;
import d.t.a.w.b;
import d.t.a.x;
import d.t.a.x.a;
import d.t.a.x.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements d.i.i.d
{
  public static final int[] U0 = { 16843830 };
  public static final int[] V0 = { 16842987 };
  public static final boolean W0;
  public static final boolean X0;
  public static final boolean Y0;
  public static final boolean Z0;
  public static final Class<?>[] a1;
  public static final Interpolator b1 = new b();
  public d.t.a.a A;
  public m A0;
  public d.t.a.b B;
  public m.b B0;
  public final x C = new x();
  public final t C0;
  public boolean D;
  public n D0;
  public final Rect E = new Rect();
  public List<n> E0;
  public final Rect F = new Rect();
  public boolean F0;
  public final RectF G = new RectF();
  public boolean G0;
  public d H;
  public RecyclerView.h.b H0;
  public LayoutManager I;
  public boolean I0;
  public q J;
  public u J0;
  public final ArrayList<j> K = new ArrayList();
  public f K0;
  public final ArrayList<m> L = new ArrayList();
  public final int[] L0;
  public m M;
  public g M0;
  public boolean N;
  public final int[] N0;
  public boolean O;
  public final int[] O0;
  public boolean P;
  public final int[] P0;
  public boolean Q;
  public final int[] Q0;
  public int R = 0;
  public final List<w> R0;
  public boolean S;
  public Runnable S0;
  public boolean T;
  public final x.b T0;
  public boolean U;
  public int V;
  public boolean W;
  public final AccessibilityManager a0;
  public boolean b0 = false;
  public boolean c0 = false;
  public int d0 = 0;
  public int e0 = 0;
  public g f0 = new g();
  public EdgeEffect g0;
  public EdgeEffect h0;
  public EdgeEffect i0;
  public EdgeEffect j0;
  public h k0 = new k();
  public int l0 = 0;
  public int m0 = -1;
  public VelocityTracker n0;
  public int o0;
  public int p0;
  public int q0;
  public int r0;
  public int s0;
  public l t0;
  public final int u0;
  public final int v0;
  public float w0 = Float.MIN_VALUE;
  public final r x = new r();
  public float x0 = Float.MIN_VALUE;
  public final p y = new p();
  public boolean y0;
  public s z;
  public final v z0;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    W0 = bool;
    X0 = true;
    Y0 = false;
    Z0 = false;
    Class localClass = Integer.TYPE;
    a1 = new Class[] { Context.class, AttributeSet.class, localClass, localClass };
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool1 = true;
    y0 = true;
    z0 = new v();
    if (X0) {
      localObject1 = new m.b();
    } else {
      localObject1 = null;
    }
    B0 = ((m.b)localObject1);
    C0 = new t();
    F0 = false;
    G0 = false;
    H0 = new i();
    I0 = false;
    L0 = new int[2];
    N0 = new int[2];
    O0 = new int[2];
    P0 = new int[2];
    Q0 = new int[2];
    R0 = new ArrayList();
    S0 = new a();
    T0 = new c();
    if (paramAttributeSet != null)
    {
      localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, V0, paramInt, 0);
      D = ((TypedArray)localObject1).getBoolean(0, true);
      ((TypedArray)localObject1).recycle();
    }
    else
    {
      D = true;
    }
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject1 = ViewConfiguration.get(paramContext);
    s0 = ((ViewConfiguration)localObject1).getScaledTouchSlop();
    w0 = r.b((ViewConfiguration)localObject1, paramContext);
    float f;
    if (Build.VERSION.SDK_INT >= 26) {
      f = ((ViewConfiguration)localObject1).getScaledVerticalScrollFactor();
    } else {
      f = r.a((ViewConfiguration)localObject1, paramContext);
    }
    x0 = f;
    u0 = ((ViewConfiguration)localObject1).getScaledMinimumFlingVelocity();
    v0 = ((ViewConfiguration)localObject1).getScaledMaximumFlingVelocity();
    boolean bool2;
    if (getOverScrollMode() == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    k0.a = H0;
    A = new d.t.a.a(new t(this));
    B = new d.t.a.b(new s(this));
    if ((n.h(this) == 0) && (Build.VERSION.SDK_INT >= 26)) {
      setImportantForAutofill(8);
    }
    if (getImportantForAccessibility() == 0) {
      setImportantForAccessibility(1);
    }
    a0 = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new u(this));
    if (paramAttributeSet != null)
    {
      Object localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
      localObject1 = ((TypedArray)localObject2).getString(R.styleable.RecyclerView_layoutManager);
      if (((TypedArray)localObject2).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      bool2 = ((TypedArray)localObject2).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
      P = bool2;
      Object localObject3;
      Object localObject4;
      if (bool2)
      {
        localObject3 = (StateListDrawable)((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
        Drawable localDrawable1 = ((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
        StateListDrawable localStateListDrawable = (StateListDrawable)((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
        Drawable localDrawable2 = ((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
        if ((localObject3 != null) && (localDrawable1 != null) && (localStateListDrawable != null) && (localDrawable2 != null))
        {
          localObject4 = getContext().getResources();
          new l(this, (StateListDrawable)localObject3, localDrawable1, localStateListDrawable, localDrawable2, ((Resources)localObject4).getDimensionPixelSize(R.dimen.fastscroll_default_thickness), ((Resources)localObject4).getDimensionPixelSize(R.dimen.fastscroll_minimum_range), ((Resources)localObject4).getDimensionPixelOffset(R.dimen.fastscroll_margin));
        }
        else
        {
          throw new IllegalArgumentException(e.a.a.a.a.a(this, e.a.a.a.a.a("Trying to set fast scroller without both required drawables.")));
        }
      }
      ((TypedArray)localObject2).recycle();
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).trim();
        if (!((String)localObject1).isEmpty())
        {
          if (((String)localObject1).charAt(0) == '.')
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramContext.getPackageName());
            ((StringBuilder)localObject4).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject4).toString();
          }
          for (;;)
          {
            break;
            if (!((String)localObject1).contains("."))
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(RecyclerView.class.getPackage().getName());
              ((StringBuilder)localObject4).append('.');
              ((StringBuilder)localObject4).append((String)localObject1);
              localObject1 = ((StringBuilder)localObject4).toString();
            }
          }
          try
          {
            if (isInEditMode()) {
              localObject4 = getClass().getClassLoader();
            } else {
              localObject4 = paramContext.getClassLoader();
            }
            localObject2 = ((ClassLoader)localObject4).loadClass((String)localObject1).asSubclass(LayoutManager.class);
            try
            {
              localObject3 = ((Class)localObject2).getConstructor(a1);
              localObject4 = new Object[4];
              localObject4[0] = paramContext;
              localObject4[1] = paramAttributeSet;
              localObject4[2] = Integer.valueOf(paramInt);
              localObject4[3] = Integer.valueOf(0);
            }
            catch (NoSuchMethodException localNoSuchMethodException) {}
            Object localObject5;
            try
            {
              localObject3 = ((Class)localObject2).getConstructor(new Class[0]);
              localObject5 = null;
              ((Constructor)localObject3).setAccessible(true);
              setLayoutManager((LayoutManager)((Constructor)localObject3).newInstance((Object[])localObject5));
            }
            catch (NoSuchMethodException paramContext)
            {
              paramContext.initCause((Throwable)localObject5);
              localObject3 = new java/lang/IllegalStateException;
              localObject5 = new java/lang/StringBuilder;
              ((StringBuilder)localObject5).<init>();
              ((StringBuilder)localObject5).append(paramAttributeSet.getPositionDescription());
              ((StringBuilder)localObject5).append(": Error creating LayoutManager ");
              ((StringBuilder)localObject5).append((String)localObject1);
              ((IllegalStateException)localObject3).<init>(((StringBuilder)localObject5).toString(), paramContext);
              throw ((Throwable)localObject3);
            }
            StringBuilder localStringBuilder;
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, U0, paramInt, 0);
          }
          catch (ClassCastException paramContext)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(paramAttributeSet.getPositionDescription());
            ((StringBuilder)localObject5).append(": Class is not a LayoutManager ");
            ((StringBuilder)localObject5).append((String)localObject1);
            throw new IllegalStateException(((StringBuilder)localObject5).toString(), paramContext);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Cannot access non-public constructor ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localIllegalAccessException);
          }
          catch (InstantiationException paramContext)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAttributeSet.getPositionDescription());
            localStringBuilder.append(": Could not instantiate the LayoutManager: ");
            localStringBuilder.append((String)localObject1);
            throw new IllegalStateException(localStringBuilder.toString(), paramContext);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Could not instantiate the LayoutManager: ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localInvocationTargetException);
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Unable to find LayoutManager ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localClassNotFoundException);
          }
        }
      }
      bool2 = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    else
    {
      setDescendantFocusability(262144);
      bool2 = bool1;
    }
    setNestedScrollingEnabled(bool2);
  }
  
  public static void a(View paramView, Rect paramRect)
  {
    k localk = (k)paramView.getLayoutParams();
    Rect localRect = b;
    paramRect.set(paramView.getLeft() - left - leftMargin, paramView.getTop() - top - topMargin, paramView.getRight() + right + rightMargin, paramView.getBottom() + bottom + bottomMargin);
  }
  
  public static w b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsa;
  }
  
  public static void b(w paramw)
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      while (localObject != null)
      {
        if (localObject == a) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      b = null;
    }
  }
  
  private g getScrollingChildHelper()
  {
    if (M0 == null) {
      M0 = new g(this);
    }
    return M0;
  }
  
  public int a(w paramw)
  {
    boolean bool = paramw.b(524);
    int i = -1;
    int j = i;
    if (!bool) {
      if (!paramw.k())
      {
        j = i;
      }
      else
      {
        d.t.a.a locala = A;
        int k = c;
        int m = b.size();
        int n = 0;
        while (n < m)
        {
          paramw = (a.b)b.get(n);
          j = a;
          if (j != 1)
          {
            int i1;
            if (j != 2)
            {
              if (j != 8)
              {
                j = k;
              }
              else
              {
                j = b;
                if (j == k)
                {
                  j = d;
                }
                else
                {
                  i1 = k;
                  if (j < k) {
                    i1 = k - 1;
                  }
                  j = i1;
                  if (d <= i1) {
                    j = i1 + 1;
                  }
                }
              }
            }
            else
            {
              i1 = b;
              j = k;
              if (i1 <= k)
              {
                j = d;
                if (i1 + j > k)
                {
                  j = i;
                  break label254;
                }
                j = k - j;
              }
            }
          }
          else
          {
            j = k;
            if (b <= k) {
              j = k + d;
            }
          }
          n++;
          k = j;
        }
        j = k;
      }
    }
    label254:
    return j;
  }
  
  public View a(View paramView)
  {
    for (ViewParent localViewParent = paramView.getParent(); (localViewParent != null) && (localViewParent != this) && ((localViewParent instanceof View)); localViewParent = paramView.getParent()) {
      paramView = (View)localViewParent;
    }
    if (localViewParent != this) {
      paramView = null;
    }
    return paramView;
  }
  
  public final void a()
  {
    p();
    setScrollState(0);
  }
  
  public void a(int paramInt)
  {
    getScrollingChildHelper().c(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    EdgeEffect localEdgeEffect = g0;
    if ((localEdgeEffect != null) && (!localEdgeEffect.isFinished()) && (paramInt1 > 0))
    {
      g0.onRelease();
      bool1 = g0.isFinished();
    }
    else
    {
      bool1 = false;
    }
    localEdgeEffect = i0;
    boolean bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0)
        {
          i0.onRelease();
          bool2 = bool1 | i0.isFinished();
        }
      }
    }
    localEdgeEffect = h0;
    boolean bool1 = bool2;
    if (localEdgeEffect != null)
    {
      bool1 = bool2;
      if (!localEdgeEffect.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0)
        {
          h0.onRelease();
          bool1 = bool2 | h0.isFinished();
        }
      }
    }
    localEdgeEffect = j0;
    bool2 = bool1;
    if (localEdgeEffect != null)
    {
      bool2 = bool1;
      if (!localEdgeEffect.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0)
        {
          j0.onRelease();
          bool2 = bool1 | j0.isFinished();
        }
      }
    }
    if (bool2) {
      n.x(this);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt2;
    int j = B.b();
    w localw;
    int m;
    for (int k = 0; k < j; k++)
    {
      localw = b(B.d(k));
      if ((localw != null) && (!localw.u()))
      {
        m = c;
        if (m >= i)
        {
          localw.a(-paramInt2, paramBoolean);
          C0.f = true;
        }
        else if (m >= paramInt1)
        {
          localw.a(paramInt1 - 1, -paramInt2, paramBoolean);
          C0.f = true;
        }
      }
    }
    p localp = y;
    k = c.size();
    for (;;)
    {
      j = k - 1;
      if (j < 0) {
        break;
      }
      localw = (w)c.get(j);
      k = j;
      if (localw != null)
      {
        m = c;
        if (m >= i)
        {
          localw.a(-paramInt2, paramBoolean);
          k = j;
        }
        else
        {
          k = j;
          if (m >= paramInt1)
          {
            localw.a(8);
            localp.b(j);
            k = j;
          }
        }
      }
    }
    requestLayout();
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == m0)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      m0 = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      q0 = j;
      o0 = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      r0 = i;
      p0 = i;
    }
  }
  
  public final void a(View paramView1, View paramView2)
  {
    if (paramView2 != null) {
      localObject1 = paramView2;
    } else {
      localObject1 = paramView1;
    }
    E.set(0, 0, ((View)localObject1).getWidth(), ((View)localObject1).getHeight());
    Object localObject1 = ((View)localObject1).getLayoutParams();
    if ((localObject1 instanceof k))
    {
      localObject1 = (k)localObject1;
      if (!c)
      {
        localObject2 = b;
        localObject1 = E;
        left -= left;
        right += right;
        top -= top;
        bottom += bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, E);
      offsetRectIntoDescendantCoords(paramView1, E);
    }
    Object localObject2 = I;
    localObject1 = E;
    boolean bool1 = Q;
    boolean bool2;
    if (paramView2 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((LayoutManager)localObject2).a(this, paramView1, (Rect)localObject1, bool1 ^ true, bool2);
  }
  
  public void a(w paramw, RecyclerView.h.c paramc)
  {
    paramw.a(0, 8192);
    if ((C0.h) && (paramw.q()) && (!paramw.n()) && (!paramw.u())) {
      throw null;
    }
    C.a(paramw, paramc);
  }
  
  public void a(String paramString)
  {
    if (k())
    {
      if (paramString == null) {
        throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("Cannot call this method while RecyclerView is computing a layout or scrolling")));
      }
      throw new IllegalStateException(paramString);
    }
    if (e0 > 0) {
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a(""))));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = d0;
    int j = 1;
    i--;
    d0 = i;
    if (i < 1)
    {
      d0 = 0;
      if (paramBoolean)
      {
        i = V;
        V = 0;
        Object localObject;
        if (i != 0)
        {
          localObject = a0;
          if ((localObject == null) || (!((AccessibilityManager)localObject).isEnabled())) {
            j = 0;
          }
          if (j != 0)
          {
            localObject = AccessibilityEvent.obtain();
            ((AccessibilityEvent)localObject).setEventType(2048);
            ((AccessibilityEvent)localObject).setContentChangeTypes(i);
            sendAccessibilityEventUnchecked((AccessibilityEvent)localObject);
          }
        }
        for (j = R0.size() - 1; j >= 0; j--)
        {
          localObject = (w)R0.get(j);
          if ((a.getParent() == this) && (!((w)localObject).u()))
          {
            i = p;
            if (i != -1)
            {
              n.e(a, i);
              p = -1;
            }
          }
        }
        R0.clear();
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, null);
  }
  
  public boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    b();
    if (!K.isEmpty()) {
      invalidate();
    }
    boolean bool = a(0, 0, 0, 0, N0, 0);
    int i = 1;
    if (bool)
    {
      paramInt1 = q0;
      int[] arrayOfInt = N0;
      q0 = (paramInt1 - arrayOfInt[0]);
      r0 -= arrayOfInt[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      }
      arrayOfInt = P0;
      paramInt1 = arrayOfInt[0];
      paramMotionEvent = N0;
      arrayOfInt[0] = (paramInt1 + paramMotionEvent[0]);
      arrayOfInt[1] += paramMotionEvent[1];
    }
    else if (getOverScrollMode() != 2)
    {
      if (paramMotionEvent != null)
      {
        int j;
        if ((paramMotionEvent.getSource() & 0x2002) == 8194) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0)
        {
          float f1 = paramMotionEvent.getX();
          float f2 = 0;
          float f3 = paramMotionEvent.getY();
          float f4 = 0;
          if (f2 < 0.0F)
          {
            e();
            g0.onPull(-f2 / getWidth(), 1.0F - f3 / getHeight());
          }
          else
          {
            if (f2 <= 0.0F) {
              break label273;
            }
            f();
            i0.onPull(f2 / getWidth(), f3 / getHeight());
          }
          j = 1;
          break label276;
          label273:
          j = 0;
          label276:
          if (f4 < 0.0F)
          {
            g();
            h0.onPull(-f4 / getHeight(), f1 / getWidth());
            j = i;
          }
          else if (f4 > 0.0F)
          {
            d();
            j0.onPull(f4 / getHeight(), 1.0F - f1 / getWidth());
            j = i;
          }
          if ((j != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
            n.x(this);
          }
        }
      }
      a(paramInt1, paramInt2);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean a(w paramw, int paramInt)
  {
    if (k())
    {
      p = paramInt;
      R0.add(paramw);
      return false;
    }
    n.e(a, paramInt);
    return true;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    LayoutManager localLayoutManager = I;
    if ((localLayoutManager != null) && (localLayoutManager == null)) {
      throw null;
    }
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  public void b()
  {
    if ((Q) && (!b0))
    {
      if (!A.c()) {
        return;
      }
      int i = A.g;
      int j = 0;
      if ((i & 0x4) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((A.g & 0xB) != 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          d.i.e.b.a("RV PartialInvalidate");
          q();
          m();
          A.d();
          if (!S)
          {
            int k = B.a();
            int m;
            for (i = 0;; i++)
            {
              m = j;
              if (i >= k) {
                break;
              }
              w localw = b(B.b(i));
              if ((localw != null) && (!localw.u()) && (localw.q()))
              {
                m = 1;
                break;
              }
            }
            if (m != 0) {
              c();
            } else {
              A.a();
            }
          }
          b(true);
          a(true);
          Trace.endSection();
          break label232;
        }
      }
      if (A.c())
      {
        d.i.e.b.a("RV FullInvalidate");
        c();
        Trace.endSection();
      }
      label232:
      return;
    }
    d.i.e.b.a("RV FullInvalidate");
    c();
    Trace.endSection();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    i = LayoutManager.a(paramInt1, getPaddingRight() + i, n.k(this));
    paramInt1 = getPaddingTop();
    setMeasuredDimension(i, LayoutManager.a(paramInt2, getPaddingBottom() + paramInt1, getMinimumHeight()));
  }
  
  public void b(boolean paramBoolean)
  {
    if (R < 1) {
      R = 1;
    }
    if ((!paramBoolean) && (!T)) {
      S = false;
    }
    if (R == 1)
    {
      if ((paramBoolean) && (S) && (!T)) {
        LayoutManager localLayoutManager = I;
      }
      if (!T) {
        S = false;
      }
    }
    R -= 1;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    if (getScrollingChildHelper().a(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    Log.e("RecyclerView", "No adapter attached; skipping layout");
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    Object localObject1 = I;
    if (localObject1 == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    else if (!T)
    {
      if (!((LayoutManager)localObject1).a()) {
        paramInt1 = 0;
      }
      if (!I.b()) {
        paramInt2 = 0;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        localObject1 = z0;
        if (localObject1 == null) {
          break label372;
        }
        int i = Math.abs(paramInt1);
        int j = Math.abs(paramInt2);
        if (i > j) {
          k = 1;
        } else {
          k = 0;
        }
        int m = (int)Math.sqrt(0);
        int n = (int)Math.sqrt(paramInt2 * paramInt2 + paramInt1 * paramInt1);
        Object localObject2 = D;
        int i1;
        if (k != 0) {
          i1 = ((ViewGroup)localObject2).getWidth();
        } else {
          i1 = ((ViewGroup)localObject2).getHeight();
        }
        int i2 = i1 / 2;
        float f1 = n;
        float f2 = i1;
        float f3 = Math.min(1.0F, f1 * 1.0F / f2);
        f1 = i2;
        f3 = (float)Math.sin((f3 - 0.5F) * 0.47123894F);
        if (m > 0)
        {
          k = Math.round(Math.abs((f3 * f1 + f1) / m) * 1000.0F) * 4;
        }
        else
        {
          if (k != 0) {
            k = i;
          } else {
            k = j;
          }
          k = (int)((k / f2 + 1.0F) * 300.0F);
        }
        int k = Math.min(k, 2000);
        localObject2 = b1;
        if (A != localObject2)
        {
          A = ((Interpolator)localObject2);
          z = new OverScroller(D.getContext(), (Interpolator)localObject2);
        }
        D.setScrollState(2);
        y = 0;
        x = 0;
        z.startScroll(0, 0, paramInt1, paramInt2, k);
        if (Build.VERSION.SDK_INT < 23) {
          z.computeScrollOffset();
        }
        ((v)localObject1).a();
      }
    }
    return;
    label372:
    throw null;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof k)) && (I.a((k)paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int computeHorizontalScrollExtent()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.a()) {
      i = I.a(C0);
    }
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.a()) {
      i = I.b(C0);
    }
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.a()) {
      i = I.c(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.b()) {
      i = I.d(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.b()) {
      i = I.e(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    LayoutManager localLayoutManager = I;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (localLayoutManager.b()) {
      i = I.f(C0);
    }
    return i;
  }
  
  public void d()
  {
    if (j0 != null) {
      return;
    }
    EdgeEffect localEdgeEffect = f0.a(this);
    j0 = localEdgeEffect;
    if (D) {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public boolean d(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  public void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = K.size();
    int j = 0;
    int m;
    int i1;
    for (int k = 0;; k++)
    {
      m = 1;
      n = 1;
      if (k >= i) {
        break;
      }
      localObject = (l)K.get(k);
      if ((q == s.getWidth()) && (r == s.getHeight()))
      {
        if (A != 0)
        {
          int i2;
          if (t)
          {
            m = q;
            i1 = e;
            m -= i1;
            i2 = l;
            int i3 = k;
            i2 -= i3 / 2;
            c.setBounds(0, 0, i1, i3);
            d.setBounds(0, 0, f, r);
            if (n.i(s) != 1) {
              n = 0;
            }
            if (n != 0)
            {
              d.draw(paramCanvas);
              paramCanvas.translate(e, i2);
              paramCanvas.scale(-1.0F, 1.0F);
              c.draw(paramCanvas);
              paramCanvas.scale(1.0F, 1.0F);
              paramCanvas.translate(-e, -i2);
            }
            else
            {
              paramCanvas.translate(m, 0.0F);
              d.draw(paramCanvas);
              paramCanvas.translate(0.0F, i2);
              c.draw(paramCanvas);
              paramCanvas.translate(-m, -i2);
            }
          }
          if (u)
          {
            m = r;
            n = i;
            i1 = m - n;
            i2 = o;
            m = n;
            i2 -= m / 2;
            g.setBounds(0, 0, m, n);
            h.setBounds(0, 0, q, j);
            paramCanvas.translate(0.0F, i1);
            h.draw(paramCanvas);
            paramCanvas.translate(i2, 0.0F);
            g.draw(paramCanvas);
            paramCanvas.translate(-i2, -i1);
          }
        }
      }
      else
      {
        q = s.getWidth();
        r = s.getHeight();
        ((l)localObject).a(0);
      }
    }
    Object localObject = g0;
    if ((localObject != null) && (!((EdgeEffect)localObject).isFinished()))
    {
      i = paramCanvas.save();
      if (D) {
        k = getPaddingBottom();
      } else {
        k = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + k, 0.0F);
      localObject = g0;
      if ((localObject != null) && (((EdgeEffect)localObject).draw(paramCanvas))) {
        n = 1;
      } else {
        n = 0;
      }
      paramCanvas.restoreToCount(i);
    }
    else
    {
      n = 0;
    }
    localObject = h0;
    k = n;
    if (localObject != null)
    {
      k = n;
      if (!((EdgeEffect)localObject).isFinished())
      {
        i = paramCanvas.save();
        if (D) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        localObject = h0;
        if ((localObject != null) && (((EdgeEffect)localObject).draw(paramCanvas))) {
          k = 1;
        } else {
          k = 0;
        }
        k = n | k;
        paramCanvas.restoreToCount(i);
      }
    }
    localObject = i0;
    int n = k;
    if (localObject != null)
    {
      n = k;
      if (!((EdgeEffect)localObject).isFinished())
      {
        i = paramCanvas.save();
        i1 = getWidth();
        if (D) {
          n = getPaddingTop();
        } else {
          n = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-n, -i1);
        localObject = i0;
        if ((localObject != null) && (((EdgeEffect)localObject).draw(paramCanvas))) {
          n = 1;
        } else {
          n = 0;
        }
        n = k | n;
        paramCanvas.restoreToCount(i);
      }
    }
    localObject = j0;
    k = n;
    if (localObject != null)
    {
      k = n;
      if (!((EdgeEffect)localObject).isFinished())
      {
        i = paramCanvas.save();
        paramCanvas.rotate(180.0F);
        if (D)
        {
          k = -getWidth();
          float f = getPaddingRight() + k;
          k = -getHeight();
          paramCanvas.translate(f, getPaddingBottom() + k);
        }
        else
        {
          paramCanvas.translate(-getWidth(), -getHeight());
        }
        localObject = j0;
        k = j;
        if (localObject != null)
        {
          k = j;
          if (((EdgeEffect)localObject).draw(paramCanvas)) {
            k = 1;
          }
        }
        k = n | k;
        paramCanvas.restoreToCount(i);
      }
    }
    if ((k == 0) && (k0 != null) && (K.size() > 0) && (k0.c())) {
      k = m;
    }
    if (k != 0) {
      n.x(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void e()
  {
    if (g0 != null) {
      return;
    }
    EdgeEffect localEdgeEffect = f0.a(this);
    g0 = localEdgeEffect;
    if (D) {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
    }
  }
  
  public void f()
  {
    if (i0 != null) {
      return;
    }
    EdgeEffect localEdgeEffect = f0.a(this);
    i0 = localEdgeEffect;
    if (D) {
      localEdgeEffect.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
    } else {
      localEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
    }
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    if (I != null)
    {
      View localView = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (getFocusedChild() == null) {
          return super.focusSearch(paramView, paramInt);
        }
        a(localView, null);
        return paramView;
      }
      int i = 0;
      int j = i;
      if (localView != null) {
        if (localView == this)
        {
          j = i;
        }
        else if (a(localView) == null)
        {
          j = i;
        }
        else
        {
          if ((paramView != null) && (a(paramView) != null))
          {
            E.set(0, 0, paramView.getWidth(), paramView.getHeight());
            F.set(0, 0, localView.getWidth(), localView.getHeight());
            offsetDescendantRectToMyCoords(paramView, E);
            offsetDescendantRectToMyCoords(localView, F);
            int k = I.e();
            int m = -1;
            int n;
            if (k == 1) {
              n = -1;
            } else {
              n = 1;
            }
            Rect localRect = E;
            j = left;
            k = F.left;
            if (((j < k) || (right <= k)) && (E.right < F.right))
            {
              k = 1;
            }
            else
            {
              localRect = E;
              j = right;
              k = F.right;
              if (((j > k) || (left >= k)) && (E.left > F.left)) {
                k = -1;
              } else {
                k = 0;
              }
            }
            localRect = E;
            j = top;
            int i1 = F.top;
            if (((j < i1) || (bottom <= i1)) && (E.bottom < F.bottom))
            {
              m = 1;
            }
            else
            {
              localRect = E;
              j = bottom;
              i1 = F.bottom;
              if (((j <= i1) && (top < i1)) || (E.top <= F.top)) {
                m = 0;
              }
            }
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 17)
                {
                  if (paramInt != 33)
                  {
                    if (paramInt != 66)
                    {
                      if (paramInt == 130)
                      {
                        j = i;
                        if (m <= 0) {
                          break label612;
                        }
                      }
                      else
                      {
                        paramView = new StringBuilder();
                        paramView.append("Invalid direction: ");
                        paramView.append(paramInt);
                        throw new IllegalArgumentException(e.a.a.a.a.a(this, paramView));
                      }
                    }
                    else
                    {
                      j = i;
                      if (k <= 0) {
                        break label612;
                      }
                    }
                  }
                  else
                  {
                    j = i;
                    if (m >= 0) {
                      break label612;
                    }
                  }
                }
                else
                {
                  j = i;
                  if (k >= 0) {
                    break label612;
                  }
                }
              }
              else if (m <= 0)
              {
                j = i;
                if (m != 0) {
                  break label612;
                }
                j = i;
                if (k * n < 0) {
                  break label612;
                }
              }
            }
            else if (m >= 0)
            {
              j = i;
              if (m != 0) {
                break label612;
              }
              j = i;
              if (k * n > 0) {
                break label612;
              }
            }
          }
          j = 1;
        }
      }
      label612:
      if (j != 0) {
        paramView = localView;
      } else {
        paramView = super.focusSearch(paramView, paramInt);
      }
      return paramView;
    }
    throw null;
  }
  
  public void g()
  {
    if (h0 != null) {
      return;
    }
    EdgeEffect localEdgeEffect = f0.a(this);
    h0 = localEdgeEffect;
    if (D) {
      localEdgeEffect.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
    } else {
      localEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    LayoutManager localLayoutManager = I;
    if (localLayoutManager != null) {
      return localLayoutManager.c();
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    LayoutManager localLayoutManager = I;
    if (localLayoutManager != null) {
      return localLayoutManager.a(getContext(), paramAttributeSet);
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    LayoutManager localLayoutManager = I;
    if (localLayoutManager != null) {
      return localLayoutManager.a(paramLayoutParams);
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public d getAdapter()
  {
    return null;
  }
  
  public int getBaseline()
  {
    LayoutManager localLayoutManager = I;
    if (localLayoutManager != null)
    {
      if (localLayoutManager != null) {
        return -1;
      }
      throw null;
    }
    return super.getBaseline();
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    f localf = K0;
    if (localf == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localf.a(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return D;
  }
  
  public u getCompatAccessibilityDelegate()
  {
    return J0;
  }
  
  public g getEdgeEffectFactory()
  {
    return f0;
  }
  
  public h getItemAnimator()
  {
    return k0;
  }
  
  public int getItemDecorationCount()
  {
    return K.size();
  }
  
  public LayoutManager getLayoutManager()
  {
    return I;
  }
  
  public int getMaxFlingVelocity()
  {
    return v0;
  }
  
  public int getMinFlingVelocity()
  {
    return u0;
  }
  
  public long getNanoTime()
  {
    if (X0) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  public l getOnFlingListener()
  {
    return null;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return y0;
  }
  
  public o getRecycledViewPool()
  {
    return y.b();
  }
  
  public int getScrollState()
  {
    return l0;
  }
  
  public String h()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(null);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(I);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().b(0);
  }
  
  public boolean i()
  {
    boolean bool;
    if ((Q) && (!b0) && (!A.c())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isAttachedToWindow()
  {
    return N;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelperd;
  }
  
  public void j()
  {
    j0 = null;
    h0 = null;
    i0 = null;
    g0 = null;
  }
  
  public boolean k()
  {
    boolean bool;
    if (d0 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void l()
  {
    int i = B.b();
    int j = 0;
    for (int k = 0; k < i; k++) {
      B.d(k).getLayoutParams()).c = true;
    }
    p localp = y;
    i = c.size();
    for (k = j; k < i; k++)
    {
      k localk = (k)c.get(k)).a.getLayoutParams();
      if (localk != null) {
        c = true;
      }
    }
  }
  
  public void m()
  {
    d0 += 1;
  }
  
  public final void n()
  {
    boolean bool1 = b0;
    boolean bool2 = false;
    if (bool1)
    {
      localObject = A;
      ((d.t.a.a)localObject).a(b);
      ((d.t.a.a)localObject).a(c);
      g = 0;
      if (c0) {
        I.a(this);
      }
    }
    int i;
    if ((k0 != null) && (I.m())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      A.d();
    } else {
      A.b();
    }
    if ((!F0) && (!G0)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = C0;
    if ((Q) && (k0 != null) && ((b0) || (i != 0) || (I.g)))
    {
      if (!b0) {
        bool1 = true;
      } else {
        throw null;
      }
    }
    else {
      bool1 = false;
    }
    j = bool1;
    localObject = C0;
    bool1 = bool2;
    if (j)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (!b0)
        {
          if ((k0 != null) && (I.m())) {
            i = 1;
          } else {
            i = 0;
          }
          bool1 = bool2;
          if (i != 0) {
            bool1 = true;
          }
        }
      }
    }
    k = bool1;
  }
  
  public void o()
  {
    Object localObject = k0;
    if (localObject != null) {
      ((h)localObject).b();
    }
    localObject = I;
    if (localObject != null)
    {
      ((LayoutManager)localObject).a(y);
      I.b(y);
    }
    y.a();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d0 = 0;
    N = true;
    boolean bool;
    if ((Q) && (!isLayoutRequested())) {
      bool = true;
    } else {
      bool = false;
    }
    Q = bool;
    Object localObject = I;
    if (localObject != null) {
      h = true;
    }
    I0 = false;
    if (X0)
    {
      localObject = (m)m.B.get();
      A0 = ((m)localObject);
      if (localObject == null)
      {
        A0 = new m();
        localObject = n.e(this);
        float f1 = 60.0F;
        float f2 = f1;
        if (!isInEditMode())
        {
          f2 = f1;
          if (localObject != null)
          {
            float f3 = ((Display)localObject).getRefreshRate();
            f2 = f1;
            if (f3 >= 30.0F) {
              f2 = f3;
            }
          }
        }
        localObject = A0;
        z = ((1.0E9F / f2));
        m.B.set(localObject);
      }
      A0.x.add(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = k0;
    if (localObject != null) {
      ((h)localObject).b();
    }
    r();
    N = false;
    LayoutManager localLayoutManager = I;
    if (localLayoutManager != null)
    {
      localObject = y;
      h = false;
      localLayoutManager.a(this, (p)localObject);
    }
    R0.clear();
    removeCallbacks(S0);
    if (C != null)
    {
      while (x.a.d.a() != null) {}
      if (X0)
      {
        localObject = A0;
        if (localObject != null)
        {
          x.remove(this);
          A0 = null;
        }
      }
      return;
    }
    throw null;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = K.size();
    int j = 0;
    while (j < i) {
      if ((j)K.get(j) != null) {
        j++;
      } else {
        throw null;
      }
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (I == null) {
      return false;
    }
    if (T) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f2;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (I.b()) {
          f1 = -paramMotionEvent.getAxisValue(9);
        } else {
          f1 = 0.0F;
        }
        f2 = f1;
        if (I.a())
        {
          float f3 = paramMotionEvent.getAxisValue(10);
          f2 = f1;
          f1 = f3;
          break label140;
        }
      }
      else
      {
        if ((paramMotionEvent.getSource() & 0x400000) != 0)
        {
          f1 = paramMotionEvent.getAxisValue(26);
          if (I.b())
          {
            f2 = -f1;
            break label138;
          }
          if (I.a())
          {
            f2 = 0.0F;
            break label140;
          }
        }
        f2 = 0.0F;
      }
      label138:
      float f1 = 0.0F;
      label140:
      if ((f2 != 0.0F) || (f1 != 0.0F)) {
        a((int)(f1 * w0), (int)(f2 * x0), paramMotionEvent);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = T;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 0)) {
      M = null;
    }
    int j = L.size();
    for (int k = 0; k < j; k++)
    {
      localObject = (m)L.get(k);
      if ((((m)localObject).a(this, paramMotionEvent)) && (i != 3))
      {
        M = ((m)localObject);
        k = 1;
        break label107;
      }
    }
    k = 0;
    label107:
    if (k != 0)
    {
      a();
      return true;
    }
    Object localObject = I;
    if (localObject == null) {
      return false;
    }
    boolean bool3 = ((LayoutManager)localObject).a();
    bool1 = I.b();
    if (n0 == null) {
      n0 = VelocityTracker.obtain();
    }
    n0.addMovement(paramMotionEvent);
    j = paramMotionEvent.getActionMasked();
    k = paramMotionEvent.getActionIndex();
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 5)
            {
              if (j == 6) {
                a(paramMotionEvent);
              }
            }
            else
            {
              m0 = paramMotionEvent.getPointerId(k);
              j = (int)(paramMotionEvent.getX(k) + 0.5F);
              q0 = j;
              o0 = j;
              k = (int)(paramMotionEvent.getY(k) + 0.5F);
              r0 = k;
              p0 = k;
            }
          }
          else {
            a();
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(m0);
          if (j < 0)
          {
            paramMotionEvent = e.a.a.a.a.a("Error processing scroll; pointer index for id ");
            paramMotionEvent.append(m0);
            paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
            Log.e("RecyclerView", paramMotionEvent.toString());
            return false;
          }
          k = (int)(paramMotionEvent.getX(j) + 0.5F);
          i = (int)(paramMotionEvent.getY(j) + 0.5F);
          if (l0 != 1)
          {
            j = o0;
            int m = p0;
            if ((bool3) && (Math.abs(k - j) > s0))
            {
              q0 = k;
              k = 1;
            }
            else
            {
              k = 0;
            }
            j = k;
            if (bool1)
            {
              j = k;
              if (Math.abs(i - m) > s0)
              {
                r0 = i;
                j = 1;
              }
            }
            if (j != 0) {
              setScrollState(1);
            }
          }
        }
      }
      else
      {
        n0.clear();
        a(0);
      }
    }
    else
    {
      if (U) {
        U = false;
      }
      m0 = paramMotionEvent.getPointerId(0);
      k = (int)(paramMotionEvent.getX() + 0.5F);
      q0 = k;
      o0 = k;
      k = (int)(paramMotionEvent.getY() + 0.5F);
      r0 = k;
      p0 = k;
      if (l0 == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = P0;
      paramMotionEvent[1] = 0;
      paramMotionEvent[0] = 0;
      if (bool3) {
        k = 1;
      } else {
        k = 0;
      }
      j = k;
      if (bool1) {
        j = k | 0x2;
      }
      d(j, 0);
    }
    if (l0 == 1) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    d.i.e.b.a("RV OnLayout");
    c();
    Trace.endSection();
    Q = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = I;
    if (localObject == null)
    {
      b(paramInt1, paramInt2);
      return;
    }
    if (((LayoutManager)localObject).j())
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      I.b.b(paramInt1, paramInt2);
      if ((i == 1073741824) && (j != 1073741824)) {}
      return;
    }
    if (O)
    {
      I.b.b(paramInt1, paramInt2);
      return;
    }
    if (W)
    {
      q();
      m();
      n();
      a(true);
      localObject = C0;
      if (k)
      {
        g = true;
      }
      else
      {
        A.b();
        C0.g = false;
      }
      W = false;
      b(false);
    }
    else if (C0.k)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    C0.e = 0;
    q();
    I.b.b(paramInt1, paramInt2);
    b(false);
    C0.g = false;
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (k()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof s))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (s)paramParcelable;
    z = paramParcelable;
    super.onRestoreInstanceState(x);
    paramParcelable = I;
    if (paramParcelable != null)
    {
      Parcelable localParcelable = z.z;
      if (localParcelable != null) {
        paramParcelable.a(localParcelable);
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    s locals = new s(super.onSaveInstanceState());
    Object localObject = z;
    if (localObject != null)
    {
      z = z;
    }
    else
    {
      localObject = I;
      if (localObject != null) {
        z = ((LayoutManager)localObject).k();
      } else {
        z = null;
      }
    }
    return locals;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      j();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = T;
    int i = 0;
    if ((!bool1) && (!U))
    {
      int j = paramMotionEvent.getAction();
      Object localObject = M;
      if (localObject != null) {
        if (j == 0)
        {
          M = null;
        }
        else
        {
          ((m)localObject).b(this, paramMotionEvent);
          if ((j != 3) && (j != 1)) {
            break label136;
          }
          M = null;
          break label136;
        }
      }
      if (j != 0)
      {
        k = L.size();
        for (j = 0; j < k; j++)
        {
          localObject = (m)L.get(j);
          if (((m)localObject).a(this, paramMotionEvent))
          {
            M = ((m)localObject);
            label136:
            j = 1;
            break label151;
          }
        }
      }
      j = 0;
      label151:
      if (j != 0)
      {
        a();
        return true;
      }
      localObject = I;
      if (localObject == null) {
        return false;
      }
      boolean bool2 = ((LayoutManager)localObject).a();
      bool1 = I.b();
      if (n0 == null) {
        n0 = VelocityTracker.obtain();
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
      int k = paramMotionEvent.getActionMasked();
      j = paramMotionEvent.getActionIndex();
      if (k == 0)
      {
        arrayOfInt = P0;
        arrayOfInt[1] = 0;
        arrayOfInt[0] = 0;
      }
      int[] arrayOfInt = P0;
      ((MotionEvent)localObject).offsetLocation(arrayOfInt[0], arrayOfInt[1]);
      if (k != 0)
      {
        int i3;
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 5)
              {
                if (k != 6)
                {
                  j = i;
                }
                else
                {
                  a(paramMotionEvent);
                  j = i;
                }
              }
              else
              {
                m0 = paramMotionEvent.getPointerId(j);
                k = (int)(paramMotionEvent.getX(j) + 0.5F);
                q0 = k;
                o0 = k;
                j = (int)(paramMotionEvent.getY(j) + 0.5F);
                r0 = j;
                p0 = j;
                j = i;
              }
            }
            else
            {
              a();
              j = i;
            }
          }
          else
          {
            j = paramMotionEvent.findPointerIndex(m0);
            if (j < 0)
            {
              paramMotionEvent = e.a.a.a.a.a("Error processing scroll; pointer index for id ");
              paramMotionEvent.append(m0);
              paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
              Log.e("RecyclerView", paramMotionEvent.toString());
              return false;
            }
            int m = (int)(paramMotionEvent.getX(j) + 0.5F);
            int n = (int)(paramMotionEvent.getY(j) + 0.5F);
            int i1 = q0 - m;
            i3 = r0 - n;
            paramMotionEvent = O0;
            arrayOfInt = N0;
            k = i1;
            j = i3;
            if (getScrollingChildHelper().a(i1, i3, paramMotionEvent, arrayOfInt, 0))
            {
              paramMotionEvent = O0;
              k = i1 - paramMotionEvent[0];
              j = i3 - paramMotionEvent[1];
              paramMotionEvent = N0;
              ((MotionEvent)localObject).offsetLocation(paramMotionEvent[0], paramMotionEvent[1]);
              paramMotionEvent = P0;
              i3 = paramMotionEvent[0];
              arrayOfInt = N0;
              paramMotionEvent[0] = (i3 + arrayOfInt[0]);
              paramMotionEvent[1] += arrayOfInt[1];
            }
            i1 = k;
            i3 = j;
            if (l0 != 1)
            {
              if (bool2)
              {
                i3 = Math.abs(k);
                i1 = s0;
                if (i3 > i1)
                {
                  if (k > 0) {
                    k -= i1;
                  } else {
                    k += i1;
                  }
                  i3 = 1;
                  break label674;
                }
              }
              i3 = 0;
              label674:
              int i4 = i3;
              int i5 = j;
              if (bool1)
              {
                int i6 = Math.abs(j);
                i1 = s0;
                i4 = i3;
                i5 = j;
                if (i6 > i1)
                {
                  if (j > 0) {
                    i5 = j - i1;
                  } else {
                    i5 = j + i1;
                  }
                  i4 = 1;
                }
              }
              i1 = k;
              i3 = i5;
              if (i4 != 0)
              {
                setScrollState(1);
                i3 = i5;
                i1 = k;
              }
            }
            j = i;
            if (l0 == 1)
            {
              paramMotionEvent = N0;
              q0 = (m - paramMotionEvent[0]);
              r0 = (n - paramMotionEvent[1]);
              if (bool2) {
                j = i1;
              } else {
                j = 0;
              }
              if (bool1) {
                k = i3;
              } else {
                k = 0;
              }
              a(j, k, (MotionEvent)localObject);
              j = i;
              if (A0 != null) {
                if (i1 == 0)
                {
                  j = i;
                  if (i3 == 0) {}
                }
                else
                {
                  A0.a(this, i1, i3);
                  j = i;
                }
              }
            }
          }
        }
        else
        {
          n0.addMovement((MotionEvent)localObject);
          n0.computeCurrentVelocity(1000, v0);
          float f1;
          if (bool2) {
            f1 = -n0.getXVelocity(m0);
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (bool1) {
            f2 = -n0.getYVelocity(m0);
          } else {
            f2 = 0.0F;
          }
          if ((f1 != 0.0F) || (f2 != 0.0F))
          {
            k = (int)f1;
            i3 = (int)f2;
            paramMotionEvent = I;
            if (paramMotionEvent == null)
            {
              Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            }
            else if (!T)
            {
              int i2 = paramMotionEvent.a();
              bool2 = I.b();
              if (i2 != 0)
              {
                j = k;
                if (Math.abs(k) >= u0) {}
              }
              else
              {
                j = 0;
              }
              if (bool2)
              {
                k = i3;
                if (Math.abs(i3) >= u0) {}
              }
              else
              {
                k = 0;
              }
              if ((j != 0) || (k != 0))
              {
                f1 = j;
                f2 = k;
                if (!dispatchNestedPreFling(f1, f2))
                {
                  if ((i2 == 0) && (!bool2)) {
                    bool1 = false;
                  } else {
                    bool1 = true;
                  }
                  dispatchNestedFling(f1, f2, bool1);
                  if (bool1)
                  {
                    i3 = i2;
                    if (bool2) {
                      i3 = i2 | 0x2;
                    }
                    d(i3, 1);
                    i3 = v0;
                    j = Math.max(-i3, Math.min(j, i3));
                    i3 = v0;
                    k = Math.max(-i3, Math.min(k, i3));
                    paramMotionEvent = z0;
                    D.setScrollState(2);
                    y = 0;
                    x = 0;
                    z.fling(0, 0, j, k, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    paramMotionEvent.a();
                    j = 1;
                    break label1268;
                  }
                }
              }
            }
            j = 0;
            label1268:
            if (j != 0) {}
          }
          else
          {
            setScrollState(0);
          }
          p();
          j = 1;
        }
      }
      else
      {
        m0 = paramMotionEvent.getPointerId(0);
        j = (int)(paramMotionEvent.getX() + 0.5F);
        q0 = j;
        o0 = j;
        j = (int)(paramMotionEvent.getY() + 0.5F);
        r0 = j;
        p0 = j;
        if (bool2) {
          j = 1;
        } else {
          j = 0;
        }
        k = j;
        if (bool1) {
          k = j | 0x2;
        }
        d(k, 0);
        j = i;
      }
      if (j == 0) {
        n0.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    }
    return false;
  }
  
  public final void p()
  {
    Object localObject = n0;
    if (localObject != null) {
      ((VelocityTracker)localObject).clear();
    }
    boolean bool1 = false;
    a(0);
    localObject = g0;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool1 = g0.isFinished();
    }
    localObject = h0;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool2 = bool1 | h0.isFinished();
    }
    localObject = i0;
    bool1 = bool2;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool1 = bool2 | i0.isFinished();
    }
    localObject = j0;
    bool2 = bool1;
    if (localObject != null)
    {
      ((EdgeEffect)localObject).onRelease();
      bool2 = bool1 | j0.isFinished();
    }
    if (bool2) {
      n.x(this);
    }
  }
  
  public void q()
  {
    int i = R + 1;
    R = i;
    if ((i == 1) && (!T)) {
      S = false;
    }
  }
  
  public void r()
  {
    setScrollState(0);
    s();
  }
  
  public void removeDetachedView(View paramView, boolean paramBoolean)
  {
    w localw = b(paramView);
    if (localw != null) {
      if (localw.p())
      {
        localw.c();
      }
      else if (!localw.u())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localw);
        throw new IllegalArgumentException(e.a.a.a.a.a(this, paramView));
      }
    }
    paramView.clearAnimation();
    b(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (I != null)
    {
      if ((!k()) && (paramView2 != null)) {
        a(paramView1, paramView2);
      }
      super.requestChildFocus(paramView1, paramView2);
      return;
    }
    throw null;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return I.a(this, paramView, paramRect, paramBoolean, false);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int i = L.size();
    for (int j = 0; j < i; j++) {
      ((m)L.get(j)).a(paramBoolean);
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((R == 0) && (!T)) {
      super.requestLayout();
    } else {
      S = true;
    }
  }
  
  public final void s()
  {
    Object localObject = z0;
    D.removeCallbacks((Runnable)localObject);
    z.abortAnimation();
    localObject = I;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    LayoutManager localLayoutManager = I;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (T) {
      return;
    }
    boolean bool1 = localLayoutManager.a();
    boolean bool2 = I.b();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      a(paramInt1, paramInt2, null);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = k();
    int i = 0;
    int j = 0;
    if (bool)
    {
      if (paramAccessibilityEvent != null) {
        i = paramAccessibilityEvent.getContentChangeTypes();
      } else {
        i = 0;
      }
      if (i == 0) {
        i = j;
      }
      V |= i;
      i = 1;
    }
    if (i != 0) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(u paramu)
  {
    J0 = paramu;
    n.a(this, paramu);
  }
  
  public void setAdapter(d paramd)
  {
    int i = 0;
    setLayoutFrozen(false);
    o();
    Object localObject = A;
    ((d.t.a.a)localObject).a(b);
    ((d.t.a.a)localObject).a(c);
    g = 0;
    H = paramd;
    if (paramd == null)
    {
      paramd = I;
      paramd = y;
      paramd.a();
      paramd = paramd.b();
      if (paramd != null)
      {
        if (b == 0) {
          for (j = 0; j < a.size(); j++) {
            a.valueAt(j)).a.clear();
          }
        }
        C0.f = true;
        c0 |= false;
        b0 = true;
        int k = B.b();
        for (int j = 0; j < k; j++)
        {
          paramd = b(B.d(j));
          if ((paramd != null) && (!paramd.u())) {
            paramd.a(6);
          }
        }
        l();
        paramd = y;
        k = c.size();
        for (j = i; j < k; j++)
        {
          localObject = (w)c.get(j);
          if (localObject != null)
          {
            ((w)localObject).a(6);
            ((w)localObject).a(null);
          }
        }
        paramd.c();
        requestLayout();
        return;
      }
      throw null;
    }
    throw null;
  }
  
  public void setChildDrawingOrderCallback(f paramf)
  {
    if (paramf == K0) {
      return;
    }
    K0 = paramf;
    boolean bool;
    if (paramf != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != D) {
      j();
    }
    D = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (Q) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(g paramg)
  {
    if (paramg != null)
    {
      f0 = paramg;
      j();
      return;
    }
    throw null;
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    O = paramBoolean;
  }
  
  public void setItemAnimator(h paramh)
  {
    h localh = k0;
    if (localh != null)
    {
      localh.b();
      k0.a = null;
    }
    k0 = paramh;
    if (paramh != null) {
      a = H0;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    p localp = y;
    e = paramInt;
    localp.d();
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != T)
    {
      a("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        T = false;
        if (S) {
          LayoutManager localLayoutManager = I;
        }
        S = false;
      }
      else
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        T = true;
        U = true;
        r();
      }
    }
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == I) {
      return;
    }
    r();
    Object localObject1 = I;
    int i = 0;
    if (localObject1 != null)
    {
      localObject1 = k0;
      if (localObject1 != null) {
        ((h)localObject1).b();
      }
      I.a(y);
      I.b(y);
      y.a();
      if (N)
      {
        localObject1 = I;
        localObject2 = y;
        h = false;
        ((LayoutManager)localObject1).a(this, (p)localObject2);
      }
      I.b(null);
      I = null;
    }
    else
    {
      y.a();
    }
    localObject1 = B;
    Object localObject2 = b;
    a = 0L;
    localObject2 = b;
    if (localObject2 != null) {
      ((b.a)localObject2).b();
    }
    int j = c.size();
    for (;;)
    {
      j--;
      if (j < 0) {
        break label245;
      }
      Object localObject3 = a;
      localObject2 = (View)c.get(j);
      localObject3 = (s)localObject3;
      if (localObject3 == null) {
        break;
      }
      localObject2 = b((View)localObject2);
      if (localObject2 != null) {
        ((w)localObject2).a(a);
      }
      c.remove(j);
    }
    throw null;
    label245:
    localObject1 = (s)a;
    int k = ((s)localObject1).a();
    j = i;
    while (j < k)
    {
      localObject2 = ((s)localObject1).a(j);
      if (a != null)
      {
        b((View)localObject2);
        ((View)localObject2).clearAnimation();
        j++;
      }
      else
      {
        throw null;
      }
    }
    a.removeAllViews();
    I = paramLayoutManager;
    if (paramLayoutManager != null) {
      if (b == null)
      {
        paramLayoutManager.b(this);
        if (N) {
          I.h = true;
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("LayoutManager ");
        ((StringBuilder)localObject1).append(paramLayoutManager);
        ((StringBuilder)localObject1).append(" is already attached to a RecyclerView:");
        throw new IllegalArgumentException(e.a.a.a.a.a(b, (StringBuilder)localObject1));
      }
    }
    y.d();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    g localg = getScrollingChildHelper();
    if (d) {
      n.z(c);
    }
    d = paramBoolean;
  }
  
  public void setOnFlingListener(l paraml)
  {
    t0 = paraml;
  }
  
  @Deprecated
  public void setOnScrollListener(n paramn)
  {
    D0 = paramn;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    y0 = paramBoolean;
  }
  
  public void setRecycledViewPool(o paramo)
  {
    p localp = y;
    o localo = g;
    if (localo != null) {
      b -= 1;
    }
    g = paramo;
    if (paramo != null) {
      h.getAdapter();
    }
  }
  
  public void setRecyclerListener(q paramq)
  {
    J = paramq;
  }
  
  public void setScrollState(int paramInt)
  {
    if (paramInt == l0) {
      return;
    }
    l0 = paramInt;
    if (paramInt != 2) {
      s();
    }
    Object localObject = I;
    if (localObject != null) {
      ((LayoutManager)localObject).b(paramInt);
    }
    localObject = D0;
    localObject = E0;
    if (localObject != null)
    {
      paramInt = ((List)localObject).size();
      do
      {
        paramInt--;
        if (paramInt < 0) {
          break;
        }
      } while ((n)E0.get(paramInt) != null);
      throw null;
    }
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("; using default value");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      else
      {
        s0 = localViewConfiguration.getScaledPagingTouchSlop();
        return;
      }
    }
    s0 = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(u paramu) {}
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().c(0);
  }
  
  public static abstract class LayoutManager
  {
    public d.t.a.b a;
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
        paramInt = ((d.t.a.b)localObject).c(paramInt);
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
    
    public void a(View paramView, d.i.i.x.d paramd)
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
    
    public void a(RecyclerView.p paramp, RecyclerView.t paramt, View paramView, d.i.i.x.d paramd)
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
        d.t.a.b localb = a;
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
      d.t.a.b localb = a;
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
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      Object localObject1 = k0;
      if (localObject1 != null)
      {
        localObject1 = (k)localObject1;
        boolean bool1 = h.isEmpty() ^ true;
        boolean bool2 = j.isEmpty() ^ true;
        boolean bool3 = k.isEmpty() ^ true;
        boolean bool4 = i.isEmpty() ^ true;
        if ((bool1) || (bool2) || (bool4) || (bool3))
        {
          Object localObject2 = h.iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)((Iterator)localObject2).next();
            View localView = a;
            localObject3 = localView.animate();
            q.add(localw);
            ((ViewPropertyAnimator)localObject3).setDuration(d).alpha(0.0F).setListener(new f((k)localObject1, localw, (ViewPropertyAnimator)localObject3, localView)).start();
          }
          h.clear();
          if (bool2)
          {
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).addAll(j);
            m.add(localObject3);
            j.clear();
            localObject2 = new c((k)localObject1, (ArrayList)localObject3);
            if (bool1) {
              n.a(get0a.a, (Runnable)localObject2, d);
            } else {
              ((c)localObject2).run();
            }
          }
          if (bool3)
          {
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).addAll(k);
            n.add(localObject3);
            k.clear();
            localObject2 = new d.t.a.d((k)localObject1, (ArrayList)localObject3);
            if (bool1) {
              n.a(get0a.a, (Runnable)localObject2, d);
            } else {
              ((d.t.a.d)localObject2).run();
            }
          }
          if (bool4)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).addAll(i);
            l.add(localObject2);
            i.clear();
            localObject3 = new e((k)localObject1, (ArrayList)localObject2);
            if ((!bool1) && (!bool2) && (!bool3))
            {
              ((e)localObject3).run();
            }
            else
            {
              long l1 = 0L;
              long l2;
              if (bool1) {
                l2 = d;
              } else {
                l2 = 0L;
              }
              if (bool2) {
                l3 = e;
              } else {
                l3 = 0L;
              }
              if (bool3) {
                l1 = f;
              }
              long l3 = Math.max(l3, l1);
              n.a(get0a, (Runnable)localObject3, l3 + l2);
            }
          }
        }
      }
      I0 = false;
    }
  }
  
  public static final class b
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
    }
  }
  
  public class c
    implements x.b
  {
    public c() {}
  }
  
  public static abstract class d<VH extends RecyclerView.w> {}
  
  public static abstract class e {}
  
  public static abstract interface f
  {
    public abstract int a(int paramInt1, int paramInt2);
  }
  
  public static class g
  {
    public EdgeEffect a(RecyclerView paramRecyclerView)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
  }
  
  public static abstract class h
  {
    public b a = null;
    public ArrayList<a> b = new ArrayList();
    public long c = 120L;
    public long d = 120L;
    public long e = 250L;
    public long f = 250L;
    
    public static int d(RecyclerView.w paramw)
    {
      int i = paramw.i & 0xE;
      if (paramw.l()) {
        return 4;
      }
      int j = i;
      if ((i & 0x4) == 0)
      {
        int k = paramw.h();
        int m = paramw.e();
        j = i;
        if (k != -1)
        {
          j = i;
          if (m != -1)
          {
            j = i;
            if (k != m) {
              j = i | 0x800;
            }
          }
        }
      }
      return j;
    }
    
    public final void a()
    {
      int i = b.size();
      for (int j = 0; j < i; j++) {
        ((a)b.get(j)).a();
      }
      b.clear();
    }
    
    public final void a(RecyclerView.w paramw)
    {
      Object localObject1 = a;
      if (localObject1 != null)
      {
        localObject1 = (RecyclerView.i)localObject1;
        if (localObject1 != null)
        {
          int i = 1;
          paramw.a(true);
          if ((g != null) && (h == null)) {
            g = null;
          }
          h = null;
          if (!paramw.t())
          {
            RecyclerView localRecyclerView = a;
            View localView = a;
            localRecyclerView.q();
            Object localObject2 = B;
            int j = a).a.indexOfChild(localView);
            if (j == -1)
            {
              ((d.t.a.b)localObject2).c(localView);
            }
            else if (b.c(j))
            {
              b.d(j);
              ((d.t.a.b)localObject2).c(localView);
              ((s)a).b(j);
            }
            else
            {
              i = 0;
            }
            if (i != 0)
            {
              localObject2 = RecyclerView.b(localView);
              y.b((RecyclerView.w)localObject2);
              y.a((RecyclerView.w)localObject2);
            }
            localRecyclerView.b(i ^ 0x1);
            if ((i == 0) && (paramw.p())) {
              a.removeDetachedView(a, false);
            }
          }
        }
        else
        {
          throw null;
        }
      }
    }
    
    public boolean a(RecyclerView.w paramw, List<Object> paramList)
    {
      boolean bool;
      if ((g) && (!paramw.l())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public abstract void b();
    
    public abstract void b(RecyclerView.w paramw);
    
    public c c(RecyclerView.t paramt, RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      paramw = new c();
      paramt = a;
      a = paramt.getLeft();
      b = paramt.getTop();
      paramt.getRight();
      paramt.getBottom();
      return paramw;
    }
    
    public abstract boolean c();
    
    public static abstract interface a
    {
      public abstract void a();
    }
    
    public static abstract interface b {}
    
    public static class c
    {
      public int a;
      public int b;
    }
  }
  
  public class i
    implements RecyclerView.h.b
  {
    public i() {}
  }
  
  public static abstract class j {}
  
  public static class k
    extends ViewGroup.MarginLayoutParams
  {
    public RecyclerView.w a;
    public final Rect b = new Rect();
    public boolean c = true;
    public boolean d = false;
    
    public k(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public k(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public k(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public k(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public k(k paramk)
    {
      super();
    }
    
    public int a()
    {
      return a.g();
    }
  }
  
  public static abstract class l {}
  
  public static abstract interface m
  {
    public abstract void a(boolean paramBoolean);
    
    public abstract boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
  }
  
  public static abstract class n {}
  
  public static class o
  {
    public SparseArray<a> a = new SparseArray();
    public int b = 0;
    
    public final a a(int paramInt)
    {
      a locala1 = (a)a.get(paramInt);
      a locala2 = locala1;
      if (locala1 == null)
      {
        locala2 = new a();
        a.put(paramInt, locala2);
      }
      return locala2;
    }
    
    public static class a
    {
      public final ArrayList<RecyclerView.w> a = new ArrayList();
      public int b = 5;
      public long c = 0L;
      public long d = 0L;
    }
  }
  
  public final class p
  {
    public final ArrayList<RecyclerView.w> a = new ArrayList();
    public ArrayList<RecyclerView.w> b = null;
    public final ArrayList<RecyclerView.w> c = new ArrayList();
    public final List<RecyclerView.w> d = Collections.unmodifiableList(a);
    public int e = 2;
    public int f = 2;
    public RecyclerView.o g;
    
    public p() {}
    
    public int a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < C0.a()))
      {
        localObject = RecyclerView.this;
        if (!C0.g) {
          return paramInt;
        }
        return A.a(paramInt, 0);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid position ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(". State ");
      ((StringBuilder)localObject).append("item count is ");
      ((StringBuilder)localObject).append(C0.a());
      throw new IndexOutOfBoundsException(e.a.a.a.a.a(RecyclerView.this, (StringBuilder)localObject));
    }
    
    public RecyclerView.w a(int paramInt, boolean paramBoolean, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < C0.a()))
      {
        boolean bool = C0.g;
        int i = 1;
        if (bool)
        {
          localObject1 = b;
          if (localObject1 != null)
          {
            j = ((ArrayList)localObject1).size();
            if (j != 0)
            {
              for (k = 0; k < j; k++)
              {
                localObject1 = (RecyclerView.w)b.get(k);
                if ((!((RecyclerView.w)localObject1).w()) && (((RecyclerView.w)localObject1).g() == paramInt))
                {
                  ((RecyclerView.w)localObject1).a(32);
                  break label126;
                }
              }
              throw null;
            }
          }
          localObject1 = null;
          label126:
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            k = 1;
            break label151;
          }
        }
        else
        {
          localObject2 = null;
        }
        int k = 0;
        localObject1 = localObject2;
        label151:
        int j = k;
        Object localObject2 = localObject1;
        Object localObject3;
        if (localObject1 == null)
        {
          int m = a.size();
          for (j = 0; j < m; j++)
          {
            localObject1 = (RecyclerView.w)a.get(j);
            if ((!((RecyclerView.w)localObject1).w()) && (((RecyclerView.w)localObject1).g() == paramInt) && (!((RecyclerView.w)localObject1).l()) && ((C0.g) || (!((RecyclerView.w)localObject1).n())))
            {
              ((RecyclerView.w)localObject1).a(32);
              break label698;
            }
          }
          if (!paramBoolean)
          {
            localObject3 = B;
            m = c.size();
            j = 0;
            while (j < m)
            {
              localObject1 = (View)c.get(j);
              if ((s)a != null)
              {
                localObject2 = RecyclerView.b((View)localObject1);
                if ((((RecyclerView.w)localObject2).g() == paramInt) && (!((RecyclerView.w)localObject2).l()) && (!((RecyclerView.w)localObject2).n())) {
                  break label368;
                }
                j++;
              }
              else
              {
                throw null;
              }
            }
            localObject1 = null;
            label368:
            if (localObject1 != null)
            {
              localObject2 = RecyclerView.b((View)localObject1);
              localObject3 = B;
              j = a).a.indexOfChild((View)localObject1);
              if (j >= 0)
              {
                if (b.c(j))
                {
                  b.a(j);
                  ((d.t.a.b)localObject3).c((View)localObject1);
                  j = B.a((View)localObject1);
                  if (j != -1)
                  {
                    B.a(j);
                    b((View)localObject1);
                    ((RecyclerView.w)localObject2).a(8224);
                    localObject1 = localObject2;
                    break label698;
                  }
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("layout index should not be -1 after unhiding a view:");
                  ((StringBuilder)localObject1).append(localObject2);
                  throw new IllegalStateException(e.a.a.a.a.a(RecyclerView.this, (StringBuilder)localObject1));
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("trying to unhide a view that was not hidden");
                ((StringBuilder)localObject2).append(localObject1);
                throw new RuntimeException(((StringBuilder)localObject2).toString());
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("view is not a child, cannot hide ");
              ((StringBuilder)localObject2).append(localObject1);
              throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
            }
          }
          m = c.size();
          for (j = 0; j < m; j++)
          {
            localObject2 = (RecyclerView.w)c.get(j);
            if ((!((RecyclerView.w)localObject2).l()) && (((RecyclerView.w)localObject2).g() == paramInt))
            {
              localObject1 = localObject2;
              if (paramBoolean) {
                break label698;
              }
              c.remove(j);
              localObject1 = localObject2;
              break label698;
            }
          }
          localObject1 = null;
          label698:
          j = k;
          localObject2 = localObject1;
          if (localObject1 != null) {
            if (((RecyclerView.w)localObject1).n())
            {
              if (!C0.g)
              {
                if (!paramBoolean)
                {
                  ((RecyclerView.w)localObject1).a(4);
                  if (((RecyclerView.w)localObject1).o())
                  {
                    removeDetachedView(a, false);
                    ((RecyclerView.w)localObject1).v();
                  }
                  else if (((RecyclerView.w)localObject1).w())
                  {
                    ((RecyclerView.w)localObject1).b();
                  }
                  a((RecyclerView.w)localObject1);
                }
                localObject2 = null;
                j = k;
              }
              else
              {
                j = 1;
                localObject2 = localObject1;
              }
            }
            else
            {
              if (c >= 0) {
                throw null;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Inconsistency detected. Invalid view holder adapter position");
              ((StringBuilder)localObject2).append(localObject1);
              throw new IndexOutOfBoundsException(e.a.a.a.a.a(RecyclerView.this, (StringBuilder)localObject2));
            }
          }
        }
        if (localObject2 == null)
        {
          k = A.a(paramInt, 0);
          if (k >= 0) {
            throw null;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("(offset:");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(").");
          ((StringBuilder)localObject1).append("state:");
          ((StringBuilder)localObject1).append(C0.a());
          throw new IndexOutOfBoundsException(e.a.a.a.a.a(RecyclerView.this, (StringBuilder)localObject1));
        }
        if ((j != 0) && (!C0.g) && (((RecyclerView.w)localObject2).b(8192)))
        {
          ((RecyclerView.w)localObject2).a(0, 8192);
          if (C0.j)
          {
            RecyclerView.h.d((RecyclerView.w)localObject2);
            localObject3 = RecyclerView.this;
            localObject1 = k0;
            localObject3 = C0;
            ((RecyclerView.w)localObject2).i();
            localObject1 = ((RecyclerView.h)localObject1).c((RecyclerView.w)localObject2);
            a((RecyclerView.w)localObject2, (RecyclerView.h.c)localObject1);
          }
        }
        if ((C0.g) && (((RecyclerView.w)localObject2).k()))
        {
          f = paramInt;
        }
        else if ((!((RecyclerView.w)localObject2).k()) || (((RecyclerView.w)localObject2).r()) || (((RecyclerView.w)localObject2).l()))
        {
          A.a(paramInt, 0);
          q = RecyclerView.this;
          paramInt = ((RecyclerView.w)localObject2).f();
          long l1 = getNanoTime();
          if (paramLong == Long.MAX_VALUE) {
            break label1326;
          }
          long l2 = g.a(paramInt).d;
          paramInt = i;
          if (l2 != 0L) {
            if (l1 + l2 < paramLong) {
              paramInt = i;
            } else {
              paramInt = 0;
            }
          }
          if (paramInt != 0) {
            break label1326;
          }
        }
        localObject1 = a.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = (RecyclerView.k)generateDefaultLayoutParams();
          a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject1))
        {
          localObject1 = (RecyclerView.k)generateLayoutParams((ViewGroup.LayoutParams)localObject1);
          a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          localObject1 = (RecyclerView.k)localObject1;
        }
        a = ((RecyclerView.w)localObject2);
        d = false;
        return (RecyclerView.w)localObject2;
        label1326:
        throw null;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(C0.a());
      throw new IndexOutOfBoundsException(e.a.a.a.a.a(RecyclerView.this, (StringBuilder)localObject1));
    }
    
    public void a()
    {
      a.clear();
      c();
    }
    
    public void a(View paramView)
    {
      RecyclerView.w localw = RecyclerView.b(paramView);
      if (localw.p()) {
        removeDetachedView(paramView, false);
      }
      if (localw.o()) {
        localw.v();
      } else if (localw.w()) {
        localw.b();
      }
      a(localw);
    }
    
    public void a(RecyclerView.w paramw)
    {
      boolean bool1 = paramw.o();
      boolean bool2 = false;
      int i = 0;
      int j = 1;
      if ((!bool1) && (a.getParent() == null))
      {
        if (!paramw.p())
        {
          if (!paramw.u())
          {
            bool2 = paramw.d();
            if (paramw.m())
            {
              if ((f > 0) && (!paramw.b(526)))
              {
                i = c.size();
                k = i;
                if (i >= f)
                {
                  k = i;
                  if (i > 0)
                  {
                    b(0);
                    k = i - 1;
                  }
                }
                i = k;
                if (RecyclerView.X0)
                {
                  i = k;
                  if (k > 0)
                  {
                    i = k;
                    if (!B0.a(c))
                    {
                      int m;
                      do
                      {
                        i = k - 1;
                        if (i < 0) {
                          break;
                        }
                        m = c.get(i)).c;
                        k = i;
                      } while (B0.a(m));
                      i++;
                    }
                  }
                }
                c.add(i, paramw);
                k = 1;
              }
              else
              {
                k = 0;
              }
              i = k;
              if (k == 0)
              {
                a(paramw, true);
                break label249;
              }
            }
            j = 0;
            int k = i;
            label249:
            C.a(paramw);
            if ((k == 0) && (j == 0) && (bool2)) {
              q = null;
            }
            return;
          }
          paramw = e.a.a.a.a.a("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
          throw new IllegalArgumentException(e.a.a.a.a.a(RecyclerView.this, paramw));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        localStringBuilder.append(paramw);
        throw new IllegalArgumentException(e.a.a.a.a.a(RecyclerView.this, localStringBuilder));
      }
      StringBuilder localStringBuilder = e.a.a.a.a.a("Scrapped or attached views may not be recycled. isScrap:");
      localStringBuilder.append(paramw.o());
      localStringBuilder.append(" isAttached:");
      if (a.getParent() != null) {
        bool2 = true;
      }
      localStringBuilder.append(bool2);
      throw new IllegalArgumentException(e.a.a.a.a.a(RecyclerView.this, localStringBuilder));
    }
    
    public void a(RecyclerView.w paramw, boolean paramBoolean)
    {
      RecyclerView.b(paramw);
      if (paramw.b(16384))
      {
        paramw.a(0, 16384);
        n.a(a, null);
      }
      if (paramBoolean)
      {
        localObject = J;
        if (localObject != null) {
          ((RecyclerView.q)localObject).a(paramw);
        }
        localObject = RecyclerView.this;
        if (C0 != null) {
          C.a(paramw);
        }
      }
      q = null;
      Object localObject = b();
      if (localObject != null)
      {
        int i = paramw.f();
        ArrayList localArrayList = aa;
        if (a.get(i)).b > localArrayList.size())
        {
          paramw.s();
          localArrayList.add(paramw);
        }
        return;
      }
      throw null;
    }
    
    public RecyclerView.o b()
    {
      if (g == null) {
        g = new RecyclerView.o();
      }
      return g;
    }
    
    public void b(int paramInt)
    {
      a((RecyclerView.w)c.get(paramInt), true);
      c.remove(paramInt);
    }
    
    public void b(View paramView)
    {
      paramView = RecyclerView.b(paramView);
      if ((!paramView.b(12)) && (paramView.q()))
      {
        RecyclerView.h localh = k0;
        int i;
        if ((localh != null) && (!localh.a(paramView, paramView.i()))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          if (b == null) {
            b = new ArrayList();
          }
          paramView.a(this, true);
          b.add(paramView);
          return;
        }
      }
      if ((paramView.l()) && (!paramView.n())) {
        throw null;
      }
      paramView.a(this, false);
      a.add(paramView);
    }
    
    public void b(RecyclerView.w paramw)
    {
      if (n) {
        b.remove(paramw);
      } else {
        a.remove(paramw);
      }
      m = null;
      n = false;
      paramw.b();
    }
    
    public void c()
    {
      for (int i = c.size() - 1; i >= 0; i--) {
        b(i);
      }
      c.clear();
      if (RecyclerView.X0)
      {
        m.b localb = B0;
        int[] arrayOfInt = c;
        if (arrayOfInt != null) {
          Arrays.fill(arrayOfInt, -1);
        }
        d = 0;
      }
    }
    
    public void d()
    {
      RecyclerView.LayoutManager localLayoutManager = I;
      if (localLayoutManager != null) {
        i = l;
      } else {
        i = 0;
      }
      f = (e + i);
      for (int i = c.size() - 1; (i >= 0) && (c.size() > f); i--) {
        b(i);
      }
    }
  }
  
  public static abstract interface q
  {
    public abstract void a(RecyclerView.w paramw);
  }
  
  public class r
    extends RecyclerView.e
  {
    public r() {}
  }
  
  public static class s
    extends d.k.a.a
  {
    public static final Parcelable.Creator<s> CREATOR = new a();
    public Parcelable z;
    
    public s(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
      }
      z = paramParcel.readParcelable(paramClassLoader);
    }
    
    public s(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeParcelable(z, 0);
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<RecyclerView.s>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new RecyclerView.s(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new RecyclerView.s(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new RecyclerView.s[paramInt];
      }
    }
  }
  
  public static class t
  {
    public int a = -1;
    public int b = 0;
    public int c = 0;
    public int d = 1;
    public int e = 0;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    
    public int a()
    {
      int m;
      if (g) {
        m = b - c;
      } else {
        m = e;
      }
      return m;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = e.a.a.a.a.a("State{mTargetPosition=");
      localStringBuilder.append(a);
      localStringBuilder.append(", mData=");
      localStringBuilder.append(null);
      localStringBuilder.append(", mItemCount=");
      localStringBuilder.append(e);
      localStringBuilder.append(", mIsMeasuring=");
      localStringBuilder.append(i);
      localStringBuilder.append(", mPreviousLayoutItemCount=");
      localStringBuilder.append(b);
      localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      localStringBuilder.append(c);
      localStringBuilder.append(", mStructureChanged=");
      localStringBuilder.append(f);
      localStringBuilder.append(", mInPreLayout=");
      localStringBuilder.append(g);
      localStringBuilder.append(", mRunSimpleAnimations=");
      localStringBuilder.append(j);
      localStringBuilder.append(", mRunPredictiveAnimations=");
      localStringBuilder.append(k);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static abstract class u {}
  
  public class v
    implements Runnable
  {
    public Interpolator A = RecyclerView.b1;
    public boolean B = false;
    public boolean C = false;
    public int x;
    public int y;
    public OverScroller z = new OverScroller(getContext(), RecyclerView.b1);
    
    public v() {}
    
    public void a()
    {
      if (B)
      {
        C = true;
      }
      else
      {
        removeCallbacks(this);
        n.a(RecyclerView.this, this);
      }
    }
    
    public void run()
    {
      Object localObject1 = RecyclerView.this;
      if (I == null)
      {
        ((ViewGroup)localObject1).removeCallbacks(this);
        z.abortAnimation();
        return;
      }
      C = false;
      B = true;
      ((RecyclerView)localObject1).b();
      localObject1 = z;
      Object localObject2 = I;
      if (((OverScroller)localObject1).computeScrollOffset())
      {
        localObject2 = O0;
        int i = ((OverScroller)localObject1).getCurrX();
        int j = ((OverScroller)localObject1).getCurrY();
        int k = i - x;
        int m = j - y;
        x = i;
        y = j;
        j = k;
        i = m;
        if (a(k, m, (int[])localObject2, null, 1))
        {
          j = k - localObject2[0];
          i = m - localObject2[1];
        }
        if (!K.isEmpty()) {
          invalidate();
        }
        if (getOverScrollMode() != 2) {
          a(j, i);
        }
        a(0, 0, 0, 0, null, 1);
        if (!RecyclerView.a(RecyclerView.this)) {
          invalidate();
        }
        if ((i != 0) && (I.b()) && (i == 0)) {
          m = 1;
        } else {
          m = 0;
        }
        if ((j != 0) && (I.a()) && (j == 0)) {
          k = 1;
        } else {
          k = 0;
        }
        if (((j != 0) || (i != 0)) && (k == 0) && (m == 0)) {
          m = 0;
        } else {
          m = 1;
        }
        if ((!((OverScroller)localObject1).isFinished()) && ((m != 0) || (b(1))))
        {
          a();
          localObject1 = RecyclerView.this;
          localObject2 = A0;
          if (localObject2 != null) {
            ((m)localObject2).a((RecyclerView)localObject1, j, i);
          }
        }
        else
        {
          setScrollState(0);
          if (RecyclerView.X0)
          {
            localObject2 = B0;
            localObject1 = c;
            if (localObject1 != null) {
              Arrays.fill((int[])localObject1, -1);
            }
            d = 0;
          }
          a(1);
        }
      }
      B = false;
      if (C) {
        a();
      }
    }
  }
  
  public static abstract class w
  {
    public static final List<Object> r = ;
    public final View a;
    public WeakReference<RecyclerView> b;
    public int c;
    public int d;
    public long e;
    public int f;
    public w g;
    public w h;
    public int i;
    public List<Object> j;
    public List<Object> k;
    public int l;
    public RecyclerView.p m;
    public boolean n;
    public int o;
    public int p;
    public RecyclerView q;
    
    public void a()
    {
      List localList = j;
      if (localList != null) {
        localList.clear();
      }
      i &= 0xFBFF;
    }
    
    public void a(int paramInt)
    {
      i = (paramInt | i);
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      i = (paramInt1 & paramInt2 | i & paramInt2);
    }
    
    public void a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      a(8);
      a(paramInt2, paramBoolean);
      c = paramInt1;
    }
    
    public void a(int paramInt, boolean paramBoolean)
    {
      if (d == -1) {
        d = c;
      }
      if (f == -1) {
        f = c;
      }
      if (paramBoolean) {
        f += paramInt;
      }
      c += paramInt;
      throw null;
    }
    
    public void a(RecyclerView.p paramp, boolean paramBoolean)
    {
      m = paramp;
      n = paramBoolean;
    }
    
    public void a(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.a(this, o);
      o = 0;
    }
    
    public void a(Object paramObject)
    {
      if (paramObject == null)
      {
        a(1024);
      }
      else if ((0x400 & i) == 0)
      {
        if (j == null)
        {
          ArrayList localArrayList = new ArrayList();
          j = localArrayList;
          k = Collections.unmodifiableList(localArrayList);
        }
        j.add(paramObject);
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      int i1 = l;
      if (paramBoolean) {
        i1--;
      } else {
        i1++;
      }
      l = i1;
      if (i1 < 0)
      {
        l = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
        Log.e("View", localStringBuilder.toString());
      }
      else if ((!paramBoolean) && (i1 == 1))
      {
        i |= 0x10;
      }
      else if ((paramBoolean) && (l == 0))
      {
        i &= 0xFFFFFFEF;
      }
    }
    
    public void b()
    {
      i &= 0xFFFFFFDF;
    }
    
    public boolean b(int paramInt)
    {
      boolean bool;
      if ((paramInt & i) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void c()
    {
      i &= 0xFEFF;
    }
    
    public boolean d()
    {
      if ((i & 0x10) != 0) {
        return false;
      }
      throw null;
    }
    
    public final int e()
    {
      RecyclerView localRecyclerView = q;
      if (localRecyclerView == null) {
        return -1;
      }
      return localRecyclerView.a(this);
    }
    
    public final int f()
    {
      return 0;
    }
    
    public final int g()
    {
      int i1 = f;
      int i2 = i1;
      if (i1 == -1) {
        i2 = c;
      }
      return i2;
    }
    
    public final int h()
    {
      return d;
    }
    
    public List<Object> i()
    {
      if ((i & 0x400) == 0)
      {
        List localList = j;
        if ((localList != null) && (localList.size() != 0)) {
          return k;
        }
        return r;
      }
      return r;
    }
    
    public boolean j()
    {
      boolean bool;
      if (((i & 0x200) == 0) && (!l())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean k()
    {
      int i1 = i;
      boolean bool = true;
      if ((i1 & 0x1) == 0) {
        bool = false;
      }
      return bool;
    }
    
    public boolean l()
    {
      boolean bool;
      if ((i & 0x4) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public final boolean m()
    {
      if ((i & 0x10) != 0) {
        return false;
      }
      throw null;
    }
    
    public boolean n()
    {
      boolean bool;
      if ((i & 0x8) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean o()
    {
      boolean bool;
      if (m != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean p()
    {
      boolean bool;
      if ((i & 0x100) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean q()
    {
      boolean bool;
      if ((i & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean r()
    {
      boolean bool;
      if ((i & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void s()
    {
      i = 0;
      c = -1;
      d = -1;
      e = -1L;
      f = -1;
      l = 0;
      g = null;
      h = null;
      a();
      o = 0;
      p = -1;
      RecyclerView.b(this);
    }
    
    public boolean t()
    {
      boolean bool;
      if ((i & 0x10) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public String toString()
    {
      Object localObject = e.a.a.a.a.a("ViewHolder{");
      ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
      ((StringBuilder)localObject).append(" position=");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(" id=");
      ((StringBuilder)localObject).append(e);
      ((StringBuilder)localObject).append(", oldPos=");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(", pLpos:");
      ((StringBuilder)localObject).append(f);
      StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject).toString());
      if (o())
      {
        localStringBuilder.append(" scrap ");
        if (n) {
          localObject = "[changeScrap]";
        } else {
          localObject = "[attachedScrap]";
        }
        localStringBuilder.append((String)localObject);
      }
      if (l()) {
        localStringBuilder.append(" invalid");
      }
      if (!k()) {
        localStringBuilder.append(" unbound");
      }
      if (r()) {
        localStringBuilder.append(" update");
      }
      if (n()) {
        localStringBuilder.append(" removed");
      }
      if (u()) {
        localStringBuilder.append(" ignored");
      }
      if (p()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!m())
      {
        localObject = e.a.a.a.a.a(" not recyclable(");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (j()) {
        localStringBuilder.append(" undefined adapter position");
      }
      throw null;
    }
    
    public boolean u()
    {
      boolean bool;
      if ((i & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void v()
    {
      m.b(this);
    }
    
    public boolean w()
    {
      boolean bool;
      if ((i & 0x20) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */