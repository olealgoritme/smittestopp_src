package l.b.i.b.g;

import e.a.a.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements v
{
  public static final Map<String, d> c;
  public final int a;
  public final String b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a.a(1, "XMSSMT_SHA2_20/2_256", localHashMap, a("SHA-256", 32, 16, 67, 20, 2));
    a.a(2, "XMSSMT_SHA2_20/4_256", localHashMap, a("SHA-256", 32, 16, 67, 20, 4));
    a.a(3, "XMSSMT_SHA2_40/2_256", localHashMap, a("SHA-256", 32, 16, 67, 40, 2));
    a.a(4, "XMSSMT_SHA2_40/4_256", localHashMap, a("SHA-256", 32, 16, 67, 40, 2));
    a.a(5, "XMSSMT_SHA2_40/8_256", localHashMap, a("SHA-256", 32, 16, 67, 40, 4));
    a.a(6, "XMSSMT_SHA2_60/3_256", localHashMap, a("SHA-256", 32, 16, 67, 60, 8));
    a.a(7, "XMSSMT_SHA2_60/6_256", localHashMap, a("SHA-256", 32, 16, 67, 60, 6));
    a.a(8, "XMSSMT_SHA2_60/12_256", localHashMap, a("SHA-256", 32, 16, 67, 60, 12));
    a.a(9, "XMSSMT_SHA2_20/2_512", localHashMap, a("SHA-512", 64, 16, 131, 20, 2));
    a.a(10, "XMSSMT_SHA2_20/4_512", localHashMap, a("SHA-512", 64, 16, 131, 20, 4));
    a.a(11, "XMSSMT_SHA2_40/2_512", localHashMap, a("SHA-512", 64, 16, 131, 40, 2));
    a.a(12, "XMSSMT_SHA2_40/4_512", localHashMap, a("SHA-512", 64, 16, 131, 40, 4));
    a.a(13, "XMSSMT_SHA2_40/8_512", localHashMap, a("SHA-512", 64, 16, 131, 40, 8));
    a.a(14, "XMSSMT_SHA2_60/3_512", localHashMap, a("SHA-512", 64, 16, 131, 60, 3));
    a.a(15, "XMSSMT_SHA2_60/6_512", localHashMap, a("SHA-512", 64, 16, 131, 60, 6));
    a.a(16, "XMSSMT_SHA2_60/12_512", localHashMap, a("SHA-512", 64, 16, 131, 60, 12));
    a.a(17, "XMSSMT_SHAKE_20/2_256", localHashMap, a("SHAKE128", 32, 16, 67, 20, 2));
    a.a(18, "XMSSMT_SHAKE_20/4_256", localHashMap, a("SHAKE128", 32, 16, 67, 20, 4));
    a.a(19, "XMSSMT_SHAKE_40/2_256", localHashMap, a("SHAKE128", 32, 16, 67, 40, 2));
    a.a(20, "XMSSMT_SHAKE_40/4_256", localHashMap, a("SHAKE128", 32, 16, 67, 40, 4));
    a.a(21, "XMSSMT_SHAKE_40/8_256", localHashMap, a("SHAKE128", 32, 16, 67, 40, 8));
    a.a(22, "XMSSMT_SHAKE_60/3_256", localHashMap, a("SHAKE128", 32, 16, 67, 60, 3));
    a.a(23, "XMSSMT_SHAKE_60/6_256", localHashMap, a("SHAKE128", 32, 16, 67, 60, 6));
    a.a(24, "XMSSMT_SHAKE_60/12_256", localHashMap, a("SHAKE128", 32, 16, 67, 60, 12));
    a.a(25, "XMSSMT_SHAKE_20/2_512", localHashMap, a("SHAKE256", 64, 16, 131, 20, 2));
    a.a(26, "XMSSMT_SHAKE_20/4_512", localHashMap, a("SHAKE256", 64, 16, 131, 20, 4));
    a.a(27, "XMSSMT_SHAKE_40/2_512", localHashMap, a("SHAKE256", 64, 16, 131, 40, 2));
    a.a(28, "XMSSMT_SHAKE_40/4_512", localHashMap, a("SHAKE256", 64, 16, 131, 40, 4));
    a.a(29, "XMSSMT_SHAKE_40/8_512", localHashMap, a("SHAKE256", 64, 16, 131, 40, 8));
    a.a(30, "XMSSMT_SHAKE_60/3_512", localHashMap, a("SHAKE256", 64, 16, 131, 60, 3));
    a.a(31, "XMSSMT_SHAKE_60/6_512", localHashMap, a("SHAKE256", 64, 16, 131, 60, 6));
    localHashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new d(32, "XMSSMT_SHAKE_60/12_512"));
    c = Collections.unmodifiableMap(localHashMap);
  }
  
  public d(int paramInt, String paramString)
  {
    a = paramInt;
    b = paramString;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
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
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt5);
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public static d b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramString != null) {
      return (d)c.get(a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
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
 * Qualified Name:     l.b.i.b.g.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */