package e.e.a.u;

import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class b
  extends d
{
  public static final Set<a> N = Collections.unmodifiableSet(new HashSet(Arrays.asList(new a[] { a.y, a.z, a.A, a.B })));
  public final a I;
  public final e.e.a.v.c J;
  public final e.e.a.v.c K;
  public final e.e.a.v.c L;
  public final PrivateKey M;
  
  public b(a parama, e.e.a.v.c paramc1, e.e.a.v.c paramc2, g paramg, Set<e> paramSet, e.e.a.a parama1, String paramString, URI paramURI, e.e.a.v.c paramc3, e.e.a.v.c paramc4, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    super(f.y, paramg, paramSet, parama1, paramString, paramURI, paramc3, paramc4, paramList, paramKeyStore);
    if (parama != null)
    {
      I = parama;
      if (paramc1 != null)
      {
        J = paramc1;
        if (paramc2 != null)
        {
          K = paramc2;
          a(parama, paramc1, paramc2);
          a(b());
          L = null;
          M = null;
          return;
        }
        throw new IllegalArgumentException("The 'y' coordinate must not be null");
      }
      throw new IllegalArgumentException("The 'x' coordinate must not be null");
    }
    throw new IllegalArgumentException("The curve must not be null");
  }
  
  public b(a parama, e.e.a.v.c paramc1, e.e.a.v.c paramc2, e.e.a.v.c paramc3, g paramg, Set<e> paramSet, e.e.a.a parama1, String paramString, URI paramURI, e.e.a.v.c paramc4, e.e.a.v.c paramc5, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    super(f.y, paramg, paramSet, parama1, paramString, paramURI, paramc4, paramc5, paramList, paramKeyStore);
    if (parama != null)
    {
      I = parama;
      if (paramc1 != null)
      {
        J = paramc1;
        if (paramc2 != null)
        {
          K = paramc2;
          a(parama, paramc1, paramc2);
          a(b());
          if (paramc3 != null)
          {
            L = paramc3;
            M = null;
            return;
          }
          throw new IllegalArgumentException("The 'd' coordinate must not be null");
        }
        throw new IllegalArgumentException("The 'y' coordinate must not be null");
      }
      throw new IllegalArgumentException("The 'x' coordinate must not be null");
    }
    throw new IllegalArgumentException("The curve must not be null");
  }
  
  public static b a(i.a.b.d paramd)
  {
    a locala = a.a(e.c.a.a.b.l.c.d(paramd, "crv"));
    e.e.a.v.c localc1 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "x"));
    e.e.a.v.c localc2 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "y"));
    if (e.c.a.a.b.l.c.d(paramd) == f.y)
    {
      e.e.a.v.c localc3 = null;
      if (paramd.get("d") != null) {
        localc3 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "d"));
      }
      if (localc3 == null) {}
      try
      {
        return new b(locala, localc1, localc2, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
      }
      catch (IllegalArgumentException paramd)
      {
        throw new ParseException(paramd.getMessage(), 0);
      }
      paramd = new b(locala, localc1, localc2, localc3, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
      return paramd;
    }
    throw new ParseException("The key type \"kty\" must be EC", 0);
  }
  
  public static void a(a parama, e.e.a.v.c paramc1, e.e.a.v.c paramc2)
  {
    if (N.contains(parama))
    {
      paramc1 = paramc1.d();
      BigInteger localBigInteger1 = paramc2.d();
      if (parama != null)
      {
        Object localObject = c.a(parama).getCurve();
        BigInteger localBigInteger2 = ((EllipticCurve)localObject).getA();
        paramc2 = ((EllipticCurve)localObject).getB();
        localObject = ((ECFieldFp)((EllipticCurve)localObject).getField()).getP();
        if (localBigInteger1.pow(2).mod((BigInteger)localObject).equals(paramc1.pow(3).add(localBigInteger2.multiply(paramc1)).add(paramc2).mod((BigInteger)localObject))) {
          return;
        }
        paramc1 = new StringBuilder();
        paramc1.append("Invalid EC JWK: The 'x' and 'y' public coordinates are not on the ");
        paramc1.append(parama);
        paramc1.append(" curve");
        throw new IllegalArgumentException(paramc1.toString());
      }
      throw null;
    }
    paramc1 = new StringBuilder();
    paramc1.append("Unknown / unsupported curve: ");
    paramc1.append(parama);
    throw new IllegalArgumentException(paramc1.toString());
  }
  
  public final void a(List<X509Certificate> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    paramList = (X509Certificate)paramList.get(0);
    try
    {
      paramList = (ECPublicKey)((X509Certificate)b().get(0)).getPublicKey();
      if ((J.d().equals(paramList.getW().getAffineX())) && (K.d().equals(paramList.getW().getAffineY()))) {
        i = 1;
      }
    }
    catch (ClassCastException paramList)
    {
      for (;;) {}
    }
    if (i != 0) {
      return;
    }
    throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
  }
  
  public LinkedHashMap<String, ?> d()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("crv", I.x);
    localLinkedHashMap.put("kty", x.x);
    localLinkedHashMap.put("x", J.x);
    localLinkedHashMap.put("y", K.x);
    return localLinkedHashMap;
  }
  
  public boolean e()
  {
    boolean bool;
    if ((L == null) && (M == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (b)paramObject;
    if ((!Objects.equals(I, I)) || (!Objects.equals(J, J)) || (!Objects.equals(K, K)) || (!Objects.equals(L, L)) || (!Objects.equals(M, M))) {
      bool = false;
    }
    return bool;
  }
  
  public i.a.b.d f()
  {
    i.a.b.d locald = super.f();
    locald.put("crv", I.x);
    locald.put("x", J.x);
    locald.put("y", K.x);
    e.e.a.v.c localc = L;
    if (localc != null) {
      locald.put("d", x);
    }
    return locald;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), I, J, K, L, M });
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.u.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */