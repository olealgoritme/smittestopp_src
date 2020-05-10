package k.c.a.a.a.s.s;

import java.io.InputStream;

public class v
  extends InputStream
{
  public byte[] A;
  public int B;
  public int C;
  public int D = 0;
  public byte[] x;
  public int y;
  public int z;
  
  public v(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    x = ((byte[])paramArrayOfByte1.clone());
    A = ((byte[])paramArrayOfByte2.clone());
    y = paramInt1;
    B = paramInt3;
    z = paramInt2;
    C = paramInt4;
  }
  
  public int read()
  {
    int i = D;
    int j = z;
    if (i < j)
    {
      j = x[(y + i)];
    }
    else
    {
      if (i >= C + j) {
        break label78;
      }
      j = A[(B + i - j)];
    }
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    D += 1;
    return i;
    label78:
    return -1;
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.s.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */