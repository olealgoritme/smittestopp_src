package d.x;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class w
  extends z
{
  public static Method a;
  public static boolean b;
  public static Method c;
  public static boolean d;
  
  public void a(View paramView) {}
  
  public void a(View paramView, float paramFloat)
  {
    if (!b)
    {
      try
      {
        Method localMethod1 = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
        a = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", localNoSuchMethodException);
      }
      b = true;
    }
    Method localMethod2 = a;
    if (localMethod2 != null) {}
    try
    {
      try
      {
        localMethod2.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      paramView.setAlpha(paramFloat);
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
  
  public float b(View paramView)
  {
    if (!d)
    {
      try
      {
        Method localMethod1 = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
        c = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", localNoSuchMethodException);
      }
      d = true;
    }
    Method localMethod2 = c;
    if (localMethod2 != null) {}
    try
    {
      float f = ((Float)localMethod2.invoke(paramView, new Object[0])).floatValue();
      return f;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return super.b(paramView);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public void c(View paramView) {}
}

/* Location:
 * Qualified Name:     d.x.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */