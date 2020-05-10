package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$f
  extends a<boolean[]>
{
  public a$f(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new boolean[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Boolean)((Iterator)localObject).next()).booleanValue();
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */