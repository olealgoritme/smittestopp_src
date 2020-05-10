package d.u.m;

import android.database.Cursor;
import d.w.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class d
{
  public final String a;
  public final Map<String, d.a> b;
  public final Set<d.b> c;
  public final Set<d.d> d;
  
  public d(String paramString, Map<String, d.a> paramMap, Set<d.b> paramSet, Set<d.d> paramSet1)
  {
    a = paramString;
    b = Collections.unmodifiableMap(paramMap);
    c = Collections.unmodifiableSet(paramSet);
    if (paramSet1 == null) {
      paramString = null;
    } else {
      paramString = Collections.unmodifiableSet(paramSet1);
    }
    d = paramString;
  }
  
  public static d.d a(b paramb, String paramString, boolean paramBoolean)
  {
    Object localObject = e.a.a.a.a.a("PRAGMA index_xinfo(`", paramString, "`)");
    paramb = ((d.w.a.f.a)paramb).a((String)localObject);
    try
    {
      int i = paramb.getColumnIndex("seqno");
      int j = paramb.getColumnIndex("cid");
      int k = paramb.getColumnIndex("name");
      if ((i != -1) && (j != -1) && (k != -1))
      {
        TreeMap localTreeMap = new java/util/TreeMap;
        localTreeMap.<init>();
        while (paramb.moveToNext()) {
          if (paramb.getInt(j) >= 0) {
            localTreeMap.put(Integer.valueOf(paramb.getInt(i)), paramb.getString(k));
          }
        }
        localObject = new java/util/ArrayList;
        ((ArrayList)localObject).<init>(localTreeMap.size());
        ((ArrayList)localObject).addAll(localTreeMap.values());
        paramString = new d.d(paramString, paramBoolean, (List)localObject);
        return paramString;
      }
      return null;
    }
    finally
    {
      paramb.close();
    }
  }
  
  /* Error */
  public static d a(b paramb, String paramString)
  {
    // Byte code:
    //   0: ldc 126
    //   2: aload_1
    //   3: ldc 53
    //   5: invokestatic 58	e/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8: astore_2
    //   9: aload_0
    //   10: checkcast 60	d/w/a/f/a
    //   13: astore_3
    //   14: aload_3
    //   15: aload_2
    //   16: invokevirtual 63	d/w/a/f/a:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_0
    //   20: new 128	java/util/HashMap
    //   23: dup
    //   24: invokespecial 129	java/util/HashMap:<init>	()V
    //   27: astore 4
    //   29: aload_0
    //   30: invokeinterface 132 1 0
    //   35: istore 5
    //   37: iload 5
    //   39: ifle +154 -> 193
    //   42: aload_0
    //   43: ldc 75
    //   45: invokeinterface 71 2 0
    //   50: istore 5
    //   52: aload_0
    //   53: ldc -122
    //   55: invokeinterface 71 2 0
    //   60: istore 6
    //   62: aload_0
    //   63: ldc -120
    //   65: invokeinterface 71 2 0
    //   70: istore 7
    //   72: aload_0
    //   73: ldc -118
    //   75: invokeinterface 71 2 0
    //   80: istore 8
    //   82: aload_0
    //   83: ldc -116
    //   85: invokeinterface 71 2 0
    //   90: istore 9
    //   92: aload_0
    //   93: invokeinterface 82 1 0
    //   98: ifeq +95 -> 193
    //   101: aload_0
    //   102: iload 5
    //   104: invokeinterface 96 2 0
    //   109: astore 10
    //   111: aload_0
    //   112: iload 6
    //   114: invokeinterface 96 2 0
    //   119: astore_2
    //   120: aload_0
    //   121: iload 7
    //   123: invokeinterface 86 2 0
    //   128: ifeq +9 -> 137
    //   131: iconst_1
    //   132: istore 11
    //   134: goto +6 -> 140
    //   137: iconst_0
    //   138: istore 11
    //   140: aload_0
    //   141: iload 8
    //   143: invokeinterface 86 2 0
    //   148: istore 12
    //   150: aload_0
    //   151: iload 9
    //   153: invokeinterface 96 2 0
    //   158: astore 13
    //   160: new 6	d/u/m/d$a
    //   163: astore 14
    //   165: aload 14
    //   167: aload 10
    //   169: aload_2
    //   170: iload 11
    //   172: iload 12
    //   174: aload 13
    //   176: iconst_2
    //   177: invokespecial 143	d/u/m/d$a:<init>	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V
    //   180: aload 4
    //   182: aload 10
    //   184: aload 14
    //   186: invokevirtual 144	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: pop
    //   190: goto -98 -> 92
    //   193: aload_0
    //   194: invokeinterface 123 1 0
    //   199: new 146	java/util/HashSet
    //   202: dup
    //   203: invokespecial 147	java/util/HashSet:<init>	()V
    //   206: astore 10
    //   208: new 149	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   215: astore_0
    //   216: aload_0
    //   217: ldc -104
    //   219: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_0
    //   224: aload_1
    //   225: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_0
    //   230: ldc 53
    //   232: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload_0
    //   238: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 63	d/w/a/f/a:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   244: astore_2
    //   245: aload_2
    //   246: ldc -94
    //   248: invokeinterface 71 2 0
    //   253: istore 9
    //   255: aload_2
    //   256: ldc -92
    //   258: invokeinterface 71 2 0
    //   263: istore 8
    //   265: aload_2
    //   266: ldc -90
    //   268: invokeinterface 71 2 0
    //   273: istore 15
    //   275: aload_2
    //   276: ldc -88
    //   278: invokeinterface 71 2 0
    //   283: istore 6
    //   285: aload_2
    //   286: ldc -86
    //   288: invokeinterface 71 2 0
    //   293: istore 12
    //   295: aload_2
    //   296: invokestatic 173	d/u/m/d:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   299: astore_0
    //   300: aload_2
    //   301: invokeinterface 176 1 0
    //   306: istore 5
    //   308: iconst_0
    //   309: istore 7
    //   311: iload 7
    //   313: iload 5
    //   315: if_icmpge +178 -> 493
    //   318: aload_2
    //   319: iload 7
    //   321: invokeinterface 180 2 0
    //   326: pop
    //   327: aload_2
    //   328: iload 8
    //   330: invokeinterface 86 2 0
    //   335: ifeq +6 -> 341
    //   338: goto +149 -> 487
    //   341: aload_2
    //   342: iload 9
    //   344: invokeinterface 86 2 0
    //   349: istore 16
    //   351: new 102	java/util/ArrayList
    //   354: astore 14
    //   356: aload 14
    //   358: invokespecial 181	java/util/ArrayList:<init>	()V
    //   361: new 102	java/util/ArrayList
    //   364: astore 13
    //   366: aload 13
    //   368: invokespecial 181	java/util/ArrayList:<init>	()V
    //   371: aload_0
    //   372: checkcast 102	java/util/ArrayList
    //   375: astore 17
    //   377: aload 17
    //   379: invokevirtual 185	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   382: astore 17
    //   384: aload 17
    //   386: invokeinterface 190 1 0
    //   391: ifeq +50 -> 441
    //   394: aload 17
    //   396: invokeinterface 194 1 0
    //   401: checkcast 12	d/u/m/d$c
    //   404: astore 18
    //   406: aload 18
    //   408: getfield 198	d/u/m/d$c:x	I
    //   411: iload 16
    //   413: if_icmpne +25 -> 438
    //   416: aload 14
    //   418: aload 18
    //   420: getfield 201	d/u/m/d$c:z	Ljava/lang/String;
    //   423: invokevirtual 205	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   426: pop
    //   427: aload 13
    //   429: aload 18
    //   431: getfield 208	d/u/m/d$c:A	Ljava/lang/String;
    //   434: invokevirtual 205	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   437: pop
    //   438: goto -54 -> 384
    //   441: new 9	d/u/m/d$b
    //   444: astore 17
    //   446: aload 17
    //   448: aload_2
    //   449: iload 15
    //   451: invokeinterface 96 2 0
    //   456: aload_2
    //   457: iload 6
    //   459: invokeinterface 96 2 0
    //   464: aload_2
    //   465: iload 12
    //   467: invokeinterface 96 2 0
    //   472: aload 14
    //   474: aload 13
    //   476: invokespecial 211	d/u/m/d$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   479: aload 10
    //   481: aload 17
    //   483: invokevirtual 212	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   486: pop
    //   487: iinc 7 1
    //   490: goto -179 -> 311
    //   493: aload_2
    //   494: invokeinterface 123 1 0
    //   499: new 149	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   506: astore_0
    //   507: aload_0
    //   508: ldc -42
    //   510: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_0
    //   515: aload_1
    //   516: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_0
    //   521: ldc 53
    //   523: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_3
    //   528: aload_0
    //   529: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokevirtual 63	d/w/a/f/a:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   535: astore 13
    //   537: aload 13
    //   539: ldc 75
    //   541: invokeinterface 71 2 0
    //   546: istore 8
    //   548: aload 13
    //   550: ldc -40
    //   552: invokeinterface 71 2 0
    //   557: istore 5
    //   559: aload 13
    //   561: ldc -38
    //   563: invokeinterface 71 2 0
    //   568: istore 9
    //   570: aconst_null
    //   571: astore_2
    //   572: iload 8
    //   574: iconst_m1
    //   575: if_icmpeq +127 -> 702
    //   578: iload 5
    //   580: iconst_m1
    //   581: if_icmpeq +121 -> 702
    //   584: iload 9
    //   586: iconst_m1
    //   587: if_icmpne +6 -> 593
    //   590: goto +112 -> 702
    //   593: new 146	java/util/HashSet
    //   596: astore_0
    //   597: aload_0
    //   598: invokespecial 147	java/util/HashSet:<init>	()V
    //   601: aload 13
    //   603: invokeinterface 82 1 0
    //   608: ifeq +84 -> 692
    //   611: ldc -37
    //   613: aload 13
    //   615: iload 5
    //   617: invokeinterface 96 2 0
    //   622: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifne +6 -> 631
    //   628: goto -27 -> 601
    //   631: aload 13
    //   633: iload 8
    //   635: invokeinterface 96 2 0
    //   640: astore 14
    //   642: aload 13
    //   644: iload 9
    //   646: invokeinterface 86 2 0
    //   651: iconst_1
    //   652: if_icmpne +9 -> 661
    //   655: iconst_1
    //   656: istore 11
    //   658: goto +6 -> 664
    //   661: iconst_0
    //   662: istore 11
    //   664: aload_3
    //   665: aload 14
    //   667: iload 11
    //   669: invokestatic 226	d/u/m/d:a	(Ld/w/a/b;Ljava/lang/String;Z)Ld/u/m/d$d;
    //   672: astore 14
    //   674: aload 14
    //   676: ifnonnull +6 -> 682
    //   679: goto +23 -> 702
    //   682: aload_0
    //   683: aload 14
    //   685: invokevirtual 212	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   688: pop
    //   689: goto -88 -> 601
    //   692: aload 13
    //   694: invokeinterface 123 1 0
    //   699: goto +12 -> 711
    //   702: aload 13
    //   704: invokeinterface 123 1 0
    //   709: aload_2
    //   710: astore_0
    //   711: new 2	d/u/m/d
    //   714: dup
    //   715: aload_1
    //   716: aload 4
    //   718: aload 10
    //   720: aload_0
    //   721: invokespecial 228	d/u/m/d:<init>	(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V
    //   724: areturn
    //   725: astore_0
    //   726: aload 13
    //   728: invokeinterface 123 1 0
    //   733: aload_0
    //   734: athrow
    //   735: astore_0
    //   736: aload_2
    //   737: invokeinterface 123 1 0
    //   742: aload_0
    //   743: athrow
    //   744: astore_1
    //   745: aload_0
    //   746: invokeinterface 123 1 0
    //   751: aload_1
    //   752: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	paramb	b
    //   0	753	1	paramString	String
    //   8	729	2	localObject1	Object
    //   13	652	3	locala	d.w.a.f.a
    //   27	690	4	localHashMap	java.util.HashMap
    //   35	581	5	i	int
    //   60	398	6	j	int
    //   70	418	7	k	int
    //   80	554	8	m	int
    //   90	555	9	n	int
    //   109	610	10	localObject2	Object
    //   132	536	11	bool	boolean
    //   148	318	12	i1	int
    //   158	569	13	localObject3	Object
    //   163	521	14	localObject4	Object
    //   273	177	15	i2	int
    //   349	65	16	i3	int
    //   375	107	17	localObject5	Object
    //   404	26	18	localc	d.c
    // Exception table:
    //   from	to	target	type
    //   537	570	725	finally
    //   593	601	725	finally
    //   601	628	725	finally
    //   631	655	725	finally
    //   664	674	725	finally
    //   682	689	725	finally
    //   245	308	735	finally
    //   318	338	735	finally
    //   341	371	735	finally
    //   377	384	735	finally
    //   384	438	735	finally
    //   441	487	735	finally
    //   29	37	744	finally
    //   42	92	744	finally
    //   92	131	744	finally
    //   140	190	744	finally
  }
  
  public static List<d.c> a(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex("id");
    int j = paramCursor.getColumnIndex("seq");
    int k = paramCursor.getColumnIndex("from");
    int m = paramCursor.getColumnIndex("to");
    int n = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < n; i1++)
    {
      paramCursor.moveToPosition(i1);
      localArrayList.add(new d.c(paramCursor.getInt(i), paramCursor.getInt(j), paramCursor.getString(k), paramCursor.getString(m)));
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      paramObject = (d)paramObject;
      Object localObject = a;
      if (localObject != null ? !((String)localObject).equals(a) : a != null) {
        return false;
      }
      localObject = b;
      if (localObject != null ? !((Map)localObject).equals(b) : b != null) {
        return false;
      }
      localObject = c;
      if (localObject != null ? !((Set)localObject).equals(c) : c != null) {
        return false;
      }
      localObject = d;
      if (localObject != null)
      {
        paramObject = d;
        if (paramObject != null) {
          return ((Set)localObject).equals(paramObject);
        }
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = a;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = b;
    int k;
    if (localObject != null) {
      k = ((Map)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = c;
    if (localObject != null) {
      i = ((Set)localObject).hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("TableInfo{name='");
    e.a.a.a.a.a(localStringBuilder, a, '\'', ", columns=");
    localStringBuilder.append(b);
    localStringBuilder.append(", foreignKeys=");
    localStringBuilder.append(c);
    localStringBuilder.append(", indices=");
    localStringBuilder.append(d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.u.m.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */