package l.a.b.a.c;

public class g$b
  extends d0<l.a.b.a.b.a>
  implements g.a
{
  public g$b(g paramg, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public boolean a(r0<l.a.b.a.b.a> paramr0)
  {
    boolean bool;
    if (c == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c(Object paramObject)
  {
    return c;
  }
  
  public void d(Object paramObject)
  {
    paramObject = (l.a.b.a.b.a)paramObject;
    a.a.b(c);
    x localx = a;
    byte[] arrayOfByte = a;
    int i = b;
    int j = c;
    a.a(arrayOfByte, i, j);
  }
  
  public byte f()
  {
    return -80;
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
    r localr = b;
    int i = localr.f();
    if (i <= localr.a())
    {
      localObject = new byte[i];
      a.a((byte[])localObject, 0, i);
      return new l.a.b.a.b.a((byte[])localObject);
    }
    Object localObject = e.a.a.a.a.a("Binary data size ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject).append(localr.a());
    ((StringBuilder)localObject).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */