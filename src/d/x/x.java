package d.x;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class x
  extends w
{
  public static Method e;
  public static boolean f;
  public static Method g;
  public static boolean h;
  
  public void a(View paramView, Matrix paramMatrix)
  {
    if (!f)
    {
      try
      {
        Method localMethod1 = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
        e = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", localNoSuchMethodException);
      }
      f = true;
    }
    Method localMethod2 = e;
    if (localMethod2 != null) {}
    try
    {
      try
      {
        localMethod2.invoke(paramView, new Object[] { paramMatrix });
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
  
  public void b(View paramView, Matrix paramMatrix)
  {
    if (!h)
    {
      try
      {
        Method localMethod1 = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
        g = localMethod1;
        localMethod1.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", localNoSuchMethodException);
      }
      h = true;
    }
    Method localMethod2 = g;
    if (localMethod2 != null) {}
    try
    {
      try
      {
        localMethod2.invoke(paramView, new Object[] { paramMatrix });
      }
      catch (InvocationTargetException paramView)
      {
        throw new RuntimeException(paramView.getCause());
      }
      return;
    }
    catch (IllegalAccessException paramView)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.d.x.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */