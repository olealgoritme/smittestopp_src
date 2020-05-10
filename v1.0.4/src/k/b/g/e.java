package k.b.g;

import e.a.a.a.a;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import k.b.j.h.b.b;
import k.b.j.h.b.c;
import k.b.j.h.b.d;

public class e
  extends d
{
  public final Map x;
  
  public e(Reader paramReader)
  {
    super(paramReader);
    paramReader = new HashMap();
    x = paramReader;
    paramReader.put("CERTIFICATE REQUEST", new e.g(this, null));
    x.put("NEW CERTIFICATE REQUEST", new e.g(this, null));
    x.put("CERTIFICATE", new e.o(this, null));
    x.put("TRUSTED CERTIFICATE", new e.p(this, null));
    x.put("X509 CERTIFICATE", new e.o(this, null));
    x.put("X509 CRL", new e.n(this, null));
    x.put("PKCS7", new e.h(this, null));
    x.put("CMS", new e.h(this, null));
    x.put("ATTRIBUTE CERTIFICATE", new e.m(this, null));
    x.put("EC PARAMETERS", new e.c(this, null));
    x.put("PUBLIC KEY", new e.j(this));
    x.put("RSA PUBLIC KEY", new e.l(this));
    x.put("RSA PRIVATE KEY", new e.f(this, new e.k(this, null)));
    x.put("DSA PRIVATE KEY", new e.f(this, new e.b(this, null)));
    x.put("EC PRIVATE KEY", new e.f(this, new e.d(this, null)));
    x.put("ENCRYPTED PRIVATE KEY", new e.e(this));
    x.put("PRIVATE KEY", new e.i(this));
  }
  
  public Object readObject()
  {
    b localb = a();
    if (localb != null)
    {
      String str = a;
      if (x.containsKey(str)) {
        return ((c)x.get(str)).a(localb);
      }
      throw new IOException(a.b("unrecognised object: ", str));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.k.b.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */