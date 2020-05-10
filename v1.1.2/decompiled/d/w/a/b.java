package d.w.a;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;

public abstract interface b
  extends Closeable
{
  public abstract void beginTransaction();
  
  public abstract f compileStatement(String paramString);
  
  public abstract void endTransaction();
  
  public abstract void execSQL(String paramString);
  
  public abstract boolean inTransaction();
  
  public abstract boolean isOpen();
  
  public abstract Cursor query(e parame);
  
  public abstract Cursor query(e parame, CancellationSignal paramCancellationSignal);
  
  public abstract Cursor query(String paramString);
  
  public abstract void setTransactionSuccessful();
}

/* Location:
 * Qualified Name:     d.w.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */