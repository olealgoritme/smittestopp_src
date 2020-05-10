package d.u;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import d.w.a.b;
import d.w.a.c.a;
import d.w.a.c.b;
import d.w.a.c.c;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import no.simula.corona.data.legacy.MeasurementDatabase_Impl;

public abstract class g
{
  @Deprecated
  public volatile b a;
  public Executor b;
  public d.w.a.c c;
  public final e d;
  public boolean e;
  public boolean f;
  @Deprecated
  public List<b> g;
  public final ReentrantReadWriteLock h = new ReentrantReadWriteLock();
  public final ThreadLocal<Integer> i = new ThreadLocal();
  
  public g()
  {
    new ConcurrentHashMap();
    d = new e((MeasurementDatabase_Impl)this, new HashMap(0), new HashMap(0), new String[] { "Measurement", "BluetoothContact" });
  }
  
  public Cursor a(d.w.a.e parame, CancellationSignal paramCancellationSignal)
  {
    a();
    b();
    if (paramCancellationSignal != null) {
      return c.getWritableDatabase().query(parame, paramCancellationSignal);
    }
    return c.getWritableDatabase().query(parame);
  }
  
  public d.w.a.f a(String paramString)
  {
    a();
    b();
    return c.getWritableDatabase().compileStatement(paramString);
  }
  
  public void a()
  {
    if (e) {
      return;
    }
    int j;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return;
    }
    throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
  }
  
  public void b()
  {
    if ((!e()) && (i.get() != null)) {
      throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }
  }
  
  @Deprecated
  public void c()
  {
    a();
    b localb = c.getWritableDatabase();
    d.b(localb);
    localb.beginTransaction();
  }
  
  @Deprecated
  public void d()
  {
    c.getWritableDatabase().endTransaction();
    if (!e())
    {
      e locale = d;
      if (e.compareAndSet(false, true)) {
        d.b.execute(j);
      }
    }
  }
  
  public boolean e()
  {
    return c.getWritableDatabase().inTransaction();
  }
  
  @Deprecated
  public void f()
  {
    c.getWritableDatabase().setTransactionSuccessful();
  }
  
  public static class a<T extends g>
  {
    public final Class<T> a;
    public final String b;
    public final Context c;
    public Executor d;
    public Executor e;
    public c.c f;
    public boolean g;
    public g.c h;
    public boolean i;
    public boolean j;
    public final g.d k;
    
    public a(Context paramContext, Class<T> paramClass, String paramString)
    {
      c = paramContext;
      a = paramClass;
      b = paramString;
      h = g.c.AUTOMATIC;
      i = true;
      k = new g.d();
    }
    
    @SuppressLint({"RestrictedApi"})
    public T a()
    {
      if (c != null)
      {
        if (a != null)
        {
          if ((d == null) && (e == null))
          {
            localObject1 = d.c.a.a.a.d;
            e = ((Executor)localObject1);
            d = ((Executor)localObject1);
          }
          else
          {
            localObject1 = d;
            if ((localObject1 != null) && (e == null))
            {
              e = ((Executor)localObject1);
            }
            else if (d == null)
            {
              localObject1 = e;
              if (localObject1 != null) {
                d = ((Executor)localObject1);
              }
            }
          }
          if (f == null) {
            f = new d.w.a.g.c();
          }
          Object localObject1 = c;
          a locala = new a((Context)localObject1, b, f, k, null, g, h.resolve((Context)localObject1), d, e, false, i, j, null, null, null);
          Object localObject2 = a;
          String str = ((Class)localObject2).getPackage().getName();
          localObject1 = ((Class)localObject2).getCanonicalName();
          boolean bool1 = str.isEmpty();
          boolean bool2 = true;
          if (!bool1) {
            localObject1 = ((String)localObject1).substring(str.length() + 1);
          }
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((String)localObject1).replace('.', '_'));
          ((StringBuilder)localObject3).append("_Impl");
          localObject3 = ((StringBuilder)localObject3).toString();
          try
          {
            if (str.isEmpty())
            {
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = new java/lang/StringBuilder;
              ((StringBuilder)localObject1).<init>();
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append((String)localObject3);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            localObject1 = Class.forName((String)localObject1).newInstance();
            localObject1 = (g)localObject1;
            if (localObject1 != null)
            {
              localObject3 = new h(locala, new k.b.a.v.f.h((MeasurementDatabase_Impl)localObject1, 7), "8260d2f713a01361d6ce911d0c7159cc", "d0c844f687e96ba35d4d3a97249d2973");
              localObject2 = b;
              str = c;
              if (localObject2 != null)
              {
                localObject3 = new c.b((Context)localObject2, str, (c.a)localObject3);
                localObject3 = a.create((c.b)localObject3);
                c = ((d.w.a.c)localObject3);
                if ((localObject3 instanceof j)) {
                  f = locala;
                }
                if (g != g.c.WRITE_AHEAD_LOGGING) {
                  bool2 = false;
                }
                c.setWriteAheadLoggingEnabled(bool2);
                g = e;
                b = h;
                new ArrayDeque();
                e = f;
                f = bool2;
                if (j)
                {
                  localObject3 = d;
                  new f(b, c, (e)localObject3, d.b);
                }
                return (T)localObject1;
              }
              throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            }
            throw null;
          }
          catch (InstantiationException localInstantiationException)
          {
            StringBuilder localStringBuilder1 = e.a.a.a.a.a("Failed to create an instance of ");
            localStringBuilder1.append(((Class)localObject2).getCanonicalName());
            throw new RuntimeException(localStringBuilder1.toString());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            StringBuilder localStringBuilder2 = e.a.a.a.a.a("Cannot access the constructor");
            localStringBuilder2.append(((Class)localObject2).getCanonicalName());
            throw new RuntimeException(localStringBuilder2.toString());
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            StringBuilder localStringBuilder3 = e.a.a.a.a.a("cannot find implementation for ");
            localStringBuilder3.append(((Class)localObject2).getCanonicalName());
            localStringBuilder3.append(". ");
            localStringBuilder3.append((String)localObject3);
            localStringBuilder3.append(" does not exist");
            throw new RuntimeException(localStringBuilder3.toString());
          }
        }
        throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
      }
      throw new IllegalArgumentException("Cannot provide null context for the database.");
    }
  }
  
  public static abstract class b
  {
    public void a() {}
    
    public void b() {}
    
    public void c() {}
  }
  
  public static enum c
  {
    static
    {
      c localc = new c("WRITE_AHEAD_LOGGING", 2);
      WRITE_AHEAD_LOGGING = localc;
      $VALUES = new c[] { AUTOMATIC, TRUNCATE, localc };
    }
    
    public c() {}
    
    public static boolean isLowRamDevice(ActivityManager paramActivityManager)
    {
      return paramActivityManager.isLowRamDevice();
    }
    
    @SuppressLint({"NewApi"})
    public c resolve(Context paramContext)
    {
      if (this != AUTOMATIC) {
        return this;
      }
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext != null) && (!isLowRamDevice(paramContext))) {
        return WRITE_AHEAD_LOGGING;
      }
      return TRUNCATE;
    }
  }
  
  public static class d
  {
    public HashMap<Integer, TreeMap<Integer, d.u.l.a>> a = new HashMap();
  }
}

/* Location:
 * Qualified Name:     d.u.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */