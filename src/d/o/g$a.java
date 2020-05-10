package d.o;

public enum g$a
{
  static
  {
    ON_RESUME = new a("ON_RESUME", 2);
    ON_PAUSE = new a("ON_PAUSE", 3);
    ON_STOP = new a("ON_STOP", 4);
    ON_DESTROY = new a("ON_DESTROY", 5);
    a locala = new a("ON_ANY", 6);
    ON_ANY = locala;
    $VALUES = new a[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, locala };
  }
  
  public g$a() {}
}

/* Location:
 * Qualified Name:     base.d.o.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */