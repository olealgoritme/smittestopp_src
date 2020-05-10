package i.a.b.n;

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
    Object localObject1 = (List)paramObject;
    paramObject = new Byte[((List)localObject1).size()];
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
        if ((localObject2 instanceof Byte)) {
          paramObject[i] = ((Byte)localObject2);
        } else {
          paramObject[i] = Byte.valueOf(((Number)localObject2).byteValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */