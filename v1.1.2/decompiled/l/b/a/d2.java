package l.b.a;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class d2
{
  public static final long a = Runtime.getRuntime().maxMemory();
  
  public static int a(int paramInt)
  {
    int i = 1;
    int j = 1;
    if (paramInt > 127)
    {
      for (i = 1;; i++)
      {
        paramInt >>>= 8;
        if (paramInt == 0) {
          break;
        }
      }
      int k = (i - 1) * 8;
      paramInt = j;
      for (;;)
      {
        i = paramInt;
        if (k < 0) {
          break;
        }
        paramInt++;
        k -= 8;
      }
    }
    return i;
  }
  
  public static int a(InputStream paramInputStream)
  {
    if ((paramInputStream instanceof b2)) {
      return y;
    }
    if ((paramInputStream instanceof k)) {
      return x;
    }
    if ((paramInputStream instanceof ByteArrayInputStream)) {
      return ((ByteArrayInputStream)paramInputStream).available();
    }
    if ((paramInputStream instanceof FileInputStream)) {
      try
      {
        paramInputStream = ((FileInputStream)paramInputStream).getChannel();
        if (paramInputStream != null) {
          l = paramInputStream.size();
        } else {
          l = 2147483647L;
        }
        if (l < 2147483647L) {
          return (int)l;
        }
      }
      catch (IOException paramInputStream) {}
    }
    long l = a;
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public static int b(int paramInt)
  {
    int i = 1;
    if (paramInt >= 31) {
      if (paramInt < 128)
      {
        i = 2;
      }
      else
      {
        byte[] arrayOfByte = new byte[5];
        i = 4;
        int j;
        int k;
        do
        {
          j = paramInt >> 7;
          k = i - 1;
          arrayOfByte[k] = ((byte)(byte)(j & 0x7F | 0x80));
          i = k;
          paramInt = j;
        } while (j > 127);
        i = 1 + (5 - k);
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     l.b.a.d2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */