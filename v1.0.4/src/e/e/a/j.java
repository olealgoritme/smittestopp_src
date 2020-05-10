package e.e.a;

import java.net.URI;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
  extends b
{
  public static final Set<String> U;
  public final d L;
  public final e.e.a.u.d M;
  public final c N;
  public final e.e.a.v.c O;
  public final e.e.a.v.c P;
  public final e.e.a.v.c Q;
  public final int R;
  public final e.e.a.v.c S;
  public final e.e.a.v.c T;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("alg");
    localHashSet.add("enc");
    localHashSet.add("epk");
    localHashSet.add("zip");
    localHashSet.add("jku");
    localHashSet.add("jwk");
    localHashSet.add("x5u");
    localHashSet.add("x5t");
    localHashSet.add("x5t#S256");
    localHashSet.add("x5c");
    localHashSet.add("kid");
    localHashSet.add("typ");
    localHashSet.add("cty");
    localHashSet.add("crit");
    localHashSet.add("apu");
    localHashSet.add("apv");
    localHashSet.add("p2s");
    localHashSet.add("p2c");
    localHashSet.add("iv");
    localHashSet.add("authTag");
    U = Collections.unmodifiableSet(localHashSet);
  }
  
  public j(a parama, d paramd, h paramh, String paramString1, Set<String> paramSet, URI paramURI1, e.e.a.u.d paramd1, URI paramURI2, e.e.a.v.c paramc1, e.e.a.v.c paramc2, List<e.e.a.v.a> paramList, String paramString2, e.e.a.u.d paramd2, c paramc, e.e.a.v.c paramc3, e.e.a.v.c paramc4, e.e.a.v.c paramc5, int paramInt, e.e.a.v.c paramc6, e.e.a.v.c paramc7, Map<String, Object> paramMap, e.e.a.v.c paramc8)
  {
    super(parama, paramh, paramString1, paramSet, paramURI1, paramd1, paramURI2, paramc1, paramc2, paramList, paramString2, paramMap, paramc8);
    if (!x.equals(yx))
    {
      if (paramd != null)
      {
        if ((paramd2 != null) && (paramd2.e())) {
          throw new IllegalArgumentException("Ephemeral public key should not be a private key");
        }
        L = paramd;
        M = paramd2;
        N = paramc;
        O = paramc3;
        P = paramc4;
        Q = paramc5;
        R = paramInt;
        S = paramc6;
        T = paramc7;
        return;
      }
      throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
    }
    throw new IllegalArgumentException("The JWE algorithm cannot be \"none\"");
  }
  
  public static j a(e.e.a.v.c paramc)
  {
    i.a.b.d locald = e.c.a.a.b.l.c.b(paramc.e());
    Object localObject1 = e.a(locald);
    if ((localObject1 instanceof i))
    {
      Object localObject2 = e.c.a.a.b.l.c.d(locald, "enc");
      if (((String)localObject2).equals(zx))
      {
        localObject2 = d.z;
      }
      else if (((String)localObject2).equals(Ax))
      {
        localObject2 = d.A;
      }
      else if (((String)localObject2).equals(Bx))
      {
        localObject2 = d.B;
      }
      else if (((String)localObject2).equals(Ex))
      {
        localObject2 = d.E;
      }
      else if (((String)localObject2).equals(Fx))
      {
        localObject2 = d.F;
      }
      else if (((String)localObject2).equals(Gx))
      {
        localObject2 = d.G;
      }
      else if (((String)localObject2).equals(Cx))
      {
        localObject2 = d.C;
      }
      else
      {
        if (!((String)localObject2).equals(Dx)) {
          break label190;
        }
        localObject2 = d.D;
      }
      Object localObject3 = localObject2;
      break label200;
      label190:
      localObject3 = new d((String)localObject2);
      label200:
      i locali = (i)localObject1;
      if (!x.equals(yx))
      {
        if (localObject3 != null)
        {
          Iterator localIterator = locald.keySet().iterator();
          h localh = null;
          localObject1 = localh;
          Object localObject4 = localObject1;
          Object localObject5 = localObject4;
          Object localObject6 = localObject5;
          Object localObject7 = localObject6;
          Object localObject8 = localObject7;
          Object localObject9 = localObject8;
          Object localObject10 = localObject9;
          Object localObject11 = localObject10;
          Object localObject12 = localObject11;
          Object localObject13 = localObject12;
          Object localObject14 = localObject13;
          Object localObject15 = localObject14;
          Object localObject16 = localObject15;
          Object localObject17 = localObject16;
          Object localObject18 = localObject17;
          localObject2 = localObject18;
          int i = 0;
          Object localObject19 = localObject1;
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!"alg".equals(str)) && (!"enc".equals(str))) {
              if ("typ".equals(str))
              {
                localObject1 = e.c.a.a.b.l.c.d(locald, str);
                if (localObject1 != null) {
                  localh = new h((String)localObject1);
                }
              }
              else if ("cty".equals(str))
              {
                localObject19 = e.c.a.a.b.l.c.d(locald, str);
              }
              else if ("crit".equals(str))
              {
                localObject1 = e.c.a.a.b.l.c.e(locald, str);
                if (localObject1 != null) {
                  localObject4 = new HashSet((Collection)localObject1);
                }
              }
              else if ("jku".equals(str))
              {
                localObject5 = e.c.a.a.b.l.c.f(locald, str);
              }
              else if ("jwk".equals(str))
              {
                localObject1 = e.c.a.a.b.l.c.b(locald, str);
                if (localObject1 != null) {
                  localObject6 = e.e.a.u.d.a((i.a.b.d)localObject1);
                }
              }
              else if ("x5u".equals(str))
              {
                localObject7 = e.c.a.a.b.l.c.f(locald, str);
              }
              else if ("x5t".equals(str))
              {
                localObject8 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("x5t#S256".equals(str))
              {
                localObject9 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("x5c".equals(str))
              {
                localObject10 = e.c.a.a.b.l.c.a(e.c.a.a.b.l.c.a(locald, str));
              }
              else if ("kid".equals(str))
              {
                localObject11 = e.c.a.a.b.l.c.d(locald, str);
              }
              else if ("epk".equals(str))
              {
                localObject12 = e.e.a.u.d.a(e.c.a.a.b.l.c.b(locald, str));
              }
              else if ("zip".equals(str))
              {
                localObject1 = e.c.a.a.b.l.c.d(locald, str);
                if (localObject1 != null) {
                  localObject13 = new c((String)localObject1);
                }
              }
              else if ("apu".equals(str))
              {
                localObject14 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("apv".equals(str))
              {
                localObject15 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("p2s".equals(str))
              {
                localObject16 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("p2c".equals(str))
              {
                localObject1 = (Number)e.c.a.a.b.l.c.a(locald, str, Number.class);
                if (localObject1 != null)
                {
                  i = ((Number)localObject1).intValue();
                  if (i < 0) {
                    throw new IllegalArgumentException("The PBES2 count parameter must not be negative");
                  }
                }
                else
                {
                  throw new ParseException(e.a.a.a.a.a("JSON object member with key \"", str, "\" is missing or null"), 0);
                }
              }
              else if ("iv".equals(str))
              {
                localObject17 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else if ("tag".equals(str))
              {
                localObject18 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, str));
              }
              else
              {
                Object localObject20 = locald.get(str);
                if (!U.contains(str))
                {
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = new HashMap();
                  }
                  ((Map)localObject1).put(str, localObject20);
                  localObject2 = localObject1;
                }
                else
                {
                  throw new IllegalArgumentException(e.a.a.a.a.a("The parameter name \"", str, "\" matches a registered name"));
                }
              }
            }
          }
          return new j(locali, (d)localObject3, localh, (String)localObject19, (Set)localObject4, (URI)localObject5, (e.e.a.u.d)localObject6, (URI)localObject7, (e.e.a.v.c)localObject8, (e.e.a.v.c)localObject9, (List)localObject10, (String)localObject11, (e.e.a.u.d)localObject12, (c)localObject13, (e.e.a.v.c)localObject14, (e.e.a.v.c)localObject15, (e.e.a.v.c)localObject16, i, (e.e.a.v.c)localObject17, (e.e.a.v.c)localObject18, (Map)localObject2, paramc);
        }
        throw new IllegalArgumentException("The encryption method \"enc\" parameter must not be null");
      }
      throw new IllegalArgumentException("The JWE algorithm \"alg\" cannot be \"none\"");
    }
    throw new ParseException("The algorithm \"alg\" header parameter must be for encryption", 0);
  }
  
  public i.a.b.d b()
  {
    i.a.b.d locald = super.b();
    Object localObject = L;
    if (localObject != null) {
      locald.put("enc", x);
    }
    localObject = M;
    if (localObject != null) {
      locald.put("epk", ((e.e.a.u.d)localObject).f());
    }
    localObject = N;
    if (localObject != null) {
      locald.put("zip", x);
    }
    localObject = O;
    if (localObject != null) {
      locald.put("apu", x);
    }
    localObject = P;
    if (localObject != null) {
      locald.put("apv", x);
    }
    localObject = Q;
    if (localObject != null) {
      locald.put("p2s", x);
    }
    int i = R;
    if (i > 0) {
      locald.put("p2c", Integer.valueOf(i));
    }
    localObject = S;
    if (localObject != null) {
      locald.put("iv", x);
    }
    localObject = T;
    if (localObject != null) {
      locald.put("tag", x);
    }
    return locald;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */