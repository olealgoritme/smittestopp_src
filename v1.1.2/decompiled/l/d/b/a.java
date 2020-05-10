package l.d.b;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import l.d.b.i.e;

public abstract class a<T, K>
{
  public final l.d.b.i.a a;
  public final l.d.b.g.a b;
  public final boolean c;
  public final l.d.b.h.a<K, T> d;
  public final l.d.b.h.b<T> e;
  public final e f;
  public final int g;
  
  public a(l.d.b.i.a parama, c paramc)
  {
    a = parama;
    paramc = x;
    b = paramc;
    c = (paramc.b() instanceof SQLiteDatabase);
    paramc = G;
    d = paramc;
    if ((paramc instanceof l.d.b.h.b)) {
      e = ((l.d.b.h.b)paramc);
    } else {
      e = null;
    }
    f = F;
    parama = D;
    int i;
    if (parama != null) {
      i = a;
    } else {
      i = -1;
    }
    g = i;
  }
  
  public final long a(T paramT, l.d.b.g.c paramc)
  {
    try
    {
      if (c)
      {
        SQLiteStatement localSQLiteStatement = (SQLiteStatement)paramc.b();
        a(localSQLiteStatement, paramT);
        l = localSQLiteStatement.executeInsert();
        return l;
      }
      a(paramc, paramT);
      long l = paramc.executeInsert();
      return l;
    }
    finally {}
  }
  
  public abstract T a(Cursor paramCursor, int paramInt);
  
  public final T a(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = e;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      if ((paramInt != 0) && (paramCursor.isNull(g + paramInt))) {
        return null;
      }
      long l = paramCursor.getLong(g + paramInt);
      localObject1 = e;
      if (paramBoolean)
      {
        localObject2 = ((l.d.b.h.b)localObject1).a(l);
      }
      else
      {
        localObject1 = (Reference)a.a(l);
        if (localObject1 != null) {
          localObject2 = ((Reference)localObject1).get();
        }
      }
      if (localObject2 != null) {
        return (T)localObject2;
      }
      paramCursor = a(paramCursor, paramInt);
      if (paramBoolean) {
        e.a(l, paramCursor);
      } else {
        e.a.a(l, new WeakReference(paramCursor));
      }
      return paramCursor;
    }
    if (d != null)
    {
      localObject1 = b(paramCursor, paramInt);
      if ((paramInt != 0) && (localObject1 == null)) {
        return null;
      }
      localObject2 = d;
      if (paramBoolean) {
        localObject2 = ((l.d.b.h.a)localObject2).get(localObject1);
      } else {
        localObject2 = ((l.d.b.h.a)localObject2).a(localObject1);
      }
      if (localObject2 != null) {
        return (T)localObject2;
      }
      paramCursor = a(paramCursor, paramInt);
      a(localObject1, paramCursor, paramBoolean);
      return paramCursor;
    }
    if ((paramInt != 0) && (b(paramCursor, paramInt) == null)) {
      return null;
    }
    return (T)a(paramCursor, paramInt);
  }
  
  public abstract K a(T paramT);
  
  public abstract K a(T paramT, long paramLong);
  
  public List<T> a(Cursor paramCursor)
  {
    int i = paramCursor.getCount();
    if (i == 0) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(i);
    Object localObject1 = null;
    Object localObject2;
    if ((paramCursor instanceof CrossProcessCursor))
    {
      localObject2 = ((CrossProcessCursor)paramCursor).getWindow();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (((CursorWindow)localObject2).getNumRows() == i)
        {
          paramCursor = new l.d.b.i.b((CursorWindow)localObject2);
          j = 1;
          localObject1 = localObject2;
          break label136;
        }
        localObject1 = e.a.a.a.a.a("Window vs. result size: ");
        ((StringBuilder)localObject1).append(((CursorWindow)localObject2).getNumRows());
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i);
        l.b.c.e.a.a(((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    int j = 0;
    label136:
    if (paramCursor.moveToFirst())
    {
      localObject2 = d;
      if (localObject2 != null)
      {
        ((l.d.b.h.a)localObject2).b();
        d.a(i);
      }
      if ((j == 0) && (localObject1 != null)) {}
      try
      {
        if (d != null)
        {
          a(paramCursor, (CursorWindow)localObject1, localArrayList);
        }
        else
        {
          boolean bool;
          do
          {
            localArrayList.add(a(paramCursor, 0, false));
            bool = paramCursor.moveToNext();
          } while (bool);
        }
        paramCursor = d;
        if (paramCursor != null) {
          paramCursor.a();
        }
      }
      finally
      {
        localObject1 = d;
        if (localObject1 != null) {
          ((l.d.b.h.a)localObject1).a();
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    l.d.b.g.a locala = b;
    Object localObject = e.a.a.a.a.a("DELETE FROM '");
    ((StringBuilder)localObject).append(a.y);
    ((StringBuilder)localObject).append("'");
    locala.execSQL(((StringBuilder)localObject).toString());
    localObject = d;
    if (localObject != null) {
      ((l.d.b.h.a)localObject).clear();
    }
  }
  
  public final void a(Cursor paramCursor, CursorWindow paramCursorWindow, List<T> paramList)
  {
    int i = paramCursorWindow.getStartPosition();
    i = paramCursorWindow.getNumRows() + i;
    for (int j = 0;; j++)
    {
      paramList.add(a(paramCursor, 0, false));
      j++;
      if (j >= i) {
        d.a();
      }
      try
      {
        if (paramCursor.moveToNext()) {
          paramCursorWindow = ((CrossProcessCursor)paramCursor).getWindow();
        } else {
          paramCursorWindow = null;
        }
        d.b();
        if (paramCursorWindow != null)
        {
          i = paramCursorWindow.getStartPosition();
          i = paramCursorWindow.getNumRows() + i;
        }
      }
      finally
      {
        d.b();
      }
      return;
    }
  }
  
  public abstract void a(SQLiteStatement paramSQLiteStatement, T paramT);
  
  /* Error */
  public void a(Iterable<T> paramIterable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	l/d/b/a:f	Ll/d/b/i/e;
    //   4: invokevirtual 247	l/d/b/i/e:c	()Ll/d/b/g/c;
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   12: invokeinterface 250 1 0
    //   17: aload_2
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   23: ifnull +12 -> 35
    //   26: aload_0
    //   27: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   30: invokeinterface 200 1 0
    //   35: aload_0
    //   36: getfield 44	l/d/b/a:c	Z
    //   39: ifeq +44 -> 83
    //   42: aload_2
    //   43: invokeinterface 73 1 0
    //   48: checkcast 75	android/database/sqlite/SQLiteStatement
    //   51: astore_3
    //   52: aload_1
    //   53: invokeinterface 256 1 0
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 261 1 0
    //   65: ifeq +49 -> 114
    //   68: aload_0
    //   69: aload_1
    //   70: invokeinterface 264 1 0
    //   75: aload_3
    //   76: iconst_0
    //   77: invokevirtual 267	l/d/b/a:a	(Ljava/lang/Object;Landroid/database/sqlite/SQLiteStatement;Z)V
    //   80: goto -21 -> 59
    //   83: aload_1
    //   84: invokeinterface 256 1 0
    //   89: astore_1
    //   90: aload_1
    //   91: invokeinterface 261 1 0
    //   96: ifeq +18 -> 114
    //   99: aload_0
    //   100: aload_1
    //   101: invokeinterface 264 1 0
    //   106: aload_2
    //   107: iconst_0
    //   108: invokevirtual 270	l/d/b/a:a	(Ljava/lang/Object;Ll/d/b/g/c;Z)V
    //   111: goto -21 -> 90
    //   114: aload_0
    //   115: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   118: ifnull +12 -> 130
    //   121: aload_0
    //   122: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   125: invokeinterface 216 1 0
    //   130: aload_2
    //   131: monitorexit
    //   132: aload_0
    //   133: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   136: invokeinterface 273 1 0
    //   141: aload_0
    //   142: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   145: invokeinterface 276 1 0
    //   150: aconst_null
    //   151: astore_1
    //   152: goto +55 -> 207
    //   155: astore_1
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   163: ifnull +12 -> 175
    //   166: aload_0
    //   167: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   170: invokeinterface 216 1 0
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: aload_2
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   187: invokeinterface 276 1 0
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: aload_0
    //   199: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   202: invokeinterface 276 1 0
    //   207: aload_1
    //   208: ifnonnull +4 -> 212
    //   211: return
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: ldc_w 278
    //   218: aload_2
    //   219: invokestatic 281	l/b/c/e/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   222: pop
    //   223: aload_1
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	a
    //   0	225	1	paramIterable	Iterable<T>
    //   7	172	2	localc	l.d.b.g.c
    //   214	5	2	localRuntimeException	RuntimeException
    //   51	25	3	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   141	150	155	java/lang/RuntimeException
    //   35	59	158	finally
    //   59	80	158	finally
    //   83	90	158	finally
    //   90	111	158	finally
    //   19	35	177	finally
    //   114	130	177	finally
    //   130	132	177	finally
    //   159	175	177	finally
    //   175	177	177	finally
    //   178	180	177	finally
    //   17	19	182	finally
    //   132	141	182	finally
    //   180	182	182	finally
    //   183	192	194	java/lang/RuntimeException
    //   17	19	197	java/lang/RuntimeException
    //   132	141	197	java/lang/RuntimeException
    //   180	182	197	java/lang/RuntimeException
    //   198	207	214	java/lang/RuntimeException
  }
  
  public void a(T paramT, long paramLong, boolean paramBoolean)
  {
    if (paramLong != -1L) {
      a(a(paramT, paramLong), paramT, paramBoolean);
    } else {
      Log.w("greenDAO", "Could not insert row (executeInsert returned -1)");
    }
  }
  
  public void a(T paramT, SQLiteStatement paramSQLiteStatement, boolean paramBoolean)
  {
    a(paramSQLiteStatement, paramT);
    int i = a.A.length + 1;
    Object localObject = a(paramT);
    if ((localObject instanceof Long))
    {
      paramSQLiteStatement.bindLong(i, ((Long)localObject).longValue());
    }
    else
    {
      if (localObject == null) {
        break label79;
      }
      paramSQLiteStatement.bindString(i, localObject.toString());
    }
    paramSQLiteStatement.execute();
    a(localObject, paramT, paramBoolean);
    return;
    label79:
    throw new d("Cannot update entity without key - was it inserted before?");
  }
  
  public final void a(K paramK, T paramT, boolean paramBoolean)
  {
    l.d.b.h.a locala = d;
    if ((locala != null) && (paramK != null)) {
      if (paramBoolean) {
        locala.put(paramK, paramT);
      } else {
        locala.a(paramK, paramT);
      }
    }
  }
  
  public void a(T paramT, l.d.b.g.c paramc, boolean paramBoolean)
  {
    a(paramc, paramT);
    int i = a.A.length + 1;
    Object localObject = a(paramT);
    if ((localObject instanceof Long))
    {
      paramc.bindLong(i, ((Long)localObject).longValue());
    }
    else
    {
      if (localObject == null) {
        break label85;
      }
      paramc.bindString(i, localObject.toString());
    }
    paramc.execute();
    a(localObject, paramT, paramBoolean);
    return;
    label85:
    throw new d("Cannot update entity without key - was it inserted before?");
  }
  
  /* Error */
  public final void a(l.d.b.g.c paramc, Iterable<T> paramIterable, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   4: invokeinterface 250 1 0
    //   9: aload_1
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   15: ifnull +12 -> 27
    //   18: aload_0
    //   19: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   22: invokeinterface 200 1 0
    //   27: aload_0
    //   28: getfield 44	l/d/b/a:c	Z
    //   31: ifeq +73 -> 104
    //   34: aload_1
    //   35: invokeinterface 73 1 0
    //   40: checkcast 75	android/database/sqlite/SQLiteStatement
    //   43: astore 4
    //   45: aload_2
    //   46: invokeinterface 256 1 0
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 261 1 0
    //   60: ifeq +104 -> 164
    //   63: aload 5
    //   65: invokeinterface 264 1 0
    //   70: astore_2
    //   71: aload_0
    //   72: aload 4
    //   74: aload_2
    //   75: invokevirtual 78	l/d/b/a:a	(Landroid/database/sqlite/SQLiteStatement;Ljava/lang/Object;)V
    //   78: iload_3
    //   79: ifeq +17 -> 96
    //   82: aload_0
    //   83: aload_2
    //   84: aload 4
    //   86: invokevirtual 82	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   89: iconst_0
    //   90: invokevirtual 341	l/d/b/a:a	(Ljava/lang/Object;JZ)V
    //   93: goto -40 -> 53
    //   96: aload 4
    //   98: invokevirtual 320	android/database/sqlite/SQLiteStatement:execute	()V
    //   101: goto -48 -> 53
    //   104: aload_2
    //   105: invokeinterface 256 1 0
    //   110: astore 4
    //   112: aload 4
    //   114: invokeinterface 261 1 0
    //   119: ifeq +45 -> 164
    //   122: aload 4
    //   124: invokeinterface 264 1 0
    //   129: astore_2
    //   130: aload_0
    //   131: aload_1
    //   132: aload_2
    //   133: invokevirtual 85	l/d/b/a:a	(Ll/d/b/g/c;Ljava/lang/Object;)V
    //   136: iload_3
    //   137: ifeq +18 -> 155
    //   140: aload_0
    //   141: aload_2
    //   142: aload_1
    //   143: invokeinterface 86 1 0
    //   148: iconst_0
    //   149: invokevirtual 341	l/d/b/a:a	(Ljava/lang/Object;JZ)V
    //   152: goto -40 -> 112
    //   155: aload_1
    //   156: invokeinterface 337 1 0
    //   161: goto -49 -> 112
    //   164: aload_0
    //   165: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   168: ifnull +12 -> 180
    //   171: aload_0
    //   172: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   175: invokeinterface 216 1 0
    //   180: aload_1
    //   181: monitorexit
    //   182: aload_0
    //   183: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   186: invokeinterface 273 1 0
    //   191: aload_0
    //   192: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   195: invokeinterface 276 1 0
    //   200: return
    //   201: astore_2
    //   202: aload_0
    //   203: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   206: ifnull +12 -> 218
    //   209: aload_0
    //   210: getfield 49	l/d/b/a:d	Ll/d/b/h/a;
    //   213: invokeinterface 216 1 0
    //   218: aload_2
    //   219: athrow
    //   220: astore_2
    //   221: aload_1
    //   222: monitorexit
    //   223: aload_2
    //   224: athrow
    //   225: astore_1
    //   226: aload_0
    //   227: getfield 35	l/d/b/a:b	Ll/d/b/g/a;
    //   230: invokeinterface 276 1 0
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	a
    //   0	237	1	paramc	l.d.b.g.c
    //   0	237	2	paramIterable	Iterable<T>
    //   0	237	3	paramBoolean	boolean
    //   43	80	4	localObject	Object
    //   51	13	5	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   27	53	201	finally
    //   53	78	201	finally
    //   82	93	201	finally
    //   96	101	201	finally
    //   104	112	201	finally
    //   112	136	201	finally
    //   140	152	201	finally
    //   155	161	201	finally
    //   11	27	220	finally
    //   164	180	220	finally
    //   180	182	220	finally
    //   202	218	220	finally
    //   218	220	220	finally
    //   221	223	220	finally
    //   9	11	225	finally
    //   182	191	225	finally
    //   223	225	225	finally
  }
  
  public abstract void a(l.d.b.g.c paramc, T paramT);
  
  public long b(T paramT)
  {
    l.d.b.g.c localc = f.b();
    long l;
    if (b.a()) {
      l = a(paramT, localc);
    } else {
      b.beginTransaction();
    }
    try
    {
      l = a(paramT, localc);
      b.setTransactionSuccessful();
      b.endTransaction();
      a(paramT, l, true);
      return l;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public abstract K b(Cursor paramCursor, int paramInt);
  
  public List<T> b()
  {
    Object localObject1 = b;
    Object localObject2 = f;
    if (h == null) {
      h = l.d.b.i.d.a(b, "T", c, false);
    }
    localObject1 = ((l.d.b.g.a)localObject1).a(h, null);
    try
    {
      localObject2 = a((Cursor)localObject1);
      return (List<T>)localObject2;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */