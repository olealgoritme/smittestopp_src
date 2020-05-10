package k.f;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import k.f.e.e;
import k.f.e.f;
import k.f.e.f.b;
import org.slf4j.impl.StaticLoggerBinder;

public final class c
{
  public static volatile int a;
  public static final e b = new e();
  public static final k.f.e.c c = new k.f.e.c();
  public static boolean d;
  public static final String[] e = { "1.6", "1.7" };
  public static String f = "org/slf4j/impl/StaticLoggerBinder.class";
  
  static
  {
    Object localObject = null;
    try
    {
      String str = System.getProperty("slf4j.detectLoggerNameMismatch");
      localObject = str;
    }
    catch (SecurityException localSecurityException) {}
    boolean bool;
    if (localObject == null) {
      bool = false;
    } else {
      bool = ((String)localObject).equalsIgnoreCase("true");
    }
    d = bool;
  }
  
  public static b a(Class<?> paramClass)
  {
    b localb = a(paramClass.getName());
    if (d)
    {
      f.b localb1 = f.a;
      String str = null;
      Object localObject;
      if (localb1 == null) {
        if (f.b)
        {
          localb1 = null;
        }
        else
        {
          try
          {
            localb1 = new k/f/e/f$b;
            localb1.<init>(null);
          }
          catch (SecurityException localSecurityException)
          {
            localObject = null;
          }
          f.a = (f.b)localObject;
          f.b = true;
        }
      }
      if (localObject == null)
      {
        localObject = str;
      }
      else
      {
        localObject = ((f.b)localObject).getClassContext();
        str = f.class.getName();
        for (int i = 0; (i < localObject.length) && (!str.equals(localObject[i].getName())); i++) {}
        if (i >= localObject.length) {
          break label186;
        }
        i += 2;
        if (i >= localObject.length) {
          break label186;
        }
        localObject = localObject[i];
      }
      if ((localObject != null) && ((((Class)localObject).isAssignableFrom(paramClass) ^ true)))
      {
        f.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[] { localb.getName(), ((Class)localObject).getName() }));
        f.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        return localb;
        label186:
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
      }
    }
    return localb;
  }
  
  public static b a(String paramString)
  {
    return d().a(paramString);
  }
  
  public static final void a()
  {
    try
    {
      if (!e())
      {
        localObject = b();
        b((Set)localObject);
      }
      else
      {
        localObject = null;
      }
      StaticLoggerBinder.getSingleton();
      a = 3;
      a((Set)localObject);
      c();
      f();
      Object localObject = b;
      b.clear();
      c.clear();
    }
    catch (Exception localException)
    {
      a = 2;
      f.a("Failed to instantiate SLF4J LoggerFactory", localException);
      throw new IllegalStateException("Unexpected initialization failure", localException);
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      String str2 = localNoSuchMethodError.getMessage();
      if ((str2 != null) && (str2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")))
      {
        a = 2;
        f.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
        f.a("Your binding is version 1.5.5 or earlier.");
        f.a("Upgrade your binding to version 1.6.x.");
      }
      throw localNoSuchMethodError;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      String str1 = localNoClassDefFoundError.getMessage();
      int i = 0;
      if ((str1 != null) && ((str1.contains("org/slf4j/impl/StaticLoggerBinder")) || (str1.contains("org.slf4j.impl.StaticLoggerBinder")))) {
        i = 1;
      }
      if (i == 0) {
        break label184;
      }
    }
    a = 4;
    f.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
    f.a("Defaulting to no-operation (NOP) logger implementation");
    f.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
    return;
    label184:
    a = 2;
    f.a("Failed to instantiate SLF4J LoggerFactory", localNoClassDefFoundError);
    throw localNoClassDefFoundError;
  }
  
  public static void a(Set<URL> paramSet)
  {
    if (paramSet != null)
    {
      int i = paramSet.size();
      int j = 1;
      if (i <= 1) {
        j = 0;
      }
      if (j != 0)
      {
        paramSet = e.a.a.a.a.a("Actual binding is of type [");
        paramSet.append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
        paramSet.append("]");
        f.a(paramSet.toString());
      }
    }
  }
  
  public static Set<URL> b()
  {
    localLinkedHashSet = new LinkedHashSet();
    try
    {
      Object localObject = c.class.getClassLoader();
      if (localObject == null) {
        localObject = ClassLoader.getSystemResources(f);
      } else {
        localObject = ((ClassLoader)localObject).getResources(f);
      }
      while (((Enumeration)localObject).hasMoreElements()) {
        localLinkedHashSet.add((URL)((Enumeration)localObject).nextElement());
      }
      return localLinkedHashSet;
    }
    catch (IOException localIOException)
    {
      f.a("Error getting resources from path", localIOException);
    }
  }
  
  public static void b(Set<URL> paramSet)
  {
    int i = paramSet.size();
    int j = 1;
    if (i <= 1) {
      j = 0;
    }
    if (j != 0)
    {
      f.a("Class path contains multiple SLF4J bindings.");
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        URL localURL = (URL)localIterator.next();
        paramSet = new StringBuilder();
        paramSet.append("Found binding in [");
        paramSet.append(localURL);
        paramSet.append("]");
        f.a(paramSet.toString());
      }
      f.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
    }
  }
  
  public static void c()
  {
    synchronized (b)
    {
      ba = true;
      Object localObject1 = b;
      if (localObject1 != null)
      {
        Object localObject3 = new java/util/ArrayList;
        ((ArrayList)localObject3).<init>(b.values());
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (k.f.e.d)((Iterator)localObject1).next();
          y = a(x);
        }
        return;
      }
      throw null;
    }
  }
  
  public static a d()
  {
    if (a == 0) {
      try
      {
        if (a == 0)
        {
          a = 1;
          a();
          if (a == 3) {
            g();
          }
        }
      }
      finally {}
    }
    int i = a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return c;
          }
          throw new IllegalStateException("Unreachable code");
        }
        return StaticLoggerBinder.getSingleton().getLoggerFactory();
      }
      throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
    }
    return b;
  }
  
  public static boolean e()
  {
    Object localObject;
    try
    {
      String str = System.getProperty("java.vendor.url");
    }
    catch (SecurityException localSecurityException)
    {
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    return ((String)localObject).toLowerCase().contains("android");
  }
  
  public static void f()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = bc;
    int i = localLinkedBlockingQueue.size();
    ArrayList localArrayList = new ArrayList(128);
    int j = 0;
    for (;;)
    {
      if (localLinkedBlockingQueue.drainTo(localArrayList, 128) == 0) {
        return;
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (k.f.d.d)localIterator.next();
        k.f.e.d locald;
        String str;
        if (localObject != null)
        {
          locald = a;
          str = x;
          int k;
          if (y == null) {
            k = 1;
          } else {
            k = 0;
          }
          if ((k == 0) && (((y instanceof k.f.e.b)) || ((locald.g()) && (!locald.g())))) {}
        }
        try
        {
          A.invoke(y, new Object[] { localObject });
        }
        catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException localIllegalAccessException)
        {
          for (;;) {}
        }
        f.a(str);
        if (j == 0) {
          if (a.g())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("A number (");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(") of logging calls during the initialization phase have been intercepted and are");
            f.a(((StringBuilder)localObject).toString());
            f.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
            f.a("See also http://www.slf4j.org/codes.html#replay");
          }
          else if (!(a.y instanceof k.f.e.b))
          {
            f.a("The following set of substitute loggers may have been accessed");
            f.a("during the initialization phase. Logging calls during this");
            f.a("phase were not honored. However, subsequent logging calls to these");
            f.a("loggers will work as normally expected.");
            f.a("See also http://www.slf4j.org/codes.html#substituteLogger");
          }
        }
        j++;
        continue;
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
      }
      localArrayList.clear();
    }
  }
  
  public static final void g()
  {
    try
    {
      try
      {
        String str = StaticLoggerBinder.REQUESTED_API_VERSION;
        Object localObject = e;
        int i = localObject.length;
        int j = 0;
        int k = 0;
        while (j < i)
        {
          if (str.startsWith(localObject[j])) {
            k = 1;
          }
          j++;
        }
        if (k == 0)
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          ((StringBuilder)localObject).append("The requested version ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" by your slf4j binding is not compatible with ");
          ((StringBuilder)localObject).append(Arrays.asList(e).toString());
          f.a(((StringBuilder)localObject).toString());
          f.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        }
      }
      finally
      {
        f.a("Unexpected problem occured during version sanity check", localThrowable);
      }
      return;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.k.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */