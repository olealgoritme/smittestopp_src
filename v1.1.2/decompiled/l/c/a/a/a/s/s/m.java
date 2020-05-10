package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class m
  extends b
{
  public m(o paramo)
  {
    super((byte)5);
    b = b;
  }
  
  public m(byte[] paramArrayOfByte)
  {
    super((byte)5);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public byte[] l()
  {
    return g();
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */