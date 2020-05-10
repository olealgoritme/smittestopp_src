package l.d.b.j;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import l.d.b.d;
import l.d.b.f;

public class h<T>
{
  public final l.d.b.a<T, ?> a;
  public final List<i> b;
  
  public h(l.d.b.a<T, ?> parama, String paramString)
  {
    a = parama;
    b = new ArrayList();
  }
  
  public void a(StringBuilder paramStringBuilder, String paramString, List<Object> paramList)
  {
    ListIterator localListIterator = b.listIterator();
    while (localListIterator.hasNext())
    {
      if (localListIterator.hasPrevious()) {
        paramStringBuilder.append(" AND ");
      }
      i locali = (i)localListIterator.next();
      locali.a(paramStringBuilder, paramString);
      locali.a(paramList);
    }
  }
  
  public void a(i parami)
  {
    if ((parami instanceof i.b))
    {
      parami = d;
      Object localObject = a;
      if (localObject != null)
      {
        localObject = a.z;
        int i = localObject.length;
        int j = 0;
        int m;
        for (int k = 0;; k++)
        {
          m = j;
          if (k >= i) {
            break;
          }
          if (parami == localObject[k])
          {
            m = 1;
            break;
          }
        }
        if (m == 0)
        {
          localObject = e.a.a.a.a.a("Property '");
          ((StringBuilder)localObject).append(c);
          ((StringBuilder)localObject).append("' is not part of ");
          ((StringBuilder)localObject).append(a);
          throw new d(((StringBuilder)localObject).toString());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */