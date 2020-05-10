package com.microsoft.azure.sdk.iot.deps.ws.impl;

import com.microsoft.azure.sdk.iot.deps.ws.WebSocket;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocket.WebSocketFrameReadState;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocket.WebSocketState;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebSocketMessageType;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebsocketTuple;
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

public class WebSocketImpl
  implements WebSocket, d0
{
  public Map<String, String> _additionalHeaders;
  public long _bytesRead;
  public int _dataStart;
  public WebSocket.WebSocketFrameReadState _frameReadState;
  public boolean _head_closed;
  public String _host;
  public final ByteBuffer _inputBuffer;
  public Boolean _isWebSocketEnabled;
  public long _lastLength;
  public WebSocketHandler.WebSocketMessageType _lastType;
  public int _maxFrameSize = 4224;
  public final ByteBuffer _outputBuffer;
  public String _path;
  public ByteBuffer _pingBuffer;
  public int _port;
  public String _protocol;
  public WebSocket.WebSocketState _state;
  public boolean _tail_closed;
  public ByteBuffer _temp;
  public int _underlyingOutputSize;
  public WebSocketHandler _webSocketHandler;
  public int _webSocketHeaderSize;
  public ByteBuffer _wsInputBuffer;
  
  public WebSocketImpl()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    _tail_closed = false;
    _head_closed = false;
    _underlyingOutputSize = 0;
    _webSocketHeaderSize = 0;
    _state = WebSocket.WebSocketState.PN_WS_NOT_STARTED;
    _host = "";
    _path = "";
    _port = 0;
    _protocol = "";
    _additionalHeaders = null;
    _isWebSocketEnabled = localBoolean;
    _bytesRead = 0L;
    _dataStart = 0;
    _frameReadState = WebSocket.WebSocketFrameReadState.INIT_READ;
    _inputBuffer = ByteBuffer.allocate(_maxFrameSize);
    _outputBuffer = ByteBuffer.allocate(_maxFrameSize);
    _pingBuffer = ByteBuffer.allocate(_maxFrameSize);
    _wsInputBuffer = ByteBuffer.allocate(_maxFrameSize);
    _temp = ByteBuffer.allocate(_maxFrameSize);
    _lastType = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN;
    _lastLength = 0L;
    _isWebSocketEnabled = localBoolean;
  }
  
  public void configure(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, WebSocketHandler paramWebSocketHandler)
  {
    _host = paramString1;
    _path = paramString2;
    _port = paramInt;
    _protocol = paramString3;
    _additionalHeaders = paramMap;
    if (paramWebSocketHandler != null) {
      _webSocketHandler = paramWebSocketHandler;
    } else {
      _webSocketHandler = new WebSocketHandlerImpl();
    }
    _isWebSocketEnabled = Boolean.valueOf(true);
  }
  
  public Boolean getEnabled()
  {
    return _isWebSocketEnabled;
  }
  
  public ByteBuffer getInputBuffer()
  {
    return _inputBuffer;
  }
  
  public ByteBuffer getOutputBuffer()
  {
    return _outputBuffer;
  }
  
  public ByteBuffer getPingBuffer()
  {
    return _pingBuffer;
  }
  
  public WebSocket.WebSocketState getState()
  {
    return _state;
  }
  
  public WebSocketHandler getWebSocketHandler()
  {
    return _webSocketHandler;
  }
  
  public ByteBuffer getWsInputBuffer()
  {
    return _wsInputBuffer;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = a.a("WebSocketImpl [isWebSocketEnabled=");
    localStringBuilder1.append(_isWebSocketEnabled);
    localStringBuilder1.append(", state=");
    localStringBuilder1.append(_state);
    localStringBuilder1.append(", protocol=");
    localStringBuilder1.append(_protocol);
    localStringBuilder1.append(", host=");
    localStringBuilder1.append(_host);
    localStringBuilder1.append(", path=");
    localStringBuilder1.append(_path);
    localStringBuilder1.append(", port=");
    localStringBuilder1.append(_port);
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
  
  public WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer)
  {
    if (_isWebSocketEnabled.booleanValue()) {
      return _webSocketHandler.unwrapBuffer(paramByteBuffer);
    }
    return new WebSocketHandler.WebsocketTuple(0L, WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN);
  }
  
  public l0 wrap(b0 paramb0, f0 paramf0)
  {
    return new WebSocketImpl.1(this, new WebSocketImpl.WebSocketTransportWrapper(this, paramb0, paramf0, null), new o(paramf0, paramb0));
  }
  
  public void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if (_isWebSocketEnabled.booleanValue())
    {
      _webSocketHandler.wrapBuffer(paramByteBuffer1, paramByteBuffer2);
    }
    else
    {
      paramByteBuffer2.clear();
      paramByteBuffer2.put(paramByteBuffer1);
    }
  }
  
  public void writeClose()
  {
    _outputBuffer.clear();
    _pingBuffer.flip();
    _outputBuffer.put(_pingBuffer);
  }
  
  public void writePong()
  {
    _webSocketHandler.createPong(_pingBuffer, _outputBuffer);
  }
  
  public void writeUpgradeRequest()
  {
    _outputBuffer.clear();
    String str = _webSocketHandler.createUpgradeRequest(_host, _path, _port, _protocol, _additionalHeaders);
    _outputBuffer.put(str.getBytes());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */