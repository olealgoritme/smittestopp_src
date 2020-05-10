package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class k
  extends b
{
  public k(int paramInt)
  {
    super((byte)4);
    b = paramInt;
  }
  
  public k(o paramo)
  {
    super((byte)4);
    b = b;
  }
  
  public k(byte[] paramArrayOfByte)
  {
    super((byte)4);
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
 * Qualified Name:     base.k.c.a.a.a.s.s.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */