package e.e.a.v;

import i.a.b.i;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

public class a
  implements i.a.b.b, Serializable
{
  public final String x;
  
  public a(String paramString)
  {
    if (paramString != null)
    {
      x = paramString;
      return;
    }
    throw new IllegalArgumentException("The Base64 value must not be null");
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("\"");
    localStringBuilder.append(i.a(x));
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public byte[] b()
  {
    Object localObject = x;
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = ((String)localObject).getBytes(d.a);
      int i = localObject.length;
      byte[] arrayOfByte = new byte[i * 6 >> 3];
      int j = 0;
      int k = 0;
      while (j < localObject.length)
      {
        int m = 0;
        int i2;
        int i4;
        for (int n = 0; (m < 4) && (j < i); n = i4)
        {
          int i1 = localObject[j];
          i2 = b.b(i1, 64) & b.c(i1, 91);
          int i3 = b.b(i1, 96) & b.c(i1, 123);
          i4 = b.b(i1, 47) & b.c(i1, 58);
          int i5 = b.a(i1, 45);
          i5 = b.a(i1, 43) | i5;
          int i6 = b.a(i1, 95);
          i6 = b.a(i1, 47) | i6;
          i3 = b.a(i2, i1 - 65 + 0, 0) | b.a(i3, i1 - 97 + 26, 0) | b.a(i4, i1 - 48 + 52, 0) | b.a(i5, 62, 0) | b.a(i6, 63, 0) | b.a(i2 | i3 | i4 | i5 | i6, 0, -1);
          i2 = m;
          i4 = n;
          if (i3 >= 0)
          {
            i4 = n | i3 << 18 - m * 6;
            i2 = m + 1;
          }
          j++;
          m = i2;
        }
        if (m >= 2)
        {
          i2 = k + 1;
          arrayOfByte[k] = ((byte)(byte)(n >> 16));
          k = i2;
          if (m >= 3)
          {
            i4 = i2 + 1;
            arrayOfByte[i2] = ((byte)(byte)(n >> 8));
            k = i4;
            if (m >= 4)
            {
              k = i4 + 1;
              arrayOfByte[i4] = ((byte)(byte)n);
            }
          }
          else {}
        }
      }
      localObject = Arrays.copyOf(arrayOfByte, k);
    }
    else
    {
      localObject = new byte[0];
    }
    return (byte[])localObject;
  }
  
  public BigInteger d()
  {
    return new BigInteger(1, b());
  }
  
  public String e()
  {
    return new String(b(), d.a);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && ((paramObject instanceof a)) && (x.equals(paramObject.toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */