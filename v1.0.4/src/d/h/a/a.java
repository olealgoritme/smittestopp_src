package d.h.a;

import d.f.h;
import d.i.h.b;
import java.util.ArrayList;
import java.util.HashSet;

public final class a<T>
{
  public final b<ArrayList<T>> a = new b(10);
  public final h<T, ArrayList<T>> b = new h();
  public final ArrayList<T> c = new ArrayList();
  public final HashSet<T> d = new HashSet();
  
  public void a(T paramT)
  {
    int i;
    if (b.a(paramT) >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      b.put(paramT, null);
    }
  }
  
  public final void a(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (!paramHashSet.contains(paramT))
    {
      paramHashSet.add(paramT);
      ArrayList localArrayList = (ArrayList)b.getOrDefault(paramT, null);
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          a(localArrayList.get(i), paramArrayList, paramHashSet);
          i++;
        }
      }
      paramHashSet.remove(paramT);
      paramArrayList.add(paramT);
      return;
    }
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
}

/* Location:
 * Qualified Name:     base.d.h.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */