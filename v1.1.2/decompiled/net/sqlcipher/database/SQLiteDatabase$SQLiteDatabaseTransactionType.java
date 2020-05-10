package net.sqlcipher.database;

public enum SQLiteDatabase$SQLiteDatabaseTransactionType
{
  static
  {
    SQLiteDatabaseTransactionType localSQLiteDatabaseTransactionType = new SQLiteDatabaseTransactionType("Exclusive", 2);
    Exclusive = localSQLiteDatabaseTransactionType;
    $VALUES = new SQLiteDatabaseTransactionType[] { Deferred, Immediate, localSQLiteDatabaseTransactionType };
  }
  
  public SQLiteDatabase$SQLiteDatabaseTransactionType() {}
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.SQLiteDatabaseTransactionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */