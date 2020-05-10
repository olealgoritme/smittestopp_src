package l.b.a;

import e.a.a.a.a;
import java.io.IOException;
import java.io.InputStream;

public class z
{
  public final InputStream a;
  public final int b;
  public final byte[][] c;
  
  public z(InputStream paramInputStream)
  {
    a = paramInputStream;
    b = i;
    c = new byte[11][];
  }
  
  public z(InputStream paramInputStream, int paramInt)
  {
    a = paramInputStream;
    b = paramInt;
    c = new byte[11][];
  }
  
  public e a()
  {
    int i = a.read();
    if (i == -1) {
      return null;
    }
    Object localObject = a;
    boolean bool1 = localObject instanceof y1;
    boolean bool2 = false;
    if (bool1)
    {
      localObject = (y1)localObject;
      C = false;
      ((y1)localObject).a();
    }
    int j = k.a(a, i);
    if ((i & 0x20) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = a;
    int k = b;
    if ((j == 4) || (j == 16) || (j == 17) || (j == 8)) {
      bool2 = true;
    }
    k = k.a((InputStream)localObject, k, bool2);
    if (k < 0)
    {
      if (bool1)
      {
        localObject = new z(new y1(a, b), b);
        if ((i & 0x40) != 0) {
          return new f0(j, (z)localObject);
        }
        if ((i & 0x80) != 0) {
          return new o0(true, j, (z)localObject);
        }
        if (j != 4)
        {
          if (j != 8)
          {
            if (j != 16)
            {
              if (j == 17)
              {
                localObject = new m0((z)localObject);
              }
              else
              {
                localObject = a.a("unknown BER object encountered: 0x");
                ((StringBuilder)localObject).append(Integer.toHexString(j));
                throw new h(((StringBuilder)localObject).toString());
              }
            }
            else {
              localObject = new k0((z)localObject);
            }
          }
          else {
            localObject = new t0((z)localObject);
          }
        }
        else {
          localObject = new i0((z)localObject);
        }
        return (e)localObject;
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    localObject = new w1(a, k, b);
    if ((i & 0x40) != 0) {
      return new m1(bool1, j, ((w1)localObject).a());
    }
    if ((i & 0x80) != 0) {
      return new o0(bool1, j, new z((InputStream)localObject));
    }
    if (bool1)
    {
      if (j != 4)
      {
        if (j != 8)
        {
          if (j != 16)
          {
            if (j == 17) {
              return new u1(new z((InputStream)localObject));
            }
            throw new IOException(a.b("unknown tag ", j, " encountered"));
          }
          return new s1(new z((InputStream)localObject));
        }
        return new t0(new z((InputStream)localObject));
      }
      return new i0(new z((InputStream)localObject));
    }
    if (j != 4) {
      try
      {
        localObject = k.a(j, (w1)localObject, c);
        return (e)localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new h("corrupted stream detected", localIllegalArgumentException);
      }
    }
    return new b1(localIllegalArgumentException);
  }
  
  public t a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      return new v1(false, paramInt, new a1(((w1)a).a()));
    }
    Object localObject = b();
    if ((a instanceof y1))
    {
      if (b == 1) {
        localObject = new n0(true, paramInt, ((f)localObject).a(0));
      } else {
        localObject = new n0(false, paramInt, g0.a((f)localObject));
      }
      return (t)localObject;
    }
    if (b == 1) {
      localObject = new v1(true, paramInt, ((f)localObject).a(0));
    } else {
      localObject = new v1(false, paramInt, p1.a((f)localObject));
    }
    return (t)localObject;
  }
  
  public f b()
  {
    Object localObject = a();
    if (localObject == null) {
      return new f(0);
    }
    f localf = new f(10);
    e locale;
    do
    {
      if ((localObject instanceof x1)) {
        localObject = ((x1)localObject).d();
      } else {
        localObject = ((e)localObject).b();
      }
      localf.a((e)localObject);
      locale = a();
      localObject = locale;
    } while (locale != null);
    return localf;
  }
}

/* Location:
 * Qualified Name:     l.b.a.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */