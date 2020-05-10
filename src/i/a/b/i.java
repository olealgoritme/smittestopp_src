package i.a.b;

import i.a.b.m.l;
import i.a.b.m.l.i;
import i.a.b.m.n;
import i.a.b.n.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class i
{
  public static g a = g.h;
  public static final l b = new l();
  public static final e c = new e();
  
  public static String a(String paramString)
  {
    g localg = a;
    if (paramString == null)
    {
      paramString = null;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.a(paramString, localStringBuilder);
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  public static void a(Object paramObject, Appendable paramAppendable, g paramg)
  {
    if (paramObject == null)
    {
      paramAppendable.append("null");
      return;
    }
    Class localClass = paramObject.getClass();
    Object localObject1 = (n)ba.get(localClass);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (localClass.isArray())
      {
        localObject2 = l.k;
      }
      else
      {
        localObject1 = b;
        localObject2 = paramObject.getClass();
        Iterator localIterator = b.iterator();
        do
        {
          if (!localIterator.hasNext())
          {
            localObject1 = null;
            break;
          }
          localObject1 = (l.i)localIterator.next();
        } while (!a.isAssignableFrom((Class)localObject2));
        localObject1 = b;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = l.j;
        }
      }
      b.a((n)localObject2, new Class[] { localClass });
    }
    ((n)localObject2).a(paramObject, paramAppendable, paramg);
  }
  
  public static void a(String paramString, Appendable paramAppendable, g paramg)
  {
    if (paramString == null) {
      return;
    }
    g.a(paramString, paramAppendable);
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */