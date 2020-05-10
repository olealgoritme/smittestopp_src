package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$j
  extends a<short[]>
{
  public a$j(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new short[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Number)((Iterator)localObject).next()).shortValue();
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */