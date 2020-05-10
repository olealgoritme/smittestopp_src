package net.sqlcipher;

public class CursorWrapper
  extends android.database.CursorWrapper
  implements Cursor
{
  public final Cursor mCursor;
  
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    mCursor = paramCursor;
  }
  
  public int getType(int paramInt)
  {
    return mCursor.getType(paramInt);
  }
  
  public Cursor getWrappedCursor()
  {
    return mCursor;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.CursorWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */