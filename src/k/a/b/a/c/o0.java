package k.a.b.a.c;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import k.a.b.a.b.f;

public class o0
  extends c<f>
{
  public static final Charset e = Charset.forName("US-ASCII");
  public final o0.d a;
  public final o0.d b;
  public final Map<k0, f> c = new HashMap();
  public r.b<f> d = new o0.a(this);
  
  public o0(x paramx, r paramr)
  {
    a = new o0.b(this, paramx, paramr);
    b = new o0.c(this, paramx, paramr);
    c.put(f.class, this);
    paramr.a(this);
  }
  
  public Class<f> a()
  {
    return f.class;
  }
  
  public j0 a(Object paramObject)
  {
    if (((f)paramObject).length() <= 255) {
      paramObject = b;
    } else {
      paramObject = a;
    }
    return (j0)paramObject;
  }
  
  public r0 a(Object paramObject)
  {
    if (((f)paramObject).length() <= 255) {
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
  
  public Collection<o0.d> i()
  {
    return Arrays.asList(new o0.d[] { b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.o0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */