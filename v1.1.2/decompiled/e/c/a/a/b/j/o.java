package e.c.a.a.b.j;

import d.b.a.s;
import java.util.List;

public final class o
{
  public final List<String> a;
  public final Object b;
  
  public final o a(String paramString, Object paramObject)
  {
    List localList = a;
    s.a(paramString);
    paramString = (String)paramString;
    paramObject = String.valueOf(paramObject);
    int i = String.valueOf(paramString).length();
    StringBuilder localStringBuilder = new StringBuilder(((String)paramObject).length() + (i + 1));
    localStringBuilder.append(paramString);
    localStringBuilder.append("=");
    localStringBuilder.append((String)paramObject);
    localList.add(localStringBuilder.toString());
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(b.getClass().getSimpleName());
    localStringBuilder.append('{');
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append((String)a.get(j));
      if (j < i - 1) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */