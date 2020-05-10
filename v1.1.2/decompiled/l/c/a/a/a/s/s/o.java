package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import l.c.a.a.a.k;
import l.c.a.a.a.l;

public class o
  extends h
{
  public l g;
  public String h;
  public byte[] i = null;
  
  public o(byte paramByte, byte[] paramArrayOfByte)
  {
    super((byte)3);
    Object localObject = new p();
    g = ((l)localObject);
    ((l)localObject).a(0x3 & paramByte >> 1);
    if ((paramByte & 0x1) == 1)
    {
      localObject = g;
      ((l)localObject).a();
      d = true;
    }
    if ((paramByte & 0x8) == 8) {
      g).e = true;
    }
    a locala = new a(new ByteArrayInputStream(paramArrayOfByte));
    localObject = new DataInputStream(locala);
    h = u.a((DataInputStream)localObject);
    if (g.c > 0) {
      b = ((DataInputStream)localObject).readUnsignedShort();
    }
    paramArrayOfByte = new byte[paramArrayOfByte.length - y];
    ((DataInputStream)localObject).readFully(paramArrayOfByte);
    ((DataInputStream)localObject).close();
    g.a(paramArrayOfByte);
  }
  
  public o(String paramString, l paraml)
  {
    super((byte)3);
    h = paramString;
    g = paraml;
  }
  
  public int a()
  {
    int j;
    try
    {
      j = k().length;
    }
    catch (k localk)
    {
      j = 0;
    }
    return j;
  }
  
  public void a(int paramInt)
  {
    b = paramInt;
    l locall = g;
    if ((locall instanceof p)) {
      f = paramInt;
    }
  }
  
  public byte j()
  {
    l locall = g;
    byte b1 = (byte)(c << 1);
    byte b2 = b1;
    if (d) {
      b2 = (byte)(b1 | 0x1);
    }
    byte b3;
    if (!g.e)
    {
      b3 = b2;
      if (!c) {}
    }
    else
    {
      b2 = (byte)(b2 | 0x8);
      b3 = b2;
    }
    return b3;
  }
  
  public byte[] k()
  {
    if (i == null) {
      i = g.b;
    }
    return i;
  }
  
  public byte[] l()
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      u.a(localDataOutputStream, h);
      if (g.c > 0) {
        localDataOutputStream.writeShort(b);
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
  
  public boolean m()
  {
    return true;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = g.b;
    int j = Math.min(arrayOfByte.length, 20);
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        try
        {
          String str = new java/lang/String;
          str.<init>(arrayOfByte, 0, j, "UTF-8");
        }
        catch (Exception localException)
        {
          localObject1 = "?";
        }
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(super.toString());
        ((StringBuffer)localObject2).append(" qos:");
        ((StringBuffer)localObject2).append(g.c);
        if (g.c > 0)
        {
          ((StringBuffer)localObject2).append(" msgId:");
          ((StringBuffer)localObject2).append(b);
        }
        ((StringBuffer)localObject2).append(" retained:");
        ((StringBuffer)localObject2).append(g.d);
        ((StringBuffer)localObject2).append(" dup:");
        ((StringBuffer)localObject2).append(c);
        ((StringBuffer)localObject2).append(" topic:\"");
        ((StringBuffer)localObject2).append(h);
        ((StringBuffer)localObject2).append("\"");
        ((StringBuffer)localObject2).append(" payload:[hex:");
        ((StringBuffer)localObject2).append(localStringBuffer);
        ((StringBuffer)localObject2).append(" utf8:\"");
        ((StringBuffer)localObject2).append((String)localObject1);
        ((StringBuffer)localObject2).append("\"");
        ((StringBuffer)localObject2).append(" length:");
        ((StringBuffer)localObject2).append(arrayOfByte.length);
        ((StringBuffer)localObject2).append("]");
        return ((StringBuffer)localObject2).toString();
      }
      Object localObject2 = Integer.toHexString(arrayOfByte[k]);
      Object localObject1 = localObject2;
      if (((String)localObject2).length() == 1)
      {
        localObject1 = new StringBuilder("0");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localStringBuffer.append((String)localObject1);
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */