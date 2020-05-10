package l.a.b.a.c;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g0
  extends c<Map>
{
  public final b a;
  public final b b;
  public x c;
  public a<?> d;
  
  public g0(x paramx, r paramr)
  {
    c = paramx;
    a = new a(paramx, paramr);
    b = new c(paramx, paramr);
    c.put(Map.class, this);
    paramr.a(this);
  }
  
  public final int a(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    a locala = d;
    d = null;
    int i = 0;
    try
    {
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (locala == null) {
          paramMap = c.a(localEntry.getKey()).a(localEntry.getKey());
        } else {
          paramMap = locala.a(localEntry.getKey());
        }
        int j = paramMap.d();
        int k = paramMap.a(localEntry.getKey());
        paramMap = c.a(localEntry.getValue()).a(localEntry.getValue());
        int m = paramMap.d();
        int n = paramMap.a(localEntry.getValue());
        i = m + n + (j + k + i);
      }
      return i;
    }
    finally
    {
      d = locala;
    }
  }
  
  public Class<Map> b()
  {
    return Map.class;
  }
  
  public b b(Map paramMap)
  {
    int i = a(paramMap);
    b localb;
    if ((paramMap.size() <= 127) && (i < 254)) {
      localb = b;
    } else {
      localb = a;
    }
    localb.a(paramMap, i);
    return localb;
  }
  
  public r0 e()
  {
    return a;
  }
  
  public Collection<b> k()
  {
    return Arrays.asList(new b[] { b, a });
  }
  
  public class a
    extends d0<Map>
    implements g0.b
  {
    public Map c;
    public int d;
    
    public a(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(Map paramMap, int paramInt)
    {
      c = paramMap;
      d = paramInt;
    }
    
    public boolean a(r0<Map> paramr0)
    {
      boolean bool;
      if (g0.this == paramr0.getType()) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int c(Object paramObject)
    {
      paramObject = (Map)paramObject;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = a((Map)paramObject);
      }
      return i + 4;
    }
    
    public void d(Object paramObject)
    {
      paramObject = (Map)paramObject;
      Object localObject = a.a;
      if (paramObject == c) {
        i = d;
      } else {
        i = a((Map)paramObject);
      }
      ((y0)localObject).b(i + 4 + 4);
      localObject = a;
      int i = ((Map)paramObject).size();
      a.c(i * 2);
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      paramObject = g0.this;
      localObject = d;
      d = null;
      try
      {
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localObject == null) {
            paramObject = c.a(localEntry.getKey()).a(localEntry.getKey());
          } else {
            paramObject = ((a)localObject).a(localEntry.getKey());
          }
          ((r0)paramObject).c();
          ((r0)paramObject).b(localEntry.getKey());
          paramObject = a.a(localEntry.getValue()).a(localEntry.getValue());
          ((r0)paramObject).c();
          ((r0)paramObject).b(localEntry.getValue());
        }
        return;
      }
      finally
      {
        d = ((a)localObject);
      }
    }
    
    public byte f()
    {
      return -47;
    }
    
    public a getType()
    {
      return g0.this;
    }
    
    public i0 getType()
    {
      return g0.this;
    }
    
    public Object i()
    {
      r localr = b;
      k0 localk0 = a;
      localr.f();
      int i = localr.f();
      if (i <= localr.a())
      {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap(i);
        q0 localq01 = null;
        localObject1 = null;
        int j = 0;
        while (j < i / 2)
        {
          localq01 = g0.a(localr, localk0, localq01);
          if (localq01 != null)
          {
            Object localObject2 = localq01.i();
            int k = localk0.get(localk0.position());
            if ((k != -32) && (k != -16)) {
              k = 0;
            } else {
              k = 1;
            }
            q0 localq02 = g0.a(localr, localk0, (q0)localObject1);
            if (localq02 != null)
            {
              if (k != 0) {
                localObject1 = ((e.b)localq02).h();
              } else {
                localObject1 = localq02.i();
              }
              localLinkedHashMap.put(localObject2, localObject1);
              j++;
              localObject1 = localq02;
            }
            else
            {
              throw new q("Unknown constructor");
            }
          }
          else
          {
            throw new q("Unknown constructor");
          }
        }
        return localLinkedHashMap;
      }
      Object localObject1 = e.a.a.a.a.a("Map element count ", i, " is specified to be greater than the amount of data available (");
      ((StringBuilder)localObject1).append(localr.a());
      ((StringBuilder)localObject1).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
  }
  
  public static abstract interface b
    extends j0<Map>
  {
    public abstract void a(Map paramMap, int paramInt);
  }
  
  public class c
    extends m0<Map>
    implements g0.b
  {
    public Map c;
    public int d;
    
    public c(x paramx, r paramr)
    {
      super(paramr);
    }
    
    public void a(Map paramMap, int paramInt)
    {
      c = paramMap;
      d = paramInt;
    }
    
    public boolean a(r0<Map> paramr0)
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
      paramObject = (Map)paramObject;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = a((Map)paramObject);
      }
      return i + 1;
    }
    
    public void d(Object paramObject)
    {
      paramObject = (Map)paramObject;
      Object localObject = a.a;
      int i;
      if (paramObject == c) {
        i = d;
      } else {
        i = a((Map)paramObject);
      }
      ((y0)localObject).b(i + 1 + 1);
      localObject = a;
      byte b = (byte)(((Map)paramObject).size() * 2);
      a.a(b);
      Iterator localIterator = ((Map)paramObject).entrySet().iterator();
      paramObject = g0.this;
      localObject = d;
      d = null;
      try
      {
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localObject == null) {
            paramObject = c.a(localEntry.getKey()).a(localEntry.getKey());
          } else {
            paramObject = ((a)localObject).a(localEntry.getKey());
          }
          ((r0)paramObject).c();
          ((r0)paramObject).b(localEntry.getKey());
          paramObject = a.a(localEntry.getValue()).a(localEntry.getValue());
          ((r0)paramObject).c();
          ((r0)paramObject).b(localEntry.getValue());
        }
        return;
      }
      finally
      {
        d = ((a)localObject);
      }
    }
    
    public byte f()
    {
      return -63;
    }
    
    public a getType()
    {
      return g0.this;
    }
    
    public i0 getType()
    {
      return g0.this;
    }
    
    public Object i()
    {
      r localr = b;
      k0 localk0 = a;
      localr.e();
      int i = localr.e() & 0xFF;
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(i);
      q0 localq01 = null;
      Object localObject1 = null;
      int j = 0;
      while (j < i / 2)
      {
        localq01 = g0.a(localr, localk0, localq01);
        if (localq01 != null)
        {
          Object localObject2 = localq01.i();
          int k = localk0.get(localk0.position());
          if ((k != -32) && (k != -16)) {
            k = 0;
          } else {
            k = 1;
          }
          q0 localq02 = g0.a(localr, localk0, (q0)localObject1);
          if (localq02 != null)
          {
            if (k != 0) {
              localObject1 = ((e.b)localq02).h();
            } else {
              localObject1 = localq02.i();
            }
            localLinkedHashMap.put(localObject2, localObject1);
            j++;
            localObject1 = localq02;
          }
          else
          {
            throw new q("Unknown constructor");
          }
        }
        else
        {
          throw new q("Unknown constructor");
        }
      }
      return localLinkedHashMap;
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.g0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */