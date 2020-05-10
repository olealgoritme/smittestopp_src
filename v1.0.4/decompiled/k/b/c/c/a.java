package k.b.c.c;

public abstract class a
  implements k.b.c.a
{
  public final byte[] a = new byte[4];
  public int b = 0;
  public long c;
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = a;
    int i = b;
    int j = i + 1;
    b = j;
    arrayOfByte[i] = ((byte)paramByte);
    if (j == arrayOfByte.length)
    {
      b(arrayOfByte, 0);
      b = 0;
    }
    c += 1L;
  }
  
  public abstract void a(long paramLong);
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = Math.max(0, paramInt2);
    paramInt2 = i;
    byte[] arrayOfByte;
    int k;
    if (b != 0) {
      for (paramInt2 = 0; paramInt2 < j; paramInt2 = i)
      {
        arrayOfByte = a;
        k = b;
        int m = k + 1;
        b = m;
        i = paramInt2 + 1;
        arrayOfByte[k] = ((byte)paramArrayOfByte[(paramInt2 + paramInt1)]);
        if (m == 4)
        {
          b(arrayOfByte, 0);
          b = 0;
          paramInt2 = i;
          break;
        }
      }
    }
    for (i = paramInt2;; i = k + 4)
    {
      k = i;
      i = k;
      if (k >= (j - paramInt2 & 0xFFFFFFFC) + paramInt2) {
        break;
      }
      b(paramArrayOfByte, paramInt1 + k);
    }
    while (i < j)
    {
      arrayOfByte = a;
      paramInt2 = b;
      b = (paramInt2 + 1);
      arrayOfByte[paramInt2] = ((byte)paramArrayOfByte[(i + paramInt1)]);
      i++;
    }
    c += j;
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt);
  
  public void c()
  {
    long l = c;
    byte b1 = Byte.MIN_VALUE;
    for (byte b2 = b1;; b2 = b1)
    {
      a(b2);
      if (b == 0) {
        break;
      }
      b1 = 0;
    }
    a(l << 3);
    d();
  }
  
  public abstract void d();
  
  public void e()
  {
    c = 0L;
    b = 0;
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = a;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = ((byte)0);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.c.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */