package l.a.b.a.c.z0;

import e.a.a.a.a;
import java.util.AbstractList;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.g;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.k.l;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

public class v
  extends b<l, List>
  implements s<l>
{
  public static final Object[] d = { i.a(112L), f.a("amqp:header:list") };
  public static final i e = i.a(112L);
  
  public v(x paramx)
  {
    super(paramx);
  }
  
  public i a()
  {
    return e;
  }
  
  public Class<l> b()
  {
    return l.class;
  }
  
  public Object b(Object paramObject)
  {
    List localList = (List)paramObject;
    paramObject = new l();
    int i = 5 - localList.size();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          break label77;
        }
        if (i == 3) {
          break label91;
        }
        if (i == 4) {
          break label105;
        }
        return paramObject;
      }
    }
    else {
      e = ((h)localList.get(4));
    }
    d = ((Boolean)localList.get(3));
    label77:
    c = ((h)localList.get(2));
    label91:
    b = ((g)localList.get(1));
    label105:
    a = ((Boolean)localList.get(0));
    return paramObject;
  }
  
  public Object d(Object paramObject)
  {
    return new a((l)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public final l x;
    
    public a(l paraml)
    {
      x = paraml;
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
              if (paramInt == 4) {
                return x.e;
              }
              throw new IllegalStateException(a.a("Unknown index ", paramInt));
            }
            return x.d;
          }
          return x.c;
        }
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      l locall = x;
      int i;
      if (e != null) {
        i = 5;
      } else if (d != null) {
        i = 4;
      } else if (c != null) {
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
 * Qualified Name:     l.a.b.a.c.z0.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */