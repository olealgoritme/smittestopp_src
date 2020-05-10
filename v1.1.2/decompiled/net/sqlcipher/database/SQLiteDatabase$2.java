package net.sqlcipher.database;

public class SQLiteDatabase$2
  implements Runnable
{
  public SQLiteDatabase$2(SQLiteDatabase paramSQLiteDatabase, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    byte[] arrayOfByte = val$password;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      SQLiteDatabase.access$000(this$0, arrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */