package l.b.f.a;

import java.math.BigInteger;
import java.util.Arrays;

public abstract class c
  implements a
{
  public int a()
  {
    return h().bitLength();
  }
  
  public abstract c a(c paramc);
  
  public abstract int b();
  
  public abstract c b(c paramc);
  
  public abstract c c();
  
  public abstract c c(c paramc);
  
  public boolean d()
  {
    int i = a();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean e()
  {
    boolean bool;
    if (h().signum() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract c f();
  
  public abstract c g();
  
  public abstract BigInteger h();
  
  public String toString()
  {
    return h().toString(16);
  }
  
  public static abstract class a
    extends c
  {}
  
  public static abstract class b
    extends c
  {}
  
  public static class c
    extends c.a
  {
    public int d;
    public int e;
    public int[] f;
    public e g;
    
    public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BigInteger paramBigInteger)
    {
      if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt1))
      {
        if ((paramInt3 == 0) && (paramInt4 == 0))
        {
          d = 2;
          f = new int[] { paramInt2 };
        }
        else
        {
          if (paramInt3 >= paramInt4) {
            break label118;
          }
          if (paramInt3 <= 0) {
            break label108;
          }
          d = 3;
          f = new int[] { paramInt2, paramInt3, paramInt4 };
        }
        e = paramInt1;
        g = new e(paramBigInteger);
        return;
        label108:
        throw new IllegalArgumentException("k2 must be larger than 0");
        label118:
        throw new IllegalArgumentException("k2 must be smaller than k3");
      }
      throw new IllegalArgumentException("x value invalid in F2m field element");
    }
    
    public c(int paramInt, int[] paramArrayOfInt, e parame)
    {
      e = paramInt;
      if (paramArrayOfInt.length == 1) {
        paramInt = 2;
      } else {
        paramInt = 3;
      }
      d = paramInt;
      f = paramArrayOfInt;
      g = parame;
    }
    
    public int a()
    {
      return g.a();
    }
    
    public c a(c paramc)
    {
      e locale1 = (e)g.clone();
      e locale2 = g;
      int i = locale2.b();
      if (i != 0)
      {
        int j = i + 0;
        long[] arrayOfLong = x;
        if (j > arrayOfLong.length)
        {
          paramc = new long[j];
          System.arraycopy(arrayOfLong, 0, paramc, 0, Math.min(arrayOfLong.length, j));
          x = paramc;
        }
        e.a(x, 0, x, 0, i);
      }
      return new c(e, f, locale1);
    }
    
    public int b()
    {
      return e;
    }
    
    public c b(c paramc)
    {
      return c(paramc.c());
    }
    
    public c c()
    {
      int i = e;
      int[] arrayOfInt = f;
      Object localObject1 = g;
      int j = ((e)localObject1).a();
      if (j != 0)
      {
        Object localObject2;
        int k;
        Object localObject3;
        e locale2;
        e[] arrayOfe;
        int m;
        int n;
        if (j != 1)
        {
          localObject2 = (e)((e)localObject1).clone();
          k = i + 63 >>> 6;
          localObject3 = new e(k);
          e.a(x, 0, i, i, arrayOfInt);
          e locale1 = new e(k);
          x[0] = 1L;
          locale2 = new e(k);
          localObject1 = new int[2];
          localObject1[0] = j;
          localObject1[1] = (i + 1);
          arrayOfe = new e[2];
          arrayOfe[0] = localObject2;
          arrayOfe[1] = localObject3;
          localObject3 = new int[2];
          Object tmp146_144 = localObject3;
          tmp146_144[0] = 1;
          Object tmp150_146 = tmp146_144;
          tmp150_146[1] = 0;
          tmp150_146;
          localObject2 = new e[2];
          localObject2[0] = locale1;
          localObject2[1] = locale2;
          m = localObject1[1];
          j = localObject3[1];
          n = m - localObject1[0];
        }
        int i4;
        for (int i1 = 1;; i1 = i4)
        {
          int i2 = m;
          k = j;
          int i3 = n;
          i4 = i1;
          if (n < 0)
          {
            i3 = -n;
            localObject1[i1] = m;
            localObject3[i1] = j;
            i4 = 1 - i1;
            i2 = localObject1[i4];
            k = localObject3[i4];
          }
          locale2 = arrayOfe[i4];
          j = 1 - i4;
          locale2.a(arrayOfe[j], localObject1[j], i3);
          m = arrayOfe[i4].a(i2);
          if (m == 0)
          {
            localObject1 = localObject2[j];
            return new c(i, arrayOfInt, (e)localObject1);
          }
          n = localObject3[j];
          localObject2[i4].a(localObject2[j], n, i3);
          n += i3;
          if (n > k)
          {
            j = n;
          }
          else
          {
            j = k;
            if (n == k) {
              j = localObject2[i4].a(k);
            }
          }
          n = i3 + (m - i2);
        }
      }
      throw new IllegalStateException();
    }
    
    public c c(c paramc)
    {
      int i = e;
      int[] arrayOfInt = f;
      Object localObject1 = g;
      Object localObject2 = g;
      int j = ((e)localObject1).a();
      if (j == 0)
      {
        paramc = (c)localObject1;
      }
      else
      {
        int k = ((e)localObject2).a();
        if (k == 0) {}
        for (;;)
        {
          paramc = (c)localObject2;
          break;
          if (j > k)
          {
            m = j;
            j = k;
            paramc = (c)localObject1;
          }
          else
          {
            paramc = (c)localObject2;
            m = k;
            localObject2 = localObject1;
          }
          int n = j + 63 >>> 6;
          k = m + 63 >>> 6;
          int i1 = j + m + 62 >>> 6;
          long l1;
          if (n == 1)
          {
            l1 = x[0];
            if (l1 == 1L) {
              break;
            }
            localObject2 = new long[i1];
            paramc = x;
            if ((l1 & 1L) != 0L) {
              e.a((long[])localObject2, 0, paramc, 0, k);
            }
            for (m = 1;; m++)
            {
              l1 >>>= 1;
              if (l1 == 0L) {
                break;
              }
              if ((l1 & 1L) != 0L)
              {
                long l2 = e.a((long[])localObject2, 0, paramc, 0, k, m);
                if (l2 != 0L)
                {
                  j = k + 0;
                  localObject2[j] = (l2 ^ localObject2[j]);
                }
              }
            }
            paramc = new e((long[])localObject2, 0, e.b((long[])localObject2, 0, i1, i, arrayOfInt));
            break;
          }
          int i2 = m + 7 + 63 >>> 6;
          localObject1 = new int[16];
          int m = i2 << 4;
          Object localObject3 = new long[m];
          localObject1[1] = i2;
          System.arraycopy(x, 0, localObject3, i2, k);
          j = 2;
          k = i2;
          paramc = (c)localObject3;
          while (j < 16)
          {
            i3 = k + i2;
            localObject1[j] = i3;
            if ((j & 0x1) == 0)
            {
              e.c(paramc, i3 >>> 1, paramc, i3, i2, 1);
            }
            else
            {
              localObject3 = paramc;
              for (k = 0; k < i2; k++) {
                localObject3[(i2 + k)] ^= localObject3[(i3 - i2 + k)];
              }
            }
            j++;
            k = i3;
          }
          localObject3 = new long[m];
          e.c(paramc, 0, (long[])localObject3, 0, m, 4);
          localObject2 = x;
          int i3 = i1 << 3;
          long[] arrayOfLong = new long[i3];
          m = 0;
          j = i3;
          if (m < n)
          {
            l1 = localObject2[m];
            j = m;
            for (;;)
            {
              int i4 = (int)l1;
              l1 >>>= 4;
              k = (int)l1;
              i4 = localObject1[(i4 & 0xF)];
              int i5 = localObject1[(k & 0xF)];
              for (k = 0; k < i2; k++)
              {
                int i6 = j + k;
                arrayOfLong[i6] ^= paramc[(i4 + k)] ^ localObject3[(i5 + k)];
              }
              l1 >>>= 4;
              if (l1 == 0L)
              {
                m++;
                break;
              }
              j += i1;
            }
          }
          for (;;)
          {
            j -= i1;
            if (j == 0) {
              break;
            }
            e.a(arrayOfLong, j - i1, arrayOfLong, j, i1, 8);
          }
          localObject2 = new e(arrayOfLong, 0, e.b(arrayOfLong, 0, i1, i, arrayOfInt));
        }
      }
      return new c(i, arrayOfInt, paramc);
    }
    
    public boolean d()
    {
      long[] arrayOfLong = g.x;
      boolean bool = false;
      if (arrayOfLong[0] == 1L)
      {
        for (int i = 1; i < arrayOfLong.length; i++) {
          if (arrayOfLong[i] != 0L) {
            return bool;
          }
        }
        bool = true;
      }
      return bool;
    }
    
    public boolean e()
    {
      long[] arrayOfLong = g.x;
      boolean bool = false;
      for (int i = 0; i < arrayOfLong.length; i++) {
        if (arrayOfLong[i] != 0L) {
          return bool;
        }
      }
      bool = true;
      return bool;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      if ((e != e) || (d != d) || (!Arrays.equals(f, f)) || (!g.equals(g))) {
        bool = false;
      }
      return bool;
    }
    
    public c f()
    {
      return this;
    }
    
    public c g()
    {
      int i = e;
      int[] arrayOfInt = f;
      e locale = g;
      int j = locale.b();
      if (j != 0)
      {
        int k = j << 1;
        long[] arrayOfLong = new long[k];
        j = 0;
        while (j < k)
        {
          long l = x[(j >>> 1)];
          int m = j + 1;
          arrayOfLong[j] = e.b((int)l);
          j = m + 1;
          arrayOfLong[m] = e.b((int)(l >>> 32));
        }
        locale = new e(arrayOfLong, 0, e.b(arrayOfLong, 0, k, i, arrayOfInt));
      }
      return new c(i, arrayOfInt, locale);
    }
    
    public BigInteger h()
    {
      Object localObject1 = g;
      int i = ((e)localObject1).b();
      if (i == 0)
      {
        localObject1 = a.a;
      }
      else
      {
        Object localObject2 = x;
        int j = i - 1;
        long l = localObject2[j];
        byte[] arrayOfByte = new byte[8];
        int k = 0;
        int m = 7;
        int n = 0;
        int i1 = 0;
        while (m >= 0)
        {
          int i2 = (byte)(int)(l >>> m * 8);
          int i3;
          if (i1 == 0)
          {
            i3 = n;
            if (i2 == 0) {}
          }
          else
          {
            arrayOfByte[n] = ((byte)i2);
            i3 = n + 1;
            i1 = 1;
          }
          m--;
          n = i3;
        }
        localObject2 = new byte[j * 8 + n];
        for (m = k; m < n; m++) {
          localObject2[m] = ((byte)arrayOfByte[m]);
        }
        i1 = i - 2;
        m = n;
        for (n = i1; n >= 0; n--)
        {
          l = x[n];
          i1 = 7;
          while (i1 >= 0)
          {
            localObject2[m] = ((byte)(byte)(int)(l >>> i1 * 8));
            i1--;
            m++;
          }
        }
        localObject1 = new BigInteger(1, (byte[])localObject2);
      }
      return (BigInteger)localObject1;
    }
    
    public int hashCode()
    {
      return g.hashCode() ^ e ^ l.b.c.e.a.b(f);
    }
  }
  
  public static class d
    extends c.b
  {
    public BigInteger d;
    public BigInteger e;
    public BigInteger f;
    
    public d(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
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
      Object localObject = l.b.c.e.a.a(i, d);
      int[] arrayOfInt1 = l.b.c.e.a.a(i, paramBigInteger);
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
        if (l.b.c.e.a.a(k, arrayOfInt1))
        {
          System.arraycopy(arrayOfInt1, 0, paramBigInteger, 0, k);
        }
        else
        {
          arrayOfInt2 = new int[k];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, k);
          arrayOfInt3 = new int[k];
          arrayOfInt3[0] = 1;
          if ((arrayOfInt2[0] & 0x1) == 0) {
            i = l.b.c.e.a.a((int[])localObject, arrayOfInt2, k, arrayOfInt3, 0);
          } else {
            i = 0;
          }
          if (l.b.c.e.a.a(k, arrayOfInt2))
          {
            l.b.c.e.a.a((int[])localObject, i, arrayOfInt3, paramBigInteger);
          }
          else
          {
            arrayOfInt1 = new int[k];
            System.arraycopy(localObject, 0, arrayOfInt1, 0, k);
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
            if (arrayOfInt1[i1] == 0)
            {
              m = i1;
              continue;
            }
          }
          while (i2 >= 0)
          {
            int i3 = arrayOfInt2[i2] ^ 0x80000000;
            i1 = arrayOfInt1[i2] ^ 0x80000000;
            if (i3 < i1)
            {
              i2 = 0;
              break label297;
            }
            if (i3 > i1) {
              break;
            }
            i2--;
          }
          i2 = 1;
          if (i2 != 0)
          {
            l.b.c.e.a.a(m, arrayOfInt1, arrayOfInt2);
            i2 = l.b.c.e.a.a((int[])localObject, arrayOfInt2, m, arrayOfInt3, l.b.c.e.a.a(k, arrayOfInt4, arrayOfInt3) - n + i);
            i = i2;
            if (!l.b.c.e.a.a(m, arrayOfInt2)) {
              break label474;
            }
            i = i2;
            break;
          }
          l.b.c.e.a.a(m, arrayOfInt2, arrayOfInt1);
          i2 = l.b.c.e.a.a((int[])localObject, arrayOfInt1, m, arrayOfInt4, l.b.c.e.a.a(k, arrayOfInt3, arrayOfInt4) - i + n);
          n = i2;
          if (l.b.c.e.a.a(m, arrayOfInt1))
          {
            l.b.c.e.a.a((int[])localObject, i2, arrayOfInt4, paramBigInteger);
            localObject = new byte[j << 2];
            for (i = 0; i < j; i++)
            {
              n = paramBigInteger[i];
              if (n != 0) {
                l.b.c.e.a.b(n, (byte[])localObject, j - 1 - i << 2);
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
      paramBigInteger1 = paramBigInteger1.multiply(paramBigInteger2);
      if (e != null)
      {
        int i;
        if (paramBigInteger1.signum() < 0) {
          i = 1;
        } else {
          i = 0;
        }
        paramBigInteger2 = paramBigInteger1;
        if (i != 0) {
          paramBigInteger2 = paramBigInteger1.abs();
        }
        int j = d.bitLength();
        boolean bool = e.equals(a.b);
        for (;;)
        {
          paramBigInteger1 = paramBigInteger2;
          if (paramBigInteger2.bitLength() <= j + 1) {
            break;
          }
          BigInteger localBigInteger = paramBigInteger2.shiftRight(j);
          paramBigInteger2 = paramBigInteger2.subtract(localBigInteger.shiftLeft(j));
          paramBigInteger1 = localBigInteger;
          if (!bool) {
            paramBigInteger1 = localBigInteger.multiply(e);
          }
          paramBigInteger2 = paramBigInteger1.add(paramBigInteger2);
        }
        while (paramBigInteger1.compareTo(d) >= 0) {
          paramBigInteger1 = paramBigInteger1.subtract(d);
        }
        paramBigInteger2 = paramBigInteger1;
        if (i != 0)
        {
          paramBigInteger2 = paramBigInteger1;
          if (paramBigInteger1.signum() != 0) {
            paramBigInteger2 = d.subtract(paramBigInteger1);
          }
        }
      }
      else
      {
        paramBigInteger2 = paramBigInteger1.mod(d);
      }
      return paramBigInteger2;
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
}

/* Location:
 * Qualified Name:     l.b.f.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */