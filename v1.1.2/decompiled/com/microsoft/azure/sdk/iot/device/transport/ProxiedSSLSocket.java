package com.microsoft.azure.sdk.iot.device.transport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import lombok.NonNull;

public class ProxiedSSLSocket
  extends SSLSocket
{
  public static final String HTTP = "HTTP/";
  public static final String HTTP_VERSION_1_1 = "HTTP/1.1";
  public static final l.f.b log = l.f.c.a(ProxiedSSLSocket.class);
  public char[] proxyPassword;
  public final Socket proxySocket;
  public String proxyUsername;
  public final SSLSocketFactory socketFactory;
  public SSLSocket sslSocket;
  
  public ProxiedSSLSocket(SSLSocketFactory paramSSLSocketFactory, Socket paramSocket, String paramString, char[] paramArrayOfChar)
  {
    socketFactory = paramSSLSocketFactory;
    proxySocket = paramSocket;
    proxyUsername = paramString;
    proxyPassword = paramArrayOfChar;
  }
  
  private void doTunnelHandshake(Socket paramSocket, String paramString, int paramInt)
  {
    Charset localCharset = StandardCharsets.UTF_8;
    Object localObject1 = paramSocket.getOutputStream();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(paramInt);
    String str = ((StringBuilder)localObject2).toString();
    if ((proxyUsername != null) && (proxyPassword != null))
    {
      localObject2 = String.format("%s:%s", new Object[] { proxyUsername, new String(proxyPassword) }).getBytes(localCharset);
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        l.a.a.a.b.b localb = new l.a.a.a.b.b(0, l.a.a.a.b.b.j, false);
        int i = localObject2.length;
        j = b;
        long l1 = (i + j - 1) / j * c;
        j = d;
        long l2 = l1;
        if (j > 0)
        {
          l2 = j;
          l2 = (l2 + l1 - 1L) / l2 * e + l1;
        }
        if (l2 <= Integer.MAX_VALUE)
        {
          localObject2 = localb.b((byte[])localObject2);
        }
        else
        {
          paramSocket = new StringBuilder();
          paramSocket.append("Input array too big, the output array would be bigger (");
          paramSocket.append(l2);
          paramSocket.append(") than the specified maximum size of ");
          paramSocket.append(Integer.MAX_VALUE);
          throw new IllegalArgumentException(paramSocket.toString());
        }
      }
      localObject2 = String.format("CONNECT %s %s\r\nHost: %s\r\nProxy-Authorization: Basic %s\r\n\r\n", new Object[] { str, "HTTP/1.1", str, new String((byte[])localObject2) });
    }
    else
    {
      localObject2 = String.format("CONNECT %s %s\r\nHost: %s\r\n\r\n", new Object[] { str, "HTTP/1.1", str });
    }
    ((OutputStream)localObject1).write(((String)localObject2).getBytes(localCharset));
    ((OutputStream)localObject1).flush();
    localObject2 = new HttpConnectResponseReader(paramSocket.getInputStream(), localCharset).readHttpConnectResponse().split("\r\n");
    for (int j = 0; localObject2[j].isEmpty(); j++) {}
    localObject2 = localObject2[j];
    if (((String)localObject2).startsWith("HTTP/"))
    {
      localObject1 = ((String)localObject2).split(" ");
      if (localObject1.length >= 2) {
        try
        {
          j = Integer.parseInt(localObject1[1]);
          if ((j > 199) && (j < 300))
          {
            log.d("HTTP proxy responded to connect request with status {}, so the proxy connect was successful", Integer.valueOf(j));
            return;
          }
          paramSocket.close();
          throw new IOException(String.format("Unable to tunnel through %s:%d. Expected proxy response to CONNECT to return status code 2XX but status code was %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(j) }));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          paramSocket.close();
          throw new IOException(String.format("Unable to tunnel through %s:%d. Expected proxy response to CONNECT to contain a status code but status code could not be parsed. Response was %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject2 }));
        }
      }
      paramSocket.close();
      throw new IOException(String.format("Unable to tunnel through %s:%d. Expected proxy response to CONNECT to contain a space between http version and status code, but was %s", new Object[] { paramString, Integer.valueOf(paramInt), localObject2 }));
    }
    paramSocket.close();
    throw new IOException(String.format("Unable to tunnel through %s:%d.  Expected first response line to start with %s, but proxy returns \"%s\"", new Object[] { paramString, Integer.valueOf(paramInt), "HTTP/", localObject2 }));
  }
  
  public void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    sslSocket.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void bind(SocketAddress paramSocketAddress)
  {
    sslSocket.bind(paramSocketAddress);
  }
  
  public void close()
  {
    proxySocket.close();
    sslSocket.close();
  }
  
  public void connect(SocketAddress paramSocketAddress)
  {
    connect(paramSocketAddress, 0);
  }
  
  public void connect(SocketAddress paramSocketAddress, int paramInt)
  {
    log.e("Sending tunnel handshake to HTTP proxy");
    Socket localSocket = proxySocket;
    paramSocketAddress = (InetSocketAddress)paramSocketAddress;
    doTunnelHandshake(localSocket, paramSocketAddress.getHostName(), paramSocketAddress.getPort());
    log.e("Handshake to HTTP proxy succeeded");
    sslSocket = ((SSLSocket)socketFactory.createSocket(proxySocket, paramSocketAddress.getHostName(), paramSocketAddress.getPort(), true));
  }
  
  public SocketChannel getChannel()
  {
    return sslSocket.getChannel();
  }
  
  public boolean getEnableSessionCreation()
  {
    return sslSocket.getEnableSessionCreation();
  }
  
  public String[] getEnabledCipherSuites()
  {
    return sslSocket.getEnabledCipherSuites();
  }
  
  public String[] getEnabledProtocols()
  {
    return sslSocket.getEnabledProtocols();
  }
  
  public SSLSession getHandshakeSession()
  {
    return sslSocket.getHandshakeSession();
  }
  
  public InetAddress getInetAddress()
  {
    return sslSocket.getInetAddress();
  }
  
  public InputStream getInputStream()
  {
    return sslSocket.getInputStream();
  }
  
  public boolean getKeepAlive()
  {
    return sslSocket.getKeepAlive();
  }
  
  public InetAddress getLocalAddress()
  {
    return sslSocket.getLocalAddress();
  }
  
  public int getLocalPort()
  {
    return sslSocket.getLocalPort();
  }
  
  public SocketAddress getLocalSocketAddress()
  {
    return sslSocket.getLocalSocketAddress();
  }
  
  public boolean getNeedClientAuth()
  {
    return sslSocket.getNeedClientAuth();
  }
  
  public boolean getOOBInline()
  {
    return sslSocket.getOOBInline();
  }
  
  public OutputStream getOutputStream()
  {
    return sslSocket.getOutputStream();
  }
  
  public int getPort()
  {
    return sslSocket.getPort();
  }
  
  public int getReceiveBufferSize()
  {
    return sslSocket.getReceiveBufferSize();
  }
  
  public SocketAddress getRemoteSocketAddress()
  {
    return sslSocket.getRemoteSocketAddress();
  }
  
  public boolean getReuseAddress()
  {
    return sslSocket.getReuseAddress();
  }
  
  public SSLParameters getSSLParameters()
  {
    return sslSocket.getSSLParameters();
  }
  
  public int getSendBufferSize()
  {
    return sslSocket.getSendBufferSize();
  }
  
  public SSLSession getSession()
  {
    return sslSocket.getSession();
  }
  
  public int getSoLinger()
  {
    return sslSocket.getSoLinger();
  }
  
  public int getSoTimeout()
  {
    return sslSocket.getSoTimeout();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return sslSocket.getSupportedCipherSuites();
  }
  
  public String[] getSupportedProtocols()
  {
    return sslSocket.getSupportedProtocols();
  }
  
  public boolean getTcpNoDelay()
  {
    return sslSocket.getTcpNoDelay();
  }
  
  public int getTrafficClass()
  {
    return sslSocket.getTrafficClass();
  }
  
  public boolean getUseClientMode()
  {
    return sslSocket.getUseClientMode();
  }
  
  public boolean getWantClientAuth()
  {
    return sslSocket.getWantClientAuth();
  }
  
  public boolean isBound()
  {
    return sslSocket.isBound();
  }
  
  public boolean isClosed()
  {
    return sslSocket.isClosed();
  }
  
  public boolean isConnected()
  {
    return sslSocket.isConnected();
  }
  
  public boolean isInputShutdown()
  {
    return sslSocket.isInputShutdown();
  }
  
  public boolean isOutputShutdown()
  {
    return sslSocket.isOutputShutdown();
  }
  
  public void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    sslSocket.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public void sendUrgentData(int paramInt)
  {
    sslSocket.sendUrgentData(paramInt);
  }
  
  public void setEnableSessionCreation(boolean paramBoolean)
  {
    sslSocket.setEnableSessionCreation(paramBoolean);
  }
  
  public void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    sslSocket.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    sslSocket.setEnabledProtocols(paramArrayOfString);
  }
  
  public void setKeepAlive(boolean paramBoolean)
  {
    sslSocket.setKeepAlive(paramBoolean);
  }
  
  public void setNeedClientAuth(boolean paramBoolean)
  {
    sslSocket.setNeedClientAuth(paramBoolean);
  }
  
  public void setOOBInline(boolean paramBoolean)
  {
    sslSocket.setOOBInline(paramBoolean);
  }
  
  public void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    sslSocket.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public void setReceiveBufferSize(int paramInt)
  {
    sslSocket.setReceiveBufferSize(paramInt);
  }
  
  public void setReuseAddress(boolean paramBoolean)
  {
    sslSocket.setReuseAddress(paramBoolean);
  }
  
  public void setSSLParameters(SSLParameters paramSSLParameters)
  {
    sslSocket.setSSLParameters(paramSSLParameters);
  }
  
  public void setSendBufferSize(int paramInt)
  {
    sslSocket.setSendBufferSize(paramInt);
  }
  
  public void setSoLinger(boolean paramBoolean, int paramInt)
  {
    sslSocket.setSoLinger(paramBoolean, paramInt);
  }
  
  public void setSoTimeout(int paramInt)
  {
    sslSocket.setSoTimeout(paramInt);
  }
  
  public void setTcpNoDelay(boolean paramBoolean)
  {
    sslSocket.setTcpNoDelay(paramBoolean);
  }
  
  public void setTrafficClass(int paramInt)
  {
    sslSocket.setTrafficClass(paramInt);
  }
  
  public void setUseClientMode(boolean paramBoolean)
  {
    sslSocket.setUseClientMode(paramBoolean);
  }
  
  public void setWantClientAuth(boolean paramBoolean)
  {
    sslSocket.setWantClientAuth(paramBoolean);
  }
  
  public void shutdownInput()
  {
    sslSocket.shutdownInput();
  }
  
  public void shutdownOutput()
  {
    sslSocket.shutdownOutput();
  }
  
  public void startHandshake()
  {
    sslSocket.startHandshake();
  }
  
  public class HttpConnectResponseReader
  {
    public boolean alreadyRead = false;
    @NonNull
    public Charset byteEncoding;
    @NonNull
    public InputStream inputStream;
    
    public HttpConnectResponseReader(@NonNull InputStream paramInputStream, Charset paramCharset)
    {
      if (paramInputStream != null)
      {
        if (paramCharset != null)
        {
          inputStream = paramInputStream;
          byteEncoding = paramCharset;
          return;
        }
        throw new NullPointerException("byteEncoding is marked non-null but is null");
      }
      throw new NullPointerException("inputStream is marked non-null but is null");
    }
    
    public boolean isCRLF(List<Integer> paramList)
    {
      int i = paramList.size();
      boolean bool1 = false;
      if (i < 4) {
        return false;
      }
      boolean bool2 = bool1;
      if (((Integer)paramList.get(0)).intValue() == 13)
      {
        bool2 = bool1;
        if (((Integer)paramList.get(1)).intValue() == 10)
        {
          bool2 = bool1;
          if (((Integer)paramList.get(2)).intValue() == 13)
          {
            bool2 = bool1;
            if (((Integer)paramList.get(3)).intValue() == 10) {
              bool2 = true;
            }
          }
        }
      }
      return bool2;
    }
    
    public String readHttpConnectResponse()
    {
      if (!alreadyRead)
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        Object localObject = new LinkedList();
        while (!isCRLF((List)localObject))
        {
          int i = inputStream.read();
          if (i != -1)
          {
            localByteArrayOutputStream.write(i);
            if (((LinkedList)localObject).size() == 4) {
              ((LinkedList)localObject).poll();
            }
            ((LinkedList)localObject).offer(Integer.valueOf(i));
          }
          else
          {
            inputStream.close();
            throw new IOException("Unexpected EOF from proxy");
          }
        }
        localObject = new String(localByteArrayOutputStream.toByteArray(), byteEncoding);
        localByteArrayOutputStream.close();
        alreadyRead = true;
        return (String)localObject;
      }
      throw new IOException("Http connect response has already been read");
    }
  }
  
  public static abstract interface ProxiedSSLSocketNonDelegatedFunctions
  {
    public abstract void close();
    
    public abstract void connect(SocketAddress paramSocketAddress);
    
    public abstract void connect(SocketAddress paramSocketAddress, int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.ProxiedSSLSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */