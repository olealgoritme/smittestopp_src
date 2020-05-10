package k.a.b.a.b;

public final class h
  extends Number
  implements Comparable<h>
{
  public static final h A = arrayOfh[1];
  public static final h B = new h(-1);
  public static final h[] y = new h['Ā'];
  public static final h z;
  public final int x;
  
  static
  {
    for (int i = 0; i < 256; i++) {
      y[i] = new h(i);
    }
    h[] arrayOfh = y;
    z = arrayOfh[0];
  }
  
  public h(int paramInt)
  {
    x = paramInt;
  }
  
  public static h a(int paramInt)
  {
    if ((paramInt & 0xFF00) == 0) {
      return y[paramInt];
    }
    return new h(paramInt);
  }
  
  public static h a(long paramLong)
  {
    if ((paramLong >= 0L) && (paramLong < 4294967296L)) {
      return a((int)paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Value \"");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("\" lies outside the range [");
    localStringBuilder.append(0L);
    localStringBuilder.append("-");
    localStringBuilder.append(4294967296L);
    localStringBuilder.append(").");
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public h a(h paramh)
  {
    return a(x + x);
  }
  
  public int b(h paramh)
  {
    return Long.signum(longValue() - paramh.longValue());
  }
  
  public h c(h paramh)
  {
    return a(x - x);
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
    if ((paramObject != null) && (h.class == paramObject.getClass()))
    {
      paramObject = (h)paramObject;
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
    return x;
  }
  
  public long longValue()
  {
    return x & 0xFFFFFFFF;
  }
  
  public String toString()
  {
    return String.valueOf(longValue());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */