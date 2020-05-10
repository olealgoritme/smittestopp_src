package d.x;

import android.view.View;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p
{
  public final Map<String, Object> a = new HashMap();
  public View b;
  public final ArrayList<h> c = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof p))
    {
      View localView = b;
      paramObject = (p)paramObject;
      if ((localView == b) && (a.equals(a))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = b.hashCode();
    return a.hashCode() + i * 31;
  }
  
  public String toString()
  {
    Object localObject = a.a("TransitionValues@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(":\n");
    localObject = a.a(((StringBuilder)localObject).toString(), "    view = ");
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append("\n");
    localObject = a.b(((StringBuilder)localObject).toString(), "    values:");
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("    ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(a.get(str));
      localStringBuilder.append("\n");
      localObject = localStringBuilder.toString();
    }
    return (String)localObject;
  }
}

/* Location:
 * Qualified Name:     base.d.x.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */