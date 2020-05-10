package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.k.n;
import l.a.b.a.c.b;
import l.a.b.a.c.s;

public class x
  extends b<n, List>
  implements s<n>
{
  public static final Object[] d = { i.a(39L), f.a("amqp:modified:list") };
  public static final i e = i.a(39L);
  
  public x(l.a.b.a.c.x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<n> b()
  {
    return n.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    n localn = new n();
    int i = 3 - ((List)paramObject).size();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label67;
        }
        return localn;
      }
    }
    else {
      c = ((Map)((List)paramObject).get(2));
    }
    b = ((Boolean)((List)paramObject).get(1));
    label67:
    a = ((Boolean)((List)paramObject).get(0));
    return localn;
  }
  
  public Object d(Object paramObject)
  {
    return new a((n)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public final n x;
    
    public a(n paramn)
    {
      x = paramn;
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
      n localn = x;
      int i;
      if (c != null) {
        i = 3;
      } else if (b != null) {
        i = 2;
      } else if (a != null) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */