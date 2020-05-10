package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;

public final class IotHubTransportPacket
{
  public Object callbackContext;
  public int currentRetryAttempt;
  public IotHubEventCallback eventCallback;
  public Message message;
  public final long startTimeMillis;
  public IotHubStatusCode status;
  
  public IotHubTransportPacket(Message paramMessage, IotHubEventCallback paramIotHubEventCallback, Object paramObject, IotHubStatusCode paramIotHubStatusCode, long paramLong)
  {
    if (paramLong >= 1L)
    {
      if (paramMessage != null)
      {
        message = paramMessage;
        eventCallback = paramIotHubEventCallback;
        callbackContext = paramObject;
        status = paramIotHubStatusCode;
        startTimeMillis = paramLong;
        return;
      }
      throw new IllegalArgumentException("Message cannot be null");
    }
    throw new IllegalArgumentException("start time cannot be 0 or negative");
  }
  
  public IotHubEventCallback getCallback()
  {
    return eventCallback;
  }
  
  public Object getContext()
  {
    return callbackContext;
  }
  
  public int getCurrentRetryAttempt()
  {
    return currentRetryAttempt;
  }
  
  public Message getMessage()
  {
    return message;
  }
  
  public long getStartTimeMillis()
  {
    return startTimeMillis;
  }
  
  public IotHubStatusCode getStatus()
  {
    return status;
  }
  
  public void incrementRetryAttempt()
  {
    currentRetryAttempt += 1;
  }
  
  public void setStatus(IotHubStatusCode paramIotHubStatusCode)
  {
    status = paramIotHubStatusCode;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.IotHubTransportPacket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */