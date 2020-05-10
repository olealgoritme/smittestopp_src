package d.t.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.R.dimen;
import androidx.recyclerview.R.styleable;
import d.i.i.d;
import d.i.i.g;
import d.i.i.n;
import d.i.i.r;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class s
  extends ViewGroup
  implements d
{
  public static final int[] U0 = { 16843830 };
  public static final int[] V0 = { 16842987 };
  public static final boolean W0;
  public static final boolean X0;
  public static final boolean Y0;
  public static final boolean Z0;
  public static final Class<?>[] a1;
  public static final Interpolator b1 = new s.b();
  public a A;
  public m A0;
  public b B;
  public m.b B0;
  public final y C = new y();
  public final s.u C0;
  public boolean D;
  public s.o D0;
  public final Rect E = new Rect();
  public List<s.o> E0;
  public final Rect F = new Rect();
  public boolean F0;
  public final RectF G = new RectF();
  public boolean G0;
  public s.d H;
  public s.h.b H0;
  public s.k I;
  public boolean I0;
  public s.r J;
  public v J0;
  public final ArrayList<s.j> K = new ArrayList();
  public s.f K0;
  public final ArrayList<s.n> L = new ArrayList();
  public final int[] L0;
  public s.n M;
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
  public final List<s.x> R0;
  public boolean S;
  public Runnable S0;
  public boolean T;
  public final y.b T0;
  public boolean U;
  public int V;
  public boolean W;
  public final AccessibilityManager a0;
  public boolean b0 = false;
  public boolean c0 = false;
  public int d0 = 0;
  public int e0 = 0;
  public s.g f0 = new s.g();
  public EdgeEffect g0;
  public EdgeEffect h0;
  public EdgeEffect i0;
  public EdgeEffect j0;
  public s.h k0 = new k();
  public int l0 = 0;
  public int m0 = -1;
  public VelocityTracker n0;
  public int o0;
  public int p0;
  public int q0;
  public int r0;
  public int s0;
  public s.m t0;
  public final int u0;
  public final int v0;
  public float w0 = Float.MIN_VALUE;
  public final s.s x = new s.s(this);
  public float x0 = Float.MIN_VALUE;
  public final s.q y = new s.q(this);
  public boolean y0;
  public s.t z;
  public final s.w z0;
  
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
  
  public s(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public s(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public s(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool1 = true;
    y0 = true;
    z0 = new s.w(this);
    if (X0) {
      localObject1 = new m.b();
    } else {
      localObject1 = null;
    }
    B0 = ((m.b)localObject1);
    C0 = new s.u();
    F0 = false;
    G0 = false;
    H0 = new s.i(this);
    I0 = false;
    L0 = new int[2];
    N0 = new int[2];
    O0 = new int[2];
    P0 = new int[2];
    Q0 = new int[2];
    R0 = new ArrayList();
    S0 = new s.a(this);
    T0 = new s.c(this);
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
    A = new a(new u(this));
    B = new b(new t(this));
    if ((n.h(this) == 0) && (Build.VERSION.SDK_INT >= 26)) {
      setImportantForAutofill(8);
    }
    if (getImportantForAccessibility() == 0) {
      setImportantForAccessibility(1);
    }
    a0 = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new v(this));
    if (paramAttributeSet != null)
    {
      Object localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
      Object localObject3 = ((TypedArray)localObject2).getString(R.styleable.RecyclerView_layoutManager);
      if (((TypedArray)localObject2).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      bool2 = ((TypedArray)localObject2).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
      P = bool2;
      Object localObject5;
      if (bool2)
      {
        localObject1 = (StateListDrawable)((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
        localObject5 = ((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
        StateListDrawable localStateListDrawable = (StateListDrawable)((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
        Drawable localDrawable = ((TypedArray)localObject2).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
        if ((localObject1 != null) && (localObject5 != null) && (localStateListDrawable != null) && (localDrawable != null))
        {
          Resources localResources = getContext().getResources();
          new l(this, (StateListDrawable)localObject1, (Drawable)localObject5, localStateListDrawable, localDrawable, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        }
        else
        {
          throw new IllegalArgumentException(e.a.a.a.a.a(this, e.a.a.a.a.a("Trying to set fast scroller without both required drawables.")));
        }
      }
      ((TypedArray)localObject2).recycle();
      if (localObject3 != null)
      {
        localObject1 = ((String)localObject3).trim();
        if (!((String)localObject1).isEmpty())
        {
          if (((String)localObject1).charAt(0) == '.')
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramContext.getPackageName());
            ((StringBuilder)localObject3).append((String)localObject1);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
          for (;;)
          {
            break;
            if (!((String)localObject1).contains("."))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(s.class.getPackage().getName());
              ((StringBuilder)localObject3).append('.');
              ((StringBuilder)localObject3).append((String)localObject1);
              localObject1 = ((StringBuilder)localObject3).toString();
            }
          }
          try
          {
            if (isInEditMode()) {
              localObject3 = getClass().getClassLoader();
            } else {
              localObject3 = paramContext.getClassLoader();
            }
            localObject5 = ((ClassLoader)localObject3).loadClass((String)localObject1).asSubclass(s.k.class);
            try
            {
              localObject2 = ((Class)localObject5).getConstructor(a1);
              localObject3 = new Object[4];
              localObject3[0] = paramContext;
              localObject3[1] = paramAttributeSet;
              localObject3[2] = Integer.valueOf(paramInt);
              localObject3[3] = Integer.valueOf(0);
            }
            catch (NoSuchMethodException localNoSuchMethodException) {}
            try
            {
              localObject2 = ((Class)localObject5).getConstructor(new Class[0]);
              localObject4 = null;
              ((Constructor)localObject2).setAccessible(true);
              setLayoutManager((s.k)((Constructor)localObject2).newInstance((Object[])localObject4));
            }
            catch (NoSuchMethodException paramContext)
            {
              paramContext.initCause((Throwable)localObject4);
              localObject2 = new java/lang/IllegalStateException;
              Object localObject4 = new java/lang/StringBuilder;
              ((StringBuilder)localObject4).<init>();
              ((StringBuilder)localObject4).append(paramAttributeSet.getPositionDescription());
              ((StringBuilder)localObject4).append(": Error creating LayoutManager ");
              ((StringBuilder)localObject4).append((String)localObject1);
              ((IllegalStateException)localObject2).<init>(((StringBuilder)localObject4).toString(), paramContext);
              throw ((Throwable)localObject2);
            }
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, U0, paramInt, 0);
          }
          catch (ClassCastException localClassCastException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Class is not a LayoutManager ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localClassCastException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Cannot access non-public constructor ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localIllegalAccessException);
          }
          catch (InstantiationException localInstantiationException)
          {
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Could not instantiate the LayoutManager: ");
            paramContext.append((String)localObject1);
            throw new IllegalStateException(paramContext.toString(), localInstantiationException);
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
    s.l locall = (s.l)paramView.getLayoutParams();
    Rect localRect = b;
    paramRect.set(paramView.getLeft() - left - leftMargin, paramView.getTop() - top - topMargin, paramView.getRight() + right + rightMargin, paramView.getBottom() + bottom + bottomMargin);
  }
  
  public static s.x b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsa;
  }
  
  public static void b(s.x paramx)
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
  
  public int a(s.x paramx)
  {
    boolean bool = paramx.b(524);
    int i = -1;
    int j = i;
    if (!bool) {
      if (!paramx.k())
      {
        j = i;
      }
      else
      {
        a locala = A;
        int k = c;
        int m = b.size();
        int n = 0;
        while (n < m)
        {
          paramx = (a.b)b.get(n);
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
    s.x localx;
    int m;
    for (int k = 0; k < j; k++)
    {
      localx = b(B.d(k));
      if ((localx != null) && (!localx.u()))
      {
        m = c;
        if (m >= i)
        {
          localx.a(-paramInt2, paramBoolean);
          C0.f = true;
        }
        else if (m >= paramInt1)
        {
          localx.a(paramInt1 - 1, -paramInt2, paramBoolean);
          C0.f = true;
        }
      }
    }
    s.q localq = y;
    k = c.size();
    for (;;)
    {
      j = k - 1;
      if (j < 0) {
        break;
      }
      localx = (s.x)c.get(j);
      k = j;
      if (localx != null)
      {
        m = c;
        if (m >= i)
        {
          localx.a(-paramInt2, paramBoolean);
          k = j;
        }
        else
        {
          k = j;
          if (m >= paramInt1)
          {
            localx.a(8);
            localq.b(j);
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
    if ((localObject1 instanceof s.l))
    {
      localObject1 = (s.l)localObject1;
      if (!c)
      {
        localObject1 = b;
        localObject2 = E;
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
    ((s.k)localObject2).a(this, paramView1, (Rect)localObject1, bool1 ^ true, bool2);
  }
  
  public void a(s.x paramx, s.h.c paramc)
  {
    paramx.a(0, 8192);
    if ((C0.h) && (paramx.q()) && (!paramx.n()) && (!paramx.u())) {
      throw null;
    }
    C.a(paramx, paramc);
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
          localObject = (s.x)R0.get(j);
          if ((a.getParent() == this) && (!((s.x)localObject).u()))
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
      paramMotionEvent = P0;
      paramInt1 = paramMotionEvent[0];
      arrayOfInt = N0;
      paramMotionEvent[0] = (paramInt1 + arrayOfInt[0]);
      paramMotionEvent[1] += arrayOfInt[1];
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
              break label271;
            }
            f();
            i0.onPull(f2 / getWidth(), f3 / getHeight());
          }
          j = 1;
          break label274;
          label271:
          j = 0;
          label274:
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
  
  public boolean a(s.x paramx, int paramInt)
  {
    if (k())
    {
      p = paramInt;
      R0.add(paramx);
      return false;
    }
    n.e(a, paramInt);
    return true;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    s.k localk = I;
    if ((localk != null) && (localk == null)) {
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
              s.x localx = b(B.b(i));
              if ((localx != null) && (!localx.u()) && (localx.q()))
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
    i = s.k.a(paramInt1, getPaddingRight() + i, n.k(this));
    paramInt1 = getPaddingTop();
    setMeasuredDimension(i, s.k.a(paramInt2, getPaddingBottom() + paramInt1, getMinimumHeight()));
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
        s.k localk = I;
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
      if (!((s.k)localObject1).a()) {
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
        ((s.w)localObject1).a();
      }
    }
    return;
    label372:
    throw null;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof s.l)) && (I.a((s.l)paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int computeHorizontalScrollExtent()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.a()) {
      i = I.a(C0);
    }
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.a()) {
      i = I.b(C0);
    }
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.a()) {
      i = I.c(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.b()) {
      i = I.d(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.b()) {
      i = I.e(C0);
    }
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    s.k localk = I;
    int i = 0;
    if (localk == null) {
      return 0;
    }
    if (localk.b()) {
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
    int i2;
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
          int i1;
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
            i2 = m - n;
            i1 = o;
            m = n;
            i1 -= m / 2;
            g.setBounds(0, 0, m, n);
            h.setBounds(0, 0, q, j);
            paramCanvas.translate(0.0F, i2);
            h.draw(paramCanvas);
            paramCanvas.translate(i1, 0.0F);
            g.draw(paramCanvas);
            paramCanvas.translate(-i1, -i2);
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
        i2 = getWidth();
        if (D) {
          n = getPaddingTop();
        } else {
          n = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-n, -i2);
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
              k = right;
              j = F.right;
              if (((k > j) || (left >= j)) && (E.left > F.left)) {
                k = -1;
              } else {
                k = 0;
              }
            }
            localRect = E;
            int i1 = top;
            j = F.top;
            if (((i1 < j) || (bottom <= j)) && (E.bottom < F.bottom))
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
    s.k localk = I;
    if (localk != null) {
      return localk.c();
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    s.k localk = I;
    if (localk != null) {
      return localk.a(getContext(), paramAttributeSet);
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    s.k localk = I;
    if (localk != null) {
      return localk.a(paramLayoutParams);
    }
    throw new IllegalStateException(e.a.a.a.a.a(this, e.a.a.a.a.a("RecyclerView has no LayoutManager")));
  }
  
  public s.d getAdapter()
  {
    return null;
  }
  
  public int getBaseline()
  {
    s.k localk = I;
    if (localk != null)
    {
      if (localk != null) {
        return -1;
      }
      throw null;
    }
    return super.getBaseline();
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    s.f localf = K0;
    if (localf == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return localf.a(paramInt1, paramInt2);
  }
  
  public boolean getClipToPadding()
  {
    return D;
  }
  
  public v getCompatAccessibilityDelegate()
  {
    return J0;
  }
  
  public s.g getEdgeEffectFactory()
  {
    return f0;
  }
  
  public s.h getItemAnimator()
  {
    return k0;
  }
  
  public int getItemDecorationCount()
  {
    return K.size();
  }
  
  public s.k getLayoutManager()
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
  
  public s.m getOnFlingListener()
  {
    return null;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return y0;
  }
  
  public s.p getRecycledViewPool()
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
    s.q localq = y;
    i = c.size();
    for (k = j; k < i; k++)
    {
      s.l locall = (s.l)c.get(k)).a.getLayoutParams();
      if (locall != null) {
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
      ((a)localObject).a(b);
      ((a)localObject).a(c);
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
      ((s.h)localObject).b();
    }
    localObject = I;
    if (localObject != null)
    {
      ((s.k)localObject).a(y);
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
      ((s.h)localObject).b();
    }
    r();
    N = false;
    localObject = I;
    if (localObject != null)
    {
      s.q localq = y;
      h = false;
      ((s.k)localObject).a(this, localq);
    }
    R0.clear();
    removeCallbacks(S0);
    if (C != null)
    {
      while (y.a.d.a() != null) {}
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
      if ((s.j)K.get(j) != null) {
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
      localObject = (s.n)L.get(k);
      if ((((s.n)localObject).a(this, paramMotionEvent)) && (i != 3))
      {
        M = ((s.n)localObject);
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
    boolean bool3 = ((s.k)localObject).a();
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
          int m = (int)(paramMotionEvent.getY(j) + 0.5F);
          if (l0 != 1)
          {
            j = o0;
            i = p0;
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
              if (Math.abs(m - i) > s0)
              {
                r0 = m;
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
    if (((s.k)localObject).j())
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
    if (!(paramParcelable instanceof s.t))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (s.t)paramParcelable;
    z = paramParcelable;
    super.onRestoreInstanceState(x);
    s.k localk = I;
    if (localk != null)
    {
      paramParcelable = z.z;
      if (paramParcelable != null) {
        localk.a(paramParcelable);
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    s.t localt = new s.t(super.onSaveInstanceState());
    Object localObject = z;
    if (localObject != null)
    {
      z = z;
    }
    else
    {
      localObject = I;
      if (localObject != null) {
        z = ((s.k)localObject).k();
      } else {
        z = null;
      }
    }
    return localt;
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
          ((s.n)localObject).b(this, paramMotionEvent);
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
          localObject = (s.n)L.get(j);
          if (((s.n)localObject).a(this, paramMotionEvent))
          {
            M = ((s.n)localObject);
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
      bool1 = ((s.k)localObject).a();
      boolean bool2 = I.b();
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
              arrayOfInt = P0;
              i3 = arrayOfInt[0];
              paramMotionEvent = N0;
              arrayOfInt[0] = (i3 + paramMotionEvent[0]);
              arrayOfInt[1] += paramMotionEvent[1];
            }
            i1 = k;
            i3 = j;
            if (l0 != 1)
            {
              if (bool1)
              {
                i1 = Math.abs(k);
                i3 = s0;
                if (i1 > i3)
                {
                  if (k > 0) {
                    k -= i3;
                  } else {
                    k += i3;
                  }
                  i3 = 1;
                  break label675;
                }
              }
              i3 = 0;
              label675:
              int i4 = i3;
              int i5 = j;
              if (bool2)
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
              if (bool1) {
                j = i1;
              } else {
                j = 0;
              }
              if (bool2) {
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
          if (bool1) {
            f1 = -n0.getXVelocity(m0);
          } else {
            f1 = 0.0F;
          }
          float f2;
          if (bool2) {
            f2 = -n0.getYVelocity(m0);
          } else {
            f2 = 0.0F;
          }
          if ((f1 != 0.0F) || (f2 != 0.0F))
          {
            j = (int)f1;
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
                k = j;
                if (Math.abs(j) >= u0) {}
              }
              else
              {
                k = 0;
              }
              if (bool2)
              {
                j = i3;
                if (Math.abs(i3) >= u0) {}
              }
              else
              {
                j = 0;
              }
              if ((k != 0) || (j != 0))
              {
                f1 = k;
                f2 = j;
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
                    k = Math.max(-i3, Math.min(k, i3));
                    i3 = v0;
                    j = Math.max(-i3, Math.min(j, i3));
                    paramMotionEvent = z0;
                    D.setScrollState(2);
                    y = 0;
                    x = 0;
                    z.fling(0, 0, k, j, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    paramMotionEvent.a();
                    j = 1;
                    break label1270;
                  }
                }
              }
            }
            j = 0;
            label1270:
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
        if (bool1) {
          j = 1;
        } else {
          j = 0;
        }
        k = j;
        if (bool2) {
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
    s.x localx = b(paramView);
    if (localx != null) {
      if (localx.p())
      {
        localx.c();
      }
      else if (!localx.u())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localx);
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
      ((s.n)L.get(j)).a(paramBoolean);
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
    s.k localk = I;
    if (localk == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (T) {
      return;
    }
    boolean bool1 = localk.a();
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
  
  public void setAccessibilityDelegateCompat(v paramv)
  {
    J0 = paramv;
    n.a(this, paramv);
  }
  
  public void setAdapter(s.d paramd)
  {
    int i = 0;
    setLayoutFrozen(false);
    o();
    Object localObject = A;
    ((a)localObject).a(b);
    ((a)localObject).a(c);
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
          localObject = (s.x)c.get(j);
          if (localObject != null)
          {
            ((s.x)localObject).a(6);
            ((s.x)localObject).a(null);
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
  
  public void setChildDrawingOrderCallback(s.f paramf)
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
  
  public void setEdgeEffectFactory(s.g paramg)
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
  
  public void setItemAnimator(s.h paramh)
  {
    s.h localh = k0;
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
    s.q localq = y;
    e = paramInt;
    localq.d();
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
          s.k localk = I;
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
  
  public void setLayoutManager(s.k paramk)
  {
    if (paramk == I) {
      return;
    }
    r();
    Object localObject1 = I;
    int i = 0;
    if (localObject1 != null)
    {
      localObject1 = k0;
      if (localObject1 != null) {
        ((s.h)localObject1).b();
      }
      I.a(y);
      I.b(y);
      y.a();
      if (N)
      {
        localObject1 = I;
        localObject2 = y;
        h = false;
        ((s.k)localObject1).a(this, (s.q)localObject2);
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
      localObject2 = a;
      Object localObject3 = (View)c.get(j);
      localObject2 = (t)localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject3 = b((View)localObject3);
      if (localObject3 != null) {
        ((s.x)localObject3).a(a);
      }
      c.remove(j);
    }
    throw null;
    label245:
    localObject1 = (t)a;
    int k = ((t)localObject1).a();
    j = i;
    while (j < k)
    {
      localObject2 = ((t)localObject1).a(j);
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
    I = paramk;
    if (paramk != null) {
      if (b == null)
      {
        paramk.b(this);
        if (N) {
          I.h = true;
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("LayoutManager ");
        ((StringBuilder)localObject1).append(paramk);
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
  
  public void setOnFlingListener(s.m paramm)
  {
    t0 = paramm;
  }
  
  @Deprecated
  public void setOnScrollListener(s.o paramo)
  {
    D0 = paramo;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    y0 = paramBoolean;
  }
  
  public void setRecycledViewPool(s.p paramp)
  {
    s.q localq = y;
    s.p localp = g;
    if (localp != null) {
      b -= 1;
    }
    g = paramp;
    if (paramp != null) {
      h.getAdapter();
    }
  }
  
  public void setRecyclerListener(s.r paramr)
  {
    J = paramr;
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
      ((s.k)localObject).b(paramInt);
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
      } while ((s.o)E0.get(paramInt) != null);
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
  
  public void setViewCacheExtension(s.v paramv) {}
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().c(0);
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */