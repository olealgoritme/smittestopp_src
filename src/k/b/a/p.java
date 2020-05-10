package k.b.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public abstract class p
  extends t
  implements q
{
  public byte[] x;
  
  public p(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      x = paramArrayOfByte;
      return;
    }
    throw new NullPointerException("'string' cannot be null");
  }
  
  public static p a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof p)))
    {
      Object localObject;
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = a(t.a((byte[])paramObject));
          return (p)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = e.a.a.a.a.a("failed to construct OCTET STRING from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof p)) {
          return (p)localObject;
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("illegal object in getInstance: ")));
    }
    return (p)paramObject;
  }
  
  public static p a(b0 paramb0, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (y) {
        return a(paramb0.j());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    Object localObject = paramb0.j();
    if (y)
    {
      localObject = a(localObject);
      if ((paramb0 instanceof n0)) {
        return new h0(new p[] { localObject });
      }
      return (p)new h0(new p[] { localObject }).i();
    }
    if ((localObject instanceof p))
    {
      localObject = (p)localObject;
      if ((paramb0 instanceof n0)) {
        return (p)localObject;
      }
      return (p)((p)localObject).i();
    }
    if ((localObject instanceof u))
    {
      localObject = (u)localObject;
      if ((paramb0 instanceof n0)) {
        return h0.a((u)localObject);
      }
      return (p)h0.a((u)localObject).i();
    }
    localObject = e.a.a.a.a.a("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramb0.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public t a()
  {
    return this;
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof p)) {
      return false;
    }
    paramt = (p)paramt;
    return Arrays.equals(x, x);
  }
  
  public InputStream b()
  {
    return new ByteArrayInputStream(x);
  }
  
  public t h()
  {
    return new a1(x);
  }
  
  public int hashCode()
  {
    return k.b.c.e.a.d(j());
  }
  
  public t i()
  {
    return new a1(x);
  }
  
  public byte[] j()
  {
    return x;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("#");
    localStringBuilder.append(k.b.j.f.a(k.b.j.g.f.a(x)));
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */