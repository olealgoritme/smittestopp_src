package l.a.b.a.b.k;

import e.a.a.a.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.n.q;

public final class u
  extends w
  implements q
{
  public f h;
  public Map i;
  public o j;
  public f[] k;
  
  public u() {}
  
  public u(u paramu)
  {
    super(paramu);
    h = h;
    if (i != null) {
      i = new HashMap(i);
    }
    j = j;
    paramu = k;
    if (paramu != null) {
      k = ((f[])paramu.clone());
    }
  }
  
  public q a()
  {
    return new u(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Source{address='");
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
    localStringBuilder.append(", distributionMode=");
    localStringBuilder.append(h);
    localStringBuilder.append(", filter=");
    localStringBuilder.append(i);
    localStringBuilder.append(", defaultOutcome=");
    localStringBuilder.append(j);
    localStringBuilder.append(", outcomes=");
    Object localObject1 = k;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", capabilities=");
    localObject1 = g;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = Arrays.asList((Object[])localObject1);
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.k.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */