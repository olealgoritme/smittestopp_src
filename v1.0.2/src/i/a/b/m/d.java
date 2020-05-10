package i.a.b.m;

import i.a.b.g;
import i.a.b.i;
import java.util.Date;

public class d
  implements n<Date>
{
  public d(l paraml) {}
  
  public void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    paramObject = (Date)paramObject;
    paramAppendable.append('"');
    i.a(((Date)paramObject).toString(), paramAppendable, paramg);
    paramAppendable.append('"');
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.m.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */