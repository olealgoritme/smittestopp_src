package e.e.a.u;

import java.io.Serializable;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class d
  implements j.a.b.b, Serializable
{
  public final e.e.a.a A;
  public final String B;
  public final URI C;
  @Deprecated
  public final e.e.a.v.c D;
  public e.e.a.v.c E;
  public final List<e.e.a.v.a> F;
  public final List<X509Certificate> G;
  public final KeyStore H;
  public final f x;
  public final g y;
  public final Set<e> z;
  
  public d(f paramf, g paramg, Set<e> paramSet, e.e.a.a parama, String paramString, URI paramURI, e.e.a.v.c paramc1, e.e.a.v.c paramc2, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    if (paramf != null)
    {
      x = paramf;
      if (h.a(paramg, paramSet))
      {
        y = paramg;
        z = paramSet;
        A = parama;
        B = paramString;
        C = paramURI;
        D = paramc1;
        E = paramc2;
        if ((paramList != null) && (paramList.isEmpty())) {
          throw new IllegalArgumentException("The X.509 certificate chain \"x5c\" must not be empty");
        }
        F = paramList;
        try
        {
          G = e.c.a.a.b.l.c.a(paramList);
          H = paramKeyStore;
          return;
        }
        catch (ParseException paramf)
        {
          paramg = e.a.a.a.a.a("Invalid X.509 certificate chain \"x5c\": ");
          paramg.append(paramf.getMessage());
          throw new IllegalArgumentException(paramg.toString(), paramf);
        }
      }
      throw new IllegalArgumentException("The key use \"use\" and key options \"key_opts\" parameters are not consistent, see RFC 7517, section 4.3");
    }
    throw new IllegalArgumentException("The key type \"kty\" parameter must not be null");
  }
  
  public static d a(j.a.b.d paramd)
  {
    Object localObject1 = f.a(e.c.a.a.b.l.c.d(paramd, "kty"));
    if (localObject1 == f.y) {
      return b.a(paramd);
    }
    if (localObject1 == f.z)
    {
      e.e.a.v.c localc1 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "n"));
      e.e.a.v.c localc2 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "e"));
      if (f.a(e.c.a.a.b.l.c.d(paramd, "kty")) == f.z)
      {
        boolean bool = paramd.containsKey("d");
        Object localObject2 = null;
        if (bool) {
          localObject1 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "d"));
        } else {
          localObject1 = null;
        }
        e.e.a.v.c localc3;
        if (paramd.containsKey("p")) {
          localc3 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "p"));
        } else {
          localc3 = null;
        }
        e.e.a.v.c localc4;
        if (paramd.containsKey("q")) {
          localc4 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "q"));
        } else {
          localc4 = null;
        }
        e.e.a.v.c localc5;
        if (paramd.containsKey("dp")) {
          localc5 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "dp"));
        } else {
          localc5 = null;
        }
        String str = "dq";
        e.e.a.v.c localc6;
        if (paramd.containsKey("dq")) {
          localc6 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "dq"));
        } else {
          localc6 = null;
        }
        e.e.a.v.c localc7;
        if (paramd.containsKey("qi")) {
          localc7 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "qi"));
        } else {
          localc7 = null;
        }
        if (paramd.containsKey("oth"))
        {
          localObject2 = e.c.a.a.b.l.c.a(paramd, "oth");
          ArrayList localArrayList = new ArrayList(((ArrayList)localObject2).size());
          Iterator localIterator = ((ArrayList)localObject2).iterator();
          for (;;)
          {
            localObject2 = localArrayList;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = localIterator.next();
            if ((localObject2 instanceof j.a.b.d))
            {
              localObject2 = (j.a.b.d)localObject2;
              localArrayList.add(new k.a(new e.e.a.v.c(e.c.a.a.b.l.c.d((j.a.b.d)localObject2, "r")), new e.e.a.v.c(e.c.a.a.b.l.c.d((j.a.b.d)localObject2, str)), new e.e.a.v.c(e.c.a.a.b.l.c.d((j.a.b.d)localObject2, "t"))));
            }
          }
        }
        try
        {
          paramd = new k(localc1, localc2, (e.e.a.v.c)localObject1, localc3, localc4, localc5, localc6, localc7, (List)localObject2, null, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
          return paramd;
        }
        catch (IllegalArgumentException paramd)
        {
          throw new ParseException(paramd.getMessage(), 0);
        }
      }
      throw new ParseException("The key type \"kty\" must be RSA", 0);
    }
    if (localObject1 == f.A)
    {
      localObject1 = new e.e.a.v.c(e.c.a.a.b.l.c.d(paramd, "k"));
      if (e.c.a.a.b.l.c.d(paramd) == f.A) {
        return new j((e.e.a.v.c)localObject1, e.c.a.a.b.l.c.e(paramd), e.c.a.a.b.l.c.c(paramd), e.c.a.a.b.l.c.a(paramd), e.c.a.a.b.l.c.b(paramd), e.c.a.a.b.l.c.i(paramd), e.c.a.a.b.l.c.h(paramd), e.c.a.a.b.l.c.g(paramd), e.c.a.a.b.l.c.f(paramd), null);
      }
      throw new ParseException("The key type \"kty\" must be oct", 0);
    }
    if (localObject1 == f.B) {
      return i.a(paramd);
    }
    paramd = new StringBuilder();
    paramd.append("Unsupported key type \"kty\" parameter: ");
    paramd.append(localObject1);
    throw new ParseException(paramd.toString(), 0);
  }
  
  public String a()
  {
    return f().toString();
  }
  
  public List<X509Certificate> c()
  {
    List localList = G;
    if (localList == null) {
      return null;
    }
    return Collections.unmodifiableList(localList);
  }
  
  public abstract LinkedHashMap<String, ?> d();
  
  public abstract boolean e();
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    if ((!Objects.equals(x, x)) || (!Objects.equals(y, y)) || (!Objects.equals(z, z)) || (!Objects.equals(A, A)) || (!Objects.equals(B, B)) || (!Objects.equals(C, C)) || (!Objects.equals(D, D)) || (!Objects.equals(E, E)) || (!Objects.equals(F, F)) || (!Objects.equals(G, G)) || (!Objects.equals(H, H))) {
      bool = false;
    }
    return bool;
  }
  
  public j.a.b.d f()
  {
    j.a.b.d locald = new j.a.b.d();
    locald.put("kty", x.x);
    Object localObject1 = y;
    if (localObject1 != null) {
      locald.put("use", x);
    }
    Object localObject2;
    if (z != null)
    {
      localObject2 = new ArrayList(z.size());
      localObject1 = z.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject2).add(((e)((Iterator)localObject1).next()).identifier());
      }
      locald.put("key_ops", localObject2);
    }
    localObject1 = A;
    if (localObject1 != null) {
      locald.put("alg", x);
    }
    localObject1 = B;
    if (localObject1 != null) {
      locald.put("kid", localObject1);
    }
    localObject1 = C;
    if (localObject1 != null) {
      locald.put("x5u", ((URI)localObject1).toString());
    }
    localObject1 = D;
    if (localObject1 != null) {
      locald.put("x5t", x);
    }
    localObject1 = E;
    if (localObject1 != null) {
      locald.put("x5t#S256", x);
    }
    if (F != null)
    {
      localObject1 = new j.a.b.a();
      localObject2 = F.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(nextx);
      }
      locald.put("x5c", localObject1);
    }
    return locald;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { x, y, z, A, B, C, D, E, F, G, H });
  }
  
  public String toString()
  {
    return f().toString();
  }
}

/* Location:
 * Qualified Name:     e.e.a.u.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */