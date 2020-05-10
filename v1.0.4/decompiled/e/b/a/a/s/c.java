package e.b.a.a.s;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends OutputStream
{
  public static final byte[] B = new byte[0];
  public int A;
  public final LinkedList<byte[]> x = new LinkedList();
  public int y;
  public byte[] z;
  
  public c(a parama)
  {
    if (parama == null) {
      parama = new byte['Ǵ'];
    } else {
      parama = parama.a(2);
    }
    z = parama;
  }
  
  public final void a()
  {
    int i = y + z.length;
    if (i >= 0)
    {
      y = i;
      int j = Math.max(i >> 1, 1000);
      i = j;
      if (j > 262144) {
        i = 262144;
      }
      x.add(z);
      z = new byte[i];
      A = 0;
      return;
    }
    throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
  }
  
  public void a(int paramInt)
  {
    if (A >= z.length) {
      a();
    }
    byte[] arrayOfByte = z;
    int i = A;
    A = (i + 1);
    arrayOfByte[i] = ((byte)(byte)paramInt);
  }
  
  public void b()
  {
    y = 0;
    A = 0;
    if (!x.isEmpty()) {
      x.clear();
    }
  }
  
  public void b(int paramInt)
  {
    int i = A;
    byte[] arrayOfByte = z;
    if (i + 2 < arrayOfByte.length)
    {
      int j = i + 1;
      A = j;
      arrayOfByte[i] = ((byte)(byte)(paramInt >> 16));
      i = j + 1;
      A = i;
      arrayOfByte[j] = ((byte)(byte)(paramInt >> 8));
      A = (i + 1);
      arrayOfByte[i] = ((byte)(byte)paramInt);
    }
    else
    {
      a(paramInt >> 16);
      a(paramInt >> 8);
      a(paramInt);
    }
  }
  
  public void c(int paramInt)
  {
    int i = A;
    byte[] arrayOfByte = z;
    if (i + 1 < arrayOfByte.length)
    {
      int j = i + 1;
      A = j;
      arrayOfByte[i] = ((byte)(byte)(paramInt >> 8));
      A = (j + 1);
      arrayOfByte[j] = ((byte)(byte)paramInt);
    }
    else
    {
      a(paramInt >> 8);
      a(paramInt);
    }
  }
  
  public byte[] c()
  {
    int i = y + A;
    if (i == 0) {
      return B;
    }
    byte[] arrayOfByte = new byte[i];
    Iterator localIterator = x.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      localObject = (byte[])localIterator.next();
      int k = localObject.length;
      System.arraycopy(localObject, 0, arrayOfByte, j, k);
      j += k;
    }
    System.arraycopy(z, 0, arrayOfByte, j, A);
    j += A;
    if (j == i)
    {
      if (!x.isEmpty()) {
        b();
      }
      return arrayOfByte;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Internal error: total len assumed to be ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", copied ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" bytes");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
  {
    a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      int j = Math.min(z.length - A, paramInt2);
      int k = i;
      paramInt1 = paramInt2;
      if (j > 0)
      {
        System.arraycopy(paramArrayOfByte, i, z, A, j);
        k = i + j;
        A += j;
        paramInt1 = paramInt2 - j;
      }
      if (paramInt1 <= 0) {
        return;
      }
      a();
      i = k;
      paramInt2 = paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.s.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */