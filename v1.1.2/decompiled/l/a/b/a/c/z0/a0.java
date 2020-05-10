package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.k.r;
import l.a.b.a.b.n.j;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class a0
  extends b<r, List>
  implements s<r>
{
  public static final Object[] d = { i.a(37L), f.a("amqp:rejected:list") };
  public static final i e = i.a(37L);
  
  public a0(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<r> b()
  {
    return r.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new r();
    if (1 - localList.size() == 0) {
      a = ((j)localList.get(0));
    }
    return paramObject;
  }
  
  public Object d(Object paramObject)
  {
    return new b((r)paramObject, null);
  }
  
  public static final class b
    extends AbstractList
  {
    public final r x;
    
    public Object get(int paramInt)
    {
      if (paramInt == 0) {
        return x.a;
      }
      throw new IllegalStateException(a.a("Unknown index ", paramInt));
    }
    
    public int size()
    {
      int i;
      if (x.a != null) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.z0.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */