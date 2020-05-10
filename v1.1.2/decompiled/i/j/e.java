package i.j;

import i.k.a.p;
import i.k.b.g;
import i.k.b.h;

public final class e
  extends h
  implements p<d, d.a, d>
{
  public static final e x = new e();
  
  public e()
  {
    super(2);
  }
  
  public Object a(Object paramObject1, Object paramObject2)
  {
    d locald = (d)paramObject1;
    paramObject1 = (d.a)paramObject2;
    if (locald != null)
    {
      if (paramObject1 != null)
      {
        locald = locald.minusKey(((d.a)paramObject1).getKey());
        if (locald != f.x)
        {
          paramObject2 = (c)locald.get(c.c);
          if (paramObject2 == null)
          {
            paramObject1 = new b(locald, (d.a)paramObject1);
          }
          else
          {
            locald = locald.minusKey(c.c);
            if (locald == f.x) {
              paramObject1 = new b((d)paramObject1, (d.a)paramObject2);
            } else {
              paramObject1 = new b(new b(locald, (d.a)paramObject1), (d.a)paramObject2);
            }
          }
        }
        return paramObject1;
      }
      g.a("element");
      throw null;
    }
    g.a("acc");
    throw null;
  }
}

/* Location:
 * Qualified Name:     i.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */