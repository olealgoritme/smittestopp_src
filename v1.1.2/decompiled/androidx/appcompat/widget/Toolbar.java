package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import d.b.a.a.a;
import d.b.d.b;
import d.b.d.f;
import d.b.d.i.h;
import d.b.d.i.h.a;
import d.b.d.i.j;
import d.b.d.i.o;
import d.b.d.i.o.a;
import d.b.d.i.t;
import d.b.e.b0;
import d.b.e.b1;
import d.b.e.c;
import d.b.e.l;
import d.b.e.m0;
import d.b.e.u0;
import d.b.e.v0;
import d.b.e.x0;
import d.b.e.y;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  public ImageButton A;
  public ImageView B;
  public Drawable C;
  public CharSequence D;
  public ImageButton E;
  public View F;
  public Context G;
  public int H;
  public int I;
  public int J;
  public int K;
  public int L;
  public int M;
  public int N;
  public int O;
  public int P;
  public m0 Q;
  public int R;
  public int S;
  public int T = 8388627;
  public CharSequence U;
  public CharSequence V;
  public int W;
  public int a0;
  public boolean b0;
  public boolean c0;
  public final ArrayList<View> d0 = new ArrayList();
  public final ArrayList<View> e0 = new ArrayList();
  public final int[] f0 = new int[2];
  public e g0;
  public final ActionMenuView.e h0 = new a();
  public x0 i0;
  public c j0;
  public c k0;
  public o.a l0;
  public h.a m0;
  public boolean n0;
  public final Runnable o0 = new b();
  public ActionMenuView x;
  public TextView y;
  public TextView z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = u0.a(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    I = paramContext.g(R.styleable.Toolbar_titleTextAppearance, 0);
    J = paramContext.g(R.styleable.Toolbar_subtitleTextAppearance, 0);
    T = paramContext.e(R.styleable.Toolbar_android_gravity, T);
    K = paramContext.e(R.styleable.Toolbar_buttonGravity, 48);
    int i = paramContext.b(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.e(R.styleable.Toolbar_titleMargins)) {
      paramInt = paramContext.b(R.styleable.Toolbar_titleMargins, i);
    }
    P = paramInt;
    O = paramInt;
    N = paramInt;
    M = paramInt;
    paramInt = paramContext.b(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      M = paramInt;
    }
    paramInt = paramContext.b(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      N = paramInt;
    }
    paramInt = paramContext.b(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      O = paramInt;
    }
    paramInt = paramContext.b(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      P = paramInt;
    }
    L = paramContext.c(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.b(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    int j = paramContext.b(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    i = paramContext.c(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = paramContext.c(R.styleable.Toolbar_contentInsetRight, 0);
    a();
    paramAttributeSet = Q;
    h = false;
    if (i != Integer.MIN_VALUE)
    {
      e = i;
      a = i;
    }
    if (k != Integer.MIN_VALUE)
    {
      f = k;
      b = k;
    }
    if ((paramInt != Integer.MIN_VALUE) || (j != Integer.MIN_VALUE)) {
      Q.a(paramInt, j);
    }
    R = paramContext.b(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
    S = paramContext.b(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
    C = paramContext.b(R.styleable.Toolbar_collapseIcon);
    D = paramContext.d(R.styleable.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.d(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.d(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    G = getContext();
    setPopupTheme(paramContext.g(R.styleable.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.b(R.styleable.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.d(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.b(R.styleable.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.d(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.e(R.styleable.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.a(R.styleable.Toolbar_titleTextColor, -1));
    }
    if (paramContext.e(R.styleable.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.a(R.styleable.Toolbar_subtitleTextColor, -1));
    }
    b.recycle();
  }
  
  private MenuInflater getMenuInflater()
  {
    return new f(getContext());
  }
  
  public final int a(int paramInt)
  {
    int i = d.i.i.n.i(this);
    int j = Gravity.getAbsoluteGravity(paramInt, i) & 0x7;
    if (j != 1)
    {
      paramInt = 3;
      if ((j != 3) && (j != 5))
      {
        if (i == 1) {
          paramInt = 5;
        }
        return paramInt;
      }
    }
    return j;
  }
  
  public final int a(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return paramView.getMarginStart() + paramView.getMarginEnd();
  }
  
  public final int a(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (i - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int j = a & 0x70;
    int k = j;
    if (j != 16)
    {
      k = j;
      if (j != 48)
      {
        k = j;
        if (j != 80) {
          k = T & 0x70;
        }
      }
    }
    if (k != 48)
    {
      if (k != 80)
      {
        j = getPaddingTop();
        int m = getPaddingBottom();
        int n = getHeight();
        k = (n - j - m - i) / 2;
        paramInt = topMargin;
        if (k >= paramInt)
        {
          m = n - m - i - k - j;
          i = bottomMargin;
          paramInt = k;
          if (m < i) {
            paramInt = Math.max(0, k - (i - m));
          }
        }
        return j + paramInt;
      }
      return getHeight() - getPaddingBottom() - i - bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  public final int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = leftMargin - paramArrayOfInt[0];
    int j = rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i);
    k = Math.max(0, j) + k;
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    j = getPaddingLeft();
    paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingRight() + j + k + paramInt2, width);
    paramInt2 = getPaddingTop();
    paramView.measure(paramInt1, ViewGroup.getChildMeasureSpec(paramInt3, getPaddingBottom() + paramInt2 + topMargin + bottomMargin + paramInt4, height));
    return paramView.getMeasuredWidth() + k;
  }
  
  public final int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    d locald = (d)paramView.getLayoutParams();
    int i = leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    i = a(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, i, paramInt1 + paramInt2, paramView.getMeasuredHeight() + i);
    return paramInt2 + rightMargin + paramInt1;
  }
  
  public final void a()
  {
    if (Q == null) {
      Q = new m0();
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getPaddingLeft();
    i = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingRight() + i + leftMargin + rightMargin + paramInt2, width);
    paramInt1 = getPaddingTop();
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt3, getPaddingBottom() + paramInt1 + topMargin + bottomMargin + paramInt4, height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0)
      {
        paramInt1 = paramInt5;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i, paramInt1);
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = generateDefaultLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = generateLayoutParams((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (d)localObject;
    }
    b = 1;
    if ((paramBoolean) && (F != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      e0.add(paramView);
    }
    else
    {
      addView(paramView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public final void a(List<View> paramList, int paramInt)
  {
    int i = d.i.i.n.i(this);
    int j = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int k = getChildCount();
    int m = Gravity.getAbsoluteGravity(paramInt, getLayoutDirection());
    paramList.clear();
    paramInt = j;
    View localView;
    d locald;
    if (i != 0) {
      for (paramInt = k - 1; paramInt >= 0; paramInt--)
      {
        localView = getChildAt(paramInt);
        locald = (d)localView.getLayoutParams();
        if ((b == 0) && (d(localView)) && (a(a) == m)) {
          paramList.add(localView);
        }
      }
    }
    while (paramInt < k)
    {
      localView = getChildAt(paramInt);
      locald = (d)localView.getLayoutParams();
      if ((b == 0) && (d(localView)) && (a(a) == m)) {
        paramList.add(localView);
      }
      paramInt++;
    }
  }
  
  public final int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return topMargin + bottomMargin;
  }
  
  public final int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    d locald = (d)paramView.getLayoutParams();
    int i = rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    i = a(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - paramInt2, i, paramInt1, paramView.getMeasuredHeight() + i);
    return paramInt1 - (paramInt2 + leftMargin);
  }
  
  public final void b()
  {
    c();
    Object localObject = x;
    if (M == null)
    {
      localObject = (h)((ActionMenuView)localObject).getMenu();
      if (k0 == null) {
        k0 = new c();
      }
      x.setExpandedActionViewsExclusive(true);
      ((h)localObject).a(k0, G);
    }
  }
  
  public final void c()
  {
    if (x == null)
    {
      Object localObject = new ActionMenuView(getContext());
      x = ((ActionMenuView)localObject);
      ((ActionMenuView)localObject).setPopupTheme(H);
      x.setOnMenuItemClickListener(h0);
      ActionMenuView localActionMenuView = x;
      o.a locala = l0;
      localObject = m0;
      R = locala;
      S = ((h.a)localObject);
      localObject = generateDefaultLayoutParams();
      a = (0x800005 | K & 0x70);
      x.setLayoutParams((ViewGroup.LayoutParams)localObject);
      a(x, false);
    }
  }
  
  public final boolean c(View paramView)
  {
    boolean bool;
    if ((paramView.getParent() != this) && (!e0.contains(paramView))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof d))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void d()
  {
    if (A == null)
    {
      A = new l(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      d locald = generateDefaultLayoutParams();
      a = (0x800003 | K & 0x70);
      A.setLayoutParams(locald);
    }
  }
  
  public final boolean d(View paramView)
  {
    boolean bool;
    if ((paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean e()
  {
    Object localObject = x;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = Q;
      int i;
      if ((localObject != null) && (((c)localObject).f())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean f()
  {
    Object localObject = x;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = Q;
      int i;
      if ((localObject != null) && (((c)localObject).g())) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public d generateDefaultLayoutParams()
  {
    return new d(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new d(getContext(), paramAttributeSet);
  }
  
  public d generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof d)) {
      return new d((d)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof a.a)) {
      return new d((a.a)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new d((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new d(paramLayoutParams);
  }
  
  public int getContentInsetEnd()
  {
    m0 localm0 = Q;
    int i;
    if (localm0 != null)
    {
      if (g) {
        i = a;
      } else {
        i = b;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i = S;
    if (i == Integer.MIN_VALUE) {
      i = getContentInsetEnd();
    }
    return i;
  }
  
  public int getContentInsetLeft()
  {
    m0 localm0 = Q;
    int i;
    if (localm0 != null) {
      i = a;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetRight()
  {
    m0 localm0 = Q;
    int i;
    if (localm0 != null) {
      i = b;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetStart()
  {
    m0 localm0 = Q;
    int i;
    if (localm0 != null)
    {
      if (g) {
        i = b;
      } else {
        i = a;
      }
    }
    else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i = R;
    if (i == Integer.MIN_VALUE) {
      i = getContentInsetStart();
    }
    return i;
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = x;
    if (localObject != null)
    {
      localObject = M;
      if ((localObject != null) && (((h)localObject).hasVisibleItems()))
      {
        i = 1;
        break label32;
      }
    }
    int i = 0;
    label32:
    if (i != 0) {
      i = Math.max(getContentInsetEnd(), Math.max(S, 0));
    } else {
      i = getContentInsetEnd();
    }
    return i;
  }
  
  public int getCurrentContentInsetLeft()
  {
    int i;
    if (d.i.i.n.i(this) == 1) {
      i = getCurrentContentInsetEnd();
    } else {
      i = getCurrentContentInsetStart();
    }
    return i;
  }
  
  public int getCurrentContentInsetRight()
  {
    int i;
    if (d.i.i.n.i(this) == 1) {
      i = getCurrentContentInsetStart();
    } else {
      i = getCurrentContentInsetEnd();
    }
    return i;
  }
  
  public int getCurrentContentInsetStart()
  {
    int i;
    if (getNavigationIcon() != null) {
      i = Math.max(getContentInsetStart(), Math.max(R, 0));
    } else {
      i = getContentInsetStart();
    }
    return i;
  }
  
  public Drawable getLogo()
  {
    Object localObject = B;
    if (localObject != null) {
      localObject = ((ImageView)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public CharSequence getLogoDescription()
  {
    Object localObject = B;
    if (localObject != null) {
      localObject = ((ImageView)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  public Menu getMenu()
  {
    b();
    return x.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    Object localObject = A;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  public Drawable getNavigationIcon()
  {
    Object localObject = A;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public c getOuterActionMenuPresenter()
  {
    return j0;
  }
  
  public Drawable getOverflowIcon()
  {
    b();
    return x.getOverflowIcon();
  }
  
  public Context getPopupContext()
  {
    return G;
  }
  
  public int getPopupTheme()
  {
    return H;
  }
  
  public CharSequence getSubtitle()
  {
    return V;
  }
  
  public CharSequence getTitle()
  {
    return U;
  }
  
  public int getTitleMarginBottom()
  {
    return P;
  }
  
  public int getTitleMarginEnd()
  {
    return N;
  }
  
  public int getTitleMarginStart()
  {
    return M;
  }
  
  public int getTitleMarginTop()
  {
    return O;
  }
  
  public b0 getWrapper()
  {
    if (i0 == null) {
      i0 = new x0(this, true);
    }
    return i0;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(o0);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      c0 = false;
    }
    if (!c0)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        c0 = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      c0 = false;
    }
    return true;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (d.i.i.n.i(this) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = getWidth();
    int k = getHeight();
    paramInt3 = getPaddingLeft();
    int m = getPaddingRight();
    int n = getPaddingTop();
    int i1 = getPaddingBottom();
    int i2 = j - m;
    int[] arrayOfInt = f0;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = getMinimumHeight();
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    }
    if (d(A))
    {
      if (i != 0)
      {
        i3 = b(A, i2, arrayOfInt, paramInt4);
        i4 = paramInt3;
        break label167;
      }
      i4 = a(A, paramInt3, arrayOfInt, paramInt4);
    }
    else
    {
      i4 = paramInt3;
    }
    int i3 = i2;
    label167:
    paramInt1 = i4;
    paramInt2 = i3;
    if (d(E)) {
      if (i != 0)
      {
        paramInt2 = b(E, i3, arrayOfInt, paramInt4);
        paramInt1 = i4;
      }
      else
      {
        paramInt1 = a(E, i4, arrayOfInt, paramInt4);
        paramInt2 = i3;
      }
    }
    int i4 = paramInt1;
    i3 = paramInt2;
    if (d(x)) {
      if (i != 0)
      {
        i4 = a(x, paramInt1, arrayOfInt, paramInt4);
        i3 = paramInt2;
      }
      else
      {
        i3 = b(x, paramInt2, arrayOfInt, paramInt4);
        i4 = paramInt1;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - i4);
    arrayOfInt[1] = Math.max(0, paramInt1 - (i2 - i3));
    paramInt2 = Math.max(i4, paramInt2);
    i3 = Math.min(i3, i2 - paramInt1);
    paramInt1 = paramInt2;
    i4 = i3;
    if (d(F)) {
      if (i != 0)
      {
        i4 = b(F, i3, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = a(F, paramInt2, arrayOfInt, paramInt4);
        i4 = i3;
      }
    }
    paramInt2 = paramInt1;
    i3 = i4;
    if (d(B)) {
      if (i != 0)
      {
        i3 = b(B, i4, arrayOfInt, paramInt4);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = a(B, paramInt1, arrayOfInt, paramInt4);
        i3 = i4;
      }
    }
    boolean bool = d(y);
    paramBoolean = d(z);
    Object localObject1;
    if (bool)
    {
      localObject1 = (d)y.getLayoutParams();
      paramInt1 = topMargin;
      paramInt1 = y.getMeasuredHeight() + paramInt1 + bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramBoolean)
    {
      localObject1 = (d)z.getLayoutParams();
      i4 = topMargin;
      paramInt1 += z.getMeasuredHeight() + i4 + bottomMargin;
    }
    Object localObject2;
    if ((!bool) && (!paramBoolean))
    {
      paramInt1 = paramInt2;
    }
    else
    {
      if (bool) {
        localObject1 = y;
      } else {
        localObject1 = z;
      }
      if (paramBoolean) {
        localObject2 = z;
      } else {
        localObject2 = y;
      }
      localObject1 = (d)((View)localObject1).getLayoutParams();
      localObject2 = (d)((View)localObject2).getLayoutParams();
      if (((bool) && (y.getMeasuredWidth() > 0)) || ((paramBoolean) && (z.getMeasuredWidth() > 0))) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      i2 = T & 0x70;
      if (i2 != 48)
      {
        if (i2 != 80)
        {
          i2 = (k - n - i1 - paramInt1) / 2;
          int i5 = topMargin;
          int i6 = O;
          if (i2 < i5 + i6)
          {
            paramInt1 = i5 + i6;
          }
          else
          {
            i1 = k - i1 - paramInt1 - i2 - n;
            i6 = bottomMargin;
            k = P;
            paramInt1 = i2;
            if (i1 < i6 + k) {
              paramInt1 = Math.max(0, i2 - (bottomMargin + k - i1));
            }
          }
          paramInt1 = n + paramInt1;
        }
        else
        {
          paramInt1 = k - i1 - bottomMargin - P - paramInt1;
        }
      }
      else {
        paramInt1 = getPaddingTop() + topMargin + O;
      }
      i2 = paramInt2;
      if (i != 0)
      {
        if (i4 != 0) {
          paramInt2 = M;
        } else {
          paramInt2 = 0;
        }
        i = paramInt2 - arrayOfInt[1];
        paramInt2 = i3 - Math.max(0, i);
        arrayOfInt[1] = Math.max(0, -i);
        if (bool)
        {
          localObject1 = (d)y.getLayoutParams();
          i = paramInt2 - y.getMeasuredWidth();
          i3 = y.getMeasuredHeight() + paramInt1;
          y.layout(i, paramInt1, paramInt2, i3);
          paramInt1 = i - N;
          i = i3 + bottomMargin;
        }
        else
        {
          i3 = paramInt2;
          i = paramInt1;
          paramInt1 = i3;
        }
        if (paramBoolean)
        {
          i3 = i + z.getLayoutParams()).topMargin;
          i = z.getMeasuredWidth();
          n = z.getMeasuredHeight();
          z.layout(paramInt2 - i, i3, paramInt2, n + i3);
          i3 = paramInt2 - N;
        }
        else
        {
          i3 = paramInt2;
        }
        if (i4 != 0) {
          paramInt2 = Math.min(paramInt1, i3);
        }
        paramInt1 = i2;
        i3 = paramInt2;
      }
      else
      {
        if (i4 != 0) {
          paramInt2 = M;
        } else {
          paramInt2 = 0;
        }
        i = paramInt2 - arrayOfInt[0];
        paramInt2 = Math.max(0, i) + i2;
        arrayOfInt[0] = Math.max(0, -i);
        if (bool)
        {
          localObject1 = (d)y.getLayoutParams();
          i2 = y.getMeasuredWidth() + paramInt2;
          i = y.getMeasuredHeight() + paramInt1;
          y.layout(paramInt2, paramInt1, i2, i);
          paramInt1 = i2 + N;
          i += bottomMargin;
        }
        else
        {
          i2 = paramInt2;
          i = paramInt1;
          paramInt1 = i2;
        }
        if (paramBoolean)
        {
          i += z.getLayoutParams()).topMargin;
          n = z.getMeasuredWidth() + paramInt2;
          i2 = z.getMeasuredHeight();
          z.layout(paramInt2, i, n, i2 + i);
          i = n + N;
        }
        else
        {
          i = paramInt2;
        }
        if (i4 != 0) {
          paramInt1 = Math.max(paramInt1, i);
        } else {
          paramInt1 = paramInt2;
        }
      }
    }
    int i = paramInt4;
    i2 = paramInt3;
    a(d0, 3);
    paramInt3 = d0.size();
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++) {
      paramInt1 = a((View)d0.get(paramInt2), paramInt1, arrayOfInt, i);
    }
    a(d0, 5);
    paramInt3 = d0.size();
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++) {
      i3 = b((View)d0.get(paramInt2), i3, arrayOfInt, i);
    }
    a(d0, 1);
    ArrayList localArrayList = d0;
    i4 = arrayOfInt[0];
    paramInt4 = arrayOfInt[1];
    n = localArrayList.size();
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt3 < n)
    {
      localObject1 = (View)localArrayList.get(paramInt3);
      localObject2 = (d)((View)localObject1).getLayoutParams();
      i4 = leftMargin - i4;
      paramInt4 = rightMargin - paramInt4;
      k = Math.max(0, i4);
      i1 = Math.max(0, paramInt4);
      i4 = Math.max(0, -i4);
      paramInt4 = Math.max(0, -paramInt4);
      paramInt2 += ((View)localObject1).getMeasuredWidth() + k + i1;
      paramInt3++;
    }
    paramInt3 = (j - i2 - m) / 2 + i2 - paramInt2 / 2;
    paramInt2 += paramInt3;
    if (paramInt3 >= paramInt1) {
      if (paramInt2 > i3) {
        paramInt1 = paramInt3 - (paramInt2 - i3);
      } else {
        paramInt1 = paramInt3;
      }
    }
    paramInt3 = d0.size();
    paramInt2 = paramInt1;
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
      paramInt2 = a((View)d0.get(paramInt1), paramInt2, arrayOfInt, i);
    }
    d0.clear();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = f0;
    boolean bool = b1.a(this);
    int i = 1;
    int j = 0;
    if (bool)
    {
      k = 1;
      m = 0;
    }
    else
    {
      k = 0;
      m = 1;
    }
    if (d(A))
    {
      a(A, paramInt1, 0, paramInt2, 0, L);
      n = A.getMeasuredWidth();
      n = a(A) + n;
      i1 = A.getMeasuredHeight();
      i2 = Math.max(0, b(A) + i1);
      i3 = View.combineMeasuredStates(0, A.getMeasuredState());
    }
    else
    {
      n = 0;
      i2 = 0;
      i3 = 0;
    }
    int i4 = n;
    int i1 = i2;
    int n = i3;
    if (d(E))
    {
      a(E, paramInt1, 0, paramInt2, 0, L);
      n = E.getMeasuredWidth();
      i4 = a(E) + n;
      n = E.getMeasuredHeight();
      i1 = Math.max(i2, b(E) + n);
      n = View.combineMeasuredStates(i3, E.getMeasuredState());
    }
    int i3 = getCurrentContentInsetStart();
    int i5 = Math.max(i3, i4) + 0;
    arrayOfInt[k] = Math.max(0, i3 - i4);
    if (d(x))
    {
      a(x, paramInt1, i5, paramInt2, 0, L);
      i3 = x.getMeasuredWidth();
      i3 = a(x) + i3;
      i2 = x.getMeasuredHeight();
      i2 = Math.max(i1, b(x) + i2);
      n = View.combineMeasuredStates(n, x.getMeasuredState());
      i1 = i3;
      i3 = i2;
    }
    else
    {
      i2 = 0;
      i3 = i1;
      i1 = i2;
    }
    int i2 = getCurrentContentInsetEnd();
    i4 = Math.max(i2, i1) + i5;
    arrayOfInt[m] = Math.max(0, i2 - i1);
    int k = i4;
    i2 = i3;
    i1 = n;
    if (d(F))
    {
      k = i4 + a(F, paramInt1, i4, paramInt2, 0, arrayOfInt);
      i1 = F.getMeasuredHeight();
      i2 = Math.max(i3, b(F) + i1);
      i1 = View.combineMeasuredStates(n, F.getMeasuredState());
    }
    int m = k;
    i3 = i2;
    n = i1;
    if (d(B))
    {
      m = k + a(B, paramInt1, k, paramInt2, 0, arrayOfInt);
      n = B.getMeasuredHeight();
      i3 = Math.max(i2, b(B) + n);
      n = View.combineMeasuredStates(i1, B.getMeasuredState());
    }
    i5 = getChildCount();
    i1 = 0;
    i2 = i3;
    View localView;
    while (i1 < i5)
    {
      localView = getChildAt(i1);
      i4 = m;
      k = i2;
      i3 = n;
      if (getLayoutParamsb == 0) {
        if (!d(localView))
        {
          i4 = m;
          k = i2;
          i3 = n;
        }
        else
        {
          i4 = m + a(localView, paramInt1, m, paramInt2, 0, arrayOfInt);
          i3 = localView.getMeasuredHeight();
          k = Math.max(i2, b(localView) + i3);
          i3 = View.combineMeasuredStates(n, localView.getMeasuredState());
        }
      }
      i1++;
      m = i4;
      i2 = k;
      n = i3;
    }
    k = O + P;
    i4 = M + N;
    if (d(y))
    {
      a(y, paramInt1, m + i4, paramInt2, k, arrayOfInt);
      i3 = y.getMeasuredWidth();
      i5 = a(y);
      i1 = y.getMeasuredHeight();
      int i6 = b(y);
      n = View.combineMeasuredStates(n, y.getMeasuredState());
      i1 = i6 + i1;
      i3 = i5 + i3;
    }
    else
    {
      i3 = 0;
      i1 = 0;
    }
    if (d(z))
    {
      i3 = Math.max(i3, a(z, paramInt1, m + i4, paramInt2, i1 + k, arrayOfInt));
      k = z.getMeasuredHeight();
      i1 = b(z) + k + i1;
      n = View.combineMeasuredStates(n, z.getMeasuredState());
    }
    k = Math.max(i2, i1);
    i5 = getPaddingLeft();
    i1 = getPaddingRight();
    i4 = getPaddingTop();
    i2 = getPaddingBottom();
    i1 = View.resolveSizeAndState(Math.max(i1 + i5 + (m + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & n);
    n = View.resolveSizeAndState(Math.max(i2 + i4 + k, getSuggestedMinimumHeight()), paramInt2, n << 16);
    if (!n0)
    {
      paramInt2 = 0;
    }
    else
    {
      i3 = getChildCount();
      for (paramInt1 = 0;; paramInt1++)
      {
        paramInt2 = i;
        if (paramInt1 >= i3) {
          break label1094;
        }
        localView = getChildAt(paramInt1);
        if ((d(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0)) {
          break;
        }
      }
    }
    label1094:
    if (paramInt2 != 0) {
      paramInt1 = j;
    } else {
      paramInt1 = n;
    }
    setMeasuredDimension(i1, paramInt1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof f))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    f localf = (f)paramParcelable;
    super.onRestoreInstanceState(x);
    paramParcelable = x;
    if (paramParcelable != null) {
      paramParcelable = M;
    } else {
      paramParcelable = null;
    }
    int i = z;
    if ((i != 0) && (k0 != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(i);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (A)
    {
      removeCallbacks(o0);
      post(o0);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    a();
    m0 localm0 = Q;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    if (bool != g)
    {
      g = bool;
      if (h)
      {
        if (bool)
        {
          paramInt = d;
          if (paramInt == Integer.MIN_VALUE) {
            paramInt = e;
          }
          a = paramInt;
          paramInt = c;
          if (paramInt == Integer.MIN_VALUE) {
            paramInt = f;
          }
          b = paramInt;
        }
        else
        {
          paramInt = c;
          if (paramInt == Integer.MIN_VALUE) {
            paramInt = e;
          }
          a = paramInt;
          paramInt = d;
          if (paramInt == Integer.MIN_VALUE) {
            paramInt = f;
          }
          b = paramInt;
        }
      }
      else
      {
        a = e;
        b = f;
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    f localf = new f(super.onSaveInstanceState());
    Object localObject = k0;
    if (localObject != null)
    {
      localObject = y;
      if (localObject != null) {
        z = a;
      }
    }
    A = e();
    return localf;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      b0 = false;
    }
    if (!b0)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        b0 = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      b0 = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    n0 = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != S)
    {
      S = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = Integer.MIN_VALUE;
    }
    if (i != R)
    {
      R = i;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(d.b.b.a.a.c(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (B == null) {
        B = new d.b.e.n(getContext(), null, 0);
      }
      if (!c(B)) {
        a(B, true);
      }
    }
    else
    {
      localImageView = B;
      if ((localImageView != null) && (c(localImageView)))
      {
        removeView(B);
        e0.remove(B);
      }
    }
    ImageView localImageView = B;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (B == null)) {
      B = new d.b.e.n(getContext(), null, 0);
    }
    ImageView localImageView = B;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      d();
    }
    ImageButton localImageButton = A;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(d.b.b.a.a.c(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      d();
      if (!c(A)) {
        a(A, true);
      }
    }
    else
    {
      localImageButton = A;
      if ((localImageButton != null) && (c(localImageButton)))
      {
        removeView(A);
        e0.remove(A);
      }
    }
    ImageButton localImageButton = A;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    d();
    A.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(e parame)
  {
    g0 = parame;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    b();
    x.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (H != paramInt)
    {
      H = paramInt;
      if (paramInt == 0) {
        G = getContext();
      } else {
        G = new ContextThemeWrapper(getContext(), paramInt);
      }
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (z == null)
      {
        localObject = getContext();
        y localy = new y((Context)localObject);
        z = localy;
        localy.setSingleLine();
        z.setEllipsize(TextUtils.TruncateAt.END);
        int i = J;
        if (i != 0) {
          z.setTextAppearance((Context)localObject, i);
        }
        i = a0;
        if (i != 0) {
          z.setTextColor(i);
        }
      }
      if (!c(z)) {
        a(z, true);
      }
    }
    else
    {
      localObject = z;
      if ((localObject != null) && (c((View)localObject)))
      {
        removeView(z);
        e0.remove(z);
      }
    }
    Object localObject = z;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    V = paramCharSequence;
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    a0 = paramInt;
    TextView localTextView = z;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (y == null)
      {
        localObject = getContext();
        y localy = new y((Context)localObject);
        y = localy;
        localy.setSingleLine();
        y.setEllipsize(TextUtils.TruncateAt.END);
        int i = I;
        if (i != 0) {
          y.setTextAppearance((Context)localObject, i);
        }
        i = W;
        if (i != 0) {
          y.setTextColor(i);
        }
      }
      if (!c(y)) {
        a(y, true);
      }
    }
    else
    {
      localObject = y;
      if ((localObject != null) && (c((View)localObject)))
      {
        removeView(y);
        e0.remove(y);
      }
    }
    Object localObject = y;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    U = paramCharSequence;
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    P = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    N = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    M = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    O = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    W = paramInt;
    TextView localTextView = y;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public class a
    implements ActionMenuView.e
  {
    public a() {}
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      f();
    }
  }
  
  public class c
    implements o
  {
    public h x;
    public j y;
    
    public c() {}
    
    public void a(Context paramContext, h paramh)
    {
      h localh = x;
      if (localh != null)
      {
        paramContext = y;
        if (paramContext != null) {
          localh.a(paramContext);
        }
      }
      x = paramh;
    }
    
    public void a(Parcelable paramParcelable) {}
    
    public void a(h paramh, boolean paramBoolean) {}
    
    public void a(o.a parama) {}
    
    public void a(boolean paramBoolean)
    {
      if (y != null)
      {
        h localh = x;
        int i = 0;
        int j = i;
        if (localh != null)
        {
          int k = localh.size();
          for (int m = 0;; m++)
          {
            j = i;
            if (m >= k) {
              break;
            }
            if (x.getItem(m) == y)
            {
              j = 1;
              break;
            }
          }
        }
        if (j == 0) {
          a(x, y);
        }
      }
    }
    
    public boolean a(h paramh, j paramj)
    {
      paramh = F;
      if ((paramh instanceof b)) {
        ((b)paramh).c();
      }
      paramh = Toolbar.this;
      paramh.removeView(F);
      paramh = Toolbar.this;
      paramh.removeView(E);
      paramh = Toolbar.this;
      F = null;
      int i = e0.size();
      for (;;)
      {
        i--;
        if (i < 0) {
          break;
        }
        paramh.addView((View)e0.get(i));
      }
      e0.clear();
      y = null;
      requestLayout();
      C = false;
      n.b(false);
      return true;
    }
    
    public boolean a(t paramt)
    {
      return false;
    }
    
    public boolean b(h paramh, j paramj)
    {
      paramh = Toolbar.this;
      if (E == null)
      {
        localObject = new l(paramh.getContext(), null, R.attr.toolbarNavigationButtonStyle);
        E = ((ImageButton)localObject);
        ((ImageButton)localObject).setImageDrawable(C);
        E.setContentDescription(D);
        localObject = paramh.generateDefaultLayoutParams();
        a = (K & 0x70 | 0x800003);
        b = 2;
        E.setLayoutParams((ViewGroup.LayoutParams)localObject);
        E.setOnClickListener(new v0(paramh));
      }
      paramh = E.getParent();
      Object localObject = Toolbar.this;
      if (paramh != localObject)
      {
        if ((paramh instanceof ViewGroup)) {
          ((ViewGroup)paramh).removeView(E);
        }
        paramh = Toolbar.this;
        paramh.addView(E);
      }
      F = paramj.getActionView();
      y = paramj;
      paramh = F.getParent();
      localObject = Toolbar.this;
      if (paramh != localObject)
      {
        if ((paramh instanceof ViewGroup)) {
          ((ViewGroup)paramh).removeView(F);
        }
        localObject = generateDefaultLayoutParams();
        paramh = Toolbar.this;
        a = (0x800003 | K & 0x70);
        b = 2;
        F.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramh = Toolbar.this;
        paramh.addView(F);
      }
      paramh = Toolbar.this;
      int i = paramh.getChildCount();
      for (;;)
      {
        int j = i - 1;
        if (j < 0) {
          break;
        }
        localObject = paramh.getChildAt(j);
        i = j;
        if (getLayoutParamsb != 2)
        {
          i = j;
          if (localObject != x)
          {
            paramh.removeViewAt(j);
            e0.add(localObject);
            i = j;
          }
        }
      }
      requestLayout();
      C = true;
      n.b(false);
      paramh = F;
      if ((paramh instanceof b)) {
        ((b)paramh).a();
      }
      return true;
    }
    
    public boolean c()
    {
      return false;
    }
    
    public Parcelable d()
    {
      return null;
    }
    
    public int getId()
    {
      return 0;
    }
  }
  
  public static class d
    extends a.a
  {
    public int b = 0;
    
    public d(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      a = 8388627;
    }
    
    public d(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public d(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public d(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      leftMargin = leftMargin;
      topMargin = topMargin;
      rightMargin = rightMargin;
      bottomMargin = bottomMargin;
    }
    
    public d(d paramd)
    {
      super();
      b = b;
    }
    
    public d(a.a parama)
    {
      super();
    }
  }
  
  public static abstract interface e {}
  
  public static class f
    extends d.k.a.a
  {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public boolean A;
    public int z;
    
    public f(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      z = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      A = bool;
    }
    
    public f(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(x, paramInt);
      paramParcel.writeInt(z);
      paramParcel.writeInt(A);
    }
    
    public static final class a
      implements Parcelable.ClassLoaderCreator<Toolbar.f>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new Toolbar.f(paramParcel, null);
      }
      
      public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new Toolbar.f(paramParcel, paramClassLoader);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new Toolbar.f[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.Toolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */