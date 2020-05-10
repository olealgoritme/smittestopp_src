package l.a.b.a.b;

public final class j
  extends Number
  implements Comparable<j>
{
  public static final j[] y = new j['Ā'];
  public static final j z = new j((short)-1);
  public final short x;
  
  static
  {
    short s1 = 0;
    for (short s2 = s1; s2 < 256; s2 = s1)
    {
      y[s2] = new j(s2);
      s1 = (short)(s2 + 1);
    }
  }
  
  public j(short paramShort)
  {
    x = ((short)paramShort);
  }
  
  public static j a(short paramShort)
  {
    if ((0xFF00 & paramShort) == 0) {
      return y[paramShort];
    }
    return new j(paramShort);
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (j)paramObject;
    return Integer.signum(intValue() - ((j)paramObject).intValue());
  }
  
  public double doubleValue()
  {
    return intValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (j.class == paramObject.getClass()))
    {
      paramObject = (j)paramObject;
      return x == x;
    }
    return false;
  }
  
  public float floatValue()
  {
    return intValue();
  }
  
  public int hashCode()
  {
    return x;
  }
  
  public int intValue()
  {
    return x & 0xFFFF;
  }
  
  public long longValue()
  {
    return x & 0xFFFF;
  }
  
  public short shortValue()
  {
    return x;
  }
  
  public String toString()
  {
    return String.valueOf(longValue());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */