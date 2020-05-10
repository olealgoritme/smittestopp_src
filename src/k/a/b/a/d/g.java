package k.a.b.a.d;

public enum g
{
  static
  {
    ACTIVE = new g("ACTIVE", 1);
    g localg = new g("CLOSED", 2);
    CLOSED = localg;
    $VALUES = new g[] { UNINITIALIZED, ACTIVE, localg };
  }
  
  public g() {}
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */