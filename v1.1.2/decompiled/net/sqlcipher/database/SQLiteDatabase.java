package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import d.w.a.b;
import d.w.a.e;
import e.a.a.a.a;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;

public class SQLiteDatabase
  extends SQLiteClosable
  implements b
{
  public static final String COMMIT_SQL = "COMMIT;";
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  public static final String[] CONFLICT_VALUES = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  public static final int CREATE_IF_NECESSARY = 268435456;
  public static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
  public static final int EVENT_DB_CORRUPT = 75004;
  public static final int EVENT_DB_OPERATION = 52000;
  public static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
  public static final String KEY_ENCODING = "UTF-8";
  public static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
  public static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
  public static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
  public static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
  public static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
  public static final int MAX_SQL_CACHE_SIZE = 250;
  public static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
  public static final String MEMORY = ":memory:";
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  public static final int OPEN_READ_MASK = 1;
  public static final int QUERY_LOG_SQL_LENGTH = 64;
  public static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
  public static final String SQLCIPHER_ANDROID_VERSION = "4.3.0";
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  public static final String TAG = "Database";
  public static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
  public static int sQueryLogTimeInMillis = 0;
  public int mCacheFullWarnings;
  public Map<String, SQLiteCompiledSql> mCompiledQueries = new HashMap();
  public final DatabaseErrorHandler mErrorHandler;
  public CursorFactory mFactory;
  public int mFlags;
  public boolean mInnerTransactionIsSuccessful;
  public long mLastLockMessageTime = 0L;
  public String mLastSqlStatement = null;
  public final ReentrantLock mLock = new ReentrantLock(true);
  public long mLockAcquiredThreadTime = 0L;
  public long mLockAcquiredWallTime = 0L;
  public boolean mLockingEnabled = true;
  public int mMaxSqlCacheSize = 250;
  public long mNativeHandle = 0L;
  public int mNumCacheHits;
  public int mNumCacheMisses;
  public String mPath;
  public String mPathForLogs = null;
  public WeakHashMap<SQLiteClosable, Object> mPrograms;
  public final int mSlowQueryThreshold;
  public Throwable mStackTrace = null;
  public final Map<String, SyncUpdateInfo> mSyncUpdateInfo = new HashMap();
  public int mTempTableSequence = 0;
  public String mTimeClosed = null;
  public String mTimeOpened = null;
  public boolean mTransactionIsSuccessful;
  public SQLiteTransactionListener mTransactionListener;
  
  public SQLiteDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString != null)
    {
      mFlags = paramInt;
      mPath = paramString;
      mSlowQueryThreshold = -1;
      mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      mFactory = paramCursorFactory;
      mPrograms = new WeakHashMap();
      mErrorHandler = paramDatabaseErrorHandler;
      return;
    }
    throw new IllegalArgumentException("path should not be null");
  }
  
  public SQLiteDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramString, paramCursorFactory, paramInt, null);
    openDatabaseInternal(paramArrayOfByte, paramSQLiteDatabaseHook);
  }
  
  public SQLiteDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramString, paramCursorFactory, paramInt, null);
    openDatabaseInternal(paramArrayOfChar, null);
  }
  
  public SQLiteDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramString, paramCursorFactory, paramInt, null);
    openDatabaseInternal(paramArrayOfChar, paramSQLiteDatabaseHook);
  }
  
  private void beginTransactionWithListenerInternal(SQLiteTransactionListener paramSQLiteTransactionListener, SQLiteDatabaseTransactionType paramSQLiteDatabaseTransactionType)
  {
    lockForced();
    if (isOpen()) {
      try
      {
        if (mLock.getHoldCount() > 1)
        {
          if (!mInnerTransactionIsSuccessful) {
            return;
          }
          paramSQLiteTransactionListener = new java/lang/IllegalStateException;
          paramSQLiteTransactionListener.<init>("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
          throw paramSQLiteTransactionListener;
        }
        if (paramSQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Exclusive)
        {
          execSQL("BEGIN EXCLUSIVE;");
        }
        else if (paramSQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Immediate)
        {
          execSQL("BEGIN IMMEDIATE;");
        }
        else
        {
          if (paramSQLiteDatabaseTransactionType != SQLiteDatabaseTransactionType.Deferred) {
            break label130;
          }
          execSQL("BEGIN DEFERRED;");
        }
        mTransactionListener = paramSQLiteTransactionListener;
        mTransactionIsSuccessful = true;
        mInnerTransactionIsSuccessful = false;
        if (paramSQLiteTransactionListener != null) {
          try
          {
            paramSQLiteTransactionListener.onBegin();
          }
          catch (RuntimeException paramSQLiteTransactionListener)
          {
            execSQL("ROLLBACK;");
            throw paramSQLiteTransactionListener;
          }
        }
        return;
        label130:
        paramSQLiteDatabaseTransactionType = String.format("%s is an unsupported transaction type", new Object[] { paramSQLiteDatabaseTransactionType });
        paramSQLiteTransactionListener = new java/lang/IllegalArgumentException;
        paramSQLiteTransactionListener.<init>(paramSQLiteDatabaseTransactionType);
        throw paramSQLiteTransactionListener;
      }
      finally
      {
        unlockForced();
      }
    }
    throw new IllegalStateException("database not open");
  }
  
  private void checkLockHoldTime()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - mLockAcquiredWallTime;
    boolean bool1 = l2 < 2000L;
    if ((bool1) && (!Log.isLoggable("Database", 2)) && (l1 - mLastLockMessageTime < 20000L)) {
      return;
    }
    if ((l2 > 300L) && (((int)((Debug.threadCpuTimeNanos() - mLockAcquiredThreadTime) / 1000000L) > 100) || (bool1)))
    {
      mLastLockMessageTime = l1;
      boolean bool2 = SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE;
    }
  }
  
  private void closeClosable()
  {
    deallocCachedSqlStatements();
    Iterator localIterator = mPrograms.entrySet().iterator();
    while (localIterator.hasNext())
    {
      SQLiteClosable localSQLiteClosable = (SQLiteClosable)((Map.Entry)localIterator.next()).getKey();
      if (localSQLiteClosable != null) {
        localSQLiteClosable.onAllReferencesReleasedFromContainer();
      }
    }
  }
  
  private boolean containsNull(char[] paramArrayOfChar)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramArrayOfChar != null)
    {
      bool2 = bool1;
      if (paramArrayOfChar.length > 0)
      {
        int i = paramArrayOfChar.length;
        for (int j = 0;; j++)
        {
          bool2 = bool1;
          if (j >= i) {
            break;
          }
          if (paramArrayOfChar[j] == 0)
          {
            bool2 = true;
            break;
          }
        }
      }
    }
    return bool2;
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory, String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.toCharArray();
    }
    return openDatabase(":memory:", paramString, paramCursorFactory, 268435456);
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory, char[] paramArrayOfChar)
  {
    return openDatabase(":memory:", paramArrayOfChar, paramCursorFactory, 268435456);
  }
  
  private native void dbclose();
  
  private native void dbopen(String paramString, int paramInt);
  
  private void deallocCachedSqlStatements()
  {
    synchronized (mCompiledQueries)
    {
      Iterator localIterator = mCompiledQueries.values().iterator();
      while (localIterator.hasNext()) {
        ((SQLiteCompiledSql)localIterator.next()).releaseSqlStatement();
      }
      mCompiledQueries.clear();
      return;
    }
  }
  
  private native void enableSqlProfiling(String paramString);
  
  private native void enableSqlTracing(String paramString);
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      if ((i > 0) && ((i < j) || (j < 0))) {
        return paramString.substring(0, i);
      }
      String str = paramString;
      if (j > 0) {
        if (j >= i)
        {
          str = paramString;
          if (i >= 0) {}
        }
        else
        {
          str = paramString.substring(0, j);
        }
      }
      return str;
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  public static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }
  
  public static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!paramSQLiteDatabase.isOpen()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("pragma database_list;", null);
    while (paramSQLiteDatabase.moveToNext()) {
      localArrayList.add(new Pair(paramSQLiteDatabase.getString(1), paramSQLiteDatabase.getString(2)));
    }
    paramSQLiteDatabase.close();
    return localArrayList;
  }
  
  public static byte[] getBytes(char[] paramArrayOfChar)
  {
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length != 0))
    {
      paramArrayOfChar = CharBuffer.wrap(paramArrayOfChar);
      ByteBuffer localByteBuffer = Charset.forName("UTF-8").encode(paramArrayOfChar);
      paramArrayOfChar = new byte[localByteBuffer.limit()];
      localByteBuffer.get(paramArrayOfChar);
      return paramArrayOfChar;
    }
    return null;
  }
  
  public static char[] getChars(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      paramArrayOfByte = Charset.forName("UTF-8").decode(paramArrayOfByte);
      char[] arrayOfChar = new char[paramArrayOfByte.limit()];
      paramArrayOfByte.get(arrayOfChar);
      return arrayOfChar;
    }
    return null;
  }
  
  public static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext())
    {
      SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)localIterator.next();
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
      {
        int i = localSQLiteDatabase.native_getDbLookaside();
        Object localObject = localSQLiteDatabase.getPath();
        int j = ((String)localObject).lastIndexOf("/");
        if (j != -1) {
          j++;
        } else {
          j = 0;
        }
        String str1 = ((String)localObject).substring(j);
        ArrayList localArrayList2 = getAttachedDbs(localSQLiteDatabase);
        if (localArrayList2 != null) {
          for (j = 0; j < localArrayList2.size(); j++)
          {
            Pair localPair = (Pair)localArrayList2.get(j);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append((String)first);
            ((StringBuilder)localObject).append(".page_count;");
            long l = getPragmaVal(localSQLiteDatabase, ((StringBuilder)localObject).toString());
            if (j == 0)
            {
              localObject = str1;
            }
            else
            {
              localObject = a.a("  (attached) ");
              ((StringBuilder)localObject).append((String)first);
              String str2 = ((StringBuilder)localObject).toString();
              localObject = str2;
              if (((String)second).trim().length() > 0)
              {
                i = ((String)second).lastIndexOf("/");
                localObject = a.a(str2, " : ");
                str2 = (String)second;
                if (i != -1) {
                  i++;
                } else {
                  i = 0;
                }
                ((StringBuilder)localObject).append(str2.substring(i));
                localObject = ((StringBuilder)localObject).toString();
              }
              i = 0;
            }
            if (l > 0L) {
              localArrayList1.add(new SQLiteDebug.DbStats((String)localObject, l, localSQLiteDatabase.getPageSize(), i));
            }
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private String getPathForLogs()
  {
    String str = mPathForLogs;
    if (str != null) {
      return str;
    }
    str = mPath;
    if (str == null) {
      return null;
    }
    if (str.indexOf('@') == -1) {
      mPathForLogs = mPath;
    } else {
      mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(mPath).replaceAll("XX@YY");
    }
    return mPathForLogs;
  }
  
  /* Error */
  public static long getPragmaVal(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   4: ifne +5 -> 9
    //   7: lconst_0
    //   8: lreturn
    //   9: aconst_null
    //   10: astore_2
    //   11: new 618	net/sqlcipher/database/SQLiteStatement
    //   14: astore_3
    //   15: new 556	java/lang/StringBuilder
    //   18: astore 4
    //   20: aload 4
    //   22: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   25: aload 4
    //   27: ldc_w 620
    //   30: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 4
    //   36: aload_1
    //   37: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: aload_0
    //   43: aload 4
    //   45: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 623	net/sqlcipher/database/SQLiteStatement:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;Ljava/lang/String;)V
    //   51: aload_3
    //   52: invokevirtual 626	net/sqlcipher/database/SQLiteStatement:simpleQueryForLong	()J
    //   55: lstore 5
    //   57: aload_3
    //   58: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   61: lload 5
    //   63: lreturn
    //   64: astore_0
    //   65: aload_3
    //   66: astore_1
    //   67: goto +6 -> 73
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +7 -> 81
    //   77: aload_1
    //   78: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	83	1	paramString	String
    //   10	62	2	localObject	Object
    //   14	52	3	localSQLiteStatement	SQLiteStatement
    //   18	26	4	localStringBuilder	StringBuilder
    //   55	7	5	l	long
    // Exception table:
    //   from	to	target	type
    //   51	57	64	finally
    //   11	51	70	finally
  }
  
  private Pair<Boolean, String> getResultFromPragma(String paramString)
  {
    net.sqlcipher.Cursor localCursor = rawQuery(paramString, new Object[0]);
    if (localCursor == null) {
      return new Pair(Boolean.valueOf(false), "");
    }
    localCursor.moveToFirst();
    paramString = localCursor.getString(0);
    localCursor.close();
    return new Pair(Boolean.valueOf(true), paramString);
  }
  
  private String getTime()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
  }
  
  private native void key(byte[] paramArrayOfByte);
  
  private void keyDatabase(SQLiteDatabaseHook paramSQLiteDatabaseHook, Runnable paramRunnable)
  {
    if (paramSQLiteDatabaseHook != null) {
      paramSQLiteDatabaseHook.preKey(this);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    if (paramSQLiteDatabaseHook != null) {
      paramSQLiteDatabaseHook.postKey(this);
    }
    if (SQLiteDebug.DEBUG_SQL_CACHE) {
      mTimeOpened = getTime();
    }
    try
    {
      paramSQLiteDatabaseHook = rawQuery("select count(*) from sqlite_master;", new String[0]);
      if (paramSQLiteDatabaseHook != null)
      {
        paramSQLiteDatabaseHook.moveToFirst();
        paramSQLiteDatabaseHook.getInt(0);
        paramSQLiteDatabaseHook.close();
      }
      return;
    }
    catch (RuntimeException paramSQLiteDatabaseHook)
    {
      throw paramSQLiteDatabaseHook;
    }
  }
  
  private native void key_mutf8(char[] paramArrayOfChar);
  
  /* Error */
  public static void loadICUData(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: new 705	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc_w 707
    //   8: invokespecial 710	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore_2
    //   12: new 705	java/io/File
    //   15: dup
    //   16: aload_2
    //   17: ldc_w 712
    //   20: invokespecial 710	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 715	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_2
    //   43: invokevirtual 718	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_3
    //   48: invokevirtual 715	java/io/File:exists	()Z
    //   51: ifne +109 -> 160
    //   54: new 720	java/util/zip/ZipInputStream
    //   57: astore_1
    //   58: aload_1
    //   59: aload_0
    //   60: invokevirtual 726	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: ldc_w 728
    //   66: invokevirtual 734	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   69: invokespecial 737	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: aload_1
    //   73: astore_0
    //   74: aload 5
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 741	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   81: pop
    //   82: aload_1
    //   83: astore_0
    //   84: aload 5
    //   86: astore_2
    //   87: new 743	java/io/FileOutputStream
    //   90: astore 6
    //   92: aload_1
    //   93: astore_0
    //   94: aload 5
    //   96: astore_2
    //   97: aload 6
    //   99: aload_3
    //   100: invokespecial 746	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: sipush 1024
    //   106: newarray <illegal type>
    //   108: astore_0
    //   109: aload_1
    //   110: aload_0
    //   111: invokevirtual 750	java/util/zip/ZipInputStream:read	([B)I
    //   114: istore 7
    //   116: iload 7
    //   118: ifle +15 -> 133
    //   121: aload 6
    //   123: aload_0
    //   124: iconst_0
    //   125: iload 7
    //   127: invokevirtual 756	java/io/OutputStream:write	([BII)V
    //   130: goto -21 -> 109
    //   133: aload_1
    //   134: astore_0
    //   135: goto +30 -> 165
    //   138: astore_2
    //   139: aload_1
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: goto +141 -> 284
    //   146: astore 5
    //   148: goto +80 -> 228
    //   151: astore 5
    //   153: aload 4
    //   155: astore 6
    //   157: goto +71 -> 228
    //   160: aconst_null
    //   161: astore 6
    //   163: aload_1
    //   164: astore_0
    //   165: aload_0
    //   166: ifnull +14 -> 180
    //   169: aload_0
    //   170: invokevirtual 757	java/util/zip/ZipInputStream:close	()V
    //   173: goto +7 -> 180
    //   176: astore_0
    //   177: goto +21 -> 198
    //   180: aload 6
    //   182: ifnull +25 -> 207
    //   185: aload 6
    //   187: invokevirtual 760	java/io/OutputStream:flush	()V
    //   190: aload 6
    //   192: invokevirtual 761	java/io/OutputStream:close	()V
    //   195: goto +12 -> 207
    //   198: new 226	java/lang/RuntimeException
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 764	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   206: athrow
    //   207: return
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_2
    //   211: aload 6
    //   213: astore_0
    //   214: aload_2
    //   215: astore 6
    //   217: goto +67 -> 284
    //   220: astore 5
    //   222: aconst_null
    //   223: astore_1
    //   224: aload 4
    //   226: astore 6
    //   228: aload_1
    //   229: astore_0
    //   230: aload 6
    //   232: astore_2
    //   233: aload_3
    //   234: invokevirtual 715	java/io/File:exists	()Z
    //   237: ifeq +13 -> 250
    //   240: aload_1
    //   241: astore_0
    //   242: aload 6
    //   244: astore_2
    //   245: aload_3
    //   246: invokevirtual 767	java/io/File:delete	()Z
    //   249: pop
    //   250: aload_1
    //   251: astore_0
    //   252: aload 6
    //   254: astore_2
    //   255: new 226	java/lang/RuntimeException
    //   258: astore 4
    //   260: aload_1
    //   261: astore_0
    //   262: aload 6
    //   264: astore_2
    //   265: aload 4
    //   267: aload 5
    //   269: invokespecial 764	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   272: aload_1
    //   273: astore_0
    //   274: aload 6
    //   276: astore_2
    //   277: aload 4
    //   279: athrow
    //   280: astore_1
    //   281: aload_2
    //   282: astore 6
    //   284: aload_0
    //   285: ifnull +14 -> 299
    //   288: aload_0
    //   289: invokevirtual 757	java/util/zip/ZipInputStream:close	()V
    //   292: goto +7 -> 299
    //   295: astore_0
    //   296: goto +21 -> 317
    //   299: aload 6
    //   301: ifnull +25 -> 326
    //   304: aload 6
    //   306: invokevirtual 760	java/io/OutputStream:flush	()V
    //   309: aload 6
    //   311: invokevirtual 761	java/io/OutputStream:close	()V
    //   314: goto +12 -> 326
    //   317: new 226	java/lang/RuntimeException
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 764	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   325: athrow
    //   326: aload_1
    //   327: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   0	328	1	paramFile	File
    //   11	86	2	localObject1	Object
    //   138	4	2	localObject2	Object
    //   210	72	2	localObject3	Object
    //   23	223	3	localFile	File
    //   25	253	4	localRuntimeException	RuntimeException
    //   28	67	5	localObject4	Object
    //   146	1	5	localException1	Exception
    //   151	1	5	localException2	Exception
    //   220	48	5	localException3	Exception
    //   31	279	6	localObject5	Object
    //   114	12	7	i	int
    // Exception table:
    //   from	to	target	type
    //   103	109	138	finally
    //   109	116	138	finally
    //   121	130	138	finally
    //   103	109	146	java/lang/Exception
    //   109	116	146	java/lang/Exception
    //   121	130	146	java/lang/Exception
    //   77	82	151	java/lang/Exception
    //   87	92	151	java/lang/Exception
    //   97	103	151	java/lang/Exception
    //   169	173	176	java/io/IOException
    //   185	195	176	java/io/IOException
    //   35	47	208	finally
    //   47	72	208	finally
    //   35	47	220	java/lang/Exception
    //   47	72	220	java/lang/Exception
    //   77	82	280	finally
    //   87	92	280	finally
    //   97	103	280	finally
    //   233	240	280	finally
    //   245	250	280	finally
    //   255	260	280	finally
    //   265	272	280	finally
    //   277	280	280	finally
    //   288	292	295	java/io/IOException
    //   304	314	295	java/io/IOException
  }
  
  public static void loadLibs(Context paramContext)
  {
    try
    {
      loadLibs(paramContext, paramContext.getFilesDir());
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, File paramFile)
  {
    try
    {
      LibraryLoader local1 = new net/sqlcipher/database/SQLiteDatabase$1;
      local1.<init>();
      loadLibs(paramContext, paramFile, local1);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, File paramFile, LibraryLoader paramLibraryLoader)
  {
    try
    {
      paramLibraryLoader.loadLibraries(new String[] { "sqlcipher" });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, LibraryLoader paramLibraryLoader)
  {
    try
    {
      loadLibs(paramContext, paramContext.getFilesDir(), paramLibraryLoader);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void lockForced()
  {
    mLock.lock();
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (mLock.getHoldCount() == 1))
    {
      mLockAcquiredWallTime = SystemClock.elapsedRealtime();
      mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
    }
  }
  
  /* Error */
  private void markTableSyncable(String paramString1, String arg2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   4: new 556	java/lang/StringBuilder
    //   7: astore 5
    //   9: aload 5
    //   11: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   14: aload 5
    //   16: ldc_w 797
    //   19: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_3
    //   26: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 5
    //   32: ldc_w 799
    //   35: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_0
    //   40: aload 5
    //   42: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 802	net/sqlcipher/database/SQLiteDatabase:native_execSQL	(Ljava/lang/String;)V
    //   48: new 556	java/lang/StringBuilder
    //   51: astore 5
    //   53: aload 5
    //   55: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   58: aload 5
    //   60: ldc_w 804
    //   63: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 5
    //   69: aload_2
    //   70: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: ldc_w 806
    //   79: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 5
    //   85: aload_1
    //   86: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 5
    //   92: ldc_w 799
    //   95: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: aload 5
    //   102: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokevirtual 802	net/sqlcipher/database/SQLiteDatabase:native_execSQL	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   112: new 27	net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo
    //   115: dup
    //   116: aload_3
    //   117: aload 4
    //   119: aload_2
    //   120: invokespecial 812	net/sqlcipher/database/SQLiteDatabase$SyncUpdateInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   123: astore_3
    //   124: aload_0
    //   125: getfield 215	net/sqlcipher/database/SQLiteDatabase:mSyncUpdateInfo	Ljava/util/Map;
    //   128: astore_2
    //   129: aload_2
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 215	net/sqlcipher/database/SQLiteDatabase:mSyncUpdateInfo	Ljava/util/Map;
    //   135: aload_1
    //   136: aload_3
    //   137: invokeinterface 816 3 0
    //   142: pop
    //   143: aload_2
    //   144: monitorexit
    //   145: return
    //   146: astore_1
    //   147: aload_2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: aload_0
    //   153: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	SQLiteDatabase
    //   0	158	1	paramString1	String
    //   0	158	3	paramString3	String
    //   0	158	4	paramString4	String
    //   7	94	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   131	145	146	finally
    //   147	149	146	finally
    //   4	108	151	finally
  }
  
  private native int native_getDbLookaside();
  
  private native void native_rawExecSQL(String paramString);
  
  private native int native_status(int paramInt, boolean paramBoolean);
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.toCharArray();
    }
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openDatabase(String arg0, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramDatabaseErrorHandler == null) {
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = new net/sqlcipher/database/SQLiteDatabase;
      localSQLiteDatabase1.<init>(???, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
      paramDatabaseErrorHandler.onCorruption(localSQLiteDatabase2);
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1)
    {
      try
      {
        localSQLiteDatabase1.openDatabaseInternal(paramArrayOfByte, paramSQLiteDatabaseHook);
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException2)
      {
        SQLiteDatabase localSQLiteDatabase2;
        for (;;) {}
      }
      localSQLiteDatabaseCorruptException1 = localSQLiteDatabaseCorruptException1;
      localSQLiteDatabase2 = null;
    }
    localSQLiteDatabase2 = new SQLiteDatabase(???, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
    localSQLiteDatabase2.openDatabaseInternal(paramArrayOfByte, paramSQLiteDatabaseHook);
    if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
      localSQLiteDatabase2.enableSqlTracing(???);
    }
    if (SQLiteDebug.DEBUG_SQL_TIME) {
      localSQLiteDatabase2.enableSqlProfiling(???);
    }
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(localSQLiteDatabase2, null);
      return localSQLiteDatabase2;
    }
  }
  
  public static SQLiteDatabase openDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, paramInt, null, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, getBytes(paramArrayOfChar), paramCursorFactory, paramInt, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  /* Error */
  private void openDatabaseInternal(byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 219	net/sqlcipher/database/SQLiteDatabase:mPath	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 217	net/sqlcipher/database/SQLiteDatabase:mFlags	I
    //   9: invokespecial 858	net/sqlcipher/database/SQLiteDatabase:dbopen	(Ljava/lang/String;I)V
    //   12: iconst_0
    //   13: istore_3
    //   14: new 10	net/sqlcipher/database/SQLiteDatabase$2
    //   17: astore 4
    //   19: aload 4
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 860	net/sqlcipher/database/SQLiteDatabase$2:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;[B)V
    //   26: aload_0
    //   27: aload_2
    //   28: aload 4
    //   30: invokespecial 862	net/sqlcipher/database/SQLiteDatabase:keyDatabase	(Lnet/sqlcipher/database/SQLiteDatabaseHook;Ljava/lang/Runnable;)V
    //   33: goto +85 -> 118
    //   36: astore_1
    //   37: iconst_1
    //   38: istore_3
    //   39: goto +83 -> 122
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 864	net/sqlcipher/database/SQLiteDatabase:getChars	([B)[C
    //   48: astore 4
    //   50: aload_0
    //   51: aload 4
    //   53: invokespecial 866	net/sqlcipher/database/SQLiteDatabase:containsNull	([C)Z
    //   56: ifeq +63 -> 119
    //   59: new 12	net/sqlcipher/database/SQLiteDatabase$3
    //   62: astore 5
    //   64: aload 5
    //   66: aload_0
    //   67: aload_1
    //   68: aload 4
    //   70: invokespecial 869	net/sqlcipher/database/SQLiteDatabase$3:<init>	(Lnet/sqlcipher/database/SQLiteDatabase;[B[C)V
    //   73: aload_0
    //   74: aload_2
    //   75: aload 5
    //   77: invokespecial 862	net/sqlcipher/database/SQLiteDatabase:keyDatabase	(Lnet/sqlcipher/database/SQLiteDatabaseHook;Ljava/lang/Runnable;)V
    //   80: aload_1
    //   81: ifnull +13 -> 94
    //   84: aload_1
    //   85: arraylength
    //   86: ifle +8 -> 94
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 872	net/sqlcipher/database/SQLiteDatabase:rekey	([B)V
    //   94: aload 4
    //   96: ifnull +22 -> 118
    //   99: aload 4
    //   101: arraylength
    //   102: ifle +16 -> 118
    //   105: aload 4
    //   107: iconst_0
    //   108: invokestatic 878	java/util/Arrays:fill	([CC)V
    //   111: goto +7 -> 118
    //   114: astore_1
    //   115: goto +7 -> 122
    //   118: return
    //   119: aload 5
    //   121: athrow
    //   122: iload_3
    //   123: ifeq +21 -> 144
    //   126: aload_0
    //   127: invokespecial 880	net/sqlcipher/database/SQLiteDatabase:dbclose	()V
    //   130: getstatic 690	net/sqlcipher/database/SQLiteDebug:DEBUG_SQL_CACHE	Z
    //   133: ifeq +11 -> 144
    //   136: aload_0
    //   137: aload_0
    //   138: invokespecial 692	net/sqlcipher/database/SQLiteDatabase:getTime	()Ljava/lang/String;
    //   141: putfield 209	net/sqlcipher/database/SQLiteDatabase:mTimeClosed	Ljava/lang/String;
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	SQLiteDatabase
    //   0	146	1	paramArrayOfByte	byte[]
    //   0	146	2	paramSQLiteDatabaseHook	SQLiteDatabaseHook
    //   13	110	3	i	int
    //   17	89	4	localObject	Object
    //   42	1	5	localRuntimeException	RuntimeException
    //   62	58	5	local3	3
    // Exception table:
    //   from	to	target	type
    //   14	33	36	finally
    //   44	80	36	finally
    //   84	94	36	finally
    //   119	122	36	finally
    //   14	33	42	java/lang/RuntimeException
    //   99	111	114	finally
  }
  
  private void openDatabaseInternal(char[] paramArrayOfChar, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    openDatabaseInternal(getBytes(paramArrayOfChar), paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramFile == null) {
      paramFile = null;
    } else {
      paramFile = paramFile.getPath();
    }
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.toCharArray();
    }
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfByte, paramCursorFactory, 268435456, null, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString, paramArrayOfByte, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, byte[] paramArrayOfByte, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfByte, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  private native void rekey(byte[] paramArrayOfByte);
  
  public static native int releaseMemory();
  
  public static native void setICURoot(String paramString);
  
  private void unlockForced()
  {
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (mLock.getHoldCount() == 1)) {
      checkLockHoldTime();
    }
    mLock.unlock();
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    if (mLock.getQueueLength() == 0)
    {
      mLockAcquiredWallTime = SystemClock.elapsedRealtime();
      mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
      return false;
    }
    setTransactionSuccessful();
    SQLiteTransactionListener localSQLiteTransactionListener = mTransactionListener;
    endTransaction();
    if ((paramBoolean) && (isDbLockedByCurrentThread())) {
      throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
    }
    if (paramLong > 0L) {
      do
      {
        if (paramLong <= 0L) {
          break;
        }
        long l;
        if (paramLong < 1000L) {
          l = paramLong;
        } else {
          l = 1000L;
        }
        try
        {
          Thread.sleep(l);
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.interrupted();
        }
        paramLong -= 1000L;
      } while (mLock.getQueueLength() != 0);
    }
    beginTransactionWithListener(localSQLiteTransactionListener);
    return true;
  }
  
  public void addSQLiteClosable(SQLiteClosable paramSQLiteClosable)
  {
    lock();
    try
    {
      mPrograms.put(paramSQLiteClosable, null);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public void addToCompiledQueries(String paramString, SQLiteCompiledSql paramSQLiteCompiledSql)
  {
    boolean bool;
    if (mMaxSqlCacheSize == 0)
    {
      bool = SQLiteDebug.DEBUG_SQL_CACHE;
      return;
    }
    synchronized (mCompiledQueries)
    {
      if ((SQLiteCompiledSql)mCompiledQueries.get(paramString) != null) {
        return;
      }
      if (mCompiledQueries.size() == mMaxSqlCacheSize)
      {
        mCacheFullWarnings += 1;
      }
      else
      {
        mCompiledQueries.put(paramString, paramSQLiteCompiledSql);
        bool = SQLiteDebug.DEBUG_SQL_CACHE;
      }
      return;
    }
  }
  
  public void beginTransaction()
  {
    beginTransactionWithListener(null);
  }
  
  public void beginTransactionNonExclusive()
  {
    beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
  }
  
  public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransactionWithListener(new SQLiteTransactionListener()
    {
      public void onBegin()
      {
        paramSQLiteTransactionListener.onBegin();
      }
      
      public void onCommit()
      {
        paramSQLiteTransactionListener.onCommit();
      }
      
      public void onRollback()
      {
        paramSQLiteTransactionListener.onRollback();
      }
    });
  }
  
  public void beginTransactionWithListener(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransactionWithListenerInternal(paramSQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
  }
  
  public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener()
    {
      public void onBegin()
      {
        paramSQLiteTransactionListener.onBegin();
      }
      
      public void onCommit()
      {
        paramSQLiteTransactionListener.onCommit();
      }
      
      public void onRollback()
      {
        paramSQLiteTransactionListener.onRollback();
      }
    });
  }
  
  public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener paramSQLiteTransactionListener)
  {
    beginTransactionWithListenerInternal(paramSQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
  }
  
  public void changePassword(String paramString)
  {
    if (isOpen())
    {
      if (paramString != null)
      {
        paramString = getBytes(paramString.toCharArray());
        rekey(paramString);
        Arrays.fill(paramString, (byte)0);
      }
      return;
    }
    throw new SQLiteException("database not open");
  }
  
  public void changePassword(char[] paramArrayOfChar)
  {
    if (isOpen())
    {
      if (paramArrayOfChar != null)
      {
        paramArrayOfChar = getBytes(paramArrayOfChar);
        rekey(paramArrayOfChar);
        Arrays.fill(paramArrayOfChar, (byte)0);
      }
      return;
    }
    throw new SQLiteException("database not open");
  }
  
  public void close()
  {
    if (!isOpen()) {
      return;
    }
    lock();
    try
    {
      closeClosable();
      onAllReferencesReleased();
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public SQLiteStatement compileStatement(String paramString)
  {
    lock();
    try
    {
      if (isOpen())
      {
        paramString = new SQLiteStatement(this, paramString);
        return paramString;
      }
      paramString = new java/lang/IllegalStateException;
      paramString.<init>("database not open");
      throw paramString;
    }
    finally
    {
      unlock();
    }
  }
  
  /* Error */
  public int delete(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 5
    //   10: aload 5
    //   12: astore 6
    //   14: aload 4
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   22: ifeq +268 -> 290
    //   25: aload 5
    //   27: astore 6
    //   29: aload 4
    //   31: astore 7
    //   33: new 556	java/lang/StringBuilder
    //   36: astore 8
    //   38: aload 5
    //   40: astore 6
    //   42: aload 4
    //   44: astore 7
    //   46: aload 8
    //   48: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   51: aload 5
    //   53: astore 6
    //   55: aload 4
    //   57: astore 7
    //   59: aload 8
    //   61: ldc_w 982
    //   64: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: aload 8
    //   78: aload_1
    //   79: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 5
    //   85: astore 6
    //   87: aload 4
    //   89: astore 7
    //   91: aload_2
    //   92: invokestatic 435	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifne +73 -> 168
    //   98: aload 5
    //   100: astore 6
    //   102: aload 4
    //   104: astore 7
    //   106: new 556	java/lang/StringBuilder
    //   109: astore_1
    //   110: aload 5
    //   112: astore 6
    //   114: aload 4
    //   116: astore 7
    //   118: aload_1
    //   119: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   122: aload 5
    //   124: astore 6
    //   126: aload 4
    //   128: astore 7
    //   130: aload_1
    //   131: ldc_w 984
    //   134: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: astore 6
    //   142: aload 4
    //   144: astore 7
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: astore 6
    //   156: aload 4
    //   158: astore 7
    //   160: aload_1
    //   161: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore_1
    //   165: goto +6 -> 171
    //   168: ldc -106
    //   170: astore_1
    //   171: aload 5
    //   173: astore 6
    //   175: aload 4
    //   177: astore 7
    //   179: aload 8
    //   181: aload_1
    //   182: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 5
    //   188: astore 6
    //   190: aload 4
    //   192: astore 7
    //   194: aload_0
    //   195: aload 8
    //   197: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 979	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   203: astore_1
    //   204: aload_3
    //   205: ifnull +52 -> 257
    //   208: aload_1
    //   209: astore 6
    //   211: aload_1
    //   212: astore 7
    //   214: aload_3
    //   215: arraylength
    //   216: istore 9
    //   218: iconst_0
    //   219: istore 10
    //   221: iload 10
    //   223: iload 9
    //   225: if_icmpge +32 -> 257
    //   228: iload 10
    //   230: iconst_1
    //   231: iadd
    //   232: istore 11
    //   234: aload_1
    //   235: astore 6
    //   237: aload_1
    //   238: astore 7
    //   240: aload_1
    //   241: iload 11
    //   243: aload_3
    //   244: iload 10
    //   246: aaload
    //   247: invokestatic 990	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   250: iload 11
    //   252: istore 10
    //   254: goto -33 -> 221
    //   257: aload_1
    //   258: astore 6
    //   260: aload_1
    //   261: astore 7
    //   263: aload_1
    //   264: invokevirtual 993	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   267: aload_1
    //   268: astore 6
    //   270: aload_1
    //   271: astore 7
    //   273: aload_0
    //   274: invokevirtual 996	net/sqlcipher/database/SQLiteDatabase:lastChangeCount	()I
    //   277: istore 10
    //   279: aload_1
    //   280: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   283: aload_0
    //   284: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   287: iload 10
    //   289: ireturn
    //   290: aload 5
    //   292: astore 6
    //   294: aload 4
    //   296: astore 7
    //   298: new 284	java/lang/IllegalStateException
    //   301: astore_1
    //   302: aload 5
    //   304: astore 6
    //   306: aload 4
    //   308: astore 7
    //   310: aload_1
    //   311: ldc_w 330
    //   314: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   317: aload 5
    //   319: astore 6
    //   321: aload 4
    //   323: astore 7
    //   325: aload_1
    //   326: athrow
    //   327: astore_1
    //   328: goto +18 -> 346
    //   331: astore_1
    //   332: aload 7
    //   334: astore 6
    //   336: aload_0
    //   337: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   340: aload 7
    //   342: astore 6
    //   344: aload_1
    //   345: athrow
    //   346: aload 6
    //   348: ifnull +8 -> 356
    //   351: aload 6
    //   353: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   356: aload_0
    //   357: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	SQLiteDatabase
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramArrayOfObject	Object[]
    //   5	317	4	localObject1	Object
    //   8	310	5	localObject2	Object
    //   12	340	6	localObject3	Object
    //   16	325	7	localObject4	Object
    //   36	160	8	localStringBuilder	StringBuilder
    //   216	10	9	i	int
    //   219	69	10	j	int
    //   232	19	11	k	int
    // Exception table:
    //   from	to	target	type
    //   18	25	327	finally
    //   33	38	327	finally
    //   46	51	327	finally
    //   59	68	327	finally
    //   76	83	327	finally
    //   91	98	327	finally
    //   106	110	327	finally
    //   118	122	327	finally
    //   130	138	327	finally
    //   146	152	327	finally
    //   160	165	327	finally
    //   179	186	327	finally
    //   194	204	327	finally
    //   214	218	327	finally
    //   240	250	327	finally
    //   263	267	327	finally
    //   273	279	327	finally
    //   298	302	327	finally
    //   310	317	327	finally
    //   325	327	327	finally
    //   336	340	327	finally
    //   344	346	327	finally
    //   18	25	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   33	38	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   46	51	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   59	68	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   76	83	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   91	98	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   106	110	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   118	122	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   130	138	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   146	152	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   160	165	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   179	186	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   194	204	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   214	218	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   240	250	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   263	267	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   273	279	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   298	302	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   310	317	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   325	327	331	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Object[] arrayOfObject = new Object[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, arrayOfObject, 0, paramArrayOfString.length);
    return delete(paramString1, paramString2, arrayOfObject);
  }
  
  public void disableWriteAheadLogging()
  {
    if (!inTransaction())
    {
      rawExecSQL("PRAGMA journal_mode = DELETE;");
      return;
    }
    throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
  }
  
  public boolean enableWriteAheadLogging()
  {
    if (!inTransaction())
    {
      ArrayList localArrayList = getAttachedDbs(this);
      if ((localArrayList != null) && (localArrayList.size() > 1)) {
        return false;
      }
      if ((!isReadOnly()) && (!getPath().equals(":memory:")))
      {
        rawExecSQL("PRAGMA journal_mode = WAL;");
        return true;
      }
      return false;
    }
    throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
  }
  
  public void endTransaction()
  {
    if (isOpen()) {
      if (!mLock.isHeldByCurrentThread()) {}
    }
    for (;;)
    {
      try
      {
        if (mInnerTransactionIsSuccessful) {
          mInnerTransactionIsSuccessful = false;
        } else {
          mTransactionIsSuccessful = false;
        }
        int i = mLock.getHoldCount();
        if (i != 1) {
          return;
        }
        SQLiteTransactionListener localSQLiteTransactionListener = mTransactionListener;
        if (localSQLiteTransactionListener != null) {
          try
          {
            if (mTransactionIsSuccessful) {
              mTransactionListener.onCommit();
            } else {
              mTransactionListener.onRollback();
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            mTransactionIsSuccessful = false;
            continue;
          }
        }
        localObject1 = null;
        if (mTransactionIsSuccessful) {
          execSQL("COMMIT;");
        }
      }
      finally
      {
        Object localObject1;
        mTransactionListener = null;
        unlockForced();
      }
      try
      {
        execSQL("ROLLBACK;");
        if (localObject1 != null) {
          throw ((Throwable)localObject1);
        }
      }
      catch (SQLException localSQLException) {}
    }
    mTransactionListener = null;
    unlockForced();
    return;
    throw new IllegalStateException("no transaction pending");
    throw new IllegalStateException("database not open");
  }
  
  /* Error */
  public void execSQL(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1046	android/os/SystemClock:uptimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   8: aload_0
    //   9: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 802	net/sqlcipher/database/SQLiteDatabase:native_execSQL	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   24: return
    //   25: new 284	java/lang/IllegalStateException
    //   28: astore_1
    //   29: aload_1
    //   30: ldc_w 330
    //   33: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: goto +10 -> 49
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   47: aload_1
    //   48: athrow
    //   49: aload_0
    //   50: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	SQLiteDatabase
    //   0	55	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   8	20	38	finally
    //   25	38	38	finally
    //   43	49	38	finally
    //   8	20	42	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   25	38	42	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  /* Error */
  public void execSQL(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +180 -> 181
    //   4: invokestatic 1046	android/os/SystemClock:uptimeMillis	()J
    //   7: pop2
    //   8: aload_0
    //   9: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: aload 4
    //   19: astore 5
    //   21: aload_3
    //   22: astore 6
    //   24: aload_0
    //   25: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   28: ifeq +84 -> 112
    //   31: aload 4
    //   33: astore 5
    //   35: aload_3
    //   36: astore 6
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 979	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   43: astore_1
    //   44: aload_1
    //   45: astore 5
    //   47: aload_1
    //   48: astore 6
    //   50: aload_2
    //   51: arraylength
    //   52: istore 7
    //   54: iconst_0
    //   55: istore 8
    //   57: iload 8
    //   59: iload 7
    //   61: if_icmpge +32 -> 93
    //   64: iload 8
    //   66: iconst_1
    //   67: iadd
    //   68: istore 9
    //   70: aload_1
    //   71: astore 5
    //   73: aload_1
    //   74: astore 6
    //   76: aload_1
    //   77: iload 9
    //   79: aload_2
    //   80: iload 8
    //   82: aaload
    //   83: invokestatic 990	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   86: iload 9
    //   88: istore 8
    //   90: goto -33 -> 57
    //   93: aload_1
    //   94: astore 5
    //   96: aload_1
    //   97: astore 6
    //   99: aload_1
    //   100: invokevirtual 993	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   103: aload_1
    //   104: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   107: aload_0
    //   108: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   111: return
    //   112: aload 4
    //   114: astore 5
    //   116: aload_3
    //   117: astore 6
    //   119: new 284	java/lang/IllegalStateException
    //   122: astore_1
    //   123: aload 4
    //   125: astore 5
    //   127: aload_3
    //   128: astore 6
    //   130: aload_1
    //   131: ldc_w 330
    //   134: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: astore 5
    //   141: aload_3
    //   142: astore 6
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: goto +18 -> 165
    //   150: astore_1
    //   151: aload 6
    //   153: astore 5
    //   155: aload_0
    //   156: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   159: aload 6
    //   161: astore 5
    //   163: aload_1
    //   164: athrow
    //   165: aload 5
    //   167: ifnull +8 -> 175
    //   170: aload 5
    //   172: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   175: aload_0
    //   176: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   179: aload_1
    //   180: athrow
    //   181: new 238	java/lang/IllegalArgumentException
    //   184: dup
    //   185: ldc_w 1049
    //   188: invokespecial 243	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	SQLiteDatabase
    //   0	192	1	paramString	String
    //   0	192	2	paramArrayOfObject	Object[]
    //   13	129	3	localObject1	Object
    //   15	123	4	localObject2	Object
    //   19	152	5	localObject3	Object
    //   22	138	6	localObject4	Object
    //   52	10	7	i	int
    //   55	34	8	j	int
    //   68	19	9	k	int
    // Exception table:
    //   from	to	target	type
    //   24	31	146	finally
    //   38	44	146	finally
    //   50	54	146	finally
    //   76	86	146	finally
    //   99	103	146	finally
    //   119	123	146	finally
    //   130	137	146	finally
    //   144	146	146	finally
    //   155	159	146	finally
    //   163	165	146	finally
    //   24	31	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   38	44	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   50	54	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   76	86	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   99	103	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   119	123	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   130	137	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   144	146	150	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  public void finalize()
  {
    if (isOpen())
    {
      closeClosable();
      onAllReferencesReleased();
    }
  }
  
  public List<Pair<String, String>> getAttachedDbs()
  {
    return getAttachedDbs(this);
  }
  
  public SQLiteCompiledSql getCompiledStatementForSql(String paramString)
  {
    synchronized (mCompiledQueries)
    {
      if (mMaxSqlCacheSize == 0)
      {
        bool = SQLiteDebug.DEBUG_SQL_CACHE;
        return null;
      }
      paramString = (SQLiteCompiledSql)mCompiledQueries.get(paramString);
      int i;
      if (paramString != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        mNumCacheHits += 1;
      } else {
        mNumCacheMisses += 1;
      }
      boolean bool = SQLiteDebug.DEBUG_SQL_CACHE;
      return paramString;
    }
  }
  
  public int getMaxSqlCacheSize()
  {
    try
    {
      int i = mMaxSqlCacheSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaximumSize()
  {
    lock();
    try
    {
      if (isOpen())
      {
        localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
        localSQLiteStatement.<init>(this, "PRAGMA max_page_count;");
        try
        {
          long l1 = localSQLiteStatement.simpleQueryForLong();
          long l2 = getPageSize();
          localSQLiteStatement.close();
          unlock();
          return l1 * l2;
        }
        finally
        {
          break label72;
        }
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("database not open");
      throw localIllegalStateException;
    }
    finally
    {
      SQLiteStatement localSQLiteStatement = null;
      label72:
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      unlock();
    }
  }
  
  public long getPageSize()
  {
    lock();
    try
    {
      if (isOpen())
      {
        localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
        localSQLiteStatement.<init>(this, "PRAGMA page_size;");
        try
        {
          long l = localSQLiteStatement.simpleQueryForLong();
          localSQLiteStatement.close();
          unlock();
          return l;
        }
        finally
        {
          break label63;
        }
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("database not open");
      throw localIllegalStateException;
    }
    finally
    {
      SQLiteStatement localSQLiteStatement = null;
      label63:
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      unlock();
    }
  }
  
  public final String getPath()
  {
    return mPath;
  }
  
  public SQLiteQueryStats getQueryStats(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      execSQL(String.format("CREATE TABLE tempstat AS %s", new Object[] { paramString }), paramArrayOfObject);
      paramString = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
      if (paramString == null) {
        return new SQLiteQueryStats(0L, 0L);
      }
      paramString.moveToFirst();
      long l1 = paramString.getLong(0);
      paramString.close();
      paramString = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
      if (paramString == null) {
        return new SQLiteQueryStats(l1, 0L);
      }
      paramString.moveToFirst();
      long l2 = paramString.getLong(0);
      paramString.close();
      execSQL("DROP TABLE tempstat;");
      return new SQLiteQueryStats(l1, l2);
    }
    catch (SQLiteException paramString)
    {
      execSQL("DROP TABLE IF EXISTS tempstat;");
      throw paramString;
    }
  }
  
  public Map<String, String> getSyncedTables()
  {
    synchronized (mSyncUpdateInfo)
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      Iterator localIterator = mSyncUpdateInfo.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        SyncUpdateInfo localSyncUpdateInfo = (SyncUpdateInfo)mSyncUpdateInfo.get(str);
        if (deletedTable != null) {
          localHashMap.put(str, deletedTable);
        }
      }
      return localHashMap;
    }
  }
  
  public int getVersion()
  {
    lock();
    try
    {
      if (isOpen())
      {
        localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
        localSQLiteStatement.<init>(this, "PRAGMA user_version;");
        try
        {
          long l = localSQLiteStatement.simpleQueryForLong();
          int i = (int)l;
          localSQLiteStatement.close();
          unlock();
          return i;
        }
        finally
        {
          break label68;
        }
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("database not open");
      throw localIllegalStateException;
    }
    finally
    {
      SQLiteStatement localSQLiteStatement = null;
      label68:
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      unlock();
    }
  }
  
  public boolean inTransaction()
  {
    boolean bool;
    if (mLock.getHoldCount() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long insert(String paramString, int paramInt, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString, null, paramContentValues, paramInt);
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
      return l;
    }
    catch (SQLException paramString1) {}
    return -1L;
  }
  
  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  /* Error */
  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   4: ifeq +450 -> 454
    //   7: new 556	java/lang/StringBuilder
    //   10: dup
    //   11: sipush 152
    //   14: invokespecial 1111	java/lang/StringBuilder:<init>	(I)V
    //   17: astore 5
    //   19: aload 5
    //   21: ldc_w 1113
    //   24: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: getstatic 162	net/sqlcipher/database/SQLiteDatabase:CONFLICT_VALUES	[Ljava/lang/String;
    //   33: iload 4
    //   35: aaload
    //   36: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: ldc_w 1115
    //   45: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: aload_1
    //   52: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: new 556	java/lang/StringBuilder
    //   59: dup
    //   60: bipush 40
    //   62: invokespecial 1111	java/lang/StringBuilder:<init>	(I)V
    //   65: astore 6
    //   67: iconst_0
    //   68: istore 7
    //   70: aconst_null
    //   71: astore 8
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_3
    //   76: ifnull +113 -> 189
    //   79: aload_3
    //   80: invokevirtual 1118	android/content/ContentValues:size	()I
    //   83: ifle +106 -> 189
    //   86: aload_3
    //   87: invokevirtual 1121	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   90: astore_3
    //   91: aload_3
    //   92: invokeinterface 375 1 0
    //   97: astore_2
    //   98: aload 5
    //   100: bipush 40
    //   102: invokevirtual 1124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: iconst_0
    //   107: istore 4
    //   109: aload_2
    //   110: invokeinterface 380 1 0
    //   115: ifeq +63 -> 178
    //   118: iload 4
    //   120: ifeq +21 -> 141
    //   123: aload 5
    //   125: ldc_w 1126
    //   128: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 6
    //   134: ldc_w 1126
    //   137: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: aload_2
    //   144: invokeinterface 384 1 0
    //   149: checkcast 386	java/util/Map$Entry
    //   152: invokeinterface 389 1 0
    //   157: checkcast 148	java/lang/String
    //   160: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 6
    //   166: bipush 63
    //   168: invokevirtual 1124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iconst_1
    //   173: istore 4
    //   175: goto -66 -> 109
    //   178: aload 5
    //   180: bipush 41
    //   182: invokevirtual 1124	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: goto +54 -> 240
    //   189: new 556	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 557	java/lang/StringBuilder:<init>	()V
    //   196: astore_3
    //   197: aload_3
    //   198: ldc_w 1128
    //   201: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: aload_2
    //   207: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: ldc_w 1130
    //   215: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 5
    //   221: aload_3
    //   222: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: ldc_w 1132
    //   234: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aconst_null
    //   239: astore_3
    //   240: aload 5
    //   242: ldc_w 1134
    //   245: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 5
    //   251: aload 6
    //   253: invokevirtual 1137	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 5
    //   259: ldc_w 1139
    //   262: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   270: aload 8
    //   272: astore_2
    //   273: aload_0
    //   274: aload 5
    //   276: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokevirtual 979	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   282: astore 8
    //   284: aload_3
    //   285: ifnull +84 -> 369
    //   288: aload 8
    //   290: astore_1
    //   291: aload 8
    //   293: astore_2
    //   294: aload_3
    //   295: invokeinterface 1140 1 0
    //   300: istore 9
    //   302: aload 8
    //   304: astore_1
    //   305: aload 8
    //   307: astore_2
    //   308: aload_3
    //   309: invokeinterface 375 1 0
    //   314: astore 5
    //   316: iload 7
    //   318: istore 4
    //   320: iload 4
    //   322: iload 9
    //   324: if_icmpge +45 -> 369
    //   327: aload 8
    //   329: astore_1
    //   330: aload 8
    //   332: astore_2
    //   333: aload 5
    //   335: invokeinterface 384 1 0
    //   340: checkcast 386	java/util/Map$Entry
    //   343: astore_3
    //   344: iinc 4 1
    //   347: aload 8
    //   349: astore_1
    //   350: aload 8
    //   352: astore_2
    //   353: aload 8
    //   355: iload 4
    //   357: aload_3
    //   358: invokeinterface 1143 1 0
    //   363: invokestatic 990	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   366: goto -46 -> 320
    //   369: aload 8
    //   371: astore_1
    //   372: aload 8
    //   374: astore_2
    //   375: aload 8
    //   377: invokevirtual 993	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   380: aload 8
    //   382: astore_1
    //   383: aload 8
    //   385: astore_2
    //   386: aload_0
    //   387: invokevirtual 996	net/sqlcipher/database/SQLiteDatabase:lastChangeCount	()I
    //   390: ifle +18 -> 408
    //   393: aload 8
    //   395: astore_1
    //   396: aload 8
    //   398: astore_2
    //   399: aload_0
    //   400: invokevirtual 1146	net/sqlcipher/database/SQLiteDatabase:lastInsertRow	()J
    //   403: lstore 10
    //   405: goto +8 -> 413
    //   408: ldc2_w 1106
    //   411: lstore 10
    //   413: aload 8
    //   415: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   418: aload_0
    //   419: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   422: lload 10
    //   424: lreturn
    //   425: astore_2
    //   426: goto +14 -> 440
    //   429: astore_3
    //   430: aload_2
    //   431: astore_1
    //   432: aload_0
    //   433: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   436: aload_2
    //   437: astore_1
    //   438: aload_3
    //   439: athrow
    //   440: aload_1
    //   441: ifnull +7 -> 448
    //   444: aload_1
    //   445: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   448: aload_0
    //   449: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   452: aload_2
    //   453: athrow
    //   454: new 284	java/lang/IllegalStateException
    //   457: dup
    //   458: ldc_w 330
    //   461: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   464: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	SQLiteDatabase
    //   0	465	1	paramString1	String
    //   0	465	2	paramString2	String
    //   0	465	3	paramContentValues	ContentValues
    //   0	465	4	paramInt	int
    //   17	317	5	localObject	Object
    //   65	187	6	localStringBuilder	StringBuilder
    //   68	249	7	i	int
    //   71	343	8	localSQLiteStatement	SQLiteStatement
    //   300	25	9	j	int
    //   403	20	10	l	long
    // Exception table:
    //   from	to	target	type
    //   273	284	425	finally
    //   294	302	425	finally
    //   308	316	425	finally
    //   333	344	425	finally
    //   353	366	425	finally
    //   375	380	425	finally
    //   386	393	425	finally
    //   399	405	425	finally
    //   432	436	425	finally
    //   438	440	425	finally
    //   273	284	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   294	302	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   308	316	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   333	344	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   353	366	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   375	380	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   386	393	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   399	405	429	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  public boolean isDatabaseIntegrityOk()
  {
    Pair localPair = getResultFromPragma("PRAGMA integrity_check;");
    boolean bool;
    if (((Boolean)first).booleanValue()) {
      bool = ((String)second).equals("ok");
    } else {
      bool = ((Boolean)first).booleanValue();
    }
    return bool;
  }
  
  public boolean isDbLockedByCurrentThread()
  {
    return mLock.isHeldByCurrentThread();
  }
  
  public boolean isDbLockedByOtherThreads()
  {
    boolean bool;
    if ((!mLock.isHeldByCurrentThread()) && (mLock.isLocked())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isInCompiledSqlCache(String paramString)
  {
    synchronized (mCompiledQueries)
    {
      boolean bool = mCompiledQueries.containsKey(paramString);
      return bool;
    }
  }
  
  public boolean isOpen()
  {
    boolean bool;
    if (mNativeHandle != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isReadOnly()
  {
    int i = mFlags;
    boolean bool = true;
    if ((i & 0x1) != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isWriteAheadLoggingEnabled()
  {
    Pair localPair = getResultFromPragma("PRAGMA journal_mode;");
    boolean bool;
    if (((Boolean)first).booleanValue()) {
      bool = ((String)second).equals("wal");
    } else {
      bool = ((Boolean)first).booleanValue();
    }
    return bool;
  }
  
  public native int lastChangeCount();
  
  public native long lastInsertRow();
  
  public void lock()
  {
    if (!mLockingEnabled) {
      return;
    }
    mLock.lock();
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (mLock.getHoldCount() == 1))
    {
      mLockAcquiredWallTime = SystemClock.elapsedRealtime();
      mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
    }
  }
  
  public void markTableSyncable(String paramString1, String paramString2)
  {
    if (isOpen())
    {
      markTableSyncable(paramString1, "_id", paramString1, paramString2);
      return;
    }
    throw new SQLiteException("database not open");
  }
  
  public void markTableSyncable(String paramString1, String paramString2, String paramString3)
  {
    if (isOpen())
    {
      markTableSyncable(paramString1, paramString2, paramString3, null);
      return;
    }
    throw new SQLiteException("database not open");
  }
  
  public native void native_execSQL(String paramString);
  
  public native void native_setLocale(String paramString, int paramInt);
  
  public boolean needUpgrade(int paramInt)
  {
    boolean bool;
    if (paramInt > getVersion()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onAllReferencesReleased()
  {
    if (isOpen())
    {
      if (SQLiteDebug.DEBUG_SQL_CACHE) {
        mTimeClosed = getTime();
      }
      dbclose();
      synchronized (sActiveDatabases)
      {
        sActiveDatabases.remove(this);
      }
    }
  }
  
  public void onCorruption()
  {
    mErrorHandler.onCorruption(this);
  }
  
  public void purgeFromCompiledSqlCache(String paramString)
  {
    synchronized (mCompiledQueries)
    {
      mCompiledQueries.remove(paramString);
      return;
    }
  }
  
  public android.database.Cursor query(e parame)
  {
    return query(parame, null);
  }
  
  public android.database.Cursor query(e parame, CancellationSignal paramCancellationSignal)
  {
    paramCancellationSignal = new BindingsRecorder();
    parame.a(paramCancellationSignal);
    return rawQuery(parame.a(), paramCancellationSignal.getBindings());
  }
  
  public android.database.Cursor query(String paramString)
  {
    return rawQuery(paramString, null);
  }
  
  public android.database.Cursor query(String paramString, Object[] paramArrayOfObject)
  {
    return rawQuery(paramString, paramArrayOfObject);
  }
  
  public net.sqlcipher.Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null);
  }
  
  public net.sqlcipher.Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return query(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public net.sqlcipher.Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return queryWithFactory(null, paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public net.sqlcipher.Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (isOpen()) {
      return rawQueryWithFactory(paramCursorFactory, SQLiteQueryBuilder.buildQueryString(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5, paramString6), paramArrayOfString2, findEditTable(paramString1));
    }
    throw new IllegalStateException("database not open");
  }
  
  /* Error */
  public void rawExecSQL(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1046	android/os/SystemClock:uptimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   8: aload_0
    //   9: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 1229	net/sqlcipher/database/SQLiteDatabase:native_rawExecSQL	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   24: return
    //   25: new 284	java/lang/IllegalStateException
    //   28: astore_1
    //   29: aload_1
    //   30: ldc_w 330
    //   33: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: athrow
    //   38: astore_1
    //   39: goto +10 -> 49
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   47: aload_1
    //   48: athrow
    //   49: aload_0
    //   50: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	SQLiteDatabase
    //   0	55	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   8	20	38	finally
    //   25	38	38	finally
    //   43	49	38	finally
    //   8	20	42	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   25	38	42	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  public net.sqlcipher.Cursor rawQuery(String paramString, Object[] paramArrayOfObject)
  {
    if (isOpen())
    {
      long l = 0L;
      int i = mSlowQueryThreshold;
      int j = -1;
      if (i != -1) {
        l = System.currentTimeMillis();
      }
      paramString = new SQLiteDirectCursorDriver(this, paramString, null);
      try
      {
        localObject = paramString.query(mFactory, paramArrayOfObject);
        if (mSlowQueryThreshold != -1)
        {
          if (localObject != null) {
            j = ((android.database.Cursor)localObject).getCount();
          }
          l = System.currentTimeMillis() - l;
          if (l >= mSlowQueryThreshold)
          {
            paramArrayOfObject = new StringBuilder();
            paramArrayOfObject.append("query (");
            paramArrayOfObject.append(l);
            paramArrayOfObject.append(" ms): ");
            paramArrayOfObject.append(paramString.toString());
            paramArrayOfObject.append(", args are <redacted>, count is ");
            paramArrayOfObject.append(j);
            Log.v("Database", paramArrayOfObject.toString());
          }
        }
        return new CrossProcessCursorWrapper((net.sqlcipher.Cursor)localObject);
      }
      finally
      {
        Object localObject;
        if (mSlowQueryThreshold != -1)
        {
          l = System.currentTimeMillis() - l;
          if (l >= mSlowQueryThreshold)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("query (");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(" ms): ");
            ((StringBuilder)localObject).append(paramString.toString());
            ((StringBuilder)localObject).append(", args are <redacted>, count is ");
            ((StringBuilder)localObject).append(-1);
            Log.v("Database", ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    throw new IllegalStateException("database not open");
  }
  
  public net.sqlcipher.Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null);
  }
  
  public net.sqlcipher.Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    paramString = (CursorWrapper)rawQueryWithFactory(null, paramString, paramArrayOfString, null);
    ((SQLiteCursor)paramString.getWrappedCursor()).setLoadStyle(paramInt1, paramInt2);
    return paramString;
  }
  
  public net.sqlcipher.Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (isOpen())
    {
      long l = 0L;
      int i = mSlowQueryThreshold;
      int j = -1;
      if (i != -1) {
        l = System.currentTimeMillis();
      }
      paramString1 = new SQLiteDirectCursorDriver(this, paramString1, paramString2);
      if (paramCursorFactory == null) {}
      try
      {
        paramCursorFactory = mFactory;
        paramCursorFactory = paramString1.query(paramCursorFactory, paramArrayOfString);
        if (mSlowQueryThreshold != -1)
        {
          if (paramCursorFactory != null) {
            j = paramCursorFactory.getCount();
          }
          l = System.currentTimeMillis() - l;
          if (l >= mSlowQueryThreshold)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("query (");
            paramArrayOfString.append(l);
            paramArrayOfString.append(" ms): ");
            paramArrayOfString.append(paramString1.toString());
            paramArrayOfString.append(", args are <redacted>, count is ");
            paramArrayOfString.append(j);
            Log.v("Database", paramArrayOfString.toString());
          }
        }
        return new CrossProcessCursorWrapper(paramCursorFactory);
      }
      finally
      {
        if (mSlowQueryThreshold != -1)
        {
          l = System.currentTimeMillis() - l;
          if (l >= mSlowQueryThreshold)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append("query (");
            paramArrayOfString.append(l);
            paramArrayOfString.append(" ms): ");
            paramArrayOfString.append(paramString1.toString());
            paramArrayOfString.append(", args are <redacted>, count is ");
            paramArrayOfString.append(-1);
            Log.v("Database", paramArrayOfString.toString());
          }
        }
      }
    }
    throw new IllegalStateException("database not open");
  }
  
  public void removeSQLiteClosable(SQLiteClosable paramSQLiteClosable)
  {
    lock();
    try
    {
      mPrograms.remove(paramSQLiteClosable);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      long l = insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
      return l;
    }
    catch (SQLException paramString1) {}
    return -1L;
  }
  
  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  public void resetCompiledSqlCache()
  {
    synchronized (mCompiledQueries)
    {
      mCompiledQueries.clear();
      return;
    }
  }
  
  public void rowUpdated(String paramString, long paramLong)
  {
    synchronized (mSyncUpdateInfo)
    {
      SyncUpdateInfo localSyncUpdateInfo = (SyncUpdateInfo)mSyncUpdateInfo.get(paramString);
      if (localSyncUpdateInfo != null)
      {
        ??? = a.a("UPDATE ");
        ((StringBuilder)???).append(masterTable);
        ((StringBuilder)???).append(" SET _sync_dirty=1 WHERE _id=(SELECT ");
        ((StringBuilder)???).append(foreignKey);
        ((StringBuilder)???).append(" FROM ");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(" WHERE _id=");
        ((StringBuilder)???).append(paramLong);
        ((StringBuilder)???).append(")");
        execSQL(((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void setForeignKeyConstraintsEnabled(boolean paramBoolean)
  {
    if (!inTransaction())
    {
      String str;
      if (paramBoolean) {
        str = "ON";
      } else {
        str = "OFF";
      }
      execSQL(String.format("PRAGMA foreign_keys = %s;", new Object[] { str }));
      return;
    }
    throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
  }
  
  public void setLocale(Locale paramLocale)
  {
    lock();
    try
    {
      native_setLocale(paramLocale.toString(), mFlags);
      return;
    }
    finally
    {
      unlock();
    }
  }
  
  public void setLockingEnabled(boolean paramBoolean)
  {
    mLockingEnabled = paramBoolean;
  }
  
  public void setMaxSqlCacheSize(int paramInt)
  {
    if ((paramInt <= 250) && (paramInt >= 0)) {}
    try
    {
      if (paramInt >= mMaxSqlCacheSize)
      {
        mMaxSqlCacheSize = paramInt;
        return;
      }
      localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
      throw localIllegalStateException;
    }
    finally {}
    IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
    localIllegalStateException.<init>("expected value between 0 and 250");
    throw localIllegalStateException;
  }
  
  public long setMaximumSize(long paramLong)
  {
    lock();
    Object localObject1 = null;
    try
    {
      if (isOpen())
      {
        long l1 = getPageSize();
        long l2 = paramLong / l1;
        long l3 = l2;
        if (paramLong % l1 != 0L) {
          l3 = l2 + 1L;
        }
        SQLiteStatement localSQLiteStatement = new net/sqlcipher/database/SQLiteStatement;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("PRAGMA max_page_count = ");
        localStringBuilder.append(l3);
        localSQLiteStatement.<init>(this, localStringBuilder.toString());
        try
        {
          paramLong = localSQLiteStatement.simpleQueryForLong();
          localSQLiteStatement.close();
          unlock();
          return paramLong * l1;
        }
        finally
        {
          localObject1 = localSQLiteStatement;
          break label133;
        }
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("database not open");
      throw localIllegalStateException;
    }
    finally
    {
      label133:
      if (localObject1 != null) {
        ((SQLiteProgram)localObject1).close();
      }
      unlock();
    }
  }
  
  public void setPageSize(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA page_size = ");
    localStringBuilder.append(paramLong);
    execSQL(localStringBuilder.toString());
  }
  
  public void setTransactionSuccessful()
  {
    if (isOpen())
    {
      if (mLock.isHeldByCurrentThread())
      {
        if (!mInnerTransactionIsSuccessful)
        {
          mInnerTransactionIsSuccessful = true;
          return;
        }
        throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
      }
      throw new IllegalStateException("no transaction pending");
    }
    throw new IllegalStateException("database not open");
  }
  
  public void setVersion(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PRAGMA user_version = ");
    localStringBuilder.append(paramInt);
    execSQL(localStringBuilder.toString());
  }
  
  public int status(int paramInt, boolean paramBoolean)
  {
    return native_status(paramInt, paramBoolean);
  }
  
  public void unlock()
  {
    if (!mLockingEnabled) {
      return;
    }
    if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) && (mLock.getHoldCount() == 1)) {
      checkLockHoldTime();
    }
    mLock.unlock();
  }
  
  public int update(String paramString1, int paramInt, ContentValues paramContentValues, String paramString2, Object[] paramArrayOfObject)
  {
    String[] arrayOfString = new String[paramArrayOfObject.length];
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      arrayOfString[i] = paramArrayOfObject[i].toString();
    }
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, arrayOfString, paramInt);
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return updateWithOnConflict(paramString1, paramContentValues, paramString2, paramArrayOfString, 0);
  }
  
  /* Error */
  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +476 -> 477
    //   4: aload_2
    //   5: invokevirtual 1118	android/content/ContentValues:size	()I
    //   8: ifeq +469 -> 477
    //   11: new 556	java/lang/StringBuilder
    //   14: dup
    //   15: bipush 120
    //   17: invokespecial 1111	java/lang/StringBuilder:<init>	(I)V
    //   20: astore 6
    //   22: aload 6
    //   24: ldc_w 1288
    //   27: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: getstatic 162	net/sqlcipher/database/SQLiteDatabase:CONFLICT_VALUES	[Ljava/lang/String;
    //   36: iload 5
    //   38: aaload
    //   39: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 6
    //   45: aload_1
    //   46: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: ldc_w 1345
    //   55: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 1121	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   63: astore 7
    //   65: aload 7
    //   67: invokeinterface 375 1 0
    //   72: astore_1
    //   73: aload_1
    //   74: invokeinterface 380 1 0
    //   79: ifeq +56 -> 135
    //   82: aload 6
    //   84: aload_1
    //   85: invokeinterface 384 1 0
    //   90: checkcast 386	java/util/Map$Entry
    //   93: invokeinterface 389 1 0
    //   98: checkcast 148	java/lang/String
    //   101: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: ldc_w 1347
    //   110: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: invokeinterface 380 1 0
    //   120: ifeq -47 -> 73
    //   123: aload 6
    //   125: ldc_w 1126
    //   128: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: goto -59 -> 73
    //   135: aload_3
    //   136: invokestatic 435	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +19 -> 158
    //   142: aload 6
    //   144: ldc_w 984
    //   147: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: aload_3
    //   154: invokevirtual 565	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aconst_null
    //   159: astore 8
    //   161: aconst_null
    //   162: astore 9
    //   164: aconst_null
    //   165: astore 10
    //   167: aload_0
    //   168: invokevirtual 795	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   171: aload 10
    //   173: astore_1
    //   174: aload 8
    //   176: astore_2
    //   177: aload 9
    //   179: astore_3
    //   180: aload_0
    //   181: invokevirtual 276	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   184: ifeq +216 -> 400
    //   187: aload 10
    //   189: astore_1
    //   190: aload 8
    //   192: astore_2
    //   193: aload 9
    //   195: astore_3
    //   196: aload_0
    //   197: aload 6
    //   199: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 979	net/sqlcipher/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteStatement;
    //   205: astore 10
    //   207: aload 10
    //   209: astore_1
    //   210: aload 10
    //   212: astore_2
    //   213: aload 10
    //   215: astore_3
    //   216: aload 7
    //   218: invokeinterface 1140 1 0
    //   223: istore 11
    //   225: aload 10
    //   227: astore_1
    //   228: aload 10
    //   230: astore_2
    //   231: aload 10
    //   233: astore_3
    //   234: aload 7
    //   236: invokeinterface 375 1 0
    //   241: astore 8
    //   243: iconst_0
    //   244: istore 12
    //   246: iconst_1
    //   247: istore 5
    //   249: iconst_0
    //   250: istore 13
    //   252: iload 13
    //   254: iload 11
    //   256: if_icmpge +43 -> 299
    //   259: aload 10
    //   261: astore_1
    //   262: aload 10
    //   264: astore_2
    //   265: aload 10
    //   267: astore_3
    //   268: aload 10
    //   270: iload 5
    //   272: aload 8
    //   274: invokeinterface 384 1 0
    //   279: checkcast 386	java/util/Map$Entry
    //   282: invokeinterface 1143 1 0
    //   287: invokestatic 990	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   290: iinc 5 1
    //   293: iinc 13 1
    //   296: goto -44 -> 252
    //   299: aload 4
    //   301: ifnull +58 -> 359
    //   304: aload 10
    //   306: astore_1
    //   307: aload 10
    //   309: astore_2
    //   310: aload 10
    //   312: astore_3
    //   313: aload 4
    //   315: arraylength
    //   316: istore 11
    //   318: iload 12
    //   320: istore 13
    //   322: iload 13
    //   324: iload 11
    //   326: if_icmpge +33 -> 359
    //   329: aload 10
    //   331: astore_1
    //   332: aload 10
    //   334: astore_2
    //   335: aload 10
    //   337: astore_3
    //   338: aload 10
    //   340: iload 5
    //   342: aload 4
    //   344: iload 13
    //   346: aaload
    //   347: invokevirtual 1351	net/sqlcipher/database/SQLiteProgram:bindString	(ILjava/lang/String;)V
    //   350: iinc 5 1
    //   353: iinc 13 1
    //   356: goto -34 -> 322
    //   359: aload 10
    //   361: astore_1
    //   362: aload 10
    //   364: astore_2
    //   365: aload 10
    //   367: astore_3
    //   368: aload 10
    //   370: invokevirtual 993	net/sqlcipher/database/SQLiteStatement:execute	()V
    //   373: aload 10
    //   375: astore_1
    //   376: aload 10
    //   378: astore_2
    //   379: aload 10
    //   381: astore_3
    //   382: aload_0
    //   383: invokevirtual 996	net/sqlcipher/database/SQLiteDatabase:lastChangeCount	()I
    //   386: istore 5
    //   388: aload 10
    //   390: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   393: aload_0
    //   394: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   397: iload 5
    //   399: ireturn
    //   400: aload 10
    //   402: astore_1
    //   403: aload 8
    //   405: astore_2
    //   406: aload 9
    //   408: astore_3
    //   409: new 284	java/lang/IllegalStateException
    //   412: astore 4
    //   414: aload 10
    //   416: astore_1
    //   417: aload 8
    //   419: astore_2
    //   420: aload 9
    //   422: astore_3
    //   423: aload 4
    //   425: ldc_w 330
    //   428: invokespecial 287	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   431: aload 10
    //   433: astore_1
    //   434: aload 8
    //   436: astore_2
    //   437: aload 9
    //   439: astore_3
    //   440: aload 4
    //   442: athrow
    //   443: astore_2
    //   444: goto +19 -> 463
    //   447: astore_3
    //   448: aload_2
    //   449: astore_1
    //   450: aload_3
    //   451: athrow
    //   452: astore_2
    //   453: aload_3
    //   454: astore_1
    //   455: aload_0
    //   456: invokevirtual 998	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   459: aload_3
    //   460: astore_1
    //   461: aload_2
    //   462: athrow
    //   463: aload_1
    //   464: ifnull +7 -> 471
    //   467: aload_1
    //   468: invokevirtual 629	net/sqlcipher/database/SQLiteProgram:close	()V
    //   471: aload_0
    //   472: invokevirtual 809	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   475: aload_2
    //   476: athrow
    //   477: new 238	java/lang/IllegalArgumentException
    //   480: dup
    //   481: ldc_w 1353
    //   484: invokespecial 243	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   487: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	SQLiteDatabase
    //   0	488	1	paramString1	String
    //   0	488	2	paramContentValues	ContentValues
    //   0	488	3	paramString2	String
    //   0	488	4	paramArrayOfString	String[]
    //   0	488	5	paramInt	int
    //   20	178	6	localStringBuilder	StringBuilder
    //   63	172	7	localSet	Set
    //   159	276	8	localIterator	Iterator
    //   162	276	9	localObject	Object
    //   165	267	10	localSQLiteStatement	SQLiteStatement
    //   223	104	11	i	int
    //   244	75	12	j	int
    //   250	104	13	k	int
    // Exception table:
    //   from	to	target	type
    //   180	187	443	finally
    //   196	207	443	finally
    //   216	225	443	finally
    //   234	243	443	finally
    //   268	290	443	finally
    //   313	318	443	finally
    //   338	350	443	finally
    //   368	373	443	finally
    //   382	388	443	finally
    //   409	414	443	finally
    //   423	431	443	finally
    //   440	443	443	finally
    //   450	452	443	finally
    //   455	459	443	finally
    //   461	463	443	finally
    //   180	187	447	net/sqlcipher/SQLException
    //   196	207	447	net/sqlcipher/SQLException
    //   216	225	447	net/sqlcipher/SQLException
    //   234	243	447	net/sqlcipher/SQLException
    //   268	290	447	net/sqlcipher/SQLException
    //   313	318	447	net/sqlcipher/SQLException
    //   338	350	447	net/sqlcipher/SQLException
    //   368	373	447	net/sqlcipher/SQLException
    //   382	388	447	net/sqlcipher/SQLException
    //   409	414	447	net/sqlcipher/SQLException
    //   423	431	447	net/sqlcipher/SQLException
    //   440	443	447	net/sqlcipher/SQLException
    //   180	187	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   196	207	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   216	225	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   234	243	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   268	290	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   313	318	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   338	350	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   368	373	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   382	388	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   409	414	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   423	431	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   440	443	452	net/sqlcipher/database/SQLiteDatabaseCorruptException
  }
  
  @Deprecated
  public boolean yieldIfContended()
  {
    if (!isOpen()) {
      return false;
    }
    return yieldIfContendedHelper(false, -1L);
  }
  
  public boolean yieldIfContendedSafely()
  {
    if (!isOpen()) {
      return false;
    }
    return yieldIfContendedHelper(true, -1L);
  }
  
  public boolean yieldIfContendedSafely(long paramLong)
  {
    if (!isOpen()) {
      return false;
    }
    return yieldIfContendedHelper(true, paramLong);
  }
  
  public static abstract interface CursorFactory
  {
    public abstract net.sqlcipher.Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery);
  }
  
  public static abstract interface LibraryLoader
  {
    public abstract void loadLibraries(String... paramVarArgs);
  }
  
  public static enum SQLiteDatabaseTransactionType
  {
    static
    {
      SQLiteDatabaseTransactionType localSQLiteDatabaseTransactionType = new SQLiteDatabaseTransactionType("Exclusive", 2);
      Exclusive = localSQLiteDatabaseTransactionType;
      $VALUES = new SQLiteDatabaseTransactionType[] { Deferred, Immediate, localSQLiteDatabaseTransactionType };
    }
    
    public SQLiteDatabaseTransactionType() {}
  }
  
  public static class SyncUpdateInfo
  {
    public String deletedTable;
    public String foreignKey;
    public String masterTable;
    
    public SyncUpdateInfo(String paramString1, String paramString2, String paramString3)
    {
      masterTable = paramString1;
      deletedTable = paramString2;
      foreignKey = paramString3;
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */