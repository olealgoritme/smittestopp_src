package l.a.b.a.d.g0;

public class w
  extends l<l0, l0>
{
  public w(l0 paraml01, l0 paraml02)
  {
    super(paraml01, paraml02);
  }
  
  public int bufferSize()
  {
    return b.b.length;
  }
  
  public void makeDetermination(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= b.b.length)
    {
      for (int i = 0;; i++)
      {
        byte[] arrayOfByte = b.b;
        if (i >= arrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[i] != arrayOfByte[i])
        {
          _selectedTransportWrapper = _wrapper2;
          return;
        }
      }
      _selectedTransportWrapper = _wrapper1;
      return;
    }
    throw new IllegalArgumentException("insufficient bytes");
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */