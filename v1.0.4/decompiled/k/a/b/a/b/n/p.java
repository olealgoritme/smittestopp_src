package k.a.b.a.b.n;

import k.a.b.a.b.g;

public enum p
{
  public g value;
  
  static
  {
    SETTLED = new p("SETTLED", 1, 1);
    p localp = new p("MIXED", 2, 2);
    MIXED = localp;
    $VALUES = new p[] { UNSETTLED, SETTLED, localp };
  }
  
  public p(int paramInt)
  {
    value = g.a((byte)paramInt);
  }
  
  public static p valueOf(g paramg)
  {
    int i = x & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return MIXED;
        }
        throw new IllegalArgumentException("The value can be only 0 (for UNSETTLED), 1 (for SETTLED) and 2 (for MIXED)");
      }
      return SETTLED;
    }
    return UNSETTLED;
  }
  
  public g getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.n.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */