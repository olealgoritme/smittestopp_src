package net.sqlcipher.database;

public class SQLiteDebug$DbStats
{
  public String dbName;
  public long dbSize;
  public int lookaside;
  public long pageSize;
  
  public SQLiteDebug$DbStats(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    dbName = paramString;
    pageSize = paramLong2;
    dbSize = (paramLong1 * paramLong2 / 1024L);
    lookaside = paramInt;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteDebug.DbStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */