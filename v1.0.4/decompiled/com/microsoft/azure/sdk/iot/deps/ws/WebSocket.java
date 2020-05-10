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
  
  public abstract WebSocket.WebSocketState getState();
  
  public abstract WebSocketHandler getWebSocketHandler();
  
  public abstract ByteBuffer getWsInputBuffer();
  
  public abstract WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer);
  
  public abstract void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.ws.WebSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */