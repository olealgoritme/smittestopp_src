package e.c.a.b.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.BaseBehavior;
import d.i.i.n;

public abstract class b<V extends View>
  extends d<V>
{
  public Runnable d;
  public OverScroller e;
  public boolean f;
  public int g = -1;
  public int h;
  public int i = -1;
  public VelocityTracker j;
  
  public b() {}
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return b(paramCoordinatorLayout, paramV, b() - paramInt1, paramInt2, paramInt3);
  }
  
  public abstract boolean a(V paramV);
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (i < 0) {
      i = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (f)) {
      return true;
    }
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label241;
          }
        }
        else
        {
          k = g;
          if (k == -1) {
            break label241;
          }
          k = paramMotionEvent.findPointerIndex(k);
          if (k == -1) {
            break label241;
          }
          k = (int)paramMotionEvent.getY(k);
          if (Math.abs(k - h) <= i) {
            break label241;
          }
          f = true;
          h = k;
          break label241;
        }
      }
      f = false;
      g = -1;
      paramCoordinatorLayout = j;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        j = null;
      }
    }
    else
    {
      f = false;
      int m = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      if ((a(paramV)) && (paramCoordinatorLayout.a(paramV, m, k)))
      {
        h = k;
        g = paramMotionEvent.getPointerId(0);
        if (j == null) {
          j = VelocityTracker.obtain();
        }
      }
    }
    label241:
    paramCoordinatorLayout = j;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return f;
  }
  
  public abstract int b();
  
  public abstract int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3);
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (i < 0) {
      i = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int k = paramMotionEvent.getActionMasked();
    int n;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3) {
            break label445;
          }
        }
        else
        {
          k = paramMotionEvent.findPointerIndex(g);
          if (k == -1) {
            return false;
          }
          int m = (int)paramMotionEvent.getY(k);
          n = h - m;
          k = n;
          if (!f)
          {
            int i1 = Math.abs(n);
            int i2 = i;
            k = n;
            if (i1 > i2)
            {
              f = true;
              if (n > 0) {
                k = n - i2;
              } else {
                k = n + i2;
              }
            }
          }
          if (!f) {
            break label445;
          }
          h = m;
          a(paramCoordinatorLayout, paramV, k, -((AppBarLayout)paramV).getDownNestedScrollRange(), 0);
          break label445;
        }
      }
      else
      {
        Object localObject = j;
        if (localObject != null)
        {
          ((VelocityTracker)localObject).addMovement(paramMotionEvent);
          j.computeCurrentVelocity(1000);
          float f1 = j.getYVelocity(g);
          localObject = (AppBarLayout)paramV;
          k = -((AppBarLayout)localObject).getTotalScrollRange();
          Runnable localRunnable = d;
          if (localRunnable != null)
          {
            paramV.removeCallbacks(localRunnable);
            d = null;
          }
          if (e == null) {
            e = new OverScroller(paramV.getContext());
          }
          e.fling(0, a(), 0, Math.round(f1), 0, 0, k, 0);
          if (e.computeScrollOffset())
          {
            paramCoordinatorLayout = new a(paramCoordinatorLayout, paramV);
            d = paramCoordinatorLayout;
            n.a(paramV, paramCoordinatorLayout);
          }
          else
          {
            ((AppBarLayout.BaseBehavior)this).a(paramCoordinatorLayout, (AppBarLayout)localObject);
          }
        }
      }
      f = false;
      g = -1;
      paramCoordinatorLayout = j;
      if (paramCoordinatorLayout != null)
      {
        paramCoordinatorLayout.recycle();
        j = null;
      }
    }
    else
    {
      k = (int)paramMotionEvent.getX();
      n = (int)paramMotionEvent.getY();
      if ((!paramCoordinatorLayout.a(paramV, k, n)) || (!a(paramV))) {
        break label461;
      }
      h = n;
      g = paramMotionEvent.getPointerId(0);
      if (j == null) {
        j = VelocityTracker.obtain();
      }
    }
    label445:
    paramCoordinatorLayout = j;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return true;
    label461:
    return false;
  }
  
  public int c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return b(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public class a
    implements Runnable
  {
    public final CoordinatorLayout x;
    public final V y;
    
    public a(V paramV)
    {
      x = paramV;
      View localView;
      y = localView;
    }
    
    public void run()
    {
      if (y != null)
      {
        Object localObject1 = e;
        if (localObject1 != null) {
          if (((OverScroller)localObject1).computeScrollOffset())
          {
            localObject1 = b.this;
            ((b)localObject1).c(x, y, e.getCurrY());
            n.a(y, this);
          }
          else
          {
            Object localObject2 = b.this;
            localObject1 = x;
            View localView = y;
            localObject2 = (AppBarLayout.BaseBehavior)localObject2;
            if (localObject2 != null) {
              ((AppBarLayout.BaseBehavior)localObject2).a((CoordinatorLayout)localObject1, (AppBarLayout)localView);
            } else {
              throw null;
            }
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */