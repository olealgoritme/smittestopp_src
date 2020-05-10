package l.b.g;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import l.b.a.i2.g;
import l.b.a.k;
import l.b.a.l;
import l.b.a.l2.s;
import l.b.a.o;
import l.b.a.r0;
import l.b.a.t;
import l.b.a.u;
import l.b.a.y0;

public class e
  extends l.b.j.h.b.d
{
  public final Map x;
  
  public e(Reader paramReader)
  {
    super(paramReader);
    paramReader = new HashMap();
    x = paramReader;
    paramReader.put("CERTIFICATE REQUEST", new g(null));
    x.put("NEW CERTIFICATE REQUEST", new g(null));
    x.put("CERTIFICATE", new o(null));
    x.put("TRUSTED CERTIFICATE", new p(null));
    x.put("X509 CERTIFICATE", new o(null));
    x.put("X509 CRL", new n(null));
    x.put("PKCS7", new h(null));
    x.put("CMS", new h(null));
    x.put("ATTRIBUTE CERTIFICATE", new m(null));
    x.put("EC PARAMETERS", new c(null));
    x.put("PUBLIC KEY", new j());
    x.put("RSA PUBLIC KEY", new l());
    x.put("RSA PRIVATE KEY", new f(new k(null)));
    x.put("DSA PRIVATE KEY", new f(new b(null)));
    x.put("EC PRIVATE KEY", new f(new d(null)));
    x.put("ENCRYPTED PRIVATE KEY", new e());
    x.put("PRIVATE KEY", new i());
  }
  
  public Object readObject()
  {
    l.b.j.h.b.b localb = a();
    if (localb != null)
    {
      String str = a;
      if (x.containsKey(str)) {
        return ((l.b.j.h.b.c)x.get(str)).a(localb);
      }
      throw new IOException(e.a.a.a.a.b("unrecognised object: ", str));
    }
    return null;
  }
  
  public class b
    implements d
  {
    public c a(byte[] paramArrayOfByte)
    {
      try
      {
        Object localObject1 = u.a(paramArrayOfByte);
        if (((u)localObject1).size() == 6)
        {
          l locall1 = l.a(((u)localObject1).a(1));
          paramArrayOfByte = l.a(((u)localObject1).a(2));
          l locall2 = l.a(((u)localObject1).a(3));
          Object localObject2 = l.a(((u)localObject1).a(4));
          l locall3 = l.a(((u)localObject1).a(5));
          localObject1 = new l/b/a/l2/s;
          Object localObject3 = new l/b/a/l2/a;
          o localo = l.b.a.m2.f.r;
          Object localObject4 = new l/b/a/l2/h;
          ((l.b.a.l2.h)localObject4).<init>(locall1.j(), paramArrayOfByte.j(), locall2.j());
          ((l.b.a.l2.a)localObject3).<init>(localo, (l.b.a.e)localObject4);
          ((s)localObject1).<init>((l.b.a.l2.a)localObject3, (l.b.a.e)localObject2);
          localObject4 = new l/b/a/i2/f;
          localObject2 = new l/b/a/l2/a;
          localo = l.b.a.m2.f.r;
          localObject3 = new l/b/a/l2/h;
          ((l.b.a.l2.h)localObject3).<init>(locall1.j(), paramArrayOfByte.j(), locall2.j());
          ((l.b.a.l2.a)localObject2).<init>(localo, (l.b.a.e)localObject3);
          ((l.b.a.i2.f)localObject4).<init>((l.b.a.l2.a)localObject2, locall3, null, null);
          return new c((s)localObject1, (l.b.a.i2.f)localObject4);
        }
        paramArrayOfByte = new l/b/g/b;
        paramArrayOfByte.<init>("malformed sequence in DSA private key");
        throw paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating DSA private key: ")), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  public class c
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        t localt = t.a(c);
        if ((localt instanceof o)) {
          return t.a(c);
        }
        if ((localt instanceof u))
        {
          paramb = l.b.a.m2.b.a(localt);
          return paramb;
        }
        return null;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("exception extracting EC named curve: ")));
      }
      catch (IOException paramb)
      {
        throw paramb;
      }
    }
  }
  
  public class d
    implements d
  {
    public c a(byte[] paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = u.a(paramArrayOfByte);
        if ((paramArrayOfByte instanceof l.b.a.j2.a)) {
          paramArrayOfByte = (l.b.a.j2.a)paramArrayOfByte;
        } else if (paramArrayOfByte != null) {
          paramArrayOfByte = new l.b.a.j2.a(u.a(paramArrayOfByte));
        } else {
          paramArrayOfByte = null;
        }
        l.b.a.l2.a locala = new l/b/a/l2/a;
        locala.<init>(l.b.a.m2.f.m, paramArrayOfByte.a(0));
        l.b.a.i2.f localf = new l/b/a/i2/f;
        localf.<init>(locala, paramArrayOfByte, null, null);
        if ((r0)paramArrayOfByte.a(1) != null)
        {
          s locals = new l/b/a/l2/s;
          locals.<init>(locala, ((r0)paramArrayOfByte.a(1)).j());
          return new c(locals, localf);
        }
        paramArrayOfByte = new c(null, localf);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating EC private key: ")), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  public class e
    implements l.b.j.h.b.c
  {
    public e() {}
    
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = c;
        if ((paramb instanceof l.b.a.i2.d)) {
          paramb = (l.b.a.i2.d)paramb;
        } else if (paramb != null) {
          paramb = new l.b.a.i2.d(u.a(paramb));
        } else {
          paramb = null;
        }
        paramb = new l.b.h.b(paramb);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing ENCRYPTED PRIVATE KEY: ")), paramb);
      }
    }
  }
  
  public class f
    implements l.b.j.h.b.c
  {
    public final d a;
    
    public f(d paramd)
    {
      a = paramd;
    }
    
    public Object a(l.b.j.h.b.b paramb)
    {
      Object localObject = b.iterator();
      i = 0;
      String str = null;
      while (((Iterator)localObject).hasNext())
      {
        l.b.j.h.b.a locala = (l.b.j.h.b.a)((Iterator)localObject).next();
        if ((a.equals("Proc-Type")) && (b.equals("4,ENCRYPTED"))) {
          i = 1;
        } else if (a.equals("DEK-Info")) {
          str = b;
        }
      }
      paramb = c;
      if (i != 0) {}
      try
      {
        localObject = new java/util/StringTokenizer;
        ((StringTokenizer)localObject).<init>(str, ",");
        return new a(((StringTokenizer)localObject).nextToken(), l.b.j.g.f.a(((StringTokenizer)localObject).nextToken()), paramb, a);
      }
      catch (IllegalArgumentException paramb)
      {
        if (i == 0) {
          break label163;
        }
        throw new b("exception decoding - please check password and data.", paramb);
        throw new b(paramb.getMessage(), paramb);
      }
      catch (IOException paramb)
      {
        if (i == 0) {
          break label192;
        }
        throw new b("exception decoding - please check password and data.", paramb);
        throw new b(paramb.getMessage(), paramb);
      }
      paramb = a.a(paramb);
      return paramb;
    }
  }
  
  public class g
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = new l.b.h.a(c);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing certrequest: ")), paramb);
      }
    }
  }
  
  public class h
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        k localk = new l/b/a/k;
        localk.<init>(c);
        paramb = localk.readObject();
        if ((paramb instanceof l.b.a.f2.a)) {
          paramb = (l.b.a.f2.a)paramb;
        } else if (paramb != null) {
          paramb = new l.b.a.f2.a(u.a(paramb));
        } else {
          paramb = null;
        }
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing PKCS7 object: ")), paramb);
      }
    }
  }
  
  public class i
    implements l.b.j.h.b.c
  {
    public i() {}
    
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = l.b.a.i2.f.a(c);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing PRIVATE KEY: ")), paramb);
      }
    }
  }
  
  public class j
    implements l.b.j.h.b.c
  {
    public j() {}
    
    public Object a(l.b.j.h.b.b paramb)
    {
      return s.a(c);
    }
  }
  
  public class k
    implements d
  {
    public c a(byte[] paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = u.a(paramArrayOfByte);
        if (paramArrayOfByte.size() == 9)
        {
          if ((paramArrayOfByte instanceof g)) {
            paramArrayOfByte = (g)paramArrayOfByte;
          } else {
            paramArrayOfByte = new g(u.a(paramArrayOfByte));
          }
          Object localObject = new l/b/a/i2/h;
          ((l.b.a.i2.h)localObject).<init>(y, z);
          l.b.a.l2.a locala = new l/b/a/l2/a;
          locala.<init>(l.b.a.i2.e.b, y0.x);
          s locals = new l/b/a/l2/s;
          locals.<init>(locala, (l.b.a.e)localObject);
          localObject = new l/b/a/i2/f;
          ((l.b.a.i2.f)localObject).<init>(locala, paramArrayOfByte, null, null);
          return new c(locals, (l.b.a.i2.f)localObject);
        }
        paramArrayOfByte = new l/b/g/b;
        paramArrayOfByte.<init>("malformed sequence in RSA private key");
        throw paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new b(e.a.a.a.a.a(paramArrayOfByte, e.a.a.a.a.a("problem creating RSA private key: ")), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  public class l
    implements l.b.j.h.b.c
  {
    public l() {}
    
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = c;
        if ((paramb instanceof l.b.a.i2.h)) {
          paramb = (l.b.a.i2.h)paramb;
        } else if (paramb != null) {
          paramb = new l.b.a.i2.h(u.a(paramb));
        } else {
          paramb = null;
        }
        l.b.a.l2.a locala = new l/b/a/l2/a;
        locala.<init>(l.b.a.i2.e.b, y0.x);
        paramb = new s(locala, paramb);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem extracting key: ")), paramb);
      }
      catch (IOException paramb)
      {
        throw paramb;
      }
    }
  }
  
  public class m
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      return new l.b.b.c(c);
    }
  }
  
  public class n
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = new l.b.b.d(c);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing cert: ")), paramb);
      }
    }
  }
  
  public class o
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = new l.b.b.e(c);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing cert: ")), paramb);
      }
    }
  }
  
  public class p
    implements l.b.j.h.b.c
  {
    public Object a(l.b.j.h.b.b paramb)
    {
      try
      {
        paramb = new f(c);
        return paramb;
      }
      catch (Exception paramb)
      {
        throw new b(e.a.a.a.a.a(paramb, e.a.a.a.a.a("problem parsing cert: ")), paramb);
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.b.g.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */