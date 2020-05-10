package e.c.a.a.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import d.b.a.s;
import e.c.a.a.b.i.k.b0;
import e.c.a.a.b.i.k.f;
import e.c.a.a.b.i.k.f.a;
import e.c.a.a.b.i.k.f0;
import e.c.a.a.b.i.k.g0;
import e.c.a.a.b.i.k.u;
import e.c.a.a.b.i.k.v;
import e.c.a.a.d.c.e;
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
      s.a(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      paramLooper = Looper.myLooper();
    }
    Object localObject = b.class.getSimpleName();
    s.b(paramb, "Listener must not be null");
    s.b(paramLooper, "Looper must not be null");
    s.b(localObject, "Listener type must not be null");
    paramb = new f(paramLooper, paramb, (String)localObject);
    paramLooper = new l(paramb, paramLocationRequest, paramb);
    localObject = new m(this, c);
    s.a(paramLooper);
    s.a(localObject);
    s.b(a.c, "Listener has already been released.");
    s.b(a, "Listener has already been released.");
    if (a.c.equals(a))
    {
      paramLocationRequest = f;
      if (paramLocationRequest != null)
      {
        paramb = new e.c.a.a.g.b();
        paramLooper = new f0(new v(paramLooper, (e.c.a.a.b.i.k.h)localObject), paramb);
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
    s.b(paramb, "Listener must not be null");
    s.b(localObject1, "Listener type must not be null");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new f.a(paramb, (String)localObject1);
      s.b(localObject2, "Listener key cannot be null.");
      paramb = f;
      if (paramb != null)
      {
        localObject1 = new e.c.a.a.g.b();
        Object localObject3 = new g0((f.a)localObject2, (e.c.a.a.g.b)localObject1);
        localObject2 = m;
        ((Handler)localObject2).sendMessage(((Handler)localObject2).obtainMessage(13, new u((e.c.a.a.b.i.k.m)localObject3, h.get(), this)));
        localObject3 = a;
        paramb = new b0();
        if (localObject3 != null)
        {
          localObject1 = e.c.a.a.g.c.a;
          localObject2 = new e.c.a.a.g.h();
          b.a(new d((Executor)localObject1, paramb, (e.c.a.a.g.h)localObject2));
          ((e.c.a.a.g.h)localObject3).c();
          return (e.c.a.a.g.h<Void>)localObject2;
        }
        throw null;
      }
      throw null;
    }
    throw new IllegalArgumentException("Listener type must not be empty");
  }
  
  public static final class a
    extends e
  {
    public final e.c.a.a.g.b<Void> a;
    
    public a(e.c.a.a.g.b<Void> paramb)
    {
      a = paramb;
    }
    
    public final void a(e.c.a.a.d.c.b paramb)
    {
      Object localObject = x;
      paramb = a;
      int i;
      if (y <= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        a.a(null);
      }
      else
      {
        localObject = new e.c.a.a.b.i.b((Status)localObject);
        a.a((Exception)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */