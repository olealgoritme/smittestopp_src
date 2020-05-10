package l.a.b.a.c;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class f
  extends c<BigInteger>
{
  public static final BigInteger c = BigInteger.valueOf(-128L);
  public static final BigInteger d = BigInteger.valueOf(127L);
  public static final BigInteger e = BigInteger.valueOf(Long.MIN_VALUE);
  public static final BigInteger f = BigInteger.valueOf(Long.MAX_VALUE);
  public b a;
  public b b;
  
  public f(x paramx, r paramr)
  {
    a = new a(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(BigInteger.class, this);
  }
  
  public b a(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.compareTo(c) >= 0) && (paramBigInteger.compareTo(d) <= 0)) {
      paramBigInteger = b;
    } else {
      paramBigInteger = a;
    }
    return paramBigInteger;
  }
  
  public Class<BigInteger> b()
  {
    return BigInteger.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { b, a });
  }
  
  public class a
    extends z<BigInteger>
    implements f.b
  {
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<BigInteger> paramr0)
    {
      boolean bool;
      if (f.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      BigInteger localBigInteger = (BigInteger)paramObject;
      paramObject = a;
      if (f.this != null)
      {
        if ((localBigInteger.compareTo(f.e) >= 0) && (localBigInteger.compareTo(f.f) <= 0))
        {
          long l = localBigInteger.longValue();
          a.a(l);
          return;
        }
        throw new ArithmeticException("cannot encode BigInteger not representable as long");
      }
      throw null;
    }
    
    public byte f()
    {
      return -127;
    }
    
    public a getType()
    {
      return f.this;
    }
    
    public i0 getType()
    {
      return f.this;
    }
    
    public Object i()
    {
      Object localObject = b;
      int i = a.get();
      if (i != -127)
      {
        if (i != 64)
        {
          if (i == 85) {
            localObject = Long.valueOf(((r)localObject).e());
          } else {
            throw new q(e.a.a.a.a.a("Expected Long type but found encoding: ", i));
          }
        }
        else {
          localObject = null;
        }
      }
      else {
        localObject = Long.valueOf(((r)localObject).g());
      }
      return BigInteger.valueOf(((Long)localObject).longValue());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 8;
    }
  }
  
  public static abstract interface b
    extends j0<BigInteger>
  {}
  
  public class c
    extends z<BigInteger>
    implements f.b
  {
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public boolean a(r0<BigInteger> paramr0)
    {
      boolean bool;
      if (paramr0 == this) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void b(Object paramObject)
    {
      BigInteger localBigInteger = (BigInteger)paramObject;
      paramObject = a;
      byte b = localBigInteger.byteValue();
      a.a(b);
    }
    
    public byte f()
    {
      return 85;
    }
    
    public a getType()
    {
      return f.this;
    }
    
    public i0 getType()
    {
      return f.this;
    }
    
    public Object i()
    {
      return BigInteger.valueOf(b.e());
    }
    
    public boolean j()
    {
      return true;
    }
    
    public int k()
    {
      return 1;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */