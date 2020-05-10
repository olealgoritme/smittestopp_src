package l.a.b.a.d.g0;

import java.nio.ByteBuffer;
import java.util.Map;
import l.a.b.a.b.h;
import l.a.b.a.b.n.a;
import l.a.b.a.b.n.c;
import l.a.b.a.b.n.i;
import l.a.b.a.b.n.n;
import l.a.b.a.b.n.o;
import l.a.b.a.b.n.r;
import l.a.b.a.d.g;

public class g0
  implements f0
{
  public static final ByteBuffer h;
  public final h0 a;
  public final int b;
  public ByteBuffer c = null;
  public ByteBuffer d = null;
  public boolean e = false;
  public boolean f = false;
  public boolean g = true;
  
  static
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(0);
    localByteBuffer.flip();
    h = localByteBuffer.asReadOnlyBuffer();
  }
  
  public g0(h0 paramh0, int paramInt, boolean paramBoolean)
  {
    a = paramh0;
    if (paramInt <= 0) {
      paramInt = 16384;
    }
    b = paramInt;
    g = paramBoolean;
  }
  
  public final void a()
  {
    d = null;
    c = null;
  }
  
  public void close_head()
  {
    f = true;
    ((a0)a).a(null);
    a();
  }
  
  public ByteBuffer head()
  {
    pending();
    ByteBuffer localByteBuffer = d;
    if (localByteBuffer == null) {
      localByteBuffer = h;
    }
    return localByteBuffer;
  }
  
  public int pending()
  {
    if (f) {
      return -1;
    }
    Object localObject1 = c;
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = ByteBuffer.allocate(b);
      c = ((ByteBuffer)localObject1);
      if (g) {
        d = ((ByteBuffer)localObject1).asReadOnlyBuffer();
      } else {
        d = ((ByteBuffer)localObject1).duplicate();
      }
      d.limit(0);
    }
    localObject1 = a;
    ByteBuffer localByteBuffer = c;
    a0 locala0 = (a0)localObject1;
    boolean bool1 = M;
    boolean bool2 = true;
    Object localObject2;
    if (!bool1)
    {
      if (locala0.W())
      {
        locala0.a(a0.F0, "AMQP");
        localObject1 = locala0.U();
        if (localObject1 != null) {
          ((p)localObject1).a();
        }
      }
      localObject1 = X;
      localObject2 = b.a;
      c.a((byte[])localObject2, 0, localObject2.length);
      M = true;
    }
    Object localObject3;
    int j;
    if (!K) {
      if (!j0)
      {
        localObject1 = J;
        if ((localObject1 == null) || (x == g.UNINITIALIZED)) {}
      }
      else
      {
        localObject3 = new l.a.b.a.b.n.m();
        localObject2 = J;
        localObject1 = "";
        if (localObject2 != null)
        {
          localObject2 = V;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((l.a.b.a.b.n.m)localObject3).a((String)localObject1);
          b = J.W;
          i = null;
          h = null;
          j = null;
        }
        else
        {
          ((l.a.b.a.b.n.m)localObject3).a("");
        }
        j = T;
        if (j > 0) {
          c = h.a(j);
        }
        j = W;
        if (j > 0) {
          d = l.a.b.a.b.j.a((short)j);
        }
        if (n0 > 0) {
          e = new h(n0 / 2);
        }
        K = true;
        X.a(0, localObject3, null, null);
      }
    }
    localObject1 = J;
    Object localObject4;
    if ((localObject1 != null) && (K) && (!L)) {
      for (localObject1 = J; localObject1 != null; localObject1 = C) {
        if ((localObject1 instanceof y))
        {
          localObject4 = (y)localObject1;
          localObject2 = locala0.a((y)localObject4);
          if ((x != g.UNINITIALIZED) && (!t))
          {
            for (j = 0; j < J.K; j++) {
              if (!O.containsKey(Integer.valueOf(j)))
              {
                O.put(Integer.valueOf(j), localObject2);
                if (!((k0)localObject2).a()) {
                  b.z();
                }
                c = j;
                break label542;
              }
            }
            j = -1;
            label542:
            localObject3 = new l.a.b.a.b.n.b();
            if (y != g.UNINITIALIZED) {
              a = l.a.b.a.b.j.a((short)d);
            }
            ((k0)localObject2).d();
            e = e;
            localObject4 = g;
            if (localObject4 != null)
            {
              c = ((h)localObject4);
              localObject4 = h;
              if (localObject4 != null)
              {
                d = ((h)localObject4);
                localObject4 = i;
                if (localObject4 != null)
                {
                  b = ((h)localObject4);
                  X.a(j, localObject3, null, null);
                  t = true;
                }
                else
                {
                  throw new NullPointerException("the next-outgoing-id field is mandatory");
                }
              }
              else
              {
                throw new NullPointerException("the outgoing-window field is mandatory");
              }
            }
            else
            {
              throw new NullPointerException("the incoming-window field is mandatory");
            }
          }
        }
      }
    }
    localObject1 = J;
    Object localObject5;
    if ((localObject1 != null) && (K) && (!L)) {
      label1215:
      for (localObject1 = J; localObject1 != null; localObject1 = C) {
        if ((localObject1 instanceof m))
        {
          m localm = (m)localObject1;
          localObject5 = locala0.a(localm);
          localObject3 = locala0.a(H);
          if ((x != g.UNINITIALIZED) && (!i) && (((k0)localObject3).a()))
          {
            if (y == g.ACTIVE)
            {
              if (a != null) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0) {}
            }
            else
            {
              if (y != g.UNINITIALIZED) {
                continue;
              }
            }
            for (j = 0; j <= 65535; j++)
            {
              localObject2 = h.a(j);
              if (!l.containsKey(localObject2))
              {
                l.put(localObject2, localObject5);
                if (a == null) {
                  f.z();
                }
                a = ((h)localObject2);
                if (y == g.UNINITIALIZED) {
                  m.put(b, localObject5);
                }
                localObject4 = new a();
                if (localObject2 != null)
                {
                  b = ((h)localObject2);
                  localObject2 = b;
                  if (localObject2 != null)
                  {
                    a = ((String)localObject2);
                    localObject2 = U;
                    if (localObject2 != null) {
                      d = ((l.a.b.a.b.n.p)localObject2);
                    }
                    localObject2 = V;
                    if (localObject2 != null) {
                      e = ((n)localObject2);
                    }
                    localObject2 = M;
                    if (localObject2 != null) {
                      f = ((l.a.b.a.b.n.q)localObject2);
                    }
                    localObject2 = O;
                    if (localObject2 != null) {
                      g = ((r)localObject2);
                    }
                    localObject2 = Y;
                    if (localObject2 != null) {
                      n = ((Map)localObject2);
                    }
                    if ((localObject1 instanceof q)) {
                      localObject2 = o.RECEIVER;
                    } else {
                      localObject2 = o.SENDER;
                    }
                    if (localObject2 != null)
                    {
                      c = ((o)localObject2);
                      if ((localm instanceof x)) {
                        j = h.z;
                      }
                      j = c;
                      X.a(j, localObject4, null, null);
                      i = true;
                      break label1215;
                    }
                    throw new NullPointerException("Role cannot be null");
                  }
                  throw new NullPointerException("the name field is mandatory");
                }
                throw new NullPointerException("the handle field is mandatory");
              }
            }
            throw new IllegalStateException("no local handle available for allocation");
          }
        }
      }
    }
    localObject1 = J;
    if ((localObject1 != null) && (K) && (!L))
    {
      for (localObject1 = J; localObject1 != null; localObject1 = C) {
        if ((localObject1 instanceof q))
        {
          localObject4 = (q)localObject1;
          localObject2 = locala0.a((m)localObject4);
          localObject3 = locala0.a(H);
          if ((x == g.ACTIVE) && (((k0)localObject3).a()))
          {
            j = b0;
            b0 = 0;
            if ((j != 0) || (X) || (g.equals(h.z)))
            {
              e = h.a(e.x + j);
              locala0.a((k0)localObject3, (e0)localObject2);
            }
          }
        }
      }
      for (localObject1 = J.J; localObject1 != null; localObject1 = C) {
        if ((localObject1 instanceof y))
        {
          localObject2 = (y)localObject1;
          localObject3 = locala0.a((y)localObject2);
          if ((x == g.ACTIVE) && (((k0)localObject3).a()) && (g.equals(h.z))) {
            locala0.a((k0)localObject3, null);
          }
        }
      }
    }
    locala0.a0();
    locala0.a0();
    localObject1 = J;
    if ((localObject1 != null) && (K) && (!L)) {
      for (localObject1 = J; localObject1 != null; localObject1 = C) {
        if ((localObject1 instanceof x))
        {
          localObject4 = (x)localObject1;
          if ((X) && (T > 0))
          {
            localObject5 = a0;
            localObject2 = H.L;
            localObject3 = e;
            e = h.z;
            d = d.a((h)localObject3);
            T = 0;
            locala0.a((k0)localObject2, (e0)localObject5);
          }
        }
      }
    }
    localObject1 = J;
    if ((localObject1 != null) && (K))
    {
      localObject1 = J;
      while (localObject1 != null) {
        if ((localObject1 instanceof m))
        {
          localObject4 = (m)localObject1;
          localObject5 = locala0.a((m)localObject4);
          localObject2 = locala0.a(H);
          if (x == g.CLOSED)
          {
            if (a != null) {
              j = 1;
            } else {
              j = 0;
            }
            if ((j != 0) && (((k0)localObject2).a()) && (!L))
            {
              if (((localObject4 instanceof x)) && (Q > 0) && (!h) && (!s) && (!Y))
              {
                localObject1 = C;
                continue;
              }
              localObject3 = a;
              if (localObject3 != null) {
                f.k();
              }
              a = null;
              l.remove(localObject3);
              localObject5 = new l.a.b.a.b.n.f();
              if (localObject3 != null)
              {
                a = ((h)localObject3);
                b = true;
                localObject3 = z;
                if (a != null) {
                  c = ((l.a.b.a.b.n.j)localObject3);
                }
                j = c;
                X.a(j, localObject5, null, null);
              }
              else
              {
                throw new NullPointerException("the handle field is mandatory");
              }
            }
          }
          ((f)localObject1).h();
        }
        else
        {
          localObject1 = C;
        }
      }
    }
    localObject1 = J;
    if ((localObject1 != null) && (K))
    {
      localObject1 = J;
      while (localObject1 != null) {
        if ((localObject1 instanceof y))
        {
          localObject3 = (y)localObject1;
          if (x == g.CLOSED)
          {
            localObject2 = L;
            if ((((k0)localObject2).a()) && (!L))
            {
              if (locala0.b((y)localObject3))
              {
                localObject1 = C;
                continue;
              }
              j = c;
              O.remove(Integer.valueOf(j));
              ((k0)localObject2).b();
              localObject2 = new i();
              localObject3 = ((f)localObject1).v();
              if (a != null) {
                a = ((l.a.b.a.b.n.j)localObject3);
              }
              X.a(j, localObject2, null, null);
            }
          }
          ((f)localObject1).h();
        }
        else
        {
          localObject1 = C;
        }
      }
    }
    if (!j0)
    {
      localObject1 = J;
      if ((localObject1 == null) || (x != g.CLOSED)) {}
    }
    else if ((!L) && (!locala0.b(null)))
    {
      localObject2 = new c();
      localObject1 = J;
      if (localObject1 == null) {
        localObject1 = locala0.v();
      } else {
        localObject1 = z;
      }
      if ((localObject1 != null) && (a != null)) {
        a = ((l.a.b.a.b.n.j)localObject1);
      }
      L = true;
      X.a(0, localObject2, null, null);
      localObject1 = J;
      if (localObject1 != null) {
        ((f)localObject1).h();
      }
    }
    X.a(localByteBuffer);
    bool1 = bool2;
    if (!L) {
      if (i0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    e = bool1;
    d.limit(c.position());
    if ((c.position() == 0) && (c.capacity() > a0.B0)) {
      a();
    }
    if (e)
    {
      localObject1 = c;
      if ((localObject1 == null) || (((ByteBuffer)localObject1).position() == 0)) {
        return -1;
      }
    }
    localObject1 = c;
    if (localObject1 == null) {
      j = i;
    } else {
      j = ((ByteBuffer)localObject1).position();
    }
    return j;
  }
  
  public void pop(int paramInt)
  {
    ByteBuffer localByteBuffer = c;
    if (localByteBuffer != null)
    {
      localByteBuffer.flip();
      c.position(paramInt);
      c.compact();
      d.position(0);
      d.limit(c.position());
      if ((c.position() == 0) && (c.capacity() > a0.B0)) {
        a();
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.g0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */