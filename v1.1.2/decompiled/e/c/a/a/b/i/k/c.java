package e.c.a.a.b.i.k;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import e.c.a.a.b.e;
import e.c.a.a.b.i.a.b;
import e.c.a.a.b.i.a.d;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.j.b.c;
import e.c.a.a.b.j.r;
import e.c.a.a.e.l;
import e.c.a.a.f.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public class c
  implements Handler.Callback
{
  public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
  public static final Status o = new Status(4, "The user must be signed in to make this API call.");
  public static final Object p = new Object();
  @GuardedBy("lock")
  public static c q;
  public long a = 5000L;
  public long b = 120000L;
  public long c = 10000L;
  public final Context d;
  public final e.c.a.a.b.d e;
  public final e.c.a.a.b.j.j f;
  public final AtomicInteger g = new AtomicInteger(1);
  public final AtomicInteger h = new AtomicInteger(0);
  public final Map<h0<?>, a<?>> i = new ConcurrentHashMap(5, 0.75F, 1);
  @GuardedBy("lock")
  public j j = null;
  @GuardedBy("lock")
  public final Set<h0<?>> k = new d.f.c();
  public final Set<h0<?>> l = new d.f.c();
  public final Handler m;
  
  public c(Context paramContext, Looper paramLooper, e.c.a.a.b.d paramd)
  {
    d = paramContext;
    m = new e.c.a.a.d.a.c(paramLooper, this);
    e = paramd;
    f = new e.c.a.a.b.j.j(paramd);
    paramContext = m;
    paramContext.sendMessage(paramContext.obtainMessage(6));
  }
  
  public static c a(Context paramContext)
  {
    synchronized (p)
    {
      if (q == null)
      {
        Object localObject2 = new android/os/HandlerThread;
        ((HandlerThread)localObject2).<init>("GoogleApiHandler", 9);
        ((HandlerThread)localObject2).start();
        Looper localLooper = ((HandlerThread)localObject2).getLooper();
        localObject2 = new e/c/a/a/b/i/k/c;
        ((c)localObject2).<init>(paramContext.getApplicationContext(), localLooper, e.c.a.a.b.d.c);
        q = (c)localObject2;
      }
      paramContext = q;
      return paramContext;
    }
  }
  
  public final void a(e.c.a.a.b.i.c<?> paramc)
  {
    h0 localh0 = d;
    a locala1 = (a)i.get(localh0);
    a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new a(paramc);
      i.put(localh0, locala2);
    }
    if (locala2.b()) {
      l.add(localh0);
    }
    locala2.a();
  }
  
  public final boolean a(e.c.a.a.b.a parama, int paramInt)
  {
    e.c.a.a.b.d locald = e;
    Context localContext = d;
    PendingIntent localPendingIntent = null;
    if (locald != null)
    {
      int i1 = y;
      boolean bool = false;
      if ((i1 != 0) && (z != null)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        localPendingIntent = z;
      }
      else
      {
        Intent localIntent = locald.a(localContext, y, null);
        if (localIntent != null) {
          localPendingIntent = PendingIntent.getActivity(localContext, 0, localIntent, 134217728);
        }
      }
      if (localPendingIntent != null)
      {
        locald.a(localContext, y, GoogleApiActivity.a(localContext, localPendingIntent, paramInt));
        bool = true;
      }
      return bool;
    }
    throw null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = what;
    int i2 = 0;
    long l1 = 300000L;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i3;
    switch (i1)
    {
    default: 
      paramMessage = new StringBuilder(31);
      paramMessage.append("Unknown message id: ");
      paramMessage.append(i1);
      Log.w("GoogleApiManager", paramMessage.toString());
      return false;
    case 16: 
      localObject1 = (b)obj;
      if (i.containsKey(a))
      {
        paramMessage = (a)i.get(a);
        if (k.remove(localObject1))
        {
          m.m.removeMessages(15, localObject1);
          m.m.removeMessages(16, localObject1);
          localObject2 = b;
          localObject1 = new ArrayList(a.size());
          localObject3 = a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (m)((Iterator)localObject3).next();
            if ((localObject4 instanceof w))
            {
              e.c.a.a.b.c[] arrayOfc = ((w)localObject4).b(paramMessage);
              if (arrayOfc != null)
              {
                i3 = arrayOfc.length;
                for (i1 = 0; i1 < i3; i1++) {
                  if (d.b.a.s.c(arrayOfc[i1], localObject2)) {
                    break label331;
                  }
                }
                i1 = -1;
                if (i1 >= 0) {
                  i1 = 1;
                } else {
                  i1 = 0;
                }
                if (i1 != 0) {
                  ((ArrayList)localObject1).add(localObject4);
                }
              }
            }
          }
          i3 = ((ArrayList)localObject1).size();
          i1 = i2;
        }
      }
      break;
    case 15: 
    case 14: 
    case 12: 
    case 11: 
    case 10: 
    case 9: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 8: 
    case 13: 
    case 3: 
    case 2: 
    case 1: 
      label331:
      while (i1 < i3)
      {
        localObject4 = ((ArrayList)localObject1).get(i1);
        i1++;
        localObject3 = (m)localObject4;
        a.remove(localObject3);
        localObject4 = new e.c.a.a.b.i.j((e.c.a.a.b.c)localObject2);
        a.a.b((Exception)localObject4);
        continue;
        paramMessage = (b)obj;
        if (i.containsKey(a))
        {
          localObject1 = (a)i.get(a);
          if ((k.contains(paramMessage)) && (!j)) {
            if (!b.a())
            {
              ((a)localObject1).a();
            }
            else
            {
              ((a)localObject1).e();
              break;
              if ((k)obj != null)
              {
                if (!i.containsKey(null)) {
                  throw null;
                }
                ((a)i.get(null)).a(false);
                throw null;
              }
              throw null;
              if (i.containsKey(obj))
              {
                ((a)i.get(obj)).a(true);
                break;
                if (i.containsKey(obj))
                {
                  localObject1 = (a)i.get(obj);
                  d.b.a.s.a(m.m);
                  if (j)
                  {
                    ((a)localObject1).h();
                    paramMessage = m;
                    if (e.a(d, e.a) == 18) {
                      paramMessage = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                    } else {
                      paramMessage = new Status(8, "API failed to connect while resuming due to an unknown error.");
                    }
                    ((a)localObject1).a(paramMessage);
                    b.g();
                    break;
                    paramMessage = l.iterator();
                    while (paramMessage.hasNext())
                    {
                      localObject1 = (h0)paramMessage.next();
                      ((a)i.remove(localObject1)).f();
                    }
                    l.clear();
                    break;
                    if (i.containsKey(obj))
                    {
                      paramMessage = (a)i.get(obj);
                      d.b.a.s.a(m.m);
                      if (j)
                      {
                        paramMessage.a();
                        break;
                        a((e.c.a.a.b.i.c)obj);
                        break;
                        if ((d.getApplicationContext() instanceof Application))
                        {
                          b.a((Application)d.getApplicationContext());
                          b.B.a(new n(this));
                          paramMessage = b.B;
                          if (!y.get())
                          {
                            localObject1 = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)localObject1);
                            if ((!y.getAndSet(true)) && (importance > 100)) {
                              x.set(true);
                            }
                          }
                          if (!x.get())
                          {
                            c = 300000L;
                            break;
                            i1 = arg1;
                            localObject1 = (e.c.a.a.b.a)obj;
                            localObject2 = i.values().iterator();
                            while (((Iterator)localObject2).hasNext())
                            {
                              paramMessage = (a)((Iterator)localObject2).next();
                              if (h == i1) {
                                break label1061;
                              }
                            }
                            paramMessage = null;
                            label1061:
                            if (paramMessage != null)
                            {
                              localObject2 = e;
                              i1 = y;
                              if (localObject2 != null)
                              {
                                localObject2 = e.c.a.a.b.g.a(i1);
                                localObject4 = A;
                                i1 = String.valueOf(localObject2).length();
                                localObject1 = new StringBuilder(String.valueOf(localObject4).length() + (i1 + 69));
                                ((StringBuilder)localObject1).append("Error resolution was canceled by the user, original error message: ");
                                ((StringBuilder)localObject1).append((String)localObject2);
                                ((StringBuilder)localObject1).append(": ");
                                ((StringBuilder)localObject1).append((String)localObject4);
                                paramMessage.a(new Status(17, ((StringBuilder)localObject1).toString()));
                              }
                              else
                              {
                                throw null;
                              }
                            }
                            else
                            {
                              paramMessage = new StringBuilder(76);
                              paramMessage.append("Could not find API instance ");
                              paramMessage.append(i1);
                              paramMessage.append(" while trying to fail enqueued calls.");
                              Log.wtf("GoogleApiManager", paramMessage.toString(), new Exception());
                              break;
                              localObject2 = (u)obj;
                              localObject1 = (a)i.get(c.d);
                              paramMessage = (Message)localObject1;
                              if (localObject1 == null)
                              {
                                a(c);
                                paramMessage = (a)i.get(c.d);
                              }
                              if ((paramMessage.b()) && (h.get() != b))
                              {
                                a.a(n);
                                paramMessage.f();
                              }
                              else
                              {
                                paramMessage.a(a);
                                break;
                                localObject1 = i.values().iterator();
                                while (((Iterator)localObject1).hasNext())
                                {
                                  paramMessage = (a)((Iterator)localObject1).next();
                                  paramMessage.g();
                                  paramMessage.a();
                                  continue;
                                  if ((i0)obj != null) {
                                    throw null;
                                  }
                                  throw null;
                                  if (((Boolean)obj).booleanValue()) {
                                    l1 = 10000L;
                                  }
                                  c = l1;
                                  m.removeMessages(12);
                                  localObject2 = i.keySet().iterator();
                                  while (((Iterator)localObject2).hasNext())
                                  {
                                    localObject1 = (h0)((Iterator)localObject2).next();
                                    paramMessage = m;
                                    paramMessage.sendMessageDelayed(paramMessage.obtainMessage(12, localObject1), c);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  public final class a<O extends a.d>
    implements e.c.a.a.b.i.d.a, d.b, l0
  {
    public final Queue<m> a = new LinkedList();
    public final a.f b;
    public final a.b c;
    public final h0<O> d;
    public final i e;
    public final Set<i0> f = new HashSet();
    public final Map<f.a<?>, v> g = new HashMap();
    public final int h;
    public final x i;
    public boolean j;
    public final List<c.b> k = new ArrayList();
    public e.c.a.a.b.a l = null;
    
    public a()
    {
      Looper localLooper = m.getLooper();
      Object localObject1;
      e.c.a.a.b.j.d locald = ((e.c.a.a.b.i.c)localObject1).a().a();
      Object localObject2 = b;
      boolean bool;
      if (a != null) {
        bool = true;
      } else {
        bool = false;
      }
      d.b.a.s.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      localObject2 = a.a(a, localLooper, locald, c, this, this);
      b = ((a.f)localObject2);
      if ((localObject2 instanceof r))
      {
        if ((r)localObject2 != null) {
          c = null;
        } else {
          throw null;
        }
      }
      else {
        c = ((a.b)localObject2);
      }
      d = d;
      e = new i();
      h = e;
      if (b.i())
      {
        i = new x(d, m, ((e.c.a.a.b.i.c)localObject1).a().a());
        return;
      }
      i = null;
    }
    
    public final e.c.a.a.b.c a(e.c.a.a.b.c[] paramArrayOfc)
    {
      if ((paramArrayOfc != null) && (paramArrayOfc.length != 0))
      {
        Object localObject1 = b.e();
        int n = 0;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new e.c.a.a.b.c[0];
        }
        localObject1 = new d.f.a(localObject2.length);
        int i1 = localObject2.length;
        for (int i2 = 0; i2 < i1; i2++)
        {
          Object localObject3 = localObject2[i2];
          ((d.f.h)localObject1).put(x, Long.valueOf(((e.c.a.a.b.c)localObject3).b()));
        }
        i1 = paramArrayOfc.length;
        i2 = n;
        while (i2 < i1)
        {
          localObject2 = paramArrayOfc[i2];
          if ((((d.f.h)localObject1).containsKey(x)) && (((Long)((d.f.h)localObject1).get(x)).longValue() >= ((e.c.a.a.b.c)localObject2).b())) {
            i2++;
          } else {
            return (e.c.a.a.b.c)localObject2;
          }
        }
      }
      return null;
    }
    
    public final void a()
    {
      d.b.a.s.a(m);
      if ((!b.a()) && (!b.d()))
      {
        Object localObject1 = c.this;
        Object localObject2 = f;
        localObject1 = d;
        Object localObject3 = b;
        if (localObject2 != null)
        {
          d.b.a.s.a(localObject1);
          d.b.a.s.a(localObject3);
          boolean bool = ((a.f)localObject3).b();
          int n = 0;
          int i1 = 0;
          if (bool)
          {
            int i2 = ((a.f)localObject3).c();
            int i3 = a.get(i2, -1);
            if (i3 != -1)
            {
              n = i3;
            }
            else
            {
              for (n = 0; n < a.size(); n++)
              {
                int i4 = a.keyAt(n);
                if ((i4 > i2) && (a.get(i4) == 0))
                {
                  i3 = i1;
                  break;
                }
              }
              n = i3;
              if (i3 == -1) {
                n = b.a((Context)localObject1, i2);
              }
              a.put(i2, n);
            }
          }
          if (n != 0)
          {
            a(new e.c.a.a.b.a(n, null));
            return;
          }
          localObject1 = new c.c(c.this, b, d);
          if (b.i())
          {
            localObject2 = i;
            localObject3 = f;
            if (localObject3 != null) {
              ((a.f)localObject3).g();
            }
            e.h = Integer.valueOf(System.identityHashCode(localObject2));
            e.c.a.a.b.i.a.a locala = c;
            Context localContext = a;
            localObject3 = b.getLooper();
            e.c.a.a.b.j.d locald = e;
            f = ((f)locala.a(localContext, (Looper)localObject3, locald, g, (e.c.a.a.b.i.d.a)localObject2, (d.b)localObject2));
            g = ((a0)localObject1);
            localObject3 = d;
            if ((localObject3 != null) && (!((Set)localObject3).isEmpty())) {
              f.h();
            } else {
              b.post(new y((x)localObject2));
            }
          }
          b.a((b.c)localObject1);
          return;
        }
        throw null;
      }
    }
    
    public final void a(int paramInt)
    {
      if (Looper.myLooper() == m.getLooper())
      {
        d();
        return;
      }
      m.post(new p(this));
    }
    
    public final void a(Bundle paramBundle)
    {
      if (Looper.myLooper() == m.getLooper())
      {
        c();
        return;
      }
      m.post(new o(this));
    }
    
    public final void a(Status paramStatus)
    {
      d.b.a.s.a(m);
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        e.c.a.a.g.b localb = nexta;
        e.c.a.a.b.i.b localb1 = new e.c.a.a.b.i.b(paramStatus);
        a.b(localb1);
      }
      a.clear();
    }
    
    public final void a(e.c.a.a.b.a parama)
    {
      d.b.a.s.a(m);
      Object localObject = i;
      if (localObject != null)
      {
        localObject = f;
        if (localObject != null) {
          ((a.f)localObject).g();
        }
      }
      g();
      f.a.clear();
      c(parama);
      if (y == 4)
      {
        a(c.o);
        return;
      }
      if (a.isEmpty())
      {
        l = parama;
        return;
      }
      b(parama);
      if (!a(parama, h))
      {
        if (y == 18) {
          j = true;
        }
        if (j)
        {
          parama = m;
          parama.sendMessageDelayed(Message.obtain(parama, 9, d), a);
          return;
        }
        localObject = d.c.b;
        parama = new StringBuilder(String.valueOf(localObject).length() + 38);
        parama.append("API: ");
        parama.append((String)localObject);
        parama.append(" is not available on this device.");
        a(new Status(17, parama.toString()));
      }
    }
    
    public final void a(m paramm)
    {
      d.b.a.s.a(m);
      if (b.a())
      {
        if (b(paramm))
        {
          i();
          return;
        }
        a.add(paramm);
        return;
      }
      a.add(paramm);
      paramm = l;
      if (paramm != null)
      {
        int n;
        if ((y != 0) && (z != null)) {
          n = 1;
        } else {
          n = 0;
        }
        if (n != 0)
        {
          a(l);
          return;
        }
      }
      a();
    }
    
    public final boolean a(boolean paramBoolean)
    {
      d.b.a.s.a(m);
      if ((b.a()) && (g.size() == 0))
      {
        i locali = e;
        int n;
        if ((a.isEmpty()) && (b.isEmpty())) {
          n = 0;
        } else {
          n = 1;
        }
        if (n != 0)
        {
          if (paramBoolean) {
            i();
          }
          return false;
        }
        b.g();
        return true;
      }
      return false;
    }
    
    public final boolean b()
    {
      return b.i();
    }
    
    public final boolean b(e.c.a.a.b.a parama)
    {
      synchronized (c.p)
      {
        return false;
      }
    }
    
    public final boolean b(m paramm)
    {
      if (!(paramm instanceof w))
      {
        c(paramm);
        return true;
      }
      Object localObject = (w)paramm;
      e.c.a.a.b.c localc = a(((w)localObject).b(this));
      if (localc == null)
      {
        c(paramm);
        return true;
      }
      if (((w)localObject).c(this))
      {
        paramm = new c.b(d, localc, null);
        int n = k.indexOf(paramm);
        if (n >= 0)
        {
          localObject = (c.b)k.get(n);
          m.removeMessages(15, localObject);
          paramm = m;
          paramm.sendMessageDelayed(Message.obtain(paramm, 15, localObject), a);
        }
        else
        {
          k.add(paramm);
          localObject = m;
          ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 15, paramm), a);
          localObject = m;
          ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 16, paramm), b);
          paramm = new e.c.a.a.b.a(2, null);
          b(paramm);
          a(paramm, h);
        }
      }
      else
      {
        paramm = new e.c.a.a.b.i.j(localc);
        a.a.b(paramm);
      }
      return false;
    }
    
    public final void c()
    {
      g();
      c(e.c.a.a.b.a.B);
      h();
      Iterator localIterator = g.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject1 = (v)localIterator.next();
          if (a(a.b) != null)
          {
            localIterator.remove();
            continue;
          }
          try
          {
            Object localObject2 = a;
            Object localObject3 = c;
            localObject1 = new e/c/a/a/g/b;
            ((e.c.a.a.g.b)localObject1).<init>();
            localObject2 = (l)localObject2;
            if (localObject2 != null)
            {
              localObject3 = (e.c.a.a.d.c.o)localObject3;
              e.c.a.a.e.a.a locala = new e/c/a/a/e/a$a;
              locala.<init>((e.c.a.a.g.b)localObject1);
              ((e.c.a.a.d.c.o)localObject3).a(d, e, locala);
            }
            else
            {
              throw null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            localIterator.remove();
          }
          catch (DeadObjectException localDeadObjectException)
          {
            a(1);
            b.g();
          }
        }
      }
      e();
      i();
    }
    
    public final void c(e.c.a.a.b.a parama)
    {
      Object localObject = f.iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (i0)((Iterator)localObject).next();
        if (d.b.a.s.c(parama, e.c.a.a.b.a.B)) {
          b.f();
        }
        if (localObject != null) {
          throw null;
        }
        throw null;
      }
      f.clear();
    }
    
    public final void c(m paramm)
    {
      paramm.a(e, b());
      try
      {
        paramm.a(this);
        return;
      }
      catch (DeadObjectException paramm)
      {
        a(1);
        b.g();
      }
    }
    
    public final void d()
    {
      g();
      j = true;
      Object localObject = e;
      if (localObject != null)
      {
        ((i)localObject).a(true, c0.a);
        localObject = m;
        ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 9, d), a);
        localObject = m;
        ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 11, d), b);
        f.a.clear();
        return;
      }
      throw null;
    }
    
    public final void e()
    {
      ArrayList localArrayList = new ArrayList(a);
      int n = localArrayList.size();
      int i1 = 0;
      while (i1 < n)
      {
        Object localObject = localArrayList.get(i1);
        int i2 = i1 + 1;
        localObject = (m)localObject;
        if (!b.a()) {
          break;
        }
        i1 = i2;
        if (b((m)localObject))
        {
          a.remove(localObject);
          i1 = i2;
        }
      }
    }
    
    public final void f()
    {
      d.b.a.s.a(m);
      a(c.n);
      i locali = e;
      if (locali != null)
      {
        Object localObject = c.n;
        int n = 0;
        locali.a(false, (Status)localObject);
        localObject = (f.a[])g.keySet().toArray(new f.a[g.size()]);
        int i1 = localObject.length;
        while (n < i1)
        {
          a(new g0(localObject[n], new e.c.a.a.g.b()));
          n++;
        }
        c(new e.c.a.a.b.a(4));
        if (b.a()) {
          b.a(new q(this));
        }
        return;
      }
      throw null;
    }
    
    public final void g()
    {
      d.b.a.s.a(m);
      l = null;
    }
    
    public final void h()
    {
      if (j)
      {
        m.removeMessages(11, d);
        m.removeMessages(9, d);
        j = false;
      }
    }
    
    public final void i()
    {
      m.removeMessages(12, d);
      Handler localHandler = m;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(12, d), c);
    }
  }
  
  public static final class b
  {
    public final h0<?> a;
    public final e.c.a.a.b.c b;
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof b)))
      {
        paramObject = (b)paramObject;
        if ((d.b.a.s.c(a, a)) && (d.b.a.s.c(b, b))) {
          return true;
        }
      }
      return false;
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(new Object[] { a, b });
    }
    
    public final String toString()
    {
      e.c.a.a.b.j.o localo = d.b.a.s.c(this);
      localo.a("key", a);
      localo.a("feature", b);
      return localo.toString();
    }
  }
  
  public final class c
    implements a0, b.c
  {
    public final a.f a;
    public final h0<?> b;
    public e.c.a.a.b.j.k c = null;
    public Set<Scope> d = null;
    public boolean e = false;
    
    public c(h0<?> paramh0)
    {
      a = paramh0;
      h0 localh0;
      b = localh0;
    }
    
    public final void a(e.c.a.a.b.a parama)
    {
      m.post(new s(this, parama));
    }
    
    public final void b(e.c.a.a.b.a parama)
    {
      c.a locala = (c.a)i.get(b);
      d.b.a.s.a(m.m);
      b.g();
      locala.a(parama);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */