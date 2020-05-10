package l.a.b.a.c.z0;

import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import l.a.b.a.b.f;
import l.a.b.a.b.h;
import l.a.b.a.b.i;
import l.a.b.a.b.k.p;
import l.a.b.a.c.b;
import l.a.b.a.c.s;
import l.a.b.a.c.x;

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
  
  public i a()
  {
    return e;
  }
  
  public Class<p> b()
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
      b = ((l.a.b.a.b.a)((List)paramObject).get(1));
    case 12: 
      a = ((List)paramObject).get(0);
    }
    return localp;
  }
  
  public Object d(Object paramObject)
  {
    return new a((p)paramObject);
  }
  
  public static final class a
    extends AbstractList
  {
    public p x;
    
    public a(p paramp)
    {
      x = paramp;
    }
    
    public Object get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalStateException(e.a.a.a.a.a("Unknown index ", paramInt));
      case 12: 
        return x.m;
      case 11: 
        return x.l;
      case 10: 
        return x.k;
      case 9: 
        return x.j;
      case 8: 
        return x.i;
      case 7: 
        return x.h;
      case 6: 
        return x.g;
      case 5: 
        return x.f;
      case 4: 
        return x.e;
      case 3: 
        return x.d;
      case 2: 
        return x.c;
      case 1: 
        return x.b;
      }
      return x.a;
    }
    
    public int size()
    {
      p localp = x;
      int i;
      if (m != null) {
        i = 13;
      } else if (l != null) {
        i = 12;
      } else if (k != null) {
        i = 11;
      } else if (j != null) {
        i = 10;
      } else if (i != null) {
        i = 9;
      } else if (h != null) {
        i = 8;
      } else if (g != null) {
        i = 7;
      } else if (f != null) {
        i = 6;
      } else if (e != null) {
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
 * Qualified Name:     l.a.b.a.c.z0.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */