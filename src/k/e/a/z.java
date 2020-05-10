package k.e.a;

public final class z
{
  public final byte[] a;
  public final int b;
  
  public z(byte[] paramArrayOfByte, int paramInt)
  {
    a = paramArrayOfByte;
    b = paramInt;
  }
  
  public static void a(z paramz, c paramc)
  {
    if (paramz == null)
    {
      paramc.b(0);
    }
    else
    {
      byte[] arrayOfByte = a;
      int i = b;
      paramc.a(arrayOfByte, i, arrayOfByte[i] * 2 + 1);
    }
  }
  
  public String toString()
  {
    int i = a[b];
    StringBuilder localStringBuilder = new StringBuilder(i * 2);
    for (int j = 0; j < i; j++)
    {
      byte[] arrayOfByte = a;
      int k = b;
      int m = j * 2;
      int n = arrayOfByte[(m + k + 1)];
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            if (n == 3)
            {
              localStringBuilder.append(arrayOfByte[(m + k + 2)]);
              localStringBuilder.append(';');
            }
            else
            {
              throw new AssertionError();
            }
          }
          else {
            localStringBuilder.append('*');
          }
        }
        else {
          localStringBuilder.append('.');
        }
      }
      else {
        localStringBuilder.append('[');
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */