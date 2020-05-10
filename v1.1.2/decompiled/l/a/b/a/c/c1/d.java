package l.a.b.a.c.c1;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.n.j;
import l.a.b.a.c.b;
import l.a.b.a.c.q;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public final class d
  extends b<l.a.b.a.b.n.f, List>
  implements s<l.a.b.a.b.n.f>
{
  public static final Object[] d = { i.a(22L), l.a.b.a.b.f.a("amqp:detach:list") };
  public static final i e = i.a(22L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l.a.b.a.b.n.f> b()
  {
    return l.a.b.a.b.n.f.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new l.a.b.a.b.n.f();
    if (!((List)localObject).isEmpty())
    {
      int i = 3 - ((List)localObject).size();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label98;
          }
          break label118;
        }
      }
      else {
        c = ((j)((List)localObject).get(2));
      }
      Boolean localBoolean = (Boolean)((List)localObject).get(1);
      boolean bool;
      if (localBoolean == null) {
        bool = false;
      } else {
        bool = localBoolean.booleanValue();
      }
      b = bool;
      label98:
      localObject = (h)((List)localObject).get(0);
      if (localObject != null)
      {
        a = ((h)localObject);
        label118:
        return paramObject;
      }
      throw new NullPointerException("the handle field is mandatory");
    }
    throw new q("The handle field cannot be omitted");
  }
  
  public Object d(Object paramObject)
  {
    return new a((l.a.b.a.b.n.f)paramObject);
  }
  
  public static class a
    extends AbstractList
  {
    public l.a.b.a.b.n.f x;
    
    public a(l.a.b.a.b.n.f paramf)
    {
      x = paramf;
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
        return Boolean.valueOf(x.b);
      }
      return x.a;
    }
    
    public int size()
    {
      l.a.b.a.b.n.f localf = x;
      int i;
      if (c != null) {
        i = 3;
      } else if (b) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.c1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */