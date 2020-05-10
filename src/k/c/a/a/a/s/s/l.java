package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class l
  extends b
{
  public l(int paramInt)
  {
    super((byte)7);
    b = paramInt;
  }
  
  public l(o paramo)
  {
    super((byte)7);
    b = b;
  }
  
  public l(byte[] paramArrayOfByte)
  {
    super((byte)7);
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
 * Qualified Name:     base.k.c.a.a.a.s.s.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */