package l.a.b.a.c.b1;

import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class d
  extends b<l.a.b.a.b.m.d, List>
  implements s<l.a.b.a.b.m.d>
{
  public static final Object[] d = { i.a(50L), f.a("amqp:discharge:list") };
  public static final i e = i.a(50L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.m.d> b()
  {
    return l.a.b.a.b.m.d.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new l.a.b.a.b.m.d();
    if (!((List)localObject).isEmpty())
    {
      int i = 2 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1) {
          break label77;
        }
      }
      else {
        b = ((Boolean)((List)localObject).get(1));
      }
      localObject = (l.a.b.a.b.a)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((l.a.b.a.b.a)localObject);
        label77:
        return paramObject;
      }
      throw new NullPointerException("the txn-id field is mandatory");
    }
    throw new q("The txn-id field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.m.d)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.m.d x;
    
    public a(l.a.b.a.b.m.d paramd)
    {
      x = paramd;
    }
    
    public Object get(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return x.b;
        }
        throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
      }
      return x.a;
    }
    
    public int size()
    {
      int i;
      if (x.b != null) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.b1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */