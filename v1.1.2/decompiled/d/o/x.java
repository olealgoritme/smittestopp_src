package d.o;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import d.v.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class x
  extends b0
{
  public static final Class<?>[] f = { Application.class, w.class };
  public static final Class<?>[] g = { w.class };
  public final Application a;
  public final z b;
  public final Bundle c;
  public final g d;
  public final d.v.a e;
  
  @SuppressLint({"LambdaLast"})
  public x(Application paramApplication, c paramc, Bundle paramBundle)
  {
    e = paramc.getSavedStateRegistry();
    d = paramc.getLifecycle();
    c = paramBundle;
    a = paramApplication;
    if (z.b == null) {
      z.b = new z(paramApplication);
    }
    b = z.b;
  }
  
  public static <T> Constructor<T> a(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    for (paramClass : paramClass.getConstructors()) {
      if (Arrays.equals(paramArrayOfClass, paramClass.getParameterTypes())) {
        return paramClass;
      }
    }
    return null;
  }
  
  public <T extends y> T a(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null) {
      return a(str, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public <T extends y> T a(String paramString, Class<T> paramClass)
  {
    boolean bool = a.class.isAssignableFrom(paramClass);
    Constructor localConstructor;
    if (bool) {
      localConstructor = a(paramClass, f);
    } else {
      localConstructor = a(paramClass, g);
    }
    if (localConstructor == null) {
      return b.a(paramClass);
    }
    d.v.a locala = e;
    g localg = d;
    Object localObject = c;
    localObject = new SavedStateHandleController(paramString, w.a(locala.a(paramString), (Bundle)localObject));
    ((SavedStateHandleController)localObject).a(locala, localg);
    SavedStateHandleController.b(locala, localg);
    if (bool) {}
    try
    {
      paramString = (y)localConstructor.newInstance(new Object[] { a, z });
      break label157;
      paramString = (y)localConstructor.newInstance(new Object[] { z });
      label157:
      paramString.a("androidx.lifecycle.savedstate.vm.tag", localObject);
      return paramString;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      paramString = new StringBuilder();
      paramString.append("An exception happened in constructor of ");
      paramString.append(paramClass);
      throw new RuntimeException(paramString.toString(), localInvocationTargetException.getCause());
    }
    catch (InstantiationException paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("A ");
      localStringBuilder.append(paramClass);
      localStringBuilder.append(" cannot be instantiated.");
      throw new RuntimeException(localStringBuilder.toString(), paramString);
    }
    catch (IllegalAccessException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to access ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), paramString);
    }
  }
  
  public void a(y paramy)
  {
    d.v.a locala = e;
    g localg = d;
    paramy = (SavedStateHandleController)paramy.a("androidx.lifecycle.savedstate.vm.tag");
    if ((paramy != null) && (!y))
    {
      paramy.a(locala, localg);
      SavedStateHandleController.b(locala, localg);
    }
  }
}

/* Location:
 * Qualified Name:     d.o.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */