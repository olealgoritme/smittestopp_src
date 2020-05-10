package net.sqlcipher;

import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;

public class MatrixCursor
  extends AbstractCursor
{
  public final int columnCount;
  public final String[] columnNames;
  public Object[] data;
  public int rowCount = 0;
  
  public MatrixCursor(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 16);
  }
  
  public MatrixCursor(String[] paramArrayOfString, int paramInt)
  {
    columnNames = paramArrayOfString;
    columnCount = paramArrayOfString.length;
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    data = new Object[columnCount * i];
  }
  
  private void addRow(ArrayList<?> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size();
    if (i == columnCount)
    {
      rowCount += 1;
      Object[] arrayOfObject = data;
      for (int j = 0; j < i; j++) {
        arrayOfObject[(paramInt + j)] = paramArrayList.get(j);
      }
      return;
    }
    paramArrayList = a.a("columnNames.length = ");
    paramArrayList.append(columnCount);
    paramArrayList.append(", columnValues.size() = ");
    paramArrayList.append(i);
    throw new IllegalArgumentException(paramArrayList.toString());
  }
  
  private void ensureCapacity(int paramInt)
  {
    Object[] arrayOfObject1 = data;
    if (paramInt > arrayOfObject1.length)
    {
      int i = arrayOfObject1.length * 2;
      if (i >= paramInt) {
        paramInt = i;
      }
      Object[] arrayOfObject2 = new Object[paramInt];
      data = arrayOfObject2;
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    }
  }
  
  private Object get(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = columnCount;
      if (paramInt < i)
      {
        int j = mPos;
        if (j >= 0)
        {
          if (j < rowCount) {
            return data[(j * i + paramInt)];
          }
          throw new CursorIndexOutOfBoundsException("After last row.");
        }
        throw new CursorIndexOutOfBoundsException("Before first row.");
      }
    }
    StringBuilder localStringBuilder = a.a("Requested column: ", paramInt, ", # of columns: ");
    localStringBuilder.append(columnCount);
    throw new CursorIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void addRow(Iterable<?> paramIterable)
  {
    int i = rowCount;
    int j = columnCount;
    i *= j;
    j += i;
    ensureCapacity(j);
    if ((paramIterable instanceof ArrayList))
    {
      addRow((ArrayList)paramIterable, i);
      return;
    }
    Object[] arrayOfObject = data;
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = localIterator.next();
      if (i != j)
      {
        arrayOfObject[i] = paramIterable;
        i++;
      }
      else
      {
        throw new IllegalArgumentException("columnValues.size() > columnNames.length");
      }
    }
    if (i == j)
    {
      rowCount += 1;
      return;
    }
    throw new IllegalArgumentException("columnValues.size() < columnNames.length");
  }
  
  public void addRow(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = columnCount;
    if (i == j)
    {
      i = rowCount;
      rowCount = (i + 1);
      i *= j;
      ensureCapacity(j + i);
      System.arraycopy(paramArrayOfObject, 0, data, i, columnCount);
      return;
    }
    StringBuilder localStringBuilder = a.a("columnNames.length = ");
    localStringBuilder.append(columnCount);
    localStringBuilder.append(", columnValues.length = ");
    localStringBuilder.append(paramArrayOfObject.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String[] getColumnNames()
  {
    return columnNames;
  }
  
  public int getCount()
  {
    return rowCount;
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).doubleValue();
    }
    return Double.parseDouble(localObject.toString());
  }
  
  public float getFloat(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).floatValue();
    }
    return Float.parseFloat(localObject.toString());
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).intValue();
    }
    return Integer.parseInt(localObject.toString());
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).longValue();
    }
    return Long.parseLong(localObject.toString());
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).shortValue();
    }
    return Short.parseShort(localObject.toString());
  }
  
  public String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public int getType(int paramInt)
  {
    return DatabaseUtils.getTypeOfObject(get(paramInt));
  }
  
  public boolean isNull(int paramInt)
  {
    boolean bool;
    if (get(paramInt) == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public RowBuilder newRow()
  {
    int i = rowCount + 1;
    rowCount = i;
    i *= columnCount;
    ensureCapacity(i);
    return new RowBuilder(i - columnCount, i);
  }
  
  public class RowBuilder
  {
    public final int endIndex;
    public int index;
    
    public RowBuilder(int paramInt1, int paramInt2)
    {
      index = paramInt1;
      endIndex = paramInt2;
    }
    
    public RowBuilder add(Object paramObject)
    {
      if (index != endIndex)
      {
        Object[] arrayOfObject = MatrixCursor.access$000(MatrixCursor.this);
        int i = index;
        index = (i + 1);
        arrayOfObject[i] = paramObject;
        return this;
      }
      throw new CursorIndexOutOfBoundsException("No more columns left.");
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.MatrixCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */