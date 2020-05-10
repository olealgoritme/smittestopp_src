package k.a.b.a.b.l;

import k.a.b.a.b.g;

public enum b
{
  static
  {
    AUTH = new b("AUTH", 1);
    SYS = new b("SYS", 2);
    SYS_PERM = new b("SYS_PERM", 3);
    b localb = new b("SYS_TEMP", 4);
    SYS_TEMP = localb;
    $VALUES = new b[] { OK, AUTH, SYS, SYS_PERM, localb };
  }
  
  public b() {}
  
  public static b valueOf(g paramg)
  {
    return values()[x];
  }
  
  public g getValue()
  {
    return g.a((byte)ordinal());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.l.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */