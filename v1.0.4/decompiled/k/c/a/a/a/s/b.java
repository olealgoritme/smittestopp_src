package k.c.a.a.a.s;

import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import k.c.a.a.a.r.a;
import k.c.a.a.a.s.s.d;
import k.c.a.a.a.s.s.i;
import k.c.a.a.a.s.s.n;
import k.c.a.a.a.s.s.s;
import k.c.a.a.a.s.s.t;
import k.c.a.a.a.s.s.u;

public class b
{
  public Hashtable A = null;
  public Hashtable B = null;
  public k.c.a.a.a.o C = null;
  public k.c.a.a.a.t.b a = k.c.a.a.a.t.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "k.c.a.a.a.s.b");
  public int b = 0;
  public Hashtable c;
  public volatile Vector d;
  public volatile Vector e;
  public f f;
  public a g = null;
  public c h = null;
  public long i;
  public boolean j;
  public k.c.a.a.a.u.a k;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public final Object o = new Object();
  public final Object p = new Object();
  public boolean q = false;
  public long r = 0L;
  public long s = 0L;
  public long t = 0L;
  public u u;
  public final Object v = new Object();
  public int w = 0;
  public boolean x = false;
  public Hashtable y = null;
  public Hashtable z = null;
  
  public b(k.c.a.a.a.u.a parama, f paramf, c paramc, a parama1, k.c.a.a.a.o paramo)
  {
    a.a(c).y);
    a.a("k.c.a.a.a.s.b", "<Init>", "");
    c = new Hashtable();
    e = new Vector();
    y = new Hashtable();
    z = new Hashtable();
    A = new Hashtable();
    B = new Hashtable();
    u = new i();
    n = 0;
    m = 0;
    k = parama;
    h = paramc;
    f = paramf;
    g = parama1;
    C = paramo;
    parama.a();
    parama = x.keys();
    int i1 = b;
    paramf = new Vector();
    a.b("k.c.a.a.a.s.b", "restoreState", "600");
    for (;;)
    {
      if (!parama.hasMoreElements())
      {
        parama = paramf.elements();
        for (;;)
        {
          if (!parama.hasMoreElements())
          {
            b = i1;
            return;
          }
          paramf = (String)parama.nextElement();
          a.b("k.c.a.a.a.s.b", "restoreState", "609", new Object[] { paramf });
          k.a(paramf);
        }
      }
      paramc = (String)parama.nextElement();
      parama1 = k;
      parama1.a();
      parama1 = a(paramc, (k.c.a.a.a.m)x.get(paramc));
      if (parama1 != null) {
        if (paramc.startsWith("r-"))
        {
          a.b("k.c.a.a.a.s.b", "restoreState", "604", new Object[] { paramc, parama1 });
          B.put(Integer.valueOf(b), parama1);
        }
        else if (paramc.startsWith("s-"))
        {
          paramo = (k.c.a.a.a.s.s.o)parama1;
          i1 = Math.max(b, i1);
          Object localObject1 = k;
          Object localObject2 = c(paramo);
          ((k.c.a.a.a.u.a)localObject1).a();
          if (x.containsKey(localObject2))
          {
            localObject2 = k;
            localObject1 = c(paramo);
            ((k.c.a.a.a.u.a)localObject2).a();
            localObject2 = (n)a(paramc, (k.c.a.a.a.m)x.get(localObject1));
            if (localObject2 != null)
            {
              a.b("k.c.a.a.a.s.b", "restoreState", "605", new Object[] { paramc, parama1 });
              y.put(Integer.valueOf(b), localObject2);
            }
            else
            {
              a.b("k.c.a.a.a.s.b", "restoreState", "606", new Object[] { paramc, parama1 });
            }
          }
          else
          {
            c = true;
            if (g.c == 2)
            {
              a.b("k.c.a.a.a.s.b", "restoreState", "607", new Object[] { paramc, parama1 });
              y.put(Integer.valueOf(b), paramo);
            }
            else
            {
              a.b("k.c.a.a.a.s.b", "restoreState", "608", new Object[] { paramc, parama1 });
              z.put(Integer.valueOf(b), paramo);
            }
          }
          f.a(paramo).a.k = g.c;
          c.put(Integer.valueOf(b), Integer.valueOf(b));
        }
        else if (paramc.startsWith("sb-"))
        {
          paramo = (k.c.a.a.a.s.s.o)parama1;
          i1 = Math.max(b, i1);
          int i2 = g.c;
          if (i2 == 2)
          {
            a.b("k.c.a.a.a.s.b", "restoreState", "607", new Object[] { paramc, parama1 });
            y.put(Integer.valueOf(b), paramo);
          }
          else if (i2 == 1)
          {
            a.b("k.c.a.a.a.s.b", "restoreState", "608", new Object[] { paramc, parama1 });
            z.put(Integer.valueOf(b), paramo);
          }
          else
          {
            a.b("k.c.a.a.a.s.b", "restoreState", "511", new Object[] { paramc, parama1 });
            A.put(Integer.valueOf(b), paramo);
            parama1 = k;
            parama1.a();
            x.remove(paramc);
          }
          f.a(paramo).a.k = g.c;
          c.put(Integer.valueOf(b), Integer.valueOf(b));
        }
        else if (paramc.startsWith("sc-"))
        {
          paramo = (n)parama1;
          parama1 = k;
          paramo = d(paramo);
          parama1.a();
          if (!x.containsKey(paramo)) {
            paramf.addElement(paramc);
          }
        }
      }
    }
  }
  
  public final String a(u paramu)
  {
    StringBuilder localStringBuilder = new StringBuilder("r-");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public final Vector a(Vector paramVector)
  {
    Vector localVector = new Vector();
    if (paramVector.size() == 0) {
      return localVector;
    }
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    for (;;)
    {
      if (i2 >= paramVector.size())
      {
        if (65535 - i3 + elementAt0b > i4) {
          i2 = 0;
        } else {
          i2 = i5;
        }
        for (i5 = i2;; i5++)
        {
          if (i5 >= paramVector.size()) {
            for (i5 = i1;; i5++)
            {
              if (i5 >= i2) {
                return localVector;
              }
              localVector.addElement(paramVector.elementAt(i5));
            }
          }
          localVector.addElement(paramVector.elementAt(i5));
        }
      }
      int i6 = elementAtb;
      i3 = i6 - i3;
      int i7 = i4;
      if (i3 > i4)
      {
        i5 = i2;
        i7 = i3;
      }
      i2++;
      i3 = i6;
      i4 = i7;
    }
  }
  
  public k.c.a.a.a.q a(k.c.a.a.a.a parama)
  {
    a.b("k.c.a.a.a.s.b", "checkForActivity", "616", new Object[0]);
    synchronized (p)
    {
      boolean bool = q;
      ??? = null;
      if (bool) {
        return null;
      }
      long l1 = i;
      ??? = ???;
      if (x)
      {
        ??? = ???;
        if (l1 > 0L)
        {
          l1 = System.nanoTime();
          synchronized (v)
          {
            if ((w > 0) && (l1 - s >= i + 100000))
            {
              a.a("k.c.a.a.a.s.b", "checkForActivity", "619", new Object[] { Long.valueOf(i), Long.valueOf(r), Long.valueOf(s), Long.valueOf(l1), Long.valueOf(t) });
              throw k.b.c.e.a.a(32000);
            }
            if ((w == 0) && (l1 - r >= i * 2L))
            {
              a.a("k.c.a.a.a.s.b", "checkForActivity", "642", new Object[] { Long.valueOf(i), Long.valueOf(r), Long.valueOf(s), Long.valueOf(l1), Long.valueOf(t) });
              throw k.b.c.e.a.a(32002);
            }
            if (((w == 0) && (l1 - s >= i - 100000)) || (l1 - r >= i - 100000))
            {
              a.b("k.c.a.a.a.s.b", "checkForActivity", "620", new Object[] { Long.valueOf(i), Long.valueOf(r), Long.valueOf(s) });
              ??? = new k/c/a/a/a/q;
              ((k.c.a.a.a.q)???).<init>(g.c).y);
              if (parama != null) {
                a.l = parama;
              }
              f.a((k.c.a.a.a.q)???, u);
              e.insertElementAt(u, 0);
              l1 = g();
              i();
              parama = (k.c.a.a.a.a)???;
            }
            else
            {
              a.b("k.c.a.a.a.s.b", "checkForActivity", "634", null);
              l1 = Math.max(1L, g() - (l1 - r));
              parama = null;
            }
            a.b("k.c.a.a.a.s.b", "checkForActivity", "624", new Object[] { Long.valueOf(l1) });
            ??? = (k.c.a.a.a.r)C;
            c.schedule(new r.a((k.c.a.a.a.r)???, null), l1);
            ??? = parama;
          }
        }
      }
      return (k.c.a.a.a.q)???;
    }
  }
  
  public final u a(String paramString, k.c.a.a.a.m paramm)
  {
    try
    {
      paramm = u.a(paramm);
    }
    catch (k.c.a.a.a.k paramm)
    {
      a.a("k.c.a.a.a.s.b", "restoreMessage", "602", new Object[] { paramString }, paramm);
      if (!(y instanceof EOFException)) {
        break label100;
      }
    }
    if (paramString != null)
    {
      paramm = k;
      paramm.a();
      x.remove(paramString);
    }
    paramm = null;
    a.b("k.c.a.a.a.s.b", "restoreMessage", "601", new Object[] { paramString, paramm });
    return paramm;
    label100:
    throw paramm;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      s = System.nanoTime();
    }
    a.b("k.c.a.a.a.s.b", "notifyReceivedBytes", "630", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      a.b("k.c.a.a.a.s.b", "quiesce", "637", new Object[] { Long.valueOf(paramLong) });
      synchronized (o)
      {
        q = true;
        h.d();
        i();
        for (;;)
        {
          try
          {
            synchronized (p)
            {
              int i1 = f.b();
              if ((i1 > 0) || (e.size() > 0) || (!h.a()))
              {
                a.b("k.c.a.a.a.s.b", "quiesce", "639", new Object[] { Integer.valueOf(m), Integer.valueOf(e.size()), Integer.valueOf(n), Integer.valueOf(i1) });
                p.wait(paramLong);
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;) {}
          }
          synchronized (o)
          {
            d.clear();
            e.clear();
            q = false;
            m = 0;
            a.b("k.c.a.a.a.s.b", "quiesce", "640");
          }
        }
        throw ((Throwable)???);
      }
    }
  }
  
  public final void a(Vector paramVector, u paramu)
  {
    int i1 = b;
    for (int i2 = 0;; i2++)
    {
      if (i2 >= paramVector.size())
      {
        paramVector.addElement(paramu);
        return;
      }
      if (elementAtb > i1)
      {
        paramVector.insertElementAt(paramu, i2);
        return;
      }
    }
  }
  
  public void a(k.c.a.a.a.k arg1)
  {
    a.b("k.c.a.a.a.s.b", "disconnected", "633", new Object[] { ??? });
    x = false;
    try
    {
      if (j) {
        b();
      }
      d.clear();
      e.clear();
      synchronized (v)
      {
        w = 0;
      }
      return;
    }
    catch (k.c.a.a.a.k ???)
    {
      for (;;) {}
    }
  }
  
  public void a(k.c.a.a.a.q paramq)
  {
    u localu = a.g;
    if ((localu != null) && ((localu instanceof k.c.a.a.a.s.s.b)))
    {
      a.b("k.c.a.a.a.s.b", "notifyComplete", "629", new Object[] { Integer.valueOf(b), paramq, localu });
      paramq = (k.c.a.a.a.s.s.b)localu;
      if ((paramq instanceof k.c.a.a.a.s.s.k))
      {
        k.a(d(localu));
        k.a(b(localu));
        z.remove(Integer.valueOf(b));
        e();
        c(b);
        f.b(localu);
        a.b("k.c.a.a.a.s.b", "notifyComplete", "650", new Object[] { Integer.valueOf(b) });
      }
      else if ((paramq instanceof k.c.a.a.a.s.s.l))
      {
        k.a(d(localu));
        k.a(c(localu));
        k.a(b(localu));
        y.remove(Integer.valueOf(b));
        n -= 1;
        e();
        c(b);
        f.b(localu);
        a.b("k.c.a.a.a.s.b", "notifyComplete", "645", new Object[] { Integer.valueOf(b), Integer.valueOf(n) });
      }
      a();
    }
  }
  
  public void a(k.c.a.a.a.s.s.b arg1)
  {
    s = System.nanoTime();
    a.b("k.c.a.a.a.s.b", "notifyReceivedAck", "627", new Object[] { Integer.valueOf(b), ??? });
    k.c.a.a.a.q localq = f.a(???);
    if (localq == null)
    {
      a.b("k.c.a.a.a.s.b", "notifyReceivedAck", "662", new Object[] { Integer.valueOf(b) });
    }
    else if ((??? instanceof k.c.a.a.a.s.s.m))
    {
      a(new n((k.c.a.a.a.s.s.m)???), localq);
    }
    else if ((!(??? instanceof k.c.a.a.a.s.s.k)) && (!(??? instanceof k.c.a.a.a.s.s.l)))
    {
      if ((??? instanceof k.c.a.a.a.s.s.j)) {
        synchronized (v)
        {
          w = Math.max(0, w - 1);
          a(???, localq, null);
          if (w == 0) {
            f.b(???);
          }
          a.b("k.c.a.a.a.s.b", "notifyReceivedAck", "636", new Object[] { Integer.valueOf(w) });
        }
      }
      if ((??? instanceof k.c.a.a.a.s.s.c))
      {
        k.c.a.a.a.s.s.c localc = (k.c.a.a.a.s.s.c)???;
        int i1 = g;
        if (i1 == 0) {
          synchronized (o)
          {
            if (j)
            {
              b();
              f.a(localq, ???);
            }
            n = 0;
            m = 0;
            j();
            d();
            g.a(localc, null);
            a(???, localq, null);
            f.b(???);
            synchronized (o)
            {
              o.notifyAll();
            }
          }
        }
        throw k.b.c.e.a.a(i1);
      }
      a(???, localq, null);
      c(b);
      f.b(???);
    }
    else
    {
      a(???, localq, null);
    }
    a();
  }
  
  public void a(k.c.a.a.a.s.s.o paramo)
  {
    synchronized (o)
    {
      a.b("k.c.a.a.a.s.b", "undo", "618", new Object[] { Integer.valueOf(b), Integer.valueOf(g.c) });
      if (g.c == 1) {
        z.remove(Integer.valueOf(b));
      } else {
        y.remove(Integer.valueOf(b));
      }
      d.removeElement(paramo);
      k.a(d(paramo));
      f.b(paramo);
      if (g.c > 0)
      {
        c(b);
        paramo.a(0);
      }
      a();
      return;
    }
  }
  
  public void a(u paramu, k.c.a.a.a.q paramq)
  {
    if ((paramu.m()) && (b == 0)) {
      if (((paramu instanceof k.c.a.a.a.s.s.o)) && (g.c != 0)) {
        paramu.a(h());
      } else if (((paramu instanceof k.c.a.a.a.s.s.k)) || ((paramu instanceof k.c.a.a.a.s.s.m)) || ((paramu instanceof n)) || ((paramu instanceof k.c.a.a.a.s.s.l)) || ((paramu instanceof k.c.a.a.a.s.s.r)) || ((paramu instanceof k.c.a.a.a.s.s.q)) || ((paramu instanceof t)) || ((paramu instanceof s))) {
        paramu.a(h());
      }
    }
    if (paramq != null)
    {
      d = paramq;
      try
      {
        a.n = b;
      }
      catch (Exception localException) {}
    }
    if ((paramu instanceof k.c.a.a.a.s.s.o)) {
      synchronized (o)
      {
        if (m < l)
        {
          k.c.a.a.a.l locall = g;
          a.b("k.c.a.a.a.s.b", "send", "628", new Object[] { Integer.valueOf(b), Integer.valueOf(c), paramu });
          int i1 = c;
          if (i1 != 1)
          {
            if (i1 == 2)
            {
              y.put(Integer.valueOf(b), paramu);
              k.a(d(paramu), (k.c.a.a.a.s.s.o)paramu);
              f.a(paramq, paramu);
            }
          }
          else
          {
            z.put(Integer.valueOf(b), paramu);
            k.a(d(paramu), (k.c.a.a.a.s.s.o)paramu);
            f.a(paramq, paramu);
          }
          d.addElement(paramu);
          o.notifyAll();
          break label589;
        }
        a.b("k.c.a.a.a.s.b", "send", "613", new Object[] { Integer.valueOf(m) });
        paramu = new k/c/a/a/a/k;
        paramu.<init>(32202);
        throw paramu;
      }
    }
    a.b("k.c.a.a.a.s.b", "send", "615", new Object[] { Integer.valueOf(b), paramu });
    if ((paramu instanceof d)) {
      synchronized (o)
      {
        f.a(paramq, paramu);
        e.insertElementAt(paramu, 0);
        o.notifyAll();
      }
    }
    if ((paramu instanceof i))
    {
      u = paramu;
    }
    else if ((paramu instanceof n))
    {
      y.put(Integer.valueOf(b), paramu);
      k.a(c(paramu), (n)paramu);
    }
    else if ((paramu instanceof k.c.a.a.a.s.s.l))
    {
      k.a(a(paramu));
    }
    synchronized (o)
    {
      if (!(paramu instanceof k.c.a.a.a.s.s.b)) {
        f.a(paramq, paramu);
      }
      e.addElement(paramu);
      o.notifyAll();
      label589:
      return;
    }
  }
  
  public void a(u paramu, k.c.a.a.a.q paramq, k.c.a.a.a.k paramk)
  {
    a.a(paramu, paramk);
    a.a();
    if ((paramu != null) && ((paramu instanceof k.c.a.a.a.s.s.b)) && (!(paramu instanceof k.c.a.a.a.s.s.m)))
    {
      a.b("k.c.a.a.a.s.b", "notifyResult", "648", new Object[] { a.j, paramu, paramk });
      h.a(paramq);
    }
    if (paramu == null)
    {
      a.b("k.c.a.a.a.s.b", "notifyResult", "649", new Object[] { a.j, paramk });
      h.a(paramq);
    }
  }
  
  public boolean a()
  {
    int i1 = f.b();
    if ((q) && (i1 == 0) && (e.size() == 0) && (h.a()))
    {
      a.b("k.c.a.a.a.s.b", "checkQuiesceLock", "626", new Object[] { Boolean.valueOf(q), Integer.valueOf(m), Integer.valueOf(e.size()), Integer.valueOf(n), Boolean.valueOf(h.a()), Integer.valueOf(i1) });
      synchronized (p)
      {
        p.notifyAll();
        return true;
      }
    }
    return false;
  }
  
  public final String b(u paramu)
  {
    StringBuilder localStringBuilder = new StringBuilder("sb-");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public Vector b(k.c.a.a.a.k arg1)
  {
    a.b("k.c.a.a.a.s.b", "resolveOldTokens", "632", new Object[] { ??? });
    k.c.a.a.a.k localk = ???;
    if (??? == null) {
      localk = new k.c.a.a.a.k(32102);
    }
    Vector localVector = f.d();
    Enumeration localEnumeration = localVector.elements();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        return localVector;
      }
      synchronized ((k.c.a.a.a.q)localEnumeration.nextElement())
      {
        if ((!a.b) && (!a.c) && (a.h == null)) {
          a.a(localk);
        }
        if ((??? instanceof k.c.a.a.a.j)) {
          continue;
        }
        f.a(a.j);
        continue;
        throw localk;
      }
    }
  }
  
  public void b()
  {
    a.b("k.c.a.a.a.s.b", "clearState", ">");
    k.c.a.a.a.u.a locala = k;
    locala.a();
    x.clear();
    c.clear();
    d.clear();
    e.clear();
    y.clear();
    z.clear();
    A.clear();
    B.clear();
    f.a();
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      r = System.nanoTime();
    }
    a.b("k.c.a.a.a.s.b", "notifySentBytes", "643", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final String c(u paramu)
  {
    StringBuilder localStringBuilder = new StringBuilder("sc-");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public void c()
  {
    c.clear();
    if (d != null) {
      d.clear();
    }
    e.clear();
    y.clear();
    z.clear();
    A.clear();
    B.clear();
    f.a();
    c = null;
    d = null;
    e = null;
    y = null;
    z = null;
    A = null;
    B = null;
    f = null;
    h = null;
    g = null;
    k = null;
    u = null;
  }
  
  public final void c(int paramInt)
  {
    try
    {
      c.remove(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String d(u paramu)
  {
    StringBuilder localStringBuilder = new StringBuilder("s-");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public void d()
  {
    a.b("k.c.a.a.a.s.b", "connected", "631");
    x = true;
    k.c.a.a.a.r localr = (k.c.a.a.a.r)C;
    a.b("k.c.a.a.a.r", "start", "659", new Object[] { d });
    Object localObject = new StringBuilder("MQTT Ping: ");
    ((StringBuilder)localObject).append(d);
    localObject = new Timer(((StringBuilder)localObject).toString());
    c = ((Timer)localObject);
    ((Timer)localObject).schedule(new r.a(localr, null), b.i.g());
  }
  
  public final void e()
  {
    synchronized (o)
    {
      int i1 = m - 1;
      m = i1;
      a.b("k.c.a.a.a.s.b", "decrementInFlight", "646", new Object[] { Integer.valueOf(i1) });
      if (!a()) {
        o.notifyAll();
      }
      return;
    }
  }
  
  public void e(u paramu)
  {
    s = System.nanoTime();
    a.b("k.c.a.a.a.s.b", "notifyReceivedMsg", "651", new Object[] { Integer.valueOf(b), paramu });
    if (!q)
    {
      k.c.a.a.a.s.s.o localo;
      if ((paramu instanceof k.c.a.a.a.s.s.o))
      {
        localo = (k.c.a.a.a.s.s.o)paramu;
        int i1 = g.c;
        if ((i1 != 0) && (i1 != 1))
        {
          if (i1 == 2)
          {
            k.a(a(paramu), localo);
            B.put(Integer.valueOf(b), localo);
            a(new k.c.a.a.a.s.s.m(localo), null);
          }
        }
        else
        {
          paramu = h;
          if (paramu != null) {
            paramu.b(localo);
          }
        }
      }
      else if ((paramu instanceof n))
      {
        localo = (k.c.a.a.a.s.s.o)B.get(Integer.valueOf(b));
        if (localo != null)
        {
          paramu = h;
          if (paramu != null) {
            paramu.b(localo);
          }
        }
        else
        {
          a(new k.c.a.a.a.s.s.l(b), null);
        }
      }
    }
  }
  
  /* Error */
  public u f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	k/c/a/a/a/s/b:o	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_1
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 416	k/c/a/a/a/s/b:d	Ljava/util/Vector;
    //   21: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   31: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   34: ifne +30 -> 64
    //   37: aload_0
    //   38: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   41: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   44: ifeq +61 -> 105
    //   47: aload_0
    //   48: getfield 72	k/c/a/a/a/s/b:m	I
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 70	k/c/a/a/a/s/b:l	I
    //   56: istore 4
    //   58: iload_3
    //   59: iload 4
    //   61: if_icmplt +44 -> 105
    //   64: aload_0
    //   65: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   68: ldc 55
    //   70: ldc_w 638
    //   73: ldc_w 640
    //   76: invokeinterface 159 4 0
    //   81: aload_0
    //   82: getfield 76	k/c/a/a/a/s/b:o	Ljava/lang/Object;
    //   85: invokevirtual 642	java/lang/Object:wait	()V
    //   88: aload_0
    //   89: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   92: ldc 55
    //   94: ldc_w 638
    //   97: ldc_w 644
    //   100: invokeinterface 159 4 0
    //   105: aload_0
    //   106: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   109: ifnull +221 -> 330
    //   112: aload_0
    //   113: getfield 92	k/c/a/a/a/s/b:x	Z
    //   116: ifne +33 -> 149
    //   119: aload_0
    //   120: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   123: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   126: ifne +204 -> 330
    //   129: aload_0
    //   130: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   133: iconst_0
    //   134: invokevirtual 298	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   137: checkcast 199	k/c/a/a/a/s/s/u
    //   140: instanceof 539
    //   143: ifne +6 -> 149
    //   146: goto +184 -> 330
    //   149: aload_0
    //   150: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   153: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   156: ifne +70 -> 226
    //   159: aload_0
    //   160: getfield 134	k/c/a/a/a/s/b:e	Ljava/util/Vector;
    //   163: iconst_0
    //   164: invokevirtual 646	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   167: checkcast 199	k/c/a/a/a/s/s/u
    //   170: astore_2
    //   171: aload_2
    //   172: instanceof 229
    //   175: ifeq +43 -> 218
    //   178: aload_0
    //   179: getfield 74	k/c/a/a/a/s/b:n	I
    //   182: iconst_1
    //   183: iadd
    //   184: istore_3
    //   185: aload_0
    //   186: iload_3
    //   187: putfield 74	k/c/a/a/a/s/b:n	I
    //   190: aload_0
    //   191: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   194: ldc 55
    //   196: ldc_w 638
    //   199: ldc_w 648
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_3
    //   209: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokeinterface 179 5 0
    //   218: aload_0
    //   219: invokevirtual 458	k/c/a/a/a/s/b:a	()Z
    //   222: pop
    //   223: goto -214 -> 9
    //   226: aload_0
    //   227: getfield 416	k/c/a/a/a/s/b:d	Ljava/util/Vector;
    //   230: invokevirtual 637	java/util/Vector:isEmpty	()Z
    //   233: ifne -224 -> 9
    //   236: aload_0
    //   237: getfield 72	k/c/a/a/a/s/b:m	I
    //   240: aload_0
    //   241: getfield 70	k/c/a/a/a/s/b:l	I
    //   244: if_icmpge +66 -> 310
    //   247: aload_0
    //   248: getfield 416	k/c/a/a/a/s/b:d	Ljava/util/Vector;
    //   251: iconst_0
    //   252: invokevirtual 298	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   255: checkcast 199	k/c/a/a/a/s/s/u
    //   258: astore_2
    //   259: aload_0
    //   260: getfield 416	k/c/a/a/a/s/b:d	Ljava/util/Vector;
    //   263: iconst_0
    //   264: invokevirtual 651	java/util/Vector:removeElementAt	(I)V
    //   267: aload_0
    //   268: getfield 72	k/c/a/a/a/s/b:m	I
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: aload_0
    //   275: iload_3
    //   276: putfield 72	k/c/a/a/a/s/b:m	I
    //   279: aload_0
    //   280: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   283: ldc 55
    //   285: ldc_w 638
    //   288: ldc_w 653
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: iload_3
    //   298: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: invokeinterface 179 5 0
    //   307: goto -298 -> 9
    //   310: aload_0
    //   311: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   314: ldc 55
    //   316: ldc_w 638
    //   319: ldc_w 655
    //   322: invokeinterface 159 4 0
    //   327: goto -318 -> 9
    //   330: aload_0
    //   331: getfield 62	k/c/a/a/a/s/b:a	Lk/c/a/a/a/t/b;
    //   334: ldc 55
    //   336: ldc_w 638
    //   339: ldc_w 657
    //   342: invokeinterface 159 4 0
    //   347: aload_1
    //   348: monitorexit
    //   349: aconst_null
    //   350: areturn
    //   351: astore_2
    //   352: aload_1
    //   353: monitorexit
    //   354: aload_2
    //   355: athrow
    //   356: astore 5
    //   358: goto -253 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	b
    //   4	349	1	localObject1	Object
    //   8	251	2	localu	u
    //   351	4	2	localObject2	Object
    //   51	247	3	i1	int
    //   56	6	4	i2	int
    //   356	1	5	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   13	15	351	finally
    //   17	37	351	finally
    //   37	58	351	finally
    //   64	105	351	finally
    //   105	146	351	finally
    //   149	218	351	finally
    //   218	223	351	finally
    //   226	307	351	finally
    //   310	327	351	finally
    //   330	349	351	finally
    //   352	354	351	finally
    //   64	105	356	java/lang/InterruptedException
  }
  
  public void f(u arg1)
  {
    r = System.nanoTime();
    a.b("k.c.a.a.a.s.b", "notifySent", "625", new Object[] { ???.i() });
    k.c.a.a.a.q localq1 = d;
    ??? = localq1;
    if (localq1 == null)
    {
      localq1 = f.a(???);
      ??? = localq1;
      if (localq1 == null) {
        return;
      }
    }
    a.b();
    if ((??? instanceof i)) {
      synchronized (v)
      {
        long l1 = System.nanoTime();
        synchronized (v)
        {
          t = l1;
          int i1 = w + 1;
          w = i1;
          a.b("k.c.a.a.a.s.b", "notifySent", "635", new Object[] { Integer.valueOf(i1) });
        }
      }
    }
    if (((??? instanceof k.c.a.a.a.s.s.o)) && (g.c == 0))
    {
      a.a(null, null);
      h.a(localq2);
      e();
      c(b);
      f.b(???);
      a();
    }
  }
  
  public long g()
  {
    return TimeUnit.NANOSECONDS.toMillis(i);
  }
  
  public final int h()
  {
    try
    {
      int i1 = b;
      int i2 = 0;
      do
      {
        int i3 = b + 1;
        b = i3;
        if (i3 > 65535) {
          b = 1;
        }
        i3 = i2;
        if (b == i1)
        {
          i3 = i2 + 1;
          if (i3 == 2) {
            throw k.b.c.e.a.a(32001);
          }
        }
        i2 = i3;
      } while (c.containsKey(Integer.valueOf(b)));
      Integer localInteger = Integer.valueOf(b);
      c.put(localInteger, localInteger);
      i2 = b;
      return i2;
    }
    finally {}
  }
  
  public void i()
  {
    synchronized (o)
    {
      a.b("k.c.a.a.a.s.b", "notifyQueueLock", "638");
      o.notifyAll();
      return;
    }
  }
  
  public final void j()
  {
    d = new Vector(l);
    e = new Vector();
    Enumeration localEnumeration = y.keys();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements())
      {
        localEnumeration = z.keys();
        for (;;)
        {
          if (!localEnumeration.hasMoreElements())
          {
            localEnumeration = A.keys();
            for (;;)
            {
              if (!localEnumeration.hasMoreElements())
              {
                e = a(e);
                d = a(d);
                return;
              }
              localObject1 = localEnumeration.nextElement();
              localObject2 = (k.c.a.a.a.s.s.o)A.get(localObject1);
              a.b("k.c.a.a.a.s.b", "restoreInflightMessages", "512", new Object[] { localObject1 });
              a(d, (u)localObject2);
            }
          }
          localObject2 = localEnumeration.nextElement();
          localObject1 = (k.c.a.a.a.s.s.o)z.get(localObject2);
          c = true;
          a.b("k.c.a.a.a.s.b", "restoreInflightMessages", "612", new Object[] { localObject2 });
          a(d, (u)localObject1);
        }
      }
      Object localObject2 = localEnumeration.nextElement();
      Object localObject1 = (u)y.get(localObject2);
      if ((localObject1 instanceof k.c.a.a.a.s.s.o))
      {
        a.b("k.c.a.a.a.s.b", "restoreInflightMessages", "610", new Object[] { localObject2 });
        c = true;
        a(d, (k.c.a.a.a.s.s.o)localObject1);
      }
      else if ((localObject1 instanceof n))
      {
        a.b("k.c.a.a.a.s.b", "restoreInflightMessages", "611", new Object[] { localObject2 });
        a(e, (n)localObject1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */