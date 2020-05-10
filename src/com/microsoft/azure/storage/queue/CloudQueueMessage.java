package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.Utility;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class CloudQueueMessage
{
  public int dequeueCount;
  public Date expirationTime;
  public String id;
  public Date insertionTime;
  public String messageContent;
  public QueueMessageType messageType;
  public Date nextVisibleTime;
  public String popReceipt;
  
  public CloudQueueMessage() {}
  
  public CloudQueueMessage(String paramString)
  {
    setMessageContent(paramString);
  }
  
  public CloudQueueMessage(byte[] paramArrayOfByte)
  {
    setMessageContent(paramArrayOfByte);
  }
  
  public final int getDequeueCount()
  {
    return dequeueCount;
  }
  
  public final Date getExpirationTime()
  {
    return expirationTime;
  }
  
  public final String getId()
  {
    return id;
  }
  
  public final Date getInsertionTime()
  {
    return insertionTime;
  }
  
  public final byte[] getMessageContentAsByte()
  {
    if (Utility.isNullOrEmpty(messageContent)) {
      return new byte[0];
    }
    if (messageType == QueueMessageType.RAW_STRING) {
      try
      {
        byte[] arrayOfByte = messageContent.getBytes("UTF-8");
        return arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw Utility.generateNewUnexpectedStorageException(localUnsupportedEncodingException);
      }
    }
    return Base64.decode(messageContent);
  }
  
  public final String getMessageContentAsString()
  {
    if (messageType == QueueMessageType.RAW_STRING) {
      return messageContent;
    }
    if (Utility.isNullOrEmpty(messageContent)) {
      return null;
    }
    try
    {
      String str = new String(Base64.decode(messageContent), "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw Utility.generateNewUnexpectedStorageException(localUnsupportedEncodingException);
    }
  }
  
  public final String getMessageContentForTransfer(boolean paramBoolean, QueueRequestOptions paramQueueRequestOptions)
  {
    QueueEncryptionPolicy localQueueEncryptionPolicy = paramQueueRequestOptions.getEncryptionPolicy();
    Long localLong = Long.valueOf(65536L);
    if (localQueueEncryptionPolicy != null)
    {
      paramQueueRequestOptions = paramQueueRequestOptions.getEncryptionPolicy().encryptMessage(getMessageContentAsByte());
      if (paramQueueRequestOptions.length() <= 65536L) {
        return paramQueueRequestOptions;
      }
      throw new IllegalArgumentException(String.format("Encrypted Messages cannot be larger than {0} bytes. Please note that encrypting queue messages can increase their size.", new Object[] { localLong }));
    }
    if ((messageType == QueueMessageType.RAW_STRING) && (paramBoolean)) {
      paramQueueRequestOptions = Base64.encode(getMessageContentAsByte());
    } else {
      paramQueueRequestOptions = messageContent;
    }
    if ((paramQueueRequestOptions != null) && (paramQueueRequestOptions.length() > 65536L)) {
      throw new IllegalArgumentException(String.format("The message size cannot be larger than %s bytes.", new Object[] { localLong }));
    }
    return paramQueueRequestOptions;
  }
  
  public final String getMessageId()
  {
    return id;
  }
  
  public final QueueMessageType getMessageType()
  {
    return messageType;
  }
  
  public final Date getNextVisibleTime()
  {
    return nextVisibleTime;
  }
  
  public final String getPopReceipt()
  {
    return popReceipt;
  }
  
  public final void setDequeueCount(int paramInt)
  {
    dequeueCount = paramInt;
  }
  
  public final void setExpirationTime(Date paramDate)
  {
    expirationTime = paramDate;
  }
  
  public final void setInsertionTime(Date paramDate)
  {
    insertionTime = paramDate;
  }
  
  public final void setMessageContent(String paramString)
  {
    messageContent = paramString;
    messageType = QueueMessageType.RAW_STRING;
  }
  
  public final void setMessageContent(byte[] paramArrayOfByte)
  {
    Utility.assertNotNull("content", paramArrayOfByte);
    messageContent = Base64.encode(paramArrayOfByte);
    messageType = QueueMessageType.BASE_64_ENCODED;
  }
  
  public final void setMessageId(String paramString)
  {
    id = paramString;
  }
  
  public final void setMessageType(QueueMessageType paramQueueMessageType)
  {
    messageType = paramQueueMessageType;
  }
  
  public final void setNextVisibleTime(Date paramDate)
  {
    nextVisibleTime = paramDate;
  }
  
  public final void setPopReceipt(String paramString)
  {
    popReceipt = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueueMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */