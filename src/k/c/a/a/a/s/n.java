package k.c.a.a.a.s;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import k.c.a.a.a.k;
import k.c.a.a.a.t.b;
import k.c.a.a.a.t.c;

public class n
  implements i
{
  public b a;
  public Socket b;
  public SocketFactory c;
  public String d;
  public int e;
  public int f;
  
  public n(SocketFactory paramSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    b localb = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "k.c.a.a.a.s.n");
    a = localb;
    localb.a(paramString2);
    c = paramSocketFactory;
    d = paramString1;
    e = paramInt;
  }
  
  public OutputStream a()
  {
    return b.getOutputStream();
  }
  
  public InputStream b()
  {
    return b.getInputStream();
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("tcp://");
    localStringBuilder.append(d);
    localStringBuilder.append(":");
    localStringBuilder.append(e);
    return localStringBuilder.toString();
  }
  
  public void start()
  {
    try
    {
      a.b("k.c.a.a.a.s.n", "start", "252", new Object[] { d, Integer.valueOf(e), Long.valueOf(f * 1000) });
      InetSocketAddress localInetSocketAddress = new java/net/InetSocketAddress;
      localInetSocketAddress.<init>(d, e);
      Socket localSocket = c.createSocket();
      b = localSocket;
      localSocket.connect(localInetSocketAddress, f * 1000);
      b.setSoTimeout(1000);
      return;
    }
    catch (ConnectException localConnectException)
    {
      a.a("k.c.a.a.a.s.n", "start", "250", null, localConnectException);
      throw new k(32103, localConnectException);
    }
  }
  
  public void stop()
  {
    Socket localSocket = b;
    if (localSocket != null) {
      localSocket.close();
    }
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.n
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */