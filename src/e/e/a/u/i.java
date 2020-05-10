package e.e.a.u;

import java.net.URI;
import java.security.KeyStore;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class i
  extends d
{
  public static final Set<a> N = Collections.unmodifiableSet(new HashSet(Arrays.asList(new a[] { a.C, a.D, a.E, a.F })));
  public final a I;
  public final e.e.a.v.c J;
  public final byte[] K;
  public final e.e.a.v.c L;
  public final byte[] M;
  
  public i(a parama, e.e.a.v.c paramc1, g paramg, Set<e> paramSet, e.e.a.a parama1, String paramString, URI paramURI, e.e.a.v.c paramc2, e.e.a.v.c paramc3, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    super(f.B, paramg, paramSet, parama1, paramString, paramURI, paramc2, paramc3, paramList, paramKeyStore);
    if (parama != null)
    {
      if (N.contains(parama))
      {
        I = parama;
        if (paramc1 != null)
        {
          J = paramc1;
          K = paramc1.b();
          L = null;
          M = null;
          return;
        }
        throw new IllegalArgumentException("The 'x' parameter must not be null");
      }
      paramc1 = new StringBuilder();
      paramc1.append("Unknown / unsupported curve: ");
      paramc1.append(parama);
      throw new IllegalArgumentException(paramc1.toString());
    }
    throw new IllegalArgumentException("The curve must not be null");
  }
  
  public i(a parama, e.e.a.v.c paramc1, e.e.a.v.c paramc2, g paramg, Set<e> paramSet, e.e.a.a parama1, String paramString, URI paramURI, e.e.a.v.c paramc3, e.e.a.v.c paramc4, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    super(f.B, paramg, paramSet, parama1, paramString, paramURI, paramc3, paramc4, paramList, paramKeyStore);
    if (parama != null)
    {
      if (N.contains(parama))
      {
        I = parama;
        if (paramc1 != null)
        {
          J = paramc1;
          K = paramc1.b();
          if (paramc2 != null)
          {
            L = paramc2;
            M = paramc2.b();
            return;
          }
          throw new IllegalArgumentException("The 'd' parameter must not be null");
        }
        throw new IllegalArgumentException("The 'x' parameter must not be null");
      }
      paramc1 = new StringBuilder();
      paramc1.append("Unknown / unsupported curve: ");
      paramc1.append(parama);
      throw new IllegalArgumentException(paramc1.toString());
    }
    throw new IllegalArgumentException("The curve must not be null");
  }
  
  public static i a(i.a.b.d paramd)
  {
    a locala = a.a(e.c.a.a.b.l.c.d(paramd, "crv"));
    e.e.a.v.c localc1 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "x"));
    if (e.c.a.a.b.l.c.d(paramd) == f.B)
    {
      e.e.a.v.c localc2 = null;
      if (paramd.get("d") != null) {
        localc2 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "d"));
      }
      if (localc2 == null) {}
      try
      {
        return new i(locala, localc1, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
      }
      catch (IllegalArgumentException paramd)
      {
        throw new ParseException(paramd.getMessage(), 0);
      }
      paramd = new i(locala, localc1, localc2, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
      return paramd;
    }
    throw new ParseException("The key type \"kty\" must be OKP", 0);
  }
  
  public LinkedHashMap<String, ?> d()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("crv", I.x);
    localLinkedHashMap.put("kty", x.x);
    localLinkedHashMap.put("x", J.x);
    return localLinkedHashMap;
  }
  
  public boolean e()
  {
    boolean bool;
    if (L != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof i)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (i)paramObject;
    if ((!Objects.equals(I, I)) || (!Objects.equals(J, J)) || (!Arrays.equals(K, K)) || (!Objects.equals(L, L)) || (!Arrays.equals(M, M))) {
      bool = false;
    }
    return bool;
  }
  
  public i.a.b.d f()
  {
    i.a.b.d locald = super.f();
    locald.put("crv", I.x);
    locald.put("x", J.x);
    e.e.a.v.c localc = L;
    if (localc != null) {
      locald.put("d", x);
    }
    return locald;
  }
  
  public int hashCode()
  {
    int i = Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), I, J, L });
    int j = Arrays.hashCode(K);
    return Arrays.hashCode(M) + (j + i * 31) * 31;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.u.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */