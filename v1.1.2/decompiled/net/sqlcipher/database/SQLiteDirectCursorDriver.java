package net.sqlcipher.database;

import e.a.a.a.a;

public class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  public net.sqlcipher.Cursor mCursor;
  public SQLiteDatabase mDatabase;
  public String mEditTable;
  public SQLiteQuery mQuery;
  public String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    mDatabase = paramSQLiteDatabase;
    mEditTable = paramString2;
    mSql = paramString1;
  }
  
  public void cursorClosed()
  {
    mCursor = null;
  }
  
  public void cursorDeactivated() {}
  
  public void cursorRequeried(android.database.Cursor paramCursor) {}
  
  public net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject)
  {
    SQLiteQuery localSQLiteQuery1 = new SQLiteQuery(mDatabase, mSql, 0, paramArrayOfObject);
    SQLiteQuery localSQLiteQuery2 = localSQLiteQuery1;
    try
    {
      localSQLiteQuery1.bindArguments(paramArrayOfObject);
      if (paramCursorFactory == null)
      {
        localSQLiteQuery2 = localSQLiteQuery1;
        paramCursorFactory = new net/sqlcipher/database/SQLiteCursor;
        localSQLiteQuery2 = localSQLiteQuery1;
        paramCursorFactory.<init>(mDatabase, this, mEditTable, localSQLiteQuery1);
        localSQLiteQuery2 = localSQLiteQuery1;
        mCursor = paramCursorFactory;
      }
      else
      {
        localSQLiteQuery2 = localSQLiteQuery1;
        mCursor = paramCursorFactory.newCursor(mDatabase, this, mEditTable, localSQLiteQuery1);
      }
      localSQLiteQuery2 = localSQLiteQuery1;
      mQuery = localSQLiteQuery1;
      localSQLiteQuery2 = null;
      paramCursorFactory = mCursor;
      return paramCursorFactory;
    }
    finally
    {
      if (localSQLiteQuery2 != null) {
        localSQLiteQuery2.close();
      }
    }
  }
  
  public net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    Object localObject1 = mDatabase;
    Object localObject2 = mSql;
    int i = 0;
    localObject1 = new SQLiteQuery((SQLiteDatabase)localObject1, (String)localObject2, 0, paramArrayOfString);
    int j;
    if (paramArrayOfString == null) {
      j = 0;
    } else {
      localObject2 = localObject1;
    }
    try
    {
      j = paramArrayOfString.length;
      while (i < j)
      {
        int k = i + 1;
        localObject2 = localObject1;
        ((SQLiteQuery)localObject1).bindString(k, paramArrayOfString[i]);
        i = k;
      }
      if (paramCursorFactory == null)
      {
        localObject2 = localObject1;
        paramCursorFactory = new net/sqlcipher/database/SQLiteCursor;
        localObject2 = localObject1;
        paramCursorFactory.<init>(mDatabase, this, mEditTable, (SQLiteQuery)localObject1);
        localObject2 = localObject1;
        mCursor = paramCursorFactory;
      }
      else
      {
        localObject2 = localObject1;
        mCursor = paramCursorFactory.newCursor(mDatabase, this, mEditTable, (SQLiteQuery)localObject1);
      }
      localObject2 = localObject1;
      mQuery = ((SQLiteQuery)localObject1);
      localObject2 = null;
      paramCursorFactory = mCursor;
      return paramCursorFactory;
    }
    finally
    {
      if (localObject2 != null) {
        ((SQLiteProgram)localObject2).close();
      }
    }
  }
  
  public void setBindArguments(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int k;
    for (int j = 0; j < i; j = k)
    {
      SQLiteQuery localSQLiteQuery = mQuery;
      k = j + 1;
      localSQLiteQuery.bindString(k, paramArrayOfString[j]);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("SQLiteDirectCursorDriver: ");
    localStringBuilder.append(mSql);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDirectCursorDriver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */