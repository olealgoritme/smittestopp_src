package net.sqlcipher.database;

import net.sqlcipher.Cursor;

public abstract interface SQLiteDatabase$CursorFactory
{
  public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery);
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.CursorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */