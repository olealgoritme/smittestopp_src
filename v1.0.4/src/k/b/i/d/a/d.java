package k.b.i.d.a;

public class d
{
  public int[] a;
  
  public d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 4)
    {
      int i = 0;
      int j = k.b.c.e.a.a(paramArrayOfByte, 0);
      int k = c.a(j - 1);
      if (paramArrayOfByte.length == j * k + 4)
      {
        a = new int[j];
        for (int m = 0; m < j; m++)
        {
          arrayOfInt = a;
          n = k - 1;
          i1 = 0;
          while (n >= 0)
          {
            i1 |= (paramArrayOfByte[(m * k + 4 + n)] & 0xFF) << n * 8;
            n--;
          }
          arrayOfInt[m] = i1;
        }
        int[] arrayOfInt = a;
        int i1 = arrayOfInt.length;
        paramArrayOfByte = new boolean[i1];
        for (m = 0; m < i1; m++)
        {
          n = i;
          if (arrayOfInt[m] < 0) {
            break label202;
          }
          n = i;
          if (arrayOfInt[m] >= i1) {
            break label202;
          }
          if (paramArrayOfByte[arrayOfInt[m]] != 0)
          {
            n = i;
            break label202;
          }
          paramArrayOfByte[arrayOfInt[m]] = 1;
        }
        int n = 1;
        label202:
        if (n != 0) {
          return;
        }
        throw new IllegalArgumentException("invalid encoding");
      }
      throw new IllegalArgumentException("invalid encoding");
    }
    throw new IllegalArgumentException("invalid encoding");
  }
  
  public byte[] a()
  {
    int i = a.length;
    int j = c.a(i - 1);
    byte[] arrayOfByte = new byte[i * j + 4];
    int k = 0;
    k.b.c.e.a.a(i, arrayOfByte, 0);
    while (k < i)
    {
      int m = a[k];
      for (int n = j - 1; n >= 0; n--) {
        arrayOfByte[(k * j + 4 + n)] = ((byte)(byte)(m >>> n * 8));
      }
      k++;
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    return k.b.c.e.a.a(a, a);
  }
  
  public int hashCode()
  {
    return k.b.c.e.a.b(a);
  }
  
  public String toString()
  {
    Object localObject = e.a.a.a.a.a("[");
    ((StringBuilder)localObject).append(a[0]);
    localObject = ((StringBuilder)localObject).toString();
    for (int i = 1; i < a.length; i++)
    {
      localObject = e.a.a.a.a.a((String)localObject, ", ");
      ((StringBuilder)localObject).append(a[i]);
      localObject = ((StringBuilder)localObject).toString();
    }
    return e.a.a.a.a.b((String)localObject, "]");
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.d.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */