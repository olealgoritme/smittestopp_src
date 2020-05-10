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
import l.a.b.a.b.k.d;
import l.a.b.a.b.k.u;
import l.a.b.a.b.k.v;
import l.a.b.a.b.k.w;
import l.a.b.a.b.n.q;
import l.a.b.a.b.n.r;
import l.a.b.a.d.t;
import l.a.b.a.d.x;
import l.a.b.a.d.y;
import l.f.b;
import l.f.c;

public abstract class AmqpsDeviceOperations
{
  public static final String AMQPS_APP_PROPERTY_PREFIX = "iothub-app-";
  public static final String API_VERSION_KEY = "com.microsoft:api-version";
  public static final String INPUT_NAME_PROPERTY_KEY = "x-opt-input-name";
  public static final String TO_KEY = "to";
  public static final String USER_ID_KEY = "userId";
  public static final String VERSION_IDENTIFIER_KEY = "com.microsoft:client-version";
  public static final b log = c.a(AmqpsDeviceOperations.class);
  public Map<l.a.b.a.b.f, Object> amqpProperties;
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
      ((Map)localObject).put(l.a.b.a.b.f.a("com.microsoft:client-version"), paramDeviceClientConfig.getProductInfo().getUserAgentString());
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
      ((l.a.b.a.d.f)localObject).close();
      senderLink = null;
      log.a("Closed {} sender link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
    }
    else
    {
      log.d("Sender link was already closed, so nothing was done to the link");
    }
    localObject = receiverLink;
    if (localObject != null)
    {
      ((l.a.b.a.d.f)localObject).close();
      receiverLink = null;
      log.a("Closed {} receiver link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
    }
    else
    {
      log.d("Receiver link was already closed, so nothing was done to the link");
    }
    localObject = AmqpsDeviceOperationLinkState.CLOSED;
    amqpsSendLinkState = ((AmqpsDeviceOperationLinkState)localObject);
    amqpsRecvLinkState = ((AmqpsDeviceOperationLinkState)localObject);
  }
  
  public abstract AmqpsConvertFromProtonReturnValue convertFromProton(AmqpsMessage paramAmqpsMessage, DeviceClientConfig paramDeviceClientConfig);
  
  public abstract AmqpsConvertToProtonReturnValue convertToProton(Message paramMessage);
  
  public Map<l.a.b.a.b.f, Object> getAmqpProperties()
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
          paramString = paramString.i();
          if ((paramString != null) && (paramString.D()) && (!paramString.P()))
          {
            int i = paramString.pending();
            byte[] arrayOfByte = new byte[i];
            int j = receiverLink.a(arrayOfByte, 0, i);
            log.b("read {} bytes from receiver link {}", Integer.valueOf(j), receiverLinkTag);
            if (!receiverLink.d()) {
              log.d("{} receiver link with link correlation id {} did not advance after bytes were read from it", getLinkInstanceType(), linkCorrelationId);
            }
            if (i != j) {
              log.b("Amqp read from {} receiver link with link correlation id {} did not read the expected amount of bytes. Read {} but expected {}", new Object[] { getLinkInstanceType(), linkCorrelationId, Integer.valueOf(j), Integer.valueOf(i) });
            }
            AmqpsMessage localAmqpsMessage = new AmqpsMessage();
            localAmqpsMessage.setDelivery(paramString);
            localAmqpsMessage.decode(arrayOfByte, 0, j);
            return localAmqpsMessage;
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
  
  public void initLink(l.a.b.a.d.n paramn)
  {
    if (paramn != null) {
      try
      {
        Object localObject = paramn.getName();
        if ((((String)localObject).equals(getSenderLinkTag())) && (amqpsSendLinkState == AmqpsDeviceOperationLinkState.OPENING))
        {
          localObject = new l/a/b/a/b/k/v;
          ((v)localObject).<init>();
          a = getSenderLinkAddress();
          paramn.a((r)localObject);
          paramn.a(l.a.b.a.b.n.p.UNSETTLED);
          log.d("Initializing sender link with correlation id {}", linkCorrelationId);
        }
        else if ((((String)localObject).equals(getReceiverLinkTag())) && (amqpsRecvLinkState == AmqpsDeviceOperationLinkState.OPENING))
        {
          localObject = new l/a/b/a/b/k/u;
          ((u)localObject).<init>();
          a = getReceiverLinkAddress();
          paramn.a((q)localObject);
          paramn.a(l.a.b.a.b.n.n.FIRST);
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
  
  public l.a.b.a.f.d.a iotHubMessageToProtonMessage(Message paramMessage)
  {
    Object localObject1 = log;
    Object localObject2 = getLinkInstanceType();
    int i = 0;
    ((b)localObject1).a("Converting IoT Hub message to proton message for {} sender link with link correlation id {}. IoT Hub message correlationId {}", new Object[] { localObject2, linkCorrelationId, paramMessage.getCorrelationId() });
    localObject2 = new l.a.b.a.f.d.a();
    localObject1 = new l.a.b.a.b.k.p();
    if (paramMessage.getMessageId() != null) {
      a = paramMessage.getMessageId();
    }
    if (paramMessage.getCorrelationId() != null) {
      f = paramMessage.getCorrelationId();
    }
    if (paramMessage.getContentType() != null) {
      g = l.a.b.a.b.f.a(paramMessage.getContentType());
    }
    if (paramMessage.getContentEncoding() != null) {
      h = l.a.b.a.b.f.a(paramMessage.getContentEncoding());
    }
    ((l.a.b.a.f.d.a)localObject2).setProperties((l.a.b.a.b.k.p)localObject1);
    localObject1 = new HashMap();
    if (paramMessage.getProperties().length > 0)
    {
      MessageProperty[] arrayOfMessageProperty = paramMessage.getProperties();
      int j = arrayOfMessageProperty.length;
      while (i < j)
      {
        MessageProperty localMessageProperty = arrayOfMessageProperty[i];
        if (!MessageProperty.RESERVED_PROPERTY_NAMES.contains(localMessageProperty.getName())) {
          ((HashMap)localObject1).put(localMessageProperty.getName(), localMessageProperty.getValue());
        }
        i++;
      }
    }
    if (paramMessage.getConnectionDeviceId() != null) {
      ((HashMap)localObject1).put("iothub-connection-device-id", paramMessage.getConnectionDeviceId());
    }
    if (paramMessage.getConnectionModuleId() != null) {
      ((HashMap)localObject1).put("iothub-connection-module-id", paramMessage.getConnectionModuleId());
    }
    if (paramMessage.getCreationTimeUTC() != null) {
      ((HashMap)localObject1).put("iothub-creation-time-utc", paramMessage.getCreationTimeUTCString());
    }
    if (paramMessage.isSecurityMessage()) {
      ((HashMap)localObject1).put("iothub-interface-id", "urn:azureiot:Security:SecurityAgent:1");
    }
    ((l.a.b.a.f.d.a)localObject2).setApplicationProperties(new d((Map)localObject1));
    ((l.a.b.a.f.d.a)localObject2).setBody(new l.a.b.a.b.k.e(new l.a.b.a.b.a(paramMessage.getBytes())));
    return (l.a.b.a.f.d.a)localObject2;
  }
  
  public boolean onLinkRemoteClose(String paramString)
  {
    if (paramString.equals(getSenderLinkTag()))
    {
      amqpsSendLinkState = AmqpsDeviceOperationLinkState.CLOSED;
      log.a("{} sender link with link correlation id {} was closed", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    if (paramString.equals(getReceiverLinkTag()))
    {
      amqpsRecvLinkState = AmqpsDeviceOperationLinkState.CLOSED;
      log.a("{} receiver link with link correlation id {} was closed", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    return false;
  }
  
  public boolean onLinkRemoteOpen(String paramString)
  {
    if (paramString.equals(getSenderLinkTag()))
    {
      amqpsSendLinkState = AmqpsDeviceOperationLinkState.OPENED;
      log.a("{} sender link with link correlation id {} was successfully opened {}", getLinkInstanceType(), linkCorrelationId);
      return true;
    }
    if (paramString.equals(getReceiverLinkTag()))
    {
      amqpsRecvLinkState = AmqpsDeviceOperationLinkState.OPENED;
      log.a("{} receiver link with link correlation id {} was successfully opened", getLinkInstanceType(), linkCorrelationId);
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
          localObject = paramy.b(getSenderLinkTag());
          senderLink = ((x)localObject);
          ((l.a.b.a.d.n)localObject).a(getAmqpProperties());
          localObject = new l/a/b/a/b/k/v;
          ((v)localObject).<init>();
          u localu = new l/a/b/a/b/k/u;
          localu.<init>();
          a = getSenderLinkAddress();
          a = getReceiverLinkAddress();
          senderLink.a((r)localObject);
          senderLink.a(localu);
          amqpsSendLinkState = AmqpsDeviceOperationLinkState.OPENING;
          senderLink.open();
          log.a("Opening {} sender link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
        }
        if ((receiverLink == null) && (amqpsRecvLinkState == AmqpsDeviceOperationLinkState.CLOSED))
        {
          paramy = paramy.c(getReceiverLinkTag());
          receiverLink = paramy;
          paramy.a(getAmqpProperties());
          paramy = new l/a/b/a/b/k/v;
          paramy.<init>();
          localObject = new l/a/b/a/b/k/u;
          ((u)localObject).<init>();
          a = getSenderLinkAddress();
          a = getReceiverLinkAddress();
          receiverLink.a(paramy);
          receiverLink.a((q)localObject);
          amqpsRecvLinkState = AmqpsDeviceOperationLinkState.OPENING;
          receiverLink.open();
          log.a("Opening {} receiver link with link correlation id {}", getLinkInstanceType(), linkCorrelationId);
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
  
  public IotHubTransportMessage protonMessageToIoTHubMessage(l.a.b.a.f.d.a parama)
  {
    log.a("Converting proton message to iot hub message for {} receiver link with link correlation id {}. Proton message correlation id {}", new Object[] { getLinkInstanceType(), linkCorrelationId, parama.getCorrelationId() });
    Object localObject1 = (l.a.b.a.b.k.e)parama.getBody();
    if (localObject1 != null)
    {
      localObject2 = a;
      localObject1 = new byte[c];
      ((l.a.b.a.b.a)localObject2).a().get((byte[])localObject1);
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
        ((Message)localObject1).setProperty("iothub-app-userId", ((l.a.b.a.b.a)localObject3).toString());
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
      localObject3 = getApplicationPropertiesa.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        parama = (Map.Entry)((Iterator)localObject3).next();
        localObject2 = (String)parama.getKey();
        if (((String)localObject2).equalsIgnoreCase("iothub-connection-device-id")) {
          ((Message)localObject1).setConnectionDeviceId(parama.getValue().toString());
        } else if (((String)localObject2).equalsIgnoreCase("iothub-connection-module-id")) {
          ((Message)localObject1).setConnectionModuleId(parama.getValue().toString());
        } else if (!MessageProperty.RESERVED_PROPERTY_NAMES.contains(localObject2)) {
          ((Message)localObject1).setProperty((String)parama.getKey(), parama.getValue().toString());
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
            log.a("Sending {} bytes over the amqp {} sender link with link correlation id {}", new Object[] { Integer.valueOf(paramInt2), getLinkInstanceType(), linkCorrelationId });
            paramInt1 = senderLink.b(paramArrayOfByte1, paramInt1, paramInt2);
            log.a("{} bytes sent over the amqp {} sender link with link correlation id {}", new Object[] { Integer.valueOf(paramInt1), getLinkInstanceType(), linkCorrelationId });
            if (paramInt1 == paramInt2)
            {
              if (senderLink.d())
              {
                paramArrayOfByte1 = log;
                String str1 = getLinkInstanceType();
                String str2 = new java/lang/String;
                str2.<init>(paramArrayOfByte2);
                paramArrayOfByte1.a("Message was sent over {} sender link with delivery tag {} and hash {}", new Object[] { str1, str2, Integer.valueOf(paramMessageType.hashCode()) });
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
            log.b("Encountered a problem while sending a message on {} sender link with link correlation id {}", new Object[] { getLinkInstanceType(), linkCorrelationId, paramArrayOfByte1 });
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
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceOperations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */