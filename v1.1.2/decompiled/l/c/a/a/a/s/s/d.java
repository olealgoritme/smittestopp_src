package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import l.c.a.a.a.k;
import l.c.a.a.a.l;

public class d
  extends u
{
  public String g;
  public boolean h;
  public l i;
  public String j;
  public char[] k;
  public int l;
  public String m;
  public int n;
  
  public d(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, String paramString2, char[] paramArrayOfChar, l paraml, String paramString3)
  {
    super((byte)1);
    g = paramString1;
    h = paramBoolean;
    l = paramInt2;
    j = paramString2;
    if (paramArrayOfChar != null) {
      k = ((char[])paramArrayOfChar.clone());
    }
    i = paraml;
    m = paramString3;
    n = paramInt1;
  }
  
  public d(byte[] paramArrayOfByte)
  {
    super((byte)1);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    u.a(paramArrayOfByte);
    paramArrayOfByte.readByte();
    paramArrayOfByte.readByte();
    l = paramArrayOfByte.readUnsignedShort();
    g = u.a(paramArrayOfByte);
    paramArrayOfByte.close();
  }
  
  public String i()
  {
    return "Con";
  }
  
  public byte j()
  {
    return 0;
  }
  
  public byte[] k()
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      u.a(localDataOutputStream, g);
      if (i != null)
      {
        u.a(localDataOutputStream, m);
        localDataOutputStream.writeShort(i.b.length);
        localDataOutputStream.write(i.b);
      }
      if (j != null)
      {
        u.a(localDataOutputStream, j);
        if (k != null)
        {
          String str = new java/lang/String;
          str.<init>(k);
          u.a(localDataOutputStream, str);
        }
      }
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new k(localIOException);
    }
  }
  
  public byte[] l()
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      if (n == 3) {
        u.a(localDataOutputStream, "MQIsdp");
      } else if (n == 4) {
        u.a(localDataOutputStream, "MQTT");
      }
      localDataOutputStream.write(n);
      int i1 = 0;
      if (h) {
        i1 = (byte)2;
      }
      int i2 = i1;
      if (i != null)
      {
        i1 = (byte)((byte)(i1 | 0x4) | i.c << 3);
        i2 = i1;
        if (i.d) {
          i2 = (byte)(i1 | 0x20);
        }
      }
      i1 = i2;
      if (j != null)
      {
        i2 = (byte)(i2 | 0x80);
        i1 = i2;
        if (k != null) {
          i1 = (byte)(i2 | 0x40);
        }
      }
      localDataOutputStream.write(i1);
      localDataOutputStream.writeShort(l);
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new k(localIOException);
    }
  }
  
  public boolean m()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" clientId ");
    localStringBuilder.append(g);
    localStringBuilder.append(" keepAliveInterval ");
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */