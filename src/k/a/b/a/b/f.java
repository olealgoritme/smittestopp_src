package k.a.b.a.b;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import k.a.b.a.c.y0;

public final class f
  implements Comparable<f>, CharSequence
{
  public static final ConcurrentHashMap<String, f> z = new ConcurrentHashMap(2048);
  public final String x;
  public final byte[] y;
  
  public f(String paramString)
  {
    x = paramString;
    y = paramString.getBytes(StandardCharsets.US_ASCII);
  }
  
  public static f a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    f localf = (f)z.get(paramString);
    Object localObject = localf;
    if (localf == null)
    {
      paramString = paramString.intern();
      localObject = new f(paramString);
      paramString = (f)z.putIfAbsent(paramString, localObject);
      if (paramString != null) {
        localObject = paramString;
      }
    }
    return (f)localObject;
  }
  
  public void a(y0 paramy0)
  {
    byte[] arrayOfByte = y;
    paramy0.a(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public char charAt(int paramInt)
  {
    return x.charAt(paramInt);
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (f)paramObject;
    return x.compareTo(x);
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
  
  public int length()
  {
    return x.length();
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return x.subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */