package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class n
  extends h
{
  public n(m paramm)
  {
    super((byte)6);
    b = b;
  }
  
  public n(byte[] paramArrayOfByte)
  {
    super((byte)6);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
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
  
  public byte[] l()
  {
    return g();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" msgId ");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.s.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */