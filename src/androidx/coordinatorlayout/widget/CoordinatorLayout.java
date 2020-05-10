package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R.attr;
import androidx.coordinatorlayout.R.style;
import androidx.coordinatorlayout.R.styleable;
import d.b.a.r;
import d.i.h.c;
import d.i.i.j;
import d.i.i.k;
import d.i.i.n;
import d.i.i.w;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
  extends ViewGroup
  implements d.i.i.h
{
  public static final String P;
  public static final Class<?>[] Q = { Context.class, AttributeSet.class };
  public static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.c>>> R = new ThreadLocal();
  public static final Comparator<View> S;
  public static final d.i.h.b<Rect> T = new c(12);
  public final List<View> A = new ArrayList();
  public final int[] B = new int[2];
  public boolean C;
  public boolean D;
  public int[] E;
  public View F;
  public View G;
  public CoordinatorLayout.g H;
  public boolean I;
  public w J;
  public boolean K;
  public Drawable L;
  public ViewGroup.OnHierarchyChangeListener M;
  public k N;
  public final j O = new j();
  public final List<View> x = new ArrayList();
  public final d.h.a.a<View> y = new d.h.a.a();
  public final List<View> z = new ArrayList();
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    P = (String)localObject;
    S = new CoordinatorLayout.i();
  }
  
  public CoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i = 0;
    if (paramInt == 0) {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    } else {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, 0);
    }
    paramInt = paramAttributeSet.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      E = paramContext.getIntArray(paramInt);
      float f = getDisplayMetricsdensity;
      int j = E.length;
      for (paramInt = i; paramInt < j; paramInt++)
      {
        paramContext = E;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
      }
    }
    L = paramAttributeSet.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    paramAttributeSet.recycle();
    b();
    super.setOnHierarchyChangeListener(new CoordinatorLayout.e(this));
  }
  
  public static CoordinatorLayout.c a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (paramString.startsWith("."))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramString.indexOf('.') >= 0)
    {
      localObject1 = paramString;
    }
    else
    {
      localObject1 = paramString;
      if (!TextUtils.isEmpty(P))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(P);
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    try
    {
      Object localObject2 = (Map)R.get();
      paramString = (String)localObject2;
      if (localObject2 == null)
      {
        paramString = new java/util/HashMap;
        paramString.<init>();
        R.set(paramString);
      }
      Constructor localConstructor = (Constructor)paramString.get(localObject1);
      localObject2 = localConstructor;
      if (localConstructor == null)
      {
        localObject2 = paramContext.getClassLoader().loadClass((String)localObject1).getConstructor(Q);
        ((Constructor)localObject2).setAccessible(true);
        paramString.put(localObject1, localObject2);
      }
      paramContext = (CoordinatorLayout.c)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException(e.a.a.a.a.b("Could not inflate Behavior subclass ", (String)localObject1), paramContext);
    }
  }
  
  public static void a(Rect paramRect)
  {
    paramRect.setEmpty();
    T.a(paramRect);
  }
  
  public static Rect c()
  {
    Rect localRect1 = (Rect)T.a();
    Rect localRect2 = localRect1;
    if (localRect1 == null) {
      localRect2 = new Rect();
    }
    return localRect2;
  }
  
  public final int a(int paramInt)
  {
    Object localObject = E;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
    }
    if ((paramInt >= 0) && (paramInt < localObject.length)) {
      return localObject[paramInt];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Keyline index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of range for ");
    ((StringBuilder)localObject).append(this);
    Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public List<View> a(View paramView)
  {
    d.h.a.a locala = y;
    int i = b.z;
    Object localObject1 = null;
    int j = 0;
    while (j < i)
    {
      ArrayList localArrayList = (ArrayList)b.e(j);
      Object localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramView))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(b.c(j));
        }
      }
      j++;
      localObject1 = localObject2;
    }
    A.clear();
    if (localObject1 != null) {
      A.addAll((Collection)localObject1);
    }
    return A;
  }
  
  public final void a()
  {
    x.clear();
    Object localObject1 = y;
    int i = b.z;
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      localObject2 = (ArrayList)b.e(k);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).clear();
        a.a(localObject2);
      }
    }
    b.clear();
    int m = getChildCount();
    k = 0;
    while (k < m)
    {
      View localView1 = getChildAt(k);
      CoordinatorLayout.f localf = c(localView1);
      if (f == -1)
      {
        l = null;
        k = null;
      }
      else
      {
        localObject1 = k;
        if (localObject1 != null)
        {
          if (((View)localObject1).getId() == f)
          {
            localObject2 = k;
            for (localObject1 = ((View)localObject2).getParent();; localObject1 = ((ViewParent)localObject1).getParent())
            {
              if (localObject1 == this) {
                break label232;
              }
              if ((localObject1 == null) || (localObject1 == localView1)) {
                break;
              }
              if ((localObject1 instanceof View)) {
                localObject2 = (View)localObject1;
              }
            }
            l = null;
            k = null;
          }
          i = 0;
          break label241;
          label232:
          l = ((View)localObject2);
          i = 1;
          label241:
          if (i != 0) {}
        }
        else
        {
          localObject2 = findViewById(f);
          k = ((View)localObject2);
          if (localObject2 != null)
          {
            if (localObject2 == this)
            {
              if (isInEditMode())
              {
                l = null;
                k = null;
              }
              else
              {
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
              }
            }
            else
            {
              for (localObject1 = ((View)localObject2).getParent(); (localObject1 != this) && (localObject1 != null); localObject1 = ((ViewParent)localObject1).getParent())
              {
                if (localObject1 == localView1)
                {
                  if (isInEditMode())
                  {
                    l = null;
                    k = null;
                    break label413;
                  }
                  throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                if ((localObject1 instanceof View)) {
                  localObject2 = (View)localObject1;
                }
              }
              l = ((View)localObject2);
            }
          }
          else
          {
            if (!isInEditMode()) {
              break label752;
            }
            l = null;
            k = null;
          }
        }
      }
      label413:
      y.a(localView1);
      for (i = 0; i < m; i++) {
        if (i != k)
        {
          View localView2 = getChildAt(i);
          if (localView2 != l)
          {
            n = n.i(this);
            int i1 = Gravity.getAbsoluteGravity(getLayoutParamsg, n);
            if ((i1 != 0) && ((Gravity.getAbsoluteGravity(h, n) & i1) == i1)) {
              n = 1;
            } else {
              n = 0;
            }
            if (n == 0)
            {
              localObject1 = a;
              if ((localObject1 == null) || (!((CoordinatorLayout.c)localObject1).a(this, localView1, localView2)))
              {
                n = 0;
                break label551;
              }
            }
          }
          int n = 1;
          label551:
          if (n != 0)
          {
            if (y.b.a(localView2) >= 0) {
              n = 1;
            } else {
              n = 0;
            }
            if (n == 0) {
              y.a(localView2);
            }
            d.h.a.a locala = y;
            if (b.a(localView2) >= 0) {
              n = 1;
            } else {
              n = 0;
            }
            if (n != 0)
            {
              if (b.a(localView1) >= 0) {
                n = 1;
              } else {
                n = 0;
              }
              if (n != 0)
              {
                localObject2 = (ArrayList)b.getOrDefault(localView2, null);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject2 = (ArrayList)a.a();
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new ArrayList();
                  }
                  b.put(localView2, localObject1);
                }
                ((ArrayList)localObject1).add(localView1);
                continue;
              }
            }
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
          }
        }
      }
      k++;
      continue;
      label752:
      localObject1 = e.a.a.a.a.a("Could not find CoordinatorLayout descendant view with id ");
      ((StringBuilder)localObject1).append(getResources().getResourceName(f));
      ((StringBuilder)localObject1).append(" to anchor view ");
      ((StringBuilder)localObject1).append(localView1);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    Object localObject2 = x;
    localObject1 = y;
    c.clear();
    d.clear();
    i = b.z;
    for (k = j; k < i; k++) {
      ((d.h.a.a)localObject1).a(b.c(k), c, d);
    }
    ((List)localObject2).addAll(c);
    Collections.reverse(x);
  }
  
  public final void a(int paramInt1, Rect paramRect1, Rect paramRect2, CoordinatorLayout.f paramf, int paramInt2, int paramInt3)
  {
    int i = c;
    int j = i;
    if (i == 0) {
      j = 17;
    }
    int k = Gravity.getAbsoluteGravity(j, paramInt1);
    i = d;
    j = i;
    if ((i & 0x7) == 0) {
      j = i | 0x800003;
    }
    i = j;
    if ((j & 0x70) == 0) {
      i = j | 0x30;
    }
    j = Gravity.getAbsoluteGravity(i, paramInt1);
    int m = k & 0x7;
    k &= 0x70;
    paramInt1 = j & 0x7;
    j &= 0x70;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 5) {
        paramInt1 = left;
      } else {
        paramInt1 = right;
      }
    }
    else {
      paramInt1 = left + paramRect1.width() / 2;
    }
    if (j != 16)
    {
      if (j != 80) {
        j = top;
      } else {
        j = bottom;
      }
    }
    else {
      j = top + paramRect1.height() / 2;
    }
    if (m != 1)
    {
      i = paramInt1;
      if (m != 5) {
        i = paramInt1 - paramInt2;
      }
    }
    else
    {
      i = paramInt1 - paramInt2 / 2;
    }
    if (k != 16)
    {
      paramInt1 = j;
      if (k != 80) {
        paramInt1 = j - paramInt3;
      }
    }
    else
    {
      paramInt1 = j - paramInt3 / 2;
    }
    paramRect2.set(i, paramInt1, paramInt2 + i, paramInt3 + paramInt1);
  }
  
  public void a(View paramView, int paramInt)
  {
    Object localObject = O;
    if (paramInt == 1) {
      b = 0;
    } else {
      a = 0;
    }
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      localObject = getChildAt(j);
      CoordinatorLayout.f localf = (CoordinatorLayout.f)((View)localObject).getLayoutParams();
      if (localf.a(paramInt))
      {
        CoordinatorLayout.c localc = a;
        if (localc != null) {
          localc.a(this, (View)localObject, paramView, paramInt);
        }
        localf.a(paramInt, false);
        p = false;
      }
    }
    G = null;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = getChildCount();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() != 8)
      {
        Object localObject = (CoordinatorLayout.f)localView.getLayoutParams();
        if (((CoordinatorLayout.f)localObject).a(paramInt5))
        {
          localObject = a;
          if (localObject != null)
          {
            ((CoordinatorLayout.c)localObject).a(this, localView, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
            j = 1;
          }
        }
      }
    }
    if (j != 0) {
      b(1);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    int i2;
    for (int n = 0; k < i; n = i2)
    {
      Object localObject1 = getChildAt(k);
      int i1;
      if (((View)localObject1).getVisibility() == 8)
      {
        i1 = m;
        i2 = n;
      }
      else
      {
        Object localObject2 = (CoordinatorLayout.f)((View)localObject1).getLayoutParams();
        if (!((CoordinatorLayout.f)localObject2).a(paramInt3))
        {
          i1 = m;
          i2 = n;
        }
        else
        {
          CoordinatorLayout.c localc = a;
          i1 = m;
          i2 = n;
          if (localc != null)
          {
            localObject2 = B;
            localObject2[1] = 0;
            localObject2[0] = 0;
            localc.a(this, (View)localObject1, paramView, paramInt1, paramInt2, (int[])localObject2, paramInt3);
            localObject1 = B;
            if (paramInt1 > 0) {
              i2 = Math.max(m, localObject1[0]);
            } else {
              i2 = Math.min(m, localObject1[0]);
            }
            i1 = i2;
            localObject1 = B;
            if (paramInt2 > 0) {
              i2 = Math.max(n, localObject1[1]);
            } else {
              i2 = Math.min(n, localObject1[1]);
            }
            j = 1;
          }
        }
      }
      k++;
      m = i1;
    }
    paramArrayOfInt[0] = m;
    paramArrayOfInt[1] = n;
    if (j != 0) {
      b(1);
    }
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    paramView1 = O;
    if (paramInt2 == 1) {
      b = paramInt1;
    } else {
      a = paramInt1;
    }
    G = paramView2;
    int i = getChildCount();
    for (paramInt1 = 0; paramInt1 < i; paramInt1++)
    {
      paramView1 = (CoordinatorLayout.f)getChildAt(paramInt1).getLayoutParams();
      if (paramView1.a(paramInt2)) {
        paramView1 = a;
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean) {
        d.h.a.b.a(this, paramView, paramRect);
      } else {
        paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      }
      return;
    }
    paramRect.setEmpty();
  }
  
  public final void a(CoordinatorLayout.f paramf, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getWidth();
    int j = getHeight();
    i = Math.max(getPaddingLeft() + leftMargin, Math.min(left, i - getPaddingRight() - paramInt1 - rightMargin));
    j = Math.max(getPaddingTop() + topMargin, Math.min(top, j - getPaddingBottom() - paramInt2 - bottomMargin));
    paramRect.set(i, j, paramInt1 + i, paramInt2 + j);
  }
  
  public final void a(List<View> paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int i = getChildCount();
    for (int j = i - 1; j >= 0; j--)
    {
      int k;
      if (bool) {
        k = getChildDrawingOrder(i, j);
      } else {
        k = j;
      }
      paramList.add(getChildAt(k));
    }
    Comparator localComparator = S;
    if (localComparator != null) {
      Collections.sort(paramList, localComparator);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      CoordinatorLayout.c localc = getLayoutParamsa;
      if (localc != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          localc.a(this, localView, localMotionEvent);
        } else {
          localc.b(this, localView, localMotionEvent);
        }
        localMotionEvent.recycle();
      }
    }
    for (j = 0; j < i; j++) {
      getChildAtgetLayoutParamsm = false;
    }
    F = null;
    C = false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int i = paramMotionEvent.getActionMasked();
    List localList = z;
    a(localList);
    int j = localList.size();
    Object localObject1 = null;
    int k = 0;
    boolean bool1 = false;
    boolean bool2;
    int n;
    for (int m = 0;; m = n)
    {
      bool2 = bool1;
      if (k >= j) {
        break;
      }
      View localView = (View)localList.get(k);
      Object localObject2 = (CoordinatorLayout.f)localView.getLayoutParams();
      CoordinatorLayout.c localc = a;
      boolean bool3;
      if (((bool1) || (m != 0)) && (i != 0))
      {
        localObject2 = localObject1;
        bool3 = bool1;
        n = m;
        if (localc != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
          }
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              bool3 = bool1;
              n = m;
            }
            else
            {
              localc.b(this, localView, (MotionEvent)localObject2);
              bool3 = bool1;
              n = m;
            }
          }
          else
          {
            localc.a(this, localView, (MotionEvent)localObject2);
            bool3 = bool1;
            n = m;
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (localc != null)
          {
            if (paramInt != 0)
            {
              if (paramInt == 1) {
                bool1 = localc.b(this, localView, paramMotionEvent);
              }
            }
            else {
              bool1 = localc.a(this, localView, paramMotionEvent);
            }
            bool2 = bool1;
            if (bool1)
            {
              F = localView;
              bool2 = bool1;
            }
          }
        }
        if (a == null) {
          m = false;
        }
        bool3 = m;
        if (bool3)
        {
          bool1 = true;
        }
        else
        {
          localc = a;
          bool1 = bool3 | false;
          m = bool1;
        }
        if ((bool1) && (!bool3)) {
          m = 1;
        } else {
          m = 0;
        }
        localObject2 = localObject1;
        bool3 = bool2;
        n = m;
        if (bool1)
        {
          localObject2 = localObject1;
          bool3 = bool2;
          n = m;
          if (m == 0) {
            break;
          }
        }
      }
      k++;
      localObject1 = localObject2;
      bool1 = bool3;
    }
    localList.clear();
    return bool2;
  }
  
  public boolean a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = c();
    d.h.a.b.a(this, paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      localRect.setEmpty();
      T.a(localRect);
    }
  }
  
  public List<View> b(View paramView)
  {
    paramView = (List)y.b.getOrDefault(paramView, null);
    A.clear();
    if (paramView != null) {
      A.addAll(paramView);
    }
    return A;
  }
  
  public final void b()
  {
    if (n.g(this))
    {
      if (N == null) {
        N = new CoordinatorLayout.a(this);
      }
      n.a(this, N);
      setSystemUiVisibility(1280);
    }
    else
    {
      n.a(this, null);
    }
  }
  
  public final void b(int paramInt)
  {
    int i = n.i(this);
    int j = x.size();
    Rect localRect1 = c();
    Rect localRect2 = c();
    Object localObject1 = c();
    int i1;
    for (int k = 0; k < j; k = i1)
    {
      View localView = (View)x.get(k);
      Object localObject2 = (CoordinatorLayout.f)localView.getLayoutParams();
      int m;
      if ((paramInt == 0) && (localView.getVisibility() == 8))
      {
        m = k;
        k = j;
      }
      else
      {
        int n = 0;
        i1 = k;
        k = j;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        int i2;
        for (j = n; j < i1; j++)
        {
          localObject3 = (View)x.get(j);
          if (l == localObject3)
          {
            localObject4 = (CoordinatorLayout.f)localView.getLayoutParams();
            if (k != null)
            {
              localObject3 = c();
              Rect localRect3 = c();
              localObject5 = c();
              d.h.a.b.a(this, k, (Rect)localObject3);
              a(localView, false, localRect3);
              i2 = localView.getMeasuredWidth();
              m = localView.getMeasuredHeight();
              a(i, (Rect)localObject3, (Rect)localObject5, (CoordinatorLayout.f)localObject4, i2, m);
              if ((left == left) && (top == top)) {
                n = 0;
              } else {
                n = 1;
              }
              a((CoordinatorLayout.f)localObject4, (Rect)localObject5, i2, m);
              m = left - left;
              i2 = top - top;
              if (m != 0) {
                n.c(localView, m);
              }
              if (i2 != 0) {
                n.d(localView, i2);
              }
              if (n != 0)
              {
                CoordinatorLayout.c localc = a;
                if (localc != null) {
                  localc.b(this, localView, k);
                }
              }
              ((Rect)localObject3).setEmpty();
              T.a(localObject3);
              localRect3.setEmpty();
              T.a(localRect3);
              ((Rect)localObject5).setEmpty();
              T.a(localObject5);
            }
          }
        }
        a(localView, true, localRect2);
        if ((g != 0) && (!localRect2.isEmpty()))
        {
          j = Gravity.getAbsoluteGravity(g, i);
          n = j & 0x70;
          if (n != 48)
          {
            if (n == 80) {
              bottom = Math.max(bottom, getHeight() - top);
            }
          }
          else {
            top = Math.max(top, bottom);
          }
          j &= 0x7;
          if (j != 3)
          {
            if (j == 5) {
              right = Math.max(right, getWidth() - left);
            }
          }
          else {
            left = Math.max(left, right);
          }
        }
        if ((h != 0) && (localView.getVisibility() == 0) && (localView.isLaidOut()) && (localView.getWidth() > 0) && (localView.getHeight() > 0))
        {
          localObject4 = (CoordinatorLayout.f)localView.getLayoutParams();
          localObject5 = a;
          localObject3 = c();
          localObject2 = c();
          ((Rect)localObject2).set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          if ((localObject5 != null) && (((CoordinatorLayout.c)localObject5).a(this, localView, (Rect)localObject3)))
          {
            if (!((Rect)localObject2).contains((Rect)localObject3))
            {
              localObject1 = e.a.a.a.a.a("Rect should be within the child's bounds. Rect:");
              ((StringBuilder)localObject1).append(((Rect)localObject3).toShortString());
              ((StringBuilder)localObject1).append(" | Bounds:");
              ((StringBuilder)localObject1).append(((Rect)localObject2).toShortString());
              throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
            }
          }
          else {
            ((Rect)localObject3).set((Rect)localObject2);
          }
          ((Rect)localObject2).setEmpty();
          T.a(localObject2);
          if (((Rect)localObject3).isEmpty())
          {
            ((Rect)localObject3).setEmpty();
            T.a(localObject3);
          }
          else
          {
            m = Gravity.getAbsoluteGravity(h, i);
            if ((m & 0x30) == 48)
            {
              j = top - topMargin - j;
              n = top;
              if (j < n)
              {
                d(localView, n - j);
                j = 1;
                break label857;
              }
            }
            j = 0;
            label857:
            n = j;
            if ((m & 0x50) == 80)
            {
              i2 = getHeight() - bottom - bottomMargin + j;
              int i3 = bottom;
              n = j;
              if (i2 < i3)
              {
                d(localView, i2 - i3);
                n = 1;
              }
            }
            if (n == 0) {
              d(localView, 0);
            }
            if ((m & 0x3) == 3)
            {
              j = left - leftMargin - i;
              n = left;
              if (j < n)
              {
                c(localView, n - j);
                j = 1;
                break label993;
              }
            }
            j = 0;
            label993:
            n = j;
            if ((m & 0x5) == 5)
            {
              i2 = getWidth() - right - rightMargin + i;
              m = right;
              n = j;
              if (i2 < m)
              {
                c(localView, i2 - m);
                n = 1;
              }
            }
            if (n == 0) {
              c(localView, 0);
            }
            ((Rect)localObject3).setEmpty();
            T.a(localObject3);
          }
        }
        if (paramInt != 2)
        {
          localObject3 = getLayoutParamsq;
          localObject2 = localObject1;
          ((Rect)localObject2).set((Rect)localObject3);
          if (((Rect)localObject2).equals(localRect2))
          {
            localObject1 = localObject2;
            m = i1;
            break label1297;
          }
          getLayoutParamsq.set(localRect2);
        }
        localObject2 = localObject1;
        n = i1 + 1;
        j = k;
        for (;;)
        {
          k = j;
          localObject1 = localObject2;
          m = i1;
          if (n >= j) {
            break;
          }
          localObject3 = (View)x.get(n);
          localObject1 = (CoordinatorLayout.f)((View)localObject3).getLayoutParams();
          localObject4 = a;
          if ((localObject4 != null) && (((CoordinatorLayout.c)localObject4).a(this, (View)localObject3, localView))) {
            if ((paramInt == 0) && (p))
            {
              p = false;
            }
            else
            {
              boolean bool;
              if (paramInt != 2) {
                bool = ((CoordinatorLayout.c)localObject4).b(this, (View)localObject3, localView);
              } else {
                bool = true;
              }
              if (paramInt == 1) {
                p = bool;
              }
            }
          }
          n++;
        }
      }
      label1297:
      i1 = m + 1;
      j = k;
    }
    a(localRect1);
    a(localRect2);
    a((Rect)localObject1);
  }
  
  public void b(View paramView, int paramInt)
  {
    Object localObject1 = (CoordinatorLayout.f)paramView.getLayoutParams();
    Object localObject2 = k;
    int i = 0;
    int j;
    if ((localObject2 == null) && (f != -1)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0)
    {
      Object localObject3 = k;
      if (localObject3 != null)
      {
        localObject1 = c();
        localObject2 = c();
      }
      int k;
      try
      {
        d.h.a.b.a(this, (View)localObject3, (Rect)localObject1);
        localObject3 = (CoordinatorLayout.f)paramView.getLayoutParams();
        j = paramView.getMeasuredWidth();
        i = paramView.getMeasuredHeight();
        a(paramInt, (Rect)localObject1, (Rect)localObject2, (CoordinatorLayout.f)localObject3, j, i);
        a((CoordinatorLayout.f)localObject3, (Rect)localObject2, j, i);
        paramView.layout(left, top, right, bottom);
        ((Rect)localObject1).setEmpty();
        T.a(localObject1);
        ((Rect)localObject2).setEmpty();
        T.a(localObject2);
      }
      finally
      {
        a((Rect)localObject1);
        a((Rect)localObject2);
      }
      localObject1 = (CoordinatorLayout.f)paramView.getLayoutParams();
      int m = c;
      j = m;
      if (m == 0) {
        j = 8388661;
      }
      j = Gravity.getAbsoluteGravity(j, paramInt);
      int n = j & 0x7;
      int i1 = j & 0x70;
      int i2 = getWidth();
      int i3 = getHeight();
      m = paramView.getMeasuredWidth();
      int i4 = paramView.getMeasuredHeight();
      j = k;
      if (paramInt == 1) {
        j = i2 - k;
      }
      paramInt = a(j) - m;
      if (n != 1)
      {
        if (n == 5) {
          paramInt += m;
        }
      }
      else {
        paramInt += m / 2;
      }
      if (i1 != 16)
      {
        if (i1 != 80) {
          j = i;
        } else {
          j = i4 + 0;
        }
      }
      else {
        j = 0 + i4 / 2;
      }
      paramInt = Math.max(getPaddingLeft() + leftMargin, Math.min(paramInt, i2 - getPaddingRight() - m - rightMargin));
      j = Math.max(getPaddingTop() + topMargin, Math.min(j, i3 - getPaddingBottom() - i4 - bottomMargin));
      paramView.layout(paramInt, j, m + paramInt, i4 + j);
      break label732;
      localObject1 = (CoordinatorLayout.f)paramView.getLayoutParams();
      localObject2 = c();
      ((Rect)localObject2).set(getPaddingLeft() + leftMargin, getPaddingTop() + topMargin, getWidth() - getPaddingRight() - rightMargin, getHeight() - getPaddingBottom() - bottomMargin);
      if ((J != null) && (n.g(this)) && (!paramView.getFitsSystemWindows()))
      {
        j = left;
        left = (J.b() + j);
        j = top;
        top = (J.d() + j);
        right -= J.c();
        bottom -= J.a();
      }
      localObject3 = c();
      i = c;
      j = i;
      if ((i & 0x7) == 0) {
        j = i | 0x800003;
      }
      i = j;
      if ((j & 0x70) == 0) {
        i = j | 0x30;
      }
      Gravity.apply(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), (Rect)localObject2, (Rect)localObject3, paramInt);
      paramView.layout(left, top, right, bottom);
      ((Rect)localObject2).setEmpty();
      T.a(localObject2);
      ((Rect)localObject3).setEmpty();
      T.a(localObject3);
      label732:
      return;
    }
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  public boolean b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool1 = false;
    while (j < i)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.f localf = (CoordinatorLayout.f)localView.getLayoutParams();
        CoordinatorLayout.c localc = a;
        if (localc != null)
        {
          boolean bool2 = localc.a(this, localView, paramView1, paramView2, paramInt1, paramInt2);
          bool1 |= bool2;
          localf.a(paramInt2, bool2);
        }
        else
        {
          localf.a(paramInt2, false);
        }
      }
      j++;
    }
    return bool1;
  }
  
  public CoordinatorLayout.f c(View paramView)
  {
    CoordinatorLayout.f localf = (CoordinatorLayout.f)paramView.getLayoutParams();
    if (!b) {
      if ((paramView instanceof CoordinatorLayout.b))
      {
        paramView = ((CoordinatorLayout.b)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        localf.a(paramView);
        b = true;
      }
      else
      {
        Class localClass = paramView.getClass();
        Object localObject;
        for (paramView = null; localClass != null; paramView = (View)localObject)
        {
          localObject = (CoordinatorLayout.d)localClass.getAnnotation(CoordinatorLayout.d.class);
          paramView = (View)localObject;
          if (localObject != null) {
            break;
          }
          localClass = localClass.getSuperclass();
        }
        if (paramView != null) {
          try
          {
            localf.a((CoordinatorLayout.c)paramView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
          }
          catch (Exception localException)
          {
            localObject = e.a.a.a.a.a("Default behavior class ");
            ((StringBuilder)localObject).append(paramView.value().getName());
            ((StringBuilder)localObject).append(" could not be instantiated. Did you forget");
            ((StringBuilder)localObject).append(" a default constructor?");
            Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString(), localException);
          }
        }
        b = true;
      }
    }
    return localf;
  }
  
  public final void c(View paramView, int paramInt)
  {
    CoordinatorLayout.f localf = (CoordinatorLayout.f)paramView.getLayoutParams();
    int i = i;
    if (i != paramInt)
    {
      n.c(paramView, paramInt - i);
      i = paramInt;
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if (((paramLayoutParams instanceof CoordinatorLayout.f)) && (super.checkLayoutParams(paramLayoutParams))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void d(View paramView, int paramInt)
  {
    CoordinatorLayout.f localf = (CoordinatorLayout.f)paramView.getLayoutParams();
    int i = j;
    if (i != paramInt)
    {
      n.d(paramView, paramInt - i);
      j = paramInt;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    CoordinatorLayout.c localc = getLayoutParamsa;
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = L;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new CoordinatorLayout.f(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CoordinatorLayout.f(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof CoordinatorLayout.f)) {
      paramLayoutParams = new CoordinatorLayout.f((CoordinatorLayout.f)paramLayoutParams);
    } else if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramLayoutParams = new CoordinatorLayout.f((ViewGroup.MarginLayoutParams)paramLayoutParams);
    } else {
      paramLayoutParams = new CoordinatorLayout.f(paramLayoutParams);
    }
    return paramLayoutParams;
  }
  
  public final List<View> getDependencySortedChildren()
  {
    a();
    return Collections.unmodifiableList(x);
  }
  
  public final w getLastWindowInsets()
  {
    return J;
  }
  
  public int getNestedScrollAxes()
  {
    return O.a();
  }
  
  public Drawable getStatusBarBackground()
  {
    return L;
  }
  
  public int getSuggestedMinimumHeight()
  {
    int i = super.getSuggestedMinimumHeight();
    int j = getPaddingTop();
    return Math.max(i, getPaddingBottom() + j);
  }
  
  public int getSuggestedMinimumWidth()
  {
    int i = super.getSuggestedMinimumWidth();
    int j = getPaddingLeft();
    return Math.max(i, getPaddingRight() + j);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(false);
    if (I)
    {
      if (H == null) {
        H = new CoordinatorLayout.g(this);
      }
      getViewTreeObserver().addOnPreDrawListener(H);
    }
    if ((J == null) && (n.g(this))) {
      requestApplyInsets();
    }
    D = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
    if ((I) && (H != null)) {
      getViewTreeObserver().removeOnPreDrawListener(H);
    }
    View localView = G;
    if (localView != null) {
      a(localView, 0);
    }
    D = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((K) && (L != null))
    {
      w localw = J;
      int i;
      if (localw != null) {
        i = localw.d();
      } else {
        i = 0;
      }
      if (i > 0)
      {
        L.setBounds(0, 0, getWidth(), i);
        L.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      a(true);
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i == 1) || (i == 3)) {
      a(true);
    }
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = n.i(this);
    paramInt2 = x.size();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++)
    {
      View localView = (View)x.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        CoordinatorLayout.c localc = getLayoutParamsa;
        if ((localc == null) || (!localc.a(this, localView, paramInt3))) {
          b(localView, paramInt3);
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    int i = getChildCount();
    Object localObject1;
    Object localObject2;
    int k;
    Object localObject3;
    for (int j = 0; j < i; j++)
    {
      localObject1 = getChildAt(j);
      localObject2 = y;
      k = b.z;
      for (m = 0; m < k; m++)
      {
        localObject3 = (ArrayList)b.e(m);
        if ((localObject3 != null) && (((ArrayList)localObject3).contains(localObject1)))
        {
          m = 1;
          break label97;
        }
      }
      m = 0;
      label97:
      if (m != 0)
      {
        n = 1;
        break label117;
      }
    }
    int n = 0;
    label117:
    if (n != I) {
      if (n != 0)
      {
        if (D)
        {
          if (H == null) {
            H = new CoordinatorLayout.g(this);
          }
          getViewTreeObserver().addOnPreDrawListener(H);
        }
        I = true;
      }
      else
      {
        if ((D) && (H != null)) {
          getViewTreeObserver().removeOnPreDrawListener(H);
        }
        I = false;
      }
    }
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i3 = getPaddingRight();
    int i4 = getPaddingBottom();
    int i5 = n.i(this);
    if (i5 == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i9 = View.MeasureSpec.getSize(paramInt2);
    int i10 = getSuggestedMinimumWidth();
    int i11 = getSuggestedMinimumHeight();
    if ((J != null) && (getFitsSystemWindows())) {
      k = 1;
    } else {
      k = 0;
    }
    int i12 = x.size();
    j = 0;
    int i13 = 0;
    int i14;
    for (int m = i1;; m = i14)
    {
      i14 = m;
      if (i13 >= i12) {
        break;
      }
      localObject2 = (View)x.get(i13);
      if (((View)localObject2).getVisibility() != 8)
      {
        localObject1 = (CoordinatorLayout.f)((View)localObject2).getLayoutParams();
        m = e;
        int i15;
        int i16;
        if ((m >= 0) && (i6 != 0))
        {
          i15 = a(m);
          i16 = c;
          m = i16;
          if (i16 == 0) {
            m = 8388661;
          }
          m = Gravity.getAbsoluteGravity(m, i5) & 0x7;
          if (((m == 3) && (i == 0)) || ((m == 5) && (i != 0)))
          {
            m = Math.max(0, i7 - i3 - i15);
            break label514;
          }
          if (((m == 5) && (i == 0)) || ((m == 3) && (i != 0)))
          {
            m = Math.max(0, i15 - i14);
            break label514;
          }
        }
        m = 0;
        label514:
        int i17 = j;
        if ((k != 0) && (!((View)localObject2).getFitsSystemWindows()))
        {
          int i18 = J.b();
          j = J.c();
          i15 = J.d();
          i16 = J.a();
          j = View.MeasureSpec.makeMeasureSpec(i7 - (j + i18), i6);
          i16 = View.MeasureSpec.makeMeasureSpec(i9 - (i16 + i15), i8);
          i15 = j;
          j = i16;
        }
        else
        {
          i16 = paramInt1;
          j = paramInt2;
          i15 = i16;
        }
        localObject3 = a;
        if (localObject3 != null) {
          if (((CoordinatorLayout.c)localObject3).a(this, (View)localObject2, i15, m, j, 0)) {
            break label664;
          }
        }
        a((View)localObject2, i15, m, j, 0);
        label664:
        i10 = Math.max(i10, ((View)localObject2).getMeasuredWidth() + (i1 + i3) + leftMargin + rightMargin);
        i11 = Math.max(i11, ((View)localObject2).getMeasuredHeight() + (i2 + i4) + topMargin + bottomMargin);
        j = View.combineMeasuredStates(i17, ((View)localObject2).getMeasuredState());
      }
      i13++;
    }
    setMeasuredDimension(View.resolveSizeAndState(i10, paramInt1, 0xFF000000 & j), View.resolveSizeAndState(i11, paramInt2, j << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      paramView = getChildAt(j);
      if (paramView.getVisibility() != 8)
      {
        paramView = (CoordinatorLayout.f)paramView.getLayoutParams();
        if (paramView.a(0)) {
          paramView = a;
        }
      }
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool2;
    for (boolean bool1 = false; j < i; bool1 = bool2)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() == 8)
      {
        bool2 = bool1;
      }
      else
      {
        Object localObject = (CoordinatorLayout.f)localView.getLayoutParams();
        if (!((CoordinatorLayout.f)localObject).a(0))
        {
          bool2 = bool1;
        }
        else
        {
          localObject = a;
          bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((CoordinatorLayout.c)localObject).a(this, localView, paramView, paramFloat1, paramFloat2);
          }
        }
      }
      j++;
    }
    return bool1;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.h))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (CoordinatorLayout.h)paramParcelable;
    super.onRestoreInstanceState(x);
    SparseArray localSparseArray = z;
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      paramParcelable = getChildAt(i);
      int k = paramParcelable.getId();
      CoordinatorLayout.c localc = ca;
      if ((k != -1) && (localc != null))
      {
        Parcelable localParcelable = (Parcelable)localSparseArray.get(k);
        if (localParcelable != null) {
          localc.a(this, paramParcelable, localParcelable);
        }
      }
      i++;
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.h localh = new CoordinatorLayout.h(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      Object localObject = getChildAt(j);
      int k = ((View)localObject).getId();
      CoordinatorLayout.c localc = getLayoutParamsa;
      if ((k != -1) && (localc != null))
      {
        localObject = localc.a(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
    }
    z = localSparseArray;
    return localh;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return b(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    a(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1;
    if (F == null)
    {
      bool1 = a(paramMotionEvent, 1);
      bool2 = bool1;
      if (!bool1) {
        break label76;
      }
    }
    else
    {
      bool1 = false;
    }
    CoordinatorLayout.c localc = F.getLayoutParams()).a;
    boolean bool2 = bool1;
    boolean bool3;
    if (localc != null)
    {
      bool3 = localc.b(this, F, paramMotionEvent);
      bool2 = bool1;
      bool1 = bool3;
    }
    else
    {
      label76:
      bool1 = false;
    }
    View localView = F;
    localc = null;
    if (localView == null)
    {
      bool3 = bool1 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = localc;
    }
    else
    {
      bool3 = bool1;
      paramMotionEvent = localc;
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        super.onTouchEvent(paramMotionEvent);
        bool3 = bool1;
      }
    }
    if (paramMotionEvent != null) {
      paramMotionEvent.recycle();
    }
    if ((i == 1) || (i == 3)) {
      a(false);
    }
    return bool3;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    CoordinatorLayout.c localc = getLayoutParamsa;
    if ((localc != null) && (localc.a(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!C))
    {
      a(false);
      C = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    b();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    M = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable1 = L;
    if (localDrawable1 != paramDrawable)
    {
      Drawable localDrawable2 = null;
      if (localDrawable1 != null) {
        localDrawable1.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable2 = paramDrawable.mutate();
      }
      L = localDrawable2;
      if (localDrawable2 != null)
      {
        if (localDrawable2.isStateful()) {
          L.setState(getDrawableState());
        }
        r.a(L, n.i(this));
        paramDrawable = L;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        L.setCallback(this);
      }
      n.x(this);
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = d.i.b.a.c(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = L;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      L.setVisible(bool, false);
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    boolean bool;
    if ((!super.verifyDrawable(paramDrawable)) && (paramDrawable != L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.androidx.coordinatorlayout.widget.CoordinatorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */