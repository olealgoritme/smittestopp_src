package d.o;

public enum g$b
{
  static
  {
    CREATED = new b("CREATED", 2);
    STARTED = new b("STARTED", 3);
    b localb = new b("RESUMED", 4);
    RESUMED = localb;
    $VALUES = new b[] { DESTROYED, INITIALIZED, CREATED, STARTED, localb };
  }
  
  public g$b() {}
  
  public boolean isAtLeast(b paramb)
  {
    boolean bool;
    if (compareTo(paramb) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     d.o.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */