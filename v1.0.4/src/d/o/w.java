package d.o;

import android.os.Bundle;
import d.v.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class w
{
  public final Map<String, Object> a;
  public final a.b b;
  
  static
  {
    Class localClass = Boolean.TYPE;
    localClass = Double.TYPE;
    localClass = Integer.TYPE;
    localClass = Long.TYPE;
    localClass = Byte.TYPE;
    localClass = Character.TYPE;
    localClass = Float.TYPE;
    localClass = Short.TYPE;
  }
  
  public w()
  {
    new HashMap();
    b = new w.a(this);
    a = new HashMap();
  }
  
  public w(Map<String, Object> paramMap)
  {
    new HashMap();
    b = new w.a(this);
    a = new HashMap(paramMap);
  }
  
  public static w a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return new w();
    }
    HashMap localHashMap = new HashMap();
    if (paramBundle2 != null)
    {
      Iterator localIterator = paramBundle2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle2.get(str));
      }
    }
    if (paramBundle1 == null) {
      return new w(localHashMap);
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    if ((paramBundle2 != null) && (paramBundle1 != null) && (paramBundle2.size() == paramBundle1.size()))
    {
      for (int i = 0; i < paramBundle2.size(); i++) {
        localHashMap.put((String)paramBundle2.get(i), paramBundle1.get(i));
      }
      return new w(localHashMap);
    }
    throw new IllegalStateException("Invalid bundle passed as restored state");
  }
}

/* Location:
 * Qualified Name:     base.d.o.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */