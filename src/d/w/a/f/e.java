package d.w.a.f;

import android.database.sqlite.SQLiteProgram;
import d.w.a.d;

public class e
  implements d
{
  public final SQLiteProgram x;
  
  public e(SQLiteProgram paramSQLiteProgram)
  {
    x = paramSQLiteProgram;
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    x.bindBlob(paramInt, paramArrayOfByte);
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    x.bindDouble(paramInt, paramDouble);
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    x.bindLong(paramInt, paramLong);
  }
  
  public void bindNull(int paramInt)
  {
    x.bindNull(paramInt);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    x.bindString(paramInt, paramString);
  }
  
  public void close()
  {
    x.close();
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */