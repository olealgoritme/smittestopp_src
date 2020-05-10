package l.a.b.a.b.n;

import e.a.a.a.a;
import java.util.Map;
import l.a.b.a.b.f;

public final class j
{
  public f a;
  public String b;
  public Map c;
  
  public j() {}
  
  public j(f paramf, String paramString)
  {
    a = paramf;
    b = paramString;
  }
  
  public void a(f paramf)
  {
    if (paramf != null)
    {
      a = paramf;
      return;
    }
    throw new NullPointerException("the condition field is mandatory");
  }
  
  public void a(j paramj)
  {
    a = a;
    b = b;
    c = c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (j.class == paramObject.getClass()))
    {
      paramObject = (j)paramObject;
      Object localObject = a;
      if (localObject != null ? !localObject.equals(a) : a != null) {
        return false;
      }
      localObject = b;
      if (localObject != null ? !((String)localObject).equals(b) : b != null) {
        return false;
      }
      localObject = c;
      paramObject = c;
      return localObject != null ? ((Map)localObject).equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = a;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((f)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = b;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = c;
    if (localObject != null) {
      i = ((Map)localObject).hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("Error{condition=");
    localStringBuilder.append(a);
    localStringBuilder.append(", description='");
    a.a(localStringBuilder, b, '\'', ", info=");
    localStringBuilder.append(c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.b.n.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */