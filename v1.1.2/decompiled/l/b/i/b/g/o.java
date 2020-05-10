package l.b.i.b.g;

import l.b.c.e.a;

public abstract class o
{
  public final int a;
  public final long b;
  public final int c;
  public final int d;
  
  public o(a parama)
  {
    a = b;
    b = c;
    c = a;
    d = d;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[32];
    a.b(a, arrayOfByte, 0);
    a.a(b, arrayOfByte, 4);
    a.b(c, arrayOfByte, 12);
    a.b(d, arrayOfByte, 28);
    return arrayOfByte;
  }
  
  public static abstract class a<T extends a>
  {
    public final int a;
    public int b = 0;
    public long c = 0L;
    public int d = 0;
    
    public a(int paramInt)
    {
      a = paramInt;
    }
    
    public abstract T a();
    
    public T a(int paramInt)
    {
      d = paramInt;
      return a();
    }
    
    public T a(long paramLong)
    {
      c = paramLong;
      return a();
    }
    
    public T b(int paramInt)
    {
      b = paramInt;
      return a();
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */