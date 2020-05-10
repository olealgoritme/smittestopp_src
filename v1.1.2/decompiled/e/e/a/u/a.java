package e.e.a.u;

import java.io.Serializable;

public final class a
  implements Serializable
{
  public static final a A = new a("P-384", "secp384r1", "1.3.132.0.34");
  public static final a B = new a("P-521", "secp521r1", "1.3.132.0.35");
  public static final a C = new a("Ed25519", "Ed25519", null);
  public static final a D = new a("Ed448", "Ed448", null);
  public static final a E = new a("X25519", "X25519", null);
  public static final a F = new a("X448", "X448", null);
  public static final a y = new a("P-256", "secp256r1", "1.2.840.10045.3.1.7");
  public static final a z = new a("P-256K", "secp256k1", "1.3.132.0.10");
  public final String x;
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      x = paramString1;
      return;
    }
    throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
  }
  
  public static a a(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().isEmpty()))
    {
      if (paramString.equals(yx)) {
        return y;
      }
      if (paramString.equals(zx)) {
        return z;
      }
      if (paramString.equals(Ax)) {
        return A;
      }
      if (paramString.equals(Bx)) {
        return B;
      }
      if (paramString.equals(Cx)) {
        return C;
      }
      if (paramString.equals(Dx)) {
        return D;
      }
      if (paramString.equals(Ex)) {
        return E;
      }
      if (paramString.equals(Fx)) {
        return F;
      }
      return new a(paramString, null, null);
    }
    throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof a)) && (x.equals(paramObject.toString()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    return x;
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */