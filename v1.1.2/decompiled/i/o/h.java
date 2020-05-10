package i.o;

import i.k.a.p;
import i.l.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class h
  extends i.k.b.h
  implements p<CharSequence, Integer, i.c<? extends Integer, ? extends Integer>>
{
  public h(List paramList, boolean paramBoolean)
  {
    super(2);
  }
  
  public Object a(Object paramObject1, Object paramObject2)
  {
    CharSequence localCharSequence = (CharSequence)paramObject1;
    int i = ((Number)paramObject2).intValue();
    paramObject2 = null;
    if (localCharSequence != null)
    {
      List localList = x;
      boolean bool = y;
      int j;
      if ((!bool) && (localList.size() == 1))
      {
        j = localList.size();
        if (j != 0)
        {
          if (j == 1)
          {
            paramObject1 = (String)localList.get(0);
            j = g.a(localCharSequence, (String)paramObject1, i, false);
            if (j >= 0)
            {
              paramObject1 = new i.c(Integer.valueOf(j), paramObject1);
              break label455;
            }
          }
          else
          {
            throw new IllegalArgumentException("List has more than one element.");
          }
        }
        else {
          throw new NoSuchElementException("List is empty.");
        }
      }
      else
      {
        j = i;
        if (i < 0) {
          j = 0;
        }
        paramObject1 = new i.l.c(j, localCharSequence.length());
        int k;
        Object localObject1;
        Object localObject2;
        if ((localCharSequence instanceof String))
        {
          j = x;
          i = y;
          k = z;
          if (k >= 0 ? j <= i : j >= i) {
            for (;;)
            {
              localObject1 = localList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                paramObject1 = ((Iterator)localObject1).next();
                localObject2 = (String)paramObject1;
                if (g.a((String)localObject2, 0, (String)localCharSequence, j, ((String)localObject2).length(), bool)) {
                  break label270;
                }
              }
              paramObject1 = null;
              label270:
              paramObject1 = (String)paramObject1;
              if (paramObject1 != null)
              {
                paramObject1 = new i.c(Integer.valueOf(j), paramObject1);
                break label455;
              }
              if (j == i) {
                break;
              }
              j += k;
            }
          }
        }
        else
        {
          j = x;
          k = y;
          i = z;
          if (i >= 0 ? j <= k : j >= k) {
            for (;;)
            {
              localObject2 = localList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                paramObject1 = ((Iterator)localObject2).next();
                localObject1 = (String)paramObject1;
                if (g.a((CharSequence)localObject1, 0, localCharSequence, j, ((String)localObject1).length(), bool)) {
                  break label410;
                }
              }
              paramObject1 = null;
              label410:
              paramObject1 = (String)paramObject1;
              if (paramObject1 != null)
              {
                paramObject1 = new i.c(Integer.valueOf(j), paramObject1);
                break label455;
              }
              if (j == k) {
                break;
              }
              j += i;
            }
          }
        }
      }
      paramObject1 = null;
      label455:
      if (paramObject1 != null) {
        paramObject2 = new i.c(x, Integer.valueOf(((String)y).length()));
      }
      return paramObject2;
    }
    i.k.b.g.a("$receiver");
    throw null;
  }
}

/* Location:
 * Qualified Name:     i.o.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */