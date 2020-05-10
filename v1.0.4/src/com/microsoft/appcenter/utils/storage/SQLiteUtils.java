package com.microsoft.appcenter.utils.storage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SQLiteUtils
{
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS `");
    localStringBuilder.append(paramString);
    localStringBuilder.append("` (oid INTEGER PRIMARY KEY AUTOINCREMENT");
    paramString = paramContentValues.valueSet().iterator();
    while (paramString.hasNext())
    {
      paramContentValues = (Map.Entry)paramString.next();
      localStringBuilder.append(", `");
      localStringBuilder.append((String)paramContentValues.getKey());
      localStringBuilder.append("` ");
      paramContentValues = paramContentValues.getValue();
      if ((!(paramContentValues instanceof Double)) && (!(paramContentValues instanceof Float)))
      {
        if ((!(paramContentValues instanceof Number)) && (!(paramContentValues instanceof Boolean)))
        {
          if ((paramContentValues instanceof byte[])) {
            localStringBuilder.append("BLOB");
          } else {
            localStringBuilder.append("TEXT");
          }
        }
        else {
          localStringBuilder.append("INTEGER");
        }
      }
      else {
        localStringBuilder.append("REAL");
      }
    }
    localStringBuilder.append(");");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase.execSQL(String.format("DROP TABLE `%s`", new Object[] { paramString }));
  }
  
  public static SQLiteQueryBuilder newSQLiteQueryBuilder()
  {
    return new SQLiteQueryBuilder();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.storage.SQLiteUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */