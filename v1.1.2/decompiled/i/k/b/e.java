package i.k.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<*>;
import java.util.Iterator;

public final class e
{
  public static final Object[] a = new Object[0];
  
  public static final Object[] a(Collection<?> paramCollection)
  {
    if (paramCollection != null)
    {
      int i = paramCollection.size();
      if (i == 0) {}
      Iterator localIterator;
      do
      {
        paramCollection = a;
        break;
        localIterator = paramCollection.iterator();
      } while (!localIterator.hasNext());
      paramCollection = new Object[i];
      i = 0;
      for (;;)
      {
        int j = i + 1;
        paramCollection[i] = localIterator.next();
        Object localObject;
        if (j >= paramCollection.length)
        {
          if (localIterator.hasNext())
          {
            int k = j * 3 + 1 >>> 1;
            i = k;
            if (k <= j) {
              if (j < 2147483645) {
                i = 2147483645;
              } else {
                throw new OutOfMemoryError();
              }
            }
            localObject = Arrays.copyOf(paramCollection, i);
            g.a(localObject, "Arrays.copyOf(result, newSize)");
            break label160;
          }
        }
        else
        {
          localObject = paramCollection;
          if (localIterator.hasNext()) {
            break label160;
          }
          paramCollection = Arrays.copyOf(paramCollection, j);
          g.a(paramCollection, "Arrays.copyOf(result, size)");
        }
        return paramCollection;
        label160:
        i = j;
        paramCollection = (Collection<?>)localObject;
      }
    }
    g.a("collection");
    throw null;
  }
  
  public static final Object[] a(Collection<?> paramCollection, Object[] paramArrayOfObject)
  {
    if (paramCollection != null)
    {
      if (paramArrayOfObject != null)
      {
        int i = paramCollection.size();
        int j = 0;
        Iterator localIterator;
        if (i == 0)
        {
          paramCollection = paramArrayOfObject;
          if (paramArrayOfObject.length > 0)
          {
            paramArrayOfObject[0] = null;
            paramCollection = paramArrayOfObject;
          }
        }
        else
        {
          localIterator = paramCollection.iterator();
          if (!localIterator.hasNext())
          {
            paramCollection = paramArrayOfObject;
            if (paramArrayOfObject.length > 0)
            {
              paramArrayOfObject[0] = null;
              paramCollection = paramArrayOfObject;
            }
          }
          else if (i <= paramArrayOfObject.length)
          {
            paramCollection = paramArrayOfObject;
          }
          else
          {
            paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
            if (paramCollection == null) {
              break label240;
            }
          }
        }
        Object localObject;
        for (paramCollection = (Object[])paramCollection;; paramCollection = (Collection<?>)localObject)
        {
          i = j + 1;
          paramCollection[j] = localIterator.next();
          if (i >= paramCollection.length)
          {
            if (localIterator.hasNext())
            {
              int k = i * 3 + 1 >>> 1;
              j = k;
              if (k <= i) {
                if (i < 2147483645) {
                  j = 2147483645;
                } else {
                  throw new OutOfMemoryError();
                }
              }
              localObject = Arrays.copyOf(paramCollection, j);
              g.a(localObject, "Arrays.copyOf(result, newSize)");
              break label232;
            }
          }
          else
          {
            localObject = paramCollection;
            if (localIterator.hasNext()) {
              break label232;
            }
            if (paramCollection == paramArrayOfObject)
            {
              paramArrayOfObject[i] = null;
              paramCollection = paramArrayOfObject;
            }
            else
            {
              paramCollection = Arrays.copyOf(paramCollection, i);
              g.a(paramCollection, "Arrays.copyOf(result, size)");
            }
          }
          return paramCollection;
          label232:
          j = i;
        }
        label240:
        throw new i.e("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      }
      throw null;
    }
    g.a("collection");
    throw null;
  }
}

/* Location:
 * Qualified Name:     i.k.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */