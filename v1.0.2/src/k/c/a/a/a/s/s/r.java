package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import k.c.a.a.a.k;

public class r
  extends u
{
  public String[] g;
  public int[] h;
  public int i;
  
  public r(byte[] paramArrayOfByte)
  {
    super((byte)8);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = paramArrayOfByte.readUnsignedShort();
    int j = 0;
    i = 0;
    g = new String[10];
    h = new int[10];
    for (;;)
    {
      if (j != 0)
      {
        paramArrayOfByte.close();
        return;
      }
      try
      {
        g[i] = u.a(paramArrayOfByte);
        int[] arrayOfInt = h;
        int k = i;
        i = (k + 1);
        arrayOfInt[k] = paramArrayOfByte.readByte();
      }
      catch (Exception localException)
      {
        j = 1;
      }
    }
  }
  
  public r(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super((byte)8);
    if ((paramArrayOfString != null) && (paramArrayOfInt != null))
    {
      g = ((String[])paramArrayOfString.clone());
      int[] arrayOfInt = (int[])paramArrayOfInt.clone();
      h = arrayOfInt;
      if (g.length == arrayOfInt.length)
      {
        i = paramArrayOfString.length;
        int j = paramArrayOfInt.length;
        for (int k = 0;; k++)
        {
          if (k >= j) {
            return;
          }
          int m = paramArrayOfInt[k];
          if ((m < 0) || (m > 2)) {
            break;
          }
        }
        throw new IllegalArgumentException();
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  public byte j()
  {
    int j;
    if (c) {
      j = 8;
    } else {
      j = 0;
    }
    return (byte)(j | 0x2);
  }
  
  /* Error */
  public byte[] k()
  {
    // Byte code:
    //   0: new 77	java/io/ByteArrayOutputStream
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial 78	java/io/ByteArrayOutputStream:<init>	()V
    //   8: new 80	java/io/DataOutputStream
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokespecial 83	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_3
    //   20: aload_0
    //   21: getfield 39	k/c/a/a/a/s/s/r:g	[Ljava/lang/String;
    //   24: arraylength
    //   25: if_icmplt +12 -> 37
    //   28: aload_2
    //   29: invokevirtual 86	java/io/DataOutputStream:flush	()V
    //   32: aload_1
    //   33: invokevirtual 89	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: areturn
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 39	k/c/a/a/a/s/s/r:g	[Ljava/lang/String;
    //   42: iload_3
    //   43: aaload
    //   44: invokestatic 92	k/c/a/a/a/s/s/u:a	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   47: aload_2
    //   48: aload_0
    //   49: getfield 41	k/c/a/a/a/s/s/r:h	[I
    //   52: iload_3
    //   53: iaload
    //   54: invokevirtual 96	java/io/DataOutputStream:writeByte	(I)V
    //   57: iinc 3 1
    //   60: goto -41 -> 19
    //   63: astore_1
    //   64: new 98	k/c/a/a/a/k
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 101	k/c/a/a/a/k:<init>	(Ljava/lang/Throwable;)V
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	r
    //   3	30	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   63	6	1	localIOException	IOException
    //   11	37	2	localDataOutputStream	DataOutputStream
    //   18	40	3	j	int
    // Exception table:
    //   from	to	target	type
    //   0	17	63	java/io/IOException
    //   19	37	63	java/io/IOException
    //   37	57	63	java/io/IOException
  }
  
  public byte[] l()
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      localDataOutputStream.writeShort(b);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new k(localIOException);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" names:[");
    int j = 0;
    for (int k = 0;; k++)
    {
      if (k >= i)
      {
        localStringBuffer.append("] qos:[");
        for (k = j;; k++)
        {
          if (k >= i)
          {
            localStringBuffer.append("]");
            return localStringBuffer.toString();
          }
          if (k > 0) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append(h[k]);
        }
      }
      if (k > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append("\"");
      localStringBuffer.append(g[k]);
      localStringBuffer.append("\"");
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.s.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */