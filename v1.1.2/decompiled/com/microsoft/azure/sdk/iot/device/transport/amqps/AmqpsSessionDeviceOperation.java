package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import l.a.b.a.d.n;
import l.a.b.a.d.y;
import l.a.b.a.f.a;
import l.f.b;
import l.f.c;

public class AmqpsSessionDeviceOperation
{
  public static final b log = c.a(AmqpsSessionDeviceOperation.class);
  public static long nextTag = 0L;
  public AmqpsDeviceAuthenticationState amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.UNKNOWN;
  public final AmqpsDeviceAuthentication amqpsDeviceAuthentication;
  public Map<MessageType, AmqpsDeviceOperations> amqpsDeviceOperationsMap = new HashMap();
  public List<UUID> cbsCorrelationIdList = Collections.synchronizedList(new ArrayList());
  public final DeviceClientConfig deviceClientConfig;
  public Integer openLock = new Integer(1);
  
  public AmqpsSessionDeviceOperation(DeviceClientConfig paramDeviceClientConfig, AmqpsDeviceAuthentication paramAmqpsDeviceAuthentication)
  {
    if (paramDeviceClientConfig != null)
    {
      if (paramAmqpsDeviceAuthentication != null)
      {
        deviceClientConfig = paramDeviceClientConfig;
        amqpsDeviceAuthentication = paramAmqpsDeviceAuthentication;
        amqpsDeviceOperationsMap.put(MessageType.DEVICE_TELEMETRY, new AmqpsDeviceTelemetry(deviceClientConfig));
        if (deviceClientConfig.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN) {
          amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.NOT_AUTHENTICATED;
        } else {
          amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.AUTHENTICATED;
        }
        return;
      }
      throw new IllegalArgumentException("amqpsDeviceAuthentication cannot be null.");
    }
    throw new IllegalArgumentException("deviceClientConfig cannot be null.");
  }
  
  private Integer sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    if (amqpsDeviceOperationsMap.get(paramMessageType) != null)
    {
      paramMessageType = ((AmqpsDeviceOperations)amqpsDeviceOperationsMap.get(paramMessageType)).sendMessageAndGetDeliveryTag(paramMessageType, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
      if (paramMessageType.isDeliverySuccessful()) {
        return Integer.valueOf(Integer.parseInt(new String(paramMessageType.getDeliveryTag())));
      }
    }
    return Integer.valueOf(-1);
  }
  
  public void authenticate()
  {
    if (deviceClientConfig.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN)
    {
      UUID localUUID = UUID.randomUUID();
      synchronized (cbsCorrelationIdList)
      {
        log.d("Adding correlation id to cbs correlation id list {}", localUUID);
        cbsCorrelationIdList.add(localUUID);
        amqpsDeviceAuthentication.authenticate(deviceClientConfig, localUUID);
        log.d("Setting amqps device authentication state to AUTHENTICATING");
        amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.AUTHENTICATING;
        log.d("Amqp session now waiting for service to acknowledge the sent authentication message");
      }
    }
  }
  
  public void close()
  {
    closeLinks();
    if (deviceClientConfig.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN)
    {
      amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.NOT_AUTHENTICATED;
      log.d("Setting amqps device authentication state to NOT_AUTHENTICATED");
    }
  }
  
  public void closeLinks()
  {
    Iterator localIterator = amqpsDeviceOperationsMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((AmqpsDeviceOperations)((Map.Entry)localIterator.next()).getValue()).closeLinks();
    }
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    if (amqpsDeviceOperationsMap.get(paramAmqpsMessage.getAmqpsMessageType()) != null) {
      paramAmqpsMessage = ((AmqpsDeviceOperations)amqpsDeviceOperationsMap.get(paramAmqpsMessage.getAmqpsMessageType())).convertFromProton(paramAmqpsMessage, paramDeviceClientConfig);
    } else {
      paramAmqpsMessage = null;
    }
    return paramAmqpsMessage;
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    MessageType localMessageType;
    if (paramMessage.getMessageType() == null) {
      localMessageType = MessageType.DEVICE_TELEMETRY;
    } else {
      localMessageType = paramMessage.getMessageType();
    }
    if (amqpsDeviceOperationsMap.get(localMessageType) != null) {
      return ((AmqpsDeviceOperations)amqpsDeviceOperationsMap.get(localMessageType)).convertToProton(paramMessage);
    }
    return null;
  }
  
  public String getDeviceId()
  {
    return deviceClientConfig.getDeviceId();
  }
  
  public int getExpectedWorkerLinkCount()
  {
    return amqpsDeviceOperationsMap.size() * 2;
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    Object localObject = null;
    try
    {
      Iterator localIterator = amqpsDeviceOperationsMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        AmqpsMessage localAmqpsMessage = ((AmqpsDeviceOperations)((Map.Entry)localIterator.next()).getValue()).getMessageFromReceiverLink(paramString);
        localObject = localAmqpsMessage;
        if (localAmqpsMessage != null) {
          localObject = localAmqpsMessage;
        }
      }
      return (AmqpsMessage)localObject;
    }
    finally {}
  }
  
  public boolean handleAuthenticationMessage(AmqpsMessage paramAmqpsMessage)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramAmqpsMessage != null)
    {
      List localList = cbsCorrelationIdList;
      Object localObject1 = null;
      try
      {
        Iterator localIterator = cbsCorrelationIdList.iterator();
        Object localObject2;
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (UUID)localIterator.next();
        } while (!amqpsDeviceAuthentication.handleAuthenticationMessage(paramAmqpsMessage, (UUID)localObject2));
        log.d("Setting amqps device authentication state to AUTHENTICATED");
        amqpsAuthenticatorState = AmqpsDeviceAuthenticationState.AUTHENTICATED;
        bool1 = bool2;
        if (localObject2 != null)
        {
          cbsCorrelationIdList.remove(localObject2);
          bool1 = true;
        }
      }
      finally {}
    }
    return bool1;
  }
  
  public void initLink(n paramn)
  {
    if ((paramn != null) && (amqpsAuthenticatorState == AmqpsDeviceAuthenticationState.AUTHENTICATED))
    {
      Iterator localIterator = amqpsDeviceOperationsMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((AmqpsDeviceOperations)((Map.Entry)localIterator.next()).getValue()).initLink(paramn);
      }
    }
  }
  
  public boolean onLinkRemoteClose(String paramString)
  {
    Iterator localIterator = amqpsDeviceOperationsMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((AmqpsDeviceOperations)((Map.Entry)localIterator.next()).getValue()).onLinkRemoteClose(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onLinkRemoteOpen(String paramString)
  {
    if (amqpsAuthenticatorState == AmqpsDeviceAuthenticationState.AUTHENTICATED)
    {
      Iterator localIterator = amqpsDeviceOperationsMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((AmqpsDeviceOperations)((Map.Entry)localIterator.next()).getValue()).onLinkRemoteOpen(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void openLinks(y paramy)
  {
    if ((paramy != null) && (amqpsAuthenticatorState == AmqpsDeviceAuthenticationState.AUTHENTICATED)) {
      synchronized (openLock)
      {
        Iterator localIterator = amqpsDeviceOperationsMap.values().iterator();
        while (localIterator.hasNext()) {
          ((AmqpsDeviceOperations)localIterator.next()).openLinks(paramy);
        }
      }
    }
  }
  
  public Integer sendMessage(a parama, MessageType paramMessageType, String paramString)
  {
    AmqpsDeviceAuthenticationState localAmqpsDeviceAuthenticationState1 = amqpsAuthenticatorState;
    AmqpsDeviceAuthenticationState localAmqpsDeviceAuthenticationState2 = AmqpsDeviceAuthenticationState.AUTHENTICATED;
    Integer localInteger = Integer.valueOf(-1);
    if (localAmqpsDeviceAuthenticationState1 == localAmqpsDeviceAuthenticationState2)
    {
      if (deviceClientConfig.getDeviceId().equals(paramString))
      {
        paramString = new byte['Ѐ'];
        for (;;)
        {
          try
          {
            int i = parama.encode(paramString, 0, paramString.length);
            parama = String.valueOf(nextTag).getBytes();
            long l = nextTag;
            if ((l != 2147483647L) && (l >= 0L)) {
              nextTag = l + 1L;
            } else {
              nextTag = 0L;
            }
            return sendMessageAndGetDeliveryTag(paramMessageType, paramString, 0, i, parama);
          }
          catch (BufferOverflowException localBufferOverflowException)
          {
            paramString = new byte[paramString.length * 2];
          }
        }
      }
      return localBufferOverflowException;
    }
    log.d("Attempted to send a message while state was not AUTHENTICATED, returning delivery tag of -1 ({})", parama);
    return localBufferOverflowException;
  }
  
  public void subscribeToMessageType(y paramy, MessageType paramMessageType)
  {
    if ((paramMessageType == MessageType.DEVICE_METHODS) && (!amqpsDeviceOperationsMap.keySet().contains(MessageType.DEVICE_METHODS)))
    {
      amqpsDeviceOperationsMap.put(MessageType.DEVICE_METHODS, new AmqpsDeviceMethods(deviceClientConfig));
      openLinks(paramy);
    }
    if ((paramMessageType == MessageType.DEVICE_TWIN) && (!amqpsDeviceOperationsMap.keySet().contains(MessageType.DEVICE_TWIN)))
    {
      amqpsDeviceOperationsMap.put(MessageType.DEVICE_TWIN, new AmqpsDeviceTwin(deviceClientConfig));
      openLinks(paramy);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsSessionDeviceOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */