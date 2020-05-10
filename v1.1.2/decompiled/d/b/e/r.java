package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import d.b.b.a.a;

public class r
  extends RadioButton
{
  public final i x;
  public final x y;
  
  public r(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = new i(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
    paramContext = new x(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, i);
  }
  
  public int getCompoundPaddingLeft()
  {
    int i = super.getCompoundPaddingLeft();
    i locali = x;
    return i;
  }
  
  public ColorStateList getSupportButtonTintList()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = b;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = c;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(a.c(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    paramDrawable = x;
    if (paramDrawable != null) {
      if (f)
      {
        f = false;
      }
      else
      {
        f = true;
        paramDrawable.a();
      }
    }
  }
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    i locali = x;
    if (locali != null)
    {
      b = paramColorStateList;
      d = true;
      locali.a();
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    i locali = x;
    if (locali != null)
    {
      c = paramMode;
      e = true;
      locali.a();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */