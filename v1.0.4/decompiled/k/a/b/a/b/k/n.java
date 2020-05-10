package k.a.b.a.b.k;

import e.a.a.a.a;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.n.e;

public final class n
  implements e, o
{
  public Boolean a;
  public Boolean b;
  public Map<f, Object> c;
  
  static
  {
    f.a("amqp:modified:list");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Modified{deliveryFailed=");
    localStringBuilder.append(a);
    localStringBuilder.append(", undeliverableHere=");
    localStringBuilder.append(b);
    localStringBuilder.append(", messageAnnotations=");
    localStringBuilder.append(c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.k.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */