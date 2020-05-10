package net.sqlcipher.database;

public abstract interface SQLiteCursorDriver
{
  public abstract void cursorClosed();
  
  public abstract void cursorDeactivated();
  
  public abstract void cursorRequeried(android.database.Cursor paramCursor);
  
  public abstract net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString);
  
  public abstract void setBindArguments(String[] paramArrayOfString);
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteCursorDriver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */