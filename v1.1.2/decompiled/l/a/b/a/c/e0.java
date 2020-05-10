package l.a.b.a.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class e0
  extends c<List>
{
  public final b a;
  public final b b;
  public final b c;
  public x d;
  
  public e0(x paramx, r paramr)
  {
    d = paramx;
    a = new a(paramx, paramr);
    b = new c(paramx, paramr);
    c = new d(paramx, paramr);
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
        k += ((r0)localObject2).a(localObject1) + m;
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
  
  public b a(List paramList)
  {
    int i = a(paramList, d);
    b localb;
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
  
  public Class<List> b()
  {
    return List.class;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { c, b, a });
  }
  
  public class a
    extends d0<List>
    implements e0.b
  {
    public List c;
    public int d;
    
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(List paramList, int paramInt)
    {
      c = paramList;
      d = paramInt;
    }
    
    public boolean a(r0<List> paramr0)
    {
      boolean bool;
      if (e0.this == paramr0.getType()) {
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
      return e0.this;
    }
    
    public i0 getType()
    {
      return e0.this;
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
  
  public static abstract interface b
    extends j0<List>
  {
    public abstract void a(List paramList, int paramInt);
  }
  
  public class c
    extends m0<List>
    implements e0.b
  {
    public List c;
    public int d;
    
    public c(x paramx, r paramr)
    {
      super(paramr);
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
      ((y0)localObject2).b(i + 1 + 1);
      localObject2 = a;
      byte b = (byte)((List)paramObject).size();
      a.a(b);
      int j = ((List)paramObject).size();
      for (int i = 0; i < j; i++)
      {
        localObject2 = ((List)paramObject).get(i);
        localObject1 = a.a(localObject2).a(localObject2);
        ((r0)localObject1).c();
        ((r0)localObject1).b(localObject2);
      }
    }
    
    public byte f()
    {
      return -64;
    }
    
    public a getType()
    {
      return e0.this;
    }
    
    public i0 getType()
    {
      return e0.this;
    }
    
    public Object i()
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
          Object localObject2;
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
  }
  
  public class d
    extends z<List>
    implements e0.b
  {
    public d(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(List paramList, int paramInt) {}
    
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
    
    public void b(Object paramObject)
    {
      paramObject = (List)paramObject;
    }
    
    public byte f()
    {
      return 69;
    }
    
    public a getType()
    {
      return e0.this;
    }
    
    public i0 getType()
    {
      return e0.this;
    }
    
    public Object i()
    {
      return Collections.EMPTY_LIST;
    }
    
    public int k()
    {
      return 0;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */