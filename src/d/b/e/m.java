package d.b.e;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.appcompat.R.styleable;

public class m
{
  public final ImageView a;
  public v0 b;
  public v0 c;
  
  public m(ImageView paramImageView)
  {
    a = paramImageView;
  }
  
  public void a()
  {
    Drawable localDrawable = a.getDrawable();
    if (localDrawable != null) {
      e0.b(localDrawable);
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
          c = new v0();
        }
        localv0 = c;
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
          j.a(localDrawable, localv0, a.getDrawableState());
          i = j;
        }
        if (i != 0) {
          return;
        }
      }
      v0 localv0 = b;
      if (localv0 != null) {
        j.a(localDrawable, localv0, a.getDrawableState());
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.c(a.getContext(), paramInt);
      if (localDrawable != null) {
        e0.b(localDrawable);
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
      b = new v0();
    }
    v0 localv0 = b;
    a = paramColorStateList;
    d = true;
    a();
  }
  
  public void a(PorterDuff.Mode paramMode)
  {
    if (b == null) {
      b = new v0();
    }
    v0 localv0 = b;
    b = paramMode;
    c = true;
    a();
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    x0 localx0 = x0.a(a.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    Object localObject;
    try
    {
      localObject = a.getDrawable();
      paramAttributeSet = (AttributeSet)localObject;
      if (localObject == null)
      {
        paramInt = localx0.f(R.styleable.AppCompatImageView_srcCompat, -1);
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
        e0.b(paramAttributeSet);
      }
      if (!localx0.f(R.styleable.AppCompatImageView_tint)) {
        break label176;
      }
      localObject = a;
      ((ImageView)localObject).setImageTintList(localx0.a(R.styleable.AppCompatImageView_tint));
      if (Build.VERSION.SDK_INT != 21) {
        break label176;
      }
      paramAttributeSet = ((ImageView)localObject).getDrawable();
      if ((paramAttributeSet == null) || (((ImageView)localObject).getImageTintList() == null)) {
        break label176;
      }
      if (paramAttributeSet.isStateful()) {
        paramAttributeSet.setState(((ImageView)localObject).getDrawableState());
      }
    }
    finally
    {
      break label266;
    }
    ((ImageView)localObject).setImageDrawable(paramAttributeSet);
    label176:
    if (localx0.f(R.styleable.AppCompatImageView_tintMode))
    {
      localObject = a;
      ((ImageView)localObject).setImageTintMode(e0.a(localx0.c(R.styleable.AppCompatImageView_tintMode, -1), null));
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
    label266:
    b.recycle();
    throw paramAttributeSet;
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */