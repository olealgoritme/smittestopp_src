package d.b.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

import androidx.appcompat.R.styleable;

import d.b.a.r;
import d.b.b.a.a;

public class p
  extends PopupWindow
{
  public p(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PopupWindow, paramInt1, paramInt2);
    if (paramAttributeSet.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
      r.a(this, paramAttributeSet.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
    }
    paramInt1 = R.styleable.PopupWindow_android_popupBackground;
    if (paramAttributeSet.hasValue(paramInt1))
    {
      paramInt2 = paramAttributeSet.getResourceId(paramInt1, 0);
      if (paramInt2 != 0)
      {
        paramContext = a.c(paramContext, paramInt2);
        break label84;
      }
    }
    paramContext = paramAttributeSet.getDrawable(paramInt1);
    label84:
    setBackgroundDrawable(paramContext);
    paramAttributeSet.recycle();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */