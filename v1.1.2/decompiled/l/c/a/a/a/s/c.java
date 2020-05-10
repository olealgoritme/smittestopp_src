package l.c.a.a.a.s;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import l.c.a.a.a.d;
import l.c.a.a.a.f;
import l.c.a.a.a.g;
import l.c.a.a.a.h;
import l.c.a.a.a.j;
import l.c.a.a.a.q;
import l.c.a.a.a.s.s.k;
import l.c.a.a.a.s.s.o;
import l.c.a.a.a.s.s.u;

public class c
  implements Runnable
{
  public static final String O = c.class.getName();
  public Hashtable<String, d> A;
  public a B;
  public final Vector<u> C;
  public final Vector<q> D;
  public a E;
  public a F;
  public final Object G;
  public Thread H;
  public String I;
  public Future<?> J;
  public final Object K;
  public final Object L;
  public b M;
  public boolean N;
  public final l.c.a.a.a.t.b x = l.c.a.a.a.t.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", O);
  public g y;
  public h z;
  
  public c(a parama)
  {
    a locala = a.STOPPED;
    E = locala;
    F = locala;
    G = new Object();
    K = new Object();
    L = new Object();
    N = false;
    B = parama;
    C = new Vector(10);
    D = new Vector(10);
    A = new Hashtable();
    x.a(c).y);
  }
  
  public void a(String arg1, ExecutorService paramExecutorService)
  {
    I = ???;
    synchronized (G)
    {
      if (E == a.STOPPED)
      {
        C.clear();
        D.clear();
        F = a.RUNNING;
        if (paramExecutorService == null)
        {
          paramExecutorService = new java/lang/Thread;
          paramExecutorService.<init>(this);
          paramExecutorService.start();
        }
        else
        {
          J = paramExecutorService.submit(this);
        }
      }
      for (;;)
      {
        if (c()) {
          return;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception ???) {}
      }
    }
  }
  
  /* Error */
  public void a(q paramq)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 144	l/c/a/a/a/s/c:c	()Z
    //   4: ifeq +65 -> 69
    //   7: aload_0
    //   8: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   11: aload_1
    //   12: invokevirtual 155	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: getfield 79	l/c/a/a/a/s/c:K	Ljava/lang/Object;
    //   19: astore_2
    //   20: aload_2
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   26: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   29: ldc -99
    //   31: ldc -97
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: getfield 164	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   43: getfield 169	l/c/a/a/a/s/p:j	Ljava/lang/String;
    //   46: aastore
    //   47: invokeinterface 173 5 0
    //   52: aload_0
    //   53: getfield 79	l/c/a/a/a/s/c:K	Ljava/lang/Object;
    //   56: invokevirtual 176	java/lang/Object:notifyAll	()V
    //   59: aload_2
    //   60: monitorexit
    //   61: goto +51 -> 112
    //   64: astore_1
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: aload_0
    //   70: aload_1
    //   71: invokevirtual 178	l/c/a/a/a/s/c:c	(Ll/c/a/a/a/q;)V
    //   74: goto +38 -> 112
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   82: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   85: ldc -99
    //   87: ldc -76
    //   89: aconst_null
    //   90: aload_1
    //   91: invokeinterface 183 6 0
    //   96: aload_0
    //   97: getfield 85	l/c/a/a/a/s/c:B	Ll/c/a/a/a/s/a;
    //   100: aconst_null
    //   101: new 185	l/c/a/a/a/k
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 188	l/c/a/a/a/k:<init>	(Ljava/lang/Throwable;)V
    //   109: invokevirtual 191	l/c/a/a/a/s/a:a	(Ll/c/a/a/a/q;Ll/c/a/a/a/k;)V
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	c
    //   0	113	1	paramq	q
    //   19	47	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	61	64	finally
    //   65	67	64	finally
    //   69	74	77	finally
  }
  
  public final void a(o paramo)
  {
    String str1 = h;
    x.b(O, "handleMessage", "713", new Object[] { Integer.valueOf(b), str1 });
    int i = b;
    Object localObject1 = g;
    Object localObject2 = A.keys();
    int j = 0;
    for (;;)
    {
      if (!((Enumeration)localObject2).hasMoreElements())
      {
        localObject2 = y;
        if ((localObject2 != null) && (j == 0))
        {
          f = i;
          ((g)localObject2).messageArrived(str1, (l.c.a.a.a.l)localObject1);
        }
        if (!N)
        {
          k = g.c;
          if (k == 1)
          {
            B.a(new k(paramo), new q(B.c).y));
          }
          else if (k == 2)
          {
            localObject1 = B.i;
            a.b("l.c.a.a.a.s.b", "deliveryComplete", "641", new Object[] { Integer.valueOf(b) });
            k.a(((b)localObject1).a(paramo));
            B.remove(Integer.valueOf(b));
            localObject1 = new l.c.a.a.a.s.s.l(paramo);
            paramo = B;
            paramo.a((u)localObject1, new q(c).y));
          }
        }
        return;
      }
      String str2 = (String)((Enumeration)localObject2).nextElement();
      int m = str1.length();
      int n = str2.length();
      l.b.c.e.a.a(str2, true);
      l.b.c.e.a.a(str1, false);
      if (!str2.equals(str1))
      {
        int i1 = 0;
        for (k = 0; (i1 < n) && (k < m) && ((str1.charAt(k) != '/') || (str2.charAt(i1) == '/')) && ((str2.charAt(i1) == '+') || (str2.charAt(i1) == '#') || (str2.charAt(i1) == str1.charAt(k))); k++)
        {
          if (str2.charAt(i1) == '+')
          {
            int i3;
            for (int i2 = k;; i2 = i3)
            {
              i3 = i2 + 1;
              k = i2;
              if (i3 >= m) {
                break;
              }
              if (str1.charAt(i3) == '/')
              {
                k = i2;
                break;
              }
            }
          }
          if (str2.charAt(i1) == '#') {
            k = m - 1;
          }
          i1++;
        }
        if ((k != m) || (i1 != n)) {}
      }
      else
      {
        k = 1;
        break label650;
      }
      if ((str2.length() - str1.length() == 2) && (str2.substring(str2.length() - 2, str2.length()).equals("/#")))
      {
        String str3 = str2.substring(0, str2.length() - 2);
        if (str3.equals(str1))
        {
          PrintStream localPrintStream = System.err;
          StringBuilder localStringBuilder = new StringBuilder("filterSub equals topicName: ");
          localStringBuilder.append(str3);
          localStringBuilder.append(" == ");
          localStringBuilder.append(str1);
          localPrintStream.println(localStringBuilder.toString());
          k = 1;
          break label650;
        }
      }
      int k = 0;
      label650:
      if (k != 0)
      {
        f = i;
        ((d)A.get(str2)).messageArrived(str1, (l.c.a.a.a.l)localObject1);
        j = 1;
      }
    }
  }
  
  public boolean a()
  {
    return (b()) && (D.size() == 0) && (C.size() == 0);
  }
  
  public void b(q paramq)
  {
    if (paramq != null)
    {
      p localp = a;
      l.c.a.a.a.a locala = l;
      if (locala != null) {
        if (h == null)
        {
          x.b(O, "fireActionEvent", "716", new Object[] { j });
          locala.a(paramq);
        }
        else
        {
          x.b(O, "fireActionEvent", "716", new Object[] { j });
          locala.a(paramq, a.h);
        }
      }
    }
  }
  
  public void b(o paramo)
  {
    if ((y != null) || (A.size() > 0)) {}
    for (;;)
    {
      synchronized (L)
      {
        if ((c()) && (!b()))
        {
          int i = C.size();
          if (i >= 10) {}
        }
      }
      try
      {
        x.b(O, "messageArrived", "709");
        L.wait(200L);
      }
      catch (InterruptedException localInterruptedException) {}
      if (!b())
      {
        C.addElement(paramo);
        synchronized (K)
        {
          x.b(O, "messageArrived", "710");
          K.notifyAll();
        }
      }
      return;
      paramo = finally;
      throw paramo;
    }
  }
  
  public boolean b()
  {
    synchronized (G)
    {
      boolean bool;
      if (E == a.QUIESCING) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public final void c(q paramq)
  {
    try
    {
      x.b(O, "handleActionComplete", "705", new Object[] { a.j });
      if (a.b) {
        M.a(paramq);
      }
      a.a();
      if (!a.o)
      {
        if ((y != null) && ((paramq instanceof j)) && (a.b)) {
          y.deliveryComplete((j)paramq);
        }
        b(paramq);
      }
      if ((a.b) && ((paramq instanceof j))) {
        a.o = true;
      }
      return;
    }
    finally {}
  }
  
  public boolean c()
  {
    synchronized (G)
    {
      boolean bool;
      if (((E == a.RUNNING) || (E == a.QUIESCING)) && (F == a.RUNNING)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void d()
  {
    synchronized (G)
    {
      if (E == a.RUNNING) {
        E = a.QUIESCING;
      }
      synchronized (L)
      {
        x.b(O, "quiesce", "711");
        L.notifyAll();
        return;
      }
    }
  }
  
  public void e()
  {
    for (;;)
    {
      synchronized (G)
      {
        if (J != null) {
          J.cancel(true);
        }
        if (c())
        {
          x.b(O, "stop", "700");
          synchronized (G)
          {
            F = a.STOPPED;
            if (!Thread.currentThread().equals(H)) {
              synchronized (K)
              {
                x.b(O, "stop", "701");
                K.notifyAll();
                if (c()) {}
              }
            }
          }
        }
      }
      try
      {
        Thread.sleep(100L);
        M.i();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        x.b(O, "stop", "703");
        break label172;
        localObject3 = finally;
        throw ((Throwable)localObject3);
        label172:
        return;
        localObject5 = finally;
        throw ((Throwable)localObject5);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 425	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore_1
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 427	l/c/a/a/a/s/c:H	Ljava/lang/Thread;
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 119	l/c/a/a/a/s/c:I	Ljava/lang/String;
    //   14: invokevirtual 438	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 77	l/c/a/a/a/s/c:G	Ljava/lang/Object;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_0
    //   25: getstatic 125	l/c/a/a/a/s/c$a:RUNNING	Ll/c/a/a/a/s/c$a;
    //   28: putfield 73	l/c/a/a/a/s/c:E	Ll/c/a/a/a/s/c$a;
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_0
    //   34: invokevirtual 144	l/c/a/a/a/s/c:c	()Z
    //   37: ifne +30 -> 67
    //   40: aload_0
    //   41: getfield 77	l/c/a/a/a/s/c:G	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getstatic 71	l/c/a/a/a/s/c$a:STOPPED	Ll/c/a/a/a/s/c$a;
    //   51: putfield 73	l/c/a/a/a/s/c:E	Ll/c/a/a/a/s/c$a;
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 427	l/c/a/a/a/s/c:H	Ljava/lang/Thread;
    //   61: return
    //   62: astore_2
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    //   67: aload_0
    //   68: getfield 79	l/c/a/a/a/s/c:K	Ljava/lang/Object;
    //   71: astore_2
    //   72: aload_2
    //   73: monitorenter
    //   74: aload_0
    //   75: invokevirtual 144	l/c/a/a/a/s/c:c	()Z
    //   78: ifeq +48 -> 126
    //   81: aload_0
    //   82: getfield 92	l/c/a/a/a/s/c:C	Ljava/util/Vector;
    //   85: invokevirtual 441	java/util/Vector:isEmpty	()Z
    //   88: ifeq +38 -> 126
    //   91: aload_0
    //   92: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   95: invokevirtual 441	java/util/Vector:isEmpty	()Z
    //   98: ifeq +28 -> 126
    //   101: aload_0
    //   102: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   105: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   108: ldc_w 442
    //   111: ldc_w 444
    //   114: invokeinterface 373 4 0
    //   119: aload_0
    //   120: getfield 79	l/c/a/a/a/s/c:K	Ljava/lang/Object;
    //   123: invokevirtual 446	java/lang/Object:wait	()V
    //   126: aload_2
    //   127: monitorexit
    //   128: goto +12 -> 140
    //   131: astore_1
    //   132: aload_2
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: goto +186 -> 323
    //   140: aload_0
    //   141: invokevirtual 144	l/c/a/a/a/s/c:c	()Z
    //   144: ifeq +122 -> 266
    //   147: aload_0
    //   148: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   151: astore_2
    //   152: aload_2
    //   153: monitorenter
    //   154: aload_0
    //   155: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   158: invokevirtual 441	java/util/Vector:isEmpty	()Z
    //   161: ifne +26 -> 187
    //   164: aload_0
    //   165: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   168: iconst_0
    //   169: invokevirtual 450	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   172: checkcast 161	l/c/a/a/a/q
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 94	l/c/a/a/a/s/c:D	Ljava/util/Vector;
    //   180: iconst_0
    //   181: invokevirtual 453	java/util/Vector:removeElementAt	(I)V
    //   184: goto +5 -> 189
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_2
    //   190: monitorexit
    //   191: aload_1
    //   192: ifnull +8 -> 200
    //   195: aload_0
    //   196: aload_1
    //   197: invokevirtual 178	l/c/a/a/a/s/c:c	(Ll/c/a/a/a/q;)V
    //   200: aload_0
    //   201: getfield 92	l/c/a/a/a/s/c:C	Ljava/util/Vector;
    //   204: astore_2
    //   205: aload_2
    //   206: monitorenter
    //   207: aload_0
    //   208: getfield 92	l/c/a/a/a/s/c:C	Ljava/util/Vector;
    //   211: invokevirtual 441	java/util/Vector:isEmpty	()Z
    //   214: ifne +26 -> 240
    //   217: aload_0
    //   218: getfield 92	l/c/a/a/a/s/c:C	Ljava/util/Vector;
    //   221: iconst_0
    //   222: invokevirtual 450	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   225: checkcast 194	l/c/a/a/a/s/s/o
    //   228: astore_1
    //   229: aload_0
    //   230: getfield 92	l/c/a/a/a/s/c:C	Ljava/util/Vector;
    //   233: iconst_0
    //   234: invokevirtual 453	java/util/Vector:removeElementAt	(I)V
    //   237: goto +5 -> 242
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_2
    //   243: monitorexit
    //   244: aload_1
    //   245: ifnull +21 -> 266
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual 455	l/c/a/a/a/s/c:a	(Ll/c/a/a/a/s/s/o;)V
    //   253: goto +13 -> 266
    //   256: astore_1
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_2
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    //   266: aload_0
    //   267: invokevirtual 342	l/c/a/a/a/s/c:b	()Z
    //   270: ifeq +11 -> 281
    //   273: aload_0
    //   274: getfield 391	l/c/a/a/a/s/c:M	Ll/c/a/a/a/s/b;
    //   277: invokevirtual 457	l/c/a/a/a/s/b:a	()Z
    //   280: pop
    //   281: aload_0
    //   282: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   285: astore_1
    //   286: aload_1
    //   287: monitorenter
    //   288: aload_0
    //   289: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   292: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   295: ldc_w 442
    //   298: ldc_w 459
    //   301: invokeinterface 373 4 0
    //   306: aload_0
    //   307: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   310: invokevirtual 176	java/lang/Object:notifyAll	()V
    //   313: aload_1
    //   314: monitorexit
    //   315: goto -282 -> 33
    //   318: astore_2
    //   319: aload_1
    //   320: monitorexit
    //   321: aload_2
    //   322: athrow
    //   323: aload_0
    //   324: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   327: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   330: ldc_w 442
    //   333: ldc_w 461
    //   336: aconst_null
    //   337: aload_1
    //   338: invokeinterface 183 6 0
    //   343: aload_0
    //   344: getfield 85	l/c/a/a/a/s/c:B	Ll/c/a/a/a/s/a;
    //   347: astore_3
    //   348: new 185	l/c/a/a/a/k
    //   351: astore_2
    //   352: aload_2
    //   353: aload_1
    //   354: invokespecial 188	l/c/a/a/a/k:<init>	(Ljava/lang/Throwable;)V
    //   357: aload_3
    //   358: aconst_null
    //   359: aload_2
    //   360: invokevirtual 191	l/c/a/a/a/s/a:a	(Ll/c/a/a/a/q;Ll/c/a/a/a/k;)V
    //   363: aload_0
    //   364: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   367: astore_1
    //   368: aload_1
    //   369: monitorenter
    //   370: aload_0
    //   371: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   374: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   377: ldc_w 442
    //   380: ldc_w 459
    //   383: invokeinterface 373 4 0
    //   388: aload_0
    //   389: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   392: invokevirtual 176	java/lang/Object:notifyAll	()V
    //   395: aload_1
    //   396: monitorexit
    //   397: goto -364 -> 33
    //   400: astore_2
    //   401: aload_1
    //   402: monitorexit
    //   403: aload_2
    //   404: athrow
    //   405: astore_2
    //   406: aload_0
    //   407: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   410: astore_1
    //   411: aload_1
    //   412: monitorenter
    //   413: aload_0
    //   414: getfield 68	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   417: getstatic 54	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   420: ldc_w 442
    //   423: ldc_w 459
    //   426: invokeinterface 373 4 0
    //   431: aload_0
    //   432: getfield 81	l/c/a/a/a/s/c:L	Ljava/lang/Object;
    //   435: invokevirtual 176	java/lang/Object:notifyAll	()V
    //   438: aload_1
    //   439: monitorexit
    //   440: aload_2
    //   441: athrow
    //   442: astore_2
    //   443: aload_1
    //   444: monitorexit
    //   445: aload_2
    //   446: athrow
    //   447: astore_2
    //   448: aload_1
    //   449: monitorexit
    //   450: aload_2
    //   451: athrow
    //   452: astore_1
    //   453: goto -313 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	c
    //   3	61	1	localObject1	Object
    //   131	4	1	localObject2	Object
    //   136	1	1	localObject3	Object
    //   175	75	1	localObject4	Object
    //   256	4	1	localObject5	Object
    //   261	4	1	localObject6	Object
    //   452	1	1	localInterruptedException	InterruptedException
    //   62	4	2	localObject8	Object
    //   71	192	2	localObject9	Object
    //   318	4	2	localObject10	Object
    //   351	9	2	localk	l.c.a.a.a.k
    //   400	4	2	localObject11	Object
    //   405	36	2	localObject12	Object
    //   442	4	2	localObject13	Object
    //   447	4	2	localObject14	Object
    //   347	11	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   47	56	62	finally
    //   63	65	62	finally
    //   74	126	131	finally
    //   126	128	131	finally
    //   132	134	131	finally
    //   67	74	136	finally
    //   134	136	136	finally
    //   140	154	136	finally
    //   195	200	136	finally
    //   200	207	136	finally
    //   248	253	136	finally
    //   259	261	136	finally
    //   264	266	136	finally
    //   266	281	136	finally
    //   207	237	256	finally
    //   242	244	256	finally
    //   257	259	256	finally
    //   154	184	261	finally
    //   189	191	261	finally
    //   262	264	261	finally
    //   288	315	318	finally
    //   319	321	318	finally
    //   370	397	400	finally
    //   401	403	400	finally
    //   323	363	405	finally
    //   413	440	442	finally
    //   443	445	442	finally
    //   24	33	447	finally
    //   448	450	447	finally
    //   67	74	452	java/lang/InterruptedException
    //   134	136	452	java/lang/InterruptedException
  }
  
  public static enum a
  {
    static
    {
      RUNNING = new a("RUNNING", 1);
      a locala = new a("QUIESCING", 2);
      QUIESCING = locala;
      ENUM$VALUES = new a[] { STOPPED, RUNNING, locala };
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */