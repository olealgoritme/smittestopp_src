package net.sqlcipher;

import android.content.ContentValues;
import android.database.Cursor;
import e.a.a.a.a;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class DatabaseUtils$InsertHelper
{
  public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
  public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
  public HashMap<String, Integer> mColumns;
  public final SQLiteDatabase mDb;
  public String mInsertSQL = null;
  public SQLiteStatement mInsertStatement = null;
  public SQLiteStatement mPreparedStatement = null;
  public SQLiteStatement mReplaceStatement = null;
  public final String mTableName;
  
  public DatabaseUtils$InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    mDb = paramSQLiteDatabase;
    mTableName = paramString;
  }
  
  private void buildSQL()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    localStringBuilder1.append("INSERT INTO ");
    localStringBuilder1.append(mTableName);
    localStringBuilder1.append(" (");
    StringBuilder localStringBuilder2 = new StringBuilder(128);
    localStringBuilder2.append("VALUES (");
    Object localObject1 = null;
    Object localObject3 = localObject1;
    try
    {
      Object localObject4 = mDb;
      localObject3 = localObject1;
      Object localObject5 = new java/lang/StringBuilder;
      localObject3 = localObject1;
      ((StringBuilder)localObject5).<init>();
      localObject3 = localObject1;
      ((StringBuilder)localObject5).append("PRAGMA table_info(");
      localObject3 = localObject1;
      ((StringBuilder)localObject5).append(mTableName);
      localObject3 = localObject1;
      ((StringBuilder)localObject5).append(")");
      localObject3 = localObject1;
      localObject4 = ((SQLiteDatabase)localObject4).rawQuery(((StringBuilder)localObject5).toString(), null);
      localObject3 = localObject4;
      localObject1 = new java/util/HashMap;
      localObject3 = localObject4;
      ((HashMap)localObject1).<init>(((Cursor)localObject4).getCount());
      localObject3 = localObject4;
      mColumns = ((HashMap)localObject1);
      for (int i = 1;; i++)
      {
        localObject3 = localObject4;
        if (!((Cursor)localObject4).moveToNext()) {
          break;
        }
        localObject3 = localObject4;
        localObject1 = ((Cursor)localObject4).getString(1);
        localObject3 = localObject4;
        localObject5 = ((Cursor)localObject4).getString(4);
        localObject3 = localObject4;
        mColumns.put(localObject1, Integer.valueOf(i));
        localObject3 = localObject4;
        localStringBuilder1.append("'");
        localObject3 = localObject4;
        localStringBuilder1.append((String)localObject1);
        localObject3 = localObject4;
        localStringBuilder1.append("'");
        if (localObject5 == null)
        {
          localObject3 = localObject4;
          localStringBuilder2.append("?");
        }
        else
        {
          localObject3 = localObject4;
          localStringBuilder2.append("COALESCE(?, ");
          localObject3 = localObject4;
          localStringBuilder2.append((String)localObject5);
          localObject3 = localObject4;
          localStringBuilder2.append(")");
        }
        localObject3 = localObject4;
        int j = ((Cursor)localObject4).getCount();
        localObject5 = ", ";
        if (i == j) {
          localObject1 = ") ";
        } else {
          localObject1 = ", ";
        }
        localObject3 = localObject4;
        localStringBuilder1.append((String)localObject1);
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (i == ((Cursor)localObject4).getCount()) {
          localObject1 = ");";
        }
        localObject3 = localObject4;
        localStringBuilder2.append((String)localObject1);
      }
      ((Cursor)localObject4).close();
      localStringBuilder1.append(localStringBuilder2);
      mInsertSQL = localStringBuilder1.toString();
      return;
    }
    finally
    {
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
    }
  }
  
  private SQLiteStatement getStatement(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (mReplaceStatement == null)
      {
        if (mInsertSQL == null) {
          buildSQL();
        }
        Object localObject = a.a("INSERT OR REPLACE");
        ((StringBuilder)localObject).append(mInsertSQL.substring(6));
        localObject = ((StringBuilder)localObject).toString();
        mReplaceStatement = mDb.compileStatement((String)localObject);
      }
      return mReplaceStatement;
    }
    if (mInsertStatement == null)
    {
      if (mInsertSQL == null) {
        buildSQL();
      }
      mInsertStatement = mDb.compileStatement(mInsertSQL);
    }
    return mInsertStatement;
  }
  
  /* Error */
  private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: invokespecial 146	net/sqlcipher/DatabaseUtils$InsertHelper:getStatement	(Z)Lnet/sqlcipher/database/SQLiteStatement;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 151	net/sqlcipher/database/SQLiteProgram:clearBindings	()V
    //   12: aload_1
    //   13: invokevirtual 157	android/content/ContentValues:valueSet	()Ljava/util/Set;
    //   16: invokeinterface 163 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 168 1 0
    //   30: ifeq +43 -> 73
    //   33: aload 4
    //   35: invokeinterface 172 1 0
    //   40: checkcast 174	java/util/Map$Entry
    //   43: astore 5
    //   45: aload_3
    //   46: aload_0
    //   47: aload 5
    //   49: invokeinterface 177 1 0
    //   54: checkcast 133	java/lang/String
    //   57: invokevirtual 181	net/sqlcipher/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
    //   60: aload 5
    //   62: invokeinterface 184 1 0
    //   67: invokestatic 188	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
    //   70: goto -47 -> 23
    //   73: aload_3
    //   74: invokevirtual 194	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
    //   77: lstore 6
    //   79: aload_0
    //   80: monitorexit
    //   81: lload 6
    //   83: lreturn
    //   84: astore_1
    //   85: goto +67 -> 152
    //   88: astore 4
    //   90: new 45	java/lang/StringBuilder
    //   93: astore 5
    //   95: aload 5
    //   97: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   100: aload 5
    //   102: ldc -60
    //   104: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 5
    //   117: ldc -55
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 5
    //   125: aload_0
    //   126: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
    //   129: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc -53
    //   135: aload 5
    //   137: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: aload 4
    //   142: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: aload_0
    //   147: monitorexit
    //   148: ldc2_w 210
    //   151: lreturn
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	InsertHelper
    //   0	156	1	paramContentValues	ContentValues
    //   0	156	2	paramBoolean	boolean
    //   7	67	3	localSQLiteStatement	SQLiteStatement
    //   21	13	4	localIterator	java.util.Iterator
    //   88	53	4	localSQLException	SQLException
    //   43	93	5	localObject	Object
    //   77	5	6	l	long
    // Exception table:
    //   from	to	target	type
    //   2	23	84	finally
    //   23	70	84	finally
    //   73	79	84	finally
    //   90	146	84	finally
    //   2	23	88	net/sqlcipher/SQLException
    //   23	70	88	net/sqlcipher/SQLException
    //   73	79	88	net/sqlcipher/SQLException
  }
  
  public void bind(int paramInt, double paramDouble)
  {
    mPreparedStatement.bindDouble(paramInt, paramDouble);
  }
  
  public void bind(int paramInt, float paramFloat)
  {
    mPreparedStatement.bindDouble(paramInt, paramFloat);
  }
  
  public void bind(int paramInt1, int paramInt2)
  {
    mPreparedStatement.bindLong(paramInt1, paramInt2);
  }
  
  public void bind(int paramInt, long paramLong)
  {
    mPreparedStatement.bindLong(paramInt, paramLong);
  }
  
  public void bind(int paramInt, String paramString)
  {
    if (paramString == null) {
      mPreparedStatement.bindNull(paramInt);
    } else {
      mPreparedStatement.bindString(paramInt, paramString);
    }
  }
  
  public void bind(int paramInt, boolean paramBoolean)
  {
    SQLiteStatement localSQLiteStatement = mPreparedStatement;
    long l;
    if (paramBoolean) {
      l = 1L;
    } else {
      l = 0L;
    }
    localSQLiteStatement.bindLong(paramInt, l);
  }
  
  public void bind(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      mPreparedStatement.bindNull(paramInt);
    } else {
      mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
    }
  }
  
  public void bindNull(int paramInt)
  {
    mPreparedStatement.bindNull(paramInt);
  }
  
  public void close()
  {
    SQLiteStatement localSQLiteStatement = mInsertStatement;
    if (localSQLiteStatement != null)
    {
      localSQLiteStatement.close();
      mInsertStatement = null;
    }
    localSQLiteStatement = mReplaceStatement;
    if (localSQLiteStatement != null)
    {
      localSQLiteStatement.close();
      mReplaceStatement = null;
    }
    mInsertSQL = null;
    mColumns = null;
  }
  
  /* Error */
  public long execute()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +76 -> 82
    //   9: aload_1
    //   10: invokevirtual 194	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
    //   13: lstore_2
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
    //   19: lload_2
    //   20: lreturn
    //   21: astore_1
    //   22: goto +53 -> 75
    //   25: astore_1
    //   26: new 45	java/lang/StringBuilder
    //   29: astore 4
    //   31: aload 4
    //   33: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   36: aload 4
    //   38: ldc -18
    //   40: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: aload_0
    //   47: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
    //   50: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc -53
    //   56: aload 4
    //   58: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: aload_1
    //   62: invokestatic 209	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   65: pop
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
    //   71: ldc2_w 210
    //   74: lreturn
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 37	net/sqlcipher/DatabaseUtils$InsertHelper:mPreparedStatement	Lnet/sqlcipher/database/SQLiteStatement;
    //   80: aload_1
    //   81: athrow
    //   82: new 240	java/lang/IllegalStateException
    //   85: dup
    //   86: ldc -14
    //   88: invokespecial 245	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	InsertHelper
    //   4	6	1	localSQLiteStatement	SQLiteStatement
    //   21	1	1	localObject	Object
    //   25	56	1	localSQLException	SQLException
    //   13	7	2	l	long
    //   29	28	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	14	21	finally
    //   26	66	21	finally
    //   9	14	25	net/sqlcipher/SQLException
  }
  
  public int getColumnIndex(String paramString)
  {
    getStatement(false);
    Integer localInteger = (Integer)mColumns.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalArgumentException(a.a("column '", paramString, "' is invalid"));
  }
  
  public long insert(ContentValues paramContentValues)
  {
    return insertInternal(paramContentValues, false);
  }
  
  public void prepareForInsert()
  {
    SQLiteStatement localSQLiteStatement = getStatement(false);
    mPreparedStatement = localSQLiteStatement;
    localSQLiteStatement.clearBindings();
  }
  
  public void prepareForReplace()
  {
    SQLiteStatement localSQLiteStatement = getStatement(true);
    mPreparedStatement = localSQLiteStatement;
    localSQLiteStatement.clearBindings();
  }
  
  public long replace(ContentValues paramContentValues)
  {
    return insertInternal(paramContentValues, true);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.DatabaseUtils.InsertHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */