package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.DeviceClientConfig.AuthType;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageType;
import java.util.ArrayList;
import java.util.Iterator;
import l.a.b.a.d.c0;
import l.a.b.a.d.f;
import l.a.b.a.d.n;
import l.a.b.a.d.y;
import l.a.b.a.f.a;
import l.f.b;

public class AmqpsSessionManager
{
  public static final b log = l.f.c.a(AmqpsSessionManager.class);
  public AmqpsDeviceAuthentication amqpsDeviceAuthentication;
  public ArrayList<AmqpsSessionDeviceOperation> amqpsDeviceSessionList = new ArrayList();
  public final DeviceClientConfig deviceClientConfig;
  public y session = null;
  
  public AmqpsSessionManager(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      deviceClientConfig = paramDeviceClientConfig;
      int i = paramDeviceClientConfig.getAuthenticationType().ordinal();
      if (i != 0)
      {
        if (i == 1) {
          amqpsDeviceAuthentication = new AmqpsDeviceAuthenticationCBS(deviceClientConfig);
        }
      }
      else {
        amqpsDeviceAuthentication = new AmqpsDeviceAuthenticationX509(deviceClientConfig);
      }
      addDeviceOperationSession(deviceClientConfig);
      return;
    }
    throw new IllegalArgumentException("deviceClientConfig cannot be null.");
  }
  
  public final void addDeviceOperationSession(DeviceClientConfig paramDeviceClientConfig)
  {
    if (paramDeviceClientConfig != null)
    {
      paramDeviceClientConfig = new AmqpsSessionDeviceOperation(paramDeviceClientConfig, amqpsDeviceAuthentication);
      amqpsDeviceSessionList.add(paramDeviceClientConfig);
      return;
    }
    throw new IllegalArgumentException("deviceClientConfig cannot be null.");
  }
  
  public void authenticate()
  {
    if (deviceClientConfig.getAuthenticationType() == DeviceClientConfig.AuthType.SAS_TOKEN) {
      for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
        if (amqpsDeviceSessionList.get(i) != null) {
          ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).authenticate();
        }
      }
    }
  }
  
  public void closeNow()
  {
    log.e("Closing AMQP session");
    for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
      if (amqpsDeviceSessionList.get(i) != null) {
        ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).close();
      }
    }
    amqpsDeviceAuthentication.closeLinks();
    y localy = session;
    if (localy != null)
    {
      localy.close();
      session = null;
    }
  }
  
  public AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig)
  {
    AmqpsConvertFromProtonReturnValue localAmqpsConvertFromProtonReturnValue = null;
    for (int i = 0; i < amqpsDeviceSessionList.size(); i++)
    {
      localAmqpsConvertFromProtonReturnValue = ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).convertFromProton(paramAmqpsMessage, paramDeviceClientConfig);
      if (localAmqpsConvertFromProtonReturnValue != null) {
        break;
      }
    }
    return localAmqpsConvertFromProtonReturnValue;
  }
  
  public AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage)
  {
    AmqpsConvertToProtonReturnValue localAmqpsConvertToProtonReturnValue = null;
    for (int i = 0; i < amqpsDeviceSessionList.size(); i++)
    {
      localAmqpsConvertToProtonReturnValue = ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).convertToProton(paramMessage);
      if (localAmqpsConvertToProtonReturnValue != null) {
        break;
      }
    }
    return localAmqpsConvertToProtonReturnValue;
  }
  
  public int getExpectedWorkerLinkCount()
  {
    Iterator localIterator = amqpsDeviceSessionList.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((AmqpsSessionDeviceOperation)localIterator.next()).getExpectedWorkerLinkCount();
    }
    return i;
  }
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    y localy = session;
    Object localObject1 = null;
    Object localObject2 = null;
    if (localy != null)
    {
      boolean bool = paramString.startsWith("cbs-receiver-");
      int i = 0;
      int j = 0;
      if (!bool)
      {
        localObject1 = localObject2;
        if (!paramString.startsWith("cbs-sender-")) {
          while (j < amqpsDeviceSessionList.size())
          {
            localObject1 = ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(j)).getMessageFromReceiverLink(paramString);
            if (localObject1 != null) {
              break;
            }
            j++;
          }
        }
      }
      paramString = amqpsDeviceAuthentication.getMessageFromReceiverLink(paramString);
      for (j = i;; j++)
      {
        localObject1 = paramString;
        if (j >= amqpsDeviceSessionList.size()) {
          break;
        }
        if (((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(j)).handleAuthenticationMessage(paramString))
        {
          localObject1 = paramString;
          break;
        }
      }
    }
    return (AmqpsMessage)localObject1;
  }
  
  public boolean isAuthenticationOpened()
  {
    return amqpsDeviceAuthentication.operationLinksOpened();
  }
  
  public void onConnectionBound(c0 paramc0)
  {
    if (session != null) {
      amqpsDeviceAuthentication.setSslDomain(paramc0);
    }
  }
  
  public void onConnectionInit(l.a.b.a.d.c paramc)
  {
    if ((paramc != null) && (session == null))
    {
      session = paramc.q();
      log.d("Opening session...");
      session.open();
    }
  }
  
  public void onLinkInit(n paramn)
  {
    if (session != null)
    {
      if (isAuthenticationOpened()) {
        for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
          ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).initLink(paramn);
        }
      }
      amqpsDeviceAuthentication.initLink(paramn);
    }
  }
  
  public void onLinkRemoteClose(n paramn)
  {
    paramn = paramn.getName();
    for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
      if (((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).onLinkRemoteClose(paramn)) {
        return;
      }
    }
    if (amqpsDeviceAuthentication.onLinkRemoteClose(paramn)) {
      return;
    }
    log.c("onLinkRemoteClose could not be correlated with a local link, ignoring it");
  }
  
  public boolean onLinkRemoteOpen(n paramn)
  {
    paramn = paramn.getName();
    if (isAuthenticationOpened())
    {
      for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
        if (((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).onLinkRemoteOpen(paramn)) {
          return true;
        }
      }
      log.c("onLinkRemoteOpen could not be correlated with a local link, ignoring it");
      return false;
    }
    return amqpsDeviceAuthentication.onLinkRemoteOpen(paramn);
  }
  
  public void onSessionRemoteOpen(y paramy)
  {
    AmqpsDeviceAuthentication localAmqpsDeviceAuthentication = amqpsDeviceAuthentication;
    if ((localAmqpsDeviceAuthentication instanceof AmqpsDeviceAuthenticationCBS)) {
      localAmqpsDeviceAuthentication.openLinks(paramy);
    } else {
      openWorkerLinks();
    }
  }
  
  public void openWorkerLinks()
  {
    if (session != null) {
      for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
        if (amqpsDeviceSessionList.get(i) != null) {
          ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).openLinks(session);
        }
      }
    }
  }
  
  public Integer sendMessage(a parama, MessageType paramMessageType, String paramString)
  {
    Integer localInteger1 = Integer.valueOf(-1);
    Integer localInteger2 = localInteger1;
    if (session != null)
    {
      int i = 0;
      localInteger2 = localInteger1;
      while (i < amqpsDeviceSessionList.size())
      {
        localInteger2 = ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).sendMessage(parama, paramMessageType, paramString);
        if (localInteger2.intValue() != -1) {
          break;
        }
        i++;
      }
      log.d("Attempt to send message over amqp failed because no session handled it ({})", parama);
    }
    return localInteger2;
  }
  
  public void subscribeDeviceToMessageType(MessageType paramMessageType, String paramString)
  {
    log.d("Subscribing to {}", paramMessageType);
    if (session != null) {
      for (int i = 0; i < amqpsDeviceSessionList.size(); i++) {
        if (((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).getDeviceId().equals(paramString))
        {
          ((AmqpsSessionDeviceOperation)amqpsDeviceSessionList.get(i)).subscribeToMessageType(session, paramMessageType);
          return;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsSessionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */