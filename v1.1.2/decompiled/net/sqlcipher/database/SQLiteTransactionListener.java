package net.sqlcipher.database;

public abstract interface SQLiteTransactionListener
{
  public abstract void onBegin();
  
  public abstract void onCommit();
  
  public abstract void onRollback();
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteTransactionListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */