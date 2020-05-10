package d.b.e;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.R.styleable;

import d.i.i.n;

public class e
{
  public final View a;
  public final j b;
  public int c = -1;
  public v0 d;
  public v0 e;
  public v0 f;
  
  public e(View paramView)
  {
    a = paramView;
    b = j.a();
  }
  
  public void a()
  {
    Drawable localDrawable = a.getBackground();
    if (localDrawable != null)
    {
      int i = Build.VERSION.SDK_INT;
      int j = 1;
      if (i > 21) {
        if (d == null) {}
      }
      for (;;)
      {
        i = 1;
        break;
        do
        {
          i = 0;
          break;
        } while (i != 21);
      }
      if (i != 0)
      {
        if (f == null) {
          f = new v0();
        }
        localv0 = f;
        a = null;
        d = false;
        b = null;
        c = false;
        Object localObject = n.c(a);
        if (localObject != null)
        {
          d = true;
          a = ((ColorStateList)localObject);
        }
        localObject = a.getBackgroundTintMode();
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
      v0 localv0 = e;
      if (localv0 != null)
      {
        j.a(localDrawable, localv0, a.getDrawableState());
      }
      else
      {
        localv0 = d;
        if (localv0 != null) {
          j.a(localDrawable, localv0, a.getDrawableState());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    c = paramInt;
    Object localObject = b;
    if (localObject != null) {
      localObject = ((j)localObject).b(a.getContext(), paramInt);
    } else {
      localObject = null;
    }
    a((ColorStateList)localObject);
    a();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (d == null) {
        d = new v0();
      }
      v0 localv0 = d;
      a = paramColorStateList;
      d = true;
    }
    else
    {
      d = null;
    }
    a();
  }
  
  public void a(PorterDuff.Mode paramMode)
  {
    if (e == null) {
      e = new v0();
    }
    v0 localv0 = e;
    b = paramMode;
    c = true;
    a();
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = x0.a(a.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try
    {
      if (paramAttributeSet.f(R.styleable.ViewBackgroundHelper_android_background))
      {
        c = paramAttributeSet.f(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList localColorStateList = b.b(a.getContext(), c);
        if (localColorStateList != null) {
          a(localColorStateList);
        }
      }
      if (paramAttributeSet.f(R.styleable.ViewBackgroundHelper_backgroundTint)) {
        n.a(a, paramAttributeSet.a(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      if (paramAttributeSet.f(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
        n.a(a, e0.a(paramAttributeSet.c(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      b.recycle();
    }
  }
  
  public ColorStateList b()
  {
    Object localObject = e;
    if (localObject != null) {
      localObject = a;
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    if (e == null) {
      e = new v0();
    }
    v0 localv0 = e;
    a = paramColorStateList;
    d = true;
    a();
  }
  
  public PorterDuff.Mode c()
  {
    Object localObject = e;
    if (localObject != null) {
      localObject = b;
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public void d()
  {
    c = -1;
    a(null);
    a();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */