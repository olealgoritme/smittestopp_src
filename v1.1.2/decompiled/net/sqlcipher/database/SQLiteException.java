package net.sqlcipher.database;

import net.sqlcipher.SQLException;

public class SQLiteException
  extends SQLException
{
  public SQLiteException() {}
  
  public SQLiteException(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */