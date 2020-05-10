package com.microsoft.azure.proton.transport.ws.impl;

import com.microsoft.azure.proton.transport.ws.WebSocket.WebSocketFrameReadState;
import com.microsoft.azure.proton.transport.ws.WebSocket.WebSocketState;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler.WebSocketMessageType;
import com.microsoft.azure.proton.transport.ws.WebSocketHandler.WebsocketTuple;
import e.c.a.a.b.l.c;
import java.nio.ByteBuffer;
import k.a.b.a.d.g0.b0;
import k.a.b.a.d.g0.f0;
import k.a.b.a.d.g0.l0;
import k.f.b;

public class WebSocketImpl$WebSocketTransportWrapper
  implements l0
{
  public final ByteBuffer head;
  public final char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public final b0 underlyingInput;
  public final f0 underlyingOutput;
  
  public WebSocketImpl$WebSocketTransportWrapper(WebSocketImpl paramWebSocketImpl, b0 paramb0, f0 paramf0)
  {
    underlyingInput = paramb0;
    underlyingOutput = paramf0;
    paramWebSocketImpl = WebSocketImpl.access$100(paramWebSocketImpl).asReadOnlyBuffer();
    head = paramWebSocketImpl;
    paramWebSocketImpl.limit(0);
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
    for (int k = 0; j < i; k++)
    {
      int m = k + 1;
      arrayOfChar1[k] = ((char)48);
      k = m + 1;
      arrayOfChar1[m] = ((char)120);
      m = k + 1;
      char[] arrayOfChar2 = hexDigits;
      arrayOfChar1[k] = ((char)arrayOfChar2[((paramArrayOfByte[j] & 0xF0) >>> 4)]);
      k = m + 1;
      arrayOfChar1[m] = ((char)arrayOfChar2[(paramArrayOfByte[j] & 0xF)]);
      arrayOfChar1[k] = ((char)124);
      j++;
    }
    return new String(arrayOfChar1);
  }
  
  private void processInput()
  {
    int i = WebSocketImpl.access$800(this$0).ordinal();
    if (i != 1)
    {
      if ((i == 2) || (i == 3))
      {
        if (WebSocketImpl.access$200(this$0).remaining() > 0)
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
              int j = WebSocketImpl.access$1100(this$0).ordinal();
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
                  WebSocketImpl.access$300(this$0).flip();
                  localObject = this$0;
                  localObject = ((WebSocketImpl)localObject).unwrapBuffer(WebSocketImpl.access$300((WebSocketImpl)localObject));
                  WebSocketImpl.access$402(this$0, ((WebSocketHandler.WebsocketTuple)localObject).getType());
                  WebSocketImpl.access$1302(this$0, ((WebSocketHandler.WebsocketTuple)localObject).getLength());
                  localWebSocketImpl = this$0;
                  if (WebSocketImpl.access$400(localWebSocketImpl) == WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK) {
                    localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
                  } else {
                    localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                  }
                  WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
                  if ((WebSocketImpl.access$1100(this$0) != WebSocket.WebSocketFrameReadState.CHUNK_READ) && (WebSocketImpl.access$300(this$0).position() != WebSocketImpl.access$300(this$0).limit())) {
                    i = 0;
                  } else {
                    i = 1;
                  }
                  if (WebSocketImpl.access$1100(this$0) == WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ)
                  {
                    WebSocketImpl.access$300(this$0).compact();
                  }
                  else
                  {
                    WebSocketImpl.access$300(this$0).position(WebSocketImpl.access$300(this$0).limit());
                    WebSocketImpl.access$300(this$0).limit(WebSocketImpl.access$300(this$0).capacity());
                  }
                }
              }
              else
              {
                readInputBuffer();
                WebSocketImpl.access$300(this$0).flip();
                if (WebSocketImpl.access$300(this$0).remaining() >= WebSocketImpl.access$1300(this$0) - WebSocketImpl.access$1200(this$0))
                {
                  localObject = new byte[(int)(WebSocketImpl.access$1300(this$0) - WebSocketImpl.access$1200(this$0))];
                  WebSocketImpl.access$300(this$0).get((byte[])localObject, 0, (int)(WebSocketImpl.access$1300(this$0) - WebSocketImpl.access$1200(this$0)));
                  WebSocketImpl.access$500(this$0).put((byte[])localObject);
                  localObject = this$0;
                  long l = WebSocketImpl.access$1200((WebSocketImpl)localObject);
                  WebSocketImpl.access$1202((WebSocketImpl)localObject, WebSocketImpl.access$1300(this$0) - WebSocketImpl.access$1200(this$0) + l);
                }
                else
                {
                  i = WebSocketImpl.access$300(this$0).remaining();
                  localObject = new byte[i];
                  WebSocketImpl.access$300(this$0).get((byte[])localObject);
                  WebSocketImpl.access$500(this$0).put((byte[])localObject);
                  localObject = this$0;
                  WebSocketImpl.access$1202((WebSocketImpl)localObject, WebSocketImpl.access$1200((WebSocketImpl)localObject) + i);
                }
                sendToUnderlyingInput();
                localWebSocketImpl = this$0;
                if (WebSocketImpl.access$1200(localWebSocketImpl) == WebSocketImpl.access$1300(this$0)) {
                  localObject = WebSocket.WebSocketFrameReadState.INIT_READ;
                } else {
                  localObject = WebSocket.WebSocketFrameReadState.CONTINUED_FRAME_READ;
                }
                WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
                if (WebSocketImpl.access$300(this$0).remaining() == 0) {
                  i = 1;
                } else {
                  i = 0;
                }
                WebSocketImpl.access$300(this$0).compact();
              }
            }
            readInputBuffer();
            localWebSocketImpl = this$0;
            if (WebSocketImpl.access$300(localWebSocketImpl).position() < 2) {
              localObject = WebSocketImpl.access$1100(this$0);
            } else {
              localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
            }
            WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
          } while (WebSocketImpl.access$1100(this$0) != WebSocket.WebSocketFrameReadState.CHUNK_READ);
          for (;;)
          {
            i = 1;
            break label44;
            label626:
            WebSocketImpl.access$1202(this$0, 0L);
            readInputBuffer();
            localWebSocketImpl = this$0;
            if (WebSocketImpl.access$300(localWebSocketImpl).position() < 2) {
              localObject = WebSocket.WebSocketFrameReadState.CHUNK_READ;
            } else {
              localObject = WebSocket.WebSocketFrameReadState.HEADER_READ;
            }
            WebSocketImpl.access$1102(localWebSocketImpl, (WebSocket.WebSocketFrameReadState)localObject);
            if (WebSocketImpl.access$1100(this$0) != WebSocket.WebSocketFrameReadState.CHUNK_READ) {
              break;
            }
          }
        }
        label691:
        WebSocketImpl.access$200(this$0).compact();
      }
    }
    else
    {
      WebSocketImpl.access$200(this$0).mark();
      if (WebSocketImpl.access$900(this$0).validateUpgradeReply(WebSocketImpl.access$200(this$0)).booleanValue())
      {
        WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
      }
      else
      {
        WebSocketImpl.access$200(this$0).reset();
        WebSocketImpl.access$1000().d("Websocket connecting response incomplete");
      }
      WebSocketImpl.access$200(this$0).compact();
    }
  }
  
  private void readInputBuffer()
  {
    c.a(WebSocketImpl.access$200(this$0), WebSocketImpl.access$300(this$0));
  }
  
  private boolean sendToUnderlyingInput()
  {
    int i = WebSocketImpl.access$400(this$0).ordinal();
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
              WebSocketImpl.access$500(this$0).flip();
              WebSocketImpl.access$700(this$0).put(WebSocketImpl.access$500(this$0));
              WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CONNECTED_CLOSING);
              WebSocketImpl.access$500(this$0).compact();
              WebSocketImpl.access$500(this$0).flip();
              break label322;
            }
          }
          else
          {
            WebSocketImpl.access$500(this$0).flip();
            WebSocketImpl.access$700(this$0).put(WebSocketImpl.access$500(this$0));
            WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CONNECTED_PONG);
            WebSocketImpl.access$500(this$0).compact();
            WebSocketImpl.access$500(this$0).flip();
            break label322;
          }
        }
        else
        {
          WebSocketImpl.access$500(this$0).flip();
          if (c.a(WebSocketImpl.access$500(this$0), underlyingInput) == -1) {
            WebSocketImpl.access$602(this$0, true);
          }
          WebSocketImpl.access$500(this$0).compact();
          WebSocketImpl.access$500(this$0).flip();
          break label322;
        }
      }
      else
      {
        WebSocketImpl.access$500(this$0).position(WebSocketImpl.access$500(this$0).limit());
        WebSocketImpl.access$500(this$0).limit(WebSocketImpl.access$500(this$0).capacity());
      }
    }
    else
    {
      WebSocketImpl.access$500(this$0).position(WebSocketImpl.access$500(this$0).limit());
      WebSocketImpl.access$500(this$0).limit(WebSocketImpl.access$500(this$0).capacity());
    }
    bool = false;
    label322:
    WebSocketImpl.access$500(this$0).position(WebSocketImpl.access$500(this$0).limit());
    WebSocketImpl.access$500(this$0).limit(WebSocketImpl.access$500(this$0).capacity());
    return bool;
  }
  
  public int capacity()
  {
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      if (WebSocketImpl.access$600(this$0)) {
        return -1;
      }
      return WebSocketImpl.access$200(this$0).remaining();
    }
    return underlyingInput.capacity();
  }
  
  public void close_head()
  {
    underlyingOutput.close_head();
  }
  
  public void close_tail()
  {
    WebSocketImpl.access$602(this$0, true);
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      WebSocketImpl.access$1402(this$0, true);
      underlyingInput.close_tail();
    }
    else
    {
      underlyingInput.close_tail();
    }
  }
  
  public ByteBuffer head()
  {
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      int i = WebSocketImpl.access$800(this$0).ordinal();
      if (i != 1) {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return underlyingOutput.head();
          }
        }
        else
        {
          WebSocketImpl.access$1502(this$0, underlyingOutput.pending());
          if (WebSocketImpl.access$1500(this$0) > 0)
          {
            this$0.wrapBuffer(underlyingOutput.head(), WebSocketImpl.access$100(this$0));
            WebSocketImpl localWebSocketImpl = this$0;
            WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$100(localWebSocketImpl).position() - WebSocketImpl.access$1500(this$0));
            head.limit(WebSocketImpl.access$100(this$0).position());
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
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      int i = WebSocketImpl.access$800(this$0).ordinal();
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
              WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CLOSED);
              this$0.writeClose();
              head.limit(WebSocketImpl.access$100(this$0).position());
              if (WebSocketImpl.access$1400(this$0))
              {
                WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_FAILED);
                return -1;
              }
              return WebSocketImpl.access$100(this$0).position();
            }
            WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CONNECTED_FLOW);
            this$0.writePong();
            head.limit(WebSocketImpl.access$100(this$0).position());
            if (WebSocketImpl.access$1400(this$0))
            {
              WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_FAILED);
              return -1;
            }
            return WebSocketImpl.access$100(this$0).position();
          }
          WebSocketImpl.access$1502(this$0, underlyingOutput.pending());
          if (WebSocketImpl.access$1500(this$0) > 0)
          {
            WebSocketImpl localWebSocketImpl = this$0;
            WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$900(localWebSocketImpl).calculateHeaderSize(WebSocketImpl.access$1500(this$0)));
            i = WebSocketImpl.access$1500(this$0);
            return WebSocketImpl.access$1600(this$0) + i;
          }
          return WebSocketImpl.access$1500(this$0);
        }
        if ((WebSocketImpl.access$1400(this$0)) && (WebSocketImpl.access$100(this$0).position() == 0))
        {
          WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_FAILED);
          return -1;
        }
        return WebSocketImpl.access$100(this$0).position();
      }
      if (WebSocketImpl.access$100(this$0).position() == 0)
      {
        WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_CONNECTING);
        this$0.writeUpgradeRequest();
        head.limit(WebSocketImpl.access$100(this$0).position());
        if (WebSocketImpl.access$1400(this$0))
        {
          WebSocketImpl.access$802(this$0, WebSocket.WebSocketState.PN_WS_FAILED);
          return -1;
        }
        return WebSocketImpl.access$100(this$0).position();
      }
      return WebSocketImpl.access$100(this$0).position();
    }
    return underlyingOutput.pending();
  }
  
  public void pop(int paramInt)
  {
    if (this$0.isWebSocketEnabled.booleanValue()) {
      switch (WebSocketImpl.access$800(this$0).ordinal())
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
        if ((paramInt >= WebSocketImpl.access$1600(this$0)) && (WebSocketImpl.access$100(this$0).position() != 0))
        {
          WebSocketImpl.access$100(this$0).flip();
          WebSocketImpl.access$100(this$0).position(paramInt);
          WebSocketImpl.access$100(this$0).compact();
          head.position(0);
          head.limit(WebSocketImpl.access$100(this$0).position());
          underlyingOutput.pop(paramInt - WebSocketImpl.access$1600(this$0));
          WebSocketImpl.access$1602(this$0, 0);
        }
        else if ((paramInt > 0) && (paramInt < WebSocketImpl.access$1600(this$0)))
        {
          WebSocketImpl localWebSocketImpl = this$0;
          WebSocketImpl.access$1602(localWebSocketImpl, WebSocketImpl.access$1600(localWebSocketImpl) - paramInt);
        }
        else
        {
          underlyingOutput.pop(paramInt);
        }
        break;
      case 1: 
        if (WebSocketImpl.access$100(this$0).position() != 0)
        {
          WebSocketImpl.access$100(this$0).flip();
          WebSocketImpl.access$100(this$0).position(paramInt);
          WebSocketImpl.access$100(this$0).compact();
          head.position(0);
          head.limit(WebSocketImpl.access$100(this$0).position());
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
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      if (WebSocketImpl.access$600(this$0)) {
        return -1;
      }
      return WebSocketImpl.access$200(this$0).position();
    }
    return underlyingInput.position();
  }
  
  public void process()
  {
    if (this$0.isWebSocketEnabled.booleanValue())
    {
      WebSocketImpl.access$200(this$0).flip();
      int i = WebSocketImpl.access$800(this$0).ordinal();
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
    if (this$0.isWebSocketEnabled.booleanValue()) {
      return WebSocketImpl.access$200(this$0);
    }
    return underlyingInput.tail();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.impl.WebSocketImpl.WebSocketTransportWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */