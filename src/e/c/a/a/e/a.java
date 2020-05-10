package e.c.a.a.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.location.LocationRequest;
import d.b.a.r;
import e.c.a.a.b.i.k.b0;
import e.c.a.a.b.i.k.f;
import e.c.a.a.b.i.k.f.a;
import e.c.a.a.b.i.k.f0;
import e.c.a.a.b.i.k.g0;
import e.c.a.a.b.i.k.u;
import e.c.a.a.b.i.k.v;
import e.c.a.a.d.c.q;
import e.c.a.a.g.d;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class a
  extends e.c.a.a.b.i.c<Object>
{
  public a(Context paramContext)
  {
    super(paramContext, c.c, null, new e.c.a.a.b.i.k.a());
  }
  
  public e.c.a.a.g.h<Void> a(LocationRequest paramLocationRequest, b paramb, Looper paramLooper)
  {
    paramLocationRequest = new q(paramLocationRequest, q.E, null, false, false, false, null);
    if (paramLooper == null)
    {
      boolean bool;
      if (Looper.myLooper() != null) {
        bool = true;
      } else {
        bool = false;
      }
      r.a(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      paramLooper = Looper.myLooper();
    }
    Object localObject = b.class.getSimpleName();
    r.b(paramb, "Listener must not be null");
    r.b(paramLooper, "Looper must not be null");
    r.b(localObject, "Listener type must not be null");
    paramb = new f(paramLooper, paramb, (String)localObject);
    paramLooper = new l(paramb, paramLocationRequest, paramb);
    localObject = new m(this, c);
    r.a(paramLooper);
    r.a(localObject);
    r.b(a.c, "Listener has already been released.");
    r.b(a, "Listener has already been released.");
    if (a.c.equals(a))
    {
      paramb = f;
      if (paramb != null)
      {
        paramLocationRequest = new e.c.a.a.g.b();
        paramLooper = new f0(new v(paramLooper, (e.c.a.a.b.i.k.h)localObject), paramLocationRequest);
        localObject = m;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(8, new u(paramLooper, h.get(), this)));
        return a;
      }
      throw null;
    }
    throw new IllegalArgumentException("Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
  }
  
  public e.c.a.a.g.h<Void> a(b paramb)
  {
    Object localObject1 = b.class.getSimpleName();
    r.b(paramb, "Listener must not be null");
    r.b(localObject1, "Listener type must not be null");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new f.a(paramb, (String)localObject1);
      r.b(localObject2, "Listener key cannot be null.");
      localObject1 = f;
      if (localObject1 != null)
      {
        paramb = new e.c.a.a.g.b();
        localObject2 = new g0((f.a)localObject2, paramb);
        Object localObject3 = m;
        ((Handler)localObject3).sendMessage(((Handler)localObject3).obtainMessage(13, new u((e.c.a.a.b.i.k.m)localObject2, h.get(), this)));
        paramb = a;
        localObject2 = new b0();
        if (paramb != null)
        {
          localObject1 = e.c.a.a.g.c.a;
          localObject3 = new e.c.a.a.g.h();
          b.a(new d((Executor)localObject1, (b0)localObject2, (e.c.a.a.g.h)localObject3));
          paramb.c();
          return (e.c.a.a.g.h<Void>)localObject3;
        }
        throw null;
      }
      throw null;
    }
    throw new IllegalArgumentException("Listener type must not be empty");
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */