package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$m
  extends a<Byte[]>
{
  public a$m(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new Byte[((List)localObject).size()];
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
        if ((localObject instanceof Byte)) {
          paramObject[i] = ((Byte)localObject);
        } else {
          paramObject[i] = Byte.valueOf(((Number)localObject).byteValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */