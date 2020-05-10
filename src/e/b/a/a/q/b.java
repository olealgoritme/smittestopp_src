package e.b.a.a.q;

import java.util.HashSet;

public class b
{
  public final Object a;
  public String b;
  public String c;
  public HashSet<String> d;
  
  public b(Object paramObject)
  {
    a = paramObject;
  }
  
  public b a()
  {
    return new b(a);
  }
  
  public boolean a(String paramString)
  {
    Object localObject = b;
    if (localObject == null)
    {
      b = paramString;
      return false;
    }
    if (paramString.equals(localObject)) {
      return true;
    }
    localObject = c;
    if (localObject == null)
    {
      c = paramString;
      return false;
    }
    if (paramString.equals(localObject)) {
      return true;
    }
    if (d == null)
    {
      localObject = new HashSet(16);
      d = ((HashSet)localObject);
      ((HashSet)localObject).add(b);
      d.add(c);
    }
    return d.add(paramString) ^ true;
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.q.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */