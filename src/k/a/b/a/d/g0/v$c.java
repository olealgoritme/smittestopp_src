package k.a.b.a.d.g0;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.a.b.a.b.l.c.a;
import k.a.b.a.b.l.d;
import k.a.b.a.b.l.e;
import k.a.b.a.b.l.g;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.d.d0;
import k.a.b.a.d.v.a;

public class v$c
  implements l0
{
  public final b0 a;
  public final f0 b;
  public boolean c;
  public final ByteBuffer d;
  public final ByteBuffer e;
  public final ByteBuffer f;
  public final v.d g;
  
  public final boolean a()
  {
    v localv = h;
    v.b localb = v;
    if ((localb != null) && ((localb != v.b.CLIENT) || (s)))
    {
      localv = h;
      if ((v != v.b.SERVER) || ((m) && (s))) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public final boolean b()
  {
    v localv = h;
    v.b localb = v;
    boolean bool;
    if ((localb != null) && ((localb != v.b.CLIENT) || ((s) && (o))) && ((h.v != v.b.SERVER) || (c))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final void c()
  {
    Object localObject1;
    Object localObject5;
    label1765:
    label1855:
    label1917:
    Object localObject4;
    if (a())
    {
      if (v.y.isLoggable(Level.FINER))
      {
        localObject1 = v.y;
        localObject2 = Level.FINER;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(h);
        ((StringBuilder)localObject5).append(" about to call input.");
        ((Logger)localObject1).log((Level)localObject2, ((StringBuilder)localObject5).toString());
      }
      u localu = h.l;
      localObject1 = e;
      int i = c;
      localObject5 = b;
      Object localObject2 = null;
      Object localObject6 = null;
      while ((((ByteBuffer)localObject1).hasRemaining()) && (localObject5 != u.a.ERROR) && (!((v)a).b()))
      {
        Object localObject7 = localObject5;
        Object localObject8 = localObject5;
        Object localObject9 = localObject5;
        Object localObject10 = localObject5;
        Object localObject11 = localObject5;
        Object localObject12 = localObject5;
        Object localObject13 = localObject5;
        Object localObject14 = localObject5;
        int j = i;
        int k = i;
        int m = i;
        int n = i;
        Object localObject15 = localObject5;
        int i1 = i;
        Object localObject16 = localObject5;
        Object localObject17 = localObject1;
        int i2 = i;
        Object localObject18 = localObject6;
        byte b1;
        switch (((Enum)localObject5).ordinal())
        {
        default: 
          break;
        case 0: 
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[0])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[0]), localObject5 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject7 = u.a.HEADER1;
            }
          }
          break;
        case 1: 
          localObject5 = localObject7;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[1])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[1]), localObject7 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject8 = u.a.HEADER2;
            }
          }
          break;
        case 2: 
          localObject5 = localObject8;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[2])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[2]), localObject8 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject9 = u.a.HEADER3;
            }
          }
          break;
        case 3: 
          localObject5 = localObject9;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[3])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[3]), localObject9 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject10 = u.a.HEADER4;
            }
          }
          break;
        case 4: 
          localObject5 = localObject10;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[4])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[4]), localObject10 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject11 = u.a.HEADER5;
            }
          }
          break;
        case 5: 
          localObject5 = localObject11;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[5])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[5]), localObject11 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject12 = u.a.HEADER6;
            }
          }
          break;
        case 6: 
          localObject5 = localObject12;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[6])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[6]), localObject12 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              localObject13 = u.a.HEADER7;
            }
          }
          break;
        case 7: 
          localObject5 = localObject13;
          if (((ByteBuffer)localObject1).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject1).get();
            if (b1 != b.b[7])
            {
              localObject2 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[7]), localObject13 });
              localObject5 = u.a.ERROR;
            }
            else
            {
              if (g.X())
              {
                g.a(a0.E0, "SASL");
                localObject5 = g.V();
                if (localObject5 != null) {
                  ((p)localObject5).a();
                }
              }
              localObject14 = u.a.SIZE_0;
            }
          }
          break;
        case 8: 
          if (!((ByteBuffer)localObject1).hasRemaining())
          {
            localObject5 = localObject14;
          }
          else if (((ByteBuffer)localObject1).remaining() >= 4)
          {
            i = ((ByteBuffer)localObject1).getInt();
            localObject5 = u.a.PRE_PARSE;
          }
          else
          {
            i = ((ByteBuffer)localObject1).get() << 24 & 0xFF000000;
            j = i;
            if (!((ByteBuffer)localObject1).hasRemaining()) {
              localObject5 = u.a.SIZE_1;
            }
          }
          break;
        case 9: 
          i = j | ((ByteBuffer)localObject1).get() << 16 & 0xFF0000;
          k = i;
          if (!((ByteBuffer)localObject1).hasRemaining()) {
            localObject5 = u.a.SIZE_2;
          }
          break;
        case 10: 
          i = k | ((ByteBuffer)localObject1).get() << 8 & 0xFF00;
          m = i;
          if (!((ByteBuffer)localObject1).hasRemaining()) {
            localObject5 = u.a.SIZE_3;
          }
          break;
        case 11: 
          n = m | ((ByteBuffer)localObject1).get() & 0xFF;
          localObject15 = u.a.PRE_PARSE;
        case 12: 
          if (n < 8)
          {
            localObject2 = new d0("specified frame size %d smaller than minimum SASL frame header size 8", new Object[] { Integer.valueOf(n) });
            localObject5 = u.a.ERROR;
            i = n;
          }
          else if (n > f)
          {
            localObject2 = new d0("specified frame size %d larger than maximum SASL frame size %d", new Object[] { Integer.valueOf(n), Integer.valueOf(f) });
            localObject5 = u.a.ERROR;
            i = n;
          }
          else
          {
            i2 = ((ByteBuffer)localObject1).remaining();
            i = n - 4;
            i1 = n;
            localObject16 = localObject15;
            if (i2 < i)
            {
              localObject5 = ByteBuffer.allocate(i);
              d = ((ByteBuffer)localObject5);
              ((ByteBuffer)localObject5).put((ByteBuffer)localObject1);
              localObject5 = u.a.BUFFERING;
              i = n;
            }
          }
          break;
        case 13: 
          localObject17 = localObject1;
          i2 = i1;
          localObject18 = localObject6;
          if (d != null)
          {
            if (((ByteBuffer)localObject1).remaining() < d.remaining())
            {
              d.put((ByteBuffer)localObject1);
              i = i1;
              localObject5 = localObject16;
              continue;
            }
            localObject5 = ((ByteBuffer)localObject1).duplicate();
            i = ((ByteBuffer)localObject5).position();
            ((ByteBuffer)localObject5).limit(d.remaining() + i);
            i = ((ByteBuffer)localObject1).position();
            ((ByteBuffer)localObject1).position(d.remaining() + i);
            d.put((ByteBuffer)localObject5);
            d.flip();
            localObject17 = d;
            localObject5 = u.a.PARSING;
            localObject18 = localObject1;
            i2 = i1;
          }
        case 14: 
          i = ((ByteBuffer)localObject17).get() << 2 & 0x3FF;
          if (i < 8)
          {
            localObject2 = new d0("specified frame data offset %d smaller than minimum frame header size %d", new Object[] { Integer.valueOf(i), Integer.valueOf(8) });
            localObject5 = u.a.ERROR;
            localObject1 = localObject17;
            i = i2;
            localObject6 = localObject18;
          }
          else if (i > i2)
          {
            localObject2 = new d0("specified frame data offset %d larger than the frame size %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i2) });
            localObject5 = u.a.ERROR;
            localObject1 = localObject17;
            i = i2;
            localObject6 = localObject18;
          }
          else
          {
            i1 = ((ByteBuffer)localObject17).get() & 0xFF;
            ((ByteBuffer)localObject17).get();
            ((ByteBuffer)localObject17).get();
            if (i1 != 1)
            {
              localObject2 = new d0("unknown frame type: %d", new Object[] { Integer.valueOf(i1) });
              localObject5 = u.a.ERROR;
              localObject1 = localObject17;
              i = i2;
              localObject6 = localObject18;
            }
            else
            {
              if (i != 8) {
                ((ByteBuffer)localObject17).position(((ByteBuffer)localObject17).position() + i - 8);
              }
              if (localObject18 == null)
              {
                localObject1 = ((ByteBuffer)localObject17).duplicate();
                i = ((ByteBuffer)localObject1).position() + i2 - i;
                ((ByteBuffer)localObject1).limit(i);
                ((ByteBuffer)localObject17).position(i);
                localObject5 = localObject17;
              }
              else
              {
                localObject1 = localObject17;
                localObject5 = localObject18;
              }
              try
              {
                localObject6 = e;
                localObject6 = (r)localObject6;
                ((r)localObject6).a((ByteBuffer)localObject1);
                localObject6 = e;
                localObject6 = (r)localObject6;
                localObject18 = ((r)localObject6).d();
                if (((ByteBuffer)localObject1).hasRemaining())
                {
                  localObject17 = new byte[((ByteBuffer)localObject1).remaining()];
                  ((ByteBuffer)localObject1).get((byte[])localObject17);
                  localObject6 = new k/a/b/a/b/a;
                  ((k.a.b.a.b.a)localObject6).<init>((byte[])localObject17);
                }
                else
                {
                  localObject6 = null;
                }
                if (!(localObject18 instanceof k.a.b.a.b.l.c)) {
                  break label1855;
                }
                localObject18 = (k.a.b.a.b.l.c)localObject18;
                localObject17 = (v)a;
                localObject15 = d;
                localObject9 = a0.E0;
                if (!((a0)localObject15).Z()) {
                  break label1765;
                }
                ((a0)localObject15).a((String)localObject9, 0, localObject18, null);
              }
              catch (q localq3)
              {
                for (;;) {}
              }
              break label1917;
              localObject15 = d.V();
              if (localObject15 != null) {
                ((p)localObject15).c();
              }
              try
              {
                ((k.a.b.a.b.l.c)localObject18).a((c.a)localObject17, (k.a.b.a.b.a)localObject6, null);
                c = 0;
                b = u.a.SIZE_0;
                try
                {
                  d = null;
                  localObject6 = u.a.SIZE_0;
                  localObject17 = null;
                  localObject1 = localObject5;
                  i = i2;
                  localObject5 = localObject6;
                  localObject6 = localObject17;
                }
                catch (q localq1)
                {
                  localObject6 = null;
                  localObject1 = localObject5;
                  localObject5 = localObject6;
                  break label1917;
                }
                localObject17 = u.a.ERROR;
                if (localObject18 == null) {
                  localObject3 = "null";
                } else {
                  localObject3 = localObject18.getClass();
                }
                Object localObject3 = new d0("Unexpected frame type encountered. Found a %s which does not implement %s", new Object[] { localObject3, k.a.b.a.b.l.c.class });
                localObject6 = localObject5;
              }
              catch (q localq2) {}
              localObject17 = u.a.ERROR;
              localObject4 = new d0(localq3);
              localObject6 = localObject5;
              i = i2;
              localObject5 = localObject17;
            }
          }
          break;
        }
      }
      b = ((u.a)localObject5);
      c = i;
      if (localObject5 == u.a.ERROR)
      {
        if (localObject4 != null) {
          throw ((Throwable)localObject4);
        }
        throw new d0("Unable to parse, probably because of a previous error");
      }
    }
    if (!a())
    {
      if (v.y.isLoggable(Level.FINER))
      {
        localObject4 = v.y;
        localObject1 = Level.FINER;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(h);
        ((StringBuilder)localObject5).append(" about to call plain input");
        ((Logger)localObject4).log((Level)localObject1, ((StringBuilder)localObject5).toString());
      }
      if (e.hasRemaining())
      {
        if (e.c.a.a.b.l.c.a(e, a) == -1) {
          h.e = true;
        }
        if (!e.hasRemaining())
        {
          localObject5 = g;
          c = a;
        }
      }
      else
      {
        localObject5 = g;
        c = a;
      }
      a.process();
    }
  }
  
  public int capacity()
  {
    if (h.e) {
      return -1;
    }
    if (a()) {
      return e.remaining();
    }
    return a.capacity();
  }
  
  public void close_head()
  {
    v.d locald = g;
    d = b;
    b.close_head();
  }
  
  public void close_tail()
  {
    h.e = true;
    if (a())
    {
      h.f = true;
      a.close_tail();
    }
    else
    {
      a.close_tail();
    }
  }
  
  public ByteBuffer head()
  {
    if ((!b()) && (d.position() == 0))
    {
      v.d locald = g;
      d = b;
      return b.head();
    }
    pending();
    return f;
  }
  
  public int pending()
  {
    Object localObject1;
    if ((!b()) && (d.position() == 0))
    {
      localObject1 = g;
      d = b;
      return b.pending();
    }
    if (b())
    {
      Object localObject2 = h;
      Object localObject3;
      if (!j)
      {
        if (d.X())
        {
          d.a(a0.F0, "SASL");
          localObject1 = d.V();
          if (localObject1 != null) {
            ((p)localObject1).d();
          }
        }
        localObject1 = h;
        localObject3 = b.b;
        c.a((byte[])localObject3, 0, localObject3.length);
        j = true;
        int i = b.b.length;
      }
      localObject1 = v;
      if (localObject1 == v.b.SERVER)
      {
        if ((!n) && (t != null))
        {
          localObject1 = new e();
          ((e)localObject1).a(t);
          h.a(0, localObject1, null, null);
          n = true;
          q = k.a.b.a.d.v.b.PN_SASL_STEP;
        }
        if ((q == k.a.b.a.d.v.b.PN_SASL_STEP) && (k != null))
        {
          localObject3 = new k.a.b.a.b.l.a();
          localObject1 = k;
          if (localObject1 != null)
          {
            a = ((k.a.b.a.b.a)localObject1);
            h.a(0, localObject3, null, null);
            k = null;
          }
          else
          {
            throw new NullPointerException("the challenge field is mandatory");
          }
        }
        if (s)
        {
          localObject3 = new k.a.b.a.b.l.f();
          localObject1 = k.a.b.a.b.l.b.values()[p.getCode()];
          if (localObject1 != null)
          {
            a = ((k.a.b.a.b.l.b)localObject1);
            if (p == k.a.b.a.d.v.a) {
              b = k;
            }
            h.a(0, localObject3, null, null);
            k = null;
          }
          else
          {
            throw new NullPointerException("the code field is mandatory");
          }
        }
      }
      else if (localObject1 == v.b.CLIENT)
      {
        if ((q == k.a.b.a.d.v.b.PN_SASL_IDLE) && (u != null))
        {
          localObject1 = new d();
          c = r;
          localObject3 = u;
          if (localObject3 != null)
          {
            a = ((k.a.b.a.b.f)localObject3);
            localObject3 = k;
            if (localObject3 != null)
            {
              b = ((k.a.b.a.b.a)localObject3);
              k = null;
            }
            o = true;
            h.a(0, localObject1, null, null);
            q = k.a.b.a.d.v.b.PN_SASL_STEP;
            localObject1 = p;
            if (localObject1 != v.a.PN_SASL_NONE)
            {
              if (localObject1 == v.a.PN_SASL_OK) {
                localObject1 = k.a.b.a.d.v.b.PN_SASL_PASS;
              } else {
                localObject1 = k.a.b.a.d.v.b.PN_SASL_FAIL;
              }
              q = ((k.a.b.a.d.v.b)localObject1);
            }
          }
          else
          {
            throw new NullPointerException("the mechanism field is mandatory");
          }
        }
        if ((q == k.a.b.a.d.v.b.PN_SASL_STEP) && (k != null))
        {
          localObject3 = new g();
          localObject1 = k;
          if (localObject1 != null)
          {
            a = ((k.a.b.a.b.a)localObject1);
            k = null;
            h.a(0, localObject3, null, null);
          }
          else
          {
            throw new NullPointerException("the response field is mandatory");
          }
        }
      }
      h.h.a(d);
      if (v.y.isLoggable(Level.FINER))
      {
        localObject1 = v.y;
        localObject2 = Level.FINER;
        localObject3 = e.a.a.a.a.a("Finished writing SASL output. Output Buffer : ");
        ((StringBuilder)localObject3).append(d);
        ((Logger)localObject1).log((Level)localObject2, ((StringBuilder)localObject3).toString());
      }
      if (h.s) {
        c = true;
      }
    }
    f.limit(d.position());
    if ((h.f) && (d.position() == 0)) {
      return -1;
    }
    return d.position();
  }
  
  public void pop(int paramInt)
  {
    if ((!b()) && (d.position() == 0))
    {
      v.d locald = g;
      d = b;
      b.pop(paramInt);
    }
    else
    {
      d.flip();
      d.position(paramInt);
      d.compact();
      f.position(0);
      f.limit(d.position());
    }
  }
  
  public int position()
  {
    if (h.e) {
      return -1;
    }
    if (a()) {
      return e.position();
    }
    return a.position();
  }
  
  public void process()
  {
    e.flip();
    try
    {
      c();
      return;
    }
    finally
    {
      e.compact();
    }
  }
  
  public ByteBuffer tail()
  {
    if (!a()) {
      return a.tail();
    }
    return e;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.v.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */