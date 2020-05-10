package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import e.a.a.a.a;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;

public abstract class SQLiteOpenHelper
{
  public static final String TAG = "SQLiteOpenHelper";
  public final Context mContext;
  public SQLiteDatabase mDatabase = null;
  public boolean mDeferSetWriteAheadLoggingEnabled;
  public boolean mEnableWriteAheadLogging;
  public final DatabaseErrorHandler mErrorHandler;
  public final SQLiteDatabase.CursorFactory mFactory;
  public final SQLiteDatabaseHook mHook;
  public boolean mIsInitializing = false;
  public final String mName;
  public final int mNewVersion;
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt >= 1)
    {
      if (paramDatabaseErrorHandler != null)
      {
        mContext = paramContext;
        mName = paramString;
        mFactory = paramCursorFactory;
        mNewVersion = paramInt;
        mHook = paramSQLiteDatabaseHook;
        mErrorHandler = paramDatabaseErrorHandler;
        return;
      }
      throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
    }
    throw new IllegalArgumentException(a.a("Version must be >= 1, was ", paramInt));
  }
  
  public void close()
  {
    try
    {
      if (!mIsInitializing)
      {
        if ((mDatabase != null) && (mDatabase.isOpen()))
        {
          mDatabase.close();
          mDatabase = null;
        }
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("Closed during initialization");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  public String getDatabaseName()
  {
    return mName;
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getReadableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  public SQLiteDatabase getReadableDatabase(byte[] paramArrayOfByte)
  {
    try
    {
      if ((mDatabase != null) && (mDatabase.isOpen()))
      {
        paramArrayOfByte = mDatabase;
        return paramArrayOfByte;
      }
      boolean bool = mIsInitializing;
      if (!bool) {
        try
        {
          SQLiteDatabase localSQLiteDatabase = getWritableDatabase(paramArrayOfByte);
          return localSQLiteDatabase;
        }
        catch (SQLiteException localSQLiteException)
        {
          Object localObject1;
          if (mName != null)
          {
            Object localObject2 = TAG;
            Object localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            ((StringBuilder)localObject3).append("Couldn't open ");
            ((StringBuilder)localObject3).append(mName);
            ((StringBuilder)localObject3).append(" for writing (will try read-only):");
            Log.e((String)localObject2, ((StringBuilder)localObject3).toString(), localSQLiteException);
            localObject3 = null;
            localObject2 = null;
            localObject1 = localObject3;
            try
            {
              mIsInitializing = true;
              localObject1 = localObject3;
              String str = mContext.getDatabasePath(mName).getPath();
              localObject1 = localObject3;
              File localFile1 = new java/io/File;
              localObject1 = localObject3;
              localFile1.<init>(str);
              localObject1 = localObject3;
              File localFile2 = new java/io/File;
              localObject1 = localObject3;
              localFile2.<init>(mContext.getDatabasePath(mName).getParent());
              localObject1 = localObject3;
              if (!localFile2.exists())
              {
                localObject1 = localObject3;
                localFile2.mkdirs();
              }
              localObject1 = localObject3;
              if (!localFile1.exists())
              {
                localObject1 = localObject3;
                mIsInitializing = false;
                localObject1 = localObject3;
                localObject2 = getWritableDatabase(paramArrayOfByte);
                localObject1 = localObject2;
                mIsInitializing = true;
                localObject1 = localObject2;
                ((SQLiteDatabase)localObject2).close();
              }
              localObject1 = localObject2;
              paramArrayOfByte = SQLiteDatabase.openDatabase(str, paramArrayOfByte, mFactory, 1, mHook, mErrorHandler);
              localObject1 = paramArrayOfByte;
              if (paramArrayOfByte.getVersion() == mNewVersion)
              {
                localObject1 = paramArrayOfByte;
                onOpen(paramArrayOfByte);
                localObject1 = paramArrayOfByte;
                localObject3 = TAG;
                localObject1 = paramArrayOfByte;
                localObject2 = new java/lang/StringBuilder;
                localObject1 = paramArrayOfByte;
                ((StringBuilder)localObject2).<init>();
                localObject1 = paramArrayOfByte;
                ((StringBuilder)localObject2).append("Opened ");
                localObject1 = paramArrayOfByte;
                ((StringBuilder)localObject2).append(mName);
                localObject1 = paramArrayOfByte;
                ((StringBuilder)localObject2).append(" in read-only mode");
                localObject1 = paramArrayOfByte;
                Log.w((String)localObject3, ((StringBuilder)localObject2).toString());
                localObject1 = paramArrayOfByte;
                mDatabase = paramArrayOfByte;
                mIsInitializing = false;
                return paramArrayOfByte;
              }
              localObject1 = paramArrayOfByte;
              localObject2 = new net/sqlcipher/database/SQLiteException;
              localObject1 = paramArrayOfByte;
              localObject3 = new java/lang/StringBuilder;
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).<init>();
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append("Can't upgrade read-only database from version ");
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append(paramArrayOfByte.getVersion());
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append(" to ");
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append(mNewVersion);
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append(": ");
              localObject1 = paramArrayOfByte;
              ((StringBuilder)localObject3).append(str);
              localObject1 = paramArrayOfByte;
              ((SQLiteException)localObject2).<init>(((StringBuilder)localObject3).toString());
              localObject1 = paramArrayOfByte;
              throw ((Throwable)localObject2);
            }
            finally
            {
              mIsInitializing = false;
              if ((localObject1 != null) && (localObject1 != mDatabase)) {
                ((SQLiteDatabase)localObject1).close();
              }
            }
          }
          throw ((Throwable)localObject1);
        }
      }
      paramArrayOfByte = new java/lang/IllegalStateException;
      paramArrayOfByte.<init>("getReadableDatabase called recursively");
      throw paramArrayOfByte;
    }
    finally {}
  }
  
  public SQLiteDatabase getReadableDatabase(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      paramArrayOfChar = null;
    }
    try
    {
      paramArrayOfChar = SQLiteDatabase.getBytes(paramArrayOfChar);
      paramArrayOfChar = getReadableDatabase(paramArrayOfChar);
      return paramArrayOfChar;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getWritableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   13: invokevirtual 76	net/sqlcipher/database/SQLiteDatabase:isOpen	()Z
    //   16: ifeq +22 -> 38
    //   19: aload_0
    //   20: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   23: invokevirtual 190	net/sqlcipher/database/SQLiteDatabase:isReadOnly	()Z
    //   26: ifne +12 -> 38
    //   29: aload_0
    //   30: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: aload_0
    //   39: getfield 42	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   42: ifne +330 -> 372
    //   45: aload_0
    //   46: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   56: invokevirtual 193	net/sqlcipher/database/SQLiteDatabase:lock	()V
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: astore_3
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 42	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   68: aload_2
    //   69: astore_3
    //   70: aload_0
    //   71: getfield 46	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   74: ifnonnull +15 -> 89
    //   77: aload_2
    //   78: astore_3
    //   79: aconst_null
    //   80: ldc -61
    //   82: invokestatic 199	net/sqlcipher/database/SQLiteDatabase:create	(Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   85: astore_1
    //   86: goto +82 -> 168
    //   89: aload_2
    //   90: astore_3
    //   91: aload_0
    //   92: getfield 44	net/sqlcipher/database/SQLiteOpenHelper:mContext	Landroid/content/Context;
    //   95: aload_0
    //   96: getfield 46	net/sqlcipher/database/SQLiteOpenHelper:mName	Ljava/lang/String;
    //   99: invokevirtual 130	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   102: invokevirtual 135	java/io/File:getPath	()Ljava/lang/String;
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: new 132	java/io/File
    //   112: astore 5
    //   114: aload_2
    //   115: astore_3
    //   116: aload 5
    //   118: aload 4
    //   120: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: astore_3
    //   125: aload 5
    //   127: invokevirtual 142	java/io/File:exists	()Z
    //   130: ifne +14 -> 144
    //   133: aload_2
    //   134: astore_3
    //   135: aload 5
    //   137: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   140: invokevirtual 145	java/io/File:mkdirs	()Z
    //   143: pop
    //   144: aload_2
    //   145: astore_3
    //   146: aload 4
    //   148: aload_1
    //   149: aload_0
    //   150: getfield 48	net/sqlcipher/database/SQLiteOpenHelper:mFactory	Lnet/sqlcipher/database/SQLiteDatabase$CursorFactory;
    //   153: aload_0
    //   154: getfield 52	net/sqlcipher/database/SQLiteOpenHelper:mHook	Lnet/sqlcipher/database/SQLiteDatabaseHook;
    //   157: aload_0
    //   158: getfield 54	net/sqlcipher/database/SQLiteOpenHelper:mErrorHandler	Lnet/sqlcipher/DatabaseErrorHandler;
    //   161: invokestatic 207	net/sqlcipher/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;[BLnet/sqlcipher/database/SQLiteDatabase$CursorFactory;Lnet/sqlcipher/database/SQLiteDatabaseHook;Lnet/sqlcipher/DatabaseErrorHandler;)Lnet/sqlcipher/database/SQLiteDatabase;
    //   164: astore_1
    //   165: goto -79 -> 86
    //   168: aload_1
    //   169: astore_3
    //   170: aload_0
    //   171: getfield 209	net/sqlcipher/database/SQLiteOpenHelper:mDeferSetWriteAheadLoggingEnabled	Z
    //   174: ifeq +13 -> 187
    //   177: aload_1
    //   178: astore_3
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual 212	net/sqlcipher/database/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   184: putfield 214	net/sqlcipher/database/SQLiteOpenHelper:mEnableWriteAheadLogging	Z
    //   187: aload_1
    //   188: astore_3
    //   189: aload_0
    //   190: aload_1
    //   191: invokevirtual 217	net/sqlcipher/database/SQLiteOpenHelper:onConfigure	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   194: aload_1
    //   195: astore_3
    //   196: aload_1
    //   197: invokevirtual 153	net/sqlcipher/database/SQLiteDatabase:getVersion	()I
    //   200: istore 6
    //   202: aload_1
    //   203: astore_3
    //   204: iload 6
    //   206: aload_0
    //   207: getfield 50	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   210: if_icmpeq +88 -> 298
    //   213: aload_1
    //   214: astore_3
    //   215: aload_1
    //   216: invokevirtual 220	net/sqlcipher/database/SQLiteDatabase:beginTransaction	()V
    //   219: iload 6
    //   221: ifne +11 -> 232
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual 223	net/sqlcipher/database/SQLiteOpenHelper:onCreate	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   229: goto +37 -> 266
    //   232: iload 6
    //   234: aload_0
    //   235: getfield 50	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   238: if_icmple +17 -> 255
    //   241: aload_0
    //   242: aload_1
    //   243: iload 6
    //   245: aload_0
    //   246: getfield 50	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   249: invokevirtual 227	net/sqlcipher/database/SQLiteOpenHelper:onDowngrade	(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    //   252: goto +14 -> 266
    //   255: aload_0
    //   256: aload_1
    //   257: iload 6
    //   259: aload_0
    //   260: getfield 50	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   263: invokevirtual 230	net/sqlcipher/database/SQLiteOpenHelper:onUpgrade	(Lnet/sqlcipher/database/SQLiteDatabase;II)V
    //   266: aload_1
    //   267: aload_0
    //   268: getfield 50	net/sqlcipher/database/SQLiteOpenHelper:mNewVersion	I
    //   271: invokevirtual 234	net/sqlcipher/database/SQLiteDatabase:setVersion	(I)V
    //   274: aload_1
    //   275: invokevirtual 237	net/sqlcipher/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   278: aload_1
    //   279: astore_3
    //   280: aload_1
    //   281: invokevirtual 240	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   284: goto +14 -> 298
    //   287: astore_2
    //   288: aload_1
    //   289: astore_3
    //   290: aload_1
    //   291: invokevirtual 240	net/sqlcipher/database/SQLiteDatabase:endTransaction	()V
    //   294: aload_1
    //   295: astore_3
    //   296: aload_2
    //   297: athrow
    //   298: aload_1
    //   299: astore_3
    //   300: aload_0
    //   301: aload_1
    //   302: invokevirtual 157	net/sqlcipher/database/SQLiteOpenHelper:onOpen	(Lnet/sqlcipher/database/SQLiteDatabase;)V
    //   305: aload_0
    //   306: iconst_0
    //   307: putfield 42	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   310: aload_0
    //   311: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   314: astore_3
    //   315: aload_3
    //   316: ifnull +17 -> 333
    //   319: aload_0
    //   320: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   323: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   326: aload_0
    //   327: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   330: invokevirtual 243	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   333: aload_0
    //   334: aload_1
    //   335: putfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: aload_0
    //   344: iconst_0
    //   345: putfield 42	net/sqlcipher/database/SQLiteOpenHelper:mIsInitializing	Z
    //   348: aload_0
    //   349: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   352: ifnull +10 -> 362
    //   355: aload_0
    //   356: getfield 40	net/sqlcipher/database/SQLiteOpenHelper:mDatabase	Lnet/sqlcipher/database/SQLiteDatabase;
    //   359: invokevirtual 243	net/sqlcipher/database/SQLiteDatabase:unlock	()V
    //   362: aload_3
    //   363: ifnull +7 -> 370
    //   366: aload_3
    //   367: invokevirtual 78	net/sqlcipher/database/SQLiteDatabase:close	()V
    //   370: aload_1
    //   371: athrow
    //   372: new 80	java/lang/IllegalStateException
    //   375: astore_1
    //   376: aload_1
    //   377: ldc -11
    //   379: invokespecial 83	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   382: aload_1
    //   383: athrow
    //   384: astore_1
    //   385: aload_0
    //   386: monitorexit
    //   387: aload_1
    //   388: athrow
    //   389: astore_3
    //   390: goto -64 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	SQLiteOpenHelper
    //   0	393	1	paramArrayOfByte	byte[]
    //   60	85	2	localObject1	Object
    //   287	10	2	localObject2	Object
    //   62	305	3	localObject3	Object
    //   389	1	3	localException	Exception
    //   105	42	4	str	String
    //   112	24	5	localFile	File
    //   200	58	6	i	int
    // Exception table:
    //   from	to	target	type
    //   224	229	287	finally
    //   232	252	287	finally
    //   255	266	287	finally
    //   266	278	287	finally
    //   63	68	342	finally
    //   70	77	342	finally
    //   79	86	342	finally
    //   91	107	342	finally
    //   109	114	342	finally
    //   116	123	342	finally
    //   125	133	342	finally
    //   135	144	342	finally
    //   146	165	342	finally
    //   170	177	342	finally
    //   179	187	342	finally
    //   189	194	342	finally
    //   196	202	342	finally
    //   204	213	342	finally
    //   215	219	342	finally
    //   280	284	342	finally
    //   290	294	342	finally
    //   296	298	342	finally
    //   300	305	342	finally
    //   2	34	384	finally
    //   38	59	384	finally
    //   305	315	384	finally
    //   319	326	384	finally
    //   326	333	384	finally
    //   333	338	384	finally
    //   343	362	384	finally
    //   366	370	384	finally
    //   370	372	384	finally
    //   372	384	384	finally
    //   319	326	389	java/lang/Exception
  }
  
  public SQLiteDatabase getWritableDatabase(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      paramArrayOfChar = null;
    }
    try
    {
      paramArrayOfChar = SQLiteDatabase.getBytes(paramArrayOfChar);
      paramArrayOfChar = getWritableDatabase(paramArrayOfChar);
      return paramArrayOfChar;
    }
    finally {}
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Can't downgrade database from version ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    throw new SQLiteException(paramSQLiteDatabase.toString());
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    try
    {
      if (mEnableWriteAheadLogging != paramBoolean) {
        if ((mDatabase != null) && (mDatabase.isOpen()) && (!mDatabase.isReadOnly()))
        {
          if (paramBoolean) {
            mDatabase.enableWriteAheadLogging();
          } else {
            mDatabase.disableWriteAheadLogging();
          }
          mEnableWriteAheadLogging = paramBoolean;
        }
        else
        {
          mDeferSetWriteAheadLoggingEnabled = paramBoolean;
        }
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteOpenHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */