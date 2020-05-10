package d.b.e;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R.styleable;
import d.b.b.a.a;

public class m
{
  public final ImageView a;
  public s0 b;
  public s0 c;
  
  public m(ImageView paramImageView)
  {
    a = paramImageView;
  }
  
  public void a()
  {
    Drawable localDrawable = a.getDrawable();
    if (localDrawable != null) {
      c0.b(localDrawable);
    }
    if (localDrawable != null)
    {
      int i = Build.VERSION.SDK_INT;
      int j = 1;
      if (i > 21) {}
      while (i != 21)
      {
        i = 0;
        break;
      }
      i = 1;
      if (i != 0)
      {
        if (c == null) {
          c = new s0();
        }
        locals0 = c;
        a = null;
        d = false;
        b = null;
        c = false;
        Object localObject = a.getImageTintList();
        if (localObject != null)
        {
          d = true;
          a = ((ColorStateList)localObject);
        }
        localObject = a.getImageTintMode();
        if (localObject != null)
        {
          c = true;
          b = ((PorterDuff.Mode)localObject);
        }
        if ((!d) && (!c))
        {
          i = 0;
        }
        else
        {
          j.a(localDrawable, locals0, a.getDrawableState());
          i = j;
        }
        if (i != 0) {
          return;
        }
      }
      s0 locals0 = b;
      if (locals0 != null) {
        j.a(localDrawable, locals0, a.getDrawableState());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.c(a.getContext(), paramInt);
      if (localDrawable != null) {
        c0.b(localDrawable);
      }
      a.setImageDrawable(localDrawable);
    }
    else
    {
      a.setImageDrawable(null);
    }
    a();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    if (b == null) {
      b = new s0();
    }
    s0 locals0 = b;
    a = paramColorStateList;
    d = true;
    a();
  }
  
  public void a(PorterDuff.Mode paramMode)
  {
    if (b == null) {
      b = new s0();
    }
    s0 locals0 = b;
    b = paramMode;
    c = true;
    a();
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    u0 localu0 = u0.a(a.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    Object localObject;
    try
    {
      localObject = a.getDrawable();
      paramAttributeSet = (AttributeSet)localObject;
      if (localObject == null)
      {
        paramInt = localu0.g(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = (AttributeSet)localObject;
        if (paramInt != -1)
        {
          localObject = a.c(a.getContext(), paramInt);
          paramAttributeSet = (AttributeSet)localObject;
          if (localObject != null)
          {
            a.setImageDrawable((Drawable)localObject);
            paramAttributeSet = (AttributeSet)localObject;
          }
        }
      }
      if (paramAttributeSet != null) {
        c0.b(paramAttributeSet);
      }
      if (!localu0.e(R.styleable.AppCompatImageView_tint)) {
        break label175;
      }
      paramAttributeSet = a;
      paramAttributeSet.setImageTintList(localu0.a(R.styleable.AppCompatImageView_tint));
      if (Build.VERSION.SDK_INT != 21) {
        break label175;
      }
      localObject = paramAttributeSet.getDrawable();
      if ((localObject == null) || (paramAttributeSet.getImageTintList() == null)) {
        break label175;
      }
      if (((Drawable)localObject).isStateful()) {
        ((Drawable)localObject).setState(paramAttributeSet.getDrawableState());
      }
    }
    finally
    {
      break label265;
    }
    paramAttributeSet.setImageDrawable((Drawable)localObject);
    label175:
    if (localu0.e(R.styleable.AppCompatImageView_tintMode))
    {
      localObject = a;
      ((ImageView)localObject).setImageTintMode(c0.a(localu0.d(R.styleable.AppCompatImageView_tintMode, -1), null));
      if (Build.VERSION.SDK_INT == 21)
      {
        paramAttributeSet = ((ImageView)localObject).getDrawable();
        if ((paramAttributeSet != null) && (((ImageView)localObject).getImageTintList() != null))
        {
          if (paramAttributeSet.isStateful()) {
            paramAttributeSet.setState(((ImageView)localObject).getDrawableState());
          }
          ((ImageView)localObject).setImageDrawable(paramAttributeSet);
        }
      }
    }
    b.recycle();
    return;
    label265:
    b.recycle();
    throw paramAttributeSet;
  }
}

/* Location:
 * Qualified Name:     d.b.e.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */