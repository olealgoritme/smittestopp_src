package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import com.microsoft.azure.sdk.iot.device.MessageType;
import com.microsoft.azure.sdk.iot.device.ProductInfo;
import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import k.a.b.a.b.k.d;
import k.a.b.a.b.k.u;
import k.a.b.a.b.k.v;
import k.a.b.a.b.k.w;
import k.a.b.a.b.n.q;
import k.a.b.a.b.n.r;
import k.a.b.a.d.t;
import k.a.b.a.d.x;
import k.a.b.a.d.y;
import k.f.b;
import k.f.c;

public abstract class AmqpsDeviceOperations
{
  public static final String AMQPS_APP_PROPERTY_PREFIX = "iothub-app-";
  public static final String API_VERSION_KEY = "com.microsoft:api-version";
  public static final String INPUT_NAME_PROPERTY_KEY = "x-opt-input-name";
  public static final String TO_KEY = "to";
  public static final String USER_ID_KEY = "userId";
  public static final String VERSION_IDENTIFIER_KEY = "com.microsoft:client-version";
  public static final b log = c.a(AmqpsDeviceOperations.class);
  public Map<k.a.b.a.b.f, Object> amqpProperties;
  public AmqpsDeviceOperationLinkState amqpsRecvLinkState;
  public AmqpsDeviceOperationLinkState amqpsSendLinkState;
  public String linkCorrelationId;
  public t receiverLink;
  public String receiverLinkAddress;
  public String receiverLinkEndpointPath;
  public String receiverLinkTag;
  public x senderLink;
  public String senderLinkAddress;
  public String senderLinkEndpointPath;
  public String senderLinkTag;
  
  public AmqpsDeviceOperations(DeviceClientConfig paramDeviceClientConfig, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject = AmqpsDeviceOperationLinkState.UNKNOWN;
    amqpsSendLinkState = ((AmqpsDeviceOperationLinkState)localObject);
    amqpsRecvLinkState = ((AmqpsDeviceOperationLinkState)localObject);
    if (paramDeviceClientConfig != null)
    {
      localObject = new HashMap();
      amqpProperties = ((Map)localObject);
      ((Map)localObject).put(k.a.b.a.b.f.a("com.microsoft:client-version"), paramDeviceClientConfig.getProductInfo().getUserAgentString());
      linkCorrelationId = UUID.randomUUID().toString();
      senderLink = null;
      receiverLink = null;
      localObject = AmqpsDeviceOperationLinkState.CLOSED;
      amqpsSendLinkState = ((AmqpsDeviceOperationLinkState)localObject);
      amqpsRecvLinkState = ((AmqpsDeviceOperationLinkState)localObject);
      localObject = paramDeviceClientConfig.getModuleId();
      paramDeviceClientConfig = paramDeviceClientConfig.getDeviceId();
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        senderLinkEndpointPath = paramString3;
        receiverLinkEndpointPath = paramString4;
        paramString1 = new StringBuilder();
        paramString1.append(paramString5);
        paramString1.append(paramDeviceClientConfig);
        paramString1.append("/");
        paramString1.append((String)localObject);
        paramString1.append("-");
        paramString1.append(linkCorrelationId);
        senderLinkTag = paramString1.toString();
        paramString1 = new StringBuilder();
        paramString1.append(paramString6);
        paramString1.append(paramDeviceClientConfig);
        paramString1.append("/");
        paramString1.append((String)localObject);
        paramString1.append("-");
        paramString1.append(linkCorrelationId);
        receiverLinkTag = paramString1.toString();
        senderLinkAddress = String.format(senderLinkEndpointPath, new Object[] { paramDeviceClientConfig, localObject });
        receiverLinkAddress = String.format(receiverLinkEndpointPath, new Object[] { paramDeviceClientConfig, localObject });
      }
      else
      {
        senderLinkEndpointPath = paramString1;
        receiverLinkEndpointPath = paramString2;
        paramString1 = new StringBuilder();
        paramString1.append(paramString5);
        paramString1.append(paramDeviceClientConfig);
        paramString1.append("-");
        paramString1.append(linkCorrelationId);
        senderLinkTag = paramString1.toString();
        paramString1 = new StringBuilder();
        paramString1.append(paramString6);
        paramString1.append(paramDeviceClientConfig);
        paramString1.append("-");
        paramString1.append(linkCorrelationId);
        receiverLinkTag = paramString1.toString();
        senderLinkAddress = String.format(senderLinkEndpointPath, new Object[] { paramDeviceClientConfig });
        receiverLinkAddress = String.format(receiverLinkEndpointPath, new Object[] { paramDeviceClientConfig });
      }
      return;
    }
    throw new IllegalArgumentException("device config cannot be null");
  }
  
  public void closeLinks()
  {
    Object localObject = senderLink;
    if (localObject != null)
    {
      ((k.a.b.a.d.f)localObject).close();
      senderLink = null;
      log.c("Closed {} sender link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
    }
    else
    {
      log.e("Sender link was already closed, so nothing was done to the link");
    }
    localObject = receiverLink;
    if (localObject != null)
    {
      ((k.a.b.a.d.f)localObject).close();
      receiverLink = null;
      log.c("Closed {} receiver link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
    }
    else
    {
      log.e("Receiver link was already closed, so nothing was done to the link");
    }
    localObject = AmqpsDeviceOperationLinkState.CLOSED;
    amqpsSendLinkState = ((AmqpsDeviceOperationLinkState)localObject);
    amqpsRecvLinkState = ((AmqpsDeviceOperationLinkState)localObject);
  }
  
  public abstract AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig);
  
  public abstract AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage);
  
  public Map<k.a.b.a.b.f, Object> getAmqpProperties()
  {
    return amqpProperties;
  }
  
  public abstract String getLinkInstanceType();
  
  public AmqpsMessage getMessageFromReceiverLink(String paramString)
  {
    if (!paramString.isEmpty())
    {
      if (paramString.equals(getReceiverLinkTag()))
      {
        paramString = receiverLink;
        if (paramString != null)
        {
          k.a.b.a.d.e locale = paramString.k();
          if ((locale != null) && (locale.t()) && (!locale.O()))
          {
            int i = locale.pending();
            byte[] arrayOfByte = new byte[i];
            int j = receiverLink.b(arrayOfByte, 0, i);
            log.e("read {} bytes from receiver link {}", Integer.valueOf(j), receiverLinkTag);
            if (!receiverLink.d()) {
              log.b("{} receiver link with link correlation id {} did not advance after bytes were read from it", getLinkInstanceType(), linkCorrelationId);
            }
            if (i != j) {
              log.c("Amqp read from {} receiver link with link correlation id {} did not read the expected amount of bytes. Read {} but expected {}", new Object[] { getLinkInstanceType(), linkCorrelationId, Integer.valueOf(j), Integer.valueOf(i) });
            }
            paramString = new AmqpsMessage();
            paramString.setDelivery(locale);
            paramString.decode(arrayOfByte, 0, j);
            return paramString;
          }
        }
      }
      return null;
    }
    throw new IllegalArgumentException("The linkName cannot be empty.");
  }
  
  public String getReceiverLinkAddress()
  {
    return receiverLinkAddress;
  }
  
  public String getReceiverLinkTag()
  {
    return receiverLinkTag;
  }
  
  public String getSenderLinkAddress()
  {
    return senderLinkAddress;
  }
  
  public String getSenderLinkTag()
  {
    return senderLinkTag;
  }
  
  public void initLink(k.a.b.a.d.n paramn)
  {
    if (paramn != null) {
      try
      {
        Object localObject = paramn.getName();
        if ((((String)localObject).equals(getSenderLinkTag())) && (amqpsSendLinkState == AmqpsDeviceOperationLinkState.OPENING))
        {
          localObject = new k/a/b/a/b/k/v;
          ((v)localObject).<init>();
          a = getSenderLinkAddress();
          paramn.a((r)localObject);
          paramn.a(k.a.b.a.b.n.p.UNSETTLED);
          log.d("Initializing sender link with correlation id {}", linkCorrelationId);
        }
        else if ((((String)localObject).equals(getReceiverLinkTag())) && (amqpsRecvLinkState == AmqpsDeviceOperationLinkState.OPENING))
        {
          localObject = new k/a/b/a/b/k/u;
          ((u)localObject).<init>();
          a = getReceiverLinkAddress();
          paramn.a((q)localObject);
          paramn.a(k.a.b.a.b.n.n.FIRST);
          log.d("Initializing receiver link with correlation id {}", linkCorrelationId);
        }
        else
        {
          log.d("InitLink called, but no link names matched {} or the link was not opening yet", localObject);
        }
        return;
      }
      finally
      {
        break label187;
      }
    }
    paramn = new java/lang/IllegalArgumentException;
    paramn.<init>("The link cannot be null.");
    throw paramn;
    label187:
    throw paramn;
  }
  
  public k.a.b.a.f.d.a iotHubMessageToProtonMessage(Message paramMessage)
  {
    Object localObject1 = log;
    Object localObject2 = getLinkInstanceType();
    int i = 0;
    ((b)localObject1).b("Converting IoT Hub message to proton message for {} sender link with link correlation id {}. IoT Hub message correlationId {}", new Object[] { localObject2, linkCorrelationId, paramMessage.getCorrelationId() });
    localObject1 = new k.a.b.a.f.d.a();
    localObject2 = new k.a.b.a.b.k.p();
    if (paramMessage.getMessageId() != null) {
      a = paramMessage.getMessageId();
    }
    if (paramMessage.getCorrelationId() != null) {
      f = paramMessage.getCorrelationId();
    }
    if (paramMessage.getContentType() != null) {
      g = k.a.b.a.b.f.a(paramMessage.getContentType());
    }
    if (paramMessage.getContentEncoding() != null) {
      h = k.a.b.a.b.f.a(paramMessage.getContentEncoding());
    }
    ((k.a.b.a.f.d.a)localObject1).setProperties((k.a.b.a.b.k.p)localObject2);
    HashMap localHashMap = new HashMap();
    if (paramMessage.getProperties().length > 0)
    {
      localObject2 = paramMessage.getProperties();
      int j = localObject2.length;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if (!MessageProperty.RESERVED_PROPERTY_NAMES.contains(((MessageProperty)localObject3).getName())) {
          localHashMap.put(((MessageProperty)localObject3).getName(), ((MessageProperty)localObject3).getValue());
        }
        i++;
      }
    }
    if (paramMessage.getConnectionDeviceId() != null) {
      localHashMap.put("iothub-connection-device-id", paramMessage.getConnectionDeviceId());
    }
    if (paramMessage.getConnectionModuleId() != null) {
      localHashMap.put("iothub-connection-module-id", paramMessage.getConnectionModuleId());
    }
    if (paramMessage.getCreationTimeUTC() != null) {
      localHashMap.put("iothub-creation-time-utc", paramMessage.getCreationTimeUTCString());
    }
    if (paramMessage.isSecurityMessage()) {
      localHashMap.put("iothub-interface-id", "urn:azureiot:Security:SecurityAgent:1");
    }
    ((k.a.b.a.f.d.a)localObject1).setApplicationProperties(new d(localHashMap));
    ((k.a.b.a.f.d.a)localObject1).setBody(new k.a.b.a.b.k.e(new k.a.b.a.b.a(paramMessage.getBytes())));
    return (k.a.b.a.f.d.a)localObject1;
  }
  
  public boolean onLinkRemoteClose(String paramString)
  {
    if (paramString.equals(getSenderLinkTag()))
    {
      amqpsSendLinkState = AmqpsDeviceOperationLinkState.CLOSED;
      log.c("{} sender link with link correlation id {} was closed", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    if (paramString.equals(getReceiverLinkTag()))
    {
      amqpsRecvLinkState = AmqpsDeviceOperationLinkState.CLOSED;
      log.c("{} receiver link with link correlation id {} was closed", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    return false;
  }
  
  public boolean onLinkRemoteOpen(String paramString)
  {
    if (paramString.equals(getSenderLinkTag()))
    {
      amqpsSendLinkState = AmqpsDeviceOperationLinkState.OPENED;
      log.c("{} sender link with link correlation id {} was successfully opened {}", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    if (paramString.equals(getReceiverLinkTag()))
    {
      amqpsRecvLinkState = AmqpsDeviceOperationLinkState.OPENED;
      log.c("{} receiver link with link correlation id {} was successfully opened", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    return false;
  }
  
  public void openLinks(y paramy)
  {
    if (paramy != null) {
      try
      {
        Object localObject;
        if ((senderLink == null) && (amqpsSendLinkState == AmqpsDeviceOperationLinkState.CLOSED))
        {
          localObject = paramy.a(getSenderLinkTag());
          senderLink = ((x)localObject);
          ((k.a.b.a.d.n)localObject).a(getAmqpProperties());
          v localv = new k/a/b/a/b/k/v;
          localv.<init>();
          localObject = new k/a/b/a/b/k/u;
          ((u)localObject).<init>();
          a = getSenderLinkAddress();
          a = getReceiverLinkAddress();
          senderLink.a(localv);
          senderLink.a((q)localObject);
          amqpsSendLinkState = AmqpsDeviceOperationLinkState.OPENING;
          senderLink.open();
          log.c("Opening {} sender link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
        }
        if ((receiverLink == null) && (amqpsRecvLinkState == AmqpsDeviceOperationLinkState.CLOSED))
        {
          paramy = paramy.b(getReceiverLinkTag());
          receiverLink = paramy;
          paramy.a(getAmqpProperties());
          localObject = new k/a/b/a/b/k/v;
          ((v)localObject).<init>();
          paramy = new k/a/b/a/b/k/u;
          paramy.<init>();
          a = getSenderLinkAddress();
          a = getReceiverLinkAddress();
          receiverLink.a((r)localObject);
          receiverLink.a(paramy);
          amqpsRecvLinkState = AmqpsDeviceOperationLinkState.OPENING;
          receiverLink.open();
          log.c("Opening {} receiver link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
        }
        return;
      }
      finally
      {
        break label286;
      }
    }
    paramy = new java/lang/IllegalArgumentException;
    paramy.<init>("The session cannot be null.");
    throw paramy;
    label286:
    throw paramy;
  }
  
  public boolean operationLinksOpened()
  {
    AmqpsDeviceOperationLinkState localAmqpsDeviceOperationLinkState1 = amqpsSendLinkState;
    AmqpsDeviceOperationLinkState localAmqpsDeviceOperationLinkState2 = AmqpsDeviceOperationLinkState.OPENED;
    boolean bool;
    if ((localAmqpsDeviceOperationLinkState1 == localAmqpsDeviceOperationLinkState2) && (amqpsRecvLinkState == localAmqpsDeviceOperationLinkState2)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public IotHubTransportMessage protonMessageToIoTHubMessage(k.a.b.a.f.d.a parama)
  {
    log.b("Converting proton message to iot hub message for {} receiver link with link correlation id {}. Proton message correlation id {}", new Object[] { getLinkInstanceType(), linkCorrelationId, parama.getCorrelationId() });
    Object localObject1 = (k.a.b.a.b.k.e)parama.getBody();
    if (localObject1 != null)
    {
      localObject2 = a;
      localObject1 = new byte[c];
      ((k.a.b.a.b.a)localObject2).a().get((byte[])localObject1);
    }
    else
    {
      localObject1 = new byte[0];
    }
    localObject1 = new IotHubTransportMessage((byte[])localObject1, MessageType.UNKNOWN);
    Object localObject2 = parama.getProperties();
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = f;
      if (localObject3 != null) {
        ((Message)localObject1).setCorrelationId(localObject3.toString());
      }
      localObject3 = a;
      if (localObject3 != null) {
        ((Message)localObject1).setMessageId(localObject3.toString());
      }
      localObject3 = c;
      if (localObject3 != null) {
        ((Message)localObject1).setProperty("iothub-app-to", (String)localObject3);
      }
      localObject3 = b;
      if (localObject3 != null) {
        ((Message)localObject1).setProperty("iothub-app-userId", ((k.a.b.a.b.a)localObject3).toString());
      }
      localObject3 = h;
      if (localObject3 != null) {
        ((Message)localObject1).setContentEncoding(x);
      }
      localObject2 = g;
      if (localObject2 != null) {
        ((Message)localObject1).setContentType(x);
      }
    }
    if (parama.getApplicationProperties() != null)
    {
      parama = getApplicationPropertiesa.entrySet().iterator();
      while (parama.hasNext())
      {
        localObject2 = (Map.Entry)parama.next();
        localObject3 = (String)((Map.Entry)localObject2).getKey();
        if (((String)localObject3).equalsIgnoreCase("iothub-connection-device-id")) {
          ((Message)localObject1).setConnectionDeviceId(((Map.Entry)localObject2).getValue().toString());
        } else if (((String)localObject3).equalsIgnoreCase("iothub-connection-module-id")) {
          ((Message)localObject1).setConnectionModuleId(((Map.Entry)localObject2).getValue().toString());
        } else if (!MessageProperty.RESERVED_PROPERTY_NAMES.contains(localObject3)) {
          ((Message)localObject1).setProperty((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
        }
      }
    }
    return (IotHubTransportMessage)localObject1;
  }
  
  public AmqpsSendReturnValue sendMessageAndGetDeliveryTag(MessageType paramMessageType, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      if (senderLink != null)
      {
        if (paramArrayOfByte2.length != 0)
        {
          paramMessageType = senderLink.a(paramArrayOfByte2);
          try
          {
            log.b("Sending {} bytes over the amqp {} sender link with link correlation id {}", new Object[] { Integer.valueOf(paramInt2), getLinkInstanceType(), linkCorrelationId });
            paramInt1 = senderLink.a(paramArrayOfByte1, paramInt1, paramInt2);
            log.b("{} bytes sent over the amqp {} sender link with link correlation id {}", new Object[] { Integer.valueOf(paramInt1), getLinkInstanceType(), linkCorrelationId });
            if (paramInt1 == paramInt2)
            {
              if (senderLink.d())
              {
                b localb = log;
                String str = getLinkInstanceType();
                paramArrayOfByte1 = new java/lang/String;
                paramArrayOfByte1.<init>(paramArrayOfByte2);
                localb.b("Message was sent over {} sender link with delivery tag {} and hash {}", new Object[] { str, paramArrayOfByte1, Integer.valueOf(paramMessageType.hashCode()) });
                paramArrayOfByte1 = new AmqpsSendReturnValue(true, paramMessageType.hashCode(), paramArrayOfByte2);
                return paramArrayOfByte1;
              }
              paramArrayOfByte1 = new com/microsoft/azure/sdk/iot/device/exceptions/ProtocolException;
              paramArrayOfByte1.<init>(String.format("Failed to advance the senderLink after sending a message on %s sender link with link correlation id %s, retrying to send the message", new Object[] { getLinkInstanceType(), linkCorrelationId }));
              throw paramArrayOfByte1;
            }
            paramArrayOfByte1 = new com/microsoft/azure/sdk/iot/device/exceptions/ProtocolException;
            paramArrayOfByte1.<init>(String.format("Amqp send operation did not send all of the expected bytes for %s sender link with link correlation id %s, retrying to send the message", new Object[] { getLinkInstanceType(), linkCorrelationId }));
            throw paramArrayOfByte1;
          }
          catch (Exception paramArrayOfByte1)
          {
            log.c("Encountered a problem while sending a message on {} sender link with link correlation id {}", new Object[] { getLinkInstanceType(), linkCorrelationId, paramArrayOfByte1 });
            senderLink.d();
            paramMessageType.a();
            paramMessageType = new AmqpsSendReturnValue(false, -1);
            return paramMessageType;
          }
        }
        paramMessageType = new java/lang/IllegalArgumentException;
        paramMessageType.<init>("Trying deliveryTag cannot be null.");
        throw paramMessageType;
      }
      paramMessageType = new java/lang/IllegalStateException;
      paramMessageType.<init>("Trying to send but Sender link is not initialized.");
      throw paramMessageType;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */