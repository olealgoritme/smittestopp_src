package com.microsoft.azure.proton.transport.proxy.impl;

import com.microsoft.azure.proton.transport.proxy.ProxyHandler;
import com.microsoft.azure.proton.transport.proxy.ProxyHandler.ProxyResponseResult;
import e.d.a.a.a.a.a.c;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ProxyHandlerImpl
  implements ProxyHandler
{
  public static final String CONNECT_REQUEST = "CONNECT %1$s HTTP/1.1%2$sHost: %1$s%2$sConnection: Keep-Alive%2$s";
  public static final String HEADER_FORMAT = "%s: %s";
  public static final String NEW_LINE = "\r\n";
  
  public String createProxyRequest(String paramString, Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.ROOT, "CONNECT %1$s HTTP/1.1%2$sHost: %1$s%2$sConnection: Keep-Alive%2$s", new Object[] { paramString, "\r\n" }));
    if (paramMap != null) {
      paramMap.forEach(new c(localStringBuilder));
    }
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
  
  public ProxyHandler.ProxyResponseResult validateProxyResponse(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.remaining();
    Object localObject = null;
    if (i > 0)
    {
      localObject = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get((byte[])localObject);
      localObject = new String((byte[])localObject, StandardCharsets.UTF_8);
      paramByteBuffer = new Scanner((String)localObject);
      if (paramByteBuffer.hasNextLine())
      {
        paramByteBuffer = paramByteBuffer.nextLine();
        if (((paramByteBuffer.toLowerCase().contains("http/1.1")) || (paramByteBuffer.toLowerCase().contains("http/1.0"))) && (paramByteBuffer.contains("200")) && (paramByteBuffer.toLowerCase().contains("connection established"))) {
          return new ProxyHandler.ProxyResponseResult(Boolean.valueOf(true), null);
        }
      }
    }
    return new ProxyHandler.ProxyResponseResult(Boolean.valueOf(false), (String)localObject);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.proton.transport.proxy.impl.ProxyHandlerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */