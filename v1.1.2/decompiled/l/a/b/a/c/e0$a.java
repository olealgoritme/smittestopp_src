package l.a.b.a.c;

import java.util.ArrayList;
import java.util.List;

public class e0$a
  extends d0<List>
  implements e0.b
{
  public List c;
  public int d;
  
  public e0$a(e0 parame0, x paramx, r paramr)
  {
    super(paramx, paramr);
  }
  
  public void a(List paramList, int paramInt)
  {
    c = paramList;
    d = paramInt;
  }
  
  public boolean a(r0<List> paramr0)
  {
    boolean bool;
    if (e == paramr0.getType()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int c(Object paramObject)
  {
    paramObject = (List)paramObject;
    int i;
    if (paramObject == c) {
      i = d;
    } else {
      i = e0.a((List)paramObject, a);
    }
    return i + 4;
  }
  
  public void d(Object paramObject)
  {
    paramObject = (List)paramObject;
    Object localObject1 = a;
    Object localObject2 = a;
    if (paramObject == c) {
      i = d;
    } else {
      i = e0.a((List)paramObject, (x)localObject1);
    }
    ((y0)localObject2).b(i + 4 + 4);
    localObject1 = a;
    int i = ((List)paramObject).size();
    a.c(i);
    int j = ((List)paramObject).size();
    for (i = 0; i < j; i++)
    {
      localObject1 = ((List)paramObject).get(i);
      localObject2 = a.a(localObject1).a(localObject1);
      ((r0)localObject2).c();
      ((r0)localObject2).b(localObject1);
    }
  }
  
  public byte f()
  {
    return -48;
  }
  
  public a getType()
  {
    return e;
  }
  
  public i0 getType()
  {
    return e;
  }
  
  public Object i()
  {
    Object localObject1 = b;
    k0 localk0 = a;
    ((r)localObject1).f();
    int i = ((r)localObject1).f();
    if (i <= ((r)localObject1).a())
    {
      localObject1 = null;
      ArrayList localArrayList = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        int k = localk0.get(localk0.position());
        int m;
        if ((k != -32) && (k != -16)) {
          m = 0;
        } else {
          m = 1;
        }
        if (localObject1 == null) {
          localObject1 = b.b();
        } else if ((k != 0) && ((localObject1 instanceof j0)))
        {
          if (k != ((j0)localObject1).f()) {
            localObject1 = b.b();
          } else {
            localk0.get();
          }
        }
        else {
          localObject1 = b.b();
        }
        if (localObject1 != null)
        {
          if (m != 0) {
            localObject2 = ((e.b)localObject1).h();
          } else {
            localObject2 = ((q0)localObject1).i();
          }
          localArrayList.add(localObject2);
          j++;
        }
        else
        {
          throw new q("Unknown constructor");
        }
      }
      return localArrayList;
    }
    Object localObject2 = e.a.a.a.a.a("List element count ", i, " is specified to be greater than the amount of data available (");
    ((StringBuilder)localObject2).append(((r)localObject1).a());
    ((StringBuilder)localObject2).append(")");
    throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.e0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */