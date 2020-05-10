package l.a.b.a.b;

import java.math.BigInteger;

public final class i
  extends Number
  implements Comparable<i>
{
  public static final i A = z[0];
  public static final BigInteger y = new BigInteger(new byte[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 });
  public static final i[] z;
  public final long x;
  
  static
  {
    BigInteger.valueOf(Long.MAX_VALUE);
    z = new i['Ā'];
    for (int i = 0; i < 256; i++) {
      z[i] = new i(i);
    }
  }
  
  public i(long paramLong)
  {
    x = paramLong;
  }
  
  public static i a(long paramLong)
  {
    if ((0xFF & paramLong) == paramLong) {
      return z[((int)paramLong)];
    }
    return new i(paramLong);
  }
  
  public BigInteger a()
  {
    long l = x;
    if (l >= 0L) {
      return BigInteger.valueOf(l);
    }
    return y.add(BigInteger.valueOf(l));
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (i)paramObject;
    return a().compareTo(((i)paramObject).a());
  }
  
  public double doubleValue()
  {
    return x;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (i.class == paramObject.getClass()))
    {
      paramObject = (i)paramObject;
      return x == x;
    }
    return false;
  }
  
  public float floatValue()
  {
    return (float)x;
  }
  
  public int hashCode()
  {
    long l = x;
    return (int)(l ^ l >>> 32);
  }
  
  public int intValue()
  {
    return (int)x;
  }
  
  public long longValue()
  {
    return x;
  }
  
  public String toString()
  {
    return String.valueOf(a());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */