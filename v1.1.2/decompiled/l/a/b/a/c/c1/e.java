package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.n.g;
import l.a.b.a.b.n.o;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

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
  
  public i a()
  {
    return e;
  }
  
  public Class<g> b()
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
      e = ((l.a.b.a.b.n.e)((List)paramObject).get(4));
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
  
  public Object d(Object paramObject)
  {
    return new a((g)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public g x;
    
    public a(g paramg)
    {
      x = paramg;
    }
    
    public Object get(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt == 5) {
                  return Boolean.valueOf(x.f);
                }
                throw new IllegalStateException(a.a("Unknown index ", paramInt));
              }
              return x.e;
            }
            return Boolean.valueOf(x.d);
          }
          return x.c;
        }
        return x.b;
      }
      return Boolean.valueOf(x.a.getValue());
    }
    
    public int size()
    {
      g localg = x;
      int i;
      if (f) {
        i = 6;
      } else if (e != null) {
        i = 5;
      } else if (d) {
        i = 4;
      } else if (c != null) {
        i = 3;
      } else {
        i = 2;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */