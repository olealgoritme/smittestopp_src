package com.microsoft.azure.sdk.iot.deps.ws;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface WebSocket
{
  public abstract void configure(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, WebSocketHandler paramWebSocketHandler);
  
  public abstract Boolean getEnabled();
  
  public abstract ByteBuffer getInputBuffer();
  
  public abstract ByteBuffer getOutputBuffer();
  
  public abstract ByteBuffer getPingBuffer();
  
  public abstract WebSocketState getState();
  
  public abstract WebSocketHandler getWebSocketHandler();
  
  public abstract ByteBuffer getWsInputBuffer();
  
  public abstract WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer);
  
  public abstract void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public static enum WebSocketFrameReadState
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
    
    public WebSocketFrameReadState() {}
  }
  
  public static enum WebSocketState
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
    
    public WebSocketState() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.ws.WebSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */