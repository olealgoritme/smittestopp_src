package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.coordinatorlayout.R.styleable;

public class CoordinatorLayout$f
  extends ViewGroup.MarginLayoutParams
{
  public CoordinatorLayout.c a;
  public boolean b = false;
  public int c = 0;
  public int d = 0;
  public int e = -1;
  public int f = -1;
  public int g = 0;
  public int h = 0;
  public int i;
  public int j;
  public View k;
  public View l;
  public boolean m;
  public boolean n;
  public boolean o;
  public boolean p;
  public final Rect q = new Rect();
  
  public CoordinatorLayout$f(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public CoordinatorLayout$f(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
    c = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
    f = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
    d = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
    e = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
    g = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
    h = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
    boolean bool = localTypedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
    b = bool;
    if (bool) {
      a = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
    }
    localTypedArray.recycle();
    paramContext = a;
    if (paramContext != null) {
      paramContext.a(this);
    }
  }
  
  public CoordinatorLayout$f(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$f(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public CoordinatorLayout$f(f paramf)
  {
    super(paramf);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        o = paramBoolean;
      }
    }
    else {
      n = paramBoolean;
    }
  }
  
  public void a(CoordinatorLayout.c paramc)
  {
    CoordinatorLayout.c localc = a;
    if (localc != paramc)
    {
      if ((localc != null) && (localc == null)) {
        throw null;
      }
      a = paramc;
      b = true;
      if (paramc != null) {
        paramc.a(this);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      return o;
    }
    return n;
  }
}

/* Location:
 * Qualified Name:     base.androidx.coordinatorlayout.widget.CoordinatorLayout.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */