package k.a.b.a.d.g0;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.a.b.a.b.n.l;
import k.a.b.a.c.q;
import k.a.b.a.c.r;
import k.a.b.a.d.d0;

public class i
  implements b0
{
  public static final Logger m = Logger.getLogger("proton.trace");
  public static final ByteBuffer n = ByteBuffer.allocate(0);
  public final h a;
  public final k.a.b.a.c.i b;
  public final int c;
  public final int d;
  public final a0 e;
  public ByteBuffer f = null;
  public boolean g = false;
  public i.a h = i.a.HEADER0;
  public long i = 0L;
  public int j;
  public ByteBuffer k;
  public k.a.b.a.e.a l;
  
  public i(h paramh, k.a.b.a.c.i parami, int paramInt, a0 parama0)
  {
    a = paramh;
    b = parami;
    d = paramInt;
    if (paramInt <= 0) {
      paramInt = 16384;
    }
    c = paramInt;
    e = parama0;
  }
  
  public final void a()
  {
    if ((l != null) && (((a0)a).Y()))
    {
      h localh = a;
      k.a.b.a.e.a locala = l;
      g = ((a0)localh).a(locala);
      l = null;
    }
  }
  
  public final void a(ByteBuffer paramByteBuffer)
  {
    a();
    if (l != null) {
      return;
    }
    int i1 = j;
    Object localObject1 = h;
    int i2 = 1;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = paramByteBuffer;
    paramByteBuffer = (ByteBuffer)localObject1;
    label1743:
    label2231:
    Object localObject6;
    while ((((ByteBuffer)localObject4).hasRemaining()) && (paramByteBuffer != i.a.ERROR) && (i2 != 0))
    {
      Object localObject7 = paramByteBuffer;
      Object localObject8 = paramByteBuffer;
      Object localObject9 = paramByteBuffer;
      Object localObject10 = paramByteBuffer;
      Object localObject11 = paramByteBuffer;
      Object localObject12 = paramByteBuffer;
      Object localObject13 = paramByteBuffer;
      Object localObject14 = paramByteBuffer;
      int i3 = i1;
      int i4 = i1;
      int i5 = i1;
      int i6 = i1;
      Object localObject15 = paramByteBuffer;
      int i7 = i1;
      Object localObject16 = paramByteBuffer;
      localObject1 = localObject4;
      int i8 = i1;
      Object localObject17 = localObject3;
      byte b1;
      switch (paramByteBuffer.ordinal())
      {
      default: 
        break;
      case 0: 
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[0])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[0]), paramByteBuffer });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject7 = i.a.HEADER1;
          }
        }
        break;
      case 1: 
        paramByteBuffer = (ByteBuffer)localObject7;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[1])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[1]), localObject7 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject8 = i.a.HEADER2;
          }
        }
        break;
      case 2: 
        paramByteBuffer = (ByteBuffer)localObject8;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[2])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[2]), localObject8 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject9 = i.a.HEADER3;
          }
        }
        break;
      case 3: 
        paramByteBuffer = (ByteBuffer)localObject9;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[3])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[3]), localObject9 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject10 = i.a.HEADER4;
          }
        }
        break;
      case 4: 
        paramByteBuffer = (ByteBuffer)localObject10;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[4])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[4]), localObject10 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject11 = i.a.HEADER5;
          }
        }
        break;
      case 5: 
        paramByteBuffer = (ByteBuffer)localObject11;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[5])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[5]), localObject11 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject12 = i.a.HEADER6;
          }
        }
        break;
      case 6: 
        paramByteBuffer = (ByteBuffer)localObject12;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[6])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[6]), localObject12 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            localObject13 = i.a.HEADER7;
          }
        }
        break;
      case 7: 
        paramByteBuffer = (ByteBuffer)localObject13;
        if (((ByteBuffer)localObject4).hasRemaining())
        {
          b1 = ((ByteBuffer)localObject4).get();
          if (b1 != b.a[7])
          {
            localObject1 = new d0("AMQP header mismatch value %x, expecting %x. In state: %s", new Object[] { Byte.valueOf(b1), Byte.valueOf(b.a[7]), localObject13 });
            paramByteBuffer = i.a.ERROR;
          }
          else
          {
            if (e.X())
            {
              e.a(a0.E0, "AMQP");
              paramByteBuffer = e.V();
              if (paramByteBuffer != null) {
                paramByteBuffer.a();
              }
            }
            localObject14 = i.a.SIZE_0;
          }
        }
        break;
      case 8: 
        if (!((ByteBuffer)localObject4).hasRemaining())
        {
          paramByteBuffer = (ByteBuffer)localObject14;
        }
        else if (((ByteBuffer)localObject4).remaining() >= 4)
        {
          i1 = ((ByteBuffer)localObject4).getInt();
          paramByteBuffer = i.a.PRE_PARSE;
          localObject1 = localObject2;
        }
        else
        {
          i1 = ((ByteBuffer)localObject4).get() << 24 & 0xFF000000;
          i3 = i1;
          if (!((ByteBuffer)localObject4).hasRemaining())
          {
            paramByteBuffer = i.a.SIZE_1;
            localObject1 = localObject2;
          }
        }
        break;
      case 9: 
        i1 = i3 | ((ByteBuffer)localObject4).get() << 16 & 0xFF0000;
        i4 = i1;
        if (!((ByteBuffer)localObject4).hasRemaining())
        {
          paramByteBuffer = i.a.SIZE_2;
          localObject1 = localObject2;
        }
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
        for (;;)
        {
          localObject2 = localObject1;
          break;
          i1 = i4 | ((ByteBuffer)localObject4).get() << 8 & 0xFF00;
          i5 = i1;
          if (!((ByteBuffer)localObject4).hasRemaining())
          {
            paramByteBuffer = i.a.SIZE_3;
            localObject1 = localObject2;
          }
          else
          {
            i6 = i5 | ((ByteBuffer)localObject4).get() & 0xFF;
            localObject15 = i.a.PRE_PARSE;
            if (i6 < 8)
            {
              localObject1 = new d0("specified frame size %d smaller than minimum frame header size %d", new Object[] { Integer.valueOf(i6), Integer.valueOf(8) });
              paramByteBuffer = i.a.ERROR;
              i1 = i6;
            }
            else
            {
              i1 = d;
              if ((i1 > 0) && (i6 > i1))
              {
                localObject1 = new d0("specified frame size %d greater than maximum valid frame size %d", new Object[] { Integer.valueOf(i6), Integer.valueOf(d) });
                paramByteBuffer = i.a.ERROR;
                i1 = i6;
              }
              else
              {
                i1 = ((ByteBuffer)localObject4).remaining();
                i8 = i6 - 4;
                i7 = i6;
                localObject16 = localObject15;
                if (i1 < i8)
                {
                  paramByteBuffer = ByteBuffer.allocate(i8);
                  k = paramByteBuffer;
                  paramByteBuffer.put((ByteBuffer)localObject4);
                  paramByteBuffer = i.a.BUFFERING;
                  i1 = i6;
                  localObject1 = localObject2;
                }
                else
                {
                  localObject1 = localObject4;
                  i8 = i7;
                  localObject17 = localObject3;
                  if (k != null)
                  {
                    if (((ByteBuffer)localObject4).remaining() < k.remaining())
                    {
                      k.put((ByteBuffer)localObject4);
                      i1 = i7;
                      paramByteBuffer = (ByteBuffer)localObject16;
                      break;
                    }
                    paramByteBuffer = ((ByteBuffer)localObject4).duplicate();
                    i1 = paramByteBuffer.position();
                    paramByteBuffer.limit(k.remaining() + i1);
                    i1 = ((ByteBuffer)localObject4).position();
                    ((ByteBuffer)localObject4).position(k.remaining() + i1);
                    k.put(paramByteBuffer);
                    k.flip();
                    localObject1 = k;
                    paramByteBuffer = i.a.PARSING;
                    localObject17 = localObject4;
                    i8 = i7;
                  }
                  i1 = ((ByteBuffer)localObject1).get() << 2 & 0x3FF;
                  if (i1 < 8)
                  {
                    localObject3 = new d0("specified frame data offset %d smaller than minimum frame header size %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(8) });
                    paramByteBuffer = i.a.ERROR;
                    localObject4 = localObject1;
                    i1 = i8;
                    localObject1 = localObject3;
                    localObject3 = localObject17;
                  }
                  else if (i1 > i8)
                  {
                    localObject3 = new d0("specified frame data offset %d larger than the frame size %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i8) });
                    paramByteBuffer = i.a.ERROR;
                    localObject4 = localObject1;
                    i1 = i8;
                    localObject1 = localObject3;
                    localObject3 = localObject17;
                  }
                  else
                  {
                    i7 = ((ByteBuffer)localObject1).get() & 0xFF;
                    i6 = ((ByteBuffer)localObject1).getShort() & 0xFFFF;
                    if (i7 != 0)
                    {
                      localObject3 = new d0("unknown frame type: %d", new Object[] { Integer.valueOf(i7) });
                      paramByteBuffer = i.a.ERROR;
                      localObject4 = localObject1;
                      i1 = i8;
                      localObject1 = localObject3;
                      localObject3 = localObject17;
                    }
                    else
                    {
                      if (i1 != 8) {
                        ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).position() + i1 - 8);
                      }
                      i7 = i8 - i1;
                      if (localObject17 == null)
                      {
                        localObject4 = ((ByteBuffer)localObject1).duplicate();
                        i1 = ((ByteBuffer)localObject4).position() + i7;
                        ((ByteBuffer)localObject4).limit(i1);
                        ((ByteBuffer)localObject1).position(i1);
                        paramByteBuffer = (ByteBuffer)localObject1;
                        localObject1 = localObject4;
                      }
                      else
                      {
                        paramByteBuffer = (ByteBuffer)localObject17;
                      }
                      i1 = i2;
                      try
                      {
                        i += 1L;
                        if (i7 > 0)
                        {
                          i1 = i2;
                          localObject4 = b;
                          localObject4 = (r)localObject4;
                          i1 = i2;
                          ((r)localObject4).a((ByteBuffer)localObject1);
                          i1 = i2;
                          localObject4 = b;
                          localObject4 = (r)localObject4;
                          i1 = i2;
                          localObject3 = ((r)localObject4).d();
                          i1 = i2;
                          localObject4 = b;
                          localObject4 = (r)localObject4;
                          i1 = i2;
                          ((r)localObject4).a(null);
                          localObject4 = localObject3;
                          i1 = i2;
                          if (((ByteBuffer)localObject1).hasRemaining())
                          {
                            i1 = i2;
                            localObject4 = new byte[((ByteBuffer)localObject1).remaining()];
                            i1 = i2;
                            ((ByteBuffer)localObject1).get((byte[])localObject4);
                            i1 = i2;
                            localObject17 = new k/a/b/a/b/a;
                            i1 = i2;
                            ((k.a.b.a.b.a)localObject17).<init>((byte[])localObject4);
                            localObject4 = localObject3;
                            localObject3 = localObject17;
                            break label1743;
                          }
                        }
                        else
                        {
                          i1 = i2;
                          localObject4 = k.a.b.a.b.n.h.a;
                        }
                        localObject3 = null;
                        i1 = i2;
                        if ((localObject4 instanceof l))
                        {
                          i1 = i2;
                          localObject17 = (l)localObject4;
                          i1 = i2;
                          if (m.isLoggable(Level.FINE))
                          {
                            i1 = i2;
                            localObject13 = m;
                            i1 = i2;
                            localObject11 = Level.FINE;
                            i1 = i2;
                            localObject15 = new java/lang/StringBuilder;
                            i1 = i2;
                            ((StringBuilder)localObject15).<init>();
                            i1 = i2;
                            ((StringBuilder)localObject15).append("IN: CH[");
                            i1 = i2;
                            ((StringBuilder)localObject15).append(i6);
                            i1 = i2;
                            ((StringBuilder)localObject15).append("] : ");
                            i1 = i2;
                            ((StringBuilder)localObject15).append(localObject17);
                            if (localObject3 == null)
                            {
                              localObject4 = "";
                            }
                            else
                            {
                              i1 = i2;
                              localObject4 = new java/lang/StringBuilder;
                              i1 = i2;
                              ((StringBuilder)localObject4).<init>();
                              i1 = i2;
                              ((StringBuilder)localObject4).append("[");
                              i1 = i2;
                              ((StringBuilder)localObject4).append(localObject3);
                              i1 = i2;
                              ((StringBuilder)localObject4).append("]");
                              i1 = i2;
                              localObject4 = ((StringBuilder)localObject4).toString();
                            }
                            i1 = i2;
                            ((StringBuilder)localObject15).append((String)localObject4);
                            i1 = i2;
                            ((Logger)localObject13).log((Level)localObject11, ((StringBuilder)localObject15).toString());
                          }
                          i1 = i2;
                          localObject4 = new k/a/b/a/e/a;
                          i1 = i2;
                          ((k.a.b.a.e.a)localObject4).<init>(i6, (l)localObject17, (k.a.b.a.b.a)localObject3);
                          i1 = i2;
                          localObject3 = a;
                          localObject3 = (a0)localObject3;
                          i1 = i2;
                          if (((a0)localObject3).Y())
                          {
                            i1 = i2;
                            localObject3 = a;
                            localObject3 = (a0)localObject3;
                            i1 = i2;
                            g = ((a0)localObject3).a((k.a.b.a.e.a)localObject4);
                          }
                          try
                          {
                            l = ((k.a.b.a.e.a)localObject4);
                            i2 = 0;
                            i1 = i2;
                            j = 0;
                            i1 = i2;
                            h = i.a.SIZE_0;
                            try
                            {
                              k = null;
                              localObject1 = i.a.SIZE_0;
                              localObject3 = null;
                              localObject4 = paramByteBuffer;
                              i1 = i8;
                              paramByteBuffer = (ByteBuffer)localObject1;
                            }
                            catch (q localq1)
                            {
                              localObject3 = null;
                              localObject1 = paramByteBuffer;
                              break label2231;
                            }
                            i1 = i2;
                          }
                          catch (q localq2)
                          {
                            i2 = 0;
                            localObject3 = paramByteBuffer;
                          }
                        }
                        localObject3 = new k/a/b/a/d/d0;
                        i1 = i2;
                        localObject17 = new java/lang/StringBuilder;
                        i1 = i2;
                        ((StringBuilder)localObject17).<init>();
                        i1 = i2;
                        ((StringBuilder)localObject17).append("Frameparser encountered a ");
                        Object localObject5;
                        if (localq2 == null)
                        {
                          localObject5 = "null";
                        }
                        else
                        {
                          i1 = i2;
                          localObject5 = localObject5.getClass();
                        }
                        i1 = i2;
                        ((StringBuilder)localObject17).append(localObject5);
                        i1 = i2;
                        ((StringBuilder)localObject17).append(" which is not a ");
                        i1 = i2;
                        ((StringBuilder)localObject17).append(l.class);
                        i1 = i2;
                        ((d0)localObject3).<init>(((StringBuilder)localObject17).toString());
                        i1 = i2;
                        throw ((Throwable)localObject3);
                      }
                      catch (q localq3)
                      {
                        localObject3 = paramByteBuffer;
                        i2 = i1;
                        paramByteBuffer = i.a.ERROR;
                        localObject17 = new d0(localq3);
                        localObject6 = localObject1;
                        i1 = i8;
                        localObject1 = localObject17;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    localObject1 = paramByteBuffer;
    localObject3 = localObject2;
    if (g) {
      if (((ByteBuffer)localObject6).hasRemaining())
      {
        localObject1 = i.a.ERROR;
        localObject3 = new d0("framing error");
      }
      else if (paramByteBuffer != i.a.SIZE_0)
      {
        localObject1 = i.a.ERROR;
        localObject3 = new d0("connection aborted");
      }
      else
      {
        ((a0)a).a(null);
        localObject3 = localObject2;
        localObject1 = paramByteBuffer;
      }
    }
    h = ((i.a)localObject1);
    j = i1;
    if (localObject1 == i.a.ERROR)
    {
      g = true;
      if (localObject3 != null) {
        ((a0)a).a((d0)localObject3);
      } else {
        throw new d0("Unable to parse, probably because of a previous error");
      }
    }
  }
  
  public int capacity()
  {
    if (g) {
      return -1;
    }
    ByteBuffer localByteBuffer = f;
    if (localByteBuffer != null) {
      return localByteBuffer.remaining();
    }
    return c;
  }
  
  public void close_tail()
  {
    g = true;
    process();
  }
  
  public int position()
  {
    if (g) {
      return -1;
    }
    ByteBuffer localByteBuffer = f;
    int i1;
    if (localByteBuffer == null) {
      i1 = 0;
    } else {
      i1 = localByteBuffer.position();
    }
    return i1;
  }
  
  /* Error */
  public void process()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +122 -> 128
    //   9: aload_1
    //   10: invokevirtual 229	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   13: pop
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   19: invokevirtual 342	k/a/b/a/d/g0/i:a	(Ljava/nio/ByteBuffer;)V
    //   22: aload_0
    //   23: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   26: invokevirtual 99	java/nio/ByteBuffer:hasRemaining	()Z
    //   29: ifeq +14 -> 43
    //   32: aload_0
    //   33: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   36: invokevirtual 345	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   39: pop
    //   40: goto +95 -> 135
    //   43: aload_0
    //   44: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   47: invokevirtual 347	java/nio/ByteBuffer:capacity	()I
    //   50: getstatic 350	k/a/b/a/d/g0/a0:B0	I
    //   53: if_icmple +11 -> 64
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   61: goto +74 -> 135
    //   64: aload_0
    //   65: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   68: invokevirtual 353	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   71: pop
    //   72: goto +63 -> 135
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   80: invokevirtual 99	java/nio/ByteBuffer:hasRemaining	()Z
    //   83: ifne +35 -> 118
    //   86: aload_0
    //   87: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   90: invokevirtual 347	java/nio/ByteBuffer:capacity	()I
    //   93: getstatic 350	k/a/b/a/d/g0/a0:B0	I
    //   96: if_icmple +11 -> 107
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   104: goto +22 -> 126
    //   107: aload_0
    //   108: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   111: invokevirtual 353	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   114: pop
    //   115: goto +11 -> 126
    //   118: aload_0
    //   119: getfield 59	k/a/b/a/d/g0/i:f	Ljava/nio/ByteBuffer;
    //   122: invokevirtual 345	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   125: pop
    //   126: aload_1
    //   127: athrow
    //   128: aload_0
    //   129: getstatic 52	k/a/b/a/d/g0/i:n	Ljava/nio/ByteBuffer;
    //   132: invokevirtual 342	k/a/b/a/d/g0/i:a	(Ljava/nio/ByteBuffer;)V
    //   135: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	i
    //   4	6	1	localByteBuffer	ByteBuffer
    //   75	52	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	22	75	finally
  }
  
  public ByteBuffer tail()
  {
    if (!g)
    {
      if (f == null) {
        f = ByteBuffer.allocate(c);
      }
      return f;
    }
    throw new d0("tail closed");
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */