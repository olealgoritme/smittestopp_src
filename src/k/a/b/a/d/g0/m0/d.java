package k.a.b.a.d.g0.m0;

import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import k.a.b.a.d.d0;
import k.a.b.a.d.g0.b0;
import k.a.b.a.d.g0.f0;

public class d
  implements h
{
  public static final Logger l = Logger.getLogger(d.class.getName());
  public final b a;
  public final b0 b;
  public final f0 c;
  public boolean d = false;
  public ByteBuffer e;
  public boolean f = false;
  public ByteBuffer g;
  public ByteBuffer h;
  public ByteBuffer i;
  public String j;
  public String k;
  
  public d(b paramb, b0 paramb0, f0 paramf0)
  {
    b = paramb0;
    c = paramf0;
    a = paramb;
    int m = a.getSession().getApplicationBufferSize();
    int n = a).a.getSession().getPacketBufferSize();
    e = ByteBuffer.allocate(n);
    paramb = ByteBuffer.allocate(n);
    g = paramb;
    paramb = paramb.asReadOnlyBuffer();
    h = paramb;
    paramb.limit(0);
    i = ByteBuffer.allocate(m + 50);
    if (l.isLoggable(Level.FINE))
    {
      paramb = l;
      paramb0 = new StringBuilder();
      paramb0.append("Constructed ");
      paramb0.append(this);
      paramb.fine(paramb0.toString());
    }
  }
  
  public final void a()
  {
    int m = -1;
    for (;;)
    {
      Object localObject1 = a;
      Object localObject2 = e;
      Object localObject3 = i;
      localObject3 = a.unwrap((ByteBuffer)localObject2, (ByteBuffer)localObject3);
      a((SSLEngineResult)localObject3, "input");
      ((SSLEngineResult)localObject3).bytesProduced();
      SSLEngineResult.Status localStatus = ((SSLEngineResult)localObject3).getStatus();
      localObject2 = ((SSLEngineResult)localObject3).getHandshakeStatus();
      int n = b.capacity();
      if ((n != -1) && (n > 0))
      {
        i.flip();
        while ((i.hasRemaining()) && (n > 0))
        {
          localObject1 = b.tail();
          int i1 = i.limit();
          n = i.remaining() - n;
          if (n > 0) {
            i.limit(i1 - n);
          }
          ((ByteBuffer)localObject1).put(i);
          i.limit(i1);
          b.process();
          n = b.capacity();
        }
        if ((n == -1) || (n <= 0))
        {
          d = true;
          if (i.hasRemaining()) {}
        }
        else
        {
          i.compact();
          break label261;
        }
        throw new d0("bytes left unconsumed");
      }
      else
      {
        d = true;
        if (i.position() > 0) {
          break label503;
        }
      }
      label261:
      n = d.a.a[localStatus.ordinal()];
      if (n != 1)
      {
        if (n != 2)
        {
          if ((n == 3) && (d)) {
            f = true;
          }
        }
        else
        {
          localObject2 = i;
          i = ByteBuffer.allocate(((ByteBuffer)localObject2).capacity() * 2);
          ((ByteBuffer)localObject2).flip();
          i.put((ByteBuffer)localObject2);
        }
      }
      else {
        d = true;
      }
      n = d.a.b[localObject2.ordinal()];
      if (n != 1)
      {
        if (n != 2)
        {
          if (n != 3)
          {
            if ((n != 4) && (n != 5)) {
              break;
            }
          }
          else {
            b((SSLEngineResult)localObject3);
          }
          if ((e.position() <= 0) || (localStatus != SSLEngineResult.Status.OK))
          {
            if ((e.position() != 0) || (localObject2 != SSLEngineResult.HandshakeStatus.NEED_UNWRAP) || (!d)) {
              break;
            }
            f = true;
            break;
          }
        }
        else
        {
          a((SSLEngineResult)localObject3);
        }
      }
      else
      {
        n = e.remaining();
        if ((n <= 0) || (localStatus != SSLEngineResult.Status.OK) || ((n >= m) && (m >= 0))) {
          break;
        }
        pending();
        m = n;
      }
    }
    return;
    label503:
    throw new d0("bytes left unconsumed");
  }
  
  public final void a(SSLEngineResult paramSSLEngineResult)
  {
    if (paramSSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK)
    {
      for (;;)
      {
        paramSSLEngineResult = a).a.getDelegatedTask();
        if (paramSSLEngineResult == null) {
          break;
        }
        paramSSLEngineResult.run();
      }
      if (a).a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
        throw new RuntimeException("handshake shouldn't need additional tasks");
      }
    }
  }
  
  public final void a(SSLEngineResult paramSSLEngineResult, String paramString)
  {
    if (l.isLoggable(Level.FINEST))
    {
      Logger localLogger = l;
      Level localLevel = Level.FINEST;
      StringBuilder localStringBuilder = e.a.a.a.a.a("useClientMode = ");
      localStringBuilder.append(a).a.getUseClientMode());
      localStringBuilder.append(" direction = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      paramString = new StringBuilder("[SSLEngineResult status = ");
      paramString.append(paramSSLEngineResult.getStatus());
      paramString.append(" handshakeStatus = ");
      paramString.append(paramSSLEngineResult.getHandshakeStatus());
      paramString.append(" bytesConsumed = ");
      paramString.append(paramSSLEngineResult.bytesConsumed());
      paramString.append(" bytesProduced = ");
      paramString.append(paramSSLEngineResult.bytesProduced());
      paramString.append("]");
      localStringBuilder.append(paramString.toString());
      localLogger.log(localLevel, localStringBuilder.toString());
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      if (c.pending() < 0) {
        f = true;
      }
      Object localObject1 = c.head();
      Object localObject2 = a;
      Object localObject3 = g;
      localObject1 = a.wrap((ByteBuffer)localObject1, (ByteBuffer)localObject3);
      a((SSLEngineResult)localObject1, "output");
      int m = ((SSLEngineResult)localObject1).bytesConsumed();
      c.pop(m);
      m = c.pending();
      localObject2 = ((SSLEngineResult)localObject1).getStatus();
      int n = d.a.a[localObject2.ordinal()];
      if (n != 1)
      {
        if (n != 2)
        {
          if (n == 3) {
            throw new IllegalStateException("app buffer underflow");
          }
        }
        else
        {
          localObject3 = g;
          localObject2 = ByteBuffer.allocate(((ByteBuffer)localObject3).capacity() * 2);
          g = ((ByteBuffer)localObject2);
          h = ((ByteBuffer)localObject2).asReadOnlyBuffer();
          ((ByteBuffer)localObject3).flip();
          g.put((ByteBuffer)localObject3);
        }
      }
      else {
        f = true;
      }
      localObject3 = ((SSLEngineResult)localObject1).getHandshakeStatus();
      n = d.a.b[localObject3.ordinal()];
      if (n != 1) {
        if (n != 2)
        {
          if (n != 3)
          {
            if (n != 4)
            {
              if ((n != 5) || (e.position() != 0) || (!d)) {
                break label276;
              }
              f = true;
              break label276;
            }
          }
          else {
            b((SSLEngineResult)localObject1);
          }
          if ((m > 0) && (localObject2 == SSLEngineResult.Status.OK)) {}
        }
        else
        {
          label276:
          a((SSLEngineResult)localObject1);
        }
      }
    }
  }
  
  public final void b(SSLEngineResult paramSSLEngineResult)
  {
    if (paramSSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED)
    {
      j = a).a.getSession().getCipherSuite();
      k = a).a.getSession().getProtocol();
    }
  }
  
  public int capacity()
  {
    if (d) {
      return -1;
    }
    return e.remaining();
  }
  
  public void close_head()
  {
    c.close_head();
    int m = pending();
    if (m > 0) {
      pop(m);
    }
  }
  
  public void close_tail()
  {
    try
    {
      b.close_tail();
      return;
    }
    finally
    {
      d = true;
    }
  }
  
  public ByteBuffer head()
  {
    pending();
    return h;
  }
  
  public int pending()
  {
    try
    {
      b();
    }
    catch (SSLException localSSLException)
    {
      l.log(Level.WARNING, localSSLException.getMessage());
      f = true;
    }
    h.limit(g.position());
    if ((f) && (g.position() == 0)) {
      return -1;
    }
    return g.position();
  }
  
  public void pop(int paramInt)
  {
    g.flip();
    g.position(paramInt);
    g.compact();
    h.position(0);
    h.limit(g.position());
  }
  
  public int position()
  {
    if (d) {
      return -1;
    }
    return e.position();
  }
  
  /* Error */
  public void process()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	k/a/b/a/d/g0/m0/d:d	Z
    //   4: ifne +112 -> 116
    //   7: aload_0
    //   8: getfield 86	k/a/b/a/d/g0/m0/d:e	Ljava/nio/ByteBuffer;
    //   11: invokevirtual 160	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 333	k/a/b/a/d/g0/m0/d:a	()V
    //   19: aload_0
    //   20: getfield 86	k/a/b/a/d/g0/m0/d:e	Ljava/nio/ByteBuffer;
    //   23: invokevirtual 182	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   26: pop
    //   27: return
    //   28: astore_1
    //   29: goto +77 -> 106
    //   32: astore_1
    //   33: getstatic 43	k/a/b/a/d/g0/m0/d:l	Ljava/util/logging/Logger;
    //   36: getstatic 242	java/util/logging/Level:FINEST	Ljava/util/logging/Level;
    //   39: invokevirtual 110	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
    //   42: ifeq +20 -> 62
    //   45: getstatic 43	k/a/b/a/d/g0/m0/d:l	Ljava/util/logging/Logger;
    //   48: getstatic 242	java/util/logging/Level:FINEST	Ljava/util/logging/Level;
    //   51: aload_1
    //   52: invokevirtual 329	javax/net/ssl/SSLException:getMessage	()Ljava/lang/String;
    //   55: aload_1
    //   56: invokevirtual 336	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: goto +16 -> 75
    //   62: getstatic 43	k/a/b/a/d/g0/m0/d:l	Ljava/util/logging/Logger;
    //   65: getstatic 326	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   68: aload_1
    //   69: invokevirtual 329	javax/net/ssl/SSLException:getMessage	()Ljava/lang/String;
    //   72: invokevirtual 279	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 86	k/a/b/a/d/g0/m0/d:e	Ljava/nio/ByteBuffer;
    //   79: aload_0
    //   80: getfield 86	k/a/b/a/d/g0/m0/d:e	Ljava/nio/ByteBuffer;
    //   83: invokevirtual 169	java/nio/ByteBuffer:limit	()I
    //   86: invokevirtual 331	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   89: pop
    //   90: aload_0
    //   91: iconst_1
    //   92: putfield 50	k/a/b/a/d/g0/m0/d:d	Z
    //   95: new 184	k/a/b/a/d/d0
    //   98: astore_2
    //   99: aload_2
    //   100: aload_1
    //   101: invokespecial 339	k/a/b/a/d/d0:<init>	(Ljava/lang/Throwable;)V
    //   104: aload_2
    //   105: athrow
    //   106: aload_0
    //   107: getfield 86	k/a/b/a/d/g0/m0/d:e	Ljava/nio/ByteBuffer;
    //   110: invokevirtual 182	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   113: pop
    //   114: aload_1
    //   115: athrow
    //   116: new 184	k/a/b/a/d/d0
    //   119: dup
    //   120: ldc_w 341
    //   123: invokespecial 188	k/a/b/a/d/d0:<init>	(Ljava/lang/String;)V
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	d
    //   28	1	1	localObject	Object
    //   32	83	1	localSSLException	SSLException
    //   98	7	2	locald0	d0
    // Exception table:
    //   from	to	target	type
    //   15	19	28	finally
    //   33	59	28	finally
    //   62	75	28	finally
    //   75	106	28	finally
    //   15	19	32	javax/net/ssl/SSLException
  }
  
  public ByteBuffer tail()
  {
    if (!d) {
      return e;
    }
    throw new d0("tail closed");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SimpleSslTransportWrapper [sslEngine=");
    localStringBuilder.append(a);
    localStringBuilder.append(", inputBuffer=");
    localStringBuilder.append(e);
    localStringBuilder.append(", outputBuffer=");
    localStringBuilder.append(g);
    localStringBuilder.append(", decodedInputBuffer=");
    localStringBuilder.append(i);
    localStringBuilder.append(", cipherName=");
    localStringBuilder.append(j);
    localStringBuilder.append(", protocolName=");
    return e.a.a.a.a.a(localStringBuilder, k, "]");
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.m0.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */