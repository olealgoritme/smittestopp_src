package com.microsoft.azure.proton.transport.ws;

public enum WebSocket$WebSocketFrameReadState
{
  static
  {
    CHUNK_READ = new WebSocketFrameReadState("CHUNK_READ", 1);
    CONTINUED_FRAME_READ = new WebSocketFrameReadState("CONTINUED_FRAME_READ", 2);
    HEADER_READ = new WebSocketFrameReadState("HEADER_READ", 3);
    WebSocketFrameReadState localWebSocketFrameReadState = new WebSocketFrameReadState("READ_ERROR", 4);
    READ_ERROR = localWebSocketFrameReadState;
    $VALUES = new WebSocketFrameReadState[] { INIT_READ, CHUNK_READ, CONTINUED_FRAME_READ, HEADER_READ, localWebSocketFrameReadState };
  }
  
  public WebSocket$WebSocketFrameReadState() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.WebSocket.WebSocketFrameReadState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */