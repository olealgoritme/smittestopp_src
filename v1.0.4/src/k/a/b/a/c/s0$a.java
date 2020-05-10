package k.a.b.a.c;

import java.util.UUID;

public class s0$a
  extends z<UUID>
{
  public s0$a(s0 params0, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public void a(Object paramObject)
  {
    paramObject = (UUID)paramObject;
    x localx = a;
    long l = ((UUID)paramObject).getMostSignificantBits();
    a.a(l);
    localx = a;
    l = ((UUID)paramObject).getLeastSignificantBits();
    a.a(l);
  }
  
  public boolean a(r0<UUID> paramr0)
  {
    boolean bool;
    if (c == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public byte g()
  {
    return -104;
  }
  
  public a getType()
  {
    return c;
  }
  
  public i0 getType()
  {
    return c;
  }
  
  public int i()
  {
    return 16;
  }
  
  public Object k()
  {
    return new UUID(b.g(), b.g());
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.s0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */