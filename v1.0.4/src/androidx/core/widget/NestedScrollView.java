package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import androidx.appcompat.app.AlertController;
import d.b.a.b;
import d.i.i.e;
import d.i.i.g;
import d.i.i.i;
import d.i.i.j;
import d.i.i.n;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements i, e
{
  public static final NestedScrollView.a a0 = new NestedScrollView.a();
  public static final int[] b0 = { 16843130 };
  public EdgeEffect A;
  public EdgeEffect B;
  public int C;
  public boolean D = true;
  public boolean E = false;
  public View F = null;
  public boolean G = false;
  public VelocityTracker H;
  public boolean I;
  public boolean J = true;
  public int K;
  public int L;
  public int M;
  public int N = -1;
  public final int[] O = new int[2];
  public final int[] P = new int[2];
  public int Q;
  public int R;
  public NestedScrollView.c S;
  public final j T;
  public final g U;
  public float V;
  public NestedScrollView.b W;
  public long x;
  public final Rect y = new Rect();
  public OverScroller z = new OverScroller(getContext());
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    K = localViewConfiguration.getScaledTouchSlop();
    L = localViewConfiguration.getScaledMinimumFlingVelocity();
    M = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b0, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    T = new j();
    U = new g(this);
    setNestedScrollingEnabled(true);
    n.a(this, a0);
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    boolean bool = true;
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    if ((!(paramView1 instanceof ViewGroup)) || (!a((View)paramView1, paramView2))) {
      bool = false;
    }
    return bool;
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      if (paramInt2 + paramInt1 > paramInt3) {
        return paramInt3 - paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (V == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        V = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return V;
  }
  
  public int a(Rect paramRect)
  {
    int i = getChildCount();
    int j = 0;
    if (i == 0) {
      return 0;
    }
    int k = getHeight();
    i = getScrollY();
    int m = i + k;
    int n = getVerticalFadingEdgeLength();
    int i1 = i;
    if (top > 0) {
      i1 = i + n;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    if (bottom < localView.getHeight() + topMargin + bottomMargin) {
      n = m - n;
    } else {
      n = m;
    }
    if ((bottom > n) && (top > i1))
    {
      if (paramRect.height() > k) {
        i = top - i1;
      } else {
        i = bottom - n;
      }
      i = Math.min(i + 0, localView.getBottom() + bottomMargin - m);
    }
    else
    {
      i = j;
      if (top < i1)
      {
        i = j;
        if (bottom < n)
        {
          if (paramRect.height() > k) {
            i = 0 - (n - bottom);
          } else {
            i = 0 - (i1 - top);
          }
          i = Math.max(i, -getScrollY());
        }
      }
    }
    return i;
  }
  
  public final void a()
  {
    z.abortAnimation();
    U.c(1);
  }
  
  public void a(int paramInt)
  {
    U.c(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - x > 250L)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getHeight();
      int j = topMargin;
      int k = bottomMargin;
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, Math.max(0, i + j + k - (m - n - i1))));
      z.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      a(paramBoolean);
    }
    else
    {
      if (!z.isFinished()) {
        a();
      }
      scrollBy(paramInt1, paramInt2);
    }
    x = AnimationUtils.currentAnimationTimeMillis();
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = getScrollY();
    scrollBy(0, paramInt1);
    i = getScrollY() - i;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += i;
    }
    U.a(0, i, 0, paramInt1 - i, null, paramInt2, paramArrayOfInt);
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == N)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      C = ((int)paramMotionEvent.getY(i));
      N = paramMotionEvent.getPointerId(i);
      paramMotionEvent = H;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  public final void a(View paramView)
  {
    paramView.getDrawingRect(y);
    offsetDescendantRectToMyCoords(paramView, y);
    int i = a(y);
    if (i != 0) {
      scrollBy(0, i);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = T;
    if (paramInt == 1) {
      b = 0;
    } else {
      a = 0;
    }
    U.c(paramInt);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramInt4, paramInt5, null);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    a(paramInt4, paramInt5, paramArrayOfInt);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    paramView1 = T;
    if (paramInt2 == 1) {
      b = paramInt1;
    } else {
      a = paramInt1;
    }
    a(2, paramInt2);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(2, 1);
    } else {
      U.c(1);
    }
    R = getScrollY();
    n.x(this);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return U.a(paramInt1, paramInt2);
  }
  
  public final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getHeight();
    int j = getScrollY();
    int k = i + j;
    int m;
    if (paramInt1 == 33) {
      m = 1;
    } else {
      m = 0;
    }
    ArrayList localArrayList = getFocusables(2);
    int n = localArrayList.size();
    Object localObject1 = null;
    int i1 = 0;
    int i5;
    for (int i2 = 0; i1 < n; i2 = i5)
    {
      View localView = (View)localArrayList.get(i1);
      int i3 = localView.getTop();
      int i4 = localView.getBottom();
      localObject2 = localObject1;
      i5 = i2;
      if (paramInt2 < i4)
      {
        localObject2 = localObject1;
        i5 = i2;
        if (i3 < paramInt3)
        {
          if ((paramInt2 < i3) && (i4 < paramInt3)) {
            i = 1;
          } else {
            i = 0;
          }
          if (localObject1 == null)
          {
            localObject2 = localView;
            i5 = i;
          }
          else
          {
            if (((m != 0) && (i3 < ((View)localObject1).getTop())) || ((m == 0) && (i4 > ((View)localObject1).getBottom()))) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            if (i2 != 0)
            {
              localObject2 = localObject1;
              i5 = i2;
              if (i == 0) {
                break label268;
              }
              localObject2 = localObject1;
              i5 = i2;
              if (i4 == 0) {
                break label268;
              }
            }
            else
            {
              if (i != 0)
              {
                localObject2 = localView;
                i5 = 1;
                break label268;
              }
              localObject2 = localObject1;
              i5 = i2;
              if (i4 == 0) {
                break label268;
              }
            }
            localObject2 = localView;
            i5 = i2;
          }
        }
      }
      label268:
      i1++;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this;
    }
    boolean bool;
    if ((paramInt2 >= j) && (paramInt3 <= k))
    {
      bool = false;
    }
    else
    {
      if (m != 0) {
        paramInt2 -= j;
      } else {
        paramInt2 = paramInt3 - k;
      }
      c(paramInt2);
      bool = true;
    }
    if (localObject2 != findFocus()) {
      ((View)localObject2).requestFocus(paramInt1);
    }
    return bool;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = getOverScrollMode();
    int j = super.computeHorizontalScrollRange();
    int k = super.computeHorizontalScrollExtent();
    boolean bool = false;
    if (j > k) {
      k = 1;
    } else {
      k = 0;
    }
    if (computeVerticalScrollRange() > super.computeVerticalScrollExtent()) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && ((i != 1) || (k == 0))) {
      k = 0;
    } else {
      k = 1;
    }
    if ((i != 0) && ((i != 1) || (j == 0))) {
      j = 0;
    } else {
      j = 1;
    }
    paramInt3 += paramInt1;
    if (k == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramInt7;
    }
    paramInt4 += paramInt2;
    if (j == 0) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt8;
    }
    paramInt7 = -paramInt1;
    paramInt1 += paramInt5;
    paramInt5 = -paramInt2;
    paramInt6 = paramInt2 + paramInt6;
    if (paramInt3 > paramInt1) {}
    for (;;)
    {
      paramInt3 = 1;
      paramInt2 = paramInt1;
      break label198;
      if (paramInt3 >= paramInt7) {
        break;
      }
      paramInt1 = paramInt7;
    }
    paramInt1 = 0;
    paramInt2 = paramInt3;
    paramInt3 = paramInt1;
    label198:
    if (paramInt4 > paramInt6) {}
    for (paramInt1 = paramInt6;; paramInt1 = paramInt5)
    {
      paramInt4 = 1;
      break label237;
      if (paramInt4 >= paramInt5) {
        break;
      }
    }
    paramInt5 = 0;
    paramInt1 = paramInt4;
    paramInt4 = paramInt5;
    label237:
    if ((paramInt4 != 0) && (!f(1))) {
      z.springBack(paramInt2, paramInt1, 0, 0, 0, getScrollRange());
    }
    super.scrollTo(paramInt2, paramInt1);
    if ((paramInt3 != 0) || (paramInt4 != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return U.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    y.setEmpty();
    int i = getChildCount();
    boolean bool1 = true;
    boolean bool2 = false;
    Object localObject;
    if (i > 0)
    {
      localObject = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (((View)localObject).getHeight() + topMargin + bottomMargin > getHeight() - getPaddingTop() - getPaddingBottom())
      {
        i = 1;
        break label79;
      }
    }
    i = 0;
    label79:
    if (i == 0)
    {
      if ((isFocused()) && (paramKeyEvent.getKeyCode() != 4))
      {
        localObject = findFocus();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == this) {
          paramKeyEvent = null;
        }
        paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
        if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
          bool1 = false;
        }
        return bool1;
      }
      return false;
    }
    bool1 = bool2;
    if (paramKeyEvent.getAction() == 0)
    {
      int j = paramKeyEvent.getKeyCode();
      i = 33;
      if (j != 19)
      {
        if (j != 20)
        {
          if (j != 62)
          {
            bool1 = bool2;
          }
          else
          {
            if (!paramKeyEvent.isShiftPressed()) {
              i = 130;
            }
            if (i == 130) {
              j = 1;
            } else {
              j = 0;
            }
            int k = getHeight();
            if (j != 0)
            {
              y.top = (getScrollY() + k);
              j = getChildCount();
              if (j > 0)
              {
                paramKeyEvent = getChildAt(j - 1);
                localObject = (FrameLayout.LayoutParams)paramKeyEvent.getLayoutParams();
                int m = paramKeyEvent.getBottom();
                j = bottomMargin;
                j = getPaddingBottom() + (m + j);
                paramKeyEvent = y;
                if (top + k > j) {
                  top = (j - k);
                }
              }
            }
            else
            {
              y.top = (getScrollY() - k);
              paramKeyEvent = y;
              if (top < 0) {
                top = 0;
              }
            }
            paramKeyEvent = y;
            j = top;
            k += j;
            bottom = k;
            a(i, j, k);
            bool1 = bool2;
          }
        }
        else if (!paramKeyEvent.isAltPressed()) {
          bool1 = b(130);
        } else {
          bool1 = e(130);
        }
      }
      else if (!paramKeyEvent.isAltPressed()) {
        bool1 = b(33);
      } else {
        bool1 = e(33);
      }
    }
    return bool1;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(y);
    offsetDescendantRectToMyCoords(paramView, y);
    boolean bool;
    if ((y.bottom + paramInt1 >= getScrollY()) && (y.top - paramInt1 <= getScrollY() + paramInt2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public final void b()
  {
    G = false;
    d();
    U.c(0);
    EdgeEffect localEdgeEffect = A;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      B.onRelease();
    }
  }
  
  public boolean b(int paramInt)
  {
    View localView1 = findFocus();
    View localView2 = localView1;
    if (localView1 == this) {
      localView2 = null;
    }
    localView1 = FocusFinder.getInstance().findNextFocus(this, localView2, paramInt);
    int i = getMaxScrollAmount();
    if ((localView1 != null) && (a(localView1, i, getHeight())))
    {
      localView1.getDrawingRect(y);
      offsetDescendantRectToMyCoords(localView1, y);
      c(a(y));
      localView1.requestFocus(paramInt);
    }
    else
    {
      int j;
      if ((paramInt == 33) && (getScrollY() < i))
      {
        j = getScrollY();
      }
      else
      {
        j = i;
        if (paramInt == 130)
        {
          j = i;
          if (getChildCount() > 0)
          {
            localView1 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView1.getLayoutParams();
            j = localView1.getBottom();
            int k = bottomMargin;
            int m = getScrollY();
            j = Math.min(j + k - (getHeight() + m - getPaddingBottom()), i);
          }
        }
      }
      if (j == 0) {
        return false;
      }
      if (paramInt != 130) {
        j = -j;
      }
      c(j);
    }
    if ((localView2 != null) && (localView2.isFocused()) && ((a(localView2, 0, getHeight()) ^ true)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  public boolean b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void c()
  {
    if (getOverScrollMode() != 2)
    {
      if (A == null)
      {
        Context localContext = getContext();
        A = new EdgeEffect(localContext);
        B = new EdgeEffect(localContext);
      }
    }
    else
    {
      A = null;
      B = null;
    }
  }
  
  public final void c(int paramInt)
  {
    if (paramInt != 0) {
      if (J) {
        a(0, paramInt, false);
      } else {
        scrollBy(0, paramInt);
      }
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    if (z.isFinished()) {
      return;
    }
    z.computeScrollOffset();
    int i = z.getCurrY();
    int j = i - R;
    R = i;
    int[] arrayOfInt1 = P;
    int k = 0;
    arrayOfInt1[1] = 0;
    a(0, j, arrayOfInt1, null, 1);
    i = j - P[1];
    int m = getScrollRange();
    j = i;
    if (i != 0)
    {
      j = getScrollY();
      a(0, i, getScrollX(), j, 0, m, 0, 0);
      j = getScrollY() - j;
      i -= j;
      int[] arrayOfInt2 = P;
      arrayOfInt2[1] = 0;
      arrayOfInt1 = O;
      U.a(0, j, 0, i, arrayOfInt1, 1, arrayOfInt2);
      j = i - P[1];
    }
    if (j != 0)
    {
      int n = getOverScrollMode();
      if (n != 0)
      {
        i = k;
        if (n == 1)
        {
          i = k;
          if (m <= 0) {}
        }
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        c();
        if (j < 0)
        {
          if (A.isFinished()) {
            A.onAbsorb((int)z.getCurrVelocity());
          }
        }
        else if (B.isFinished()) {
          B.onAbsorb((int)z.getCurrVelocity());
        }
      }
      a();
    }
    if (!z.isFinished()) {
      n.x(this);
    } else {
      U.c(1);
    }
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int i = getChildCount();
    int j = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i == 0) {
      return j;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    i = localView.getBottom() + bottomMargin;
    int k = getScrollY();
    int m = Math.max(0, i - j);
    if (k < 0)
    {
      j = i - k;
    }
    else
    {
      j = i;
      if (k > m) {
        j = i + (k - m);
      }
    }
    return j;
  }
  
  public final void d()
  {
    VelocityTracker localVelocityTracker = H;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      H = null;
    }
  }
  
  public void d(int paramInt)
  {
    if (getChildCount() > 0)
    {
      z.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
      a(true);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((!super.dispatchKeyEvent(paramKeyEvent)) && (!a(paramKeyEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return U.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return U.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return U.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (A != null)
    {
      int i = getScrollY();
      boolean bool = A.isFinished();
      int j = 0;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      if (!bool)
      {
        k = paramCanvas.save();
        m = getWidth();
        n = getHeight();
        i1 = Math.min(0, i);
        if (getClipToPadding())
        {
          i2 = getPaddingLeft();
          m -= getPaddingRight() + i2;
          i2 = getPaddingLeft() + 0;
        }
        else
        {
          i2 = 0;
        }
        i3 = n;
        i4 = i1;
        if (getClipToPadding())
        {
          i4 = getPaddingTop();
          i3 = n - (getPaddingBottom() + i4);
          i4 = i1 + getPaddingTop();
        }
        paramCanvas.translate(i2, i4);
        A.setSize(m, i3);
        if (A.draw(paramCanvas)) {
          n.x(this);
        }
        paramCanvas.restoreToCount(k);
      }
      if (!B.isFinished())
      {
        k = paramCanvas.save();
        i4 = getWidth();
        n = getHeight();
        i1 = Math.max(getScrollRange(), i) + n;
        i2 = j;
        m = i4;
        if (getClipToPadding())
        {
          m = getPaddingLeft();
          m = i4 - (getPaddingRight() + m);
          i2 = 0 + getPaddingLeft();
        }
        i3 = i1;
        i4 = n;
        if (getClipToPadding())
        {
          i4 = getPaddingTop();
          i4 = n - (getPaddingBottom() + i4);
          i3 = i1 - getPaddingBottom();
        }
        paramCanvas.translate(i2 - m, i3);
        paramCanvas.rotate(180.0F, m, 0.0F);
        B.setSize(m, i4);
        if (B.draw(paramCanvas)) {
          n.x(this);
        }
        paramCanvas.restoreToCount(k);
      }
    }
  }
  
  public boolean e(int paramInt)
  {
    int i;
    if (paramInt == 130) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getHeight();
    Object localObject = y;
    top = 0;
    bottom = j;
    if (i != 0)
    {
      i = getChildCount();
      if (i > 0)
      {
        View localView = getChildAt(i - 1);
        localObject = (FrameLayout.LayoutParams)localView.getLayoutParams();
        Rect localRect = y;
        int k = localView.getBottom();
        i = bottomMargin;
        bottom = (getPaddingBottom() + (k + i));
        localObject = y;
        top = (bottom - j);
      }
    }
    localObject = y;
    return a(paramInt, top, bottom);
  }
  
  public boolean f(int paramInt)
  {
    boolean bool;
    if (U.a(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int i = getVerticalFadingEdgeLength();
    int j = getHeight();
    int k = getPaddingBottom();
    k = localView.getBottom() + bottomMargin - getScrollY() - (j - k);
    if (k < i) {
      return k / i;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return T.a();
  }
  
  public int getScrollRange()
  {
    int i = getChildCount();
    int j = 0;
    if (i > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      j = Math.max(0, localView.getHeight() + topMargin + bottomMargin - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return j;
  }
  
  public float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i = getVerticalFadingEdgeLength();
    int j = getScrollY();
    if (j < i) {
      return j / i;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return f(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return U.d;
  }
  
  public void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramInt2 = getPaddingLeft();
    paramView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingRight() + paramInt2, width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt3 = getPaddingLeft();
    paramView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingRight() + paramInt3 + leftMargin + rightMargin + paramInt2, width), View.MeasureSpec.makeMeasureSpec(topMargin + bottomMargin, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    E = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() == 8) && (!G))
    {
      float f = paramMotionEvent.getAxisValue(9);
      if (f != 0.0F)
      {
        int i = (int)(f * getVerticalScrollFactorCompat());
        int j = getScrollRange();
        int k = getScrollY();
        i = k - i;
        if (i < 0) {
          j = 0;
        } else if (i <= j) {
          j = i;
        }
        if (j != k)
        {
          super.scrollTo(getScrollX(), j);
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (G)) {
      return true;
    }
    i &= 0xFF;
    int j;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              break label444;
            }
            a(paramMotionEvent);
            break label444;
          }
        }
        else
        {
          j = N;
          if (j == -1) {
            break label444;
          }
          i = paramMotionEvent.findPointerIndex(j);
          if (i == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(j);
            paramMotionEvent.append(" in onInterceptTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
            break label444;
          }
          i = (int)paramMotionEvent.getY(i);
          if ((Math.abs(i - C) <= K) || ((0x2 & getNestedScrollAxes()) != 0)) {
            break label444;
          }
          G = true;
          C = i;
          if (H == null) {
            H = VelocityTracker.obtain();
          }
          H.addMovement(paramMotionEvent);
          Q = 0;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label444;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label444;
        }
      }
      G = false;
      N = -1;
      d();
      if (z.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        n.x(this);
      }
      U.c(0);
    }
    else
    {
      j = (int)paramMotionEvent.getY();
      int k = (int)paramMotionEvent.getX();
      Object localObject;
      if (getChildCount() > 0)
      {
        i = getScrollY();
        localObject = getChildAt(0);
        if ((j >= ((View)localObject).getTop() - i) && (j < ((View)localObject).getBottom() - i) && (k >= ((View)localObject).getLeft()) && (k < ((View)localObject).getRight()))
        {
          i = 1;
          break label352;
        }
      }
      i = 0;
      label352:
      if (i == 0)
      {
        G = false;
        d();
      }
      else
      {
        C = j;
        N = paramMotionEvent.getPointerId(0);
        localObject = H;
        if (localObject == null) {
          H = VelocityTracker.obtain();
        } else {
          ((VelocityTracker)localObject).clear();
        }
        H.addMovement(paramMotionEvent);
        z.computeScrollOffset();
        G = (z.isFinished() ^ true);
        a(2, 0);
      }
    }
    label444:
    return G;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    D = false;
    View localView = F;
    if ((localView != null) && (a(localView, this))) {
      a(F);
    }
    F = null;
    if (!E)
    {
      if (S != null)
      {
        scrollTo(getScrollX(), S.x);
        S = null;
      }
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight() + topMargin + bottomMargin;
      }
      int i = getPaddingTop();
      int j = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = b(paramInt3, paramInt4 - paramInt2 - i - j, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    E = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!I) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = localView.getMeasuredHeight();
      paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - topMargin - bottomMargin;
      if (i < paramInt2)
      {
        i = getPaddingLeft();
        localView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingRight() + i + leftMargin + rightMargin, width), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      d((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return U.a(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, null, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt4, 0, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    T.a = paramInt;
    a(2, 0);
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i;
    if (paramInt == 2)
    {
      i = 130;
    }
    else
    {
      i = paramInt;
      if (paramInt == 1) {
        i = 33;
      }
    }
    View localView;
    if (paramRect == null) {
      localView = FocusFinder.getInstance().findNextFocus(this, null, i);
    } else {
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i);
    }
    if (localView == null) {
      return false;
    }
    if ((true ^ a(localView, 0, getHeight()))) {
      return false;
    }
    return localView.requestFocus(i, paramRect);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NestedScrollView.c))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NestedScrollView.c)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    S = paramParcelable;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    NestedScrollView.c localc = new NestedScrollView.c(super.onSaveInstanceState());
    x = getScrollY();
    return localc;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = W;
    if (localObject != null)
    {
      localObject = (b)localObject;
      AlertController.a(this, a, b);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView != null) && (this != localView) && (a(localView, 0, paramInt4)))
    {
      localView.getDrawingRect(y);
      offsetDescendantRectToMyCoords(localView, y);
      c(a(y));
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    boolean bool;
    if ((paramInt & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    T.a = 0;
    a(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (H == null) {
      H = VelocityTracker.obtain();
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      Q = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, Q);
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i == 6)
              {
                a(paramMotionEvent);
                C = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(N)));
              }
            }
            else
            {
              i = paramMotionEvent.getActionIndex();
              C = ((int)paramMotionEvent.getY(i));
              N = paramMotionEvent.getPointerId(i);
            }
          }
          else
          {
            if ((G) && (getChildCount() > 0) && (z.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
              n.x(this);
            }
            N = -1;
            b();
          }
        }
        else
        {
          int j = paramMotionEvent.findPointerIndex(N);
          if (j == -1)
          {
            paramMotionEvent = a.a("Invalid pointerId=");
            paramMotionEvent.append(N);
            paramMotionEvent.append(" in onTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
          }
          else
          {
            int k = (int)paramMotionEvent.getY(j);
            int m = C - k;
            i = m;
            if (!G)
            {
              i = m;
              if (Math.abs(m) > K)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
                G = true;
                if (m > 0) {
                  i = m - K;
                } else {
                  i = m + K;
                }
              }
            }
            m = i;
            if (G)
            {
              i = m;
              if (a(0, m, P, O, 0))
              {
                i = m - P[1];
                Q += O[1];
              }
              C = (k - O[1]);
              int n = getScrollY();
              k = getScrollRange();
              m = getOverScrollMode();
              if ((m != 0) && ((m != 1) || (k <= 0))) {
                m = 0;
              } else {
                m = 1;
              }
              if ((a(0, i, 0, getScrollY(), 0, k, 0, 0)) && (!f(0))) {
                H.clear();
              }
              int i1 = getScrollY() - n;
              int[] arrayOfInt = P;
              arrayOfInt[1] = 0;
              localObject = O;
              U.a(0, i1, 0, i - i1, (int[])localObject, 0, arrayOfInt);
              i1 = C;
              localObject = O;
              C = (i1 - localObject[1]);
              Q += localObject[1];
              if (m != 0)
              {
                i -= P[1];
                c();
                m = n + i;
                if (m < 0)
                {
                  A.onPull(i / getHeight(), paramMotionEvent.getX(j) / getWidth());
                  if (!B.isFinished()) {
                    B.onRelease();
                  }
                }
                else if (m > k)
                {
                  B.onPull(i / getHeight(), 1.0F - paramMotionEvent.getX(j) / getWidth());
                  if (!A.isFinished()) {
                    A.onRelease();
                  }
                }
                paramMotionEvent = A;
                if ((paramMotionEvent != null) && ((!paramMotionEvent.isFinished()) || (!B.isFinished()))) {
                  n.x(this);
                }
              }
            }
          }
        }
      }
      else
      {
        paramMotionEvent = H;
        paramMotionEvent.computeCurrentVelocity(1000, M);
        i = (int)paramMotionEvent.getYVelocity(N);
        if (Math.abs(i) >= L)
        {
          i = -i;
          float f = i;
          if (!dispatchNestedPreFling(0.0F, f))
          {
            dispatchNestedFling(0.0F, f, true);
            d(i);
          }
        }
        else if (z.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))
        {
          n.x(this);
        }
        N = -1;
        b();
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      boolean bool = z.isFinished() ^ true;
      G = bool;
      if (bool)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!z.isFinished()) {
        a();
      }
      C = ((int)paramMotionEvent.getY());
      N = paramMotionEvent.getPointerId(0);
      a(2, 0);
    }
    paramMotionEvent = H;
    if (paramMotionEvent != null) {
      paramMotionEvent.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!D) {
      a(paramView2);
    } else {
      F = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i = a(paramRect);
    boolean bool;
    if (i != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      if (paramBoolean) {
        scrollBy(0, i);
      } else {
        a(0, i, false);
      }
    }
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      d();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    D = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = localView.getWidth();
      int n = leftMargin;
      int i1 = rightMargin;
      int i2 = getHeight();
      int i3 = getPaddingTop();
      int i4 = getPaddingBottom();
      int i5 = localView.getHeight();
      int i6 = topMargin;
      int i7 = bottomMargin;
      paramInt1 = b(paramInt1, i - j - k, m + n + i1);
      paramInt2 = b(paramInt2, i2 - i3 - i4, i5 + i6 + i7);
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != I)
    {
      I = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    g localg = U;
    if (d) {
      n.z(c);
    }
    d = paramBoolean;
  }
  
  public void setOnScrollChangeListener(NestedScrollView.b paramb)
  {
    W = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    J = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return U.a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    U.c(0);
  }
}

/* Location:
 * Qualified Name:     base.androidx.core.widget.NestedScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */