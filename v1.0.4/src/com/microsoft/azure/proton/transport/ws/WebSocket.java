package com.microsoft.azure.proton.transport.ws;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface WebSocket
{
  public abstract void configure(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, String> paramMap, WebSocketHandler paramWebSocketHandler);
  
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
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.WebSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */