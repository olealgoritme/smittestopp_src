package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R.styleable;
import d.b.a.r;
import d.i.i.n;
import java.lang.reflect.Method;

public class k0
  implements d.b.d.i.p
{
  public static Method Z;
  public static Method a0;
  public static Method b0;
  public int A = -2;
  public int B = -2;
  public int C;
  public int D;
  public int E = 1002;
  public boolean F;
  public boolean G;
  public boolean H;
  public int I = 0;
  public boolean J = false;
  public boolean K = false;
  public int L = Integer.MAX_VALUE;
  public int M = 0;
  public DataSetObserver N;
  public View O;
  public AdapterView.OnItemClickListener P;
  public final k0.e Q = new k0.e(this);
  public final k0.d R = new k0.d(this);
  public final k0.c S = new k0.c(this);
  public final k0.a T = new k0.a(this);
  public final Handler U;
  public final Rect V = new Rect();
  public Rect W;
  public boolean X;
  public PopupWindow Y;
  public Context x;
  public ListAdapter y;
  public f0 z;
  
  static
  {
    if (Build.VERSION.SDK_INT <= 28)
    {
      try
      {
        Z = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }
      try
      {
        b0 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      }
    }
    if (Build.VERSION.SDK_INT <= 23) {
      try
      {
        a0 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      }
    }
  }
  
  public k0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    x = paramContext;
    U = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    C = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    int i = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    D = i;
    if (i != 0) {
      F = true;
    }
    localTypedArray.recycle();
    paramContext = new p(paramContext, paramAttributeSet, paramInt1, paramInt2);
    Y = paramContext;
    paramContext.setInputMethodMode(1);
  }
  
  public f0 a(Context paramContext, boolean paramBoolean)
  {
    return new f0(paramContext, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    C = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    Y.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = N;
    if (localDataSetObserver == null)
    {
      N = new k0.b(this);
    }
    else
    {
      ListAdapter localListAdapter = y;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    y = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(N);
    }
    paramListAdapter = z;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(y);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    X = paramBoolean;
    Y.setFocusable(paramBoolean);
  }
  
  public boolean a()
  {
    return Y.isShowing();
  }
  
  public int b()
  {
    return C;
  }
  
  public void b(int paramInt)
  {
    D = paramInt;
    F = true;
  }
  
  public void c()
  {
    Object localObject1 = z;
    boolean bool1 = true;
    if (localObject1 == null)
    {
      localObject1 = a(x, X ^ true);
      z = ((f0)localObject1);
      ((ListView)localObject1).setAdapter(y);
      z.setOnItemClickListener(P);
      z.setFocusable(true);
      z.setFocusableInTouchMode(true);
      z.setOnItemSelectedListener(new j0(this));
      z.setOnScrollListener(S);
      localObject1 = z;
      Y.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)Y.getContentView();
    }
    localObject1 = Y.getBackground();
    int j;
    int k;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(V);
      localObject1 = V;
      i = top;
      j = bottom + i;
      k = j;
      if (!F)
      {
        D = (-i);
        k = j;
      }
    }
    else
    {
      V.setEmpty();
      k = 0;
    }
    boolean bool2;
    if (Y.getInputMethodMode() == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localObject1 = O;
    int i = D;
    if (Build.VERSION.SDK_INT <= 23)
    {
      Method localMethod = a0;
      if (localMethod != null) {
        try
        {
          j = ((Integer)localMethod.invoke(Y, new Object[] { localObject1, Integer.valueOf(i), Boolean.valueOf(bool2) })).intValue();
        }
        catch (Exception localException3)
        {
          Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
        }
      } else {
        j = Y.getMaxAvailableHeight((View)localObject1, i);
      }
    }
    else
    {
      j = Y.getMaxAvailableHeight((View)localObject1, i, bool2);
    }
    if ((!J) && (A != -1))
    {
      i = B;
      if (i != -2)
      {
        if (i != -1)
        {
          i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        else
        {
          i = x.getResources().getDisplayMetrics().widthPixels;
          localObject1 = V;
          i = View.MeasureSpec.makeMeasureSpec(i - (left + right), 1073741824);
        }
      }
      else
      {
        i = x.getResources().getDisplayMetrics().widthPixels;
        localObject1 = V;
        i = View.MeasureSpec.makeMeasureSpec(i - (left + right), Integer.MIN_VALUE);
      }
      i = z.a(i, j - 0, -1);
      if (i > 0)
      {
        j = z.getPaddingTop();
        j = z.getPaddingBottom() + j + k + 0;
      }
      else
      {
        j = 0;
      }
      j = i + j;
    }
    else
    {
      j += k;
    }
    if (Y.getInputMethodMode() == 2) {
      k = 1;
    } else {
      k = 0;
    }
    r.a(Y, E);
    if (Y.isShowing())
    {
      if (!n.s(O)) {
        return;
      }
      int m = B;
      if (m == -1)
      {
        i = -1;
      }
      else
      {
        i = m;
        if (m == -2) {
          i = O.getWidth();
        }
      }
      m = A;
      if (m == -1)
      {
        if (k == 0) {
          j = -1;
        }
        if (k != 0)
        {
          localObject1 = Y;
          if (B == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          Y.setHeight(0);
        }
        else
        {
          localObject1 = Y;
          if (B == -1) {
            k = -1;
          } else {
            k = 0;
          }
          ((PopupWindow)localObject1).setWidth(k);
          Y.setHeight(-1);
        }
      }
      else if (m != -2)
      {
        j = m;
      }
      localObject1 = Y;
      if ((!K) && (!J)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      ((PopupWindow)localObject1).setOutsideTouchable(bool2);
      PopupWindow localPopupWindow = Y;
      localObject1 = O;
      k = C;
      m = D;
      if (i < 0) {
        i = -1;
      }
      if (j < 0) {
        j = -1;
      }
      localPopupWindow.update((View)localObject1, k, m, i, j);
    }
    else
    {
      k = B;
      if (k == -1)
      {
        i = -1;
      }
      else
      {
        i = k;
        if (k == -2) {
          i = O.getWidth();
        }
      }
      k = A;
      if (k == -1) {
        j = -1;
      } else if (k != -2) {
        j = k;
      }
      Y.setWidth(i);
      Y.setHeight(j);
      if (Build.VERSION.SDK_INT <= 28)
      {
        localObject1 = Z;
        if (localObject1 != null) {
          try
          {
            ((Method)localObject1).invoke(Y, new Object[] { Boolean.valueOf(true) });
          }
          catch (Exception localException1)
          {
            Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
          }
        }
      }
      else
      {
        Y.setIsClippedToScreen(true);
      }
      Object localObject2 = Y;
      if ((!K) && (!J)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((PopupWindow)localObject2).setOutsideTouchable(bool2);
      Y.setTouchInterceptor(R);
      if (H) {
        r.a(Y, G);
      }
      if (Build.VERSION.SDK_INT <= 28)
      {
        localObject2 = b0;
        if (localObject2 != null) {
          try
          {
            ((Method)localObject2).invoke(Y, new Object[] { W });
          }
          catch (Exception localException2)
          {
            Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException2);
          }
        }
      }
      else
      {
        Y.setEpicenterBounds(W);
      }
      Y.showAsDropDown(O, C, D, I);
      z.setSelection(-1);
      if ((!X) || (z.isInTouchMode()))
      {
        f0 localf0 = z;
        if (localf0 != null)
        {
          localf0.setListSelectionHidden(true);
          localf0.requestLayout();
        }
      }
      if (!X) {
        U.post(T);
      }
    }
  }
  
  public int d()
  {
    if (!F) {
      return 0;
    }
    return D;
  }
  
  public void d(int paramInt)
  {
    Object localObject = Y.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(V);
      localObject = V;
      B = (left + right + paramInt);
    }
    else
    {
      B = paramInt;
    }
  }
  
  public void dismiss()
  {
    Y.dismiss();
    Y.setContentView(null);
    z = null;
    U.removeCallbacks(Q);
  }
  
  public Drawable e()
  {
    return Y.getBackground();
  }
  
  public ListView g()
  {
    return z;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.k0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */