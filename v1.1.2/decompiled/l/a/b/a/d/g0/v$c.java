package l.a.b.a.d.g0;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.a.b.a.b.l.c.a;
import l.a.b.a.b.l.d;
import l.a.b.a.b.l.e;
import l.a.b.a.b.l.g;
import l.a.b.a.c.q;
import l.a.b.a.c.r;
import l.a.b.a.d.d0;
import l.a.b.a.d.v.a;

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
    Object localObject2;
    label1765:
    label1851:
    label1913:
    Object localObject5;
    if (a())
    {
      if (v.y.isLoggable(Level.FINER))
      {
        localObject1 = v.y;
        localObject2 = Level.FINER;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(h);
        ((StringBuilder)localObject3).append(" about to call input.");
        ((Logger)localObject1).log((Level)localObject2, ((StringBuilder)localObject3).toString());
      }
      u localu = h.l;
      localObject2 = e;
      int i = c;
      localObject1 = b;
      Object localObject3 = null;
      Object localObject6 = null;
      while ((((ByteBuffer)localObject2).hasRemaining()) && (localObject1 != u.a.ERROR) && (!((v)a).b()))
      {
        Object localObject7 = localObject1;
        Object localObject8 = localObject1;
        Object localObject9 = localObject1;
        Object localObject10 = localObject1;
        Object localObject11 = localObject1;
        Object localObject12 = localObject1;
        Object localObject13 = localObject1;
        Object localObject14 = localObject1;
        int j = i;
        int k = i;
        int m = i;
        int n = i;
        Object localObject15 = localObject1;
        int i1 = i;
        Object localObject16 = localObject1;
        Object localObject17 = localObject2;
        int i2 = i;
        Object localObject18 = localObject6;
        byte b1;
        switch (((Enum)localObject1).ordinal())
        {
        default: 
          break;
        case 0: 
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[0])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[0]), localObject1 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject7 = u.a.HEADER1;
            }
          }
          break;
        case 1: 
          localObject1 = localObject7;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[1])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[1]), localObject7 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject8 = u.a.HEADER2;
            }
          }
          break;
        case 2: 
          localObject1 = localObject8;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[2])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[2]), localObject8 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject9 = u.a.HEADER3;
            }
          }
          break;
        case 3: 
          localObject1 = localObject9;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[3])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[3]), localObject9 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject10 = u.a.HEADER4;
            }
          }
          break;
        case 4: 
          localObject1 = localObject10;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[4])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[4]), localObject10 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject11 = u.a.HEADER5;
            }
          }
          break;
        case 5: 
          localObject1 = localObject11;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[5])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[5]), localObject11 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject12 = u.a.HEADER6;
            }
          }
          break;
        case 6: 
          localObject1 = localObject12;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[6])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[6]), localObject12 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              localObject13 = u.a.HEADER7;
            }
          }
          break;
        case 7: 
          localObject1 = localObject13;
          if (((ByteBuffer)localObject2).hasRemaining())
          {
            b1 = ((ByteBuffer)localObject2).get();
            if (b1 != b.b[7])
            {
              localObject3 = new d0("AMQP SASL header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.b[7]), localObject13 });
              localObject1 = u.a.ERROR;
            }
            else
            {
              if (g.W())
              {
                g.a(a0.E0, "SASL");
                localObject1 = g.U();
                if (localObject1 != null) {
                  ((p)localObject1).b();
                }
              }
              localObject14 = u.a.SIZE_0;
            }
          }
          break;
        case 8: 
          if (!((ByteBuffer)localObject2).hasRemaining())
          {
            localObject1 = localObject14;
          }
          else if (((ByteBuffer)localObject2).remaining() >= 4)
          {
            i = ((ByteBuffer)localObject2).getInt();
            localObject1 = u.a.PRE_PARSE;
          }
          else
          {
            i = ((ByteBuffer)localObject2).get() << 24 & 0xFF000000;
            j = i;
            if (!((ByteBuffer)localObject2).hasRemaining()) {
              localObject1 = u.a.SIZE_1;
            }
          }
          break;
        case 9: 
          i = j | ((ByteBuffer)localObject2).get() << 16 & 0xFF0000;
          k = i;
          if (!((ByteBuffer)localObject2).hasRemaining()) {
            localObject1 = u.a.SIZE_2;
          }
          break;
        case 10: 
          i = k | ((ByteBuffer)localObject2).get() << 8 & 0xFF00;
          m = i;
          if (!((ByteBuffer)localObject2).hasRemaining()) {
            localObject1 = u.a.SIZE_3;
          }
          break;
        case 11: 
          n = m | ((ByteBuffer)localObject2).get() & 0xFF;
          localObject15 = u.a.PRE_PARSE;
        case 12: 
          if (n < 8)
          {
            localObject3 = new d0("specified frame size %d smaller than minimum SASL frame header size 8", new Object[] { Integer.valueOf(n) });
            localObject1 = u.a.ERROR;
            i = n;
          }
          else if (n > f)
          {
            localObject3 = new d0("specified frame size %d larger than maximum SASL frame size %d", new Object[] { Integer.valueOf(n), Integer.valueOf(f) });
            localObject1 = u.a.ERROR;
            i = n;
          }
          else
          {
            i = ((ByteBuffer)localObject2).remaining();
            i2 = n - 4;
            i1 = n;
            localObject16 = localObject15;
            if (i < i2)
            {
              localObject1 = ByteBuffer.allocate(i2);
              d = ((ByteBuffer)localObject1);
              ((ByteBuffer)localObject1).put((ByteBuffer)localObject2);
              localObject1 = u.a.BUFFERING;
              i = n;
            }
          }
          break;
        case 13: 
          localObject17 = localObject2;
          i2 = i1;
          localObject18 = localObject6;
          if (d != null)
          {
            if (((ByteBuffer)localObject2).remaining() < d.remaining())
            {
              d.put((ByteBuffer)localObject2);
              i = i1;
              localObject1 = localObject16;
              continue;
            }
            localObject1 = ((ByteBuffer)localObject2).duplicate();
            i = ((ByteBuffer)localObject1).position();
            ((ByteBuffer)localObject1).limit(d.remaining() + i);
            i = ((ByteBuffer)localObject2).position();
            ((ByteBuffer)localObject2).position(d.remaining() + i);
            d.put((ByteBuffer)localObject1);
            d.flip();
            localObject17 = d;
            localObject1 = u.a.PARSING;
            localObject18 = localObject2;
            i2 = i1;
          }
        case 14: 
          i1 = ((ByteBuffer)localObject17).get() << 2 & 0x3FF;
          if (i1 < 8)
          {
            localObject3 = new d0("specified frame data offset %d smaller than minimum frame header size %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(8) });
            localObject1 = u.a.ERROR;
            localObject2 = localObject17;
            i = i2;
            localObject6 = localObject18;
          }
          else if (i1 > i2)
          {
            localObject3 = new d0("specified frame data offset %d larger than the frame size %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
            localObject1 = u.a.ERROR;
            localObject2 = localObject17;
            i = i2;
            localObject6 = localObject18;
          }
          else
          {
            i = ((ByteBuffer)localObject17).get() & 0xFF;
            ((ByteBuffer)localObject17).get();
            ((ByteBuffer)localObject17).get();
            if (i != 1)
            {
              localObject3 = new d0("unknown frame type: %d", new Object[] { Integer.valueOf(i) });
              localObject1 = u.a.ERROR;
              localObject2 = localObject17;
              i = i2;
              localObject6 = localObject18;
            }
            else
            {
              if (i1 != 8) {
                ((ByteBuffer)localObject17).position(((ByteBuffer)localObject17).position() + i1 - 8);
              }
              if (localObject18 == null)
              {
                localObject2 = ((ByteBuffer)localObject17).duplicate();
                i = ((ByteBuffer)localObject2).position() + i2 - i1;
                ((ByteBuffer)localObject2).limit(i);
                ((ByteBuffer)localObject17).position(i);
                localObject1 = localObject17;
              }
              else
              {
                localObject2 = localObject17;
                localObject1 = localObject18;
              }
              try
              {
                localObject6 = e;
                localObject6 = (r)localObject6;
                ((r)localObject6).a((ByteBuffer)localObject2);
                localObject6 = e;
                localObject6 = (r)localObject6;
                localObject18 = ((r)localObject6).d();
                if (((ByteBuffer)localObject2).hasRemaining())
                {
                  localObject17 = new byte[((ByteBuffer)localObject2).remaining()];
                  ((ByteBuffer)localObject2).get((byte[])localObject17);
                  localObject6 = new l/a/b/a/b/a;
                  ((l.a.b.a.b.a)localObject6).<init>((byte[])localObject17);
                }
                else
                {
                  localObject6 = null;
                }
                if (!(localObject18 instanceof l.a.b.a.b.l.c)) {
                  break label1851;
                }
                localObject18 = (l.a.b.a.b.l.c)localObject18;
                localObject17 = (v)a;
                localObject15 = d;
                localObject14 = a0.E0;
                if (!((a0)localObject15).Y()) {
                  break label1765;
                }
                ((a0)localObject15).a((String)localObject14, 0, localObject18, null);
              }
              catch (q localq3)
              {
                for (;;) {}
              }
              break label1913;
              localObject15 = d.U();
              if (localObject15 != null) {
                ((p)localObject15).d();
              }
              try
              {
                ((l.a.b.a.b.l.c)localObject18).a((c.a)localObject17, (l.a.b.a.b.a)localObject6, null);
                c = 0;
                b = u.a.SIZE_0;
                try
                {
                  d = null;
                  localObject17 = u.a.SIZE_0;
                  localObject6 = null;
                  localObject2 = localObject1;
                  i = i2;
                  localObject1 = localObject17;
                }
                catch (q localq1)
                {
                  localObject6 = null;
                  localObject2 = localObject1;
                  localObject1 = localObject6;
                  break label1913;
                }
                localObject17 = u.a.ERROR;
                if (localObject18 == null) {
                  localObject4 = "null";
                } else {
                  localObject4 = localObject18.getClass();
                }
                Object localObject4 = new d0("Unexpected frame type encountered. Found a %s which does not implement %s", new Object[] { localObject4, l.a.b.a.b.l.c.class });
                localObject6 = localObject1;
              }
              catch (q localq2) {}
              localObject17 = u.a.ERROR;
              localObject5 = new d0(localq3);
              localObject6 = localObject1;
              i = i2;
              localObject1 = localObject17;
            }
          }
          break;
        }
      }
      b = ((u.a)localObject1);
      c = i;
      if (localObject1 == u.a.ERROR)
      {
        if (localObject5 != null) {
          throw ((Throwable)localObject5);
        }
        throw new d0("Unable to parse, probably because of a previous error");
      }
    }
    if (!a())
    {
      if (v.y.isLoggable(Level.FINER))
      {
        localObject2 = v.y;
        localObject5 = Level.FINER;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(h);
        ((StringBuilder)localObject1).append(" about to call plain input");
        ((Logger)localObject2).log((Level)localObject5, ((StringBuilder)localObject1).toString());
      }
      if (e.hasRemaining())
      {
        if (e.c.a.a.b.l.c.a(e, a) == -1) {
          h.e = true;
        }
        if (!e.hasRemaining())
        {
          localObject1 = g;
          c = a;
        }
      }
      else
      {
        localObject1 = g;
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
        if (d.W())
        {
          d.a(a0.F0, "SASL");
          localObject1 = d.U();
          if (localObject1 != null) {
            ((p)localObject1).a();
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
          q = l.a.b.a.d.v.b.PN_SASL_STEP;
        }
        if ((q == l.a.b.a.d.v.b.PN_SASL_STEP) && (k != null))
        {
          localObject1 = new l.a.b.a.b.l.a();
          localObject3 = k;
          if (localObject3 != null)
          {
            a = ((l.a.b.a.b.a)localObject3);
            h.a(0, localObject1, null, null);
            k = null;
          }
          else
          {
            throw new NullPointerException("the challenge field is mandatory");
          }
        }
        if (s)
        {
          localObject3 = new l.a.b.a.b.l.f();
          localObject1 = l.a.b.a.b.l.b.values()[p.getCode()];
          if (localObject1 != null)
          {
            a = ((l.a.b.a.b.l.b)localObject1);
            if (p == l.a.b.a.d.v.a) {
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
        if ((q == l.a.b.a.d.v.b.PN_SASL_IDLE) && (u != null))
        {
          localObject1 = new d();
          c = r;
          localObject3 = u;
          if (localObject3 != null)
          {
            a = ((l.a.b.a.b.f)localObject3);
            localObject3 = k;
            if (localObject3 != null)
            {
              b = ((l.a.b.a.b.a)localObject3);
              k = null;
            }
            o = true;
            h.a(0, localObject1, null, null);
            q = l.a.b.a.d.v.b.PN_SASL_STEP;
            localObject1 = p;
            if (localObject1 != v.a.PN_SASL_NONE)
            {
              if (localObject1 == v.a.PN_SASL_OK) {
                localObject1 = l.a.b.a.d.v.b.PN_SASL_PASS;
              } else {
                localObject1 = l.a.b.a.d.v.b.PN_SASL_FAIL;
              }
              q = ((l.a.b.a.d.v.b)localObject1);
            }
          }
          else
          {
            throw new NullPointerException("the mechanism field is mandatory");
          }
        }
        if ((q == l.a.b.a.d.v.b.PN_SASL_STEP) && (k != null))
        {
          localObject3 = new g();
          localObject1 = k;
          if (localObject1 != null)
          {
            a = ((l.a.b.a.b.a)localObject1);
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
        localObject2 = v.y;
        localObject3 = Level.FINER;
        localObject1 = e.a.a.a.a.a("Finished writing SASL output. Output Buffer : ");
        ((StringBuilder)localObject1).append(d);
        ((Logger)localObject2).log((Level)localObject3, ((StringBuilder)localObject1).toString());
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
 * Qualified Name:     l.a.b.a.d.g0.v.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */