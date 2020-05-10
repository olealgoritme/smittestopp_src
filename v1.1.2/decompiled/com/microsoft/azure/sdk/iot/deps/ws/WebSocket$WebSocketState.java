package com.microsoft.azure.sdk.iot.deps.ws;

public enum WebSocket$WebSocketState
{
  static
  {
    PN_WS_CONNECTING = new WebSocketState("PN_WS_CONNECTING", 1);
    PN_WS_CONNECTED_FLOW = new WebSocketState("PN_WS_CONNECTED_FLOW", 2);
    PN_WS_CONNECTED_PONG = new WebSocketState("PN_WS_CONNECTED_PONG", 3);
    PN_WS_CONNECTED_CLOSING = new WebSocketState("PN_WS_CONNECTED_CLOSING", 4);
    PN_WS_CLOSED = new WebSocketState("PN_WS_CLOSED", 5);
    WebSocketState localWebSocketState = new WebSocketState("PN_WS_FAILED", 6);
    PN_WS_FAILED = localWebSocketState;
    $VALUES = new WebSocketState[] { PN_WS_NOT_STARTED, PN_WS_CONNECTING, PN_WS_CONNECTED_FLOW, PN_WS_CONNECTED_PONG, PN_WS_CONNECTED_CLOSING, PN_WS_CLOSED, localWebSocketState };
  }
  
  public WebSocket$WebSocketState() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.WebSocket.WebSocketState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */