package l.d.b.g;

import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class e
  implements c
{
  public final SQLiteStatement a;
  
  public e(SQLiteStatement paramSQLiteStatement)
  {
    a = paramSQLiteStatement;
  }
  
  public void a()
  {
    a.clearBindings();
  }
  
  public Object b()
  {
    return a;
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    a.bindDouble(paramInt, paramDouble);
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    a.bindLong(paramInt, paramLong);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    a.bindString(paramInt, paramString);
  }
  
  public void close()
  {
    a.close();
  }
  
  public void execute()
  {
    a.execute();
  }
  
  public long executeInsert()
  {
    return a.executeInsert();
  }
}

/* Location:
 * Qualified Name:     l.d.b.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */