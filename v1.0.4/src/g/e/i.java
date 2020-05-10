package g.e;

import g.c.f.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class i
  extends g.e.k.a
{
  public i.b A;
  public h B;
  public h C;
  public final ReadWriteLock D;
  public final a E;
  
  public final boolean a()
  {
    D.readLock().lock();
    boolean bool;
    if (A == i.b.IDLE) {
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
      parame = g.a.d.b.valueOf(f.a.a.a());
      j = parame.ordinal();
      if ((j != 34) && (j != 35)) {
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
      A = i.b.CONNECTING;
      D.writeLock().unlock();
      return false;
    }
    D.writeLock().lock();
    A = i.b.CONNECTED;
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
          A = i.b.CONNECTED;
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
    if (i.a.a.contains(paramSocketOption))
    {
      int i = x.a;
      localObject = (g.a.d.i)b.c.get(paramSocketOption);
      if (localObject != null)
      {
        paramSocketOption = paramSocketOption.type();
        if (paramSocketOption != c.class)
        {
          if (paramSocketOption == Integer.class)
          {
            paramSocketOption = Integer.valueOf(d.a(i, g.a.d.h.SOL_SOCKET, ((g.a.d.i)localObject).intValue()));
          }
          else
          {
            boolean bool;
            if (d.a(i, g.a.d.h.SOL_SOCKET, ((g.a.d.i)localObject).intValue()) != 0) {
              bool = true;
            } else {
              bool = false;
            }
            paramSocketOption = Boolean.valueOf(bool);
          }
          return paramSocketOption;
        }
        paramSocketOption = new f();
        d.a(i, g.a.d.h.SOL_SOCKET, g.a.d.i.SO_PEERCRED, paramSocketOption);
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
    if (A == i.b.CONNECTED) {
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
    if (A == i.b.CONNECTING) {
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
      if (i.a.a.contains(paramSocketOption))
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
    return i.a.a;
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
      g.e.k.b localb = x;
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
}

/* Location:
 * Qualified Name:     base.g.e.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */