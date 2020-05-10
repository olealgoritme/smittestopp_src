package net.sqlcipher.database;

public class SQLiteDatabase$5
  implements SQLiteTransactionListener
{
  public SQLiteDatabase$5(SQLiteDatabase paramSQLiteDatabase, android.database.sqlite.SQLiteTransactionListener paramSQLiteTransactionListener) {}
  
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
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */