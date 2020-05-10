package k.a.b.a.c;

import java.util.ArrayList;
import java.util.List;

public class e0$c
  extends m0<List>
  implements e0.b
{
  public List c;
  public int d;
  
  public e0$c(e0 parame0, x paramx, r paramr)
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
    if (paramr0 == this) {
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
    return i + 1;
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
    ((y0)localObject2).c(i + 1 + 1);
    localObject2 = a;
    byte b = (byte)((List)paramObject).size();
    a.a(b);
    int j = ((List)paramObject).size();
    for (int i = 0; i < j; i++)
    {
      localObject2 = ((List)paramObject).get(i);
      localObject1 = a.a(localObject2).a(localObject2);
      ((r0)localObject1).c();
      ((r0)localObject1).a(localObject2);
    }
  }
  
  public byte g()
  {
    return -64;
  }
  
  public a getType()
  {
    return e;
  }
  
  public i0 getType()
  {
    return e;
  }
  
  public Object k()
  {
    Object localObject1 = b;
    k0 localk0 = a;
    ((r)localObject1).e();
    int i = ((r)localObject1).e() & 0xFF;
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
        if (k != ((j0)localObject1).g()) {
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
        Object localObject2;
        if (m != 0) {
          localObject2 = ((e.b)localObject1).j();
        } else {
          localObject2 = ((q0)localObject1).k();
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
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.e0.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */