package d.w.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

public class b
  implements SQLiteDatabase.CursorFactory
{
  public b(a parama, d.w.a.e parame) {}
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    a.a(new e(paramSQLiteQuery));
    return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */