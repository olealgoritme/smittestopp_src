package k.a.b.a.b;

import java.math.BigDecimal;

public final class c
  extends Number
{
  public final BigDecimal x;
  public final int y;
  
  public c(int paramInt)
  {
    y = paramInt;
    x = BigDecimal.ZERO;
  }
  
  public double doubleValue()
  {
    return x.doubleValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (c.class == paramObject.getClass()))
    {
      paramObject = (c)paramObject;
      return y == y;
    }
    return false;
  }
  
  public float floatValue()
  {
    return x.floatValue();
  }
  
  public int hashCode()
  {
    return y;
  }
  
  public int intValue()
  {
    return x.intValue();
  }
  
  public long longValue()
  {
    return x.longValue();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */