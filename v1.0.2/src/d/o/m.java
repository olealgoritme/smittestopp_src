package d.o;

import d.c.a.b.a;
import d.c.a.b.b;
import d.c.a.b.b.b;
import d.c.a.b.b.c;
import d.c.a.b.b.d;
import d.c.a.b.b.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class m
  extends g
{
  public a<k, m.a> a = new a();
  public g.b b;
  public final WeakReference<l> c;
  public int d = 0;
  public boolean e = false;
  public boolean f = false;
  public ArrayList<g.b> g = new ArrayList();
  
  public m(l paraml)
  {
    c = new WeakReference(paraml);
    b = g.b.INITIALIZED;
  }
  
  public static g.b a(g.b paramb1, g.b paramb2)
  {
    g.b localb = paramb1;
    if (paramb2 != null)
    {
      localb = paramb1;
      if (paramb2.compareTo(paramb1) < 0) {
        localb = paramb2;
      }
    }
    return localb;
  }
  
  public static g.a b(g.b paramb)
  {
    int i = paramb.ordinal();
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unexpected state value ");
            localStringBuilder.append(paramb);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          throw new IllegalArgumentException();
        }
        return g.a.ON_RESUME;
      }
      return g.a.ON_START;
    }
    return g.a.ON_CREATE;
  }
  
  public static g.b b(g.a parama)
  {
    int i = parama.ordinal();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              break label79;
            }
            if (i == 5) {
              return g.b.DESTROYED;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unexpected event value ");
            localStringBuilder.append(parama);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
        }
        else {
          return g.b.RESUMED;
        }
      }
      return g.b.STARTED;
    }
    label79:
    return g.b.CREATED;
  }
  
  public final void a()
  {
    ArrayList localArrayList = g;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  public void a(g.a parama)
  {
    a(b(parama));
  }
  
  public final void a(g.b paramb)
  {
    if (b == paramb) {
      return;
    }
    b = paramb;
    if ((!e) && (d == 0))
    {
      e = true;
      b();
      e = false;
      return;
    }
    f = true;
  }
  
  public void a(k paramk)
  {
    Object localObject = b;
    g.b localb = g.b.DESTROYED;
    if (localObject != localb) {
      localb = g.b.INITIALIZED;
    }
    m.a locala = new m.a(paramk, localb);
    if ((m.a)a.b(paramk, locala) != null) {
      return;
    }
    localObject = (l)c.get();
    if (localObject == null) {
      return;
    }
    int i;
    if ((d == 0) && (!e)) {
      i = 0;
    } else {
      i = 1;
    }
    localb = b(paramk);
    d += 1;
    while ((a.compareTo(localb) < 0) && (a.B.containsKey(paramk)))
    {
      localb = a;
      g.add(localb);
      locala.a((l)localObject, b(a));
      a();
      localb = b(paramk);
    }
    if (i == 0) {
      b();
    }
    d -= 1;
  }
  
  public final g.b b(k paramk)
  {
    a locala = a;
    boolean bool = B.containsKey(paramk);
    Object localObject = null;
    if (bool) {
      paramk = B.get(paramk)).A;
    } else {
      paramk = null;
    }
    if (paramk != null) {
      paramk = getValuea;
    } else {
      paramk = null;
    }
    if (!g.isEmpty())
    {
      localObject = g;
      localObject = (g.b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(b, paramk), (g.b)localObject);
  }
  
  public final void b()
  {
    Object localObject1 = (l)c.get();
    if (localObject1 != null)
    {
      Object localObject2;
      label87:
      Object localObject4;
      Object localObject5;
      label355:
      label363:
      do
      {
        localObject2 = a;
        if (A != 0)
        {
          localObject3 = x.getValue()).a;
          localObject2 = a.y.getValue()).a;
          if ((localObject3 != localObject2) || (b != localObject2)) {}
        }
        else
        {
          i = 1;
          break label87;
        }
        int i = 0;
        if (i != 0) {
          break;
        }
        f = false;
        if (b.compareTo(a.x.getValue()).a) < 0)
        {
          localObject2 = a;
          localObject3 = new b.b(y, x);
          z.put(localObject3, Boolean.valueOf(false));
          while ((((b.e)localObject3).hasNext()) && (!f))
          {
            localObject4 = (Map.Entry)((b.e)localObject3).next();
            localObject5 = (m.a)((Map.Entry)localObject4).getValue();
            while ((a.compareTo(b) > 0) && (!f) && (a.contains(((Map.Entry)localObject4).getKey())))
            {
              localObject2 = a;
              i = ((Enum)localObject2).ordinal();
              if (i == 0) {
                break label363;
              }
              if (i == 1) {
                break label355;
              }
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4)
                  {
                    localObject2 = g.a.ON_PAUSE;
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Unexpected state value ");
                    ((StringBuilder)localObject1).append(localObject2);
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                }
                else {
                  localObject2 = g.a.ON_STOP;
                }
              }
              else {
                localObject2 = g.a.ON_DESTROY;
              }
              g.b localb = b((g.a)localObject2);
              g.add(localb);
              ((m.a)localObject5).a((l)localObject1, (g.a)localObject2);
              a();
            }
            continue;
            throw new IllegalArgumentException();
            throw new IllegalArgumentException();
          }
        }
        localObject2 = a.y;
      } while ((f) || (localObject2 == null) || (b.compareTo(getValuea) <= 0));
      Object localObject3 = a.a();
      while ((((b.d)localObject3).hasNext()) && (!f))
      {
        localObject2 = (Map.Entry)((b.d)localObject3).next();
        localObject4 = (m.a)((Map.Entry)localObject2).getValue();
        while ((a.compareTo(b) < 0) && (!f) && (a.contains(((Map.Entry)localObject2).getKey())))
        {
          localObject5 = a;
          g.add(localObject5);
          ((m.a)localObject4).a((l)localObject1, b(a));
          a();
        }
      }
      f = false;
      return;
    }
    throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
  }
}

/* Location:
 * Qualified Name:     base.d.o.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */