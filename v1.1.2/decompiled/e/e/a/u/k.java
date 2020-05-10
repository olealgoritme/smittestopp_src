package e.e.a.u;

import e.e.a.v.c;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class k
  extends d
{
  public final c I;
  public final c J;
  public final c K;
  public final c L;
  public final c M;
  public final c N;
  public final c O;
  public final c P;
  public final List<a> Q;
  public final PrivateKey R;
  
  public k(c paramc1, c paramc2, c paramc3, c paramc4, c paramc5, c paramc6, c paramc7, c paramc8, List<a> paramList, PrivateKey paramPrivateKey, g paramg, Set<e> paramSet, e.e.a.a parama, String paramString, URI paramURI, c paramc9, c paramc10, List<e.e.a.v.a> paramList1, KeyStore paramKeyStore)
  {
    super(f.z, paramg, paramSet, parama, paramString, paramURI, paramc9, paramc10, paramList1, paramKeyStore);
    int i;
    if (paramc1 != null)
    {
      I = paramc1;
      if (paramc2 != null)
      {
        J = paramc2;
        if (c() != null)
        {
          paramc1 = c();
          i = 0;
          paramc1 = (X509Certificate)paramc1.get(0);
        }
      }
    }
    try
    {
      paramc1 = (RSAPublicKey)((X509Certificate)c().get(0)).getPublicKey();
      if ((J.d().equals(paramc1.getPublicExponent())) && (I.d().equals(paramc1.getModulus()))) {
        i = 1;
      }
    }
    catch (ClassCastException paramc1)
    {
      for (;;) {}
    }
    if (i == 0) {
      throw new IllegalArgumentException("The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters");
    }
    K = paramc3;
    if ((paramc4 != null) && (paramc5 != null))
    {
      paramc1 = paramc6;
      paramc3 = paramc7;
      if (paramc1 != null)
      {
        paramc2 = paramc8;
        if ((paramc3 != null) && (paramc2 != null))
        {
          L = paramc4;
          M = paramc5;
          N = paramc1;
          O = paramc3;
          P = paramc2;
          if (paramList != null) {
            Q = Collections.unmodifiableList(paramList);
          } else {
            Q = Collections.emptyList();
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((paramc4 == null) && (paramc5 == null) && (paramc6 == null) && (paramc7 == null) && (paramc8 == null) && (paramList == null))
      {
        L = null;
        M = null;
        N = null;
        O = null;
        P = null;
        Q = Collections.emptyList();
      }
      else
      {
        if ((paramc4 != null) || (paramc5 != null) || (paramc6 != null) || (paramc7 != null) || (paramc8 != null)) {
          break label379;
        }
        L = null;
        M = null;
        N = null;
        O = null;
        P = null;
        Q = Collections.emptyList();
      }
    }
    R = paramPrivateKey;
    return;
    label379:
    if (paramc4 != null)
    {
      if (paramc5 != null)
      {
        if (paramc6 != null)
        {
          if (paramc7 == null) {
            throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second factor CRT exponent must not be null");
          }
          throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first CRT coefficient must not be null");
        }
        throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first factor CRT exponent must not be null");
      }
      throw new IllegalArgumentException("Incomplete second private (CRT) representation: The second prime factor must not be null");
    }
    throw new IllegalArgumentException("Incomplete second private (CRT) representation: The first prime factor must not be null");
    throw new IllegalArgumentException("The public exponent value must not be null");
    throw new IllegalArgumentException("The modulus value must not be null");
  }
  
  public LinkedHashMap<String, ?> d()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("e", J.x);
    localLinkedHashMap.put("kty", x.x);
    localLinkedHashMap.put("n", I.x);
    return localLinkedHashMap;
  }
  
  public boolean e()
  {
    boolean bool;
    if ((K == null) && (L == null) && (R == null)) {
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
    if (!(paramObject instanceof k)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (k)paramObject;
    if ((!Objects.equals(I, I)) || (!Objects.equals(J, J)) || (!Objects.equals(K, K)) || (!Objects.equals(L, L)) || (!Objects.equals(M, M)) || (!Objects.equals(N, N)) || (!Objects.equals(O, O)) || (!Objects.equals(P, P)) || (!Objects.equals(Q, Q)) || (!Objects.equals(R, R))) {
      bool = false;
    }
    return bool;
  }
  
  public j.a.b.d f()
  {
    j.a.b.d locald = super.f();
    locald.put("n", I.x);
    locald.put("e", J.x);
    Object localObject = K;
    if (localObject != null) {
      locald.put("d", x);
    }
    localObject = L;
    if (localObject != null) {
      locald.put("p", x);
    }
    localObject = M;
    if (localObject != null) {
      locald.put("q", x);
    }
    localObject = N;
    if (localObject != null) {
      locald.put("dp", x);
    }
    localObject = O;
    if (localObject != null) {
      locald.put("dq", x);
    }
    localObject = P;
    if (localObject != null) {
      locald.put("qi", x);
    }
    localObject = Q;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      j.a.b.a locala = new j.a.b.a();
      Iterator localIterator = Q.iterator();
      while (localIterator.hasNext())
      {
        a locala1 = (a)localIterator.next();
        localObject = new j.a.b.d();
        ((HashMap)localObject).put("r", x.x);
        ((HashMap)localObject).put("d", y.x);
        ((HashMap)localObject).put("t", z.x);
        locala.add(localObject);
      }
      locald.put("oth", locala);
    }
    return locald;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), I, J, K, L, M, N, O, P, Q, R });
  }
  
  public static class a
    implements Serializable
  {
    public final c x;
    public final c y;
    public final c z;
    
    public a(c paramc1, c paramc2, c paramc3)
    {
      if (paramc1 != null)
      {
        x = paramc1;
        if (paramc2 != null)
        {
          y = paramc2;
          if (paramc3 != null)
          {
            z = paramc3;
            return;
          }
          throw new IllegalArgumentException("The factor CRT coefficient must not be null");
        }
        throw new IllegalArgumentException("The factor CRT exponent must not be null");
      }
      throw new IllegalArgumentException("The prime factor must not be null");
    }
    
    public a(RSAOtherPrimeInfo paramRSAOtherPrimeInfo)
    {
      x = c.a(paramRSAOtherPrimeInfo.getPrime());
      y = c.a(paramRSAOtherPrimeInfo.getExponent());
      z = c.a(paramRSAOtherPrimeInfo.getCrtCoefficient());
    }
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */