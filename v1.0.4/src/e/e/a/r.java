package e.e.a;

public enum r
{
  static
  {
    RECOMMENDED = new r("RECOMMENDED", 1);
    r localr = new r("OPTIONAL", 2);
    OPTIONAL = localr;
    $VALUES = new r[] { REQUIRED, RECOMMENDED, localr };
  }
  
  public r() {}
}

/* Location:
 * Qualified Name:     base.e.e.a.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */