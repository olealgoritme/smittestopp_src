package l.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class c
  extends b
{
  public int g;
  public boolean h;
  
  public c(byte[] paramArrayOfByte)
  {
    super((byte)2);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    int i = paramArrayOfByte.readUnsignedByte();
    boolean bool = true;
    if ((i & 0x1) != 1) {
      bool = false;
    }
    h = bool;
    g = paramArrayOfByte.readUnsignedByte();
    paramArrayOfByte.close();
  }
  
  public String i()
  {
    return "Con";
  }
  
  public byte[] l()
  {
    return new byte[0];
  }
  
  public boolean m()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(super.toString()));
    localStringBuilder.append(" session present:");
    localStringBuilder.append(h);
    localStringBuilder.append(" return code: ");
    localStringBuilder.append(g);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.s.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */