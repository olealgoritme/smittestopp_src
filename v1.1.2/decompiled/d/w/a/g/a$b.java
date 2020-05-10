package d.w.a.g;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import d.w.a.e;

public class a$b
  implements SQLiteDatabase.CursorFactory
{
  public a$b(a parama, e parame) {}
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    a.a(new d(paramSQLiteQuery));
    return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
}

/* Location:
 * Qualified Name:     d.w.a.g.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */