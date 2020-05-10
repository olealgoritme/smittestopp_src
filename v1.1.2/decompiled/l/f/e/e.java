package l.f.e;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import l.f.a;
import l.f.b;

public class e
  implements a
{
  public boolean a = false;
  public final Map<String, d> b = new HashMap();
  public final LinkedBlockingQueue<l.f.d.d> c = new LinkedBlockingQueue();
  
  public b a(String paramString)
  {
    try
    {
      d locald1 = (d)b.get(paramString);
      d locald2 = locald1;
      if (locald1 == null)
      {
        locald2 = new l/f/e/d;
        locald2.<init>(paramString, c, a);
        b.put(paramString, locald2);
      }
      return locald2;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     l.f.e.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */