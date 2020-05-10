package l.d.b.g;

import android.database.Cursor;

public abstract interface a
{
  public abstract Cursor a(String paramString, String[] paramArrayOfString);
  
  public abstract void a(String paramString, Object[] paramArrayOfObject);
  
  public abstract boolean a();
  
  public abstract Object b();
  
  public abstract void beginTransaction();
  
  public abstract void close();
  
  public abstract c compileStatement(String paramString);
  
  public abstract void endTransaction();
  
  public abstract void execSQL(String paramString);
  
  public abstract void setTransactionSuccessful();
}

/* Location:
 * Qualified Name:     l.d.b.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */