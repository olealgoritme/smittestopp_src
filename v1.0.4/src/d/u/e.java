package d.u;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import d.c.a.b.b.e;
import d.w.a.c;
import d.w.a.f.f;
import java.util.AbstractCollection;
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
  public e.b h;
  @SuppressLint({"RestrictedApi"})
  public final d.c.a.b.b<e.c, e.d> i;
  public Runnable j;
  
  public e(g paramg, Map<String, String> paramMap, Map<String, Set<String>> paramMap1, String... paramVarArgs)
  {
    int m = 0;
    e = new AtomicBoolean(false);
    f = false;
    i = new d.c.a.b.b();
    j = new e.a(this);
    d = paramg;
    h = new e.b(paramVarArgs.length);
    a = new HashMap();
    c = paramMap1;
    Collections.newSetFromMap(new IdentityHashMap());
    int n = paramVarArgs.length;
    b = new String[n];
    while (m < n)
    {
      paramMap1 = paramVarArgs[m].toLowerCase(Locale.US);
      a.put(paramMap1, Integer.valueOf(m));
      paramg = (String)paramMap.get(paramVarArgs[m]);
      if (paramg != null) {
        b[m] = paramg.toLowerCase(Locale.US);
      } else {
        b[m] = paramMap1;
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
        paramVarArgs = ((String)paramMap1.getKey()).toLowerCase(Locale.US);
        paramMap1 = a;
        paramMap1.put(paramVarArgs, paramMap1.get(paramMap));
      }
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void a(e.c paramc)
  {
    String[] arrayOfString = a;
    Object localObject1 = new HashSet();
    int m = arrayOfString.length;
    int n = 0;
    for (int i1 = 0; i1 < m; i1++)
    {
      localObject2 = arrayOfString[i1];
      ??? = ((String)localObject2).toLowerCase(Locale.US);
      if (c.containsKey(???)) {
        ((AbstractCollection)localObject1).addAll((Collection)c.get(???));
      } else {
        ((HashSet)localObject1).add(localObject2);
      }
    }
    ??? = (String[])((AbstractCollection)localObject1).toArray(new String[((HashSet)localObject1).size()]);
    localObject1 = new int[???.length];
    m = ???.length;
    i1 = n;
    while (i1 < m)
    {
      localObject2 = (Integer)a.get(???[i1].toLowerCase(Locale.US));
      if (localObject2 != null)
      {
        localObject1[i1] = ((Integer)localObject2).intValue();
        i1++;
      }
      else
      {
        paramc = e.a.a.a.a.a("There is no table with name ");
        paramc.append(???[i1]);
        throw new IllegalArgumentException(paramc.toString());
      }
    }
    Object localObject2 = new e.d(paramc, (int[])localObject1, (String[])???);
    synchronized (i)
    {
      paramc = (e.d)i.b(paramc, localObject2);
      if ((paramc == null) && (h.a((int[])localObject1))) {
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
      x.execSQL("PRAGMA temp_store = MEMORY;");
      x.execSQL("PRAGMA recursive_triggers='ON';");
      x.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
      b(paramb);
      paramb = (d.w.a.f.a)paramb;
      f localf = new d/w/a/f/f;
      localf.<init>(x.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
      g = localf;
      f = true;
      return;
    }
    finally {}
  }
  
  public final void a(d.w.a.b paramb, int paramInt)
  {
    String str1 = e.a.a.a.a.b("INSERT OR IGNORE INTO room_table_modification_log VALUES(", paramInt, ", 0)");
    paramb = (d.w.a.f.a)paramb;
    x.execSQL(str1);
    str1 = b[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
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
      str2 = localStringBuilder.toString();
      x.execSQL(str2);
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
    if (!d.f()) {
      return false;
    }
    if (!f) {
      d.c.a();
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
    if (!d.f()) {
      return;
    }
    b(d.c.a());
  }
  
  @SuppressLint({"RestrictedApi"})
  public void b(e.c paramc)
  {
    synchronized (i)
    {
      paramc = (e.d)i.remove(paramc);
      if ((paramc != null) && (h.b(a))) {
        b();
      }
      return;
    }
  }
  
  public void b(d.w.a.b paramb)
  {
    if (x.inTransaction()) {
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
          x.beginTransaction();
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
              break label112;
              a(paramb, n);
              label112:
              n++;
            }
            finally
            {
              x.endTransaction();
            }
          }
          x.setTransactionSuccessful();
          x.endTransaction();
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
      str2 = localStringBuilder.toString();
      x.execSQL(str2);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.u.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */