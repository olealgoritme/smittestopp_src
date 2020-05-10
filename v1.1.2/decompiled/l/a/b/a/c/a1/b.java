package l.a.b.a.c.a1;

import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.i;
import l.a.b.a.b.l.d;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class b
  extends l.a.b.a.c.b<d, List>
  implements s<d>
{
  public static final Object[] d = { i.a(65L), f.a("amqp:sasl-init:list") };
  public static final i e = i.a(65L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<d> b()
  {
    return d.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new d();
    if (((List)localObject).size() > 0)
    {
      int i = 3 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label76;
          }
          break label96;
        }
      }
      else {
        c = ((String)((List)localObject).get(2));
      }
      b = ((l.a.b.a.b.a)((List)localObject).get(1));
      label76:
      localObject = (f)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((f)localObject);
        label96:
        return paramObject;
      }
      throw new NullPointerException("the mechanism field is mandatory");
    }
    throw new q("The mechanism field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((d)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public d x;
    
    public a(d paramd)
    {
      x = paramd;
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
          throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
        }
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      d locald = x;
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
 * Qualified Name:     l.a.b.a.c.a1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */