package k.a.b.a.c;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class s0
  extends c<UUID>
{
  public s0.a a;
  
  public s0(x paramx, r paramr)
  {
    a = new s0.a(this, paramx, paramr);
    c.put(UUID.class, this);
    paramr.a(this);
  }
  
  public Class<UUID> a()
  {
    return UUID.class;
  }
  
  public j0 a(Object paramObject)
  {
    paramObject = (UUID)paramObject;
    return a;
  }
  
  public r0 a(Object paramObject)
  {
    paramObject = (UUID)paramObject;
    return a;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<s0.a> i()
  {
    return Collections.singleton(a);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.s0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */