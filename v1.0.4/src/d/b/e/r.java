package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import d.b.b.a.a;

public class r
  extends RadioButton
{
  public final i x;
  public final e y;
  public final y z;
  
  public r(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = new i(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
    paramContext = new e(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, i);
    paramContext = new y(this);
    z = paramContext;
    paramContext.a(paramAttributeSet, i);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = y;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = z;
    if (localObject != null) {
      ((y)localObject).a();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i = super.getCompoundPaddingLeft();
    i locali = x;
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = y;
    if (localObject != null) {
      localObject = ((e)localObject).b();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = y;
    if (localObject != null) {
      localObject = ((e)localObject).c();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
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
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = y;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    e locale = y;
    if (locale != null) {
      locale.a(paramInt);
    }
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
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    e locale = y;
    if (locale != null) {
      locale.b(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    e locale = y;
    if (locale != null) {
      locale.a(paramMode);
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
 * Qualified Name:     base.d.b.e.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */