package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class s
  extends b
{
  public s(byte[] paramArrayOfByte)
  {
    super((byte)11);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  public byte[] l()
  {
    return new byte[0];
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */