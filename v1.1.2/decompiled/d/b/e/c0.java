package d.b.e;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import d.b.c.a.c;
import d.i.c.j.b;

public class c0
{
  static
  {
    new Rect();
    try
    {
      Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int i = paramDrawable.length;
        for (int j = 0; j < i; j++) {
          if (!a(paramDrawable[j])) {
            return false;
          }
        }
      }
    }
    else
    {
      if ((paramDrawable instanceof b)) {
        return a(((b)paramDrawable).a());
      }
      if ((paramDrawable instanceof c)) {
        return a(x);
      }
      if ((paramDrawable instanceof ScaleDrawable)) {
        return a(((ScaleDrawable)paramDrawable).getDrawable());
      }
    }
    return true;
  }
  
  public static void b(Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      int[] arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        paramDrawable.setState(p0.f);
      } else {
        paramDrawable.setState(p0.e);
      }
      paramDrawable.setState(arrayOfInt);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */