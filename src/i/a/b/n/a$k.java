package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$k
  extends a<Short[]>
{
  public a$k(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject1 = (List)paramObject;
    paramObject = new Short[((List)localObject1).size()];
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
        if ((localObject2 instanceof Short)) {
          paramObject[i] = ((Short)localObject2);
        } else {
          paramObject[i] = Short.valueOf(((Number)localObject2).shortValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */