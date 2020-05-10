package com.microsoft.azure.proton.transport.ws;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface WebSocketHandler
{
  public abstract int calculateHeaderSize(int paramInt);
  
  public abstract void createPong(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public abstract String createUpgradeRequest(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Map<String, String> paramMap);
  
  public abstract WebSocketHandler.WebsocketTuple unwrapBuffer(ByteBuffer paramByteBuffer);
  
  public abstract Boolean validateUpgradeReply(ByteBuffer paramByteBuffer);
  
  public abstract void wrapBuffer(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.ws.WebSocketHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */