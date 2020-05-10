package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$d
  extends a<double[]>
{
  public a$d(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new double[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Number)((Iterator)localObject).next()).doubleValue();
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */