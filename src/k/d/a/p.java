package k.d.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k.d.a.s.b;

public class p
{
  public static final Map<Class<?>, List<o>> d = new ConcurrentHashMap();
  public static final p.a[] e = new p.a[4];
  public List<b> a;
  public final boolean b;
  public final boolean c;
  
  public p(List<b> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramList;
    b = paramBoolean1;
    c = paramBoolean2;
  }
  
  public final p.a a()
  {
    arrayOfa = e;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        p.a locala = e[i];
        if (locala != null)
        {
          e[i] = null;
          return locala;
        }
        i++;
      }
      finally {}
    }
    return new p.a();
  }
  
  /* Error */
  public final void a(p.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 47	k/d/a/p$a:e	Ljava/lang/Class;
    //   4: invokevirtual 53	java/lang/Class:getDeclaredMethods	()[Ljava/lang/reflect/Method;
    //   7: astore_2
    //   8: goto +17 -> 25
    //   11: astore_2
    //   12: aload_1
    //   13: getfield 47	k/d/a/p$a:e	Ljava/lang/Class;
    //   16: invokevirtual 56	java/lang/Class:getMethods	()[Ljava/lang/reflect/Method;
    //   19: astore_2
    //   20: aload_1
    //   21: iconst_1
    //   22: putfield 59	k/d/a/p$a:f	Z
    //   25: aload_2
    //   26: arraylength
    //   27: istore_3
    //   28: iconst_0
    //   29: istore 4
    //   31: iload 4
    //   33: iload_3
    //   34: if_icmpge +321 -> 355
    //   37: aload_2
    //   38: iload 4
    //   40: aaload
    //   41: astore 5
    //   43: aload 5
    //   45: invokevirtual 65	java/lang/reflect/Method:getModifiers	()I
    //   48: istore 6
    //   50: iload 6
    //   52: iconst_1
    //   53: iand
    //   54: ifeq +220 -> 274
    //   57: iload 6
    //   59: sipush 5192
    //   62: iand
    //   63: ifne +211 -> 274
    //   66: aload 5
    //   68: invokevirtual 69	java/lang/reflect/Method:getParameterTypes	()[Ljava/lang/Class;
    //   71: astore 7
    //   73: aload 7
    //   75: arraylength
    //   76: iconst_1
    //   77: if_icmpne +86 -> 163
    //   80: aload 5
    //   82: ldc 71
    //   84: invokevirtual 75	java/lang/reflect/Method:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   87: checkcast 71	k/d/a/m
    //   90: astore 8
    //   92: aload 8
    //   94: ifnull +255 -> 349
    //   97: aload 7
    //   99: iconst_0
    //   100: aaload
    //   101: astore 7
    //   103: aload_1
    //   104: aload 5
    //   106: aload 7
    //   108: invokevirtual 78	k/d/a/p$a:a	(Ljava/lang/reflect/Method;Ljava/lang/Class;)Z
    //   111: ifeq +238 -> 349
    //   114: aload 8
    //   116: invokeinterface 82 1 0
    //   121: astore 9
    //   123: aload_1
    //   124: getfield 83	k/d/a/p$a:a	Ljava/util/List;
    //   127: new 85	k/d/a/o
    //   130: dup
    //   131: aload 5
    //   133: aload 7
    //   135: aload 9
    //   137: aload 8
    //   139: invokeinterface 88 1 0
    //   144: aload 8
    //   146: invokeinterface 92 1 0
    //   151: invokespecial 95	k/d/a/o:<init>	(Ljava/lang/reflect/Method;Ljava/lang/Class;Lorg/greenrobot/eventbus/ThreadMode;IZ)V
    //   154: invokeinterface 101 2 0
    //   159: pop
    //   160: goto +189 -> 349
    //   163: aload_0
    //   164: getfield 35	k/d/a/p:b	Z
    //   167: ifeq +182 -> 349
    //   170: aload 5
    //   172: ldc 71
    //   174: invokevirtual 105	java/lang/reflect/Method:isAnnotationPresent	(Ljava/lang/Class;)Z
    //   177: ifne +6 -> 183
    //   180: goto +169 -> 349
    //   183: new 107	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   190: astore_1
    //   191: aload_1
    //   192: aload 5
    //   194: invokevirtual 112	java/lang/reflect/Method:getDeclaringClass	()Ljava/lang/Class;
    //   197: invokevirtual 116	java/lang/Class:getName	()Ljava/lang/String;
    //   200: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: ldc 122
    //   207: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: aload 5
    //   214: invokevirtual 123	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   217: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_1
    //   222: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore_2
    //   226: new 107	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   233: astore_1
    //   234: aload_1
    //   235: ldc -128
    //   237: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: aload_2
    //   243: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: ldc -126
    //   250: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: aload 7
    //   257: arraylength
    //   258: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: new 135	k/d/a/e
    //   265: dup
    //   266: aload_1
    //   267: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokespecial 138	k/d/a/e:<init>	(Ljava/lang/String;)V
    //   273: athrow
    //   274: aload_0
    //   275: getfield 35	k/d/a/p:b	Z
    //   278: ifeq +71 -> 349
    //   281: aload 5
    //   283: ldc 71
    //   285: invokevirtual 105	java/lang/reflect/Method:isAnnotationPresent	(Ljava/lang/Class;)Z
    //   288: ifne +6 -> 294
    //   291: goto +58 -> 349
    //   294: new 107	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   301: astore_1
    //   302: aload_1
    //   303: aload 5
    //   305: invokevirtual 112	java/lang/reflect/Method:getDeclaringClass	()Ljava/lang/Class;
    //   308: invokevirtual 116	java/lang/Class:getName	()Ljava/lang/String;
    //   311: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_1
    //   316: ldc 122
    //   318: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_1
    //   323: aload 5
    //   325: invokevirtual 123	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   328: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: new 135	k/d/a/e
    //   335: dup
    //   336: aload_1
    //   337: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: ldc -116
    //   342: invokestatic 145	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokespecial 138	k/d/a/e:<init>	(Ljava/lang/String;)V
    //   348: athrow
    //   349: iinc 4 1
    //   352: goto -321 -> 31
    //   355: return
    //   356: astore_2
    //   357: ldc -109
    //   359: invokestatic 149	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: astore 5
    //   364: aload 5
    //   366: aload_1
    //   367: getfield 47	k/d/a/p$a:e	Ljava/lang/Class;
    //   370: invokevirtual 116	java/lang/Class:getName	()Ljava/lang/String;
    //   373: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 5
    //   379: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: astore_1
    //   383: aload_0
    //   384: getfield 37	k/d/a/p:c	Z
    //   387: ifeq +13 -> 400
    //   390: aload_1
    //   391: ldc -105
    //   393: invokestatic 145	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   396: astore_1
    //   397: goto +10 -> 407
    //   400: aload_1
    //   401: ldc -103
    //   403: invokestatic 145	e/a/a/a/a:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   406: astore_1
    //   407: new 135	k/d/a/e
    //   410: dup
    //   411: aload_1
    //   412: aload_2
    //   413: invokespecial 156	k/d/a/e:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   416: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	p
    //   0	417	1	parama	p.a
    //   7	1	2	arrayOfMethod	java.lang.reflect.Method[]
    //   11	1	2	localObject1	Object
    //   19	224	2	localObject2	Object
    //   356	57	2	localLinkageError	LinkageError
    //   27	8	3	i	int
    //   29	321	4	j	int
    //   41	337	5	localObject3	Object
    //   48	15	6	k	int
    //   71	185	7	localObject4	Object
    //   90	55	8	localm	m
    //   121	15	9	localThreadMode	org.greenrobot.eventbus.ThreadMode
    // Exception table:
    //   from	to	target	type
    //   0	8	11	finally
    //   12	20	356	java/lang/LinkageError
  }
  
  public final List<o> b(p.a parama)
  {
    ArrayList localArrayList = new ArrayList(a);
    a.clear();
    b.clear();
    c.clear();
    Object localObject = d;
    int i = 0;
    ((StringBuilder)localObject).setLength(0);
    e = null;
    f = false;
    g = null;
    localObject = e;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        if (e[i] == null)
        {
          e[i] = parama;
        }
        else
        {
          i++;
          continue;
        }
        return localArrayList;
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */