package k.a.b.a.b.k;

import k.a.b.a.b.h;

public enum x
{
  static
  {
    CONFIGURATION = new x("CONFIGURATION", 1);
    x localx = new x("UNSETTLED_STATE", 2);
    UNSETTLED_STATE = localx;
    $VALUES = new x[] { NONE, CONFIGURATION, localx };
  }
  
  public x() {}
  
  public static x get(h paramh)
  {
    int i = x;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          return UNSETTLED_STATE;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown TerminusDurablity: ");
        localStringBuilder.append(paramh);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return CONFIGURATION;
    }
    return NONE;
  }
  
  public h getValue()
  {
    return h.a(ordinal());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.k.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */