package l.c.a.a.a.s;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import l.c.a.a.a.k;
import l.c.a.a.a.q;
import l.c.a.a.a.r;
import l.c.a.a.a.s.s.u;

public class a
{
  public final String a;
  public final l.c.a.a.a.t.b b;
  public l.c.a.a.a.b c;
  public int d;
  public i[] e;
  public d f;
  public e g;
  public c h;
  public b i;
  public l.c.a.a.a.i j;
  public l.c.a.a.a.u.a k;
  public l.c.a.a.a.o l;
  public f m;
  public boolean n;
  public byte o;
  public final Object p;
  public boolean q;
  public ExecutorService r;
  
  public a(l.c.a.a.a.b paramb, l.c.a.a.a.u.a parama, l.c.a.a.a.o paramo, ExecutorService paramExecutorService)
  {
    Object localObject = a.class.getName();
    a = ((String)localObject);
    b = l.c.a.a.a.t.c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", (String)localObject);
    n = false;
    o = ((byte)3);
    p = new Object();
    q = false;
    o = ((byte)3);
    c = paramb;
    k = parama;
    l = paramo;
    localObject = (r)paramo;
    if (localObject != null)
    {
      b = this;
      paramb = y;
      d = paramb;
      a.a(paramb);
      r = paramExecutorService;
      m = new f(c).y);
      h = new c(this);
      paramb = new b(parama, m, h, this, paramo);
      i = paramb;
      h.M = paramb;
      b.a(c).y);
      return;
    }
    throw null;
  }
  
  public final void a(Exception paramException)
  {
    b.a(a, "handleRunException", "804", null, paramException);
    if (!(paramException instanceof k)) {
      paramException = new k(32109, paramException);
    } else {
      paramException = (k)paramException;
    }
    a(null, paramException);
  }
  
  public void a(l.c.a.a.a.i parami, q paramq)
  {
    synchronized (p)
    {
      if ((d()) && (!q))
      {
        b.b(a, "connect", "214");
        o = ((byte)1);
        j = parami;
        parami = new l/c/a/a/a/s/s/d;
        parami.<init>(c).y, j.n, j.k, j.a, j.e, j.f, j.d, j.c);
        Object localObject2 = i;
        long l1 = j.a;
        if (localObject2 != null)
        {
          i = TimeUnit.SECONDS.toNanos(l1);
          i.j = j.k;
          b localb = i;
          l = j.b;
          localObject2 = new java/util/Vector;
          ((Vector)localObject2).<init>(l);
          d = ((Vector)localObject2);
          m.e();
          localObject2 = new l/c/a/a/a/s/a$a;
          ((a)localObject2).<init>(this, this, paramq, parami);
          parami = B.r;
          if (parami == null)
          {
            parami = new java/lang/Thread;
            parami.<init>((Runnable)localObject2);
            parami.start();
          }
          else
          {
            parami.execute((Runnable)localObject2);
          }
          return;
        }
        throw null;
      }
      b.b(a, "connect", "207", new Object[] { Byte.valueOf(o) });
      if ((!a()) && (!q))
      {
        if (!c())
        {
          if (e())
          {
            parami = new l/c/a/a/a/k;
            parami.<init>(32102);
            throw parami;
          }
          throw l.b.c.e.a.a(32100);
        }
        parami = new l/c/a/a/a/k;
        parami.<init>(32110);
        throw parami;
      }
      parami = new l/c/a/a/a/k;
      parami.<init>(32111);
      throw parami;
    }
  }
  
  /* Error */
  public void a(q arg1, k paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 71	l/c/a/a/a/s/a:p	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 67	l/c/a/a/a/s/a:n	Z
    //   11: ifne +643 -> 654
    //   14: aload_0
    //   15: getfield 73	l/c/a/a/a/s/a:q	Z
    //   18: ifne +636 -> 654
    //   21: aload_0
    //   22: invokevirtual 236	l/c/a/a/a/s/a:a	()Z
    //   25: ifeq +6 -> 31
    //   28: goto +626 -> 654
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 67	l/c/a/a/a/s/a:n	Z
    //   36: aload_0
    //   37: getfield 65	l/c/a/a/a/s/a:b	Ll/c/a/a/a/t/b;
    //   40: aload_0
    //   41: getfield 56	l/c/a/a/a/s/a:a	Ljava/lang/String;
    //   44: ldc -6
    //   46: ldc -4
    //   48: invokeinterface 151 4 0
    //   53: aload_0
    //   54: invokevirtual 254	l/c/a/a/a/s/a:b	()Z
    //   57: ifne +16 -> 73
    //   60: aload_0
    //   61: invokevirtual 240	l/c/a/a/a/s/a:e	()Z
    //   64: ifne +9 -> 73
    //   67: iconst_0
    //   68: istore 4
    //   70: goto +6 -> 76
    //   73: iconst_1
    //   74: istore 4
    //   76: aload_0
    //   77: iconst_2
    //   78: i2b
    //   79: putfield 69	l/c/a/a/a/s/a:o	B
    //   82: aload_3
    //   83: monitorexit
    //   84: aload_1
    //   85: ifnull +21 -> 106
    //   88: aload_1
    //   89: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   92: getfield 263	l/c/a/a/a/s/p:b	Z
    //   95: ifne +11 -> 106
    //   98: aload_1
    //   99: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   102: aload_2
    //   103: invokevirtual 266	l/c/a/a/a/s/p:a	(Ll/c/a/a/a/k;)V
    //   106: aload_0
    //   107: getfield 113	l/c/a/a/a/s/a:h	Ll/c/a/a/a/s/c;
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 267	l/c/a/a/a/s/c:e	()V
    //   119: aload_0
    //   120: getfield 269	l/c/a/a/a/s/a:f	Ll/c/a/a/a/s/d;
    //   123: astore_3
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 273	l/c/a/a/a/s/d:b	()V
    //   132: aload_0
    //   133: getfield 275	l/c/a/a/a/s/a:e	[Ll/c/a/a/a/s/i;
    //   136: ifnull +23 -> 159
    //   139: aload_0
    //   140: getfield 275	l/c/a/a/a/s/a:e	[Ll/c/a/a/a/s/i;
    //   143: aload_0
    //   144: getfield 277	l/c/a/a/a/s/a:d	I
    //   147: aaload
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +9 -> 159
    //   153: aload_3
    //   154: invokeinterface 282 1 0
    //   159: aload_0
    //   160: getfield 106	l/c/a/a/a/s/a:m	Ll/c/a/a/a/s/f;
    //   163: new 134	l/c/a/a/a/k
    //   166: dup
    //   167: sipush 32102
    //   170: invokespecial 241	l/c/a/a/a/k:<init>	(I)V
    //   173: invokevirtual 283	l/c/a/a/a/s/f:a	(Ll/c/a/a/a/k;)V
    //   176: aload_0
    //   177: getfield 65	l/c/a/a/a/s/a:b	Ll/c/a/a/a/t/b;
    //   180: aload_0
    //   181: getfield 56	l/c/a/a/a/s/a:a	Ljava/lang/String;
    //   184: ldc_w 285
    //   187: ldc_w 287
    //   190: invokeinterface 151 4 0
    //   195: aload_1
    //   196: ifnull +47 -> 243
    //   199: aload_0
    //   200: getfield 106	l/c/a/a/a/s/a:m	Ll/c/a/a/a/s/f;
    //   203: astore_3
    //   204: aload_1
    //   205: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   208: getfield 289	l/c/a/a/a/s/p:j	Ljava/lang/String;
    //   211: astore 5
    //   213: aload_3
    //   214: getfield 292	l/c/a/a/a/s/f:b	Ljava/util/Hashtable;
    //   217: aload 5
    //   219: invokevirtual 298	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   222: checkcast 256	l/c/a/a/a/q
    //   225: ifnonnull +18 -> 243
    //   228: aload_0
    //   229: getfield 106	l/c/a/a/a/s/a:m	Ll/c/a/a/a/s/f;
    //   232: aload_1
    //   233: aload_1
    //   234: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   237: getfield 289	l/c/a/a/a/s/p:j	Ljava/lang/String;
    //   240: invokevirtual 301	l/c/a/a/a/s/f:a	(Ll/c/a/a/a/q;Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 120	l/c/a/a/a/s/a:i	Ll/c/a/a/a/s/b;
    //   247: aload_2
    //   248: invokevirtual 304	l/c/a/a/a/s/b:b	(Ll/c/a/a/a/k;)Ljava/util/Vector;
    //   251: invokevirtual 308	java/util/Vector:elements	()Ljava/util/Enumeration;
    //   254: astore 5
    //   256: aconst_null
    //   257: astore_1
    //   258: aload 5
    //   260: invokeinterface 313 1 0
    //   265: ifne +6 -> 271
    //   268: goto +68 -> 336
    //   271: aload 5
    //   273: invokeinterface 317 1 0
    //   278: checkcast 256	l/c/a/a/a/q
    //   281: astore_3
    //   282: aload_3
    //   283: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   286: getfield 289	l/c/a/a/a/s/p:j	Ljava/lang/String;
    //   289: ldc_w 319
    //   292: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifne +33 -> 328
    //   298: aload_3
    //   299: getfield 259	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
    //   302: getfield 289	l/c/a/a/a/s/p:j	Ljava/lang/String;
    //   305: ldc_w 327
    //   308: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +6 -> 317
    //   314: goto +14 -> 328
    //   317: aload_0
    //   318: getfield 113	l/c/a/a/a/s/a:h	Ll/c/a/a/a/s/c;
    //   321: aload_3
    //   322: invokevirtual 330	l/c/a/a/a/s/c:a	(Ll/c/a/a/a/q;)V
    //   325: goto -67 -> 258
    //   328: aload_3
    //   329: astore_1
    //   330: goto -72 -> 258
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_1
    //   336: aload_0
    //   337: getfield 120	l/c/a/a/a/s/a:i	Ll/c/a/a/a/s/b;
    //   340: aload_2
    //   341: invokevirtual 331	l/c/a/a/a/s/b:a	(Ll/c/a/a/a/k;)V
    //   344: aload_0
    //   345: getfield 120	l/c/a/a/a/s/a:i	Ll/c/a/a/a/s/b;
    //   348: getfield 191	l/c/a/a/a/s/b:j	Z
    //   351: ifeq +17 -> 368
    //   354: aload_0
    //   355: getfield 113	l/c/a/a/a/s/a:h	Ll/c/a/a/a/s/c;
    //   358: getfield 334	l/c/a/a/a/s/c:A	Ljava/util/Hashtable;
    //   361: invokevirtual 337	java/util/Hashtable:clear	()V
    //   364: goto +4 -> 368
    //   367: astore_3
    //   368: aload_0
    //   369: getfield 339	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
    //   372: astore_3
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 342	l/c/a/a/a/s/e:b	()V
    //   381: aload_0
    //   382: getfield 79	l/c/a/a/a/s/a:l	Ll/c/a/a/a/o;
    //   385: astore_3
    //   386: aload_3
    //   387: ifnull +40 -> 427
    //   390: aload_3
    //   391: checkcast 81	l/c/a/a/a/r
    //   394: astore_3
    //   395: aload_3
    //   396: getfield 93	l/c/a/a/a/r:a	Ll/c/a/a/a/t/b;
    //   399: ldc_w 344
    //   402: ldc_w 345
    //   405: ldc_w 347
    //   408: aconst_null
    //   409: invokeinterface 234 5 0
    //   414: aload_3
    //   415: getfield 350	l/c/a/a/a/r:c	Ljava/util/Timer;
    //   418: astore_3
    //   419: aload_3
    //   420: ifnull +7 -> 427
    //   423: aload_3
    //   424: invokevirtual 355	java/util/Timer:cancel	()V
    //   427: aload_0
    //   428: getfield 77	l/c/a/a/a/s/a:k	Ll/c/a/a/a/u/a;
    //   431: ifnull +10 -> 441
    //   434: aload_0
    //   435: getfield 77	l/c/a/a/a/s/a:k	Ll/c/a/a/a/u/a;
    //   438: invokevirtual 360	l/c/a/a/a/u/a:close	()V
    //   441: aload_0
    //   442: getfield 71	l/c/a/a/a/s/a:p	Ljava/lang/Object;
    //   445: astore_3
    //   446: aload_3
    //   447: monitorenter
    //   448: aload_0
    //   449: getfield 65	l/c/a/a/a/s/a:b	Ll/c/a/a/a/t/b;
    //   452: aload_0
    //   453: getfield 56	l/c/a/a/a/s/a:a	Ljava/lang/String;
    //   456: ldc -6
    //   458: ldc_w 362
    //   461: invokeinterface 151 4 0
    //   466: aload_0
    //   467: iconst_3
    //   468: i2b
    //   469: putfield 69	l/c/a/a/a/s/a:o	B
    //   472: aload_0
    //   473: iconst_0
    //   474: putfield 67	l/c/a/a/a/s/a:n	Z
    //   477: aload_3
    //   478: monitorexit
    //   479: aload_1
    //   480: ifnull +17 -> 497
    //   483: aload_0
    //   484: getfield 113	l/c/a/a/a/s/a:h	Ll/c/a/a/a/s/c;
    //   487: astore_3
    //   488: aload_3
    //   489: ifnull +8 -> 497
    //   492: aload_3
    //   493: aload_1
    //   494: invokevirtual 330	l/c/a/a/a/s/c:a	(Ll/c/a/a/a/q;)V
    //   497: iload 4
    //   499: ifeq +119 -> 618
    //   502: aload_0
    //   503: getfield 113	l/c/a/a/a/s/a:h	Ll/c/a/a/a/s/c;
    //   506: astore_1
    //   507: aload_1
    //   508: ifnull +110 -> 618
    //   511: aload_1
    //   512: ifnull +104 -> 616
    //   515: aload_1
    //   516: getfield 365	l/c/a/a/a/s/c:y	Ll/c/a/a/a/g;
    //   519: ifnull +43 -> 562
    //   522: aload_2
    //   523: ifnull +39 -> 562
    //   526: aload_1
    //   527: getfield 368	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   530: getstatic 371	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   533: ldc_w 373
    //   536: ldc_w 375
    //   539: iconst_1
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload_2
    //   546: aastore
    //   547: invokeinterface 234 5 0
    //   552: aload_1
    //   553: getfield 365	l/c/a/a/a/s/c:y	Ll/c/a/a/a/g;
    //   556: aload_2
    //   557: invokeinterface 380 2 0
    //   562: aload_1
    //   563: getfield 384	l/c/a/a/a/s/c:z	Ll/c/a/a/a/h;
    //   566: ifnull +52 -> 618
    //   569: aload_2
    //   570: ifnull +48 -> 618
    //   573: aload_1
    //   574: getfield 384	l/c/a/a/a/s/c:z	Ll/c/a/a/a/h;
    //   577: aload_2
    //   578: invokeinterface 380 2 0
    //   583: goto +35 -> 618
    //   586: astore_2
    //   587: aload_1
    //   588: getfield 368	l/c/a/a/a/s/c:x	Ll/c/a/a/a/t/b;
    //   591: getstatic 371	l/c/a/a/a/s/c:O	Ljava/lang/String;
    //   594: ldc_w 373
    //   597: ldc_w 386
    //   600: iconst_1
    //   601: anewarray 4	java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: aload_2
    //   607: aastore
    //   608: invokeinterface 234 5 0
    //   613: goto +5 -> 618
    //   616: aconst_null
    //   617: athrow
    //   618: aload_0
    //   619: getfield 71	l/c/a/a/a/s/a:p	Ljava/lang/Object;
    //   622: astore_1
    //   623: aload_1
    //   624: monitorenter
    //   625: aload_0
    //   626: getfield 73	l/c/a/a/a/s/a:q	Z
    //   629: istore 6
    //   631: iload 6
    //   633: ifeq +8 -> 641
    //   636: aload_0
    //   637: iconst_1
    //   638: invokevirtual 389	l/c/a/a/a/s/a:a	(Z)V
    //   641: aload_1
    //   642: monitorexit
    //   643: return
    //   644: astore_2
    //   645: aload_1
    //   646: monitorexit
    //   647: aload_2
    //   648: athrow
    //   649: astore_1
    //   650: aload_3
    //   651: monitorexit
    //   652: aload_1
    //   653: athrow
    //   654: aload_3
    //   655: monitorexit
    //   656: return
    //   657: astore_1
    //   658: aload_3
    //   659: monitorexit
    //   660: aload_1
    //   661: athrow
    //   662: astore_3
    //   663: goto -504 -> 159
    //   666: astore_3
    //   667: goto -331 -> 336
    //   670: astore_3
    //   671: goto -230 -> 441
    //   674: astore_2
    //   675: goto -34 -> 641
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	a
    //   0	678	2	paramk	k
    //   4	325	3	localObject1	Object
    //   367	1	3	localException1	Exception
    //   662	1	3	localException2	Exception
    //   666	1	3	localException3	Exception
    //   670	1	3	localException4	Exception
    //   68	430	4	i1	int
    //   211	61	5	localObject3	Object
    //   629	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   199	243	333	java/lang/Exception
    //   243	256	333	java/lang/Exception
    //   336	364	367	java/lang/Exception
    //   515	522	586	finally
    //   526	562	586	finally
    //   562	569	586	finally
    //   573	583	586	finally
    //   625	631	644	finally
    //   636	641	644	finally
    //   641	643	644	finally
    //   645	647	644	finally
    //   448	479	649	finally
    //   650	652	649	finally
    //   7	28	657	finally
    //   31	67	657	finally
    //   76	84	657	finally
    //   654	656	657	finally
    //   658	660	657	finally
    //   132	149	662	java/lang/Exception
    //   153	159	662	java/lang/Exception
    //   258	268	666	java/lang/Exception
    //   271	314	666	java/lang/Exception
    //   317	325	666	java/lang/Exception
    //   427	441	670	java/lang/Exception
    //   636	641	674	java/lang/Exception
  }
  
  public void a(l.c.a.a.a.s.s.c paramc, k paramk)
  {
    int i1 = g;
    paramc = p;
    if (i1 == 0) {}
    try
    {
      b.b(a, "connectComplete", "215");
      o = ((byte)0);
      return;
    }
    finally {}
    b.b(a, "connectComplete", "204", new Object[] { Integer.valueOf(i1) });
    throw paramk;
  }
  
  public void a(l.c.a.a.a.s.s.e parame, long paramLong, q paramq)
  {
    synchronized (p)
    {
      if (!a())
      {
        if (!d())
        {
          if (!e())
          {
            if (Thread.currentThread() != h.H)
            {
              b.b(a, "disconnect", "218");
              o = ((byte)2);
              b localb = new l/c/a/a/a/s/a$b;
              localb.<init>(this, parame, paramLong, paramq);
              localb.a();
              return;
            }
            b.b(a, "disconnect", "210");
            throw l.b.c.e.a.a(32107);
          }
          b.b(a, "disconnect", "219");
          throw l.b.c.e.a.a(32102);
        }
        b.b(a, "disconnect", "211");
        throw l.b.c.e.a.a(32101);
      }
      b.b(a, "disconnect", "223");
      throw l.b.c.e.a.a(32111);
    }
  }
  
  public void a(u paramu, q paramq)
  {
    b.b(a, "internalSend", "200", new Object[] { paramu.i(), paramu, paramq });
    p localp = a;
    if (k == null)
    {
      k = c;
      try
      {
        i.a(paramu, paramq);
        return;
      }
      catch (k localk)
      {
        a.k = null;
        if ((paramu instanceof l.c.a.a.a.s.s.o)) {
          i.a((l.c.a.a.a.s.s.o)paramu);
        }
        throw localk;
      }
    }
    b.b(a, "internalSend", "213", new Object[] { paramu.i(), paramu, paramq });
    throw new k(32201);
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (p)
    {
      if (!a())
      {
        if ((!d()) || (paramBoolean))
        {
          b.b(a, "close", "224");
          if (c()) {
            break label141;
          }
          if (b()) {
            break label134;
          }
          if (e())
          {
            q = true;
            return;
          }
        }
        o = ((byte)4);
        i.c();
        i = null;
        h = null;
        k = null;
        g = null;
        l = null;
        f = null;
        e = null;
        j = null;
        m = null;
        break label154;
        label134:
        throw l.b.c.e.a.a(32100);
        label141:
        k localk = new l/c/a/a/a/k;
        localk.<init>(32110);
        throw localk;
      }
      label154:
      return;
    }
  }
  
  public boolean a()
  {
    synchronized (p)
    {
      boolean bool;
      if (o == 4) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void b(u paramu, q paramq)
  {
    if ((!b()) && ((b()) || (!(paramu instanceof l.c.a.a.a.s.s.d))) && ((!e()) || (!(paramu instanceof l.c.a.a.a.s.s.e))))
    {
      b.b(a, "sendNoWait", "208");
      throw l.b.c.e.a.a(32104);
    }
    a(paramu, paramq);
  }
  
  public boolean b()
  {
    synchronized (p)
    {
      boolean bool;
      if (o == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean c()
  {
    synchronized (p)
    {
      int i1 = o;
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean d()
  {
    synchronized (p)
    {
      boolean bool;
      if (o == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean e()
  {
    synchronized (p)
    {
      boolean bool;
      if (o == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public class a
    implements Runnable
  {
    public String A;
    public a x = null;
    public q y;
    public l.c.a.a.a.s.s.d z;
    
    public a(a parama, q paramq, l.c.a.a.a.s.s.d paramd)
    {
      x = parama;
      y = paramq;
      z = paramd;
      parama = new StringBuilder("MQTT Con: ");
      parama.append(c).y);
      A = parama.toString();
    }
    
    public void run()
    {
      Thread.currentThread().setName(A);
      Object localObject1 = a.this;
      b.b(a, "connectBG:run", "220");
      localObject1 = null;
      try
      {
        Object localObject2 = m.c();
        int i = localObject2.length;
        for (int j = 0;; j++)
        {
          if (j >= i)
          {
            m.a(y, z);
            localObject2 = e[d];
            ((i)localObject2).start();
            Object localObject3 = a.this;
            Object localObject4 = new l/c/a/a/a/s/d;
            ((d)localObject4).<init>(x, a.this.i, m, ((i)localObject2).b());
            f = ((d)localObject4);
            localObject3 = f;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>("MQTT Rec: ");
            ((StringBuilder)localObject4).append(c).y);
            ((d)localObject3).a(((StringBuilder)localObject4).toString(), r);
            localObject3 = a.this;
            localObject4 = new l/c/a/a/a/s/e;
            ((e)localObject4).<init>(x, a.this.i, m, ((i)localObject2).a());
            g = ((e)localObject4);
            localObject2 = g;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>("MQTT Snd: ");
            ((StringBuilder)localObject4).append(c).y);
            ((e)localObject2).a(((StringBuilder)localObject4).toString(), r);
            localObject2 = h;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>("MQTT Call: ");
            ((StringBuilder)localObject4).append(c).y);
            ((c)localObject2).a(((StringBuilder)localObject4).toString(), r);
            a(z, y);
            break;
          }
          a.a(null);
        }
        a locala;
        if (localk == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        localObject1 = a.this;
        b.a(a, "connectBG:run", "209", null, localException);
        if (localException.getClass().getName().equals("java.security.GeneralSecurityException")) {
          localObject1 = new l.c.a.a.a.p(localException);
        } else {
          localObject1 = new k(localException);
        }
      }
      catch (k localk)
      {
        locala = a.this;
        b.a(a, "connectBG:run", "212", null, localk);
      }
      a(y, localk);
    }
  }
  
  public class b
    implements Runnable
  {
    public String A;
    public l.c.a.a.a.s.s.e x;
    public long y;
    public q z;
    
    public b(l.c.a.a.a.s.s.e parame, long paramLong, q paramq)
    {
      x = parame;
      y = paramLong;
      z = paramq;
    }
    
    public void a()
    {
      Object localObject = new StringBuilder("MQTT Disc: ");
      ((StringBuilder)localObject).append(c).y);
      A = ((StringBuilder)localObject).toString();
      localObject = r;
      if (localObject == null) {
        new Thread(this).start();
      } else {
        ((ExecutorService)localObject).execute(this);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   3: aload_0
      //   4: getfield 59	l/c/a/a/a/s/a$b:A	Ljava/lang/String;
      //   7: invokevirtual 86	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   10: aload_0
      //   11: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   14: astore_1
      //   15: aload_1
      //   16: getfield 89	l/c/a/a/a/s/a:b	Ll/c/a/a/a/t/b;
      //   19: aload_1
      //   20: getfield 91	l/c/a/a/a/s/a:a	Ljava/lang/String;
      //   23: ldc 93
      //   25: ldc 95
      //   27: invokeinterface 100 4 0
      //   32: aload_0
      //   33: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   36: getfield 104	l/c/a/a/a/s/a:i	Ll/c/a/a/a/s/b;
      //   39: aload_0
      //   40: getfield 30	l/c/a/a/a/s/a$b:y	J
      //   43: invokevirtual 109	l/c/a/a/a/s/b:a	(J)V
      //   46: aload_0
      //   47: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   50: aload_0
      //   51: getfield 28	l/c/a/a/a/s/a$b:x	Ll/c/a/a/a/s/s/e;
      //   54: aload_0
      //   55: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   58: invokevirtual 112	l/c/a/a/a/s/a:a	(Ll/c/a/a/a/s/s/u;Ll/c/a/a/a/q;)V
      //   61: aload_0
      //   62: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   65: getfield 116	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
      //   68: ifnull +26 -> 94
      //   71: aload_0
      //   72: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   75: getfield 116	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
      //   78: invokevirtual 121	l/c/a/a/a/s/e:a	()Z
      //   81: ifeq +13 -> 94
      //   84: aload_0
      //   85: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   88: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   91: invokevirtual 130	l/c/a/a/a/s/p:c	()V
      //   94: aload_0
      //   95: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   98: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   101: aconst_null
      //   102: aconst_null
      //   103: invokevirtual 133	l/c/a/a/a/s/p:a	(Ll/c/a/a/a/s/s/u;Ll/c/a/a/a/k;)V
      //   106: aload_0
      //   107: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   110: getfield 116	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
      //   113: astore_1
      //   114: aload_1
      //   115: ifnull +101 -> 216
      //   118: aload_1
      //   119: invokevirtual 121	l/c/a/a/a/s/e:a	()Z
      //   122: ifne +104 -> 226
      //   125: goto +91 -> 216
      //   128: astore_1
      //   129: aload_0
      //   130: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   133: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   136: aconst_null
      //   137: aconst_null
      //   138: invokevirtual 133	l/c/a/a/a/s/p:a	(Ll/c/a/a/a/s/s/u;Ll/c/a/a/a/k;)V
      //   141: aload_0
      //   142: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   145: getfield 116	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
      //   148: astore_2
      //   149: aload_2
      //   150: ifnull +10 -> 160
      //   153: aload_2
      //   154: invokevirtual 121	l/c/a/a/a/s/e:a	()Z
      //   157: ifne +13 -> 170
      //   160: aload_0
      //   161: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   164: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   167: invokevirtual 135	l/c/a/a/a/s/p:a	()V
      //   170: aload_0
      //   171: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   174: aload_0
      //   175: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   178: aconst_null
      //   179: invokevirtual 138	l/c/a/a/a/s/a:a	(Ll/c/a/a/a/q;Ll/c/a/a/a/k;)V
      //   182: aload_1
      //   183: athrow
      //   184: astore_1
      //   185: aload_0
      //   186: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   189: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   192: aconst_null
      //   193: aconst_null
      //   194: invokevirtual 133	l/c/a/a/a/s/p:a	(Ll/c/a/a/a/s/s/u;Ll/c/a/a/a/k;)V
      //   197: aload_0
      //   198: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   201: getfield 116	l/c/a/a/a/s/a:g	Ll/c/a/a/a/s/e;
      //   204: astore_1
      //   205: aload_1
      //   206: ifnull +10 -> 216
      //   209: aload_1
      //   210: invokevirtual 121	l/c/a/a/a/s/e:a	()Z
      //   213: ifne +13 -> 226
      //   216: aload_0
      //   217: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   220: getfield 126	l/c/a/a/a/q:a	Ll/c/a/a/a/s/p;
      //   223: invokevirtual 135	l/c/a/a/a/s/p:a	()V
      //   226: aload_0
      //   227: getfield 23	l/c/a/a/a/s/a$b:B	Ll/c/a/a/a/s/a;
      //   230: aload_0
      //   231: getfield 32	l/c/a/a/a/s/a$b:z	Ll/c/a/a/a/q;
      //   234: aconst_null
      //   235: invokevirtual 138	l/c/a/a/a/s/a:a	(Ll/c/a/a/a/q;Ll/c/a/a/a/k;)V
      //   238: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	239	0	this	b
      //   14	105	1	localObject1	Object
      //   128	55	1	localObject2	Object
      //   184	1	1	localk	k
      //   204	6	1	locale1	e
      //   148	6	2	locale2	e
      // Exception table:
      //   from	to	target	type
      //   46	94	128	finally
      //   46	94	184	l/c/a/a/a/k
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */