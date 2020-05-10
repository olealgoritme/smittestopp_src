package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import d.b.b.a.a;

public class ActivityChooserView$InnerLayout
  extends LinearLayout
{
  public static final int[] x = { 16842964 };
  
  public ActivityChooserView$InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, x);
    if (paramAttributeSet.hasValue(0))
    {
      int i = paramAttributeSet.getResourceId(0, 0);
      if (i != 0)
      {
        paramContext = a.c(paramContext, i);
        break label49;
      }
    }
    paramContext = paramAttributeSet.getDrawable(0);
    label49:
    setBackgroundDrawable(paramContext);
    paramAttributeSet.recycle();
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.InnerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */