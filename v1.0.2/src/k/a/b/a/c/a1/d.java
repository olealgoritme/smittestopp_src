package k.a.b.a.c.a1;

import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.g;
import k.a.b.a.b.i;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class d
  extends k.a.b.a.c.b<k.a.b.a.b.l.f, List>
  implements s<k.a.b.a.b.l.f>
{
  public static final Object[] d = { i.a(68L), k.a.b.a.b.f.a("amqp:sasl-outcome:list") };
  public static final i e = i.a(68L);
  
  public d(x paramx)
  {
    super(paramx);
  }
  
  public Class<k.a.b.a.b.l.f> a()
  {
    return k.a.b.a.b.l.f.class;
  }
  
  public Object b(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new k.a.b.a.b.l.f();
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
        b = ((a)((List)localObject).get(1));
      }
      localObject = k.a.b.a.b.l.b.valueOf((g)((List)localObject).get(0));
      if (localObject != null)
      {
        a = ((k.a.b.a.b.l.b)localObject);
        label80:
        return paramObject;
      }
      throw new NullPointerException("the code field is mandatory");
    }
    throw new q("The code field cannot be omitted");
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new d.a((k.a.b.a.b.l.f)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.a1.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */