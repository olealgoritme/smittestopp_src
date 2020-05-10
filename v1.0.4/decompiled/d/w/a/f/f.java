package d.w.a.f;

import android.database.sqlite.SQLiteStatement;
import d.w.a.d;

public class f
  extends e
  implements d
{
  public final SQLiteStatement y;
  
  public f(SQLiteStatement paramSQLiteStatement)
  {
    super(paramSQLiteStatement);
    y = paramSQLiteStatement;
  }
  
  public int a()
  {
    return y.executeUpdateDelete();
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */