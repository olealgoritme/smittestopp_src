package k.b.a.v.e;

import android.content.Context;
import i.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import l.d.b.f;
import m.a.a.b;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;
import no.simula.corona.data.greendao.BluetoothContactDao.Properties;
import no.simula.corona.data.greendao.MeasurementDao.Properties;

public final class d
  implements k.b.a.v.a
{
  public static Semaphore d = new Semaphore(1);
  public static Semaphore e = new Semaphore(1);
  public Context a;
  public c b;
  public l.d.b.g.a c;
  
  public d(Context paramContext) {}
  
  /* Error */
  public final <T> T a(a<T> parama, T paramT)
  {
    // Byte code:
    //   0: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   3: invokevirtual 79	java/util/concurrent/Semaphore:acquire	()V
    //   6: aload_1
    //   7: invokeinterface 83 1 0
    //   12: astore_3
    //   13: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   16: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   19: aload_3
    //   20: areturn
    //   21: astore_1
    //   22: goto +56 -> 78
    //   25: astore_1
    //   26: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   29: aload_1
    //   30: invokevirtual 96	m/a/a$b:a	(Ljava/lang/Throwable;)V
    //   33: goto +37 -> 70
    //   36: astore_3
    //   37: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   40: ldc 98
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokevirtual 101	m/a/a$b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload_0
    //   50: invokevirtual 104	k/b/a/v/e/d:close	()V
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 55	k/b/a/v/e/d:a	Landroid/content/Context;
    //   58: invokevirtual 57	k/b/a/v/e/d:a	(Landroid/content/Context;)V
    //   61: aload_1
    //   62: invokeinterface 83 1 0
    //   67: astore_1
    //   68: aload_1
    //   69: astore_2
    //   70: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   73: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   76: aload_2
    //   77: areturn
    //   78: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   81: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: goto -17 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	d
    //   0	90	1	parama	a<T>
    //   0	90	2	paramT	T
    //   12	8	3	localObject	Object
    //   36	1	3	localSQLiteException	net.sqlcipher.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	13	21	finally
    //   26	33	21	finally
    //   37	61	21	finally
    //   61	68	21	finally
    //   0	13	25	java/lang/Exception
    //   0	13	36	net/sqlcipher/database/SQLiteException
    //   61	68	86	java/lang/Exception
  }
  
  public void a()
  {
    a(new d(this));
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      e.acquire();
      Object localObject = new k/b/a/v/e/b$a;
      ((b.a)localObject).<init>(paramContext, "measurement_database_encrypted");
      if (k.b.a.y.b.a == null) {
        k.b.a.y.b.a = k.b.a.y.b.a(paramContext, "alias_db");
      }
      String str = k.b.a.y.b.a;
      if (A == null)
      {
        paramContext = new l/d/b/g/b$a;
        paramContext.<init>((l.d.b.g.b)localObject, x, y, z, B);
        A = paramContext;
      }
      localObject = A.getWritableDatabase(str);
      paramContext = new l/d/b/g/d;
      paramContext.<init>((SQLiteDatabase)localObject);
      i.k.b.g.a(paramContext, "helper.getEncryptedWrita…etSecureValueDB(context))");
      c = paramContext;
      localObject = new k/b/a/v/e/b;
      ((b)localObject).<init>(paramContext);
      paramContext = new k/b/a/v/e/c;
      paramContext.<init>(a, l.d.b.h.d.Session, b);
      i.k.b.g.a(paramContext, "DaoMaster(mDatabase).newSession()");
      b = paramContext;
      return;
    }
    finally
    {
      e.release();
    }
  }
  
  /* Error */
  public final void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   3: invokevirtual 79	java/util/concurrent/Semaphore:acquire	()V
    //   6: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   9: ldc -57
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokevirtual 201	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_1
    //   19: invokeinterface 205 1 0
    //   24: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   27: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   30: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   33: ldc -49
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokevirtual 201	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: goto +96 -> 138
    //   45: astore_1
    //   46: goto +93 -> 139
    //   49: astore_1
    //   50: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   53: aload_1
    //   54: invokevirtual 96	m/a/a$b:a	(Ljava/lang/Throwable;)V
    //   57: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   60: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   63: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   66: ldc -49
    //   68: iconst_0
    //   69: anewarray 4	java/lang/Object
    //   72: invokevirtual 201	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: goto +63 -> 138
    //   78: astore_2
    //   79: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   82: ldc 98
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokevirtual 101	m/a/a$b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: invokevirtual 104	k/b/a/v/e/d:close	()V
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 55	k/b/a/v/e/d:a	Landroid/content/Context;
    //   100: invokevirtual 57	k/b/a/v/e/d:a	(Landroid/content/Context;)V
    //   103: aload_1
    //   104: invokeinterface 205 1 0
    //   109: goto +11 -> 120
    //   112: astore_1
    //   113: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   116: aload_1
    //   117: invokevirtual 96	m/a/a$b:a	(Ljava/lang/Throwable;)V
    //   120: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   123: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   126: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   129: ldc -49
    //   131: iconst_0
    //   132: anewarray 4	java/lang/Object
    //   135: invokevirtual 201	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: return
    //   139: getstatic 47	k/b/a/v/e/d:d	Ljava/util/concurrent/Semaphore;
    //   142: invokevirtual 86	java/util/concurrent/Semaphore:release	()V
    //   145: getstatic 91	m/a/a:d	Lm/a/a$b;
    //   148: ldc -49
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokevirtual 201	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	d
    //   0	159	1	paramRunnable	Runnable
    //   78	1	2	localSQLiteException	net.sqlcipher.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   0	24	45	finally
    //   50	57	45	finally
    //   79	103	45	finally
    //   103	109	45	finally
    //   113	120	45	finally
    //   0	24	49	java/lang/Exception
    //   0	24	78	net/sqlcipher/database/SQLiteException
    //   103	109	112	java/lang/Exception
  }
  
  public void a(final List<Long> paramList)
  {
    if (paramList != null)
    {
      a(new h(this, paramList));
      return;
    }
    i.k.b.g.a("ids");
    throw null;
  }
  
  public void a(final k.b.a.v.g.a parama)
  {
    if (parama != null)
    {
      a(new f(this, parama));
      return;
    }
    i.k.b.g.a("bluetoothContact");
    throw null;
  }
  
  public void a(final k.b.a.v.g.b paramb)
  {
    if (paramb != null)
    {
      a(new g(this, paramb));
      return;
    }
    i.k.b.g.a("measurement");
    throw null;
  }
  
  public List<k.b.a.v.g.b> b()
  {
    return (List)a(new k(this), new ArrayList());
  }
  
  public void b(final List<Long> paramList)
  {
    if (paramList != null)
    {
      a(new i(this, paramList));
      return;
    }
    i.k.b.g.a("ids");
    throw null;
  }
  
  public void c()
  {
    a(new e(this));
  }
  
  public void close()
  {
    try
    {
      l.d.b.g.a locala = c;
      if (locala != null)
      {
        locala.close();
      }
      else
      {
        i.k.b.g.b("mDatabase");
        throw null;
      }
    }
    catch (Exception localException)
    {
      m.a.a.d.b(localException);
    }
  }
  
  public List<k.b.a.v.g.a> d()
  {
    return (List)a(new j(this), new ArrayList());
  }
  
  public void e()
  {
    a(new b(this));
  }
  
  public void f()
  {
    a(new c(this));
  }
  
  public static abstract interface a<T>
  {
    public abstract T run();
  }
  
  public static final class b
    implements Runnable
  {
    public void run()
    {
      ax).e.a();
      l.d.b.h.a locala = ax).e.d;
      if (locala != null) {
        locala.clear();
      }
    }
  }
  
  public static final class c
    implements Runnable
  {
    public void run()
    {
      ax).d.a();
      l.d.b.h.a locala = ax).d.d;
      if (locala != null) {
        locala.clear();
      }
    }
  }
  
  public static final class d
    implements Runnable
  {
    public void run()
    {
      Object localObject = ax).e;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(BluetoothContactDao.Properties.IsUploaded.a(Boolean.valueOf(true)), new l.d.b.j.i[0]);
        ((l.d.b.j.g)localObject).a().b().a();
        c localc = d.a(x);
        localObject = b.G;
        if (localObject != null) {
          ((l.d.b.h.a)localObject).clear();
        }
        localObject = c.G;
        if (localObject != null) {
          ((l.d.b.h.a)localObject).clear();
        }
        return;
      }
      throw null;
    }
  }
  
  public static final class e
    implements Runnable
  {
    public void run()
    {
      Object localObject = ax).d;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(MeasurementDao.Properties.IsUploaded.a(Boolean.valueOf(true)), new l.d.b.j.i[0]);
        ((l.d.b.j.g)localObject).a().b().a();
        localObject = d.a(x);
        l.d.b.h.a locala = b.G;
        if (locala != null) {
          locala.clear();
        }
        localObject = c.G;
        if (localObject != null) {
          ((l.d.b.h.a)localObject).clear();
        }
        return;
      }
      throw null;
    }
  }
  
  public static final class f
    implements Runnable
  {
    public f(k.b.a.v.g.a parama) {}
    
    public void run()
    {
      ax).e.b(k.b.a.v.g.a.a(parama));
    }
  }
  
  public static final class g
    implements Runnable
  {
    public g(k.b.a.v.g.b paramb) {}
    
    public void run()
    {
      ax).d.b(k.b.a.v.g.b.a(paramb));
    }
  }
  
  public static final class h
    implements Runnable
  {
    public h(List paramList) {}
    
    public void run()
    {
      Object localObject = ax).e;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(BluetoothContactDao.Properties.Id.a(paramList), new l.d.b.j.i[0]);
        List localList = ((l.d.b.j.g)localObject).b();
        i.k.b.g.a(localList, "entities");
        localObject = new ArrayList(e.c.a.a.b.l.c.a(localList, 10));
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          i.k.b.g.a(locala, "it");
          f = Boolean.valueOf(true);
          ((Collection)localObject).add(h.a);
        }
        ax).e.a(localList);
        return;
      }
      throw null;
    }
  }
  
  public static final class i
    implements Runnable
  {
    public i(List paramList) {}
    
    public void run()
    {
      Object localObject = ax).d;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(MeasurementDao.Properties.Id.a(paramList), new l.d.b.j.i[0]);
        List localList = ((l.d.b.j.g)localObject).b();
        i.k.b.g.a(localList, "entities");
        localObject = new ArrayList(e.c.a.a.b.l.c.a(localList, 10));
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          i.k.b.g.a(locali, "it");
          j = Boolean.valueOf(true);
          ((Collection)localObject).add(h.a);
        }
        ax).d.a(localList);
        return;
      }
      throw null;
    }
  }
  
  public static final class j
    implements d.a<List<? extends k.b.a.v.g.a>>
  {
    public Object run()
    {
      Object localObject = aa).e;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(BluetoothContactDao.Properties.IsUploaded.a(Boolean.valueOf(false)), new l.d.b.j.i[0]);
        localObject = ((l.d.b.j.g)localObject).b();
        i.k.b.g.a(localObject, "mSession.bluetoothContac…ploaded.eq(false)).list()");
        return k.b.a.v.g.a.b((List)localObject);
      }
      throw null;
    }
  }
  
  public static final class k
    implements d.a<List<? extends k.b.a.v.g.b>>
  {
    public Object run()
    {
      Object localObject = aa).d;
      if (localObject != null)
      {
        localObject = new l.d.b.j.g((l.d.b.a)localObject);
        ((l.d.b.j.g)localObject).a(MeasurementDao.Properties.IsUploaded.a(Boolean.valueOf(false)), new l.d.b.j.i[0]);
        localObject = ((l.d.b.j.g)localObject).b();
        i.k.b.g.a(localObject, "mSession.measurementDao.…ploaded.eq(false)).list()");
        return k.b.a.v.g.b.b((List)localObject);
      }
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */