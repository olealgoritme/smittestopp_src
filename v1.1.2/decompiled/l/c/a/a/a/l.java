package l.c.a.a.a;

public class l
{
  public boolean a = true;
  public byte[] b;
  public int c = 1;
  public boolean d = false;
  public boolean e = false;
  public int f;
  
  public l()
  {
    a(new byte[0]);
  }
  
  public l(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
  }
  
  public void a()
  {
    if (a) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(int paramInt)
  {
    a();
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      c = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a();
    if (paramArrayOfByte != null)
    {
      b = ((byte[])paramArrayOfByte.clone());
      return;
    }
    throw null;
  }
  
  public String toString()
  {
    return new String(b);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */