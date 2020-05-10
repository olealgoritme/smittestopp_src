package d.w.a.g;

import android.database.sqlite.SQLiteStatement;
import d.w.a.f;

public class e
  extends d
  implements f
{
  public final SQLiteStatement y;
  
  public e(SQLiteStatement paramSQLiteStatement)
  {
    super(paramSQLiteStatement);
    y = paramSQLiteStatement;
  }
  
  public long executeInsert()
  {
    return y.executeInsert();
  }
  
  public int executeUpdateDelete()
  {
    return y.executeUpdateDelete();
  }
}

/* Location:
 * Qualified Name:     d.w.a.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */