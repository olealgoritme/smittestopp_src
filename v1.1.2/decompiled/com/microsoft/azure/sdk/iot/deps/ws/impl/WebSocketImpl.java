package com.microsoft.azure.sdk.iot.deps.ws.impl;

import com.microsoft.azure.sdk.iot.deps.ws.WebSocket;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocket.WebSocketFrameReadState;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocket.WebSocketState;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebSocketMessageType;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebsocketTuple;
import e.a.a.a.a;
import e.c.a.a.b.l.c;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l.a.b.a.d.g0.b0;
import l.a.b.a.d.g0.d0;
import l.a.b.a.d.g0.f0;
import l.a.b.a.d.g0.l;
import l.a.b.a.d.g0.l0;
import l.a.b.a.d.g0.o;

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
    StringBuilder localStringBuilder = a.a("WebSocketImpl [isWebSocketEnabled=");
    localStringBuilder.append(_isWebSocketEnabled);
    localStringBuilder.append(", state=");
    localStringBuilder.append(_state);
    localStringBuilder.append(", protocol=");
    localStringBuilder.append(_protocol);
    localStringBuilder.append(", host=");
    localStringBuilder.append(_host);
    localStringBuilder.append(", path=");
    localStringBuilder.append(_path);
    localStringBuilder.append(", port=");
    localStringBuilder.append(_port);
    Object localObject = _additionalHeaders;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localStringBuilder.append(", additionalHeaders=");
      Iterator localIterator = _additionalHeaders.entrySet().iterator();
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
    if (_isWebSocketEnabled.booleanValue()) {
      return _webSocketHandler.unwrapBuffer(paramByteBuffer);
    }
    return new WebSocketHandler.WebsocketTuple(0L, WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN);
  }
  
  public l0 wrap(b0 paramb0, f0 paramf0)
  {
    new WebSocketSniffer(new WebSocketTransportWrapper(paramb0, paramf0, null), new o(paramf0, paramb0))
    {
      public boolean isDeterminationMade()
      {
        _selectedTransportWrapper = _wrapper1;
        return true;
      }
    };
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
  
  public class WebSocketTransportWrapper
    implements l0
  {
    public final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    public final ByteBuffer _head;
    public final b0 _underlyingInput;
    public final f0 _underlyingOutput;
    
    public WebSocketTransportWrapper(b0 paramb0, f0 paramf0)
    {
      _underlyingInput = paramb0;
      _underlyingOutput = paramf0;
      this$1 = WebSocketImpl.access$100(WebSocketImpl.this).asReadOnlyBuffer();
      _head = WebSocketImpl.this;
      limit(0);
    }
    
    private String convertToBinary(ByteBuffer paramByteBuffer)
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.duplicate().get(arrayOfByte);
      return convertToBinary(arrayOfByte);
    }
    
    private String convertToBinary(byte[] paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = paramArrayOfByte.length;
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append(String.format("%8s", new Object[] { Integer.toBinaryString(paramArrayOfByte[j] & 0xFF) }).replace(' ', '0'));
        localStringBuilder.append('|');
      }
      return localStringBuilder.toString();
    }
    
    private String convertToHex(ByteBuffer paramByteBuffer)
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.duplicate().get(arrayOfByte);
      return convertToHex(arrayOfByte);
    }
    
    private String convertToHex(byte[] paramArrayOfByte)
    {
      int i = paramArrayOfByte.length;
      char[] arrayOfChar1 = new char[i * 5];
      int j = 0;
      int m;
      for (int k = 0; j < i; k = m + 1)
      {
        m = k + 1;
        arrayOfChar1[k] = ((char)48);
        int n = m + 1;
        arrayOfChar1[m] = ((char)120);
        k = n + 1;
        char[] arrayOfChar2 = HEX_DIGITS;
        arrayOfChar1[n] = ((char)arrayOfChar2[((paramArrayOfByte[j] & 0xF0) >>> 4)]);
        m = k + 1;
        arrayOfChar1[k] = ((char)arrayOfChar2[(paramArrayOfByte[j] & 0xF)]);
        arrayOfChar1[m] = ((char)124);
        j++;
      }
      return new String(arrayOfChar1);
    }
    
    private void processInput()
    {
      int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
      if (i != 1)
      {
        if ((i == 2) || (i == 3))
        {
          if (WebSocketImpl.access$200(WebSocketImpl.this).remaining() > 0)
          {
            label44:
            Object localObject;
            WebSocketImpl localWebSocketImpl;
            do
            {
              i = 0;
              for (;;)
              {
                if (i != 0) {
                  break label691;
                }
                int j = WebSocketImpl.access$1000(WebSocketImpl.this).ordinal();
                if (j == 0) {
                  break label626;
                }
                if (j == 1) {
                  break;
                }
                if (j != 2)
                {
                  if (j == 3)
                  {
                    readInputBuffer();
                    WebSocketImpl.access$300(WebSocketImpl.this).flip();
                    localObject = WebSocketImpl.this;
                    localObject = ((WebSocketImpl)localObject).unwrapBuffer(WebSocketImpl.access$300((WebSocketImpl)localObject));
                    WebSocketImpl.access$402(WebSocketImpl.this, ((WebSocketHandler.WebsocketTuple)localObject).getType());
                    WebSocketImpl.access$1202(WebSocketImpl.this, ((WebSocketHandler.WebsocketTuple)localObject).getLength());
                    localWebSocketImpl = WebSocketImpl.this;
                    if (WebSocketImpl.access$400(localWebSocketImpl) == WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK) {
                      localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
                    } else {
                      localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                    }
                    WebSocketImpl.access$1002(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
                    if ((WebSocketImpl.access$1000(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ) && (WebSocketImpl.access$300(WebSocketImpl.this).position() != WebSocketImpl.access$300(WebSocketImpl.this).limit())) {
                      i = 0;
                    } else {
                      i = 1;
                    }
                    if (WebSocketImpl.access$1000(WebSocketImpl.this) == WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ)
                    {
                      WebSocketImpl.access$300(WebSocketImpl.this).compact();
                    }
                    else
                    {
                      WebSocketImpl.access$300(WebSocketImpl.this).position(WebSocketImpl.access$300(WebSocketImpl.this).limit());
                      WebSocketImpl.access$300(WebSocketImpl.this).limit(WebSocketImpl.access$300(WebSocketImpl.this).capacity());
                    }
                  }
                }
                else
                {
                  readInputBuffer();
                  WebSocketImpl.access$300(WebSocketImpl.this).flip();
                  if (WebSocketImpl.access$300(WebSocketImpl.this).remaining() >= WebSocketImpl.access$1200(WebSocketImpl.this) - WebSocketImpl.access$1100(WebSocketImpl.this))
                  {
                    localObject = new byte[(int)(WebSocketImpl.access$1200(WebSocketImpl.this) - WebSocketImpl.access$1100(WebSocketImpl.this))];
                    WebSocketImpl.access$300(WebSocketImpl.this).get((byte[])localObject, 0, (int)(WebSocketImpl.access$1200(WebSocketImpl.this) - WebSocketImpl.access$1100(WebSocketImpl.this)));
                    WebSocketImpl.access$500(WebSocketImpl.this).put((byte[])localObject);
                    localObject = WebSocketImpl.this;
                    long l = WebSocketImpl.access$1100((WebSocketImpl)localObject);
                    WebSocketImpl.access$1102((WebSocketImpl)localObject, WebSocketImpl.access$1200(WebSocketImpl.this) - WebSocketImpl.access$1100(WebSocketImpl.this) + l);
                  }
                  else
                  {
                    i = WebSocketImpl.access$300(WebSocketImpl.this).remaining();
                    localObject = new byte[i];
                    WebSocketImpl.access$300(WebSocketImpl.this).get((byte[])localObject);
                    WebSocketImpl.access$500(WebSocketImpl.this).put((byte[])localObject);
                    localObject = WebSocketImpl.this;
                    WebSocketImpl.access$1102((WebSocketImpl)localObject, WebSocketImpl.access$1100((WebSocketImpl)localObject) + i);
                  }
                  sendToUnderlyingInput();
                  localWebSocketImpl = WebSocketImpl.this;
                  if (WebSocketImpl.access$1100(localWebSocketImpl) == WebSocketImpl.access$1200(WebSocketImpl.this)) {
                    localObject = WebSocket.WebSocketFrameReadState.INIT_READ;
                  } else {
                    localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                  }
                  WebSocketImpl.access$1002(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
                  if (WebSocketImpl.access$300(WebSocketImpl.this).remaining() == 0) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  WebSocketImpl.access$300(WebSocketImpl.this).compact();
                }
              }
              readInputBuffer();
              localWebSocketImpl = WebSocketImpl.this;
              if (WebSocketImpl.access$300(localWebSocketImpl).position() < 2) {
                localObject = WebSocketImpl.access$1000(WebSocketImpl.this);
              } else {
                localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
              }
              WebSocketImpl.access$1002(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
            } while (WebSocketImpl.access$1000(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ);
            for (;;)
            {
              i = 1;
              break label44;
              label626:
              WebSocketImpl.access$1102(WebSocketImpl.this, 0L);
              readInputBuffer();
              localWebSocketImpl = WebSocketImpl.this;
              if (WebSocketImpl.access$300(localWebSocketImpl).position() < 2) {
                localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
              } else {
                localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
              }
              WebSocketImpl.access$1002(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
              if (WebSocketImpl.access$1000(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ) {
                break;
              }
            }
          }
          label691:
          WebSocketImpl.access$200(WebSocketImpl.this).compact();
        }
      }
      else
      {
        if (WebSocketImpl.access$900(WebSocketImpl.this).validateUpgradeReply(WebSocketImpl.access$200(WebSocketImpl.this)).booleanValue()) {
          WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
        }
        WebSocketImpl.access$200(WebSocketImpl.this).compact();
      }
    }
    
    private void readInputBuffer()
    {
      c.a(WebSocketImpl.access$200(WebSocketImpl.this), WebSocketImpl.access$300(WebSocketImpl.this));
    }
    
    private boolean sendToUnderlyingInput()
    {
      int i = WebSocketImpl.access$400(WebSocketImpl.this).ordinal();
      boolean bool = true;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                WebSocketImpl.access$500(WebSocketImpl.this).flip();
                WebSocketImpl.access$700(WebSocketImpl.this).put(WebSocketImpl.access$500(WebSocketImpl.this));
                WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_CLOSING);
                WebSocketImpl.access$500(WebSocketImpl.this).compact();
                WebSocketImpl.access$500(WebSocketImpl.this).flip();
                break label322;
              }
            }
            else
            {
              WebSocketImpl.access$500(WebSocketImpl.this).flip();
              WebSocketImpl.access$700(WebSocketImpl.this).put(WebSocketImpl.access$500(WebSocketImpl.this));
              WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_PONG);
              WebSocketImpl.access$500(WebSocketImpl.this).compact();
              WebSocketImpl.access$500(WebSocketImpl.this).flip();
              break label322;
            }
          }
          else
          {
            WebSocketImpl.access$500(WebSocketImpl.this).flip();
            if (c.a(WebSocketImpl.access$500(WebSocketImpl.this), _underlyingInput) == -1) {
              WebSocketImpl.access$602(WebSocketImpl.this, true);
            }
            WebSocketImpl.access$500(WebSocketImpl.this).compact();
            WebSocketImpl.access$500(WebSocketImpl.this).flip();
            break label322;
          }
        }
        else
        {
          WebSocketImpl.access$500(WebSocketImpl.this).position(WebSocketImpl.access$500(WebSocketImpl.this).limit());
          WebSocketImpl.access$500(WebSocketImpl.this).limit(WebSocketImpl.access$500(WebSocketImpl.this).capacity());
        }
      }
      else
      {
        WebSocketImpl.access$500(WebSocketImpl.this).position(WebSocketImpl.access$500(WebSocketImpl.this).limit());
        WebSocketImpl.access$500(WebSocketImpl.this).limit(WebSocketImpl.access$500(WebSocketImpl.this).capacity());
      }
      bool = false;
      label322:
      WebSocketImpl.access$500(WebSocketImpl.this).position(WebSocketImpl.access$500(WebSocketImpl.this).limit());
      WebSocketImpl.access$500(WebSocketImpl.this).limit(WebSocketImpl.access$500(WebSocketImpl.this).capacity());
      return bool;
    }
    
    public int capacity()
    {
      if (_isWebSocketEnabled.booleanValue())
      {
        if (WebSocketImpl.access$600(WebSocketImpl.this)) {
          return -1;
        }
        return WebSocketImpl.access$200(WebSocketImpl.this).remaining();
      }
      return _underlyingInput.capacity();
    }
    
    public void close_head()
    {
      _underlyingOutput.close_head();
    }
    
    public void close_tail()
    {
      WebSocketImpl.access$602(WebSocketImpl.this, true);
      if (_isWebSocketEnabled.booleanValue())
      {
        WebSocketImpl.access$1302(WebSocketImpl.this, true);
        _underlyingInput.close_tail();
      }
      else
      {
        _underlyingInput.close_tail();
      }
    }
    
    public ByteBuffer head()
    {
      if (_isWebSocketEnabled.booleanValue())
      {
        int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
        if (i != 1) {
          if (i != 2)
          {
            if ((i != 3) && (i != 4)) {
              return _underlyingOutput.head();
            }
          }
          else
          {
            WebSocketImpl.access$1402(WebSocketImpl.this, _underlyingOutput.pending());
            if (WebSocketImpl.access$1400(WebSocketImpl.this) > 0)
            {
              wrapBuffer(_underlyingOutput.head(), WebSocketImpl.access$100(WebSocketImpl.this));
              WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
              WebSocketImpl.access$1502(localWebSocketImpl, WebSocketImpl.access$100(localWebSocketImpl).position() - WebSocketImpl.access$1400(WebSocketImpl.this));
              _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
            }
            return _head;
          }
        }
        return _head;
      }
      return _underlyingOutput.head();
    }
    
    public int pending()
    {
      if (_isWebSocketEnabled.booleanValue())
      {
        int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  return -1;
                }
                WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CLOSED);
                writeClose();
                _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
                if (WebSocketImpl.access$1300(WebSocketImpl.this))
                {
                  WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
                  return -1;
                }
                return WebSocketImpl.access$100(WebSocketImpl.this).position();
              }
              WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
              writePong();
              _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
              if (WebSocketImpl.access$1300(WebSocketImpl.this))
              {
                WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
                return -1;
              }
              return WebSocketImpl.access$100(WebSocketImpl.this).position();
            }
            WebSocketImpl.access$1402(WebSocketImpl.this, _underlyingOutput.pending());
            if (WebSocketImpl.access$1400(WebSocketImpl.this) > 0)
            {
              WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
              WebSocketImpl.access$1502(localWebSocketImpl, WebSocketImpl.access$900(localWebSocketImpl).calculateHeaderSize(WebSocketImpl.access$1400(WebSocketImpl.this)));
              i = WebSocketImpl.access$1400(WebSocketImpl.this);
              return WebSocketImpl.access$1500(WebSocketImpl.this) + i;
            }
            return WebSocketImpl.access$1400(WebSocketImpl.this);
          }
          if ((WebSocketImpl.access$1300(WebSocketImpl.this)) && (WebSocketImpl.access$100(WebSocketImpl.this).position() == 0))
          {
            WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
            return -1;
          }
          return WebSocketImpl.access$100(WebSocketImpl.this).position();
        }
        if (WebSocketImpl.access$100(WebSocketImpl.this).position() == 0)
        {
          WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTING);
          writeUpgradeRequest();
          _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
          if (WebSocketImpl.access$1300(WebSocketImpl.this))
          {
            WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
            return -1;
          }
          return WebSocketImpl.access$100(WebSocketImpl.this).position();
        }
        return WebSocketImpl.access$100(WebSocketImpl.this).position();
      }
      return _underlyingOutput.pending();
    }
    
    public void pop(int paramInt)
    {
      if (_isWebSocketEnabled.booleanValue()) {
        switch (WebSocketImpl.access$800(WebSocketImpl.this).ordinal())
        {
        default: 
          break;
        case 0: 
        case 5: 
        case 6: 
          _underlyingOutput.pop(paramInt);
          break;
        case 2: 
        case 3: 
        case 4: 
          if ((paramInt >= WebSocketImpl.access$1500(WebSocketImpl.this)) && (WebSocketImpl.access$100(WebSocketImpl.this).position() != 0))
          {
            WebSocketImpl.access$100(WebSocketImpl.this).flip();
            WebSocketImpl.access$100(WebSocketImpl.this).position(paramInt);
            WebSocketImpl.access$100(WebSocketImpl.this).compact();
            _head.position(0);
            _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
            _underlyingOutput.pop(paramInt - WebSocketImpl.access$1500(WebSocketImpl.this));
            WebSocketImpl.access$1502(WebSocketImpl.this, 0);
          }
          else if ((paramInt > 0) && (paramInt < WebSocketImpl.access$1500(WebSocketImpl.this)))
          {
            WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
            WebSocketImpl.access$1502(localWebSocketImpl, WebSocketImpl.access$1500(localWebSocketImpl) - paramInt);
          }
          else
          {
            _underlyingOutput.pop(paramInt);
          }
          break;
        case 1: 
          if (WebSocketImpl.access$100(WebSocketImpl.this).position() != 0)
          {
            WebSocketImpl.access$100(WebSocketImpl.this).flip();
            WebSocketImpl.access$100(WebSocketImpl.this).position(paramInt);
            WebSocketImpl.access$100(WebSocketImpl.this).compact();
            _head.position(0);
            _head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
          }
          else
          {
            _underlyingOutput.pop(paramInt);
          }
          break;
        }
      } else {
        _underlyingOutput.pop(paramInt);
      }
    }
    
    public int position()
    {
      if (_isWebSocketEnabled.booleanValue())
      {
        if (WebSocketImpl.access$600(WebSocketImpl.this)) {
          return -1;
        }
        return WebSocketImpl.access$200(WebSocketImpl.this).position();
      }
      return _underlyingInput.position();
    }
    
    public void process()
    {
      if (_isWebSocketEnabled.booleanValue())
      {
        WebSocketImpl.access$200(WebSocketImpl.this).flip();
        int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
        if ((i != 1) && (i != 2)) {
          _underlyingInput.process();
        } else {
          processInput();
        }
      }
      else
      {
        _underlyingInput.process();
      }
    }
    
    public ByteBuffer tail()
    {
      if (_isWebSocketEnabled.booleanValue()) {
        return WebSocketImpl.access$200(WebSocketImpl.this);
      }
      return _underlyingInput.tail();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */