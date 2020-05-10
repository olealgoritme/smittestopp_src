package d.w.a.g;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import d.w.a.b;
import d.w.a.f;
import java.util.List;

public class a
  implements b
{
  public static final String[] y = new String[0];
  public final SQLiteDatabase x;
  
  public a(SQLiteDatabase paramSQLiteDatabase)
  {
    x = paramSQLiteDatabase;
  }
  
  public List<Pair<String, String>> a()
  {
    return x.getAttachedDbs();
  }
  
  public String b()
  {
    return x.getPath();
  }
  
  public void beginTransaction()
  {
    x.beginTransaction();
  }
  
  public void close()
  {
    x.close();
  }
  
  public f compileStatement(String paramString)
  {
    return new e(x.compileStatement(paramString));
  }
  
  public void endTransaction()
  {
    x.endTransaction();
  }
  
  public void execSQL(String paramString)
  {
    x.execSQL(paramString);
  }
  
  public boolean inTransaction()
  {
    return x.inTransaction();
  }
  
  public boolean isOpen()
  {
    return x.isOpen();
  }
  
  public Cursor query(final d.w.a.e parame)
  {
    return x.rawQueryWithFactory(new a(parame), parame.a(), y, null);
  }
  
  public Cursor query(final d.w.a.e parame, CancellationSignal paramCancellationSignal)
  {
    return x.rawQueryWithFactory(new b(parame), parame.a(), y, null, paramCancellationSignal);
  }
  
  public Cursor query(String paramString)
  {
    return query(new d.w.a.a(paramString));
  }
  
  public void setTransactionSuccessful()
  {
    x.setTransactionSuccessful();
  }
  
  public class a
    implements SQLiteDatabase.CursorFactory
  {
    public a(d.w.a.e parame) {}
    
    public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
    {
      parame.a(new d(paramSQLiteQuery));
      return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    }
  }
  
  public class b
    implements SQLiteDatabase.CursorFactory
  {
    public b(d.w.a.e parame) {}
    
    public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
    {
      parame.a(new d(paramSQLiteQuery));
      return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    }
  }
}

/* Location:
 * Qualified Name:     d.w.a.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */