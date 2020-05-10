package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import d.b.a.k;
import d.b.a.m;
import d.b.e.e0;

public class FitWindowsLinearLayout
  extends LinearLayout
{
  public e0 x;
  
  public FitWindowsLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public FitWindowsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
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
 * Qualified Name:     androidx.appcompat.widget.FitWindowsLinearLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */