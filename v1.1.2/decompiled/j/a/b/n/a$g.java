package j.a.b.n;

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
    Object localObject = (List)paramObject;
    paramObject = new Boolean[((List)localObject).size()];
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
        if ((localObject instanceof Boolean))
        {
          paramObject[i] = Boolean.valueOf(((Boolean)localObject).booleanValue());
        }
        else
        {
          if (!(localObject instanceof Number)) {
            break;
          }
          boolean bool;
          if (((Number)localObject).intValue() != 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramObject[i] = Boolean.valueOf(bool);
        }
        i++;
      }
    }
    paramObject = new StringBuilder("can not convert ");
    ((StringBuilder)paramObject).append(localObject);
    ((StringBuilder)paramObject).append(" toBoolean");
    throw new RuntimeException(((StringBuilder)paramObject).toString());
  }
}

/* Location:
 * Qualified Name:     j.a.b.n.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */