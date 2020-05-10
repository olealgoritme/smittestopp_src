package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.k.q;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class z
  extends b<q, List>
  implements s<q>
{
  public static final Object[] d = { i.a(35L), f.a("amqp:received:list") };
  public static final i e = i.a(35L);
  
  public z(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<q> b()
  {
    return q.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    q localq = new q();
    int i = 2 - ((List)paramObject).size();
    if (i != 0)
    {
      if (i != 1) {
        return localq;
      }
    }
    else {
      b = ((i)((List)paramObject).get(1));
    }
    a = ((h)((List)paramObject).get(0));
    return localq;
  }
  
  public Object d(Object paramObject)
  {
    return new b((q)paramObject, null);
  }
  
  public static final class b
    extends AbstractList
  {
    public final q x;
    
    public Object get(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return x.b;
        }
        throw new IllegalStateException(a.a("Unknown index ", paramInt));
      }
      return x.a;
    }
    
    public int size()
    {
      q localq = x;
      int i;
      if (b != null) {
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
 * Qualified Name:     l.a.b.a.c.z0.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */