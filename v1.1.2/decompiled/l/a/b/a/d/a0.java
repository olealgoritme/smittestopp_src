package l.a.b.a.d;

public abstract interface a0
{
  public static enum a
  {
    static
    {
      a locala = new a("SERVER", 1);
      SERVER = locala;
      $VALUES = new a[] { CLIENT, locala };
    }
    
    public a() {}
  }
  
  public static enum b
  {
    static
    {
      b localb = new b("ANONYMOUS_PEER", 2);
      ANONYMOUS_PEER = localb;
      $VALUES = new b[] { VERIFY_PEER, VERIFY_PEER_NAME, localb };
    }
    
    public b() {}
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */