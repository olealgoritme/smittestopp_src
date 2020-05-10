package i.j;

import i.k.a.p;
import i.k.b.g;
import i.k.b.h;

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
    paramObject2 = (d.a)paramObject2;
    if (paramObject1 != null)
    {
      if (paramObject2 != null)
      {
        int i;
        if (((CharSequence)paramObject1).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramObject1 = paramObject2.toString();
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)paramObject1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramObject2);
          paramObject1 = localStringBuilder.toString();
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
 * Qualified Name:     i.j.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */