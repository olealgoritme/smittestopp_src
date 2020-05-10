package d.u;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import android.os.Looper;
import d.w.a.c;
import d.w.a.f.a;
import d.w.a.f.f;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import no.simula.corona.MeasurementDatabase_Impl;

public abstract class g
{
  @Deprecated
  public volatile d.w.a.b a;
  public Executor b;
  public c c;
  public final e d;
  public boolean e;
  public boolean f;
  @Deprecated
  public List<g.b> g;
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
    if (paramCancellationSignal != null)
    {
      a locala = (a)c.a();
      return x.rawQueryWithFactory(new d.w.a.f.b(locala, parame), parame.a(), a.y, null, paramCancellationSignal);
    }
    return ((a)c.a()).a(parame);
  }
  
  public f a(String paramString)
  {
    a();
    b();
    return new f(c.a()).x.compileStatement(paramString));
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
    d.w.a.b localb = c.a();
    d.b(localb);
    x.beginTransaction();
  }
  
  @Deprecated
  public void d()
  {
    c.a()).x.endTransaction();
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
    return c.a()).x.inTransaction();
  }
  
  public boolean f()
  {
    d.w.a.b localb = a;
    boolean bool;
    if ((localb != null) && (x.isOpen())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Deprecated
  public void g()
  {
    c.a()).x.setTransactionSuccessful();
  }
}

/* Location:
 * Qualified Name:     base.d.u.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */