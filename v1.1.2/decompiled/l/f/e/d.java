package l.f.e;

import java.lang.reflect.Method;
import java.util.Queue;
import l.f.d.a;
import l.f.d.c;

public class d
  implements l.f.b
{
  public Method A;
  public a B;
  public Queue<l.f.d.d> C;
  public final boolean D;
  public final String x;
  public volatile l.f.b y;
  public Boolean z;
  
  public d(String paramString, Queue<l.f.d.d> paramQueue, boolean paramBoolean)
  {
    x = paramString;
    C = paramQueue;
    D = paramBoolean;
  }
  
  public void a(String paramString)
  {
    b().a(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    b().a(paramString, paramObject);
  }
  
  public void a(String paramString, Object paramObject1, Object paramObject2)
  {
    b().a(paramString, paramObject1, paramObject2);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    b().a(paramString, paramThrowable);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    b().a(paramString, paramVarArgs);
  }
  
  public boolean a()
  {
    return b().a();
  }
  
  public l.f.b b()
  {
    if (y != null) {
      return y;
    }
    if (D) {
      return b.x;
    }
    if (B == null) {
      B = new a(this, C);
    }
    return B;
  }
  
  public void b(String paramString)
  {
    b().b(paramString);
  }
  
  public void b(String paramString, Object paramObject)
  {
    b().b(paramString, paramObject);
  }
  
  public void b(String paramString, Object paramObject1, Object paramObject2)
  {
    b().b(paramString, paramObject1, paramObject2);
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    b().b(paramString, paramThrowable);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    b().b(paramString, paramVarArgs);
  }
  
  public void c(String paramString)
  {
    b().c(paramString);
  }
  
  public void c(String paramString, Object paramObject)
  {
    b().c(paramString, paramObject);
  }
  
  public void c(String paramString, Object paramObject1, Object paramObject2)
  {
    b().c(paramString, paramObject1, paramObject2);
  }
  
  public void c(String paramString, Throwable paramThrowable)
  {
    b().c(paramString, paramThrowable);
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    b().c(paramString, paramVarArgs);
  }
  
  public boolean c()
  {
    return b().c();
  }
  
  public void d(String paramString)
  {
    b().d(paramString);
  }
  
  public void d(String paramString, Object paramObject)
  {
    b().d(paramString, paramObject);
  }
  
  public void d(String paramString, Object paramObject1, Object paramObject2)
  {
    b().d(paramString, paramObject1, paramObject2);
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    b().d(paramString, paramThrowable);
  }
  
  public boolean d()
  {
    return b().d();
  }
  
  public void e(String paramString)
  {
    b().e(paramString);
  }
  
  public void e(String paramString, Object paramObject)
  {
    b().e(paramString, paramObject);
  }
  
  public void e(String paramString, Object paramObject1, Object paramObject2)
  {
    b().e(paramString, paramObject1, paramObject2);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    b().e(paramString, paramThrowable);
  }
  
  public boolean e()
  {
    return b().e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      paramObject = (d)paramObject;
      return x.equals(x);
    }
    return false;
  }
  
  public boolean f()
  {
    return b().f();
  }
  
  public boolean g()
  {
    Boolean localBoolean = z;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    try
    {
      A = y.getClass().getMethod("log", new Class[] { c.class });
      z = Boolean.TRUE;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      z = Boolean.FALSE;
    }
    return z.booleanValue();
  }
  
  public String getName()
  {
    return x;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
}

/* Location:
 * Qualified Name:     l.f.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */