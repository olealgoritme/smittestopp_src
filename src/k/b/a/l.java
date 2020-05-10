package k.b.a;

import java.math.BigInteger;
import java.util.Arrays;
import k.b.j.e;

public class l
  extends t
{
  public final byte[] x;
  public final int y;
  
  public l(long paramLong)
  {
    x = BigInteger.valueOf(paramLong).toByteArray();
    y = 0;
  }
  
  public l(BigInteger paramBigInteger)
  {
    x = paramBigInteger.toByteArray();
    y = 0;
  }
  
  public l(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (!b(paramArrayOfByte))
    {
      byte[] arrayOfByte;
      if (paramBoolean) {
        arrayOfByte = k.b.c.e.a.a(paramArrayOfByte);
      } else {
        arrayOfByte = paramArrayOfByte;
      }
      x = arrayOfByte;
      y = c(paramArrayOfByte);
      return;
    }
    throw new IllegalArgumentException("malformed integer");
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    int j = Math.max(paramInt1, i - 4);
    paramInt1 = paramInt2 & paramArrayOfByte[j];
    paramInt2 = j;
    for (;;)
    {
      paramInt2++;
      if (paramInt2 >= i) {
        break;
      }
      paramInt1 = paramInt1 << 8 | paramArrayOfByte[paramInt2] & 0xFF;
    }
    return paramInt1;
  }
  
  public static l a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof l)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (l)t.a((byte[])paramObject);
          return (l)paramObject;
        }
        catch (Exception paramObject)
        {
          throw new IllegalArgumentException(e.a.a.a.a.a((Exception)paramObject, e.a.a.a.a.a("encoding error in getInstance: ")));
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("illegal object in getInstance: ")));
    }
    return (l)paramObject;
  }
  
  public static l a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = paramb0.j();
    if ((!paramBoolean) && (!(paramb0 instanceof l))) {
      return new l(p.a(paramb0).j(), true);
    }
    return a(paramb0);
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    boolean bool = true;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((paramArrayOfByte[0] != paramArrayOfByte[1] >> 7) || (e.a("org.bouncycastle.asn1.allow_unsafe_integer"))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    return true;
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int m;
    for (int j = 0; j < i - 1; j = m)
    {
      int k = paramArrayOfByte[j];
      m = j + 1;
      if (k != paramArrayOfByte[m] >> 7) {
        break;
      }
    }
    return j;
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 2, x);
  }
  
  public boolean a(BigInteger paramBigInteger)
  {
    boolean bool;
    if ((paramBigInteger != null) && (a(x, y, -1) == paramBigInteger.intValue()) && (j().equals(paramBigInteger))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof l)) {
      return false;
    }
    paramt = (l)paramt;
    return Arrays.equals(x, x);
  }
  
  public int f()
  {
    return d2.a(x.length) + 1 + x.length;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public int hashCode()
  {
    return k.b.c.e.a.d(x);
  }
  
  public BigInteger j()
  {
    return new BigInteger(x);
  }
  
  public int k()
  {
    byte[] arrayOfByte = x;
    int i = arrayOfByte.length;
    int j = y;
    if (i - j <= 4) {
      return a(arrayOfByte, j, -1);
    }
    throw new ArithmeticException("ASN.1 Integer out of int range");
  }
  
  public long l()
  {
    byte[] arrayOfByte = x;
    int i = arrayOfByte.length;
    int j = y;
    if (i - j <= 8)
    {
      i = arrayOfByte.length;
      j = Math.max(j, i - 8);
      for (long l = 0xFFFFFFFF & arrayOfByte[j];; l = l << 8 | arrayOfByte[j] & 0xFF)
      {
        j++;
        if (j >= i) {
          break;
        }
      }
      return l;
    }
    throw new ArithmeticException("ASN.1 Integer out of long range");
  }
  
  public String toString()
  {
    return j().toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */