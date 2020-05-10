package k.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class e0
  extends c<List>
{
  public final e0.b a;
  public final e0.b b;
  public final e0.b c;
  public x d;
  
  public e0(x paramx, r paramr)
  {
    d = paramx;
    a = new e0.a(this, paramx, paramr);
    b = new e0.c(this, paramx, paramr);
    c = new e0.d(this, paramx, paramr);
    c.put(List.class, this);
    paramr.a(this);
  }
  
  public static int a(List paramList, x paramx)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject1 = paramList.get(j);
      Object localObject2 = paramx.a(localObject1);
      if (localObject2 != null)
      {
        localObject2 = ((a)localObject2).a(localObject1);
        int m = ((r0)localObject2).d();
        k += ((r0)localObject2).b(localObject1) + m;
        j++;
      }
      else
      {
        paramList = e.a.a.a.a.a("No encoding defined for type: ");
        paramList.append(localObject1.getClass());
        throw new IllegalArgumentException(paramList.toString());
      }
    }
    return k;
  }
  
  public Class<List> a()
  {
    return List.class;
  }
  
  public e0.b a(List paramList)
  {
    int i = a(paramList, d);
    e0.b localb;
    if (paramList.isEmpty()) {
      localb = c;
    } else if ((paramList.size() <= 255) && (i < 254)) {
      localb = b;
    } else {
      localb = a;
    }
    localb.a(paramList, i);
    return localb;
  }
  
  public r0 f()
  {
    return a;
  }
  
  public Collection<e0.b> i()
  {
    return Arrays.asList(new e0.b[] { c, b, a });
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */