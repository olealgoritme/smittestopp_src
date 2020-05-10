package e.c.a.a.b.j;

import android.accounts.Account;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import e.c.a.a.b.a;
import e.c.a.a.b.e;
import e.c.a.a.b.i.k.c.a;
import e.c.a.a.b.i.k.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class b<T extends IInterface>
{
  public static final e.c.a.a.b.c[] u = new e.c.a.a.b.c[0];
  public f0 a;
  public final Context b;
  public final i c;
  public final Handler d;
  public final Object e = new Object();
  public final Object f = new Object();
  @GuardedBy("mServiceBrokerLock")
  public n g;
  public b.c h;
  @GuardedBy("mLock")
  public T i;
  public final ArrayList<b.h<?>> j = new ArrayList();
  @GuardedBy("mLock")
  public b.j k;
  @GuardedBy("mLock")
  public int l = 1;
  public final b.a m;
  public final b.b n;
  public final int o;
  public final String p;
  public a q = null;
  public boolean r = false;
  public volatile z s = null;
  public AtomicInteger t = new AtomicInteger(0);
  
  public b(Context paramContext, Looper paramLooper, i parami, e parame, int paramInt, b.a parama, b.b paramb, String paramString)
  {
    d.b.a.r.b(paramContext, "Context must not be null");
    b = ((Context)paramContext);
    d.b.a.r.b(paramLooper, "Looper must not be null");
    paramContext = (Looper)paramLooper;
    d.b.a.r.b(parami, "Supervisor must not be null");
    c = ((i)parami);
    d.b.a.r.b(parame, "API availability must not be null");
    paramContext = (e)parame;
    d = new b.g(this, paramLooper);
    o = paramInt;
    m = parama;
    n = paramb;
    p = paramString;
  }
  
  public abstract T a(IBinder paramIBinder);
  
  public void a(int paramInt, T paramT) {}
  
  public void a(b.c paramc)
  {
    d.b.a.r.b(paramc, "Connection progress callbacks cannot be null.");
    h = ((b.c)paramc);
    b(2, null);
  }
  
  public void a(b.e parame)
  {
    parame = (q)parame;
    a.m.m.post(new e.c.a.a.b.i.k.r(parame));
  }
  
  public void a(k arg1, Set<Scope> paramSet)
  {
    Object localObject = j();
    g localg = new g(o);
    A = b.getPackageName();
    D = ((Bundle)localObject);
    if (paramSet != null) {
      C = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
    }
    if (g())
    {
      paramSet = w;
      if (paramSet == null) {
        paramSet = new Account("<<default account>>", "com.google");
      }
      E = paramSet;
      if (??? != null) {
        B = ???.asBinder();
      }
    }
    ??? = u;
    F = ???;
    G = ???;
    try
    {
      try
      {
        synchronized (f)
        {
          if (g != null)
          {
            localObject = g;
            paramSet = new e/c/a/a/b/j/b$i;
            paramSet.<init>(this, t.get());
            ((n)localObject).a(paramSet, localg);
          }
          else
          {
            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
          }
          return;
        }
        Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      }
      catch (RuntimeException ???) {}catch (RemoteException ???) {}
      int i1 = t.get();
      ??? = d;
      ???.sendMessage(???.obtainMessage(1, i1, -1, new b.k(this, 8, null, null)));
      return;
    }
    catch (SecurityException ???)
    {
      throw ???;
    }
    catch (DeadObjectException ???)
    {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      ??? = d;
      ???.sendMessage(???.obtainMessage(6, t.get(), 1));
    }
  }
  
  public boolean a()
  {
    synchronized (e)
    {
      boolean bool;
      if ((l != 2) && (l != 3)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (e)
    {
      if (l != paramInt1) {
        return false;
      }
      b(paramInt2, paramT);
      return true;
    }
  }
  
  public final void b(int paramInt, T paramT)
  {
    int i1;
    if (paramInt == 4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramT != null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool;
    if (i1 == i2) {
      bool = true;
    } else {
      bool = false;
    }
    d.b.a.r.a(bool);
    synchronized (e)
    {
      l = paramInt;
      i = paramT;
      a(paramInt, paramT);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            System.currentTimeMillis();
          }
        }
        else
        {
          if ((k != null) && (a != null))
          {
            paramT = a.a;
            localObject2 = a.b;
            i1 = String.valueOf(paramT).length();
            paramInt = String.valueOf(localObject2).length();
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>(i1 + 70 + paramInt);
            ((StringBuilder)localObject3).append("Calling connect() while still connected, missing disconnect() for ");
            ((StringBuilder)localObject3).append(paramT);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Log.e("GmsClient", ((StringBuilder)localObject3).toString());
            localObject4 = c;
            paramT = a.a;
            localObject5 = a.b;
            paramInt = a.c;
            localObject2 = k;
            localObject6 = n();
            if (localObject4 != null)
            {
              localObject3 = new e/c/a/a/b/j/i$a;
              ((i.a)localObject3).<init>(paramT, (String)localObject5, paramInt);
              ((i)localObject4).b((i.a)localObject3, (ServiceConnection)localObject2, (String)localObject6);
              t.incrementAndGet();
            }
            else
            {
              throw null;
            }
          }
          paramT = new e/c/a/a/b/j/b$j;
          paramT.<init>(this, t.get());
          k = paramT;
          localObject4 = new e/c/a/a/b/j/f0;
          ((f0)localObject4).<init>("com.google.android.gms", m(), false);
          a = ((f0)localObject4);
          localObject3 = c;
          localObject2 = a;
          paramT = b;
          paramInt = c;
          localObject6 = k;
          localObject4 = n();
          localObject5 = new e/c/a/a/b/j/i$a;
          ((i.a)localObject5).<init>((String)localObject2, paramT, paramInt);
          if (!((i)localObject3).a((i.a)localObject5, (ServiceConnection)localObject6, (String)localObject4))
          {
            localObject3 = a.a;
            localObject2 = a.b;
            paramInt = String.valueOf(localObject3).length();
            i1 = String.valueOf(localObject2).length();
            paramT = new java/lang/StringBuilder;
            paramT.<init>(paramInt + 34 + i1);
            paramT.append("unable to connect to service: ");
            paramT.append((String)localObject3);
            paramT.append(" on ");
            paramT.append((String)localObject2);
            Log.e("GmsClient", paramT.toString());
            paramInt = t.get();
            paramT = d;
            localObject3 = new e/c/a/a/b/j/b$l;
            ((b.l)localObject3).<init>(this, 16);
            paramT.sendMessage(paramT.obtainMessage(7, paramInt, -1, localObject3));
          }
        }
      }
      else if (k != null)
      {
        localObject2 = c;
        localObject3 = a.a;
        localObject6 = a.b;
        paramInt = a.c;
        localObject4 = k;
        paramT = n();
        if (localObject2 != null)
        {
          localObject5 = new e/c/a/a/b/j/i$a;
          ((i.a)localObject5).<init>((String)localObject3, (String)localObject6, paramInt);
          ((i)localObject2).b((i.a)localObject5, (ServiceConnection)localObject4, paramT);
          k = null;
        }
        else
        {
          throw null;
        }
      }
      return;
    }
  }
  
  public final e.c.a.a.b.c[] b()
  {
    z localz = s;
    if (localz == null) {
      return null;
    }
    return y;
  }
  
  public boolean c()
  {
    synchronized (e)
    {
      boolean bool;
      if (l == 4) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public String d()
  {
    if (c())
    {
      f0 localf0 = a;
      if (localf0 != null) {
        return b;
      }
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  public void e()
  {
    t.incrementAndGet();
    synchronized (j)
    {
      int i1 = j.size();
      for (int i2 = 0; i2 < i1; i2++) {
        ((b.h)j.get(i2)).a();
      }
      j.clear();
      synchronized (f)
      {
        g = null;
        b(1, null);
        return;
      }
    }
  }
  
  public boolean g()
  {
    return false;
  }
  
  public boolean h()
  {
    return true;
  }
  
  public Bundle j()
  {
    return new Bundle();
  }
  
  public final T k()
  {
    synchronized (e)
    {
      if (l != 5)
      {
        if (c())
        {
          boolean bool;
          if (i != null) {
            bool = true;
          } else {
            bool = false;
          }
          d.b.a.r.a(bool, "Client is connected but service is null");
          localObject2 = i;
          return (T)localObject2;
        }
        localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>("Not connected. Call connect() and wait for onConnected() to be called.");
        throw ((Throwable)localObject2);
      }
      Object localObject2 = new android/os/DeadObjectException;
      ((DeadObjectException)localObject2).<init>();
      throw ((Throwable)localObject2);
    }
  }
  
  public abstract String l();
  
  public abstract String m();
  
  public final String n()
  {
    String str1 = p;
    String str2 = str1;
    if (str1 == null) {
      str2 = b.getClass().getName();
    }
    return str2;
  }
  
  public final boolean o()
  {
    synchronized (e)
    {
      boolean bool;
      if (l == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */