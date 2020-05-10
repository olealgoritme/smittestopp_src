package net.sqlcipher.database;

import android.util.Log;
import d.w.a.d;
import e.a.a.a.a;
import java.util.Map;

public abstract class SQLiteProgram
  extends SQLiteClosable
  implements d
{
  public static final String TAG = "SQLiteProgram";
  public boolean mClosed = false;
  public SQLiteCompiledSql mCompiledSql;
  @Deprecated
  public SQLiteDatabase mDatabase;
  public final String mSql;
  @Deprecated
  public long nHandle = 0L;
  @Deprecated
  public long nStatement = 0L;
  
  public SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    mDatabase = paramSQLiteDatabase;
    mSql = paramString.trim();
    paramSQLiteDatabase.acquireReference();
    paramSQLiteDatabase.addSQLiteClosable(this);
    nHandle = mNativeHandle;
    if (mSql.length() >= 6) {
      localObject = mSql.substring(0, 6);
    } else {
      localObject = mSql;
    }
    if ((!((String)localObject).equalsIgnoreCase("INSERT")) && (!((String)localObject).equalsIgnoreCase("UPDATE")) && (!((String)localObject).equalsIgnoreCase("REPLAC")) && (!((String)localObject).equalsIgnoreCase("DELETE")) && (!((String)localObject).equalsIgnoreCase("SELECT")))
    {
      paramSQLiteDatabase = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      mCompiledSql = paramSQLiteDatabase;
      nStatement = nStatement;
      return;
    }
    Object localObject = paramSQLiteDatabase.getCompiledStatementForSql(paramString);
    mCompiledSql = ((SQLiteCompiledSql)localObject);
    if (localObject == null)
    {
      localObject = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      mCompiledSql = ((SQLiteCompiledSql)localObject);
      ((SQLiteCompiledSql)localObject).acquire();
      paramSQLiteDatabase.addToCompiledQueries(paramString, mCompiledSql);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = a.a("Created DbObj (id#");
        paramSQLiteDatabase.append(mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") for sql: ");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    else if (!((SQLiteCompiledSql)localObject).acquire())
    {
      long l = mCompiledSql.nStatement;
      mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = a.a("** possible bug ** Created NEW DbObj (id#");
        paramSQLiteDatabase.append(mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") because the previously created DbObj (id#");
        paramSQLiteDatabase.append(l);
        paramSQLiteDatabase.append(") was not released for sql:");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    nStatement = mCompiledSql.nStatement;
  }
  
  private final native void native_clear_bindings();
  
  private void releaseCompiledSqlIfNotInCache()
  {
    if (mCompiledSql == null) {
      return;
    }
    synchronized (mDatabase.mCompiledQueries)
    {
      if (!mDatabase.mCompiledQueries.containsValue(mCompiledSql))
      {
        mCompiledSql.releaseSqlStatement();
        mCompiledSql = null;
        nStatement = 0L;
      }
      else
      {
        mCompiledSql.release();
      }
      return;
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (!mClosed)
      {
        if (mDatabase.isOpen())
        {
          acquireReference();
          try
          {
            native_bind_blob(paramInt, paramArrayOfByte);
            return;
          }
          finally
          {
            releaseReference();
          }
        }
        paramArrayOfByte = a.a("database ");
        paramArrayOfByte.append(mDatabase.getPath());
        paramArrayOfByte.append(" already closed");
        throw new IllegalStateException(paramArrayOfByte.toString());
      }
      throw new IllegalStateException("program already closed");
    }
    throw new IllegalArgumentException(a.b("the bind value at index ", paramInt, " is null"));
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    if (!mClosed)
    {
      if (mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_double(paramInt, paramDouble);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = a.a("database ");
      localStringBuilder.append(mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    if (!mClosed)
    {
      if (mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_long(paramInt, paramLong);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = a.a("database ");
      localStringBuilder.append(mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindNull(int paramInt)
  {
    if (!mClosed)
    {
      if (mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_bind_null(paramInt);
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = a.a("database ");
      localStringBuilder.append(mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void bindString(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (!mClosed)
      {
        if (mDatabase.isOpen())
        {
          acquireReference();
          try
          {
            native_bind_string(paramInt, paramString);
            return;
          }
          finally
          {
            releaseReference();
          }
        }
        paramString = a.a("database ");
        paramString.append(mDatabase.getPath());
        paramString.append(" already closed");
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException("program already closed");
    }
    throw new IllegalArgumentException(a.b("the bind value at index ", paramInt, " is null"));
  }
  
  public void clearBindings()
  {
    if (!mClosed)
    {
      if (mDatabase.isOpen())
      {
        acquireReference();
        try
        {
          native_clear_bindings();
          return;
        }
        finally
        {
          releaseReference();
        }
      }
      StringBuilder localStringBuilder = a.a("database ");
      localStringBuilder.append(mDatabase.getPath());
      localStringBuilder.append(" already closed");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("program already closed");
  }
  
  public void close()
  {
    if (mClosed) {
      return;
    }
    if (!mDatabase.isOpen()) {
      return;
    }
    mDatabase.lock();
    try
    {
      releaseReference();
      mDatabase.unlock();
      mClosed = true;
      return;
    }
    finally
    {
      mDatabase.unlock();
    }
  }
  
  @Deprecated
  public void compile(String paramString, boolean paramBoolean) {}
  
  public String getSqlString()
  {
    return mSql;
  }
  
  public final long getUniqueId()
  {
    return nStatement;
  }
  
  public final native void native_bind_blob(int paramInt, byte[] paramArrayOfByte);
  
  public final native void native_bind_double(int paramInt, double paramDouble);
  
  public final native void native_bind_long(int paramInt, long paramLong);
  
  public final native void native_bind_null(int paramInt);
  
  public final native void native_bind_string(int paramInt, String paramString);
  
  @Deprecated
  public final native void native_compile(String paramString);
  
  @Deprecated
  public final native void native_finalize();
  
  public void onAllReferencesReleased()
  {
    releaseCompiledSqlIfNotInCache();
    mDatabase.releaseReference();
    mDatabase.removeSQLiteClosable(this);
  }
  
  public void onAllReferencesReleasedFromContainer()
  {
    releaseCompiledSqlIfNotInCache();
    mDatabase.releaseReference();
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteProgram
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */