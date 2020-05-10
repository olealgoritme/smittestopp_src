package net.sqlcipher.database;

import android.util.SparseArray;
import d.w.a.d;

public class BindingsRecorder
  implements d
{
  public SparseArray<Object> bindings = new SparseArray();
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    bindings.put(paramInt, paramArrayOfByte);
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    bindings.put(paramInt, Double.valueOf(paramDouble));
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    bindings.put(paramInt, Long.valueOf(paramLong));
  }
  
  public void bindNull(int paramInt)
  {
    bindings.put(paramInt, null);
  }
  
  public void bindString(int paramInt, String paramString)
  {
    bindings.put(paramInt, paramString);
  }
  
  public void clearBindings()
  {
    bindings.clear();
  }
  
  public void close()
  {
    clearBindings();
  }
  
  public String[] getBindings()
  {
    String[] arrayOfString = new String[bindings.size()];
    for (int i = 0; i < bindings.size(); i++)
    {
      int j = bindings.keyAt(i);
      if (bindings.get(j) != null) {
        arrayOfString[i] = bindings.get(j).toString();
      } else {
        arrayOfString[i] = "";
      }
    }
    return arrayOfString;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.BindingsRecorder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */