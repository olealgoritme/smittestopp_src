package com.microsoft.azure.sdk.iot.deps.ws;

public enum WebSocketHandler$WebSocketMessageType
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
  
  public WebSocketHandler$WebSocketMessageType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler.WebSocketMessageType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */