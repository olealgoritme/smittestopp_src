package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class c0
  extends c<Integer>
{
  public c0.b a;
  public c0.b b;
  
  public c0(x paramx, r paramr)
  {
    a = new c0.a(this, paramx, paramr);
    b = new c0.c(this, paramx, paramr);
    c.put(Integer.class, this);
    paramr.a(this);
  }
  
  public Class<Integer> a()
  {
    return Integer.class;
  }
  
  public j0 a(Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if ((i >= -128) && (i <= 127)) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if ((i >= -128) && (i <= 127)) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (r0)paramObject;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<c0.b> i()
  {
    return Arrays.asList(new c0.b[] { a, b });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */