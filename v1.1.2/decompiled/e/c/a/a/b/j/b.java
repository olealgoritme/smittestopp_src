package e.c.a.a.b.j;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import d.b.a.s;
import e.c.a.a.b.a;
import e.c.a.a.b.e;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.i.k.c.a;
import e.c.a.a.b.i.k.q;
import e.c.a.a.b.i.k.r;
import e.c.a.a.d.b.d;
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
  public c h;
  @GuardedBy("mLock")
  public T i;
  public final ArrayList<h<?>> j = new ArrayList();
  @GuardedBy("mLock")
  public j k;
  @GuardedBy("mLock")
  public int l = 1;
  public final a m;
  public final b n;
  public final int o;
  public final String p;
  public a q = null;
  public boolean r = false;
  public volatile z s = null;
  public AtomicInteger t = new AtomicInteger(0);
  
  public b(Context paramContext, Looper paramLooper, i parami, e parame, int paramInt, a parama, b paramb, String paramString)
  {
    s.b(paramContext, "Context must not be null");
    b = ((Context)paramContext);
    s.b(paramLooper, "Looper must not be null");
    paramContext = (Looper)paramLooper;
    s.b(parami, "Supervisor must not be null");
    c = ((i)parami);
    s.b(parame, "API availability must not be null");
    paramContext = (e)parame;
    d = new g(paramLooper);
    o = paramInt;
    m = parama;
    n = paramb;
    p = paramString;
  }
  
  public abstract T a(IBinder paramIBinder);
  
  public void a(int paramInt, T paramT) {}
  
  public void a(c paramc)
  {
    s.b(paramc, "Connection progress callbacks cannot be null.");
    h = ((c)paramc);
    b(2, null);
  }
  
  public void a(e parame)
  {
    parame = (q)parame;
    a.m.m.post(new r(parame));
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
    if (i())
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
      ???.sendMessage(???.obtainMessage(1, i1, -1, new k(8, null, null)));
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
      if (l == 4) {
        bool = true;
      } else {
        bool = false;
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
    s.a(bool);
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
            paramT = c;
            localObject2 = a.a;
            localObject4 = a.b;
            paramInt = a.c;
            localObject5 = k;
            localObject6 = n();
            if (paramT != null)
            {
              localObject3 = new e/c/a/a/b/j/i$a;
              ((i.a)localObject3).<init>((String)localObject2, (String)localObject4, paramInt);
              paramT.b((i.a)localObject3, (ServiceConnection)localObject5, (String)localObject6);
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
          localObject5 = n();
          localObject4 = new e/c/a/a/b/j/i$a;
          ((i.a)localObject4).<init>((String)localObject2, paramT, paramInt);
          if (!((i)localObject3).a((i.a)localObject4, (ServiceConnection)localObject6, (String)localObject5))
          {
            paramT = a.a;
            localObject2 = a.b;
            paramInt = String.valueOf(paramT).length();
            i1 = String.valueOf(localObject2).length();
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>(paramInt + 34 + i1);
            ((StringBuilder)localObject3).append("unable to connect to service: ");
            ((StringBuilder)localObject3).append(paramT);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Log.e("GmsClient", ((StringBuilder)localObject3).toString());
            paramInt = t.get();
            localObject3 = d;
            paramT = new e/c/a/a/b/j/b$l;
            paramT.<init>(this, 16);
            ((Handler)localObject3).sendMessage(((Handler)localObject3).obtainMessage(7, paramInt, -1, paramT));
          }
        }
      }
      else if (k != null)
      {
        paramT = c;
        localObject6 = a.a;
        localObject5 = a.b;
        paramInt = a.c;
        localObject4 = k;
        localObject3 = n();
        if (paramT != null)
        {
          localObject2 = new e/c/a/a/b/j/i$a;
          ((i.a)localObject2).<init>((String)localObject6, (String)localObject5, paramInt);
          paramT.b((i.a)localObject2, (ServiceConnection)localObject4, (String)localObject3);
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
  
  public boolean b()
  {
    return true;
  }
  
  public boolean d()
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
  
  public final e.c.a.a.b.c[] e()
  {
    z localz = s;
    if (localz == null) {
      return null;
    }
    return y;
  }
  
  public String f()
  {
    if (a())
    {
      f0 localf0 = a;
      if (localf0 != null) {
        return b;
      }
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  public void g()
  {
    t.incrementAndGet();
    synchronized (j)
    {
      int i1 = j.size();
      for (int i2 = 0; i2 < i1; i2++) {
        ((h)j.get(i2)).a();
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
  
  public boolean i()
  {
    return false;
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
        if (a())
        {
          boolean bool;
          if (i != null) {
            bool = true;
          } else {
            bool = false;
          }
          s.a(bool, "Client is connected but service is null");
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
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  public static abstract interface c
  {
    public abstract void a(a parama);
  }
  
  public class d
    implements b.c
  {
    public d() {}
    
    public void a(a parama)
    {
      if (parama.b())
      {
        parama = b.this;
        parama.a(null, v);
        return;
      }
      b.b localb = n;
      if (localb != null) {
        a.a(parama);
      }
    }
  }
  
  public static abstract interface e {}
  
  public abstract class f
    extends b.h<Boolean>
  {
    public final int d;
    public final Bundle e;
    
    public f(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      d = paramInt;
      e = paramBundle;
    }
    
    public abstract void a(a parama);
    
    public abstract boolean d();
  }
  
  public final class g
    extends d
  {
    public g(Looper paramLooper)
    {
      super();
    }
    
    public static void a(Message paramMessage)
    {
      paramMessage = (b.h)obj;
      if ((b.f)paramMessage != null)
      {
        paramMessage.b();
        return;
      }
      throw null;
    }
    
    public static boolean b(Message paramMessage)
    {
      int i = what;
      return (i == 2) || (i == 1) || (i == 7);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (t.get() != arg1)
      {
        if (b(paramMessage)) {
          a(paramMessage);
        }
        return;
      }
      int i = what;
      if ((i != 1) && (i != 7)) {
        if (i == 4)
        {
          if (b.this == null) {
            throw null;
          }
        }
        else {
          if (i != 5) {
            break label82;
          }
        }
      }
      if (!d())
      {
        a(paramMessage);
        return;
      }
      label82:
      i = what;
      if (i == 4)
      {
        q = new a(arg2);
        if (b.b(b.this))
        {
          paramMessage = b.this;
          if (!r)
          {
            paramMessage.b(3, null);
            return;
          }
        }
        paramMessage = q;
        if (paramMessage == null) {
          paramMessage = new a(8);
        }
        h.a(paramMessage);
        if (b.this != null)
        {
          System.currentTimeMillis();
          return;
        }
        throw null;
      }
      if (i == 5)
      {
        paramMessage = q;
        if (paramMessage == null) {
          paramMessage = new a(8);
        }
        h.a(paramMessage);
        if (b.this != null)
        {
          System.currentTimeMillis();
          return;
        }
        throw null;
      }
      Object localObject;
      if (i == 3)
      {
        localObject = obj;
        if ((localObject instanceof PendingIntent)) {
          localObject = (PendingIntent)localObject;
        } else {
          localObject = null;
        }
        paramMessage = new a(arg2, (PendingIntent)localObject);
        h.a(paramMessage);
        if (b.this != null)
        {
          System.currentTimeMillis();
          return;
        }
        throw null;
      }
      if (i == 6)
      {
        b(5, null);
        localObject = m;
        if (localObject != null)
        {
          i = arg2;
          a.a(i);
        }
        if (b.this != null)
        {
          System.currentTimeMillis();
          a(5, 1, null);
          return;
        }
        throw null;
      }
      if ((i == 2) && (!a()))
      {
        a(paramMessage);
        return;
      }
      if (b(paramMessage))
      {
        ((b.h)obj).c();
        return;
      }
      i = what;
      paramMessage = new StringBuilder(45);
      paramMessage.append("Don't know how to handle message: ");
      paramMessage.append(i);
      Log.wtf("GmsClient", paramMessage.toString(), new Exception());
    }
  }
  
  public abstract class h<TListener>
  {
    public TListener a;
    public boolean b;
    
    public h()
    {
      Object localObject;
      a = localObject;
      b = false;
    }
    
    public final void a()
    {
      try
      {
        a = null;
        return;
      }
      finally {}
    }
    
    public abstract void a(TListener paramTListener);
    
    public final void b()
    {
      a();
      synchronized (j)
      {
        j.remove(this);
        return;
      }
    }
    
    /* Error */
    public final void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	e/c/a/a/b/j/b$h:a	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	e/c/a/a/b/j/b$h:b	Z
      //   11: ifeq +61 -> 72
      //   14: aload_0
      //   15: invokestatic 50	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: aload_2
      //   20: invokevirtual 54	java/lang/String:length	()I
      //   23: istore_3
      //   24: new 56	java/lang/StringBuilder
      //   27: astore 4
      //   29: aload 4
      //   31: iload_3
      //   32: bipush 47
      //   34: iadd
      //   35: invokespecial 59	java/lang/StringBuilder:<init>	(I)V
      //   38: aload 4
      //   40: ldc 61
      //   42: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: pop
      //   46: aload 4
      //   48: aload_2
      //   49: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: pop
      //   53: aload 4
      //   55: ldc 67
      //   57: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: pop
      //   61: ldc 69
      //   63: aload 4
      //   65: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: invokestatic 79	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   71: pop
      //   72: aload_0
      //   73: monitorexit
      //   74: aload_1
      //   75: ifnull +16 -> 91
      //   78: aload_0
      //   79: aload_1
      //   80: invokevirtual 81	e/c/a/a/b/j/b$h:a	(Ljava/lang/Object;)V
      //   83: goto +8 -> 91
      //   86: astore 4
      //   88: aload 4
      //   90: athrow
      //   91: aload_0
      //   92: monitorenter
      //   93: aload_0
      //   94: iconst_1
      //   95: putfield 26	e/c/a/a/b/j/b$h:b	Z
      //   98: aload_0
      //   99: monitorexit
      //   100: aload_0
      //   101: invokevirtual 83	e/c/a/a/b/j/b$h:b	()V
      //   104: return
      //   105: astore 4
      //   107: aload_0
      //   108: monitorexit
      //   109: aload 4
      //   111: athrow
      //   112: astore 4
      //   114: aload_0
      //   115: monitorexit
      //   116: aload 4
      //   118: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	this	h
      //   6	74	1	localObject1	Object
      //   18	31	2	str	String
      //   23	12	3	i	int
      //   27	37	4	localStringBuilder	StringBuilder
      //   86	3	4	localRuntimeException	RuntimeException
      //   105	5	4	localObject2	Object
      //   112	5	4	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   78	83	86	java/lang/RuntimeException
      //   93	100	105	finally
      //   107	109	105	finally
      //   2	72	112	finally
      //   72	74	112	finally
      //   114	116	112	finally
    }
  }
  
  public static final class i
    extends l.a
  {
    public b a;
    public final int b;
    
    public i(b paramb, int paramInt)
    {
      a = paramb;
      b = paramInt;
    }
    
    public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      s.b(a, "onPostInitComplete can be called only once per call to getRemoteService");
      b localb = a;
      int i = b;
      Handler localHandler = d;
      localHandler.sendMessage(localHandler.obtainMessage(1, i, -1, new b.k(localb, paramInt, paramIBinder, paramBundle)));
      a = null;
    }
  }
  
  public final class j
    implements ServiceConnection
  {
    public final int a;
    
    public j(int paramInt)
    {
      a = paramInt;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        b.a(b.this);
        return;
      }
      synchronized (f)
      {
        b localb = b.this;
        paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
        if ((paramComponentName != null) && ((paramComponentName instanceof n))) {
          paramComponentName = (n)paramComponentName;
        } else {
          paramComponentName = new m(paramIBinder);
        }
        g = paramComponentName;
        paramIBinder = b.this;
        int i = a;
        paramComponentName = d;
        paramComponentName.sendMessage(paramComponentName.obtainMessage(7, i, -1, new b.l(paramIBinder, 0)));
        return;
      }
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (f)
      {
        g = null;
        ??? = d;
        ???.sendMessage(???.obtainMessage(6, a, 1));
        return;
      }
    }
  }
  
  public final class k
    extends b.f
  {
    public final IBinder g;
    
    public k(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      g = paramIBinder;
    }
    
    public final void a(a parama)
    {
      b.b localb = n;
      if (localb != null) {
        a.a(parama);
      }
      if (b.this != null)
      {
        int i = y;
        System.currentTimeMillis();
        return;
      }
      throw null;
    }
    
    public final boolean d()
    {
      try
      {
        String str1 = g.getInterfaceDescriptor();
        if (!l().equals(str1))
        {
          String str2 = l();
          int i = String.valueOf(str2).length();
          localObject = new StringBuilder(String.valueOf(str1).length() + (i + 34));
          ((StringBuilder)localObject).append("service descriptor mismatch: ");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append(" vs. ");
          ((StringBuilder)localObject).append(str1);
          Log.e("GmsClient", ((StringBuilder)localObject).toString());
          return false;
        }
        Object localObject = a(g);
        if ((localObject != null) && ((a(2, 4, (IInterface)localObject)) || (a(3, 4, (IInterface)localObject))))
        {
          localObject = b.this;
          q = null;
          localObject = m;
          if (localObject != null) {
            a.a(null);
          }
          return true;
        }
        return false;
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
      }
      return false;
    }
  }
  
  public final class l
    extends b.f
  {
    public l(int paramInt)
    {
      super(paramInt, null);
    }
    
    public final void a(a parama)
    {
      b localb = b.this;
      if (localb != null)
      {
        h.a(parama);
        if (b.this != null)
        {
          int i = y;
          System.currentTimeMillis();
          return;
        }
        throw null;
      }
      throw null;
    }
    
    public final boolean d()
    {
      h.a(a.B);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */