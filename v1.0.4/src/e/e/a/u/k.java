package e.e.a.u;

import e.e.a.v.c;
import java.math.BigInteger;
import java.net.URI;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
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
  public final List<k.a> Q;
  public final PrivateKey R;
  
  public k(c paramc1, c paramc2, c paramc3, c paramc4, c paramc5, c paramc6, c paramc7, c paramc8, List<k.a> paramList, PrivateKey paramPrivateKey, g paramg, Set<e> paramSet, e.e.a.a parama, String paramString, URI paramURI, c paramc9, c paramc10, List<e.e.a.v.a> paramList1, KeyStore paramKeyStore)
  {
    super(f.z, paramg, paramSet, parama, paramString, paramURI, paramc9, paramc10, paramList1, paramKeyStore);
    int i;
    if (paramc1 != null)
    {
      I = paramc1;
      if (paramc2 != null)
      {
        J = paramc2;
        if (b() != null)
        {
          paramc1 = b();
          i = 0;
          paramc1 = (X509Certificate)paramc1.get(0);
        }
      }
    }
    try
    {
      paramc1 = (RSAPublicKey)((X509Certificate)b().get(0)).getPublicKey();
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
      paramc3 = paramc6;
      paramc2 = paramc7;
      if (paramc3 != null)
      {
        paramc1 = paramc8;
        if ((paramc2 != null) && (paramc1 != null))
        {
          L = paramc4;
          M = paramc5;
          N = paramc3;
          O = paramc2;
          P = paramc1;
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
  
  public i.a.b.d f()
  {
    i.a.b.d locald1 = super.f();
    locald1.put("n", I.x);
    locald1.put("e", J.x);
    Object localObject = K;
    if (localObject != null) {
      locald1.put("d", x);
    }
    localObject = L;
    if (localObject != null) {
      locald1.put("p", x);
    }
    localObject = M;
    if (localObject != null) {
      locald1.put("q", x);
    }
    localObject = N;
    if (localObject != null) {
      locald1.put("dp", x);
    }
    localObject = O;
    if (localObject != null) {
      locald1.put("dq", x);
    }
    localObject = P;
    if (localObject != null) {
      locald1.put("qi", x);
    }
    localObject = Q;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new i.a.b.a();
      Iterator localIterator = Q.iterator();
      while (localIterator.hasNext())
      {
        k.a locala = (k.a)localIterator.next();
        i.a.b.d locald2 = new i.a.b.d();
        locald2.put("r", x.x);
        locald2.put("d", y.x);
        locald2.put("t", z.x);
        ((ArrayList)localObject).add(locald2);
      }
      locald1.put("oth", localObject);
    }
    return locald1;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), I, J, K, L, M, N, O, P, Q, R });
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.u.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */