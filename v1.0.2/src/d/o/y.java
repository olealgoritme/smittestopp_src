package d.o;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class y
{
  public final Map<String, Object> a = new HashMap();
  public volatile boolean b = false;
  
  public <T> T a(String paramString)
  {
    Map localMap = a;
    if (localMap == null) {
      return null;
    }
    try
    {
      paramString = a.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public <T> T a(String paramString, T paramT)
  {
    synchronized (a)
    {
      Object localObject = a.get(paramString);
      if (localObject == null) {
        a.put(paramString, paramT);
      }
      if (localObject != null) {
        paramT = (T)localObject;
      }
      if ((b) && ((paramT instanceof Closeable))) {
        try
        {
          ((Closeable)paramT).close();
        }
        catch (IOException paramString)
        {
          throw new RuntimeException(paramString);
        }
      }
      return paramT;
    }
  }
  
  public final void a()
  {
    b = true;
    Map localMap = a;
    if (localMap != null) {
      try
      {
        Iterator localIterator = a.values().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          boolean bool = localObject1 instanceof Closeable;
          if (bool) {
            try
            {
              ((Closeable)localObject1).close();
            }
            catch (IOException localIOException)
            {
              localObject1 = new java/lang/RuntimeException;
              ((RuntimeException)localObject1).<init>(localIOException);
              throw ((Throwable)localObject1);
            }
          }
        }
      }
      finally {}
    }
    b();
  }
  
  public void b() {}
}

/* Location:
 * Qualified Name:     base.d.o.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */