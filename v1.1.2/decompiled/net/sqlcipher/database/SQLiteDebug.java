package net.sqlcipher.database;

import android.util.Log;
import java.util.ArrayList;

public final class SQLiteDebug
{
  public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION = Log.isLoggable("SQLiteCursorClosing", 2);
  public static final boolean DEBUG_LOCK_TIME_TRACKING = Log.isLoggable("SQLiteLockTime", 2);
  public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE = Log.isLoggable("SQLiteLockStackTrace", 2);
  public static final boolean DEBUG_SQL_CACHE;
  public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
  public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
  public static int sNumActiveCursorsFinalized = 0;
  
  static
  {
    DEBUG_SQL_CACHE = Log.isLoggable("SQLiteCompiledSql", 2);
  }
  
  public static PagerStats getDatabaseInfo()
  {
    PagerStats localPagerStats = new PagerStats();
    getPagerStats(localPagerStats);
    dbStats = SQLiteDatabase.getDbStats();
    return localPagerStats;
  }
  
  public static native long getHeapAllocatedSize();
  
  public static native void getHeapDirtyPages(int[] paramArrayOfInt);
  
  public static native long getHeapFreeSize();
  
  public static native long getHeapSize();
  
  public static int getNumActiveCursorsFinalized()
  {
    return sNumActiveCursorsFinalized;
  }
  
  public static native void getPagerStats(PagerStats paramPagerStats);
  
  public static void notifyActiveCursorFinalized()
  {
    try
    {
      sNumActiveCursorsFinalized += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class DbStats
  {
    public String dbName;
    public long dbSize;
    public int lookaside;
    public long pageSize;
    
    public DbStats(String paramString, long paramLong1, long paramLong2, int paramInt)
    {
      dbName = paramString;
      pageSize = paramLong2;
      dbSize = (paramLong1 * paramLong2 / 1024L);
      lookaside = paramInt;
    }
  }
  
  public static class PagerStats
  {
    @Deprecated
    public long databaseBytes;
    public ArrayList<SQLiteDebug.DbStats> dbStats;
    public int largestMemAlloc;
    public int memoryUsed;
    @Deprecated
    public int numPagers;
    public int pageCacheOverflo;
    @Deprecated
    public long referencedBytes;
    @Deprecated
    public long totalBytes;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDebug
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */