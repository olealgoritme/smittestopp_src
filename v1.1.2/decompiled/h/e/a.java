package h.e;

import java.net.SocketAddress;
import java.nio.channels.AlreadyBoundException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public final AtomicBoolean a;
  
  public a(boolean paramBoolean)
  {
    a = new AtomicBoolean(paramBoolean);
  }
  
  public h a(int paramInt, SocketAddress paramSocketAddress)
  {
    if (paramSocketAddress != null) {}
    try
    {
      if (!(paramSocketAddress instanceof h))
      {
        paramSocketAddress = new java/nio/channels/UnsupportedAddressTypeException;
        paramSocketAddress.<init>();
        throw paramSocketAddress;
      }
      if (!a.get())
      {
        paramSocketAddress = b.a(paramInt, (h)paramSocketAddress);
        a.set(true);
        return paramSocketAddress;
      }
      paramSocketAddress = new java/nio/channels/AlreadyBoundException;
      paramSocketAddress.<init>();
      throw paramSocketAddress;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     h.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */