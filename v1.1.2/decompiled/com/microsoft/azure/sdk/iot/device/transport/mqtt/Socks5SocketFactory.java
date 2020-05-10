package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

public class Socks5SocketFactory
  extends SocketFactory
{
  public final InetAddress mProxyHost;
  public final int mProxyPort;
  
  public Socks5SocketFactory(String paramString, int paramInt)
  {
    mProxyHost = InetAddress.getByName(paramString);
    mProxyPort = paramInt;
  }
  
  public Socket createSocket()
  {
    return new Socks5Socket(null);
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return createSocket(paramString, paramInt, null, 0);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    Socket localSocket = createSocket();
    if (paramInetAddress != null) {
      localSocket.bind(new InetSocketAddress(paramInetAddress, paramInt2));
    }
    localSocket.connect(new InetSocketAddress(paramString, paramInt1));
    return localSocket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostName(), paramInt, null, 0);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostName(), paramInt1, paramInetAddress2, paramInt2);
  }
  
  public class Socks5Socket
    extends Socket
  {
    public static final int ATYP_DOMAINNAME = 3;
    public static final int ATYP_IPV4 = 1;
    public static final int ATYP_IPV6 = 4;
    public static final int CMD_CONNECT = 1;
    public String mLocalHost;
    public InetAddress mLocalIP;
    public Proxied mProxied;
    public InetSocketAddress mTarget;
    
    public Socks5Socket() {}
    
    public void connect(SocketAddress paramSocketAddress, int paramInt)
    {
      mTarget = ((InetSocketAddress)paramSocketAddress);
      if (isLocal()) {
        super.connect(new InetSocketAddress(getDirectInetAddress(), mTarget.getPort()), 1000);
      } else {
        connectViaProxy(paramInt);
      }
    }
    
    public void connectViaProxy(int paramInt)
    {
      super.connect(new InetSocketAddress(Socks5SocketFactory.access$100(Socks5SocketFactory.this), Socks5SocketFactory.access$200(Socks5SocketFactory.this)), paramInt);
      sendConnectCommand();
      Object localObject = new Proxied(getInputStream());
      mProxied = ((Proxied)localObject);
      if (!mHost.equals("0.0.0.0"))
      {
        localObject = mProxied;
        mLocalHost = mHost;
        mLocalIP = mIp;
      }
      else
      {
        localObject = Socks5SocketFactory.access$100(Socks5SocketFactory.this);
        mLocalIP = ((InetAddress)localObject);
        mLocalHost = ((InetAddress)localObject).getHostName();
      }
    }
    
    public byte[] getConnectCmd()
    {
      byte[] arrayOfByte1 = mTarget.getHostName().getBytes();
      int i = arrayOfByte1.length + 7;
      byte[] arrayOfByte2 = new byte[i];
      arrayOfByte2[0] = ((byte)5);
      arrayOfByte2[1] = ((byte)1);
      arrayOfByte2[2] = ((byte)0);
      arrayOfByte2[3] = ((byte)3);
      arrayOfByte2[4] = ((byte)(byte)arrayOfByte1.length);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 5, arrayOfByte1.length);
      arrayOfByte2[(i - 2)] = ((byte)(byte)(mTarget.getPort() >> 8));
      arrayOfByte2[(i - 1)] = ((byte)(byte)mTarget.getPort());
      return arrayOfByte2;
    }
    
    public InetAddress getDirectInetAddress()
    {
      Object localObject = mTarget;
      if (localObject != null)
      {
        localObject = ((InetSocketAddress)localObject).getHostName();
        if (localObject != null) {
          return InetAddress.getByName((String)localObject);
        }
      }
      throw new IOException();
    }
    
    public InetAddress getLocalAddress()
    {
      if (isLocal()) {
        return super.getLocalAddress();
      }
      if (mLocalIP == null) {}
      try
      {
        mLocalIP = InetAddress.getByName(mLocalHost);
        return mLocalIP;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        for (;;) {}
      }
    }
    
    public int getLocalPort()
    {
      int i;
      if (isLocal()) {
        i = super.getLocalPort();
      } else {
        i = mProxied.mPort;
      }
      return i;
    }
    
    public boolean isLocal()
    {
      bool1 = false;
      try
      {
        InetAddress localInetAddress = getDirectInetAddress();
        bool2 = bool1;
        if (localInetAddress != null)
        {
          boolean bool3 = localInetAddress.isSiteLocalAddress();
          bool2 = bool1;
          if (bool3) {
            bool2 = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          boolean bool2 = bool1;
        }
      }
      return bool2;
    }
    
    public void sendConnectCommand()
    {
      InputStream localInputStream = getInputStream();
      Object localObject = getOutputStream();
      try
      {
        ((OutputStream)localObject).write(new byte[] { 5, 1, 0 });
        ((OutputStream)localObject).flush();
        int i = localInputStream.read();
        int j = localInputStream.read();
        if ((i >= 0) && (j == 0))
        {
          ((OutputStream)localObject).write(getConnectCmd());
          return;
        }
        close();
        localObject = new java/io/IOException;
        ((IOException)localObject).<init>();
        throw ((Throwable)localObject);
      }
      catch (SocketException localSocketException) {}catch (UnknownHostException localUnknownHostException) {}
      close();
      throw new IOException(localUnknownHostException);
    }
    
    public class Proxied
    {
      public String mHost;
      public InetAddress mIp;
      public int mPort;
      
      public Proxied(InputStream paramInputStream)
      {
        this$1 = new DataInputStream(paramInputStream);
        readUnsignedByte();
        if (readUnsignedByte() == 0)
        {
          readUnsignedByte();
          int i = readUnsignedByte();
          if (i != 1)
          {
            if (i != 3)
            {
              if (i != 4) {
                throw new IOException();
              }
              throw new IOException();
            }
            paramInputStream = new byte[readUnsignedByte()];
            readFully(paramInputStream);
            mHost = new String(paramInputStream);
          }
          else
          {
            paramInputStream = new byte[4];
            readFully(paramInputStream);
            mHost = String.format("%s.%s.%s.%s", new Object[] { Integer.valueOf(paramInputStream[0] & 0xFF), Integer.valueOf(paramInputStream[1] & 0xFF), Integer.valueOf(paramInputStream[2] & 0xFF), Integer.valueOf(paramInputStream[3] & 0xFF) });
          }
          mPort = readUnsignedShort();
          if (i == 3) {}
        }
        try
        {
          mIp = InetAddress.getByName(mHost);
          return;
          throw new IOException();
        }
        catch (UnknownHostException this$1)
        {
          for (;;) {}
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.Socks5SocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */