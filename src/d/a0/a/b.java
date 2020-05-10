package d.a0.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.g;
import d.i.i.n;
import d.m.a.p;
import d.m.a.w;
import d.m.a.y;
import d.o.g.b;
import h.k.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import no.simula.corona.ui.onboarding.OnboardingActivity.b;
import no.simula.corona.ui.onboarding.OnboardingFragment;
import no.simula.corona.ui.onboarding.PrivavcyOnboardingFragment;

public class b
  extends ViewGroup
{
  public static final int[] w0 = { 16842931 };
  public static final Comparator<b.f> x0 = new b.a();
  public static final Interpolator y0 = new b.b();
  public static final b.l z0 = new b.l();
  public final Rect A = new Rect();
  public a B;
  public int C;
  public int D = -1;
  public Parcelable E = null;
  public ClassLoader F = null;
  public Scroller G;
  public boolean H;
  public b.j I;
  public int J;
  public Drawable K;
  public int L;
  public int M;
  public float N = -3.4028235E38F;
  public float O = Float.MAX_VALUE;
  public int P;
  public boolean Q;
  public boolean R;
  public boolean S;
  public int T = 1;
  public boolean U;
  public boolean V;
  public int W;
  public int a0;
  public int b0;
  public float c0;
  public float d0;
  public float e0;
  public float f0;
  public int g0 = -1;
  public VelocityTracker h0;
  public int i0;
  public int j0;
  public int k0;
  public int l0;
  public EdgeEffect m0;
  public EdgeEffect n0;
  public boolean o0 = true;
  public boolean p0;
  public int q0;
  public List<b.i> r0;
  public b.i s0;
  public ArrayList<View> t0;
  public final Runnable u0 = new b.c(this);
  public int v0 = 0;
  public int x;
  public final ArrayList<b.f> y = new ArrayList();
  public final b.f z = new b.f();
  
  public b(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (R != paramBoolean) {
      R = paramBoolean;
    }
  }
  
  public final Rect a(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    left = paramView.getLeft();
    right = paramView.getRight();
    top = paramView.getTop();
    bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      int i = left;
      left = (paramRect.getLeft() + i);
      i = right;
      right = (paramRect.getRight() + i);
      i = top;
      top = (paramRect.getTop() + i);
      i = bottom;
      bottom = (paramRect.getBottom() + i);
    }
    return localRect;
  }
  
  public b.f a(int paramInt1, int paramInt2)
  {
    b.f localf = new b.f();
    b = paramInt1;
    w localw = (w)B;
    Object localObject1;
    if (e.size() > paramInt1)
    {
      localObject1 = (Fragment)e.get(paramInt1);
      if (localObject1 != null) {}
    }
    else
    {
      if (c == null)
      {
        localObject2 = a;
        if (localObject2 != null) {
          c = new d.m.a.a((p)localObject2);
        } else {
          throw null;
        }
      }
      Object localObject2 = (OnboardingActivity.b)localw;
      if (paramInt1 != 0)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              localObject1 = h.getString(2131886232);
              g.a(localObject1, "getString(R.string.title1)");
              localObject2 = h.getString(2131886214);
              g.a(localObject2, "getString(R.string.register)");
              localObject2 = OnboardingFragment.a(paramInt1, (String)localObject1, 2131886197, 2131230862, (String)localObject2);
            }
            else
            {
              localObject1 = h.getString(2131886235);
              g.a(localObject1, "getString(R.string.title4)");
              localObject2 = h.getString(2131886214);
              g.a(localObject2, "getString(R.string.register)");
              localObject2 = OnboardingFragment.a(paramInt1, (String)localObject1, 2131886199, 2131230887, (String)localObject2);
            }
          }
          else
          {
            localObject1 = h.getString(2131886234);
            g.a(localObject1, "getString(R.string.title3)");
            String str = h.getString(2131886213);
            g.a(str, "getString(R.string.read_privavcy)");
            localObject2 = new PrivavcyOnboardingFragment();
            Bundle localBundle = new Bundle();
            localBundle.putString("mainText", (String)localObject1);
            localBundle.putInt("pageNo", paramInt1);
            localBundle.putString("buttonTextRId", str);
            ((Fragment)localObject2).setArguments(localBundle);
          }
        }
        else
        {
          localObject1 = h.getString(2131886233);
          g.a(localObject1, "getString(R.string.title2)");
          localObject2 = h.getString(2131886193);
          g.a(localObject2, "getString(R.string.next)");
          localObject2 = OnboardingFragment.a(paramInt1, (String)localObject1, 2131886198, 2131230890, (String)localObject2);
        }
      }
      else
      {
        localObject1 = h.getString(2131886232);
        g.a(localObject1, "getString(R.string.title1)");
        localObject2 = h.getString(2131886193);
        g.a(localObject2, "getString(R.string.next)");
        localObject2 = OnboardingFragment.a(paramInt1, (String)localObject1, 2131886197, 2131230862, (String)localObject2);
      }
      if (d.size() > paramInt1)
      {
        localObject1 = (Fragment.g)d.get(paramInt1);
        if (localObject1 != null) {
          ((Fragment)localObject2).setInitialSavedState((Fragment.g)localObject1);
        }
      }
      while (e.size() <= paramInt1) {
        e.add(null);
      }
      ((Fragment)localObject2).setMenuVisibility(false);
      if (b == 0) {
        ((Fragment)localObject2).setUserVisibleHint(false);
      }
      e.set(paramInt1, localObject2);
      c.a(getId(), (Fragment)localObject2, null, 1);
      localObject1 = localObject2;
      if (b == 1)
      {
        c.a((Fragment)localObject2, g.b.STARTED);
        localObject1 = localObject2;
      }
    }
    a = localObject1;
    if (B != null)
    {
      d = 1.0F;
      if ((paramInt2 >= 0) && (paramInt2 < y.size())) {
        y.add(paramInt2, localf);
      } else {
        y.add(localf);
      }
      return localf;
    }
    throw null;
  }
  
  public b.f a(View paramView)
  {
    int i = 0;
    while (i < y.size())
    {
      b.f localf = (b.f)y.get(i);
      a locala = B;
      Object localObject = a;
      if ((w)locala != null)
      {
        int j;
        if (((Fragment)localObject).getView() == paramView) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          return localf;
        }
        i++;
      }
      else
      {
        throw null;
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((OnboardingActivity.b)B != null)
    {
      x = 4;
      int i;
      if ((y.size() < T * 2 + 1) && (y.size() < 4)) {
        i = 1;
      } else {
        i = 0;
      }
      int j = C;
      int k = 0;
      Object localObject2;
      while (k < y.size())
      {
        Object localObject1 = (b.f)y.get(k);
        localObject2 = B;
        localObject1 = a;
        if (localObject2 != null) {
          k++;
        } else {
          throw null;
        }
      }
      Collections.sort(y, x0);
      if (i != 0)
      {
        k = getChildCount();
        for (i = 0; i < k; i++)
        {
          localObject2 = (b.g)getChildAt(i).getLayoutParams();
          if (!a) {
            c = 0.0F;
          }
        }
        a(j, false, true, 0);
        requestLayout();
      }
      return;
    }
    throw null;
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i = q0;
    int j = 0;
    int m;
    if (i > 0)
    {
      int k = getScrollX();
      i = getPaddingLeft();
      m = getPaddingRight();
      int n = getWidth();
      int i1 = getChildCount();
      for (int i2 = 0; i2 < i1; i2++)
      {
        View localView = getChildAt(i2);
        localObject = (b.g)localView.getLayoutParams();
        if (a)
        {
          int i3 = b & 0x7;
          if (i3 != 1)
          {
            int i4;
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i4 = i;
                i3 = i;
                i = i4;
              }
              else
              {
                i3 = n - m - localView.getMeasuredWidth();
                m += localView.getMeasuredWidth();
              }
            }
            else
            {
              i4 = localView.getWidth() + i;
              i3 = i;
              i = i4;
            }
          }
          else
          {
            i3 = Math.max((n - localView.getMeasuredWidth()) / 2, i);
          }
          i3 = i3 + k - localView.getLeft();
          if (i3 != 0) {
            localView.offsetLeftAndRight(i3);
          }
        }
      }
    }
    Object localObject = s0;
    if (localObject != null) {
      ((b.i)localObject).a(paramInt1, paramFloat, paramInt2);
    }
    localObject = r0;
    if (localObject != null)
    {
      m = ((List)localObject).size();
      for (i = j; i < m; i++)
      {
        localObject = (b.i)r0.get(i);
        if (localObject != null) {
          ((b.i)localObject).a(paramInt1, paramFloat, paramInt2);
        }
      }
    }
    p0 = true;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!y.isEmpty()))
    {
      if (!G.isFinished())
      {
        G.setFinalX(getCurrentItem() * getClientWidth());
      }
      else
      {
        int i = getPaddingLeft();
        int j = getPaddingRight();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      }
    }
    else
    {
      b.f localf = c(C);
      float f;
      if (localf != null) {
        f = Math.min(e, O);
      } else {
        f = 0.0F;
      }
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 != getScrollX())
      {
        a(false);
        scrollTo(paramInt1, getScrollY());
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    S = false;
    a(paramInt, paramBoolean, false, 0);
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Object localObject = c(paramInt1);
    float f1;
    int i;
    if (localObject != null)
    {
      f1 = getClientWidth();
      i = (int)(Math.max(N, Math.min(e, O)) * f1);
    }
    else
    {
      i = 0;
    }
    if (paramBoolean1)
    {
      if (getChildCount() == 0)
      {
        setScrollingCacheEnabled(false);
      }
      else
      {
        localObject = G;
        int j;
        if ((localObject != null) && (!((Scroller)localObject).isFinished())) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          if (H) {
            j = G.getCurrX();
          } else {
            j = G.getStartX();
          }
          G.abortAnimation();
          setScrollingCacheEnabled(false);
        }
        else
        {
          j = getScrollX();
        }
        int k = getScrollY();
        i -= j;
        int m = 0 - k;
        if ((i == 0) && (m == 0))
        {
          a(false);
          e(C);
          setScrollState(0);
        }
        else
        {
          setScrollingCacheEnabled(true);
          setScrollState(2);
          int n = getClientWidth();
          int i1 = n / 2;
          float f2 = Math.abs(i);
          f1 = n;
          float f3 = Math.min(1.0F, f2 * 1.0F / f1);
          f2 = i1;
          f3 = (float)Math.sin((f3 - 0.5F) * 0.47123894F);
          paramInt2 = Math.abs(paramInt2);
          if (paramInt2 > 0)
          {
            paramInt2 = Math.round(Math.abs((f3 * f2 + f2) / paramInt2) * 1000.0F) * 4;
          }
          else
          {
            if (B == null) {
              break label385;
            }
            paramInt2 = (int)((Math.abs(i) / (f1 * 1.0F + J) + 1.0F) * 100.0F);
          }
          paramInt2 = Math.min(paramInt2, 600);
          H = false;
          G.startScroll(j, k, i, m, paramInt2);
          n.x(this);
        }
      }
      if (paramBoolean2)
      {
        b(paramInt1);
        return;
        label385:
        throw null;
      }
    }
    else
    {
      if (paramBoolean2) {
        b(paramInt1);
      }
      a(false);
      scrollTo(i, 0);
      d(i);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    a locala = B;
    boolean bool = false;
    if (locala != null)
    {
      if ((OnboardingActivity.b)locala != null)
      {
        if ((!paramBoolean2) && (C == paramInt1) && (y.size() != 0))
        {
          setScrollingCacheEnabled(false);
          return;
        }
        int i;
        if (paramInt1 < 0)
        {
          i = 0;
        }
        else
        {
          locala = B;
          if ((OnboardingActivity.b)locala == null) {
            break label222;
          }
          i = paramInt1;
          if (paramInt1 >= 4) {
            if ((OnboardingActivity.b)locala != null) {
              i = 3;
            } else {
              throw null;
            }
          }
        }
        paramInt1 = T;
        int j = C;
        if ((i > j + paramInt1) || (i < j - paramInt1)) {
          for (paramInt1 = 0; paramInt1 < y.size(); paramInt1++) {
            y.get(paramInt1)).c = true;
          }
        }
        paramBoolean2 = bool;
        if (C != i) {
          paramBoolean2 = true;
        }
        if (o0)
        {
          C = i;
          if (paramBoolean2) {
            b(i);
          }
          requestLayout();
        }
        else
        {
          e(i);
          a(i, paramBoolean1, paramInt2, paramBoolean2);
        }
        return;
        label222:
        throw null;
      }
      throw null;
    }
    setScrollingCacheEnabled(false);
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == g0)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      c0 = paramMotionEvent.getX(i);
      g0 = paramMotionEvent.getPointerId(i);
      paramMotionEvent = h0;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i;
    if (v0 == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setScrollingCacheEnabled(false);
      if ((G.isFinished() ^ true))
      {
        G.abortAnimation();
        int j = getScrollX();
        k = getScrollY();
        int m = G.getCurrX();
        int n = G.getCurrY();
        if ((j != m) || (k != n))
        {
          scrollTo(m, n);
          if (m != j) {
            d(m);
          }
        }
      }
    }
    S = false;
    for (int k = 0; k < y.size(); k++)
    {
      b.f localf = (b.f)y.get(k);
      if (c)
      {
        c = false;
        i = 1;
      }
    }
    if (i != 0) {
      if (paramBoolean) {
        n.a(this, u0);
      } else {
        u0.run();
      }
    }
  }
  
  public final boolean a(float paramFloat)
  {
    float f1 = c0;
    c0 = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = N * f3;
    f1 = O * f3;
    Object localObject1 = y;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    localObject1 = (b.f)((ArrayList)localObject1).get(0);
    Object localObject2 = y;
    localObject2 = (b.f)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    int i;
    if (b != 0)
    {
      paramFloat = e * f3;
      i = 0;
    }
    else
    {
      i = 1;
    }
    int j = b;
    if ((OnboardingActivity.b)B != null)
    {
      if (j != 3)
      {
        f1 = e * f3;
        j = 0;
      }
      else
      {
        j = 1;
      }
      if (f2 < paramFloat)
      {
        if (i != 0)
        {
          m0.onPull(Math.abs(paramFloat - f2) / f3);
          bool3 = true;
        }
      }
      else
      {
        bool3 = bool2;
        paramFloat = f2;
        if (f2 > f1)
        {
          bool3 = bool1;
          if (j != 0)
          {
            n0.onPull(Math.abs(f2 - f1) / f3);
            bool3 = true;
          }
          paramFloat = f1;
        }
      }
      f1 = c0;
      i = (int)paramFloat;
      c0 = (paramFloat - i + f1);
      scrollTo(i, getScrollY());
      d(i);
      return bool3;
    }
    throw null;
  }
  
  public boolean a(int paramInt)
  {
    View localView = findFocus();
    boolean bool = false;
    Object localObject;
    int i;
    if (localView != this)
    {
      localObject = localView;
      if (localView != null)
      {
        for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
          if (localObject == this)
          {
            i = 1;
            break label63;
          }
        }
        i = 0;
        label63:
        localObject = localView;
        if (i == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView.getClass().getSimpleName());
          for (localObject = localView.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject.getClass().getSimpleName());
          }
          localObject = e.a.a.a.a.a("arrowScroll tried to find focus based on non-child current focused view ");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          Log.e("ViewPager", ((StringBuilder)localObject).toString());
        }
      }
    }
    else
    {
      localObject = null;
    }
    localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    int j;
    if ((localView != null) && (localView != localObject)) {
      if (paramInt == 17)
      {
        i = aA, localView).left;
        j = aA, (View)localObject).left;
        if ((localObject != null) && (i >= j)) {
          bool = d();
        } else {
          bool = localView.requestFocus();
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt == 66)
      {
        j = aA, localView).left;
        i = aA, (View)localObject).left;
        if ((localObject != null) && (j <= i))
        {
          bool = e();
        }
        else
        {
          bool = localView.requestFocus();
          continue;
          if ((paramInt != 17) && (paramInt != 1))
          {
            if ((paramInt == 66) || (paramInt == 2)) {
              bool = e();
            }
          }
          else {
            bool = d();
          }
        }
      }
    }
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  public boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool1 = paramView instanceof ViewGroup;
    boolean bool2 = true;
    if (bool1)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = paramView.getScrollX();
      int j = paramView.getScrollY();
      for (int k = localViewGroup.getChildCount() - 1; k >= 0; k--)
      {
        View localView = localViewGroup.getChildAt(k);
        int m = paramInt2 + i;
        if ((m >= localView.getLeft()) && (m < localView.getRight()))
        {
          int n = paramInt3 + j;
          if ((n >= localView.getTop()) && (n < localView.getBottom()) && (a(localView, true, paramInt1, m - localView.getLeft(), n - localView.getTop()))) {
            return true;
          }
        }
      }
    }
    if ((paramBoolean) && (paramView.canScrollHorizontally(-paramInt1))) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216) {
      for (int k = 0; k < getChildCount(); k++)
      {
        View localView = getChildAt(k);
        if (localView.getVisibility() == 0)
        {
          b.f localf = a(localView);
          if ((localf != null) && (b == C)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
    }
    if ((j != 262144) || (i == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      paramArrayList.add(this);
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b.f localf = a(localView);
        if ((localf != null) && (b == C)) {
          localView.addTouchables(paramArrayList);
        }
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localObject = new b.g();
    }
    paramLayoutParams = (b.g)localObject;
    boolean bool1 = a;
    boolean bool2;
    if (paramView.getClass().getAnnotation(b.e.class) != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    bool1 |= bool2;
    a = bool1;
    if (Q)
    {
      if (!bool1)
      {
        d = true;
        addViewInLayout(paramView, paramInt, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
    }
    else {
      super.addView(paramView, paramInt, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public final b.f b()
  {
    int i = getClientWidth();
    float f1 = 0.0F;
    float f2;
    if (i > 0) {
      f2 = getScrollX() / i;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if (i > 0) {
      f3 = J / i;
    } else {
      f3 = 0.0F;
    }
    Object localObject = null;
    float f4 = 0.0F;
    int j = -1;
    i = 0;
    int k = 1;
    while (i < y.size())
    {
      b.f localf1 = (b.f)y.get(i);
      int m = i;
      b.f localf2 = localf1;
      if (k == 0)
      {
        int n = b;
        j++;
        m = i;
        localf2 = localf1;
        if (n != j)
        {
          localf2 = z;
          e = (f1 + f4 + f3);
          b = j;
          if (B != null)
          {
            d = 1.0F;
            m = i - 1;
          }
          else
          {
            throw null;
          }
        }
      }
      f1 = e;
      f4 = d;
      if ((k == 0) && (f2 < f1)) {
        return (b.f)localObject;
      }
      if ((f2 >= f4 + f1 + f3) && (m != y.size() - 1))
      {
        j = b;
        f4 = d;
        i = m + 1;
        k = 0;
        localObject = localf2;
      }
      else
      {
        return localf2;
      }
    }
    return (b.f)localObject;
  }
  
  public final void b(int paramInt)
  {
    Object localObject = s0;
    if (localObject != null) {
      ((b.i)localObject).b(paramInt);
    }
    localObject = r0;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (b.i)r0.get(i);
        if (localObject != null) {
          ((b.i)localObject).b(paramInt);
        }
        i++;
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public b.f c(int paramInt)
  {
    for (int i = 0; i < y.size(); i++)
    {
      b.f localf = (b.f)y.get(i);
      if (b == paramInt) {
        return localf;
      }
    }
    return null;
  }
  
  public void c()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    G = new Scroller(localContext, y0);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = getResourcesgetDisplayMetricsdensity;
    b0 = localViewConfiguration.getScaledPagingTouchSlop();
    i0 = ((int)(400.0F * f));
    j0 = localViewConfiguration.getScaledMaximumFlingVelocity();
    m0 = new EdgeEffect(localContext);
    n0 = new EdgeEffect(localContext);
    k0 = ((int)(25.0F * f));
    l0 = ((int)(2.0F * f));
    W = ((int)(f * 16.0F));
    n.a(this, new b.h(this));
    if (getImportantForAccessibility() == 0) {
      setImportantForAccessibility(1);
    }
    n.a(this, new b.d(this));
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    a locala = B;
    boolean bool1 = false;
    boolean bool2 = false;
    if (locala == null) {
      return false;
    }
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0)
    {
      if (j > (int)(i * N)) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if (j < (int)(i * O)) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof b.g)) && (super.checkLayoutParams(paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void computeScroll()
  {
    H = true;
    if ((!G.isFinished()) && (G.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = G.getCurrX();
      int m = G.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!d(k))
        {
          G.abortAnimation();
          scrollTo(0, m);
        }
      }
      n.x(this);
      return;
    }
    a(true);
  }
  
  public boolean d()
  {
    int i = C;
    if (i > 0)
    {
      a(i - 1, true);
      return true;
    }
    return false;
  }
  
  public final boolean d(int paramInt)
  {
    if (y.size() == 0)
    {
      if (o0) {
        return false;
      }
      p0 = false;
      a(0, 0.0F, 0);
      if (p0) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    b.f localf = b();
    int i = getClientWidth();
    int j = J;
    float f1 = j;
    float f2 = i;
    f1 /= f2;
    int k = b;
    f2 = (paramInt / f2 - e) / (d + f1);
    paramInt = (int)((i + j) * f2);
    p0 = false;
    a(k, f2, paramInt);
    if (p0) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool1 = super.dispatchKeyEvent(paramKeyEvent);
    boolean bool2 = false;
    if (!bool1)
    {
      if (paramKeyEvent.getAction() == 0)
      {
        int i = paramKeyEvent.getKeyCode();
        if (i != 21)
        {
          if (i != 22)
          {
            if (i == 61)
            {
              if (paramKeyEvent.hasNoModifiers())
              {
                bool1 = a(2);
                break label136;
              }
              if (paramKeyEvent.hasModifiers(1))
              {
                bool1 = a(1);
                break label136;
              }
            }
          }
          else
          {
            if (paramKeyEvent.hasModifiers(2))
            {
              bool1 = e();
              break label136;
            }
            bool1 = a(66);
            break label136;
          }
        }
        else
        {
          if (paramKeyEvent.hasModifiers(2))
          {
            bool1 = d();
            break label136;
          }
          bool1 = a(17);
          break label136;
        }
      }
      bool1 = false;
      label136:
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 0)
      {
        b.f localf = a(localView);
        if ((localf != null) && (b == C) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getOverScrollMode();
    int j = 0;
    int k = 0;
    if (i != 0)
    {
      if (i == 1)
      {
        a locala = B;
        if (locala != null)
        {
          if ((OnboardingActivity.b)locala != null) {
            break label65;
          }
          throw null;
        }
      }
      m0.finish();
      n0.finish();
      break label261;
    }
    label65:
    int n;
    int m;
    if (!m0.isFinished())
    {
      j = paramCanvas.save();
      i = getHeight() - getPaddingTop() - getPaddingBottom();
      n = getWidth();
      paramCanvas.rotate(270.0F);
      k = -i;
      paramCanvas.translate(getPaddingTop() + k, N * n);
      m0.setSize(i, n);
      m = false | m0.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
    }
    j = m;
    boolean bool;
    if (!n0.isFinished())
    {
      i = paramCanvas.save();
      int i1 = getWidth();
      j = getHeight();
      n = getPaddingTop();
      int i2 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(O + 1.0F) * i1);
      n0.setSize(j - n - i2, i1);
      bool = m | n0.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    label261:
    if (bool) {
      n.x(this);
    }
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = K;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void e(int paramInt)
  {
    int i = C;
    Object localObject1;
    if (i != paramInt)
    {
      localObject1 = c(i);
      C = paramInt;
    }
    else
    {
      localObject1 = null;
    }
    if (B == null) {
      return;
    }
    if (S) {
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    B.b(this);
    paramInt = T;
    int j = Math.max(0, C - paramInt);
    if ((OnboardingActivity.b)B != null)
    {
      int k = Math.min(3, C + paramInt);
      Object localObject2;
      if (4 == x)
      {
        for (i = 0; i < y.size(); i++)
        {
          localObject2 = (b.f)y.get(i);
          m = b;
          paramInt = C;
          if (m >= paramInt)
          {
            if (m != paramInt) {
              break;
            }
            break label167;
          }
        }
        localObject2 = null;
        label167:
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = a(C, i);
        }
        if (localObject3 != null)
        {
          int n = i - 1;
          if (n >= 0) {
            localObject2 = (b.f)y.get(n);
          } else {
            localObject2 = null;
          }
          int i1 = getClientWidth();
          float f1;
          if (i1 <= 0) {
            f1 = 0.0F;
          } else {
            f1 = 2.0F - d + getPaddingLeft() / i1;
          }
          int i2 = C - 1;
          Object localObject4;
          float f3;
          for (float f2 = 0.0F; i2 >= 0; f2 = f3)
          {
            if ((f2 >= f1) && (i2 < j))
            {
              if (localObject2 == null) {
                break;
              }
              paramInt = n;
              m = i;
              localObject4 = localObject2;
              f3 = f2;
              if (i2 != b) {
                break label553;
              }
              paramInt = n;
              m = i;
              localObject4 = localObject2;
              f3 = f2;
              if (c) {
                break label553;
              }
              y.remove(n);
              B.a(this, i2, a);
              n--;
              i--;
              paramInt = n;
              m = i;
              f3 = f2;
              if (n >= 0)
              {
                localObject2 = (b.f)y.get(n);
                paramInt = n;
                f3 = f2;
                break label546;
              }
            }
            else if ((localObject2 != null) && (i2 == b))
            {
              f2 += d;
              n--;
              paramInt = n;
              m = i;
              f3 = f2;
              if (n >= 0)
              {
                localObject2 = (b.f)y.get(n);
                paramInt = n;
                f3 = f2;
                break label546;
              }
            }
            else
            {
              f2 += a1d;
              i++;
              paramInt = n;
              m = i;
              f3 = f2;
              if (n >= 0)
              {
                localObject2 = (b.f)y.get(n);
                paramInt = n;
                f3 = f2;
                break label546;
              }
            }
            localObject2 = null;
            i = m;
            label546:
            localObject4 = localObject2;
            m = i;
            label553:
            i2--;
            n = paramInt;
            i = m;
            localObject2 = localObject4;
          }
          f2 = d;
          n = i + 1;
          if (f2 < 2.0F)
          {
            if (n < y.size()) {
              localObject2 = (b.f)y.get(n);
            } else {
              localObject2 = null;
            }
            if (i1 <= 0) {
              f1 = 0.0F;
            } else {
              f1 = getPaddingRight() / i1 + 2.0F;
            }
            i2 = C + 1;
            m = n;
            localObject4 = localObject2;
            while (i2 < 4)
            {
              if ((f2 >= f1) && (i2 > k))
              {
                if (localObject4 == null) {
                  break;
                }
                f3 = f2;
                localObject2 = localObject4;
                paramInt = m;
                if (i2 != b) {
                  break label941;
                }
                f3 = f2;
                localObject2 = localObject4;
                paramInt = m;
                if (c) {
                  break label941;
                }
                y.remove(m);
                B.a(this, i2, a);
                f3 = f2;
                paramInt = m;
                if (m < y.size())
                {
                  localObject2 = (b.f)y.get(m);
                  f3 = f2;
                  paramInt = m;
                  break label941;
                }
              }
              else if ((localObject4 != null) && (i2 == b))
              {
                f2 += d;
                m++;
                f3 = f2;
                paramInt = m;
                if (m < y.size())
                {
                  localObject2 = (b.f)y.get(m);
                  f3 = f2;
                  paramInt = m;
                  break label941;
                }
              }
              else
              {
                localObject2 = a(i2, m);
                m++;
                f2 += d;
                f3 = f2;
                paramInt = m;
                if (m < y.size())
                {
                  localObject2 = (b.f)y.get(m);
                  f3 = f2;
                  paramInt = m;
                  break label941;
                }
              }
              localObject2 = null;
              label941:
              i2++;
              f2 = f3;
              localObject4 = localObject2;
              m = paramInt;
            }
          }
          if ((OnboardingActivity.b)B != null)
          {
            paramInt = getClientWidth();
            if (paramInt > 0) {
              f2 = J / paramInt;
            } else {
              f2 = 0.0F;
            }
            if (localObject1 != null)
            {
              paramInt = b;
              m = b;
              if (paramInt < m)
              {
                f3 = e + d + f2;
                m = 0;
                for (;;)
                {
                  i2 = paramInt + 1;
                  if ((i2 > b) || (m >= y.size())) {
                    break;
                  }
                  for (localObject2 = (b.f)y.get(m);; localObject2 = (b.f)y.get(m))
                  {
                    paramInt = i2;
                    f1 = f3;
                    if (i2 <= b) {
                      break;
                    }
                    paramInt = i2;
                    f1 = f3;
                    if (m >= y.size() - 1) {
                      break;
                    }
                    m++;
                  }
                  while (paramInt < b) {
                    if (B != null)
                    {
                      f1 += 1.0F + f2;
                      paramInt++;
                    }
                    else
                    {
                      throw null;
                    }
                  }
                  e = f1;
                  f3 = f1 + (d + f2);
                }
              }
              if (paramInt > m)
              {
                m = y.size() - 1;
                f3 = e;
                for (;;)
                {
                  i2 = paramInt - 1;
                  if ((i2 < b) || (m < 0)) {
                    break;
                  }
                  for (localObject2 = (b.f)y.get(m);; localObject2 = (b.f)y.get(m))
                  {
                    f1 = f3;
                    paramInt = i2;
                    if (i2 >= b) {
                      break;
                    }
                    f1 = f3;
                    paramInt = i2;
                    if (m <= 0) {
                      break;
                    }
                    m--;
                  }
                  while (paramInt > b) {
                    if (B != null)
                    {
                      f1 -= 1.0F + f2;
                      paramInt--;
                    }
                    else
                    {
                      throw null;
                    }
                  }
                  f3 = f1 - (d + f2);
                  e = f3;
                }
              }
            }
            m = y.size();
            f3 = e;
            i2 = b;
            paramInt = i2 - 1;
            if (i2 == 0) {
              f1 = f3;
            } else {
              f1 = -3.4028235E38F;
            }
            N = f1;
            if (b == 3) {
              f1 = e + d - 1.0F;
            } else {
              f1 = Float.MAX_VALUE;
            }
            O = f1;
            i--;
            while (i >= 0)
            {
              localObject2 = (b.f)y.get(i);
              for (;;)
              {
                i2 = b;
                if (paramInt <= i2) {
                  break label1495;
                }
                localObject1 = B;
                paramInt--;
                if (localObject1 == null) {
                  break;
                }
                f3 -= 1.0F + f2;
              }
              throw null;
              label1495:
              f3 -= d + f2;
              e = f3;
              if (i2 == 0) {
                N = f3;
              }
              i--;
              paramInt--;
            }
            f3 = e + d + f2;
            for (paramInt = b + 1; n < m; paramInt++)
            {
              localObject2 = (b.f)y.get(n);
              for (;;)
              {
                i = b;
                if (paramInt >= i) {
                  break label1617;
                }
                localObject1 = B;
                paramInt++;
                if (localObject1 == null) {
                  break;
                }
                f3 += 1.0F + f2;
              }
              throw null;
              label1617:
              if (i == 3) {
                O = (d + f3 - 1.0F);
              }
              e = f3;
              f3 += d + f2;
              n++;
            }
            localObject2 = B;
            localObject3 = a;
            localObject2 = (w)localObject2;
            if (localObject2 != null)
            {
              localObject3 = (Fragment)localObject3;
              localObject1 = f;
              if (localObject3 != localObject1)
              {
                if (localObject1 != null)
                {
                  ((Fragment)localObject1).setMenuVisibility(false);
                  if (b == 1)
                  {
                    if (c == null)
                    {
                      localObject1 = a;
                      if (localObject1 != null) {
                        c = new d.m.a.a((p)localObject1);
                      } else {
                        throw null;
                      }
                    }
                    c.a(f, g.b.STARTED);
                  }
                  else
                  {
                    f.setUserVisibleHint(false);
                  }
                }
                ((Fragment)localObject3).setMenuVisibility(true);
                if (b == 1)
                {
                  if (c == null)
                  {
                    localObject1 = a;
                    if (localObject1 != null) {
                      c = new d.m.a.a((p)localObject1);
                    } else {
                      throw null;
                    }
                  }
                  c.a((Fragment)localObject3, g.b.RESUMED);
                }
                else
                {
                  ((Fragment)localObject3).setUserVisibleHint(true);
                }
                f = ((Fragment)localObject3);
              }
            }
            else
            {
              throw null;
            }
          }
          else
          {
            throw null;
          }
        }
        i = 0;
        B.a(this);
        int m = getChildCount();
        for (paramInt = 0; paramInt < m; paramInt++)
        {
          localObject3 = getChildAt(paramInt);
          localObject2 = (b.g)((View)localObject3).getLayoutParams();
          f = paramInt;
          if ((!a) && (c == 0.0F))
          {
            localObject3 = a((View)localObject3);
            if (localObject3 != null)
            {
              c = d;
              e = b;
            }
          }
        }
        if (hasFocus())
        {
          localObject2 = findFocus();
          if (localObject2 != null)
          {
            for (;;)
            {
              localObject3 = ((View)localObject2).getParent();
              if (localObject3 == this) {
                break;
              }
              if ((localObject3 == null) || (!(localObject3 instanceof View))) {
                break label2052;
              }
              localObject2 = (View)localObject3;
            }
            localObject2 = a((View)localObject2);
          }
          else
          {
            label2052:
            localObject2 = null;
          }
          paramInt = i;
          if (localObject2 != null)
          {
            if (b == C) {}
          }
          else {
            for (paramInt = i; paramInt < getChildCount(); paramInt++)
            {
              localObject2 = getChildAt(paramInt);
              localObject3 = a((View)localObject2);
              if ((localObject3 != null) && (b == C) && (((View)localObject2).requestFocus(2))) {
                break;
              }
            }
          }
        }
        return;
      }
      String str;
      try
      {
        localObject2 = getResources().getResourceName(getId());
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        str = Integer.toHexString(getId());
      }
      Object localObject3 = e.a.a.a.a.a("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
      ((StringBuilder)localObject3).append(x);
      ((StringBuilder)localObject3).append(", found: ");
      ((StringBuilder)localObject3).append(4);
      ((StringBuilder)localObject3).append(" Pager id: ");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(" Pager class: ");
      ((StringBuilder)localObject3).append(getClass());
      ((StringBuilder)localObject3).append(" Problematic adapter: ");
      ((StringBuilder)localObject3).append(B.getClass());
      throw new IllegalStateException(((StringBuilder)localObject3).toString());
    }
    throw null;
  }
  
  public boolean e()
  {
    a locala = B;
    if (locala != null)
    {
      int i = C;
      if ((OnboardingActivity.b)locala != null)
      {
        if (i < 3)
        {
          a(i + 1, true);
          return true;
        }
      }
      else {
        throw null;
      }
    }
    return false;
  }
  
  public final boolean f()
  {
    g0 = -1;
    boolean bool = false;
    U = false;
    V = false;
    VelocityTracker localVelocityTracker = h0;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      h0 = null;
    }
    m0.onRelease();
    n0.onRelease();
    if ((m0.isFinished()) || (n0.isFinished())) {
      bool = true;
    }
    return bool;
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new b.g();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new b.g(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new b.g();
  }
  
  public a getAdapter()
  {
    return B;
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return t0.get(paramInt2)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return C;
  }
  
  public int getOffscreenPageLimit()
  {
    return T;
  }
  
  public int getPageMargin()
  {
    return J;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    o0 = true;
  }
  
  public void onDetachedFromWindow()
  {
    removeCallbacks(u0);
    Scroller localScroller = G;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      G.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((J > 0) && (K != null) && (y.size() > 0) && (B != null))
    {
      int i = getScrollX();
      int j = getWidth();
      float f1 = J;
      float f2 = j;
      float f3 = f1 / f2;
      Object localObject = y;
      int k = 0;
      localObject = (b.f)((ArrayList)localObject).get(0);
      f1 = e;
      int m = y.size();
      int n = b;
      int i1 = y.get(m - 1)).b;
      while (n < i1)
      {
        while ((n > b) && (k < m))
        {
          localObject = y;
          k++;
          localObject = (b.f)((ArrayList)localObject).get(k);
        }
        float f5;
        if (n == b)
        {
          f1 = e;
          float f4 = d;
          f5 = (f1 + f4) * f2;
          f1 = f1 + f4 + f3;
        }
        else
        {
          if (B == null) {
            break label321;
          }
          f5 = (f1 + 1.0F) * f2;
          f1 = 1.0F + f3 + f1;
        }
        if (J + f5 > i)
        {
          K.setBounds(Math.round(f5), L, Math.round(J + f5), M);
          K.draw(paramCanvas);
        }
        if (f5 <= i + j)
        {
          n++;
          continue;
          label321:
          throw null;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i != 3) && (i != 1))
    {
      if (i != 0)
      {
        if (U) {
          return true;
        }
        if (V) {
          return false;
        }
      }
      float f3;
      if (i != 0)
      {
        if (i != 2)
        {
          if (i == 6) {
            a(paramMotionEvent);
          }
        }
        else
        {
          i = g0;
          if (i != -1)
          {
            i = paramMotionEvent.findPointerIndex(i);
            float f1 = paramMotionEvent.getX(i);
            float f2 = f1 - c0;
            f3 = Math.abs(f2);
            float f4 = paramMotionEvent.getY(i);
            float f5 = Math.abs(f4 - f0);
            boolean bool = f2 < 0.0F;
            float f6;
            if (bool)
            {
              f6 = c0;
              if (((f6 < a0) && (bool)) || ((f6 > getWidth() - a0) && (f2 < 0.0F))) {
                i = 1;
              } else {
                i = 0;
              }
              if ((i == 0) && (a(this, false, (int)f2, (int)f1, (int)f4)))
              {
                c0 = f1;
                d0 = f4;
                V = true;
                return false;
              }
            }
            if ((f3 > b0) && (f3 * 0.5F > f5))
            {
              U = true;
              b(true);
              setScrollState(1);
              f3 = e0;
              f6 = b0;
              if (bool) {
                f3 += f6;
              } else {
                f3 -= f6;
              }
              c0 = f3;
              d0 = f4;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > b0)
            {
              V = true;
            }
            if ((U) && (a(f1))) {
              n.x(this);
            }
          }
        }
      }
      else
      {
        f3 = paramMotionEvent.getX();
        e0 = f3;
        c0 = f3;
        f3 = paramMotionEvent.getY();
        f0 = f3;
        d0 = f3;
        g0 = paramMotionEvent.getPointerId(0);
        V = false;
        H = true;
        G.computeScrollOffset();
        if ((v0 == 2) && (Math.abs(G.getFinalX() - G.getCurrX()) > l0))
        {
          G.abortAnimation();
          S = false;
          e(C);
          U = true;
          b(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          U = false;
        }
      }
      if (h0 == null) {
        h0 = VelocityTracker.obtain();
      }
      h0.addMovement(paramMotionEvent);
      return U;
    }
    f();
    return false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    int k = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int m = getScrollX();
    int n = 0;
    Object localObject1;
    Object localObject2;
    for (int i1 = 0; n < i; i1 = i6)
    {
      localObject1 = getChildAt(n);
      int i2 = paramInt2;
      int i3 = paramInt1;
      int i4 = paramInt4;
      int i5 = paramInt3;
      i6 = i1;
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (b.g)((View)localObject1).getLayoutParams();
        i2 = paramInt2;
        i3 = paramInt1;
        i4 = paramInt4;
        i5 = paramInt3;
        i6 = i1;
        if (a)
        {
          i5 = b;
          i6 = i5 & 0x7;
          i4 = i5 & 0x70;
          if (i6 != 1)
          {
            if (i6 != 3)
            {
              if (i6 != 5)
              {
                i6 = paramInt2;
                i5 = paramInt2;
                paramInt2 = i6;
                break label246;
              }
              i6 = j - paramInt4 - ((View)localObject1).getMeasuredWidth();
              paramInt4 += ((View)localObject1).getMeasuredWidth();
            }
            else
            {
              i6 = ((View)localObject1).getMeasuredWidth() + paramInt2;
              i5 = paramInt2;
              paramInt2 = i6;
              break label246;
            }
          }
          else {
            i6 = Math.max((j - ((View)localObject1).getMeasuredWidth()) / 2, paramInt2);
          }
          i5 = i6;
          label246:
          if (i4 != 16)
          {
            if (i4 != 48)
            {
              if (i4 != 80)
              {
                i4 = paramInt1;
                i6 = paramInt1;
                paramInt1 = i4;
              }
              else
              {
                i6 = k - paramInt3 - ((View)localObject1).getMeasuredHeight();
                paramInt3 += ((View)localObject1).getMeasuredHeight();
              }
            }
            else
            {
              i4 = ((View)localObject1).getMeasuredHeight() + paramInt1;
              i6 = paramInt1;
              paramInt1 = i4;
            }
          }
          else {
            i6 = Math.max((k - ((View)localObject1).getMeasuredHeight()) / 2, paramInt1);
          }
          i5 += m;
          ((View)localObject1).layout(i5, i6, ((View)localObject1).getMeasuredWidth() + i5, ((View)localObject1).getMeasuredHeight() + i6);
          i6 = i1 + 1;
          i5 = paramInt3;
          i4 = paramInt4;
          i3 = paramInt1;
          i2 = paramInt2;
        }
      }
      n++;
      paramInt2 = i2;
      paramInt1 = i3;
      paramInt4 = i4;
      paramInt3 = i5;
    }
    for (int i6 = 0; i6 < i; i6++)
    {
      View localView = getChildAt(i6);
      if (localView.getVisibility() != 8)
      {
        localObject1 = (b.g)localView.getLayoutParams();
        if (!a)
        {
          localObject2 = a(localView);
          if (localObject2 != null)
          {
            float f = j - paramInt2 - paramInt4;
            n = (int)(e * f) + paramInt2;
            if (d)
            {
              d = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f * c), 1073741824), View.MeasureSpec.makeMeasureSpec(k - paramInt1 - paramInt3, 1073741824));
            }
            localView.layout(n, paramInt1, localView.getMeasuredWidth() + n, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
    }
    L = paramInt1;
    M = (k - paramInt3);
    q0 = i1;
    if (o0) {
      a(C, false, 0, false);
    }
    o0 = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    setMeasuredDimension(ViewGroup.getDefaultSize(0, paramInt1), ViewGroup.getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    a0 = Math.min(paramInt1 / 10, W);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int j = getChildCount();
    int k = 0;
    View localView;
    b.g localg;
    for (;;)
    {
      int m = 1;
      int n = 1073741824;
      if (k >= j) {
        break;
      }
      localView = getChildAt(k);
      i1 = paramInt1;
      int i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localg = (b.g)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localg != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (a)
          {
            i2 = b;
            i1 = i2 & 0x7;
            i2 &= 0x70;
            int i3;
            if ((i2 != 48) && (i2 != 80)) {
              i3 = 0;
            } else {
              i3 = 1;
            }
            int i4 = m;
            if (i1 != 3) {
              if (i1 == 5) {
                i4 = m;
              } else {
                i4 = 0;
              }
            }
            i1 = Integer.MIN_VALUE;
            if (i3 != 0)
            {
              i2 = 1073741824;
            }
            else
            {
              i2 = i1;
              if (i4 != 0)
              {
                m = 1073741824;
                i2 = i1;
                i1 = m;
                break label267;
              }
            }
            i1 = Integer.MIN_VALUE;
            label267:
            m = width;
            int i5;
            if (m != -2)
            {
              if (m != -1) {
                i2 = m;
              } else {
                i2 = paramInt1;
              }
              i5 = 1073741824;
              m = i2;
            }
            else
            {
              m = paramInt1;
              i5 = i2;
            }
            i2 = height;
            if (i2 != -2)
            {
              if (i2 != -1) {
                i1 = i2;
              } else {
                i1 = paramInt2;
              }
            }
            else
            {
              i2 = paramInt2;
              n = i1;
              i1 = i2;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(m, i5), View.MeasureSpec.makeMeasureSpec(i1, n));
            if (i3 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i4 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      k++;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    P = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    Q = true;
    e(C);
    Q = false;
    int i1 = getChildCount();
    for (paramInt2 = i; paramInt2 < i1; paramInt2++)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localg = (b.g)localView.getLayoutParams();
        if ((localg == null) || (!a)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * c), 1073741824), P);
        }
      }
    }
  }
  
  public boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i = getChildCount();
    int j = -1;
    int k;
    if ((paramInt & 0x2) != 0)
    {
      j = i;
      i = 0;
      k = 1;
    }
    else
    {
      i--;
      k = -1;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b.f localf = a(localView);
        if ((localf != null) && (b == C) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof b.k))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (b.k)paramParcelable;
    super.onRestoreInstanceState(x);
    a locala = B;
    if (locala != null)
    {
      locala.a(A, B);
      a(z, false, true, 0);
    }
    else
    {
      D = z;
      E = A;
      F = B;
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    b.k localk = new b.k(super.onSaveInstanceState());
    z = C;
    Object localObject1 = B;
    if (localObject1 != null)
    {
      w localw = (w)localObject1;
      Object localObject2;
      if (d.size() > 0)
      {
        localObject2 = new Bundle();
        localObject1 = new Fragment.g[d.size()];
        d.toArray((Object[])localObject1);
        ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
      }
      else
      {
        localObject2 = null;
      }
      int i = 0;
      while (i < e.size())
      {
        Fragment localFragment = (Fragment)e.get(i);
        localObject1 = localObject2;
        if (localFragment != null)
        {
          localObject1 = localObject2;
          if (localFragment.isAdded())
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Bundle();
            }
            String str = e.a.a.a.a.a("f", i);
            localObject2 = a;
            if (localObject2 != null)
            {
              if (mFragmentManager == localObject2)
              {
                ((Bundle)localObject1).putString(str, mWho);
              }
              else
              {
                ((p)localObject2).a(new IllegalStateException(e.a.a.a.a.a("Fragment ", localFragment, " is not currently in the FragmentManager")));
                throw null;
              }
            }
            else {
              throw null;
            }
          }
        }
        i++;
        localObject2 = localObject1;
      }
      A = ((Parcelable)localObject2);
    }
    return localk;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = J;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = B;
    if (localObject != null)
    {
      if ((OnboardingActivity.b)localObject != null)
      {
        if (h0 == null) {
          h0 = VelocityTracker.obtain();
        }
        h0.addMovement(paramMotionEvent);
        i = paramMotionEvent.getAction() & 0xFF;
        float f1;
        if (i != 0)
        {
          float f3;
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
                    c0 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(g0));
                  }
                }
                else
                {
                  i = paramMotionEvent.getActionIndex();
                  c0 = paramMotionEvent.getX(i);
                  g0 = paramMotionEvent.getPointerId(i);
                }
              }
              else if (U)
              {
                a(C, true, 0, false);
                bool = f();
              }
            }
            else
            {
              if (!U)
              {
                i = paramMotionEvent.findPointerIndex(g0);
                if (i == -1)
                {
                  bool = f();
                  break label724;
                }
                f1 = paramMotionEvent.getX(i);
                float f2 = Math.abs(f1 - c0);
                f3 = paramMotionEvent.getY(i);
                float f4 = Math.abs(f3 - d0);
                if ((f2 > b0) && (f2 > f4))
                {
                  U = true;
                  b(true);
                  f2 = e0;
                  if (f1 - f2 > 0.0F) {
                    f1 = f2 + b0;
                  } else {
                    f1 = f2 - b0;
                  }
                  c0 = f1;
                  d0 = f3;
                  setScrollState(1);
                  setScrollingCacheEnabled(true);
                  localObject = getParent();
                  if (localObject != null) {
                    ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                  }
                }
              }
              if (U) {
                bool = false | a(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(g0)));
              }
            }
          }
          else if (U)
          {
            localObject = h0;
            ((VelocityTracker)localObject).computeCurrentVelocity(1000, j0);
            int j = (int)((VelocityTracker)localObject).getXVelocity(g0);
            S = true;
            i = getClientWidth();
            int k = getScrollX();
            localObject = b();
            f3 = J;
            f1 = i;
            f3 /= f1;
            i = b;
            f3 = (k / f1 - e) / (d + f3);
            if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(g0)) - e0)) > k0) && (Math.abs(j) > i0))
            {
              if (j <= 0) {
                i++;
              }
            }
            else
            {
              if (i >= C) {
                f1 = 0.4F;
              } else {
                f1 = 0.6F;
              }
              i += (int)(f3 + f1);
            }
            k = i;
            if (y.size() > 0)
            {
              paramMotionEvent = (b.f)y.get(0);
              localObject = y;
              localObject = (b.f)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
              k = Math.max(b, Math.min(i, b));
            }
            a(k, true, true, j);
            bool = f();
          }
        }
        else
        {
          G.abortAnimation();
          S = false;
          e(C);
          f1 = paramMotionEvent.getX();
          e0 = f1;
          c0 = f1;
          f1 = paramMotionEvent.getY();
          f0 = f1;
          d0 = f1;
          g0 = paramMotionEvent.getPointerId(0);
        }
        label724:
        if (bool) {
          n.x(this);
        }
        return true;
      }
      throw null;
    }
    return false;
  }
  
  public void removeView(View paramView)
  {
    if (Q) {
      removeViewInLayout(paramView);
    } else {
      super.removeView(paramView);
    }
  }
  
  public void setAdapter(a parama)
  {
    Object localObject = B;
    if (localObject != null)
    {
      ((a)localObject).a(null);
      B.b(this);
      for (int i = 0; i < y.size(); i++)
      {
        localObject = (b.f)y.get(i);
        B.a(this, b, a);
      }
      B.a(this);
      y.clear();
      int j;
      for (i = 0; i < getChildCount(); i = j + 1)
      {
        j = i;
        if (!getChildAtgetLayoutParamsa)
        {
          removeViewAt(i);
          j = i - 1;
        }
      }
      C = 0;
      scrollTo(0, 0);
    }
    B = parama;
    x = 0;
    if (parama != null)
    {
      if (I == null) {
        I = new b.j(this);
      }
      B.a(I);
      S = false;
      boolean bool = o0;
      o0 = true;
      parama = B;
      if ((OnboardingActivity.b)parama != null)
      {
        x = 4;
        if (D >= 0)
        {
          parama.a(E, F);
          a(D, false, true, 0);
          D = -1;
          E = null;
          F = null;
        }
        else if (!bool)
        {
          e(C);
        }
        else
        {
          requestLayout();
        }
      }
      else
      {
        throw null;
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    S = false;
    a(paramInt, o0 ^ true, false, 0);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to ");
      localStringBuilder.append(1);
      Log.w("ViewPager", localStringBuilder.toString());
      i = 1;
    }
    if (i != T)
    {
      T = i;
      e(C);
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(b.i parami)
  {
    s0 = parami;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i = J;
    J = paramInt;
    int j = getWidth();
    a(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(d.i.b.a.c(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    K = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setScrollState(int paramInt)
  {
    if (v0 == paramInt) {
      return;
    }
    v0 = paramInt;
    Object localObject = s0;
    if (localObject != null) {
      ((b.i)localObject).a(paramInt);
    }
    localObject = r0;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (b.i)r0.get(i);
        if (localObject != null) {
          ((b.i)localObject).a(paramInt);
        }
        i++;
      }
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != K)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.a0.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */