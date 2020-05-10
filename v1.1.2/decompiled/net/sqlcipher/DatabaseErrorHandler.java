package net.sqlcipher;

import net.sqlcipher.database.SQLiteDatabase;

public abstract interface DatabaseErrorHandler
{
  public abstract void onCorruption(SQLiteDatabase paramSQLiteDatabase);
}

/* Location:
 * Qualified Name:     net.sqlcipher.DatabaseErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */