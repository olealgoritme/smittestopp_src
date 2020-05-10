package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public abstract class u
{
  public static final Charset e = StandardCharsets.UTF_8;
  public static final String[] f = { "reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT" };
  public byte a;
  public int b;
  public boolean c = false;
  public k.c.a.a.a.q d;
  
  public u(byte paramByte)
  {
    a = ((byte)paramByte);
    b = 0;
  }
  
  public static String a(DataInputStream paramDataInputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramDataInputStream.readUnsignedShort()];
      paramDataInputStream.readFully(arrayOfByte);
      paramDataInputStream = new java/lang/String;
      paramDataInputStream.<init>(arrayOfByte, e);
      a(paramDataInputStream);
      return paramDataInputStream;
    }
    catch (IOException paramDataInputStream)
    {
      throw new k.c.a.a.a.k(paramDataInputStream);
    }
  }
  
  public static u a(InputStream paramInputStream)
  {
    try
    {
      a locala = new k/c/a/a/a/s/s/a;
      locala.<init>(paramInputStream);
      DataInputStream localDataInputStream = new java/io/DataInputStream;
      localDataInputStream.<init>(locala);
      int i = localDataInputStream.readUnsignedByte();
      int j = (byte)(i >> 4);
      byte b1 = (byte)(i & 0xF);
      long l = ba;
      l = y + l - y;
      paramInputStream = new byte[0];
      if (l > 0L)
      {
        i = (int)l;
        paramInputStream = new byte[i];
        localDataInputStream.readFully(paramInputStream, 0, i);
      }
      if (j == 1)
      {
        paramInputStream = new d(paramInputStream);
      }
      else if (j == 3)
      {
        paramInputStream = new o(b1, paramInputStream);
      }
      else if (j == 4)
      {
        paramInputStream = new k(paramInputStream);
      }
      else if (j == 7)
      {
        paramInputStream = new l(paramInputStream);
      }
      else if (j == 2)
      {
        paramInputStream = new c(paramInputStream);
      }
      else if (j == 12)
      {
        paramInputStream = new i(b1, paramInputStream);
      }
      else if (j == 13)
      {
        paramInputStream = new j();
      }
      else if (j == 8)
      {
        paramInputStream = new r(paramInputStream);
      }
      else if (j == 9)
      {
        paramInputStream = new q(paramInputStream);
      }
      else if (j == 10)
      {
        paramInputStream = new t(paramInputStream);
      }
      else if (j == 11)
      {
        paramInputStream = new s(paramInputStream);
      }
      else if (j == 6)
      {
        paramInputStream = new n(paramInputStream);
      }
      else if (j == 5)
      {
        paramInputStream = new m(paramInputStream);
      }
      else
      {
        if (j != 14) {
          break label353;
        }
        paramInputStream = new e(b1, paramInputStream);
      }
      return paramInputStream;
      label353:
      throw k.b.c.e.a.a(6);
    }
    catch (IOException paramInputStream)
    {
      throw new k.c.a.a.a.k(paramInputStream);
    }
  }
  
  public static u a(k.c.a.a.a.m paramm)
  {
    byte[] arrayOfByte1 = paramm.d();
    byte[] arrayOfByte2 = arrayOfByte1;
    if (arrayOfByte1 == null) {
      arrayOfByte2 = new byte[0];
    }
    return a(new v(paramm.c(), paramm.b(), paramm.f(), arrayOfByte2, paramm.e(), paramm.a()));
  }
  
  public static u a(byte[] paramArrayOfByte)
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static void a(DataOutputStream paramDataOutputStream, String paramString)
  {
    a(paramString);
    try
    {
      paramString = paramString.getBytes(e);
      int i = (byte)(paramString.length >>> 8 & 0xFF);
      int j = (byte)(paramString.length >>> 0 & 0xFF);
      paramDataOutputStream.write(i);
      paramDataOutputStream.write(j);
      paramDataOutputStream.write(paramString);
      return;
    }
    catch (IOException paramDataOutputStream)
    {
      throw new k.c.a.a.a.k(paramDataOutputStream);
    }
    catch (UnsupportedEncodingException paramDataOutputStream)
    {
      throw new k.c.a.a.a.k(paramDataOutputStream);
    }
  }
  
  public static void a(String paramString)
  {
    int j;
    int k;
    for (int i = 0;; i = k + 1)
    {
      if (i >= paramString.length()) {
        return;
      }
      j = paramString.charAt(i);
      if (Character.isHighSurrogate(j))
      {
        i++;
        if (i == paramString.length())
        {
          k = i;
          break label166;
        }
        char c1 = paramString.charAt(i);
        if (Character.isLowSurrogate(c1))
        {
          k = i;
          break label166;
        }
        int m = (c1 & 0x3FF | (j & 0x3FF) << 10) & 0xFFFF;
        k = i;
        if (m == 65535) {
          break label166;
        }
        k = i;
        if (m == 65534)
        {
          k = i;
          break label166;
        }
      }
      else
      {
        k = i;
        if (Character.isISOControl(j)) {
          break label166;
        }
        if (Character.isLowSurrogate(j))
        {
          k = i;
          break label166;
        }
        k = i;
        if (j >= 64976)
        {
          k = i;
          if (j == 65534) {
            break label166;
          }
          k = i;
          if (j >= 64976) {
            break label166;
          }
          k = i;
          if (j <= 64991)
          {
            k = i;
            break label166;
          }
        }
      }
      i = 0;
      break label168;
      label166:
      i = 1;
      label168:
      if (i != 0) {
        break;
      }
    }
    throw new IllegalArgumentException(String.format("Invalid UTF-8 char: [%x]", new Object[] { Integer.valueOf(j) }));
  }
  
  public static byte[] a(long paramLong)
  {
    int i = (int)paramLong;
    if ((i >= 0) && (i <= 268435455))
    {
      i = 0;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int k;
      do
      {
        int j = (byte)(int)(paramLong % 128L);
        paramLong /= 128L;
        boolean bool = paramLong < 0L;
        k = j;
        if (bool) {
          k = (byte)(j | 0x80);
        }
        localByteArrayOutputStream.write(k);
        k = i + 1;
        if (!bool) {
          break;
        }
        i = k;
      } while (k < 4);
      return localByteArrayOutputStream.toByteArray();
    }
    throw new IllegalArgumentException("This property must be a number between 0 and 268435455");
  }
  
  public static w b(DataInputStream paramDataInputStream)
  {
    int i = 0;
    int j = 0;
    int k = 1;
    int m;
    int n;
    int i1;
    do
    {
      m = paramDataInputStream.readByte();
      n = i + 1;
      i1 = j + (m & 0x7F) * k;
      k *= 128;
      i = n;
      j = i1;
    } while ((m & 0x80) != 0);
    if ((i1 >= 0) && (i1 <= 268435455)) {
      return new w(i1, n);
    }
    paramDataInputStream = new StringBuilder("This property must be a number between 0 and 268435455. Read value was: ");
    paramDataInputStream.append(i1);
    throw new IOException(paramDataInputStream.toString());
  }
  
  public void a(int paramInt)
  {
    b = paramInt;
  }
  
  public byte[] g()
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
      throw new k.c.a.a.a.k(localIOException);
    }
  }
  
  public byte[] h()
  {
    try
    {
      int i = a;
      int j = j();
      byte[] arrayOfByte = l();
      int k = arrayOfByte.length;
      int m = k().length;
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      ((DataOutputStream)localObject).writeByte((i & 0xF) << 4 ^ j & 0xF);
      ((DataOutputStream)localObject).write(a(k + m));
      ((DataOutputStream)localObject).write(arrayOfByte);
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new k.c.a.a.a.k(localIOException);
    }
  }
  
  public String i()
  {
    return Integer.toString(b);
  }
  
  public abstract byte j();
  
  public byte[] k()
  {
    return new byte[0];
  }
  
  public abstract byte[] l();
  
  public boolean m()
  {
    return true;
  }
  
  public String toString()
  {
    return f[a];
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.s.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */