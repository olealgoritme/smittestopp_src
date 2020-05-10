package com.microsoft.appcenter.persistence;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.microsoft.appcenter.utils.storage.DatabaseManager.Listener;
import com.microsoft.appcenter.utils.storage.SQLiteUtils;

public class DatabasePersistence$1
  implements DatabaseManager.Listener
{
  public DatabasePersistence$1(DatabasePersistence paramDatabasePersistence, ContentValues paramContentValues) {}
  
  private void createPriorityIndex(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE INDEX `ix_logs_priority` ON logs (`priority`)");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createPriorityIndex(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    SQLiteUtils.dropTable(paramSQLiteDatabase, "logs");
    SQLiteUtils.createTable(paramSQLiteDatabase, "logs", val$schema);
    createPriorityIndex(paramSQLiteDatabase);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.persistence.DatabasePersistence.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */