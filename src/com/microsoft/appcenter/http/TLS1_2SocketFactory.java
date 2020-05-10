package com.microsoft.appcenter.http;

import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLS1_2SocketFactory
  extends SSLSocketFactory
{
  public static final String[] ENABLED_PROTOCOLS = { "TLSv1.2" };
  public static final String TLS1_2_PROTOCOL = "TLSv1.2";
  public final SSLSocketFactory delegate;
  
  public TLS1_2SocketFactory()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = SSLContext.getInstance("TLSv1.2");
      ((SSLContext)localObject2).init(null, null, null);
      localObject2 = ((SSLContext)localObject2).getSocketFactory();
      localObject1 = localObject2;
    }
    catch (KeyManagementException|NoSuchAlgorithmException localKeyManagementException) {}
    if (localObject1 == null) {
      localObject1 = HttpsURLConnection.getDefaultSSLSocketFactory();
    }
    delegate = ((SSLSocketFactory)localObject1);
  }
  
  private SSLSocket forceTLS1_2(Socket paramSocket)
  {
    paramSocket = (SSLSocket)paramSocket;
    paramSocket.setEnabledProtocols(ENABLED_PROTOCOLS);
    return paramSocket;
  }
  
  public SSLSocket createSocket()
  {
    return forceTLS1_2(delegate.createSocket());
  }
  
  public SSLSocket createSocket(String paramString, int paramInt)
  {
    return forceTLS1_2(delegate.createSocket(paramString, paramInt));
  }
  
  public SSLSocket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return forceTLS1_2(delegate.createSocket(paramString, paramInt1, paramInetAddress, paramInt2));
  }
  
  public SSLSocket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return forceTLS1_2(delegate.createSocket(paramInetAddress, paramInt));
  }
  
  public SSLSocket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return forceTLS1_2(delegate.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2));
  }
  
  public SSLSocket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return forceTLS1_2(delegate.createSocket(paramSocket, paramString, paramInt, paramBoolean));
  }
  
  public String[] getDefaultCipherSuites()
  {
    return delegate.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return delegate.getSupportedCipherSuites();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.TLS1_2SocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */