package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.b.a.r;
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
        ConstraintLayout.a locala = (ConstraintLayout.a)localView.getLayoutParams();
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
          int i5;
          if (i != 0)
          {
            if (i1 == 0)
            {
              i5 = ViewGroup.getChildMeasureSpec(paramInt1, k, -2);
              i = 1;
            }
            else if (i1 == -1)
            {
              i5 = ViewGroup.getChildMeasureSpec(paramInt1, k, -1);
              i = 0;
            }
            else
            {
              if (i1 == -2) {
                i = 1;
              } else {
                i = 0;
              }
              i5 = ViewGroup.getChildMeasureSpec(paramInt1, k, i1);
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
            localView.measure(i5, i2);
            i2 = localView.getMeasuredWidth();
            i5 = localView.getMeasuredHeight();
          }
          else
          {
            i4 = 0;
            i = 0;
            i5 = i2;
            i2 = i1;
          }
          locald.f(i2);
          locald.e(i5);
          if (i != 0) {
            T = i2;
          }
          if (i4 != 0) {
            U = i5;
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
        localObject2 = (ConstraintLayout.a)((View)localObject1).getLayoutParams();
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
      localObject3 = localConstraintLayout.getChildAt(i4);
      if (((View)localObject3).getVisibility() != 8)
      {
        localObject1 = (ConstraintLayout.a)((View)localObject3).getLayoutParams();
        localObject2 = k0;
        if ((!X) && (!Y))
        {
          Y = ((View)localObject3).getVisibility();
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
                ((d.g.a.h.d)localObject2).g().b();
              }
              if (i == 0) {
                ((d.g.a.h.d)localObject2).f().b();
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
                    ((d.g.a.h.d)localObject2).g().a(i2);
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
                    ((d.g.a.h.d)localObject2).f().a(i1);
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
              ((View)localObject3).measure(n, i1);
              i1 = ((View)localObject3).getMeasuredWidth();
              n = ((View)localObject3).getMeasuredHeight();
              ((d.g.a.h.d)localObject2).f(i1);
              ((d.g.a.h.d)localObject2).e(n);
              if (i2 != 0) {
                T = i1;
              }
              if (i3 != 0) {
                U = n;
              }
              if (i6 != 0) {
                ((d.g.a.h.d)localObject2).g().a(i1);
              } else {
                gb = 2;
              }
              if (i != 0) {
                ((d.g.a.h.d)localObject2).f().a(n);
              } else {
                fb = 2;
              }
              if (W)
              {
                i = ((View)localObject3).getBaseline();
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
    return paramLayoutParams instanceof ConstraintLayout.a;
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
  
  public ConstraintLayout.a generateDefaultLayoutParams()
  {
    return new ConstraintLayout.a(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ConstraintLayout.a(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ConstraintLayout.a(paramLayoutParams);
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
      ConstraintLayout.a locala = (ConstraintLayout.a)localView.getLayoutParams();
      d.g.a.h.d locald = k0;
      if (((localView.getVisibility() != 8) || (X) || (Y) || (paramBoolean)) && (!Z))
      {
        int i = M + O;
        paramInt4 = N + P;
        int j = locald.i() + i;
        int k = locald.d() + paramInt4;
        localView.layout(i, paramInt4, j, k);
        if ((localView instanceof f))
        {
          localView = ((f)localView).getContent();
          if (localView != null)
          {
            localView.setVisibility(0);
            localView.layout(i, paramInt4, j, k);
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
    int i3 = D;
    Object localObject2 = q;
    localObject2[0] = i3;
    localObject2[1] = E;
    boolean bool2;
    if (getLayoutDirection() == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    l0 = bool2;
    int i4 = View.MeasureSpec.getMode(paramInt1);
    i3 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt2);
    int i7 = getPaddingTop();
    int i8 = getPaddingBottom();
    int i9 = getPaddingLeft();
    int i10 = getPaddingRight();
    localObject2 = d.a.FIXED;
    getLayoutParams();
    if (i4 != Integer.MIN_VALUE)
    {
      if (i4 != 0)
      {
        if (i4 != 1073741824)
        {
          localObject1 = localObject2;
        }
        else
        {
          i3 = Math.min(D, i3) - (i10 + i9);
          localObject1 = localObject2;
          break label236;
        }
      }
      else {
        localObject1 = d.a.WRAP_CONTENT;
      }
      i3 = 0;
    }
    else
    {
      localObject1 = d.a.WRAP_CONTENT;
    }
    label236:
    if (i5 != Integer.MIN_VALUE)
    {
      if (i5 != 0)
      {
        if (i5 == 1073741824)
        {
          i6 = Math.min(E, i6) - (i8 + i7);
          break label296;
        }
      }
      else {
        localObject2 = d.a.WRAP_CONTENT;
      }
      i6 = 0;
    }
    else
    {
      localObject2 = d.a.WRAP_CONTENT;
    }
    label296:
    Object localObject3 = A;
    R = 0;
    S = 0;
    ((d.g.a.h.d)localObject3).a((d.a)localObject1);
    A.f(i3);
    A.b((d.a)localObject2);
    A.e(i6);
    localObject2 = A;
    i3 = B - getPaddingLeft() - getPaddingRight();
    if (i3 < 0) {
      R = 0;
    } else {
      R = i3;
    }
    localObject2 = A;
    i3 = C - getPaddingTop() - getPaddingBottom();
    if (i3 < 0) {
      S = 0;
    } else {
      S = i3;
    }
    i7 = A.i();
    i10 = A.d();
    if (F)
    {
      F = false;
      i6 = getChildCount();
      for (i3 = 0; i3 < i6; i3++) {
        if (getChildAt(i3).isLayoutRequested())
        {
          i3 = 1;
          break label507;
        }
      }
      i3 = 0;
      label507:
      if (i3 != 0)
      {
        z.clear();
        bool2 = isInEditMode();
        i9 = getChildCount();
        if (bool2)
        {
          i3 = 0;
          while (i3 < i9)
          {
            localObject3 = getChildAt(i3);
            try
            {
              localObject1 = getResources().getResourceName(((View)localObject3).getId());
              a(0, localObject1, Integer.valueOf(((View)localObject3).getId()));
              i6 = ((String)localObject1).indexOf('/');
              localObject2 = localObject1;
              if (i6 != -1) {
                localObject2 = ((String)localObject1).substring(i6 + 1);
              }
              agetIdZ = ((String)localObject2);
              i3++;
            }
            catch (Resources.NotFoundException localNotFoundException1)
            {
              Object localObject4;
              Object localObject6;
              Object localObject7;
              int i11;
              int i2;
              int i13;
              for (;;) {}
            }
          }
        }
        for (i3 = 0; i3 < i9; i3++)
        {
          localObject2 = a(getChildAt(i3));
          if (localObject2 != null) {
            ((d.g.a.h.d)localObject2).k();
          }
        }
        if (I != -1) {
          for (i3 = 0; i3 < i9; i3++)
          {
            localObject2 = getChildAt(i3);
            if ((((View)localObject2).getId() == I) && ((localObject2 instanceof d.g.b.d))) {
              H = ((d.g.b.d)localObject2).getConstraintSet();
            }
          }
        }
        localObject2 = H;
        if (localObject2 != null)
        {
          i3 = getChildCount();
          localObject4 = new HashSet(a.keySet());
          i6 = 0;
          while (i6 < i3)
          {
            localObject3 = getChildAt(i6);
            i8 = ((View)localObject3).getId();
            if (i8 != -1)
            {
              if (a.containsKey(Integer.valueOf(i8)))
              {
                ((HashSet)localObject4).remove(Integer.valueOf(i8));
                localObject1 = (c.a)a.get(Integer.valueOf(i8));
                if ((localObject3 instanceof a)) {
                  t0 = 1;
                }
                i5 = t0;
                if ((i5 != -1) && (i5 == 1))
                {
                  localObject6 = (a)localObject3;
                  ((View)localObject6).setId(i8);
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
                      localObject7 = ((d.g.b.c)localObject2).a((View)localObject6, (String)localObject7);
                      u0 = ((int[])localObject7);
                      ((b)localObject6).setReferencedIds((int[])localObject7);
                    }
                  }
                }
                localObject6 = (ConstraintLayout.a)((View)localObject3).getLayoutParams();
                ((c.a)localObject1).a((ConstraintLayout.a)localObject6);
                ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((View)localObject3).setVisibility(J);
                ((View)localObject3).setAlpha(U);
                ((View)localObject3).setRotation(X);
                ((View)localObject3).setRotationX(Y);
                ((View)localObject3).setRotationY(Z);
                ((View)localObject3).setScaleX(a0);
                ((View)localObject3).setScaleY(b0);
                if (!Float.isNaN(c0)) {
                  ((View)localObject3).setPivotX(c0);
                }
                if (!Float.isNaN(d0)) {
                  ((View)localObject3).setPivotY(d0);
                }
                ((View)localObject3).setTranslationX(e0);
                ((View)localObject3).setTranslationY(f0);
                ((View)localObject3).setTranslationZ(g0);
                if (V) {
                  ((View)localObject3).setElevation(W);
                }
              }
              i6++;
            }
            else
            {
              throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
          }
          i6 = k;
          i5 = m;
          i8 = n;
          localObject3 = ((HashSet)localObject4).iterator();
          for (;;)
          {
            i3 = i8;
            k = i1;
            m = i5;
            n = i6;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (Integer)((Iterator)localObject3).next();
            localObject1 = (c.a)a.get(localObject4);
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
                  localObject7 = ((d.g.b.c)localObject2).a((View)localObject6, (String)localObject7);
                  u0 = ((int[])localObject7);
                  ((b)localObject6).setReferencedIds((int[])localObject7);
                }
              }
              ((a)localObject6).setType(s0);
              localObject7 = generateDefaultLayoutParams();
              ((b)localObject6).a();
              ((c.a)localObject1).a((ConstraintLayout.a)localObject7);
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject7);
            }
            if (a)
            {
              localObject6 = new d.g.b.e(getContext());
              ((View)localObject6).setId(((Integer)localObject4).intValue());
              localObject4 = generateDefaultLayoutParams();
              ((c.a)localObject1).a((ConstraintLayout.a)localObject4);
              addView((View)localObject6, (ViewGroup.LayoutParams)localObject4);
            }
          }
        }
        i3 = n;
        n = k;
        k = i1;
        A.k0.clear();
        i6 = y.size();
        if (i6 > 0) {
          for (i1 = 0; i1 < i6; i1++) {
            ((b)y.get(i1)).a(this);
          }
        }
        for (i1 = 0; i1 < i9; i1++)
        {
          localObject2 = getChildAt(i1);
          if ((localObject2 instanceof f))
          {
            localObject2 = (f)localObject2;
            if ((x == -1) && (!((View)localObject2).isInEditMode())) {
              ((View)localObject2).setVisibility(z);
            }
            localObject1 = findViewById(x);
            y = ((View)localObject1);
            if (localObject1 != null)
            {
              getLayoutParamsZ = true;
              y.setVisibility(0);
              ((View)localObject2).setVisibility(0);
            }
          }
        }
        i5 = 0;
        i6 = i9;
        while (i5 < i6)
        {
          localObject3 = getChildAt(i5);
          localObject1 = a((View)localObject3);
          if (localObject1 != null)
          {
            localObject2 = (ConstraintLayout.a)((View)localObject3).getLayoutParams();
            ((ConstraintLayout.a)localObject2).a();
            if (l0) {
              l0 = false;
            } else if (bool2) {
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
            k0.add(localObject1);
            localObject3 = D;
            if (localObject3 != null)
            {
              k0.remove(localObject1);
              D = null;
            }
            D = ((d.g.a.h.d)localObject5);
            if ((!V) || (!U)) {
              z.add(localObject1);
            }
            if (X)
            {
              localObject1 = (g)localObject1;
              i8 = h0;
              i9 = i0;
              f1 = j0;
              boolean bool1 = f1 < -1.0F;
              if (bool1)
              {
                if (bool1)
                {
                  k0 = f1;
                  l0 = -1;
                  m0 = -1;
                }
              }
              else if (i8 != -1)
              {
                if (i8 > -1)
                {
                  k0 = -1.0F;
                  l0 = i8;
                  m0 = -1;
                }
              }
              else if ((i9 != -1) && (i9 > -1))
              {
                k0 = -1.0F;
                l0 = -1;
                m0 = i9;
              }
            }
            else
            {
              if ((d != -1) || (e != -1) || (f != -1) || (g != -1) || (q != -1) || (p != -1) || (r != -1) || (s != -1) || (h != -1) || (i != -1) || (j != -1) || (k != -1) || (l != -1) || (P != -1) || (Q != -1) || (m != -1) || (width == -1) || (height == -1)) {
                break label2205;
              }
            }
          }
          break label3624;
          label2205:
          i8 = a0;
          i4 = b0;
          i11 = c0;
          i2 = d0;
          i9 = e0;
          int i12 = f0;
          float f1 = g0;
          i13 = m;
          if (i13 != -1)
          {
            localObject3 = a(i13);
            if (localObject3 != null)
            {
              f1 = o;
              i2 = n;
              localObject5 = c.c.CENTER;
              ((d.g.a.h.d)localObject1).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, i2, 0);
              r = f1;
            }
          }
          else
          {
            if (i8 != -1)
            {
              localObject5 = a(i8);
              if (localObject5 != null)
              {
                localObject3 = c.c.LEFT;
                ((d.g.a.h.d)localObject1).a((c.c)localObject3, (d.g.a.h.d)localObject5, (c.c)localObject3, leftMargin, i9);
              }
            }
            for (;;)
            {
              break;
              if (i4 == -1) {
                break;
              }
              localObject3 = a(i4);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject1).a(c.c.LEFT, (d.g.a.h.d)localObject3, c.c.RIGHT, leftMargin, i9);
              }
            }
            if (i11 != -1)
            {
              localObject3 = a(i11);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject1).a(c.c.RIGHT, (d.g.a.h.d)localObject3, c.c.LEFT, rightMargin, i12);
              }
            }
            else if (i2 != -1)
            {
              localObject3 = a(i2);
              if (localObject3 != null)
              {
                localObject5 = c.c.RIGHT;
                ((d.g.a.h.d)localObject1).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, rightMargin, i12);
              }
            }
            i2 = h;
            if (i2 != -1)
            {
              localObject3 = a(i2);
              if (localObject3 != null)
              {
                localObject5 = c.c.TOP;
                ((d.g.a.h.d)localObject1).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, topMargin, u);
              }
            }
            else
            {
              i2 = i;
              if (i2 != -1)
              {
                localObject3 = a(i2);
                if (localObject3 != null) {
                  ((d.g.a.h.d)localObject1).a(c.c.TOP, (d.g.a.h.d)localObject3, c.c.BOTTOM, topMargin, u);
                }
              }
            }
            i2 = j;
            if (i2 != -1)
            {
              localObject3 = a(i2);
              if (localObject3 != null) {
                ((d.g.a.h.d)localObject1).a(c.c.BOTTOM, (d.g.a.h.d)localObject3, c.c.TOP, bottomMargin, w);
              }
            }
            else
            {
              i2 = k;
              if (i2 != -1)
              {
                localObject3 = a(i2);
                if (localObject3 != null)
                {
                  localObject5 = c.c.BOTTOM;
                  ((d.g.a.h.d)localObject1).a((c.c)localObject5, (d.g.a.h.d)localObject3, (c.c)localObject5, bottomMargin, w);
                }
              }
            }
            i2 = l;
            if (i2 != -1)
            {
              localObject5 = (View)x.get(i2);
              localObject3 = a(l);
              if ((localObject3 != null) && (localObject5 != null) && ((((View)localObject5).getLayoutParams() instanceof ConstraintLayout.a)))
              {
                localObject5 = (ConstraintLayout.a)((View)localObject5).getLayoutParams();
                W = true;
                W = true;
                ((d.g.a.h.d)localObject1).a(c.c.BASELINE).a(((d.g.a.h.d)localObject3).a(c.c.BASELINE), 0, -1, c.b.STRONG, 0, true);
                ((d.g.a.h.d)localObject1).a(c.c.TOP).c();
                ((d.g.a.h.d)localObject1).a(c.c.BOTTOM).c();
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
          if ((bool2) && ((P != -1) || (Q != -1)))
          {
            i8 = P;
            i2 = Q;
            I = i8;
            J = i2;
          }
          if (!U)
          {
            if (width == -1)
            {
              ((d.g.a.h.d)localObject1).a(d.a.MATCH_PARENT);
              aLEFTe = leftMargin;
              aRIGHTe = rightMargin;
            }
            else
            {
              ((d.g.a.h.d)localObject1).a(d.a.MATCH_CONSTRAINT);
              ((d.g.a.h.d)localObject1).f(0);
            }
          }
          else
          {
            ((d.g.a.h.d)localObject1).a(d.a.FIXED);
            ((d.g.a.h.d)localObject1).f(width);
          }
          if (!V)
          {
            if (height == -1)
            {
              ((d.g.a.h.d)localObject1).b(d.a.MATCH_PARENT);
              aTOPe = topMargin;
              aBOTTOMe = bottomMargin;
            }
            else
            {
              ((d.g.a.h.d)localObject1).b(d.a.MATCH_CONSTRAINT);
              ((d.g.a.h.d)localObject1).e(0);
            }
          }
          else
          {
            ((d.g.a.h.d)localObject1).b(d.a.FIXED);
            ((d.g.a.h.d)localObject1).e(height);
          }
          Object localObject5 = B;
          if (localObject5 != null) {
            if (((String)localObject5).length() == 0)
            {
              G = 0.0F;
            }
            else
            {
              i4 = ((String)localObject5).length();
              i8 = ((String)localObject5).indexOf(',');
              if ((i8 > 0) && (i8 < i4 - 1))
              {
                localObject3 = ((String)localObject5).substring(0, i8);
                if (((String)localObject3).equalsIgnoreCase("W")) {
                  i2 = 0;
                } else if (((String)localObject3).equalsIgnoreCase("H")) {
                  i2 = 1;
                } else {
                  i2 = -1;
                }
                i9 = i8 + 1;
                i8 = i2;
                i2 = i9;
              }
              else
              {
                i2 = 0;
                i8 = -1;
              }
              i9 = ((String)localObject5).indexOf(':');
              if ((i9 >= 0) && (i9 < i4 - 1))
              {
                localObject3 = ((String)localObject5).substring(i2, i9);
                localObject5 = ((String)localObject5).substring(i9 + 1);
                if ((((String)localObject3).length() <= 0) || (((String)localObject5).length() <= 0)) {
                  break label3403;
                }
              }
            }
          }
          try
          {
            float f2 = Float.parseFloat((String)localObject3);
            f1 = Float.parseFloat((String)localObject5);
            if ((f2 > 0.0F) && (f1 > 0.0F)) {
              if (i8 == 1)
              {
                f1 = Math.abs(f1 / f2);
              }
              else
              {
                f1 = Math.abs(f2 / f1);
                break label3400;
                localObject3 = ((String)localObject5).substring(i2);
                if (((String)localObject3).length() <= 0) {
                  break label3403;
                }
                f1 = Float.parseFloat((String)localObject3);
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label3400:
            label3403:
            for (;;) {}
          }
          f1 = 0.0F;
          if (f1 > 0.0F)
          {
            G = f1;
            H = i8;
          }
          f1 = D;
          localObject3 = g0;
          localObject3[0] = f1;
          localObject3[1] = E;
          e0 = F;
          f0 = G;
          i9 = H;
          i2 = J;
          i8 = L;
          f1 = N;
          e = i9;
          h = i2;
          i = i8;
          j = f1;
          if ((f1 < 1.0F) && (i9 == 0)) {
            e = 2;
          }
          i2 = I;
          i9 = K;
          i8 = M;
          f1 = O;
          f = i2;
          k = i9;
          l = i8;
          m = f1;
          if ((f1 < 1.0F) && (i2 == 0)) {
            f = 2;
          }
          label3624:
          i5++;
        }
        i6 = i;
        i2 = j;
        i = k;
        j = m;
        k = n;
        m = i6;
      }
      else
      {
        i3 = j;
        j = m;
        i6 = i2;
        m = i;
        i2 = i3;
        i = i6;
        i3 = n;
      }
      i5 = 1;
      i6 = i3;
      n = j;
    }
    else
    {
      i3 = m;
      i6 = n;
      i5 = i2;
      i8 = 0;
      m = i;
      i2 = j;
      n = i3;
      i = i5;
      i5 = i8;
    }
    if ((G & 0x8) == 8) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (i3 != 0)
    {
      localObject2 = A;
      ((d.g.a.h.e)localObject2).p();
      ((d.g.a.h.e)localObject2).a(C0);
      localObject2 = A;
      if (C[0] != d.a.WRAP_CONTENT)
      {
        localObject1 = c;
        if (localObject1 != null) {
          ((k)localObject1).a(i7);
        }
      }
      if (C[1] != d.a.WRAP_CONTENT)
      {
        localObject2 = d;
        if (localObject2 != null) {
          ((k)localObject2).a(i10);
        }
      }
      b(paramInt1, paramInt2);
    }
    else
    {
      a(paramInt1, paramInt2);
    }
    i8 = getChildCount();
    for (j = 0; j < i8; j++)
    {
      localObject2 = getChildAt(j);
      if ((localObject2 instanceof f))
      {
        localObject1 = (f)localObject2;
        if (y != null)
        {
          localObject2 = (ConstraintLayout.a)((View)localObject1).getLayoutParams();
          localObject3 = (ConstraintLayout.a)y.getLayoutParams();
          localObject1 = k0;
          Y = 0;
          k0.f(((d.g.a.h.d)localObject1).i());
          k0.e(k0.d());
          k0.Y = 8;
        }
      }
    }
    i8 = y.size();
    if (i8 > 0)
    {
      j = 0;
      while (j < i8) {
        if ((b)y.get(j) != null) {
          j++;
        } else {
          throw null;
        }
      }
    }
    if ((getChildCount() > 0) && (i5 != 0)) {
      r.a(A);
    }
    localObject2 = A;
    if (x0)
    {
      if (y0) {
        if (m == Integer.MIN_VALUE)
        {
          j = A0;
          if (j < i2) {
            ((d.g.a.h.d)localObject2).f(j);
          }
          A.a(d.a.FIXED);
        }
        else {}
      }
      localObject2 = A;
      if (z0)
      {
        if (k == Integer.MIN_VALUE)
        {
          j = B0;
          if (j < n) {
            ((d.g.a.h.d)localObject2).e(j);
          }
          A.b(d.a.FIXED);
        }
      }
      else {}
    }
    if ((G & 0x20) == 32)
    {
      i5 = A.i();
      j = A.d();
      if ((K != i5) && (m == 1073741824)) {
        r.a(A.w0, 0, i5);
      }
      if ((L != j) && (k == 1073741824)) {
        r.a(A.w0, 1, j);
      }
      localObject2 = A;
      if ((y0) && (A0 > i2)) {
        r.a(w0, 0, i2);
      }
      localObject2 = A;
      if ((z0) && (B0 > n)) {
        r.a(w0, 1, n);
      }
    }
    if (getChildCount() > 0) {
      A.o();
    }
    i5 = z.size();
    i11 = getPaddingBottom() + i;
    k = getPaddingRight() + i6;
    if (i5 > 0)
    {
      if (A.e() == d.a.WRAP_CONTENT) {
        i6 = 1;
      } else {
        i6 = 0;
      }
      if (A.h() == d.a.WRAP_CONTENT) {
        i8 = 1;
      } else {
        i8 = 0;
      }
      n = Math.max(A.i(), B);
      i2 = Math.max(A.d(), C);
      i9 = 0;
      j = 0;
      m = 0;
      while (i9 < i5)
      {
        localObject1 = (d.g.a.h.d)z.get(i9);
        localObject2 = (View)X;
        if (localObject2 != null)
        {
          localObject3 = (ConstraintLayout.a)((View)localObject2).getLayoutParams();
          if ((!Y) && (!X) && ((((View)localObject2).getVisibility() == 8) || ((i3 == 0) || (!((d.g.a.h.d)localObject1).g().c()) || (!((d.g.a.h.d)localObject1).f().c()))))
          {
            i = width;
            if ((i == -2) && (U)) {
              i = ViewGroup.getChildMeasureSpec(paramInt1, k, i);
            } else {
              i = View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject1).i(), 1073741824);
            }
            i4 = height;
            if ((i4 == -2) && (V)) {
              i4 = ViewGroup.getChildMeasureSpec(paramInt2, i11, i4);
            } else {
              i4 = View.MeasureSpec.makeMeasureSpec(((d.g.a.h.d)localObject1).d(), 1073741824);
            }
            ((View)localObject2).measure(i, i4);
            i13 = ((View)localObject2).getMeasuredWidth();
            i4 = ((View)localObject2).getMeasuredHeight();
            i = n;
            if (i13 != ((d.g.a.h.d)localObject1).i())
            {
              ((d.g.a.h.d)localObject1).f(i13);
              if (i3 != 0) {
                ((d.g.a.h.d)localObject1).g().a(i13);
              }
              i = n;
              if (i6 != 0)
              {
                j = I + E;
                i = n;
                if (j > n) {
                  i = Math.max(n, ((d.g.a.h.d)localObject1).a(c.c.RIGHT).a() + j);
                }
              }
              j = 1;
            }
            n = i2;
            if (i4 != ((d.g.a.h.d)localObject1).d())
            {
              ((d.g.a.h.d)localObject1).e(i4);
              if (i3 != 0) {
                ((d.g.a.h.d)localObject1).f().a(i4);
              }
              n = i2;
              if (i8 != 0)
              {
                n = i2;
                if (J + F > i2)
                {
                  n = ((d.g.a.h.d)localObject1).c();
                  n = Math.max(i2, ((d.g.a.h.d)localObject1).a(c.c.BOTTOM).a() + n);
                }
              }
              j = 1;
            }
            if (W)
            {
              i4 = ((View)localObject2).getBaseline();
              i2 = j;
              if (i4 != -1)
              {
                i2 = j;
                if (i4 != Q)
                {
                  Q = i4;
                  i2 = 1;
                }
              }
            }
            else
            {
              i2 = j;
            }
            m = ViewGroup.combineMeasuredStates(m, ((View)localObject2).getMeasuredState());
            j = n;
            i4 = i2;
            break label4984;
          }
        }
        i4 = j;
        j = i2;
        i = n;
        label4984:
        i9++;
        n = i;
        i2 = j;
        j = i4;
      }
      if (j != 0)
      {
        A.f(i7);
        A.e(i10);
        if (i3 != 0) {
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
        if (A.d() < i2)
        {
          A.e(i2);
          n = 1;
        }
        if (n != 0) {
          A.o();
        }
      }
      for (i2 = 0; i2 < i5; i2++)
      {
        localObject2 = (d.g.a.h.d)z.get(i2);
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
      i2 = m;
    }
    else
    {
      i2 = 0;
    }
    m = A.i();
    n = A.d();
    paramInt1 = ViewGroup.resolveSizeAndState(m + k, paramInt1, i2);
    i2 = ViewGroup.resolveSizeAndState(n + i11, paramInt2, i2 << 16);
    paramInt2 = Math.min(D, paramInt1 & 0xFFFFFF);
    i2 = Math.min(E, i2 & 0xFFFFFF);
    paramInt1 = paramInt2;
    if (A.E0) {
      paramInt1 = paramInt2 | 0x1000000;
    }
    paramInt2 = i2;
    if (A.F0) {
      paramInt2 = i2 | 0x1000000;
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
      localObject = (ConstraintLayout.a)paramView.getLayoutParams();
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
}

/* Location:
 * Qualified Name:     base.androidx.constraintlayout.widget.ConstraintLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */