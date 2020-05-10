package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$n
  extends a<char[]>
{
  public a$n(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new char[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Iterator)localObject).next().toString().charAt(0);
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */