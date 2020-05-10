package d.i.c.j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

public class d
  extends c
{
  public static Method E;
  
  public d(Drawable paramDrawable)
  {
    super(paramDrawable);
    c();
  }
  
  public d(e parame, Resources paramResources)
  {
    super(parame, paramResources);
    c();
  }
  
  public boolean b()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i == 21)
    {
      Drawable localDrawable = C;
      if ((!(localDrawable instanceof GradientDrawable)) && (!(localDrawable instanceof DrawableContainer)) && (!(localDrawable instanceof InsetDrawable)))
      {
        bool2 = bool1;
        if (!(localDrawable instanceof RippleDrawable)) {}
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public final void c()
  {
    if (E == null) {
      try
      {
        E = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
      }
      catch (Exception localException)
      {
        Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", localException);
      }
    }
  }
  
  public Rect getDirtyBounds()
  {
    return C.getDirtyBounds();
  }
  
  public void getOutline(Outline paramOutline)
  {
    C.getOutline(paramOutline);
  }
  
  public boolean isProjected()
  {
    Drawable localDrawable = C;
    if (localDrawable != null)
    {
      Method localMethod = E;
      if (localMethod != null) {
        try
        {
          boolean bool = ((Boolean)localMethod.invoke(localDrawable, new Object[0])).booleanValue();
          return bool;
        }
        catch (Exception localException)
        {
          Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", localException);
        }
      }
    }
    return false;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    C.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    C.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (super.setState(paramArrayOfInt))
    {
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void setTint(int paramInt)
  {
    if (b()) {
      super.setTint(paramInt);
    } else {
      C.setTint(paramInt);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (b())
    {
      A.c = paramColorStateList;
      a(getState());
    }
    else
    {
      C.setTintList(paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (b())
    {
      A.d = paramMode;
      a(getState());
    }
    else
    {
      C.setTintMode(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     d.i.c.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */