package d.w.a.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import d.w.a.b;
import d.w.a.e;

public class a
  implements b
{
  public static final String[] y = new String[0];
  public final SQLiteDatabase x;
  
  public a(SQLiteDatabase paramSQLiteDatabase)
  {
    x = paramSQLiteDatabase;
  }
  
  public Cursor a(e parame)
  {
    return x.rawQueryWithFactory(new a.a(this, parame), parame.a(), y, null);
  }
  
  public Cursor a(String paramString)
  {
    return a(new d.w.a.a(paramString));
  }
  
  public String a()
  {
    return x.getPath();
  }
  
  public void close()
  {
    x.close();
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */