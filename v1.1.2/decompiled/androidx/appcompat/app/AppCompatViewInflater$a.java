package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import e.a.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppCompatViewInflater$a
  implements View.OnClickListener
{
  public Context A;
  public final View x;
  public final String y;
  public Method z;
  
  public AppCompatViewInflater$a(View paramView, String paramString)
  {
    x = paramView;
    y = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (z == null)
    {
      Object localObject = x.getContext();
      while (localObject != null) {
        try
        {
          if (!((Context)localObject).isRestricted())
          {
            Method localMethod = localObject.getClass().getMethod(y, new Class[] { View.class });
            if (localMethod != null)
            {
              z = localMethod;
              A = ((Context)localObject);
            }
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          if ((localObject instanceof ContextWrapper)) {
            localObject = ((ContextWrapper)localObject).getBaseContext();
          } else {
            localObject = null;
          }
        }
      }
      int i = x.getId();
      if (i == -1)
      {
        paramView = "";
      }
      else
      {
        paramView = a.a(" with id '");
        paramView.append(x.getContext().getResources().getResourceEntryName(i));
        paramView.append("'");
        paramView = paramView.toString();
      }
      localObject = a.a("Could not find method ");
      ((StringBuilder)localObject).append(y);
      ((StringBuilder)localObject).append("(View) in a parent or ancestor Context for android:onClick ");
      ((StringBuilder)localObject).append("attribute defined on view ");
      ((StringBuilder)localObject).append(x.getClass());
      ((StringBuilder)localObject).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    try
    {
      z.invoke(A, new Object[] { paramView });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new IllegalStateException("Could not execute method for android:onClick", paramView);
    }
    catch (IllegalAccessException paramView)
    {
      throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.appcompat.app.AppCompatViewInflater.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */