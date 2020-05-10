package e.e.a;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class e
  implements Serializable
{
  public static final Map<String, Object> D = Collections.unmodifiableMap(new HashMap());
  public final Set<String> A;
  public final Map<String, Object> B;
  public final e.e.a.v.c C;
  public final a x;
  public final h y;
  public final String z;
  
  public e(a parama, h paramh, String paramString, Set<String> paramSet, Map<String, Object> paramMap, e.e.a.v.c paramc)
  {
    if (parama != null)
    {
      x = parama;
      y = paramh;
      z = paramString;
      if (paramSet != null) {
        A = Collections.unmodifiableSet(new HashSet(paramSet));
      } else {
        A = null;
      }
      if (paramMap != null) {
        B = Collections.unmodifiableMap(new HashMap(paramMap));
      } else {
        B = D;
      }
      C = paramc;
      return;
    }
    throw new IllegalArgumentException("The algorithm \"alg\" header parameter must not be null");
  }
  
  public static a a(j.a.b.d paramd)
  {
    String str = e.c.a.a.b.l.c.d(paramd, "alg");
    if (str != null)
    {
      if (str.equals(yx)) {
        return a.y;
      }
      if (paramd.containsKey("enc"))
      {
        if (str.equals(zx)) {
          paramd = i.z;
        } else if (str.equals(Ax)) {
          paramd = i.A;
        } else if (str.equals(Bx)) {
          paramd = i.B;
        } else if (str.equals(Cx)) {
          paramd = i.C;
        } else if (str.equals(Dx)) {
          paramd = i.D;
        } else if (str.equals(Ex)) {
          paramd = i.E;
        } else if (str.equals(Fx)) {
          paramd = i.F;
        } else if (str.equals(Gx)) {
          paramd = i.G;
        } else if (str.equals(Hx)) {
          paramd = i.H;
        } else if (str.equals(Ix)) {
          paramd = i.I;
        } else if (str.equals(Jx)) {
          paramd = i.J;
        } else if (str.equals(Kx)) {
          paramd = i.K;
        } else if (str.equals(Lx)) {
          paramd = i.L;
        } else if (str.equals(Mx)) {
          paramd = i.M;
        } else if (str.equals(Nx)) {
          paramd = i.N;
        } else if (str.equals(Ox)) {
          paramd = i.O;
        } else if (str.equals(Px)) {
          paramd = i.P;
        } else {
          paramd = new i(str);
        }
        return paramd;
      }
      if (str.equals(zx)) {
        paramd = l.z;
      } else if (str.equals(Ax)) {
        paramd = l.A;
      } else if (str.equals(Bx)) {
        paramd = l.B;
      } else if (str.equals(Cx)) {
        paramd = l.C;
      } else if (str.equals(Dx)) {
        paramd = l.D;
      } else if (str.equals(Ex)) {
        paramd = l.E;
      } else if (str.equals(Fx)) {
        paramd = l.F;
      } else if (str.equals(Gx)) {
        paramd = l.G;
      } else if (str.equals(Hx)) {
        paramd = l.H;
      } else if (str.equals(Ix)) {
        paramd = l.I;
      } else if (str.equals(Jx)) {
        paramd = l.J;
      } else if (str.equals(Kx)) {
        paramd = l.K;
      } else if (str.equals(Lx)) {
        paramd = l.L;
      } else if (str.equals(Mx)) {
        paramd = l.M;
      } else {
        paramd = new l(str);
      }
      return paramd;
    }
    throw new ParseException("Missing \"alg\" in header JSON object", 0);
  }
  
  public e.e.a.v.c a()
  {
    e.e.a.v.c localc1 = C;
    e.e.a.v.c localc2 = localc1;
    if (localc1 == null) {
      localc2 = e.e.a.v.c.a(toString().getBytes(e.e.a.v.d.a));
    }
    return localc2;
  }
  
  public j.a.b.d c()
  {
    j.a.b.d locald = new j.a.b.d(B);
    locald.put("alg", x.x);
    Object localObject = y;
    if (localObject != null) {
      locald.put("typ", x);
    }
    localObject = z;
    if (localObject != null) {
      locald.put("cty", localObject);
    }
    localObject = A;
    if ((localObject != null) && (!((Set)localObject).isEmpty())) {
      locald.put("crit", new ArrayList(A));
    }
    return locald;
  }
  
  public String toString()
  {
    return c().toString();
  }
}

/* Location:
 * Qualified Name:     e.e.a.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */