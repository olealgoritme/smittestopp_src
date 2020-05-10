package l.a.b.a.d.g0.m0;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import l.a.b.a.d.a0;
import l.a.b.a.d.a0.a;
import l.a.b.a.d.a0.b;
import l.a.b.a.d.b0;
import l.a.b.a.d.d0;
import l.a.b.a.d.r;

public class e
  implements a0, c, r
{
  public a0.a a;
  public a0.b b;
  public SSLContext c;
  public final f d = new f();
  
  public a0.b a()
  {
    a0.b localb1 = b;
    a0.b localb2 = localb1;
    if (localb1 == null) {
      if (a == a0.a.SERVER) {
        localb2 = a0.b.ANONYMOUS_PEER;
      } else {
        localb2 = a0.b.VERIFY_PEER_NAME;
      }
    }
    return localb2;
  }
  
  public b a(b0 paramb0)
  {
    Object localObject1 = d;
    if (localObject1 != null)
    {
      Object localObject2 = a;
      Object localObject3 = a;
      boolean bool = false;
      if (localObject3 == null)
      {
        localObject3 = c;
        if (localObject3 != null)
        {
          a = ((SSLContext)localObject3);
          break label274;
        }
      }
      Object localObject4;
      Object localObject5;
      Object localObject6;
      if (a == null)
      {
        if (f.b.isLoggable(Level.FINE))
        {
          localObject3 = f.b;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("lazily creating new SSLContext using domain ");
          ((StringBuilder)localObject4).append(this);
          ((Logger)localObject3).fine(((StringBuilder)localObject4).toString());
        }
        localObject5 = "unused-passphrase".toCharArray();
        try
        {
          localObject6 = SSLContext.getInstance("TLS");
          localObject3 = ((f)localObject1).a(this, (char[])localObject5);
          localObject4 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
          ((KeyManagerFactory)localObject4).init((KeyStore)localObject3, (char[])localObject5);
          if (a() == a0.b.ANONYMOUS_PEER)
          {
            localObject3 = new TrustManager[1];
            localObject5 = new l/a/b/a/d/g0/m0/f$b;
            ((f.b)localObject5).<init>(null);
            localObject3[0] = localObject5;
          }
          else
          {
            localObject5 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            ((TrustManagerFactory)localObject5).init((KeyStore)localObject3);
            localObject3 = ((TrustManagerFactory)localObject5).getTrustManagers();
          }
          ((SSLContext)localObject6).init(((KeyManagerFactory)localObject4).getKeyManagers(), (TrustManager[])localObject3, null);
          a = ((SSLContext)localObject6);
        }
        catch (KeyManagementException paramb0)
        {
          throw new d0("Unexpected exception creating SSLContext", paramb0);
        }
        catch (UnrecoverableKeyException paramb0)
        {
          throw new d0("Unexpected exception creating SSLContext", paramb0);
        }
        catch (KeyStoreException paramb0)
        {
          throw new d0("Unexpected exception creating SSLContext", paramb0);
        }
        catch (NoSuchAlgorithmException paramb0)
        {
          throw new d0("Unexpected exception creating SSLContext", paramb0);
        }
      }
      label274:
      localObject3 = a;
      if (paramb0 == null) {
        paramb0 = ((SSLContext)localObject3).createSSLEngine();
      } else {
        paramb0 = ((SSLContext)localObject3).createSSLEngine(paramb0.f(), paramb0.a());
      }
      if (a() == a0.b.ANONYMOUS_PEER)
      {
        List localList = Arrays.asList(paramb0.getSupportedCipherSuites());
        localObject3 = Arrays.asList(paramb0.getEnabledCipherSuites());
        localObject4 = f.o;
        localObject1 = new ArrayList((Collection)localObject3);
        localObject6 = ((List)localObject4).iterator();
        int i = 0;
        while (((Iterator)localObject6).hasNext())
        {
          localObject5 = (String)((Iterator)localObject6).next();
          if (localList.contains(localObject5))
          {
            ((ArrayList)localObject1).add(localObject5);
            i++;
          }
        }
        if ((i > 0) && (f.b.isLoggable(Level.FINE)))
        {
          localObject6 = f.b;
          localObject5 = e.a.a.a.a.a("There are now ");
          ((StringBuilder)localObject5).append(((ArrayList)localObject1).size());
          ((StringBuilder)localObject5).append(" cipher suites enabled (previously ");
          ((StringBuilder)localObject5).append(((List)localObject3).size());
          ((StringBuilder)localObject5).append("), including ");
          ((StringBuilder)localObject5).append(i);
          ((StringBuilder)localObject5).append(" out of the ");
          ((StringBuilder)localObject5).append(((List)localObject4).size());
          ((StringBuilder)localObject5).append(" requested anonymous ones.");
          ((Logger)localObject6).fine(((StringBuilder)localObject5).toString());
        }
        paramb0.setEnabledCipherSuites((String[])((ArrayList)localObject1).toArray(new String[0]));
      }
      else
      {
        if (localObject2 == a0.a.SERVER) {
          paramb0.setNeedClientAuth(true);
        }
        if (a() == a0.b.VERIFY_PEER_NAME)
        {
          localObject3 = paramb0.getSSLParameters();
          ((SSLParameters)localObject3).setEndpointIdentificationAlgorithm("HTTPS");
          paramb0.setSSLParameters((SSLParameters)localObject3);
        }
      }
      if (f.b.isLoggable(Level.FINE))
      {
        localObject4 = f.b;
        localObject1 = Level.FINE;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject2);
        ((StringBuilder)localObject3).append(" Enabled cipher suites ");
        ((StringBuilder)localObject3).append(Arrays.asList(paramb0.getEnabledCipherSuites()));
        ((Logger)localObject4).log((Level)localObject1, ((StringBuilder)localObject3).toString());
      }
      if (localObject2 == a0.a.CLIENT) {
        bool = true;
      }
      paramb0.setUseClientMode(bool);
      localObject3 = Arrays.asList(paramb0.getEnabledProtocols());
      if (((List)localObject3).contains("SSLv3"))
      {
        localObject3 = new ArrayList((Collection)localObject3);
        ((ArrayList)localObject3).remove("SSLv3");
        paramb0.setEnabledProtocols((String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]));
      }
      if (f.b.isLoggable(Level.FINE))
      {
        localObject3 = f.b;
        localObject2 = e.a.a.a.a.a("Created SSL engine: ");
        localObject1 = new StringBuilder("[ ");
        ((StringBuilder)localObject1).append(paramb0);
        ((StringBuilder)localObject1).append(", needClientAuth=");
        ((StringBuilder)localObject1).append(paramb0.getNeedClientAuth());
        ((StringBuilder)localObject1).append(", useClientMode=");
        ((StringBuilder)localObject1).append(paramb0.getUseClientMode());
        ((StringBuilder)localObject1).append(", peerHost=");
        ((StringBuilder)localObject1).append(paramb0.getPeerHost());
        ((StringBuilder)localObject1).append(", peerPort=");
        ((StringBuilder)localObject1).append(paramb0.getPeerPort());
        ((StringBuilder)localObject1).append(" ]");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
        ((Logger)localObject3).fine(((StringBuilder)localObject2).toString());
      }
      return new a(paramb0);
    }
    throw null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("SslDomainImpl [_mode=");
    localStringBuilder.append(a);
    localStringBuilder.append(", _verifyMode=");
    localStringBuilder.append(b);
    localStringBuilder.append(", _certificateFile=");
    localStringBuilder.append(null);
    localStringBuilder.append(", _privateKeyFile=");
    localStringBuilder.append(null);
    localStringBuilder.append(", _trustedCaDb=");
    localStringBuilder.append(null);
    localStringBuilder.append(", _allowUnsecuredClient=");
    localStringBuilder.append(false);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.m0.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */