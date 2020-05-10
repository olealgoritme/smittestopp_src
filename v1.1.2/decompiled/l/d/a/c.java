package l.d.a;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

public class c
{
  public static volatile c s;
  public static final d t = new d();
  public static final Map<Class<?>, List<Class<?>>> u = new HashMap();
  public final Map<Class<?>, CopyOnWriteArrayList<q>> a;
  public final Map<Object, List<Class<?>>> b;
  public final Map<Class<?>, Object> c;
  public final ThreadLocal<b> d = new a();
  public final h e;
  public final l f;
  public final b g;
  public final a h;
  public final p i;
  public final ExecutorService j;
  public final boolean k;
  public final boolean l;
  public final boolean m;
  public final boolean n;
  public final boolean o;
  public final boolean p;
  public final int q;
  public final g r;
  
  public c()
  {
    f localf = null;
    if (locald != null)
    {
      if (l.d.a.r.a.b)
      {
        try
        {
          Looper localLooper = Looper.getMainLooper();
        }
        catch (RuntimeException localRuntimeException1)
        {
          localObject1 = null;
        }
        if (localObject1 != null)
        {
          localObject1 = new l.d.a.r.a("EventBus");
          break label67;
        }
      }
      Object localObject1 = new g.a();
      label67:
      r = ((g)localObject1);
      a = new HashMap();
      b = new HashMap();
      c = new ConcurrentHashMap();
      if (l.d.a.r.a.b)
      {
        try
        {
          localObject1 = Looper.getMainLooper();
        }
        catch (RuntimeException localRuntimeException2)
        {
          localObject2 = null;
        }
        if (localObject2 != null)
        {
          localObject2 = new h.a((Looper)localObject2);
          break label142;
        }
      }
      Object localObject2 = null;
      label142:
      e = ((h)localObject2);
      if (localObject2 != null) {
        localf = new f(this, a, 10);
      }
      f = localf;
      g = new b(this);
      h = new a(this);
      localObject2 = j;
      int i1;
      if (localObject2 != null) {
        i1 = ((List)localObject2).size();
      } else {
        i1 = 0;
      }
      q = i1;
      i = new p(j, h, g);
      l = a;
      m = b;
      n = c;
      o = d;
      k = e;
      p = f;
      j = i;
      return;
    }
    throw null;
  }
  
  public static List<Class<?>> a(Class<?> paramClass)
  {
    synchronized (u)
    {
      Object localObject1 = (List)u.get(paramClass);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        for (localObject2 = paramClass; localObject2 != null; localObject2 = ((Class)localObject2).getSuperclass())
        {
          ((ArrayList)localObject1).add(localObject2);
          a((List)localObject1, ((Class)localObject2).getInterfaces());
        }
        u.put(paramClass, localObject1);
        localObject2 = localObject1;
      }
      return (List<Class<?>>)localObject2;
    }
  }
  
  public static void a(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int i1 = paramArrayOfClass.length;
    for (int i2 = 0; i2 < i1; i2++)
    {
      Class<?> localClass = paramArrayOfClass[i2];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        a(paramList, localClass.getInterfaces());
      }
    }
  }
  
  public static c b()
  {
    c localc1 = s;
    c localc2 = localc1;
    if (localc1 == null) {
      try
      {
        localc1 = s;
        localc2 = localc1;
        if (localc1 == null)
        {
          localc2 = new l/d/a/c;
          localc2.<init>();
          s = localc2;
        }
      }
      finally {}
    }
    return localc3;
  }
  
  /* Error */
  public void a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	l/d/a/c:d	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 223	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 8	l/d/a/c$b
    //   10: astore_2
    //   11: aload_2
    //   12: getfield 225	l/d/a/c$b:a	Ljava/util/List;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_1
    //   18: invokeinterface 212 2 0
    //   23: pop
    //   24: aload_2
    //   25: getfield 226	l/d/a/c$b:b	Z
    //   28: ifne +83 -> 111
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 229	l/d/a/c:a	()Z
    //   36: putfield 230	l/d/a/c$b:c	Z
    //   39: aload_2
    //   40: iconst_1
    //   41: putfield 226	l/d/a/c$b:b	Z
    //   44: aload_2
    //   45: getfield 231	l/d/a/c$b:e	Z
    //   48: ifne +53 -> 101
    //   51: aload_3
    //   52: invokeinterface 234 1 0
    //   57: ifne +18 -> 75
    //   60: aload_0
    //   61: aload_3
    //   62: iconst_0
    //   63: invokeinterface 238 2 0
    //   68: aload_2
    //   69: invokevirtual 241	l/d/a/c:a	(Ljava/lang/Object;Ll/d/a/c$b;)V
    //   72: goto -21 -> 51
    //   75: aload_2
    //   76: iconst_0
    //   77: putfield 226	l/d/a/c$b:b	Z
    //   80: aload_2
    //   81: iconst_0
    //   82: putfield 230	l/d/a/c$b:c	Z
    //   85: goto +26 -> 111
    //   88: astore_1
    //   89: aload_2
    //   90: iconst_0
    //   91: putfield 226	l/d/a/c$b:b	Z
    //   94: aload_2
    //   95: iconst_0
    //   96: putfield 230	l/d/a/c$b:c	Z
    //   99: aload_1
    //   100: athrow
    //   101: new 243	l/d/a/e
    //   104: dup
    //   105: ldc -11
    //   107: invokespecial 246	l/d/a/e:<init>	(Ljava/lang/String;)V
    //   110: athrow
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	c
    //   0	112	1	paramObject	Object
    //   10	85	2	localb	b
    //   15	47	3	localList	List
    // Exception table:
    //   from	to	target	type
    //   51	72	88	finally
  }
  
  public final void a(Object paramObject, b paramb)
  {
    Class localClass = paramObject.getClass();
    Object localObject;
    if (p)
    {
      localObject = a(localClass);
      int i1 = ((List)localObject).size();
      int i2 = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i2 >= i1) {
          break;
        }
        bool1 |= a(paramObject, paramb, (Class)((List)localObject).get(i2));
        i2++;
      }
    }
    boolean bool2 = a(paramObject, paramb, localClass);
    if (!bool2)
    {
      if (m)
      {
        paramb = r;
        Level localLevel = Level.FINE;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No subscribers registered for event ");
        ((StringBuilder)localObject).append(localClass);
        paramb.a(localLevel, ((StringBuilder)localObject).toString());
      }
      if ((o) && (localClass != i.class) && (localClass != n.class)) {
        a(new i(this, paramObject));
      }
    }
  }
  
  public final void a(Object paramObject, o paramo)
  {
    Class localClass = c;
    q localq = new q(paramObject, paramo);
    Object localObject = (CopyOnWriteArrayList)a.get(localClass);
    if (localObject == null)
    {
      localObject = new CopyOnWriteArrayList();
      a.put(localClass, localObject);
    }
    else
    {
      if (((CopyOnWriteArrayList)localObject).contains(localq)) {
        break label307;
      }
    }
    int i1 = ((CopyOnWriteArrayList)localObject).size();
    int i2 = 0;
    while (i2 <= i1) {
      if ((i2 != i1) && (d <= getb.d)) {
        i2++;
      } else {
        ((CopyOnWriteArrayList)localObject).add(i2, localq);
      }
    }
    List localList = (List)b.get(paramObject);
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      b.put(paramObject, localObject);
    }
    ((List)localObject).add(localClass);
    if (e)
    {
      if (p)
      {
        paramObject = c.entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          paramo = (Map.Entry)((Iterator)paramObject).next();
          if (localClass.isAssignableFrom((Class)paramo.getKey()))
          {
            paramo = paramo.getValue();
            if (paramo != null) {
              a(localq, paramo, a());
            }
          }
        }
      }
      paramObject = c.get(localClass);
      if (paramObject != null) {
        a(localq, paramObject, a());
      }
    }
    return;
    label307:
    paramo = e.a.a.a.a.a("Subscriber ");
    paramo.append(paramObject.getClass());
    paramo.append(" already registered to event ");
    paramo.append(localClass);
    throw new e(paramo.toString());
  }
  
  public void a(j paramj)
  {
    Object localObject = a;
    q localq = b;
    j.a(paramj);
    if (c) {
      a(localq, localObject);
    }
  }
  
  public void a(q paramq, Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    try
    {
      b.a.invoke(a, new Object[] { paramObject });
    }
    catch (IllegalAccessException paramq)
    {
      throw new IllegalStateException("Unexpected exception", paramq);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localObject1 = localInvocationTargetException.getCause();
      if ((paramObject instanceof n))
      {
        if (!l) {
          break label289;
        }
        localObject2 = r;
        localObject3 = Level.SEVERE;
        localObject4 = e.a.a.a.a.a("SubscriberExceptionEvent subscriber ");
        ((StringBuilder)localObject4).append(a.getClass());
        ((StringBuilder)localObject4).append(" threw an exception");
        ((g)localObject2).a((Level)localObject3, ((StringBuilder)localObject4).toString(), (Throwable)localObject1);
        localObject2 = (n)paramObject;
        paramq = r;
        paramObject = Level.SEVERE;
        localObject1 = e.a.a.a.a.a("Initial event ");
        ((StringBuilder)localObject1).append(b);
        ((StringBuilder)localObject1).append(" caused exception in ");
        ((StringBuilder)localObject1).append(c);
        paramq.a((Level)paramObject, ((StringBuilder)localObject1).toString(), a);
        break label289;
      }
      if (k) {
        break label290;
      }
    }
    if (l)
    {
      localObject2 = r;
      localObject4 = Level.SEVERE;
      localObject3 = e.a.a.a.a.a("Could not dispatch event: ");
      ((StringBuilder)localObject3).append(paramObject.getClass());
      ((StringBuilder)localObject3).append(" to subscribing class ");
      ((StringBuilder)localObject3).append(a.getClass());
      ((g)localObject2).a((Level)localObject4, ((StringBuilder)localObject3).toString(), (Throwable)localObject1);
    }
    if (n) {
      a(new n(this, (Throwable)localObject1, paramObject, a));
    }
    label289:
    return;
    label290:
    throw new e("Invoking subscriber failed", (Throwable)localObject1);
  }
  
  public final void a(q paramq, Object paramObject, boolean paramBoolean)
  {
    int i1 = b.b.ordinal();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 == 4)
            {
              h.a(paramq, paramObject);
            }
            else
            {
              paramObject = e.a.a.a.a.a("Unknown thread mode: ");
              ((StringBuilder)paramObject).append(b.b);
              throw new IllegalStateException(((StringBuilder)paramObject).toString());
            }
          }
          else if (paramBoolean) {
            g.a(paramq, paramObject);
          } else {
            a(paramq, paramObject);
          }
        }
        else
        {
          l locall = f;
          if (locall != null) {
            locall.a(paramq, paramObject);
          } else {
            a(paramq, paramObject);
          }
        }
      }
      else if (paramBoolean) {
        a(paramq, paramObject);
      } else {
        f.a(paramq, paramObject);
      }
    }
    else {
      a(paramq, paramObject);
    }
  }
  
  public final boolean a()
  {
    h localh = e;
    boolean bool = false;
    if (localh != null)
    {
      int i1;
      if (a == Looper.myLooper()) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public final boolean a(Object paramObject, b paramb, Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	l/d/a/c:a	Ljava/util/Map;
    //   6: aload_3
    //   7: invokeinterface 182 2 0
    //   12: checkcast 304	java/util/concurrent/CopyOnWriteArrayList
    //   15: astore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: ifnull +81 -> 100
    //   22: aload_3
    //   23: invokevirtual 449	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   26: ifne +74 -> 100
    //   29: aload_3
    //   30: invokevirtual 450	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore 4
    //   35: aload 4
    //   37: invokeinterface 332 1 0
    //   42: ifeq +56 -> 98
    //   45: aload 4
    //   47: invokeinterface 335 1 0
    //   52: checkcast 300	l/d/a/q
    //   55: astore_3
    //   56: aload_2
    //   57: aload_1
    //   58: putfield 452	l/d/a/c$b:d	Ljava/lang/Object;
    //   61: aload_0
    //   62: aload_3
    //   63: aload_1
    //   64: aload_2
    //   65: getfield 230	l/d/a/c$b:c	Z
    //   68: invokevirtual 350	l/d/a/c:a	(Ll/d/a/q;Ljava/lang/Object;Z)V
    //   71: aload_2
    //   72: getfield 231	l/d/a/c$b:e	Z
    //   75: istore 5
    //   77: aload_2
    //   78: iconst_0
    //   79: putfield 231	l/d/a/c$b:e	Z
    //   82: iload 5
    //   84: ifeq -49 -> 35
    //   87: goto +11 -> 98
    //   90: astore_1
    //   91: aload_2
    //   92: iconst_0
    //   93: putfield 231	l/d/a/c$b:e	Z
    //   96: aload_1
    //   97: athrow
    //   98: iconst_1
    //   99: ireturn
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	c
    //   0	107	1	paramObject	Object
    //   0	107	2	paramb	b
    //   0	107	3	paramClass	Class<?>
    //   33	13	4	localIterator	Iterator
    //   75	8	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   61	77	90	finally
    //   2	18	102	finally
    //   103	105	102	finally
  }
  
  public void b(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    p localp = i;
    if (localp != null)
    {
      Object localObject1 = (List)p.d.get(localClass);
      if (localObject1 == null)
      {
        if (c)
        {
          localObject1 = localp.a();
          e = localClass;
          f = false;
          g = null;
          while (e != null)
          {
            localp.a((p.a)localObject1);
            ((p.a)localObject1).a();
          }
          localObject1 = localp.b((p.a)localObject1);
        }
        else
        {
          p.a locala = localp.a();
          e = localClass;
          f = false;
          g = null;
          while (e != null)
          {
            localObject1 = g;
            Object localObject2;
            if ((localObject1 != null) && (((l.d.a.s.a)localObject1).c() != null))
            {
              localObject1 = g.c();
              if (e == ((l.d.a.s.a)localObject1).b()) {}
            }
            else
            {
              localObject1 = a;
              if (localObject1 != null)
              {
                localObject2 = ((List)localObject1).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject1 = ((l.d.a.s.b)((Iterator)localObject2).next()).a(e);
                  if (localObject1 != null) {
                    break label247;
                  }
                }
              }
              localObject1 = null;
            }
            label247:
            g = ((l.d.a.s.a)localObject1);
            if (localObject1 != null) {
              for (localObject1 : ((l.d.a.s.a)localObject1).a()) {
                if (locala.a(a, c)) {
                  a.add(localObject1);
                }
              }
            }
            localp.a(locala);
            locala.a();
          }
          localObject1 = localp.b(locala);
        }
        if (!((List)localObject1).isEmpty()) {
          p.d.put(localClass, localObject1);
        }
      }
      else
      {
        try
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            a(paramObject, (o)((Iterator)localObject1).next());
          }
          return;
        }
        finally {}
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Subscriber ");
      ((StringBuilder)paramObject).append(localClass);
      ((StringBuilder)paramObject).append(" and its super classes have no public methods with the @Subscribe annotation");
      throw new e(((StringBuilder)paramObject).toString());
    }
    throw null;
  }
  
  public void c(Object paramObject)
  {
    try
    {
      Object localObject1 = (List)b.get(paramObject);
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Class)((Iterator)localObject1).next();
          localObject3 = (List)a.get(localObject2);
          if (localObject3 != null)
          {
            int i1 = ((List)localObject3).size();
            int i2 = 0;
            while (i2 < i1)
            {
              localObject2 = (q)((List)localObject3).get(i2);
              int i3 = i1;
              int i4 = i2;
              if (a == paramObject)
              {
                c = false;
                ((List)localObject3).remove(i2);
                i4 = i2 - 1;
                i3 = i1 - 1;
              }
              i2 = i4 + 1;
              i1 = i3;
            }
          }
        }
        b.remove(paramObject);
      }
      else
      {
        localObject2 = r;
        localObject1 = Level.WARNING;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append("Subscriber to unregister was not registered before: ");
        ((StringBuilder)localObject3).append(paramObject.getClass());
        ((g)localObject2).a((Level)localObject1, ((StringBuilder)localObject3).toString());
      }
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("EventBus[indexCount=");
    localStringBuilder.append(q);
    localStringBuilder.append(", eventInheritance=");
    localStringBuilder.append(p);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public class a
    extends ThreadLocal<c.b>
  {
    public a() {}
    
    public Object initialValue()
    {
      return new c.b();
    }
  }
  
  public static final class b
  {
    public final List<Object> a = new ArrayList();
    public boolean b;
    public boolean c;
    public Object d;
    public boolean e;
  }
}

/* Location:
 * Qualified Name:     l.d.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */