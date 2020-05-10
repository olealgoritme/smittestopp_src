package e.c.c;

import e.c.a.a.b.l.c;
import e.c.c.w.q;
import java.math.BigInteger;

public final class p
  extends j
{
  public static final Class<?>[] b = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  public Object a;
  
  public p(Boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public p(Number paramNumber)
  {
    a(paramNumber);
  }
  
  public p(Object paramObject)
  {
    a(paramObject);
  }
  
  public p(String paramString)
  {
    a(paramString);
  }
  
  public static boolean a(p paramp)
  {
    paramp = a;
    boolean bool1 = paramp instanceof Number;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramp = (Number)paramp;
      if ((!(paramp instanceof BigInteger)) && (!(paramp instanceof Long)) && (!(paramp instanceof Integer)) && (!(paramp instanceof Short)))
      {
        bool3 = bool2;
        if (!(paramp instanceof Byte)) {}
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public int a()
  {
    int i;
    if ((a instanceof Number)) {
      i = h().intValue();
    } else {
      i = Integer.parseInt(f());
    }
    return i;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      a = String.valueOf(((Character)paramObject).charValue());
    }
    else
    {
      boolean bool1 = paramObject instanceof Number;
      boolean bool2 = false;
      if (!bool1)
      {
        int i;
        if ((paramObject instanceof String))
        {
          i = 1;
        }
        else
        {
          Class localClass = paramObject.getClass();
          Class[] arrayOfClass = b;
          int j = arrayOfClass.length;
          for (i = 0;; i++)
          {
            if (i >= j) {
              break label96;
            }
            if (arrayOfClass[i].isAssignableFrom(localClass)) {
              break;
            }
          }
          label96:
          i = 0;
        }
        if (i == 0) {}
      }
      else
      {
        bool2 = true;
      }
      c.a(bool2);
      a = paramObject;
    }
  }
  
  public long e()
  {
    long l;
    if ((a instanceof Number)) {
      l = h().longValue();
    } else {
      l = Long.parseLong(f());
    }
    return l;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (p.class == paramObject.getClass()))
    {
      paramObject = (p)paramObject;
      if (a == null)
      {
        if (a != null) {
          bool3 = false;
        }
        return bool3;
      }
      if ((a(this)) && (a((p)paramObject)))
      {
        if (h().longValue() == ((p)paramObject).h().longValue()) {
          bool3 = bool1;
        } else {
          bool3 = false;
        }
        return bool3;
      }
      if (((a instanceof Number)) && ((a instanceof Number)))
      {
        double d1 = h().doubleValue();
        double d2 = ((p)paramObject).h().doubleValue();
        bool3 = bool2;
        if (d1 != d2) {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
        }
        return bool3;
      }
      return a.equals(a);
    }
    return false;
  }
  
  public String f()
  {
    Object localObject = a;
    if ((localObject instanceof Number)) {
      return h().toString();
    }
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).toString();
    }
    return (String)localObject;
  }
  
  public boolean g()
  {
    Object localObject = a;
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return Boolean.parseBoolean(f());
  }
  
  public Number h()
  {
    Object localObject = a;
    if ((localObject instanceof String)) {
      localObject = new q((String)a);
    } else {
      localObject = (Number)localObject;
    }
    return (Number)localObject;
  }
  
  public int hashCode()
  {
    if (a == null) {
      return 31;
    }
    if (a(this)) {}
    Object localObject;
    for (long l = h().longValue();; l = Double.doubleToLongBits(h().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = a;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
}

/* Location:
 * Qualified Name:     e.c.c.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */