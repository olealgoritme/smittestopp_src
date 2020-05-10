package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class f0
  extends c<Long>
{
  public f0.b a;
  public f0.b b;
  
  public f0(x paramx, r paramr)
  {
    a = new f0.a(this, paramx, paramr);
    b = new f0.c(this, paramx, paramr);
    c.put(Long.class, this);
    paramr.a(this);
  }
  
  public Class<Long> a()
  {
    return Long.class;
  }
  
  public f0.b a(Long paramLong)
  {
    long l = paramLong.longValue();
    if ((l >= -128L) && (l <= 127L)) {
      paramLong = b;
    } else {
      paramLong = a;
    }
    return paramLong;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<f0.b> i()
  {
    return Arrays.asList(new f0.b[] { b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.f0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */