package k.c.a.a.a.s.s;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class q
  extends b
{
  public int[] g;
  
  public q(byte[] paramArrayOfByte)
  {
    super((byte)9);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    b = localDataInputStream.readUnsignedShort();
    g = new int[paramArrayOfByte.length - 2];
    int i = localDataInputStream.read();
    int j = 0;
    for (;;)
    {
      if (i == -1)
      {
        localDataInputStream.close();
        return;
      }
      g[j] = i;
      j++;
      i = localDataInputStream.read();
    }
  }
  
  public byte[] l()
  {
    return new byte[0];
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" granted Qos");
    int[] arrayOfInt = g;
    int i = arrayOfInt.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localStringBuffer.toString();
      }
      int k = arrayOfInt[j];
      localStringBuffer.append(" ");
      localStringBuffer.append(k);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.s.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */