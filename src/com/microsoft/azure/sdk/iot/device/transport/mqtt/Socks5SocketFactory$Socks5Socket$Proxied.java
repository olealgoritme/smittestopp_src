package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Socks5SocketFactory$Socks5Socket$Proxied
{
  public String mHost;
  public InetAddress mIp;
  public int mPort;
  
  public Socks5SocketFactory$Socks5Socket$Proxied(Socks5SocketFactory.Socks5Socket paramSocks5Socket, InputStream paramInputStream)
  {
    paramSocks5Socket = new DataInputStream(paramInputStream);
    paramSocks5Socket.readUnsignedByte();
    if (paramSocks5Socket.readUnsignedByte() == 0)
    {
      paramSocks5Socket.readUnsignedByte();
      int i = paramSocks5Socket.readUnsignedByte();
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4) {
            throw new IOException();
          }
          throw new IOException();
        }
        paramInputStream = new byte[paramSocks5Socket.readUnsignedByte()];
        paramSocks5Socket.readFully(paramInputStream);
        mHost = new String(paramInputStream);
      }
      else
      {
        paramInputStream = new byte[4];
        paramSocks5Socket.readFully(paramInputStream);
        mHost = String.format("%s.%s.%s.%s", new Object[] { Integer.valueOf(paramInputStream[0] & 0xFF), Integer.valueOf(paramInputStream[1] & 0xFF), Integer.valueOf(paramInputStream[2] & 0xFF), Integer.valueOf(paramInputStream[3] & 0xFF) });
      }
      mPort = paramSocks5Socket.readUnsignedShort();
      if (i == 3) {}
    }
    try
    {
      mIp = InetAddress.getByName(mHost);
      return;
      throw new IOException();
    }
    catch (UnknownHostException paramSocks5Socket)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.Socks5SocketFactory.Socks5Socket.Proxied
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */