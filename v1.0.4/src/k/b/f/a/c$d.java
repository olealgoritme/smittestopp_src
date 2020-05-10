package k.b.f.a;

import java.math.BigInteger;

public class c$d
  extends c.b
{
  public BigInteger d;
  public BigInteger e;
  public BigInteger f;
  
  public c$d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    if ((paramBigInteger3 != null) && (paramBigInteger3.signum() >= 0) && (paramBigInteger3.compareTo(paramBigInteger1) < 0))
    {
      d = paramBigInteger1;
      e = paramBigInteger2;
      f = paramBigInteger3;
      return;
    }
    throw new IllegalArgumentException("x value invalid in Fp field element");
  }
  
  public static BigInteger b(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.bitLength();
    if ((i >= 96) && (paramBigInteger.shiftRight(i - 64).longValue() == -1L)) {
      return a.b.shiftLeft(i).subtract(paramBigInteger);
    }
    return null;
  }
  
  public BigInteger a(BigInteger paramBigInteger)
  {
    int i = d.bitLength();
    int j = i + 31 >> 5;
    Object localObject = k.b.c.e.a.a(i, d);
    int[] arrayOfInt1 = k.b.c.e.a.a(i, paramBigInteger);
    paramBigInteger = new int[j];
    int k = localObject.length;
    for (i = 0; i < k; i++) {
      if (arrayOfInt1[i] != 0)
      {
        i = 0;
        break label69;
      }
    }
    i = 1;
    label69:
    if (i == 0)
    {
      int[] arrayOfInt2;
      int[] arrayOfInt3;
      int[] arrayOfInt4;
      int m;
      int n;
      if (k.b.c.e.a.a(k, arrayOfInt1))
      {
        System.arraycopy(arrayOfInt1, 0, paramBigInteger, 0, k);
      }
      else
      {
        arrayOfInt2 = new int[k];
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, k);
        arrayOfInt1 = new int[k];
        arrayOfInt1[0] = 1;
        if ((arrayOfInt2[0] & 0x1) == 0) {
          i = k.b.c.e.a.a((int[])localObject, arrayOfInt2, k, arrayOfInt1, 0);
        } else {
          i = 0;
        }
        if (k.b.c.e.a.a(k, arrayOfInt2))
        {
          k.b.c.e.a.a((int[])localObject, i, arrayOfInt1, paramBigInteger);
        }
        else
        {
          arrayOfInt3 = new int[k];
          System.arraycopy(localObject, 0, arrayOfInt3, 0, k);
          arrayOfInt4 = new int[k];
          m = k;
          n = 0;
        }
      }
      label297:
      label474:
      for (;;)
      {
        int i1 = m - 1;
        int i2 = i1;
        if (arrayOfInt2[i1] == 0)
        {
          i2 = i1;
          if (arrayOfInt3[i1] == 0)
          {
            m = i1;
            continue;
          }
        }
        while (i2 >= 0)
        {
          i1 = arrayOfInt2[i2] ^ 0x80000000;
          int i3 = arrayOfInt3[i2] ^ 0x80000000;
          if (i1 < i3)
          {
            i2 = 0;
            break label297;
          }
          if (i1 > i3) {
            break;
          }
          i2--;
        }
        i2 = 1;
        if (i2 != 0)
        {
          k.b.c.e.a.a(m, arrayOfInt3, arrayOfInt2);
          i2 = k.b.c.e.a.a((int[])localObject, arrayOfInt2, m, arrayOfInt1, k.b.c.e.a.a(k, arrayOfInt4, arrayOfInt1) - n + i);
          i = i2;
          if (!k.b.c.e.a.a(m, arrayOfInt2)) {
            break label474;
          }
          i = i2;
          break;
        }
        k.b.c.e.a.a(m, arrayOfInt2, arrayOfInt3);
        i2 = k.b.c.e.a.a((int[])localObject, arrayOfInt3, m, arrayOfInt4, k.b.c.e.a.a(k, arrayOfInt1, arrayOfInt4) - i + n);
        n = i2;
        if (k.b.c.e.a.a(m, arrayOfInt3))
        {
          k.b.c.e.a.a((int[])localObject, i2, arrayOfInt4, paramBigInteger);
          localObject = new byte[j << 2];
          for (i = 0; i < j; i++)
          {
            m = paramBigInteger[i];
            if (m != 0) {
              k.b.c.e.a.b(m, (byte[])localObject, j - 1 - i << 2);
            }
          }
          return new BigInteger(1, (byte[])localObject);
        }
      }
    }
    throw new IllegalArgumentException("'x' cannot be 0");
  }
  
  public BigInteger a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger2 = paramBigInteger1.multiply(paramBigInteger2);
    if (e != null)
    {
      int i;
      if (paramBigInteger2.signum() < 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramBigInteger1 = paramBigInteger2;
      if (i != 0) {
        paramBigInteger1 = paramBigInteger2.abs();
      }
      int j = d.bitLength();
      boolean bool = e.equals(a.b);
      for (;;)
      {
        paramBigInteger2 = paramBigInteger1;
        if (paramBigInteger1.bitLength() <= j + 1) {
          break;
        }
        paramBigInteger2 = paramBigInteger1.shiftRight(j);
        BigInteger localBigInteger = paramBigInteger1.subtract(paramBigInteger2.shiftLeft(j));
        paramBigInteger1 = paramBigInteger2;
        if (!bool) {
          paramBigInteger1 = paramBigInteger2.multiply(e);
        }
        paramBigInteger1 = paramBigInteger1.add(localBigInteger);
      }
      while (paramBigInteger2.compareTo(d) >= 0) {
        paramBigInteger2 = paramBigInteger2.subtract(d);
      }
      paramBigInteger1 = paramBigInteger2;
      if (i != 0)
      {
        paramBigInteger1 = paramBigInteger2;
        if (paramBigInteger2.signum() != 0) {
          paramBigInteger1 = d.subtract(paramBigInteger2);
        }
      }
    }
    else
    {
      paramBigInteger1 = paramBigInteger2.mod(d);
    }
    return paramBigInteger1;
  }
  
  public c a(c paramc)
  {
    BigInteger localBigInteger1 = d;
    BigInteger localBigInteger2 = e;
    BigInteger localBigInteger3 = f.add(paramc.h());
    paramc = localBigInteger3;
    if (localBigInteger3.compareTo(d) >= 0) {
      paramc = localBigInteger3.subtract(d);
    }
    return new d(localBigInteger1, localBigInteger2, paramc);
  }
  
  public int b()
  {
    return d.bitLength();
  }
  
  public c b(c paramc)
  {
    return new d(d, e, a(f, a(paramc.h())));
  }
  
  public c c()
  {
    return new d(d, e, a(f));
  }
  
  public c c(c paramc)
  {
    return new d(d, e, a(f, paramc.h()));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    if ((!d.equals(d)) || (!f.equals(f))) {
      bool = false;
    }
    return bool;
  }
  
  public c f()
  {
    Object localObject;
    if (f.signum() == 0)
    {
      localObject = this;
    }
    else
    {
      localObject = d;
      localObject = new d((BigInteger)localObject, e, ((BigInteger)localObject).subtract(f));
    }
    return (c)localObject;
  }
  
  public c g()
  {
    BigInteger localBigInteger1 = d;
    BigInteger localBigInteger2 = e;
    BigInteger localBigInteger3 = f;
    return new d(localBigInteger1, localBigInteger2, a(localBigInteger3, localBigInteger3));
  }
  
  public BigInteger h()
  {
    return f;
  }
  
  public int hashCode()
  {
    return d.hashCode() ^ f.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.a.c.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */