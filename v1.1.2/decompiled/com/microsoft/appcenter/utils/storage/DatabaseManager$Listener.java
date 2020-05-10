package com.microsoft.appcenter.utils.storage;

import android.database.sqlite.SQLiteDatabase;

public abstract interface DatabaseManager$Listener
{
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.storage.DatabaseManager.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */