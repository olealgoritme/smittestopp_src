package l.c.a.a.a.s;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;

public class m
  implements l.c.a.a.a.v.a
{
  public Set<String> a()
  {
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "ssl" })));
  }
  
  public i a(URI paramURI, l.c.a.a.a.i parami, String paramString)
  {
    String str = paramURI.getHost();
    int i = paramURI.getPort();
    int j = i;
    if (i == -1) {
      j = 8883;
    }
    Object localObject = paramURI.getPath();
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
    localObject = g;
    if (localObject == null)
    {
      paramURI = new l.c.a.a.a.s.q.a();
      localObject = h;
      if (localObject != null) {
        paramURI.a((Properties)localObject, null);
      }
      localObject = paramURI.a(null);
    }
    else
    {
      if (!(localObject instanceof SSLSocketFactory)) {
        break label191;
      }
      paramURI = null;
    }
    paramString = new l((SSLSocketFactory)localObject, str, j, paramString);
    j = l;
    f = j;
    i = j;
    j = j;
    k = i;
    if (paramURI != null)
    {
      paramURI = paramURI.b(null);
      if (paramURI != null) {
        paramString.a(paramURI);
      }
    }
    return paramString;
    label191:
    throw l.b.c.e.a.a(32105);
  }
  
  public void a(URI paramURI)
  {
    String str = paramURI.getPath();
    if ((str != null) && (!str.isEmpty())) {
      throw new IllegalArgumentException(paramURI.toString());
    }
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */