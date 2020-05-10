package net.sqlcipher.database;

import android.os.SystemClock;
import d.w.a.f;
import e.a.a.a.a;

public class SQLiteStatement
  extends SQLiteProgram
  implements f
{
  public SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    super(paramSQLiteDatabase, paramString);
  }
  
  private final native long native_1x1_long();
  
  private final native String native_1x1_string();
  
  private final native void native_execute();
  
  public void execute()
  {
    if (mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        return;
      }
      finally
      {
        releaseReference();
        mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = a.a("database ");
    localStringBuilder.append(mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long executeInsert()
  {
    if (mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        long l;
        if (mDatabase.lastChangeCount() > 0) {
          l = mDatabase.lastInsertRow();
        } else {
          l = -1L;
        }
        return l;
      }
      finally
      {
        releaseReference();
        mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = a.a("database ");
    localStringBuilder.append(mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int executeUpdateDelete()
  {
    if (mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      mDatabase.lock();
      acquireReference();
      try
      {
        native_execute();
        int i = mDatabase.lastChangeCount();
        return i;
      }
      finally
      {
        releaseReference();
        mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = a.a("database ");
    localStringBuilder.append(mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public long simpleQueryForLong()
  {
    if (mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      mDatabase.lock();
      acquireReference();
      try
      {
        long l = native_1x1_long();
        return l;
      }
      finally
      {
        releaseReference();
        mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = a.a("database ");
    localStringBuilder.append(mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String simpleQueryForString()
  {
    if (mDatabase.isOpen())
    {
      SystemClock.uptimeMillis();
      mDatabase.lock();
      acquireReference();
      try
      {
        String str = native_1x1_string();
        return str;
      }
      finally
      {
        releaseReference();
        mDatabase.unlock();
      }
    }
    StringBuilder localStringBuilder = a.a("database ");
    localStringBuilder.append(mDatabase.getPath());
    localStringBuilder.append(" already closed");
    throw new IllegalStateException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteStatement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */