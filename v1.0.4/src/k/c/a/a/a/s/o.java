package k.c.a.a.a.s;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class o
  implements k.c.a.a.a.v.a
{
  public Set<String> a()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "tcp" })));
  }
  
  public i a(URI paramURI, k.c.a.a.a.i parami, String paramString)
  {
    String str1 = paramURI.getHost();
    int i = paramURI.getPort();
    int j = i;
    if (i == -1) {
      j = 1883;
    }
    String str2 = paramURI.getPath();
    if ((str2 != null) && (!str2.isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
    paramURI = g;
    if (paramURI == null) {
      paramURI = SocketFactory.getDefault();
    } else {
      if ((paramURI instanceof SSLSocketFactory)) {
        break label108;
      }
    }
    paramURI = new n(paramURI, str1, j, paramString);
    f = l;
    return paramURI;
    label108:
    throw k.b.c.e.a.a(32105);
  }
  
  public void a(URI paramURI)
  {
    Object localObject = paramURI.getPath();
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new StringBuilder("URI path must be empty \"");
      ((StringBuilder)localObject).append(paramURI.toString());
      ((StringBuilder)localObject).append("\"");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */