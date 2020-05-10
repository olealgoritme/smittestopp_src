package com.microsoft.appcenter.utils.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager$1
  extends SQLiteOpenHelper
{
  public DatabaseManager$1(DatabaseManager paramDatabaseManager, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    SQLiteUtils.createTable(paramSQLiteDatabase, DatabaseManager.access$000(this$0), DatabaseManager.access$100(this$0));
    DatabaseManager.access$200(this$0).onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    DatabaseManager.access$200(this$0).onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.storage.DatabaseManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */