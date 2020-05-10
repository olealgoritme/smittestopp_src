package k.c.a.a.a.s;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k.c.a.a.a.t.b;
import k.c.a.a.a.t.c;

public class l
  extends n
{
  public b g;
  public String[] h;
  public int i;
  public HostnameVerifier j;
  public boolean k;
  public String l;
  public int m;
  
  public l(SSLSocketFactory paramSSLSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    super(paramSSLSocketFactory, paramString1, paramInt, paramString2);
    paramSSLSocketFactory = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", "k.c.a.a.a.s.l");
    g = paramSSLSocketFactory;
    k = false;
    l = paramString1;
    m = paramInt;
    paramSSLSocketFactory.a(paramString2);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      h = ((String[])paramArrayOfString.clone());
    }
    if ((b != null) && (h != null))
    {
      if (g.a(5))
      {
        paramArrayOfString = "";
        for (int n = 0;; n++)
        {
          if (n >= h.length)
          {
            g.b("k.c.a.a.a.s.l", "setEnabledCiphers", "260", new Object[] { paramArrayOfString });
            break;
          }
          Object localObject = paramArrayOfString;
          if (n > 0)
          {
            paramArrayOfString = new StringBuilder(String.valueOf(paramArrayOfString));
            paramArrayOfString.append(",");
            localObject = paramArrayOfString.toString();
          }
          paramArrayOfString = new StringBuilder(String.valueOf(localObject));
          paramArrayOfString.append(h[n]);
          paramArrayOfString = paramArrayOfString.toString();
        }
      }
      ((SSLSocket)b).setEnabledCipherSuites(h);
    }
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder("ssl://");
    localStringBuilder.append(l);
    localStringBuilder.append(":");
    localStringBuilder.append(m);
    return localStringBuilder.toString();
  }
  
  public void start()
  {
    super.start();
    a(h);
    int n = b.getSoTimeout();
    b.setSoTimeout(i * 1000);
    Object localObject1 = new SSLParameters();
    Object localObject2 = new ArrayList(1);
    ((ArrayList)localObject2).add(new SNIHostName(l));
    ((SSLParameters)localObject1).setServerNames((List)localObject2);
    ((SSLSocket)b).setSSLParameters((SSLParameters)localObject1);
    if (k)
    {
      localObject2 = new SSLParameters();
      ((SSLParameters)localObject2).setEndpointIdentificationAlgorithm("HTTPS");
      ((SSLSocket)b).setSSLParameters((SSLParameters)localObject2);
    }
    ((SSLSocket)b).startHandshake();
    if ((j != null) && (!k))
    {
      localObject1 = ((SSLSocket)b).getSession();
      if (!j.verify(l, (SSLSession)localObject1))
      {
        ((SSLSession)localObject1).invalidate();
        b.close();
        localObject2 = new StringBuilder("Host: ");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(", Peer Host: ");
        ((StringBuilder)localObject2).append(((SSLSession)localObject1).getPeerHost());
        throw new SSLPeerUnverifiedException(((StringBuilder)localObject2).toString());
      }
    }
    b.setSoTimeout(n);
  }
}

/* Location:
 * Qualified Name:     base.k.c.a.a.a.s.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */