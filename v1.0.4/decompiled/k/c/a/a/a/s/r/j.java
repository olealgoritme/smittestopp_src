package k.c.a.a.a.s.r;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import k.c.a.a.a.s.l;

public class j
  implements k.c.a.a.a.v.a
{
  public Set<String> a()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "wss" })));
  }
  
  public k.c.a.a.a.s.i a(URI paramURI, k.c.a.a.a.i parami, String paramString)
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    if (i == -1) {
      i = 443;
    }
    Object localObject = g;
    k.c.a.a.a.s.q.a locala;
    if (localObject == null)
    {
      locala = new k.c.a.a.a.s.q.a();
      localObject = h;
      if (localObject != null) {
        locala.a((Properties)localObject, null);
      }
      localObject = locala.a(null);
    }
    else
    {
      if (!(localObject instanceof SSLSocketFactory)) {
        break label170;
      }
      locala = null;
    }
    paramURI = new i((SSLSocketFactory)localObject, paramURI.toString(), str, i, paramString, q);
    i = l;
    f = i;
    i = i;
    j = j;
    k = i;
    if (locala != null)
    {
      parami = locala.b(null);
      if (parami != null) {
        paramURI.a(parami);
      }
    }
    return paramURI;
    label170:
    throw k.b.c.e.a.a(32105);
  }
  
  public void a(URI paramURI) {}
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.r.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */