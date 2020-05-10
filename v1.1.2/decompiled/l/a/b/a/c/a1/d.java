package l.a.b.a.c.a1;

import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.g;
import l.a.b.a.b.i;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class d
  extends l.a.b.a.c.b<l.a.b.a.b.l.f, List>
  implements s<l.a.b.a.b.l.f>
{
  public static final Object[] d = { i.a(68L), l.a.b.a.b.f.a("amqp:sasl-outcome:list") };
  public static final i e = i.a(68L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.l.f> b()
  {
    return l.a.b.a.b.l.f.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new l.a.b.a.b.l.f();
    if (!((List)localObject).isEmpty())
    {
      int i = 2 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1) {
          break label80;
        }
      }
      else {
        b = ((l.a.b.a.b.a)((List)localObject).get(1));
      }
      localObject = l.a.b.a.b.l.b.valueOf((g)((List)localObject).get(0));
      if (localObject != null)
      {
        a = ((l.a.b.a.b.l.b)localObject);
        label80:
        return paramObject;
      }
      throw new NullPointerException("the code field is mandatory");
    }
    throw new q("The code field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.l.f)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public final l.a.b.a.b.l.f x;
    
    public a(l.a.b.a.b.l.f paramf)
    {
      x = paramf;
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
      return x.a.getValue();
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
 * Qualified Name:     l.a.b.a.c.a1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */