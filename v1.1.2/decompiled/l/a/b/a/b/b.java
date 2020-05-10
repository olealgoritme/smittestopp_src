package l.a.b.a.b;

import java.math.BigDecimal;

public final class b
  extends Number
{
  public final BigDecimal x;
  public final long y;
  public final long z;
  
  public b(long paramLong1, long paramLong2)
  {
    y = paramLong1;
    z = paramLong2;
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
    if ((paramObject != null) && (b.class == paramObject.getClass()))
    {
      paramObject = (b)paramObject;
      if (z != z) {
        return false;
      }
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
    int i = (int)(l ^ l >>> 32);
    l = z;
    return i * 31 + (int)(l ^ l >>> 32);
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
 * Qualified Name:     l.a.b.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */