package com.microsoft.azure.sdk.iot.deps.ws.impl;

import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebSocketMessageType;
import com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebsocketTuple;
import java.io.ByteArrayOutputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;

public class WebSocketHandlerImpl
  implements WebSocketHandler
{
  public WebSocketUpgrade _webSocketUpgrade = null;
  
  public int calculateHeaderSize(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt <= 125) {
        paramInt = 6;
      } else if (paramInt <= 65535) {
        paramInt = 8;
      } else {
        paramInt = 14;
      }
    }
    else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public void createPong(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if ((paramByteBuffer1 != null) && (paramByteBuffer2 != null))
    {
      if (paramByteBuffer1.capacity() <= paramByteBuffer2.capacity())
      {
        if (paramByteBuffer1.remaining() > 0)
        {
          paramByteBuffer1 = paramByteBuffer1.array();
          paramByteBuffer1[0] = ((byte)-118);
          paramByteBuffer2.clear();
          paramByteBuffer2.put(paramByteBuffer1);
        }
        else
        {
          paramByteBuffer2.clear();
          paramByteBuffer2.limit(0);
        }
        return;
      }
      throw new IllegalArgumentException("insufficient output buffer size");
    }
    throw new IllegalArgumentException("input parameter cannot be null");
  }
  
  public byte[] createRandomMaskingKey()
  {
    byte[] arrayOfByte = new byte[4];
    new SecureRandom().nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public String createUpgradeRequest(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    paramString1 = createWebSocketUpgrade(paramString1, paramString2, paramInt, paramString3, paramMap);
    _webSocketUpgrade = paramString1;
    return paramString1.createUpgradeRequest();
  }
  
  public WebSocketUpgrade createWebSocketUpgrade(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    return new WebSocketUpgrade(paramString1, paramString2, paramInt, paramString3, paramMap);
  }
  
  public WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer)
  {
    WebSocketHandler.WebsocketTuple localWebsocketTuple = new WebSocketHandler.WebsocketTuple(0L, WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN);
    if (paramByteBuffer != null)
    {
      WebSocketHandler.WebSocketMessageType localWebSocketMessageType1 = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN;
      if (paramByteBuffer.remaining() > 2)
      {
        int i = (byte)(paramByteBuffer.get() & 0xF);
        int j = (byte)(paramByteBuffer.get() & 0x7F);
        long l1 = -1L;
        long l2;
        WebSocketHandler.WebSocketMessageType localWebSocketMessageType2;
        if (j <= 125)
        {
          l2 = j;
          localWebSocketMessageType2 = localWebSocketMessageType1;
        }
        else if (j == 126)
        {
          try
          {
            j = paramByteBuffer.getShort();
            l2 = j & 0xFFFF;
            localWebSocketMessageType2 = localWebSocketMessageType1;
          }
          catch (BufferUnderflowException paramByteBuffer)
          {
            localWebSocketMessageType2 = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK;
            l2 = l1;
          }
        }
        else
        {
          localWebSocketMessageType2 = localWebSocketMessageType1;
          l2 = l1;
          if (j == 127) {
            try
            {
              l2 = paramByteBuffer.getLong();
              localWebSocketMessageType2 = localWebSocketMessageType1;
            }
            catch (BufferUnderflowException paramByteBuffer)
            {
              localWebSocketMessageType2 = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK;
              l2 = l1;
            }
          }
        }
        localWebSocketMessageType1 = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_UNKNOWN;
        paramByteBuffer = localWebSocketMessageType2;
        if (localWebSocketMessageType2 == localWebSocketMessageType1) {
          if (i == 2) {
            paramByteBuffer = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_AMQP;
          } else if (i == 9) {
            paramByteBuffer = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_PING;
          } else if (i == 8) {
            paramByteBuffer = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_CLOSE;
          } else if (i == 0) {
            paramByteBuffer = WebSocketHandler.WebSocketMessageType.WEB_SOCKET_MESSAGE_TYPE_CHUNK;
          } else {
            paramByteBuffer = localWebSocketMessageType1;
          }
        }
        localWebsocketTuple.setLength(l2);
        localWebsocketTuple.setType(paramByteBuffer);
      }
      return localWebsocketTuple;
    }
    throw new IllegalArgumentException("input parameter is null");
  }
  
  public Boolean validateUpgradeReply(ByteBuffer paramByteBuffer)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Object localObject = localBoolean;
    if (_webSocketUpgrade != null)
    {
      localObject = localBoolean;
      if (paramByteBuffer.remaining() > 0)
      {
        localObject = new byte[paramByteBuffer.remaining()];
        paramByteBuffer.get((byte[])localObject);
        localObject = _webSocketUpgrade.validateUpgradeReply((byte[])localObject);
        _webSocketUpgrade = null;
      }
    }
    return (Boolean)localObject;
  }
  
  public void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    if ((paramByteBuffer1 != null) && (paramByteBuffer2 != null))
    {
      if (paramByteBuffer1.remaining() > 0)
      {
        byte[] arrayOfByte = createRandomMaskingKey();
        int i = paramByteBuffer1.remaining();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i + 6);
        localByteArrayOutputStream.write(-126);
        if (i <= 125)
        {
          localByteArrayOutputStream.write((byte)(i | 0xFFFFFF80));
        }
        else if (i <= 65535)
        {
          localByteArrayOutputStream.write((byte)-2);
          localByteArrayOutputStream.write((byte)(i >>> 8));
          localByteArrayOutputStream.write((byte)i);
        }
        else
        {
          localByteArrayOutputStream.write((byte)-1);
          localByteArrayOutputStream.write((byte)(i >>> 56));
          localByteArrayOutputStream.write((byte)(i >>> 48));
          localByteArrayOutputStream.write((byte)(i >>> 40));
          localByteArrayOutputStream.write((byte)(i >>> 32));
          localByteArrayOutputStream.write((byte)(i >>> 24));
          localByteArrayOutputStream.write((byte)(i >>> 16));
          localByteArrayOutputStream.write((byte)(i >>> 8));
          localByteArrayOutputStream.write((byte)i);
        }
        int j = 0;
        localByteArrayOutputStream.write(arrayOfByte[0]);
        localByteArrayOutputStream.write(arrayOfByte[1]);
        localByteArrayOutputStream.write(arrayOfByte[2]);
        localByteArrayOutputStream.write(arrayOfByte[3]);
        while (j < i)
        {
          localByteArrayOutputStream.write((byte)(paramByteBuffer1.get() ^ arrayOfByte[(j % 4)]));
          j++;
        }
        paramByteBuffer2.clear();
        if (paramByteBuffer2.capacity() >= localByteArrayOutputStream.size()) {
          paramByteBuffer2.put(localByteArrayOutputStream.toByteArray());
        } else {
          throw new OutOfMemoryError("insufficient output buffer size");
        }
      }
      else
      {
        paramByteBuffer2.clear();
      }
      return;
    }
    throw new IllegalArgumentException("input parameter is null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketHandlerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */