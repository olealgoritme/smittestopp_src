package l.a.b.a.c;

import java.math.BigInteger;

public class f$a
  extends z<BigInteger>
  implements f.b
{
  public f$a(f paramf, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public boolean a(r0<BigInteger> paramr0)
  {
    boolean bool;
    if (c == paramr0.getType()) {
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
    if (c != null)
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
    return c;
  }
  
  public i0 getType()
  {
    return c;
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

/* Location:
 * Qualified Name:     l.a.b.a.c.f.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */