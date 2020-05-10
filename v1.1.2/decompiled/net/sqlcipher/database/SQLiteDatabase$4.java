package net.sqlcipher.database;

public class SQLiteDatabase$4
  implements SQLiteTransactionListener
{
  public SQLiteDatabase$4(SQLiteDatabase paramSQLiteDatabase, android.database.sqlite.SQLiteTransactionListener paramSQLiteTransactionListener) {}
  
  public void onBegin()
  {
    val$transactionListener.onBegin();
  }
  
  public void onCommit()
  {
    val$transactionListener.onCommit();
  }
  
  public void onRollback()
  {
    val$transactionListener.onRollback();
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */