package j.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$b
  extends a<float[]>
{
  public a$b(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new float[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Number)((Iterator)localObject).next()).floatValue();
    }
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */