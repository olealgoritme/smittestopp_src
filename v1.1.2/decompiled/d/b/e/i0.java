package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.b.d.i.r;
import d.i.i.n;
import java.lang.reflect.Method;

public class i0
  implements r
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
  public final e Q = new e();
  public final d R = new d();
  public final c S = new c();
  public final a T = new a();
  public final Handler U;
  public final Rect V = new Rect();
  public Rect W;
  public boolean X;
  public PopupWindow Y;
  public Context x;
  public ListAdapter y;
  public d0 z;
  
  static
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
      a0 = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
    }
    try
    {
      b0 = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    }
  }
  
  public i0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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
  
  public d0 a(Context paramContext, boolean paramBoolean)
  {
    return new d0(paramContext, paramBoolean);
  }
  
  public void a()
  {
    Object localObject1 = z;
    boolean bool1 = true;
    if (localObject1 == null)
    {
      localObject1 = a(x, X ^ true);
      z = ((d0)localObject1);
      ((ListView)localObject1).setAdapter(y);
      z.setOnItemClickListener(P);
      z.setFocusable(true);
      z.setFocusableInTouchMode(true);
      z.setOnItemSelectedListener(new h0(this));
      z.setOnScrollListener(S);
      localObject1 = z;
      Y.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)Y.getContentView();
    }
    localObject1 = Y.getBackground();
    int i;
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
    int j = D;
    Method localMethod = a0;
    if (localMethod != null) {
      try
      {
        i = ((Integer)localMethod.invoke(Y, new Object[] { localObject1, Integer.valueOf(j), Boolean.valueOf(bool2) })).intValue();
      }
      catch (Exception localException3)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    } else {
      i = Y.getMaxAvailableHeight((View)localObject1, j);
    }
    if ((!J) && (A != -1))
    {
      j = B;
      if (j != -2)
      {
        if (j != -1)
        {
          j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        }
        else
        {
          j = x.getResources().getDisplayMetrics().widthPixels;
          localObject1 = V;
          j = View.MeasureSpec.makeMeasureSpec(j - (left + right), 1073741824);
        }
      }
      else
      {
        j = x.getResources().getDisplayMetrics().widthPixels;
        localObject1 = V;
        j = View.MeasureSpec.makeMeasureSpec(j - (left + right), Integer.MIN_VALUE);
      }
      i = z.a(j, i - 0, -1);
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
      j = i + k;
    }
    if (Y.getInputMethodMode() == 2) {
      i = 1;
    } else {
      i = 0;
    }
    s.a(Y, E);
    if (Y.isShowing())
    {
      if (!n.s(O)) {
        return;
      }
      int m = B;
      if (m == -1)
      {
        k = -1;
      }
      else
      {
        k = m;
        if (m == -2) {
          k = O.getWidth();
        }
      }
      m = A;
      if (m == -1)
      {
        if (i == 0) {
          j = -1;
        }
        if (i != 0)
        {
          localObject1 = Y;
          if (B == -1) {
            i = -1;
          } else {
            i = 0;
          }
          ((PopupWindow)localObject1).setWidth(i);
          Y.setHeight(0);
        }
        else
        {
          localObject1 = Y;
          if (B == -1) {
            i = -1;
          } else {
            i = 0;
          }
          ((PopupWindow)localObject1).setWidth(i);
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
      localObject1 = Y;
      View localView = O;
      i = C;
      m = D;
      if (k < 0) {
        k = -1;
      }
      if (j < 0) {
        j = -1;
      }
      ((PopupWindow)localObject1).update(localView, i, m, k, j);
    }
    else
    {
      i = B;
      if (i == -1)
      {
        k = -1;
      }
      else
      {
        k = i;
        if (i == -2) {
          k = O.getWidth();
        }
      }
      i = A;
      if (i == -1) {
        j = -1;
      } else if (i != -2) {
        j = i;
      }
      Y.setWidth(k);
      Y.setHeight(j);
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
      Object localObject2 = Y;
      if ((!K) && (!J)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((PopupWindow)localObject2).setOutsideTouchable(bool2);
      Y.setTouchInterceptor(R);
      if (H) {
        s.a(Y, G);
      }
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
      Y.showAsDropDown(O, C, D, I);
      z.setSelection(-1);
      if ((!X) || (z.isInTouchMode()))
      {
        d0 locald0 = z;
        if (locald0 != null)
        {
          locald0.setListSelectionHidden(true);
          locald0.requestLayout();
        }
      }
      if (!X) {
        U.post(T);
      }
    }
  }
  
  public void a(int paramInt)
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
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = N;
    if (localDataSetObserver == null)
    {
      N = new b();
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
  
  public ListView b()
  {
    return z;
  }
  
  public void b(int paramInt)
  {
    D = paramInt;
    F = true;
  }
  
  public Drawable c()
  {
    return Y.getBackground();
  }
  
  public void dismiss()
  {
    Y.dismiss();
    Y.setContentView(null);
    z = null;
    U.removeCallbacks(Q);
  }
  
  public boolean e()
  {
    return Y.isShowing();
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      d0 locald0 = z;
      if (locald0 != null)
      {
        locald0.setListSelectionHidden(true);
        locald0.requestLayout();
      }
    }
  }
  
  public class b
    extends DataSetObserver
  {
    public b() {}
    
    public void onChanged()
    {
      if (e()) {
        a();
      }
    }
    
    public void onInvalidated()
    {
      dismiss();
    }
  }
  
  public class c
    implements AbsListView.OnScrollListener
  {
    public c() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      int i = 1;
      if (paramInt == 1)
      {
        if (Y.getInputMethodMode() == 2) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        if ((paramInt == 0) && (Y.getContentView() != null))
        {
          paramAbsListView = i0.this;
          U.removeCallbacks(Q);
          Q.run();
        }
      }
    }
  }
  
  public class d
    implements View.OnTouchListener
  {
    public d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        paramView = Y;
        if ((paramView != null) && (paramView.isShowing()) && (j >= 0) && (j < Y.getWidth()) && (k >= 0) && (k < Y.getHeight()))
        {
          paramView = i0.this;
          U.postDelayed(Q, 250L);
          break label126;
        }
      }
      if (i == 1)
      {
        paramView = i0.this;
        U.removeCallbacks(Q);
      }
      label126:
      return false;
    }
  }
  
  public class e
    implements Runnable
  {
    public e() {}
    
    public void run()
    {
      Object localObject = z;
      if ((localObject != null) && (n.s((View)localObject)) && (z.getCount() > z.getChildCount()))
      {
        int i = z.getChildCount();
        localObject = i0.this;
        if (i <= L)
        {
          Y.setInputMethodMode(2);
          a();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.i0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */