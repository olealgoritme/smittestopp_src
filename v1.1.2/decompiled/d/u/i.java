package d.u;

import d.w.a.d;
import d.w.a.e;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;

public class i
  implements e, d
{
  public static final TreeMap<Integer, i> F = new TreeMap();
  public final String[] A;
  public final byte[][] B;
  public final int[] C;
  public final int D;
  public int E;
  public volatile String x;
  public final long[] y;
  public final double[] z;
  
  public i(int paramInt)
  {
    D = paramInt;
    paramInt++;
    C = new int[paramInt];
    y = new long[paramInt];
    z = new double[paramInt];
    A = new String[paramInt];
    B = new byte[paramInt][];
  }
  
  public static i a(String paramString, int paramInt)
  {
    synchronized (F)
    {
      Object localObject2 = F.ceilingEntry(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        F.remove(((Map.Entry)localObject2).getKey());
        localObject2 = (i)((Map.Entry)localObject2).getValue();
        x = paramString;
        E = paramInt;
        return (i)localObject2;
      }
      ??? = new i(paramInt);
      x = paramString;
      E = paramInt;
      return (i)???;
    }
  }
  
  public String a()
  {
    return x;
  }
  
  public void a(d paramd)
  {
    for (int i = 1; i <= E; i++)
    {
      int j = C[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {
                paramd.bindBlob(i, B[i]);
              }
            }
            else {
              paramd.bindString(i, A[i]);
            }
          }
          else {
            paramd.bindDouble(i, z[i]);
          }
        }
        else {
          paramd.bindLong(i, y[i]);
        }
      }
      else {
        paramd.bindNull(i);
      }
    }
  }
  
  public void b()
  {
    synchronized (F)
    {
      F.put(Integer.valueOf(D), this);
      if (F.size() > 15)
      {
        int i = F.size() - 10;
        Iterator localIterator = F.descendingKeySet().iterator();
        while (i > 0)
        {
          localIterator.next();
          localIterator.remove();
          i--;
        }
      }
      return;
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    C[paramInt] = 5;
    B[paramInt] = paramArrayOfByte;
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    C[paramInt] = 3;
    z[paramInt] = paramDouble;
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    C[paramInt] = 2;
    y[paramInt] = paramLong;
  }
  
  public void bindNull(int paramInt)
  {
    C[paramInt] = 1;
  }
  
  public void bindString(int paramInt, String paramString)
  {
    C[paramInt] = 4;
    A[paramInt] = paramString;
  }
  
  public void close() {}
}

/* Location:
 * Qualified Name:     d.u.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */