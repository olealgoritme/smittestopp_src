package k.c.a.a.a.s.r;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class g
  implements k.c.a.a.a.v.a
{
  public Set<String> a()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "ws" })));
  }
  
  public k.c.a.a.a.s.i a(URI paramURI, k.c.a.a.a.i parami, String paramString)
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    if (i == -1) {
      i = 80;
    }
    SocketFactory localSocketFactory = g;
    if (localSocketFactory == null) {
      localSocketFactory = SocketFactory.getDefault();
    } else {
      if ((localSocketFactory instanceof SSLSocketFactory)) {
        break label85;
      }
    }
    paramURI = new f(localSocketFactory, paramURI.toString(), str, i, paramString, q);
    f = l;
    return paramURI;
    label85:
    throw k.b.c.e.a.a(32105);
  }
  
  public void a(URI paramURI) {}
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.r.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */