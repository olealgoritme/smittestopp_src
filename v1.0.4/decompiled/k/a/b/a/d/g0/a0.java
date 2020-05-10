package k.a.b.a.d.g0;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.a.b.a.b.n.k;
import k.a.b.a.b.n.l;
import k.a.b.a.b.n.l.a;
import k.a.b.a.c.r;
import k.a.b.a.d.h.b;
import k.a.b.a.d.z;

public class a0
  extends f
  implements k.a.b.a.d.s, l.a<Integer>, h, h0, c0
{
  public static final int B0 = Integer.getInteger("proton.transport_buffer_release_threshold", 2097152).intValue();
  public static final boolean C0;
  public static final int D0 = Integer.getInteger("proton.trace_frame_payload_length", 1024).intValue();
  public static String E0 = "<-";
  public static String F0 = "->";
  public final k.a.b.a.b.n.s A0;
  public int H;
  public i I;
  public d J;
  public boolean K;
  public boolean L;
  public boolean M;
  public Map<Integer, k0> N;
  public Map<Integer, k0> O;
  public b0 P;
  public f0 Q;
  public r R;
  public k.a.b.a.c.x S;
  public int T;
  public int U;
  public int V;
  public int W;
  public final j X;
  public boolean Y;
  public k.a.b.a.b.n.m Z;
  public v a0;
  public k.a.b.a.d.g0.m0.g b0;
  public final s<p> c0;
  public boolean d0;
  public boolean e0;
  public boolean f0;
  public boolean g0;
  public h h0;
  public boolean i0;
  public boolean j0;
  public boolean k0;
  public boolean l0;
  public boolean m0;
  public int n0;
  public int o0;
  public long p0;
  public long q0;
  public long r0;
  public long s0;
  public long t0;
  public long u0;
  public k.a.b.a.g.g v0;
  public k.a.b.a.g.d w0;
  public List<d0> x0;
  public final k.a.b.a.b.n.g y0;
  public final k z0;
  
  static
  {
    String str = System.getenv("PN_TRACE_FRM");
    boolean bool;
    if ((!"true".equalsIgnoreCase(str)) && (!"1".equals(str)) && (!"yes".equalsIgnoreCase(str))) {
      bool = false;
    } else {
      bool = true;
    }
    C0 = bool;
  }
  
  public a0()
  {
    int i;
    if (C0) {
      i = 2;
    } else {
      i = 0;
    }
    H = i;
    N = new HashMap();
    O = new HashMap();
    Object localObject = new r();
    R = ((r)localObject);
    S = new k.a.b.a.c.x((r)localObject);
    T = -1;
    U = 512;
    V = 0;
    W = 65535;
    c0 = new s(null);
    localObject = k.a.b.a.d.f0.a;
    f0 = true;
    g0 = true;
    h0 = this;
    i0 = false;
    k0 = false;
    l0 = false;
    m0 = false;
    n0 = 0;
    o0 = 0;
    p0 = 0L;
    q0 = 0L;
    r0 = 0L;
    s0 = 0L;
    t0 = 0L;
    u0 = 0L;
    y0 = new k.a.b.a.b.n.g();
    z0 = new k();
    A0 = new k.a.b.a.b.n.s();
    e.c.a.a.b.l.c.a(R, S);
    T = -1;
    X = new j(S, U, (byte)0, this);
  }
  
  public void B() {}
  
  public k.a.b.a.d.v E()
  {
    if (a0 == null) {
      if (!e0)
      {
        W();
        Object localObject = new v(this, U);
        a0 = ((v)localObject);
        b0 localb0 = P;
        f0 localf0 = Q;
        if (localObject != null)
        {
          localObject = new v.a((v)localObject, new v.d((v)localObject, localb0, localf0, null), new o(localf0, localb0));
          P = ((b0)localObject);
          Q = ((f0)localObject);
        }
        else
        {
          throw null;
        }
      }
      else
      {
        throw new IllegalStateException("Sasl can't be initiated after transport has started processing");
      }
    }
    return a0;
  }
  
  public void F() {}
  
  public k.a.b.a.b.n.j L()
  {
    k.a.b.a.b.n.j localj = z;
    if (a == null) {
      localj = null;
    }
    return localj;
  }
  
  public void S() {}
  
  public p V()
  {
    return (p)c0.a;
  }
  
  public final void W()
  {
    if (!d0)
    {
      d0 = true;
      i locali = new i(h0, R, T, this);
      I = locali;
      P = locali;
      Q = new g0(this, T, g0);
    }
  }
  
  public boolean X()
  {
    boolean bool;
    if (((H & 0x2) == 0) && (c0.a == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean Y()
  {
    boolean bool;
    if ((J == null) && (y != k.a.b.a.d.g.UNINITIALIZED)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean Z()
  {
    boolean bool;
    if ((H & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public long a(long paramLong)
  {
    int i = n0;
    long l2;
    if (i > 0)
    {
      l1 = r0;
      if ((l1 != 0L) && (s0 == p0))
      {
        if (l1 - paramLong <= 0L)
        {
          r0 = a(paramLong, i);
          Object localObject1 = J;
          if ((localObject1 != null) && (x != k.a.b.a.d.g.CLOSED))
          {
            localObject1 = new k.a.b.a.b.n.j(k.a.b.a.b.f.a("amqp:resource-limit-exceeded"), "local-idle-timeout expired");
            J.a((k.a.b.a.b.n.j)localObject1);
            J.x = k.a.b.a.d.g.CLOSED;
            Object localObject2;
            if (!K)
            {
              localObject2 = a0;
              if ((localObject2 != null) && (!((v)localObject2).b()))
              {
                v localv = a0;
                localObject2 = v;
                if ((localObject2 != null) && (localObject2 != v.b.CLIENT))
                {
                  m = true;
                }
                else
                {
                  v = v.b.CLIENT;
                  o = true;
                }
                s = true;
                p = k.a.b.a.d.v.a.PN_SASL_SYS;
              }
              localObject2 = new k.a.b.a.b.n.m();
              K = true;
              X.a(0, localObject2, null, null);
            }
            if (!L)
            {
              localObject2 = new k.a.b.a.b.n.c();
              a = ((k.a.b.a.b.n.j)localObject1);
              L = true;
              X.a(0, localObject2, null, null);
            }
            close_tail();
          }
        }
      }
      else
      {
        r0 = a(paramLong, n0);
        s0 = p0;
      }
      l2 = r0;
    }
    else
    {
      l2 = 0L;
    }
    i = o0;
    long l1 = l2;
    if (i != 0)
    {
      l1 = l2;
      if (!L)
      {
        l1 = u0;
        if ((l1 != 0L) && (t0 == q0))
        {
          if (l1 - paramLong <= 0L)
          {
            u0 = a(paramLong, i / 2);
            if (pending() == 0)
            {
              X.a(0, null, null, null);
              t0 += pending();
            }
          }
        }
        else
        {
          u0 = a(paramLong, o0 / 2);
          t0 = q0;
        }
        if (l2 == 0L)
        {
          l1 = u0;
        }
        else
        {
          paramLong = u0;
          l1 = r0;
          if (paramLong - l1 <= 0L) {
            l1 = paramLong;
          }
        }
      }
    }
    return l1;
  }
  
  public final long a(long paramLong1, long paramLong2)
  {
    paramLong1 += paramLong2;
    if (paramLong1 == 0L) {
      paramLong1 = 1L;
    }
    return paramLong1;
  }
  
  public final e0<?> a(m paramm)
  {
    e0 locale0 = paramm.V();
    Object localObject = locale0;
    if (locale0 == null) {
      if ((paramm instanceof q))
      {
        paramm = (q)paramm;
        localObject = new i0(paramm);
        a0 = ((i0)localObject);
      }
      else
      {
        paramm = (x)paramm;
        localObject = new j0(paramm);
        a0 = ((j0)localObject);
      }
    }
    return (e0<?>)localObject;
  }
  
  public final k0 a(y paramy)
  {
    k0 localk01 = L;
    k0 localk02 = localk01;
    if (localk01 == null)
    {
      localk02 = new k0(this, paramy);
      L = localk02;
    }
    return localk02;
  }
  
  public z a(k.a.b.a.d.a0 parama0)
  {
    if (b0 == null)
    {
      W();
      parama0 = new k.a.b.a.d.g0.m0.g(parama0, null);
      b0 = parama0;
      parama0 = parama0.wrap(P, Q);
      P = parama0;
      Q = parama0;
    }
    return b0;
  }
  
  public final void a(String paramString, int paramInt, Object paramObject, k.a.b.a.b.a parama)
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("[");
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramObject);
    if (parama != null)
    {
      localStringBuilder.append(" (");
      localStringBuilder.append(c);
      localStringBuilder.append(") ");
      int i = D0;
      paramString = a;
      int j = c;
      int k = b;
      paramObject = e.a.a.a.a.a("\"");
      int m = 0;
      int n = 0;
      paramInt = 0;
      for (;;)
      {
        i1 = m;
        if (n >= j) {
          break label242;
        }
        byte b = paramString[(k + n)];
        if ((b > 31) && (b < Byte.MAX_VALUE) && (b != 92))
        {
          paramInt++;
          if (paramInt > i) {
            break;
          }
          ((StringBuilder)paramObject).append((char)b);
        }
        else
        {
          paramInt += 4;
          if (paramInt > i) {
            break;
          }
          ((StringBuilder)paramObject).append(String.format("\\x%02x", new Object[] { Byte.valueOf(b) }));
        }
        n++;
      }
      int i1 = 1;
      label242:
      ((StringBuilder)paramObject).append("\"");
      if (i1 != 0) {
        ((StringBuilder)paramObject).append("...(truncated)");
      }
      localStringBuilder.append(((StringBuilder)paramObject).toString());
    }
    System.out.println(localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (Z()) {
      a(paramString1, 0, paramString2, null);
    }
  }
  
  public void a(k.a.b.a.b.n.j paramj)
  {
    super.a(paramj);
    boolean bool;
    if ((paramj != null) && (a != null)) {
      bool = true;
    } else {
      bool = false;
    }
    j0 = bool;
  }
  
  public void a(k.a.b.a.d.d0 paramd0)
  {
    if ((!Y) || (paramd0 != null))
    {
      if (!j0)
      {
        if (paramd0 == null) {
          paramd0 = "connection aborted";
        } else {
          paramd0 = paramd0.toString();
        }
        a(new k.a.b.a.b.n.j(k.a.b.a.b.n.d.a, paramd0));
      }
      i0 = true;
    }
    if ((j0) && (!m0))
    {
      a(h.b.TRANSPORT_ERROR, this);
      m0 = true;
    }
    if (!l0)
    {
      a(h.b.TRANSPORT_TAIL_CLOSED, this);
      l0 = true;
      if (k0) {
        a(h.b.TRANSPORT_CLOSED, this);
      }
    }
  }
  
  public void a(d0 paramd0)
  {
    if (!e0)
    {
      if (x0 == null) {
        x0 = new ArrayList();
      }
      if (!x0.contains(paramd0))
      {
        W();
        l0 locall0 = paramd0.wrap(P, Q);
        P = locall0;
        Q = locall0;
        x0.add(paramd0);
      }
      return;
    }
    throw new IllegalStateException("Additional layer can't be added after transport has started processing");
  }
  
  public final void a(k0 paramk0, e0 parame0)
  {
    k localk = z0;
    a = j;
    localk.b(i);
    paramk0.d();
    z0.a(g);
    z0.c(h);
    localk = z0;
    k = null;
    if (parame0 != null)
    {
      e = a;
      f = d;
      g = e;
      i = f.X;
    }
    else
    {
      e = null;
      f = null;
      g = null;
      i = false;
    }
    int i = c;
    paramk0 = z0;
    X.a(i, paramk0, null, null);
  }
  
  public void a(h.b paramb, Object paramObject)
  {
    Object localObject = J;
    if (localObject != null)
    {
      localObject = X;
      if (localObject != null) {
        ((c)localObject).a(paramb, paramObject);
      }
    }
  }
  
  public boolean a(k.a.b.a.e.a parama)
  {
    if (Y())
    {
      localObject = E0;
      if (Z()) {
        a((String)localObject, a, b, c);
      }
      localObject = (p)c0.a;
      if (localObject != null) {
        ((p)localObject).b(parama);
      }
      b.a(this, c, Integer.valueOf(a));
      return Y;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Transport cannot accept frame: ");
    ((StringBuilder)localObject).append(parama);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void b(k.a.b.a.d.c paramc)
  {
    J = ((d)paramc);
    a(h.b.CONNECTION_BOUND, paramc);
    paramc = J;
    R = this;
    paramc.w();
    if (y != k.a.b.a.d.g.UNINITIALIZED)
    {
      paramc = J;
      Object localObject = Z;
      if (paramc != null)
      {
        y = k.a.b.a.d.g.ACTIVE;
        localObject = b;
        paramc.a(h.b.CONNECTION_REMOTE_OPEN, paramc);
        localObject = y;
        paramc = k.a.b.a.d.g.CLOSED;
        if (localObject == paramc) {
          J.y = paramc;
        }
        paramc = I;
        paramc.a();
        if (l == null) {
          paramc.process();
        }
      }
      else
      {
        throw null;
      }
    }
  }
  
  public final boolean b(y paramy)
  {
    if (J == null) {
      return false;
    }
    if ((!Y) && ((paramy == null) || (!L.s))) {
      for (f localf = J.J; localf != null; localf = C) {
        if ((localf instanceof x))
        {
          x localx = (x)localf;
          if (((paramy == null) || (H == paramy)) && (Q != 0) && (!ah)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  public final void b0()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 322	k/a/b/a/d/g0/a0:J	Lk/a/b/a/d/g0/d;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +1247 -> 1253
    //   9: aload_0
    //   10: getfield 358	k/a/b/a/d/g0/a0:K	Z
    //   13: ifeq +1240 -> 1253
    //   16: aload_0
    //   17: getfield 396	k/a/b/a/d/g0/a0:L	Z
    //   20: ifne +1233 -> 1253
    //   23: aload_1
    //   24: getfield 729	k/a/b/a/d/g0/d:S	Lk/a/b/a/d/g0/e;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +1224 -> 1253
    //   32: aload_1
    //   33: getfield 733	k/a/b/a/d/g0/e:H	Lk/a/b/a/d/g0/m;
    //   36: astore_2
    //   37: aload_2
    //   38: instanceof 425
    //   41: istore_3
    //   42: iconst_1
    //   43: istore 4
    //   45: iconst_0
    //   46: istore 5
    //   48: iconst_0
    //   49: istore 6
    //   51: iload_3
    //   52: ifeq +1015 -> 1067
    //   55: aload_2
    //   56: checkcast 425	k/a/b/a/d/g0/x
    //   59: astore 7
    //   61: aload 7
    //   63: getfield 433	k/a/b/a/d/g0/x:a0	Lk/a/b/a/d/g0/j0;
    //   66: astore 8
    //   68: aload 7
    //   70: getfield 717	k/a/b/a/d/g0/m:H	Lk/a/b/a/d/g0/y;
    //   73: astore 9
    //   75: aload 9
    //   77: getfield 441	k/a/b/a/d/g0/y:L	Lk/a/b/a/d/g0/k0;
    //   80: astore 10
    //   82: aload_1
    //   83: getfield 735	k/a/b/a/d/g0/e:S	Z
    //   86: istore_3
    //   87: iload_3
    //   88: ifne +758 -> 846
    //   91: aload_1
    //   92: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   95: astore_2
    //   96: aload_2
    //   97: ifnonnull +9 -> 106
    //   100: iconst_0
    //   101: istore 11
    //   103: goto +11 -> 114
    //   106: aload_2
    //   107: invokeinterface 742 1 0
    //   112: istore 11
    //   114: iload 11
    //   116: ifgt +12 -> 128
    //   119: aload_1
    //   120: aload 7
    //   122: getfield 744	k/a/b/a/d/g0/m:K	Lk/a/b/a/d/g0/e;
    //   125: if_acmpeq +721 -> 846
    //   128: aload 10
    //   130: getfield 746	k/a/b/a/d/g0/k0:o	Lk/a/b/a/b/h;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnonnull +6 -> 141
    //   138: goto +19 -> 157
    //   141: aload_2
    //   142: getstatic 750	k/a/b/a/b/h:z	Lk/a/b/a/b/h;
    //   145: invokevirtual 753	k/a/b/a/b/h:b	(Lk/a/b/a/b/h;)I
    //   148: ifle +9 -> 157
    //   151: iconst_1
    //   152: istore 11
    //   154: goto +6 -> 160
    //   157: iconst_0
    //   158: istore 11
    //   160: iload 11
    //   162: ifeq +684 -> 846
    //   165: aload 8
    //   167: getfield 629	k/a/b/a/d/g0/e0:e	Lk/a/b/a/b/h;
    //   170: getstatic 750	k/a/b/a/b/h:z	Lk/a/b/a/b/h;
    //   173: invokevirtual 753	k/a/b/a/b/h:b	(Lk/a/b/a/b/h;)I
    //   176: ifle +9 -> 185
    //   179: iconst_1
    //   180: istore 11
    //   182: goto +6 -> 188
    //   185: iconst_0
    //   186: istore 11
    //   188: iload 11
    //   190: ifeq +656 -> 846
    //   193: aload 10
    //   195: invokevirtual 755	k/a/b/a/d/g0/k0:a	()Z
    //   198: ifeq +648 -> 846
    //   201: aload 8
    //   203: getfield 620	k/a/b/a/d/g0/e0:a	Lk/a/b/a/b/h;
    //   206: ifnull +640 -> 846
    //   209: aload_0
    //   210: getfield 248	k/a/b/a/d/g0/a0:X	Lk/a/b/a/d/g0/j;
    //   213: astore_2
    //   214: aload_2
    //   215: getfield 758	k/a/b/a/d/g0/j:c	Lk/a/b/a/d/g0/k;
    //   218: getfield 761	k/a/b/a/d/g0/k:b	I
    //   221: aload_2
    //   222: getfield 763	k/a/b/a/d/g0/j:f	I
    //   225: if_icmple +9 -> 234
    //   228: iconst_1
    //   229: istore 11
    //   231: goto +6 -> 237
    //   234: iconst_0
    //   235: istore 11
    //   237: iload 11
    //   239: ifne +607 -> 846
    //   242: aload 8
    //   244: getfield 765	k/a/b/a/d/g0/j0:j	Lk/a/b/a/d/g0/e;
    //   247: astore_2
    //   248: aload_2
    //   249: ifnull +15 -> 264
    //   252: aload_2
    //   253: aload_1
    //   254: if_acmpeq +10 -> 264
    //   257: iload 5
    //   259: istore 11
    //   261: goto +785 -> 1046
    //   264: aload_1
    //   265: getfield 768	k/a/b/a/d/g0/e:P	Lk/a/b/a/d/g0/z;
    //   268: astore_2
    //   269: aload_2
    //   270: ifnull +11 -> 281
    //   273: aload_2
    //   274: getfield 771	k/a/b/a/d/g0/z:a	Lk/a/b/a/b/h;
    //   277: astore_2
    //   278: goto +21 -> 299
    //   281: aload 10
    //   283: getfield 772	k/a/b/a/d/g0/k0:f	Lk/a/b/a/b/h;
    //   286: astore_2
    //   287: aload 10
    //   289: aload_2
    //   290: getstatic 775	k/a/b/a/b/h:A	Lk/a/b/a/b/h;
    //   293: invokevirtual 778	k/a/b/a/b/h:a	(Lk/a/b/a/b/h;)Lk/a/b/a/b/h;
    //   296: putfield 772	k/a/b/a/d/g0/k0:f	Lk/a/b/a/b/h;
    //   299: aload_1
    //   300: new 770	k/a/b/a/d/g0/z
    //   303: dup
    //   304: aload_2
    //   305: aload_1
    //   306: aload 8
    //   308: invokespecial 781	k/a/b/a/d/g0/z:<init>	(Lk/a/b/a/b/h;Lk/a/b/a/d/g0/e;Lk/a/b/a/d/g0/e0;)V
    //   311: putfield 768	k/a/b/a/d/g0/e:P	Lk/a/b/a/d/g0/z;
    //   314: aload_0
    //   315: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   318: astore 12
    //   320: aload 12
    //   322: aload_2
    //   323: putfield 783	k/a/b/a/b/n/s:b	Lk/a/b/a/b/h;
    //   326: aload 12
    //   328: new 491	k/a/b/a/b/a
    //   331: dup
    //   332: aload_1
    //   333: getfield 786	k/a/b/a/d/g0/e:G	[B
    //   336: invokespecial 789	k/a/b/a/b/a:<init>	([B)V
    //   339: putfield 790	k/a/b/a/b/n/s:c	Lk/a/b/a/b/a;
    //   342: aload_0
    //   343: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   346: aload 8
    //   348: getfield 620	k/a/b/a/d/g0/e0:a	Lk/a/b/a/b/h;
    //   351: invokevirtual 791	k/a/b/a/b/n/s:a	(Lk/a/b/a/b/h;)V
    //   354: aload_0
    //   355: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   358: astore 13
    //   360: aload 13
    //   362: aconst_null
    //   363: putfield 794	k/a/b/a/b/n/s:g	Lk/a/b/a/b/n/n;
    //   366: aload 13
    //   368: iconst_0
    //   369: putfield 795	k/a/b/a/b/n/s:i	Z
    //   372: aload 13
    //   374: iconst_0
    //   375: putfield 797	k/a/b/a/b/n/s:j	Z
    //   378: aload 13
    //   380: iconst_0
    //   381: putfield 799	k/a/b/a/b/n/s:k	Z
    //   384: aload_1
    //   385: getfield 802	k/a/b/a/d/g0/e:I	Lk/a/b/a/b/n/e;
    //   388: astore 12
    //   390: aload 12
    //   392: ifnull +13 -> 405
    //   395: aload 13
    //   397: aload 12
    //   399: putfield 804	k/a/b/a/b/n/s:h	Lk/a/b/a/b/n/e;
    //   402: goto +9 -> 411
    //   405: aload 13
    //   407: aconst_null
    //   408: putfield 804	k/a/b/a/b/n/s:h	Lk/a/b/a/b/n/e;
    //   411: aload_1
    //   412: getfield 806	k/a/b/a/d/g0/e:J	Z
    //   415: ifeq +16 -> 431
    //   418: aload_0
    //   419: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   422: getstatic 812	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   425: putfield 814	k/a/b/a/b/n/s:e	Ljava/lang/Boolean;
    //   428: goto +26 -> 454
    //   431: aload_0
    //   432: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   435: getstatic 817	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   438: putfield 814	k/a/b/a/b/n/s:e	Ljava/lang/Boolean;
    //   441: aload 10
    //   443: getfield 820	k/a/b/a/d/g0/k0:q	Ljava/util/Map;
    //   446: aload_2
    //   447: aload_1
    //   448: invokeinterface 826 3 0
    //   453: pop
    //   454: aload 7
    //   456: getfield 744	k/a/b/a/d/g0/m:K	Lk/a/b/a/d/g0/e;
    //   459: aload_1
    //   460: if_acmpne +14 -> 474
    //   463: aload_0
    //   464: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   467: iconst_1
    //   468: putfield 677	k/a/b/a/b/n/s:f	Z
    //   471: goto +11 -> 482
    //   474: aload_0
    //   475: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   478: iconst_0
    //   479: putfield 677	k/a/b/a/b/n/s:f	Z
    //   482: aload_1
    //   483: getfield 828	k/a/b/a/d/g0/e:N	I
    //   486: istore 11
    //   488: iload 11
    //   490: ifne +16 -> 506
    //   493: aload_0
    //   494: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   497: getstatic 750	k/a/b/a/b/h:z	Lk/a/b/a/b/h;
    //   500: putfield 829	k/a/b/a/b/n/s:d	Lk/a/b/a/b/h;
    //   503: goto +15 -> 518
    //   506: aload_0
    //   507: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   510: iload 11
    //   512: invokestatic 832	k/a/b/a/b/h:a	(I)Lk/a/b/a/b/h;
    //   515: putfield 829	k/a/b/a/b/n/s:d	Lk/a/b/a/b/h;
    //   518: aload_1
    //   519: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   522: astore 12
    //   524: aload 12
    //   526: astore_2
    //   527: aload 12
    //   529: ifnonnull +7 -> 536
    //   532: getstatic 834	k/a/b/a/d/g0/e:V	Lk/a/b/a/c/k0;
    //   535: astore_2
    //   536: aload_2
    //   537: invokeinterface 742 1 0
    //   542: istore 5
    //   544: aload 10
    //   546: getfield 638	k/a/b/a/d/g0/k0:c	I
    //   549: istore 11
    //   551: aload_0
    //   552: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   555: astore 13
    //   557: new 836	k/a/b/a/d/g0/a
    //   560: astore 12
    //   562: aload 12
    //   564: aload_0
    //   565: invokespecial 839	k/a/b/a/d/g0/a:<init>	(Lk/a/b/a/d/g0/a0;)V
    //   568: aload_0
    //   569: getfield 248	k/a/b/a/d/g0/a0:X	Lk/a/b/a/d/g0/j;
    //   572: iload 11
    //   574: aload 13
    //   576: aload_2
    //   577: aload 12
    //   579: invokevirtual 394	k/a/b/a/d/g0/j:a	(ILjava/lang/Object;Lk/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   582: aload_1
    //   583: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   586: astore 12
    //   588: aload 12
    //   590: ifnull +31 -> 621
    //   593: aload 12
    //   595: invokeinterface 843 1 0
    //   600: pop
    //   601: aload_1
    //   602: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   605: invokeinterface 844 1 0
    //   610: ifne +11 -> 621
    //   613: aload_1
    //   614: aload_1
    //   615: getfield 847	k/a/b/a/d/g0/e:T	Lk/a/b/a/c/l;
    //   618: putfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   621: aload 10
    //   623: aload 10
    //   625: getfield 598	k/a/b/a/d/g0/k0:i	Lk/a/b/a/b/h;
    //   628: getstatic 775	k/a/b/a/b/h:A	Lk/a/b/a/b/h;
    //   631: invokevirtual 778	k/a/b/a/b/h:a	(Lk/a/b/a/b/h;)Lk/a/b/a/b/h;
    //   634: putfield 598	k/a/b/a/d/g0/k0:i	Lk/a/b/a/b/h;
    //   637: aload 10
    //   639: aload 10
    //   641: getfield 746	k/a/b/a/d/g0/k0:o	Lk/a/b/a/b/h;
    //   644: getstatic 775	k/a/b/a/b/h:A	Lk/a/b/a/b/h;
    //   647: invokevirtual 849	k/a/b/a/b/h:c	(Lk/a/b/a/b/h;)Lk/a/b/a/b/h;
    //   650: putfield 746	k/a/b/a/d/g0/k0:o	Lk/a/b/a/b/h;
    //   653: aload_2
    //   654: invokeinterface 844 1 0
    //   659: ifne +91 -> 750
    //   662: aload 9
    //   664: iload 5
    //   666: ineg
    //   667: invokevirtual 852	k/a/b/a/d/g0/y:c	(I)V
    //   670: aload_0
    //   671: getfield 236	k/a/b/a/d/g0/a0:A0	Lk/a/b/a/b/n/s;
    //   674: getfield 677	k/a/b/a/b/n/s:f	Z
    //   677: ifne +94 -> 771
    //   680: aload 8
    //   682: aconst_null
    //   683: putfield 765	k/a/b/a/d/g0/j0:j	Lk/a/b/a/d/g0/e;
    //   686: aload_1
    //   687: iconst_1
    //   688: putfield 735	k/a/b/a/d/g0/e:S	Z
    //   691: aload 8
    //   693: aload 8
    //   695: getfield 625	k/a/b/a/d/g0/e0:d	Lk/a/b/a/b/h;
    //   698: getstatic 775	k/a/b/a/b/h:A	Lk/a/b/a/b/h;
    //   701: invokevirtual 778	k/a/b/a/b/h:a	(Lk/a/b/a/b/h;)Lk/a/b/a/b/h;
    //   704: putfield 625	k/a/b/a/d/g0/e0:d	Lk/a/b/a/b/h;
    //   707: aload 8
    //   709: aload 8
    //   711: getfield 629	k/a/b/a/d/g0/e0:e	Lk/a/b/a/b/h;
    //   714: getstatic 775	k/a/b/a/b/h:A	Lk/a/b/a/b/h;
    //   717: invokevirtual 849	k/a/b/a/b/h:c	(Lk/a/b/a/b/h;)Lk/a/b/a/b/h;
    //   720: putfield 629	k/a/b/a/d/g0/e0:e	Lk/a/b/a/b/h;
    //   723: aload 9
    //   725: aload 9
    //   727: getfield 853	k/a/b/a/d/g0/y:Q	I
    //   730: iconst_1
    //   731: isub
    //   732: putfield 853	k/a/b/a/d/g0/y:Q	I
    //   735: aload 7
    //   737: aload 7
    //   739: getfield 719	k/a/b/a/d/g0/m:Q	I
    //   742: iconst_1
    //   743: isub
    //   744: putfield 719	k/a/b/a/d/g0/m:Q	I
    //   747: goto +24 -> 771
    //   750: aload 9
    //   752: iload 5
    //   754: aload_2
    //   755: invokeinterface 742 1 0
    //   760: isub
    //   761: ineg
    //   762: invokevirtual 852	k/a/b/a/d/g0/y:c	(I)V
    //   765: aload 8
    //   767: aload_1
    //   768: putfield 765	k/a/b/a/d/g0/j0:j	Lk/a/b/a/d/g0/e;
    //   771: aload_0
    //   772: getfield 193	k/a/b/a/d/g0/a0:f0	Z
    //   775: ifeq +71 -> 846
    //   778: aload 7
    //   780: getfield 338	k/a/b/a/d/g0/f:x	Lk/a/b/a/d/g;
    //   783: getstatic 341	k/a/b/a/d/g:CLOSED	Lk/a/b/a/d/g;
    //   786: if_acmpeq +60 -> 846
    //   789: aload_0
    //   790: getfield 322	k/a/b/a/d/g0/a0:J	Lk/a/b/a/d/g0/d;
    //   793: getstatic 856	k/a/b/a/d/h$b:LINK_FLOW	Lk/a/b/a/d/h$b;
    //   796: aload 7
    //   798: invokevirtual 700	k/a/b/a/d/g0/d:a	(Lk/a/b/a/d/h$b;Ljava/lang/Object;)Lk/a/b/a/d/g0/g;
    //   801: pop
    //   802: goto +44 -> 846
    //   805: astore 12
    //   807: aload_1
    //   808: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   811: astore_2
    //   812: aload_2
    //   813: ifnull +30 -> 843
    //   816: aload_2
    //   817: invokeinterface 843 1 0
    //   822: pop
    //   823: aload_1
    //   824: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   827: invokeinterface 844 1 0
    //   832: ifne +11 -> 843
    //   835: aload_1
    //   836: aload_1
    //   837: getfield 847	k/a/b/a/d/g0/e:T	Lk/a/b/a/c/l;
    //   840: putfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   843: aload 12
    //   845: athrow
    //   846: iload_3
    //   847: ifeq +112 -> 959
    //   850: aload_1
    //   851: getfield 802	k/a/b/a/d/g0/e:I	Lk/a/b/a/b/n/e;
    //   854: ifnull +105 -> 959
    //   857: aload_1
    //   858: getfield 768	k/a/b/a/d/g0/e:P	Lk/a/b/a/d/g0/z;
    //   861: astore_2
    //   862: aload_0
    //   863: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   866: aload_2
    //   867: getfield 771	k/a/b/a/d/g0/z:a	Lk/a/b/a/b/h;
    //   870: invokevirtual 857	k/a/b/a/b/n/g:a	(Lk/a/b/a/b/h;)V
    //   873: aload_0
    //   874: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   877: astore 12
    //   879: aload 12
    //   881: aload_2
    //   882: getfield 771	k/a/b/a/d/g0/z:a	Lk/a/b/a/b/h;
    //   885: putfield 859	k/a/b/a/b/n/g:c	Lk/a/b/a/b/h;
    //   888: aload 12
    //   890: getstatic 865	k/a/b/a/b/n/o:SENDER	Lk/a/b/a/b/n/o;
    //   893: invokevirtual 868	k/a/b/a/b/n/g:a	(Lk/a/b/a/b/n/o;)V
    //   896: aload_0
    //   897: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   900: astore 12
    //   902: aload_1
    //   903: getfield 806	k/a/b/a/d/g0/e:J	Z
    //   906: istore_3
    //   907: aload 12
    //   909: iload_3
    //   910: putfield 870	k/a/b/a/b/n/g:d	Z
    //   913: aload 12
    //   915: iconst_0
    //   916: putfield 871	k/a/b/a/b/n/g:f	Z
    //   919: iload_3
    //   920: ifeq +7 -> 927
    //   923: aload_2
    //   924: invokevirtual 872	k/a/b/a/d/g0/z:a	()V
    //   927: aload_0
    //   928: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   931: astore_2
    //   932: aload_2
    //   933: aload_1
    //   934: getfield 802	k/a/b/a/d/g0/e:I	Lk/a/b/a/b/n/e;
    //   937: putfield 874	k/a/b/a/b/n/g:e	Lk/a/b/a/b/n/e;
    //   940: aload 10
    //   942: getfield 638	k/a/b/a/d/g0/k0:c	I
    //   945: istore 11
    //   947: aload_0
    //   948: getfield 248	k/a/b/a/d/g0/a0:X	Lk/a/b/a/d/g0/j;
    //   951: iload 11
    //   953: aload_2
    //   954: aconst_null
    //   955: aconst_null
    //   956: invokevirtual 394	k/a/b/a/d/g0/j:a	(ILjava/lang/Object;Lk/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   959: aload_1
    //   960: getfield 875	k/a/b/a/d/g0/e:K	Z
    //   963: ifeq +10 -> 973
    //   966: iload 6
    //   968: istore 11
    //   970: goto +70 -> 1040
    //   973: iload 6
    //   975: istore 11
    //   977: aload_1
    //   978: getfield 733	k/a/b/a/d/g0/e:H	Lk/a/b/a/d/g0/m;
    //   981: instanceof 425
    //   984: ifeq +56 -> 1040
    //   987: aload_1
    //   988: getfield 735	k/a/b/a/d/g0/e:S	Z
    //   991: ifeq +10 -> 1001
    //   994: iload 6
    //   996: istore 11
    //   998: goto +42 -> 1040
    //   1001: aload_1
    //   1002: getfield 738	k/a/b/a/d/g0/e:U	Lk/a/b/a/c/k0;
    //   1005: astore_2
    //   1006: aload_2
    //   1007: ifnull +13 -> 1020
    //   1010: aload_2
    //   1011: invokeinterface 844 1 0
    //   1016: istore_3
    //   1017: goto +5 -> 1022
    //   1020: iconst_0
    //   1021: istore_3
    //   1022: aload_1
    //   1023: getfield 877	k/a/b/a/d/g0/e:Q	Z
    //   1026: ifne +11 -> 1037
    //   1029: iload 6
    //   1031: istore 11
    //   1033: iload_3
    //   1034: ifeq +6 -> 1040
    //   1037: iconst_1
    //   1038: istore 11
    //   1040: iload 11
    //   1042: iconst_1
    //   1043: ixor
    //   1044: istore 11
    //   1046: iload 11
    //   1048: ifeq +11 -> 1059
    //   1051: aload_1
    //   1052: invokevirtual 880	k/a/b/a/d/g0/e:i	()Lk/a/b/a/d/g0/e;
    //   1055: astore_1
    //   1056: goto -1028 -> 28
    //   1059: aload_1
    //   1060: getfield 882	k/a/b/a/d/g0/e:C	Lk/a/b/a/d/g0/e;
    //   1063: astore_1
    //   1064: goto -1036 -> 28
    //   1067: aload_2
    //   1068: checkcast 415	k/a/b/a/d/g0/q
    //   1071: astore 12
    //   1073: aload_1
    //   1074: getfield 768	k/a/b/a/d/g0/e:P	Lk/a/b/a/d/g0/z;
    //   1077: astore_2
    //   1078: aload 12
    //   1080: getfield 717	k/a/b/a/d/g0/m:H	Lk/a/b/a/d/g0/y;
    //   1083: getfield 441	k/a/b/a/d/g0/y:L	Lk/a/b/a/d/g0/k0;
    //   1086: astore 12
    //   1088: aload 12
    //   1090: invokevirtual 755	k/a/b/a/d/g0/k0:a	()Z
    //   1093: ifeq +136 -> 1229
    //   1096: aload_1
    //   1097: getfield 806	k/a/b/a/d/g0/e:J	Z
    //   1100: istore_3
    //   1101: aload_1
    //   1102: getfield 802	k/a/b/a/d/g0/e:I	Lk/a/b/a/b/n/e;
    //   1105: astore 10
    //   1107: aload_0
    //   1108: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   1111: aload_2
    //   1112: getfield 771	k/a/b/a/d/g0/z:a	Lk/a/b/a/b/h;
    //   1115: invokevirtual 857	k/a/b/a/b/n/g:a	(Lk/a/b/a/b/h;)V
    //   1118: aload_0
    //   1119: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   1122: astore 9
    //   1124: aload 9
    //   1126: aload_2
    //   1127: getfield 771	k/a/b/a/d/g0/z:a	Lk/a/b/a/b/h;
    //   1130: putfield 859	k/a/b/a/b/n/g:c	Lk/a/b/a/b/h;
    //   1133: aload 9
    //   1135: getstatic 885	k/a/b/a/b/n/o:RECEIVER	Lk/a/b/a/b/n/o;
    //   1138: invokevirtual 868	k/a/b/a/b/n/g:a	(Lk/a/b/a/b/n/o;)V
    //   1141: aload_0
    //   1142: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   1145: astore 9
    //   1147: aload 9
    //   1149: iload_3
    //   1150: putfield 870	k/a/b/a/b/n/g:d	Z
    //   1153: aload 9
    //   1155: aload 10
    //   1157: putfield 874	k/a/b/a/b/n/g:e	Lk/a/b/a/b/n/e;
    //   1160: aload 9
    //   1162: iconst_0
    //   1163: putfield 871	k/a/b/a/b/n/g:f	Z
    //   1166: aload 10
    //   1168: ifnonnull +16 -> 1184
    //   1171: iload_3
    //   1172: ifeq +12 -> 1184
    //   1175: aload 9
    //   1177: aload_1
    //   1178: getfield 887	k/a/b/a/d/g0/e:M	Lk/a/b/a/b/n/e;
    //   1181: putfield 874	k/a/b/a/b/n/g:e	Lk/a/b/a/b/n/e;
    //   1184: aload 12
    //   1186: getfield 638	k/a/b/a/d/g0/k0:c	I
    //   1189: istore 11
    //   1191: aload_0
    //   1192: getfield 226	k/a/b/a/d/g0/a0:y0	Lk/a/b/a/b/n/g;
    //   1195: astore 12
    //   1197: aload_0
    //   1198: getfield 248	k/a/b/a/d/g0/a0:X	Lk/a/b/a/d/g0/j;
    //   1201: iload 11
    //   1203: aload 12
    //   1205: aconst_null
    //   1206: aconst_null
    //   1207: invokevirtual 394	k/a/b/a/d/g0/j:a	(ILjava/lang/Object;Lk/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   1210: iload 4
    //   1212: istore 11
    //   1214: iload_3
    //   1215: ifeq +17 -> 1232
    //   1218: aload_2
    //   1219: invokevirtual 872	k/a/b/a/d/g0/z:a	()V
    //   1222: iload 4
    //   1224: istore 11
    //   1226: goto +6 -> 1232
    //   1229: iconst_0
    //   1230: istore 11
    //   1232: iload 11
    //   1234: ifeq +11 -> 1245
    //   1237: aload_1
    //   1238: invokevirtual 880	k/a/b/a/d/g0/e:i	()Lk/a/b/a/d/g0/e;
    //   1241: astore_1
    //   1242: goto -1214 -> 28
    //   1245: aload_1
    //   1246: getfield 882	k/a/b/a/d/g0/e:C	Lk/a/b/a/d/g0/e;
    //   1249: astore_1
    //   1250: goto -1222 -> 28
    //   1253: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1254	0	this	a0
    //   4	1246	1	localObject1	Object
    //   36	1183	2	localObject2	Object
    //   41	1174	3	bool	boolean
    //   43	1180	4	i	int
    //   46	715	5	j	int
    //   49	981	6	k	int
    //   59	738	7	localx	x
    //   66	700	8	localj0	j0
    //   73	1103	9	localObject3	Object
    //   80	1087	10	localObject4	Object
    //   101	1132	11	m	int
    //   318	276	12	localObject5	Object
    //   805	39	12	localObject6	Object
    //   877	327	12	localObject7	Object
    //   358	217	13	locals	k.a.b.a.b.n.s
    // Exception table:
    //   from	to	target	type
    //   544	582	805	finally
  }
  
  public int capacity()
  {
    W();
    return P.capacity();
  }
  
  public void close_head()
  {
    Q.close_head();
  }
  
  public void close_tail()
  {
    W();
    P.close_tail();
  }
  
  public ByteBuffer head()
  {
    W();
    return Q.head();
  }
  
  public boolean m()
  {
    int i = pending();
    int j = capacity();
    boolean bool;
    if ((i == -1) && (j == -1)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void n() {}
  
  public d o()
  {
    return J;
  }
  
  public int pending()
  {
    W();
    return Q.pending();
  }
  
  public void pop(int paramInt)
  {
    W();
    Q.pop(paramInt);
    q0 += paramInt;
    if ((pending() < 0) && (!k0))
    {
      a(h.b.TRANSPORT_HEAD_CLOSED, this);
      k0 = true;
      if (l0) {
        a(h.b.TRANSPORT_CLOSED, this);
      }
    }
  }
  
  public void process()
  {
    e0 = true;
    try
    {
      W();
      int i = P.position();
      P.process();
      p0 += i - P.position();
      return;
    }
    catch (k.a.b.a.d.d0 locald0)
    {
      i0 = true;
      throw locald0;
    }
  }
  
  public ByteBuffer tail()
  {
    W();
    return P.tail();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("TransportImpl [_connectionEndpoint=");
    localStringBuilder.append(J);
    localStringBuilder.append(", ");
    return e.a.a.a.a.a(localStringBuilder, super.toString(), "]");
  }
  
  public void v()
  {
    Object localObject1 = O.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k0)((Iterator)localObject1).next();
      ((k0)localObject2).b();
      ((k0)localObject2).c();
    }
    localObject1 = N.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k0)((Iterator)localObject1).next();
      ((k0)localObject2).b();
      ((k0)localObject2).c();
    }
    a(h.b.CONNECTION_UNBOUND, J);
    localObject1 = J;
    Object localObject2 = H;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        y localy = (y)((Iterator)localObject2).next();
        Iterator localIterator = I.values().iterator();
        while (localIterator.hasNext()) {
          ((x)localIterator.next()).c(true);
        }
        localIterator = J.values().iterator();
        while (localIterator.hasNext()) {
          ((q)localIterator.next()).c(true);
        }
        localy.c(true);
      }
    }
    if (!G) {
      ((f)localObject1).c(true);
    }
    localObject1 = J;
    R = null;
    ((f)localObject1).i();
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */