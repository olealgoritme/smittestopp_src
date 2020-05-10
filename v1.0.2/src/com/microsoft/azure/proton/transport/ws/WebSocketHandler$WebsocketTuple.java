package com.microsoft.azure.proton.transport.ws;

public class WebSocketHandler$WebsocketTuple
{
  public long length;
  public WebSocketHandler.WebSocketMessageType type;
  
  public WebSocketHandler$WebsocketTuple(long paramLong, WebSocketHandler.WebSocketMessageType paramWebSocketMessageType)
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

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.WebSocketHandler.WebsocketTuple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */