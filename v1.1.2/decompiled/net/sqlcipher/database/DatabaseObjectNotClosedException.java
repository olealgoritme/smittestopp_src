package net.sqlcipher.database;

public class DatabaseObjectNotClosedException
  extends RuntimeException
{
  public static final String s = "Application did not close the cursor or database object that was opened here";
  
  public DatabaseObjectNotClosedException()
  {
    super("Application did not close the cursor or database object that was opened here");
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.DatabaseObjectNotClosedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */