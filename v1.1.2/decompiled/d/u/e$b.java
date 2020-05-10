package d.u;

import java.util.Arrays;

public class e$b
{
  public final long[] a;
  public final boolean[] b;
  public final int[] c;
  public boolean d;
  public boolean e;
  
  public e$b(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    a = arrayOfLong;
    b = new boolean[paramInt];
    c = new int[paramInt];
    Arrays.fill(arrayOfLong, 0L);
    Arrays.fill(b, false);
  }
  
  public boolean a(int... paramVarArgs)
  {
    try
    {
      int i = paramVarArgs.length;
      int j = 0;
      boolean bool = false;
      while (j < i)
      {
        int k = paramVarArgs[j];
        long l = a[k];
        a[k] = (1L + l);
        if (l == 0L)
        {
          d = true;
          bool = true;
        }
        j++;
      }
      return bool;
    }
    finally {}
  }
  
  public int[] a()
  {
    try
    {
      if ((d) && (!e))
      {
        int i = a.length;
        for (int j = 0;; j++)
        {
          int k = 1;
          if (j >= i) {
            break;
          }
          int m;
          if (a[j] > 0L) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != b[j])
          {
            arrayOfInt = c;
            if (m == 0) {
              k = 2;
            }
            arrayOfInt[j] = k;
          }
          else
          {
            c[j] = 0;
          }
          b[j] = m;
        }
        e = true;
        d = false;
        int[] arrayOfInt = c;
        return arrayOfInt;
      }
      return null;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      e = false;
      return;
    }
    finally {}
  }
  
  public boolean b(int... paramVarArgs)
  {
    try
    {
      int i = paramVarArgs.length;
      int j = 0;
      boolean bool = false;
      while (j < i)
      {
        int k = paramVarArgs[j];
        long l = a[k];
        a[k] = (l - 1L);
        if (l == 1L)
        {
          d = true;
          bool = true;
        }
        j++;
      }
      return bool;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     d.u.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */