package com.microsoft.azure.sdk.iot.device;

import e.a.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import k.f.b;
import k.f.c;

public class Message
{
  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSSSSSS";
  public static final Charset DEFAULT_IOTHUB_MESSAGE_CHARSET = StandardCharsets.UTF_8;
  public static final String SECURITY_CLIENT_JSON_ENCODING = "application/json";
  public static final b log = c.a(Message.class);
  public FeedbackStatusCodeEnum ack;
  public byte[] body;
  public ByteArrayInputStream bodyStream;
  public String connectionAuthenticationMethod;
  public String connectionDeviceGenerationId;
  public String connectionDeviceId;
  public String connectionModuleId;
  public String contentEncoding;
  public String contentType;
  public String correlationId;
  public Date creationTimeUTC;
  public String deliveryAcknowledgement;
  public long expiryTime;
  public String feedbackDescription;
  public String feedbackDeviceGenerationId;
  public String feedbackDeviceId;
  public FeedbackStatusCodeEnum feedbackStatusCode;
  public StandardCharsets httpBatchEncoding;
  public Boolean httpBatchSerializeAsString;
  public String inputName;
  public IotHubConnectionString iotHubConnectionString;
  public boolean isSecurityClient;
  public String lockToken;
  public String messageId;
  public MessageType messageType;
  public String outputName;
  public ArrayList<MessageProperty> properties;
  public String to;
  public String userId;
  
  public Message()
  {
    initialize();
  }
  
  public Message(ByteArrayInputStream paramByteArrayInputStream)
  {
    initialize();
  }
  
  public Message(String paramString)
  {
    if (paramString != null)
    {
      initialize();
      body = paramString.getBytes(DEFAULT_IOTHUB_MESSAGE_CHARSET);
      setContentType(DEFAULT_IOTHUB_MESSAGE_CHARSET.name());
      return;
    }
    throw new IllegalArgumentException("Message body cannot be 'null'.");
  }
  
  public Message(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      initialize();
      body = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("Message body cannot be 'null'.");
  }
  
  private void initialize()
  {
    lockToken = UUID.randomUUID().toString();
    messageId = UUID.randomUUID().toString();
    correlationId = UUID.randomUUID().toString();
    FeedbackStatusCodeEnum localFeedbackStatusCodeEnum = FeedbackStatusCodeEnum.none;
    feedbackStatusCode = localFeedbackStatusCodeEnum;
    ack = localFeedbackStatusCodeEnum;
    properties = new ArrayList();
    isSecurityClient = false;
  }
  
  public ByteArrayOutputStream getBodyStream()
  {
    return null;
  }
  
  public byte[] getBytes()
  {
    byte[] arrayOfByte = body;
    if (arrayOfByte != null) {
      arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    } else {
      arrayOfByte = null;
    }
    return arrayOfByte;
  }
  
  public String getConnectionDeviceId()
  {
    return connectionDeviceId;
  }
  
  public String getConnectionModuleId()
  {
    return connectionModuleId;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public String getCorrelationId()
  {
    String str1 = correlationId;
    String str2 = str1;
    if (str1 == null) {
      str2 = "";
    }
    return str2;
  }
  
  public Date getCreationTimeUTC()
  {
    return creationTimeUTC;
  }
  
  public String getCreationTimeUTCString()
  {
    if (creationTimeUTC == null) {
      return null;
    }
    return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSSSSSS").format(creationTimeUTC).replace("_", "T");
  }
  
  public String getDeliveryAcknowledgement()
  {
    return deliveryAcknowledgement;
  }
  
  public String getInputName()
  {
    return inputName;
  }
  
  public IotHubConnectionString getIotHubConnectionString()
  {
    return iotHubConnectionString;
  }
  
  public String getMessageId()
  {
    return messageId;
  }
  
  public MessageType getMessageType()
  {
    return messageType;
  }
  
  public String getOutputName()
  {
    return outputName;
  }
  
  public MessageProperty[] getProperties()
  {
    ArrayList localArrayList = properties;
    return (MessageProperty[])localArrayList.toArray(new MessageProperty[localArrayList.size()]);
  }
  
  public String getProperty(String paramString)
  {
    Iterator localIterator = properties.iterator();
    while (localIterator.hasNext())
    {
      MessageProperty localMessageProperty = (MessageProperty)localIterator.next();
      if (localMessageProperty.hasSameName(paramString))
      {
        paramString = localMessageProperty;
        break label42;
      }
    }
    paramString = null;
    label42:
    if (paramString == null) {
      return null;
    }
    return paramString.getValue();
  }
  
  public String getTo()
  {
    return to;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public boolean isExpired()
  {
    long l = expiryTime;
    boolean bool = false;
    if ((l != 0L) && (System.currentTimeMillis() > expiryTime))
    {
      log.c("The message with correlation id {} expired", getCorrelationId());
      bool = true;
    }
    return bool;
  }
  
  public boolean isSecurityMessage()
  {
    return isSecurityClient;
  }
  
  public void setAbsoluteExpiryTime(long paramLong)
  {
    if (paramLong >= 0L)
    {
      expiryTime = paramLong;
      return;
    }
    throw new IllegalArgumentException("ExpiryTime may not be negative");
  }
  
  public void setAsSecurityMessage()
  {
    contentEncoding = "application/json";
    isSecurityClient = true;
  }
  
  public void setConnectionDeviceId(String paramString)
  {
    connectionDeviceId = paramString;
  }
  
  public void setConnectionModuleId(String paramString)
  {
    connectionModuleId = paramString;
  }
  
  public void setContentEncoding(String paramString)
  {
    contentEncoding = paramString;
  }
  
  @Deprecated
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
  
  public final void setContentTypeFinal(String paramString)
  {
    contentType = paramString;
  }
  
  public void setCorrelationId(String paramString)
  {
    correlationId = paramString;
  }
  
  public final void setCreationTimeUTC(Date paramDate)
  {
    creationTimeUTC = paramDate;
  }
  
  public void setExpiryTime(long paramLong)
  {
    expiryTime = (System.currentTimeMillis() + paramLong);
    log.b("The message with messageid {} has expiry time in {} milliseconds and the message will expire on {}", new Object[] { getMessageId(), Long.valueOf(paramLong), new Date(expiryTime) });
  }
  
  public void setInputName(String paramString)
  {
    inputName = paramString;
  }
  
  public void setIotHubConnectionString(IotHubConnectionString paramIotHubConnectionString)
  {
    iotHubConnectionString = paramIotHubConnectionString;
  }
  
  public void setMessageId(String paramString)
  {
    messageId = paramString;
  }
  
  public void setMessageType(MessageType paramMessageType)
  {
    messageType = paramMessageType;
  }
  
  public void setOutputName(String paramString)
  {
    outputName = paramString;
  }
  
  public void setProperty(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        Object localObject1 = null;
        Iterator localIterator = properties.iterator();
        Object localObject2;
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (MessageProperty)localIterator.next();
        } while (!((MessageProperty)localObject2).hasSameName(paramString1));
        if (localObject2 != null) {
          properties.remove(localObject2);
        }
        log.e("Setting message property");
        properties.add(new MessageProperty(paramString1, paramString2));
        return;
      }
      throw new IllegalArgumentException("Property value cannot be 'null'.");
    }
    throw new IllegalArgumentException("Property name cannot be 'null'.");
  }
  
  public void setUserId(String paramString)
  {
    userId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a(" Message details: ");
    String str = correlationId;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("Correlation Id [");
      localStringBuilder.append(correlationId);
      localStringBuilder.append("] ");
    }
    str = messageId;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("Message Id [");
      localStringBuilder.append(messageId);
      localStringBuilder.append("] ");
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */