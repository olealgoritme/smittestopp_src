package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public final class h
  extends c<Boolean>
{
  public h.b a;
  public h.b b;
  public h.b c;
  
  public h(x paramx, r paramr)
  {
    a = new h.d(this, paramx, paramr);
    b = new h.c(this, paramx, paramr);
    c = new h.a(this, paramx, paramr);
    c.put(Boolean.class, this);
    paramr.a(this);
  }
  
  public Class<Boolean> a()
  {
    return Boolean.class;
  }
  
  public j0 a(Object paramObject)
  {
    if (((Boolean)paramObject).booleanValue()) {
      paramObject = a;
    } else {
      paramObject = b;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    if (((Boolean)paramObject).booleanValue()) {
      paramObject = a;
    } else {
      paramObject = b;
    }
    return (r0)paramObject;
  }
  
  public r0 f()
  {
    return c;
  }
  
  public Collection<h.b> i()
  {
    return Arrays.asList(new h.b[] { a, b, c });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */