package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$c
  extends a<Float[]>
{
  public a$c(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject1 = (List)paramObject;
    paramObject = new Float[((List)localObject1).size()];
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
          paramObject[i] = ((Float)localObject2);
        } else {
          paramObject[i] = Float.valueOf(((Number)localObject2).floatValue());
        }
        i++;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */