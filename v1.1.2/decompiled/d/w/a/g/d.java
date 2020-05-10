package d.w.a.g;

import android.database.sqlite.SQLiteProgram;

public class d
  implements d.w.a.d
{
  public final SQLiteProgram x;
  
  public d(SQLiteProgram paramSQLiteProgram)
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
 * Qualified Name:     d.w.a.g.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */