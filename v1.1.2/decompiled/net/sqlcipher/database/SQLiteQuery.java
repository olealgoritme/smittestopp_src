package net.sqlcipher.database;

import e.a.a.a.a;
import net.sqlcipher.CursorWindow;

public class SQLiteQuery
  extends SQLiteProgram
{
  public static final String TAG = "Cursor";
  public String[] mBindArgs;
  public Object[] mObjectBindArgs;
  public int mOffsetIndex;
  
  public SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString);
    mOffsetIndex = paramInt;
    mObjectBindArgs = paramArrayOfObject;
    if (paramArrayOfObject != null) {
      paramInt = paramArrayOfObject.length;
    } else {
      paramInt = 0;
    }
    mBindArgs = new String[paramInt];
  }
  
  public SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, String[] paramArrayOfString)
  {
    super(paramSQLiteDatabase, paramString);
    mOffsetIndex = paramInt;
    mBindArgs = paramArrayOfString;
  }
  
  private final native int native_column_count();
  
  private final native String native_column_name(int paramInt);
  
  private final native int native_fill_window(CursorWindow paramCursorWindow, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public void bindArguments(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      for (int i = 0; i < paramArrayOfObject.length; i++)
      {
        Object localObject = paramArrayOfObject[i];
        if (localObject == null)
        {
          bindNull(i + 1);
        }
        else if ((localObject instanceof Double))
        {
          bindDouble(i + 1, ((Double)localObject).doubleValue());
        }
        else if ((localObject instanceof Float))
        {
          bindDouble(i + 1, Double.valueOf(((Number)localObject).floatValue()).doubleValue());
        }
        else if ((localObject instanceof Long))
        {
          bindLong(i + 1, ((Long)localObject).longValue());
        }
        else if ((localObject instanceof Integer))
        {
          bindLong(i + 1, Long.valueOf(((Number)localObject).intValue()).longValue());
        }
        else if ((localObject instanceof Boolean))
        {
          long l;
          if (((Boolean)localObject).booleanValue()) {
            l = 1L;
          } else {
            l = 0L;
          }
          bindLong(i + 1, l);
        }
        else if ((localObject instanceof byte[]))
        {
          bindBlob(i + 1, (byte[])localObject);
        }
        else
        {
          bindString(i + 1, localObject.toString());
        }
      }
    }
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    mBindArgs[(paramInt - 1)] = Double.toString(paramDouble);
    if (!mClosed) {
      super.bindDouble(paramInt, paramDouble);
    }
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    mBindArgs[(paramInt - 1)] = Long.toString(paramLong);
    if (!mClosed) {
      super.bindLong(paramInt, paramLong);
    }
  }
  
  public void bindNull(int paramInt)
  {
    mBindArgs[(paramInt - 1)] = null;
    if (!mClosed) {
      super.bindNull(paramInt);
    }
  }
  
  public void bindString(int paramInt, String paramString)
  {
    mBindArgs[(paramInt - 1)] = paramString;
    if (!mClosed) {
      super.bindString(paramInt, paramString);
    }
  }
  
  public int columnCountLocked()
  {
    acquireReference();
    try
    {
      int i = native_column_count();
      return i;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public String columnNameLocked(int paramInt)
  {
    acquireReference();
    try
    {
      String str = native_column_name(paramInt);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  /* Error */
  public int fillWindow(CursorWindow paramCursorWindow, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 143	android/os/SystemClock:uptimeMillis	()J
    //   3: pop2
    //   4: aload_0
    //   5: getfield 147	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   8: invokevirtual 152	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   11: aload_0
    //   12: invokevirtual 124	net/sqlcipher/database/SQLiteClosable:acquireReference	()V
    //   15: aload_1
    //   16: invokevirtual 155	android/database/CursorWindow:acquireReference	()V
    //   19: aload_0
    //   20: aload_1
    //   21: aload_1
    //   22: invokevirtual 160	net/sqlcipher/CursorWindow:getStartPosition	()I
    //   25: aload_1
    //   26: invokevirtual 163	net/sqlcipher/CursorWindow:getRequiredPosition	()I
    //   29: aload_0
    //   30: getfield 21	net/sqlcipher/database/SQLiteQuery:mOffsetIndex	I
    //   33: iload_2
    //   34: iload_3
    //   35: invokespecial 165	net/sqlcipher/database/SQLiteQuery:native_fill_window	(Lnet/sqlcipher/CursorWindow;IIIII)I
    //   38: istore_3
    //   39: iload_3
    //   40: istore_2
    //   41: getstatic 170	net/sqlcipher/database/SQLiteDebug:DEBUG_SQL_STATEMENTS	Z
    //   44: ifeq +44 -> 88
    //   47: new 172	java/lang/StringBuilder
    //   50: astore 4
    //   52: aload 4
    //   54: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   57: aload 4
    //   59: ldc -80
    //   61: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: aload_0
    //   68: getfield 183	net/sqlcipher/database/SQLiteProgram:mSql	Ljava/lang/String;
    //   71: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: ldc 8
    //   77: aload 4
    //   79: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 190	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: iload_3
    //   87: istore_2
    //   88: aload_1
    //   89: invokevirtual 191	android/database/CursorWindow:releaseReference	()V
    //   92: aload_0
    //   93: invokevirtual 129	net/sqlcipher/database/SQLiteClosable:releaseReference	()V
    //   96: aload_0
    //   97: getfield 147	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   100: invokevirtual 194	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   103: iload_2
    //   104: ireturn
    //   105: astore 4
    //   107: goto +15 -> 122
    //   110: astore 4
    //   112: aload_0
    //   113: getfield 147	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   116: invokevirtual 197	net/sqlcipher/database/SQLiteDatabase:onCorruption	()V
    //   119: aload 4
    //   121: athrow
    //   122: aload_1
    //   123: invokevirtual 191	android/database/CursorWindow:releaseReference	()V
    //   126: aload 4
    //   128: athrow
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: goto -45 -> 88
    //   136: astore_1
    //   137: aload_0
    //   138: invokevirtual 129	net/sqlcipher/database/SQLiteClosable:releaseReference	()V
    //   141: aload_0
    //   142: getfield 147	net/sqlcipher/database/SQLiteProgram:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   145: invokevirtual 194	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	SQLiteQuery
    //   0	150	1	paramCursorWindow	CursorWindow
    //   0	150	2	paramInt1	int
    //   0	150	3	paramInt2	int
    //   50	28	4	localStringBuilder	StringBuilder
    //   105	1	4	localObject	Object
    //   110	17	4	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   129	1	4	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   15	39	105	finally
    //   41	86	105	finally
    //   112	122	105	finally
    //   15	39	110	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   41	86	110	net/sqlcipher/database/SQLiteDatabaseCorruptException
    //   15	39	129	java/lang/IllegalStateException
    //   41	86	129	java/lang/IllegalStateException
    //   11	15	136	finally
    //   88	92	136	finally
    //   122	129	136	finally
  }
  
  public void requery()
  {
    String[] arrayOfString = mBindArgs;
    if (arrayOfString != null)
    {
      int i = arrayOfString.length;
      int j = 0;
      try
      {
        int k;
        if (mObjectBindArgs != null)
        {
          bindArguments(mObjectBindArgs);
        }
        else
        {
          int m;
          for (k = 0; k < i; k = m)
          {
            m = k + 1;
            super.bindString(m, mBindArgs[k]);
          }
        }
        StringBuilder localStringBuilder;
        return;
      }
      catch (SQLiteMisuseException localSQLiteMisuseException)
      {
        localStringBuilder = a.a("mSql ");
        localStringBuilder.append(mSql);
        localStringBuilder = new StringBuilder(localStringBuilder.toString());
        for (k = j; k < i; k++)
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(mBindArgs[k]);
        }
        localStringBuilder.append(" ");
        throw new IllegalStateException(localStringBuilder.toString(), localSQLiteMisuseException);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("SQLiteQuery: ");
    localStringBuilder.append(mSql);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */