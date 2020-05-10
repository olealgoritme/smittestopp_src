package k.c.a.a.a.s.r;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.util.Properties;
import javax.net.ssl.SSLSocketFactory;
import k.c.a.a.a.s.l;
import k.c.a.a.a.s.n;
import k.c.a.a.a.t.c;

public class i
  extends l
{
  public k.c.a.a.a.t.b n = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "k.c.a.a.a.s.r.i");
  public PipedInputStream o;
  public h p;
  public String q;
  public String r;
  public int s;
  public Properties t;
  public ByteArrayOutputStream u = new b(this);
  
  public i(SSLSocketFactory paramSSLSocketFactory, String paramString1, String paramString2, int paramInt, String paramString3, Properties paramProperties)
  {
    super(paramSSLSocketFactory, paramString2, paramInt, paramString3);
    q = paramString1;
    r = paramString2;
    s = paramInt;
    t = paramProperties;
    o = new PipedInputStream();
    n.a(paramString3);
  }
  
  public OutputStream a()
  {
    return u;
  }
  
  public InputStream b()
  {
    return o;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("wss://");
    localStringBuilder.append(r);
    localStringBuilder.append(":");
    localStringBuilder.append(s);
    return localStringBuilder.toString();
  }
  
  public OutputStream d()
  {
    return super.a();
  }
  
  public void start()
  {
    super.start();
    new e(super.b(), super.a(), q, r, s, t).a();
    h localh = new h(super.b(), o);
    p = localh;
    localh.a("WssSocketReceiver");
  }
  
  public void stop()
  {
    Object localObject = new d((byte)8, true, "1000".getBytes()).a();
    super.a().write((byte[])localObject);
    super.a().flush();
    localObject = p;
    if (localObject != null) {
      ((h)localObject).a();
    }
    super.stop();
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.r.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */