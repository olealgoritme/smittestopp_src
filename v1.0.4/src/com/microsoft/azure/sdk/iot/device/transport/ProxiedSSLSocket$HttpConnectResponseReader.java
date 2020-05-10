package com.microsoft.azure.sdk.iot.device.transport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import lombok.NonNull;

public class ProxiedSSLSocket$HttpConnectResponseReader
{
  public boolean alreadyRead = false;
  @NonNull
  public Charset byteEncoding;
  @NonNull
  public InputStream inputStream;
  
  public ProxiedSSLSocket$HttpConnectResponseReader(@NonNull ProxiedSSLSocket paramProxiedSSLSocket, @NonNull InputStream paramInputStream, Charset paramCharset)
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

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.ProxiedSSLSocket.HttpConnectResponseReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */