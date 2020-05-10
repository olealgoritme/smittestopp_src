package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class CoordinatorLayout$c<V extends View>
{
  public CoordinatorLayout$c() {}
  
  public CoordinatorLayout$c(Context paramContext, AttributeSet paramAttributeSet) {}
  
  public Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return View.BaseSavedState.EMPTY_STATE;
  }
  
  public void a(CoordinatorLayout.f paramf) {}
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt) {}
  
  @Deprecated
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      a(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3) {}
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  @Deprecated
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return a(paramCoordinatorLayout, paramV, paramView1, paramView2, paramInt1);
    }
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.androidx.coordinatorlayout.widget.CoordinatorLayout.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */