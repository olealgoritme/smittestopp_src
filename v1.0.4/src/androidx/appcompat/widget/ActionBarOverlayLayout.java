package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import d.b.a.v;
import d.b.d.g;
import d.b.d.i.m.a;
import d.b.e.c0;
import d.b.e.d0;
import d.b.e.d1;
import d.i.i.h;
import d.i.i.i;
import d.i.i.j;
import d.i.i.n;
import e.a.a.a.a;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements c0, h, i
{
  public static final int[] b0 = { R.attr.actionBarSize, 16842841 };
  public ActionBarContainer A;
  public d0 B;
  public Drawable C;
  public boolean D;
  public boolean E;
  public boolean F;
  public boolean G;
  public boolean H;
  public int I;
  public int J;
  public final Rect K = new Rect();
  public final Rect L = new Rect();
  public final Rect M = new Rect();
  public final Rect N = new Rect();
  public final Rect O = new Rect();
  public final Rect P = new Rect();
  public final Rect Q = new Rect();
  public ActionBarOverlayLayout.d R;
  public OverScroller S;
  public ViewPropertyAnimator T;
  public final AnimatorListenerAdapter U = new ActionBarOverlayLayout.a(this);
  public final Runnable V = new ActionBarOverlayLayout.b(this);
  public final Runnable W = new ActionBarOverlayLayout.c(this);
  public final j a0;
  public int x;
  public int y = 0;
  public ContentFrameLayout z;
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    a0 = new j();
  }
  
  public void a(int paramInt)
  {
    i();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt == 109) {
          setOverlayMode(true);
        }
      }
      else {
        B.o();
      }
    }
    else {
      B.m();
    }
  }
  
  public final void a(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(b0);
    boolean bool1 = false;
    x = localTypedArray.getDimensionPixelSize(0, 0);
    Drawable localDrawable = localTypedArray.getDrawable(1);
    C = localDrawable;
    if (localDrawable == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    setWillNotDraw(bool2);
    localTypedArray.recycle();
    boolean bool2 = bool1;
    if (getApplicationInfotargetSdkVersion < 19) {
      bool2 = true;
    }
    D = bool2;
    S = new OverScroller(paramContext);
  }
  
  public void a(Menu paramMenu, m.a parama)
  {
    i();
    B.a(paramMenu, parama);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramView);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0)
    {
      paramInt1 = I + paramInt2;
      I = paramInt1;
      setActionBarHideOffset(paramInt1);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt5 == 0)
    {
      paramInt1 = I + paramInt2;
      I = paramInt1;
      setActionBarHideOffset(paramInt1);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) {}
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramView1, paramView2, paramInt1);
    }
  }
  
  public boolean a()
  {
    i();
    return B.a();
  }
  
  public final boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramView = (ActionBarOverlayLayout.e)paramView.getLayoutParams();
    boolean bool1 = true;
    int i;
    int j;
    if (paramBoolean1)
    {
      i = leftMargin;
      j = left;
      if (i != j)
      {
        leftMargin = j;
        bool2 = true;
        break label49;
      }
    }
    boolean bool2 = false;
    label49:
    paramBoolean1 = bool2;
    if (paramBoolean2)
    {
      j = topMargin;
      i = top;
      paramBoolean1 = bool2;
      if (j != i)
      {
        topMargin = i;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      i = rightMargin;
      j = right;
      paramBoolean2 = paramBoolean1;
      if (i != j)
      {
        rightMargin = j;
        paramBoolean2 = true;
      }
    }
    if (paramBoolean3)
    {
      i = bottomMargin;
      j = bottom;
      if (i != j)
      {
        bottomMargin = j;
        return bool1;
      }
    }
    paramBoolean1 = paramBoolean2;
    return paramBoolean1;
  }
  
  public boolean b()
  {
    i();
    return B.b();
  }
  
  public boolean b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt2 == 0) && (onStartNestedScroll(paramView1, paramView2, paramInt1))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean c()
  {
    i();
    return B.c();
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ActionBarOverlayLayout.e;
  }
  
  public boolean d()
  {
    i();
    return B.d();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((C != null) && (!D))
    {
      int i;
      if (A.getVisibility() == 0)
      {
        float f = A.getBottom();
        i = (int)(A.getTranslationY() + f + 0.5F);
      }
      else
      {
        i = 0;
      }
      C.setBounds(0, i, getWidth(), C.getIntrinsicHeight() + i);
      C.draw(paramCanvas);
    }
  }
  
  public void e()
  {
    i();
    B.e();
  }
  
  public boolean f()
  {
    i();
    return B.f();
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    i();
    n.o(this);
    boolean bool = a(A, paramRect, true, true, false, true);
    N.set(paramRect);
    d1.a(this, N, K);
    if (!O.equals(N))
    {
      O.set(N);
      bool = true;
    }
    if (!L.equals(K))
    {
      L.set(K);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public void g()
  {
    i();
    B.g();
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ActionBarOverlayLayout.e(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionBarOverlayLayout.e(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ActionBarOverlayLayout.e(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = A;
    int i;
    if (localActionBarContainer != null) {
      i = -(int)localActionBarContainer.getTranslationY();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getNestedScrollAxes()
  {
    return a0.a();
  }
  
  public CharSequence getTitle()
  {
    i();
    return B.getTitle();
  }
  
  public void h()
  {
    removeCallbacks(V);
    removeCallbacks(W);
    ViewPropertyAnimator localViewPropertyAnimator = T;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public void i()
  {
    if (z == null)
    {
      z = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      A = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      View localView = findViewById(R.id.action_bar);
      if ((localView instanceof d0))
      {
        localObject = (d0)localView;
      }
      else
      {
        if (!(localView instanceof Toolbar)) {
          break label81;
        }
        localObject = ((Toolbar)localView).getWrapper();
      }
      B = ((d0)localObject);
      return;
      label81:
      Object localObject = a.a("Can't make a decor toolbar out of ");
      ((StringBuilder)localObject).append(localView.getClass().getSimpleName());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    n.y(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt4 = getPaddingLeft();
    getPaddingRight();
    paramInt3 = getPaddingTop();
    getPaddingBottom();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        ActionBarOverlayLayout.e locale = (ActionBarOverlayLayout.e)localView.getLayoutParams();
        int i = localView.getMeasuredWidth();
        int j = localView.getMeasuredHeight();
        int k = leftMargin + paramInt4;
        int m = topMargin + paramInt3;
        localView.layout(k, m, i + k, j + m);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    i();
    measureChildWithMargins(A, paramInt1, 0, paramInt2, 0);
    Object localObject = (ActionBarOverlayLayout.e)A.getLayoutParams();
    int i = Math.max(0, A.getMeasuredWidth() + leftMargin + rightMargin);
    int j = Math.max(0, A.getMeasuredHeight() + topMargin + bottomMargin);
    int k = View.combineMeasuredStates(0, A.getMeasuredState());
    if ((n.o(this) & 0x100) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      n = x;
      i1 = n;
      if (F)
      {
        i1 = n;
        if (A.getTabContainer() != null) {
          i1 = n + x;
        }
      }
    }
    else if (A.getVisibility() != 8)
    {
      i1 = A.getMeasuredHeight();
    }
    else
    {
      i1 = 0;
    }
    M.set(K);
    P.set(N);
    if ((!E) && (m == 0))
    {
      localObject = M;
      top += i1;
      bottom += 0;
    }
    else
    {
      localObject = P;
      top += i1;
      bottom += 0;
    }
    a(z, M, true, true, true, true);
    if (!Q.equals(P))
    {
      Q.set(P);
      z.a(P);
    }
    measureChildWithMargins(z, paramInt1, 0, paramInt2, 0);
    localObject = (ActionBarOverlayLayout.e)z.getLayoutParams();
    int i1 = Math.max(i, z.getMeasuredWidth() + leftMargin + rightMargin);
    j = Math.max(j, z.getMeasuredHeight() + topMargin + bottomMargin);
    int n = View.combineMeasuredStates(k, z.getMeasuredState());
    k = getPaddingLeft();
    int m = getPaddingRight();
    i = getPaddingTop();
    j = Math.max(getPaddingBottom() + i + j, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(m + k + i1, getSuggestedMinimumWidth()), paramInt1, n), View.resolveSizeAndState(j, paramInt2, n << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool = G;
    int i = 0;
    if ((bool) && (paramBoolean))
    {
      S.fling(0, 0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
      if (S.getFinalY() > A.getHeight()) {
        i = 1;
      }
      if (i != 0)
      {
        h();
        W.run();
      }
      else
      {
        h();
        V.run();
      }
      H = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = I + paramInt2;
    I = paramInt1;
    setActionBarHideOffset(paramInt1);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    a0.a = paramInt;
    I = getActionBarHideOffset();
    h();
    paramView1 = R;
    if (paramView1 != null)
    {
      paramView1 = (v)paramView1;
      paramView2 = u;
      if (paramView2 != null)
      {
        paramView2.a();
        u = null;
      }
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (A.getVisibility() == 0)) {
      return G;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((G) && (!H)) {
      if (I <= A.getHeight())
      {
        h();
        postDelayed(V, 600L);
      }
      else
      {
        h();
        postDelayed(W, 600L);
      }
    }
    paramView = R;
    if ((paramView != null) && ((v)paramView == null)) {
      throw null;
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    super.onWindowSystemUiVisibilityChanged(paramInt);
    i();
    int i = J;
    J = paramInt;
    int j;
    if ((paramInt & 0x4) == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((paramInt & 0x100) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    Object localObject = R;
    if (localObject != null)
    {
      p = (k ^ 0x1);
      if ((j == 0) && (k != 0))
      {
        localObject = (v)localObject;
        if (!r)
        {
          r = true;
          ((v)localObject).g(true);
        }
      }
      else
      {
        localObject = (v)R;
        if (r)
        {
          r = false;
          ((v)localObject).g(true);
        }
      }
    }
    if ((((i ^ paramInt) & 0x100) != 0) && (R != null)) {
      n.y(this);
    }
  }
  
  public void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    y = paramInt;
    ActionBarOverlayLayout.d locald = R;
    if (locald != null) {
      o = paramInt;
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    h();
    paramInt = Math.max(0, Math.min(paramInt, A.getHeight()));
    A.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarOverlayLayout.d paramd)
  {
    R = paramd;
    if (getWindowToken() != null)
    {
      paramd = R;
      int i = y;
      o = i;
      i = J;
      if (i != 0)
      {
        onWindowSystemUiVisibilityChanged(i);
        n.y(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != G)
    {
      G = paramBoolean;
      if (!paramBoolean)
      {
        h();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    i();
    B.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    i();
    B.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    i();
    B.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    E = paramBoolean;
    if ((paramBoolean) && (getContextgetApplicationInfotargetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    D = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    i();
    B.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    i();
    B.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.ActionBarOverlayLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */