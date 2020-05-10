package net.sqlcipher.database;

public final class SQLiteDatabase$1
  implements SQLiteDatabase.LibraryLoader
{
  public void loadLibraries(String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      System.loadLibrary(paramVarArgs[j]);
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */