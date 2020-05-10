package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.b.a.s;
import d.g.a.h.c.b;
import d.g.a.h.c.c;
import d.g.a.h.d.a;
import d.g.a.h.g;
import d.g.a.h.j;
import d.g.a.h.k;
import d.g.a.h.l;
import d.g.a.h.n;
import d.g.b.a;
import d.g.b.b;
import d.g.b.c.a;
import d.g.b.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintLayout
  extends ViewGroup
{
  public d.g.a.h.e A = new d.g.a.h.e();
  public int B = 0;
  public int C = 0;
  public int D = Integer.MAX_VALUE;
  public int E = Integer.MAX_VALUE;
  public boolean F = true;
  public int G = 7;
  public d.g.b.c H = null;
  public int I = -1;
  public HashMap<String, Integer> J = new HashMap();
  public int K = -1;
  public int L = -1;
  public SparseArray<View> x = new SparseArray();
  public ArrayList<b> y = new ArrayList(4);
  public final ArrayList<d.g.a.h.d> z = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  public final d.g.a.h.d a(int paramInt)
  {
    if (paramInt == 0) {
      return A;
    }
    View localView = (View)x.get(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localView = findViewById(paramInt);
      localObject = localView;
      if (localView != null)
      {
        localObject = localView;
        if (localView != this)
        {
          localObject = localView;
          if (localView.getParent() == this)
          {
            onViewAdded(localView);
            localObject = localView;
          }
        }
      }
    }
    if (localObject == this) {
      return A;
    }
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = getLayoutParamsk0;
    }
    return (d.g.a.h.d)localObject;
  }
  
  public final d.g.a.h.d a(View paramView)
  {
    if (paramView == this) {
      return A;
    }
    if (paramView == null) {
      paramView = null;
    } else {
      paramView = getLayoutParamsk0;
    }
    return paramView;
  }
  
  public Object a(int paramInt, Object paramObject)
  {
    if ((paramInt == 0) && ((paramObject instanceof String)))
    {
      String str = (String)paramObject;
      paramObject = J;
      if ((paramObject != null) && (((HashMap)paramObject).containsKey(str))) {
        return J.get(str);
      }
    }
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop();
    int j = getPaddingBottom() + i;
    i = getPaddingLeft();
    int k = getPaddingRight() + i;
    int m = getChildCount();
    for (int n = 0; n < m; n++)
    {
      View localView = getChildAt(n);
      if (localView.getVisibility() != 8)
      {
        a locala = (a)localView.getLayoutParams();
        d.g.a.h.d locald = k0;
        if ((!X) && (!Y))
        {
          Y = localView.getVisibility();
          int i1 = width;
          int i2 = height;
          boolean bool = U;
          int i3 = 1;
          int i4 = 1;
          if ((!bool) && (!V) && ((bool) || (H != 1)) && (width != -1) && ((V) || ((I != 1) && (height != -1)))) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            if (i1 == 0)
            {
              i1 = ViewGroup.getChildMeasureSpec(paramInt1, k, -2);
              i = 1;
            }
            else if (i1 == -1)
            {
              i1 = ViewGroup.getChildMeasureSpec(paramInt1, k, -1);
              i = 0;
            }
            else
            {
              if (i1 == -2) {
                i = 1;
              } else {
                i = 0;
              }
              i1 = ViewGroup.getChildMeasureSpec(paramInt1, k, i1);
            }
            if (i2 == 0) {}
            for (i2 = ViewGroup.getChildMeasureSpec(paramInt2, j, -2);; i2 = ViewGroup.getChildMeasureSpec(paramInt2, j, i2))
            {
              break;
              if (i2 == -1)
              {
                i2 = ViewGroup.getChildMeasureSpec(paramInt2, j, -1);
                i4 = 0;
                break;
              }
              if (i2 == -2) {
                i4 = i3;
              } else {
                i4 = 0;
              }
            }
            localView.measure(i1, i2);
            i1 = localView.getMeasuredWidth();
            i2 = localView.getMeasuredHeight();
          }
          else
          {
            i4 = 0;
            i = 0;
          }
          locald.f(i1);
          locald.e(i2);
          if (i != 0) {
            T = i1;
          }
          if (i4 != 0) {
            U = i2;
          }
          if (W)
          {
            i = localView.getBaseline();
            if (i != -1) {
              Q = i;
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    if ((paramInt == 0) && ((paramObject1 instanceof String)) && ((paramObject2 instanceof Integer)))
    {
      if (J == null) {
        J = new HashMap();
      }
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1) {
        paramObject1 = str.substring(paramInt + 1);
      }
      paramInt = ((Integer)paramObject2).intValue();
      J.put(paramObject1, Integer.valueOf(paramInt));
    }
  }
  
  public final void a(AttributeSet paramAttributeSet)
  {
    A.X = this;
    x.put(getId(), this);
    H = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = paramAttributeSet.getIndexCount();
      for (int j = 0; j < i; j++)
      {
        int k = paramAttributeSet.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth)
        {
          B = paramAttributeSet.getDimensionPixelOffset(k, B);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight)
        {
          C = paramAttributeSet.getDimensionPixelOffset(k, C);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth)
        {
          D = paramAttributeSet.getDimensionPixelOffset(k, D);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight)
        {
          E = paramAttributeSet.getDimensionPixelOffset(k, E);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          G = paramAttributeSet.getInt(k, G);
        }
        else if (k == R.styleable.ConstraintLayout_Layout_constraintSet)
        {
          k = paramAttributeSet.getResourceId(k, 0);
          try
          {
            d.g.b.c localc = new d/g/b/c;
            localc.<init>();
            H = localc;
            localc.a(getContext(), k);
          }
          catch (Resources.NotFoundException localNotFoundException)
          {
            H = null;
          }
          I = k;
        }
      }
      paramAttributeSet.recycle();
    }
    A.C0 = G;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    ConstraintLayout localConstraintLayout = this;
    int i = getPaddingTop();
    int j = getPaddingBottom() + i;
    i = getPaddingLeft();
    int k = getPaddingRight() + i;
    int m = getChildCount();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int n;
    int i1;
    int i2;
    int i3;
    for (i = 0; i < m; i++)
    {
      localObject1 = localConstraintLayout.getChildAt(i);
      if (((View)localObject1).getVisibility() != 8)
      {
        localObject2 = (a)((View)localObject1).getLayoutParams();
        localObject3 = k0;
        if ((!X) && (!Y))
        {
          Y = ((View)localObject1).getVisibility();
          n = width;
          i1 = height;
          if ((n != 0) && (i1 != 0))
          {
            if (n == -2) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            i3 = ViewGroup.getChildMeasureSpec(paramInt1, k, n);
            if (i1 == -2) {
              n = 1;
            } else {
              n = 0;
            }
            ((View)localObject1).measure(i3, ViewGroup.getChildMeasureSpec(paramInt2, j, i1));
            i1 = ((View)localObject1).getMeasuredWidth();
            i3 = ((View)localObject1).getMeasuredHeight();
            ((d.g.a.h.d)localObject3).f(i1);
            ((d.g.a.h.d)localObject3).e(i3);
            if (i2 != 0) {
              T = i1;
            }
            if (n != 0) {
              U = i3;
            }
            if (W)
            {
              i2 = ((View)localObject1).getBaseline();
              if (i2 != -1) {
                Q = i2;
              }
            }
            if ((U) && (V))
            {
              ((d.g.a.h.d)localObject3).g().a(i1);
              ((d.g.a.h.d)localObject3).f().a(i3);
            }
          }
          else
          {
            ((d.g.a.h.d)localObject3).g().b();
            ((d.g.a.h.d)localObject3).f().b();
          }
        }
      }
    }
    A.r();
    for (int i4 = 0;; i4++)
    {
      localConstraintLayout = this;
      if (i4 >= m) {
        break;
      }
      localObject2 = localConstraintLayout.getChildAt(i4);
      if (((View)localObject2).getVisibility() != 8)
      {
        localObject3 = (a)((View)localObject2).getLayoutParams();
        localObject1 = k0;
        if ((!X) && (!Y))
        {
          Y = ((View)localObject2).getVisibility();
          n = width;
          int i5 = height;
          if ((n == 0) || (i5 == 0))
          {
            j localj1 = aLEFTa;
            j localj2 = aRIGHTa;
            if ((aLEFTd != null) && (aRIGHTd != null)) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            j localj3 = aTOPa;
            j localj4 = aBOTTOMa;
            if ((aTOPd != null) && (aBOTTOMd != null)) {
              i3 = 1;
            } else {
              i3 = 0;
            }
            if ((n != 0) || (i5 != 0) || (i2 == 0) || (i3 == 0))
            {
              if (A.e() != d.a.WRAP_CONTENT) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (A.h() != d.a.WRAP_CONTENT) {
                i = 1;
              } else {
                i = 0;
              }
              if (i1 == 0) {
                ((d.g.a.h.d)localObject1).g().b();
              }
              if (i == 0) {
                ((d.g.a.h.d)localObject1).f().b();
              }
              if (n == 0)
              {
                if (i1 != 0)
                {
                  if ((e == 0) && (G == 0.0F) && (h == 0) && (i == 0) && (C[0] == d.a.MATCH_CONSTRAINT)) {
                    n = 1;
                  } else {
                    n = 0;
                  }
                  if ((n != 0) && (i2 != 0) && (localj1.c()) && (localj2.c()))
                  {
                    i2 = (int)(g - g);
                    ((d.g.a.h.d)localObject1).g().a(i2);
                    i2 = ViewGroup.getChildMeasureSpec(paramInt1, k, i2);
                    break label835;
                  }
                }
                n = ViewGroup.getChildMeasureSpec(paramInt1, k, -2);
                i2 = 1;
                i6 = 0;
                break label879;
              }
              else
              {
                if (n != -1) {
                  break label849;
                }
                i2 = ViewGroup.getChildMeasureSpec(paramInt1, k, -1);
              }
              label835:
              n = i2;
              i2 = 0;
              int i6 = i1;
              break label879;
              label849:
              if (n == -2) {
                i2 = 1;
              } else {
                i2 = 0;
              }
              n = ViewGroup.getChildMeasureSpec(paramInt1, k, n);
              i6 = i1;
              label879:
              if (i5 == 0)
              {
                if (i != 0)
                {
                  if ((f == 0) && (G == 0.0F) && (k == 0) && (l == 0) && (C[1] == d.a.MATCH_CONSTRAINT)) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  }
                  if ((i1 != 0) && (i3 != 0) && (localj3.c()) && (localj4.c()))
                  {
                    i1 = (int)(g - g);
                    ((d.g.a.h.d)localObject1).f().a(i1);
                    i1 = ViewGroup.getChildMeasureSpec(paramInt2, j, i1);
                    break label1042;
                  }
                }
                i1 = ViewGroup.getChildMeasureSpec(paramInt2, j, -2);
                i = 0;
                i3 = 1;
                break label1082;
              }
              else
              {
                if (i5 != -1) {
                  break label1048;
                }
                i1 = ViewGroup.getChildMeasureSpec(paramInt2, j, -1);
              }
              label1042:
              i3 = 0;
              break label1082;
              label1048:
              if (i5 == -2) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              i5 = ViewGroup.getChildMeasureSpec(paramInt2, j, i5);
              i3 = i1;
              i1 = i5;
              label1082:
              ((View)localObject2).measure(n, i1);
              i1 = ((View)localObject2).getMeasuredWidth();
              n = ((View)localObject2).getMeasuredHeight();
              ((d.g.a.h.d)localObject1).f(i1);
              ((d.g.a.h.d)localObject1).e(n);
              if (i2 != 0) {
                T = i1;
              }
              if (i3 != 0) {
                U = n;
              }
              if (i6 != 0) {
                ((d.g.a.h.d)localObject1).g().a(i1);
              } else {
                gb = 2;
              }
              if (i != 0) {
                ((d.g.a.h.d)localObject1).f().a(n);
              } else {
                fb = 2;
              }
              if (W)
              {
                i = ((View)localObject2).getBaseline();
                if (i != -1) {
                  Q = i;
                }
              }
              else {}
            }
          }
        }
      }
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof a;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode())
    {
      int i = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      for (int j = 0; j < i; j++)
      {
        Object localObject = getChildAt(j);
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = ((View)localObject).getTag();
          if ((localObject != null) && ((localObject instanceof String)))
          {
            localObject = ((String)localObject).split(",");
            if (localObject.length == 4)
            {
              int k = Integer.parseInt(localObject[0]);
              int m = Integer.parseInt(localObject[1]);
              int n = Integer.parseInt(localObject[2]);
              int i1 = Integer.parseInt(localObject[3]);
              k = (int)(k / 1080.0F * f1);
              m = (int)(m / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              localObject = new Paint();
              ((Paint)localObject).setColor(-65536);
              float f3 = k;
              float f4 = m;
              float f5 = k + n;
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)localObject);
              float f6 = m + i1;
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)localObject);
              ((Paint)localObject).setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)localObject);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)localObject);
            }
          }
        }
      }
    }
  }
  
  public a generateDefaultLayoutParams()
  {
    return new a(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new a(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new a(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return E;
  }
  
  public int getMaxWidth()
  {
    return D;
  }
  
  public int getMinHeight()
  {
    return C;
  }
  
  public int getMinWidth()
  {
    return B;
  }
  
  public int getOptimizationLevel()
  {
    return A.C0;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++)
    {
      View localView = getChildAt(paramInt1);
      a locala = (a)localView.getLayoutParams();
      Object localObject = k0;
      if (((localView.getVisibility() != 8) || (X) || (Y) || (paramBoolean)) && (!Z))
      {
        paramInt4 = M + O;
        int i = N + P;
        int j = ((d.g.a.h.d)localObject).i() + paramInt4;
        int k = ((d.g.a.h.d)localObject).d() + i;
        localView.layout(paramInt4, i, j, k);
        if ((localView instanceof f))
        {
          localObject = ((f)localView).getContent();
          if (localObject != null)
          {
            ((View)localObject).setVisibility(0);
            ((View)localObject).layout(paramInt4, i, j, k);
          }
        }
      }
    }
    paramInt3 = y.size();
    if (paramInt3 > 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3) {
        if ((b)y.get(paramInt1) != null) {
          paramInt1++;
        } else {
          throw null;
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    System.currentTimeMillis();
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = getPaddingLeft();
    int i1 = getPaddingTop();
    Object localObject1 = A;
    I = n;
    J = i1;
    int i2 = D;
    Object localObject2 = q;
    localObject2[0] = i2;
    localObject2[1] = E;
    boolean bool1;
    if (getLayoutDirection() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    l0 = bool1;
    int i3 = View.MeasureSpec.getMode(paramInt1);
    i2 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i6 = getPaddingTop();
    int i7 = getPaddingBottom();
    int i8 = getPaddingLeft();
    int i10 = getPaddingRight();
    localObject1 = d.a.FIXED;
    getLayoutParams();
    if (i3 != Integer.MIN_VALUE)
    {
      if (i3 != 0)
      {
        if (i3 != 1073741824)
        {
          localObject2 = localObject1;
        }
        else
        {
          i2 = Math.min(D, i2) - (i10 + i8);
          localObject2 = localObject1;
          break label236;
        }
      }
      else {
        localObject2 = d.a.WRAP_CONTENT;
      }
      i2 = 0;
    }
    else
    {
      localObject2 = d.a.WRAP_CONTENT;
    }
    label236:
    if (i4 != Integer.MIN_VALUE)
    {
      if (i4 != 0)
      {
        if (i4 == 1073741824)
        {
          i5 = Math.min(E, i5) - (i7 + i6);
          break label296;
        }
      }
      else {
        localObject1 = d.a.WRAP_CONTENT;
      }
      i5 = 0;
    }
    else
    {
      localObject1 = d.a.WRAP_CONTENT;
    }
    label296:
    Object localObject3 = A;
    R = 0;
    S = 0;
    ((d.g.a.h.d)localObject3).a((d.a)localObject2);
    A.f(i2);
    A.b((d.a)localObject1);
    A.e(i5);
    localObject1 = A;
    i2 = B - getPaddingLeft() - getPaddingRight();
    if (i2 < 0) {
      R = 0;
    } else {
      R = i2;
    }
    localObject1 = A;
    i2 = C - getPaddingTop() - getPaddingBottom();
    if (i2 < 0) {
      S = 0;
    } else {
      S = i2;
    }
    i7 = A.i();
    i10 = A.d();
    if (F)
    {
      F = false;
      i5 = getChildCount();
      for (i2 = 0; i2 < i5; i2++) {
        if (getChildAt(i2).isLayoutRequested())
        {
          i2 = 1;
          break label507;
        }
      }
      i2 = 0;
      label507:
      if (i2 != 0)
      {
        z.clear();
        bool1 = isInEditMode();
        i8 = getChildCount();
        if (bool1)
        {
          i2 = 0;
          while (i2 < i8)
          {
            localObject3 = getChildAt(i2);
            try
            {
              localObject2 = getResources().getResourceName(((View)localObject3).getId());
              a(0, localObject2, Integer.valueOf(((View)localObject3).getId()));
              i5 = ((String)localObject2).indexOf('/');
              localObject1 = localObject2;
              if (i5 != -1) {
                localObject1 = ((String)localObject2).substring(i5 + 1);
              }
              agetIdZ = ((String)localObject1);
              i2++;
            }
            catch (Resources.NotFoundException localNotFoundException1)
            {
              Object localObject4;
              Object localObject6;
              Object localObject7;
              int i9;
              int i11;
              int i12;
              for (;;) {}
            }
          }
        }
        for (i2 = 0; i2 < i8; i2++)
        {
          localObject1 = a(getChildAt(i2));
          if (localObject1 != null) {
            ((d.g.a.h.d)localObject1).k();
          }
        }
        if (I != -1) {
          for (i2 = 0; i2 < i8; i2++)
          {
            localObject1 = getChildAt(i2);
            if ((((View)localObject1).getId() == I) && ((localObject1 instanceof d.g.b.d))) {
              H = ((d.g.b.d)localObject1).getConstraintSet();
            }
          }
        }
        localObject1 = H;
        if (localObject1 != null)
        {
          i2 = getChildCount();
          localObject3 = new HashSet(a.keySet());
          i5 = 0;
          while (i5 < i2)
          {
            localObject2 = getChildAt(i5);
            i4 = ((View)localObject2).getId();
            if (i4 != -1)
            {
              if (a.containsKey(Integer.valueOf(i4)))
              {
                ((HashSet)localObject3).remove(Integer.valueOf(i4));
                localObject4 = (c.a)a.get(Integer.valueOf(i4));
                if ((localObject2 instanceof a)) {
                  t0 = 1;
                }
                i6 = t0;
                if ((i6 != -1) && (i6 == 1))
                {
                  localObject6 = (a)localObject2;
                  ((View)localObject6).setId(i4);
                  ((a)localObject6).setType(s0);
                  ((a)localObject6).setAllowsGoneWidget(r0);
                  localObject7 = u0;
                  if (localObject7 != null)
                  {
                    ((b)localObject6).setReferencedIds((int[])localObject7);
                  }
                  else
                  {
                    localObject7 = v0;
                    if (localObject7 != null)
                    {
                      localObject7 = ((d.g.b.c)localObject1).a((View)localObject6, (String)localObject7);
                      u0 = ((int[])localObject7);
                      ((b)localObject6).setReferencedIds((int[])localObject7);
                    }
                  }
                }
                localObject6 = (a)((View)localObject2).getLayoutParams();
                ((c.a)localObject4).a((a)localObject6);
                ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((View)localObject2).setVisibility(J);
                ((View)localObject2).setAlpha(U);
                ((View)localObject2).setRotation(X);
                ((View)localObject2).setRotationX(Y);
                ((View)localObject2).setRotationY(Z);
                ((View)localObject2).setScaleX(a0);
                ((View)localObject2).setScaleY(b0);
                if (!Float.isNaN(c0)) {
                  ((View)localObject2).setPivotX(c0);
                }
                if (!Float.isNaN(d0)) {
                  ((View)localObject2).setPivotY(d0);
                }
                ((View)localObject2).setTranslationX(e0);
                ((View)localObject2).setTranslationY(f0);
                ((View)localObject2).setTranslationZ(g0);
                if (V) {
                  ((View)localObject2).setElevation(W);
                }
              }
              i5++;
            }
            else
            {
              throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
          }
          i5 = k;
          i6 = m;
          i4 = n;
          localObject3 = ((HashSet)localObject3).iterator();
          for (;;)
          {
            i2 = i4;
            k = i1;
            m = i6;
            n = i5;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (Integer)((Iterator)localObject3).next();
            localObject2 = (c.a)a.get(localObject4);
            n = t0;
            if ((n != -1) && (n == 1))
            {
              localObject6 = new a(getContext());
              ((View)localObject6).setId(((Integer)localObject4).intValue());
              localObject7 = u0;
              if (localObject7 != null)
              {
                ((b)localObject6).setReferencedIds((int[])localObject7);
              }
              else
              {
                localObject7 = v0;
                if (localObject7 != null)
                {
                  localObject7 = ((d.g.b.c)localObject1).a((View)localObject6, (String)localObject7);
                  u0 = ((int[])localObject7);
                  ((b)localObject6).setReferencedIds((int[])localObject7);
                }
              }
              ((a)localObject6).setType(s0);
              localObject7 = generateDefaultLayoutParams();
              ((b)localObject6).a();
              ((c.a)localObject2).a((a)localObject7);
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
            }
            if (a)
            {
              localObject6 = new d.g.b.e(getContext());
              ((View)localObject6).setId(((Integer)localObject4).intValue());
              localObject4 = generateDefaultLayoutParams();
              ((c.a)localObject2).a((a)localObject4);
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject4);
            }
          }
        }
        i2 = n;
        n = k;
        k = i1;
        A.k0.clear();
        i5 = y.size();
        if (i5 > 0) {
          for (i1 = 0; i1 < i5; i1++) {
            ((b)y.get(i1)).a(this);
          }
        }
        for (i1 = 0; i1 < i8; i1++)
        {
          localObject1 = getChildAt(i1);
          if ((localObject1 instanceof f))
          {
            localObject1 = (f)localObject1;
            if ((x == -1) && (!((View)localObject1).isInEditMode())) {
              ((View)localObject1).setVisibility(z);
            }
            localObject2 = findViewById(x);
            y = ((View)localObject2);
            if (localObject2 != null)
            {
              getLayoutParamsZ = true;
              y.setVisibility(0);
              ((View)localObject1).setVisibility(0);
            }
          }
        }
        i6 = 0;
        i5 = i8;
        while (i6 < i5)
        {
          localObject3 = getChildAt(i6);
          localObject2 = a((View)localObject3);
          if (localObject2 != null)
          {
            localObject1 = (a)((View)localObject3).getLayoutParams();
            ((a)localObject1).a();
            if (l0) {
              l0 = false;
            } else if (bool1) {
              try
              {
                localObject4 = getResources().getResourceName(((View)localObject3).getId());
                a(0, localObject4, Integer.valueOf(((View)localObject3).getId()));
                localObject4 = ((String)localObject4).substring(((String)localObject4).indexOf("id/") + 3);
                agetIdZ = ((String)localObject4);
              }
              catch (Resources.NotFoundException localNotFoundException2) {}
            }
            Y = ((View)localObject3).getVisibility();
            if (Z) {
              Y = 8;
            }
            X = localObject3;
            localObject5 = A;
            k0.add(localObject2);
            localObject3 = D;
            if (localObject3 != null)
            {
              k0.remove(localObject2);
              D = null;
            }
            D = ((d.g.a.h.d)localObject5);
            if ((!V) || (!U)) {
              z.add(localObject2);
            }
            if (X)
            {
              localObject2 = (g)localObject2;
              i4 = h0;
              i1 = i0;
              f1 = j0;
              boolean bool2 = f1 < -1.0F;
              if (bool2)
              {
                if (bool2)
                {
                  k0 = f1;
                  l0 = -1;
                  m0 = -1;
                }
              }
              else if (i4 != -1)
              {
                if (i4 > -1)
                {
                  k0 = -1.0F;
                  l0 = i4;
                  m0 = -1;
                }
              }
              else if ((i1 != -1) && (i1 > -1))
              {
                k0 = -1.0F;
                l0 = -1;
                m0 = i1;
              }
            }
            else
            {
              if ((d != -1) || (e != -1) || (f != -1) || (g != -1) || (q != -1) || (p != -1) || (r != -1) || (s != -1) || (h != -1) || (i != -1) || (j != -1) || (k != -1) || (l != -1) || (P != -1) || (Q != -1) || (m != -1) || (width == -1) || (height == -1)) {
                break label2205;
              }
            }
          }
          break label3613;
          label2205:
          i9 = a0;
          i1 = b0;
          i11 = c0;
          i12 = d0;
          int i13 = e0;
          i3 = f0;
          float f1 = g0;
          i4 = m;
          if (i4 != -1)
          {
            localObject3 = a(i4);
            if (localObject3 != null)
            {
              f1 = o;
              i1 = n;
              localObject5 = c.c.CENTER;
              ((d.g.a.h.d)localObject2).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, i1, 0);
              r = f1;
            }
          }
          else
          {
            if (i9 != -1)
            {
              localObject5 = a(i9);
              if (localObject5 != null)
              {
                localObject3 = c.c.LEFT;
                ((d.g.a.h.d)localObject2).a((c.c)localObject3, (d.g.a.h.d)localObject5, (c.c)localObject3, leftMargin, i13);
              }
            }
            for (;;)
            {
              break;
              if (i1 == -1) {
                break;
              }
              localObject3 = a(i1);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject2).a(c.c.LEFT, (d.g.a.h.d)localObject3, c.c.RIGHT, leftMargin, i13);
              }
            }
            if (i11 != -1)
            {
              localObject3 = a(i11);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject2).a(c.c.RIGHT, (d.g.a.h.d)localObject3, c.c.LEFT, rightMargin, i3);
              }
            }
            else if (i12 != -1)
            {
              localObject5 = a(i12);
              if (localObject5 != null)
              {
                localObject3 = c.c.RIGHT;
                ((d.g.a.h.d)localObject2).a((c.c)localObject3, (d.g.a.h.d)localObject5, (c.c)localObject3, rightMargin, i3);
              }
            }
            i1 = h;
            if (i1 != -1)
            {
              localObject3 = a(i1);
              if (localObject3 != null)
              {
                localObject5 = c.c.TOP;
                ((d.g.a.h.d)localObject2).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, topMargin, u);
              }
            }
            else
            {
              i1 = i;
              if (i1 != -1)
              {
                localObject3 = a(i1);
                if (localObject3 != null) {
                  ((d.g.a.h.d)localObject2).a(c.c.TOP, (d.g.a.h.d)localObject3, c.c.BOTTOM, topMargin, u);
                }
              }
            }
            i1 = j;
            if (i1 != -1)
            {
              localObject3 = a(i1);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject2).a(c.c.BOTTOM, (d.g.a.h.d)localObject3, c.c.TOP, bottomMargin, w);
              }
            }
            else
            {
              i1 = k;
              if (i1 != -1)
              {
                localObject3 = a(i1);
                if (localObject3 != null)
                {
                  localObject5 = c.c.BOTTOM;
                  ((d.g.a.h.d)localObject2).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, bottomMargin, w);
                }
              }
            }
            i1 = l;
            if (i1 != -1)
            {
              localObject5 = (View)x.get(i1);
              localObject3 = a(l);
              if ((localObject3 != null) && (localObject5 != null) && ((((View)localObject5).getLayoutParams() instanceof a)))
              {
                localObject5 = (a)((View)localObject5).getLayoutParams();
                W = true;
                W = true;
                ((d.g.a.h.d)localObject2).a(c.c.BASELINE).a(((d.g.a.h.d)localObject3).a(c.c.BASELINE), 0, -1, c.b.STRONG, 0, true);
                ((d.g.a.h.d)localObject2).a(c.c.TOP).c();
                ((d.g.a.h.d)localObject2).a(c.c.BOTTOM).c();
              }
            }
            if ((f1 >= 0.0F) && (f1 != 0.5F)) {
              V = f1;
            }
            f1 = A;
            if ((f1 >= 0.0F) && (f1 != 0.5F)) {
              W = f1;
            }
          }
          if ((bool1) && ((P != -1) || (Q != -1)))
          {
            i4 = P;
            i1 = Q;
            I = i4;
            J = i1;
          }
          if (!U)
          {
            if (width == -1)
            {
              ((d.g.a.h.d)localObject2).a(d.a.MATCH_PARENT);
              aLEFTe = leftMargin;
              aRIGHTe = rightMargin;
            }
            else
            {
              ((d.g.a.h.d)localObject2).a(d.a.MATCH_CONSTRAINT);
              ((d.g.a.h.d)localObject2).f(0);
            }
          }
          else
          {
            ((d.g.a.h.d)localObject2).a(d.a.FIXED);
            ((d.g.a.h.d)localObject2).f(width);
          }
          if (!V)
          {
            if (height == -1)
            {
              ((d.g.a.h.d)localObject2).b(d.a.MATCH_PARENT);
              aTOPe = topMargin;
              aBOTTOMe = bottomMargin;
            }
            else
            {
              ((d.g.a.h.d)localObject2).b(d.a.MATCH_CONSTRAINT);
              ((d.g.a.h.d)localObject2).e(0);
            }
          }
          else
          {
            ((d.g.a.h.d)localObject2).b(d.a.FIXED);
            ((d.g.a.h.d)localObject2).e(height);
          }
          Object localObject5 = B;
          if (localObject5 != null) {
            if (((String)localObject5).length() == 0)
            {
              G = 0.0F;
            }
            else
            {
              i9 = ((String)localObject5).length();
              i4 = ((String)localObject5).indexOf(',');
              if ((i4 > 0) && (i4 < i9 - 1))
              {
                localObject3 = ((String)localObject5).substring(0, i4);
                if (((String)localObject3).equalsIgnoreCase("W")) {
                  i1 = 0;
                } else if (((String)localObject3).equalsIgnoreCase("H")) {
                  i1 = 1;
                } else {
                  i1 = -1;
                }
                i4++;
              }
              else
              {
                i4 = 0;
                i1 = -1;
              }
              i3 = ((String)localObject5).indexOf(':');
              if ((i3 >= 0) && (i3 < i9 - 1))
              {
                localObject3 = ((String)localObject5).substring(i4, i3);
                localObject5 = ((String)localObject5).substring(i3 + 1);
                if ((((String)localObject3).length() <= 0) || (((String)localObject5).length() <= 0)) {
                  break label3392;
                }
              }
            }
          }
          try
          {
            f1 = Float.parseFloat((String)localObject3);
            float f2 = Float.parseFloat((String)localObject5);
            if ((f1 > 0.0F) && (f2 > 0.0F)) {
              if (i1 == 1)
              {
                f1 = Math.abs(f2 / f1);
              }
              else
              {
                f1 = Math.abs(f1 / f2);
                break label3389;
                localObject3 = ((String)localObject5).substring(i4);
                if (((String)localObject3).length() <= 0) {
                  break label3392;
                }
                f1 = Float.parseFloat((String)localObject3);
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label3389:
            label3392:
            for (;;) {}
          }
          f1 = 0.0F;
          if (f1 > 0.0F)
          {
            G = f1;
            H = i1;
          }
          f1 = D;
          localObject3 = g0;
          localObject3[0] = f1;
          localObject3[1] = E;
          e0 = F;
          f0 = G;
          i4 = H;
          i9 = J;
          i1 = L;
          f1 = N;
          e = i4;
          h = i9;
          i = i1;
          j = f1;
          if ((f1 < 1.0F) && (i4 == 0)) {
            e = 2;
          }
          i4 = I;
          i9 = K;
          i1 = M;
          f1 = O;
          f = i4;
          k = i9;
          l = i1;
          m = f1;
          if ((f1 < 1.0F) && (i4 == 0)) {
            f = 2;
          }
          label3613:
          i6++;
        }
        i5 = i;
        i1 = j;
        i = k;
        j = m;
        k = n;
        m = i5;
      }
      else
      {
        i2 = m;
        i5 = i1;
        m = i;
        i1 = j;
        j = i2;
        i = i5;
        i2 = n;
      }
      i6 = 1;
      i5 = i2;
      n = j;
    }
    else
    {
      i2 = j;
      j = m;
      i5 = n;
      i6 = i1;
      i4 = 0;
      m = i;
      i1 = i2;
      n = j;
      i = i6;
      i6 = i4;
    }
    if ((G & 0x8) == 8) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0)
    {
      localObject1 = A;
      ((d.g.a.h.e)localObject1).p();
      ((d.g.a.h.e)localObject1).a(C0);
      localObject1 = A;
      if (C[0] != d.a.WRAP_CONTENT)
      {
        localObject2 = c;
        if (localObject2 != null) {
          ((k)localObject2).a(i7);
        }
      }
      if (C[1] != d.a.WRAP_CONTENT)
      {
        localObject1 = d;
        if (localObject1 != null) {
          ((k)localObject1).a(i10);
        }
      }
      b(paramInt1, paramInt2);
    }
    else
    {
      a(paramInt1, paramInt2);
    }
    i4 = getChildCount();
    for (j = 0; j < i4; j++)
    {
      localObject1 = getChildAt(j);
      if ((localObject1 instanceof f))
      {
        localObject2 = (f)localObject1;
        if (y != null)
        {
          localObject1 = (a)((View)localObject2).getLayoutParams();
          localObject2 = (a)y.getLayoutParams();
          localObject3 = k0;
          Y = 0;
          k0.f(((d.g.a.h.d)localObject3).i());
          k0.e(k0.d());
          k0.Y = 8;
        }
      }
    }
    i4 = y.size();
    if (i4 > 0)
    {
      j = 0;
      while (j < i4) {
        if ((b)y.get(j) != null) {
          j++;
        } else {
          throw null;
        }
      }
    }
    if ((getChildCount() > 0) && (i6 != 0)) {
      s.a(A);
    }
    localObject1 = A;
    if (x0)
    {
      if (y0) {
        if (m == Integer.MIN_VALUE)
        {
          j = A0;
          if (j < i1) {
            ((d.g.a.h.d)localObject1).f(j);
          }
          A.a(d.a.FIXED);
        }
        else {}
      }
      localObject1 = A;
      if (z0)
      {
        if (k == Integer.MIN_VALUE)
        {
          j = B0;
          if (j < n) {
            ((d.g.a.h.d)localObject1).e(j);
          }
          A.b(d.a.FIXED);
        }
      }
      else {}
    }
    if ((G & 0x20) == 32)
    {
      i6 = A.i();
      j = A.d();
      if ((K != i6) && (m == 1073741824)) {
        s.a(A.w0, 0, i6);
      }
      if ((L != j) && (k == 1073741824)) {
        s.a(A.w0, 1, j);
      }
      localObject1 = A;
      if ((y0) && (A0 > i1)) {
        s.a(w0, 0, i1);
      }
      localObject1 = A;
      if ((z0) && (B0 > n)) {
        s.a(w0, 1, n);
      }
    }
    if (getChildCount() > 0) {
      A.o();
    }
    i6 = z.size();
    i12 = getPaddingBottom() + i;
    k = getPaddingRight() + i5;
    if (i6 > 0)
    {
      if (A.e() == d.a.WRAP_CONTENT) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if (A.h() == d.a.WRAP_CONTENT) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      n = Math.max(A.i(), B);
      i1 = Math.max(A.d(), C);
      i9 = 0;
      j = 0;
      m = 0;
      while (i9 < i6)
      {
        localObject2 = (d.g.a.h.d)z.get(i9);
        localObject1 = (View)X;
        if (localObject1 != null)
        {
          localObject3 = (a)((View)localObject1).getLayoutParams();
          if ((!Y) && (!X) && ((((View)localObject1).getVisibility() == 8) || ((i2 == 0) || (!((d.g.a.h.d)localObject2).g().c()) || (!((d.g.a.h.d)localObject2).f().c()))))
          {
            i = width;
            if ((i == -2) && (U)) {
              i = ViewGroup.getChildMeasureSpec(paramInt1, k, i);
            } else {
              i = View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject2).i(), 1073741824);
            }
            i3 = height;
            if ((i3 == -2) && (V)) {
              i3 = ViewGroup.getChildMeasureSpec(paramInt2, i12, i3);
            } else {
              i3 = View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject2).d(), 1073741824);
            }
            ((View)localObject1).measure(i, i3);
            i11 = ((View)localObject1).getMeasuredWidth();
            i3 = ((View)localObject1).getMeasuredHeight();
            i = n;
            if (i11 != ((d.g.a.h.d)localObject2).i())
            {
              ((d.g.a.h.d)localObject2).f(i11);
              if (i2 != 0) {
                ((d.g.a.h.d)localObject2).g().a(i11);
              }
              i = n;
              if (i5 != 0)
              {
                j = I + E;
                i = n;
                if (j > n) {
                  i = Math.max(n, ((d.g.a.h.d)localObject2).a(c.c.RIGHT).a() + j);
                }
              }
              j = 1;
            }
            n = i1;
            if (i3 != ((d.g.a.h.d)localObject2).d())
            {
              ((d.g.a.h.d)localObject2).e(i3);
              if (i2 != 0) {
                ((d.g.a.h.d)localObject2).f().a(i3);
              }
              n = i1;
              if (i4 != 0)
              {
                n = i1;
                if (J + F > i1)
                {
                  n = ((d.g.a.h.d)localObject2).c();
                  n = Math.max(i1, ((d.g.a.h.d)localObject2).a(c.c.BOTTOM).a() + n);
                }
              }
              j = 1;
            }
            if (W)
            {
              i3 = ((View)localObject1).getBaseline();
              i1 = j;
              if (i3 != -1)
              {
                i1 = j;
                if (i3 != Q)
                {
                  Q = i3;
                  i1 = 1;
                }
              }
            }
            else
            {
              i1 = j;
            }
            m = ViewGroup.combineMeasuredStates(m, ((View)localObject1).getMeasuredState());
            i3 = n;
            j = i1;
            break label4973;
          }
        }
        i3 = i1;
        i = n;
        label4973:
        i9++;
        n = i;
        i1 = i3;
      }
      if (j != 0)
      {
        A.f(i7);
        A.e(i10);
        if (i2 != 0) {
          A.r();
        }
        A.o();
        if (A.i() < n)
        {
          A.f(n);
          n = 1;
        }
        else
        {
          n = 0;
        }
        if (A.d() < i1)
        {
          A.e(i1);
          n = 1;
        }
        if (n != 0) {
          A.o();
        }
      }
      for (i1 = 0; i1 < i6; i1++)
      {
        localObject2 = (d.g.a.h.d)z.get(i1);
        localObject1 = (View)X;
        if ((localObject1 == null) || ((((View)localObject1).getMeasuredWidth() == ((d.g.a.h.d)localObject2).i()) && (((View)localObject1).getMeasuredHeight() == ((d.g.a.h.d)localObject2).d()))) {}
        for (;;)
        {
          break;
          if (Y != 8) {
            ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject2).i(), 1073741824), View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject2).d(), 1073741824));
          }
        }
      }
      i1 = m;
    }
    else
    {
      i1 = 0;
    }
    m = A.i();
    n = A.d();
    paramInt1 = ViewGroup.resolveSizeAndState(m + k, paramInt1, i1);
    i1 = ViewGroup.resolveSizeAndState(n + i12, paramInt2, i1 << 16);
    paramInt2 = Math.min(D, paramInt1 & 0xFFFFFF);
    i1 = Math.min(E, i1 & 0xFFFFFF);
    paramInt1 = paramInt2;
    if (A.E0) {
      paramInt1 = paramInt2 | 0x1000000;
    }
    paramInt2 = i1;
    if (A.F0) {
      paramInt2 = i1 | 0x1000000;
    }
    setMeasuredDimension(paramInt1, paramInt2);
    K = paramInt1;
    L = paramInt2;
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    Object localObject = a(paramView);
    if (((paramView instanceof d.g.b.e)) && (!(localObject instanceof g)))
    {
      localObject = (a)paramView.getLayoutParams();
      g localg = new g();
      k0 = localg;
      X = true;
      ((g)localg).g(R);
    }
    if ((paramView instanceof b))
    {
      localObject = (b)paramView;
      ((b)localObject).a();
      getLayoutParamsY = true;
      if (!y.contains(localObject)) {
        y.add(localObject);
      }
    }
    x.put(paramView.getId(), paramView);
    F = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    x.remove(paramView.getId());
    d.g.a.h.d locald = a(paramView);
    A.k0.remove(locald);
    D = null;
    y.remove(paramView);
    z.remove(locald);
    F = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    F = true;
    K = -1;
    L = -1;
  }
  
  public void setConstraintSet(d.g.b.c paramc)
  {
    H = paramc;
  }
  
  public void setId(int paramInt)
  {
    x.remove(getId());
    super.setId(paramInt);
    x.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == E) {
      return;
    }
    E = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == D) {
      return;
    }
    D = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == C) {
      return;
    }
    C = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == B) {
      return;
    }
    B = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    A.C0 = paramInt;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class a
    extends ViewGroup.MarginLayoutParams
  {
    public float A = 0.5F;
    public String B = null;
    public int C = 1;
    public float D = -1.0F;
    public float E = -1.0F;
    public int F = 0;
    public int G = 0;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public float N = 1.0F;
    public float O = 1.0F;
    public int P = -1;
    public int Q = -1;
    public int R = -1;
    public boolean S = false;
    public boolean T = false;
    public boolean U = true;
    public boolean V = true;
    public boolean W = false;
    public boolean X = false;
    public boolean Y = false;
    public boolean Z = false;
    public int a = -1;
    public int a0 = -1;
    public int b = -1;
    public int b0 = -1;
    public float c = -1.0F;
    public int c0 = -1;
    public int d = -1;
    public int d0 = -1;
    public int e = -1;
    public int e0 = -1;
    public int f = -1;
    public int f0 = -1;
    public int g = -1;
    public float g0 = 0.5F;
    public int h = -1;
    public int h0;
    public int i = -1;
    public int i0;
    public int j = -1;
    public float j0;
    public int k = -1;
    public d.g.a.h.d k0 = new d.g.a.h.d();
    public int l = -1;
    public boolean l0 = false;
    public int m = -1;
    public int n = 0;
    public float o = 0.0F;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;
    public int v = -1;
    public int w = -1;
    public int x = -1;
    public int y = -1;
    public float z = 0.5F;
    
    public a(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i1 = paramContext.getIndexCount();
      for (int i2 = 0; i2 < i1; i2++)
      {
        int i3 = paramContext.getIndex(i2);
        int i4 = a.a.get(i3);
        String str;
        switch (i4)
        {
        default: 
          switch (i4)
          {
          default: 
            break;
          case 50: 
            Q = paramContext.getDimensionPixelOffset(i3, Q);
            break;
          case 49: 
            P = paramContext.getDimensionPixelOffset(i3, P);
            break;
          case 48: 
            G = paramContext.getInt(i3, 0);
            break;
          case 47: 
            F = paramContext.getInt(i3, 0);
            break;
          case 46: 
            E = paramContext.getFloat(i3, E);
            break;
          case 45: 
            D = paramContext.getFloat(i3, D);
            break;
          case 44: 
            paramAttributeSet = paramContext.getString(i3);
            B = paramAttributeSet;
            C = -1;
            if (paramAttributeSet != null)
            {
              i4 = paramAttributeSet.length();
              i3 = B.indexOf(',');
              if ((i3 > 0) && (i3 < i4 - 1))
              {
                paramAttributeSet = B.substring(0, i3);
                if (paramAttributeSet.equalsIgnoreCase("W")) {
                  C = 0;
                } else if (paramAttributeSet.equalsIgnoreCase("H")) {
                  C = 1;
                }
                i3++;
              }
              else
              {
                i3 = 0;
              }
              int i5 = B.indexOf(':');
              if ((i5 >= 0) && (i5 < i4 - 1))
              {
                paramAttributeSet = B.substring(i3, i5);
                str = B.substring(i5 + 1);
                if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
                  continue;
                }
              }
            }
            break;
          }
          break;
        }
        try
        {
          f1 = Float.parseFloat(paramAttributeSet);
          float f2 = Float.parseFloat(str);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            continue;
          }
          if (C == 1) {
            Math.abs(f2 / f1);
          } else {
            Math.abs(f1 / f2);
          }
        }
        catch (NumberFormatException paramAttributeSet)
        {
          float f1;
          continue;
        }
        paramAttributeSet = B.substring(i3);
        if (paramAttributeSet.length() > 0)
        {
          Float.parseFloat(paramAttributeSet);
          continue;
          O = Math.max(0.0F, paramContext.getFloat(i3, O));
          continue;
          try
          {
            M = paramContext.getDimensionPixelSize(i3, M);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(i3, M) != -2) {
              continue;
            }
          }
          M = -2;
          continue;
          try
          {
            K = paramContext.getDimensionPixelSize(i3, K);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(i3, K) != -2) {
              continue;
            }
          }
          K = -2;
          continue;
          N = Math.max(0.0F, paramContext.getFloat(i3, N));
          continue;
          try
          {
            L = paramContext.getDimensionPixelSize(i3, L);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(i3, L) != -2) {
              continue;
            }
          }
          L = -2;
          continue;
          try
          {
            J = paramContext.getDimensionPixelSize(i3, J);
          }
          catch (Exception paramAttributeSet)
          {
            if (paramContext.getInt(i3, J) != -2) {
              continue;
            }
          }
          J = -2;
          continue;
          i3 = paramContext.getInt(i3, 0);
          I = i3;
          if (i3 == 1)
          {
            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            continue;
            i3 = paramContext.getInt(i3, 0);
            H = i3;
            if (i3 == 1)
            {
              Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
              continue;
              A = paramContext.getFloat(i3, A);
              continue;
              z = paramContext.getFloat(i3, z);
              continue;
              T = paramContext.getBoolean(i3, T);
              continue;
              S = paramContext.getBoolean(i3, S);
              continue;
              y = paramContext.getDimensionPixelSize(i3, y);
              continue;
              x = paramContext.getDimensionPixelSize(i3, x);
              continue;
              w = paramContext.getDimensionPixelSize(i3, w);
              continue;
              v = paramContext.getDimensionPixelSize(i3, v);
              continue;
              u = paramContext.getDimensionPixelSize(i3, u);
              continue;
              t = paramContext.getDimensionPixelSize(i3, t);
              continue;
              i4 = paramContext.getResourceId(i3, s);
              s = i4;
              if (i4 == -1)
              {
                s = paramContext.getInt(i3, -1);
                continue;
                i4 = paramContext.getResourceId(i3, r);
                r = i4;
                if (i4 == -1)
                {
                  r = paramContext.getInt(i3, -1);
                  continue;
                  i4 = paramContext.getResourceId(i3, q);
                  q = i4;
                  if (i4 == -1)
                  {
                    q = paramContext.getInt(i3, -1);
                    continue;
                    i4 = paramContext.getResourceId(i3, p);
                    p = i4;
                    if (i4 == -1)
                    {
                      p = paramContext.getInt(i3, -1);
                      continue;
                      i4 = paramContext.getResourceId(i3, l);
                      l = i4;
                      if (i4 == -1)
                      {
                        l = paramContext.getInt(i3, -1);
                        continue;
                        i4 = paramContext.getResourceId(i3, k);
                        k = i4;
                        if (i4 == -1)
                        {
                          k = paramContext.getInt(i3, -1);
                          continue;
                          i4 = paramContext.getResourceId(i3, j);
                          j = i4;
                          if (i4 == -1)
                          {
                            j = paramContext.getInt(i3, -1);
                            continue;
                            i4 = paramContext.getResourceId(i3, i);
                            i = i4;
                            if (i4 == -1)
                            {
                              i = paramContext.getInt(i3, -1);
                              continue;
                              i4 = paramContext.getResourceId(i3, h);
                              h = i4;
                              if (i4 == -1)
                              {
                                h = paramContext.getInt(i3, -1);
                                continue;
                                i4 = paramContext.getResourceId(i3, g);
                                g = i4;
                                if (i4 == -1)
                                {
                                  g = paramContext.getInt(i3, -1);
                                  continue;
                                  i4 = paramContext.getResourceId(i3, f);
                                  f = i4;
                                  if (i4 == -1)
                                  {
                                    f = paramContext.getInt(i3, -1);
                                    continue;
                                    i4 = paramContext.getResourceId(i3, e);
                                    e = i4;
                                    if (i4 == -1)
                                    {
                                      e = paramContext.getInt(i3, -1);
                                      continue;
                                      i4 = paramContext.getResourceId(i3, d);
                                      d = i4;
                                      if (i4 == -1)
                                      {
                                        d = paramContext.getInt(i3, -1);
                                        continue;
                                        c = paramContext.getFloat(i3, c);
                                        continue;
                                        b = paramContext.getDimensionPixelOffset(i3, b);
                                        continue;
                                        a = paramContext.getDimensionPixelOffset(i3, a);
                                        continue;
                                        f1 = paramContext.getFloat(i3, o) % 360.0F;
                                        o = f1;
                                        if (f1 < 0.0F)
                                        {
                                          o = ((360.0F - f1) % 360.0F);
                                          continue;
                                          n = paramContext.getDimensionPixelSize(i3, n);
                                          continue;
                                          i4 = paramContext.getResourceId(i3, m);
                                          m = i4;
                                          if (i4 == -1)
                                          {
                                            m = paramContext.getInt(i3, -1);
                                            continue;
                                            R = paramContext.getInt(i3, R);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      paramContext.recycle();
      a();
    }
    
    public a(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void a()
    {
      X = false;
      U = true;
      V = true;
      if ((width == -2) && (S))
      {
        U = false;
        H = 1;
      }
      if ((height == -2) && (T))
      {
        V = false;
        I = 1;
      }
      int i1 = width;
      if ((i1 == 0) || (i1 == -1))
      {
        U = false;
        if ((width == 0) && (H == 1))
        {
          width = -2;
          S = true;
        }
      }
      i1 = height;
      if ((i1 == 0) || (i1 == -1))
      {
        V = false;
        if ((height == 0) && (I == 1))
        {
          height = -2;
          T = true;
        }
      }
      if ((c != -1.0F) || (a != -1) || (b != -1))
      {
        X = true;
        U = true;
        V = true;
        if (!(k0 instanceof g)) {
          k0 = new g();
        }
        ((g)k0).g(R);
      }
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i1 = leftMargin;
      int i2 = rightMargin;
      super.resolveLayoutDirection(paramInt);
      c0 = -1;
      d0 = -1;
      a0 = -1;
      b0 = -1;
      e0 = -1;
      f0 = -1;
      e0 = t;
      f0 = v;
      g0 = z;
      h0 = a;
      i0 = b;
      j0 = c;
      paramInt = getLayoutDirection();
      int i3 = 0;
      if (1 == paramInt) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        paramInt = p;
        if (paramInt != -1) {
          c0 = paramInt;
        }
        for (;;)
        {
          paramInt = 1;
          break;
          int i4 = q;
          paramInt = i3;
          if (i4 == -1) {
            break;
          }
          d0 = i4;
        }
        i3 = r;
        if (i3 != -1)
        {
          b0 = i3;
          paramInt = 1;
        }
        i3 = s;
        if (i3 != -1)
        {
          a0 = i3;
          paramInt = 1;
        }
        i3 = x;
        if (i3 != -1) {
          f0 = i3;
        }
        i3 = y;
        if (i3 != -1) {
          e0 = i3;
        }
        if (paramInt != 0) {
          g0 = (1.0F - z);
        }
        if ((X) && (R == 1))
        {
          float f1 = c;
          if (f1 != -1.0F)
          {
            j0 = (1.0F - f1);
            h0 = -1;
            i0 = -1;
          }
          else
          {
            paramInt = a;
            if (paramInt != -1)
            {
              i0 = paramInt;
              h0 = -1;
              j0 = -1.0F;
            }
            else
            {
              paramInt = b;
              if (paramInt != -1)
              {
                h0 = paramInt;
                i0 = -1;
                j0 = -1.0F;
              }
            }
          }
        }
      }
      else
      {
        paramInt = p;
        if (paramInt != -1) {
          b0 = paramInt;
        }
        paramInt = q;
        if (paramInt != -1) {
          a0 = paramInt;
        }
        paramInt = r;
        if (paramInt != -1) {
          c0 = paramInt;
        }
        paramInt = s;
        if (paramInt != -1) {
          d0 = paramInt;
        }
        paramInt = x;
        if (paramInt != -1) {
          e0 = paramInt;
        }
        paramInt = y;
        if (paramInt != -1) {
          f0 = paramInt;
        }
      }
      if ((r == -1) && (s == -1) && (q == -1) && (p == -1))
      {
        paramInt = f;
        if (paramInt != -1)
        {
          c0 = paramInt;
          if ((rightMargin <= 0) && (i2 > 0)) {
            rightMargin = i2;
          }
        }
        else
        {
          paramInt = g;
          if (paramInt != -1)
          {
            d0 = paramInt;
            if ((rightMargin <= 0) && (i2 > 0)) {
              rightMargin = i2;
            }
          }
        }
        paramInt = d;
        if (paramInt != -1)
        {
          a0 = paramInt;
          if ((leftMargin <= 0) && (i1 > 0)) {
            leftMargin = i1;
          }
        }
        else
        {
          paramInt = e;
          if (paramInt != -1)
          {
            b0 = paramInt;
            if ((leftMargin <= 0) && (i1 > 0)) {
              leftMargin = i1;
            }
          }
        }
      }
    }
    
    public static class a
    {
      public static final SparseIntArray a;
      
      static
      {
        SparseIntArray localSparseIntArray = new SparseIntArray();
        a = localSparseIntArray;
        localSparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */