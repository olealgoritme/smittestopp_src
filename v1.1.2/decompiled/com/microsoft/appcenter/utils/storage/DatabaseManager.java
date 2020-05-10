package com.microsoft.appcenter.utils.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.io.Closeable;
import java.util.Arrays;

public class DatabaseManager
  implements Closeable
{
  public static final String PRIMARY_KEY = "oid";
  public static final String[] SELECT_PRIMARY_KEY = { "oid" };
  public final Context mContext;
  public final String mDatabase;
  public final String mDefaultTable;
  public final Listener mListener;
  public SQLiteOpenHelper mSQLiteOpenHelper;
  public final ContentValues mSchema;
  
  public DatabaseManager(Context paramContext, String paramString1, String paramString2, int paramInt, ContentValues paramContentValues, Listener paramListener)
  {
    mContext = paramContext;
    mDatabase = paramString1;
    mDefaultTable = paramString2;
    mSchema = paramContentValues;
    mListener = paramListener;
    mSQLiteOpenHelper = new SQLiteOpenHelper(paramContext, paramString1, null, paramInt)
    {
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        SQLiteUtils.createTable(paramAnonymousSQLiteDatabase, DatabaseManager.access$000(DatabaseManager.this), DatabaseManager.access$100(DatabaseManager.this));
        DatabaseManager.access$200(DatabaseManager.this).onCreate(paramAnonymousSQLiteDatabase);
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        DatabaseManager.access$200(DatabaseManager.this).onUpgrade(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public static ContentValues buildValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    ContentValues localContentValues = new ContentValues();
    for (int i = 0; i < paramCursor.getColumnCount(); i++) {
      if (!paramCursor.isNull(i))
      {
        String str = paramCursor.getColumnName(i);
        if (str.equals("oid"))
        {
          localContentValues.put(str, Long.valueOf(paramCursor.getLong(i)));
        }
        else
        {
          Object localObject = paramContentValues.get(str);
          if ((localObject instanceof byte[]))
          {
            localContentValues.put(str, paramCursor.getBlob(i));
          }
          else if ((localObject instanceof Double))
          {
            localContentValues.put(str, Double.valueOf(paramCursor.getDouble(i)));
          }
          else if ((localObject instanceof Float))
          {
            localContentValues.put(str, Float.valueOf(paramCursor.getFloat(i)));
          }
          else if ((localObject instanceof Integer))
          {
            localContentValues.put(str, Integer.valueOf(paramCursor.getInt(i)));
          }
          else if ((localObject instanceof Long))
          {
            localContentValues.put(str, Long.valueOf(paramCursor.getLong(i)));
          }
          else if ((localObject instanceof Short))
          {
            localContentValues.put(str, Short.valueOf(paramCursor.getShort(i)));
          }
          else if ((localObject instanceof Boolean))
          {
            int j = paramCursor.getInt(i);
            boolean bool = true;
            if (j != 1) {
              bool = false;
            }
            localContentValues.put(str, Boolean.valueOf(bool));
          }
          else
          {
            localContentValues.put(str, paramCursor.getString(i));
          }
        }
      }
    }
    return localContentValues;
  }
  
  private int delete(String paramString1, String paramString2, Object paramObject)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramObject);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getDatabase();
      paramObject = new java/lang/StringBuilder;
      ((StringBuilder)paramObject).<init>();
      ((StringBuilder)paramObject).append(paramString2);
      ((StringBuilder)paramObject).append(" = ?");
      int i = localSQLiteDatabase.delete(paramString1, ((StringBuilder)paramObject).toString(), arrayOfString);
      return i;
    }
    catch (RuntimeException paramString1)
    {
      AppCenterLog.error("AppCenter", String.format("Failed to delete values that match condition=\"%s\" and values=\"%s\" from database %s.", new Object[] { a.b(paramString2, " = ?"), Arrays.toString(arrayOfString), mDatabase }), paramString1);
    }
    return 0;
  }
  
  public ContentValues buildValues(Cursor paramCursor)
  {
    return buildValues(paramCursor, mSchema);
  }
  
  public void clear()
  {
    try
    {
      getDatabase().delete(mDefaultTable, null, null);
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Failed to clear the table.", localRuntimeException);
    }
  }
  
  public void close()
  {
    try
    {
      mSQLiteOpenHelper.close();
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Failed to close the database.", localRuntimeException);
    }
  }
  
  public int delete(String paramString, Object paramObject)
  {
    return delete(mDefaultTable, paramString, paramObject);
  }
  
  public void delete(long paramLong)
  {
    delete(mDefaultTable, "oid", Long.valueOf(paramLong));
  }
  
  public Cursor getCursor(SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString)
  {
    return getCursor(mDefaultTable, paramSQLiteQueryBuilder, paramArrayOfString1, paramArrayOfString2, paramString);
  }
  
  public Cursor getCursor(String paramString1, SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = paramSQLiteQueryBuilder;
    if (paramSQLiteQueryBuilder == null) {
      localSQLiteQueryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
    }
    localSQLiteQueryBuilder.setTables(paramString1);
    return localSQLiteQueryBuilder.query(getDatabase(), paramArrayOfString1, null, paramArrayOfString2, null, null, paramString2);
  }
  
  public SQLiteDatabase getDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = mSQLiteOpenHelper.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.warn("AppCenter", "Failed to open database. Trying to delete database (may be corrupted).", localRuntimeException);
      if (mContext.deleteDatabase(mDatabase)) {
        AppCenterLog.info("AppCenter", "The database was successfully deleted.");
      } else {
        AppCenterLog.warn("AppCenter", "Failed to delete database.");
      }
    }
    return mSQLiteOpenHelper.getWritableDatabase();
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = getDatabase().getMaximumSize();
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Could not get maximum database size.", localRuntimeException);
    }
    return -1L;
  }
  
  public final long getRowCount()
  {
    try
    {
      long l = DatabaseUtils.queryNumEntries(getDatabase(), mDefaultTable);
      return l;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Failed to get row count of database.", localRuntimeException);
    }
    return -1L;
  }
  
  public ContentValues nextValues(Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToNext())
      {
        paramCursor = buildValues(paramCursor);
        return paramCursor;
      }
    }
    catch (RuntimeException paramCursor)
    {
      AppCenterLog.error("AppCenter", "Failed to get next cursor value: ", paramCursor);
    }
    return null;
  }
  
  public long put(ContentValues paramContentValues, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject3 = localObject1;
      localObject4 = localObject3;
      localObject1 = localObject2;
      if (localObject3 != null) {
        break label374;
      }
      localObject1 = localObject2;
      try
      {
        localObject4 = Long.valueOf(getDatabase().insertOrThrow(mDefaultTable, null, paramContentValues));
        localObject1 = localObject4;
      }
      catch (RuntimeException paramString) {}catch (SQLiteFullException localSQLiteFullException)
      {
        localObject1 = localObject2;
        AppCenterLog.debug("AppCenter", "Storage is full, trying to delete the oldest log that has the lowest priority which is lower or equal priority than the new log");
        localObject4 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          localObject4 = paramContentValues.getAsString(paramString);
          localObject1 = localObject2;
          SQLiteQueryBuilder localSQLiteQueryBuilder = SQLiteUtils.newSQLiteQueryBuilder();
          localObject1 = localObject2;
          Object localObject5 = new java/lang/StringBuilder;
          localObject1 = localObject2;
          ((StringBuilder)localObject5).<init>();
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append(paramString);
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append(" <= ?");
          localObject1 = localObject2;
          localSQLiteQueryBuilder.appendWhere(((StringBuilder)localObject5).toString());
          localObject1 = localObject2;
          localObject5 = SELECT_PRIMARY_KEY;
          localObject1 = localObject2;
          Object localObject6 = new java/lang/StringBuilder;
          localObject1 = localObject2;
          ((StringBuilder)localObject6).<init>();
          localObject1 = localObject2;
          ((StringBuilder)localObject6).append(paramString);
          localObject1 = localObject2;
          ((StringBuilder)localObject6).append(" , ");
          localObject1 = localObject2;
          ((StringBuilder)localObject6).append("oid");
          localObject1 = localObject2;
          localObject6 = ((StringBuilder)localObject6).toString();
          localObject1 = localObject2;
          localObject4 = getCursor(localSQLiteQueryBuilder, (String[])localObject5, new String[] { localObject4 }, (String)localObject6);
        }
        localObject1 = localObject4;
        if (((Cursor)localObject4).moveToNext())
        {
          localObject1 = localObject4;
          long l = ((Cursor)localObject4).getLong(0);
          localObject1 = localObject4;
          delete(l);
          localObject1 = localObject4;
          localObject2 = new java/lang/StringBuilder;
          localObject1 = localObject4;
          ((StringBuilder)localObject2).<init>();
          localObject1 = localObject4;
          ((StringBuilder)localObject2).append("Deleted log id=");
          localObject1 = localObject4;
          ((StringBuilder)localObject2).append(l);
          localObject1 = localObject4;
          AppCenterLog.debug("AppCenter", ((StringBuilder)localObject2).toString());
          localObject1 = localObject3;
          localObject2 = localObject4;
        }
        else
        {
          localObject1 = localObject4;
          throw localSQLiteFullException;
        }
      }
    }
    Object localObject4 = Long.valueOf(-1L);
    AppCenterLog.error("AppCenter", String.format("Failed to insert values (%s) to database %s.", new Object[] { paramContentValues.toString(), mDatabase }), paramString);
    label374:
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).close();
      return ((Long)localObject4).longValue();
    }
    catch (RuntimeException paramContentValues)
    {
      for (;;) {}
    }
  }
  
  public boolean setMaxSize(long paramLong)
  {
    try
    {
      Object localObject = getDatabase();
      long l1 = ((SQLiteDatabase)localObject).setMaximumSize(paramLong);
      long l2 = ((SQLiteDatabase)localObject).getPageSize();
      long l3 = paramLong / l2;
      long l4 = l3;
      if (paramLong % l2 != 0L) {
        l4 = l3 + 1L;
      }
      if (l1 != l4 * l2)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Could not change maximum database size to ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" bytes, current maximum size is ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" bytes.");
        AppCenterLog.error("AppCenter", ((StringBuilder)localObject).toString());
        return false;
      }
      if (paramLong == l1)
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Changed maximum database size to ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" bytes.");
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("Changed maximum database size to ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" bytes (next multiple of page size).");
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject).toString());
      }
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Could not change maximum database size.", localRuntimeException);
    }
    return false;
  }
  
  public void setSQLiteOpenHelper(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    mSQLiteOpenHelper.close();
    mSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  public static abstract interface Listener
  {
    public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
    
    public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.storage.DatabaseManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */