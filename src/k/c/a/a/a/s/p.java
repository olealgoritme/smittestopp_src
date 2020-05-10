package k.c.a.a.a.s;

import k.c.a.a.a.k;
import k.c.a.a.a.s.s.u;
import k.c.a.a.a.t.c;

public class p
{
  public k.c.a.a.a.t.b a = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "k.c.a.a.a.s.p");
  public volatile boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public final Object e = new Object();
  public final Object f = new Object();
  public u g = null;
  public k h = null;
  public String[] i = null;
  public String j;
  public k.c.a.a.a.b k = null;
  public k.c.a.a.a.a l = null;
  public Object m = null;
  public int n = 0;
  public boolean o = false;
  
  public p(String paramString)
  {
    a.a(paramString);
  }
  
  public void a()
  {
    a.b("k.c.a.a.a.s.p", "notifyComplete", "404", new Object[] { j, g, h });
    synchronized (e)
    {
      if ((h == null) && (c))
      {
        b = true;
        c = false;
      }
      else
      {
        c = false;
      }
      e.notifyAll();
      synchronized (f)
      {
        d = true;
        f.notifyAll();
        return;
      }
    }
  }
  
  public void a(long paramLong)
  {
    a.b("k.c.a.a.a.s.p", "waitForCompletion", "407", new Object[] { j, Long.valueOf(paramLong), this });
    if ((b(paramLong) == null) && (!b))
    {
      a.b("k.c.a.a.a.s.p", "waitForCompletion", "406", new Object[] { j, this });
      localk = new k(32000);
      h = localk;
      throw localk;
    }
    k localk = h;
    if (localk == null) {
      return;
    }
    throw localk;
  }
  
  public void a(k paramk)
  {
    synchronized (e)
    {
      h = paramk;
      return;
    }
  }
  
  public void a(u paramu, k paramk)
  {
    a.b("k.c.a.a.a.s.p", "markComplete", "404", new Object[] { j, paramu, paramk });
    synchronized (e)
    {
      boolean bool = paramu instanceof k.c.a.a.a.s.s.b;
      c = true;
      g = paramu;
      h = paramk;
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    i = ((String[])paramArrayOfString.clone());
  }
  
  public u b(long paramLong)
  {
    synchronized (e)
    {
      k.c.a.a.a.t.b localb = a;
      String str = j;
      boolean bool1 = d;
      boolean bool2 = b;
      Object localObject2;
      if (h == null) {
        localObject2 = "false";
      } else {
        localObject2 = "true";
      }
      u localu = g;
      k localk = h;
      localb.a("k.c.a.a.a.s.p", "waitForResponse", "400", new Object[] { str, Long.valueOf(paramLong), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject2, localu, this }, localk);
      do
      {
        do
        {
          if (b) {
            break;
          }
          localObject2 = h;
          if (localObject2 == null) {
            try
            {
              a.b("k.c.a.a.a.s.p", "waitForResponse", "408", new Object[] { j, Long.valueOf(paramLong) });
              if (paramLong <= 0L) {
                e.wait();
              } else {
                e.wait(paramLong);
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localObject2 = new k/c/a/a/a/k;
              ((k)localObject2).<init>(localInterruptedException);
              h = ((k)localObject2);
            }
          }
        } while (b);
        if (h != null) {
          break label285;
        }
      } while (paramLong <= 0L);
      a.b("k.c.a.a.a.s.p", "waitForResponse", "402", new Object[] { j, g });
      return g;
      label285:
      a.a("k.c.a.a.a.s.p", "waitForResponse", "401", null, h);
      throw h;
    }
  }
  
  public void b()
  {
    a.b("k.c.a.a.a.s.p", "notifySent", "403", new Object[] { j });
    synchronized (e)
    {
      g = null;
      b = false;
      synchronized (f)
      {
        d = true;
        f.notifyAll();
        return;
      }
    }
  }
  
  public void c()
  {
    for (;;)
    {
      synchronized (f)
      {
        synchronized (e)
        {
          if (h == null) {
            if (d)
            {
              if (!d)
              {
                if (h == null) {
                  throw k.b.c.e.a.a(6);
                }
                throw h;
              }
              return;
            }
          }
          try
          {
            a.b("k.c.a.a.a.s.p", "waitUntilSent", "409", new Object[] { j });
            f.wait();
          }
          catch (InterruptedException localInterruptedException) {}
          throw h;
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("key=");
    localStringBuffer.append(j);
    localStringBuffer.append(" ,topics=");
    if (i != null) {
      for (int i1 = 0;; i1++)
      {
        String[] arrayOfString = i;
        if (i1 >= arrayOfString.length) {
          break;
        }
        localStringBuffer.append(arrayOfString[i1]);
        localStringBuffer.append(", ");
      }
    }
    localStringBuffer.append(" ,usercontext=");
    localStringBuffer.append(m);
    localStringBuffer.append(" ,isComplete=");
    localStringBuffer.append(b);
    localStringBuffer.append(" ,isNotified=");
    localStringBuffer.append(o);
    localStringBuffer.append(" ,exception=");
    localStringBuffer.append(h);
    localStringBuffer.append(" ,actioncallback=");
    localStringBuffer.append(l);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */