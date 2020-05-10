package h.j;

import h.k.a.p;
import h.k.b.g;
import h.k.b.h;

public final class b$a
  extends h
  implements p<String, d.a, String>
{
  public static final a x = new a();
  
  public b$a()
  {
    super(2);
  }
  
  public Object a(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (String)paramObject1;
    d.a locala = (d.a)paramObject2;
    if (paramObject1 != null)
    {
      if (locala != null)
      {
        int i;
        if (((CharSequence)paramObject1).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramObject1 = locala.toString();
        }
        else
        {
          paramObject2 = new StringBuilder();
          ((StringBuilder)paramObject2).append((String)paramObject1);
          ((StringBuilder)paramObject2).append(", ");
          ((StringBuilder)paramObject2).append(locala);
          paramObject1 = ((StringBuilder)paramObject2).toString();
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
 * Qualified Name:     base.h.j.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */