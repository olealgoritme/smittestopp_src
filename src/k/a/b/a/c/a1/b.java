package k.a.b.a.c.a1;

import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.i;
import k.a.b.a.b.l.d;
import k.a.b.a.c.q;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class b
  extends k.a.b.a.c.b<d, List>
  implements s<d>
{
  public static final Object[] d = { i.a(65L), f.a("amqp:sasl-init:list") };
  public static final i e = i.a(65L);
  
  public b(x paramx)
  {
    super(paramx);
  }
  
  public Class<d> a()
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
      b = ((a)((List)localObject).get(1));
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
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new b.a((d)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.a1.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */