package l.c.a.a.a;

import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import l.c.a.a.a.s.s.o;
import l.c.a.a.a.s.s.t;
import l.c.a.a.a.s.s.u;

public class f
  implements b
{
  public static final String I = f.class.getName();
  public static int J = 1000;
  public static final Object K = new Object();
  public l.c.a.a.a.s.a A;
  public l.c.a.a.a.u.a B;
  public g C;
  public i D;
  public Object E;
  public Timer F;
  public boolean G;
  public ScheduledExecutorService H;
  public l.c.a.a.a.t.b x;
  public String y;
  public String z;
  
  public f(String paramString1, String paramString2, l.c.a.a.a.u.a parama)
  {
    l.c.a.a.a.t.b localb = l.c.a.a.a.t.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", I);
    x = localb;
    G = false;
    localb.a(paramString2);
    if (paramString2 != null)
    {
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i >= paramString2.length() - 1)
        {
          if (j <= 65535)
          {
            l.c.a.a.a.s.j.a(paramString1);
            z = paramString1;
            y = paramString2;
            B = parama;
            if (parama == null) {
              B = new l.c.a.a.a.u.a();
            }
            H = null;
            x.b(I, "MqttAsyncClient", "101", new Object[] { paramString2, paramString1, parama });
            B.b();
            A = new l.c.a.a.a.s.a(this, B, localr, H);
            B.close();
            new Hashtable();
            return;
          }
          throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        int k = paramString2.charAt(i);
        int m;
        if ((k >= 55296) && (k <= 56319)) {
          m = 1;
        } else {
          m = 0;
        }
        k = i;
        if (m != 0) {
          k = i + 1;
        }
        j++;
        i = k + 1;
      }
    }
    throw new IllegalArgumentException("Null clientId");
  }
  
  public c a(String paramString, l paraml)
  {
    x.b(I, "publish", "111", new Object[] { paramString, null, null });
    l.b.c.e.a.a(paramString, false);
    j localj = new j(y);
    l.c.a.a.a.s.p localp = a;
    l = null;
    m = null;
    localp.a(new String[] { paramString });
    paramString = new o(paramString, paraml);
    A.b(paramString, localj);
    x.b(I, "publish", "112");
    return localj;
  }
  
  public e a()
  {
    x.b(I, "disconnect", "104", new Object[] { Long.valueOf(30000L), null, null });
    q localq = new q(y);
    Object localObject = a;
    l = null;
    m = null;
    localObject = new l.c.a.a.a.s.s.e();
    try
    {
      A.a((l.c.a.a.a.s.s.e)localObject, 30000L, localq);
      x.b(I, "disconnect", "108");
      return localq;
    }
    catch (k localk)
    {
      x.a(I, "disconnect", "105", null, localk);
      throw localk;
    }
  }
  
  public e a(String paramString)
  {
    String[] arrayOfString = new String[1];
    int i = 0;
    arrayOfString[0] = paramString;
    Object localObject;
    if (x.a(5))
    {
      paramString = "";
      for (j = 0;; j++)
      {
        if (j >= 1)
        {
          x.b(I, "unsubscribe", "107", new Object[] { paramString, null, null });
          break;
        }
        localObject = paramString;
        if (j > 0)
        {
          paramString = new StringBuilder(String.valueOf(paramString));
          paramString.append(", ");
          localObject = paramString.toString();
        }
        paramString = new StringBuilder(String.valueOf(localObject));
        paramString.append(arrayOfString[j]);
        paramString = paramString.toString();
      }
    }
    for (int j = 0;; j++)
    {
      if (j >= 1) {
        for (j = i;; j++)
        {
          if (j >= 1)
          {
            paramString = new q(y);
            localObject = a;
            l = null;
            m = null;
            ((l.c.a.a.a.s.p)localObject).a(arrayOfString);
            localObject = new t(arrayOfString);
            A.b((u)localObject, paramString);
            x.b(I, "unsubscribe", "110");
            return paramString;
          }
          paramString = arrayOfString[j];
          A.h.A.remove(paramString);
        }
      }
      l.b.c.e.a.a(arrayOfString[j], true);
    }
  }
  
  public e a(String paramString, int paramInt)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    paramString = new int[1];
    paramString[0] = paramInt;
    for (paramInt = 0;; paramInt++)
    {
      if (paramInt >= 1)
      {
        if (x.a(5))
        {
          localObject = new StringBuffer();
          for (paramInt = 0;; paramInt++)
          {
            if (paramInt >= 1)
            {
              x.b(I, "subscribe", "106", new Object[] { ((StringBuffer)localObject).toString(), null, null });
              break;
            }
            if (paramInt > 0) {
              ((StringBuffer)localObject).append(", ");
            }
            ((StringBuffer)localObject).append("topic=");
            ((StringBuffer)localObject).append(arrayOfString[paramInt]);
            ((StringBuffer)localObject).append(" qos=");
            ((StringBuffer)localObject).append(paramString[paramInt]);
          }
        }
        localObject = new q(y);
        l.c.a.a.a.s.p localp = a;
        l = null;
        m = null;
        localp.a(arrayOfString);
        paramString = new l.c.a.a.a.s.s.r(arrayOfString, paramString);
        A.b(paramString, (q)localObject);
        x.b(I, "subscribe", "109");
        return (e)localObject;
      }
      Object localObject = arrayOfString[paramInt];
      l.b.c.e.a.a((String)localObject, true);
      A.h.A.remove(localObject);
    }
  }
  
  public e a(i parami, Object paramObject, a parama)
  {
    if (!A.b())
    {
      if (!A.c())
      {
        if (!A.e())
        {
          if (!A.a())
          {
            i locali;
            if (parami == null) {
              locali = new i();
            } else {
              locali = parami;
            }
            D = locali;
            E = paramObject;
            boolean bool1 = o;
            Object localObject1 = x;
            Object localObject2 = I;
            boolean bool2 = k;
            int i = l;
            int j = a;
            String str = e;
            parami = f;
            Object localObject3 = "[null]";
            if (parami == null) {
              parami = "[null]";
            } else {
              parami = "[notnull]";
            }
            if (d != null) {
              localObject3 = "[notnull]";
            }
            ((l.c.a.a.a.t.b)localObject1).b((String)localObject2, "connect", "103", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), str, parami, localObject3, paramObject, parama });
            localObject2 = A;
            localObject1 = z;
            x.b(I, "createNetworkModules", "116", new Object[] { localObject1 });
            localObject3 = m;
            if (localObject3 == null)
            {
              parami = new String[1];
              parami[0] = localObject1;
            }
            else
            {
              parami = (i)localObject3;
              if (localObject3.length == 0)
              {
                parami = new String[1];
                parami[0] = localObject1;
              }
            }
            localObject3 = new l.c.a.a.a.s.i[parami.length];
            for (j = 0;; j++)
            {
              if (j >= parami.length)
              {
                x.b(I, "createNetworkModules", "108");
                if (localObject2 != null)
                {
                  e = ((l.c.a.a.a.s.i[])((l.c.a.a.a.s.i[])localObject3).clone());
                  parami = A;
                  localObject3 = new b(bool1);
                  h.z = ((h)localObject3);
                  parami = new q(y);
                  paramObject = new l.c.a.a.a.s.g(this, B, A, locali, parami, paramObject, parama, G);
                  parama = a;
                  l = ((a)paramObject);
                  m = this;
                  parama = C;
                  if ((parama instanceof h)) {
                    i = ((h)parama);
                  }
                  A.d = 0;
                  ((l.c.a.a.a.s.g)paramObject).a();
                  return parami;
                }
                throw null;
              }
              localObject1 = parami[j];
              x.b(I, "createNetworkModule", "115", new Object[] { localObject1 });
              localObject3[j] = l.c.a.a.a.s.j.a((String)localObject1, locali, y);
            }
          }
          throw new k(32111);
        }
        throw new k(32102);
      }
      throw new k(32110);
    }
    throw l.b.c.e.a.a(32100);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = A.h;
    if (localObject1 != null)
    {
      if (paramInt2 == 1)
      {
        B.a(new l.c.a.a.a.s.s.k(paramInt1), new q(B.c).y));
      }
      else if (paramInt2 == 2)
      {
        l.c.a.a.a.s.b localb = B.i;
        a.b("l.c.a.a.a.s.b", "deliveryComplete", "641", new Object[] { Integer.valueOf(paramInt1) });
        Object localObject2 = k;
        StringBuilder localStringBuilder = new StringBuilder("r-");
        localStringBuilder.append(paramInt1);
        ((l.c.a.a.a.u.a)localObject2).a(localStringBuilder.toString());
        B.remove(Integer.valueOf(paramInt1));
        localObject2 = new l.c.a.a.a.s.s.l(paramInt1);
        localObject1 = B;
        ((l.c.a.a.a.s.a)localObject1).a((u)localObject2, new q(c).y));
      }
      return;
    }
    throw null;
  }
  
  public boolean b()
  {
    return A.b();
  }
  
  public final void c()
  {
    x.b(I, "stopReconnectCycle", "504", new Object[] { y });
    synchronized (K)
    {
      if (D.o)
      {
        if (F != null)
        {
          F.cancel();
          F = null;
        }
        J = 1000;
      }
      return;
    }
  }
  
  public void close()
  {
    x.b(I, "close", "113");
    A.a(false);
    x.b(I, "close", "114");
  }
  
  public class a
    implements a
  {
    public final String a;
    
    public a(String paramString)
    {
      a = paramString;
    }
    
    public final void a(int paramInt)
    {
      ??? = new StringBuilder(String.valueOf(a));
      ((StringBuilder)???).append(":rescheduleReconnectCycle");
      Object localObject2 = ((StringBuilder)???).toString();
      ??? = f.this;
      x.b(f.I, (String)localObject2, "505", new Object[] { y, String.valueOf(f.J) });
      synchronized (f.K)
      {
        if (D.o) {
          if (F != null)
          {
            Timer localTimer = F;
            localObject2 = new l/c/a/a/a/f$c;
            ((f.c)localObject2).<init>(f.this, null);
            localTimer.schedule((TimerTask)localObject2, paramInt);
          }
          else
          {
            f.J = paramInt;
            f.a(f.this);
          }
        }
        return;
      }
    }
    
    public void a(e parame)
    {
      x.b(f.I, a, "501", new Object[] { a.k).y });
      parame = f.this;
      if (A != null)
      {
        parame.c();
        return;
      }
      throw null;
    }
    
    public void a(e parame, Throwable paramThrowable)
    {
      x.b(f.I, a, "502", new Object[] { a.k).y });
      int i = f.J;
      if (i < D.p) {
        f.J = i * 2;
      }
      a(f.J);
    }
  }
  
  public class b
    implements h
  {
    public final boolean a;
    
    public b(boolean paramBoolean)
    {
      a = paramBoolean;
    }
    
    public void a(boolean paramBoolean, String paramString) {}
    
    public void connectionLost(Throwable paramThrowable)
    {
      if (a)
      {
        paramThrowable = f.this;
        if (A != null)
        {
          G = true;
          f.a(paramThrowable);
        }
        else
        {
          throw null;
        }
      }
    }
    
    public void deliveryComplete(c paramc) {}
    
    public void messageArrived(String paramString, l paraml) {}
  }
  
  public class c
    extends TimerTask
  {
    public void run()
    {
      x.x.b(f.I, "ReconnectTask.run", "506");
      f localf = x;
      x.b(f.I, "attemptReconnect", "500", new Object[] { y });
      try
      {
        i locali = D;
        Object localObject = E;
        f.a locala = new l/c/a/a/a/f$a;
        locala.<init>(localf, "attemptReconnect");
        localf.a(locali, localObject, locala);
      }
      catch (k localk)
      {
        x.a(f.I, "attemptReconnect", "804", null, localk);
      }
      catch (p localp)
      {
        x.a(f.I, "attemptReconnect", "804", null, localp);
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */