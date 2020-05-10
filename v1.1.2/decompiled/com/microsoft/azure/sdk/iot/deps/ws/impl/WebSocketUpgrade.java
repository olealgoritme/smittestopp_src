package com.microsoft.azure.sdk.iot.deps.ws.impl;

import com.microsoft.azure.sdk.iot.deps.util.Base64;
import e.a.a.a.a;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WebSocketUpgrade
{
  public static final String RFC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  public Map<String, String> _additionalHeaders = null;
  public boolean _certAvailability = false;
  public final char _colon = (char)58;
  public String _host = "";
  public String _path = "";
  public String _port = "";
  public String _protocol = "";
  public final char _slash = (char)47;
  public String _webSocketKey = "";
  
  public WebSocketUpgrade(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    setHostFinal(paramString1);
    setPathFinal(paramString2);
    setPortFinal(paramInt);
    setProtocolFinal(paramString3);
    setAdditionalHeadersFinal(paramMap);
  }
  
  private String createWebSocketKey()
  {
    byte[] arrayOfByte = new byte[16];
    new SecureRandom().nextBytes(arrayOfByte);
    return Base64.encodeBase64StringLocal(arrayOfByte).trim();
  }
  
  public void clearAdditionalHeaders()
  {
    _additionalHeaders.clear();
  }
  
  public String createUpgradeRequest()
  {
    if (!_host.isEmpty())
    {
      if (!_protocol.isEmpty())
      {
        _webSocketKey = createWebSocketKey();
        StringBuilder localStringBuilder = a.a("GET https://");
        localStringBuilder.append(_host);
        localStringBuilder.append(_path);
        localStringBuilder.append("?");
        localStringBuilder.append("iothub-no-client-cert=");
        localStringBuilder.append(_certAvailability ^ true);
        localStringBuilder.append(" HTTP/1.1");
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Connection: Upgrade,Keep-Alive");
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Upgrade: websocket");
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Sec-WebSocket-Version: 13");
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Sec-WebSocket-Key: ");
        localStringBuilder.append(_webSocketKey);
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Sec-WebSocket-Protocol: ");
        localStringBuilder.append(_protocol);
        localStringBuilder.append("\r\n");
        localStringBuilder.append("Host: ");
        localStringBuilder.append(_host);
        localStringBuilder.append("\r\n");
        Object localObject = _additionalHeaders;
        if (localObject != null)
        {
          Iterator localIterator = ((Map)localObject).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append((String)localEntry.getKey());
            ((StringBuilder)localObject).append(": ");
            ((StringBuilder)localObject).append((String)localEntry.getValue());
            localStringBuilder.append(((StringBuilder)localObject).toString());
            localStringBuilder.append("\r\n");
          }
        }
        localStringBuilder.append("\r\n");
        return localStringBuilder.toString();
      }
      throw new InvalidParameterException("protocol header has no value");
    }
    throw new InvalidParameterException("host header has no value");
  }
  
  @Deprecated
  public void setAdditionalHeaders(Map<String, String> paramMap)
  {
    _additionalHeaders = paramMap;
  }
  
  public final void setAdditionalHeadersFinal(Map<String, String> paramMap)
  {
    _additionalHeaders = paramMap;
  }
  
  public void setClientCertAvailable()
  {
    _certAvailability = true;
  }
  
  @Deprecated
  public void setHost(String paramString)
  {
    _host = paramString;
  }
  
  public final void setHostFinal(String paramString)
  {
    _host = paramString;
  }
  
  @Deprecated
  public void setPath(String paramString)
  {
    _path = paramString;
    if (!paramString.isEmpty())
    {
      int i = _path.charAt(0);
      getClass();
      if (i != 47)
      {
        paramString = new StringBuilder();
        getClass();
        paramString.append('/');
        paramString.append(_path);
        _path = paramString.toString();
      }
    }
  }
  
  public final void setPathFinal(String paramString)
  {
    _path = paramString;
    if (!paramString.isEmpty())
    {
      int i = _path.charAt(0);
      getClass();
      if (i != 47)
      {
        paramString = new StringBuilder();
        getClass();
        paramString.append('/');
        paramString.append(_path);
        _path = paramString.toString();
      }
    }
  }
  
  @Deprecated
  public void setPort(int paramInt)
  {
    _port = "";
    if (paramInt != 0) {
      _port = String.valueOf(paramInt);
    }
  }
  
  public final void setPortFinal(int paramInt)
  {
    _port = "";
    if (paramInt != 0) {
      _port = String.valueOf(paramInt);
    }
  }
  
  @Deprecated
  public void setProtocol(String paramString)
  {
    _protocol = paramString;
  }
  
  public final void setProtocolFinal(String paramString)
  {
    _protocol = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = a.a("WebSocketUpgrade [host=");
    localStringBuilder1.append(_host);
    localStringBuilder1.append(", path=");
    localStringBuilder1.append(_path);
    localStringBuilder1.append(", port=");
    localStringBuilder1.append(_port);
    localStringBuilder1.append(", protocol=");
    localStringBuilder1.append(_protocol);
    localStringBuilder1.append(", webSocketKey=");
    localStringBuilder1.append(_webSocketKey);
    Object localObject = _additionalHeaders;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localStringBuilder1.append(", additionalHeaders=");
      Iterator localIterator = _additionalHeaders.entrySet().iterator();
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
        if ((str.toLowerCase().contains("sec-websocket-protocol")) && (str.toLowerCase().contains(_protocol.toLowerCase())))
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
          localStringBuilder.append(_webSocketKey);
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
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketUpgrade
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */