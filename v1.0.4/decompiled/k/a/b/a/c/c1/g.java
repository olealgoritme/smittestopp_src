package k.a.b.a.c.c1;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.n.j;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class g
  extends b<j, List>
  implements s<j>
{
  public static final Object[] d = { i.a(29L), f.a("amqp:error:list") };
  public static final i e = i.a(29L);
  
  public g(x paramx)
  {
    super(paramx);
  }
  
  public Class<j> a()
  {
    return j.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new j();
    if (!localList.isEmpty())
    {
      int i = 3 - localList.size();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label76;
          }
          break label90;
        }
      }
      else {
        c = ((Map)localList.get(2));
      }
      b = ((String)localList.get(1));
      label76:
      ((j)paramObject).a((f)localList.get(0));
      label90:
      return paramObject;
    }
    throw new q("The condition field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new g.a((j)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */