package e.c.a.a.b.i.k;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import d.b.a.s;
import e.c.a.a.b.e;
import e.c.a.a.b.i.a.b;
import e.c.a.a.b.i.a.d;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.j.b.c;
import e.c.a.a.b.j.d;
import e.c.a.a.b.j.r;
import e.c.a.a.e.l;
import e.c.a.a.f.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c$a<O extends a.d>
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
  
  public c$a(e.c.a.a.b.i.c<O> paramc)
  {
    Looper localLooper = m.getLooper();
    Object localObject1;
    d locald = ((e.c.a.a.b.i.c)localObject1).a().a();
    Object localObject2 = b;
    boolean bool;
    if (a != null) {
      bool = true;
    } else {
      bool = false;
    }
    s.a(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
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
    s.a(m.m);
    if ((!b.a()) && (!b.d()))
    {
      Object localObject1 = m;
      Object localObject2 = f;
      localObject1 = d;
      Object localObject3 = b;
      if (localObject2 != null)
      {
        s.a(localObject1);
        s.a(localObject3);
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
        localObject1 = new c.c(m, b, d);
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
          d locald = e;
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
    if (Looper.myLooper() == m.m.getLooper())
    {
      d();
      return;
    }
    m.m.post(new p(this));
  }
  
  public final void a(Bundle paramBundle)
  {
    if (Looper.myLooper() == m.m.getLooper())
    {
      c();
      return;
    }
    m.m.post(new o(this));
  }
  
  public final void a(Status paramStatus)
  {
    s.a(m.m);
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
    s.a(m.m);
    Object localObject = i;
    if (localObject != null)
    {
      localObject = f;
      if (localObject != null) {
        ((a.f)localObject).g();
      }
    }
    g();
    m.f.a.clear();
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
    if (!m.a(parama, h))
    {
      if (y == 18) {
        j = true;
      }
      if (j)
      {
        parama = m.m;
        parama.sendMessageDelayed(Message.obtain(parama, 9, d), m.a);
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
    s.a(m.m);
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
    s.a(m.m);
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
        m.m.removeMessages(15, localObject);
        paramm = m.m;
        paramm.sendMessageDelayed(Message.obtain(paramm, 15, localObject), m.a);
      }
      else
      {
        k.add(paramm);
        localObject = m.m;
        ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 15, paramm), m.a);
        localObject = m.m;
        ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 16, paramm), m.b);
        paramm = new e.c.a.a.b.a(2, null);
        b(paramm);
        m.a(paramm, h);
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
      if (s.c(parama, e.c.a.a.b.a.B)) {
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
      localObject = m.m;
      ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 9, d), m.a);
      localObject = m.m;
      ((Handler)localObject).sendMessageDelayed(Message.obtain((Handler)localObject, 11, d), m.b);
      m.f.a.clear();
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
    s.a(m.m);
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
    s.a(m.m);
    l = null;
  }
  
  public final void h()
  {
    if (j)
    {
      m.m.removeMessages(11, d);
      m.m.removeMessages(9, d);
      j = false;
    }
  }
  
  public final void i()
  {
    m.m.removeMessages(12, d);
    Handler localHandler = m.m;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(12, d), m.c);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */