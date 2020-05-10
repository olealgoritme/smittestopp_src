package d.u;

import android.database.Cursor;
import d.w.a.a;
import d.w.a.f.f;
import java.util.HashSet;
import java.util.Set;

public class e$a
  implements Runnable
{
  public e$a(e parame) {}
  
  public final Set<Integer> a()
  {
    HashSet localHashSet = new HashSet();
    Cursor localCursor = x.d.a(new a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null);
    try
    {
      while (localCursor.moveToNext()) {
        localHashSet.add(Integer.valueOf(localCursor.getInt(0)));
      }
      localCursor.close();
      if (!localHashSet.isEmpty()) {
        x.g.a();
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
    //   7: getfield 85	d/u/g:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 91	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: astore_1
    //   14: aload_1
    //   15: invokeinterface 96 1 0
    //   20: aload_0
    //   21: getfield 14	d/u/e$a:x	Ld/u/e;
    //   24: invokevirtual 98	d/u/e:a	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifne +10 -> 39
    //   32: aload_1
    //   33: invokeinterface 101 1 0
    //   38: return
    //   39: aload_0
    //   40: getfield 14	d/u/e$a:x	Ld/u/e;
    //   43: getfield 105	d/u/e:e	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   46: iconst_1
    //   47: iconst_0
    //   48: invokevirtual 111	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifne +10 -> 63
    //   56: aload_1
    //   57: invokeinterface 101 1 0
    //   62: return
    //   63: aload_0
    //   64: getfield 14	d/u/e$a:x	Ld/u/e;
    //   67: getfield 27	d/u/e:d	Ld/u/g;
    //   70: invokevirtual 113	d/u/g:e	()Z
    //   73: istore_2
    //   74: iload_2
    //   75: ifeq +10 -> 85
    //   78: aload_1
    //   79: invokeinterface 101 1 0
    //   84: return
    //   85: aload_0
    //   86: getfield 14	d/u/e$a:x	Ld/u/e;
    //   89: getfield 27	d/u/e:d	Ld/u/g;
    //   92: getfield 117	d/u/g:f	Z
    //   95: ifeq +123 -> 218
    //   98: aload_0
    //   99: getfield 14	d/u/e$a:x	Ld/u/e;
    //   102: getfield 27	d/u/e:d	Ld/u/g;
    //   105: getfield 121	d/u/g:c	Ld/w/a/c;
    //   108: invokeinterface 126 1 0
    //   113: astore_3
    //   114: aload_3
    //   115: checkcast 128	d/w/a/f/a
    //   118: getfield 131	d/w/a/f/a:x	Landroid/database/sqlite/SQLiteDatabase;
    //   121: invokevirtual 136	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   124: aload_0
    //   125: invokevirtual 138	d/u/e$a:a	()Ljava/util/Set;
    //   128: astore 4
    //   130: aload_3
    //   131: checkcast 128	d/w/a/f/a
    //   134: getfield 131	d/w/a/f/a:x	Landroid/database/sqlite/SQLiteDatabase;
    //   137: invokevirtual 141	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   140: aload 4
    //   142: astore 5
    //   144: aload 4
    //   146: astore 6
    //   148: aload_3
    //   149: checkcast 128	d/w/a/f/a
    //   152: getfield 131	d/w/a/f/a:x	Landroid/database/sqlite/SQLiteDatabase;
    //   155: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: goto +94 -> 252
    //   161: astore 7
    //   163: goto +8 -> 171
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 4
    //   171: aload 4
    //   173: astore 5
    //   175: aload 4
    //   177: astore 6
    //   179: aload_3
    //   180: checkcast 128	d/w/a/f/a
    //   183: getfield 131	d/w/a/f/a:x	Landroid/database/sqlite/SQLiteDatabase;
    //   186: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   189: aload 4
    //   191: astore 5
    //   193: aload 4
    //   195: astore 6
    //   197: aload 7
    //   199: athrow
    //   200: astore 7
    //   202: aload 5
    //   204: astore 4
    //   206: goto +36 -> 242
    //   209: astore 7
    //   211: aload 6
    //   213: astore 4
    //   215: goto +27 -> 242
    //   218: aload_0
    //   219: invokevirtual 138	d/u/e$a:a	()Ljava/util/Set;
    //   222: astore 4
    //   224: goto +28 -> 252
    //   227: astore 4
    //   229: goto +235 -> 464
    //   232: astore 7
    //   234: goto +5 -> 239
    //   237: astore 7
    //   239: aconst_null
    //   240: astore 4
    //   242: ldc -110
    //   244: ldc -108
    //   246: aload 7
    //   248: invokestatic 153	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   251: pop
    //   252: aload_1
    //   253: invokeinterface 101 1 0
    //   258: aload 4
    //   260: ifnull +203 -> 463
    //   263: aload 4
    //   265: invokeinterface 156 1 0
    //   270: ifne +193 -> 463
    //   273: aload_0
    //   274: getfield 14	d/u/e$a:x	Ld/u/e;
    //   277: getfield 160	d/u/e:i	Ld/c/a/b/b;
    //   280: astore 7
    //   282: aload 7
    //   284: monitorenter
    //   285: aload_0
    //   286: getfield 14	d/u/e$a:x	Ld/u/e;
    //   289: getfield 160	d/u/e:i	Ld/c/a/b/b;
    //   292: invokevirtual 166	d/c/a/b/b:iterator	()Ljava/util/Iterator;
    //   295: astore_1
    //   296: aload_1
    //   297: checkcast 168	d/c/a/b/b$e
    //   300: astore 5
    //   302: aload 5
    //   304: invokevirtual 171	d/c/a/b/b$e:hasNext	()Z
    //   307: ifeq +142 -> 449
    //   310: aload 5
    //   312: invokevirtual 175	d/c/a/b/b$e:next	()Ljava/lang/Object;
    //   315: checkcast 177	java/util/Map$Entry
    //   318: invokeinterface 180 1 0
    //   323: checkcast 182	d/u/e$d
    //   326: astore_3
    //   327: aload_3
    //   328: getfield 185	d/u/e$d:a	[I
    //   331: arraylength
    //   332: istore 8
    //   334: aconst_null
    //   335: astore 5
    //   337: iconst_0
    //   338: istore 9
    //   340: iload 9
    //   342: iload 8
    //   344: if_icmpge +88 -> 432
    //   347: aload 5
    //   349: astore 6
    //   351: aload 4
    //   353: aload_3
    //   354: getfield 185	d/u/e$d:a	[I
    //   357: iload 9
    //   359: iaload
    //   360: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: invokeinterface 188 2 0
    //   368: ifeq +54 -> 422
    //   371: iload 8
    //   373: iconst_1
    //   374: if_icmpne +12 -> 386
    //   377: aload_3
    //   378: getfield 191	d/u/e$d:d	Ljava/util/Set;
    //   381: astore 6
    //   383: goto +39 -> 422
    //   386: aload 5
    //   388: astore 6
    //   390: aload 5
    //   392: ifnonnull +15 -> 407
    //   395: new 22	java/util/HashSet
    //   398: astore 6
    //   400: aload 6
    //   402: iload 8
    //   404: invokespecial 194	java/util/HashSet:<init>	(I)V
    //   407: aload 6
    //   409: aload_3
    //   410: getfield 198	d/u/e$d:b	[Ljava/lang/String;
    //   413: iload 9
    //   415: aaload
    //   416: invokeinterface 199 2 0
    //   421: pop
    //   422: iinc 9 1
    //   425: aload 6
    //   427: astore 5
    //   429: goto -89 -> 340
    //   432: aload 5
    //   434: ifnull -138 -> 296
    //   437: aload_3
    //   438: getfield 202	d/u/e$d:c	Ld/u/e$c;
    //   441: aload 5
    //   443: invokevirtual 207	d/u/e$c:a	(Ljava/util/Set;)V
    //   446: goto -150 -> 296
    //   449: aload 7
    //   451: monitorexit
    //   452: goto +11 -> 463
    //   455: astore 4
    //   457: aload 7
    //   459: monitorexit
    //   460: aload 4
    //   462: athrow
    //   463: return
    //   464: aload_1
    //   465: invokeinterface 101 1 0
    //   470: aload 4
    //   472: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	a
    //   13	452	1	localObject1	Object
    //   27	48	2	bool	boolean
    //   113	325	3	localObject2	Object
    //   128	95	4	localObject3	Object
    //   227	1	4	localObject4	Object
    //   240	112	4	localObject5	Object
    //   455	16	4	localObject6	Object
    //   142	300	5	localObject7	Object
    //   146	280	6	localObject8	Object
    //   161	1	7	localObject9	Object
    //   166	32	7	localObject10	Object
    //   200	1	7	localSQLiteException1	android.database.sqlite.SQLiteException
    //   209	1	7	localIllegalStateException1	IllegalStateException
    //   232	1	7	localSQLiteException2	android.database.sqlite.SQLiteException
    //   237	10	7	localIllegalStateException2	IllegalStateException
    //   280	178	7	localb	d.c.a.b.b
    //   332	71	8	i	int
    //   338	85	9	j	int
    // Exception table:
    //   from	to	target	type
    //   130	140	161	finally
    //   124	130	166	finally
    //   148	158	200	android/database/sqlite/SQLiteException
    //   179	189	200	android/database/sqlite/SQLiteException
    //   197	200	200	android/database/sqlite/SQLiteException
    //   148	158	209	java/lang/IllegalStateException
    //   179	189	209	java/lang/IllegalStateException
    //   197	200	209	java/lang/IllegalStateException
    //   14	28	227	finally
    //   39	52	227	finally
    //   63	74	227	finally
    //   85	124	227	finally
    //   148	158	227	finally
    //   179	189	227	finally
    //   197	200	227	finally
    //   218	224	227	finally
    //   242	252	227	finally
    //   14	28	232	android/database/sqlite/SQLiteException
    //   39	52	232	android/database/sqlite/SQLiteException
    //   63	74	232	android/database/sqlite/SQLiteException
    //   85	124	232	android/database/sqlite/SQLiteException
    //   218	224	232	android/database/sqlite/SQLiteException
    //   14	28	237	java/lang/IllegalStateException
    //   39	52	237	java/lang/IllegalStateException
    //   63	74	237	java/lang/IllegalStateException
    //   85	124	237	java/lang/IllegalStateException
    //   218	224	237	java/lang/IllegalStateException
    //   285	296	455	finally
    //   302	334	455	finally
    //   351	371	455	finally
    //   377	383	455	finally
    //   395	407	455	finally
    //   407	422	455	finally
    //   437	446	455	finally
    //   449	452	455	finally
    //   457	460	455	finally
  }
}

/* Location:
 * Qualified Name:     base.d.u.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */