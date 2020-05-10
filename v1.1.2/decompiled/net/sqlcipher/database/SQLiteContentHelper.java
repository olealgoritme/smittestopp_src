package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class SQLiteContentHelper
{
  public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramString = simpleQueryForBlobMemoryFile(paramSQLiteDatabase, paramString, paramArrayOfString);
      if (paramString != null)
      {
        paramSQLiteDatabase = paramString.getClass();
        try
        {
          paramSQLiteDatabase = paramSQLiteDatabase.getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
          paramSQLiteDatabase.setAccessible(true);
          paramSQLiteDatabase = (ParcelFileDescriptor)paramSQLiteDatabase.invoke(paramString, new Object[0]);
        }
        catch (Exception paramArrayOfString)
        {
          for (;;)
          {
            paramSQLiteDatabase = new java/lang/StringBuilder;
            paramSQLiteDatabase.<init>();
            paramSQLiteDatabase.append("SQLiteCursor.java: ");
            paramSQLiteDatabase.append(paramArrayOfString);
            Log.i("SQLiteContentHelper", paramSQLiteDatabase.toString());
            paramSQLiteDatabase = null;
          }
        }
        return new AssetFileDescriptor(paramSQLiteDatabase, 0L, paramString.length());
      }
      paramSQLiteDatabase = new java/io/FileNotFoundException;
      paramSQLiteDatabase.<init>("No results.");
      throw paramSQLiteDatabase;
    }
    catch (IOException paramSQLiteDatabase)
    {
      throw new FileNotFoundException(paramSQLiteDatabase.toString());
    }
  }
  
  public static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
    if (paramSQLiteDatabase == null) {
      return null;
    }
    try
    {
      boolean bool = paramSQLiteDatabase.moveToFirst();
      if (!bool) {
        return null;
      }
      paramString = paramSQLiteDatabase.getBlob(0);
      if (paramString == null) {
        return null;
      }
      paramArrayOfString = new android/os/MemoryFile;
      paramArrayOfString.<init>(null, paramString.length);
      paramArrayOfString.writeBytes(paramString, 0, 0, paramString.length);
      return paramArrayOfString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteContentHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */