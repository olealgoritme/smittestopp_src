package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import d.b.a.k;
import d.b.a.m;
import d.b.e.e0;

public class FitWindowsFrameLayout
  extends FrameLayout
{
  public e0 x;
  
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
    e0 locale0 = x;
    if (locale0 != null) {
      top = a.f(top);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(e0 parame0)
  {
    x = parame0;
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.FitWindowsFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */