package h.e;

import h.c.f.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class i
  extends h.e.k.a
{
  public b A;
  public h B;
  public h C;
  public final ReadWriteLock D;
  public final a E;
  
  public final boolean a()
  {
    D.readLock().lock();
    boolean bool;
    if (A == b.IDLE) {
      bool = true;
    } else {
      bool = false;
    }
    D.readLock().unlock();
    return bool;
  }
  
  public final boolean a(e parame)
  {
    int i = x.a;
    int j = parame.d();
    if (d.b.b(i, parame, j) != 0)
    {
      parame = h.a.d.b.valueOf(f.a.a.a());
      i = parame.ordinal();
      if ((i != 34) && (i != 35)) {
        throw new IOException(parame.toString());
      }
      return false;
    }
    return true;
  }
  
  public boolean a(h paramh)
  {
    B = paramh;
    if (!a(x))
    {
      D.writeLock().lock();
      A = b.CONNECTING;
      D.writeLock().unlock();
      return false;
    }
    D.writeLock().lock();
    A = b.CONNECTED;
    D.writeLock().unlock();
    return true;
  }
  
  public i bind(SocketAddress paramSocketAddress)
  {
    try
    {
      C = E.a(x.a, paramSocketAddress);
      return this;
    }
    finally
    {
      paramSocketAddress = finally;
      throw paramSocketAddress;
    }
  }
  
  public boolean connect(SocketAddress paramSocketAddress)
  {
    if ((paramSocketAddress instanceof h)) {
      return a((h)paramSocketAddress);
    }
    throw new UnsupportedAddressTypeException();
  }
  
  public boolean finishConnect()
  {
    D.writeLock().lock();
    try
    {
      int i = A.ordinal();
      if (i != 1)
      {
        if (i == 3)
        {
          boolean bool = a(B.x);
          if (!bool) {
            return false;
          }
          A = b.CONNECTED;
        }
      }
      else {
        return true;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("socket is not waiting for connect to complete");
      throw localIllegalStateException;
    }
    finally
    {
      D.writeLock().unlock();
    }
  }
  
  public SocketAddress getLocalAddress()
  {
    return C;
  }
  
  public <T> T getOption(SocketOption<T> paramSocketOption)
  {
    if (a.a.contains(paramSocketOption))
    {
      int i = x.a;
      localObject = (h.a.d.i)b.c.get(paramSocketOption);
      if (localObject != null)
      {
        paramSocketOption = paramSocketOption.type();
        if (paramSocketOption != c.class)
        {
          if (paramSocketOption == Integer.class)
          {
            paramSocketOption = Integer.valueOf(d.a(i, h.a.d.h.SOL_SOCKET, ((h.a.d.i)localObject).intValue()));
          }
          else
          {
            boolean bool;
            if (d.a(i, h.a.d.h.SOL_SOCKET, ((h.a.d.i)localObject).intValue()) != 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramSocketOption = Boolean.valueOf(bool);
          }
          return paramSocketOption;
        }
        paramSocketOption = new f();
        d.a(i, h.a.d.h.SOL_SOCKET, h.a.d.i.SO_PEERCRED, paramSocketOption);
        throw null;
      }
      throw new AssertionError("Option not found");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("'");
    ((StringBuilder)localObject).append(paramSocketOption);
    ((StringBuilder)localObject).append("' not supported");
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
  }
  
  public SocketAddress getRemoteAddress()
  {
    return B;
  }
  
  public boolean isConnected()
  {
    D.readLock().lock();
    boolean bool;
    if (A == b.CONNECTED) {
      bool = true;
    } else {
      bool = false;
    }
    D.readLock().unlock();
    return bool;
  }
  
  public boolean isConnectionPending()
  {
    D.readLock().lock();
    boolean bool;
    if (A == b.CONNECTING) {
      bool = true;
    } else {
      bool = false;
    }
    D.readLock().unlock();
    return bool;
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    if (isConnected()) {
      return x.a(paramByteBuffer);
    }
    if (a()) {
      return 0;
    }
    throw new ClosedChannelException();
  }
  
  public <T> SocketChannel setOption(SocketOption<T> paramSocketOption, T paramT)
  {
    if (paramSocketOption != null)
    {
      if (a.a.contains(paramSocketOption))
      {
        b.a(x.a, paramSocketOption, paramT);
        return this;
      }
      paramT = new StringBuilder();
      paramT.append("'");
      paramT.append(paramSocketOption);
      paramT.append("' not supported");
      throw new UnsupportedOperationException(paramT.toString());
    }
    throw new IllegalArgumentException("name may not be null");
  }
  
  public Socket socket()
  {
    return new g(this);
  }
  
  public final Set<SocketOption<?>> supportedOptions()
  {
    return a.a;
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (isConnected()) {
      return x.b(paramByteBuffer);
    }
    if (a()) {
      return 0;
    }
    throw new ClosedChannelException();
  }
  
  public long write(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2)
  {
    boolean bool = isConnected();
    long l = 0L;
    if (bool)
    {
      h.e.k.b localb = x;
      if (localb != null)
      {
        while (paramInt1 < paramInt2)
        {
          l += localb.b(paramArrayOfByteBuffer[paramInt1]);
          paramInt1++;
        }
        return l;
      }
      throw null;
    }
    if (a()) {
      return 0L;
    }
    throw new ClosedChannelException();
  }
  
  public static class a
  {
    public static final Set<SocketOption<?>> a;
    
    static
    {
      HashSet localHashSet = new HashSet(5);
      localHashSet.add(j.a);
      localHashSet.add(j.b);
      localHashSet.add(j.c);
      localHashSet.add(j.d);
      localHashSet.add(j.f);
      localHashSet.add(j.e);
      localHashSet.add(j.g);
      a = Collections.unmodifiableSet(localHashSet);
    }
  }
  
  public static enum b
  {
    static
    {
      CONNECTED = new b("CONNECTED", 1);
      IDLE = new b("IDLE", 2);
      b localb = new b("CONNECTING", 3);
      CONNECTING = localb;
      $VALUES = new b[] { UNINITIALIZED, CONNECTED, IDLE, localb };
    }
    
    public b() {}
  }
}

/* Location:
 * Qualified Name:     h.e.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */