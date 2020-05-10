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
import l.a.b.a.d.g0.b0;
import l.a.b.a.d.g0.d0;
import l.a.b.a.d.g0.f0;
import l.a.b.a.d.g0.l;
import l.a.b.a.d.g0.l0;
import l.a.b.a.d.g0.o;
import l.f.b;

public class WebSocketImpl
  implements WebSocket, d0
{
  public static final b TRACE_LOGGER = l.f.c.a(WebSocketImpl.class);
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
    StringBuilder localStringBuilder1 = a.a("WebSocketImpl [isWebSocketEnabled=");
    localStringBuilder1.append(isWebSocketEnabled);
    localStringBuilder1.append(", state=");
    localStringBuilder1.append(webSocketState);
    localStringBuilder1.append(", protocol=");
    localStringBuilder1.append(protocol);
    localStringBuilder1.append(", host=");
    localStringBuilder1.append(host);
    localStringBuilder1.append(", path=");
    localStringBuilder1.append(path);
    localStringBuilder1.append(", query=");
    localStringBuilder1.append(query);
    localStringBuilder1.append(", port=");
    localStringBuilder1.append(port);
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
  
  public WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer)
  {
    if (isWebSocketEnabled.booleanValue()) {
      return webSocketHandler.unwrapBuffer(paramByteBuffer);
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
  
  public class WebSocketTransportWrapper
    implements l0
  {
    public final ByteBuffer head;
    public final char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    public final b0 underlyingInput;
    public final f0 underlyingOutput;
    
    public WebSocketTransportWrapper(b0 paramb0, f0 paramf0)
    {
      underlyingInput = paramb0;
      underlyingOutput = paramf0;
      this$1 = WebSocketImpl.access$100(WebSocketImpl.this).asReadOnlyBuffer();
      head = WebSocketImpl.this;
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
        char[] arrayOfChar2 = hexDigits;
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
                int j = WebSocketImpl.access$1100(WebSocketImpl.this).ordinal();
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
                    WebSocketImpl.access$1302(WebSocketImpl.this, ((WebSocketHandler.WebsocketTuple)localObject).getLength());
                    localWebSocketImpl = WebSocketImpl.this;
                    if (WebSocketImpl.access$400(localWebSocketImpl) == WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK) {
                      localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
                    } else {
                      localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                    }
                    WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
                    if ((WebSocketImpl.access$1100(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ) && (WebSocketImpl.access$300(WebSocketImpl.this).position() != WebSocketImpl.access$300(WebSocketImpl.this).limit())) {
                      i = 0;
                    } else {
                      i = 1;
                    }
                    if (WebSocketImpl.access$1100(WebSocketImpl.this) == WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ)
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
                  if (WebSocketImpl.access$300(WebSocketImpl.this).remaining() >= WebSocketImpl.access$1300(WebSocketImpl.this) - WebSocketImpl.access$1200(WebSocketImpl.this))
                  {
                    localObject = new byte[(int)(WebSocketImpl.access$1300(WebSocketImpl.this) - WebSocketImpl.access$1200(WebSocketImpl.this))];
                    WebSocketImpl.access$300(WebSocketImpl.this).get((byte[])localObject, 0, (int)(WebSocketImpl.access$1300(WebSocketImpl.this) - WebSocketImpl.access$1200(WebSocketImpl.this)));
                    WebSocketImpl.access$500(WebSocketImpl.this).put((byte[])localObject);
                    localObject = WebSocketImpl.this;
                    long l = WebSocketImpl.access$1200((WebSocketImpl)localObject);
                    WebSocketImpl.access$1202((WebSocketImpl)localObject, WebSocketImpl.access$1300(WebSocketImpl.this) - WebSocketImpl.access$1200(WebSocketImpl.this) + l);
                  }
                  else
                  {
                    i = WebSocketImpl.access$300(WebSocketImpl.this).remaining();
                    localObject = new byte[i];
                    WebSocketImpl.access$300(WebSocketImpl.this).get((byte[])localObject);
                    WebSocketImpl.access$500(WebSocketImpl.this).put((byte[])localObject);
                    localObject = WebSocketImpl.this;
                    WebSocketImpl.access$1202((WebSocketImpl)localObject, WebSocketImpl.access$1200((WebSocketImpl)localObject) + i);
                  }
                  sendToUnderlyingInput();
                  localWebSocketImpl = WebSocketImpl.this;
                  if (WebSocketImpl.access$1200(localWebSocketImpl) == WebSocketImpl.access$1300(WebSocketImpl.this)) {
                    localObject = WebSocket.WebSocketFrameReadState.INIT_READ;
                  } else {
                    localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                  }
                  WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
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
                localObject = WebSocketImpl.access$1100(WebSocketImpl.this);
              } else {
                localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
              }
              WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
            } while (WebSocketImpl.access$1100(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ);
            for (;;)
            {
              i = 1;
              break label44;
              label626:
              WebSocketImpl.access$1202(WebSocketImpl.this, 0L);
              readInputBuffer();
              localWebSocketImpl = WebSocketImpl.this;
              if (WebSocketImpl.access$300(localWebSocketImpl).position() < 2) {
                localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
              } else {
                localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
              }
              WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
              if (WebSocketImpl.access$1100(WebSocketImpl.this) != WebSocket.WebSocketFrameReadState.CHUNK_READ) {
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
        WebSocketImpl.access$200(WebSocketImpl.this).mark();
        if (WebSocketImpl.access$900(WebSocketImpl.this).validateUpgradeReply(WebSocketImpl.access$200(WebSocketImpl.this)).booleanValue())
        {
          WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
        }
        else
        {
          WebSocketImpl.access$200(WebSocketImpl.this).reset();
          WebSocketImpl.access$1000().c("Websocket connecting response incomplete");
        }
        WebSocketImpl.access$200(WebSocketImpl.this).compact();
      }
    }
    
    private void readInputBuffer()
    {
      e.c.a.a.b.l.c.a(WebSocketImpl.access$200(WebSocketImpl.this), WebSocketImpl.access$300(WebSocketImpl.this));
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
            if (e.c.a.a.b.l.c.a(WebSocketImpl.access$500(WebSocketImpl.this), underlyingInput) == -1) {
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
      if (isWebSocketEnabled.booleanValue())
      {
        if (WebSocketImpl.access$600(WebSocketImpl.this)) {
          return -1;
        }
        return WebSocketImpl.access$200(WebSocketImpl.this).remaining();
      }
      return underlyingInput.capacity();
    }
    
    public void close_head()
    {
      underlyingOutput.close_head();
    }
    
    public void close_tail()
    {
      WebSocketImpl.access$602(WebSocketImpl.this, true);
      if (isWebSocketEnabled.booleanValue())
      {
        WebSocketImpl.access$1402(WebSocketImpl.this, true);
        underlyingInput.close_tail();
      }
      else
      {
        underlyingInput.close_tail();
      }
    }
    
    public ByteBuffer head()
    {
      if (isWebSocketEnabled.booleanValue())
      {
        int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
        if (i != 1) {
          if (i != 2)
          {
            if ((i != 3) && (i != 4)) {
              return underlyingOutput.head();
            }
          }
          else
          {
            WebSocketImpl.access$1502(WebSocketImpl.this, underlyingOutput.pending());
            if (WebSocketImpl.access$1500(WebSocketImpl.this) > 0)
            {
              wrapBuffer(underlyingOutput.head(), WebSocketImpl.access$100(WebSocketImpl.this));
              WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
              WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$100(localWebSocketImpl).position() - WebSocketImpl.access$1500(WebSocketImpl.this));
              head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
            }
            return head;
          }
        }
        return head;
      }
      return underlyingOutput.head();
    }
    
    public int pending()
    {
      if (isWebSocketEnabled.booleanValue())
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
                head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
                if (WebSocketImpl.access$1400(WebSocketImpl.this))
                {
                  WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
                  return -1;
                }
                return WebSocketImpl.access$100(WebSocketImpl.this).position();
              }
              WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
              writePong();
              head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
              if (WebSocketImpl.access$1400(WebSocketImpl.this))
              {
                WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
                return -1;
              }
              return WebSocketImpl.access$100(WebSocketImpl.this).position();
            }
            WebSocketImpl.access$1502(WebSocketImpl.this, underlyingOutput.pending());
            if (WebSocketImpl.access$1500(WebSocketImpl.this) > 0)
            {
              WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
              WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$900(localWebSocketImpl).calculateHeaderSize(WebSocketImpl.access$1500(WebSocketImpl.this)));
              i = WebSocketImpl.access$1500(WebSocketImpl.this);
              return WebSocketImpl.access$1600(WebSocketImpl.this) + i;
            }
            return WebSocketImpl.access$1500(WebSocketImpl.this);
          }
          if ((WebSocketImpl.access$1400(WebSocketImpl.this)) && (WebSocketImpl.access$100(WebSocketImpl.this).position() == 0))
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
          head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
          if (WebSocketImpl.access$1400(WebSocketImpl.this))
          {
            WebSocketImpl.access$802(WebSocketImpl.this, WebSocket.WebSocketState.PN_WS_FAILED);
            return -1;
          }
          return WebSocketImpl.access$100(WebSocketImpl.this).position();
        }
        return WebSocketImpl.access$100(WebSocketImpl.this).position();
      }
      return underlyingOutput.pending();
    }
    
    public void pop(int paramInt)
    {
      if (isWebSocketEnabled.booleanValue()) {
        switch (WebSocketImpl.access$800(WebSocketImpl.this).ordinal())
        {
        default: 
          break;
        case 0: 
        case 5: 
        case 6: 
          underlyingOutput.pop(paramInt);
          break;
        case 2: 
        case 3: 
        case 4: 
          if ((paramInt >= WebSocketImpl.access$1600(WebSocketImpl.this)) && (WebSocketImpl.access$100(WebSocketImpl.this).position() != 0))
          {
            WebSocketImpl.access$100(WebSocketImpl.this).flip();
            WebSocketImpl.access$100(WebSocketImpl.this).position(paramInt);
            WebSocketImpl.access$100(WebSocketImpl.this).compact();
            head.position(0);
            head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
            underlyingOutput.pop(paramInt - WebSocketImpl.access$1600(WebSocketImpl.this));
            WebSocketImpl.access$1602(WebSocketImpl.this, 0);
          }
          else if ((paramInt > 0) && (paramInt < WebSocketImpl.access$1600(WebSocketImpl.this)))
          {
            WebSocketImpl localWebSocketImpl = WebSocketImpl.this;
            WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$1600(localWebSocketImpl) - paramInt);
          }
          else
          {
            underlyingOutput.pop(paramInt);
          }
          break;
        case 1: 
          if (WebSocketImpl.access$100(WebSocketImpl.this).position() != 0)
          {
            WebSocketImpl.access$100(WebSocketImpl.this).flip();
            WebSocketImpl.access$100(WebSocketImpl.this).position(paramInt);
            WebSocketImpl.access$100(WebSocketImpl.this).compact();
            head.position(0);
            head.limit(WebSocketImpl.access$100(WebSocketImpl.this).position());
          }
          else
          {
            underlyingOutput.pop(paramInt);
          }
          break;
        }
      } else {
        underlyingOutput.pop(paramInt);
      }
    }
    
    public int position()
    {
      if (isWebSocketEnabled.booleanValue())
      {
        if (WebSocketImpl.access$600(WebSocketImpl.this)) {
          return -1;
        }
        return WebSocketImpl.access$200(WebSocketImpl.this).position();
      }
      return underlyingInput.position();
    }
    
    public void process()
    {
      if (isWebSocketEnabled.booleanValue())
      {
        WebSocketImpl.access$200(WebSocketImpl.this).flip();
        int i = WebSocketImpl.access$800(WebSocketImpl.this).ordinal();
        if ((i != 1) && (i != 2)) {
          underlyingInput.process();
        } else {
          processInput();
        }
      }
      else
      {
        underlyingInput.process();
      }
    }
    
    public ByteBuffer tail()
    {
      if (isWebSocketEnabled.booleanValue()) {
        return WebSocketImpl.access$200(WebSocketImpl.this);
      }
      return underlyingInput.tail();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.proton.transport.ws.impl.WebSocketImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */