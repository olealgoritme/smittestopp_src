package e.c.c;

import e.c.c.w.r;
import e.c.c.w.r.e;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;

public final class m
  extends j
{
  public final r<String, j> a = new r();
  
  public final j a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = l.a;
    } else {
      paramObject = new p(paramObject);
    }
    return (j)paramObject;
  }
  
  public j a(String paramString)
  {
    paramString = a.a(paramString);
    if (paramString != null) {
      paramString = D;
    } else {
      paramString = null;
    }
    return (j)paramString;
  }
  
  public void a(String paramString, j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = l.a;
    }
    a.put(paramString, localObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, a(paramString2));
  }
  
  public m b(String paramString)
  {
    paramString = a.a(paramString);
    if (paramString != null) {
      paramString = D;
    } else {
      paramString = null;
    }
    return (m)paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && ((!(paramObject instanceof m)) || (!a.equals(a)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public Set<Map.Entry<String, j>> g()
  {
    return a.entrySet();
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */