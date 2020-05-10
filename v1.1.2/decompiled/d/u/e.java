package d.u;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import d.c.a.b.b.e;
import d.w.a.c;
import d.w.a.f;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class e
{
  public static final String[] k = { "UPDATE", "DELETE", "INSERT" };
  public final HashMap<String, Integer> a;
  public final String[] b;
  public Map<String, Set<String>> c;
  public final g d;
  public AtomicBoolean e;
  public volatile boolean f;
  public volatile f g;
  public b h;
  @SuppressLint({"RestrictedApi"})
  public final d.c.a.b.b<c, d> i;
  public Runnable j;
  
  public e(g paramg, Map<String, String> paramMap, Map<String, Set<String>> paramMap1, String... paramVarArgs)
  {
    int m = 0;
    e = new AtomicBoolean(false);
    f = false;
    i = new d.c.a.b.b();
    j = new a();
    d = paramg;
    h = new b(paramVarArgs.length);
    a = new HashMap();
    c = paramMap1;
    Collections.newSetFromMap(new IdentityHashMap());
    int n = paramVarArgs.length;
    b = new String[n];
    while (m < n)
    {
      paramg = paramVarArgs[m].toLowerCase(Locale.US);
      a.put(paramg, Integer.valueOf(m));
      paramMap1 = (String)paramMap.get(paramVarArgs[m]);
      if (paramMap1 != null) {
        b[m] = paramMap1.toLowerCase(Locale.US);
      } else {
        b[m] = paramg;
      }
      m++;
    }
    paramg = paramMap.entrySet().iterator();
    while (paramg.hasNext())
    {
      paramMap1 = (Map.Entry)paramg.next();
      paramMap = ((String)paramMap1.getValue()).toLowerCase(Locale.US);
      if (a.containsKey(paramMap))
      {
        paramMap1 = ((String)paramMap1.getKey()).toLowerCase(Locale.US);
        paramVarArgs = a;
        paramVarArgs.put(paramMap1, paramVarArgs.get(paramMap));
      }
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void a(c paramc)
  {
    ??? = a;
    HashSet localHashSet = new HashSet();
    int m = ???.length;
    int n = 0;
    for (int i1 = 0; i1 < m; i1++)
    {
      localObject2 = ???[i1];
      localObject3 = ((String)localObject2).toLowerCase(Locale.US);
      if (c.containsKey(localObject3)) {
        localHashSet.addAll((Collection)c.get(localObject3));
      } else {
        localHashSet.add(localObject2);
      }
    }
    ??? = (String[])localHashSet.toArray(new String[localHashSet.size()]);
    Object localObject2 = new int[???.length];
    m = ???.length;
    i1 = n;
    while (i1 < m)
    {
      localObject3 = (Integer)a.get(???[i1].toLowerCase(Locale.US));
      if (localObject3 != null)
      {
        localObject2[i1] = ((Integer)localObject3).intValue();
        i1++;
      }
      else
      {
        paramc = e.a.a.a.a.a("There is no table with name ");
        paramc.append(???[i1]);
        throw new IllegalArgumentException(paramc.toString());
      }
    }
    Object localObject3 = new d(paramc, (int[])localObject2, (String[])???);
    synchronized (i)
    {
      paramc = (d)i.b(paramc, localObject3);
      if ((paramc == null) && (h.a((int[])localObject2))) {
        b();
      }
      return;
    }
  }
  
  public void a(d.w.a.b paramb)
  {
    try
    {
      if (f)
      {
        Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
        return;
      }
      paramb.execSQL("PRAGMA temp_store = MEMORY;");
      paramb.execSQL("PRAGMA recursive_triggers='ON';");
      paramb.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
      b(paramb);
      g = paramb.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
      f = true;
      return;
    }
    finally {}
  }
  
  public final void a(d.w.a.b paramb, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", 0)");
    paramb.execSQL(localStringBuilder.toString());
    String str1 = b[paramInt];
    localStringBuilder = new StringBuilder();
    for (String str2 : k)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
      localStringBuilder.append("`");
      localStringBuilder.append("room_table_modification_trigger_");
      localStringBuilder.append(str1);
      localStringBuilder.append("_");
      localStringBuilder.append(str2);
      localStringBuilder.append("`");
      localStringBuilder.append(" AFTER ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ON `");
      localStringBuilder.append(str1);
      localStringBuilder.append("` BEGIN UPDATE ");
      localStringBuilder.append("room_table_modification_log");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 1");
      localStringBuilder.append(" WHERE ");
      localStringBuilder.append("table_id");
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" AND ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 0");
      localStringBuilder.append("; END");
      paramb.execSQL(localStringBuilder.toString());
    }
  }
  
  public void a(String... arg1)
  {
    synchronized (i)
    {
      Iterator localIterator = i.iterator();
      b.e locale;
      do
      {
        locale = (b.e)localIterator;
        if (!locale.hasNext()) {
          break;
        }
      } while ((f.e)((Map.Entry)locale.next()).getKey() != null);
      throw null;
      return;
    }
  }
  
  public boolean a()
  {
    d.w.a.b localb = d.a;
    int m;
    if ((localb != null) && (localb.isOpen())) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return false;
    }
    if (!f) {
      d.c.getWritableDatabase();
    }
    if (!f)
    {
      Log.e("ROOM", "database is not initialized even though it is open");
      return false;
    }
    return true;
  }
  
  public void b()
  {
    d.w.a.b localb = d.a;
    int m;
    if ((localb != null) && (localb.isOpen())) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return;
    }
    b(d.c.getWritableDatabase());
  }
  
  @SuppressLint({"RestrictedApi"})
  public void b(c paramc)
  {
    synchronized (i)
    {
      paramc = (d)i.remove(paramc);
      if ((paramc != null) && (h.b(a))) {
        b();
      }
      return;
    }
  }
  
  public void b(d.w.a.b paramb)
  {
    if (paramb.inTransaction()) {
      return;
    }
    try
    {
      for (;;)
      {
        ReentrantReadWriteLock.ReadLock localReadLock = d.h.readLock();
        localReadLock.lock();
        try
        {
          int[] arrayOfInt = h.a();
          if (arrayOfInt == null) {
            return;
          }
          int m = arrayOfInt.length;
          paramb.beginTransaction();
          int n = 0;
          for (;;)
          {
            if (n < m)
            {
              int i1 = arrayOfInt[n];
              if ((i1 != 1) && (i1 != 2)) {}
            }
            try
            {
              b(paramb, n);
              break label104;
              a(paramb, n);
              label104:
              n++;
            }
            finally {}
          }
          paramb.setTransactionSuccessful();
          paramb.endTransaction();
          h.b();
          localReadLock.unlock();
        }
        finally
        {
          localReadLock.unlock();
        }
      }
      Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", paramb);
    }
    catch (SQLiteException paramb) {}catch (IllegalStateException paramb) {}
  }
  
  public final void b(d.w.a.b paramb, int paramInt)
  {
    String str1 = b[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    for (String str2 : k)
    {
      localStringBuilder.setLength(0);
      localStringBuilder.append("DROP TRIGGER IF EXISTS ");
      localStringBuilder.append("`");
      localStringBuilder.append("room_table_modification_trigger_");
      localStringBuilder.append(str1);
      localStringBuilder.append("_");
      localStringBuilder.append(str2);
      localStringBuilder.append("`");
      paramb.execSQL(localStringBuilder.toString());
    }
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public final Set<Integer> a()
    {
      HashSet localHashSet = new HashSet();
      Cursor localCursor = d.a(new d.w.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null);
      try
      {
        while (localCursor.moveToNext()) {
          localHashSet.add(Integer.valueOf(localCursor.getInt(0)));
        }
        localCursor.close();
        if (!localHashSet.isEmpty()) {
          g.executeUpdateDelete();
        }
        return localHashSet;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	d/u/e$a:x	Ld/u/e;
      //   4: getfield 27	d/u/e:d	Ld/u/g;
      //   7: getfield 86	d/u/g:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   10: invokevirtual 92	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   13: astore_1
      //   14: aload_1
      //   15: invokeinterface 97 1 0
      //   20: aload_0
      //   21: getfield 14	d/u/e$a:x	Ld/u/e;
      //   24: invokevirtual 99	d/u/e:a	()Z
      //   27: istore_2
      //   28: iload_2
      //   29: ifne +10 -> 39
      //   32: aload_1
      //   33: invokeinterface 102 1 0
      //   38: return
      //   39: aload_0
      //   40: getfield 14	d/u/e$a:x	Ld/u/e;
      //   43: getfield 106	d/u/e:e	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   46: iconst_1
      //   47: iconst_0
      //   48: invokevirtual 112	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   51: istore_2
      //   52: iload_2
      //   53: ifne +10 -> 63
      //   56: aload_1
      //   57: invokeinterface 102 1 0
      //   62: return
      //   63: aload_0
      //   64: getfield 14	d/u/e$a:x	Ld/u/e;
      //   67: getfield 27	d/u/e:d	Ld/u/g;
      //   70: invokevirtual 114	d/u/g:e	()Z
      //   73: istore_2
      //   74: iload_2
      //   75: ifeq +10 -> 85
      //   78: aload_1
      //   79: invokeinterface 102 1 0
      //   84: return
      //   85: aload_0
      //   86: getfield 14	d/u/e$a:x	Ld/u/e;
      //   89: getfield 27	d/u/e:d	Ld/u/g;
      //   92: getfield 118	d/u/g:f	Z
      //   95: ifeq +107 -> 202
      //   98: aload_0
      //   99: getfield 14	d/u/e$a:x	Ld/u/e;
      //   102: getfield 27	d/u/e:d	Ld/u/g;
      //   105: getfield 122	d/u/g:c	Ld/w/a/c;
      //   108: invokeinterface 128 1 0
      //   113: astore_3
      //   114: aload_3
      //   115: invokeinterface 133 1 0
      //   120: aload_0
      //   121: invokevirtual 135	d/u/e$a:a	()Ljava/util/Set;
      //   124: astore 4
      //   126: aload_3
      //   127: invokeinterface 138 1 0
      //   132: aload 4
      //   134: astore 5
      //   136: aload 4
      //   138: astore 6
      //   140: aload_3
      //   141: invokeinterface 141 1 0
      //   146: goto +90 -> 236
      //   149: astore 7
      //   151: aload 5
      //   153: astore 4
      //   155: goto +71 -> 226
      //   158: astore 7
      //   160: aload 6
      //   162: astore 4
      //   164: goto +62 -> 226
      //   167: astore 7
      //   169: goto +8 -> 177
      //   172: astore 7
      //   174: aconst_null
      //   175: astore 4
      //   177: aload 4
      //   179: astore 5
      //   181: aload 4
      //   183: astore 6
      //   185: aload_3
      //   186: invokeinterface 141 1 0
      //   191: aload 4
      //   193: astore 5
      //   195: aload 4
      //   197: astore 6
      //   199: aload 7
      //   201: athrow
      //   202: aload_0
      //   203: invokevirtual 135	d/u/e$a:a	()Ljava/util/Set;
      //   206: astore 4
      //   208: goto +28 -> 236
      //   211: astore 4
      //   213: goto +235 -> 448
      //   216: astore 7
      //   218: goto +5 -> 223
      //   221: astore 7
      //   223: aconst_null
      //   224: astore 4
      //   226: ldc -113
      //   228: ldc -111
      //   230: aload 7
      //   232: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   235: pop
      //   236: aload_1
      //   237: invokeinterface 102 1 0
      //   242: aload 4
      //   244: ifnull +203 -> 447
      //   247: aload 4
      //   249: invokeinterface 153 1 0
      //   254: ifne +193 -> 447
      //   257: aload_0
      //   258: getfield 14	d/u/e$a:x	Ld/u/e;
      //   261: getfield 157	d/u/e:i	Ld/c/a/b/b;
      //   264: astore 7
      //   266: aload 7
      //   268: monitorenter
      //   269: aload_0
      //   270: getfield 14	d/u/e$a:x	Ld/u/e;
      //   273: getfield 157	d/u/e:i	Ld/c/a/b/b;
      //   276: invokevirtual 163	d/c/a/b/b:iterator	()Ljava/util/Iterator;
      //   279: astore_1
      //   280: aload_1
      //   281: checkcast 165	d/c/a/b/b$e
      //   284: astore 6
      //   286: aload 6
      //   288: invokevirtual 168	d/c/a/b/b$e:hasNext	()Z
      //   291: ifeq +142 -> 433
      //   294: aload 6
      //   296: invokevirtual 172	d/c/a/b/b$e:next	()Ljava/lang/Object;
      //   299: checkcast 174	java/util/Map$Entry
      //   302: invokeinterface 177 1 0
      //   307: checkcast 179	d/u/e$d
      //   310: astore_3
      //   311: aload_3
      //   312: getfield 182	d/u/e$d:a	[I
      //   315: arraylength
      //   316: istore 8
      //   318: aconst_null
      //   319: astore 6
      //   321: iconst_0
      //   322: istore 9
      //   324: iload 9
      //   326: iload 8
      //   328: if_icmpge +88 -> 416
      //   331: aload 6
      //   333: astore 5
      //   335: aload 4
      //   337: aload_3
      //   338: getfield 182	d/u/e$d:a	[I
      //   341: iload 9
      //   343: iaload
      //   344: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   347: invokeinterface 185 2 0
      //   352: ifeq +54 -> 406
      //   355: iload 8
      //   357: iconst_1
      //   358: if_icmpne +12 -> 370
      //   361: aload_3
      //   362: getfield 188	d/u/e$d:d	Ljava/util/Set;
      //   365: astore 5
      //   367: goto +39 -> 406
      //   370: aload 6
      //   372: astore 5
      //   374: aload 6
      //   376: ifnonnull +15 -> 391
      //   379: new 22	java/util/HashSet
      //   382: astore 5
      //   384: aload 5
      //   386: iload 8
      //   388: invokespecial 191	java/util/HashSet:<init>	(I)V
      //   391: aload 5
      //   393: aload_3
      //   394: getfield 195	d/u/e$d:b	[Ljava/lang/String;
      //   397: iload 9
      //   399: aaload
      //   400: invokeinterface 196 2 0
      //   405: pop
      //   406: iinc 9 1
      //   409: aload 5
      //   411: astore 6
      //   413: goto -89 -> 324
      //   416: aload 6
      //   418: ifnull -138 -> 280
      //   421: aload_3
      //   422: getfield 199	d/u/e$d:c	Ld/u/e$c;
      //   425: aload 6
      //   427: invokevirtual 204	d/u/e$c:a	(Ljava/util/Set;)V
      //   430: goto -150 -> 280
      //   433: aload 7
      //   435: monitorexit
      //   436: goto +11 -> 447
      //   439: astore 4
      //   441: aload 7
      //   443: monitorexit
      //   444: aload 4
      //   446: athrow
      //   447: return
      //   448: aload_1
      //   449: invokeinterface 102 1 0
      //   454: aload 4
      //   456: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	457	0	this	a
      //   13	436	1	localObject1	Object
      //   27	48	2	bool	boolean
      //   113	309	3	localObject2	Object
      //   124	83	4	localObject3	Object
      //   211	1	4	localObject4	Object
      //   224	112	4	localObject5	Object
      //   439	16	4	localObject6	Object
      //   134	276	5	localObject7	Object
      //   138	288	6	localObject8	Object
      //   149	1	7	localSQLiteException1	SQLiteException
      //   158	1	7	localIllegalStateException1	IllegalStateException
      //   167	1	7	localObject9	Object
      //   172	28	7	localObject10	Object
      //   216	1	7	localSQLiteException2	SQLiteException
      //   221	10	7	localIllegalStateException2	IllegalStateException
      //   264	178	7	localb	d.c.a.b.b
      //   316	71	8	i	int
      //   322	85	9	j	int
      // Exception table:
      //   from	to	target	type
      //   140	146	149	android/database/sqlite/SQLiteException
      //   185	191	149	android/database/sqlite/SQLiteException
      //   199	202	149	android/database/sqlite/SQLiteException
      //   140	146	158	java/lang/IllegalStateException
      //   185	191	158	java/lang/IllegalStateException
      //   199	202	158	java/lang/IllegalStateException
      //   126	132	167	finally
      //   120	126	172	finally
      //   14	28	211	finally
      //   39	52	211	finally
      //   63	74	211	finally
      //   85	120	211	finally
      //   140	146	211	finally
      //   185	191	211	finally
      //   199	202	211	finally
      //   202	208	211	finally
      //   226	236	211	finally
      //   14	28	216	android/database/sqlite/SQLiteException
      //   39	52	216	android/database/sqlite/SQLiteException
      //   63	74	216	android/database/sqlite/SQLiteException
      //   85	120	216	android/database/sqlite/SQLiteException
      //   202	208	216	android/database/sqlite/SQLiteException
      //   14	28	221	java/lang/IllegalStateException
      //   39	52	221	java/lang/IllegalStateException
      //   63	74	221	java/lang/IllegalStateException
      //   85	120	221	java/lang/IllegalStateException
      //   202	208	221	java/lang/IllegalStateException
      //   269	280	439	finally
      //   286	318	439	finally
      //   335	355	439	finally
      //   361	367	439	finally
      //   379	391	439	finally
      //   391	406	439	finally
      //   421	430	439	finally
      //   433	436	439	finally
      //   441	444	439	finally
    }
  }
  
  public static class b
  {
    public final long[] a;
    public final boolean[] b;
    public final int[] c;
    public boolean d;
    public boolean e;
    
    public b(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      a = arrayOfLong;
      b = new boolean[paramInt];
      c = new int[paramInt];
      Arrays.fill(arrayOfLong, 0L);
      Arrays.fill(b, false);
    }
    
    public boolean a(int... paramVarArgs)
    {
      try
      {
        int i = paramVarArgs.length;
        int j = 0;
        boolean bool = false;
        while (j < i)
        {
          int k = paramVarArgs[j];
          long l = a[k];
          a[k] = (1L + l);
          if (l == 0L)
          {
            d = true;
            bool = true;
          }
          j++;
        }
        return bool;
      }
      finally {}
    }
    
    public int[] a()
    {
      try
      {
        if ((d) && (!e))
        {
          int i = a.length;
          for (int j = 0;; j++)
          {
            int k = 1;
            if (j >= i) {
              break;
            }
            int m;
            if (a[j] > 0L) {
              m = 1;
            } else {
              m = 0;
            }
            if (m != b[j])
            {
              arrayOfInt = c;
              if (m == 0) {
                k = 2;
              }
              arrayOfInt[j] = k;
            }
            else
            {
              c[j] = 0;
            }
            b[j] = m;
          }
          e = true;
          d = false;
          int[] arrayOfInt = c;
          return arrayOfInt;
        }
        return null;
      }
      finally {}
    }
    
    public void b()
    {
      try
      {
        e = false;
        return;
      }
      finally {}
    }
    
    public boolean b(int... paramVarArgs)
    {
      try
      {
        int i = paramVarArgs.length;
        int j = 0;
        boolean bool = false;
        while (j < i)
        {
          int k = paramVarArgs[j];
          long l = a[k];
          a[k] = (l - 1L);
          if (l == 1L)
          {
            d = true;
            bool = true;
          }
          j++;
        }
        return bool;
      }
      finally {}
    }
  }
  
  public static abstract class c
  {
    public final String[] a;
    
    public c(String[] paramArrayOfString)
    {
      a = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    }
    
    public abstract void a(Set<String> paramSet);
  }
  
  public static class d
  {
    public final int[] a;
    public final String[] b;
    public final e.c c;
    public final Set<String> d;
    
    public d(e.c paramc, int[] paramArrayOfInt, String[] paramArrayOfString)
    {
      c = paramc;
      a = paramArrayOfInt;
      b = paramArrayOfString;
      if (paramArrayOfInt.length == 1)
      {
        paramc = new HashSet();
        paramc.add(b[0]);
        d = Collections.unmodifiableSet(paramc);
      }
      else
      {
        d = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.u.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */