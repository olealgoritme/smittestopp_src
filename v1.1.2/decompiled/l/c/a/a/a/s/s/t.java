package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import l.c.a.a.a.k;

public class t
  extends u
{
  public String[] g;
  public int h;
  
  public t(byte[] paramArrayOfByte)
  {
    super((byte)10);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = localDataInputStream.readUnsignedShort();
    int i = 0;
    h = 0;
    g = new String[10];
    for (;;)
    {
      if (i != 0)
      {
        localDataInputStream.close();
        return;
      }
      try
      {
        g[h] = u.a(localDataInputStream);
      }
      catch (Exception paramArrayOfByte)
      {
        i = 1;
      }
    }
  }
  
  public t(String[] paramArrayOfString)
  {
    super((byte)10);
    if (paramArrayOfString != null) {
      g = ((String[])paramArrayOfString.clone());
    }
  }
  
  public byte j()
  {
    int i;
    if (c) {
      i = 8;
    } else {
      i = 0;
    }
    return (byte)(i | 0x2);
  }
  
  /* Error */
  public byte[] k()
  {
    // Byte code:
    //   0: new 64	java/io/ByteArrayOutputStream
    //   3: astore_1
    //   4: aload_1
    //   5: invokespecial 66	java/io/ByteArrayOutputStream:<init>	()V
    //   8: new 68	java/io/DataOutputStream
    //   11: astore_2
    //   12: aload_2
    //   13: aload_1
    //   14: invokespecial 71	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: aload_0
    //   18: getfield 37	l/c/a/a/a/s/s/t:g	[Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: arraylength
    //   24: istore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 5
    //   31: iload 4
    //   33: if_icmplt +12 -> 45
    //   36: aload_2
    //   37: invokevirtual 74	java/io/DataOutputStream:flush	()V
    //   40: aload_1
    //   41: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: areturn
    //   45: aload_2
    //   46: aload_3
    //   47: iload 5
    //   49: aaload
    //   50: invokestatic 80	l/c/a/a/a/s/s/u:a	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
    //   53: iinc 5 1
    //   56: goto -27 -> 29
    //   59: astore_2
    //   60: new 82	l/c/a/a/a/k
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 85	l/c/a/a/a/k:<init>	(Ljava/lang/Throwable;)V
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	t
    //   3	38	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   11	35	2	localDataOutputStream	DataOutputStream
    //   59	6	2	localIOException	IOException
    //   21	26	3	arrayOfString	String[]
    //   24	10	4	i	int
    //   27	27	5	j	int
    // Exception table:
    //   from	to	target	type
    //   0	26	59	java/io/IOException
    //   36	45	59	java/io/IOException
    //   45	53	59	java/io/IOException
  }
  
  public byte[] l()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      ((DataOutputStream)localObject).writeShort(b);
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
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
    for (int i = 0;; i++)
    {
      if (i >= h)
      {
        localStringBuffer.append("]");
        return localStringBuffer.toString();
      }
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      StringBuilder localStringBuilder = new StringBuilder("\"");
      localStringBuilder.append(g[i]);
      localStringBuilder.append("\"");
      localStringBuffer.append(localStringBuilder.toString());
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */