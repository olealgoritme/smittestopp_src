package com.microsoft.azure.sdk.iot.deps.ws;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface WebSocketHandler
{
  public abstract int calculateHeaderSize(int paramInt);
  
  public abstract void createPong(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public abstract String createUpgradeRequest(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap);
  
  public abstract WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer);
  
  public abstract Boolean validateUpgradeReply(ByteBuffer paramByteBuffer);
  
  public abstract void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public static enum WebSocketMessageType
  {
    static
    {
      WEB_SOCKET_MESSAGE_TYPE_CHUNK = new WebSocketMessageType("WEB_SOCKET_MESSAGE_TYPE_CHUNK", 1);
      WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK = new WebSocketMessageType("WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK", 2);
      WEB_SOCKET_MESSAGE_TYPE_AMQP = new WebSocketMessageType("WEB_SOCKET_MESSAGE_TYPE_AMQP", 3);
      WEB_SOCKET_MESSAGE_TYPE_PING = new WebSocketMessageType("WEB_SOCKET_MESSAGE_TYPE_PING", 4);
      WebSocketMessageType localWebSocketMessageType = new WebSocketMessageType("WEB_SOCKET_MESSAGE_TYPE_CLOSE", 5);
      WEB_SOCKET_MESSAGE_TYPE_CLOSE = localWebSocketMessageType;
      $VALUES = new WebSocketMessageType[] { WEB_SOCKET_MESSAGE_TYPE_UNKNOWN, WEB_SOCKET_MESSAGE_TYPE_CHUNK, WEB_SOCKET_MESSAGE_TYPE_HEADER_CHUNK, WEB_SOCKET_MESSAGE_TYPE_AMQP, WEB_SOCKET_MESSAGE_TYPE_PING, localWebSocketMessageType };
    }
    
    public WebSocketMessageType() {}
  }
  
  public static class WebsocketTuple
  {
    public long length;
    public WebSocketHandler.WebSocketMessageType type;
    
    public WebsocketTuple(long paramLong, WebSocketHandler.WebSocketMessageType paramWebSocketMessageType)
    {
      length = paramLong;
      type = paramWebSocketMessageType;
    }
    
    public long getLength()
    {
      return length;
    }
    
    public WebSocketHandler.WebSocketMessageType getType()
    {
      return type;
    }
    
    public void setLength(long paramLong)
    {
      length = paramLong;
    }
    
    public void setType(WebSocketHandler.WebSocketMessageType paramWebSocketMessageType)
    {
      type = paramWebSocketMessageType;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */