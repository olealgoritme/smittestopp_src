package e.c.a.a.b.i.k;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import d.b.a.r;
import e.c.a.a.b.a;
import e.c.a.a.b.d;
import e.c.a.a.b.e;
import e.c.a.a.b.g;
import e.c.a.a.b.i.a.f;
import e.c.a.a.g.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
  public final d e;
  public final e.c.a.a.b.j.j f;
  public final AtomicInteger g = new AtomicInteger(1);
  public final AtomicInteger h = new AtomicInteger(0);
  public final Map<h0<?>, c.a<?>> i = new ConcurrentHashMap(5, 0.75F, 1);
  @GuardedBy("lock")
  public j j = null;
  @GuardedBy("lock")
  public final Set<h0<?>> k = new d.f.c();
  public final Set<h0<?>> l = new d.f.c();
  public final Handler m;
  
  public c(Context paramContext, Looper paramLooper, d paramd)
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
        localObject2 = ((HandlerThread)localObject2).getLooper();
        c localc = new e/c/a/a/b/i/k/c;
        localc.<init>(paramContext.getApplicationContext(), (Looper)localObject2, d.c);
        q = localc;
      }
      paramContext = q;
      return paramContext;
    }
  }
  
  public final void a(e.c.a.a.b.i.c<?> paramc)
  {
    h0 localh0 = d;
    c.a locala1 = (c.a)i.get(localh0);
    c.a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new c.a(this, paramc);
      i.put(localh0, locala2);
    }
    if (locala2.b()) {
      l.add(localh0);
    }
    locala2.a();
  }
  
  public final boolean a(a parama, int paramInt)
  {
    d locald = e;
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
      localObject1 = (c.b)obj;
      if (i.containsKey(a))
      {
        paramMessage = (c.a)i.get(a);
        if (k.remove(localObject1))
        {
          m.m.removeMessages(15, localObject1);
          m.m.removeMessages(16, localObject1);
          localObject2 = b;
          localObject1 = new ArrayList(a.size());
          Iterator localIterator = a.iterator();
          while (localIterator.hasNext())
          {
            localObject3 = (m)localIterator.next();
            if ((localObject3 instanceof w))
            {
              localObject4 = ((w)localObject3).b(paramMessage);
              if (localObject4 != null)
              {
                i3 = localObject4.length;
                for (i1 = 0; i1 < i3; i1++) {
                  if (r.c(localObject4[i1], localObject2)) {
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
                  ((ArrayList)localObject1).add(localObject3);
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
        localObject4 = (m)localObject4;
        a.remove(localObject4);
        localObject3 = new e.c.a.a.b.i.j((e.c.a.a.b.c)localObject2);
        a.a.b((Exception)localObject3);
        continue;
        localObject1 = (c.b)obj;
        if (i.containsKey(a))
        {
          paramMessage = (c.a)i.get(a);
          if ((k.contains(localObject1)) && (!j)) {
            if (!b.c())
            {
              paramMessage.a();
            }
            else
            {
              paramMessage.e();
              break;
              if ((k)obj != null)
              {
                if (!i.containsKey(null)) {
                  throw null;
                }
                ((c.a)i.get(null)).a(false);
                throw null;
              }
              throw null;
              if (i.containsKey(obj))
              {
                ((c.a)i.get(obj)).a(true);
                break;
                if (i.containsKey(obj))
                {
                  localObject1 = (c.a)i.get(obj);
                  r.a(m.m);
                  if (j)
                  {
                    ((c.a)localObject1).h();
                    paramMessage = m;
                    if (e.a(d, e.a) == 18) {
                      paramMessage = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                    } else {
                      paramMessage = new Status(8, "API failed to connect while resuming due to an unknown error.");
                    }
                    ((c.a)localObject1).a(paramMessage);
                    b.e();
                    break;
                    localObject1 = l.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      paramMessage = (h0)((Iterator)localObject1).next();
                      ((c.a)i.remove(paramMessage)).f();
                    }
                    l.clear();
                    break;
                    if (i.containsKey(obj))
                    {
                      paramMessage = (c.a)i.get(obj);
                      r.a(m.m);
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
                            localObject1 = (a)obj;
                            localObject2 = i.values().iterator();
                            while (((Iterator)localObject2).hasNext())
                            {
                              paramMessage = (c.a)((Iterator)localObject2).next();
                              if (h == i1) {
                                break label1060;
                              }
                            }
                            paramMessage = null;
                            label1060:
                            if (paramMessage != null)
                            {
                              localObject2 = e;
                              i1 = y;
                              if (localObject2 != null)
                              {
                                localObject2 = g.a(i1);
                                localObject1 = A;
                                i1 = String.valueOf(localObject2).length();
                                localObject4 = new StringBuilder(String.valueOf(localObject1).length() + (i1 + 69));
                                ((StringBuilder)localObject4).append("Error resolution was canceled by the user, original error message: ");
                                ((StringBuilder)localObject4).append((String)localObject2);
                                ((StringBuilder)localObject4).append(": ");
                                ((StringBuilder)localObject4).append((String)localObject1);
                                paramMessage.a(new Status(17, ((StringBuilder)localObject4).toString()));
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
                              localObject1 = (c.a)i.get(c.d);
                              paramMessage = (Message)localObject1;
                              if (localObject1 == null)
                              {
                                a(c);
                                paramMessage = (c.a)i.get(c.d);
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
                                  paramMessage = (c.a)((Iterator)localObject1).next();
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
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.i.k.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */