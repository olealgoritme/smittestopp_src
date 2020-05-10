package i.a.b.n;

import java.util.Iterator;
import java.util.List;

public class a$g
  extends a<Boolean[]>
{
  public a$g(e parame)
  {
    super(parame);
  }
  
  public Object a(Object paramObject)
  {
    paramObject = (List)paramObject;
    Object localObject = new Boolean[((List)paramObject).size()];
    Iterator localIterator = ((List)paramObject).iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localObject;
      }
      paramObject = localIterator.next();
      if (paramObject != null)
      {
        if ((paramObject instanceof Boolean))
        {
          localObject[i] = Boolean.valueOf(((Boolean)paramObject).booleanValue());
        }
        else
        {
          if (!(paramObject instanceof Number)) {
            break;
          }
          boolean bool;
          if (((Number)paramObject).intValue() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localObject[i] = Boolean.valueOf(bool);
        }
        i++;
      }
    }
    localObject = new StringBuilder("can not convert ");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(" toBoolean");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.n.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */