package k.a.b.a.b.n;

public enum o
{
  static
  {
    o localo = new o("RECEIVER", 1);
    RECEIVER = localo;
    $VALUES = new o[] { SENDER, localo };
  }
  
  public o() {}
  
  public boolean getValue()
  {
    boolean bool;
    if (this == RECEIVER) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */