package k.b.a;

import e.a.a.a.a;
import java.io.IOException;

public abstract class b0
  extends t
  implements c0
{
  public final int x;
  public final boolean y;
  public final e z;
  
  public b0(boolean paramBoolean, int paramInt, e parame)
  {
    if (parame != null)
    {
      x = paramInt;
      if ((!paramBoolean) && (!(parame instanceof d))) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      y = paramBoolean;
      z = parame;
      return;
    }
    throw new NullPointerException("'obj' cannot be null");
  }
  
  public static b0 a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof b0)))
    {
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = a(t.a((byte[])paramObject));
          return (b0)paramObject;
        }
        catch (IOException localIOException)
        {
          paramObject = a.a("failed to construct tagged object from byte[]: ");
          ((StringBuilder)paramObject).append(localIOException.getMessage());
          throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
        }
      }
      throw new IllegalArgumentException(a.a(paramObject, a.a("unknown object in getInstance: ")));
    }
    return (b0)paramObject;
  }
  
  public t a()
  {
    return this;
  }
  
  public boolean a(t paramt)
  {
    boolean bool1 = paramt instanceof b0;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = (b0)paramt;
    bool1 = bool2;
    if (x == x) {
      if (y != y)
      {
        bool1 = bool2;
      }
      else
      {
        paramt = z.c();
        localObject = z.c();
        if (paramt != localObject)
        {
          bool1 = bool2;
          if (!paramt.a((t)localObject)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public t h()
  {
    return new h1(y, x, z);
  }
  
  public int hashCode()
  {
    int i = x;
    int j;
    if (y) {
      j = 15;
    } else {
      j = 240;
    }
    return i ^ j ^ z.c().hashCode();
  }
  
  public t i()
  {
    return new v1(y, x, z);
  }
  
  public t j()
  {
    return z.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("[");
    localStringBuilder.append(x);
    localStringBuilder.append("]");
    localStringBuilder.append(z);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.b0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */