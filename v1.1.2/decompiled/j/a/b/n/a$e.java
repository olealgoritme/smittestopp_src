package j.a.b.n;

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
    Object localObject1 = (List)paramObject;
    paramObject = new Double[((List)localObject1).size()];
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return paramObject;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        if ((localObject2 instanceof Double)) {
          paramObject[i] = ((Double)localObject2);
        } else {
          paramObject[i] = Double.valueOf(((Number)localObject2).doubleValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */