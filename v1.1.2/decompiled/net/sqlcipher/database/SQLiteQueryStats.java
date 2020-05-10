package net.sqlcipher.database;

public class SQLiteQueryStats
{
  public long largestIndividualRowSize = 0L;
  public long totalQueryResultSize = 0L;
  
  public SQLiteQueryStats(long paramLong1, long paramLong2)
  {
    totalQueryResultSize = paramLong1;
    largestIndividualRowSize = paramLong2;
  }
  
  public long getLargestIndividualRowSize()
  {
    return largestIndividualRowSize;
  }
  
  public long getTotalQueryResultSize()
  {
    return totalQueryResultSize;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteQueryStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */