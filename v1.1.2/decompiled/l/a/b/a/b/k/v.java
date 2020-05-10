package l.a.b.a.b.k;

import e.a.a.a.a;
import java.util.Arrays;
import l.a.b.a.b.n.r;

public final class v
  extends w
  implements r
{
  public v() {}
  
  public v(v paramv)
  {
    super(paramv);
  }
  
  public r a()
  {
    return new v(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Target{address='");
    a.a(localStringBuilder, a, '\'', ", durable=");
    localStringBuilder.append(b);
    localStringBuilder.append(", expiryPolicy=");
    localStringBuilder.append(c);
    localStringBuilder.append(", timeout=");
    localStringBuilder.append(d);
    localStringBuilder.append(", dynamic=");
    localStringBuilder.append(e);
    localStringBuilder.append(", dynamicNodeProperties=");
    localStringBuilder.append(f);
    localStringBuilder.append(", capabilities=");
    Object localObject = g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = Arrays.asList((Object[])localObject);
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.k.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */