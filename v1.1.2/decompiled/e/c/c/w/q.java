package e.c.c.w;

import java.math.BigDecimal;

public final class q
  extends Number
{
  public final String x;
  
  public q(String paramString)
  {
    x = paramString;
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(x);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof q))
    {
      Object localObject = (q)paramObject;
      paramObject = x;
      localObject = x;
      boolean bool2 = bool1;
      if (paramObject != localObject) {
        if (((String)paramObject).equals(localObject)) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
      return bool2;
    }
    return false;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(x);
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(x);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(x);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    return new BigDecimal(x).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(x);
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return new BigDecimal(x).longValue();
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.c.c.w.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */