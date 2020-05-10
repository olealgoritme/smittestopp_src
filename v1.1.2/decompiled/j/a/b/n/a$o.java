package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$o
  extends a<Character[]>
{
  public a$o(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new Character[((List)localObject).size()];
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
        paramObject[i] = Character.valueOf(localObject.toString().charAt(0));
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */