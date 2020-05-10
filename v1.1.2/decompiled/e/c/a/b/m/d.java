package e.c.a.b.m;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import com.google.android.material.R.styleable;
import d.i.i.n;

public class d
  extends FrameLayout
{
  public b A;
  public final AccessibilityManager x;
  public final d.i.i.x.b y;
  public c z;
  
  public d(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    if (paramAttributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
      n.a(this, paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
    }
    paramAttributeSet.recycle();
    x = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    paramContext = new a();
    y = paramContext;
    x.addTouchExplorationStateChangeListener(new d.i.i.x.c(paramContext));
    setClickableOrFocusableBasedOnAccessibility(x.isTouchExplorationEnabled());
  }
  
  private void setClickableOrFocusableBasedOnAccessibility(boolean paramBoolean)
  {
    setClickable(paramBoolean ^ true);
    setFocusable(paramBoolean);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b localb = A;
    if (localb != null) {
      localb.onViewAttachedToWindow(this);
    }
    n.y(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = A;
    if (localObject != null) {
      ((b)localObject).onViewDetachedFromWindow(this);
    }
    localObject = x;
    d.i.i.x.b localb = y;
    if (localb != null) {
      ((AccessibilityManager)localObject).removeTouchExplorationStateChangeListener(new d.i.i.x.c(localb));
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c localc = z;
    if (localc != null) {
      localc.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnAttachStateChangeListener(b paramb)
  {
    A = paramb;
  }
  
  public void setOnLayoutChangeListener(c paramc)
  {
    z = paramc;
  }
  
  public class a
    implements d.i.i.x.b
  {
    public a() {}
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.m.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */