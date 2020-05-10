package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$e
  extends a<Double[]>
{
  public a$e(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new Double[((List)localObject).size()];
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramObject;
      }
      localObject = localIterator.next();
      if (localObject != null)
      {
        if ((localObject instanceof Double)) {
          paramObject[i] = ((Double)localObject);
        } else {
          paramObject[i] = Double.valueOf(((Number)localObject).doubleValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */