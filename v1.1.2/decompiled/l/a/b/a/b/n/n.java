package l.a.b.a.b.n;

import l.a.b.a.b.g;

public enum n
{
  public g value;
  
  static
  {
    n localn = new n("SECOND", 1, 1);
    SECOND = localn;
    $VALUES = new n[] { FIRST, localn };
  }
  
  public n(int paramInt)
  {
    value = g.a((byte)paramInt);
  }
  
  public static n valueOf(g paramg)
  {
    int i = x & 0xFF;
    if (i != 0)
    {
      if (i == 1) {
        return SECOND;
      }
      throw new IllegalArgumentException("The value can be only 0 (for FIRST) and 1 (for SECOND)");
    }
    return FIRST;
  }
  
  public g getValue()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.n.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */