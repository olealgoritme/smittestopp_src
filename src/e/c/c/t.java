package e.c.c;

public enum t
{
  static
  {
    t.b localb = new t.b("STRING", 1);
    STRING = localb;
    $VALUES = new t[] { DEFAULT, localb };
  }
  
  public t() {}
  
  public abstract j serialize(Long paramLong);
}

/* Location:
 * Qualified Name:     base.e.c.c.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */