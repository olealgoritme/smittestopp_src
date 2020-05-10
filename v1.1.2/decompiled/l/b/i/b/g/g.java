package l.b.i.b.g;

import l.b.c.e.a;

public final class g
  extends o
{
  public final int e;
  public final int f;
  public final int g;
  
  public byte[] a()
  {
    byte[] arrayOfByte = super.a();
    a.b(e, arrayOfByte, 16);
    a.b(f, arrayOfByte, 20);
    a.b(g, arrayOfByte, 24);
    return arrayOfByte;
  }
  
  public static class b
    extends o.a<b>
  {
    public int e = 0;
    public int f = 0;
    
    public b()
    {
      super();
    }
    
    public o.a a()
    {
      return this;
    }
    
    public o b()
    {
      return new g(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     l.b.i.b.g.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */