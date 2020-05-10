package e.e.a;

import e.e.a.v.c;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class b
  extends e
{
  public final URI E;
  public final e.e.a.u.d F;
  public final URI G;
  public final c H;
  public final c I;
  public final List<e.e.a.v.a> J;
  public final String K;
  
  public b(a parama, h paramh, String paramString1, Set<String> paramSet, URI paramURI1, e.e.a.u.d paramd, URI paramURI2, c paramc1, c paramc2, List<e.e.a.v.a> paramList, String paramString2, Map<String, Object> paramMap, c paramc3)
  {
    super(parama, paramh, paramString1, paramSet, paramMap, paramc3);
    E = paramURI1;
    F = paramd;
    G = paramURI2;
    H = paramc1;
    I = paramc2;
    if (paramList != null) {
      J = Collections.unmodifiableList(new ArrayList(paramList));
    } else {
      J = null;
    }
    K = paramString2;
  }
  
  public i.a.b.d b()
  {
    i.a.b.d locald = super.b();
    Object localObject = E;
    if (localObject != null) {
      locald.put("jku", ((URI)localObject).toString());
    }
    localObject = F;
    if (localObject != null) {
      locald.put("jwk", ((e.e.a.u.d)localObject).f());
    }
    localObject = G;
    if (localObject != null) {
      locald.put("x5u", ((URI)localObject).toString());
    }
    localObject = H;
    if (localObject != null) {
      locald.put("x5t", x);
    }
    localObject = I;
    if (localObject != null) {
      locald.put("x5t#S256", x);
    }
    localObject = J;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      locald.put("x5c", J);
    }
    localObject = K;
    if (localObject != null) {
      locald.put("kid", localObject);
    }
    return locald;
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */