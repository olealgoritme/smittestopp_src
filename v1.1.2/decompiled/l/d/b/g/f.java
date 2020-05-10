package l.d.b.g;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class f
  implements a
{
  public final SQLiteDatabase a;
  
  public f(SQLiteDatabase paramSQLiteDatabase)
  {
    a = paramSQLiteDatabase;
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    return a.rawQuery(paramString, paramArrayOfString);
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    a.execSQL(paramString, paramArrayOfObject);
  }
  
  public boolean a()
  {
    return a.isDbLockedByCurrentThread();
  }
  
  public Object b()
  {
    return a;
  }
  
  public void beginTransaction()
  {
    a.beginTransaction();
  }
  
  public void close()
  {
    a.close();
  }
  
  public c compileStatement(String paramString)
  {
    return new g(a.compileStatement(paramString));
  }
  
  public void endTransaction()
  {
    a.endTransaction();
  }
  
  public void execSQL(String paramString)
  {
    a.execSQL(paramString);
  }
  
  public void setTransactionSuccessful()
  {
    a.setTransactionSuccessful();
  }
}

/* Location:
 * Qualified Name:     l.d.b.g.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */