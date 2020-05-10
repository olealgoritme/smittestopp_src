package l.b.a;

import java.io.OutputStream;
import java.util.Arrays;

public class q0
  extends t
  implements a0
{
  public final char[] x;
  
  public q0(char[] paramArrayOfChar)
  {
    x = paramArrayOfChar;
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    int i = x.length;
    if (paramBoolean) {
      a.write(30);
    }
    paramr.a(i * 2);
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int k;
    int m;
    int n;
    int i1;
    while (j < (i & 0xFFFFFFFC))
    {
      char[] arrayOfChar = x;
      k = arrayOfChar[j];
      m = arrayOfChar[(j + 1)];
      n = arrayOfChar[(j + 2)];
      i1 = arrayOfChar[(j + 3)];
      j += 4;
      arrayOfByte[0] = ((byte)(byte)(k >> 8));
      arrayOfByte[1] = ((byte)(byte)k);
      arrayOfByte[2] = ((byte)(byte)(m >> 8));
      arrayOfByte[3] = ((byte)(byte)m);
      arrayOfByte[4] = ((byte)(byte)(n >> 8));
      arrayOfByte[5] = ((byte)(byte)n);
      arrayOfByte[6] = ((byte)(byte)(i1 >> 8));
      arrayOfByte[7] = ((byte)(byte)i1);
      a.write(arrayOfByte, 0, 8);
    }
    if (j < i)
    {
      n = 0;
      do
      {
        k = x[j];
        m = j + 1;
        j = n + 1;
        arrayOfByte[n] = ((byte)(byte)(k >> 8));
        i1 = j + 1;
        arrayOfByte[j] = ((byte)(byte)k);
        j = m;
        n = i1;
      } while (m < i);
      a.write(arrayOfByte, 0, i1);
    }
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof q0)) {
      return false;
    }
    paramt = (q0)paramt;
    return Arrays.equals(x, x);
  }
  
  public String c()
  {
    return new String(x);
  }
  
  public int f()
  {
    int i = d2.a(x.length * 2);
    return x.length * 2 + (i + 1);
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int hashCode()
  {
    char[] arrayOfChar = x;
    int i;
    if (arrayOfChar == null)
    {
      i = 0;
    }
    else
    {
      int j = arrayOfChar.length;
      for (i = j + 1;; i = i * 257 ^ arrayOfChar[j])
      {
        j--;
        if (j < 0) {
          break;
        }
      }
    }
    return i;
  }
  
  public String toString()
  {
    return c();
  }
}

/* Location:
 * Qualified Name:     l.b.a.q0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */