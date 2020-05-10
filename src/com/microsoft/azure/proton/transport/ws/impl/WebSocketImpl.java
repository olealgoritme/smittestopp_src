package com.microsoft.azure.proton.transport.ws.impl;

import com.microsoft.azure.proton.transport.ws.WebSocket;
import com.microsoft.azure.proton.transport.ws.WebSocket.WebSocketFrameReadState;
import com.microsoft.azure.proton.transport.ws.WebSocket.WebSocketState;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler.WebSocketMessageType;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler.WebsocketTuple;
import e.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import k.a.b.a.d.g0.b0;
import k.a.b.a.d.g0.d0;
import k.a.b.a.d.g0.f0;
import k.a.b.a.d.g0.l0;
import k.a.b.a.d.g0.o;
import k.f.b;
import k.f.c;

public class WebSocketImpl
  implements WebSocket, d0
{
  public static final b TRACE_LOGGER = c.a(WebSocketImpl.class);
  public Map<String, String> additionalHeaders = null;
  public long bytesRead = 0L;
  public WebSocket.WebSocketFrameReadState frameReadState = WebSocket.WebSocketFrameReadState.INIT_READ;
  public boolean headClosed = false;
  public String host = "";
  public final ByteBuffer inputBuffer = ByteBuffer.allocate(4224);
  public Boolean isWebSocketEnabled = Boolean.valueOf(false);
  public long lastLength = 0L;
  public WebSocketHandler.WebSocketMessageType lastType = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN;
  public final int maxFrameSize = 4224;
  public final ByteBuffer outputBuffer = ByteBuffer.allocate(4224);
  public String path = "";
  public ByteBuffer pingBuffer = ByteBuffer.allocate(4224);
  public int port = 0;
  public String protocol = "";
  public String query = "";
  public boolean tailClosed = false;
  public ByteBuffer tempBuffer = ByteBuffer.allocate(4224);
  public int underlyingOutputSize = 0;
  public WebSocketHandler webSocketHandler;
  public int webSocketHeaderSize = 0;
  public WebSocket.WebSocketState webSocketState = WebSocket.WebSocketState.PN_WS_NOT_STARTED;
  public ByteBuffer wsInputBuffer = ByteBuffer.allocate(4224);
  
  public void configure(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, String> paramMap, WebSocketHandler paramWebSocketHandler)
  {
    host = paramString1;
    path = paramString2;
    query = paramString3;
    port = paramInt;
    protocol = paramString4;
    additionalHeaders = paramMap;
    if (paramWebSocketHandler != null) {
      webSocketHandler = paramWebSocketHandler;
    } else {
      webSocketHandler = new WebSocketHandlerImpl();
    }
    isWebSocketEnabled = Boolean.valueOf(true);
  }
  
  public Boolean getEnabled()
  {
    return isWebSocketEnabled;
  }
  
  public ByteBuffer getInputBuffer()
  {
    return inputBuffer;
  }
  
  public ByteBuffer getOutputBuffer()
  {
    return outputBuffer;
  }
  
  public ByteBuffer getPingBuffer()
  {
    return pingBuffer;
  }
  
  public WebSocket.WebSocketState getState()
  {
    return webSocketState;
  }
  
  public WebSocketHandler getWebSocketHandler()
  {
    return webSocketHandler;
  }
  
  public ByteBuffer getWsInputBuffer()
  {
    return wsInputBuffer;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("WebSocketImpl [isWebSocketEnabled=");
    localStringBuilder.append(isWebSocketEnabled);
    localStringBuilder.append(", state=");
    localStringBuilder.append(webSocketState);
    localStringBuilder.append(", protocol=");
    localStringBuilder.append(protocol);
    localStringBuilder.append(", host=");
    localStringBuilder.append(host);
    localStringBuilder.append(", path=");
    localStringBuilder.append(path);
    localStringBuilder.append(", query=");
    localStringBuilder.append(query);
    localStringBuilder.append(", port=");
    localStringBuilder.append(port);
    Object localObject = additionalHeaders;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localStringBuilder.append(", additionalHeaders=");
      Iterator localIterator = additionalHeaders.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)localEntry.getKey());
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append((String)localEntry.getValue());
        localStringBuilder.append(((StringBuilder)localObject).toString());
        localStringBuilder.append(", ");
      }
      int i = localStringBuilder.lastIndexOf(", ");
      localStringBuilder.delete(i, i + 2);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer)
  {
    if (isWebSocketEnabled.booleanValue()) {
      return webSocketHandler.unwrapBuffer(paramByteBuffer);
    }
    return new WebSocketHandler.WebsocketTuple(0L, WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN);
  }
  
  public l0 wrap(b0 paramb0, f0 paramf0)
  {
    return new WebSocketImpl.1(this, new WebSocketImpl.WebSocketTransportWrapper(this, paramb0, paramf0, null), new o(paramf0, paramb0));
  }
  
  public void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if (isWebSocketEnabled.booleanValue())
    {
      webSocketHandler.wrapBuffer(paramByteBuffer1, paramByteBuffer2);
    }
    else
    {
      paramByteBuffer2.clear();
      paramByteBuffer2.put(paramByteBuffer1);
    }
  }
  
  public void writeClose()
  {
    outputBuffer.clear();
    pingBuffer.flip();
    outputBuffer.put(pingBuffer);
  }
  
  public void writePong()
  {
    webSocketHandler.createPong(pingBuffer, outputBuffer);
  }
  
  public void writeUpgradeRequest()
  {
    outputBuffer.clear();
    String str = webSocketHandler.createUpgradeRequest(host, path, query, port, protocol, additionalHeaders);
    outputBuffer.put(str.getBytes());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.impl.WebSocketImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */