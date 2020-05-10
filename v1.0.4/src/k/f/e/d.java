package k.f.e;

import java.lang.reflect.Method;
import java.util.Queue;
import k.f.d.a;
import k.f.d.c;

public class d
  implements k.f.b
{
  public Method A;
  public a B;
  public Queue<k.f.d.d> C;
  public final boolean D;
  public final String x;
  public volatile k.f.b y;
  public Boolean z;
  
  public d(String paramString, Queue<k.f.d.d> paramQueue, boolean paramBoolean)
  {
    x = paramString;
    C = paramQueue;
    D = paramBoolean;
  }
  
  public void a(String paramString)
  {
    c().a(paramString);
  }
  
  public void a(String paramString, Object paramObject)
  {
    c().a(paramString, paramObject);
  }
  
  public void a(String paramString, Object paramObject1, Object paramObject2)
  {
    c().a(paramString, paramObject1, paramObject2);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    c().a(paramString, paramThrowable);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    c().a(paramString, paramVarArgs);
  }
  
  public boolean a()
  {
    return c().a();
  }
  
  public void b(String paramString)
  {
    c().b(paramString);
  }
  
  public void b(String paramString, Object paramObject)
  {
    c().b(paramString, paramObject);
  }
  
  public void b(String paramString, Object paramObject1, Object paramObject2)
  {
    c().b(paramString, paramObject1, paramObject2);
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    c().b(paramString, paramThrowable);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    c().b(paramString, paramVarArgs);
  }
  
  public boolean b()
  {
    return c().b();
  }
  
  public k.f.b c()
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
  
  public void c(String paramString)
  {
    c().c(paramString);
  }
  
  public void c(String paramString, Object paramObject)
  {
    c().c(paramString, paramObject);
  }
  
  public void c(String paramString, Object paramObject1, Object paramObject2)
  {
    c().c(paramString, paramObject1, paramObject2);
  }
  
  public void c(String paramString, Throwable paramThrowable)
  {
    c().c(paramString, paramThrowable);
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    c().c(paramString, paramVarArgs);
  }
  
  public void d(String paramString)
  {
    c().d(paramString);
  }
  
  public void d(String paramString, Object paramObject)
  {
    c().d(paramString, paramObject);
  }
  
  public void d(String paramString, Object paramObject1, Object paramObject2)
  {
    c().d(paramString, paramObject1, paramObject2);
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    c().d(paramString, paramThrowable);
  }
  
  public boolean d()
  {
    return c().d();
  }
  
  public void e(String paramString)
  {
    c().e(paramString);
  }
  
  public void e(String paramString, Object paramObject)
  {
    c().e(paramString, paramObject);
  }
  
  public void e(String paramString, Object paramObject1, Object paramObject2)
  {
    c().e(paramString, paramObject1, paramObject2);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    c().e(paramString, paramThrowable);
  }
  
  public boolean e()
  {
    return c().e();
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
    return c().f();
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
 * Qualified Name:     base.k.f.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */