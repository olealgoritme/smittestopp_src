package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$i
  extends a<Integer[]>
{
  public a$i(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new Integer[((List)localObject).size()];
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
        if ((localObject instanceof Integer)) {
          paramObject[i] = ((Integer)localObject);
        } else {
          paramObject[i] = Integer.valueOf(((Number)localObject).intValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */