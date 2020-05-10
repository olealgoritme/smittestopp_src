package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractCursor;
import net.sqlcipher.AbstractWindowedCursor;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  public static final int NO_COUNT = -1;
  public static final String TAG = "Cursor";
  public boolean fillWindowForwardOnly;
  public Map<String, Integer> mColumnNameMap;
  public String[] mColumns;
  public int mCount = -1;
  public int mCursorState;
  public int mCursorWindowCapacity;
  public SQLiteDatabase mDatabase;
  public SQLiteCursorDriver mDriver;
  public String mEditTable;
  public int mInitialRead;
  public ReentrantLock mLock;
  public int mMaxRead;
  public MainThreadNotificationHandler mNotificationHandler;
  public boolean mPendingData;
  public SQLiteQuery mQuery;
  public Throwable mStackTrace;
  
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    int i = 0;
    mCursorWindowCapacity = 0;
    fillWindowForwardOnly = false;
    mMaxRead = Integer.MAX_VALUE;
    mInitialRead = Integer.MAX_VALUE;
    mCursorState = 0;
    mLock = null;
    mPendingData = false;
    mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    mDatabase = paramSQLiteDatabase;
    mDriver = paramSQLiteCursorDriver;
    mEditTable = paramString;
    mColumnNameMap = null;
    mQuery = paramSQLiteQuery;
    try
    {
      paramSQLiteDatabase.lock();
      int j = mQuery.columnCountLocked();
      mColumns = new String[j];
      while (i < j)
      {
        paramSQLiteCursorDriver = mQuery.columnNameLocked(i);
        mColumns[i] = paramSQLiteCursorDriver;
        if ("_id".equals(paramSQLiteCursorDriver)) {
          mRowIdColumnIndex = i;
        }
        i++;
      }
      return;
    }
    finally
    {
      paramSQLiteDatabase.unlock();
    }
  }
  
  private void deactivateCommon()
  {
    mCursorState = 0;
    net.sqlcipher.CursorWindow localCursorWindow = mWindow;
    if (localCursorWindow != null)
    {
      localCursorWindow.close();
      mWindow = null;
    }
  }
  
  private void fillWindow(int paramInt)
  {
    if (mWindow == null)
    {
      mWindow = new net.sqlcipher.CursorWindow(true);
    }
    else
    {
      mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      mWindow.clear();
      queryThreadUnlock();
      int i;
      if (fillWindowForwardOnly) {
        i = paramInt;
      } else if (mCount == -1) {
        i = cursorPickFillWindowStartPosition(paramInt, 0);
      } else {
        i = cursorPickFillWindowStartPosition(paramInt, mCursorWindowCapacity);
      }
      mWindow.setStartPosition(i);
      mWindow.setRequiredPosition(paramInt);
      mCount = mQuery.fillWindow(mWindow, mInitialRead, 0);
      if (mCursorWindowCapacity == 0) {
        mCursorWindowCapacity = mWindow.getNumRows();
      }
      if (mCount == -1)
      {
        mCount = (i + mInitialRead);
        new Thread(new QueryThread(mCursorState), "query thread").start();
      }
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  private void queryThreadLock()
  {
    ReentrantLock localReentrantLock = mLock;
    if (localReentrantLock != null) {
      localReentrantLock.lock();
    }
  }
  
  private void queryThreadUnlock()
  {
    ReentrantLock localReentrantLock = mLock;
    if (localReentrantLock != null) {
      localReentrantLock.unlock();
    }
  }
  
  public void close()
  {
    super.close();
    deactivateCommon();
    mQuery.close();
    mDriver.cursorClosed();
  }
  
  /* Error */
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 215	net/sqlcipher/database/SQLiteCursor:supportsUpdates	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 219	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_1
    //   17: ifnull +11 -> 28
    //   20: aload_0
    //   21: getfield 219	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   24: aload_1
    //   25: invokevirtual 225	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   28: aload_0
    //   29: getfield 219	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   32: invokevirtual 228	java/util/HashMap:size	()I
    //   35: ifne +7 -> 42
    //   38: aload_2
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   46: invokevirtual 231	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   49: new 233	java/lang/StringBuilder
    //   52: astore_3
    //   53: aload_3
    //   54: sipush 128
    //   57: invokespecial 235	java/lang/StringBuilder:<init>	(I)V
    //   60: aload_0
    //   61: getfield 219	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   64: invokevirtual 239	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   67: invokeinterface 245 1 0
    //   72: astore_1
    //   73: aload_1
    //   74: invokeinterface 250 1 0
    //   79: ifeq +379 -> 458
    //   82: aload_1
    //   83: invokeinterface 254 1 0
    //   88: checkcast 256	java/util/Map$Entry
    //   91: astore 4
    //   93: aload 4
    //   95: invokeinterface 259 1 0
    //   100: checkcast 261	java/util/Map
    //   103: astore 5
    //   105: aload 4
    //   107: invokeinterface 264 1 0
    //   112: checkcast 266	java/lang/Long
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +287 -> 406
    //   122: aload 5
    //   124: ifnull +282 -> 406
    //   127: aload 5
    //   129: invokeinterface 267 1 0
    //   134: ifne +6 -> 140
    //   137: goto -64 -> 73
    //   140: aload 4
    //   142: invokevirtual 271	java/lang/Long:longValue	()J
    //   145: lstore 6
    //   147: aload 5
    //   149: invokeinterface 272 1 0
    //   154: invokeinterface 245 1 0
    //   159: astore 4
    //   161: aload_3
    //   162: iconst_0
    //   163: invokevirtual 275	java/lang/StringBuilder:setLength	(I)V
    //   166: new 233	java/lang/StringBuilder
    //   169: astore 8
    //   171: aload 8
    //   173: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   176: aload 8
    //   178: ldc_w 278
    //   181: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 8
    //   187: aload_0
    //   188: getfield 82	net/sqlcipher/database/SQLiteCursor:mEditTable	Ljava/lang/String;
    //   191: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 8
    //   197: ldc_w 284
    //   200: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_3
    //   205: aload 8
    //   207: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 5
    //   216: invokeinterface 267 1 0
    //   221: anewarray 290	java/lang/Object
    //   224: astore 5
    //   226: iconst_0
    //   227: istore 9
    //   229: aload 4
    //   231: invokeinterface 250 1 0
    //   236: ifeq +74 -> 310
    //   239: aload 4
    //   241: invokeinterface 254 1 0
    //   246: checkcast 256	java/util/Map$Entry
    //   249: astore 8
    //   251: aload_3
    //   252: aload 8
    //   254: invokeinterface 264 1 0
    //   259: checkcast 99	java/lang/String
    //   262: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_3
    //   267: ldc_w 292
    //   270: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 5
    //   276: iload 9
    //   278: aload 8
    //   280: invokeinterface 259 1 0
    //   285: aastore
    //   286: aload 4
    //   288: invokeinterface 250 1 0
    //   293: ifeq +11 -> 304
    //   296: aload_3
    //   297: ldc_w 294
    //   300: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: iinc 9 1
    //   307: goto -78 -> 229
    //   310: new 233	java/lang/StringBuilder
    //   313: astore 4
    //   315: aload 4
    //   317: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   320: aload 4
    //   322: ldc_w 296
    //   325: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 4
    //   331: aload_0
    //   332: getfield 101	net/sqlcipher/database/SQLiteCursor:mColumns	[Ljava/lang/String;
    //   335: aload_0
    //   336: getfield 116	net/sqlcipher/AbstractCursor:mRowIdColumnIndex	I
    //   339: aaload
    //   340: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 4
    //   346: bipush 61
    //   348: invokevirtual 299	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 4
    //   354: lload 6
    //   356: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_3
    //   361: aload 4
    //   363: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_3
    //   371: bipush 59
    //   373: invokevirtual 299	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_0
    //   378: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   381: aload_3
    //   382: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aload 5
    //   387: invokevirtual 306	net/sqlcipher/database/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: aload_0
    //   391: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   394: aload_0
    //   395: getfield 82	net/sqlcipher/database/SQLiteCursor:mEditTable	Ljava/lang/String;
    //   398: lload 6
    //   400: invokevirtual 310	net/sqlcipher/database/SQLiteDatabase:rowUpdated	(Ljava/lang/String;J)V
    //   403: goto -330 -> 73
    //   406: new 312	java/lang/IllegalStateException
    //   409: astore_3
    //   410: new 233	java/lang/StringBuilder
    //   413: astore_1
    //   414: aload_1
    //   415: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   418: aload_1
    //   419: ldc_w 314
    //   422: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_1
    //   427: aload 4
    //   429: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 319
    //   437: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload_1
    //   442: aload 5
    //   444: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_3
    //   449: aload_1
    //   450: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokespecial 322	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   456: aload_3
    //   457: athrow
    //   458: aload_0
    //   459: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   462: invokevirtual 325	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   465: aload_0
    //   466: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   469: invokevirtual 328	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   472: aload_0
    //   473: getfield 219	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   476: invokevirtual 329	java/util/HashMap:clear	()V
    //   479: aload_2
    //   480: monitorexit
    //   481: aload_0
    //   482: iconst_1
    //   483: invokevirtual 332	net/sqlcipher/AbstractCursor:onChange	(Z)V
    //   486: iconst_1
    //   487: ireturn
    //   488: astore_1
    //   489: aload_0
    //   490: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   493: invokevirtual 328	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   496: aload_1
    //   497: athrow
    //   498: astore_1
    //   499: aload_2
    //   500: monitorexit
    //   501: aload_1
    //   502: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	SQLiteCursor
    //   0	503	1	paramMap	Map<? extends Long, ? extends Map<String, Object>>
    //   13	487	2	localHashMap	HashMap
    //   52	405	3	localObject1	Object
    //   91	337	4	localObject2	Object
    //   103	340	5	localObject3	Object
    //   145	254	6	l	long
    //   169	110	8	localObject4	Object
    //   227	78	9	i	int
    // Exception table:
    //   from	to	target	type
    //   49	73	488	finally
    //   73	117	488	finally
    //   127	137	488	finally
    //   140	226	488	finally
    //   229	304	488	finally
    //   310	403	488	finally
    //   406	458	488	finally
    //   458	465	488	finally
    //   20	28	498	finally
    //   28	40	498	finally
    //   42	49	498	finally
    //   465	481	498	finally
    //   489	498	498	finally
    //   499	501	498	finally
  }
  
  public int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public void deactivate()
  {
    super.deactivate();
    deactivateCommon();
    mDriver.cursorDeactivated();
  }
  
  /* Error */
  public boolean deleteRow()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 351	net/sqlcipher/AbstractWindowedCursor:checkPosition	()V
    //   4: aload_0
    //   5: getfield 116	net/sqlcipher/AbstractCursor:mRowIdColumnIndex	I
    //   8: iconst_m1
    //   9: if_icmpeq +146 -> 155
    //   12: aload_0
    //   13: getfield 355	net/sqlcipher/AbstractCursor:mCurrentRowID	Ljava/lang/Long;
    //   16: ifnonnull +6 -> 22
    //   19: goto +136 -> 155
    //   22: aload_0
    //   23: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   26: invokevirtual 91	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   29: aload_0
    //   30: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   33: astore_1
    //   34: aload_0
    //   35: getfield 82	net/sqlcipher/database/SQLiteCursor:mEditTable	Ljava/lang/String;
    //   38: astore_2
    //   39: new 233	java/lang/StringBuilder
    //   42: astore_3
    //   43: aload_3
    //   44: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   47: aload_3
    //   48: aload_0
    //   49: getfield 101	net/sqlcipher/database/SQLiteCursor:mColumns	[Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 116	net/sqlcipher/AbstractCursor:mRowIdColumnIndex	I
    //   56: aaload
    //   57: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: ldc_w 292
    //   65: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: iconst_1
    //   76: anewarray 99	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 355	net/sqlcipher/AbstractCursor:mCurrentRowID	Ljava/lang/Long;
    //   85: invokevirtual 356	java/lang/Long:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: invokevirtual 360	net/sqlcipher/database/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   92: pop
    //   93: iconst_1
    //   94: istore 4
    //   96: goto +11 -> 107
    //   99: astore_2
    //   100: goto +46 -> 146
    //   103: astore_2
    //   104: iconst_0
    //   105: istore 4
    //   107: aload_0
    //   108: getfield 363	net/sqlcipher/AbstractCursor:mPos	I
    //   111: istore 5
    //   113: aload_0
    //   114: invokevirtual 366	net/sqlcipher/database/SQLiteCursor:requery	()Z
    //   117: pop
    //   118: aload_0
    //   119: iload 5
    //   121: invokevirtual 370	net/sqlcipher/AbstractCursor:moveToPosition	(I)Z
    //   124: pop
    //   125: aload_0
    //   126: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   129: invokevirtual 119	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   132: iload 4
    //   134: ifeq +10 -> 144
    //   137: aload_0
    //   138: iconst_1
    //   139: invokevirtual 332	net/sqlcipher/AbstractCursor:onChange	(Z)V
    //   142: iconst_1
    //   143: ireturn
    //   144: iconst_0
    //   145: ireturn
    //   146: aload_0
    //   147: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   150: invokevirtual 119	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   153: aload_2
    //   154: athrow
    //   155: iconst_0
    //   156: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	SQLiteCursor
    //   33	37	1	localSQLiteDatabase	SQLiteDatabase
    //   38	33	2	str	String
    //   99	1	2	localObject	Object
    //   103	51	2	localSQLException	net.sqlcipher.SQLException
    //   42	30	3	localStringBuilder	StringBuilder
    //   94	39	4	i	int
    //   111	9	5	j	int
    // Exception table:
    //   from	to	target	type
    //   29	93	99	finally
    //   107	125	99	finally
    //   29	93	103	net/sqlcipher/SQLException
  }
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    if (mWindow == null)
    {
      mWindow = new net.sqlcipher.CursorWindow(true);
    }
    else
    {
      mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      mWindow.clear();
      queryThreadUnlock();
      int i;
      if (fillWindowForwardOnly) {
        i = paramInt;
      } else if (mCount == -1) {
        i = cursorPickFillWindowStartPosition(paramInt, 0);
      } else {
        i = cursorPickFillWindowStartPosition(paramInt, mCursorWindowCapacity);
      }
      mWindow.setStartPosition(i);
      mWindow.setRequiredPosition(paramInt);
      mCount = mQuery.fillWindow(mWindow, mInitialRead, 0);
      if (mCursorWindowCapacity == 0) {
        mCursorWindowCapacity = mWindow.getNumRows();
      }
      if (mCount == -1)
      {
        mCount = (i + mInitialRead);
        new Thread(new QueryThread(mCursorState), "query thread").start();
      }
      return;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  public void finalize()
  {
    try
    {
      if (mWindow != null)
      {
        mQuery.mSql.length();
        close();
        SQLiteDebug.notifyActiveCursorFinalized();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    if (mColumnNameMap == null)
    {
      String[] arrayOfString = mColumns;
      int i = arrayOfString.length;
      HashMap localHashMap = new HashMap(i, 1.0F);
      for (int j = 0; j < i; j++) {
        localHashMap.put(arrayOfString[j], Integer.valueOf(j));
      }
      mColumnNameMap = localHashMap;
    }
    if (paramString.lastIndexOf('.') != -1) {
      new Exception();
    }
    paramString = (Integer)mColumnNameMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public String[] getColumnNames()
  {
    return mColumns;
  }
  
  public int getCount()
  {
    if (mCount == -1) {
      fillWindow(0);
    }
    return mCount;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return mDatabase;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    net.sqlcipher.CursorWindow localCursorWindow = mWindow;
    if ((localCursorWindow != null) && (paramInt2 >= localCursorWindow.getStartPosition()))
    {
      paramInt1 = mWindow.getStartPosition();
      if (paramInt2 < mWindow.getNumRows() + paramInt1) {}
    }
    else
    {
      fillWindow(paramInt2);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerDataSetObserver(paramDataSetObserver);
    if (((Integer.MAX_VALUE != mMaxRead) || (Integer.MAX_VALUE != mInitialRead)) && (mNotificationHandler == null))
    {
      queryThreadLock();
      try
      {
        paramDataSetObserver = new net/sqlcipher/database/SQLiteCursor$MainThreadNotificationHandler;
        paramDataSetObserver.<init>(this);
        mNotificationHandler = paramDataSetObserver;
        if (mPendingData)
        {
          notifyDataSetChange();
          mPendingData = false;
        }
        queryThreadUnlock();
      }
      finally
      {
        queryThreadUnlock();
      }
    }
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 438	net/sqlcipher/AbstractCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 91	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   16: aload_0
    //   17: getfield 128	net/sqlcipher/AbstractWindowedCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   20: ifnull +10 -> 30
    //   23: aload_0
    //   24: getfield 128	net/sqlcipher/AbstractWindowedCursor:mWindow	Lnet/sqlcipher/CursorWindow;
    //   27: invokevirtual 162	net/sqlcipher/CursorWindow:clear	()V
    //   30: aload_0
    //   31: iconst_m1
    //   32: putfield 363	net/sqlcipher/AbstractCursor:mPos	I
    //   35: aload_0
    //   36: getfield 80	net/sqlcipher/database/SQLiteCursor:mDriver	Lnet/sqlcipher/database/SQLiteCursorDriver;
    //   39: aload_0
    //   40: invokeinterface 442 2 0
    //   45: aload_0
    //   46: iconst_m1
    //   47: putfield 50	net/sqlcipher/database/SQLiteCursor:mCount	I
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 61	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   55: iconst_1
    //   56: iadd
    //   57: putfield 61	net/sqlcipher/database/SQLiteCursor:mCursorState	I
    //   60: aload_0
    //   61: invokespecial 159	net/sqlcipher/database/SQLiteCursor:queryThreadLock	()V
    //   64: aload_0
    //   65: getfield 86	net/sqlcipher/database/SQLiteCursor:mQuery	Lnet/sqlcipher/database/SQLiteQuery;
    //   68: invokevirtual 444	net/sqlcipher/database/SQLiteQuery:requery	()V
    //   71: aload_0
    //   72: invokespecial 165	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   75: aload_0
    //   76: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   79: invokevirtual 119	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   82: aload_0
    //   83: invokespecial 445	net/sqlcipher/AbstractCursor:requery	()Z
    //   86: ireturn
    //   87: astore_1
    //   88: aload_0
    //   89: invokespecial 165	net/sqlcipher/database/SQLiteCursor:queryThreadUnlock	()V
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 78	net/sqlcipher/database/SQLiteCursor:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   99: invokevirtual 119	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	SQLiteCursor
    //   87	6	1	localObject1	Object
    //   94	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   64	71	87	finally
    //   16	30	94	finally
    //   30	64	94	finally
    //   71	75	94	finally
    //   88	94	94	finally
  }
  
  public void setFillWindowForwardOnly(boolean paramBoolean)
  {
    fillWindowForwardOnly = paramBoolean;
  }
  
  public void setLoadStyle(int paramInt1, int paramInt2)
  {
    mMaxRead = paramInt2;
    mInitialRead = paramInt1;
    mLock = new ReentrantLock(true);
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    mDriver.setBindArguments(paramArrayOfString);
  }
  
  public void setWindow(net.sqlcipher.CursorWindow paramCursorWindow)
  {
    if (mWindow != null)
    {
      mCursorState += 1;
      queryThreadLock();
    }
    try
    {
      mWindow.close();
      queryThreadUnlock();
      mCount = -1;
    }
    finally
    {
      queryThreadUnlock();
    }
  }
  
  public boolean supportsUpdates()
  {
    return TextUtils.isEmpty(mEditTable) ^ true;
  }
  
  public static class MainThreadNotificationHandler
    extends Handler
  {
    public final WeakReference<SQLiteCursor> wrappedCursor;
    
    public MainThreadNotificationHandler(SQLiteCursor paramSQLiteCursor)
    {
      wrappedCursor = new WeakReference(paramSQLiteCursor);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (SQLiteCursor)wrappedCursor.get();
      if (paramMessage != null) {
        SQLiteCursor.access$700(paramMessage);
      }
    }
  }
  
  public final class QueryThread
    implements Runnable
  {
    public final int mThreadState;
    
    public QueryThread(int paramInt)
    {
      mThreadState = paramInt;
    }
    
    private void sendMessage()
    {
      SQLiteCursor localSQLiteCursor = SQLiteCursor.this;
      SQLiteCursor.MainThreadNotificationHandler localMainThreadNotificationHandler = mNotificationHandler;
      if (localMainThreadNotificationHandler != null)
      {
        localMainThreadNotificationHandler.sendEmptyMessage(1);
        SQLiteCursor.access$002(SQLiteCursor.this, false);
      }
      else
      {
        SQLiteCursor.access$002(localSQLiteCursor, true);
      }
    }
    
    public void run()
    {
      net.sqlcipher.CursorWindow localCursorWindow = SQLiteCursor.access$100(SQLiteCursor.this);
      Process.setThreadPriority(Process.myTid(), 10);
      for (;;)
      {
        if (SQLiteCursor.access$200(SQLiteCursor.this) == null) {
          SQLiteCursor.access$202(SQLiteCursor.this, new ReentrantLock(true));
        }
        SQLiteCursor.access$200(SQLiteCursor.this).lock();
        if (SQLiteCursor.access$300(SQLiteCursor.this) != mThreadState)
        {
          SQLiteCursor.access$200(SQLiteCursor.this).unlock();
          break label193;
        }
        try
        {
          try
          {
            int i = SQLiteCursor.access$600(SQLiteCursor.this).fillWindow(localCursorWindow, SQLiteCursor.access$400(SQLiteCursor.this), SQLiteCursor.access$500(SQLiteCursor.this));
            if (i != 0)
            {
              if (i == -1)
              {
                SQLiteCursor.access$502(SQLiteCursor.this, SQLiteCursor.access$500(SQLiteCursor.this) + SQLiteCursor.access$400(SQLiteCursor.this));
                sendMessage();
                SQLiteCursor.access$200(SQLiteCursor.this).unlock();
                continue;
              }
              SQLiteCursor.access$502(SQLiteCursor.this, i);
              sendMessage();
            }
          }
          finally
          {
            SQLiteCursor.access$200(SQLiteCursor.this).unlock();
          }
        }
        catch (Exception localException)
        {
          label193:
          for (;;) {}
        }
      }
      SQLiteCursor.access$200(SQLiteCursor.this).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */