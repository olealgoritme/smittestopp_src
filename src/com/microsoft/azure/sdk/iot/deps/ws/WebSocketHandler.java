package com.microsoft.azure.sdk.iot.deps.ws;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface WebSocketHandler
{
  public abstract int calculateHeaderSize(int paramInt);
  
  public abstract void createPong(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public abstract String createUpgradeRequest(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap);
  
  public abstract WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer);
  
  public abstract Boolean validateUpgradeReply(ByteBuffer paramByteBuffer);
  
  public abstract void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.ws.WebSocketHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */