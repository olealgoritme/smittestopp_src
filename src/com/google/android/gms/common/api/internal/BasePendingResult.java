package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import d.b.a.r;
import e.c.a.a.b.i.e;
import e.c.a.a.b.i.e.a;
import e.c.a.a.b.i.f;
import e.c.a.a.b.i.h;
import e.c.a.a.b.i.i;
import e.c.a.a.b.i.k.d0;
import e.c.a.a.b.i.k.k0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends h>
  extends e<R>
{
  public final Object a = new Object();
  public final BasePendingResult.a<R> b = new BasePendingResult.a(Looper.getMainLooper());
  public final CountDownLatch c = new CountDownLatch(1);
  public final ArrayList<e.a> d = new ArrayList();
  public i<? super R> e;
  public final AtomicReference<d0> f = new AtomicReference();
  public R g;
  public Status h;
  public volatile boolean i;
  public boolean j;
  @KeepName
  public BasePendingResult.b mResultGuardian;
  
  static
  {
    new k0();
  }
  
  @Deprecated
  public BasePendingResult()
  {
    new WeakReference(null);
  }
  
  public static void c(h paramh)
  {
    if ((paramh instanceof f)) {
      try
      {
        ((f)paramh).c();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str = String.valueOf(paramh);
        paramh = new StringBuilder(str.length() + 18);
        paramh.append("Unable to release ");
        paramh.append(str);
        Log.w("BasePendingResult", paramh.toString(), localRuntimeException);
      }
    }
  }
  
  public final R a()
  {
    synchronized (a)
    {
      boolean bool;
      if (!i) {
        bool = true;
      } else {
        bool = false;
      }
      r.a(bool, "Result has already been consumed.");
      r.a(b(), "Result is not ready.");
      h localh = g;
      g = null;
      e = null;
      i = true;
      ??? = (d0)f.getAndSet(null);
      if (??? != null) {
        ((d0)???).a(this);
      }
      return localh;
    }
  }
  
  public abstract R a(Status paramStatus);
  
  public final void a(R paramR)
  {
    synchronized (a)
    {
      if (!j)
      {
        b();
        boolean bool1 = b();
        boolean bool2 = true;
        if (!bool1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        r.a(bool1, "Results have already been set");
        if (!i) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        r.a(bool1, "Result has already been consumed");
        b(paramR);
        return;
      }
      c(paramR);
      return;
    }
  }
  
  public final void b(Status paramStatus)
  {
    synchronized (a)
    {
      if (!b())
      {
        a(a(paramStatus));
        j = true;
      }
      return;
    }
  }
  
  public final void b(R paramR)
  {
    g = paramR;
    c.countDown();
    h = g.a();
    if (e == null)
    {
      if ((g instanceof f)) {
        mResultGuardian = new BasePendingResult.b(this, null);
      }
    }
    else
    {
      b.removeMessages(2);
      localObject = b;
      i locali = e;
      paramR = a();
      if (localObject == null) {
        break label159;
      }
      ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1, new Pair(locali, paramR)));
    }
    Object localObject = d;
    int k = ((ArrayList)localObject).size();
    int m = 0;
    while (m < k)
    {
      paramR = ((ArrayList)localObject).get(m);
      m++;
      ((e.a)paramR).a(h);
    }
    d.clear();
    return;
    label159:
    throw null;
  }
  
  public final boolean b()
  {
    return c.getCount() == 0L;
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.internal.BasePendingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */