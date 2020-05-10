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

public final class m
  extends b
{
  public static final Set<String> L;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("alg");
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
    L = Collections.unmodifiableSet(localHashSet);
  }
  
  public m(l paraml, h paramh, String paramString1, Set<String> paramSet, URI paramURI1, e.e.a.u.d paramd, URI paramURI2, e.e.a.v.c paramc1, e.e.a.v.c paramc2, List<e.e.a.v.a> paramList, String paramString2, Map<String, Object> paramMap, e.e.a.v.c paramc3)
  {
    super(paraml, paramh, paramString1, paramSet, paramURI1, paramd, paramURI2, paramc1, paramc2, paramList, paramString2, paramMap, paramc3);
    if (!x.equals(yx)) {
      return;
    }
    throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
  }
  
  public static m a(e.e.a.v.c paramc)
  {
    i.a.b.d locald = e.c.a.a.b.l.c.b(paramc.e());
    Object localObject1 = e.a(locald);
    if ((localObject1 instanceof l))
    {
      l locall = (l)localObject1;
      if (!x.equals(yx))
      {
        Iterator localIterator = locald.keySet().iterator();
        Object localObject2 = null;
        Object localObject3 = localObject2;
        Object localObject4 = localObject3;
        Object localObject5 = localObject4;
        Object localObject6 = localObject5;
        Object localObject7 = localObject6;
        Object localObject8 = localObject7;
        Object localObject9 = localObject8;
        Object localObject10 = localObject9;
        Object localObject11 = localObject10;
        localObject1 = localObject11;
        while (localIterator.hasNext())
        {
          Object localObject12 = (String)localIterator.next();
          Object localObject13;
          Object localObject14;
          Object localObject15;
          Object localObject16;
          Object localObject17;
          Object localObject19;
          Object localObject20;
          Object localObject21;
          if ("alg".equals(localObject12))
          {
            localObject13 = localObject2;
            localObject14 = localObject3;
            localObject15 = localObject4;
            localObject16 = localObject5;
            localObject17 = localObject6;
            localObject12 = localObject7;
            localObject18 = localObject8;
            localObject19 = localObject9;
            localObject20 = localObject10;
            localObject21 = localObject11;
          }
          else
          {
            Object localObject22;
            if ("typ".equals(localObject12))
            {
              localObject22 = e.c.a.a.b.l.c.d(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
              if (localObject22 != null)
              {
                localObject13 = new h((String)localObject22);
                localObject14 = localObject3;
                localObject15 = localObject4;
                localObject16 = localObject5;
                localObject17 = localObject6;
                localObject12 = localObject7;
                localObject18 = localObject8;
                localObject19 = localObject9;
                localObject20 = localObject10;
                localObject21 = localObject11;
              }
            }
            else if ("cty".equals(localObject12))
            {
              localObject14 = e.c.a.a.b.l.c.d(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
            }
            else if ("crit".equals(localObject12))
            {
              localObject22 = e.c.a.a.b.l.c.e(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
              if (localObject22 != null)
              {
                localObject15 = new HashSet((Collection)localObject22);
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject16 = localObject5;
                localObject17 = localObject6;
                localObject12 = localObject7;
                localObject18 = localObject8;
                localObject19 = localObject9;
                localObject20 = localObject10;
                localObject21 = localObject11;
              }
            }
            else if ("jku".equals(localObject12))
            {
              localObject16 = e.c.a.a.b.l.c.f(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
            }
            else if ("jwk".equals(localObject12))
            {
              localObject22 = e.c.a.a.b.l.c.b(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
              if (localObject22 != null)
              {
                localObject17 = e.e.a.u.d.a((i.a.b.d)localObject22);
                localObject13 = localObject2;
                localObject14 = localObject3;
                localObject15 = localObject4;
                localObject16 = localObject5;
                localObject12 = localObject7;
                localObject18 = localObject8;
                localObject19 = localObject9;
                localObject20 = localObject10;
                localObject21 = localObject11;
              }
            }
            else if ("x5u".equals(localObject12))
            {
              localObject12 = e.c.a.a.b.l.c.f(locald, (String)localObject12);
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
            }
            else if ("x5t".equals(localObject12))
            {
              localObject18 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, (String)localObject12));
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject19 = localObject9;
              localObject20 = localObject10;
              localObject21 = localObject11;
            }
            else if ("x5t#S256".equals(localObject12))
            {
              localObject19 = e.e.a.v.c.a(e.c.a.a.b.l.c.d(locald, (String)localObject12));
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject20 = localObject10;
              localObject21 = localObject11;
            }
            else if ("x5c".equals(localObject12))
            {
              localObject20 = e.c.a.a.b.l.c.a(e.c.a.a.b.l.c.a(locald, (String)localObject12));
              localObject13 = localObject2;
              localObject14 = localObject3;
              localObject15 = localObject4;
              localObject16 = localObject5;
              localObject17 = localObject6;
              localObject12 = localObject7;
              localObject18 = localObject8;
              localObject19 = localObject9;
              localObject21 = localObject11;
            }
            else
            {
              if (!"kid".equals(localObject12)) {
                break label952;
              }
              localObject21 = e.c.a.a.b.l.c.d(locald, (String)localObject12);
              localObject20 = localObject10;
              localObject19 = localObject9;
              localObject18 = localObject8;
              localObject12 = localObject7;
              localObject17 = localObject6;
              localObject16 = localObject5;
              localObject15 = localObject4;
              localObject14 = localObject3;
              localObject13 = localObject2;
            }
          }
          localObject2 = localObject13;
          localObject3 = localObject14;
          localObject4 = localObject15;
          localObject5 = localObject16;
          localObject6 = localObject17;
          localObject7 = localObject12;
          localObject8 = localObject18;
          localObject9 = localObject19;
          localObject10 = localObject20;
          localObject11 = localObject21;
          break label1004;
          label952:
          Object localObject18 = locald.get(localObject12);
          if (!L.contains(localObject12))
          {
            localObject21 = localObject1;
            if (localObject1 == null) {
              localObject21 = new HashMap();
            }
            ((Map)localObject21).put(localObject12, localObject18);
            localObject1 = localObject21;
          }
          else
          {
            label1004:
            throw new IllegalArgumentException(e.a.a.a.a.a("The parameter name \"", (String)localObject12, "\" matches a registered name"));
          }
        }
        return new m(locall, (h)localObject2, (String)localObject3, (Set)localObject4, (URI)localObject5, (e.e.a.u.d)localObject6, (URI)localObject7, (e.e.a.v.c)localObject8, (e.e.a.v.c)localObject9, (List)localObject10, (String)localObject11, (Map)localObject1, paramc);
      }
      throw new IllegalArgumentException("The JWS algorithm \"alg\" cannot be \"none\"");
    }
    throw new ParseException("The algorithm \"alg\" header parameter must be for signatures", 0);
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */