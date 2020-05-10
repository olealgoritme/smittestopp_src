package net.sqlcipher;

public class MatrixCursor$RowBuilder
{
  public final int endIndex;
  public int index;
  
  public MatrixCursor$RowBuilder(MatrixCursor paramMatrixCursor, int paramInt1, int paramInt2)
  {
    index = paramInt1;
    endIndex = paramInt2;
  }
  
  public RowBuilder add(Object paramObject)
  {
    if (index != endIndex)
    {
      Object[] arrayOfObject = MatrixCursor.access$000(this$0);
      int i = index;
      index = (i + 1);
      arrayOfObject[i] = paramObject;
      return this;
    }
    throw new CursorIndexOutOfBoundsException("No more columns left.");
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.MatrixCursor.RowBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */