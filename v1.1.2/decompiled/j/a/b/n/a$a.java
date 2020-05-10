package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$a
  extends a<Long[]>
{
  public a$a(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject1 = (List)paramObject;
    paramObject = new Long[((List)localObject1).size()];
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
        if ((localObject2 instanceof Float)) {
          paramObject[i] = ((Long)localObject2);
        } else {
          paramObject[i] = Long.valueOf(((Number)localObject2).longValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */