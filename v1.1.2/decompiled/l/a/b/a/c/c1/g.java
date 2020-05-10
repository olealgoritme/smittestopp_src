package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.n.j;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

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
  
  public i a()
  {
    return e;
  }
  
  public Class<j> b()
  {
    return j.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    j localj = new j();
    if (!((List)paramObject).isEmpty())
    {
      int i = 3 - ((List)paramObject).size();
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
        c = ((Map)((List)paramObject).get(2));
      }
      b = ((String)((List)paramObject).get(1));
      label76:
      localj.a((f)((List)paramObject).get(0));
      label90:
      return localj;
    }
    throw new q("The condition field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((j)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public j x;
    
    public a(j paramj)
    {
      x = paramj;
    }
    
    public Object get(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            return x.c;
          }
          throw new IllegalStateException(a.a("Unknown index ", paramInt));
        }
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      j localj = x;
      int i;
      if (c != null) {
        i = 3;
      } else if (b != null) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */