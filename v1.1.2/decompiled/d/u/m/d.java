package d.u.m;

import android.database.Cursor;
import d.w.a.b;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class d
{
  public final String a;
  public final Map<String, a> b;
  public final Set<b> c;
  public final Set<d> d;
  
  public d(String paramString, Map<String, a> paramMap, Set<b> paramSet, Set<d> paramSet1)
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
  
  public static d a(b paramb, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA index_xinfo(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramb = paramb.query(((StringBuilder)localObject).toString());
    try
    {
      int i = paramb.getColumnIndex("seqno");
      int j = paramb.getColumnIndex("cid");
      int k = paramb.getColumnIndex("name");
      if ((i != -1) && (j != -1) && (k != -1))
      {
        localObject = new java/util/TreeMap;
        ((TreeMap)localObject).<init>();
        while (paramb.moveToNext()) {
          if (paramb.getInt(j) >= 0) {
            ((TreeMap)localObject).put(Integer.valueOf(paramb.getInt(i)), paramb.getString(k));
          }
        }
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(((TreeMap)localObject).size());
        localArrayList.addAll(((TreeMap)localObject).values());
        paramString = new d(paramString, paramBoolean, localArrayList);
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
    //   0: new 51	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc -123
    //   11: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: ldc 60
    //   24: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_0
    //   29: aload_2
    //   30: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokeinterface 70 2 0
    //   38: astore_2
    //   39: new 135	java/util/HashMap
    //   42: dup
    //   43: invokespecial 136	java/util/HashMap:<init>	()V
    //   46: astore_3
    //   47: aload_2
    //   48: invokeinterface 139 1 0
    //   53: istore 4
    //   55: iload 4
    //   57: ifle +155 -> 212
    //   60: aload_2
    //   61: ldc 82
    //   63: invokeinterface 78 2 0
    //   68: istore 5
    //   70: aload_2
    //   71: ldc -115
    //   73: invokeinterface 78 2 0
    //   78: istore 4
    //   80: aload_2
    //   81: ldc -113
    //   83: invokeinterface 78 2 0
    //   88: istore 6
    //   90: aload_2
    //   91: ldc -111
    //   93: invokeinterface 78 2 0
    //   98: istore 7
    //   100: aload_2
    //   101: ldc -109
    //   103: invokeinterface 78 2 0
    //   108: istore 8
    //   110: aload_2
    //   111: invokeinterface 89 1 0
    //   116: ifeq +96 -> 212
    //   119: aload_2
    //   120: iload 5
    //   122: invokeinterface 103 2 0
    //   127: astore 9
    //   129: aload_2
    //   130: iload 4
    //   132: invokeinterface 103 2 0
    //   137: astore 10
    //   139: aload_2
    //   140: iload 6
    //   142: invokeinterface 93 2 0
    //   147: ifeq +9 -> 156
    //   150: iconst_1
    //   151: istore 11
    //   153: goto +6 -> 159
    //   156: iconst_0
    //   157: istore 11
    //   159: aload_2
    //   160: iload 7
    //   162: invokeinterface 93 2 0
    //   167: istore 12
    //   169: aload_2
    //   170: iload 8
    //   172: invokeinterface 103 2 0
    //   177: astore 13
    //   179: new 6	d/u/m/d$a
    //   182: astore 14
    //   184: aload 14
    //   186: aload 9
    //   188: aload 10
    //   190: iload 11
    //   192: iload 12
    //   194: aload 13
    //   196: iconst_2
    //   197: invokespecial 150	d/u/m/d$a:<init>	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V
    //   200: aload_3
    //   201: aload 9
    //   203: aload 14
    //   205: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: pop
    //   209: goto -99 -> 110
    //   212: aload_2
    //   213: invokeinterface 130 1 0
    //   218: new 153	java/util/HashSet
    //   221: dup
    //   222: invokespecial 154	java/util/HashSet:<init>	()V
    //   225: astore 13
    //   227: new 51	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   234: astore_2
    //   235: aload_2
    //   236: ldc -100
    //   238: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: aload_1
    //   244: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_2
    //   249: ldc 60
    //   251: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_0
    //   256: aload_2
    //   257: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokeinterface 70 2 0
    //   265: astore 10
    //   267: aload 10
    //   269: ldc -98
    //   271: invokeinterface 78 2 0
    //   276: istore 12
    //   278: aload 10
    //   280: ldc -96
    //   282: invokeinterface 78 2 0
    //   287: istore 5
    //   289: aload 10
    //   291: ldc -94
    //   293: invokeinterface 78 2 0
    //   298: istore 8
    //   300: aload 10
    //   302: ldc -92
    //   304: invokeinterface 78 2 0
    //   309: istore 15
    //   311: aload 10
    //   313: ldc -90
    //   315: invokeinterface 78 2 0
    //   320: istore 7
    //   322: aload 10
    //   324: invokestatic 169	d/u/m/d:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   327: astore_2
    //   328: aload 10
    //   330: invokeinterface 172 1 0
    //   335: istore 4
    //   337: iconst_0
    //   338: istore 6
    //   340: iload 6
    //   342: iload 4
    //   344: if_icmpge +184 -> 528
    //   347: aload 10
    //   349: iload 6
    //   351: invokeinterface 176 2 0
    //   356: pop
    //   357: aload 10
    //   359: iload 5
    //   361: invokeinterface 93 2 0
    //   366: ifeq +6 -> 372
    //   369: goto +153 -> 522
    //   372: aload 10
    //   374: iload 12
    //   376: invokeinterface 93 2 0
    //   381: istore 16
    //   383: new 109	java/util/ArrayList
    //   386: astore 14
    //   388: aload 14
    //   390: invokespecial 177	java/util/ArrayList:<init>	()V
    //   393: new 109	java/util/ArrayList
    //   396: astore 9
    //   398: aload 9
    //   400: invokespecial 177	java/util/ArrayList:<init>	()V
    //   403: aload_2
    //   404: checkcast 109	java/util/ArrayList
    //   407: astore 17
    //   409: aload 17
    //   411: invokevirtual 181	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   414: astore 17
    //   416: aload 17
    //   418: invokeinterface 186 1 0
    //   423: ifeq +50 -> 473
    //   426: aload 17
    //   428: invokeinterface 190 1 0
    //   433: checkcast 12	d/u/m/d$c
    //   436: astore 18
    //   438: aload 18
    //   440: getfield 194	d/u/m/d$c:x	I
    //   443: iload 16
    //   445: if_icmpne +25 -> 470
    //   448: aload 14
    //   450: aload 18
    //   452: getfield 197	d/u/m/d$c:z	Ljava/lang/String;
    //   455: invokevirtual 201	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   458: pop
    //   459: aload 9
    //   461: aload 18
    //   463: getfield 204	d/u/m/d$c:A	Ljava/lang/String;
    //   466: invokevirtual 201	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   469: pop
    //   470: goto -54 -> 416
    //   473: new 9	d/u/m/d$b
    //   476: astore 17
    //   478: aload 17
    //   480: aload 10
    //   482: iload 8
    //   484: invokeinterface 103 2 0
    //   489: aload 10
    //   491: iload 15
    //   493: invokeinterface 103 2 0
    //   498: aload 10
    //   500: iload 7
    //   502: invokeinterface 103 2 0
    //   507: aload 14
    //   509: aload 9
    //   511: invokespecial 207	d/u/m/d$b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   514: aload 13
    //   516: aload 17
    //   518: invokevirtual 208	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   521: pop
    //   522: iinc 6 1
    //   525: goto -185 -> 340
    //   528: aload 10
    //   530: invokeinterface 130 1 0
    //   535: new 51	java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   542: astore_2
    //   543: aload_2
    //   544: ldc -46
    //   546: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_2
    //   551: aload_1
    //   552: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_2
    //   557: ldc 60
    //   559: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_0
    //   564: aload_2
    //   565: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokeinterface 70 2 0
    //   573: astore 14
    //   575: aload 14
    //   577: ldc 82
    //   579: invokeinterface 78 2 0
    //   584: istore 5
    //   586: aload 14
    //   588: ldc -44
    //   590: invokeinterface 78 2 0
    //   595: istore 12
    //   597: aload 14
    //   599: ldc -42
    //   601: invokeinterface 78 2 0
    //   606: istore 4
    //   608: aconst_null
    //   609: astore 10
    //   611: iload 5
    //   613: iconst_m1
    //   614: if_icmpeq +129 -> 743
    //   617: iload 12
    //   619: iconst_m1
    //   620: if_icmpeq +123 -> 743
    //   623: iload 4
    //   625: iconst_m1
    //   626: if_icmpne +6 -> 632
    //   629: goto +114 -> 743
    //   632: new 153	java/util/HashSet
    //   635: astore_2
    //   636: aload_2
    //   637: invokespecial 154	java/util/HashSet:<init>	()V
    //   640: aload 14
    //   642: invokeinterface 89 1 0
    //   647: ifeq +84 -> 731
    //   650: ldc -41
    //   652: aload 14
    //   654: iload 12
    //   656: invokeinterface 103 2 0
    //   661: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifne +6 -> 670
    //   667: goto -27 -> 640
    //   670: aload 14
    //   672: iload 5
    //   674: invokeinterface 103 2 0
    //   679: astore 9
    //   681: aload 14
    //   683: iload 4
    //   685: invokeinterface 93 2 0
    //   690: iconst_1
    //   691: if_icmpne +9 -> 700
    //   694: iconst_1
    //   695: istore 11
    //   697: goto +6 -> 703
    //   700: iconst_0
    //   701: istore 11
    //   703: aload_0
    //   704: aload 9
    //   706: iload 11
    //   708: invokestatic 222	d/u/m/d:a	(Ld/w/a/b;Ljava/lang/String;Z)Ld/u/m/d$d;
    //   711: astore 9
    //   713: aload 9
    //   715: ifnonnull +6 -> 721
    //   718: goto +25 -> 743
    //   721: aload_2
    //   722: aload 9
    //   724: invokevirtual 208	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   727: pop
    //   728: goto -88 -> 640
    //   731: aload 14
    //   733: invokeinterface 130 1 0
    //   738: aload_2
    //   739: astore_0
    //   740: goto +13 -> 753
    //   743: aload 14
    //   745: invokeinterface 130 1 0
    //   750: aload 10
    //   752: astore_0
    //   753: new 2	d/u/m/d
    //   756: dup
    //   757: aload_1
    //   758: aload_3
    //   759: aload 13
    //   761: aload_0
    //   762: invokespecial 224	d/u/m/d:<init>	(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V
    //   765: areturn
    //   766: astore_0
    //   767: aload 14
    //   769: invokeinterface 130 1 0
    //   774: aload_0
    //   775: athrow
    //   776: astore_0
    //   777: aload 10
    //   779: invokeinterface 130 1 0
    //   784: aload_0
    //   785: athrow
    //   786: astore_0
    //   787: aload_2
    //   788: invokeinterface 130 1 0
    //   793: aload_0
    //   794: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	paramb	b
    //   0	795	1	paramString	String
    //   7	781	2	localObject1	Object
    //   46	713	3	localHashMap	java.util.HashMap
    //   53	631	4	i	int
    //   68	605	5	j	int
    //   88	435	6	k	int
    //   98	403	7	m	int
    //   108	375	8	n	int
    //   127	596	9	localObject2	Object
    //   137	641	10	localObject3	Object
    //   151	556	11	bool	boolean
    //   167	488	12	i1	int
    //   177	583	13	localObject4	Object
    //   182	586	14	localObject5	Object
    //   309	183	15	i2	int
    //   381	65	16	i3	int
    //   407	110	17	localObject6	Object
    //   436	26	18	localc	c
    // Exception table:
    //   from	to	target	type
    //   575	608	766	finally
    //   632	640	766	finally
    //   640	667	766	finally
    //   670	694	766	finally
    //   703	713	766	finally
    //   721	728	766	finally
    //   267	337	776	finally
    //   347	369	776	finally
    //   372	403	776	finally
    //   409	416	776	finally
    //   416	470	776	finally
    //   473	522	776	finally
    //   47	55	786	finally
    //   60	110	786	finally
    //   110	150	786	finally
    //   159	209	786	finally
  }
  
  public static List<c> a(Cursor paramCursor)
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
      localArrayList.add(new c(paramCursor.getInt(i), paramCursor.getInt(j), paramCursor.getString(k), paramCursor.getString(m)));
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
    StringBuilder localStringBuilder = a.a("TableInfo{name='");
    a.a(localStringBuilder, a, '\'', ", columns=");
    localStringBuilder.append(b);
    localStringBuilder.append(", foreignKeys=");
    localStringBuilder.append(c);
    localStringBuilder.append(", indices=");
    localStringBuilder.append(d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final int e;
    public final String f;
    public final int g;
    
    public a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, String paramString3, int paramInt2)
    {
      a = paramString1;
      b = paramString2;
      d = paramBoolean;
      e = paramInt1;
      paramInt1 = 5;
      if (paramString2 != null)
      {
        paramString1 = paramString2.toUpperCase(Locale.US);
        if (paramString1.contains("INT")) {
          paramInt1 = 3;
        } else if ((!paramString1.contains("CHAR")) && (!paramString1.contains("CLOB")) && (!paramString1.contains("TEXT")))
        {
          if (!paramString1.contains("BLOB")) {
            if ((!paramString1.contains("REAL")) && (!paramString1.contains("FLOA")) && (!paramString1.contains("DOUB"))) {
              paramInt1 = 1;
            } else {
              paramInt1 = 4;
            }
          }
        }
        else {
          paramInt1 = 2;
        }
      }
      c = paramInt1;
      f = paramString3;
      g = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (a.class == paramObject.getClass()))
      {
        paramObject = (a)paramObject;
        if (e != e) {
          return false;
        }
        if (!a.equals(a)) {
          return false;
        }
        if (d != d) {
          return false;
        }
        String str;
        if ((g == 1) && (g == 2))
        {
          str = f;
          if ((str != null) && (!str.equals(f))) {
            return false;
          }
        }
        if ((g == 2) && (g == 1))
        {
          str = f;
          if ((str != null) && (!str.equals(f))) {
            return false;
          }
        }
        int i = g;
        if ((i != 0) && (i == g))
        {
          str = f;
          if (str != null ? !str.equals(f) : f != null) {
            return false;
          }
        }
        if (c != c) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = a.hashCode();
      int j = c;
      int k;
      if (d) {
        k = 1231;
      } else {
        k = 1237;
      }
      return ((i * 31 + j) * 31 + k) * 31 + e;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("Column{name='");
      a.a(localStringBuilder, a, '\'', ", type='");
      a.a(localStringBuilder, b, '\'', ", affinity='");
      localStringBuilder.append(c);
      localStringBuilder.append('\'');
      localStringBuilder.append(", notNull=");
      localStringBuilder.append(d);
      localStringBuilder.append(", primaryKeyPosition=");
      localStringBuilder.append(e);
      localStringBuilder.append(", defaultValue='");
      localStringBuilder.append(f);
      localStringBuilder.append('\'');
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final List<String> e;
    
    public b(String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2)
    {
      a = paramString1;
      b = paramString2;
      c = paramString3;
      d = Collections.unmodifiableList(paramList1);
      e = Collections.unmodifiableList(paramList2);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (b.class == paramObject.getClass()))
      {
        paramObject = (b)paramObject;
        if (!a.equals(a)) {
          return false;
        }
        if (!b.equals(b)) {
          return false;
        }
        if (!c.equals(c)) {
          return false;
        }
        if (!d.equals(d)) {
          return false;
        }
        return e.equals(e);
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = a.hashCode();
      int j = b.hashCode();
      int k = c.hashCode();
      int m = d.hashCode();
      return e.hashCode() + (m + (k + (j + i * 31) * 31) * 31) * 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("ForeignKey{referenceTable='");
      a.a(localStringBuilder, a, '\'', ", onDelete='");
      a.a(localStringBuilder, b, '\'', ", onUpdate='");
      a.a(localStringBuilder, c, '\'', ", columnNames=");
      localStringBuilder.append(d);
      localStringBuilder.append(", referenceColumnNames=");
      localStringBuilder.append(e);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class c
    implements Comparable<c>
  {
    public final String A;
    public final int x;
    public final int y;
    public final String z;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      x = paramInt1;
      y = paramInt2;
      z = paramString1;
      A = paramString2;
    }
    
    public int compareTo(Object paramObject)
    {
      paramObject = (c)paramObject;
      int i = x - x;
      int j = i;
      if (i == 0) {
        j = y - y;
      }
      return j;
    }
  }
  
  public static class d
  {
    public final String a;
    public final boolean b;
    public final List<String> c;
    
    public d(String paramString, boolean paramBoolean, List<String> paramList)
    {
      a = paramString;
      b = paramBoolean;
      c = paramList;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (d.class == paramObject.getClass()))
      {
        paramObject = (d)paramObject;
        if (b != b) {
          return false;
        }
        if (!c.equals(c)) {
          return false;
        }
        if (a.startsWith("index_")) {
          return a.startsWith("index_");
        }
        return a.equals(a);
      }
      return false;
    }
    
    public int hashCode()
    {
      int i;
      if (a.startsWith("index_")) {
        i = -1184239155;
      } else {
        i = a.hashCode();
      }
      int j = b;
      return c.hashCode() + (i * 31 + j) * 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("Index{name='");
      a.a(localStringBuilder, a, '\'', ", unique=");
      localStringBuilder.append(b);
      localStringBuilder.append(", columns=");
      localStringBuilder.append(c);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}

/* Location:
 * Qualified Name:     d.u.m.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */