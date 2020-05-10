package k.b.g.g;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import k.b.a.i2.e;
import k.b.a.m2.f;
import k.b.a.o;

public class a
{
  public static final Map b;
  public k.b.d.b.a a = new k.b.d.b.a();
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put(f.m, "ECDSA");
    b.put(e.b, "RSA");
    b.put(f.r, "DSA");
  }
  
  public final KeyFactory a(k.b.a.l2.a parama)
  {
    o localo = x;
    String str = (String)b.get(localo);
    parama = str;
    if (str == null) {
      parama = x;
    }
    try
    {
      if (a != null) {
        return KeyFactory.getInstance(parama);
      }
      throw null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      if (parama.equals("ECDSA"))
      {
        if (a != null) {
          return KeyFactory.getInstance("EC");
        }
        throw null;
      }
      throw localNoSuchAlgorithmException;
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */