package l.b.i.d.a;

public class b
{
  public int a;
  public int b;
  
  public b(byte[] paramArrayOfByte)
  {
    int i = 0;
    a = 0;
    if (paramArrayOfByte.length == 4)
    {
      int j = paramArrayOfByte[0];
      int k = paramArrayOfByte[1];
      int m = 2;
      int n = paramArrayOfByte[2];
      k = (paramArrayOfByte[3] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (n & 0xFF) << 16;
      b = k;
      if (k == 0)
      {
        m = i;
      }
      else
      {
        int i1 = l.b.c.e.a.b(k);
        j = 0;
        while (j < i1 >>> 1)
        {
          int i2 = l.b.c.e.a.a(m, m, k);
          n = i2 ^ 0x2;
          int i3;
          for (m = k; m != 0; m = i3)
          {
            i3 = l.b.c.e.a.a(n, m);
            n = m;
          }
          if (n != 1)
          {
            m = i;
            break label177;
          }
          j++;
          m = i2;
        }
        m = 1;
      }
      label177:
      if (m != 0)
      {
        a = l.b.c.e.a.b(b);
        return;
      }
      throw new IllegalArgumentException("byte array is not an encoded finite field");
    }
    throw new IllegalArgumentException("byte array is not an encoded finite field");
  }
  
  public int a(int paramInt)
  {
    int i = a;
    int j = 1;
    int k = (1 << i) - 2;
    if (k == 0)
    {
      paramInt = j;
    }
    else if (paramInt == 0)
    {
      paramInt = 0;
    }
    else if (paramInt == 1)
    {
      paramInt = j;
    }
    else
    {
      j = k;
      i = paramInt;
      if (k < 0)
      {
        i = a(paramInt);
        j = -k;
      }
      for (paramInt = 1; j != 0; paramInt = k)
      {
        k = paramInt;
        if ((j & 0x1) == 1) {
          k = a(paramInt, i);
        }
        i = a(i, i);
        j >>>= 1;
      }
    }
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return l.b.c.e.a.a(paramInt1, paramInt2, b);
  }
  
  public byte[] a()
  {
    int i = b;
    return new byte[] { (byte)i, (byte)(i >>> 8), (byte)(i >>> 16), (byte)(i >>> 24) };
  }
  
  public boolean b(int paramInt)
  {
    int i = a;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i == 31)
    {
      if (paramInt >= 0) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      if (paramInt < 1 << i) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      paramObject = (b)paramObject;
      if ((a == a) && (b == b)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Finite Field GF(2^");
    localStringBuilder.append(a);
    localStringBuilder.append(") = GF(2)[X]/<");
    int i = b;
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "0";
    }
    else
    {
      if ((byte)(i & 0x1) == 1) {
        localObject1 = "1";
      } else {
        localObject1 = "";
      }
      int j = i >>> 1;
      i = 1;
      while (j != 0)
      {
        Object localObject2 = localObject1;
        if ((byte)(j & 0x1) == 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("+x^");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        j >>>= 1;
        i++;
        localObject1 = localObject2;
      }
    }
    return e.a.a.a.a.a(localStringBuilder, (String)localObject1, "> ");
  }
}

/* Location:
 * Qualified Name:     l.b.i.d.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */