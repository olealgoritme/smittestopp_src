package l.a.b.a.b;

import java.math.BigDecimal;

public final class d
  extends Number
{
  public final BigDecimal x;
  public final long y;
  
  public d(long paramLong)
  {
    y = paramLong;
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
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      paramObject = (d)paramObject;
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
    long l = y;
    return (int)(l ^ l >>> 32);
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
 * Qualified Name:     l.a.b.a.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */