package net.sqlcipher;

import android.util.Log;
import e.a.a.a.a;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler
  implements DatabaseErrorHandler
{
  public final String TAG = DefaultDatabaseErrorHandler.class.getSimpleName();
  
  private void deleteDatabaseFile(String paramString)
  {
    if ((!paramString.equalsIgnoreCase(":memory:")) && (paramString.trim().length() != 0))
    {
      String str = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleting the database file: ");
      ((StringBuilder)localObject).append(paramString);
      Log.e(str, ((StringBuilder)localObject).toString());
      try
      {
        localObject = new java/io/File;
        ((File)localObject).<init>(paramString);
        ((File)localObject).delete();
      }
      catch (Exception paramString)
      {
        str = TAG;
        localObject = a.a("delete failed: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        Log.w(str, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Corruption reported by sqlite on database, deleting: ");
    localStringBuilder.append(paramSQLiteDatabase.getPath());
    Log.e(str, localStringBuilder.toString());
    if (paramSQLiteDatabase.isOpen())
    {
      Log.e(TAG, "Database object for corrupted database is already open, closing");
      try
      {
        paramSQLiteDatabase.close();
      }
      catch (Exception localException)
      {
        Log.e(TAG, "Exception closing Database object for corrupted database, ignored", localException);
      }
    }
    deleteDatabaseFile(paramSQLiteDatabase.getPath());
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.DefaultDatabaseErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */