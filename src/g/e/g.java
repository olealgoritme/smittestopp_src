package g.e;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
  extends Socket
{
  public AtomicBoolean A = new AtomicBoolean(false);
  public InputStream B;
  public OutputStream C;
  public i x;
  public AtomicBoolean y = new AtomicBoolean(false);
  public AtomicBoolean z = new AtomicBoolean(false);
  
  public g(i parami)
  {
    x = parami;
    B = Channels.newInputStream(new g.a(parami));
    C = Channels.newOutputStream(new g.a(parami));
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    if (x != null) {
      if (!isClosed())
      {
        if (!isBound()) {
          try
          {
            x.bind(paramSocketAddress);
          }
          catch (IOException paramSocketAddress)
          {
            throw ((SocketException)new SocketException().initCause(paramSocketAddress));
          }
        } else {
          throw new SocketException("already bound");
        }
      }
      else {
        throw new SocketException("Socket is closed");
      }
    }
  }
  
  public void close()
  {
    if ((x != null) && (y.compareAndSet(false, true))) {}
    try
    {
      x.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public void connect(SocketAddress paramSocketAddress)
  {
    connect(paramSocketAddress, 0);
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    if ((paramSocketAddress instanceof h))
    {
      x.a((h)paramSocketAddress);
      return;
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("address of type ");
    localStringBuilder.append(paramSocketAddress.getClass());
    localStringBuilder.append(" are not supported. Use ");
    localStringBuilder.append(h.class);
    localStringBuilder.append(" instead");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public SocketChannel getChannel()
  {
    return x;
  }
  
  public InetAddress getInetAddress()
  {
    return null;
  }
  
  public InputStream getInputStream()
  {
    if (x.isConnected()) {
      return B;
    }
    throw new IOException("not connected");
  }
  
  public boolean getKeepAlive()
  {
    try
    {
      boolean bool = ((Boolean)x.getOption(j.e)).booleanValue();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    i locali = x;
    h localh = C;
    if (localh == null)
    {
      localh = b.b(x.a);
      C = localh;
    }
    return localh;
  }
  
  public OutputStream getOutputStream()
  {
    if (x.isConnected()) {
      return C;
    }
    throw new IOException("not connected");
  }
  
  public int getReceiveBufferSize()
  {
    try
    {
      int i = ((Integer)x.getOption(j.c)).intValue();
      return i;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public SocketAddress getRemoteSocketAddress()
  {
    i locali = x;
    h localh;
    if (!locali.isConnected())
    {
      localh = null;
    }
    else
    {
      localh = B;
      if (localh == null)
      {
        localh = b.a(x.a);
        B = localh;
      }
    }
    if (localh != null) {
      return localh;
    }
    return null;
  }
  
  public int getSendBufferSize()
  {
    try
    {
      int i = ((Integer)x.getOption(j.a)).intValue();
      return i;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public int getSoTimeout()
  {
    try
    {
      int i = ((Integer)x.getOption(j.d)).intValue();
      return i;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public boolean isBound()
  {
    i locali = x;
    if (locali == null) {
      return false;
    }
    return E.a.get();
  }
  
  public boolean isClosed()
  {
    return y.get();
  }
  
  public boolean isConnected()
  {
    return x.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return z.get();
  }
  
  public boolean isOutputShutdown()
  {
    return A.get();
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    try
    {
      x.setOption(j.e, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    try
    {
      x.setOption(j.c, Integer.valueOf(paramInt));
      return;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public void setSendBufferSize(int paramInt)
  {
    try
    {
      x.setOption(j.a, Integer.valueOf(paramInt));
      return;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public void setSoTimeout(int paramInt)
  {
    try
    {
      x.setOption(j.d, Integer.valueOf(paramInt));
      return;
    }
    catch (IOException localIOException)
    {
      throw ((SocketException)new SocketException().initCause(localIOException));
    }
  }
  
  public void shutdownInput()
  {
    if (z.compareAndSet(false, true)) {
      x.shutdownInput();
    }
  }
  
  public void shutdownOutput()
  {
    if (A.compareAndSet(false, true)) {
      x.shutdownOutput();
    }
  }
}

/* Location:
 * Qualified Name:     base.g.e.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */