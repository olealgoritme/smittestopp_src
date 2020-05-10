package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.b.a.k;
import d.b.a.m;
import d.b.e.g0;

public class FitWindowsFrameLayout
  extends FrameLayout
{
  public g0 x;
  
  public FitWindowsFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitWindowsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    g0 localg0 = x;
    if (localg0 != null) {
      top = a.f(top);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(g0 paramg0)
  {
    x = paramg0;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.FitWindowsFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */