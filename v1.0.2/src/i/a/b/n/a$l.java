package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$l
  extends a<byte[]>
{
  public a$l(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new byte[((List)localObject).size()];
    localObject = ((List)localObject).iterator();
    for (int i = 0;; i++)
    {
      if (!((Iterator)localObject).hasNext()) {
        return paramObject;
      }
      paramObject[i] = ((Number)((Iterator)localObject).next()).byteValue();
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */