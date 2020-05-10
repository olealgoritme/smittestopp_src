package k.b.i.b.g;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l
  implements v
{
  public static final Map<String, l> c;
  public final int a;
  public final String b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(a("SHA-256", 32, 16, 67), new l(16777217, "WOTSP_SHA2-256_W16"));
    localHashMap.put(a("SHA-512", 64, 16, 131), new l(33554434, "WOTSP_SHA2-512_W16"));
    localHashMap.put(a("SHAKE128", 32, 16, 67), new l(50331651, "WOTSP_SHAKE128_W16"));
    localHashMap.put(a("SHAKE256", 64, 16, 131), new l(67108868, "WOTSP_SHAKE256_W16"));
    c = Collections.unmodifiableMap(localHashMap);
  }
  
  public l(int paramInt, String paramString)
  {
    a = paramInt;
    b = paramString;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt3);
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public static l b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null) {
      return (l)c.get(a(paramString, paramInt1, paramInt2, paramInt3));
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public int a()
  {
    return a;
  }
  
  public String toString()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     base.k.b.i.b.g.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */