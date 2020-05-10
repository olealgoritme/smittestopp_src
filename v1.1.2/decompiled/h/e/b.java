package h.e;

import h.a.d.i;
import h.c.d.f;
import h.c.g.h;
import h.c.k.a;
import java.io.File;
import java.io.IOException;
import java.net.SocketOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static d.f a = da;
  public static final Map<SocketOption<?>, i> b = new HashMap();
  public static final Map<SocketOption<?>, i> c = new HashMap();
  
  static
  {
    b.put(j.c, i.SO_RCVBUF);
    b.put(j.a, i.SO_SNDBUF);
    b.put(j.d, i.SO_RCVTIMEO);
    b.put(j.b, i.SO_SNDTIMEO);
    b.put(j.e, i.SO_KEEPALIVE);
    b.put(j.g, i.SO_PASSCRED);
    c.putAll(b);
    c.put(j.f, i.SO_PEERCRED);
  }
  
  public static h a(int paramInt)
  {
    h localh = new h();
    e locale = x;
    a locala = new a(cd + 2);
    if (d.b.a(paramInt, locale, locala) >= 0)
    {
      locale.a(((Integer)x).intValue());
      return localh;
    }
    throw new Error(d.a());
  }
  
  public static h a(int paramInt, h paramh)
  {
    if (paramh == null)
    {
      paramh = e.e();
      paramh.a(h.a.d.e.PF_UNIX);
      if (a == d.f.LINUX)
      {
        paramh.a("");
      }
      else
      {
        File localFile = Files.createTempFile("jnr-unixsocket-tmp", ".sock", new FileAttribute[0]).toFile();
        localFile.deleteOnExit();
        localFile.delete();
        paramh.a(localFile.getPath());
      }
    }
    else
    {
      paramh = x;
    }
    int i = paramh.d();
    if (d.b.a(paramInt, paramh, i) >= 0) {
      return b(paramInt);
    }
    throw new IOException(d.a());
  }
  
  public static void a(int paramInt, SocketOption<?> paramSocketOption, Object paramObject)
  {
    if (paramObject != null)
    {
      i locali = (i)b.get(paramSocketOption);
      if (locali != null)
      {
        Class localClass = paramSocketOption.type();
        if ((localClass != Integer.class) && (localClass != Boolean.class)) {
          throw new AssertionError("Unsupported option type");
        }
        int j;
        if (localClass == Integer.class) {
          int i = ((Integer)paramObject).intValue();
        } else {
          j = ((Boolean)paramObject).booleanValue();
        }
        if (((paramSocketOption != j.c) && (paramSocketOption != j.a)) || (((Integer)paramObject).intValue() >= 0))
        {
          if (((paramSocketOption != j.d) && (paramSocketOption != j.b)) || (((Integer)paramObject).intValue() >= 0))
          {
            if (d.a(paramInt, h.a.d.h.SOL_SOCKET, locali, j) == 0) {
              return;
            }
            throw new IOException(d.a());
          }
          throw new IllegalArgumentException("Invalid send/receive timeout");
        }
        throw new IllegalArgumentException("Invalid send/receive buffer size");
      }
      throw new AssertionError("Option not found or not writable");
    }
    throw new IllegalArgumentException("Invalid option value");
  }
  
  public static h b(int paramInt)
  {
    h localh = new h();
    e locale = x;
    a locala = new a(cd + 2);
    if (d.b.b(paramInt, locale, locala) >= 0)
    {
      locale.a(((Integer)x).intValue());
      return localh;
    }
    throw new Error(d.a());
  }
}

/* Location:
 * Qualified Name:     h.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */