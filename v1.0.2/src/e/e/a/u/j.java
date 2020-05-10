package e.e.a.u;

import e.e.a.v.c;
import java.net.URI;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class j
  extends d
{
  public final c I;
  
  public j(c paramc1, g paramg, Set<e> paramSet, e.e.a.a parama, String paramString, URI paramURI, c paramc2, c paramc3, List<e.e.a.v.a> paramList, KeyStore paramKeyStore)
  {
    super(f.A, paramg, paramSet, parama, paramString, paramURI, paramc2, paramc3, paramList, paramKeyStore);
    if (paramc1 != null)
    {
      I = paramc1;
      return;
    }
    throw new IllegalArgumentException("The key value must not be null");
  }
  
  public LinkedHashMap<String, ?> d()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("k", I.x);
    localLinkedHashMap.put("kty", x.x);
    return localLinkedHashMap;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof j)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (j)paramObject;
    return Objects.equals(I, I);
  }
  
  public i.a.b.d f()
  {
    i.a.b.d locald = super.f();
    locald.put("k", I.x);
    return locald;
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), I });
  }
}

/* Location:
 * Qualified Name:     base.e.e.a.u.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */