package j.a.b.n;

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
    Object localObject = (List)paramObject;
    paramObject = new Short[((List)localObject).size()];
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
        if ((localObject instanceof Short)) {
          paramObject[i] = ((Short)localObject);
        } else {
          paramObject[i] = Short.valueOf(((Number)localObject).shortValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */