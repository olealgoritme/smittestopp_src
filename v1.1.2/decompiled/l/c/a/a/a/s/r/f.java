package l.c.a.a.a.s.r;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.util.Properties;
import javax.net.SocketFactory;
import l.c.a.a.a.s.n;
import l.c.a.a.a.t.c;

public class f
  extends n
{
  public l.c.a.a.a.t.b g = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "l.c.a.a.a.s.r.f");
  public String h;
  public String i;
  public int j;
  public Properties k;
  public PipedInputStream l;
  public h m;
  public ByteArrayOutputStream n = new b(this);
  
  public f(SocketFactory paramSocketFactory, String paramString1, String paramString2, int paramInt, String paramString3, Properties paramProperties)
  {
    super(paramSocketFactory, paramString2, paramInt, paramString3);
    h = paramString1;
    i = paramString2;
    j = paramInt;
    k = paramProperties;
    l = new PipedInputStream();
    g.a(paramString3);
  }
  
  public OutputStream a()
  {
    return n;
  }
  
  public InputStream b()
  {
    return l;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("ws://");
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
  
  public OutputStream d()
  {
    return super.a();
  }
  
  public void start()
  {
    super.start();
    new e(super.b(), super.a(), h, i, j, k).a();
    h localh = new h(super.b(), l);
    m = localh;
    localh.a("webSocketReceiver");
  }
  
  public void stop()
  {
    Object localObject = new d((byte)8, true, "1000".getBytes()).a();
    super.a().write((byte[])localObject);
    super.a().flush();
    localObject = m;
    if (localObject != null) {
      ((h)localObject).a();
    }
    super.stop();
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.r.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */