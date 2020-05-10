package k.a.b.a.c.z0;

import java.util.Date;
import java.util.List;
import k.a.b.a.b.a;
import k.a.b.a.b.f;
import k.a.b.a.b.h;
import k.a.b.a.b.i;
import k.a.b.a.b.k.p;
import k.a.b.a.c.b;
import k.a.b.a.c.s;
import k.a.b.a.c.x;

public class y
  extends b<p, List>
  implements s<p>
{
  public static final Object[] d = { i.a(115L), f.a("amqp:properties:list") };
  public static final i e = i.a(115L);
  
  public y(x paramx)
  {
    super(paramx);
  }
  
  public Class<p> a()
  {
    return p.class;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = (List)paramObject;
    p localp = new p();
    switch (13 - ((List)paramObject).size())
    {
    default: 
      break;
    case 0: 
      m = ((String)((List)paramObject).get(12));
    case 1: 
      l = ((h)((List)paramObject).get(11));
    case 2: 
      k = ((String)((List)paramObject).get(10));
    case 3: 
      j = ((Date)((List)paramObject).get(9));
    case 4: 
      i = ((Date)((List)paramObject).get(8));
    case 5: 
      h = ((f)((List)paramObject).get(7));
    case 6: 
      g = ((f)((List)paramObject).get(6));
    case 7: 
      f = ((List)paramObject).get(5);
    case 8: 
      e = ((String)((List)paramObject).get(4));
    case 9: 
      d = ((String)((List)paramObject).get(3));
    case 10: 
      c = ((String)((List)paramObject).get(2));
    case 11: 
      b = ((a)((List)paramObject).get(1));
    case 12: 
      a = ((List)paramObject).get(0);
    }
    return localp;
  }
  
  public i b()
  {
    return e;
  }
  
  public Object d(Object paramObject)
  {
    return new y.a((p)paramObject);
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.z0.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */