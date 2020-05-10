package net.sqlcipher.database;

import android.content.Context;
import d.u.h;
import d.w.a.b;
import d.w.a.c;
import d.w.a.c.a;
import d.w.a.c.b;

public class SupportHelper
  implements c
{
  public final boolean clearPassphrase;
  public byte[] passphrase;
  public SQLiteOpenHelper standardHelper;
  
  public SupportHelper(final c.b paramb, byte[] paramArrayOfByte, SQLiteDatabaseHook paramSQLiteDatabaseHook, boolean paramBoolean)
  {
    SQLiteDatabase.loadLibs(a);
    passphrase = paramArrayOfByte;
    clearPassphrase = paramBoolean;
    standardHelper = new SQLiteOpenHelper(a, b, null, c.a, paramSQLiteDatabaseHook)
    {
      public void onConfigure(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        if ((h)parambc != null) {
          return;
        }
        throw null;
      }
      
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        parambc.a(paramAnonymousSQLiteDatabase);
      }
      
      public void onDowngrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ((h)parambc).a(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public void onOpen(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        parambc.b(paramAnonymousSQLiteDatabase);
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        parambc.a(paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public void close()
  {
    standardHelper.close();
  }
  
  public String getDatabaseName()
  {
    return standardHelper.getDatabaseName();
  }
  
  public b getReadableDatabase()
  {
    return getWritableDatabase();
  }
  
  public b getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = standardHelper.getWritableDatabase(passphrase);
      if ((clearPassphrase) && (passphrase != null)) {
        for (i = 0;; i++)
        {
          arrayOfByte = passphrase;
          if (i >= arrayOfByte.length) {
            break;
          }
          arrayOfByte[i] = ((byte)0);
        }
      }
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      int i;
      byte[] arrayOfByte = passphrase;
      if (arrayOfByte != null)
      {
        int j = arrayOfByte.length;
        int k = 0;
        i = 1;
        while (k < j)
        {
          int m = arrayOfByte[k];
          if ((i != 0) && (m == 0)) {
            i = 1;
          } else {
            i = 0;
          }
          k++;
        }
        if (i != 0) {
          throw new IllegalStateException("The passphrase appears to be cleared. This happens bydefault the first time you use the factory to open a database, so we can remove thecleartext passphrase from memory. If you close the database yourself, please use afresh SupportFactory to reopen it. If something else (e.g., Room) closed thedatabase, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", localSQLiteException);
        }
      }
      throw localSQLiteException;
    }
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    standardHelper.setWriteAheadLoggingEnabled(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SupportHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */