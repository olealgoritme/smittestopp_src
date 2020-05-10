package l.a.b.a.d.g0;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l.a.b.a.b.n.k;
import l.a.b.a.b.n.l;
import l.a.b.a.b.n.l.a;
import l.a.b.a.c.r;
import l.a.b.a.d.h.b;
import l.a.b.a.d.z;

public class a0
  extends f
  implements l.a.b.a.d.s, l.a<Integer>, h, h0, c0
{
  public static final int B0 = Integer.getInteger("proton.transport_buffer_release_threshold", 2097152).intValue();
  public static final boolean C0;
  public static final int D0 = Integer.getInteger("proton.trace_frame_payload_length", 1024).intValue();
  public static String E0 = "<-";
  public static String F0 = "->";
  public final l.a.b.a.b.n.s A0;
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
  public l.a.b.a.c.x S;
  public int T;
  public int U;
  public int V;
  public int W;
  public final j X;
  public boolean Y;
  public l.a.b.a.b.n.m Z;
  public v a0;
  public l.a.b.a.d.g0.m0.g b0;
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
  public l.a.b.a.g.g v0;
  public l.a.b.a.g.d w0;
  public List<d0> x0;
  public final l.a.b.a.b.n.g y0;
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
    S = new l.a.b.a.c.x((r)localObject);
    T = -1;
    U = 512;
    V = 0;
    W = 65535;
    c0 = new s(null);
    localObject = l.a.b.a.d.f0.a;
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
    y0 = new l.a.b.a.b.n.g();
    z0 = new k();
    A0 = new l.a.b.a.b.n.s();
    e.c.a.a.b.l.c.a(R, S);
    T = -1;
    X = new j(S, U, (byte)0, this);
  }
  
  public void J() {}
  
  public l.a.b.a.d.v L()
  {
    if (a0 == null) {
      if (!e0)
      {
        V();
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
  
  public void M() {}
  
  public void S() {}
  
  public p U()
  {
    return (p)c0.a;
  }
  
  public final void V()
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
  
  public boolean W()
  {
    boolean bool;
    if (((H & 0x2) == 0) && (c0.a == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean X()
  {
    boolean bool;
    if ((J == null) && (y != l.a.b.a.d.g.UNINITIALIZED)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean Y()
  {
    boolean bool;
    if ((H & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
    e0 locale0 = paramm.U();
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
  
  public z a(l.a.b.a.d.a0 parama0)
  {
    if (b0 == null)
    {
      V();
      parama0 = new l.a.b.a.d.g0.m0.g(parama0, null);
      b0 = parama0;
      parama0 = parama0.wrap(P, Q);
      P = parama0;
      Q = parama0;
    }
    return b0;
  }
  
  public final void a(String paramString, int paramInt, Object paramObject, l.a.b.a.b.a parama)
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
    if (Y()) {
      a(paramString1, 0, paramString2, null);
    }
  }
  
  public void a(l.a.b.a.b.n.j paramj)
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
  
  public void a(l.a.b.a.d.c paramc)
  {
    J = ((d)paramc);
    a(h.b.CONNECTION_BOUND, paramc);
    paramc = J;
    R = this;
    paramc.z();
    if (y != l.a.b.a.d.g.UNINITIALIZED)
    {
      paramc = J;
      Object localObject = Z;
      if (paramc != null)
      {
        y = l.a.b.a.d.g.ACTIVE;
        localObject = b;
        paramc.a(h.b.CONNECTION_REMOTE_OPEN, paramc);
        paramc = y;
        localObject = l.a.b.a.d.g.CLOSED;
        if (paramc == localObject) {
          J.y = ((l.a.b.a.d.g)localObject);
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
  
  public void a(l.a.b.a.d.d0 paramd0)
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
        a(new l.a.b.a.b.n.j(l.a.b.a.b.n.d.a, paramd0));
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
        V();
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
  
  public boolean a(l.a.b.a.e.a parama)
  {
    if (X())
    {
      localObject = E0;
      if (Y()) {
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
  
  /* Error */
  public final void a0()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 309	l/a/b/a/d/g0/a0:J	Ll/a/b/a/d/g0/d;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +1248 -> 1254
    //   9: aload_0
    //   10: getfield 643	l/a/b/a/d/g0/a0:K	Z
    //   13: ifeq +1241 -> 1254
    //   16: aload_0
    //   17: getfield 645	l/a/b/a/d/g0/a0:L	Z
    //   20: ifne +1234 -> 1254
    //   23: aload_1
    //   24: getfield 648	l/a/b/a/d/g0/d:S	Ll/a/b/a/d/g0/e;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +1225 -> 1254
    //   32: aload_1
    //   33: getfield 652	l/a/b/a/d/g0/e:H	Ll/a/b/a/d/g0/m;
    //   36: astore_2
    //   37: aload_2
    //   38: instanceof 340
    //   41: istore_3
    //   42: iconst_1
    //   43: istore 4
    //   45: iconst_0
    //   46: istore 5
    //   48: iconst_0
    //   49: istore 6
    //   51: iload_3
    //   52: ifeq +1016 -> 1068
    //   55: aload_2
    //   56: checkcast 340	l/a/b/a/d/g0/x
    //   59: astore 7
    //   61: aload 7
    //   63: getfield 348	l/a/b/a/d/g0/x:a0	Ll/a/b/a/d/g0/j0;
    //   66: astore 8
    //   68: aload 7
    //   70: getfield 655	l/a/b/a/d/g0/m:H	Ll/a/b/a/d/g0/y;
    //   73: astore 9
    //   75: aload 9
    //   77: getfield 356	l/a/b/a/d/g0/y:L	Ll/a/b/a/d/g0/k0;
    //   80: astore 10
    //   82: aload_1
    //   83: getfield 657	l/a/b/a/d/g0/e:S	Z
    //   86: istore_3
    //   87: iload_3
    //   88: ifne +759 -> 847
    //   91: aload_1
    //   92: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   95: astore_2
    //   96: aload_2
    //   97: ifnonnull +9 -> 106
    //   100: iconst_0
    //   101: istore 11
    //   103: goto +11 -> 114
    //   106: aload_2
    //   107: invokeinterface 664 1 0
    //   112: istore 11
    //   114: iload 11
    //   116: ifgt +12 -> 128
    //   119: aload_1
    //   120: aload 7
    //   122: getfield 666	l/a/b/a/d/g0/m:K	Ll/a/b/a/d/g0/e;
    //   125: if_acmpeq +722 -> 847
    //   128: aload 10
    //   130: getfield 669	l/a/b/a/d/g0/k0:o	Ll/a/b/a/b/h;
    //   133: astore_2
    //   134: aload_2
    //   135: ifnonnull +6 -> 141
    //   138: goto +19 -> 157
    //   141: aload_2
    //   142: getstatic 673	l/a/b/a/b/h:z	Ll/a/b/a/b/h;
    //   145: invokevirtual 676	l/a/b/a/b/h:b	(Ll/a/b/a/b/h;)I
    //   148: ifle +9 -> 157
    //   151: iconst_1
    //   152: istore 11
    //   154: goto +6 -> 160
    //   157: iconst_0
    //   158: istore 11
    //   160: iload 11
    //   162: ifeq +685 -> 847
    //   165: aload 8
    //   167: getfield 594	l/a/b/a/d/g0/e0:e	Ll/a/b/a/b/h;
    //   170: getstatic 673	l/a/b/a/b/h:z	Ll/a/b/a/b/h;
    //   173: invokevirtual 676	l/a/b/a/b/h:b	(Ll/a/b/a/b/h;)I
    //   176: ifle +9 -> 185
    //   179: iconst_1
    //   180: istore 11
    //   182: goto +6 -> 188
    //   185: iconst_0
    //   186: istore 11
    //   188: iload 11
    //   190: ifeq +657 -> 847
    //   193: aload 10
    //   195: invokevirtual 678	l/a/b/a/d/g0/k0:a	()Z
    //   198: ifeq +649 -> 847
    //   201: aload 8
    //   203: getfield 586	l/a/b/a/d/g0/e0:a	Ll/a/b/a/b/h;
    //   206: ifnull +641 -> 847
    //   209: aload_0
    //   210: getfield 248	l/a/b/a/d/g0/a0:X	Ll/a/b/a/d/g0/j;
    //   213: astore_2
    //   214: aload_2
    //   215: getfield 681	l/a/b/a/d/g0/j:c	Ll/a/b/a/d/g0/k;
    //   218: getfield 684	l/a/b/a/d/g0/k:b	I
    //   221: aload_2
    //   222: getfield 686	l/a/b/a/d/g0/j:f	I
    //   225: if_icmple +9 -> 234
    //   228: iconst_1
    //   229: istore 11
    //   231: goto +6 -> 237
    //   234: iconst_0
    //   235: istore 11
    //   237: iload 11
    //   239: ifne +608 -> 847
    //   242: aload 8
    //   244: getfield 688	l/a/b/a/d/g0/j0:j	Ll/a/b/a/d/g0/e;
    //   247: astore_2
    //   248: aload_2
    //   249: ifnull +15 -> 264
    //   252: aload_2
    //   253: aload_1
    //   254: if_acmpeq +10 -> 264
    //   257: iload 5
    //   259: istore 11
    //   261: goto +786 -> 1047
    //   264: aload_1
    //   265: getfield 691	l/a/b/a/d/g0/e:P	Ll/a/b/a/d/g0/z;
    //   268: astore_2
    //   269: aload_2
    //   270: ifnull +11 -> 281
    //   273: aload_2
    //   274: getfield 694	l/a/b/a/d/g0/z:a	Ll/a/b/a/b/h;
    //   277: astore_2
    //   278: goto +21 -> 299
    //   281: aload 10
    //   283: getfield 695	l/a/b/a/d/g0/k0:f	Ll/a/b/a/b/h;
    //   286: astore_2
    //   287: aload 10
    //   289: aload_2
    //   290: getstatic 698	l/a/b/a/b/h:A	Ll/a/b/a/b/h;
    //   293: invokevirtual 701	l/a/b/a/b/h:a	(Ll/a/b/a/b/h;)Ll/a/b/a/b/h;
    //   296: putfield 695	l/a/b/a/d/g0/k0:f	Ll/a/b/a/b/h;
    //   299: aload_1
    //   300: new 693	l/a/b/a/d/g0/z
    //   303: dup
    //   304: aload_2
    //   305: aload_1
    //   306: aload 8
    //   308: invokespecial 704	l/a/b/a/d/g0/z:<init>	(Ll/a/b/a/b/h;Ll/a/b/a/d/g0/e;Ll/a/b/a/d/g0/e0;)V
    //   311: putfield 691	l/a/b/a/d/g0/e:P	Ll/a/b/a/d/g0/z;
    //   314: aload_0
    //   315: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   318: astore 12
    //   320: aload 12
    //   322: aload_2
    //   323: putfield 706	l/a/b/a/b/n/s:b	Ll/a/b/a/b/h;
    //   326: aload 12
    //   328: new 406	l/a/b/a/b/a
    //   331: dup
    //   332: aload_1
    //   333: getfield 709	l/a/b/a/d/g0/e:G	[B
    //   336: invokespecial 712	l/a/b/a/b/a:<init>	([B)V
    //   339: putfield 713	l/a/b/a/b/n/s:c	Ll/a/b/a/b/a;
    //   342: aload_0
    //   343: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   346: aload 8
    //   348: getfield 586	l/a/b/a/d/g0/e0:a	Ll/a/b/a/b/h;
    //   351: invokevirtual 714	l/a/b/a/b/n/s:a	(Ll/a/b/a/b/h;)V
    //   354: aload_0
    //   355: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   358: astore 13
    //   360: aload 13
    //   362: aconst_null
    //   363: putfield 717	l/a/b/a/b/n/s:g	Ll/a/b/a/b/n/n;
    //   366: aload 13
    //   368: iconst_0
    //   369: putfield 718	l/a/b/a/b/n/s:i	Z
    //   372: aload 13
    //   374: iconst_0
    //   375: putfield 720	l/a/b/a/b/n/s:j	Z
    //   378: aload 13
    //   380: iconst_0
    //   381: putfield 722	l/a/b/a/b/n/s:k	Z
    //   384: aload_1
    //   385: getfield 725	l/a/b/a/d/g0/e:I	Ll/a/b/a/b/n/e;
    //   388: astore 12
    //   390: aload 12
    //   392: ifnull +13 -> 405
    //   395: aload 13
    //   397: aload 12
    //   399: putfield 727	l/a/b/a/b/n/s:h	Ll/a/b/a/b/n/e;
    //   402: goto +9 -> 411
    //   405: aload 13
    //   407: aconst_null
    //   408: putfield 727	l/a/b/a/b/n/s:h	Ll/a/b/a/b/n/e;
    //   411: aload_1
    //   412: getfield 729	l/a/b/a/d/g0/e:J	Z
    //   415: ifeq +16 -> 431
    //   418: aload_0
    //   419: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   422: getstatic 735	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   425: putfield 737	l/a/b/a/b/n/s:e	Ljava/lang/Boolean;
    //   428: goto +26 -> 454
    //   431: aload_0
    //   432: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   435: getstatic 740	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   438: putfield 737	l/a/b/a/b/n/s:e	Ljava/lang/Boolean;
    //   441: aload 10
    //   443: getfield 743	l/a/b/a/d/g0/k0:q	Ljava/util/Map;
    //   446: aload_2
    //   447: aload_1
    //   448: invokeinterface 749 3 0
    //   453: pop
    //   454: aload 7
    //   456: getfield 666	l/a/b/a/d/g0/m:K	Ll/a/b/a/d/g0/e;
    //   459: aload_1
    //   460: if_acmpne +14 -> 474
    //   463: aload_0
    //   464: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   467: iconst_1
    //   468: putfield 321	l/a/b/a/b/n/s:f	Z
    //   471: goto +11 -> 482
    //   474: aload_0
    //   475: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   478: iconst_0
    //   479: putfield 321	l/a/b/a/b/n/s:f	Z
    //   482: aload_1
    //   483: getfield 751	l/a/b/a/d/g0/e:N	I
    //   486: istore 11
    //   488: iload 11
    //   490: ifne +16 -> 506
    //   493: aload_0
    //   494: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   497: getstatic 673	l/a/b/a/b/h:z	Ll/a/b/a/b/h;
    //   500: putfield 752	l/a/b/a/b/n/s:d	Ll/a/b/a/b/h;
    //   503: goto +15 -> 518
    //   506: aload_0
    //   507: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   510: iload 11
    //   512: invokestatic 755	l/a/b/a/b/h:a	(I)Ll/a/b/a/b/h;
    //   515: putfield 752	l/a/b/a/b/n/s:d	Ll/a/b/a/b/h;
    //   518: aload_1
    //   519: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   522: astore 12
    //   524: aload 12
    //   526: astore_2
    //   527: aload 12
    //   529: ifnonnull +7 -> 536
    //   532: getstatic 757	l/a/b/a/d/g0/e:V	Ll/a/b/a/c/k0;
    //   535: astore_2
    //   536: aload_2
    //   537: invokeinterface 664 1 0
    //   542: istore 5
    //   544: aload 10
    //   546: getfield 603	l/a/b/a/d/g0/k0:c	I
    //   549: istore 11
    //   551: aload_0
    //   552: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   555: astore 13
    //   557: new 759	l/a/b/a/d/g0/a
    //   560: astore 12
    //   562: aload 12
    //   564: aload_0
    //   565: invokespecial 762	l/a/b/a/d/g0/a:<init>	(Ll/a/b/a/d/g0/a0;)V
    //   568: aload_0
    //   569: getfield 248	l/a/b/a/d/g0/a0:X	Ll/a/b/a/d/g0/j;
    //   572: iload 11
    //   574: aload 13
    //   576: aload_2
    //   577: aload 12
    //   579: invokevirtual 606	l/a/b/a/d/g0/j:a	(ILjava/lang/Object;Ll/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   582: aload_1
    //   583: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   586: astore 12
    //   588: aload 12
    //   590: ifnull +31 -> 621
    //   593: aload 12
    //   595: invokeinterface 766 1 0
    //   600: pop
    //   601: aload_1
    //   602: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   605: invokeinterface 768 1 0
    //   610: ifne +11 -> 621
    //   613: aload_1
    //   614: aload_1
    //   615: getfield 771	l/a/b/a/d/g0/e:T	Ll/a/b/a/c/l;
    //   618: putfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   621: aload 10
    //   623: aload 10
    //   625: getfield 564	l/a/b/a/d/g0/k0:i	Ll/a/b/a/b/h;
    //   628: getstatic 698	l/a/b/a/b/h:A	Ll/a/b/a/b/h;
    //   631: invokevirtual 701	l/a/b/a/b/h:a	(Ll/a/b/a/b/h;)Ll/a/b/a/b/h;
    //   634: putfield 564	l/a/b/a/d/g0/k0:i	Ll/a/b/a/b/h;
    //   637: aload 10
    //   639: aload 10
    //   641: getfield 669	l/a/b/a/d/g0/k0:o	Ll/a/b/a/b/h;
    //   644: getstatic 698	l/a/b/a/b/h:A	Ll/a/b/a/b/h;
    //   647: invokevirtual 773	l/a/b/a/b/h:c	(Ll/a/b/a/b/h;)Ll/a/b/a/b/h;
    //   650: putfield 669	l/a/b/a/d/g0/k0:o	Ll/a/b/a/b/h;
    //   653: aload_2
    //   654: invokeinterface 768 1 0
    //   659: ifne +91 -> 750
    //   662: aload 9
    //   664: iload 5
    //   666: ineg
    //   667: invokevirtual 776	l/a/b/a/d/g0/y:c	(I)V
    //   670: aload_0
    //   671: getfield 236	l/a/b/a/d/g0/a0:A0	Ll/a/b/a/b/n/s;
    //   674: getfield 321	l/a/b/a/b/n/s:f	Z
    //   677: ifne +94 -> 771
    //   680: aload 8
    //   682: aconst_null
    //   683: putfield 688	l/a/b/a/d/g0/j0:j	Ll/a/b/a/d/g0/e;
    //   686: aload_1
    //   687: iconst_1
    //   688: putfield 657	l/a/b/a/d/g0/e:S	Z
    //   691: aload 8
    //   693: aload 8
    //   695: getfield 591	l/a/b/a/d/g0/e0:d	Ll/a/b/a/b/h;
    //   698: getstatic 698	l/a/b/a/b/h:A	Ll/a/b/a/b/h;
    //   701: invokevirtual 701	l/a/b/a/b/h:a	(Ll/a/b/a/b/h;)Ll/a/b/a/b/h;
    //   704: putfield 591	l/a/b/a/d/g0/e0:d	Ll/a/b/a/b/h;
    //   707: aload 8
    //   709: aload 8
    //   711: getfield 594	l/a/b/a/d/g0/e0:e	Ll/a/b/a/b/h;
    //   714: getstatic 698	l/a/b/a/b/h:A	Ll/a/b/a/b/h;
    //   717: invokevirtual 773	l/a/b/a/b/h:c	(Ll/a/b/a/b/h;)Ll/a/b/a/b/h;
    //   720: putfield 594	l/a/b/a/d/g0/e0:e	Ll/a/b/a/b/h;
    //   723: aload 9
    //   725: aload 9
    //   727: getfield 778	l/a/b/a/d/g0/y:Q	I
    //   730: iconst_1
    //   731: isub
    //   732: putfield 778	l/a/b/a/d/g0/y:Q	I
    //   735: aload 7
    //   737: aload 7
    //   739: getfield 779	l/a/b/a/d/g0/m:Q	I
    //   742: iconst_1
    //   743: isub
    //   744: putfield 779	l/a/b/a/d/g0/m:Q	I
    //   747: goto +24 -> 771
    //   750: aload 9
    //   752: iload 5
    //   754: aload_2
    //   755: invokeinterface 664 1 0
    //   760: isub
    //   761: ineg
    //   762: invokevirtual 776	l/a/b/a/d/g0/y:c	(I)V
    //   765: aload 8
    //   767: aload_1
    //   768: putfield 688	l/a/b/a/d/g0/j0:j	Ll/a/b/a/d/g0/e;
    //   771: aload_0
    //   772: getfield 193	l/a/b/a/d/g0/a0:f0	Z
    //   775: ifeq +72 -> 847
    //   778: aload 7
    //   780: getfield 782	l/a/b/a/d/g0/f:x	Ll/a/b/a/d/g;
    //   783: getstatic 502	l/a/b/a/d/g:CLOSED	Ll/a/b/a/d/g;
    //   786: if_acmpeq +61 -> 847
    //   789: aload_0
    //   790: getfield 309	l/a/b/a/d/g0/a0:J	Ll/a/b/a/d/g0/d;
    //   793: getstatic 785	l/a/b/a/d/h$b:LINK_FLOW	Ll/a/b/a/d/h$b;
    //   796: aload 7
    //   798: invokevirtual 499	l/a/b/a/d/g0/d:a	(Ll/a/b/a/d/h$b;Ljava/lang/Object;)Ll/a/b/a/d/g0/g;
    //   801: pop
    //   802: goto +45 -> 847
    //   805: astore_2
    //   806: aload_1
    //   807: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   810: astore 12
    //   812: aload 12
    //   814: ifnull +31 -> 845
    //   817: aload 12
    //   819: invokeinterface 766 1 0
    //   824: pop
    //   825: aload_1
    //   826: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   829: invokeinterface 768 1 0
    //   834: ifne +11 -> 845
    //   837: aload_1
    //   838: aload_1
    //   839: getfield 771	l/a/b/a/d/g0/e:T	Ll/a/b/a/c/l;
    //   842: putfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   845: aload_2
    //   846: athrow
    //   847: iload_3
    //   848: ifeq +112 -> 960
    //   851: aload_1
    //   852: getfield 725	l/a/b/a/d/g0/e:I	Ll/a/b/a/b/n/e;
    //   855: ifnull +105 -> 960
    //   858: aload_1
    //   859: getfield 691	l/a/b/a/d/g0/e:P	Ll/a/b/a/d/g0/z;
    //   862: astore_2
    //   863: aload_0
    //   864: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   867: aload_2
    //   868: getfield 694	l/a/b/a/d/g0/z:a	Ll/a/b/a/b/h;
    //   871: invokevirtual 786	l/a/b/a/b/n/g:a	(Ll/a/b/a/b/h;)V
    //   874: aload_0
    //   875: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   878: astore 12
    //   880: aload 12
    //   882: aload_2
    //   883: getfield 694	l/a/b/a/d/g0/z:a	Ll/a/b/a/b/h;
    //   886: putfield 788	l/a/b/a/b/n/g:c	Ll/a/b/a/b/h;
    //   889: aload 12
    //   891: getstatic 794	l/a/b/a/b/n/o:SENDER	Ll/a/b/a/b/n/o;
    //   894: invokevirtual 797	l/a/b/a/b/n/g:a	(Ll/a/b/a/b/n/o;)V
    //   897: aload_0
    //   898: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   901: astore 12
    //   903: aload_1
    //   904: getfield 729	l/a/b/a/d/g0/e:J	Z
    //   907: istore_3
    //   908: aload 12
    //   910: iload_3
    //   911: putfield 799	l/a/b/a/b/n/g:d	Z
    //   914: aload 12
    //   916: iconst_0
    //   917: putfield 800	l/a/b/a/b/n/g:f	Z
    //   920: iload_3
    //   921: ifeq +7 -> 928
    //   924: aload_2
    //   925: invokevirtual 801	l/a/b/a/d/g0/z:a	()V
    //   928: aload_0
    //   929: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   932: astore_2
    //   933: aload_2
    //   934: aload_1
    //   935: getfield 725	l/a/b/a/d/g0/e:I	Ll/a/b/a/b/n/e;
    //   938: putfield 803	l/a/b/a/b/n/g:e	Ll/a/b/a/b/n/e;
    //   941: aload 10
    //   943: getfield 603	l/a/b/a/d/g0/k0:c	I
    //   946: istore 11
    //   948: aload_0
    //   949: getfield 248	l/a/b/a/d/g0/a0:X	Ll/a/b/a/d/g0/j;
    //   952: iload 11
    //   954: aload_2
    //   955: aconst_null
    //   956: aconst_null
    //   957: invokevirtual 606	l/a/b/a/d/g0/j:a	(ILjava/lang/Object;Ll/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   960: aload_1
    //   961: getfield 804	l/a/b/a/d/g0/e:K	Z
    //   964: ifeq +10 -> 974
    //   967: iload 6
    //   969: istore 11
    //   971: goto +70 -> 1041
    //   974: iload 6
    //   976: istore 11
    //   978: aload_1
    //   979: getfield 652	l/a/b/a/d/g0/e:H	Ll/a/b/a/d/g0/m;
    //   982: instanceof 340
    //   985: ifeq +56 -> 1041
    //   988: aload_1
    //   989: getfield 657	l/a/b/a/d/g0/e:S	Z
    //   992: ifeq +10 -> 1002
    //   995: iload 6
    //   997: istore 11
    //   999: goto +42 -> 1041
    //   1002: aload_1
    //   1003: getfield 660	l/a/b/a/d/g0/e:U	Ll/a/b/a/c/k0;
    //   1006: astore_2
    //   1007: aload_2
    //   1008: ifnull +13 -> 1021
    //   1011: aload_2
    //   1012: invokeinterface 768 1 0
    //   1017: istore_3
    //   1018: goto +5 -> 1023
    //   1021: iconst_0
    //   1022: istore_3
    //   1023: aload_1
    //   1024: getfield 806	l/a/b/a/d/g0/e:Q	Z
    //   1027: ifne +11 -> 1038
    //   1030: iload 6
    //   1032: istore 11
    //   1034: iload_3
    //   1035: ifeq +6 -> 1041
    //   1038: iconst_1
    //   1039: istore 11
    //   1041: iload 11
    //   1043: iconst_1
    //   1044: ixor
    //   1045: istore 11
    //   1047: iload 11
    //   1049: ifeq +11 -> 1060
    //   1052: aload_1
    //   1053: invokevirtual 809	l/a/b/a/d/g0/e:k	()Ll/a/b/a/d/g0/e;
    //   1056: astore_1
    //   1057: goto -1029 -> 28
    //   1060: aload_1
    //   1061: getfield 812	l/a/b/a/d/g0/e:C	Ll/a/b/a/d/g0/e;
    //   1064: astore_1
    //   1065: goto -1037 -> 28
    //   1068: aload_2
    //   1069: checkcast 330	l/a/b/a/d/g0/q
    //   1072: astore 12
    //   1074: aload_1
    //   1075: getfield 691	l/a/b/a/d/g0/e:P	Ll/a/b/a/d/g0/z;
    //   1078: astore_2
    //   1079: aload 12
    //   1081: getfield 655	l/a/b/a/d/g0/m:H	Ll/a/b/a/d/g0/y;
    //   1084: getfield 356	l/a/b/a/d/g0/y:L	Ll/a/b/a/d/g0/k0;
    //   1087: astore 10
    //   1089: aload 10
    //   1091: invokevirtual 678	l/a/b/a/d/g0/k0:a	()Z
    //   1094: ifeq +136 -> 1230
    //   1097: aload_1
    //   1098: getfield 729	l/a/b/a/d/g0/e:J	Z
    //   1101: istore_3
    //   1102: aload_1
    //   1103: getfield 725	l/a/b/a/d/g0/e:I	Ll/a/b/a/b/n/e;
    //   1106: astore 12
    //   1108: aload_0
    //   1109: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   1112: aload_2
    //   1113: getfield 694	l/a/b/a/d/g0/z:a	Ll/a/b/a/b/h;
    //   1116: invokevirtual 786	l/a/b/a/b/n/g:a	(Ll/a/b/a/b/h;)V
    //   1119: aload_0
    //   1120: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   1123: astore 9
    //   1125: aload 9
    //   1127: aload_2
    //   1128: getfield 694	l/a/b/a/d/g0/z:a	Ll/a/b/a/b/h;
    //   1131: putfield 788	l/a/b/a/b/n/g:c	Ll/a/b/a/b/h;
    //   1134: aload 9
    //   1136: getstatic 815	l/a/b/a/b/n/o:RECEIVER	Ll/a/b/a/b/n/o;
    //   1139: invokevirtual 797	l/a/b/a/b/n/g:a	(Ll/a/b/a/b/n/o;)V
    //   1142: aload_0
    //   1143: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   1146: astore 9
    //   1148: aload 9
    //   1150: iload_3
    //   1151: putfield 799	l/a/b/a/b/n/g:d	Z
    //   1154: aload 9
    //   1156: aload 12
    //   1158: putfield 803	l/a/b/a/b/n/g:e	Ll/a/b/a/b/n/e;
    //   1161: aload 9
    //   1163: iconst_0
    //   1164: putfield 800	l/a/b/a/b/n/g:f	Z
    //   1167: aload 12
    //   1169: ifnonnull +16 -> 1185
    //   1172: iload_3
    //   1173: ifeq +12 -> 1185
    //   1176: aload 9
    //   1178: aload_1
    //   1179: getfield 817	l/a/b/a/d/g0/e:M	Ll/a/b/a/b/n/e;
    //   1182: putfield 803	l/a/b/a/b/n/g:e	Ll/a/b/a/b/n/e;
    //   1185: aload 10
    //   1187: getfield 603	l/a/b/a/d/g0/k0:c	I
    //   1190: istore 11
    //   1192: aload_0
    //   1193: getfield 226	l/a/b/a/d/g0/a0:y0	Ll/a/b/a/b/n/g;
    //   1196: astore 12
    //   1198: aload_0
    //   1199: getfield 248	l/a/b/a/d/g0/a0:X	Ll/a/b/a/d/g0/j;
    //   1202: iload 11
    //   1204: aload 12
    //   1206: aconst_null
    //   1207: aconst_null
    //   1208: invokevirtual 606	l/a/b/a/d/g0/j:a	(ILjava/lang/Object;Ll/a/b/a/c/k0;Ljava/lang/Runnable;)V
    //   1211: iload 4
    //   1213: istore 11
    //   1215: iload_3
    //   1216: ifeq +17 -> 1233
    //   1219: aload_2
    //   1220: invokevirtual 801	l/a/b/a/d/g0/z:a	()V
    //   1223: iload 4
    //   1225: istore 11
    //   1227: goto +6 -> 1233
    //   1230: iconst_0
    //   1231: istore 11
    //   1233: iload 11
    //   1235: ifeq +11 -> 1246
    //   1238: aload_1
    //   1239: invokevirtual 809	l/a/b/a/d/g0/e:k	()Ll/a/b/a/d/g0/e;
    //   1242: astore_1
    //   1243: goto -1215 -> 28
    //   1246: aload_1
    //   1247: getfield 812	l/a/b/a/d/g0/e:C	Ll/a/b/a/d/g0/e;
    //   1250: astore_1
    //   1251: goto -1223 -> 28
    //   1254: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1255	0	this	a0
    //   4	1247	1	localObject1	Object
    //   36	719	2	localObject2	Object
    //   805	41	2	localObject3	Object
    //   862	358	2	localObject4	Object
    //   41	1175	3	bool	boolean
    //   43	1181	4	i	int
    //   46	715	5	j	int
    //   49	982	6	k	int
    //   59	738	7	localx	x
    //   66	700	8	localj0	j0
    //   73	1104	9	localObject5	Object
    //   80	1106	10	localk0	k0
    //   101	1133	11	m	int
    //   318	887	12	localObject6	Object
    //   358	217	13	locals	l.a.b.a.b.n.s
    // Exception table:
    //   from	to	target	type
    //   544	582	805	finally
  }
  
  public long b(long paramLong)
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
          if ((localObject1 != null) && (x != l.a.b.a.d.g.CLOSED))
          {
            localObject1 = new l.a.b.a.b.n.j(l.a.b.a.b.f.a("amqp:resource-limit-exceeded"), "local-idle-timeout expired");
            J.a((l.a.b.a.b.n.j)localObject1);
            J.x = l.a.b.a.d.g.CLOSED;
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
                p = l.a.b.a.d.v.a.PN_SASL_SYS;
              }
              localObject2 = new l.a.b.a.b.n.m();
              K = true;
              X.a(0, localObject2, null, null);
            }
            if (!L)
            {
              localObject2 = new l.a.b.a.b.n.c();
              a = ((l.a.b.a.b.n.j)localObject1);
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
  
  public int capacity()
  {
    V();
    return P.capacity();
  }
  
  public void close_head()
  {
    Q.close_head();
  }
  
  public void close_tail()
  {
    V();
    P.close_tail();
  }
  
  public ByteBuffer head()
  {
    V();
    return Q.head();
  }
  
  public boolean isClosed()
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
  
  public void l() {}
  
  public void o()
  {
    Object localObject1 = O.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (k0)((Iterator)localObject1).next();
      ((k0)localObject2).b();
      ((k0)localObject2).c();
    }
    Object localObject2 = N.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (k0)((Iterator)localObject2).next();
      ((k0)localObject1).b();
      ((k0)localObject1).c();
    }
    a(h.b.CONNECTION_UNBOUND, J);
    localObject2 = J;
    localObject1 = H;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        y localy = (y)((Iterator)localObject1).next();
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
      ((f)localObject2).c(true);
    }
    localObject2 = J;
    R = null;
    ((f)localObject2).k();
  }
  
  public d p()
  {
    return J;
  }
  
  public int pending()
  {
    V();
    return Q.pending();
  }
  
  public void pop(int paramInt)
  {
    V();
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
      V();
      int i = P.position();
      P.process();
      p0 += i - P.position();
      return;
    }
    catch (l.a.b.a.d.d0 locald0)
    {
      i0 = true;
      throw locald0;
    }
  }
  
  public ByteBuffer tail()
  {
    V();
    return P.tail();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("TransportImpl [_connectionEndpoint=");
    localStringBuilder.append(J);
    localStringBuilder.append(", ");
    return e.a.a.a.a.a(localStringBuilder, super.toString(), "]");
  }
  
  public l.a.b.a.b.n.j v()
  {
    l.a.b.a.b.n.j localj = z;
    if (a == null) {
      localj = null;
    }
    return localj;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */