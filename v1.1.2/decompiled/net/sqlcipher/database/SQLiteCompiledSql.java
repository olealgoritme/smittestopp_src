package net.sqlcipher.database;

import android.util.Log;
import e.a.a.a.a;

public class SQLiteCompiledSql
{
  public static final String TAG = "SQLiteCompiledSql";
  public SQLiteDatabase mDatabase;
  public boolean mInUse = false;
  public String mSqlStmt = null;
  public Throwable mStackTrace = null;
  public long nHandle = 0L;
  public long nStatement = 0L;
  
  public SQLiteCompiledSql(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (paramSQLiteDatabase.isOpen())
    {
      mDatabase = paramSQLiteDatabase;
      mSqlStmt = paramString;
      mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      nHandle = mNativeHandle;
      compile(paramString, true);
      return;
    }
    paramString = a.a("database ");
    paramString.append(paramSQLiteDatabase.getPath());
    paramString.append(" already closed");
    throw new IllegalStateException(paramString.toString());
  }
  
  private void compile(String paramString, boolean paramBoolean)
  {
    if (mDatabase.isOpen())
    {
      if (paramBoolean) {
        mDatabase.lock();
      }
      try
      {
        native_compile(paramString);
        mDatabase.unlock();
      }
      finally
      {
        mDatabase.unlock();
      }
    }
    paramString = a.a("database ");
    paramString.append(mDatabase.getPath());
    paramString.append(" already closed");
    throw new IllegalStateException(paramString.toString());
  }
  
  private final native void native_compile(String paramString);
  
  private final native void native_finalize();
  
  public boolean acquire()
  {
    try
    {
      boolean bool = mInUse;
      if (bool) {
        return false;
      }
      mInUse = true;
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Acquired DbObj (id#");
        localStringBuilder.append(nStatement);
        localStringBuilder.append(") from DB cache");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      return true;
    }
    finally {}
  }
  
  public void finalize()
  {
    try
    {
      long l = nStatement;
      if (l == 0L) {
        return;
      }
      boolean bool = SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;
      if (bool)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("** warning ** Finalized DbObj (id#");
        ((StringBuilder)localObject1).append(nStatement);
        ((StringBuilder)localObject1).append(")");
        Log.v("SQLiteCompiledSql", ((StringBuilder)localObject1).toString());
      }
      int i = mSqlStmt.length();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: ");
      Object localObject1 = mSqlStmt;
      int j = i;
      if (i > 100) {
        j = 100;
      }
      localStringBuilder.append(((String)localObject1).substring(0, j));
      Log.w("SQLiteCompiledSql", localStringBuilder.toString(), mStackTrace);
      releaseSqlStatement();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void release()
  {
    try
    {
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Released DbObj (id#");
        localStringBuilder.append(nStatement);
        localStringBuilder.append(") back to DB cache");
        Log.v("SQLiteCompiledSql", localStringBuilder.toString());
      }
      mInUse = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void releaseSqlStatement()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifeq +77 -> 83
    //   9: getstatic 101	net/sqlcipher/database/SQLiteDebug:DEBUG_ACTIVE_CURSOR_FINALIZATION	Z
    //   12: ifeq +35 -> 47
    //   15: ldc -108
    //   17: invokestatic 65	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	J
    //   26: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: ldc 122
    //   33: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 8
    //   39: aload_1
    //   40: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 115	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: getfield 41	net/sqlcipher/database/SQLiteCompiledSql:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   51: invokevirtual 88	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   54: aload_0
    //   55: invokespecial 150	net/sqlcipher/database/SQLiteCompiledSql:native_finalize	()V
    //   58: aload_0
    //   59: lconst_0
    //   60: putfield 27	net/sqlcipher/database/SQLiteCompiledSql:nStatement	J
    //   63: aload_0
    //   64: getfield 41	net/sqlcipher/database/SQLiteCompiledSql:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   67: invokevirtual 94	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   70: goto +13 -> 83
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 41	net/sqlcipher/database/SQLiteCompiledSql:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   78: invokevirtual 94	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   81: aload_1
    //   82: athrow
    //   83: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	SQLiteCompiledSql
    //   20	20	1	localStringBuilder	StringBuilder
    //   73	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	73	finally
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteCompiledSql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */