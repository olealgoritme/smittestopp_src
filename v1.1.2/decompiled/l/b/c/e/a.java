package l.b.c.e;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Map;
import l.b.a.a1;
import l.b.a.y0;
import l.b.c.c.d;
import l.b.i.a.j;
import l.b.i.a.l;
import l.b.i.b.g.g.b;
import l.b.i.b.g.i.b;
import l.b.i.b.g.o.a;
import l.b.i.b.g.q;
import l.b.i.b.g.r;
import l.b.i.b.g.s.b;
import l.b.i.b.g.w;
import l.b.i.b.g.x.b;
import l.b.i.b.g.y;
import l.b.i.b.g.z;

public final class a
{
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      System.err.println("Error: to be divided by 0");
      return 0;
    }
    while (b(paramInt1) >= b(paramInt2)) {
      paramInt1 ^= paramInt2 << b(paramInt1) - b(paramInt2);
    }
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = a(paramInt1, paramInt3);
    paramInt1 = a(paramInt2, paramInt3);
    int j = 0;
    paramInt2 = 0;
    if (paramInt1 != 0)
    {
      int k = b(paramInt3);
      for (;;)
      {
        j = paramInt2;
        if (i == 0) {
          break;
        }
        j = paramInt2;
        if ((byte)(i & 0x1) == 1) {
          j = paramInt2 ^ paramInt1;
        }
        int m = i >>> 1;
        int n = paramInt1 << 1;
        paramInt2 = j;
        i = m;
        paramInt1 = n;
        if (n >= 1 << k)
        {
          paramInt1 = n ^ paramInt3;
          paramInt2 = j;
          i = m;
        }
      }
    }
    return j;
  }
  
  public static int a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      l = (paramArrayOfInt2[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[i]) + l;
      paramArrayOfInt2[i] = ((int)l);
      l >>= 32;
    }
    return (int)l;
  }
  
  public static int a(String paramString)
  {
    return Log.d("greenDAO", paramString);
  }
  
  public static int a(String paramString, Throwable paramThrowable)
  {
    return Log.w("greenDAO", paramString, paramThrowable);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    int k = paramArrayOfByte[i];
    i = paramArrayOfByte[paramInt];
    return (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (i & 0xFF) << 16;
  }
  
  public static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int[] paramArrayOfInt3, int paramInt2)
  {
    int i = paramArrayOfInt1.length;
    int n;
    for (int j = 0; paramArrayOfInt2[0] == 0; j += 32)
    {
      k = paramInt1;
      for (m = 0;; m = n)
      {
        k--;
        if (k < 0) {
          break;
        }
        n = paramArrayOfInt2[k];
        paramArrayOfInt2[k] = m;
      }
    }
    int m = paramArrayOfInt2[0];
    for (int k = 0; (m & 0x1) == 0; k++) {
      m >>>= 1;
    }
    m = j;
    if (k > 0)
    {
      n = 0;
      m = paramInt1;
      for (paramInt1 = n;; paramInt1 = n)
      {
        m--;
        if (m < 0) {
          break;
        }
        n = paramArrayOfInt2[m];
        paramArrayOfInt2[m] = (paramInt1 << -k | n >>> k);
      }
      m = j + k;
    }
    paramInt1 = 0;
    j = paramInt2;
    paramInt2 = paramInt1;
    while (paramInt2 < m)
    {
      paramInt1 = j;
      if ((paramArrayOfInt3[0] & 0x1) != 0) {
        if (j < 0)
        {
          long l = 0L;
          for (paramInt1 = 0; paramInt1 < i; paramInt1++)
          {
            l = (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt3[paramInt1]) + l;
            paramArrayOfInt3[paramInt1] = ((int)l);
            l >>>= 32;
          }
          paramInt1 = j + (int)l;
        }
        else
        {
          paramInt1 = a(i, paramArrayOfInt1, paramArrayOfInt3) + j;
        }
      }
      j = paramInt1;
      k = i;
      for (;;)
      {
        k--;
        if (k < 0) {
          break;
        }
        n = paramArrayOfInt3[k];
        paramArrayOfInt3[k] = (j << 31 | n >>> 1);
        j = n;
      }
      paramInt2++;
      j = paramInt1;
    }
    return j;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l = 0L;
      for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
        l = l << 8 | paramArrayOfByte[i] & 0xFF;
      }
      return l;
    }
    throw new NullPointerException("in == null");
  }
  
  public static Object a(byte[] paramArrayOfByte, Class paramClass)
  {
    paramArrayOfByte = new z(paramClass, new ByteArrayInputStream(paramArrayOfByte));
    Object localObject = paramArrayOfByte.readObject();
    if (paramArrayOfByte.available() == 0)
    {
      if (paramClass.isInstance(localObject)) {
        return localObject;
      }
      throw new IOException("unexpected class found in ObjectInputStream");
    }
    throw new IOException("unexpected data found at end of ObjectInputStream");
  }
  
  public static l.b.a.i2.f a(l.b.c.d.a parama, l.b.a.x paramx)
  {
    if ((parama instanceof l.b.i.b.c.a))
    {
      parama = (l.b.i.b.c.a)parama;
      return new l.b.a.i2.f(l.b.i.b.f.b.a(a), new a1(parama.a()), paramx, null);
    }
    if ((parama instanceof l.b.i.b.e.b))
    {
      parama = (l.b.i.b.e.b)parama;
      return new l.b.a.i2.f(new l.b.a.l2.a(l.b.i.a.e.e, new l.b.i.a.h(l.b.i.b.f.b.a(a))), new a1(parama.a()), null, null);
    }
    boolean bool = parama instanceof l.b.i.b.b.a;
    int i = 0;
    Object localObject1;
    int j;
    int k;
    if (bool)
    {
      paramx = (l.b.i.b.b.a)parama;
      parama = new l.b.a.l2.a(l.b.i.a.e.f);
      localObject1 = paramx.a();
      paramx = new byte[localObject1.length * 2];
      while (i != localObject1.length)
      {
        j = localObject1[i];
        k = i * 2;
        paramx[k] = ((byte)(byte)j);
        paramx[(k + 1)] = ((byte)(byte)(j >>> 8));
        i++;
      }
      return new l.b.a.i2.f(parama, new a1(paramx), null, null);
    }
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    Object localObject2;
    if ((parama instanceof l.b.i.b.g.x))
    {
      localObject1 = (l.b.i.b.g.x)parama;
      paramx = new l.b.a.l2.a(l.b.i.a.e.g, new l.b.i.a.i(b.b, l.b.i.b.f.b.b(a)));
      parama = ((l.b.i.b.g.x)localObject1).a();
      localObject1 = b;
      k = g;
      j = b;
      i = (int)a(parama, 0, 4);
      if (a(j, i))
      {
        localObject1 = b(parama, 4, k);
        int m = k + 4;
        arrayOfByte1 = b(parama, m, k);
        m += k;
        arrayOfByte2 = b(parama, m, k);
        m += k;
        arrayOfByte3 = b(parama, m, k);
        k = m + k;
        parama = b(parama, k, parama.length - k);
        try
        {
          localObject2 = (l.b.i.b.g.a)a(parama, l.b.i.b.g.a.class);
          k = I;
          if (k != (1 << j) - 1) {
            parama = new l.b.i.a.m(i, (byte[])localObject1, arrayOfByte1, arrayOfByte2, arrayOfByte3, parama, k);
          } else {
            parama = new l.b.i.a.m(i, (byte[])localObject1, arrayOfByte1, arrayOfByte2, arrayOfByte3, parama);
          }
          return new l.b.a.i2.f(paramx, parama, null, null);
        }
        catch (ClassNotFoundException parama)
        {
          paramx = e.a.a.a.a.a("cannot parse BDS: ");
          paramx.append(parama.getMessage());
          throw new IOException(paramx.toString());
        }
      }
      throw new IllegalArgumentException("index out of bounds");
    }
    if ((parama instanceof l.b.i.b.g.s))
    {
      paramx = (l.b.i.b.g.s)parama;
      localObject1 = l.b.i.a.e.l;
      parama = b;
      parama = new l.b.a.l2.a((l.b.a.o)localObject1, new j(c, d, l.b.i.b.f.b.b(a)));
      arrayOfByte2 = paramx.a();
      paramx = b;
      j = b.g;
      i = c;
      k = (i + 7) / 8;
      long l1 = (int)a(arrayOfByte2, 0, k);
      if (a(i, l1))
      {
        k += 0;
        localObject1 = b(arrayOfByte2, k, j);
        k += j;
        arrayOfByte3 = b(arrayOfByte2, k, j);
        k += j;
        paramx = b(arrayOfByte2, k, j);
        k += j;
        arrayOfByte1 = b(arrayOfByte2, k, j);
        j = k + j;
        arrayOfByte2 = b(arrayOfByte2, j, arrayOfByte2.length - j);
        try
        {
          localObject2 = (l.b.i.b.g.b)a(arrayOfByte2, l.b.i.b.g.b.class);
          long l2 = y;
          localObject2 = new l/b/i/a/k;
          if (l2 != (1L << i) - 1L) {
            ((l.b.i.a.k)localObject2).<init>(l1, (byte[])localObject1, arrayOfByte3, paramx, arrayOfByte1, arrayOfByte2, l2);
          } else {
            ((l.b.i.a.k)localObject2).<init>(l1, (byte[])localObject1, arrayOfByte3, paramx, arrayOfByte1, arrayOfByte2);
          }
          return new l.b.a.i2.f(parama, (l.b.a.e)localObject2, null, null);
        }
        catch (ClassNotFoundException paramx)
        {
          parama = e.a.a.a.a.a("cannot parse BDSStateMap: ");
          parama.append(paramx.getMessage());
          throw new IOException(parama.toString());
        }
      }
      throw new IllegalArgumentException("index out of bounds");
    }
    throw new IOException("key parameters not recognized");
  }
  
  public static l.b.a.l2.s a(l.b.c.d.a parama)
  {
    if ((parama instanceof l.b.i.b.c.b))
    {
      parama = (l.b.i.b.c.b)parama;
      return new l.b.a.l2.s(l.b.i.b.f.b.a(a), parama.a());
    }
    if ((parama instanceof l.b.i.b.e.c))
    {
      parama = (l.b.i.b.e.c)parama;
      return new l.b.a.l2.s(new l.b.a.l2.a(l.b.i.a.e.e, new l.b.i.a.h(l.b.i.b.f.b.a(a))), parama.a());
    }
    if ((parama instanceof l.b.i.b.b.b))
    {
      parama = (l.b.i.b.b.b)parama;
      return new l.b.a.l2.s(new l.b.a.l2.a(l.b.i.a.e.f), parama.a());
    }
    if ((parama instanceof y))
    {
      parama = (y)parama;
      return new l.b.a.l2.s(new l.b.a.l2.a(l.b.i.a.e.g, new l.b.i.a.i(b.b, l.b.i.b.f.b.b(a))), new l.b.i.a.n(b(e), b(d)));
    }
    if ((parama instanceof l.b.i.b.g.t))
    {
      parama = (l.b.i.b.g.t)parama;
      l.b.a.o localo = l.b.i.a.e.l;
      r localr = b;
      return new l.b.a.l2.s(new l.b.a.l2.a(localo, new j(c, d, l.b.i.b.f.b.b(a))), new l(b(e), b(d)));
    }
    throw new IOException("key parameters not recognized");
  }
  
  public static l.b.c.a a(l.b.a.l2.a parama)
  {
    if (x.b(l.b.a.h2.a.a)) {
      return new l.b.c.c.c();
    }
    if (x.b(l.b.a.g2.a.f)) {
      return new d();
    }
    if (x.b(l.b.a.g2.a.c)) {
      return new l.b.c.c.e();
    }
    if (x.b(l.b.a.g2.a.d)) {
      return new l.b.c.c.f();
    }
    if (x.b(l.b.a.g2.a.e)) {
      return new l.b.c.c.g();
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("unrecognised OID in digest algorithm identifier: ");
    localStringBuilder.append(x);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static l.b.c.d.a a(l.b.a.i2.f paramf)
  {
    Object localObject1 = y.x;
    Object localObject2 = l.b.a.e2.a.D;
    Object localObject3 = x;
    localObject2 = x;
    int i = ((String)localObject3).length();
    int j = ((String)localObject2).length();
    int k = 0;
    if ((i > j) && (((String)localObject3).charAt(((String)localObject2).length()) == '.') && (((String)localObject3).startsWith((String)localObject2))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = l.b.a.p.a(paramf.f());
      paramf = y;
      return new l.b.i.b.c.a(((Integer)l.b.i.b.f.b.i.get(x)).intValue(), ((l.b.a.p)localObject1).j());
    }
    if (((l.b.a.t)localObject1).b(l.b.a.e2.a.h)) {
      return new l.b.i.b.e.b(l.b.a.p.a(paramf.f()).j(), l.b.i.b.f.b.a(l.b.i.a.h.a(y.y)));
    }
    if (((l.b.a.t)localObject1).b(l.b.a.e2.a.H))
    {
      localObject1 = l.b.a.p.a(paramf.f()).j();
      j = localObject1.length / 2;
      paramf = new short[j];
      for (i = k; i != j; i++)
      {
        int m = i * 2;
        k = localObject1[m];
        paramf[i] = ((short)(short)((localObject1[(m + 1)] & 0xFF) << 8 | k & 0xFF));
      }
      return new l.b.i.b.b.a(paramf);
    }
    Object localObject4;
    if (((l.b.a.t)localObject1).b(l.b.a.e2.a.l))
    {
      localObject3 = l.b.i.a.i.a(y.y);
      localObject1 = z.x;
      paramf = paramf.f();
      if ((paramf instanceof l.b.i.a.m)) {
        paramf = (l.b.i.a.m)paramf;
      } else if (paramf != null) {
        paramf = new l.b.i.a.m(l.b.a.u.a(paramf));
      } else {
        paramf = null;
      }
      try
      {
        localObject2 = new l/b/i/b/g/x$b;
        localObject4 = new l/b/i/b/g/w;
        ((w)localObject4).<init>(y, l.b.i.b.f.b.a((l.b.a.o)localObject1));
        ((x.b)localObject2).<init>((w)localObject4);
        b = y;
        d = b(a(z));
        e = b(a(A));
        f = b(a(B));
        g = b(a(C));
        if (x != 0) {
          c = D;
        }
        if (a(E) != null)
        {
          paramf = (l.b.i.b.g.a)a(a(E), l.b.i.b.g.a.class);
          if (paramf != null)
          {
            localObject3 = new l/b/i/b/g/a;
            ((l.b.i.b.g.a)localObject3).<init>(paramf, (l.b.a.o)localObject1);
            h = ((l.b.i.b.g.a)localObject3);
          }
          else
          {
            throw null;
          }
        }
        paramf = new l.b.i.b.g.x((x.b)localObject2, null);
        return paramf;
      }
      catch (ClassNotFoundException paramf)
      {
        localObject1 = e.a.a.a.a.a("ClassNotFoundException processing BDS state: ");
        ((StringBuilder)localObject1).append(paramf.getMessage());
        throw new IOException(((StringBuilder)localObject1).toString());
      }
    }
    if (((l.b.a.t)localObject1).b(l.b.i.a.e.l))
    {
      localObject3 = j.a(y.y);
      localObject1 = A.x;
      try
      {
        paramf = paramf.f();
        if ((paramf instanceof l.b.i.a.k)) {
          paramf = (l.b.i.a.k)paramf;
        } else if (paramf != null) {
          paramf = new l.b.i.a.k(l.b.a.u.a(paramf));
        } else {
          paramf = null;
        }
        localObject2 = new l/b/i/b/g/s$b;
        localObject4 = new l/b/i/b/g/r;
        ((r)localObject4).<init>(y, z, l.b.i.b.f.b.a((l.b.a.o)localObject1));
        ((s.b)localObject2).<init>((r)localObject4);
        b = y;
        d = b(a(A));
        e = b(a(B));
        f = b(a(C));
        g = b(a(D));
        if (x != 0) {
          c = z;
        }
        if (a(E) != null)
        {
          paramf = ((l.b.i.b.g.b)a(a(E), l.b.i.b.g.b.class)).a((l.b.a.o)localObject1);
          if (y == 0L)
          {
            localObject1 = new l/b/i/b/g/b;
            ((l.b.i.b.g.b)localObject1).<init>(paramf, (1L << a.c) - 1L);
            h = ((l.b.i.b.g.b)localObject1);
          }
          else
          {
            h = paramf;
          }
        }
        paramf = new l.b.i.b.g.s((s.b)localObject2, null);
        return paramf;
      }
      catch (ClassNotFoundException paramf)
      {
        localObject1 = e.a.a.a.a.a("ClassNotFoundException processing BDS state: ");
        ((StringBuilder)localObject1).append(paramf.getMessage());
        throw new IOException(((StringBuilder)localObject1).toString());
      }
    }
    throw new RuntimeException("algorithm identifier in private key not recognised");
  }
  
  public static l.b.i.b.g.u a(l.b.i.b.g.k paramk, l.b.i.b.g.n paramn, l.b.i.b.g.i parami)
  {
    if (paramn != null)
    {
      if (parami != null)
      {
        int i = a.d;
        paramn = a(a);
        l.b.i.b.g.u[] arrayOfu = new l.b.i.b.g.u[paramn.length];
        for (int j = 0; j < paramn.length; j++) {
          arrayOfu[j] = new l.b.i.b.g.u(0, paramn[j]);
        }
        paramn = (i.b)((i.b)new i.b().b(a)).a(b);
        e = e;
        f = 0;
        g = g;
        paramn = paramn.a(d);
        j = i;
        for (;;)
        {
          paramn = (l.b.i.b.g.i)((i.b)paramn).b();
          if (j <= 1) {
            break;
          }
          double d;
          for (i = 0;; i++)
          {
            d = j / 2;
            if (i >= (int)Math.floor(d)) {
              break;
            }
            parami = (i.b)((i.b)new i.b().b(a)).a(b);
            e = e;
            f = f;
            g = i;
            paramn = (l.b.i.b.g.i)((i.b)parami.a(d)).b();
            int k = i * 2;
            arrayOfu[i] = a(paramk, arrayOfu[k], arrayOfu[(k + 1)], paramn);
          }
          if (j % 2 == 1) {
            arrayOfu[((int)Math.floor(d))] = arrayOfu[(j - 1)];
          }
          j = (int)Math.ceil(j / 2.0D);
          parami = (i.b)((i.b)new i.b().b(a)).a(b);
          e = e;
          f = (f + 1);
          g = g;
          paramn = parami.a(d);
        }
        return arrayOfu[0];
      }
      throw new NullPointerException("address == null");
    }
    throw new NullPointerException("publicKey == null");
  }
  
  public static l.b.i.b.g.u a(l.b.i.b.g.k paramk, l.b.i.b.g.u paramu1, l.b.i.b.g.u paramu2, l.b.i.b.g.o paramo)
  {
    if (paramu1 != null)
    {
      if (paramu2 != null)
      {
        if (x == x)
        {
          if (paramo != null)
          {
            byte[] arrayOfByte1 = a(d);
            boolean bool = paramo instanceof l.b.i.b.g.i;
            int i = 0;
            if (bool)
            {
              localObject = (l.b.i.b.g.i)paramo;
              paramo = (i.b)((i.b)new i.b().b(a)).a(b);
              e = e;
              f = f;
              g = g;
              localObject = (l.b.i.b.g.i)((i.b)paramo.a(0)).b();
            }
            else
            {
              localObject = paramo;
              if ((paramo instanceof l.b.i.b.g.g))
              {
                localObject = (l.b.i.b.g.g)paramo;
                paramo = (g.b)((g.b)new g.b().b(a)).a(b);
                e = f;
                f = g;
                localObject = (l.b.i.b.g.g)((g.b)paramo.a(0)).b();
              }
            }
            byte[] arrayOfByte2 = b.a(arrayOfByte1, ((l.b.i.b.g.o)localObject).a());
            if ((localObject instanceof l.b.i.b.g.i))
            {
              paramo = (l.b.i.b.g.i)localObject;
              localObject = (i.b)((i.b)new i.b().b(a)).a(b);
              e = e;
              f = f;
              g = g;
              paramo = (l.b.i.b.g.i)((i.b)((o.a)localObject).a(1)).b();
            }
            else
            {
              paramo = (l.b.i.b.g.o)localObject;
              if ((localObject instanceof l.b.i.b.g.g))
              {
                paramo = (l.b.i.b.g.g)localObject;
                localObject = (g.b)((g.b)new g.b().b(a)).a(b);
                e = f;
                f = g;
                paramo = (l.b.i.b.g.g)((g.b)((o.a)localObject).a(1)).b();
              }
            }
            byte[] arrayOfByte3 = b.a(arrayOfByte1, paramo.a());
            if ((paramo instanceof l.b.i.b.g.i))
            {
              paramo = (l.b.i.b.g.i)paramo;
              localObject = (i.b)((i.b)new i.b().b(a)).a(b);
              e = e;
              f = f;
              g = g;
              localObject = (l.b.i.b.g.i)((i.b)((o.a)localObject).a(2)).b();
            }
            else
            {
              localObject = paramo;
              if ((paramo instanceof l.b.i.b.g.g))
              {
                localObject = (l.b.i.b.g.g)paramo;
                paramo = (g.b)((g.b)new g.b().b(a)).a(b);
                e = f;
                f = g;
                localObject = (l.b.i.b.g.g)((g.b)paramo.a(2)).b();
              }
            }
            Object localObject = b.a(arrayOfByte1, ((l.b.i.b.g.o)localObject).a());
            int j = a.b;
            int k = j * 2;
            paramo = new byte[k];
            int n;
            for (int m = 0;; m++)
            {
              n = i;
              if (m >= j) {
                break;
              }
              paramo[m] = ((byte)(byte)(paramu1.a()[m] ^ arrayOfByte3[m]));
            }
            while (n < j)
            {
              paramo[(n + j)] = ((byte)(byte)(paramu2.a()[n] ^ localObject[n]));
              n++;
            }
            paramk = b;
            if (paramk != null)
            {
              m = arrayOfByte2.length;
              n = b;
              if (m == n)
              {
                if (k == n * 2)
                {
                  paramk = paramk.a(1, arrayOfByte2, paramo);
                  return new l.b.i.b.g.u(x, paramk);
                }
                throw new IllegalArgumentException("wrong in length");
              }
              throw new IllegalArgumentException("wrong key length");
            }
            throw null;
          }
          throw new NullPointerException("address == null");
        }
        throw new IllegalStateException("height of both nodes must be equal");
      }
      throw new NullPointerException("right == null");
    }
    throw new NullPointerException("left == null");
  }
  
  public static l.b.i.d.a.a a(l.b.i.d.a.b paramb, l.b.i.d.a.e parame)
  {
    int i = a;
    int j = 1 << i;
    int k = parame.b();
    int[][] arrayOfInt1 = new int[k][j];
    int[][] arrayOfInt2 = new int[k][j];
    int[] arrayOfInt4;
    int n;
    int i1;
    for (int m = 0; m < j; m++)
    {
      int[] arrayOfInt3 = arrayOfInt2[0];
      arrayOfInt4 = c;
      n = b;
      for (i1 = arrayOfInt4[n];; i1 = a.a(i1, m) ^ c[n])
      {
        n--;
        if (n < 0) {
          break;
        }
      }
      arrayOfInt3[m] = paramb.a(i1);
    }
    for (m = 1; m < k; m++) {
      for (n = 0; n < j; n++) {
        arrayOfInt2[m][n] = paramb.a(arrayOfInt2[(m - 1)][n], n);
      }
    }
    int i2;
    for (m = 0; m < k; m++) {
      for (n = 0; n < j; n++) {
        for (i1 = 0; i1 <= m; i1++)
        {
          arrayOfInt4 = arrayOfInt1[m];
          i2 = arrayOfInt1[m][n];
          arrayOfInt4[n] = (paramb.a(arrayOfInt2[i1][n], parame.a(k + i1 - m)) ^ i2);
        }
      }
    }
    parame = new int[k * i][j + 31 >>> 5];
    for (m = 0; m < j; m++)
    {
      i2 = m >>> 5;
      for (n = 0; n < k; n++)
      {
        int i3 = arrayOfInt1[n][m];
        for (i1 = 0; i1 < i; i1++) {
          if ((i3 >>> i1 & 0x1) != 0)
          {
            paramb = parame[((n + 1) * i - i1 - 1)];
            paramb[i2] ^= 1 << (m & 0x1F);
          }
        }
      }
    }
    return new l.b.i.d.a.a(j, parame);
  }
  
  public static l.c.a.a.a.k a(int paramInt)
  {
    if ((paramInt != 4) && (paramInt != 5)) {
      return new l.c.a.a.a.k(paramInt);
    }
    return new l.c.a.a.a.p(paramInt);
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 24));
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    b((int)(paramLong >>> 32), paramArrayOfByte, paramInt);
    b((int)(paramLong & 0xFFFFFFFF), paramArrayOfByte, paramInt + 4);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      int j = 0;
      if ((i >= 1) && (i <= 65535))
      {
        int k;
        int m;
        int i2;
        if (paramBoolean)
        {
          k = 0;
          i = 0;
          for (;;)
          {
            if (k >= 2)
            {
              if (i != 0) {
                return;
              }
              if ((!a(paramString)) && (!a("#")))
              {
                k = 0;
                i = 0;
                for (;;)
                {
                  k = paramString.toString().indexOf("#".toString(), k);
                  if (k == -1) {
                    break;
                  }
                  i++;
                  k += "#".length();
                }
              }
              i = 0;
              if ((i <= 1) && ((!paramString.contains("#")) || (paramString.endsWith("/#"))))
              {
                m = "+".charAt(0);
                int n = "/".charAt(0);
                localObject = paramString.toCharArray();
                int i1 = localObject.length;
                for (i = 0;; i = i2)
                {
                  if (i >= i1) {
                    return;
                  }
                  k = i - 1;
                  if (k >= 0) {
                    k = localObject[k];
                  } else {
                    k = 0;
                  }
                  i2 = i + 1;
                  if (i2 < i1) {
                    j = localObject[i2];
                  } else {
                    j = 0;
                  }
                  if ((localObject[i] == m) && (((k != n) && (k != 0)) || ((j != n) && (j != 0)))) {
                    throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", new Object[] { paramString }));
                  }
                }
              }
              localObject = new StringBuilder("Invalid usage of multi-level wildcard in topic string: ");
              ((StringBuilder)localObject).append(paramString);
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
            localObject = new String[] { "#", "+" }[k];
            if ((i == 0) && (!localObject.equals(paramString))) {
              i = 0;
            } else {
              i = 1;
            }
            k++;
          }
        }
        Object localObject = "#+".toCharArray();
        i = j;
        if (!a(paramString))
        {
          if ((localObject != null) && (localObject.length != 0)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0)
          {
            i = j;
          }
          else
          {
            m = paramString.length();
            i2 = localObject.length;
            i = 0;
            if (i >= m)
            {
              i = j;
            }
            else
            {
              char c = paramString.charAt(i);
              for (k = 0;; k++)
              {
                if (k >= i2)
                {
                  i++;
                  break;
                }
                if ((localObject[k] == c) && ((!Character.isHighSurrogate(c)) || (k == i2 - 1) || ((i < m - 1) && (localObject[(k + 1)] == paramString.charAt(i + 1)))))
                {
                  i = 1;
                  break label531;
                }
              }
            }
          }
        }
        label531:
        if (i == 0) {
          return;
        }
        throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
      }
      throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Object[] { Integer.valueOf(1), Integer.valueOf(65535) }));
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString.getMessage());
    }
  }
  
  public static void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null)
      {
        if (paramInt >= 0)
        {
          if (paramArrayOfByte2.length + paramInt <= paramArrayOfByte1.length)
          {
            for (int i = 0; i < paramArrayOfByte2.length; i++) {
              paramArrayOfByte1[(paramInt + i)] = ((byte)paramArrayOfByte2[i]);
            }
            return;
          }
          throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        throw new IllegalArgumentException("offset hast to be >= 0");
      }
      throw new NullPointerException("src == null");
    }
    throw new NullPointerException("dst == null");
  }
  
  public static void a(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = 0;
    if (paramInt < 0)
    {
      int j = paramArrayOfInt1.length;
      long l = 0L;
      for (paramInt = i; paramInt < j; paramInt++)
      {
        l = (paramArrayOfInt2[paramInt] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt1[paramInt]) + l;
        paramArrayOfInt3[paramInt] = ((int)l);
        l >>>= 32;
      }
    }
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt3, 0, paramArrayOfInt1.length);
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (paramLong >= 0L)
    {
      boolean bool;
      if (paramLong < 1L << paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    throw new IllegalStateException("index must not be negative");
  }
  
  public static boolean a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    for (int i = 1; i < paramInt; i++) {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return false;
    }
    int i = paramArrayOfInt1.length - 1;
    boolean bool1 = true;
    while (i >= 0)
    {
      boolean bool2;
      if (paramArrayOfInt1[i] == paramArrayOfInt2[i]) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 &= bool2;
      i--;
    }
    return bool1;
  }
  
  public static boolean a(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length - 1;
    boolean bool1 = true;
    while (i >= 0)
    {
      boolean bool2;
      if (paramArrayOfShort1[i] == paramArrayOfShort2[i]) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 &= bool2;
      i--;
    }
    return bool1;
  }
  
  public static boolean a(short[][] paramArrayOfShort1, short[][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i--;
    while (i >= 0)
    {
      bool &= a(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i--;
    }
    return bool;
  }
  
  public static boolean a(short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2)
  {
    if (paramArrayOfShort1.length != paramArrayOfShort2.length) {
      return false;
    }
    int i = paramArrayOfShort1.length;
    boolean bool = true;
    i--;
    while (i >= 0)
    {
      bool &= a(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      i--;
    }
    return bool;
  }
  
  public static byte[] a(long paramLong, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramInt--;
    while (paramInt >= 0)
    {
      arrayOfByte[paramInt] = ((byte)(byte)(int)paramLong);
      paramLong >>>= 8;
      paramInt--;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    } else {
      paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    }
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {}
    for (paramArrayOfByte1 = paramArrayOfByte2.clone();; paramArrayOfByte1 = paramArrayOfByte1.clone())
    {
      return (byte[])paramArrayOfByte1;
      if (paramArrayOfByte2 != null) {
        break;
      }
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static int[] a(int paramInt, BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt))
    {
      int[] arrayOfInt = new int[paramInt + 31 >> 5];
      for (paramInt = 0; paramBigInteger.signum() != 0; paramInt++)
      {
        arrayOfInt[paramInt] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
    return arrayOfInt;
  }
  
  public static short[] a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      paramArrayOfShort = null;
    } else {
      paramArrayOfShort = (short[])paramArrayOfShort.clone();
    }
    return paramArrayOfShort;
  }
  
  public static byte[][] a(byte[][] paramArrayOfByte)
  {
    if (!c(paramArrayOfByte))
    {
      byte[][] arrayOfByte = new byte[paramArrayOfByte.length][];
      for (int i = 0; i < paramArrayOfByte.length; i++)
      {
        arrayOfByte[i] = new byte[paramArrayOfByte[i].length];
        System.arraycopy(paramArrayOfByte[i], 0, arrayOfByte[i], 0, paramArrayOfByte[i].length);
      }
      return arrayOfByte;
    }
    throw new NullPointerException("in has null pointers");
  }
  
  public static byte[][] a(short[][] paramArrayOfShort)
  {
    byte[][] arrayOfByte = new byte[paramArrayOfShort.length][paramArrayOfShort[0].length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      for (int j = 0; j < paramArrayOfShort[0].length; j++) {
        arrayOfByte[i][j] = ((byte)(byte)paramArrayOfShort[i][j]);
      }
    }
    return arrayOfByte;
  }
  
  public static byte[][][] a(short[][][] paramArrayOfShort)
  {
    byte[][][] arrayOfByte = new byte[paramArrayOfShort.length][paramArrayOfShort[0].length][paramArrayOfShort[0][0].length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      for (int j = 0; j < paramArrayOfShort[0].length; j++) {
        for (int k = 0; k < paramArrayOfShort[0][0].length; k++) {
          arrayOfByte[i][j][k] = ((byte)(byte)paramArrayOfShort[i][j][k]);
        }
      }
    }
    return arrayOfByte;
  }
  
  public static short[][][] a(byte[][][] paramArrayOfByte)
  {
    short[][][] arrayOfShort = new short[paramArrayOfByte.length][paramArrayOfByte[0].length][paramArrayOfByte[0][0].length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      for (int j = 0; j < paramArrayOfByte[0].length; j++) {
        for (int k = 0; k < paramArrayOfByte[0][0].length; k++) {
          arrayOfShort[i][j][k] = ((short)(short)(paramArrayOfByte[i][j][k] & 0xFF));
        }
      }
    }
    return arrayOfShort;
  }
  
  public static int b(int paramInt)
  {
    int i = -1;
    while (paramInt != 0)
    {
      i++;
      paramInt >>>= 1;
    }
    return i;
  }
  
  public static int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j++;
    int k = paramArrayOfByte[j];
    return paramArrayOfByte[(j + 1)] & 0xFF | i << 24 | (paramInt & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static int b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return 0;
    }
    int i = paramArrayOfInt.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfInt[i])
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static int b(short[][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + c(paramArrayOfShort[i]);
      i++;
    }
    return j;
  }
  
  public static int b(short[][][] paramArrayOfShort)
  {
    int i = 0;
    int j = 0;
    while (i != paramArrayOfShort.length)
    {
      j = j * 257 + b(paramArrayOfShort[i]);
      i++;
    }
    return j;
  }
  
  public static l.b.a.l2.a b(String paramString)
  {
    if (paramString.equals("SHA-1")) {
      return new l.b.a.l2.a(l.b.a.h2.a.a, y0.x);
    }
    if (paramString.equals("SHA-224")) {
      return new l.b.a.l2.a(l.b.a.g2.a.f, y0.x);
    }
    if (paramString.equals("SHA-256")) {
      return new l.b.a.l2.a(l.b.a.g2.a.c, y0.x);
    }
    if (paramString.equals("SHA-384")) {
      return new l.b.a.l2.a(l.b.a.g2.a.d, y0.x);
    }
    if (paramString.equals("SHA-512")) {
      return new l.b.a.l2.a(l.b.a.g2.a.e, y0.x);
    }
    throw new IllegalArgumentException(e.a.a.a.a.b("unrecognised digest algorithm: ", paramString));
  }
  
  public static void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 24));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)paramInt1);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      return arrayOfByte;
    }
    throw new NullPointerException("in == null");
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= 0)
        {
          if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
          {
            byte[] arrayOfByte = new byte[paramInt2];
            for (int i = 0; i < paramInt2; i++) {
              arrayOfByte[i] = ((byte)paramArrayOfByte[(paramInt1 + i)]);
            }
            return arrayOfByte;
          }
          throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        throw new IllegalArgumentException("length hast to be >= 0");
      }
      throw new IllegalArgumentException("offset hast to be >= 0");
    }
    throw new NullPointerException("src == null");
  }
  
  public static byte[] b(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length];
    for (int i = 0; i < paramArrayOfShort.length; i++) {
      arrayOfByte[i] = ((byte)(byte)paramArrayOfShort[i]);
    }
    return arrayOfByte;
  }
  
  public static short[][] b(byte[][] paramArrayOfByte)
  {
    short[][] arrayOfShort = new short[paramArrayOfByte.length][paramArrayOfByte[0].length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      for (int j = 0; j < paramArrayOfByte[0].length; j++) {
        arrayOfShort[i][j] = ((short)(short)(paramArrayOfByte[i][j] & 0xFF));
      }
    }
    return arrayOfShort;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j++;
    int k = paramArrayOfByte[j];
    return paramArrayOfByte[(j + 1)] << 24 | i & 0xFF | (paramInt & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static int c(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      return 0;
    }
    int i = paramArrayOfShort.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfShort[i] & 0xFF)
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 5)
    {
      if (paramInt == 6) {
        return "qTESLA-p-III";
      }
      throw new IllegalArgumentException(e.a.a.a.a.a("unknown security category: ", paramInt));
    }
    return "qTESLA-p-I";
  }
  
  public static void c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(byte)paramInt1);
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 8));
    paramInt2++;
    paramArrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(byte)(paramInt1 >>> 24));
  }
  
  public static boolean c(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      if (paramArrayOfByte[i] == null) {
        return true;
      }
    }
    return false;
  }
  
  public static short[] c(byte[] paramArrayOfByte)
  {
    short[] arrayOfShort = new short[paramArrayOfByte.length];
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      arrayOfShort[i] = ((short)(short)(paramArrayOfByte[i] & 0xFF));
    }
    return arrayOfShort;
  }
  
  public static int d(int paramInt)
  {
    int i = 0;
    int j = paramInt;
    for (paramInt = i;; paramInt++)
    {
      j >>= 1;
      if (j == 0) {
        break;
      }
    }
    return paramInt;
  }
  
  public static int d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = paramArrayOfByte.length;
    for (int j = i + 1;; j = j * 257 ^ paramArrayOfByte[i])
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public static long d(byte[] paramArrayOfByte, int paramInt)
  {
    int i = c(paramArrayOfByte, paramInt);
    return (c(paramArrayOfByte, paramInt + 4) & 0xFFFFFFFF) << 32 | i & 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     l.b.c.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */