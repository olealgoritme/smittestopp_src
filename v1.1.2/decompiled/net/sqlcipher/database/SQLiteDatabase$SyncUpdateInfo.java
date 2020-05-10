package net.sqlcipher.database;

public class SQLiteDatabase$SyncUpdateInfo
{
  public String deletedTable;
  public String foreignKey;
  public String masterTable;
  
  public SQLiteDatabase$SyncUpdateInfo(String paramString1, String paramString2, String paramString3)
  {
    masterTable = paramString1;
    deletedTable = paramString2;
    foreignKey = paramString3;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDatabase.SyncUpdateInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */