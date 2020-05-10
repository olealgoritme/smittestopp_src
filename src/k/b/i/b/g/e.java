package k.b.i.b.g;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements v
{
  public static final Map<String, e> c;
  public final int a;
  public final String b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(a("SHA-256", 32, 16, 67, 10), new e(1, "XMSS_SHA2_10_256"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 16), new e(2, "XMSS_SHA2_16_256"));
    localHashMap.put(a("SHA-256", 32, 16, 67, 20), new e(3, "XMSS_SHA2_20_256"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 10), new e(4, "XMSS_SHA2_10_512"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 16), new e(5, "XMSS_SHA2_16_512"));
    localHashMap.put(a("SHA-512", 64, 16, 131, 20), new e(6, "XMSS_SHA2_20_512"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 10), new e(7, "XMSS_SHAKE_10_256"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 16), new e(8, "XMSS_SHAKE_16_256"));
    localHashMap.put(a("SHAKE128", 32, 16, 67, 20), new e(9, "XMSS_SHAKE_20_256"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 10), new e(10, "XMSS_SHAKE_10_512"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 16), new e(11, "XMSS_SHAKE_16_512"));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 20), new e(12, "XMSS_SHAKE_20_512"));
    c = Collections.unmodifiableMap(localHashMap);
  }
  
  public e(int paramInt, String paramString)
  {
    a = paramInt;
    b = paramString;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt4);
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public static e b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramString != null) {
      return (e)c.get(a(paramString, paramInt1, paramInt2, paramInt3, paramInt4));
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
 * Qualified Name:     base.k.b.i.b.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */