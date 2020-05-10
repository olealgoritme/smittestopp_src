package g.e;

public enum i$b
{
  static
  {
    CONNECTED = new b("CONNECTED", 1);
    IDLE = new b("IDLE", 2);
    b localb = new b("CONNECTING", 3);
    CONNECTING = localb;
    $VALUES = new b[] { UNINITIALIZED, CONNECTED, IDLE, localb };
  }
  
  public i$b() {}
}

/* Location:
 * Qualified Name:     base.g.e.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */