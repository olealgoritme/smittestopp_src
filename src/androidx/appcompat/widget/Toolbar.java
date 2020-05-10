package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
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
import d.b.d.f;
import d.b.d.i.g;
import d.b.d.i.g.a;
import d.b.d.i.i;
import d.b.d.i.m.a;
import d.b.e.c;
import d.b.e.d0;
import d.b.e.d1;
import d.b.e.l;
import d.b.e.p0;
import d.b.e.x0;
import d.b.e.z;
import d.b.e.z0;
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
  public p0 Q;
  public int R;
  public int S;
  public int T = 8388627;
  public CharSequence U;
  public CharSequence V;
  public ColorStateList W;
  public ColorStateList a0;
  public boolean b0;
  public boolean c0;
  public final ArrayList<View> d0 = new ArrayList();
  public final ArrayList<View> e0 = new ArrayList();
  public final int[] f0 = new int[2];
  public Toolbar.f g0;
  public final ActionMenuView.e h0 = new Toolbar.a(this);
  public z0 i0;
  public c j0;
  public Toolbar.d k0;
  public m.a l0;
  public g.a m0;
  public boolean n0;
  public final Runnable o0 = new Toolbar.b(this);
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
    paramContext = x0.a(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    I = paramContext.f(R.styleable.Toolbar_titleTextAppearance, 0);
    J = paramContext.f(R.styleable.Toolbar_subtitleTextAppearance, 0);
    T = paramContext.d(R.styleable.Toolbar_android_gravity, T);
    K = paramContext.d(R.styleable.Toolbar_buttonGravity, 48);
    int i = paramContext.a(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (paramContext.f(R.styleable.Toolbar_titleMargins)) {
      paramInt = paramContext.a(R.styleable.Toolbar_titleMargins, i);
    }
    P = paramInt;
    O = paramInt;
    N = paramInt;
    M = paramInt;
    paramInt = paramContext.a(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      M = paramInt;
    }
    paramInt = paramContext.a(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      N = paramInt;
    }
    paramInt = paramContext.a(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      O = paramInt;
    }
    paramInt = paramContext.a(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      P = paramInt;
    }
    L = paramContext.b(R.styleable.Toolbar_maxButtonHeight, -1);
    int j = paramContext.a(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
    int k = paramContext.a(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
    paramInt = paramContext.b(R.styleable.Toolbar_contentInsetLeft, 0);
    i = paramContext.b(R.styleable.Toolbar_contentInsetRight, 0);
    b();
    paramAttributeSet = Q;
    h = false;
    if (paramInt != Integer.MIN_VALUE)
    {
      e = paramInt;
      a = paramInt;
    }
    if (i != Integer.MIN_VALUE)
    {
      f = i;
      b = i;
    }
    if ((j != Integer.MIN_VALUE) || (k != Integer.MIN_VALUE)) {
      Q.a(j, k);
    }
    R = paramContext.a(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
    S = paramContext.a(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
    C = paramContext.b(R.styleable.Toolbar_collapseIcon);
    D = paramContext.e(R.styleable.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.e(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.e(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    G = getContext();
    setPopupTheme(paramContext.f(R.styleable.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.b(R.styleable.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.e(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.b(R.styleable.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.e(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.f(R.styleable.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.a(R.styleable.Toolbar_titleTextColor));
    }
    if (paramContext.f(R.styleable.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.a(R.styleable.Toolbar_subtitleTextColor));
    }
    if (paramContext.f(R.styleable.Toolbar_menu))
    {
      paramInt = paramContext.f(R.styleable.Toolbar_menu, 0);
      getMenuInflater().inflate(paramInt, getMenu());
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
    Toolbar.e locale = (Toolbar.e)paramView.getLayoutParams();
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
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt1, getPaddingRight() + j + k + paramInt2, width);
    paramInt1 = getPaddingTop();
    paramView.measure(paramInt2, ViewGroup.getChildMeasureSpec(paramInt3, getPaddingBottom() + paramInt1 + topMargin + bottomMargin + paramInt4, height));
    return paramView.getMeasuredWidth() + k;
  }
  
  public final int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Toolbar.e locale = (Toolbar.e)paramView.getLayoutParams();
    int i = leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i);
    i = a(paramView, paramInt2);
    paramInt2 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, i, paramInt1 + paramInt2, paramView.getMeasuredHeight() + i);
    return paramInt2 + rightMargin + paramInt1;
  }
  
  public void a()
  {
    if (E == null)
    {
      Object localObject = new l(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      E = ((ImageButton)localObject);
      ((ImageButton)localObject).setImageDrawable(C);
      E.setContentDescription(D);
      localObject = generateDefaultLayoutParams();
      a = (0x800003 | K & 0x70);
      b = 2;
      E.setLayoutParams((ViewGroup.LayoutParams)localObject);
      E.setOnClickListener(new Toolbar.c(this));
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
      localObject = (Toolbar.e)localObject;
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
    Toolbar.e locale;
    if (i != 0) {
      for (paramInt = k - 1; paramInt >= 0; paramInt--)
      {
        localView = getChildAt(paramInt);
        locale = (Toolbar.e)localView.getLayoutParams();
        if ((b == 0) && (d(localView)) && (a(a) == m)) {
          paramList.add(localView);
        }
      }
    }
    while (paramInt < k)
    {
      localView = getChildAt(paramInt);
      locale = (Toolbar.e)localView.getLayoutParams();
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
    Toolbar.e locale = (Toolbar.e)paramView.getLayoutParams();
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
    if (Q == null) {
      Q = new p0();
    }
  }
  
  public final void c()
  {
    d();
    Object localObject = x;
    if (M == null)
    {
      localObject = (g)((ActionMenuView)localObject).getMenu();
      if (k0 == null) {
        k0 = new Toolbar.d(this);
      }
      x.setExpandedActionViewsExclusive(true);
      ((g)localObject).a(k0, G);
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
    if ((super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof Toolbar.e))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void d()
  {
    if (x == null)
    {
      Object localObject = new ActionMenuView(getContext());
      x = ((ActionMenuView)localObject);
      ((ActionMenuView)localObject).setPopupTheme(H);
      x.setOnMenuItemClickListener(h0);
      ActionMenuView localActionMenuView = x;
      m.a locala = l0;
      localObject = m0;
      R = locala;
      S = ((g.a)localObject);
      localObject = generateDefaultLayoutParams();
      a = (0x800005 | K & 0x70);
      x.setLayoutParams((ViewGroup.LayoutParams)localObject);
      a(x, false);
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
  
  public final void e()
  {
    if (A == null)
    {
      A = new l(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      Toolbar.e locale = generateDefaultLayoutParams();
      a = (0x800003 | K & 0x70);
      A.setLayoutParams(locale);
    }
  }
  
  public boolean f()
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
  
  public boolean g()
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
  
  public Toolbar.e generateDefaultLayoutParams()
  {
    return new Toolbar.e(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Toolbar.e(getContext(), paramAttributeSet);
  }
  
  public Toolbar.e generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof Toolbar.e)) {
      return new Toolbar.e((Toolbar.e)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof a.a)) {
      return new Toolbar.e((a.a)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new Toolbar.e((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new Toolbar.e(paramLayoutParams);
  }
  
  public CharSequence getCollapseContentDescription()
  {
    Object localObject = E;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getContentDescription();
    } else {
      localObject = null;
    }
    return (CharSequence)localObject;
  }
  
  public Drawable getCollapseIcon()
  {
    Object localObject = E;
    if (localObject != null) {
      localObject = ((ImageButton)localObject).getDrawable();
    } else {
      localObject = null;
    }
    return (Drawable)localObject;
  }
  
  public int getContentInsetEnd()
  {
    p0 localp0 = Q;
    int i;
    if (localp0 != null)
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
    p0 localp0 = Q;
    int i;
    if (localp0 != null) {
      i = a;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetRight()
  {
    p0 localp0 = Q;
    int i;
    if (localp0 != null) {
      i = b;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getContentInsetStart()
  {
    p0 localp0 = Q;
    int i;
    if (localp0 != null)
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
      if ((localObject != null) && (((g)localObject).hasVisibleItems()))
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
    c();
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
    c();
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
  
  public final TextView getSubtitleTextView()
  {
    return z;
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
  
  public final TextView getTitleTextView()
  {
    return y;
  }
  
  public d0 getWrapper()
  {
    if (i0 == null) {
      i0 = new z0(this, true);
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
    i3 = paramInt1;
    int i4 = paramInt2;
    if (d(x)) {
      if (i != 0)
      {
        i3 = a(x, paramInt1, arrayOfInt, paramInt4);
        i4 = paramInt2;
      }
      else
      {
        i4 = b(x, paramInt2, arrayOfInt, paramInt4);
        i3 = paramInt1;
      }
    }
    paramInt2 = getCurrentContentInsetLeft();
    paramInt1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, paramInt2 - i3);
    arrayOfInt[1] = Math.max(0, paramInt1 - (i2 - i4));
    paramInt2 = Math.max(i3, paramInt2);
    i4 = Math.min(i4, i2 - paramInt1);
    paramInt1 = paramInt2;
    i3 = i4;
    if (d(F)) {
      if (i != 0)
      {
        i3 = b(F, i4, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = a(F, paramInt2, arrayOfInt, paramInt4);
        i3 = i4;
      }
    }
    paramInt2 = paramInt1;
    i4 = i3;
    if (d(B)) {
      if (i != 0)
      {
        i4 = b(B, i3, arrayOfInt, paramInt4);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = a(B, paramInt1, arrayOfInt, paramInt4);
        i4 = i3;
      }
    }
    boolean bool = d(y);
    paramBoolean = d(z);
    Object localObject1;
    if (bool)
    {
      localObject1 = (Toolbar.e)y.getLayoutParams();
      paramInt1 = topMargin;
      paramInt1 = y.getMeasuredHeight() + paramInt1 + bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramBoolean)
    {
      localObject1 = (Toolbar.e)z.getLayoutParams();
      i3 = topMargin;
      paramInt1 += z.getMeasuredHeight() + i3 + bottomMargin;
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
      localObject1 = (Toolbar.e)((View)localObject1).getLayoutParams();
      localObject2 = (Toolbar.e)((View)localObject2).getLayoutParams();
      if (((bool) && (y.getMeasuredWidth() > 0)) || ((paramBoolean) && (z.getMeasuredWidth() > 0))) {
        i3 = 1;
      } else {
        i3 = 0;
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
            i5 = k - i1 - paramInt1 - i2 - n;
            i1 = bottomMargin;
            k = P;
            paramInt1 = i2;
            if (i5 < i1 + k) {
              paramInt1 = Math.max(0, i2 - (bottomMargin + k - i5));
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
        if (i3 != 0) {
          paramInt2 = M;
        } else {
          paramInt2 = 0;
        }
        i = paramInt2 - arrayOfInt[1];
        paramInt2 = i4 - Math.max(0, i);
        arrayOfInt[1] = Math.max(0, -i);
        if (bool)
        {
          localObject1 = (Toolbar.e)y.getLayoutParams();
          i = paramInt2 - y.getMeasuredWidth();
          i4 = y.getMeasuredHeight() + paramInt1;
          y.layout(i, paramInt1, paramInt2, i4);
          paramInt1 = i - N;
          i = i4 + bottomMargin;
        }
        else
        {
          i4 = paramInt2;
          i = paramInt1;
          paramInt1 = i4;
        }
        if (paramBoolean)
        {
          i4 = i + z.getLayoutParams()).topMargin;
          n = z.getMeasuredWidth();
          i = z.getMeasuredHeight();
          z.layout(paramInt2 - n, i4, paramInt2, i + i4);
          i4 = paramInt2 - N;
        }
        else
        {
          i4 = paramInt2;
        }
        if (i3 != 0) {
          paramInt2 = Math.min(paramInt1, i4);
        }
        paramInt1 = i2;
        i4 = paramInt2;
      }
      else
      {
        if (i3 != 0) {
          paramInt2 = M;
        } else {
          paramInt2 = 0;
        }
        i = paramInt2 - arrayOfInt[0];
        paramInt2 = Math.max(0, i) + i2;
        arrayOfInt[0] = Math.max(0, -i);
        if (bool)
        {
          localObject1 = (Toolbar.e)y.getLayoutParams();
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
          i2 = z.getMeasuredWidth() + paramInt2;
          n = z.getMeasuredHeight();
          z.layout(paramInt2, i, i2, n + i);
          i = i2 + N;
        }
        else
        {
          i = paramInt2;
        }
        if (i3 != 0) {
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
      i4 = b((View)d0.get(paramInt2), i4, arrayOfInt, i);
    }
    a(d0, 1);
    ArrayList localArrayList = d0;
    i3 = arrayOfInt[0];
    paramInt4 = arrayOfInt[1];
    n = localArrayList.size();
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt3 < n)
    {
      localObject1 = (View)localArrayList.get(paramInt3);
      localObject2 = (Toolbar.e)((View)localObject1).getLayoutParams();
      i3 = leftMargin - i3;
      paramInt4 = rightMargin - paramInt4;
      k = Math.max(0, i3);
      i1 = Math.max(0, paramInt4);
      i3 = Math.max(0, -i3);
      paramInt4 = Math.max(0, -paramInt4);
      paramInt2 += ((View)localObject1).getMeasuredWidth() + k + i1;
      paramInt3++;
    }
    paramInt3 = (j - i2 - m) / 2 + i2 - paramInt2 / 2;
    paramInt2 += paramInt3;
    if (paramInt3 >= paramInt1) {
      if (paramInt2 > i4) {
        paramInt1 = paramInt3 - (paramInt2 - i4);
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
    Object localObject = f0;
    boolean bool = d1.a(this);
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
    localObject[k] = Math.max(0, i3 - i4);
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
    localObject[m] = Math.max(0, i2 - i1);
    int k = i4;
    i2 = i3;
    i1 = n;
    if (d(F))
    {
      k = i4 + a(F, paramInt1, i4, paramInt2, 0, (int[])localObject);
      i1 = F.getMeasuredHeight();
      i2 = Math.max(i3, b(F) + i1);
      i1 = View.combineMeasuredStates(n, F.getMeasuredState());
    }
    i3 = k;
    int m = i2;
    n = i1;
    if (d(B))
    {
      i3 = k + a(B, paramInt1, k, paramInt2, 0, (int[])localObject);
      n = B.getMeasuredHeight();
      m = Math.max(i2, b(B) + n);
      n = View.combineMeasuredStates(i1, B.getMeasuredState());
    }
    i5 = getChildCount();
    i1 = 0;
    i2 = i3;
    while (i1 < i5)
    {
      View localView = getChildAt(i1);
      i4 = i2;
      k = m;
      i3 = n;
      if (getLayoutParamsb == 0) {
        if (!d(localView))
        {
          i4 = i2;
          k = m;
          i3 = n;
        }
        else
        {
          i4 = i2 + a(localView, paramInt1, i2, paramInt2, 0, (int[])localObject);
          i3 = localView.getMeasuredHeight();
          k = Math.max(m, b(localView) + i3);
          i3 = View.combineMeasuredStates(n, localView.getMeasuredState());
        }
      }
      i1++;
      i2 = i4;
      m = k;
      n = i3;
    }
    i4 = O + P;
    k = M + N;
    if (d(y))
    {
      a(y, paramInt1, i2 + k, paramInt2, i4, (int[])localObject);
      i5 = y.getMeasuredWidth();
      i3 = a(y);
      i1 = y.getMeasuredHeight();
      int i6 = b(y);
      n = View.combineMeasuredStates(n, y.getMeasuredState());
      i1 = i6 + i1;
      i3 += i5;
    }
    else
    {
      i3 = 0;
      i1 = 0;
    }
    if (d(z))
    {
      i3 = Math.max(i3, a(z, paramInt1, i2 + k, paramInt2, i1 + i4, (int[])localObject));
      k = z.getMeasuredHeight();
      i1 = b(z) + k + i1;
      n = View.combineMeasuredStates(n, z.getMeasuredState());
    }
    i4 = Math.max(m, i1);
    i1 = getPaddingLeft();
    i5 = getPaddingRight();
    m = getPaddingTop();
    k = getPaddingBottom();
    i1 = View.resolveSizeAndState(Math.max(i5 + i1 + (i2 + i3), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & n);
    n = View.resolveSizeAndState(Math.max(k + m + i4, getSuggestedMinimumHeight()), paramInt2, n << 16);
    if (!n0)
    {
      paramInt1 = 0;
    }
    else
    {
      i3 = getChildCount();
      for (paramInt2 = 0;; paramInt2++)
      {
        paramInt1 = i;
        if (paramInt2 >= i3) {
          break label1090;
        }
        localObject = getChildAt(paramInt2);
        if ((d((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0)) {
          break;
        }
      }
    }
    label1090:
    if (paramInt1 != 0) {
      paramInt1 = j;
    } else {
      paramInt1 = n;
    }
    setMeasuredDimension(i1, paramInt1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof Toolbar.g))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Toolbar.g localg = (Toolbar.g)paramParcelable;
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
    b();
    p0 localp0 = Q;
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
    Toolbar.g localg = new Toolbar.g(super.onSaveInstanceState());
    Object localObject = k0;
    if (localObject != null)
    {
      localObject = y;
      if (localObject != null) {
        z = a;
      }
    }
    A = f();
    return localg;
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
  
  public void setCollapseContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setCollapseContentDescription(localCharSequence);
  }
  
  public void setCollapseContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      a();
    }
    ImageButton localImageButton = E;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setCollapseIcon(int paramInt)
  {
    setCollapseIcon(d.b.b.a.a.c(getContext(), paramInt));
  }
  
  public void setCollapseIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      a();
      E.setImageDrawable(paramDrawable);
    }
    else
    {
      paramDrawable = E;
      if (paramDrawable != null) {
        paramDrawable.setImageDrawable(C);
      }
    }
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
      e();
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
      e();
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
    e();
    A.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(Toolbar.f paramf)
  {
    g0 = paramf;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    c();
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
        Context localContext = getContext();
        localObject = new z(localContext);
        z = ((TextView)localObject);
        ((TextView)localObject).setSingleLine();
        z.setEllipsize(TextUtils.TruncateAt.END);
        int i = J;
        if (i != 0) {
          z.setTextAppearance(localContext, i);
        }
        localObject = a0;
        if (localObject != null) {
          z.setTextColor((ColorStateList)localObject);
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
    setSubtitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setSubtitleTextColor(ColorStateList paramColorStateList)
  {
    a0 = paramColorStateList;
    TextView localTextView = z;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
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
        z localz = new z((Context)localObject);
        y = localz;
        localz.setSingleLine();
        y.setEllipsize(TextUtils.TruncateAt.END);
        int i = I;
        if (i != 0) {
          y.setTextAppearance((Context)localObject, i);
        }
        localObject = W;
        if (localObject != null) {
          y.setTextColor((ColorStateList)localObject);
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
    setTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setTitleTextColor(ColorStateList paramColorStateList)
  {
    W = paramColorStateList;
    TextView localTextView = y;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.Toolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */