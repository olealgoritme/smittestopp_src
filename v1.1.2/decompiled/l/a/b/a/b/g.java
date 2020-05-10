package l.a.b.a.b;

public final class g
  extends Number
  implements Comparable<g>
{
  public static final g[] y = new g['Ā'];
  public final byte x;
  
  static
  {
    for (int i = 0; i < 256; i++) {
      y[i] = new g((byte)i);
    }
  }
  
  public g(byte paramByte)
  {
    x = ((byte)paramByte);
  }
  
  public static g a(byte paramByte)
  {
    return y[(paramByte & 0xFF)];
  }
  
  public byte byteValue()
  {
    return x;
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (g)paramObject;
    return Integer.signum((x & 0xFF) - (x & 0xFF));
  }
  
  public double doubleValue()
  {
    return longValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (g.class == paramObject.getClass()))
    {
      paramObject = (g)paramObject;
      return x == x;
    }
    return false;
  }
  
  public float floatValue()
  {
    return (float)longValue();
  }
  
  public int hashCode()
  {
    return x;
  }
  
  public int intValue()
  {
    return x & 0xFF;
  }
  
  public long longValue()
  {
    return x & 0xFF;
  }
  
  public short shortValue()
  {
    return (short)(x & 0xFF);
  }
  
  public String toString()
  {
    return String.valueOf(x & 0xFF);
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */