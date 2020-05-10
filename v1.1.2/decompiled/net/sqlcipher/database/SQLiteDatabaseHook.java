package net.sqlcipher.database;

public abstract interface SQLiteDatabaseHook
{
  public abstract void postKey(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void preKey(SQLiteDatabase paramSQLiteDatabase);
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabaseHook
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */