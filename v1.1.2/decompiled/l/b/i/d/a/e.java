package l.b.i.d.a;

public class e
{
  public b a;
  public int b;
  public int[] c;
  
  public e(b paramb, int paramInt)
  {
    a = paramb;
    b = paramInt;
    paramb = new int[paramInt + 1];
    c = paramb;
    paramb[paramInt] = 1;
  }
  
  public e(b paramb, byte[] paramArrayOfByte)
  {
    a = paramb;
    int i = 8;
    int j = 1;
    while (a > i)
    {
      j++;
      i += 8;
    }
    if (paramArrayOfByte.length % j == 0)
    {
      c = new int[paramArrayOfByte.length / j];
      j = 0;
      int k = 0;
      for (;;)
      {
        paramb = c;
        if (j >= paramb.length) {
          break label149;
        }
        int m = 0;
        while (m < i)
        {
          paramb = c;
          int n = paramb[j];
          paramb[j] = ((paramArrayOfByte[k] & 0xFF) << m ^ n);
          m += 8;
          k++;
        }
        if (!a.b(c[j])) {
          break;
        }
        j++;
      }
      throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      label149:
      if ((paramb.length != 1) && (paramb[(paramb.length - 1)] == 0)) {
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
      }
      a();
      return;
    }
    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
  }
  
  public e(b paramb, int[] paramArrayOfInt)
  {
    a = paramb;
    int i = a(paramArrayOfInt);
    if (i == -1)
    {
      paramb = new int[1];
    }
    else
    {
      int j = paramArrayOfInt.length;
      i++;
      if (j == i)
      {
        paramb = new int[paramArrayOfInt.length];
        System.arraycopy(paramArrayOfInt, 0, paramb, 0, paramArrayOfInt.length);
      }
      else
      {
        paramb = new int[i];
        System.arraycopy(paramArrayOfInt, 0, paramb, 0, i);
      }
    }
    c = paramb;
    a();
  }
  
  public e(e parame)
  {
    a = a;
    b = b;
    c = l.b.c.e.a.a(c);
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    for (int i = paramArrayOfInt.length - 1; (i >= 0) && (paramArrayOfInt[i] == 0); i--) {}
    return i;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= b)) {
      return c[paramInt];
    }
    return 0;
  }
  
  public final void a()
  {
    int i = c.length;
    do
    {
      b = (i - 1);
      i = b;
    } while ((i >= 0) && (c[i] == 0));
  }
  
  public final int[] a(int[] paramArrayOfInt, int paramInt)
  {
    int i = a(paramArrayOfInt);
    if ((i != -1) && (paramInt != 0))
    {
      if (paramInt == 1)
      {
        arrayOfInt = new int[paramArrayOfInt.length];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
        return arrayOfInt;
      }
      int[] arrayOfInt = new int[i + 1];
      while (i >= 0)
      {
        arrayOfInt[i] = a.a(paramArrayOfInt[i], paramInt);
        i--;
      }
      return arrayOfInt;
    }
    return new int[1];
  }
  
  public final int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Object localObject;
    if (paramArrayOfInt1.length < paramArrayOfInt2.length)
    {
      localObject = new int[paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt2, 0, localObject, 0, paramArrayOfInt2.length);
      paramArrayOfInt2 = (int[])localObject;
    }
    else
    {
      localObject = new int[paramArrayOfInt1.length];
      System.arraycopy(paramArrayOfInt1, 0, localObject, 0, paramArrayOfInt1.length);
      paramArrayOfInt1 = paramArrayOfInt2;
      paramArrayOfInt2 = (int[])localObject;
    }
    int i = paramArrayOfInt1.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        return paramArrayOfInt2;
      }
      localObject = a;
      int j = paramArrayOfInt2[i];
      int k = paramArrayOfInt1[i];
      if (localObject == null) {
        break;
      }
      paramArrayOfInt2[i] = (j ^ k);
    }
    throw null;
    return paramArrayOfInt2;
  }
  
  public int b()
  {
    int[] arrayOfInt = c;
    int i = arrayOfInt.length - 1;
    if (arrayOfInt[i] == 0) {
      return -1;
    }
    return i;
  }
  
  public void b(int paramInt)
  {
    if (a.b(paramInt))
    {
      c = a(c, paramInt);
      a();
      return;
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public e c(int paramInt)
  {
    if (a.b(paramInt))
    {
      int[] arrayOfInt = a(c, paramInt);
      return new e(a, arrayOfInt);
    }
    throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
  }
  
  public byte[] c()
  {
    int i = 8;
    int j = 1;
    while (a.a > i)
    {
      j++;
      i += 8;
    }
    byte[] arrayOfByte = new byte[c.length * j];
    j = 0;
    int k = 0;
    while (j < c.length)
    {
      int m = 0;
      while (m < i)
      {
        arrayOfByte[k] = ((byte)(byte)(c[j] >>> m));
        m += 8;
        k++;
      }
      j++;
    }
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof e)))
    {
      Object localObject = (e)paramObject;
      if ((a.equals(a)) && (b == b))
      {
        paramObject = c;
        localObject = c;
        int i = a((int[])paramObject);
        int j;
        if (i != a((int[])localObject))
        {
          j = 0;
        }
        else
        {
          for (j = 0;; j++)
          {
            if (j > i) {
              break label102;
            }
            if (paramObject[j] != localObject[j]) {
              break;
            }
          }
          label102:
          j = 1;
        }
        if (j != 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a.b;
    for (int j = 0;; j++)
    {
      int[] arrayOfInt = c;
      if (j >= arrayOfInt.length) {
        break;
      }
      i = i * 31 + arrayOfInt[j];
    }
    return i;
  }
  
  public String toString()
  {
    Object localObject = e.a.a.a.a.a(" Polynomial over ");
    ((StringBuilder)localObject).append(a.toString());
    ((StringBuilder)localObject).append(": \n");
    localObject = ((StringBuilder)localObject).toString();
    for (int i = 0; i < c.length; i++)
    {
      StringBuilder localStringBuilder1 = e.a.a.a.a.a((String)localObject);
      b localb = a;
      int j = c[i];
      localObject = "";
      for (int k = 0; k < a; k++)
      {
        StringBuilder localStringBuilder2;
        String str;
        if (((byte)j & 0x1) == 0)
        {
          localStringBuilder2 = new StringBuilder();
          str = "0";
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          str = "1";
        }
        localObject = e.a.a.a.a.a(localStringBuilder2, str, (String)localObject);
        j >>>= 1;
      }
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("Y^");
      localStringBuilder1.append(i);
      localStringBuilder1.append("+");
      localObject = localStringBuilder1.toString();
    }
    return e.a.a.a.a.b((String)localObject, ";");
  }
}

/* Location:
 * Qualified Name:     l.b.i.d.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */