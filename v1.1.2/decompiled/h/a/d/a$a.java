package h.a.d;

import h.a.c;

public final class a$a
  implements h.a.a
{
  public final long x;
  public final String y;
  
  public a$a(long paramLong, String paramString)
  {
    x = paramLong;
    y = paramString;
  }
  
  public final void a()
  {
    if (c.b) {
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("Constant ");
    localStringBuilder.append(y);
    localStringBuilder.append(" is not defined on ");
    localStringBuilder.append(c.g);
    throw new AssertionError(localStringBuilder.toString());
  }
  
  public final boolean defined()
  {
    return false;
  }
  
  public final int intValue()
  {
    a();
    return (int)x;
  }
  
  public final long longValue()
  {
    a();
    return x;
  }
  
  public final String name()
  {
    return y;
  }
  
  public final String toString()
  {
    return y;
  }
}

/* Location:
 * Qualified Name:     h.a.d.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */