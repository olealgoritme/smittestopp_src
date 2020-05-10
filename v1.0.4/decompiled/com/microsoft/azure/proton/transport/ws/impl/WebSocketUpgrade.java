package com.microsoft.azure.proton.transport.ws.impl;

import e.a.a.a.a;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WebSocketUpgrade
{
  public final Map<String, String> additionalHeaders;
  public final String host;
  public final String path;
  public final String port;
  public final String protocol;
  public final String query;
  public final char questionMark = (char)63;
  public final String rfcGuid = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  public final char slash = (char)47;
  public volatile String webSocketKey;
  
  public WebSocketUpgrade(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, String> paramMap)
  {
    String str = "";
    webSocketKey = "";
    host = paramString1;
    paramString1 = paramString2;
    int i;
    if (!paramString2.isEmpty())
    {
      i = paramString2.charAt(0);
      getClass();
      if (i == 47)
      {
        paramString1 = paramString2;
      }
      else
      {
        paramString1 = new StringBuilder();
        getClass();
        paramString1.append('/');
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
      }
    }
    path = paramString1;
    paramString1 = paramString3;
    if (!paramString3.isEmpty())
    {
      i = paramString3.charAt(0);
      getClass();
      if (i == 63)
      {
        paramString1 = paramString3;
      }
      else
      {
        paramString1 = new StringBuilder();
        getClass();
        paramString1.append('?');
        paramString1.append(paramString3);
        paramString1 = paramString1.toString();
      }
    }
    query = paramString1;
    if (paramInt == 0) {
      paramString1 = str;
    } else {
      paramString1 = String.valueOf(paramInt);
    }
    port = paramString1;
    protocol = paramString4;
    additionalHeaders = paramMap;
  }
  
  private String createWebSocketKey()
  {
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 16; i++) {
      arrayOfByte[i] = ((byte)(byte)(int)(Math.random() * 256.0D));
    }
    return Base64.encodeBase64StringLocal(arrayOfByte).trim();
  }
  
  public String createUpgradeRequest()
  {
    if (!host.isEmpty())
    {
      if (!protocol.isEmpty())
      {
        webSocketKey = createWebSocketKey();
        StringBuilder localStringBuilder1 = a.a("GET https://");
        localStringBuilder1.append(host);
        localStringBuilder1.append(path);
        localStringBuilder1.append(query);
        localStringBuilder1.append(" HTTP/1.1");
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Connection: Upgrade,Keep-Alive");
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Upgrade: websocket");
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Sec-WebSocket-Version: 13");
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Sec-WebSocket-Key: ");
        localStringBuilder1.append(webSocketKey);
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Sec-WebSocket-Protocol: ");
        localStringBuilder1.append(protocol);
        localStringBuilder1.append("\r\n");
        localStringBuilder1.append("Host: ");
        localStringBuilder1.append(host);
        localStringBuilder1.append("\r\n");
        Object localObject = additionalHeaders;
        if (localObject != null)
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append((String)localEntry.getKey());
            localStringBuilder2.append(": ");
            localStringBuilder2.append((String)localEntry.getValue());
            localStringBuilder1.append(localStringBuilder2.toString());
            localStringBuilder1.append("\r\n");
          }
        }
        localStringBuilder1.append("\r\n");
        return localStringBuilder1.toString();
      }
      throw new InvalidParameterException("protocol header has no value");
    }
    throw new InvalidParameterException("host header has no value");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = a.a("WebSocketUpgrade [host=");
    localStringBuilder1.append(host);
    localStringBuilder1.append(", path=");
    localStringBuilder1.append(path);
    localStringBuilder1.append(", port=");
    localStringBuilder1.append(port);
    localStringBuilder1.append(", protocol=");
    localStringBuilder1.append(protocol);
    localStringBuilder1.append(", webSocketKey=");
    localStringBuilder1.append(webSocketKey);
    Object localObject = additionalHeaders;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localStringBuilder1.append(", additionalHeaders=");
      Iterator localIterator = additionalHeaders.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder2.append(":");
        localStringBuilder2.append((String)((Map.Entry)localObject).getValue());
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append(", ");
      }
      int i = localStringBuilder1.lastIndexOf(", ");
      localStringBuilder1.delete(i, i + 2);
    }
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public Boolean validateUpgradeReply(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte, StandardCharsets.UTF_8);
    Boolean localBoolean = Boolean.valueOf(false);
    Object localObject1 = new Scanner(paramArrayOfByte);
    paramArrayOfByte = localBoolean;
    Object localObject2 = paramArrayOfByte;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject5 = localObject4;
    for (;;)
    {
      if (((Scanner)localObject1).hasNextLine())
      {
        String str = ((Scanner)localObject1).nextLine();
        if ((str.toLowerCase().contains("http/1.1")) && (str.contains("101")) && (str.toLowerCase().contains("switching protocols")))
        {
          paramArrayOfByte = Boolean.valueOf(true);
          continue;
        }
        if ((str.toLowerCase().contains("upgrade")) && (str.toLowerCase().contains("websocket")))
        {
          localObject2 = Boolean.valueOf(true);
          continue;
        }
        if ((str.toLowerCase().contains("connection")) && (str.toLowerCase().contains("upgrade")))
        {
          localObject3 = Boolean.valueOf(true);
          continue;
        }
        if ((str.toLowerCase().contains("sec-websocket-protocol")) && (str.toLowerCase().contains(protocol.toLowerCase())))
        {
          localObject4 = Boolean.valueOf(true);
          continue;
        }
        if (!str.toLowerCase().contains("sec-websocket-accept")) {
          continue;
        }
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(webSocketKey);
          getClass();
          localStringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
          if (str.contains(Base64.encodeBase64StringLocal(localMessageDigest.digest(localStringBuilder.toString().getBytes())).trim())) {
            localObject5 = Boolean.valueOf(true);
          }
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
      }
    }
    ((Scanner)localObject1).close();
    localObject1 = localBoolean;
    if (paramArrayOfByte.booleanValue())
    {
      localObject1 = localBoolean;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject1 = localBoolean;
        if (((Boolean)localObject3).booleanValue())
        {
          localObject1 = localBoolean;
          if (((Boolean)localObject4).booleanValue())
          {
            localObject1 = localBoolean;
            if (((Boolean)localObject5).booleanValue()) {
              localObject1 = Boolean.valueOf(true);
            }
          }
        }
      }
    }
    return (Boolean)localObject1;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.impl.WebSocketUpgrade
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */