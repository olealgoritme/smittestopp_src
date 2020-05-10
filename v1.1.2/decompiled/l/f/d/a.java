package l.f.d;

import java.util.Queue;

public class a
  implements l.f.b
{
  public String x;
  public l.f.e.d y;
  public Queue<d> z;
  
  public a(l.f.e.d paramd, Queue<d> paramQueue)
  {
    y = paramd;
    x = x;
    z = paramQueue;
  }
  
  public void a(String paramString)
  {
    a(b.ERROR, paramString, null, null);
  }
  
  public void a(String paramString, Object paramObject)
  {
    a(b.ERROR, paramString, new Object[] { paramObject }, null);
  }
  
  public void a(String paramString, Object paramObject1, Object paramObject2)
  {
    a(b.DEBUG, paramString, new Object[] { paramObject1, paramObject2 }, null);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    a(b.INFO, paramString, null, paramThrowable);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    a(b.TRACE, paramString, paramVarArgs, null);
  }
  
  public final void a(b paramb, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    paramb = new d();
    System.currentTimeMillis();
    a = y;
    b = paramArrayOfObject;
    Thread.currentThread().getName();
    z.add(paramb);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(String paramString)
  {
    a(b.INFO, paramString, null, null);
  }
  
  public void b(String paramString, Object paramObject)
  {
    a(b.INFO, paramString, new Object[] { paramObject }, null);
  }
  
  public void b(String paramString, Object paramObject1, Object paramObject2)
  {
    a(b.TRACE, paramString, new Object[] { paramObject1, paramObject2 }, null);
  }
  
  public void b(String paramString, Throwable paramThrowable)
  {
    a(b.WARN, paramString, null, paramThrowable);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    a(b.WARN, paramString, paramVarArgs, null);
  }
  
  public void c(String paramString)
  {
    a(b.WARN, paramString, null, null);
  }
  
  public void c(String paramString, Object paramObject)
  {
    a(b.WARN, paramString, new Object[] { paramObject }, null);
  }
  
  public void c(String paramString, Object paramObject1, Object paramObject2)
  {
    a(b.INFO, paramString, new Object[] { paramObject1, paramObject2 }, null);
  }
  
  public void c(String paramString, Throwable paramThrowable)
  {
    a(b.TRACE, paramString, null, paramThrowable);
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    a(b.ERROR, paramString, paramVarArgs, null);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d(String paramString)
  {
    a(b.TRACE, paramString, null, null);
  }
  
  public void d(String paramString, Object paramObject)
  {
    a(b.TRACE, paramString, new Object[] { paramObject }, null);
  }
  
  public void d(String paramString, Object paramObject1, Object paramObject2)
  {
    a(b.WARN, paramString, new Object[] { paramObject1, paramObject2 }, null);
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    a(b.DEBUG, paramString, null, paramThrowable);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e(String paramString)
  {
    a(b.DEBUG, paramString, null, null);
  }
  
  public void e(String paramString, Object paramObject)
  {
    a(b.DEBUG, paramString, new Object[] { paramObject }, null);
  }
  
  public void e(String paramString, Object paramObject1, Object paramObject2)
  {
    a(b.ERROR, paramString, new Object[] { paramObject1, paramObject2 }, null);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    a(b.ERROR, paramString, null, paramThrowable);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public String getName()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     l.f.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */