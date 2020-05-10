package k.a.b.a.c.c1;

import java.util.List;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.n.g;
import k.a.b.a.b.n.o;
import k.a.b.a.c.b;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public final class e
  extends b<g, List>
  implements s<g>
{
  public static final Object[] d = { i.a(21L), f.a("amqp:disposition:list") };
  public static final i e = i.a(21L);
  
  public e(x paramx)
  {
    super(paramx);
  }
  
  public Class<g> a()
  {
    return g.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    g localg = new g();
    if (!((List)paramObject).isEmpty())
    {
      int i = 6 - ((List)paramObject).size();
      boolean bool;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label114;
          }
          if (i == 3) {
            break label150;
          }
          if (i == 4) {
            break label164;
          }
          if (i == 5) {
            break label178;
          }
          break label210;
        }
      }
      else
      {
        localBoolean = (Boolean)((List)paramObject).get(5);
        if (localBoolean == null) {
          bool = false;
        } else {
          bool = localBoolean.booleanValue();
        }
        f = bool;
      }
      e = ((k.a.b.a.b.n.e)((List)paramObject).get(4));
      label114:
      Boolean localBoolean = (Boolean)((List)paramObject).get(3);
      if (localBoolean == null) {
        bool = false;
      } else {
        bool = localBoolean.booleanValue();
      }
      d = bool;
      label150:
      c = ((h)((List)paramObject).get(2));
      label164:
      localg.a((h)((List)paramObject).get(1));
      label178:
      if (Boolean.TRUE.equals(((List)paramObject).get(0))) {
        paramObject = o.RECEIVER;
      } else {
        paramObject = o.SENDER;
      }
      localg.a((o)paramObject);
      label210:
      return localg;
    }
    throw new q("The first field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new e.a((g)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.c1.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */